package com.ljj.Ioc.Ui.impl;


import com.ljj.Ioc.Service.impl.testServiceImpl;
import com.ljj.Ioc.Service.testService;
import com.ljj.Ioc.Ui.testUi;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.concurrent.Delayed;

public class testUiImpl implements testUi {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        //  ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//无法使用close方法
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        /*testService testService = (testService) ac.getBean("testService");
        System.out.println(testService);

        testService testServices2 = (testService) ac.getBean("testService2");
        System.out.println(testServices2);*/
        //一些常用的方法
        System.out.println("是否含有叫'testService1'的bean:"+ ac.containsBean("testService1"));//容器是否含有指定名字的bean
        System.out.println("是否单例："+ac.isSingleton("testService2"));//判断这个bean是不是单例，当然还有多例的方法
        System.out.println("testService3是否是testService类的:"+ac.isTypeMatch("testService3",testService.class));
        System.out.println("testService3的类型:"+ac.getType("testService3"));
        System.out.println("查询这个bean的别名："+ac.getAliases("testService2"));

        testService testServices3 = (testService) ac.getBean("testService3");
        testServices3.getaccout();

    }
}
