package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@ApiModel(value = "hp_condition", description = "条件")
@Entity
@Data
@Table(name="hp_condition")
public class HpCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "条件组id")
    private String pid;


    @ApiModelProperty(value = "字段id")
    private String column_id;

    @ApiModelProperty(value = "表名称")
    private String table_name;


    @ApiModelProperty(value = "字段名称")
    private String column_name;

    @ApiModelProperty(value = "左括号")
    private String left_brackets;

    @ApiModelProperty(value = "右括号")
    private String right_brackets;

    @ApiModelProperty(value = "操作符:>=")
    private String operator;

    @ApiModelProperty(value = "值")
    private String val;

    @ApiModelProperty(value = "条件关系:逻辑符 and or")
    private String link;

    @ApiModelProperty(value = "sql脚本片段")
    private String sql;

    @ApiModelProperty(value = "序号")
    private Integer xh;


    @Transient
    @ApiModelProperty(value = "字段类型")
    private Integer column_type;


    @Transient
    @ApiModelProperty(value = "是否下拉框")
    private Integer is_query;

    @Transient
    @ApiModelProperty(value = "接口数据的key")
    private String web_name;





}
