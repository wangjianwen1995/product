package com.sxdl.report.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "dr_reprot_record", description = "上报返回信息")
@Entity
@Data
@Table(name = "dr_reprot_record")
public class DrReprotRecord {

    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "模板代码")
    private Integer template_id;


    @ApiModelProperty(value = "项目代码")
    private Integer product_id;

    @ApiModelProperty(value = "病历号（主键唯一值）")
    private String primarykey;

    @ApiModelProperty(value = "上报开始时间")
    private String upload_start_time;

    @ApiModelProperty(value = "上报完成时间")
    private String upload_end_time;

    @ApiModelProperty(value = "入院科室编码")
    private String ks_code_ry;

    @ApiModelProperty(value = "出院科室编码")
    private String ks_code_cy;

    @ApiModelProperty(value = "住院号")
    private String zyh;

    @ApiModelProperty(value = "性别")
    private String sex;

     @ApiModelProperty(value = "出院诊断")
    private String primary_diagnosis;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "年龄单位")
    private String age_unit;

    @ApiModelProperty(value = "患者姓名")
    private String zhxm;

    @ApiModelProperty(value = "平台返回状态码/转态信息")
    private String result_type;


    @ApiModelProperty(value = "平台返回状内容")
    private String result_content;

    @ApiModelProperty(value = "查询时间(出院时间)", position = 8)
    private String querytime;

    @ApiModelProperty(value = "关系键值（UUID）")
    private String uuid;

    @Transient
    private String template_name;


}

