package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_reprot_column", description = "上报平台字段维护(用来储存上报平台的字段和汉字解释,为后面上报字段映射做数据提供依据)")
@Entity
@Data
@Table(name="drplus_reprot_column")
public class DrPlusReprotColumn implements Serializable {


    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "字段名称")
    private String name;

    @ApiModelProperty(value = "字段中文")
    private String name_zh;



}
