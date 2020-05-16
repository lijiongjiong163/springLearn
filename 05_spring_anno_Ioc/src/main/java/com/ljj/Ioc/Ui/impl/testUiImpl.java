package com.ljj.Ioc.Ui.impl;


import com.ljj.Ioc.Dao.testDao;
import com.ljj.Ioc.Service.impl.testServiceImpl;
import com.ljj.Ioc.Service.testService;
import com.ljj.Ioc.Ui.testUi;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class testUiImpl implements testUi {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     */
    private testService testServices;
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//执行完直接创建号对象放容器里

        testService testServices  = (testService)ac.getBean("testService");
        testService testServices2  = (testService)ac.getBean("testService");

        System.out.println(testServices == testServices2);
        testServices.getaccout();
        ac.close();


    }
}
