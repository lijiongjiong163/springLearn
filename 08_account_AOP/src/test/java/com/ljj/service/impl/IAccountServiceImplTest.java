package com.ljj.service.impl;

import com.ljj.service.IAccountService;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IAccountServiceImplTest extends TestCase {
    @Test
    public void testSaveAccount() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //IAccountService haha = (IAccountService) classPathXmlApplicationContext.getBean("haha");
        IAccountService haha =  classPathXmlApplicationContext.getBean("haha",IAccountService.class);

        haha.saveAccount();
    }
}