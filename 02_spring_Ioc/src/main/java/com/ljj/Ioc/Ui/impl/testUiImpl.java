package com.ljj.Ioc.Ui.impl;


import com.ljj.Ioc.Dao.testDao;
import com.ljj.Ioc.Service.testService;
import com.ljj.Ioc.Ui.testUi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class testUiImpl implements testUi {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        /** 1.获取核心容器对象
         * ApplicationContext的三个常用实现类：
         *      ClassPathXmlApplicationContext:它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了（更常用）
         *      FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置文件（必须有访问权限）
         *      AnnotationConfigApplicationContext:它是用于读取注解创建容器的
         *
         * 核心容器的两个接口引发出的问题：
         *      ApplicationContext:  适用于单例对象，较常用
         *              他在构建核心容器时，创建对象采取的策略时采用立即加载的方式。也就是说，只要一读完配置文件马上就创建配置文件中配置的对象（new自己的时候）
         *       BeanFactory：   适用于多例对象
         *              它在构建核心容器时，创建对象采取的策略时采用延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象。
         *
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//执行完直接创建号对象放容器里
        //下面这句也行，但不建议用
        //FileSystemXmlApplicationContext ac = new FileSystemXmlApplicationContext("D:\\Idea_workspace\\spring\\spring_Ioc\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象，下面两种都行
        testService testServices  = (testService)ac.getBean("testService");
        System.out.println("容器创建完毕呀呀呀");
        testDao testDao = ac.getBean("testDao111",testDao.class);//这个方法并没有通过beanName去找，而是通过接口类型去找,所以如果这个接口有多个实现的话就不行了，必须在前头加上beanname
        System.out.println(testServices);
        System.out.println(testDao);
        //-----------------BeanFactory----------------------------
        /*Resource resource =new ClassPathResource("bean.xml");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        //执行到这里还没有创建对象
        testService testServices2  = (testService)factory.getBean("testService");
        //上面这句执行完就创建了testServiceImpl对象
        testDao testDao2 = factory.getBean(testDao.class);
        System.out.println(testServices2);
        System.out.println(testDao2);*/


    }
}
