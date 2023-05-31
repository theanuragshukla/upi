package com.anurag.upi.paymentGateway;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SendMoney {
    private final String accountNumber;
    private String pubKey;
    public SendMoney(String accountNumber, String pubKey) {
        this.pubKey = pubKey;
        this.accountNumber = accountNumber;
    }
    public Transaction to(String receiver){
        Transaction t = new Transaction(this.accountNumber, receiver);
         ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] serializedObject = bos.toByteArray();
        return t;
    }
}
