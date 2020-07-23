# ApplicationContext分析

## 1、常用 应用上下文实现：

- **ClassPathXmlApplicationContext**:它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了（更常用）
- **FileSystemXmlApplicationContext**:它可以加载磁盘任意路径下的配置文件（必须有访问权限）
- **AnnotationConfigApplicationContext**:它是用于读取注解创建容器的



## 2、继承关系UML图：

举例：**FileSystemXmlApplicationContext**

![1595316640395](C:\Users\LiJiong\AppData\Roaming\Typora\typora-user-images\1595316640395.png)

​	意思就是FileSystemXmlApplicationContext有5个父类，组成一个巨大的类，各司其职，其中有些类在最上面的父类中有抽象方法 ，但是都在下面有实现。

## 3、上下文实现类分析

举例：**FileSystemXmlApplicationContext**

​	看一看ApplicationContext和FileSystemXmlApplicationContext的关系（其他实现也是），其实，ApplicationContext的主要功能已经在AbstractXmlApplicationContext中实现了，FileSystemXmlApplicationContext只需要干点自己相关的事情就对啦（它用来读取绝对路径的BeanDefinition，所以需要干这件事）

​	具体来说就是 这两件事情：

- refresh IoC容器（创建上下文对象时就进行）
- 读取Xml形式的Bean。

```java
//IoC功能由AbstractXmlApplicationContext实现
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    //构造方法
    public FileSystemXmlApplicationContext（）{
        //1.调用refresh()方法刷新容器
    }
    protected Resource getResourceByPath(String path) {
        //2.读取配置文件
    }
}
```

### 3.1初始化过程

三个过程：

1. 定位：找到不同类型的Bean定义信息

2. 载入：把bean载入到IoC容器的内部数据结构（BeanDefinition）
3. 注册：将BeanDefinition注册进IoC容器的HashMap中（并不实例化）

spring将这三个过程分开，是为了让用户更加灵活的对这三个 过程进行裁剪或者扩展

#### 3.1.1定位

接下来研究一下调用refresh()方法：

**AbstractApplicationContext**中的refresh()调用obtainFreshBeanFactory()，obtainFreshBeanFactory()再调用 **AbstractRefreshableApplicationContext**中的refreshBeanFactory();主要来看看 refreshBeanFactory()

```java
protected final void refreshBeanFactory() throws BeansException {
   if (hasBeanFactory()) {
      destroyBeans();
      closeBeanFactory();
   }
   try {
       //1.在这里创建容器 
      DefaultListableBeanFactory beanFactory = createBeanFactory();
      beanFactory.setSerializationId(getId());
      customizeBeanFactory(beanFactory);
       //2.和reader.loadBeanDefinitions(resource)同名
       //将刚创建的DefaultListableBeanFactory传进去
      loadBeanDefinitions(beanFactory);
      synchronized (this.beanFactoryMonitor) {
         this.beanFactory = beanFactory;
      }
   }
   catch (IOException ex) {
      throw new ApplicationContextException("I/O error parsing bean definition source for " + getDisplayName(), ex);
   }
}
```

##### 1.createBeanFactory方法

```java
protected DefaultListableBeanFactory createBeanFactory() {
   return new DefaultListableBeanFactory(getInternalParentBeanFactory());
}
```

创建了个**DefaultListableBeanFactory**，它就是上一节我们说的XmlbeanFactory中的beanFactory具体功能实现类，看来大家基本都用这个类来作为容器

##### 2.loadBeanDefinitions方法

这个方法就是AbstractRefreshableApplicationContext类中自己的一个抽象方法，由子类去实现，肯定是要用来调用reader.loadBeanDefinitions()方法，所以才跟人家叫一个名字。

具体实现是在AbstractXmlApplicationContext（上下文具体实现类）中：

```java
protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
   // 创建一个新的 XmlBeanDefinitionReader 并传入BeanFactory.这里就和xmlBeanFactory如出一辙
   XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

   // Configure the bean definition reader with this context's
   // resource loading environment.
   beanDefinitionReader.setEnvironment(this.getEnvironment());
   beanDefinitionReader.setResourceLoader(this);
   beanDefinitionReader.setEntityResolver(new ResourceEntityResolver(this));

   // Allow a subclass to provide custom initialization of the reader,
   // then proceed with actually loading the bean definitions.
   initBeanDefinitionReader(beanDefinitionReader);
    //2.1又来一个同名函数，进去看看
   loadBeanDefinitions(beanDefinitionReader);
}

//2.1终于找到了本尊
protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) throws BeansException, IOException {
		Resource[] configResources = getConfigResources();
		if (configResources != null) {
			reader.loadBeanDefinitions(configResources);
		}
		String[] configLocations = getConfigLocations();
		if (configLocations != null) {
			reader.loadBeanDefinitions(configLocations);
		}
	}
```

