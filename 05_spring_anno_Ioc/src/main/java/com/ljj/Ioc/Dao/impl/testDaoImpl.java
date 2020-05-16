package com.ljj.Ioc.Dao.impl;



import com.jdbc.moniRunner;
import com.ljj.Ioc.Dao.testDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Repository("testDao1")
public class testDaoImpl implements testDao {
    @Autowired
    private moniRunner runner;
    public void getaccout() throws Exception{
        runner.select("select * from account");
        System.out.println("dao1已执行");
    }
}
