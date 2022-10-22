package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "mainexperience_info", description = "主要经历")
@Entity
@Data
@Table(name = "mainexperience_info")

public class HnMainexperienceInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "开始时间")
    private String start_time;

    @ApiModelProperty(value = "结束时间")
    private String end_time;

    @ApiModelProperty(value = "何单位")
    private String whatunit;

    @ApiModelProperty(value = "何职位")
    private String whatpost;

    @ApiModelProperty(value = "何专业")
    private String whatmajor;

    @ApiModelProperty(value = "主要经理url")
    private String main_path;

    @ApiModelProperty(value = "主要经理url")
    private String main_name;

}
