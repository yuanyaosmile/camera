package com.yy.utils;

import org.springframework.util.DigestUtils;

import java.util.Random;

public class MD5Util {

    private static String saltStr = "1234567890abcdefghijklmnopqrstuvwxyz";

    public static  String encode(String password){
        String encodeStr = DigestUtils.md5DigestAsHex(password.getBytes());
        return encodeStr;
    }

    public static String inputToDB(String inputPassword, String salt){
        return encode(inputPassword+salt.charAt(1)+salt.charAt(4)+salt.charAt(6)+salt.charAt(7));
    }


    public static String getSalt(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++ ){
            sb.append(saltStr.charAt(new Random().nextInt(35 - 0) + 0));
        }
        return sb.toString();
    }
}
