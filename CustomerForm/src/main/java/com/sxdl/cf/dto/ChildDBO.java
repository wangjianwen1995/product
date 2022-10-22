package com.sxdl.cf.dto;

import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
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
public class ChildDBO implements Serializable {



    //表id
    private String table_id;
    //表名
    private String name;

    // 表中文名
    private String label;

    //列表属性
    private List<SysCustomerFormHeaderColumnEntity> columnList;

    private String type;
    //字段数据
    private Map<String, SysCustomerFormFieldTableEntity> fieldList;



}
