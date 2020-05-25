package com.ljj.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 模拟一个框架，在不修改代码的情况下执行方法
 */
public class reflectTest {
    public static void main(String[] args) throws Exception {
        //Properties类专门用于读取properties结尾的文件，使用properties.load()即可，使用方法如下：
        //1.new它
        Properties properties = new Properties();
        //2.必须用当前类对象，用它的字节码对象拿到它的类加载器对象，再使用getResourceAsStream方法用流去读取配置文件
        InputStream resource = reflectTest.class.getClassLoader().getResourceAsStream("pro.properties");
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //拿到类名称和方法名
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        //加载该类进内存
        Class Cls = Class.forName(className);
        //创建对象
        Object obj = Cls.newInstance();
        //获取方法对象
        Method method = Cls.getMethod(methodName);
        //传一个对象进去
        method.invoke(obj);


    }
}
