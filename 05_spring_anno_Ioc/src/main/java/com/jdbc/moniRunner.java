package com.jdbc;

import java.sql.*;

/**
 * 模拟一手dbutil,在jar包中不能修改源码，所以不能加标签去放入spring容器
 */
public class moniRunner {
    private moniDataSource dataSource;

    public moniRunner(moniDataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void select(String sql) throws Exception{
        //1.注册驱动
        //如果去掉mysql依赖包，下面这句话会直接报错，这就叫编译器依赖
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());//依赖一个包
        //这句话不会报错，能通过编译，但是运行时会报错，这叫运行期依赖
        Class.forName(dataSource.driver);//依赖一个字符串
//        2.获取连接
        Connection connection = DriverManager.getConnection(dataSource.url, dataSource.username, dataSource.password);
//        3.获取操作数据库的预处理对象
        PreparedStatement pstm = connection.prepareStatement(sql);
//        4.执行SQL，得到结果集
        ResultSet resultSet = pstm.executeQuery();
        //5.遍历结果集
        //5.遍历结果集
        while (resultSet.next()) {

            System.out.println(resultSet.getString(3));
        }
        //6.释放资源
        resultSet.close();
        pstm.close();
        connection.close();
        System.out.println("runner已执行");
    }
}
