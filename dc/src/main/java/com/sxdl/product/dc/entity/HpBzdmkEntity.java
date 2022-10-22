package com.sxdl.product.dc.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_bzdmk", description = "编码标准代码库")
@Entity
@Data
@Table(name="hp_bzdmk")
public class HpBzdmkEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "编码代码")
    private String code;

    @ApiModelProperty(value = "编码名称")
    private String name;

    @ApiModelProperty(value = "拼音码")
    private String pym;


    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "版本名称")
    private String version_name;

    @ApiModelProperty(value = "分类")
    private String type;

    @ApiModelProperty(value = "用于查询")
    private String query;





}
