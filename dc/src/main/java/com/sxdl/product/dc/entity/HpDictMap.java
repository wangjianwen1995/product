package com.sxdl.product.dc.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_dict_map", description = "hp与his字段对映")
@Entity
@Data
@Table(name="hp_dict_map")
public class HpDictMap implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "医院his代码")
    private String his_code;

    @ApiModelProperty(value = "医院his名称")
    private String his_name;

    @ApiModelProperty(value = "病案表名称")
    private String hp_table_name;

    @ApiModelProperty(value = "病案字段名称")
    private String hp_column_name;

    @ApiModelProperty(value = "病案字段 键")
    private String hp_key;

    @ApiModelProperty(value = "病案字典 值")
    private String hp_val;

    @ApiModelProperty(value = "病案字典 值的id 用来排序")
    private Integer hp_val_id;

    @ApiModelProperty(value = "his字典 键")
    private String his_key;

    @ApiModelProperty(value = "his字典 值")
    private String his_val;

    @ApiModelProperty(value = "病案表id")
    private String hp_table_id;

    @ApiModelProperty(value = "病案字段id")
    private String hp_column_id;

    @ApiModelProperty(value = "字典表id")
    private Integer dict_talbe_id;




}
