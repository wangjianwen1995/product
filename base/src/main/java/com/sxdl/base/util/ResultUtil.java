package com.sxdl.base.util;

import lombok.Data;

/**
 * 全局返回信息包装类
 */
@Data
public class ResultUtil<T> {
    /**
     * 操作的状态
     */
    private String state;

    /**
     * 返回的数据
     */
    private T t;
    /**
     * 返回的信息
     */
    private String msg;

    /**
     * 空的构造方法
     */
    public ResultUtil() {
    }

    /**
     * 包含操作状态+返回信息的构造方法
     *
     * @param state 如题
     * @param msg   如题
     */
    public ResultUtil(String state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    /**
     * 包含操作状态+返回数据的构造方法
     *
     * @param state 如题
     * @param t     如题
     */
    public ResultUtil(String state, T t) {
        this.state = state;
        this.t = t;
    }

    /**
     * 包含返回信息的构造方法
     *
     * @param msg 如题
     */
    public ResultUtil(String msg) {
        this.msg = msg;
    }

    /**
     * 包含操作状态,返回数据,返回信息的构造方法
     *
     * @param state 如题
     * @param t     如题
     * @param msg   如题
     */
    public ResultUtil(String state, T t, String msg) {
        this.state = state;
        this.t = t;
        this.msg = msg;
    }

    /**
     * 只返回信息
     *
     * @param msg 如题
     * @param <T> 如题
     */
    public static <T> ResultUtil<T> resultUtil(String msg) {
        return new ResultUtil(msg);
    }

    /**
     * 默认状态时"错误",且包含返回信息
     *
     * @param msg 如题
     * @param <T> 如题
     */
    public static <T> ResultUtil<T> error(String msg) {
        return new ResultUtil("error", msg);
    }

    /**
     * 默认状态时"错误",且包含返回信息+返回数据
     *
     * @param msg 如题
     * @param <T> 如题
     */
    public static <T> ResultUtil<T> error(T t, String msg) {
        return new ResultUtil("error", t, msg);
    }

    /**
     * 默认状态时"成功",且包含返回信息+返回数据
     *
     * @param msg 如题
     * @param <T> 如题
     */
    public static <T> ResultUtil<T> success(T t, String msg) {
        return new ResultUtil("success", t, msg);
    }

    /**
     * 默认状态时"成功",且包含返回数据
     *
     * @param t   如题
     * @param <T> 如题
     */
    public static <T> ResultUtil<T> success(T t) {
        return new ResultUtil("success", t);
    }

    /**
     * 默认状态时"成功",且包含返回信息
     *
     * @param msg 如题
     * @param <T> 如题
     */
    public static <T> ResultUtil<T> success(String msg) {
        return new ResultUtil("success", msg);
    }

    /**
     * 判断状态是否成功
     */
    public boolean isSuc() {
        if ("success".equals(this.state)) {
            return true;
        } else {
            return false;
        }
    }
}
