package cn.edu.hdu.dao.impl;

import cn.edu.hdu.dao.IAccountDao;
import cn.edu.hdu.domain.Account;
import cn.edu.hdu.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner qr;
    private ConnectionUtils connectionUtils;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAll() {
        try {
            return qr.query(connectionUtils.getConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try {
            qr.update(connectionUtils.getConnection(),"insert into account(id,uid,money) values(?,?,?)",account.getId(),account.getUid(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            qr.update(connectionUtils.getConnection(),"update account set uid = ?,money = ? where id = ?",account.getUid(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findByUid(Integer uid) {
        try {
            List<Account> accounts = qr.query(connectionUtils.getConnection(),"select * from Account where uid = ?",new BeanListHandler<Account>(Account.class),uid);
            if (accounts == null){
                return null;
            }else if(accounts.size() > 1){
                throw new RuntimeException("数据不正确");
            }

            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
