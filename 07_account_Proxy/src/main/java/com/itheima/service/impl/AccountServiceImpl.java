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


   /* public void setTm(transactionManager tm) {
        this.tm = tm;
    }*/

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {

            List<Account> list = accountDao.findAllAccount();

            return list;

    }

    @Override
    public Account findAccountById(Integer accountId) {

            Account account = accountDao.findAccountById(accountId);

            return account;
    }

    @Override
    public void saveAccount(Account account) {

            accountDao.saveAccount(account);

    }

    @Override
    public void updateAccount(Account account) {

            accountDao.updateAccount(account);

    }

    @Override
    public void deleteAccount(Integer acccountId) {


            accountDao.deleteAccount(acccountId);

    }
    /**
     * 转账
     */
    @Override
    public void transfer(String sourceName, String targetName, float money) {


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
             //int i=1/0;
            //2.6.更新转入
            accountDao.updateAccount(target);



    }



}
