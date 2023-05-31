package com.anurag.upi.paymentGateway;

import com.anurag.upi.Utils.RandomStringGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Transaction implements Serializable {

    private class Timeline{
        private final String timestamp;
        private final String message;

        Timeline(String msg){
            this.timestamp = String.valueOf(System.currentTimeMillis());
            this.message = msg;
        }
    }

    private final String sender;
    private final String receiver;
    private int amount;
    private final String timestamp;
    private boolean status;

    private boolean signed = false;
    public String txnId;
    private final List<Timeline> timeline = new ArrayList<>();

    private boolean verify(int pin){
        return pin == 1234;
    }
    public Transaction(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = String.valueOf(System.currentTimeMillis());
        this.status = false;
        this.txnId = new RandomStringGenerator().generate(16);
        this.timeline.add(new Timeline("Transaction initiated"));
    }

    private void updateTimeline(String msg){
        this.timeline.add(new Timeline(msg));
    }
    public void setAmount(int amount) {
        this.amount = amount;
        updateTimeline(String.valueOf(new StringJoiner("", "Transaction amount updated to ", String.valueOf(amount))));
    }

    public void sign(int pin){
        updateTimeline("UPI pin verification initiated");
        boolean res = this.verify(pin);
        updateTimeline(res  ? "UPI pin verification Successful" : "UPI pin verification failed");
        this.signed = res;
    }

    public boolean updateStatus(boolean status){
        boolean authorized = false;
        if(!authorized)return  false;
        this.status = status;
        this.updateTimeline(status ? "Transaction Successful" : "Transaction Failed");;
        return  true;
    }

}
