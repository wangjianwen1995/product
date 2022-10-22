package com.sxdl.cf.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true) //set链式编程
public class SqlQueryDBO implements Serializable {
    // 查询sql
    private String sql;
    //用户模糊查询的值
    private String val;
    //用户选择的数据
    private String code;
}
