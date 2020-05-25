package com.ljj.Dynamic_Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代购：去工厂买东西，卖给顾客
 */
public class daigou implements InvocationHandler {
    //被代理对象
    private Object factory;
    public daigou() {
    }

    public daigou(Object factory) {
        this.factory = factory;
    }

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object res = method.invoke(factory, args);
        doSomethingAfter();
        return res;
    }

    private void doSomethingAfter() {
        System.out.println("售后服务，全国联保");

    }

    private void doSomethingBefore() {
        System.out.println("精美包装，邮寄回国");
    }
}
