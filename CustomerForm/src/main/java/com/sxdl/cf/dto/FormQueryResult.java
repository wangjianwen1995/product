package com.sxdl.cf.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
public class FormQueryResult implements Serializable {

     // 布局数据
    private String layoutJson;

    // 预览时候字段属性数据
    private Map<String, Object> fieldPropsMap;


    // 回显数据库数据
    private Map<String, Object> formData;

    // 暂时 不用
    private Map<String, String> labelData;

    // 暂时 不用
    private List<String> deletedFields;


    //一对一子表单   map : data_id  table_id  table_name table_name_zh
    private List<Map<String,String>> oneToOneChilds;



}
