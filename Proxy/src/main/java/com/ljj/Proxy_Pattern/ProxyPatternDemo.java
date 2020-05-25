package com.ljj.Proxy_Pattern;

public class ProxyPatternDemo {

    public static void main(String[] args) {
        //不能明白为啥代理类非要和被代理类实现同一个接口，不实现完全可以用呀
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}