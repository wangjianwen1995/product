package com.sxdl.cf.util;

import java.io.*;
import java.util.List;

public class BeanUtils {


    /**
     *  list 深度拷贝
     * @param src 如题
     * @param <T> 如题

     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> deepCopyList(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }


    /**
     *  obj 深度拷贝
     * @param src 如题
     * @param <T> 如题
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> T deepCopyBean(T src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        T dest = (T) in.readObject();
        return dest;
    }
}


