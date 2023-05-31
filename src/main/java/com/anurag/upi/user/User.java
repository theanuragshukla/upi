package com.anurag.upi.user;

import com.anurag.upi.Utils.RandomStringGenerator;
import com.anurag.upi.account.Account;

public class User {
    private final String name;
    private final String userId;
    private Account account = null;

    private String createdOn;

    public User(String name){
        this.name = name;
        this.userId = new RandomStringGenerator().generate(16);
        this.createdOn = String.valueOf(System.currentTimeMillis());
    }

    public boolean createAccount(){
        if(this.account!=null)return false;
        this.account = new Account(this.userId);
        return true;
    }
}
