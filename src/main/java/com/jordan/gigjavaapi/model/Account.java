package com.jordan.gigjavaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Account {

    @NotNull
    private final String accountNumber;

    private final double balance;

    public Account(@JsonProperty("accountNumber") String accountNumber,
                   @JsonProperty("balance") double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
