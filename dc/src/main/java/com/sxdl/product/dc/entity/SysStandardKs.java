package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "sysStandardKs", description = "国家标准科目信息")
@Entity
@Data
@Table(name = "sys_standard_ks")
public class SysStandardKs implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ApiModelProperty(value = "代码")
    private String id;

    @ApiModelProperty(value = "诊疗科目")
    private String name;

    @ApiModelProperty(value = "级别")
    private Integer level;

    @ApiModelProperty(value = "试用医院级别")
    private String hospital_level;

    @ApiModelProperty(value = "父代码")
    private String parent_code;

    @Transient
    private List<SysStandardKs> children;

}
