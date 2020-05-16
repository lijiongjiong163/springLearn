package com.ljj.jdbc.jdbcDome1;

import com.sun.scenario.effect.impl.prism.PrEffectHelper;

import java.sql.*;

/**
 * 程序的耦合:程序间的依赖关系
 *    包括：类之间得依赖
 *          方法见得依赖
 *
 *          实际开发中：
 *          应该做到：编译期不依赖，运行期才依赖。
 *          解耦的思路：
 *          第一步：使用反射来创建对象，而避免使用new 关键字
 *          第二步：通过读取配置文件来获取要创建的对象全限定类名
 */
public class jdbcDemo1 {
/*    public static void main(String[] args) throws Exception{

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

    }*/
}
