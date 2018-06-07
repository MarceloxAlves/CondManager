package br.com.avantitecnologiati.condmanager.helper;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    public static String codificar(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        algorithm.update(password.getBytes(),0,password.length());
        String hash = new BigInteger(1, algorithm.digest()).toString(16);
        return hash;
   }


}
