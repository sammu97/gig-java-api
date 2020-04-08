package com.jordan.gigjavaapi.dao;

import com.jordan.gigjavaapi.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("fakeDao")
public class FakeAccountDataAccessService implements AccountDao {

    private static List<Account> Accounts = new ArrayList<>();

    @Override
    public int insertAccount(Account account) {
        Accounts.add(account);
        return 1;
    }

    @Override
    public List<Account> getAllAccounts() {
        return Accounts;
    }
}
