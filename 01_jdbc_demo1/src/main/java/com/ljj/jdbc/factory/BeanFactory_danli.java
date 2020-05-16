package com.ljj.jdbc.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 单例模式工厂
 */
public class BeanFactory_danli {
    private static Properties props;
    //    因为牵扯多个bean，所以用一个容器装起来
    private static HashMap<String, Object> beans;

    static {
        try {
//            1.new一个properties对象
            props = new Properties();
            //2.创建一个输入流，将配置文件中的内容拿到
            InputStream in = BeanFactory_danli.class.getClassLoader().getResourceAsStream("bean.properties");
//            3.加载到properties中
            props.load(in);//此时已经将配置文件中的beanName和beanPath拿到
//            实例化容器
            beans = new HashMap<String, Object>();
//           使用keys方法 取出配置文件中所有的key
            Enumeration<Object> beanNames = props.keys();//取到所有beanName
//            遍历枚举
            while (beanNames.hasMoreElements()) {
                //取出每个key
                String beanName = beanNames.nextElement().toString();
                //根据key获取velue
                String beanPath = props.getProperty(beanName);//取到beanPath
                //反射创建对象
                Object bean = Class.forName(beanPath).newInstance();//用beanPath去创建对象
//                把key和value存入容器

                beans.put(beanName,bean);


            }

        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据类名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);


    }
}
