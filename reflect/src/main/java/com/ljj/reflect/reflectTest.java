package com.ljj.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 模拟一个框架，在不修改代码的情况下执行方法
 */
public class reflectTest {
    public static void main(String[] args) {
        //Properties类专门用于读取文件，使用方法如下：
        //1.new它
        Properties properties = new Properties();
        //2.随便哪个对象，用它的字节码对象拿到它的类加载器对象，再使用getResourceAsStream方法用流去读取配置文件
        InputStream resource = Object.class.getClassLoader().getResourceAsStream("pro.properties");
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
