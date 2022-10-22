package com.sxdl.hmi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@ApiModel(value = "hmi_input_staff_ricu", description = "人员录入--RICU")
@Entity
@Data
@Table(name="hmi_input_staff_ricu")
public class HmiInputStaffRicuEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "RICU医师人数")
    private Integer ricuys;

    @ApiModelProperty(value = "RICU护士人数")
    private Integer ricuhs;


    @ApiModelProperty(value = "录入日期")
    private Date inputdate;

    @ApiModelProperty(value = "录入人员工号")
    private String inputuser;

    @ApiModelProperty(value = "录入人员名称")
    private String inputusername;

    @ApiModelProperty(value = "状态：1未审/2已审")
    private Integer status;


}
