package com.ljj.jdbc.Service.impl;

import com.ljj.jdbc.Dao.impl.testDaoImpl;
import com.ljj.jdbc.Dao.testDao;
import com.ljj.jdbc.Service.testService;

import com.ljj.jdbc.factory.BeanFactory_danli;
import com.ljj.jdbc.factory.BeanFactory_duoli;


public class testServiceImpl implements testService {
    //这就很不爽就还要new对象，如果没了testDaoimpl直接编译就报错了
//    private testDao dao = new testDaoImpl();
    //用bean工厂就美滋滋，编译通过，如果没有对应的bean的话在运行期才会报错



    /*   还遇到个问题，在工厂执行静态块的时候newInstance会创建这个Service对象，而创建这个对象时会会创建成员变量dao,
    创建dao的时候会调用getBean（testDao）方法,这时候getBean方法去工厂容器中找testDao，结果testDao还没来得及被创建并
    放入容器，所以就报空指针了，暂且放入方法里能解决，后面再看有啥好办法没
    * */
    //testDao dao = (testDao) BeanFactory_danli.getBean("testDao");

    public void getaccout() throws Exception {
        testDao dao = (testDao) BeanFactory_danli.getBean("testDao");
        dao.getaccout();
        System.out.println("service已执行");

    }
}
