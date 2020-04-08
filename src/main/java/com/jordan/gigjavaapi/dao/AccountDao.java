package com.jordan.gigjavaapi.dao;

import com.jordan.gigjavaapi.model.Account;

import java.util.List;
import java.util.Random;

public interface AccountDao {

    int insertAccount(Account account);

    List<Account> getAllAccounts();

}
