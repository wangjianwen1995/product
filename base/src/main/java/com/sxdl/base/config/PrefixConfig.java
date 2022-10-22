package com.sxdl.base.config;

import org.springframework.context.annotation.Bean;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

/**
 * base中公共的表的库名前缀
 */
public class PrefixConfig {
    /**
     * 各个系统自定义的表名前缀,在打包时候改成自己业务系统的,否则数据全部错乱
     *
     */
//    public static final String PREFIX ="drplus_" ;
    public static final String PREFIX ="";

//    public static final String PREFIX ="ae_";


}