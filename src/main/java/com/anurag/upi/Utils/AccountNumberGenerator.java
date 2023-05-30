package com.anurag.upi.Utils;

import java.util.Random;

public class AccountNumberGenerator {
    public String generate(){
        String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rand=new Random();
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < 24; i++) {
            int randIndex=rand.nextInt(aToZ.length());
            res.append(aToZ.charAt(randIndex));
        }
        return res.toString();
    }
}
