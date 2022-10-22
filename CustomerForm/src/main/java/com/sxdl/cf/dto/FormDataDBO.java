package com.sxdl.cf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class FormDataDBO implements Serializable {

    //父表数据 是一个对象
    private Map<String, Object> parentData;

    //一对多 子表表数据 是一个集合
    private Map<String,List<Map<String, Object>>> childManyData;

    //一对一子表表数据 是一个对象
    private Map<String, Map<String, Object>>  childOneData;

}
