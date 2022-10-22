package com.sxdl.hmi.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@ApiModel(value = "hmi_input_staff_hlb", description = "人员录入--护理部")
@Entity
@Data
@Table(name="hmi_input_staff_hlb")
public class HmiInputStaffHlbEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "全院职称护士总数")
    private Integer hszs;

    @ApiModelProperty(value = "正高职称护士人数")
    private Integer zghs;

    @ApiModelProperty(value = "副高职称护士人数")
    private Integer fghs;

    @ApiModelProperty(value = "中级职称护士人数")
    private Integer zjhs;

    @ApiModelProperty(value = "初级职称护士人数")
    private Integer cjhs;

    @ApiModelProperty(value = "急诊固定护士人数")
    private Integer jzgdhs;

    @ApiModelProperty(value = "急诊在岗护士人数")
    private Integer jzzghs;

    @ApiModelProperty(value = "重症医学科护士人数")
    private Integer zzhszs;

    @ApiModelProperty(value = "重症ICU护士人数")
    private Integer icuhs;

    @ApiModelProperty(value = "重症CCU护士人数")
    private Integer ccuhs;

    @ApiModelProperty(value = "重症RICU护士人数")
    private Integer ricuhs;

    @ApiModelProperty(value = "重症NICU护士人数")
    private Integer nicuhs;

    @ApiModelProperty(value = "中医护士人数")
    private Integer zyhs;

    @ApiModelProperty(value = "康复科护士人数")
    private Integer kfhs;

    @ApiModelProperty(value = "感染科在岗护士人数")
    private Integer grzghs;

    @ApiModelProperty(value = "感染科固定护士人数")
    private Integer grgdhs;


    @ApiModelProperty(value = "录入日期")
    private Date inputdate;

    @ApiModelProperty(value = "录入人员工号")
    private String inputuser;

    @ApiModelProperty(value = "录入人员名称")
    private String inputusername;

    @ApiModelProperty(value = "状态：1未审/2已审")
    private Integer status;


    @Transient
    private List<HmiInputBqhsEntity> ksInfo; //院区护士人数




}
