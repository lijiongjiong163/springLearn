package com.ljj.Ioc.Service.impl;

import com.ljj.Ioc.Service.testService;

import java.util.Date;


public class testServiceImpl2 implements testService {
    private String name;
    private  Integer age;
    private  Date birthday;
    public testServiceImpl2() {
        System.out.println("ServiceImpl2对象创建了");
    }





    public void getaccout() {


        System.out.println("service.getAccout方法已执行"+name+","+age+","+birthday);

    }

    private void init() {
        System.out.println("对象初始化了");
    }
    private void destory(){
        System.out.println("对象被销毁了!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }
    //==============================getter&setter========================================

    public String getName() {
        return name;
    }

    public void setUserame(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "testServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
