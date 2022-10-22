package com.sxdl.base.util;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * uuid主键生成策略实现类
 */
public class UUIdGenId implements GenId<String> {
    @Override
    public String genId(String table, String column) {
        return UUID.randomUUID().toString();
    }
}