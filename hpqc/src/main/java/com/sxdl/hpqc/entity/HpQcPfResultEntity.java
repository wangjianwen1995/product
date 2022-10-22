package com.sxdl.hpqc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "hp_qm_pf_result")
@ApiModel(value = "hp_qm_pf_result", description = "质控-评分结果表")
public class HpQcPfResultEntity {

    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private String ID;

    @Column(name = "bah")
    @ApiModelProperty(value = "bah")
    private String bah;

    @Column(name = "message")
    @ApiModelProperty(value = "message")
    private String message;

    @Column(name = "orde_rum")
    @ApiModelProperty(value = "orde_rum")
    private Integer orde_rum;

    @Column(name = "fields_anchor")
    @ApiModelProperty(value = "fields_anchor")
    private String fields_anchor;

    @Column(name = "time")
    @ApiModelProperty(value = "time")
    private String time;

    @Column(name = "kfz")
    @ApiModelProperty(value = "kfz")
    private Double kfz;


    @Column(name = "fields")
    @ApiModelProperty(value = "fields")
    private String fields;

    @Column(name = "packages")
    @ApiModelProperty(value = "packages")
    private String packages;

    @Column(name = "packages_score")
    @ApiModelProperty(value = "packages_score")
    private Double packages_score;

    @Column(name = "cykb")
    @ApiModelProperty(value = "出院科室")
    private String cykb;
    @Column(name = "cykb_name")
    @ApiModelProperty(value = "出院科室名称")
    private String cykb_name;
    @Column(name = "is_link")
    @ApiModelProperty(value = "是否环节质控 1：环节 2 终末")
    private int is_link;
    @Column(name = "iswest")
    @ApiModelProperty(value = "是否中西医 1：中医 2：西医")
    private int iswest;

    @Transient
    @ApiModelProperty(value = "备注")
    private String bz;

    @Column(name = "is_first")
    @ApiModelProperty(value = "是否首次质控 1：是 2：不是")
    private Integer is_first;

    @Column(name = "qc_time")
    @ApiModelProperty(value = "质控时间")
    private String qc_time;
    @Column(name = "home_type")
    @ApiModelProperty(value = "首页信息类型") // 1：基本2：诊疗3：手术4：费用5：其他
    private Integer home_type;
    @ApiModelProperty(value = "分类名称")
    private String classify;
    @ApiModelProperty(value = "是否强制1是 0否 ")
    private Integer can_forced;
}


