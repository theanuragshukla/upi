package com.anurag.upi.paymentGateway;

import com.anurag.upi.api.Transaction;

public class SendMoney {
    private String accountNumber;
    public SendMoney(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public Transaction to(String receiver){
        Transaction t = new Transaction(this.accountNumber, receiver);
        return  t;
    }
}
