package com.sxdl.product.dc.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "dc_dict_map", description = "dc与his字段对映")
@Entity
@Data
@Table(name="dc_dict_map")
public class DcDictMap implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "医院his代码")
    private String his_code;

    @ApiModelProperty(value = "医院his名称")
    private String his_name;

    @ApiModelProperty(value = "dc表名称")
    private String dc_table_name;

    @ApiModelProperty(value = "dc字段名称")
    private String dc_column_name;

    @ApiModelProperty(value = "dc字段 键")
    private String dc_key;

    @ApiModelProperty(value = "dc字典 值")
    private String dc_val;

    @ApiModelProperty(value = "字典 值的id 用来排序")
    private Integer dc_val_id;

    @ApiModelProperty(value = "his字典 键")
    private String his_key;

    @ApiModelProperty(value = "his字典 值")
    private String his_val;

    @ApiModelProperty(value = "dc表id")
    private String dc_table_id;

    @ApiModelProperty(value = "dc字段id")
    private String dc_column_id;

    @ApiModelProperty(value = "字典表id")
    private Integer dict_talbe_id;




}
