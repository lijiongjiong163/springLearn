package com.ljj.reflect;

import java.io.InputStream;
import java.util.Properties;

/**
 * 模拟一个框架，在不修改代码的情况下执行方法
 */
public class reflectTest {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream resource = Object.class.getClassLoader().getResourceAsStream("pro.properties");

    }
}
