package com.jordan.gigjavaapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Account {

    @NotNull
    @Id
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
