package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "assessment_feedback_questions", description = "反馈问题（作废不用）")
@Entity
@Data
@Table(name="assessment_feedback_questions")
@Deprecated
public class HnAssessmentFeedbackQuestions {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "反馈id")
    private Integer assessment_feedback_id;

    @ApiModelProperty(value = "责任护士代码")
    private String responsible_nurse;


    @ApiModelProperty(value = "考核时间")
    private String assessment_time;


    @ApiModelProperty(value = "考核亚目id")
    private Integer suborder_id;


    @ApiModelProperty(value = "考核亚目名称")
    private String suborder_name;


    @ApiModelProperty(value = "问题内容")
    private String problem;


    @ApiModelProperty(value = "扣分值")
    private Double point_deduction;


    @ApiModelProperty(value = "考核细目code")
    private String details_code;

    @ApiModelProperty(value = "考核细目名称")
    private String details;

    @ApiModelProperty(value = "改进措施")
    private String measures;

    @ApiModelProperty(value = "是否护理部")
    private Integer is_hlb;



}
