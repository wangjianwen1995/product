package com.sxdl.hpqc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "hp_qm_dl")
@ApiModel(value = "hp_qm_dl", description = "病案逻辑质控条件组")
public class HpQcDlEntity {

    @Column(name="id")
    @ApiModelProperty(value = "id")
    private String ID;

    @Column(name="fields")
    @ApiModelProperty(value = "fields")
    private String fields;

    @Column(name="fields_anchor")
    @ApiModelProperty(value = "fields_anchor")
    private String fields_anchor;

    @Column(name="sqls")
    @ApiModelProperty(value = "sqls")
    private String sqls;

    @Column(name="message")
    @ApiModelProperty(value = "message")
    private String message;

    @Column(name="is_on")
    @ApiModelProperty(value = "is_on")
    private String is_on;

    @Column(name="can_forced")
    @ApiModelProperty(value = "can_forced")
    private String can_forced;

    @Column(name="classify")
    @ApiModelProperty(value = "classify")
    private String classify;

    @Column(name="classify_id")
    @ApiModelProperty(value = "classify_id")
    private Integer classify_id;

    @Column(name="ordernum")
    @ApiModelProperty(value = "ordernum")
    private Integer ordernum;



    @Column(name="x1")
    @ApiModelProperty(value = "x1")
    private String x1;

    @Column(name="x2")
    @ApiModelProperty(value = "x2")
    private String x2;

    @Column(name="x3")
    @ApiModelProperty(value = "x3")
    private String x3;

    @Column(name="x4")
    @ApiModelProperty(value = "x4")
    private String x4;

    @Column(name="x5")
    @ApiModelProperty(value = "x5")
    private String x5;

    @Column(name="x6")
    @ApiModelProperty(value = "x6")
    private String x6;

    @Column(name="x7")
    @ApiModelProperty(value = "x7")
    private String x7;


    @Column(name="connetType")
    @ApiModelProperty(value = "connetType")
    private String connetType;




}
