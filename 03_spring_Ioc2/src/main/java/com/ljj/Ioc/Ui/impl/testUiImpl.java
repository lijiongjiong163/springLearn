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

import java.util.concurrent.Delayed;

public class testUiImpl implements testUi {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

      //  ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//无法使用close方法
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        while (true) {
            testService testService = (testService)ac.getBean("testService");
        //    Thread.sleep(2);
        }


//        testService testServices1  = (testService)ac.getBean("testService");
//        testService testService2 = ac.getBean(testService.class);
//        System.out.println(testServices1==testService2);//singleton则是true，prototype则是false
//        //程序自动结束时会释放线程资源，init还没来得及执行就被释放了，所以需要手动关闭容器
//        ac.close();//close是ClassPathXmlApplicationContext实现类的方法，而你把这个实现类看成了接口类型的对象，所以无法使用





    }
}
