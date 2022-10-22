package com.sxdl.ae.entity;


import com.sxdl.ae.util.GUID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "ae_patient", description = "患者信息")
@Entity
@Data
@Table(name="ae_patient")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class AEPatient implements Serializable {



    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;


    @ApiModelProperty(value = "就诊日期")
    @Column(name = "hz_jzrq")
    private String hz_jzrq;

    @ApiModelProperty(value = "患者:姓名")
    private String hz_xm;


    @ApiModelProperty(value = "患者:病案号")
    private String hz_bah;

    @ApiModelProperty(value = "患者:住院号")
    private String hz_zyh;
    @ApiModelProperty(value = "患者:年龄")
    private String hz_nl;

    @ApiModelProperty(value = "患者:性别  1男 2女")
    private String hz_xb;
    @ApiModelProperty(value = "患者:病区")
    private String hz_bq;

    @ApiModelProperty(value = "患者:床号")
    private String hz_ch;

    @ApiModelProperty(value = "患者:职业 走字典")
    private String hz_zy;


    @ApiModelProperty(value = "患者:诊疗类型 走字典 ")
    private String hz_zdlx;


    @ApiModelProperty(value = "患者:医疗付费类别 走字典")
    private String hz_fflb;


    @ApiModelProperty(value = "患者:临床主要诊断")
    private String hz_lczyzd;


    @ApiModelProperty(value = "患者:主要诊断ICD-10编码")
    private String hz_zyzdicdbm;




}
