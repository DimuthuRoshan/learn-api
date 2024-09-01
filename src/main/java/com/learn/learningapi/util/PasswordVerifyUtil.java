package com.learn.learningapi.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class PasswordVerifyUtil {

    private static final String ALGORITHM = "AES"; //AES/ECB/PKCS5Padding
    private static String getSaltValue(int length){
        StringBuilder saltVal = new StringBuilder(length);
        final String characters = "0123456789ABCDEFGHIJabcdefghij!@#$%^*_~`";

        for (int i = 0; i < length; i++)
        {
            saltVal.append( characters.charAt(new SecureRandom ().nextInt(saltVal.length())));
        }

        return new String(saltVal);
    }



    public void verifyPassword(char[] enteredPassword){
        String saltValue = getSaltValue ( 50 );
    }

    public void getPasswordPlainText(CharSequence encodedPassword){
        String pwd = "password";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder ();

        System.out.println ( bCryptPasswordEncoder.encode ( pwd ) );
    }

   /* public static String encryptPwd(String stringToEncode, String secretKey) throws Exception {
        Key publicKey = generateKey ( secretKey );
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encVal = c.doFinal(stringToEncode.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encVal);
        return encryptedValue;
    } */

    private static Key generateKey1(String secret) {
        byte[] decoded = Base64.getDecoder().decode(secret.getBytes());
        Key key = new SecretKeySpec (decoded, ALGORITHM);
        return key;
    }
    public static String decrypt(String algorithm, String cipherText, SecretKey key,
                                 IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }
    public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        SecretKey key = keyGenerator.generateKey();
        return key;
    }
    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static String encrypt(String algorithm, String input, SecretKey key,
                                 IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }
}
