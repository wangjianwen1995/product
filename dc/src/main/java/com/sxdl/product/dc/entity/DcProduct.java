package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 产品信息类
 */
@ApiModel(value = "产品信息类")
@Entity
@Data
@Table(name = "dc_product")
public class DcProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    private String id;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "简称")
    private String short_name;

    @ApiModelProperty(value = "产品版本")
    private String version;


    @ApiModelProperty(value = "数据库")
    private String database_name;

    @ApiModelProperty(value = "产品名称")
    private String name_zh;

    @ApiModelProperty(value = "简称")
    private String short_name_zh;



    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否是我们自己的项目1是2否")
    private Integer isown;

    @ApiModelProperty(value = "是否实施状态 1是2否")
    private Integer isdeploy;


    @ApiModelProperty(value = "生成源表时加的前缀")
    private String prefix;

}