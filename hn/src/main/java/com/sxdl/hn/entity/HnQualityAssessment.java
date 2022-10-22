package com.sxdl.hn.entity;

import com.sxdl.hn.dto.ObjDBO;
import com.sxdl.hn.dto.StartAssessmentEndDBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@ApiModel(value = "quality_assessment", description = "质量考核保存表(只保存公共抬头数据)")
@Entity
@Data
@Table(name="quality_assessment")
public class HnQualityAssessment {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "是否护理部 -1 /1")
    private Integer is_hlb;

    @ApiModelProperty(value = "考核亚目id")
    private Integer suborder_id;

    @ApiModelProperty(value = "模板id")
    private Integer template_id;

    @ApiModelProperty(value = "考核类型(用来填报表格):a 选择患者  b:选择护士 + 消毒隔离 c:选择护士+病区管理  d:选择护士 e:选择护士+急救物品 ")
    private String checktype;

    @ApiModelProperty(value = "考核科室代码")
    private String  ks_code;

    @ApiModelProperty(value = "考核时间")
    private  String time;

    @ApiModelProperty(value = "考核人员代码: 与模板中考核责任人一直是护理部考核")
    private String assessor;

    @ApiModelProperty(value = "总分值")
    private Double total_score;

    @ApiModelProperty(value = "所得分")
    private Double score_value;


    @ApiModelProperty(value = "总扣分")
    private Double deduction_value;


    @ApiModelProperty(value = "实际合格率")
    private Double pass_rate;

    @ApiModelProperty(value = "护士长code")
    private String head_nurse;


    @Transient
    @ApiModelProperty(value = "本次考核内容")
    private List<HnQualitydetails> templateDetails;


    @Transient
    @ApiModelProperty(value = "查询回显List数据")
    private List<StartAssessmentEndDBO> container;

    @Transient
    @ApiModelProperty(value = "查询回显Tabs 题头数据")
    private List<ObjDBO> objs;


    @Transient
    @ApiModelProperty(value = "本次考核存在问题项目.,前端自己组装数据")
    private List<HnAssessmentQuestions> questions;

    @Transient
    @ApiModelProperty(value = "a针对病人")
    private List<HnChecktypeA> checktypeA;

    @Transient
    @ApiModelProperty(value = "b消毒隔离")
    private HnChecktypeB checktypeB;

    @Transient
    @ApiModelProperty(value = "c病区管理")
    private HnChecktypeC checktypeC;


    @Transient
    @ApiModelProperty(value = "e急救物品")
    private HnChecktypeE checktypeE;
    @Transient
    @ApiModelProperty(value = "d针对病人")
    private List<HnChecktypeD> checktypeD;


    @Transient
    @ApiModelProperty(value = "考核人姓名")
    private String assessor_name;

    @Transient
    @ApiModelProperty(value = "考核科室名称")
    private String assessor_ksname;



}
