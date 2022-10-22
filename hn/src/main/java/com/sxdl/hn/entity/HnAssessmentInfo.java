package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "assessment_info", description = "档案:考核登记")
@Entity
@Data
@Table(name="assessment_info")
public class HnAssessmentInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "time")
    private String time;

    @ApiModelProperty(value = "内容")
    private String assessment_content;

    @ApiModelProperty(value = "成绩与评定意见")
    private String opinion;

    @ApiModelProperty(value = "考核部门")
    private String assessment_department;

    @ApiModelProperty(value = "url")
    private String assessment_path;


    @ApiModelProperty(value = "文件名")
    private String assessment_name;

}
