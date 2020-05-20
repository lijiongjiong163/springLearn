package com.itheima.utils;


import java.sql.SQLException;

public class transactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void beginTransaction(){
        try {
            connectionUtils.getThreadConn().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
        public void commit(){
        try {
            connectionUtils.getThreadConn().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
        public void rollback(){
        try {
            connectionUtils.getThreadConn().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
        public void remove(){
        try {
            connectionUtils.getThreadConn().close();
            connectionUtils.remove();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
