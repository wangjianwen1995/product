package com.sxdl.cf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class TableModelDBO implements Serializable {

    //字段名
    private String name;
    //字段类型 (不包含字段长度)
    private String coltype;
    //字段类型2( 包含完成的长度)
    private String coltype2;
    //字段长度
    private String collen;
    //字段允许为空 1 可以空 0 不可以
    private String ablenull;
    //字段默认值
    private String defval;
    //是否主键 1 主键 0不是
    private String ismain;



}
