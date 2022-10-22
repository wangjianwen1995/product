package com.sxdl.hmi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@ApiModel(value = "hmi_input_staff_rsk", description = "人员录入--人事科")
@Entity
@Data
@Table(name="hmi_input_staff_rsk")
public class HmiInputStaffRskEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "卫生技术人员总数")
    private Integer wsjsry;

    @ApiModelProperty(value = "正高职称人数")
    private Integer wsjszgry;

    @ApiModelProperty(value = "副高职称人数")
    private Integer wsjsfgry;

    @ApiModelProperty(value = "中级职称人数")
    private Integer wsjszjry;

    @ApiModelProperty(value = "初级职称人数")
    private Integer wsjscjry;

    @ApiModelProperty(value = "固定急诊医师人数")
    private Integer jzgdys;

    @ApiModelProperty(value = "急诊在岗医师人数")
    private Integer jzzgys;

    @ApiModelProperty(value = "急诊固定护士人数")
    private Integer jzgdhs;

    @ApiModelProperty(value = "急诊在岗护士人数")
    private Integer jzzghs;

    @ApiModelProperty(value = "重症医学科医师人数")
    private Integer zzyszs;

    @ApiModelProperty(value = "重症ICU医生人数")
    private Integer icuys;

    @ApiModelProperty(value = "重症CCU医生人数")
    private Integer ccuys;

    @ApiModelProperty(value = "重症RICU医生人数")
    private Integer ricuys;

    @ApiModelProperty(value = "重症NICU医生人数")
    private Integer nicuys;

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

    @ApiModelProperty(value = "麻醉医师人数")
    private Integer mzys;

    @ApiModelProperty(value = "中医医师人数")
    private Integer zyys;

    @ApiModelProperty(value = "中医护士人数")
    private Integer zyhs;

    @ApiModelProperty(value = "康复科医师人数")
    private Integer kfys;

    @ApiModelProperty(value = "康复科康复师人数")
    private Integer kfs;

    @ApiModelProperty(value = "康复科护士人数")
    private Integer kfhs;

    @ApiModelProperty(value = "感染科在岗医师人数")
    private Integer grzgys;

    @ApiModelProperty(value = "感染科固定医师人数")
    private Integer grgdys;

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



}
