package com.ljj.Ioc.Service.impl;

import com.ljj.Ioc.Service.testService;

import java.util.*;


public class testServiceImpl3 implements testService {
    private String[] myArray;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }





    public void getaccout() {
        System.out.println(Arrays.toString(myArray));
        System.out.println(myList);
        System.out.println(myMap);
        System.out.println(mySet);
        System.out.println(myProps);
    }
}
