package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@ApiModel(value = "quality_template", description = "质量考核模板（核心）")
@Entity
@Data
@Table(name="quality_template")
public class HnQualityTemplate {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "模板名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private String create_time;

    @ApiModelProperty(value = "护理部指定考核人员，这里可以用|隔开多个考核人员")
    private String assessor;

    @ApiModelProperty(value = "考核的项目code 集合")
    private String content_code;

    @ApiModelProperty(value = "总分值,前端计算")
    private Double total_score;

    @ApiModelProperty(value = "合格分值")
    private Double qualified_score;

    @ApiModelProperty(value = "合格率")
    private Double pass_rate;

    @ApiModelProperty(value = "考核类型(用来填报表格)：a 选择患者  b:选择护士 + 消毒隔离 c:选择护士+病区管理  d:选择护士  e: 护士+急救物品管  ")
    private String checktype;

    @ApiModelProperty(value = "计分方式:1 多分制(没项有一个分值)  2 单分制 (公用一个分值)")
    private Integer scoring_type;

    @ApiModelProperty(value = "考核备注说明")
    private String comment;

    @ApiModelProperty(value = "考核亚目id")
    private Integer suborder_id;

    @ApiModelProperty(value = "考核细目id  数组")
    private String details_ids;


    @ApiModelProperty(value = "考核细目id  数组(用来前端展示,由于tree的限制只能给是标准的id 不要目录的id)")
    private String show_ids;


    @ApiModelProperty(value = "是否启用,默认-1")
    private Integer state;


    @Transient
    @ApiModelProperty(value = "单个 考核细目id")
    private String suborder_name;

    /**********************  模板 组合数据使用
    @Transient
    @ApiModelProperty(value = "单个 考核细目id")
    private Integer single_details_id;

    @Transient
    @ApiModelProperty(value = "单个 质量考核细目代码")
    private String single_details_code;


    @Transient
    @ApiModelProperty(value = "单个 分值")
    private Double single_score;


    @Transient
    @ApiModelProperty(value = "单个 合格分值")
    private Double single_qualified_score;


    @Transient
    @ApiModelProperty(value = "单个 合格分值")
    private Double single_deduction_comment;

    @Transient
    @ApiModelProperty(value = "单个 标准父code")
    private Double single_pcode;

    @Transient
    @ApiModelProperty(value = "单个 -1目录  1内容")
    private Double single_type;

     *******************/



}
