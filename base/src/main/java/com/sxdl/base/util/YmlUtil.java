package com.sxdl.base.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 读取yml配置工具类
 */
@Component
public class YmlUtil {

    @Autowired
    private Environment env;

    /**
     * 获取yml配置中任意的值
     *
     * @param key yml中完整的key配置
     * @return String 配置中任意的值
     */
    public String getYmlValue(String key) {
        return env.containsProperty(key) ? env.getProperty(key) : null;
    }

    /**
     * 获取yum配置中的任意值,如果是空,则返回默认指定值
     *
     * @param key  yml中完整的key配置
     * @param deft 默认值
     * @return String 配置中任意的值或默认值
     */
    public String getYmlValueOrDefault(String key, String deft) {
        return StrUtil.emptyToDefault(getYmlValue(key), deft);
    }

    /**
     * 获取是否java版hbi
     * 1 是,0 否(默认)
     * @return String 是否java版hbi
     */
    public String getIsNew() {
        return getYmlValueOrDefault("HBI.isNew","0");
    }

    /**
     * 获取java版hbi中的publicKey配置
     *
     * @return String publicKey配置
     */
    public String getPublicKey() {
        return getYmlValue("HBI.publicKey");
    }

    /**
     * 获取java版hbi中url配置
     *
     * @return String hbi中url配置
     */
    public String getHbiURL() {
        return getYmlValue("HBI.url");
    }

    /**
     * 获取dclink配置,如果没有配置默认返回dl_dc
     *
     * @return String dclink配置
     */
    public String getDCDBname() {
        return getYmlValueOrDefault("dcLink", "dl_dc");
    }


    /**
     * 得到备份路径
     *
     * @return {@link String} 备份路径,默认是 D:\\bf
     */
    public String getBackupPath() {
        return getYmlValueOrDefault("back_path", "D:" + File.separator + "bf");
    }

    /**
     * 得到备份有效期
     *
     * @return {@link String} 有效期,默认是10
     */
    public Integer getBackupPeriodOfValidity() {
        return Integer.parseInt(getYmlValueOrDefault("back_time", "10"));
    }
}
