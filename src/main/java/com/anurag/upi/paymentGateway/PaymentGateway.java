package com.anurag.upi.paymentGateway;

public class PaymentGateway {
    private final String accountNumber;
    private final SendMoney sendMoney;
    private String pubKey;
    public PaymentGateway(String accountNumber, String pubKey){
        this.accountNumber = accountNumber;
        this.sendMoney = new SendMoney(accountNumber, pubKey);
        this.pubKey = pubKey;
    }
}
