package com.sxdl.ae.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "sysKs", description = "医院科室信息")
@Entity
@Data
@Table(name = "sys_ks")
public class AESysKs implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @Id
    private Integer id;

    @ApiModelProperty(value = "代码")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "简称")
    private String short_name;

    @ApiModelProperty(value = "院区id")
    private Integer yq_id;

    @ApiModelProperty(value = "院区名称")
    private String yq_name;

    @ApiModelProperty(value = "集团科室id")
    private Integer ltd_ks_id;

    @ApiModelProperty(value = "集团科室名称")
    private String ltd_ks_name;

    @ApiModelProperty(value = "科室组id")
    private String group_ks_id;

    @ApiModelProperty(value = "科室组名称")
    private String group_ks_name;

    @ApiModelProperty(value = "标准科目id")
    private String standard_ks_id;

    @ApiModelProperty(value = "标准科目名称")
    private String standard_ks_name;

    @ApiModelProperty(value = "床位数")
    private Integer bed;

    @ApiModelProperty(value = "加床数")
    private Integer extra_bed;

    @ApiModelProperty(value = "编制床位数")
    private Integer auth_bed;

    @ApiModelProperty(value = "是否手术操作")
    private Integer is_opr;

    @ApiModelProperty(value = "是否住院科室")
    private Integer is_id;

    @ApiModelProperty(value = "是否急诊科室")
    private Integer is_ed;

    @ApiModelProperty(value = "是否门诊科室")
    private Integer is_od;

    @ApiModelProperty(value = "是否停用")
    private Integer is_on;

}
