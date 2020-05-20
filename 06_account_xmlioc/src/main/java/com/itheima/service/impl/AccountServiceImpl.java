package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.transactionManager;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLOutput;
import java.util.List;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService{

    private IAccountDao accountDao;
    @Autowired
    private transactionManager tm;

   /* public void setTm(transactionManager tm) {
        this.tm = tm;
    }*/

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1.打开事务
            tm.beginTransaction();
            //2.执行操作
            List<Account> list = accountDao.findAllAccount();
            //3.提交事务
            tm.commit();
            return list;
        }catch (Exception e){
            //4.回滚
            tm.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            tm.remove();
        }


    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //1.打开事务
            tm.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountById(accountId);
            //3.提交事务
            tm.commit();
            return account;
        }catch (Exception e){
            //4.回滚
            tm.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            tm.remove();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1.打开事务
            tm.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            tm.commit();

        }catch (Exception e){
            //4.回滚
            tm.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            tm.remove();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.打开事务
            tm.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            tm.commit();

        }catch (Exception e){
            //4.回滚
            tm.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            tm.remove();
        }
    }

    @Override
    public void deleteAccount(Integer acccountId) {

        try {
            //1.打开事务
            tm.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(acccountId);
            //3.提交事务
            tm.commit();

        }catch (Exception e){
            //4.回滚
            tm.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            tm.remove();
        }
    }
    /**
     * 转账
     */
    @Override
    public void transfer(String sourceName, String targetName, float money) {

        try {
            //1.打开事务
            tm.beginTransaction();
            //2.执行操作
            //2.1.根据名称查询出转出账号
            Account source = accountDao.findAccountByName(sourceName);
            //2.2.根据名称查询出转入账号
            Account target = accountDao.findAccountByName(targetName);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney()-money);
            //2.4.转入账户加钱
            target.setMoney(target.getMoney()+money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);
             int i=1/0;
            //2.6.更新转入
            accountDao.updateAccount(target);
            //3.提交事务
            tm.commit();
            System.out.println("转账成功！");
        }catch (Exception e){
            //4.回滚
            tm.rollback();
            System.out.println("转账失败");
        }finally {
            //释放连接
            tm.remove();
        }

    }



}
