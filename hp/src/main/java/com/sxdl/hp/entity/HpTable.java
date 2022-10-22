package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "hp_table", description = "表")
@Entity
@Data
@Table(name="hp_table")
public class HpTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "表名称")
    private String name;

    @ApiModelProperty(value = "表中文")
    private String name_zh;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否附页 1 是 0 否")
    private Integer ispage;

    @ApiModelProperty(value = "省行政代码")
    private String sheng_code;

    @ApiModelProperty(value = "医院类型:1 中医 2 西医 ")
    private Integer homepage_type;

    @ApiModelProperty(value = "是否中西医统一: 1 是  0 不是")
    private Integer is_equally;

    @ApiModelProperty(value = "是否启用: 1 是  0 不是")
    private Integer is_enable;

    @ApiModelProperty(value = "是否雕龙附页表: 1 是  0 不是")
    private Integer is_diaolong;


    @Transient
    @ApiModelProperty(value = "省份名称")
    private String sheng_name;

    @Transient
    @ApiModelProperty(value = "字段表")
    private List<HpColumn> hpColumns;



}
