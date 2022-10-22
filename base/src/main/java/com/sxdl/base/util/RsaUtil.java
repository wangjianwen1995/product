package com.sxdl.base.util;

import cn.hutool.core.codec.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RsaUtil
 * @Description: RSA加解密工具类
 */
public class RsaUtil {


    private static final int DEFAULT_RSA_KEY_SIZE = 2048;

    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 生成RSA 公私钥,可选长度为1025,2048位.
     */
    public static Map<String, String> generateRsaKey(int keySize) {
        Map<String, String> result = new HashMap<>(2);
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

            // 初始化密钥对生成器，密钥大小为1024 2048位
            keyPairGen.initialize(keySize, new SecureRandom());
            // 生成一个密钥对，保存在keyPair中
            KeyPair keyPair = keyPairGen.generateKeyPair();
            // 得到公钥字符串
            result.put("publicKey", new String(Base64.encode(keyPair.getPublic().getEncoded())));
            // 得到私钥字符串
            result.put("privateKey", new String(Base64.encode(keyPair.getPrivate().getEncoded())));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) {
        //64位解码加密后的字符串
        byte[] inputByte;
        String outStr = "";
        try {
            inputByte = Base64.decode(str.getBytes("UTF-8"));
            //base64编码的私钥
            byte[] decoded = Base64.decode(privateKey);
            RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(decoded));
            //RSA解密
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            outStr = new String(cipher.doFinal(inputByte));

        } catch (UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return outStr;
    }


    /**
     * 公钥加密
     *
     * @param str       如题
     * @param publicKey 如题
     * @throws Exception
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance(KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encode(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

}
