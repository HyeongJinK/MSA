package com.illunex.invest.user.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class GenerateToken {
    public static String CreateToken(){
        String token = null;
        SecureRandom secureRandom;

        try {

            secureRandom = SecureRandom.getInstance("SHA1PRNG");

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            secureRandom.setSeed(secureRandom.generateSeed(128));


            token= new String(digest.digest((secureRandom.nextLong() + "").getBytes()));


        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return token;
    }
}
