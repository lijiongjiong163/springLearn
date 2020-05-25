package com.ljj.Dynamic_Proxy.Impl;


import com.ljj.Dynamic_Proxy.ManFactory;

/**
 * 具体的男性用品工厂（被代理类）
 */
public class AFactory implements ManFactory {
    @Override
    public void sale(String size) {
        System.out.println("售出尺寸为"+size+"的用品");
    }
}
