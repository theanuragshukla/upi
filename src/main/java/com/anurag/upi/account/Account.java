package com.anurag.upi.account;

import com.anurag.upi.Utils.RandomStringGenerator;
import com.anurag.upi.paymentGateway.PaymentGateway;

import java.security.*;
import java.util.Base64;

public class Account {
    private final int balance;
    private final String AccountNumber;
    private final String createdOn;
    private final String userId;

    private PaymentGateway paymentGateway = null;

    private String privateKey;
    public String publicKey;
    public Account(String owner) {
        this.balance=0;
        this.createdOn = String.valueOf(System.currentTimeMillis());
        this.AccountNumber = new RandomStringGenerator().generate(24);
        this.userId = owner;
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048, new SecureRandom());
            KeyPair pair = generator.generateKeyPair();
            PublicKey pubKey = pair.getPublic();
            PrivateKey privKey = pair.getPrivate();
            this.publicKey = Base64.getEncoder().encodeToString(pubKey.getEncoded());
            this.privateKey = Base64.getEncoder().encodeToString(privKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean setupPaymentGateway(){
        this.paymentGateway = new PaymentGateway(this.AccountNumber, publicKey );
        return true;
    }
}
