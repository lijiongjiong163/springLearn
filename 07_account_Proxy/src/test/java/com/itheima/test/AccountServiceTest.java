package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试：测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Qualifier("accountServiceProxy")
    @Autowired
    private  IAccountService as;

    @Test
    public void testFindAllAccount() {
        List<Account> list = as.findAllAccount();
        for (int i = 0; i < list.size(); i++) {
            Account account =  list.get(i);
            System.out.println(account);
        }

    }
    @Test
    public void testTransfer() {

        as.transfer("ccc","aaa",700f);


    }
}
