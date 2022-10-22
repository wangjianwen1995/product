package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "education_info", description = "学历信息")
@Entity
@Data
@Table(name = "education_info")
public class HnEducationInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "登录工号")
    private Integer pid;

    @ApiModelProperty(value = "开始时间")
    private String start_time;

    @ApiModelProperty(value = "结束时间")
    private String end_time;

    @ApiModelProperty(value = "院校类别")
    private String institutions_type;

    @ApiModelProperty(value = "院校名称")
    private String institutions_name;

    @ApiModelProperty(value = "年制")
    private String year_system;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "学历")
    private String education;

    @ApiModelProperty(value = "学历url")
    private String education_path;

    @ApiModelProperty(value = "文件名")
    private String education_name;

}
