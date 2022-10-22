package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@ApiModel(value = "assessment_feedback", description = "考核反馈（反馈信息补录数据）")
@Entity
@Data
@Table(name="assessment_feedback")
public class HnAssessmentFeedback {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "考核日期范围")
    private String assessment_time;

    @ApiModelProperty(value = "考核科室")
    private String assessment_kscode;


    @ApiModelProperty(value = "检查人代码 :没这无效,因为所有考核都会整理过来")
    private String assessor;


    @ApiModelProperty(value = "反馈时间")
    private String feedback_time;


    @ApiModelProperty(value = "是否护理部考核")
    private Integer is_hlb;


    @ApiModelProperty(value = "护士长代码")
    private String head_nurse;


    @ApiModelProperty(value = "原因分析")
    private String reason;


    @ApiModelProperty(value = "改进措施")
    private String measures;


    @ApiModelProperty(value = "科室追踪评价")
    private String assessment_ks;

    @ApiModelProperty(value = "护士长签字时间")
    private String head_nurse_time;

    @ApiModelProperty(value = "护理部追踪评价")
    private String assessment_hlb;

    @ApiModelProperty(value = "护理部签字代码")
    private String hlbcode;

    @ApiModelProperty(value = "护理部签字时间")
    private String hlb_time;

    @Transient
    @ApiModelProperty(value = "护理部签字代码")
    private String hlbcode_namm;

    @Transient
    @ApiModelProperty(value = "护士长名称")
    private String head_nurse_name;

    @Transient
    @ApiModelProperty(value = "考核科室")
    private String assessment_kscode_name;

    @Transient
    @ApiModelProperty(value = "考核问题")
    private List<HnAssessmentQuestions> questions;


}
