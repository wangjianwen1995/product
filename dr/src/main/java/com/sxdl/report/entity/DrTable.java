package com.sxdl.report.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "drTable", description = "模板表管理")
@Entity
@Data
@Table(name = "dr_table")
public class DrTable {


    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "表名称", position = 2)
    @NotBlank(message = "表名称不能为空")
    private String name;

    @ApiModelProperty(value = "表中文名称", position = 3)
    private String name_zh;

    @ApiModelProperty(value = "模板ID", position = 4)
    @NotBlank(message = "模板ID不能为空")
    private Integer template_id;

    @ApiModelProperty(value = "存储ID", position = 5)
    @NotBlank(message = "存储ID不能为空")
    private Integer procdure_id;

    @ApiModelProperty(value = "是否是西医表", position = 6)
    @NotBlank(message = "是否是西医表不能为空")
    private Integer is_west;

    @ApiModelProperty(value = "病案数据库视图名", position = 7)
    private String view_name;

    @ApiModelProperty(value = "查询时间字段（一般为出院时间）", position = 8)
    private String querytime;

    @ApiModelProperty(value = "主键字段名", position = 9)
    private String primarykey;

    @ApiModelProperty(value = "住院号字段字段名")
    private String zyh;

    @ApiModelProperty(value = "入院科室编码字段名")
    private String ks_code_ry;

    @ApiModelProperty(value = "出院科室编码字段名")
    private String ks_code_cy;

    @ApiModelProperty(value = "性别字段名")
    private String sex;

    @ApiModelProperty(value = "出院诊断字段名")
    private String primary_diagnosis;

    @ApiModelProperty(value = "年龄字段名")
    private String age;

    @ApiModelProperty(value = "年龄单位字段名")
    private String age_unit;

    @ApiModelProperty(value = "患者姓名字段名")
    private String zhxm;

    @ApiModelProperty(value = "1:自动调度启用")
    private Integer auto_procdure;
    @Transient
    private Integer sid;

    @Transient
    private String sidname;




}
