package com.jordan.gigjavaapi.api;

import com.jordan.gigjavaapi.model.Account;
import com.jordan.gigjavaapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void addAccount(@RequestBody @Valid @NonNull Account account){
        accountService.addAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.retrieveAccounts();
    }

}
