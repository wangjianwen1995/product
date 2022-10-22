package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_sszd_gxb", description = "各种iccm编码对照")
@Entity
@Data
@Table(name="hp_sszd_gxb")
public class HpSSZDGxb implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "左列编码")
    private String left_bm;
    
    @ApiModelProperty(value = "左列名称")
    private String left_mc;


    @ApiModelProperty(value = "右列代码")
    private String right_dm;

    @ApiModelProperty(value = "右列名称")
    private String right_mc;

    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "状态")
    private String status;


}
