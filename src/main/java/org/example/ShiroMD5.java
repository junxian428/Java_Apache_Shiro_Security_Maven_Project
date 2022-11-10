package org.example;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroMD5 {
    public static void main(String[] args){
        String password = "z3";
        // Use MD5 encryption
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println("md5 encrypted == " +md5Hash);

        Md5Hash md5Hash2 = new Md5Hash(password,"salt");
        System.out.println("md5 encrypted == " +md5Hash2);

        Md5Hash md5Hash3 = new Md5Hash(password,"salt",3);
        System.out.println("md5 encrypted == " +md5Hash3);

        SimpleHash simpleHash = new SimpleHash("MD5",password,"salt",3);
        System.out.println("md5 encrypted == " + simpleHash);

    }
}
