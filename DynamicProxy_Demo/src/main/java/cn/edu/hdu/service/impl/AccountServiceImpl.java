package cn.edu.hdu.service.impl;

import cn.edu.hdu.dao.IAccountDao;
import cn.edu.hdu.domain.Account;
import cn.edu.hdu.service.IAccountService;
import cn.edu.hdu.utils.ConnectionUtils;
import cn.edu.hdu.utils.TransactionManger;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void transfer(Integer sourceUid, Integer targetUid, Double money) {
        Account source = accountDao.findByUid(sourceUid);
        Account target = accountDao.findByUid(targetUid);

        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        accountDao.updateAccount(source);
//        int i = 1/0;
        accountDao.updateAccount(target);

    }
}
