package com.ljj.Ioc.Service.impl;

import com.ljj.Ioc.Dao.impl.testDaoImpl;
import com.ljj.Ioc.Dao.testDao;
import com.ljj.Ioc.Service.testService;


public class testServiceImpl implements testService {

    private testDao dao = new testDaoImpl();

    public testServiceImpl() {
        System.out.println("ServiceImpl对象创建了");
    }


    public void getaccout() {

        try {
            dao.getaccout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("service已执行");

    }
}
