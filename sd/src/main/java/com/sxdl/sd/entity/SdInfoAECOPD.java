package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：J44.0，J44.1 的出院患者。
*/
@ApiModel(value = "20信息")
@Entity
@Table(name = "sd_info_AECOPD")
public class SdInfoAECOPD implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    public void setId(final Integer id) {this.id = id;}
    public Integer getId() {return this.id;}
    @Column(name = "CM_0_1_1_1")
    @JsonProperty("CM-0-1-1-1")
    private String CM_0_1_1_1; // 质控医师
    public String getCM_0_1_1_1() {  return this.CM_0_1_1_1;}
    @JsonProperty("CM-0-1-1-1")
    public void setCM_0_1_1_1(final String CM_0_1_1_1) { this.CM_0_1_1_1=CM_0_1_1_1;}
    @Column(name = "CM_0_1_1_2")
    @JsonProperty("CM-0-1-1-2")
    private String CM_0_1_1_2; // 质控护士
    public String getCM_0_1_1_2() {  return this.CM_0_1_1_2;}
    @JsonProperty("CM-0-1-1-2")
    public void setCM_0_1_1_2(final String CM_0_1_1_2) { this.CM_0_1_1_2=CM_0_1_1_2;}
    @Column(name = "CM_0_1_1_3")
    @JsonProperty("CM-0-1-1-3")
    private String CM_0_1_1_3; // 主治医师
    public String getCM_0_1_1_3() {  return this.CM_0_1_1_3;}
    @JsonProperty("CM-0-1-1-3")
    public void setCM_0_1_1_3(final String CM_0_1_1_3) { this.CM_0_1_1_3=CM_0_1_1_3;}
    @Column(name = "CM_0_1_1_4")
    @JsonProperty("CM-0-1-1-4")
    private String CM_0_1_1_4; // 责任护士
    public String getCM_0_1_1_4() {  return this.CM_0_1_1_4;}
    @JsonProperty("CM-0-1-1-4")
    public void setCM_0_1_1_4(final String CM_0_1_1_4) { this.CM_0_1_1_4=CM_0_1_1_4;}
    @Column(name = "CM_0_1_1_5")
    @JsonProperty("CM-0-1-1-5")
    private String CM_0_1_1_5; // 上报科室
    public String getCM_0_1_1_5() {  return this.CM_0_1_1_5;}
    @JsonProperty("CM-0-1-1-5")
    public void setCM_0_1_1_5(final String CM_0_1_1_5) { this.CM_0_1_1_5=CM_0_1_1_5;}
    @Column(name = "caseId")
    @JsonProperty("caseId")
    private String caseId; // 患者病案号
    public String getCaseId() {  return this.caseId;}
    @JsonProperty("caseId")
    public void setCaseId(final String caseId) { this.caseId=caseId;}
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard; // 患者身份证号
    public String getIDCard() {  return this.IDCard;}
    @JsonProperty("IDCard")
    public void setIDCard(final String IDCard) { this.IDCard=IDCard;}
    @Column(name = "CM_0_1_3_1")
    @JsonProperty("CM-0-1-3-1")
    private String CM_0_1_3_1; // 主要诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getCM_0_1_4_1() {  return this.CM_0_1_4_1;}
    @JsonProperty("CM-0-1-4-1")
    public void setCM_0_1_4_1(final String CM_0_1_4_1) { this.CM_0_1_4_1=CM_0_1_4_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否出院后31天内重复住院
    public String getCM_0_1_5() {  return this.CM_0_1_5;}
    @JsonProperty("CM-0-1-5")
    public void setCM_0_1_5(final String CM_0_1_5) { this.CM_0_1_5=CM_0_1_5;}
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM-0-2-1-1")
    private String CM_0_2_1_1; // 出生日期
    public String getCM_0_2_1_1() {  return this.CM_0_2_1_1;}
    @JsonProperty("CM-0-2-1-1")
    public void setCM_0_2_1_1(final String CM_0_2_1_1) { this.CM_0_2_1_1=CM_0_2_1_1;}
    @Column(name = "CM_0_2_1_2")
    @JsonProperty("CM-0-2-1-2")
    private String CM_0_2_1_2; // 患者性别
    public String getCM_0_2_1_2() {  return this.CM_0_2_1_2;}
    @JsonProperty("CM-0-2-1-2")
    public void setCM_0_2_1_2(final String CM_0_2_1_2) { this.CM_0_2_1_2=CM_0_2_1_2;}
    @Column(name = "CM_0_2_1_3")
    @JsonProperty("CM-0-2-1-3")
    private String CM_0_2_1_3; // 患者体重（kg）
    public String getCM_0_2_1_3() {  return this.CM_0_2_1_3;}
    @JsonProperty("CM-0-2-1-3")
    public void setCM_0_2_1_3(final String CM_0_2_1_3) { this.CM_0_2_1_3=CM_0_2_1_3;}
    @Column(name = "CM_0_2_1_5")
    @JsonProperty("CM-0-2-1-5")
    private String CM_0_2_1_5; // 患者身高（cm）
    public String getCM_0_2_1_5() {  return this.CM_0_2_1_5;}
    @JsonProperty("CM-0-2-1-5")
    public void setCM_0_2_1_5(final String CM_0_2_1_5) { this.CM_0_2_1_5=CM_0_2_1_5;}
    @Column(name = "CM_0_2_1_3_1")
    @JsonProperty("CM-0-2-1-3-1")
    private String CM_0_2_1_3_1; // 身高转换
    public String getCM_0_2_1_3_1() {  return this.CM_0_2_1_3_1;}
    @JsonProperty("CM-0-2-1-3-1")
    public void setCM_0_2_1_3_1(final String CM_0_2_1_3_1) { this.CM_0_2_1_3_1=CM_0_2_1_3_1;}
    @Column(name = "CM_0_2_1_4")
    @JsonProperty("CM-0-2-1-4")
    private String CM_0_2_1_4; // 体重指数(Kg/m2)
    public String getCM_0_2_1_4() {  return this.CM_0_2_1_4;}
    @JsonProperty("CM-0-2-1-4")
    public void setCM_0_2_1_4(final String CM_0_2_1_4) { this.CM_0_2_1_4=CM_0_2_1_4;}
    @Column(name = "CM_0_2_4_1")
    @JsonProperty("CM-0-2-4-1")
    private String CM_0_2_4_1; // 入院日期时间
    public String getCM_0_2_4_1() {  return this.CM_0_2_4_1;}
    @JsonProperty("CM-0-2-4-1")
    public void setCM_0_2_4_1(final String CM_0_2_4_1) { this.CM_0_2_4_1=CM_0_2_4_1;}
    @Column(name = "age")
    @JsonProperty("age")
    private String age; // 年龄
    public String getage() {  return this.age;}
    @JsonProperty("age")
    public void setage(final String age) { this.age=age;}
    @Column(name = "CM_0_2_4_2")
    @JsonProperty("CM-0-2-4-2")
    private String CM_0_2_4_2; // 出院日期时间
    public String getCM_0_2_4_2() {  return this.CM_0_2_4_2;}
    @JsonProperty("CM-0-2-4-2")
    public void setCM_0_2_4_2(final String CM_0_2_4_2) { this.CM_0_2_4_2=CM_0_2_4_2;}
    @Column(name = "CM_0_2_5_1")
    @JsonProperty("CM-0-2-5-1")
    private String CM_0_2_5_1; // 入住ICU/RICU日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU/RICU日期时间
    public String getCM_0_2_5_2() {  return this.CM_0_2_5_2;}
    @JsonProperty("CM-0-2-5-2")
    public void setCM_0_2_5_2(final String CM_0_2_5_2) { this.CM_0_2_5_2=CM_0_2_5_2;}
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    public String getCM_0_3_1() {  return this.CM_0_3_1;}
    @JsonProperty("CM-0-3-1")
    public void setCM_0_3_1(final String CM_0_3_1) { this.CM_0_3_1=CM_0_3_1;}
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    public String getCM_0_3_2() {  return this.CM_0_3_2;}
    @JsonProperty("CM-0-3-2")
    public void setCM_0_3_2(final String CM_0_3_2) { this.CM_0_3_2=CM_0_3_2;}
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    public String getCM_0_3_3() {  return this.CM_0_3_3;}
    @JsonProperty("CM-0-3-3")
    public void setCM_0_3_3(final String CM_0_3_3) { this.CM_0_3_3=CM_0_3_3;}
    @Column(name = "AECOPD_1_1_1")
    @JsonProperty("AECOPD-1-1-1")
    private String AECOPD_1_1_1; // 入院后是否实施首次病情严重程度评估
    public String getAECOPD_1_1_1() {  return this.AECOPD_1_1_1;}
    @JsonProperty("AECOPD-1-1-1")
    public void setAECOPD_1_1_1(final String AECOPD_1_1_1) { this.AECOPD_1_1_1=AECOPD_1_1_1;}
    @Column(name = "AECOPD_1_1_2")
    @JsonProperty("AECOPD-1-1-2")
    private String AECOPD_1_1_2; // 评价结果
    public String getAECOPD_1_1_2() {  return this.AECOPD_1_1_2;}
    @JsonProperty("AECOPD-1-1-2")
    public void setAECOPD_1_1_2(final String AECOPD_1_1_2) { this.AECOPD_1_1_2=AECOPD_1_1_2;}
    @Column(name = "AECOPD_1_2_1")
    @JsonProperty("AECOPD-1-2-1")
    private String AECOPD_1_2_1; // 入院后是否实施首次氧合评估（首次）
    public String getAECOPD_1_2_1() {  return this.AECOPD_1_2_1;}
    @JsonProperty("AECOPD-1-2-1")
    public void setAECOPD_1_2_1(final String AECOPD_1_2_1) { this.AECOPD_1_2_1=AECOPD_1_2_1;}
    @Column(name = "AECOPD_1_2_2")
    @JsonProperty("AECOPD-1-2-2")
    private String AECOPD_1_2_2; // 实施首次氧合评估时是否吸氧
    public String getAECOPD_1_2_2() {  return this.AECOPD_1_2_2;}
    @JsonProperty("AECOPD-1-2-2")
    public void setAECOPD_1_2_2(final String AECOPD_1_2_2) { this.AECOPD_1_2_2=AECOPD_1_2_2;}
    @Column(name = "AECOPD_1_2_3")
    @JsonProperty("AECOPD-1-2-3")
    private String AECOPD_1_2_3; // 动脉血气分析/指氧仪检查
    public String getAECOPD_1_2_3() {  return this.AECOPD_1_2_3;}
    @JsonProperty("AECOPD-1-2-3")
    public void setAECOPD_1_2_3(final String AECOPD_1_2_3) { this.AECOPD_1_2_3=AECOPD_1_2_3;}
    @Column(name = "AECOPD_1_2_3_3")
    @JsonProperty("AECOPD-1-2-3-3")
    private String AECOPD_1_2_3_3; // 动脉血气分析（mmHg）
    public String getAECOPD_1_2_3_3() {  return this.AECOPD_1_2_3_3;}
    @JsonProperty("AECOPD-1-2-3-3")
    public void setAECOPD_1_2_3_3(final String AECOPD_1_2_3_3) { this.AECOPD_1_2_3_3=AECOPD_1_2_3_3;}
    @Column(name = "AECOPD_1_2_3_4")
    @JsonProperty("AECOPD-1-2-3-4")
    private String AECOPD_1_2_3_4; // 指氧仪检查（%）
    public String getAECOPD_1_2_3_4() {  return this.AECOPD_1_2_3_4;}
    @JsonProperty("AECOPD-1-2-3-4")
    public void setAECOPD_1_2_3_4(final String AECOPD_1_2_3_4) { this.AECOPD_1_2_3_4=AECOPD_1_2_3_4;}
    @Column(name = "AECOPD_1_2_4")
    @JsonProperty("AECOPD-1-2-4")
    private String AECOPD_1_2_4; // 入院后首次氧合评估结论的判定
    public String getAECOPD_1_2_4() {  return this.AECOPD_1_2_4;}
    @JsonProperty("AECOPD-1-2-4")
    public void setAECOPD_1_2_4(final String AECOPD_1_2_4) { this.AECOPD_1_2_4=AECOPD_1_2_4;}
    @Column(name = "AECOPD_1_3_1")
    @JsonProperty("AECOPD-1-3-1")
    private String AECOPD_1_3_1; // 入院后是否实施首次胸部影像学检查
    public String getAECOPD_1_3_1() {  return this.AECOPD_1_3_1;}
    @JsonProperty("AECOPD-1-3-1")
    public void setAECOPD_1_3_1(final String AECOPD_1_3_1) { this.AECOPD_1_3_1=AECOPD_1_3_1;}
    @Column(name = "AECOPD_1_3_2")
    @JsonProperty("AECOPD-1-3-2")
    private String AECOPD_1_3_2; // 首次胸部影像学检查模式
    public String getAECOPD_1_3_2() {  return this.AECOPD_1_3_2;}
    @JsonProperty("AECOPD-1-3-2")
    public void setAECOPD_1_3_2(final String AECOPD_1_3_2) { this.AECOPD_1_3_2=AECOPD_1_3_2;}
    @Column(name = "AECOPD_1_3_3")
    @JsonProperty("AECOPD-1-3-3")
    private String AECOPD_1_3_3; // 胸部影像学检查评估
    public String getAECOPD_1_3_3() {  return this.AECOPD_1_3_3;}
    @JsonProperty("AECOPD-1-3-3")
    public void setAECOPD_1_3_3(final String AECOPD_1_3_3) { this.AECOPD_1_3_3=AECOPD_1_3_3;}
    @Column(name = "AECOPD_1_3_3_1")
    @JsonProperty("AECOPD-1-3-3-1")
    private String AECOPD_1_3_3_1; // 其它胸部影像学检查评估
    public String getAECOPD_1_3_3_1() {  return this.AECOPD_1_3_3_1;}
    @JsonProperty("AECOPD-1-3-3-1")
    public void setAECOPD_1_3_3_1(final String AECOPD_1_3_3_1) { this.AECOPD_1_3_3_1=AECOPD_1_3_3_1;}
    @Column(name = "AECOPD_1_4_1")
    @JsonProperty("AECOPD-1-4-1")
    private String AECOPD_1_4_1; // 入院后是否实施首次心电图检查评估
    public String getAECOPD_1_4_1() {  return this.AECOPD_1_4_1;}
    @JsonProperty("AECOPD-1-4-1")
    public void setAECOPD_1_4_1(final String AECOPD_1_4_1) { this.AECOPD_1_4_1=AECOPD_1_4_1;}
    @Column(name = "AECOPD_1_4_2")
    @JsonProperty("AECOPD-1-4-2")
    private String AECOPD_1_4_2; // 心电图检查评估
    public String getAECOPD_1_4_2() {  return this.AECOPD_1_4_2;}
    @JsonProperty("AECOPD-1-4-2")
    public void setAECOPD_1_4_2(final String AECOPD_1_4_2) { this.AECOPD_1_4_2=AECOPD_1_4_2;}
    @Column(name = "AECOPD_1_4_2_1")
    @JsonProperty("AECOPD-1-4-2-1")
    private String AECOPD_1_4_2_1; // 其它心电图检查评估
    public String getAECOPD_1_4_2_1() {  return this.AECOPD_1_4_2_1;}
    @JsonProperty("AECOPD-1-4-2-1")
    public void setAECOPD_1_4_2_1(final String AECOPD_1_4_2_1) { this.AECOPD_1_4_2_1=AECOPD_1_4_2_1;}
    @Column(name = "AECOPD_1_5_1")
    @JsonProperty("AECOPD-1-5-1")
    private String AECOPD_1_5_1; // 入院后是否实施首次实验室检查评估
    public String getAECOPD_1_5_1() {  return this.AECOPD_1_5_1;}
    @JsonProperty("AECOPD-1-5-1")
    public void setAECOPD_1_5_1(final String AECOPD_1_5_1) { this.AECOPD_1_5_1=AECOPD_1_5_1;}
    @Column(name = "AECOPD_1_5_2")
    @JsonProperty("AECOPD-1-5-2")
    private String AECOPD_1_5_2; // 实验室检查评估
    public String getAECOPD_1_5_2() {  return this.AECOPD_1_5_2;}
    @JsonProperty("AECOPD-1-5-2")
    public void setAECOPD_1_5_2(final String AECOPD_1_5_2) { this.AECOPD_1_5_2=AECOPD_1_5_2;}
    @Column(name = "AECOPD_1_5_2_1")
    @JsonProperty("AECOPD-1-5-2-1")
    private String AECOPD_1_5_2_1; // 其它实验室检查评估
    public String getAECOPD_1_5_2_1() {  return this.AECOPD_1_5_2_1;}
    @JsonProperty("AECOPD-1-5-2-1")
    public void setAECOPD_1_5_2_1(final String AECOPD_1_5_2_1) { this.AECOPD_1_5_2_1=AECOPD_1_5_2_1;}
    @Column(name = "AECOPD_2_1_1")
    @JsonProperty("AECOPD-2-1-1")
    private String AECOPD_2_1_1; // 是否入住ICU
    public String getAECOPD_2_1_1() {  return this.AECOPD_2_1_1;}
    @JsonProperty("AECOPD-2-1-1")
    public void setAECOPD_2_1_1(final String AECOPD_2_1_1) { this.AECOPD_2_1_1=AECOPD_2_1_1;}
    @Column(name = "AECOPD_2_1_2")
    @JsonProperty("AECOPD-2-1-2")
    private String AECOPD_2_1_2; // 收住ICU符合指征的选择
    public String getAECOPD_2_1_2() {  return this.AECOPD_2_1_2;}
    @JsonProperty("AECOPD-2-1-2")
    public void setAECOPD_2_1_2(final String AECOPD_2_1_2) { this.AECOPD_2_1_2=AECOPD_2_1_2;}
    @Column(name = "AECOPD_2_1_3")
    @JsonProperty("AECOPD-2-1-3")
    private String AECOPD_2_1_3; // 入住ICU时机
    public String getAECOPD_2_1_3() {  return this.AECOPD_2_1_3;}
    @JsonProperty("AECOPD-2-1-3")
    public void setAECOPD_2_1_3(final String AECOPD_2_1_3) { this.AECOPD_2_1_3=AECOPD_2_1_3;}
    @Column(name = "AECOPD_2_2_1")
    @JsonProperty("AECOPD-2-2-1")
    private String AECOPD_2_2_1; // 选择AECOPD治疗的分级
    public String getAECOPD_2_2_1() {  return this.AECOPD_2_2_1;}
    @JsonProperty("AECOPD-2-2-1")
    public void setAECOPD_2_2_1(final String AECOPD_2_2_1) { this.AECOPD_2_2_1=AECOPD_2_2_1;}
    @Column(name = "AECOPD_3_1_1")
    @JsonProperty("AECOPD-3-1-1")
    private String AECOPD_3_1_1; // 氧疗方法
    public String getAECOPD_3_1_1() {  return this.AECOPD_3_1_1;}
    @JsonProperty("AECOPD-3-1-1")
    public void setAECOPD_3_1_1(final String AECOPD_3_1_1) { this.AECOPD_3_1_1=AECOPD_3_1_1;}
    @Column(name = "AECOPD_3_2_1")
    @JsonProperty("AECOPD-3-2-1")
    private String AECOPD_3_2_1; // 氧疗 30min 后是否复查动脉血气
    public String getAECOPD_3_2_1() {  return this.AECOPD_3_2_1;}
    @JsonProperty("AECOPD-3-2-1")
    public void setAECOPD_3_2_1(final String AECOPD_3_2_1) { this.AECOPD_3_2_1=AECOPD_3_2_1;}
    @Column(name = "AECOPD_4_1_1")
    @JsonProperty("AECOPD-4-1-1")
    private String AECOPD_4_1_1; // 用药前病情判定分层
    public String getAECOPD_4_1_1() {  return this.AECOPD_4_1_1;}
    @JsonProperty("AECOPD-4-1-1")
    public void setAECOPD_4_1_1(final String AECOPD_4_1_1) { this.AECOPD_4_1_1=AECOPD_4_1_1;}
    @Column(name = "AECOPD_4_1_2")
    @JsonProperty("AECOPD-4-1-2")
    private String AECOPD_4_1_2; // 患者经验性起始抗菌药物选择
    public String getAECOPD_4_1_2() {  return this.AECOPD_4_1_2;}
    @JsonProperty("AECOPD-4-1-2")
    public void setAECOPD_4_1_2(final String AECOPD_4_1_2) { this.AECOPD_4_1_2=AECOPD_4_1_2;}
    @Column(name = "AECOPD_4_2_2_2")
    @JsonProperty("AECOPD-4-2-2-2")
    private String AECOPD_4_2_2_2; // 轻度及中度COPD急性加重
    public String getAECOPD_4_2_2_2() {  return this.AECOPD_4_2_2_2;}
    @JsonProperty("AECOPD-4-2-2-2")
    public void setAECOPD_4_2_2_2(final String AECOPD_4_2_2_2) { this.AECOPD_4_2_2_2=AECOPD_4_2_2_2;}
    @Column(name = "AECOPD_4_1_2_1_1")
    @JsonProperty("AECOPD-4-1-2-1-1")
    private String AECOPD_4_1_2_1_1; // 其他轻度及中度COPD急性加重抗菌药物
    public String getAECOPD_4_1_2_1_1() {  return this.AECOPD_4_1_2_1_1;}
    @JsonProperty("AECOPD-4-1-2-1-1")
    public void setAECOPD_4_1_2_1_1(final String AECOPD_4_1_2_1_1) { this.AECOPD_4_1_2_1_1=AECOPD_4_1_2_1_1;}
    @Column(name = "AECOPD_4_1_2_3")
    @JsonProperty("AECOPD-4-1-2-3")
    private String AECOPD_4_1_2_3; // 重度及极重度COPD急性加重，无铜绿假单孢菌感染危险因素患者抗菌药物选择
    public String getAECOPD_4_1_2_3() {  return this.AECOPD_4_1_2_3;}
    @JsonProperty("AECOPD-4-1-2-3")
    public void setAECOPD_4_1_2_3(final String AECOPD_4_1_2_3) { this.AECOPD_4_1_2_3=AECOPD_4_1_2_3;}
    @Column(name = "AECOPD_4_1_2_4")
    @JsonProperty("AECOPD-4-1-2-4")
    private String AECOPD_4_1_2_4; // 其他重度及极重度COPD急性加重，无铜绿假单孢菌感染危险因素患者抗菌药物
    public String getAECOPD_4_1_2_4() {  return this.AECOPD_4_1_2_4;}
    @JsonProperty("AECOPD-4-1-2-4")
    public void setAECOPD_4_1_2_4(final String AECOPD_4_1_2_4) { this.AECOPD_4_1_2_4=AECOPD_4_1_2_4;}
    @Column(name = "AECOPD_4_1_2_5")
    @JsonProperty("AECOPD-4-1-2-5")
    private String AECOPD_4_1_2_5; // 重度及极重度COPD急性加重，有铜绿假单孢菌感染危险因素患者抗菌药物选择
    public String getAECOPD_4_1_2_5() {  return this.AECOPD_4_1_2_5;}
    @JsonProperty("AECOPD-4-1-2-5")
    public void setAECOPD_4_1_2_5(final String AECOPD_4_1_2_5) { this.AECOPD_4_1_2_5=AECOPD_4_1_2_5;}
    @Column(name = "AECOPD_4_1_2_6")
    @JsonProperty("AECOPD-4-1-2-6")
    private String AECOPD_4_1_2_6; // 其他重度及极重度COPD急性加重，有铜绿假单孢菌感染危险因素患者抗菌药物
    public String getAECOPD_4_1_2_6() {  return this.AECOPD_4_1_2_6;}
    @JsonProperty("AECOPD-4-1-2-6")
    public void setAECOPD_4_1_2_6(final String AECOPD_4_1_2_6) { this.AECOPD_4_1_2_6=AECOPD_4_1_2_6;}
    @Column(name = "AECOPD_4_1_3")
    @JsonProperty("AECOPD-4-1-3")
    private String AECOPD_4_1_3; // 患者接受首剂抗菌药物治疗（注射剂输入/注射）日期时间
    public String getAECOPD_4_1_3() {  return this.AECOPD_4_1_3;}
    @JsonProperty("AECOPD-4-1-3")
    public void setAECOPD_4_1_3(final String AECOPD_4_1_3) { this.AECOPD_4_1_3=AECOPD_4_1_3;}
    @Column(name = "AECOPD_4_1_4")
    @JsonProperty("AECOPD-4-1-4")
    private String AECOPD_4_1_4; // 接受首剂抗菌药物使用时机的分层
    public String getAECOPD_4_1_4() {  return this.AECOPD_4_1_4;}
    @JsonProperty("AECOPD-4-1-4")
    public void setAECOPD_4_1_4(final String AECOPD_4_1_4) { this.AECOPD_4_1_4=AECOPD_4_1_4;}
    @Column(name = "AECOPD_4_1_5")
    @JsonProperty("AECOPD-4-1-5")
    private String AECOPD_4_1_5; // 患者停止使用抗菌药物日期
    public String getAECOPD_4_1_5() {  return this.AECOPD_4_1_5;}
    @JsonProperty("AECOPD-4-1-5")
    public void setAECOPD_4_1_5(final String AECOPD_4_1_5) { this.AECOPD_4_1_5=AECOPD_4_1_5;}
    @Column(name = "AECOPD_5_1_1")
    @JsonProperty("AECOPD-5-1-1")
    private String AECOPD_5_1_1; // 支气管舒张剂、吸入糖皮质激素使用的选择
    public String getAECOPD_5_1_1() {  return this.AECOPD_5_1_1;}
    @JsonProperty("AECOPD-5-1-1")
    public void setAECOPD_5_1_1(final String AECOPD_5_1_1) { this.AECOPD_5_1_1=AECOPD_5_1_1;}
    @Column(name = "AECOPD_5_1_1_1")
    @JsonProperty("AECOPD-5-1-1-1")
    private String AECOPD_5_1_1_1; //  其他支气管舒张剂、吸入糖皮质激素使用
    public String getAECOPD_5_1_1_1() {  return this.AECOPD_5_1_1_1;}
    @JsonProperty("AECOPD-5-1-1-1")
    public void setAECOPD_5_1_1_1(final String AECOPD_5_1_1_1) { this.AECOPD_5_1_1_1=AECOPD_5_1_1_1;}
    @Column(name = "AECOPD_5_1_2")
    @JsonProperty("AECOPD-5-1-2")
    private String AECOPD_5_1_2; // 是否实施血清茶碱浓度监测
    public String getAECOPD_5_1_2() {  return this.AECOPD_5_1_2;}
    @JsonProperty("AECOPD-5-1-2")
    public void setAECOPD_5_1_2(final String AECOPD_5_1_2) { this.AECOPD_5_1_2=AECOPD_5_1_2;}
    @Column(name = "AECOPD_5_2_1")
    @JsonProperty("AECOPD-5-2-1")
    private String AECOPD_5_2_1; // 全身使用糖皮质激素药物的选择
    public String getAECOPD_5_2_1() {  return this.AECOPD_5_2_1;}
    @JsonProperty("AECOPD-5-2-1")
    public void setAECOPD_5_2_1(final String AECOPD_5_2_1) { this.AECOPD_5_2_1=AECOPD_5_2_1;}
    @Column(name = "AECOPD_5_2_1_1")
    @JsonProperty("AECOPD-5-2-1-1")
    private String AECOPD_5_2_1_1; // 其他使用糖皮质激素药物
    public String getAECOPD_5_2_1_1() {  return this.AECOPD_5_2_1_1;}
    @JsonProperty("AECOPD-5-2-1-1")
    public void setAECOPD_5_2_1_1(final String AECOPD_5_2_1_1) { this.AECOPD_5_2_1_1=AECOPD_5_2_1_1;}
    @Column(name = "AECOPD_5_2_2")
    @JsonProperty("AECOPD-5-2-2")
    private String AECOPD_5_2_2; // 全身使用糖皮质激素药物起始日期
    public String getAECOPD_5_2_2() {  return this.AECOPD_5_2_2;}
    @JsonProperty("AECOPD-5-2-2")
    public void setAECOPD_5_2_2(final String AECOPD_5_2_2) { this.AECOPD_5_2_2=AECOPD_5_2_2;}
    @Column(name = "AECOPD_5_2_3")
    @JsonProperty("AECOPD-5-2-3")
    private String AECOPD_5_2_3; // 全身使用糖皮质激素药物终止日期
    public String getAECOPD_5_2_3() {  return this.AECOPD_5_2_3;}
    @JsonProperty("AECOPD-5-2-3")
    public void setAECOPD_5_2_3(final String AECOPD_5_2_3) { this.AECOPD_5_2_3=AECOPD_5_2_3;}
    @Column(name = "AECOPD_6_1_1")
    @JsonProperty("AECOPD-6-1-1")
    private String AECOPD_6_1_1; // 是否有心功能不全
    public String getAECOPD_6_1_1() {  return this.AECOPD_6_1_1;}
    @JsonProperty("AECOPD-6-1-1")
    public void setAECOPD_6_1_1(final String AECOPD_6_1_1) { this.AECOPD_6_1_1=AECOPD_6_1_1;}
    @Column(name = "AECOPD_6_1_2")
    @JsonProperty("AECOPD-6-1-2")
    private String AECOPD_6_1_2; // 首位处置项目
    public String getAECOPD_6_1_2() {  return this.AECOPD_6_1_2;}
    @JsonProperty("AECOPD-6-1-2")
    public void setAECOPD_6_1_2(final String AECOPD_6_1_2) { this.AECOPD_6_1_2=AECOPD_6_1_2;}
    @Column(name = "AECOPD_6_1_2_1")
    @JsonProperty("AECOPD-6-1-2-1")
    private String AECOPD_6_1_2_1; // 有心功能不全时,其他处置项目
    public String getAECOPD_6_1_2_1() {  return this.AECOPD_6_1_2_1;}
    @JsonProperty("AECOPD-6-1-2-1")
    public void setAECOPD_6_1_2_1(final String AECOPD_6_1_2_1) { this.AECOPD_6_1_2_1=AECOPD_6_1_2_1;}
    @Column(name = "AECOPD_6_2_1")
    @JsonProperty("AECOPD-6-2-1")
    private String AECOPD_6_2_1; // 是否有肺动脉高压和右心功能不全
    public String getAECOPD_6_2_1() {  return this.AECOPD_6_2_1;}
    @JsonProperty("AECOPD-6-2-1")
    public void setAECOPD_6_2_1(final String AECOPD_6_2_1) { this.AECOPD_6_2_1=AECOPD_6_2_1;}
    @Column(name = "AECOPD_6_2_2")
    @JsonProperty("AECOPD-6-2-2")
    private String AECOPD_6_2_2; // 使用血管扩张剂（无禁忌症）的选择
    public String getAECOPD_6_2_2() {  return this.AECOPD_6_2_2;}
    @JsonProperty("AECOPD-6-2-2")
    public void setAECOPD_6_2_2(final String AECOPD_6_2_2) { this.AECOPD_6_2_2=AECOPD_6_2_2;}
    @Column(name = "AECOPD_6_2_2_1")
    @JsonProperty("AECOPD-6-2-2-1")
    private String AECOPD_6_2_2_1; // 有肺动脉高压和右心功能不全时,使用其他血管扩张剂
    public String getAECOPD_6_2_2_1() {  return this.AECOPD_6_2_2_1;}
    @JsonProperty("AECOPD-6-2-2-1")
    public void setAECOPD_6_2_2_1(final String AECOPD_6_2_2_1) { this.AECOPD_6_2_2_1=AECOPD_6_2_2_1;}
    @Column(name = "AECOPD_6_3_1")
    @JsonProperty("AECOPD-6-3-1")
    private String AECOPD_6_3_1; // 是否有血栓形成高危因素
    public String getAECOPD_6_3_1() {  return this.AECOPD_6_3_1;}
    @JsonProperty("AECOPD-6-3-1")
    public void setAECOPD_6_3_1(final String AECOPD_6_3_1) { this.AECOPD_6_3_1=AECOPD_6_3_1;}
    @Column(name = "AECOPD_6_3_2")
    @JsonProperty("AECOPD-6-3-2")
    private String AECOPD_6_3_2; // 首位处置项目
    public String getAECOPD_6_3_2() {  return this.AECOPD_6_3_2;}
    @JsonProperty("AECOPD-6-3-2")
    public void setAECOPD_6_3_2(final String AECOPD_6_3_2) { this.AECOPD_6_3_2=AECOPD_6_3_2;}
    @Column(name = "AECOPD_6_3_2_1")
    @JsonProperty("AECOPD-6-3-2-1")
    private String AECOPD_6_3_2_1; // 有血栓形成高危因素时,其他处置项目
    public String getAECOPD_6_3_2_1() {  return this.AECOPD_6_3_2_1;}
    @JsonProperty("AECOPD-6-3-2-1")
    public void setAECOPD_6_3_2_1(final String AECOPD_6_3_2_1) { this.AECOPD_6_3_2_1=AECOPD_6_3_2_1;}
    @Column(name = "AECOPD_6_4_1")
    @JsonProperty("AECOPD-6-4-1")
    private String AECOPD_6_4_1; // 是否有呼吸功能不全
    public String getAECOPD_6_4_1() {  return this.AECOPD_6_4_1;}
    @JsonProperty("AECOPD-6-4-1")
    public void setAECOPD_6_4_1(final String AECOPD_6_4_1) { this.AECOPD_6_4_1=AECOPD_6_4_1;}
    @Column(name = "AECOPD_6_4_2")
    @JsonProperty("AECOPD-6-4-2")
    private String AECOPD_6_4_2; // 首位处置项目
    public String getAECOPD_6_4_2() {  return this.AECOPD_6_4_2;}
    @JsonProperty("AECOPD-6-4-2")
    public void setAECOPD_6_4_2(final String AECOPD_6_4_2) { this.AECOPD_6_4_2=AECOPD_6_4_2;}
    @Column(name = "AECOPD_6_4_2_1")
    @JsonProperty("AECOPD-6-4-2-1")
    private String AECOPD_6_4_2_1; // 有呼吸功能不全时,其他处置项目
    public String getAECOPD_6_4_2_1() {  return this.AECOPD_6_4_2_1;}
    @JsonProperty("AECOPD-6-4-2-1")
    public void setAECOPD_6_4_2_1(final String AECOPD_6_4_2_1) { this.AECOPD_6_4_2_1=AECOPD_6_4_2_1;}
    @Column(name = "AECOPD_6_5_1")
    @JsonProperty("AECOPD-6-5-1")
    private String AECOPD_6_5_1; // 是否有气胸
    public String getAECOPD_6_5_1() {  return this.AECOPD_6_5_1;}
    @JsonProperty("AECOPD-6-5-1")
    public void setAECOPD_6_5_1(final String AECOPD_6_5_1) { this.AECOPD_6_5_1=AECOPD_6_5_1;}
    @Column(name = "AECOPD_6_5_2")
    @JsonProperty("AECOPD-6-5-2")
    private String AECOPD_6_5_2; // 首位处置项目
    public String getAECOPD_6_5_2() {  return this.AECOPD_6_5_2;}
    @JsonProperty("AECOPD-6-5-2")
    public void setAECOPD_6_5_2(final String AECOPD_6_5_2) { this.AECOPD_6_5_2=AECOPD_6_5_2;}
    @Column(name = "AECOPD_6_5_2_1")
    @JsonProperty("AECOPD-6-5-2-1")
    private String AECOPD_6_5_2_1; // 有气胸时,其他处置项目
    public String getAECOPD_6_5_2_1() {  return this.AECOPD_6_5_2_1;}
    @JsonProperty("AECOPD-6-5-2-1")
    public void setAECOPD_6_5_2_1(final String AECOPD_6_5_2_1) { this.AECOPD_6_5_2_1=AECOPD_6_5_2_1;}
    @Column(name = "AECOPD_7_1_1")
    @JsonProperty("AECOPD-7-1-1")
    private String AECOPD_7_1_1; // 是否实施无创正压通气（NIV）
    public String getAECOPD_7_1_1() {  return this.AECOPD_7_1_1;}
    @JsonProperty("AECOPD-7-1-1")
    public void setAECOPD_7_1_1(final String AECOPD_7_1_1) { this.AECOPD_7_1_1=AECOPD_7_1_1;}
    @Column(name = "AECOPD_7_1_2")
    @JsonProperty("AECOPD-7-1-2")
    private String AECOPD_7_1_2; // 无创正压通气的应用指征
    public String getAECOPD_7_1_2() {  return this.AECOPD_7_1_2;}
    @JsonProperty("AECOPD-7-1-2")
    public void setAECOPD_7_1_2(final String AECOPD_7_1_2) { this.AECOPD_7_1_2=AECOPD_7_1_2;}
    @Column(name = "AECOPD_7_1_3_1")
    @JsonProperty("AECOPD-7-1-3-1")
    private String AECOPD_7_1_3_1; // NIV相对禁忌证 
    public String getAECOPD_7_1_3_1() {  return this.AECOPD_7_1_3_1;}
    @JsonProperty("AECOPD-7-1-3-1")
    public void setAECOPD_7_1_3_1(final String AECOPD_7_1_3_1) { this.AECOPD_7_1_3_1=AECOPD_7_1_3_1;}
    @Column(name = "AECOPD_7_1_6")
    @JsonProperty("AECOPD-7-1-6")
    private String AECOPD_7_1_6; // 患者无创正压通气起始日期时间
    public String getAECOPD_7_1_6() {  return this.AECOPD_7_1_6;}
    @JsonProperty("AECOPD-7-1-6")
    public void setAECOPD_7_1_6(final String AECOPD_7_1_6) { this.AECOPD_7_1_6=AECOPD_7_1_6;}
    @Column(name = "AECOPD_7_1_7")
    @JsonProperty("AECOPD-7-1-7")
    private String AECOPD_7_1_7; // 患者无创正压通气终止日期时间
    public String getAECOPD_7_1_7() {  return this.AECOPD_7_1_7;}
    @JsonProperty("AECOPD-7-1-7")
    public void setAECOPD_7_1_7(final String AECOPD_7_1_7) { this.AECOPD_7_1_7=AECOPD_7_1_7;}
    @Column(name = "AECOPD_7_1_8_r")
    @JsonProperty("AECOPD-7-1-8-r")
    private String AECOPD_7_1_8_r; // 无创正压通气疗程（小时）
    public String getAECOPD_7_1_8_r() {  return this.AECOPD_7_1_8_r;}
    @JsonProperty("AECOPD-7-1-8-r")
    public void setAECOPD_7_1_8_r(final String AECOPD_7_1_8_r) { this.AECOPD_7_1_8_r=AECOPD_7_1_8_r;}
    @Column(name = "AECOPD_7_1_8")
    @JsonProperty("AECOPD-7-1-8")
    private String AECOPD_7_1_8; // 无创正压通气疗程（小时）
    public String getAECOPD_7_1_8() {  return this.AECOPD_7_1_8;}
    @JsonProperty("AECOPD-7-1-8")
    public void setAECOPD_7_1_8(final String AECOPD_7_1_8) { this.AECOPD_7_1_8=AECOPD_7_1_8;}
    @Column(name = "AECOPD_7_2_1")
    @JsonProperty("AECOPD-7-2-1")
    private String AECOPD_7_2_1; // 是否实施有创机械通气
    public String getAECOPD_7_2_1() {  return this.AECOPD_7_2_1;}
    @JsonProperty("AECOPD-7-2-1")
    public void setAECOPD_7_2_1(final String AECOPD_7_2_1) { this.AECOPD_7_2_1=AECOPD_7_2_1;}
    @Column(name = "AECOPD_7_2_2")
    @JsonProperty("AECOPD-7-2-2")
    private String AECOPD_7_2_2; // 有创机械通气指征
    public String getAECOPD_7_2_2() {  return this.AECOPD_7_2_2;}
    @JsonProperty("AECOPD-7-2-2")
    public void setAECOPD_7_2_2(final String AECOPD_7_2_2) { this.AECOPD_7_2_2=AECOPD_7_2_2;}
    @Column(name = "AECOPD_7_2_5_1")
    @JsonProperty("AECOPD-7-2-5-1")
    private String AECOPD_7_2_5_1; // 患者有机械通气起始日期时间
    public String getAECOPD_7_2_5_1() {  return this.AECOPD_7_2_5_1;}
    @JsonProperty("AECOPD-7-2-5-1")
    public void setAECOPD_7_2_5_1(final String AECOPD_7_2_5_1) { this.AECOPD_7_2_5_1=AECOPD_7_2_5_1;}
    @Column(name = "AECOPD_7_2_6")
    @JsonProperty("AECOPD-7-2-6")
    private String AECOPD_7_2_6; // 患者有机械通气终止日期时间
    public String getAECOPD_7_2_6() {  return this.AECOPD_7_2_6;}
    @JsonProperty("AECOPD-7-2-6")
    public void setAECOPD_7_2_6(final String AECOPD_7_2_6) { this.AECOPD_7_2_6=AECOPD_7_2_6;}
    @Column(name = "AECOPD_7_2_7_r")
    @JsonProperty("AECOPD-7-2-7-r")
    private String AECOPD_7_2_7_r; // 有机械通气疗程（小时）
    public String getAECOPD_7_2_7_r() {  return this.AECOPD_7_2_7_r;}
    @JsonProperty("AECOPD-7-2-7-r")
    public void setAECOPD_7_2_7_r(final String AECOPD_7_2_7_r) { this.AECOPD_7_2_7_r=AECOPD_7_2_7_r;}
    @Column(name = "AECOPD_7_2_7")
    @JsonProperty("AECOPD-7-2-7")
    private String AECOPD_7_2_7; // 有机械通气疗程（小时）
    public String getAECOPD_7_2_7() {  return this.AECOPD_7_2_7;}
    @JsonProperty("AECOPD-7-2-7")
    public void setAECOPD_7_2_7(final String AECOPD_7_2_7) { this.AECOPD_7_2_7=AECOPD_7_2_7;}
    @Column(name = "AECOPD_7_3_1")
    @JsonProperty("AECOPD-7-3-1")
    private String AECOPD_7_3_1; // 是否实施有创-无创序贯通气疗法
    public String getAECOPD_7_3_1() {  return this.AECOPD_7_3_1;}
    @JsonProperty("AECOPD-7-3-1")
    public void setAECOPD_7_3_1(final String AECOPD_7_3_1) { this.AECOPD_7_3_1=AECOPD_7_3_1;}
    @Column(name = "AECOPD_8_1_1")
    @JsonProperty("AECOPD-8-1-1")
    private String AECOPD_8_1_1; // 有无吸烟史
    public String getAECOPD_8_1_1() {  return this.AECOPD_8_1_1;}
    @JsonProperty("AECOPD-8-1-1")
    public void setAECOPD_8_1_1(final String AECOPD_8_1_1) { this.AECOPD_8_1_1=AECOPD_8_1_1;}
    @Column(name = "AECOPD_8_2")
    @JsonProperty("AECOPD-8-2")
    private String AECOPD_8_2; // 吸烟程度评估有记录
    public String getAECOPD_8_2() {  return this.AECOPD_8_2;}
    @JsonProperty("AECOPD-8-2")
    public void setAECOPD_8_2(final String AECOPD_8_2) { this.AECOPD_8_2=AECOPD_8_2;}
    @Column(name = "AECOPD_8_3")
    @JsonProperty("AECOPD-8-3")
    private String AECOPD_8_3; // 接受戒烟的建议或者戒烟治疗有记录
    public String getAECOPD_8_3() {  return this.AECOPD_8_3;}
    @JsonProperty("AECOPD-8-3")
    public void setAECOPD_8_3(final String AECOPD_8_3) { this.AECOPD_8_3=AECOPD_8_3;}
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    public String getCM_7_2_1() {  return this.CM_7_2_1;}
    @JsonProperty("CM-7-2-1")
    public void setCM_7_2_1(final String CM_7_2_1) { this.CM_7_2_1=CM_7_2_1;}
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    public String getCM_7_2_2() {  return this.CM_7_2_2;}
    @JsonProperty("CM-7-2-2")
    public void setCM_7_2_2(final String CM_7_2_2) { this.CM_7_2_2=CM_7_2_2;}
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    public String getCM_7_2_4() {  return this.CM_7_2_4;}
    @JsonProperty("CM-7-2-4")
    public void setCM_7_2_4(final String CM_7_2_4) { this.CM_7_2_4=CM_7_2_4;}
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
    public String getCM_7_2_5() {  return this.CM_7_2_5;}
    @JsonProperty("CM-7-2-5")
    public void setCM_7_2_5(final String CM_7_2_5) { this.CM_7_2_5=CM_7_2_5;}
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    public String getCM_7_2_3() {  return this.CM_7_2_3;}
    @JsonProperty("CM-7-2-3")
    public void setCM_7_2_3(final String CM_7_2_3) { this.CM_7_2_3=CM_7_2_3;}
    @Column(name = "CM_4_1")
    @JsonProperty("CM-4-1")
    private String CM_4_1; // 住院天数
    public String getCM_4_1() {  return this.CM_4_1;}
    @JsonProperty("CM-4-1")
    public void setCM_4_1(final String CM_4_1) { this.CM_4_1=CM_4_1;}
    @Column(name = "CM_4_3")
    @JsonProperty("CM-4-3")
    private String CM_4_3; // 离院方式选择
    public String getCM_4_3() {  return this.CM_4_3;}
    @JsonProperty("CM-4-3")
    public void setCM_4_3(final String CM_4_3) { this.CM_4_3=CM_4_3;}
    @Column(name = "CM_4_5")
    @JsonProperty("CM-4-5")
    private String CM_4_5; // 非医嘱离院可能涉及因素
    public String getCM_4_5() {  return this.CM_4_5;}
    @JsonProperty("CM-4-5")
    public void setCM_4_5(final String CM_4_5) { this.CM_4_5=CM_4_5;}
    @Column(name = "CM_4_4_1")
    @JsonProperty("CM-4-4-1")
    private String CM_4_4_1; // 其他非医嘱离院因素填写
    public String getCM_4_4_1() {  return this.CM_4_4_1;}
    @JsonProperty("CM-4-4-1")
    public void setCM_4_4_1(final String CM_4_4_1) { this.CM_4_4_1=CM_4_4_1;}
    @Column(name = "CM_4_6")
    @JsonProperty("CM-4-6")
    private String CM_4_6; // 死亡可能涉及因素
    public String getCM_4_6() {  return this.CM_4_6;}
    @JsonProperty("CM-4-6")
    public void setCM_4_6(final String CM_4_6) { this.CM_4_6=CM_4_6;}
    @Column(name = "AECOPD_9_1_1")
    @JsonProperty("AECOPD-9-1-1")
    private String AECOPD_9_1_1; // 符合出院标准
    public String getAECOPD_9_1_1() {  return this.AECOPD_9_1_1;}
    @JsonProperty("AECOPD-9-1-1")
    public void setAECOPD_9_1_1(final String AECOPD_9_1_1) { this.AECOPD_9_1_1=AECOPD_9_1_1;}
    @Column(name = "AECOPD_9_1_2")
    @JsonProperty("AECOPD-9-1-2")
    private String AECOPD_9_1_2; // 其他标准
    public String getAECOPD_9_1_2() {  return this.AECOPD_9_1_2;}
    @JsonProperty("AECOPD-9-1-2")
    public void setAECOPD_9_1_2(final String AECOPD_9_1_2) { this.AECOPD_9_1_2=AECOPD_9_1_2;}
    @Column(name = "CM_5_1")
    @JsonProperty("CM-5-1")
    private String CM_5_1; // 患者是否对服务的体验与评价
    public String getCM_5_1() {  return this.CM_5_1;}
    @JsonProperty("CM-5-1")
    public void setCM_5_1(final String CM_5_1) { this.CM_5_1=CM_5_1;}
    @Column(name = "CM_5_2_1")
    @JsonProperty("CM-5-2-1")
    private String CM_5_2_1; // 整体医院评级
    public String getCM_5_2_1() {  return this.CM_5_2_1;}
    @JsonProperty("CM-5-2-1")
    public void setCM_5_2_1(final String CM_5_2_1) { this.CM_5_2_1=CM_5_2_1;}
    @Column(name = "CM_5_2_2")
    @JsonProperty("CM-5-2-2")
    private String CM_5_2_2; // 患者推荐
    public String getCM_5_2_2() {  return this.CM_5_2_2;}
    @JsonProperty("CM-5-2-2")
    public void setCM_5_2_2(final String CM_5_2_2) { this.CM_5_2_2=CM_5_2_2;}
    @Column(name = "CM_5_2_3")
    @JsonProperty("CM-5-2-3")
    private String CM_5_2_3; // 病房、床单元和卫生间清洁度
    public String getCM_5_2_3() {  return this.CM_5_2_3;}
    @JsonProperty("CM-5-2-3")
    public void setCM_5_2_3(final String CM_5_2_3) { this.CM_5_2_3=CM_5_2_3;}
    @Column(name = "CM_5_2_5")
    @JsonProperty("CM-5-2-5")
    private String CM_5_2_5; // 病房与周边噪音
    public String getCM_5_2_5() {  return this.CM_5_2_5;}
    @JsonProperty("CM-5-2-5")
    public void setCM_5_2_5(final String CM_5_2_5) { this.CM_5_2_5=CM_5_2_5;}
    @Column(name = "CM_5_2_6")
    @JsonProperty("CM-5-2-6")
    private String CM_5_2_6; // 医生沟通
    public String getCM_5_2_6() {  return this.CM_5_2_6;}
    @JsonProperty("CM-5-2-6")
    public void setCM_5_2_6(final String CM_5_2_6) { this.CM_5_2_6=CM_5_2_6;}
    @Column(name = "CM_5_2_7")
    @JsonProperty("CM-5-2-7")
    private String CM_5_2_7; // 护士沟通
    public String getCM_5_2_7() {  return this.CM_5_2_7;}
    @JsonProperty("CM-5-2-7")
    public void setCM_5_2_7(final String CM_5_2_7) { this.CM_5_2_7=CM_5_2_7;}
    @Column(name = "CM_5_2_8")
    @JsonProperty("CM-5-2-8")
    private String CM_5_2_8; // 药师沟通
    public String getCM_5_2_8() {  return this.CM_5_2_8;}
    @JsonProperty("CM-5-2-8")
    public void setCM_5_2_8(final String CM_5_2_8) { this.CM_5_2_8=CM_5_2_8;}
    @Column(name = "CM_5_2_9")
    @JsonProperty("CM-5-2-9")
    private String CM_5_2_9; // 康复计划
    public String getCM_5_2_9() {  return this.CM_5_2_9;}
    @JsonProperty("CM-5-2-9")
    public void setCM_5_2_9(final String CM_5_2_9) { this.CM_5_2_9=CM_5_2_9;}
    @Column(name = "CM_5_2_10")
    @JsonProperty("CM-5-2-10")
    private String CM_5_2_10; // 出院时的知情告知
    public String getCM_5_2_10() {  return this.CM_5_2_10;}
    @JsonProperty("CM-5-2-10")
    public void setCM_5_2_10(final String CM_5_2_10) { this.CM_5_2_10=CM_5_2_10;}
    @Column(name = "CM_5_2_11")
    @JsonProperty("CM-5-2-11")
    private String CM_5_2_11; // 膳食评价
    public String getCM_5_2_11() {  return this.CM_5_2_11;}
    @JsonProperty("CM-5-2-11")
    public void setCM_5_2_11(final String CM_5_2_11) { this.CM_5_2_11=CM_5_2_11;}
    @Column(name = "CM_6_1")
    @JsonProperty("CM-6-1")
    private String CM_6_1; // 住院总费用
    public String getCM_6_1() {  return this.CM_6_1;}
    @JsonProperty("CM-6-1")
    public void setCM_6_1(final String CM_6_1) { this.CM_6_1=CM_6_1;}
    @Column(name = "CM_6_2")
    @JsonProperty("CM-6-2")
    private String CM_6_2; // 住院总费用其中自付金额
    public String getCM_6_2() {  return this.CM_6_2;}
    @JsonProperty("CM-6-2")
    public void setCM_6_2(final String CM_6_2) { this.CM_6_2=CM_6_2;}
    @Column(name = "CM_6_3")
    @JsonProperty("CM-6-3")
    private String CM_6_3; // 一般医疗服务费
    public String getCM_6_3() {  return this.CM_6_3;}
    @JsonProperty("CM-6-3")
    public void setCM_6_3(final String CM_6_3) { this.CM_6_3=CM_6_3;}
    @Column(name = "CM_6_4")
    @JsonProperty("CM-6-4")
    private String CM_6_4; // 一般治疗操作费
    public String getCM_6_4() {  return this.CM_6_4;}
    @JsonProperty("CM-6-4")
    public void setCM_6_4(final String CM_6_4) { this.CM_6_4=CM_6_4;}
    @Column(name = "CM_6_5")
    @JsonProperty("CM-6-5")
    private String CM_6_5; // 护理费
    public String getCM_6_5() {  return this.CM_6_5;}
    @JsonProperty("CM-6-5")
    public void setCM_6_5(final String CM_6_5) { this.CM_6_5=CM_6_5;}
    @Column(name = "CM_6_6")
    @JsonProperty("CM-6-6")
    private String CM_6_6; // 综合医疗服务类其他费用
    public String getCM_6_6() {  return this.CM_6_6;}
    @JsonProperty("CM-6-6")
    public void setCM_6_6(final String CM_6_6) { this.CM_6_6=CM_6_6;}
    @Column(name = "CM_6_7")
    @JsonProperty("CM-6-7")
    private String CM_6_7; // 病理诊断费
    public String getCM_6_7() {  return this.CM_6_7;}
    @JsonProperty("CM-6-7")
    public void setCM_6_7(final String CM_6_7) { this.CM_6_7=CM_6_7;}
    @Column(name = "CM_6_8")
    @JsonProperty("CM-6-8")
    private String CM_6_8; // 实验室诊断费
    public String getCM_6_8() {  return this.CM_6_8;}
    @JsonProperty("CM-6-8")
    public void setCM_6_8(final String CM_6_8) { this.CM_6_8=CM_6_8;}
    @Column(name = "CM_6_9")
    @JsonProperty("CM-6-9")
    private String CM_6_9; // 影像学诊断费
    public String getCM_6_9() {  return this.CM_6_9;}
    @JsonProperty("CM-6-9")
    public void setCM_6_9(final String CM_6_9) { this.CM_6_9=CM_6_9;}
    @Column(name = "CM_6_10")
    @JsonProperty("CM-6-10")
    private String CM_6_10; // 临床诊断项目费
    public String getCM_6_10() {  return this.CM_6_10;}
    @JsonProperty("CM-6-10")
    public void setCM_6_10(final String CM_6_10) { this.CM_6_10=CM_6_10;}
    @Column(name = "CM_6_11")
    @JsonProperty("CM-6-11")
    private String CM_6_11; // 非手术治疗项目费
    public String getCM_6_11() {  return this.CM_6_11;}
    @JsonProperty("CM-6-11")
    public void setCM_6_11(final String CM_6_11) { this.CM_6_11=CM_6_11;}
    @Column(name = "CM_6_12")
    @JsonProperty("CM-6-12")
    private String CM_6_12; // 其中：临床物理治疗费
    public String getCM_6_12() {  return this.CM_6_12;}
    @JsonProperty("CM-6-12")
    public void setCM_6_12(final String CM_6_12) { this.CM_6_12=CM_6_12;}
    @Column(name = "CM_6_13")
    @JsonProperty("CM-6-13")
    private String CM_6_13; // 手术治疗费
    public String getCM_6_13() {  return this.CM_6_13;}
    @JsonProperty("CM-6-13")
    public void setCM_6_13(final String CM_6_13) { this.CM_6_13=CM_6_13;}
    @Column(name = "CM_6_14")
    @JsonProperty("CM-6-14")
    private String CM_6_14; // 其中：麻醉费
    public String getCM_6_14() {  return this.CM_6_14;}
    @JsonProperty("CM-6-14")
    public void setCM_6_14(final String CM_6_14) { this.CM_6_14=CM_6_14;}
    @Column(name = "CM_6_15")
    @JsonProperty("CM-6-15")
    private String CM_6_15; // 其中：手术费
    public String getCM_6_15() {  return this.CM_6_15;}
    @JsonProperty("CM-6-15")
    public void setCM_6_15(final String CM_6_15) { this.CM_6_15=CM_6_15;}
    @Column(name = "CM_6_16")
    @JsonProperty("CM-6-16")
    private String CM_6_16; // 康复费
    public String getCM_6_16() {  return this.CM_6_16;}
    @JsonProperty("CM-6-16")
    public void setCM_6_16(final String CM_6_16) { this.CM_6_16=CM_6_16;}
    @Column(name = "CM_6_17")
    @JsonProperty("CM-6-17")
    private String CM_6_17; // 中医治疗费
    public String getCM_6_17() {  return this.CM_6_17;}
    @JsonProperty("CM-6-17")
    public void setCM_6_17(final String CM_6_17) { this.CM_6_17=CM_6_17;}
    @Column(name = "CM_6_18")
    @JsonProperty("CM-6-18")
    private String CM_6_18; // 西药费
    public String getCM_6_18() {  return this.CM_6_18;}
    @JsonProperty("CM-6-18")
    public void setCM_6_18(final String CM_6_18) { this.CM_6_18=CM_6_18;}
    @Column(name = "CM_6_19")
    @JsonProperty("CM-6-19")
    private String CM_6_19; // 其中：抗菌药物费
    public String getCM_6_19() {  return this.CM_6_19;}
    @JsonProperty("CM-6-19")
    public void setCM_6_19(final String CM_6_19) { this.CM_6_19=CM_6_19;}
    @Column(name = "CM_6_20")
    @JsonProperty("CM-6-20")
    private String CM_6_20; // 中成药费
    public String getCM_6_20() {  return this.CM_6_20;}
    @JsonProperty("CM-6-20")
    public void setCM_6_20(final String CM_6_20) { this.CM_6_20=CM_6_20;}
    @Column(name = "CM_6_21")
    @JsonProperty("CM-6-21")
    private String CM_6_21; // 中草药费
    public String getCM_6_21() {  return this.CM_6_21;}
    @JsonProperty("CM-6-21")
    public void setCM_6_21(final String CM_6_21) { this.CM_6_21=CM_6_21;}
    @Column(name = "CM_6_22")
    @JsonProperty("CM-6-22")
    private String CM_6_22; // 血费
    public String getCM_6_22() {  return this.CM_6_22;}
    @JsonProperty("CM-6-22")
    public void setCM_6_22(final String CM_6_22) { this.CM_6_22=CM_6_22;}
    @Column(name = "CM_6_23")
    @JsonProperty("CM-6-23")
    private String CM_6_23; // 白蛋白类制品费
    public String getCM_6_23() {  return this.CM_6_23;}
    @JsonProperty("CM-6-23")
    public void setCM_6_23(final String CM_6_23) { this.CM_6_23=CM_6_23;}
    @Column(name = "CM_6_24")
    @JsonProperty("CM-6-24")
    private String CM_6_24; // 球蛋白类制品费
    public String getCM_6_24() {  return this.CM_6_24;}
    @JsonProperty("CM-6-24")
    public void setCM_6_24(final String CM_6_24) { this.CM_6_24=CM_6_24;}
    @Column(name = "CM_6_25")
    @JsonProperty("CM-6-25")
    private String CM_6_25; // 凝血因子类制品费
    public String getCM_6_25() {  return this.CM_6_25;}
    @JsonProperty("CM-6-25")
    public void setCM_6_25(final String CM_6_25) { this.CM_6_25=CM_6_25;}
    @Column(name = "CM_6_26")
    @JsonProperty("CM-6-26")
    private String CM_6_26; // 细胞因子类制品费
    public String getCM_6_26() {  return this.CM_6_26;}
    @JsonProperty("CM-6-26")
    public void setCM_6_26(final String CM_6_26) { this.CM_6_26=CM_6_26;}
    @Column(name = "CM_6_27")
    @JsonProperty("CM-6-27")
    private String CM_6_27; // 检查用一次性医用材料费
    public String getCM_6_27() {  return this.CM_6_27;}
    @JsonProperty("CM-6-27")
    public void setCM_6_27(final String CM_6_27) { this.CM_6_27=CM_6_27;}
    @Column(name = "CM_6_28")
    @JsonProperty("CM-6-28")
    private String CM_6_28; // 治疗用一次性医用材料费
    public String getCM_6_28() {  return this.CM_6_28;}
    @JsonProperty("CM-6-28")
    public void setCM_6_28(final String CM_6_28) { this.CM_6_28=CM_6_28;}
    @Column(name = "CM_6_29")
    @JsonProperty("CM-6-29")
    private String CM_6_29; // 手术用一次性医用材料费
    public String getCM_6_29() {  return this.CM_6_29;}
    @JsonProperty("CM-6-29")
    public void setCM_6_29(final String CM_6_29) { this.CM_6_29=CM_6_29;}
    @Column(name = "CM_6_30")
    @JsonProperty("CM-6-30")
    private String CM_6_30; // 其他费
    public String getCM_6_30() {  return this.CM_6_30;}
    @JsonProperty("CM-6-30")
    public void setCM_6_30(final String CM_6_30) { this.CM_6_30=CM_6_30;}
}