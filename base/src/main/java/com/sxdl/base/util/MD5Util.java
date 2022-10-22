package com.sxdl.base.util;

import cn.hutool.core.util.StrUtil;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


public class MD5Util {

    /**
     * 自定义加密类
     * @param s 原文
     * @return 密文
     */
    public static final String encryptSelf(String s){
        if(StrUtil.isEmpty(s)){
            return "";
        } else  {
            BigInteger biginteger = new BigInteger(s.getBytes());
            BigInteger biginteger1 = new BigInteger("815205");
            BigInteger biginteger2 = biginteger1.xor(biginteger);
            return biginteger2.toString(16);
        }
    }

    /**
     * 自定义解密类
     * @param s 密文
     * @return 原文
     */
    public static final String decryptSelf(String s){
        if(s == null)
            return "";
        if(s.length() == 0)
            return "";
        BigInteger biginteger = new BigInteger("815205");
        try
        {
            BigInteger biginteger1 = new BigInteger(s, 16);
            BigInteger biginteger2 = biginteger1.xor(biginteger);
            return new String(biginteger2.toByteArray());
        }
        catch(Exception exception)
        {
            return "";
        }
    }
    public static String toMD5(String plainText) {

        StringBuffer buf = new StringBuffer();
        try {
            //生成实现指定摘要算法的 MessageDigest 对象。
            MessageDigest md = MessageDigest.getInstance("MD5");
            //使用指定的字节数组更新摘要。
            md.update(plainText.getBytes());
            //通过执行诸如填充之类的最终操作完成哈希计算。
            byte[] b = md.digest();
            //生成具体的md5密码到buf数组
            int i;
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    public final static String MD5Encoder(String s) {
        try {
            byte[] btInput = s.getBytes(StandardCharsets.UTF_8);
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16){
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }


    // 测试主函数
    public static void main(String[] args) {
        String s = "1";
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + MD5Encoder(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));

    }


}
