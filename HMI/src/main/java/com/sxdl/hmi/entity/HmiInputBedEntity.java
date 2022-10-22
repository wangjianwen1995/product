package com.sxdl.hmi.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@ApiModel(value = "hmi_input_bed", description = "录入--科室床位信息")
@Entity
@Data
@Table(name="hmi_input_bed")
public class HmiInputBedEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "关联医院录入信息的id")
    private String hosid;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "科室代码")
    private String kscode;

    @ApiModelProperty(value = "科室名称")
    private String ksname;

    @ApiModelProperty(value = "科室实际开放床位数")
    private Integer sjkfbed;



}
