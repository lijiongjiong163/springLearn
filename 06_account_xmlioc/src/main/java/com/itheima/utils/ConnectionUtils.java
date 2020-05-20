package com.itheima.utils;


import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，用于从数据源中获取一个连接，并实现和线程的绑定
 */
public class ConnectionUtils {
   //创建一个threadLocal对象
   private ThreadLocal<Connection> tl = new ThreadLocal<Connection>(){
      @Override
      protected void finalize() throws Throwable {
         System.out.println("tl对象已清理");
      }
   };
   //由spring给注入datasource对象，所以加set方法
   private DataSource dataSource;

   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
   }

   /**
    * 拿到线程上的connection
    * @return connection
    */
   public Connection getThreadConn() {
      try {
         if (tl.get() == null) {
            tl.set(dataSource.getConnection());
         }
         if(tl.get().isClosed()){

         }

      } catch (Exception e) {
         e.printStackTrace();
      }

      return tl.get();
   }

   /**
    * 释放threadLocal
    */
   public void remove(){
      System.out.println(tl);
      tl.remove();//清理map，一定要先清理map再清理tl对象，不然空指针了都
      //这样便可以清理tl对象
      tl=null;
      System.gc();
      try {
         Thread.sleep(500);
      }catch (Exception e){
      }





   }
}
