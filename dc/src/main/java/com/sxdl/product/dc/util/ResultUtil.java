package com.sxdl.product.dc.util;

import lombok.Data;

/**
 * @version 2.0
 */
@Data
public class ResultUtil<T> {
    private String state;


    private T t;

    private String msg;

    public ResultUtil() {
    }

    public ResultUtil(String state,String msg){
        this.state = state;
        this.msg = msg;
    }

    public ResultUtil(String state,T t){
        this.state = state;
        this.t = t;
    }

    public ResultUtil(String msg){
        this.msg = msg;
    }

    public ResultUtil(String state,T t,String msg){
        this.state = state;
        this.t = t;
        this.msg = msg;
    }

    public static <T>ResultUtil<T> resultUtil(String msg){
        return new ResultUtil(msg);
    }

    public  static  <T> ResultUtil<T>  error(String msg){
        return  new ResultUtil("error",msg);
    }

    public static <T> ResultUtil<T> success(T t,String msg){
        return new ResultUtil("success",t,msg);
    }


    public static  <T> ResultUtil<T> success(T t){
        return new ResultUtil("success",t);
    }


    public static  <T> ResultUtil<T> success(String msg){
        return new ResultUtil("success",msg);
    }


    @Override
    public String toString() {
        return "ResultUtil{" +
                "status='" + state + '\'' +
                ", t=" + t +
                ", msg='" + msg + '\'' +
                '}';
    }
}
