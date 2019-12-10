package com.anson.main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class G22Encryption {
    public static String encryption(String plainPwd) {
        if(plainPwd==null) {
            return null;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] passwordByte = plainPwd.getBytes();
            md5.reset();
            byte[] digested = md5.digest(passwordByte);
            StringBuffer buffer = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                buffer.append(Integer.toHexString(0xff & digested[i]));
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ERR: NoSuchAlgorithmException > cryptWithMD5");
        }
        return null;
    }
}
