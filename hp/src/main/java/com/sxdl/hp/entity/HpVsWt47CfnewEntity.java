package com.sxdl.hp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VsWT47_CFNew")
@ApiModel(value = "VsWT47_CFNew", description = "病案新生儿信息表")
public class HpVsWt47CfnewEntity {

    @Column(name="ChYear")
    @JsonProperty("ChYear")
    @ApiModelProperty(value = "病案年度")
    private String ChYear;

    @Column(name="WT4701")
    @JsonProperty("WT4701")
    @ApiModelProperty(value = "病案号")
    private String WT4701;

    @Column(name="CF_BH")
    @JsonProperty("CF_BH")
    @ApiModelProperty(value = "孕妇健康档案号")
    private String CF_BH;

    @Column(name="CF_JDSJ")
    @JsonProperty("CF_JDSJ")
    @ApiModelProperty(value = "建档时间")
    private Date CF_JDSJ;

    @Column(name="CF_YC")
    @JsonProperty("CF_YC")
    @ApiModelProperty(value = "孕次")
    private Integer CF_YC;

    @Column(name="CF_CC")
    @JsonProperty("CF_CC")
    @ApiModelProperty(value = "产次")
    private Integer CF_CC;

    @Column(name="CF_YFZC")
    @JsonProperty("CF_YFZC")
    @ApiModelProperty(value = "孕周")
    private Integer CF_YFZC;

    @Column(name="CF_GWYS")
    @JsonProperty("CF_GWYS")
    @ApiModelProperty(value = "是否高危妊娠")
    private String CF_GWYS;

    @Column(name="CF_FMDD")
    @JsonProperty("CF_FMDD")
    @ApiModelProperty(value = "分娩地点")
    private String CF_FMDD;

    @Column(name="CF_HYPL")
    @JsonProperty("CF_HYPL")
    @ApiModelProperty(value = "产妇会阴破裂度（Ⅰ度、Ⅱ度、Ⅲ度）")
    private String CF_HYPL;

    @Column(name="CF_JCR")
    @JsonProperty("CF_JCR")
    @ApiModelProperty(value = "接产人")
    private String CF_JCR;

    @Column(name="CF_TB")
    @JsonProperty("CF_TB")
    @ApiModelProperty(value = "胎别")
    private String CF_TB;

    @Column(name="CF_FMRQ")
    @JsonProperty("CF_FMRQ")
    @ApiModelProperty(value = "分娩日期")
    private Date CF_FMRQ;

    @Column(name="FM_XB")
    @JsonProperty("FM_XB")
    @ApiModelProperty(value = "胎儿性别")
    private Integer FM_XB;

    @Column(name="FM_XB2")
    @JsonProperty("FM_XB2")
    @ApiModelProperty(value = "胎儿性别2")
    private Integer FM_XB2;

    @Column(name="FM_XB3")
    @JsonProperty("FM_XB3")
    @ApiModelProperty(value = "胎儿性别3")
    private Integer FM_XB3;

    @Column(name="FM_XB4")
    @JsonProperty("FM_XB4")
    @ApiModelProperty(value = "胎儿性别4")
    private Integer FM_XB4;

    @Column(name="FM_XB5")
    @JsonProperty("FM_XB5")
    @ApiModelProperty(value = "胎儿性别5")
    private Integer FM_XB5;

    @Column(name="FM_Weight")
    @JsonProperty("FM_Weight")
    @ApiModelProperty(value = "胎儿体重")
    private Integer FM_Weight;

    @Column(name="FM_Weight2")
    @JsonProperty("FM_Weight2")
    @ApiModelProperty(value = "胎儿体重2")
    private Integer FM_Weight2;

    @Column(name="FM_Weight3")
    @JsonProperty("FM_Weight3")
    @ApiModelProperty(value = "胎儿体重3")
    private Integer FM_Weight3;

    @Column(name="FM_Weight4")
    @JsonProperty("FM_Weight4")
    @ApiModelProperty(value = "胎儿体重4")
    private Integer FM_Weight4;

    @Column(name="FM_Weight5")
    @JsonProperty("FM_Weight5")
    @ApiModelProperty(value = "胎儿体重5")
    private Integer FM_Weight5;

    @Column(name="FM_RSJJ")
    @JsonProperty("FM_RSJJ")
    @ApiModelProperty(value = "妊娠结局")
    private String FM_RSJJ;

    @Column(name="FM_RSJJ2")
    @JsonProperty("FM_RSJJ2")
    @ApiModelProperty(value = "妊娠结局2")
    private String FM_RSJJ2;

