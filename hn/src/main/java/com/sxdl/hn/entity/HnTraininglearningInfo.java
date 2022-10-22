package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "traininglearning_info", description = "培训学习记录")
@Entity
@Data
@Table(name = "traininglearning_info")

public class HnTraininglearningInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "开始时间")
    private String start_time;

    @ApiModelProperty(value = "结束时间")
    private String end_time;

    @ApiModelProperty(value = "培训单位")
    private String trainingunit;

    @ApiModelProperty(value = " 学习内容")
    private String learning_content;

    @ApiModelProperty(value = "学习时长")
    private String learning_length;

    @ApiModelProperty(value = "继续教育学分")
    private String credit;

    @ApiModelProperty(value = "url")
    private String learning_path;

    @ApiModelProperty(value = "文件名")
    private String learning_name;

}
