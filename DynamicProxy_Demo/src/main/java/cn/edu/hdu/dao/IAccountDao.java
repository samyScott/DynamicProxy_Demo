package cn.edu.hdu.dao;

import cn.edu.hdu.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    Account findByUid(Integer uid);

    void saveAccount(Account account);

    void updateAccount(Account account);

}
