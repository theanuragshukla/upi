package com.anurag.upi.paymentGateway;

public class PaymentGateway {
    private String accountNumber;
    private SendMoney sendMoney;
    public PaymentGateway(String accountNumber){
        this.accountNumber = accountNumber;
        this.sendMoney = new SendMoney(accountNumber);
    }
}
