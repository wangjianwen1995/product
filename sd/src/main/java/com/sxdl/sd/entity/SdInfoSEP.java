package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断/其他诊断 ICD-10 编码：A02.1，A22.7，A32.7，A40.1 至 A40.9， A41.0 至 A41.9，A42.7，A54.8，B73.7，R65.2，R65.3，R65.9 的出院患者。
*/
@ApiModel(value = "47信息")
@Entity
@Table(name = "sd_info_SEP")
public class SdInfoSEP implements Serializable {
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
    private String CM_0_1_3_1; // 主要/其他诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要/其他诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getCM_0_1_4_1() {  return this.CM_0_1_4_1;}
    @JsonProperty("CM-0-1-4-1")
    public void setCM_0_1_4_1(final String CM_0_1_4_1) { this.CM_0_1_4_1=CM_0_1_4_1;}
    @Column(name = "CM_0_1_4_1_1")
    @JsonProperty("CM-0-1-4-1-1")
    private String CM_0_1_4_1_1; // 其他ICD-9-CM-3四位亚目编码与名称
    public String getCM_0_1_4_1_1() {  return this.CM_0_1_4_1_1;}
    @JsonProperty("CM-0-1-4-1-1")
    public void setCM_0_1_4_1_1(final String CM_0_1_4_1_1) { this.CM_0_1_4_1_1=CM_0_1_4_1_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "CM_0_1_4_2_1")
    @JsonProperty("CM-0-1-4-2-1")
    private String CM_0_1_4_2_1; // 其他ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2_1() {  return this.CM_0_1_4_2_1;}
    @JsonProperty("CM-0-1-4-2-1")
    public void setCM_0_1_4_2_1(final String CM_0_1_4_2_1) { this.CM_0_1_4_2_1=CM_0_1_4_2_1;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // SEP出院后31天内是否重复住院
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
    @Column(name = "CM_0_2_2_1")
    @JsonProperty("CM-0-2-2-1")
    private String CM_0_2_2_1; // 发病日期时间是否无法确定或无记录
    public String getCM_0_2_2_1() {  return this.CM_0_2_2_1;}
    @JsonProperty("CM-0-2-2-1")
    public void setCM_0_2_2_1(final String CM_0_2_2_1) { this.CM_0_2_2_1=CM_0_2_2_1;}
    @Column(name = "CM_0_2_2_2")
    @JsonProperty("CM-0-2-2-2")
    private String CM_0_2_2_2; // 发病日期时间
    public String getCM_0_2_2_2() {  return this.CM_0_2_2_2;}
    @JsonProperty("CM-0-2-2-2")
    public void setCM_0_2_2_2(final String CM_0_2_2_2) { this.CM_0_2_2_2=CM_0_2_2_2;}
    @Column(name = "CM_0_2_3_1")
    @JsonProperty("CM-0-2-3-1")
    private String CM_0_2_3_1; // 到达本院急诊或者门诊日期时间是否无法确定或无记录
    public String getCM_0_2_3_1() {  return this.CM_0_2_3_1;}
    @JsonProperty("CM-0-2-3-1")
    public void setCM_0_2_3_1(final String CM_0_2_3_1) { this.CM_0_2_3_1=CM_0_2_3_1;}
    @Column(name = "CM_0_2_3_2")
    @JsonProperty("CM-0-2-3-2")
    private String CM_0_2_3_2; // 到达本院急诊或者门诊日期时间
    public String getCM_0_2_3_2() {  return this.CM_0_2_3_2;}
    @JsonProperty("CM-0-2-3-2")
    public void setCM_0_2_3_2(final String CM_0_2_3_2) { this.CM_0_2_3_2=CM_0_2_3_2;}
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
    private String CM_0_2_5_1; // 入住ICU日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU日期时间
    public String getCM_0_2_5_2() {  return this.CM_0_2_5_2;}
    @JsonProperty("CM-0-2-5-2")
    public void setCM_0_2_5_2(final String CM_0_2_5_2) { this.CM_0_2_5_2=CM_0_2_5_2;}
    @Column(name = "CM_0_2_6_1")
    @JsonProperty("CM-0-2-6-1")
    private String CM_0_2_6_1; // 手术开始（切皮）日期时间 
    public String getCM_0_2_6_1() {  return this.CM_0_2_6_1;}
    @JsonProperty("CM-0-2-6-1")
    public void setCM_0_2_6_1(final String CM_0_2_6_1) { this.CM_0_2_6_1=CM_0_2_6_1;}
    @Column(name = "CM_0_2_6_2")
    @JsonProperty("CM-0-2-6-2")
    private String CM_0_2_6_2; // 手术结束（缝皮结束）日期时间
    public String getCM_0_2_6_2() {  return this.CM_0_2_6_2;}
    @JsonProperty("CM-0-2-6-2")
    public void setCM_0_2_6_2(final String CM_0_2_6_2) { this.CM_0_2_6_2=CM_0_2_6_2;}
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
    @Column(name = "SEP_1_4_1")
    @JsonProperty("SEP-1-4-1")
    private String SEP_1_4_1; // 脓毒症或脓毒性休克的筛查与评估(SIRS 或NEWS 或MEWS 或SOFA 或qSOFA评分)
    public String getSEP_1_4_1() {  return this.SEP_1_4_1;}
    @JsonProperty("SEP-1-4-1")
    public void setSEP_1_4_1(final String SEP_1_4_1) { this.SEP_1_4_1=SEP_1_4_1;}
    @Column(name = "SEP_1_4_1_1")
    @JsonProperty("SEP-1-4-1-1")
    private String SEP_1_4_1_1; // SIRS评分值
    public String getSEP_1_4_1_1() {  return this.SEP_1_4_1_1;}
    @JsonProperty("SEP-1-4-1-1")
    public void setSEP_1_4_1_1(final String SEP_1_4_1_1) { this.SEP_1_4_1_1=SEP_1_4_1_1;}
    @Column(name = "SEP_1_4_1_2")
    @JsonProperty("SEP-1-4-1-2")
    private String SEP_1_4_1_2; // SIRS评分结果分层
    public String getSEP_1_4_1_2() {  return this.SEP_1_4_1_2;}
    @JsonProperty("SEP-1-4-1-2")
    public void setSEP_1_4_1_2(final String SEP_1_4_1_2) { this.SEP_1_4_1_2=SEP_1_4_1_2;}
    @Column(name = "SEP_1_4_1_3")
    @JsonProperty("SEP-1-4-1-3")
    private String SEP_1_4_1_3; // SIRS评分时间
    public String getSEP_1_4_1_3() {  return this.SEP_1_4_1_3;}
    @JsonProperty("SEP-1-4-1-3")
    public void setSEP_1_4_1_3(final String SEP_1_4_1_3) { this.SEP_1_4_1_3=SEP_1_4_1_3;}
    @Column(name = "SEP_1_4_2_1")
    @JsonProperty("SEP-1-4-2-1")
    private String SEP_1_4_2_1; // NEWS 评分值
    public String getSEP_1_4_2_1() {  return this.SEP_1_4_2_1;}
    @JsonProperty("SEP-1-4-2-1")
    public void setSEP_1_4_2_1(final String SEP_1_4_2_1) { this.SEP_1_4_2_1=SEP_1_4_2_1;}
    @Column(name = "SEP_1_4_2_2")
    @JsonProperty("SEP-1-4-2-2")
    private String SEP_1_4_2_2; // NEWS 评分结果分层
    public String getSEP_1_4_2_2() {  return this.SEP_1_4_2_2;}
    @JsonProperty("SEP-1-4-2-2")
    public void setSEP_1_4_2_2(final String SEP_1_4_2_2) { this.SEP_1_4_2_2=SEP_1_4_2_2;}
    @Column(name = "SEP_1_4_2_3")
    @JsonProperty("SEP-1-4-2-3")
    private String SEP_1_4_2_3; // NEWS 评分时间
    public String getSEP_1_4_2_3() {  return this.SEP_1_4_2_3;}
    @JsonProperty("SEP-1-4-2-3")
    public void setSEP_1_4_2_3(final String SEP_1_4_2_3) { this.SEP_1_4_2_3=SEP_1_4_2_3;}
    @Column(name = "SEP_1_4_3_1")
    @JsonProperty("SEP-1-4-3-1")
    private String SEP_1_4_3_1; // MEWS评分值
    public String getSEP_1_4_3_1() {  return this.SEP_1_4_3_1;}
    @JsonProperty("SEP-1-4-3-1")
    public void setSEP_1_4_3_1(final String SEP_1_4_3_1) { this.SEP_1_4_3_1=SEP_1_4_3_1;}
    @Column(name = "SEP_1_4_3_2")
    @JsonProperty("SEP-1-4-3-2")
    private String SEP_1_4_3_2; // MEWS 评分结果分层
    public String getSEP_1_4_3_2() {  return this.SEP_1_4_3_2;}
    @JsonProperty("SEP-1-4-3-2")
    public void setSEP_1_4_3_2(final String SEP_1_4_3_2) { this.SEP_1_4_3_2=SEP_1_4_3_2;}
    @Column(name = "SEP_1_4_3_3")
    @JsonProperty("SEP-1-4-3-3")
    private String SEP_1_4_3_3; // MEWS评分时间
    public String getSEP_1_4_3_3() {  return this.SEP_1_4_3_3;}
    @JsonProperty("SEP-1-4-3-3")
    public void setSEP_1_4_3_3(final String SEP_1_4_3_3) { this.SEP_1_4_3_3=SEP_1_4_3_3;}
    @Column(name = "SEP_1_4_4_2")
    @JsonProperty("SEP-1-4-4-2")
    private String SEP_1_4_4_2; // 第一部分：呼吸系统评分值
    public String getSEP_1_4_4_2() {  return this.SEP_1_4_4_2;}
    @JsonProperty("SEP-1-4-4-2")
    public void setSEP_1_4_4_2(final String SEP_1_4_4_2) { this.SEP_1_4_4_2=SEP_1_4_4_2;}
    @Column(name = "SEP_1_4_4_3")
    @JsonProperty("SEP-1-4-4-3")
    private String SEP_1_4_4_3; // 第二部分：血液系统评分值
    public String getSEP_1_4_4_3() {  return this.SEP_1_4_4_3;}
    @JsonProperty("SEP-1-4-4-3")
    public void setSEP_1_4_4_3(final String SEP_1_4_4_3) { this.SEP_1_4_4_3=SEP_1_4_4_3;}
    @Column(name = "SEP_1_4_4_4")
    @JsonProperty("SEP-1-4-4-4")
    private String SEP_1_4_4_4; // 第三部分：肝脏评分值
    public String getSEP_1_4_4_4() {  return this.SEP_1_4_4_4;}
    @JsonProperty("SEP-1-4-4-4")
    public void setSEP_1_4_4_4(final String SEP_1_4_4_4) { this.SEP_1_4_4_4=SEP_1_4_4_4;}
    @Column(name = "SEP_1_4_4_5")
    @JsonProperty("SEP-1-4-4-5")
    private String SEP_1_4_4_5; // 第四部分：心血管系统评分值
    public String getSEP_1_4_4_5() {  return this.SEP_1_4_4_5;}
    @JsonProperty("SEP-1-4-4-5")
    public void setSEP_1_4_4_5(final String SEP_1_4_4_5) { this.SEP_1_4_4_5=SEP_1_4_4_5;}
    @Column(name = "SEP_1_4_4_6")
    @JsonProperty("SEP-1-4-4-6")
    private String SEP_1_4_4_6; // 第五部分：中枢神经系统评分值
    public String getSEP_1_4_4_6() {  return this.SEP_1_4_4_6;}
    @JsonProperty("SEP-1-4-4-6")
    public void setSEP_1_4_4_6(final String SEP_1_4_4_6) { this.SEP_1_4_4_6=SEP_1_4_4_6;}
    @Column(name = "SEP_1_4_4_7")
    @JsonProperty("SEP-1-4-4-7")
    private String SEP_1_4_4_7; // 第六部分：肾脏评分值
    public String getSEP_1_4_4_7() {  return this.SEP_1_4_4_7;}
    @JsonProperty("SEP-1-4-4-7")
    public void setSEP_1_4_4_7(final String SEP_1_4_4_7) { this.SEP_1_4_4_7=SEP_1_4_4_7;}
    @Column(name = "SEP_1_4_4_1")
    @JsonProperty("SEP-1-4-4-1")
    private String SEP_1_4_4_1; // 合计：SOFA 评分值
    public String getSEP_1_4_4_1() {  return this.SEP_1_4_4_1;}
    @JsonProperty("SEP-1-4-4-1")
    public void setSEP_1_4_4_1(final String SEP_1_4_4_1) { this.SEP_1_4_4_1=SEP_1_4_4_1;}
    @Column(name = "SEP_1_4_4_8")
    @JsonProperty("SEP-1-4-4-8")
    private String SEP_1_4_4_8; // SOFA 评分结果分层
    public String getSEP_1_4_4_8() {  return this.SEP_1_4_4_8;}
    @JsonProperty("SEP-1-4-4-8")
    public void setSEP_1_4_4_8(final String SEP_1_4_4_8) { this.SEP_1_4_4_8=SEP_1_4_4_8;}
    @Column(name = "SEP_1_4_4_9")
    @JsonProperty("SEP-1-4-4-9")
    private String SEP_1_4_4_9; // SOFA 评分时间
    public String getSEP_1_4_4_9() {  return this.SEP_1_4_4_9;}
    @JsonProperty("SEP-1-4-4-9")
    public void setSEP_1_4_4_9(final String SEP_1_4_4_9) { this.SEP_1_4_4_9=SEP_1_4_4_9;}
    @Column(name = "SEP_1_4_5_1")
    @JsonProperty("SEP-1-4-5-1")
    private String SEP_1_4_5_1; // qSOFA评分值
    public String getSEP_1_4_5_1() {  return this.SEP_1_4_5_1;}
    @JsonProperty("SEP-1-4-5-1")
    public void setSEP_1_4_5_1(final String SEP_1_4_5_1) { this.SEP_1_4_5_1=SEP_1_4_5_1;}
    @Column(name = "SEP_1_4_5_2")
    @JsonProperty("SEP-1-4-5-2")
    private String SEP_1_4_5_2; // qSOFA评分结果分层
    public String getSEP_1_4_5_2() {  return this.SEP_1_4_5_2;}
    @JsonProperty("SEP-1-4-5-2")
    public void setSEP_1_4_5_2(final String SEP_1_4_5_2) { this.SEP_1_4_5_2=SEP_1_4_5_2;}
    @Column(name = "SEP_1_4_5_3")
    @JsonProperty("SEP-1-4-5-3")
    private String SEP_1_4_5_3; // qSOFA评分时间
    public String getSEP_1_4_5_3() {  return this.SEP_1_4_5_3;}
    @JsonProperty("SEP-1-4-5-3")
    public void setSEP_1_4_5_3(final String SEP_1_4_5_3) { this.SEP_1_4_5_3=SEP_1_4_5_3;}
    @Column(name = "SEP_1_5_1")
    @JsonProperty("SEP-1-5-1")
    private String SEP_1_5_1; // 是否有可能存在的感染灶的信息
    public String getSEP_1_5_1() {  return this.SEP_1_5_1;}
    @JsonProperty("SEP-1-5-1")
    public void setSEP_1_5_1(final String SEP_1_5_1) { this.SEP_1_5_1=SEP_1_5_1;}
    @Column(name = "SEP_1_5_2")
    @JsonProperty("SEP-1-5-2")
    private String SEP_1_5_2; // 可能存在的感染灶
    public String getSEP_1_5_2() {  return this.SEP_1_5_2;}
    @JsonProperty("SEP-1-5-2")
    public void setSEP_1_5_2(final String SEP_1_5_2) { this.SEP_1_5_2=SEP_1_5_2;}
    @Column(name = "SEP_1_5_2_1")
    @JsonProperty("SEP-1-5-2-1")
    private String SEP_1_5_2_1; // 其他可能存在的感染灶
    public String getSEP_1_5_2_1() {  return this.SEP_1_5_2_1;}
    @JsonProperty("SEP-1-5-2-1")
    public void setSEP_1_5_2_1(final String SEP_1_5_2_1) { this.SEP_1_5_2_1=SEP_1_5_2_1;}
    @Column(name = "SEP_1_3_3_1")
    @JsonProperty("SEP-1-3-3-1")
    private String SEP_1_3_3_1; // 初始SEP诊断或风险评估选择
    public String getSEP_1_3_3_1() {  return this.SEP_1_3_3_1;}
    @JsonProperty("SEP-1-3-3-1")
    public void setSEP_1_3_3_1(final String SEP_1_3_3_1) { this.SEP_1_3_3_1=SEP_1_3_3_1;}
    @Column(name = "SEP_1_3_3_2")
    @JsonProperty("SEP-1-3-3-2")
    private String SEP_1_3_3_2; // 严重脓毒症/脓毒性休克
    public String getSEP_1_3_3_2() {  return this.SEP_1_3_3_2;}
    @JsonProperty("SEP-1-3-3-2")
    public void setSEP_1_3_3_2(final String SEP_1_3_3_2) { this.SEP_1_3_3_2=SEP_1_3_3_2;}
    @Column(name = "SEP_1_3_3_3")
    @JsonProperty("SEP-1-3-3-3")
    private String SEP_1_3_3_3; // 风险评估值符合重症
    public String getSEP_1_3_3_3() {  return this.SEP_1_3_3_3;}
    @JsonProperty("SEP-1-3-3-3")
    public void setSEP_1_3_3_3(final String SEP_1_3_3_3) { this.SEP_1_3_3_3=SEP_1_3_3_3;}
    @Column(name = "SEP_1_3_2_2")
    @JsonProperty("SEP-1-3-2-2")
    private String SEP_1_3_2_2; // 连续二次监测为低血压
    public String getSEP_1_3_2_2() {  return this.SEP_1_3_2_2;}
    @JsonProperty("SEP-1-3-2-2")
    public void setSEP_1_3_2_2(final String SEP_1_3_2_2) { this.SEP_1_3_2_2=SEP_1_3_2_2;}
    @Column(name = "SEP_1_3_2_3")
    @JsonProperty("SEP-1-3-2-3")
    private String SEP_1_3_2_3; // 第二次测量血压为持续性低血压的日期时间
    public String getSEP_1_3_2_3() {  return this.SEP_1_3_2_3;}
    @JsonProperty("SEP-1-3-2-3")
    public void setSEP_1_3_2_3(final String SEP_1_3_2_3) { this.SEP_1_3_2_3=SEP_1_3_2_3;}
    @Column(name = "SEP_2_1_1")
    @JsonProperty("SEP-2-1-1")
    private String SEP_2_1_1; // 是否在使用抗菌药物之前获得血液培养
    public String getSEP_2_1_1() {  return this.SEP_2_1_1;}
    @JsonProperty("SEP-2-1-1")
    public void setSEP_2_1_1(final String SEP_2_1_1) { this.SEP_2_1_1=SEP_2_1_1;}
    @Column(name = "SEP_2_1_2_2")
    @JsonProperty("SEP-2-1-2-2")
    private String SEP_2_1_2_2; // 血液培养标本采集日期时间是否无法确定或无记录
    public String getSEP_2_1_2_2() {  return this.SEP_2_1_2_2;}
    @JsonProperty("SEP-2-1-2-2")
    public void setSEP_2_1_2_2(final String SEP_2_1_2_2) { this.SEP_2_1_2_2=SEP_2_1_2_2;}
    @Column(name = "SEP_2_1_2")
    @JsonProperty("SEP-2-1-2")
    private String SEP_2_1_2; // 血液培养标本采集日期时间
    public String getSEP_2_1_2() {  return this.SEP_2_1_2;}
    @JsonProperty("SEP-2-1-2")
    public void setSEP_2_1_2(final String SEP_2_1_2) { this.SEP_2_1_2=SEP_2_1_2;}
    @Column(name = "SEP_2_1_3_2")
    @JsonProperty("SEP-2-1-3-2")
    private String SEP_2_1_3_2; // 病原学诊断报告日期时间是否无法确定或无记录
    public String getSEP_2_1_3_2() {  return this.SEP_2_1_3_2;}
    @JsonProperty("SEP-2-1-3-2")
    public void setSEP_2_1_3_2(final String SEP_2_1_3_2) { this.SEP_2_1_3_2=SEP_2_1_3_2;}
    @Column(name = "SEP_2_1_3_1")
    @JsonProperty("SEP-2-1-3-1")
    private String SEP_2_1_3_1; // 病原学诊断报告日期时间
    public String getSEP_2_1_3_1() {  return this.SEP_2_1_3_1;}
    @JsonProperty("SEP-2-1-3-1")
    public void setSEP_2_1_3_1(final String SEP_2_1_3_1) { this.SEP_2_1_3_1=SEP_2_1_3_1;}
    @Column(name = "SEP_2_1_4")
    @JsonProperty("SEP-2-1-4")
    private String SEP_2_1_4; // 病原学诊断结果选择
    public String getSEP_2_1_4() {  return this.SEP_2_1_4;}
    @JsonProperty("SEP-2-1-4")
    public void setSEP_2_1_4(final String SEP_2_1_4) { this.SEP_2_1_4=SEP_2_1_4;}
    @Column(name = "SEP_2_1_4_1")
    @JsonProperty("SEP-2-1-4-1")
    private String SEP_2_1_4_1; // 其他病原学诊断结果
    public String getSEP_2_1_4_1() {  return this.SEP_2_1_4_1;}
    @JsonProperty("SEP-2-1-4-1")
    public void setSEP_2_1_4_1(final String SEP_2_1_4_1) { this.SEP_2_1_4_1=SEP_2_1_4_1;}
    @Column(name = "SEP_2_2_1")
    @JsonProperty("SEP-2-2-1")
    private String SEP_2_2_1; // 是否有使用静脉注射广谱或其他抗菌药物的信息
    public String getSEP_2_2_1() {  return this.SEP_2_2_1;}
    @JsonProperty("SEP-2-2-1")
    public void setSEP_2_2_1(final String SEP_2_2_1) { this.SEP_2_2_1=SEP_2_2_1;}
    @Column(name = "SEP_2_2_2_2")
    @JsonProperty("SEP-2-2-2-2")
    private String SEP_2_2_2_2; // 给予抗菌药物静脉内给药的最早日期时间是否无法确定或无记录
    public String getSEP_2_2_2_2() {  return this.SEP_2_2_2_2;}
    @JsonProperty("SEP-2-2-2-2")
    public void setSEP_2_2_2_2(final String SEP_2_2_2_2) { this.SEP_2_2_2_2=SEP_2_2_2_2;}
    @Column(name = "SEP_2_2_2_1")
    @JsonProperty("SEP-2-2-2-1")
    private String SEP_2_2_2_1; // 给予抗菌药物静脉内给药的最早日期时间
    public String getSEP_2_2_2_1() {  return this.SEP_2_2_2_1;}
    @JsonProperty("SEP-2-2-2-1")
    public void setSEP_2_2_2_1(final String SEP_2_2_2_1) { this.SEP_2_2_2_1=SEP_2_2_2_1;}
    @Column(name = "SEP_2_2_3")
    @JsonProperty("SEP-2-2-3")
    private String SEP_2_2_3; // 使用广谱或其他抗抗感染药物选择
    public String getSEP_2_2_3() {  return this.SEP_2_2_3;}
    @JsonProperty("SEP-2-2-3")
    public void setSEP_2_2_3(final String SEP_2_2_3) { this.SEP_2_2_3=SEP_2_2_3;}
    @Column(name = "SEP_2_2_3_1")
    @JsonProperty("SEP-2-2-3-1")
    private String SEP_2_2_3_1; // 青霉素类抗感染药物
    public String getSEP_2_2_3_1() {  return this.SEP_2_2_3_1;}
    @JsonProperty("SEP-2-2-3-1")
    public void setSEP_2_2_3_1(final String SEP_2_2_3_1) { this.SEP_2_2_3_1=SEP_2_2_3_1;}
    @Column(name = "SEP_2_2_3_1_1")
    @JsonProperty("SEP-2-2-3-1-1")
    private String SEP_2_2_3_1_1; // 其他青霉素类抗菌药
    public String getSEP_2_2_3_1_1() {  return this.SEP_2_2_3_1_1;}
    @JsonProperty("SEP-2-2-3-1-1")
    public void setSEP_2_2_3_1_1(final String SEP_2_2_3_1_1) { this.SEP_2_2_3_1_1=SEP_2_2_3_1_1;}
    @Column(name = "SEP_2_2_3_2")
    @JsonProperty("SEP-2-2-3-2")
    private String SEP_2_2_3_2; // 头孢菌素类抗感染药物
    public String getSEP_2_2_3_2() {  return this.SEP_2_2_3_2;}
    @JsonProperty("SEP-2-2-3-2")
    public void setSEP_2_2_3_2(final String SEP_2_2_3_2) { this.SEP_2_2_3_2=SEP_2_2_3_2;}
    @Column(name = "SEP_2_2_3_2_1")
    @JsonProperty("SEP-2-2-3-2-1")
    private String SEP_2_2_3_2_1; // 其他头孢菌素类抗菌药
    public String getSEP_2_2_3_2_1() {  return this.SEP_2_2_3_2_1;}
    @JsonProperty("SEP-2-2-3-2-1")
    public void setSEP_2_2_3_2_1(final String SEP_2_2_3_2_1) { this.SEP_2_2_3_2_1=SEP_2_2_3_2_1;}
    @Column(name = "SEP_2_2_3_3")
    @JsonProperty("SEP-2-2-3-3")
    private String SEP_2_2_3_3; // 大环内酯类抗感染药物
    public String getSEP_2_2_3_3() {  return this.SEP_2_2_3_3;}
    @JsonProperty("SEP-2-2-3-3")
    public void setSEP_2_2_3_3(final String SEP_2_2_3_3) { this.SEP_2_2_3_3=SEP_2_2_3_3;}
    @Column(name = "SEP_2_2_3_3_1")
    @JsonProperty("SEP-2-2-3-3-1")
    private String SEP_2_2_3_3_1; // 其他大环内酯类抗菌药
    public String getSEP_2_2_3_3_1() {  return this.SEP_2_2_3_3_1;}
    @JsonProperty("SEP-2-2-3-3-1")
    public void setSEP_2_2_3_3_1(final String SEP_2_2_3_3_1) { this.SEP_2_2_3_3_1=SEP_2_2_3_3_1;}
    @Column(name = "SEP_2_2_3_4")
    @JsonProperty("SEP-2-2-3-4")
    private String SEP_2_2_3_4; // 喹诺酮类抗感染药物
    public String getSEP_2_2_3_4() {  return this.SEP_2_2_3_4;}
    @JsonProperty("SEP-2-2-3-4")
    public void setSEP_2_2_3_4(final String SEP_2_2_3_4) { this.SEP_2_2_3_4=SEP_2_2_3_4;}
    @Column(name = "SEP_2_2_3_4_1")
    @JsonProperty("SEP-2-2-3-4-1")
    private String SEP_2_2_3_4_1; // 其他-喹诺酮类抗菌药
    public String getSEP_2_2_3_4_1() {  return this.SEP_2_2_3_4_1;}
    @JsonProperty("SEP-2-2-3-4-1")
    public void setSEP_2_2_3_4_1(final String SEP_2_2_3_4_1) { this.SEP_2_2_3_4_1=SEP_2_2_3_4_1;}
    @Column(name = "SEP_2_2_3_5")
    @JsonProperty("SEP-2-2-3-5")
    private String SEP_2_2_3_5; // 其他类抗感染药物
    public String getSEP_2_2_3_5() {  return this.SEP_2_2_3_5;}
    @JsonProperty("SEP-2-2-3-5")
    public void setSEP_2_2_3_5(final String SEP_2_2_3_5) { this.SEP_2_2_3_5=SEP_2_2_3_5;}
    @Column(name = "SEP_2_2_3_5_1")
    @JsonProperty("SEP-2-2-3-5-1")
    private String SEP_2_2_3_5_1; // 其他抗菌药
    public String getSEP_2_2_3_5_1() {  return this.SEP_2_2_3_5_1;}
    @JsonProperty("SEP-2-2-3-5-1")
    public void setSEP_2_2_3_5_1(final String SEP_2_2_3_5_1) { this.SEP_2_2_3_5_1=SEP_2_2_3_5_1;}
    @Column(name = "SEP_2_3_1")
    @JsonProperty("SEP-2-3-1")
    private String SEP_2_3_1; // 是否有初始乳酸水平测量
    public String getSEP_2_3_1() {  return this.SEP_2_3_1;}
    @JsonProperty("SEP-2-3-1")
    public void setSEP_2_3_1(final String SEP_2_3_1) { this.SEP_2_3_1=SEP_2_3_1;}
    @Column(name = "SEP_2_3_2_2")
    @JsonProperty("SEP-2-3-2-2")
    private String SEP_2_3_2_2; // 标本采集日期时间是否无法确定或无记录
    public String getSEP_2_3_2_2() {  return this.SEP_2_3_2_2;}
    @JsonProperty("SEP-2-3-2-2")
    public void setSEP_2_3_2_2(final String SEP_2_3_2_2) { this.SEP_2_3_2_2=SEP_2_3_2_2;}
    @Column(name = "SEP_2_3_2_1")
    @JsonProperty("SEP-2-3-2-1")
    private String SEP_2_3_2_1; // 标本采集日期时间
    public String getSEP_2_3_2_1() {  return this.SEP_2_3_2_1;}
    @JsonProperty("SEP-2-3-2-1")
    public void setSEP_2_3_2_1(final String SEP_2_3_2_1) { this.SEP_2_3_2_1=SEP_2_3_2_1;}
    @Column(name = "SEP_2_3_3_2")
    @JsonProperty("SEP-2-3-3-2")
    private String SEP_2_3_3_2; // 初始乳酸水平测定报告日期时间是否无法确定或无记录
    public String getSEP_2_3_3_2() {  return this.SEP_2_3_3_2;}
    @JsonProperty("SEP-2-3-3-2")
    public void setSEP_2_3_3_2(final String SEP_2_3_3_2) { this.SEP_2_3_3_2=SEP_2_3_3_2;}
    @Column(name = "SEP_2_3_3_1")
    @JsonProperty("SEP-2-3-3-1")
    private String SEP_2_3_3_1; // 初始乳酸水平测定报告日期时间
    public String getSEP_2_3_3_1() {  return this.SEP_2_3_3_1;}
    @JsonProperty("SEP-2-3-3-1")
    public void setSEP_2_3_3_1(final String SEP_2_3_3_1) { this.SEP_2_3_3_1=SEP_2_3_3_1;}
    @Column(name = "SEP_2_3_4")
    @JsonProperty("SEP-2-3-4")
    private String SEP_2_3_4; // 初始乳酸水平测量值(mmol / L)
    public String getSEP_2_3_4() {  return this.SEP_2_3_4;}
    @JsonProperty("SEP-2-3-4")
    public void setSEP_2_3_4(final String SEP_2_3_4) { this.SEP_2_3_4=SEP_2_3_4;}
    @Column(name = "SEP_2_3_5")
    @JsonProperty("SEP-2-3-5")
    private String SEP_2_3_5; // 判定初始乳酸水平测量值评估结果
    public String getSEP_2_3_5() {  return this.SEP_2_3_5;}
    @JsonProperty("SEP-2-3-5")
    public void setSEP_2_3_5(final String SEP_2_3_5) { this.SEP_2_3_5=SEP_2_3_5;}
    @Column(name = "SEP_2_4_1")
    @JsonProperty("SEP-2-4-1")
    private String SEP_2_4_1; // 在时间窗内,是否经静脉给予复苏液体
    public String getSEP_2_4_1() {  return this.SEP_2_4_1;}
    @JsonProperty("SEP-2-4-1")
    public void setSEP_2_4_1(final String SEP_2_4_1) { this.SEP_2_4_1=SEP_2_4_1;}
    @Column(name = "SEP_2_4_2")
    @JsonProperty("SEP-2-4-2")
    private String SEP_2_4_2; // 在时间窗内经静脉补给复苏液体量
    public String getSEP_2_4_2() {  return this.SEP_2_4_2;}
    @JsonProperty("SEP-2-4-2")
    public void setSEP_2_4_2(final String SEP_2_4_2) { this.SEP_2_4_2=SEP_2_4_2;}
    @Column(name = "SEP_2_4_3")
    @JsonProperty("SEP-2-4-3")
    private String SEP_2_4_3; // 患者体重
    public String getSEP_2_4_3() {  return this.SEP_2_4_3;}
    @JsonProperty("SEP-2-4-3")
    public void setSEP_2_4_3(final String SEP_2_4_3) { this.SEP_2_4_3=SEP_2_4_3;}
    @Column(name = "SEP_2_4_4")
    @JsonProperty("SEP-2-4-4")
    private String SEP_2_4_4; // 给予复苏液体种类
    public String getSEP_2_4_4() {  return this.SEP_2_4_4;}
    @JsonProperty("SEP-2-4-4")
    public void setSEP_2_4_4(final String SEP_2_4_4) { this.SEP_2_4_4=SEP_2_4_4;}
    @Column(name = "SEP_2_4_2_1")
    @JsonProperty("SEP-2-4-2-1")
    private String SEP_2_4_2_1; // 复苏液体给药日期时间是否无法确定或无记录
    public String getSEP_2_4_2_1() {  return this.SEP_2_4_2_1;}
    @JsonProperty("SEP-2-4-2-1")
    public void setSEP_2_4_2_1(final String SEP_2_4_2_1) { this.SEP_2_4_2_1=SEP_2_4_2_1;}
    @Column(name = "SEP_2_4_2_2")
    @JsonProperty("SEP-2-4-2-2")
    private String SEP_2_4_2_2; // 复苏液体给药日期时间
    public String getSEP_2_4_2_2() {  return this.SEP_2_4_2_2;}
    @JsonProperty("SEP-2-4-2-2")
    public void setSEP_2_4_2_2(final String SEP_2_4_2_2) { this.SEP_2_4_2_2=SEP_2_4_2_2;}
    @Column(name = "SEP_3_1_1")
    @JsonProperty("SEP-3-1-1")
    private String SEP_3_1_1; // 给予复苏液体补充液后使用升压药物指征
    public String getSEP_3_1_1() {  return this.SEP_3_1_1;}
    @JsonProperty("SEP-3-1-1")
    public void setSEP_3_1_1(final String SEP_3_1_1) { this.SEP_3_1_1=SEP_3_1_1;}
    @Column(name = "SEP_3_1_2")
    @JsonProperty("SEP-3-1-2")
    private String SEP_3_1_2; // 首次,选择使用升压药物名称
    public String getSEP_3_1_2() {  return this.SEP_3_1_2;}
    @JsonProperty("SEP-3-1-2")
    public void setSEP_3_1_2(final String SEP_3_1_2) { this.SEP_3_1_2=SEP_3_1_2;}
    @Column(name = "SEP_3_1_2_1")
    @JsonProperty("SEP-3-1-2-1")
    private String SEP_3_1_2_1; // 其他升压药物名称
    public String getSEP_3_1_2_1() {  return this.SEP_3_1_2_1;}
    @JsonProperty("SEP-3-1-2-1")
    public void setSEP_3_1_2_1(final String SEP_3_1_2_1) { this.SEP_3_1_2_1=SEP_3_1_2_1;}
    @Column(name = "SEP_3_1_4")
    @JsonProperty("SEP-3-1-4")
    private String SEP_3_1_4; // 首次,使用升压药物的途径
    public String getSEP_3_1_4() {  return this.SEP_3_1_4;}
    @JsonProperty("SEP-3-1-4")
    public void setSEP_3_1_4(final String SEP_3_1_4) { this.SEP_3_1_4=SEP_3_1_4;}
    @Column(name = "SEP_3_1_4_1")
    @JsonProperty("SEP-3-1-4-1")
    private String SEP_3_1_4_1; // 其他升压药物的途径
    public String getSEP_3_1_4_1() {  return this.SEP_3_1_4_1;}
    @JsonProperty("SEP-3-1-4-1")
    public void setSEP_3_1_4_1(final String SEP_3_1_4_1) { this.SEP_3_1_4_1=SEP_3_1_4_1;}
    @Column(name = "SEP_3_1_3_2")
    @JsonProperty("SEP-3-1-3-2")
    private String SEP_3_1_3_2; // 首次,使用升压药物的日期时间是否无法确定或无记录
    public String getSEP_3_1_3_2() {  return this.SEP_3_1_3_2;}
    @JsonProperty("SEP-3-1-3-2")
    public void setSEP_3_1_3_2(final String SEP_3_1_3_2) { this.SEP_3_1_3_2=SEP_3_1_3_2;}
    @Column(name = "SEP_3_1_3_1")
    @JsonProperty("SEP-3-1-3-1")
    private String SEP_3_1_3_1; // 首次,使用升压药物的日期时间
    public String getSEP_3_1_3_1() {  return this.SEP_3_1_3_1;}
    @JsonProperty("SEP-3-1-3-1")
    public void setSEP_3_1_3_1(final String SEP_3_1_3_1) { this.SEP_3_1_3_1=SEP_3_1_3_1;}
    @Column(name = "SEP_3_2_1")
    @JsonProperty("SEP-3-2-1")
    private String SEP_3_2_1; // 是否进行2次及以上乳酸水平测量
    public String getSEP_3_2_1() {  return this.SEP_3_2_1;}
    @JsonProperty("SEP-3-2-1")
    public void setSEP_3_2_1(final String SEP_3_2_1) { this.SEP_3_2_1=SEP_3_2_1;}
    @Column(name = "SEP_3_2_2_2")
    @JsonProperty("SEP-3-2-2-2")
    private String SEP_3_2_2_2; // 重复乳酸水平测量，末次标本采集时间是否无法确定或无记录
    public String getSEP_3_2_2_2() {  return this.SEP_3_2_2_2;}
    @JsonProperty("SEP-3-2-2-2")
    public void setSEP_3_2_2_2(final String SEP_3_2_2_2) { this.SEP_3_2_2_2=SEP_3_2_2_2;}
    @Column(name = "SEP_3_2_2_1")
    @JsonProperty("SEP-3-2-2-1")
    private String SEP_3_2_2_1; // 重复乳酸水平测量，末次标本采集时间
    public String getSEP_3_2_2_1() {  return this.SEP_3_2_2_1;}
    @JsonProperty("SEP-3-2-2-1")
    public void setSEP_3_2_2_1(final String SEP_3_2_2_1) { this.SEP_3_2_2_1=SEP_3_2_2_1;}
    @Column(name = "SEP_3_2_3_2")
    @JsonProperty("SEP-3-2-3-2")
    private String SEP_3_2_3_2; // 末次乳酸水平测量报告时间是否无法确定或无记录
    public String getSEP_3_2_3_2() {  return this.SEP_3_2_3_2;}
    @JsonProperty("SEP-3-2-3-2")
    public void setSEP_3_2_3_2(final String SEP_3_2_3_2) { this.SEP_3_2_3_2=SEP_3_2_3_2;}
    @Column(name = "SEP_3_2_3_1")
    @JsonProperty("SEP-3-2-3-1")
    private String SEP_3_2_3_1; // 末次乳酸水平测量报告时间
    public String getSEP_3_2_3_1() {  return this.SEP_3_2_3_1;}
    @JsonProperty("SEP-3-2-3-1")
    public void setSEP_3_2_3_1(final String SEP_3_2_3_1) { this.SEP_3_2_3_1=SEP_3_2_3_1;}
    @Column(name = "SEP_3_2_4")
    @JsonProperty("SEP-3-2-4")
    private String SEP_3_2_4; // 末次，重复乳酸水平测量值（mmol / L）
    public String getSEP_3_2_4() {  return this.SEP_3_2_4;}
    @JsonProperty("SEP-3-2-4")
    public void setSEP_3_2_4(final String SEP_3_2_4) { this.SEP_3_2_4=SEP_3_2_4;}
    @Column(name = "SEP_3_2_5")
    @JsonProperty("SEP-3-2-5")
    private String SEP_3_2_5; // 判定末次乳酸水平测量值评估结果分层
    public String getSEP_3_2_5() {  return this.SEP_3_2_5;}
    @JsonProperty("SEP-3-2-5")
    public void setSEP_3_2_5(final String SEP_3_2_5) { this.SEP_3_2_5=SEP_3_2_5;}
    @Column(name = "SEP_3_3_1")
    @JsonProperty("SEP-3-3-1")
    private String SEP_3_3_1; // 在时间窗口是否进行了复苏和组织灌注状态评估
    public String getSEP_3_3_1() {  return this.SEP_3_3_1;}
    @JsonProperty("SEP-3-3-1")
    public void setSEP_3_3_1(final String SEP_3_3_1) { this.SEP_3_3_1=SEP_3_3_1;}
    @Column(name = "SEP_3_3_2")
    @JsonProperty("SEP-3-3-2")
    private String SEP_3_3_2; // 常用评估项目 
    public String getSEP_3_3_2() {  return this.SEP_3_3_2;}
    @JsonProperty("SEP-3-3-2")
    public void setSEP_3_3_2(final String SEP_3_3_2) { this.SEP_3_3_2=SEP_3_3_2;}
    @Column(name = "SEP_3_3_3_2")
    @JsonProperty("SEP-3-3-3-2")
    private String SEP_3_3_3_2; // 上述a至h中最后一个项目完成的时间是否无法确定或无记录
    public String getSEP_3_3_3_2() {  return this.SEP_3_3_3_2;}
    @JsonProperty("SEP-3-3-3-2")
    public void setSEP_3_3_3_2(final String SEP_3_3_3_2) { this.SEP_3_3_3_2=SEP_3_3_3_2;}
    @Column(name = "SEP_3_3_3_1")
    @JsonProperty("SEP-3-3-3-1")
    private String SEP_3_3_3_1; // 上述a至h中最后一个项目完成的时间
    public String getSEP_3_3_3_1() {  return this.SEP_3_3_3_1;}
    @JsonProperty("SEP-3-3-3-1")
    public void setSEP_3_3_3_1(final String SEP_3_3_3_1) { this.SEP_3_3_3_1=SEP_3_3_3_1;}
    @Column(name = "SEP_3_3_4")
    @JsonProperty("SEP-3-3-4")
    private String SEP_3_3_4; // 评估其他相关测量值 
    public String getSEP_3_3_4() {  return this.SEP_3_3_4;}
    @JsonProperty("SEP-3-3-4")
    public void setSEP_3_3_4(final String SEP_3_3_4) { this.SEP_3_3_4=SEP_3_3_4;}
    @Column(name = "SEP_3_3_4_1")
    @JsonProperty("SEP-3-3-4-1")
    private String SEP_3_3_4_1; // 其他评估相关测量值
    public String getSEP_3_3_4_1() {  return this.SEP_3_3_4_1;}
    @JsonProperty("SEP-3-3-4-1")
    public void setSEP_3_3_4_1(final String SEP_3_3_4_1) { this.SEP_3_3_4_1=SEP_3_3_4_1;}
    @Column(name = "SEP_3_3_5_2")
    @JsonProperty("SEP-3-3-5-2")
    private String SEP_3_3_5_2; // 上述a至d中最后一个项目完成的时间是否无法确定或无记录
    public String getSEP_3_3_5_2() {  return this.SEP_3_3_5_2;}
    @JsonProperty("SEP-3-3-5-2")
    public void setSEP_3_3_5_2(final String SEP_3_3_5_2) { this.SEP_3_3_5_2=SEP_3_3_5_2;}
    @Column(name = "SEP_3_3_5_1")
    @JsonProperty("SEP-3-3-5-1")
    private String SEP_3_3_5_1; // 上述a至d中最后一个项目完成的时间
    public String getSEP_3_3_5_1() {  return this.SEP_3_3_5_1;}
    @JsonProperty("SEP-3-3-5-1")
    public void setSEP_3_3_5_1(final String SEP_3_3_5_1) { this.SEP_3_3_5_1=SEP_3_3_5_1;}
    @Column(name = "SEP_4_1_1")
    @JsonProperty("SEP-4-1-1")
    private String SEP_4_1_1; // 是否由急诊科/ICU集束治疗后转至本院其他科室
    public String getSEP_4_1_1() {  return this.SEP_4_1_1;}
    @JsonProperty("SEP-4-1-1")
    public void setSEP_4_1_1(final String SEP_4_1_1) { this.SEP_4_1_1=SEP_4_1_1;}
    @Column(name = "SEP_4_1_2")
    @JsonProperty("SEP-4-1-2")
    private String SEP_4_1_2; // 由急诊科/ICU集束治疗后转至本院其他科室
    public String getSEP_4_1_2() {  return this.SEP_4_1_2;}
    @JsonProperty("SEP-4-1-2")
    public void setSEP_4_1_2(final String SEP_4_1_2) { this.SEP_4_1_2=SEP_4_1_2;}
    @Column(name = "CM_4_1")
    @JsonProperty("CM-4-1")
    private String CM_4_1; // 住院天数
    public String getCM_4_1() {  return this.CM_4_1;}
    @JsonProperty("CM-4-1")
    public void setCM_4_1(final String CM_4_1) { this.CM_4_1=CM_4_1;}
    @Column(name = "CM_4_2")
    @JsonProperty("CM-4-2")
    private String CM_4_2; // 其中:术后住院天数
    public String getCM_4_2() {  return this.CM_4_2;}
    @JsonProperty("CM-4-2")
    public void setCM_4_2(final String CM_4_2) { this.CM_4_2=CM_4_2;}
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