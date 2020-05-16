package com.ljj.Ioc.Service.impl;


import com.ljj.Ioc.Service.testService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class testServiceImplTest {
    @Autowired
    public testService testService;
    @Test
    public void getaccout() {
        testService.getaccout();
    }
}