package com.jordan.gigjavaapi.service;

import com.jordan.gigjavaapi.dao.AccountDao;
import com.jordan.gigjavaapi.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account addAccount(Account account){
        return accountDao.save(account);
    }

    public Iterable<Account> retrieveAccounts(){
        return accountDao.findAll();
    }
}