    @Column(name="FM_RSJJ3")
    @JsonProperty("FM_RSJJ3")
    @ApiModelProperty(value = "妊娠结局3")
    private String FM_RSJJ3;

    @Column(name="FM_RSJJ4")
    @JsonProperty("FM_RSJJ4")
    @ApiModelProperty(value = "妊娠结局4")
    private String FM_RSJJ4;

    @Column(name="FM_RSJJ5")
    @JsonProperty("FM_RSJJ5")
    @ApiModelProperty(value = "妊娠结局5")
    private String FM_RSJJ5;

    @Column(name="FM_PF")
    @JsonProperty("FM_PF")
    @ApiModelProperty(value = "Apgar评分1")
    private String FM_PF;

    @Column(name="FM_PF2")
    @JsonProperty("FM_PF2")
    @ApiModelProperty(value = "Apgar评分2")
    private String FM_PF2;

    @Column(name="FM_PF3")
    @JsonProperty("FM_PF3")
    @ApiModelProperty(value = "Apgar评分3")
    private String FM_PF3;

    @Column(name="FM_PF4")
    @JsonProperty("FM_PF4")
    @ApiModelProperty(value = "Apgar评分4")
    private String FM_PF4;

    @Column(name="FM_PF5")
    @JsonProperty("FM_PF5")
    @ApiModelProperty(value = "Apgar评分5")
    private String FM_PF5;

    @Column(name="FM_CSRQ")
    @JsonProperty("FM_CSRQ")
    @ApiModelProperty(value = "胎儿出生日期")
    private Date FM_CSRQ;


    @Column(name="FM_YYGR")
    @JsonProperty("FM_YYGR")
    @ApiModelProperty(value = "是否医院感染")
    private String FM_YYGR;

    @Column(name="FM_SWRQ")
    @JsonProperty("FM_SWRQ")
    @ApiModelProperty(value = "死亡日期")
    private Date FM_SWRQ;

    @Column(name="FM_SWYY")
    @JsonProperty("FM_SWYY")
    @ApiModelProperty(value = "死亡原因")
    private String FM_SWYY;

    @Column(name="FM_CYQK")
    @JsonProperty("FM_CYQK")
    @ApiModelProperty(value = "出院情况")
    private String FM_CYQK;

    @Column(name="CYRQ")
    @JsonProperty("CYRQ")
    @ApiModelProperty(value = "入院日期")
    private Date CYRQ;

    @Column(name="FM_CSYE")
    @JsonProperty("FM_CSYE")
    @ApiModelProperty(value = "发生产伤的新生儿")
    private String FM_CSYE;

    @Column(name="FM_YDCS")
    @JsonProperty("FM_YDCS")
    @ApiModelProperty(value = "发生产伤的阴道分娩")
    private String FM_YDCS;

    @Column(name="FM_MDSC")
    @JsonProperty("FM_MDSC")
    @ApiModelProperty(value = "妊娠梅毒筛查")
    private Integer FM_MDSC;

    @Column(name="FM_CHCX")
    @JsonProperty("FM_CHCX")
    @ApiModelProperty(value = "产后出血")
    private Integer FM_CHCX;

    @Column(name="FM_JBSC")
    @JsonProperty("FM_JBSC")
    @ApiModelProperty(value = "新生儿疾病筛查")
    private Integer FM_JBSC;

    @Column(name="CF_YFTS")
    @JsonProperty("CF_YFTS")
    @ApiModelProperty(value = "孕妇孕满天数")
    private Integer CF_YFTS;

    @Column(name="CF_ZFXM")
    @JsonProperty("CF_ZFXM")
    @ApiModelProperty(value = "丈夫姓名")
    private String CF_ZFXM;

    @Column(name="CF_ZFSFZ")
    @JsonProperty("CF_ZFSFZ")
    @ApiModelProperty(value = "丈夫身份证")
    private String CF_ZFSFZ;

    @Column(name="CF_FMFS")
    @JsonProperty("CF_FMFS")
    @ApiModelProperty(value = "分娩方式")
    private String CF_FMFS;


    @Id
    @JsonProperty("ID")
    @Column(name="ID")
    @ApiModelProperty(value = "ID")
    @KeySql(genId = UUIdGenId.class)
    private String ID;

    @Column(name="A_ID")
    @JsonProperty("A_ID")
    @ApiModelProperty(value = "A_ID")
    private String A_ID;

    @Column(name="CYSJ")
    @ApiModelProperty(value = "出院日期" )
    @JsonProperty("CYSJ")
    private Date CYSJ;

}
