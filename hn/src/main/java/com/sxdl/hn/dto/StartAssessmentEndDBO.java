package com.sxdl.hn.dto;


import com.sxdl.hn.entity.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StartAssessmentEndDBO implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<StartAssessmentDBO> startAssessment;
    //前端第一列 融合多少行
    private List<Integer> colArrays_one;

    //前端第二列 融合多少行
    private List<Integer> colArrays_two;


    @ApiModelProperty(value = "是否护理部 -1 /1")
    private Integer is_hlb;

    @ApiModelProperty(value = "考核亚目id")
    private Integer suborder_id;

    @ApiModelProperty(value = "模板id")
    private Integer template_id;

    @ApiModelProperty(value = "考核类型(用来填报表格)：a 选择患者  b:选择护士 + 消毒隔离 c:选择护士+病区管理  d:选择护士  e: 护士+急救物品管")
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


    @ApiModelProperty(value = "a针对病人")
    private List<HnChecktypeA> checktypeA;

    @ApiModelProperty(value = "b消毒隔离")
    private HnChecktypeB checktypeB;

    @ApiModelProperty(value = "c病区管理")
    private HnChecktypeC checktypeC;

    @ApiModelProperty(value = "e急救物品管")
    private HnChecktypeE checktypeE;

    @ApiModelProperty(value = "D针对护士")
    private List<HnChecktypeD> checktypeD;

}
