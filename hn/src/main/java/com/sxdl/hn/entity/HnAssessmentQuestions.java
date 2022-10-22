package com.sxdl.hn.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "assessment_questions", description = "护理质量问题项")
@Entity
@Data
@Table(name="assessment_questions")
public class HnAssessmentQuestions {
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "是否护理部考核")
    private Integer is_hlb;

    @ApiModelProperty(value = "考核时间")
    private String assessment_time;

    @ApiModelProperty(value = "亚目id")
    private Integer suborder_id;

    @ApiModelProperty(value = "模板id")
    private Integer template_id;

    @ApiModelProperty(value = "考核亚目名称")
    private String suborder_name;

    @ApiModelProperty(value = "考核细目名称")
    private String details;

    @ApiModelProperty(value = "考核科室")
    private String kscode;

    @ApiModelProperty(value = "病历号")
    private String blh;

    @ApiModelProperty(value = "明细id")
    private Integer detalis_id;

    @ApiModelProperty(value = "扣分值")
    private Double point_deduction;

    @ApiModelProperty(value = "责任护士")
    private String  person_liable;

    @ApiModelProperty(value = "责任护士姓名")
    private String person_liable_name;

    @ApiModelProperty(value = "问题批注")
    private String  problem;

    @ApiModelProperty(value = "考核id")
    private Integer assessment_id;

    @ApiModelProperty(value = "检查人代码")
    private String assessor;

    @ApiModelProperty(value = "检查人名称")
    private String assessor_name;

    @ApiModelProperty(value = "护士长代码")
    private String head_nurse;



    /*  下面反馈后 才会有数据*/

    @ApiModelProperty(value = "反馈id")
    private Integer assessment_feedback_id;




    @ApiModelProperty(value = "责任人改进措施")
    private String measures;

}
