package com.sxdl.drplus.util;

import cn.hutool.crypto.digest.DigestUtil;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

public class Encryption {

    public static byte[] StoB(String str){
        return  DatatypeConverter.parseBase64Binary(str);
    }

    public static String EncryptionOrDecrypt(String Data,int DeOrEn ) throws Exception{
        String KEY="qJzMFK5hESZDVJeCnFPGuxzaiB7NLQM98";
        DESedeKeySpec keySpec = new DESedeKeySpec(StoB(KEY));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("desede");
        Key keyvalue = keyFactory.generateSecret(keySpec);
        Cipher deCipher = Cipher.getInstance("desede/ECB/PKCS5Padding");
        byte[] pasByte=null;
        String str = null;
        if(1==DeOrEn){ //加密
            deCipher.init(Cipher.ENCRYPT_MODE, keyvalue);
            pasByte = deCipher.doFinal(Data.getBytes("UTF-8"));
            str = new BASE64Encoder().encode(pasByte);
        }else if(2==DeOrEn){ //解密
            deCipher.init(Cipher.DECRYPT_MODE, keyvalue);
            pasByte = deCipher.doFinal(StoB(Data));
            str = new String(pasByte, "UTF-8");
        }
        return str;
    }


    public static boolean containKey(String str){
        return str.contains(getGreat());
    }

    public static String getKeySup(){
        return "Admin";
    }

    public static String getGreat(){
        return DigestUtil.md5Hex("爸爸666");
    }

    public static String getMd5(String key){
       return DigestUtil.md5Hex(key);
    }


    public static void main(String[] args)throws Exception {
        String dateTime = DataUtil.getDateTime() + getGreat();
        String 爸爸 = EncryptionOrDecrypt(dateTime, 1);
        String s = EncryptionOrDecrypt(爸爸, 2);
        System.out.println(爸爸);
        System.out.println(s);
    }

}

