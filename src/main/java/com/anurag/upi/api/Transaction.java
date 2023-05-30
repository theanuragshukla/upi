package com.anurag.upi.api;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private class Timeline{
        private String timestamp;
        private String message;

        Timeline(String msg){
            this.timestamp = String.valueOf(System.currentTimeMillis());
            this.message = msg;
        }
    }

    private String sender;
    private String receiver;
    private int amount;
    private String timestamp;
    private boolean status;

    private List<Timeline> timeline = new ArrayList<>();
    public Transaction(String sender, String receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = String.valueOf(System.currentTimeMillis());
        this.status = false;
        this.timeline.add(new Timeline("Transaction initiated"));
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean updateStatus(boolean status){
        boolean authorized = false;
        if(!authorized)return  false;
        this.status = status;
        this.timeline.add(new Timeline(status ? "Transaction Successful" : "Transaction Failed"));
        return  true;
    }

}
