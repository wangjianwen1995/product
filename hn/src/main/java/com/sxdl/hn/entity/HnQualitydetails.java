package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "quality_details", description = "护理质量考核细目")
@Entity
@Data
@Table(name="quality_details")
public class HnQualitydetails implements  Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "质量考核细目名称 5000")
    private String name;

    @ApiModelProperty(value = "质量考核细目代码")
    private String code;

    @ApiModelProperty(value = "分值")
    private Double score;

    @ApiModelProperty(value = "合格分值")
    private Double qualified_score;

    @ApiModelProperty(value = "扣分说明")
    private String deduction_comment;

    @ApiModelProperty(value = "-1停用  1启用")
    private Integer state;

    @ApiModelProperty(value = "质量考核亚目id")
    private Integer suborder_id;

    @ApiModelProperty(value = "标准父id")
    private Integer pid;

    @ApiModelProperty(value = "标准父code")
    private String pcode;

    @ApiModelProperty(value = "-1目录  1内容")
    private Integer type;

    @Transient
    @ApiModelProperty(value = "子数据")
    private List<HnQualitydetails> children;


    /**********************  模板 组合数据使用   *******************/
    @Transient
    @ApiModelProperty(value = "模板id")
    private Integer template_id;

    @Transient
    @ApiModelProperty(value = "模板名称")
    private String template_name;

    @Transient
    @ApiModelProperty(value = "模板创建时间")
    private String template_create_time;

    @Transient
    @ApiModelProperty(value = "护理部指定考核人员，这里可以用|隔开多个考核人员")
    private String template_assessor;

    @Transient
    @ApiModelProperty(value = "考核的项目code 集合")
    private String template_content_code;

    @Transient
    @ApiModelProperty(value = "总分值")
    private Double template_total_score;

    @Transient
    @ApiModelProperty(value = "合格分值")
    private Double template_qualified_score;

    @Transient
    @ApiModelProperty(value = "合格率")
    private Double template_pass_rate;

    @Transient
    @ApiModelProperty(value = "考核类型(用来填报表格)：a 选择患者  b:选择护士 + 表格 c:选择护士+表格  d:选择护士  ")
    private String template_checktype;
    @Transient
    @ApiModelProperty(value = "计分方式:1 多分制  2 单分制")
    private Integer template_scoring_type;
    @Transient
    @ApiModelProperty(value = "考核备注说明")
    private String template_comment;
    @Transient
    @ApiModelProperty(value = "考核亚目id")
    private Integer template_suborder_id;
    @Transient
    @ApiModelProperty(value = "考核细目id  数组")
    private String template_details_ids;
    @Transient
    @ApiModelProperty(value = "是否启用")
    private Integer template_state;




}
