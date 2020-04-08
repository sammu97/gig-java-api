package com.jordan.gigjavaapi.dao;

import com.jordan.gigjavaapi.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("h2")
public class AccountDataAccessService implements AccountDao {
    @Override
    public int insertAccount(Account account) {
        return 0;
    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }
}
