package com.ljj.Proxy_Pattern;

import java.lang.reflect.Proxy;

/**
 * 不能明白为啥代理类非要和被代理类实现同一个接口，不实现完全可以用呀
 * 我估计就是为了规范代理类的行为，和被代理类保持一致并增强，而不是随便改或者缺少功能
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;
    public ProxyImage(String fileName){
        this.fileName = fileName;
    }


    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}