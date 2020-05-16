package com.ljj.jdbc.Ui.impl;

import com.ljj.jdbc.Service.testService;
import com.ljj.jdbc.Ui.testUi;

import com.ljj.jdbc.factory.BeanFactory_danli;

public class testUiImpl implements testUi {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            testService service =(testService) BeanFactory_danli.getBean("testService");
            System.out.println(service);
            try {
                service.getaccout();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
