package com.ljj.Ioc.factory;

import com.ljj.Ioc.Service.impl.testServiceImpl;
import com.ljj.Ioc.Service.testService;

/**
 * 模拟一个工厂类，它是个工厂，用来生成其他对象的，这时候我们就不能单纯的靠bean去
 * 创建了，因为你要是用bean，创建的对象就是工厂本身的对象呀
 */
public class InstanceFactory {
    {
        System.out.println("工厂被创建啦");
    }
    public testService getService(){
        System.out.println("工厂创造了个service实现类");
        return new testServiceImpl();
    }

}
