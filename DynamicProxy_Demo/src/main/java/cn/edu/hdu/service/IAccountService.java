package cn.edu.hdu.service;

import cn.edu.hdu.domain.Account;
import sun.reflect.generics.scope.Scope;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();

    void saveAccount(Account account);

    void transfer(Integer sourceUid, Integer targetUid,Double money);


}
