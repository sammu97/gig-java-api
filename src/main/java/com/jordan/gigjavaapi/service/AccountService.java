package com.jordan.gigjavaapi.service;

import com.jordan.gigjavaapi.api.dtos.BankTransferDto;
import com.jordan.gigjavaapi.dao.AccountDao;
import com.jordan.gigjavaapi.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public int addOrUpdateAccount(Account account){
        accountDao.save(account);
        return 1;
    }

    public Iterable<Account> retrieveAccounts(){
        return accountDao.findAll();
    }

    public Optional<Account> getAccountByAccountNo(String accountNo){
        return accountDao.findById(accountNo);
    }

    public int TransferBetweenAccount(BankTransferDto transferDto) throws Exception {
        Optional<Account> senderAccount = getAccountByAccountNo(transferDto.senderAccountNo);
        Optional<Account> receiverAccount = getAccountByAccountNo(transferDto.receiverAccountNo);

        //We are checking if both Accounts were found successfully
        if(senderAccount.isPresent() && receiverAccount.isPresent()){
            senderAccount.get().balance -= transferDto.transferAmount;
            receiverAccount.get().balance += transferDto.transferAmount;

            //ensure that the sender has enough money
            if(senderAccount.get().balance >= 0){
                this.addOrUpdateAccount(senderAccount.get());
                this.addOrUpdateAccount(receiverAccount.get());

                return 1;
            }
            else {
                throw new Exception("Sender Account has insufficient funds!");
            }
        }

        throw new Exception("One or more accounts do not exist!");
    }
}
