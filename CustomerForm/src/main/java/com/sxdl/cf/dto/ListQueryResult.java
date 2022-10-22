package com.sxdl.cf.dto;

import com.sxdl.cf.entity.SysCustomerFormHeaderColumnEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;


@Data
public class ListQueryResult implements Serializable {

    //列表数据库数据
    private List<LinkedHashMap<String, Object>> dataList;

    //列表属性
    private List<SysCustomerFormHeaderColumnEntity> columnList;
    //分页数据
    private PaginationCF pagination;
    //查询条件
    private List<SysCustomerFormHeaderColumnEntity> conditionList;
}
