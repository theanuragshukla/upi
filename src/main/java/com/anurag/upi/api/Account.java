package com.anurag.upi.api;

import com.anurag.upi.Utils.AccountNumberGenerator;
import com.anurag.upi.paymentGateway.PaymentGateway;

public class Account {
    private int balance;
    private String AccountNumber;
    private String createdOn;
    private String userId;

    private PaymentGateway paymentGateway = null;
    public Account(String owner) {
        this.balance=0;
        this.createdOn = String.valueOf(System.currentTimeMillis());
        this.AccountNumber = new AccountNumberGenerator().generate();
        this.userId = owner;
    }

    public boolean setupPaymentGateway(){
        this.paymentGateway = new PaymentGateway(this.AccountNumber);
        return true;
    }
}
