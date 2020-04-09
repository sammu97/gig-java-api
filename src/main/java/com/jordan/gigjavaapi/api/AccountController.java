package com.jordan.gigjavaapi.api;

import com.jordan.gigjavaapi.api.dtos.BankTransferDto;
import com.jordan.gigjavaapi.model.Account;
import com.jordan.gigjavaapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/account")
@RestController
public class AccountController {


    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST)
    public void addOrUpdateAccount(@RequestBody @Valid @NonNull Account account){
        accountService.addOrUpdateAccount(account);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Iterable<Account> getAllAccounts(){
        return accountService.retrieveAccounts();
    }

    @RequestMapping(value = "/bankTransfer", method = RequestMethod.POST)
    public void bankTransfer(@RequestBody @Valid @NonNull BankTransferDto transferDto) throws Exception {
        accountService.TransferBetweenAccount(transferDto);
    }
}
