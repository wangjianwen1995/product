package com.sxdl.hmi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@ApiModel(value = "hmi_input_staff_grk", description = "人员录入--感染科")
@Entity
@Data
@Table(name="hmi_input_staff_grk")
public class HmiInputStaffGrkEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "感染专职人数")
    private Integer grzzry;


    @ApiModelProperty(value = "录入日期")
    private Date inputdate;

    @ApiModelProperty(value = "录入人员工号")
    private String inputuser;

    @ApiModelProperty(value = "录入人员名称")
    private String inputusername;

    @ApiModelProperty(value = "感染科在岗医师人数")
    private Integer grzgys;

    @ApiModelProperty(value = "感染科固定医师人数")
    private Integer grgdys;

    @ApiModelProperty(value = "感染科在岗护士人数")
    private Integer grzghs;

    @ApiModelProperty(value = "感染科固定护士人数")
    private Integer grgdhs;



}
