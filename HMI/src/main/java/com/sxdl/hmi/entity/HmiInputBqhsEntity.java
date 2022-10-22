package com.sxdl.hmi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@ApiModel(value = "hmi_input_cwk", description = "病区护士人数录入")
@Entity
@Data
@Table(name="hmi_input_bqhs")
public class HmiInputBqhsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "关联父表ID")
    private String nurid;

    @ApiModelProperty(value = "科室code")
    private String kscode;

    @ApiModelProperty(value = "科室名称")
    private String ksname;

    @ApiModelProperty(value = "护士人数")
    private Integer hsrs;


    @ApiModelProperty(value = "录入日期")
    private Date inputdate;

    @ApiModelProperty(value = "录入人员工号")
    private String inputuser;

    @ApiModelProperty(value = "录入人员名称")
    private String inputusername;



}
