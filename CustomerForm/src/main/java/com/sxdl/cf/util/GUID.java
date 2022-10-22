package com.sxdl.cf.util;

import tk.mybatis.mapper.genid.GenId;

import java.net.InetAddress;
import java.util.UUID;

public class GUID implements GenId<String> {
    /* @Override
     public String genId(String table, String column) {
         return UUID.randomUUID().toString();
     }*/
    @Override
    public String genId(String table, String column) {
        return generate() ;
    }


    public static String generate() {
        return (format(System.currentTimeMillis())+"-"+
                format(System.currentTimeMillis()>>4)+"-"+
                format(Long.parseLong(Long.toString(System.currentTimeMillis()).substring(0,9))*2)+"-"+
                formatInt( getCount())+"-"+
                UUID.randomUUID().toString().substring(0,8)).toUpperCase();
    }




    public static String generatecode() {
        return (format(System.currentTimeMillis())+
                format(Long.parseLong(Long.toString(System.currentTimeMillis()).substring(0,9))*2)+
                formatInt( getCount())+
                UUID.randomUUID().toString().substring(0,8)).toUpperCase();
    }



    public static void main(String[] args) {




//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis());
//        System.out.println(generatecode());
//        System.out.println(generatecode());
//        System.out.println(generatecode());
//        System.out.println(generatecode());
//        System.out.println(generate().toUpperCase());
//        System.out.println(generate().toUpperCase());
//        System.out.println(generate().toUpperCase());
//        System.out.println(generate().toUpperCase());
/*        List<String> list = Arrays.asList("l2798wbl-6sxdl61"+ "-"+UUID.randomUUID().toString().substring(0,8), "l2798wbl-6sxdl63"+ "-"+UUID.randomUUID().toString().substring(0,8), "l2798wbl-6sxdl64"+ "-"+ UUID.randomUUID().toString().substring(0,8), "l279anwn-6sxdl61"+ "-"+UUID.randomUUID().toString().substring(0,8));
        List<String> list2 = Arrays.asList("l2798wbl-6sxdl61", "l2798wbl-6sxdl63", "l2798wbl-6sxdl64", "l279anwn-6sxdl61");
        List<String> collect = list.stream().sorted(String::compareTo).collect(Collectors.toList());
        List<String> collect2 = list2.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect2);*/
        System.out.println(generate());
        System.out.println(generatecode());

    }

    protected static String format(int value) {
        int index = value%chars.length;
        value = value/chars.length;
        if(value>0){
            return  format(value)+chars[index];
        }else return ""+chars[index];
    }
    protected static String formatInt(int value) {
        String re = format(value);
        re="6sxdl6"+re;
        return re.substring(re.length()-7);
    }
    static char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g',
            'h','i','j','k','l','m','n',
            'o','p','q','r','s','t',
            'u','v','w','x','y','z'};

    public static String format(Long value){
        Long index = value%chars.length;
        value = value/chars.length;
        if(value>0){
            return format(value)+chars[index.intValue()];
        }else return ""+chars[index.intValue()];
    }
    public static int toInt(byte[] bytes) {
        int result = 0;
        for ( int i = 0; i < 4; i++ ) {
            result = ( result << 8 ) - Byte.MIN_VALUE + (int) bytes[i];
        }
        return result;
    }
    private static final int IP;
    static {
        int ipadd;
        try {
            ipadd = toInt( InetAddress.getLocalHost().getAddress() );
        }
        catch (Exception e) {
            ipadd = 0;
        }
        IP = ipadd;
    }
    private static Integer counter = (Integer) 0;
    private static final int JVM = (int) ( System.currentTimeMillis() >>> 8 );

    protected  synchronized static Integer getCount() {
        counter=counter<0?0:++counter;
        return counter;
    }

    protected static int getIP() {
        return IP;
    }

}
