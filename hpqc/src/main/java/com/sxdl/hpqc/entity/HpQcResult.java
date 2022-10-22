package com.sxdl.hpqc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_qm_result", description = "质控结果表")
@Entity
@Data
@Table(name="hp_qm_result")
public class HpQcResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "A_id 也是A表的Id ")
    private String bah;

    @ApiModelProperty(value = "分类名称")
    private String classify;

    @ApiModelProperty(value = "分类代码")
    private Integer classify_id;

    @ApiModelProperty(value = "总表字段")
    private String fields;

    @ApiModelProperty(value = "返回信息")
    private String message;


    @ApiModelProperty(value = "排序号")
    private Integer ordernum;

    @ApiModelProperty(value = "正式表锚点字段(ABCEP..表的字段)")
    private String fields_anchor;

    @ApiModelProperty(value = "是否强制1是 0否 ")
    private Integer can_forced;

    @ApiModelProperty(value = "出院时间 总表字段-->CYSJ")
    private String time;

    @Column(name = "cykb")
    @ApiModelProperty(value = "出院科室")
    private String cykb;
    @Column(name = "cykb_name")
    @ApiModelProperty(value = "出院科室名称")
    private String cykb_name;
    @Column(name = "is_link")
    @ApiModelProperty(value = "是否环节质控 1：环节 2 终末")
    private int is_link;
    @Column(name = "iswest")
    @ApiModelProperty(value = "是否中西医 1：中医 2：西医")
    private int iswest;

    @Column(name = "is_first")
    @ApiModelProperty(value = "是否首次质控 1：是 2：不是")
    private int is_first;

    @Column(name = "platform_on")
    @ApiModelProperty(value = "规则适用哪些平台")
    private String platform_on;

    @Column(name = "qc_time")
    @ApiModelProperty(value = "质控时间")
    private String qc_time;

    @Column(name = "home_type")
    @ApiModelProperty(value = "首页信息类型") // 1：基本2：诊疗3：手术4：费用5：其他
    private Integer home_type;

   /* @Transient
    @ApiModelProperty(value = " ")
    private String web_name;
*/




}
