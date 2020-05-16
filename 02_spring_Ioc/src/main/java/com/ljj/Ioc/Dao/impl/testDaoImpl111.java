package com.ljj.Ioc.Dao.impl;



import com.ljj.Ioc.Dao.testDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testDaoImpl111 implements testDao {
    public testDaoImpl111() {
        System.out.println("DaoImpl111对象创建了");
    }
    public void getaccout() throws Exception{


        //1.注册驱动
        //如果去掉mysql依赖包，下面这句话会直接报错，这就叫编译器依赖
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());//依赖一个包
        //这句话不会报错，能通过编译，但是运行时会报错，这叫运行期依赖
        Class.forName("com.mysql.jdbc.Driver");//依赖一个字符串
//        2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itxmyth", "root", "123456");
//        3.获取操作数据库的预处理对象
        PreparedStatement pstm = connection.prepareStatement("select * from account");
//        4.执行SQL，得到结果集
        ResultSet resultSet = pstm.executeQuery();
        //5.遍历结果集
        while (resultSet.next()) {

            System.out.println(resultSet.getString(3));
        }
        //6.释放资源
        resultSet.close();
        pstm.close();
        connection.close();
        System.out.println("dao已执行");
    }
}
