package com.ljj.jdbc.factory;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean：在计算机英语中，有可重用组件的含义
 * JavaBean：用java语言编写的可重用组件
 *          JavaBean>实体类
 *          它就是创建我们的service和dao对象的。
 *
 *          第一个：需要一个配置文件来配置我们的service和dao
 *                  配置的内容：唯一标识=权限定类名（key=value)
 *          第二个：通过读取配置文件中配置的内容，反射创建对象
 *
 *          我的配置文件可以是xml也可以是proparties
 */
public class BeanFactory_duoli {
    //定义一个properties对象
    private static Properties props;
//    使用静态代码块为properties对象赋值，他会在加载factoryBena时就执行，并把配置文件中的内容加载到props中。
    static {
    try {
        //1.实例化properties对象
    props = new Properties();
//2.获取properties的文件流对象；
   // InputStream in = new FileInputStream("只能传入绝对路径或者相对路径");//绝对路径：不好，因为你一发布位置就变了；相对路径：不好，因为你一发布到tomcat文件目录结构都变了，如下例：
    /*    在新建FileInputStream时使用当前相对路径或者绝对路径作为参数的问题

       今天在写手机与PC的webservice（用axis2实现的）传输图片的程序，服务端是一个类，编译后直接部署在axis的pojo文件夹里，当我new一个FileInputStream时，想使用相对路径这样无论我的服务端部署到哪里，都可以一直用一个文件夹而不必修改程序的路径代码，当然首先我用的绝对路径来做实验，保证能够成功通信，使用绝对路径时要注意路径的分隔符可以用“/”或者“\\”，而这也可以混用，如下：
    FileInputStream fis=new FileInputStream("D:/images/"+id+".jpg");
    或者
    FileInputStream fis=new FileInputStream("D:\\images\\"+id+".jpg");
    都行。
    甚至可以/与\\混合使用。
    然后我想用相对路径了，但是当我将images这个文件夹与我的.class文件（即要执行的webservice）放在同一个目录里时，发现运行失败了，提示找不到这个文件夹，代码如下：
    FileInputStream fis=new FileInputStream("images/"+id+".jpg");
    然后我就用System.out.println(new File(".").getAbsolutePath());打印了一下当前目录
    结果是tomcat的bin目录，而并不是tomcat里所部属的webservice目录，遂修改如下：
    FileInputStream fis=new FileInputStream("../webapps\\axis2\\WEB-INF/pojo/images/"+id+".jpg");
    注意：../表示当前目录的上一级目录。
    所以说，当作为webservice部署到tomcat里时，若想使用当前目录，最好先使用System.out.println(new File(".").getAbsolutePath());查看一下当前目录是什么，因为他不一定是你的.class文件存放的目录，通常是
    tomcat的bin目录，所以需要根据这个目录重新指定你想要到达的目录。*/
    //所以不能new FileInputStream,问题太多
    InputStream in =BeanFactory_duoli.class.getClassLoader().getResourceAsStream("bean.properties");//不懂，要学习
       //把这个输入流加载到props里
        props.load(in);

    } catch (IOException e) {
       throw new ExceptionInInitializerError("初始化properties失败！");
    }

}
//写完了静态代码块然后就要写这个工厂类的get方法了，把生产的对象造出来让别人get

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName)  {
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();//newInstance:每次都会调用默认构造函数创建对象

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
    /**
     * 上面的代码是在静态块里将配置文件加载到properties对象中，然后在方法里用去使用newInstance方法去新建对象
     */
}
