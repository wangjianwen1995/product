package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Deprecated
@ApiModel(value = "drplus_platform_bigclass", description = "平台大类(储存平台分类,如国家/省级/市级 还有启停状态)")
@Entity
@Data
@Table(name="drplus_platform_bigclass")
public class DrPlusPlatformBigclass implements Serializable {


   /*

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;


    @Transient
   */

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;


    @ApiModelProperty(value = "平台分类名称")
    private String classify;

    @ApiModelProperty(value = "状态:0停用 1 启用")
    private Integer status;




}
