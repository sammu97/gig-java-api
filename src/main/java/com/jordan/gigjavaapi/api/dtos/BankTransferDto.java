package com.jordan.gigjavaapi.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class BankTransferDto {

    @JsonProperty("receiver")
    @NotNull
    public final String receiverAccountNo;

    @JsonProperty("sender")
    @NotNull
    public final String senderAccountNo;

    @JsonProperty("amount")
    @NotNull
    @Positive
    public final double transferAmount;

    public BankTransferDto(String receiverAccountNo, String senderAccountNo, double transferAmount) {
        this.receiverAccountNo = receiverAccountNo;
        this.senderAccountNo = senderAccountNo;
        this.transferAmount = transferAmount;
    }
}
