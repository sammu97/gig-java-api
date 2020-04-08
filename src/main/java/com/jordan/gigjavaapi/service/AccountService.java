package com.jordan.gigjavaapi.service;

import com.jordan.gigjavaapi.dao.AccountDao;
import com.jordan.gigjavaapi.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountService(@Qualifier("h2") AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public int addAccount(Account account){
        return accountDao.insertAccount(account);
    }

    public List<Account> retrieveAccounts(){
        return accountDao.getAllAccounts();
    }
}
