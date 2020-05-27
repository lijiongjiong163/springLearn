package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import com.itheima.utils.transactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class beanFactory {
    private AccountServiceImpl accountService;
    private transactionManager tm;

    public void setTm(transactionManager tm) {
        this.tm = tm;
    }

    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public IAccountService getServiceProxy() {
        IAccountService ServiceProxy =(IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    //1.打开事务
                    tm.beginTransaction();
                    //2.执行操作
                    Object res = method.invoke(accountService, args);
                    //3.提交事务
                    tm.commit();
                    return res;
                } catch (Exception e) {
                    //4.回滚
                    tm.rollback();
                    System.err.println("回滚啦！！！！！");
                    throw new RuntimeException(e);
                } finally {
                    //释放连接
                    tm.remove();
                }
            }
        });
        return ServiceProxy;
    }

}



