package com.illunex.invest.user.service;

import java.util.UUID;

public class GenerateToken {
    public static String CreateToken(){
        String token = UUID.randomUUID().toString();
//        SecureRandom secureRandom;
//
//        try {
//
//            secureRandom = SecureRandom.getInstance("SHA1PRNG");
//
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//
//            secureRandom.setSeed(secureRandom.generateSeed(128));
//
//
//            token= new String(digest.digest((secureRandom.nextLong() + "").getBytes()));
//
//
//        } catch (NoSuchAlgorithmException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return token;
    }
}
