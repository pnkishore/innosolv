package com.innsolv.resourceserver.model;

import java.math.BigDecimal;

public class Account {

    private long accountNumber;
    private BigDecimal balance;

    public Account(long accNo, BigDecimal balance) {
        this.accountNumber = accNo;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
