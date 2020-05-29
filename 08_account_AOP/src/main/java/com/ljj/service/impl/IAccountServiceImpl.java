package com.ljj.service.impl;

import com.ljj.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("haha")
public class IAccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行saveAccount");
    }

    public void updateAccount(int i) {
        System.out.println("执行updateAccount"+i);
    }

    public int deleteAccount() {
        return 0;
    }
}
