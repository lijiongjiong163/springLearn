package com.ljj.Dynamic_Proxy.Impl;

import com.ljj.Dynamic_Proxy.WomanFactory;

/**
 *具体的男性用品工厂（被代理类）
 */
public class BFactory implements WomanFactory {
    @Override
    public void sale(int Lenth) {
        System.out.println("售出长度为"+Lenth+"的用品");
    }
}
