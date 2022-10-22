package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断ICD-10编码: K85.0-9急性重症胰腺炎的出院患者
*/
@ApiModel(value = "55信息")
@Entity
@Table(name = "sd_info_SAP")
public class SdInfoSAP implements Serializable {
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
    @Column(name = "SAP_0_1_4_1")
    @JsonProperty("SAP-0-1-4-1")
    private String SAP_0_1_4_1; // 其他主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getSAP_0_1_4_1() {  return this.SAP_0_1_4_1;}
    @JsonProperty("SAP-0-1-4-1")
    public void setSAP_0_1_4_1(final String SAP_0_1_4_1) { this.SAP_0_1_4_1=SAP_0_1_4_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "SAP_0_1_4_2")
    @JsonProperty("SAP-0-1-4-2")
    private String SAP_0_1_4_2; // 其他主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getSAP_0_1_4_2() {  return this.SAP_0_1_4_2;}
    @JsonProperty("SAP-0-1-4-2")
    public void setSAP_0_1_4_2(final String SAP_0_1_4_2) { this.SAP_0_1_4_2=SAP_0_1_4_2;}
    @Column(name = "SAP_0_1_5_1")
    @JsonProperty("SAP-0-1-5-1")
    private String SAP_0_1_5_1; // 其他诊断ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_1() {  return this.SAP_0_1_5_1;}
    @JsonProperty("SAP-0-1-5-1")
    public void setSAP_0_1_5_1(final String SAP_0_1_5_1) { this.SAP_0_1_5_1=SAP_0_1_5_1;}
    @Column(name = "SAP_0_1_5_2")
    @JsonProperty("SAP-0-1-5-2")
    private String SAP_0_1_5_2; // 急性肾衰竭ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_2() {  return this.SAP_0_1_5_2;}
    @JsonProperty("SAP-0-1-5-2")
    public void setSAP_0_1_5_2(final String SAP_0_1_5_2) { this.SAP_0_1_5_2=SAP_0_1_5_2;}
    @Column(name = "SAP_0_1_5_3")
    @JsonProperty("SAP-0-1-5-3")
    private String SAP_0_1_5_3; // 心律失常和心功能衰竭ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_3() {  return this.SAP_0_1_5_3;}
    @JsonProperty("SAP-0-1-5-3")
    public void setSAP_0_1_5_3(final String SAP_0_1_5_3) { this.SAP_0_1_5_3=SAP_0_1_5_3;}
    @Column(name = "SAP_0_1_5_4")
    @JsonProperty("SAP-0-1-5-4")
    private String SAP_0_1_5_4; // 消化道出血ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_4() {  return this.SAP_0_1_5_4;}
    @JsonProperty("SAP-0-1-5-4")
    public void setSAP_0_1_5_4(final String SAP_0_1_5_4) { this.SAP_0_1_5_4=SAP_0_1_5_4;}
    @Column(name = "SAP_0_1_5_5")
    @JsonProperty("SAP-0-1-5-5")
    private String SAP_0_1_5_5; // 脓毒血症ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_5() {  return this.SAP_0_1_5_5;}
    @JsonProperty("SAP-0-1-5-5")
    public void setSAP_0_1_5_5(final String SAP_0_1_5_5) { this.SAP_0_1_5_5=SAP_0_1_5_5;}
    @Column(name = "SAP_0_1_5_6")
    @JsonProperty("SAP-0-1-5-6")
    private String SAP_0_1_5_6; // 凝血功能障碍ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_6() {  return this.SAP_0_1_5_6;}
    @JsonProperty("SAP-0-1-5-6")
    public void setSAP_0_1_5_6(final String SAP_0_1_5_6) { this.SAP_0_1_5_6=SAP_0_1_5_6;}
    @Column(name = "SAP_0_1_5_7")
    @JsonProperty("SAP-0-1-5-7")
    private String SAP_0_1_5_7; // 胰性脑病ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_7() {  return this.SAP_0_1_5_7;}
    @JsonProperty("SAP-0-1-5-7")
    public void setSAP_0_1_5_7(final String SAP_0_1_5_7) { this.SAP_0_1_5_7=SAP_0_1_5_7;}
    @Column(name = "SAP_0_1_5_8")
    @JsonProperty("SAP-0-1-5-8")
    private String SAP_0_1_5_8; // 全身的炎症反应ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_8() {  return this.SAP_0_1_5_8;}
    @JsonProperty("SAP-0-1-5-8")
    public void setSAP_0_1_5_8(final String SAP_0_1_5_8) { this.SAP_0_1_5_8=SAP_0_1_5_8;}
    @Column(name = "SAP_0_1_5_9")
    @JsonProperty("SAP-0-1-5-9")
    private String SAP_0_1_5_9; // 急性呼吸窘迫综合征ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_9() {  return this.SAP_0_1_5_9;}
    @JsonProperty("SAP-0-1-5-9")
    public void setSAP_0_1_5_9(final String SAP_0_1_5_9) { this.SAP_0_1_5_9=SAP_0_1_5_9;}
    @Column(name = "SAP_0_1_5_10")
    @JsonProperty("SAP-0-1-5-10")
    private String SAP_0_1_5_10; // 腹腔间隔室综合征ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_10() {  return this.SAP_0_1_5_10;}
    @JsonProperty("SAP-0-1-5-10")
    public void setSAP_0_1_5_10(final String SAP_0_1_5_10) { this.SAP_0_1_5_10=SAP_0_1_5_10;}
    @Column(name = "SAP_0_1_5_12")
    @JsonProperty("SAP-0-1-5-12")
    private String SAP_0_1_5_12; // 急性胰周液体积聚ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_12() {  return this.SAP_0_1_5_12;}
    @JsonProperty("SAP-0-1-5-12")
    public void setSAP_0_1_5_12(final String SAP_0_1_5_12) { this.SAP_0_1_5_12=SAP_0_1_5_12;}
    @Column(name = "SAP_0_1_5_13")
    @JsonProperty("SAP-0-1-5-13")
    private String SAP_0_1_5_13; // 胰腺/胰周感染性坏死ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_13() {  return this.SAP_0_1_5_13;}
    @JsonProperty("SAP-0-1-5-13")
    public void setSAP_0_1_5_13(final String SAP_0_1_5_13) { this.SAP_0_1_5_13=SAP_0_1_5_13;}
    @Column(name = "SAP_0_1_5_14")
    @JsonProperty("SAP-0-1-5-14")
    private String SAP_0_1_5_14; // 其他ICD-10六位临床扩展编码与名称
    public String getSAP_0_1_5_14() {  return this.SAP_0_1_5_14;}
    @JsonProperty("SAP-0-1-5-14")
    public void setSAP_0_1_5_14(final String SAP_0_1_5_14) { this.SAP_0_1_5_14=SAP_0_1_5_14;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为SAP出院后31天内重复住院
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
    @Column(name = "SAP_0_2_1_3")
    @JsonProperty("SAP-0-2-1-3")
    private String SAP_0_2_1_3; // 患者体重kg（卧位，重症）
    public String getSAP_0_2_1_3() {  return this.SAP_0_2_1_3;}
    @JsonProperty("SAP-0-2-1-3")
    public void setSAP_0_2_1_3(final String SAP_0_2_1_3) { this.SAP_0_2_1_3=SAP_0_2_1_3;}
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
    private String CM_0_2_5_1; // 入住RICU/ICU日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开RICU/ICU日期时间
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
    @Column(name = "SAP_1_1_1")
    @JsonProperty("SAP-1-1-1")
    private String SAP_1_1_1; // 是否采用多学科综合治疗协作组（MDT）模式
    public String getSAP_1_1_1() {  return this.SAP_1_1_1;}
    @JsonProperty("SAP-1-1-1")
    public void setSAP_1_1_1(final String SAP_1_1_1) { this.SAP_1_1_1=SAP_1_1_1;}
    @Column(name = "SAP_1_1_2")
    @JsonProperty("SAP-1-1-2")
    private String SAP_1_1_2; // 是否有多学科综合治疗协作组（MDT）讨论记录于住院病历中
    public String getSAP_1_1_2() {  return this.SAP_1_1_2;}
    @JsonProperty("SAP-1-1-2")
    public void setSAP_1_1_2(final String SAP_1_1_2) { this.SAP_1_1_2=SAP_1_1_2;}
    @Column(name = "SAP_1_1_3")
    @JsonProperty("SAP-1-1-3")
    private String SAP_1_1_3; // 参与专业和部门
    public String getSAP_1_1_3() {  return this.SAP_1_1_3;}
    @JsonProperty("SAP-1-1-3")
    public void setSAP_1_1_3(final String SAP_1_1_3) { this.SAP_1_1_3=SAP_1_1_3;}
    @Column(name = "SAP_1_2_1")
    @JsonProperty("SAP-1-2-1")
    private String SAP_1_2_1; // 临床主要症状体征
    public String getSAP_1_2_1() {  return this.SAP_1_2_1;}
    @JsonProperty("SAP-1-2-1")
    public void setSAP_1_2_1(final String SAP_1_2_1) { this.SAP_1_2_1=SAP_1_2_1;}
    @Column(name = "SAP_1_2_2")
    @JsonProperty("SAP-1-2-2")
    private String SAP_1_2_2; // 实验室主要检查
    public String getSAP_1_2_2() {  return this.SAP_1_2_2;}
    @JsonProperty("SAP-1-2-2")
    public void setSAP_1_2_2(final String SAP_1_2_2) { this.SAP_1_2_2=SAP_1_2_2;}
    @Column(name = "SAP_1_2_3")
    @JsonProperty("SAP-1-2-3")
    private String SAP_1_2_3; // 血清淀粉酶检测方式
    public String getSAP_1_2_3() {  return this.SAP_1_2_3;}
    @JsonProperty("SAP-1-2-3")
    public void setSAP_1_2_3(final String SAP_1_2_3) { this.SAP_1_2_3=SAP_1_2_3;}
    @Column(name = "SAP_1_2_3_1")
    @JsonProperty("SAP-1-2-3-1")
    private String SAP_1_2_3_1; // 酶速率法 检测值(U/L)
    public String getSAP_1_2_3_1() {  return this.SAP_1_2_3_1;}
    @JsonProperty("SAP-1-2-3-1")
    public void setSAP_1_2_3_1(final String SAP_1_2_3_1) { this.SAP_1_2_3_1=SAP_1_2_3_1;}
    @Column(name = "SAP_1_2_3_2")
    @JsonProperty("SAP-1-2-3-2")
    private String SAP_1_2_3_2; // 碘比色 检测值(U/L)
    public String getSAP_1_2_3_2() {  return this.SAP_1_2_3_2;}
    @JsonProperty("SAP-1-2-3-2")
    public void setSAP_1_2_3_2(final String SAP_1_2_3_2) { this.SAP_1_2_3_2=SAP_1_2_3_2;}
    @Column(name = "SAP_1_2_3_3")
    @JsonProperty("SAP-1-2-3-3")
    private String SAP_1_2_3_3; // BMD法 检测值(U/L)
    public String getSAP_1_2_3_3() {  return this.SAP_1_2_3_3;}
    @JsonProperty("SAP-1-2-3-3")
    public void setSAP_1_2_3_3(final String SAP_1_2_3_3) { this.SAP_1_2_3_3=SAP_1_2_3_3;}
    @Column(name = "SAP_1_2_4")
    @JsonProperty("SAP-1-2-4")
    private String SAP_1_2_4; // 血清脂肪酶检测方式
    public String getSAP_1_2_4() {  return this.SAP_1_2_4;}
    @JsonProperty("SAP-1-2-4")
    public void setSAP_1_2_4(final String SAP_1_2_4) { this.SAP_1_2_4=SAP_1_2_4;}
    @Column(name = "SAP_1_2_4_1")
    @JsonProperty("SAP-1-2-4-1")
    private String SAP_1_2_4_1; // 滴度法测定值(U/L)
    public String getSAP_1_2_4_1() {  return this.SAP_1_2_4_1;}
    @JsonProperty("SAP-1-2-4-1")
    public void setSAP_1_2_4_1(final String SAP_1_2_4_1) { this.SAP_1_2_4_1=SAP_1_2_4_1;}
    @Column(name = "SAP_1_2_4_2")
    @JsonProperty("SAP-1-2-4-2")
    private String SAP_1_2_4_2; // 比色法测定值(U/L)
    public String getSAP_1_2_4_2() {  return this.SAP_1_2_4_2;}
    @JsonProperty("SAP-1-2-4-2")
    public void setSAP_1_2_4_2(final String SAP_1_2_4_2) { this.SAP_1_2_4_2=SAP_1_2_4_2;}
    @Column(name = "SAP_1_2_5")
    @JsonProperty("SAP-1-2-5")
    private String SAP_1_2_5; // 影像学检查主要阳性征象
    public String getSAP_1_2_5() {  return this.SAP_1_2_5;}
    @JsonProperty("SAP-1-2-5")
    public void setSAP_1_2_5(final String SAP_1_2_5) { this.SAP_1_2_5=SAP_1_2_5;}
    @Column(name = "SAP_1_2_5_1")
    @JsonProperty("SAP-1-2-5-1")
    private String SAP_1_2_5_1; // 其他影像学检查主要阳性征象
    public String getSAP_1_2_5_1() {  return this.SAP_1_2_5_1;}
    @JsonProperty("SAP-1-2-5-1")
    public void setSAP_1_2_5_1(final String SAP_1_2_5_1) { this.SAP_1_2_5_1=SAP_1_2_5_1;}
    @Column(name = "SAP_1_3_1")
    @JsonProperty("SAP-1-3-1")
    private String SAP_1_3_1; // 是否腹部CT检查
    public String getSAP_1_3_1() {  return this.SAP_1_3_1;}
    @JsonProperty("SAP-1-3-1")
    public void setSAP_1_3_1(final String SAP_1_3_1) { this.SAP_1_3_1=SAP_1_3_1;}
    @Column(name = "SAP_1_3_2")
    @JsonProperty("SAP-1-3-2")
    private String SAP_1_3_2; // 腹部CT检查日期时间
    public String getSAP_1_3_2() {  return this.SAP_1_3_2;}
    @JsonProperty("SAP-1-3-2")
    public void setSAP_1_3_2(final String SAP_1_3_2) { this.SAP_1_3_2=SAP_1_3_2;}
    @Column(name = "SAP_1_3_3")
    @JsonProperty("SAP-1-3-3")
    private String SAP_1_3_3; // 腹部CT报告是否有CT严重指数（MCTSI）评估
    public String getSAP_1_3_3() {  return this.SAP_1_3_3;}
    @JsonProperty("SAP-1-3-3")
    public void setSAP_1_3_3(final String SAP_1_3_3) { this.SAP_1_3_3=SAP_1_3_3;}
    @Column(name = "SAP_1_3_4")
    @JsonProperty("SAP-1-3-4")
    private String SAP_1_3_4; // MCTSI分值
    public String getSAP_1_3_4() {  return this.SAP_1_3_4;}
    @JsonProperty("SAP-1-3-4")
    public void setSAP_1_3_4(final String SAP_1_3_4) { this.SAP_1_3_4=SAP_1_3_4;}
    @Column(name = "SAP_1_3_4_1")
    @JsonProperty("SAP-1-3-4-1")
    private String SAP_1_3_4_1; // MCTSI严重指数分层
    public String getSAP_1_3_4_1() {  return this.SAP_1_3_4_1;}
    @JsonProperty("SAP-1-3-4-1")
    public void setSAP_1_3_4_1(final String SAP_1_3_4_1) { this.SAP_1_3_4_1=SAP_1_3_4_1;}
    @Column(name = "SAP_1_3_6")
    @JsonProperty("SAP-1-3-6")
    private String SAP_1_3_6; // 是否进行胰腺炎胰外炎症严重程度（EPIC评分）评估
    public String getSAP_1_3_6() {  return this.SAP_1_3_6;}
    @JsonProperty("SAP-1-3-6")
    public void setSAP_1_3_6(final String SAP_1_3_6) { this.SAP_1_3_6=SAP_1_3_6;}
    @Column(name = "SAP_1_3_7")
    @JsonProperty("SAP-1-3-7")
    private String SAP_1_3_7; // EPIC分值
    public String getSAP_1_3_7() {  return this.SAP_1_3_7;}
    @JsonProperty("SAP-1-3-7")
    public void setSAP_1_3_7(final String SAP_1_3_7) { this.SAP_1_3_7=SAP_1_3_7;}
    @Column(name = "SAP_1_3_8")
    @JsonProperty("SAP-1-3-8")
    private String SAP_1_3_8; // EPIC评分严重程度分层
    public String getSAP_1_3_8() {  return this.SAP_1_3_8;}
    @JsonProperty("SAP-1-3-8")
    public void setSAP_1_3_8(final String SAP_1_3_8) { this.SAP_1_3_8=SAP_1_3_8;}
    @Column(name = "SAP_1_3_9")
    @JsonProperty("SAP-1-3-9")
    private String SAP_1_3_9; // 此次检查报告中并发症的提示
    public String getSAP_1_3_9() {  return this.SAP_1_3_9;}
    @JsonProperty("SAP-1-3-9")
    public void setSAP_1_3_9(final String SAP_1_3_9) { this.SAP_1_3_9=SAP_1_3_9;}
    @Column(name = "SAP_1_3_9_1")
    @JsonProperty("SAP-1-3-9-1")
    private String SAP_1_3_9_1; // 复查报告中其他阳性发现
    public String getSAP_1_3_9_1() {  return this.SAP_1_3_9_1;}
    @JsonProperty("SAP-1-3-9-1")
    public void setSAP_1_3_9_1(final String SAP_1_3_9_1) { this.SAP_1_3_9_1=SAP_1_3_9_1;}
    @Column(name = "SAP_1_3_10")
    @JsonProperty("SAP-1-3-10")
    private String SAP_1_3_10; // 其他影像检查方法
    public String getSAP_1_3_10() {  return this.SAP_1_3_10;}
    @JsonProperty("SAP-1-3-10")
    public void setSAP_1_3_10(final String SAP_1_3_10) { this.SAP_1_3_10=SAP_1_3_10;}
    @Column(name = "SAP_1_3_10_1")
    @JsonProperty("SAP-1-3-10-1")
    private String SAP_1_3_10_1; // 其他检查方法
    public String getSAP_1_3_10_1() {  return this.SAP_1_3_10_1;}
    @JsonProperty("SAP-1-3-10-1")
    public void setSAP_1_3_10_1(final String SAP_1_3_10_1) { this.SAP_1_3_10_1=SAP_1_3_10_1;}
    @Column(name = "SAP_1_3_10_2")
    @JsonProperty("SAP-1-3-10-2")
    private String SAP_1_3_10_2; // 是否发现胆道系统结石
    public String getSAP_1_3_10_2() {  return this.SAP_1_3_10_2;}
    @JsonProperty("SAP-1-3-10-2")
    public void setSAP_1_3_10_2(final String SAP_1_3_10_2) { this.SAP_1_3_10_2=SAP_1_3_10_2;}
    @Column(name = "SAP_1_3_10_3")
    @JsonProperty("SAP-1-3-10-3")
    private String SAP_1_3_10_3; // 其他影像学检查日期时间
    public String getSAP_1_3_10_3() {  return this.SAP_1_3_10_3;}
    @JsonProperty("SAP-1-3-10-3")
    public void setSAP_1_3_10_3(final String SAP_1_3_10_3) { this.SAP_1_3_10_3=SAP_1_3_10_3;}
    @Column(name = "SAP_1_4_1")
    @JsonProperty("SAP-1-4-1")
    private String SAP_1_4_1; // 是否进行严重程度的分级评估
    public String getSAP_1_4_1() {  return this.SAP_1_4_1;}
    @JsonProperty("SAP-1-4-1")
    public void setSAP_1_4_1(final String SAP_1_4_1) { this.SAP_1_4_1=SAP_1_4_1;}
    @Column(name = "SAP_1_4_1_1")
    @JsonProperty("SAP-1-4-1-1")
    private String SAP_1_4_1_1; // 首次床旁AP严重度BISAP评分值
    public String getSAP_1_4_1_1() {  return this.SAP_1_4_1_1;}
    @JsonProperty("SAP-1-4-1-1")
    public void setSAP_1_4_1_1(final String SAP_1_4_1_1) { this.SAP_1_4_1_1=SAP_1_4_1_1;}
    @Column(name = "SAP_1_4_1_2")
    @JsonProperty("SAP-1-4-1-2")
    private String SAP_1_4_1_2; // 床旁AP严重度评分值（BISAP）分层
    public String getSAP_1_4_1_2() {  return this.SAP_1_4_1_2;}
    @JsonProperty("SAP-1-4-1-2")
    public void setSAP_1_4_1_2(final String SAP_1_4_1_2) { this.SAP_1_4_1_2=SAP_1_4_1_2;}
    @Column(name = "SAP_1_4_1_3")
    @JsonProperty("SAP-1-4-1-3")
    private String SAP_1_4_1_3; // BISAP评分日期时间
    public String getSAP_1_4_1_3() {  return this.SAP_1_4_1_3;}
    @JsonProperty("SAP-1-4-1-3")
    public void setSAP_1_4_1_3(final String SAP_1_4_1_3) { this.SAP_1_4_1_3=SAP_1_4_1_3;}
    @Column(name = "SAP_1_4_2")
    @JsonProperty("SAP-1-4-2")
    private String SAP_1_4_2; // 是否入院后24h床旁AP严重度再评分
    public String getSAP_1_4_2() {  return this.SAP_1_4_2;}
    @JsonProperty("SAP-1-4-2")
    public void setSAP_1_4_2(final String SAP_1_4_2) { this.SAP_1_4_2=SAP_1_4_2;}
    @Column(name = "SAP_1_4_2_1")
    @JsonProperty("SAP-1-4-2-1")
    private String SAP_1_4_2_1; // 床旁AP严重度BISAP评分值
    public String getSAP_1_4_2_1() {  return this.SAP_1_4_2_1;}
    @JsonProperty("SAP-1-4-2-1")
    public void setSAP_1_4_2_1(final String SAP_1_4_2_1) { this.SAP_1_4_2_1=SAP_1_4_2_1;}
    @Column(name = "SAP_1_4_2_2")
    @JsonProperty("SAP-1-4-2-2")
    private String SAP_1_4_2_2; // 床旁AP严重度评分值（BISAP）分层
    public String getSAP_1_4_2_2() {  return this.SAP_1_4_2_2;}
    @JsonProperty("SAP-1-4-2-2")
    public void setSAP_1_4_2_2(final String SAP_1_4_2_2) { this.SAP_1_4_2_2=SAP_1_4_2_2;}
    @Column(name = "SAP_1_4_2_3")
    @JsonProperty("SAP-1-4-2-3")
    private String SAP_1_4_2_3; // BISAP评分日期时间
    public String getSAP_1_4_2_3() {  return this.SAP_1_4_2_3;}
    @JsonProperty("SAP-1-4-2-3")
    public void setSAP_1_4_2_3(final String SAP_1_4_2_3) { this.SAP_1_4_2_3=SAP_1_4_2_3;}
    @Column(name = "SAP_1_4_2_4")
    @JsonProperty("SAP-1-4-2-4")
    private String SAP_1_4_2_4; // 是否入院后24h床旁AP严重度再评分
    public String getSAP_1_4_2_4() {  return this.SAP_1_4_2_4;}
    @JsonProperty("SAP-1-4-2-4")
    public void setSAP_1_4_2_4(final String SAP_1_4_2_4) { this.SAP_1_4_2_4=SAP_1_4_2_4;}
    @Column(name = "SAP_1_4_2_5")
    @JsonProperty("SAP-1-4-2-5")
    private String SAP_1_4_2_5; // 床旁AP严重度评分（BISAP）评分值
    public String getSAP_1_4_2_5() {  return this.SAP_1_4_2_5;}
    @JsonProperty("SAP-1-4-2-5")
    public void setSAP_1_4_2_5(final String SAP_1_4_2_5) { this.SAP_1_4_2_5=SAP_1_4_2_5;}
    @Column(name = "SAP_1_4_2_6")
    @JsonProperty("SAP-1-4-2-6")
    private String SAP_1_4_2_6; // 床旁AP严重度评分值（BISAP）分层
    public String getSAP_1_4_2_6() {  return this.SAP_1_4_2_6;}
    @JsonProperty("SAP-1-4-2-6")
    public void setSAP_1_4_2_6(final String SAP_1_4_2_6) { this.SAP_1_4_2_6=SAP_1_4_2_6;}
    @Column(name = "SAP_1_4_2_7")
    @JsonProperty("SAP-1-4-2-7")
    private String SAP_1_4_2_7; // BISAP评分日期时间
    public String getSAP_1_4_2_7() {  return this.SAP_1_4_2_7;}
    @JsonProperty("SAP-1-4-2-7")
    public void setSAP_1_4_2_7(final String SAP_1_4_2_7) { this.SAP_1_4_2_7=SAP_1_4_2_7;}
    @Column(name = "SAP_1_4_3")
    @JsonProperty("SAP-1-4-3")
    private String SAP_1_4_3; // 是否APACHE Ⅱ评分  
    public String getSAP_1_4_3() {  return this.SAP_1_4_3;}
    @JsonProperty("SAP-1-4-3")
    public void setSAP_1_4_3(final String SAP_1_4_3) { this.SAP_1_4_3=SAP_1_4_3;}
    @Column(name = "SAP_1_4_3_2")
    @JsonProperty("SAP-1-4-3-2")
    private String SAP_1_4_3_2; // 第一部分 急性生理学评分值
    public String getSAP_1_4_3_2() {  return this.SAP_1_4_3_2;}
    @JsonProperty("SAP-1-4-3-2")
    public void setSAP_1_4_3_2(final String SAP_1_4_3_2) { this.SAP_1_4_3_2=SAP_1_4_3_2;}
    @Column(name = "SAP_1_4_3_3")
    @JsonProperty("SAP-1-4-3-3")
    private String SAP_1_4_3_3; // 第二部分 年龄及慢性健康状况评分值
    public String getSAP_1_4_3_3() {  return this.SAP_1_4_3_3;}
    @JsonProperty("SAP-1-4-3-3")
    public void setSAP_1_4_3_3(final String SAP_1_4_3_3) { this.SAP_1_4_3_3=SAP_1_4_3_3;}
    @Column(name = "SAP_1_4_3_4")
    @JsonProperty("SAP-1-4-3-4")
    private String SAP_1_4_3_4; // 第三部分 Glasgow 昏迷评分值
    public String getSAP_1_4_3_4() {  return this.SAP_1_4_3_4;}
    @JsonProperty("SAP-1-4-3-4")
    public void setSAP_1_4_3_4(final String SAP_1_4_3_4) { this.SAP_1_4_3_4=SAP_1_4_3_4;}
    @Column(name = "SAP_1_4_3_3_r")
    @JsonProperty("SAP-1-4-3-3-r")
    private String SAP_1_4_3_3_r; // 15-GCS评分
    public String getSAP_1_4_3_3_r() {  return this.SAP_1_4_3_3_r;}
    @JsonProperty("SAP-1-4-3-3-r")
    public void setSAP_1_4_3_3_r(final String SAP_1_4_3_3_r) { this.SAP_1_4_3_3_r=SAP_1_4_3_3_r;}
    @Column(name = "SAP_1_4_3_1")
    @JsonProperty("SAP-1-4-3-1")
    private String SAP_1_4_3_1; // 合计：APACHE-Ⅱ 评分值
    public String getSAP_1_4_3_1() {  return this.SAP_1_4_3_1;}
    @JsonProperty("SAP-1-4-3-1")
    public void setSAP_1_4_3_1(final String SAP_1_4_3_1) { this.SAP_1_4_3_1=SAP_1_4_3_1;}
    @Column(name = "SAP_1_4_3_5")
    @JsonProperty("SAP-1-4-3-5")
    private String SAP_1_4_3_5; // APACHE Ⅱ评分严重分层
    public String getSAP_1_4_3_5() {  return this.SAP_1_4_3_5;}
    @JsonProperty("SAP-1-4-3-5")
    public void setSAP_1_4_3_5(final String SAP_1_4_3_5) { this.SAP_1_4_3_5=SAP_1_4_3_5;}
    @Column(name = "SAP_1_4_3_6")
    @JsonProperty("SAP-1-4-3-6")
    private String SAP_1_4_3_6; // APACHE Ⅱ评分日期时间
    public String getSAP_1_4_3_6() {  return this.SAP_1_4_3_6;}
    @JsonProperty("SAP-1-4-3-6")
    public void setSAP_1_4_3_6(final String SAP_1_4_3_6) { this.SAP_1_4_3_6=SAP_1_4_3_6;}
    @Column(name = "SAP_1_4_4")
    @JsonProperty("SAP-1-4-4")
    private String SAP_1_4_4; // 是否实施Ranson评估
    public String getSAP_1_4_4() {  return this.SAP_1_4_4;}
    @JsonProperty("SAP-1-4-4")
    public void setSAP_1_4_4(final String SAP_1_4_4) { this.SAP_1_4_4=SAP_1_4_4;}
    @Column(name = "SAP_1_4_4_1")
    @JsonProperty("SAP-1-4-4-1")
    private String SAP_1_4_4_1; // 入院时 Ranson评分值
    public String getSAP_1_4_4_1() {  return this.SAP_1_4_4_1;}
    @JsonProperty("SAP-1-4-4-1")
    public void setSAP_1_4_4_1(final String SAP_1_4_4_1) { this.SAP_1_4_4_1=SAP_1_4_4_1;}
    @Column(name = "SAP_1_4_4_2")
    @JsonProperty("SAP-1-4-4-2")
    private String SAP_1_4_4_2; // 入院时 Ranson评分日期时间
    public String getSAP_1_4_4_2() {  return this.SAP_1_4_4_2;}
    @JsonProperty("SAP-1-4-4-2")
    public void setSAP_1_4_4_2(final String SAP_1_4_4_2) { this.SAP_1_4_4_2=SAP_1_4_4_2;}
    @Column(name = "SAP_1_4_4_3")
    @JsonProperty("SAP-1-4-4-3")
    private String SAP_1_4_4_3; // 入院后第一个24小时 Ranson评分值
    public String getSAP_1_4_4_3() {  return this.SAP_1_4_4_3;}
    @JsonProperty("SAP-1-4-4-3")
    public void setSAP_1_4_4_3(final String SAP_1_4_4_3) { this.SAP_1_4_4_3=SAP_1_4_4_3;}
    @Column(name = "SAP_1_4_4_4")
    @JsonProperty("SAP-1-4-4-4")
    private String SAP_1_4_4_4; // 入院后第一个24小时 Ranson评分日期时间
    public String getSAP_1_4_4_4() {  return this.SAP_1_4_4_4;}
    @JsonProperty("SAP-1-4-4-4")
    public void setSAP_1_4_4_4(final String SAP_1_4_4_4) { this.SAP_1_4_4_4=SAP_1_4_4_4;}
    @Column(name = "SAP_1_5_1")
    @JsonProperty("SAP-1-5-1")
    private String SAP_1_5_1; // 是否进行严重程度的分级评估
    public String getSAP_1_5_1() {  return this.SAP_1_5_1;}
    @JsonProperty("SAP-1-5-1")
    public void setSAP_1_5_1(final String SAP_1_5_1) { this.SAP_1_5_1=SAP_1_5_1;}
    @Column(name = "SAP_1_5_2_2")
    @JsonProperty("SAP-1-5-2-2")
    private String SAP_1_5_2_2; // 第一部分 呼吸系统(氧合指数)分值
    public String getSAP_1_5_2_2() {  return this.SAP_1_5_2_2;}
    @JsonProperty("SAP-1-5-2-2")
    public void setSAP_1_5_2_2(final String SAP_1_5_2_2) { this.SAP_1_5_2_2=SAP_1_5_2_2;}
    @Column(name = "SAP_1_5_2_3")
    @JsonProperty("SAP-1-5-2-3")
    private String SAP_1_5_2_3; // 第二部分 肾脏(血肌酐)分值
    public String getSAP_1_5_2_3() {  return this.SAP_1_5_2_3;}
    @JsonProperty("SAP-1-5-2-3")
    public void setSAP_1_5_2_3(final String SAP_1_5_2_3) { this.SAP_1_5_2_3=SAP_1_5_2_3;}
    @Column(name = "SAP_1_5_2_4")
    @JsonProperty("SAP-1-5-2-4")
    private String SAP_1_5_2_4; // 第三部分 心血管系统(收缩压)分值
    public String getSAP_1_5_2_4() {  return this.SAP_1_5_2_4;}
    @JsonProperty("SAP-1-5-2-4")
    public void setSAP_1_5_2_4(final String SAP_1_5_2_4) { this.SAP_1_5_2_4=SAP_1_5_2_4;}
    @Column(name = "SAP_1_5_2_r")
    @JsonProperty("SAP-1-5-2-r")
    private String SAP_1_5_2_r; // Marshall 指数值总分
    public String getSAP_1_5_2_r() {  return this.SAP_1_5_2_r;}
    @JsonProperty("SAP-1-5-2-r")
    public void setSAP_1_5_2_r(final String SAP_1_5_2_r) { this.SAP_1_5_2_r=SAP_1_5_2_r;}
    @Column(name = "SAP_1_5_2_1")
    @JsonProperty("SAP-1-5-2-1")
    private String SAP_1_5_2_1; // 合计：Marshall 评分值
    public String getSAP_1_5_2_1() {  return this.SAP_1_5_2_1;}
    @JsonProperty("SAP-1-5-2-1")
    public void setSAP_1_5_2_1(final String SAP_1_5_2_1) { this.SAP_1_5_2_1=SAP_1_5_2_1;}
    @Column(name = "SAP_1_5_2_5")
    @JsonProperty("SAP-1-5-2-5")
    private String SAP_1_5_2_5; // Marshall 指数值的分层
    public String getSAP_1_5_2_5() {  return this.SAP_1_5_2_5;}
    @JsonProperty("SAP-1-5-2-5")
    public void setSAP_1_5_2_5(final String SAP_1_5_2_5) { this.SAP_1_5_2_5=SAP_1_5_2_5;}
    @Column(name = "SAP_1_5_2_6")
    @JsonProperty("SAP-1-5-2-6")
    private String SAP_1_5_2_6; // Atlanta分级（RAC）结论
    public String getSAP_1_5_2_6() {  return this.SAP_1_5_2_6;}
    @JsonProperty("SAP-1-5-2-6")
    public void setSAP_1_5_2_6(final String SAP_1_5_2_6) { this.SAP_1_5_2_6=SAP_1_5_2_6;}
    @Column(name = "SAP_1_5_2_7")
    @JsonProperty("SAP-1-5-2-7")
    private String SAP_1_5_2_7; // Marshall评估日期时间
    public String getSAP_1_5_2_7() {  return this.SAP_1_5_2_7;}
    @JsonProperty("SAP-1-5-2-7")
    public void setSAP_1_5_2_7(final String SAP_1_5_2_7) { this.SAP_1_5_2_7=SAP_1_5_2_7;}
    @Column(name = "SAP_1_5_3_2")
    @JsonProperty("SAP-1-5-3-2")
    private String SAP_1_5_3_2; // 第一部分：呼吸系统评分值
    public String getSAP_1_5_3_2() {  return this.SAP_1_5_3_2;}
    @JsonProperty("SAP-1-5-3-2")
    public void setSAP_1_5_3_2(final String SAP_1_5_3_2) { this.SAP_1_5_3_2=SAP_1_5_3_2;}
    @Column(name = "SAP_1_5_3_3")
    @JsonProperty("SAP-1-5-3-3")
    private String SAP_1_5_3_3; // 第二部分：血液系统评分值
    public String getSAP_1_5_3_3() {  return this.SAP_1_5_3_3;}
    @JsonProperty("SAP-1-5-3-3")
    public void setSAP_1_5_3_3(final String SAP_1_5_3_3) { this.SAP_1_5_3_3=SAP_1_5_3_3;}
    @Column(name = "SAP_1_5_3_4")
    @JsonProperty("SAP-1-5-3-4")
    private String SAP_1_5_3_4; // 第三部分：肝脏评分值
    public String getSAP_1_5_3_4() {  return this.SAP_1_5_3_4;}
    @JsonProperty("SAP-1-5-3-4")
    public void setSAP_1_5_3_4(final String SAP_1_5_3_4) { this.SAP_1_5_3_4=SAP_1_5_3_4;}
    @Column(name = "SAP_1_5_3_5")
    @JsonProperty("SAP-1-5-3-5")
    private String SAP_1_5_3_5; // 第四部分：心血管系统评分值
    public String getSAP_1_5_3_5() {  return this.SAP_1_5_3_5;}
    @JsonProperty("SAP-1-5-3-5")
    public void setSAP_1_5_3_5(final String SAP_1_5_3_5) { this.SAP_1_5_3_5=SAP_1_5_3_5;}
    @Column(name = "SAP_1_5_3_6")
    @JsonProperty("SAP-1-5-3-6")
    private String SAP_1_5_3_6; // 第五部分：中枢神经系统评分值
    public String getSAP_1_5_3_6() {  return this.SAP_1_5_3_6;}
    @JsonProperty("SAP-1-5-3-6")
    public void setSAP_1_5_3_6(final String SAP_1_5_3_6) { this.SAP_1_5_3_6=SAP_1_5_3_6;}
    @Column(name = "SAP_1_5_3_7")
    @JsonProperty("SAP-1-5-3-7")
    private String SAP_1_5_3_7; // 第六部分：肾脏评分值
    public String getSAP_1_5_3_7() {  return this.SAP_1_5_3_7;}
    @JsonProperty("SAP-1-5-3-7")
    public void setSAP_1_5_3_7(final String SAP_1_5_3_7) { this.SAP_1_5_3_7=SAP_1_5_3_7;}
    @Column(name = "SAP_1_5_3_1")
    @JsonProperty("SAP-1-5-3-1")
    private String SAP_1_5_3_1; // 合计：SOFA 评分值
    public String getSAP_1_5_3_1() {  return this.SAP_1_5_3_1;}
    @JsonProperty("SAP-1-5-3-1")
    public void setSAP_1_5_3_1(final String SAP_1_5_3_1) { this.SAP_1_5_3_1=SAP_1_5_3_1;}
    @Column(name = "SAP_1_5_3_8")
    @JsonProperty("SAP-1-5-3-8")
    private String SAP_1_5_3_8; // SOFA 评分结果分层
    public String getSAP_1_5_3_8() {  return this.SAP_1_5_3_8;}
    @JsonProperty("SAP-1-5-3-8")
    public void setSAP_1_5_3_8(final String SAP_1_5_3_8) { this.SAP_1_5_3_8=SAP_1_5_3_8;}
    @Column(name = "SAP_1_5_3_10")
    @JsonProperty("SAP-1-5-3-10")
    private String SAP_1_5_3_10; // Atlanta分级（DBC）结论
    public String getSAP_1_5_3_10() {  return this.SAP_1_5_3_10;}
    @JsonProperty("SAP-1-5-3-10")
    public void setSAP_1_5_3_10(final String SAP_1_5_3_10) { this.SAP_1_5_3_10=SAP_1_5_3_10;}
    @Column(name = "SAP_1_5_3_9")
    @JsonProperty("SAP-1-5-3-9")
    private String SAP_1_5_3_9; // Atlanta评估日期时间
    public String getSAP_1_5_3_9() {  return this.SAP_1_5_3_9;}
    @JsonProperty("SAP-1-5-3-9")
    public void setSAP_1_5_3_9(final String SAP_1_5_3_9) { this.SAP_1_5_3_9=SAP_1_5_3_9;}
    @Column(name = "SAP_2_1_1")
    @JsonProperty("SAP-2-1-1")
    private String SAP_2_1_1; // 是否给予液体治疗
    public String getSAP_2_1_1() {  return this.SAP_2_1_1;}
    @JsonProperty("SAP-2-1-1")
    public void setSAP_2_1_1(final String SAP_2_1_1) { this.SAP_2_1_1=SAP_2_1_1;}
    @Column(name = "SAP_2_1_2")
    @JsonProperty("SAP-2-1-2")
    private String SAP_2_1_2; // 液体治疗起始日期时间
    public String getSAP_2_1_2() {  return this.SAP_2_1_2;}
    @JsonProperty("SAP-2-1-2")
    public void setSAP_2_1_2(final String SAP_2_1_2) { this.SAP_2_1_2=SAP_2_1_2;}
    @Column(name = "SAP_2_1_3_1")
    @JsonProperty("SAP-2-1-3-1")
    private String SAP_2_1_3_1; // 静脉补给复苏液体总量是否无法确定或无记录
    public String getSAP_2_1_3_1() {  return this.SAP_2_1_3_1;}
    @JsonProperty("SAP-2-1-3-1")
    public void setSAP_2_1_3_1(final String SAP_2_1_3_1) { this.SAP_2_1_3_1=SAP_2_1_3_1;}
    @Column(name = "SAP_2_1_3_2")
    @JsonProperty("SAP-2-1-3-2")
    private String SAP_2_1_3_2; // 时间窗(24H)内经静脉补给复苏液体总量(ml)
    public String getSAP_2_1_3_2() {  return this.SAP_2_1_3_2;}
    @JsonProperty("SAP-2-1-3-2")
    public void setSAP_2_1_3_2(final String SAP_2_1_3_2) { this.SAP_2_1_3_2=SAP_2_1_3_2;}
    @Column(name = "SAP_2_1_4_1")
    @JsonProperty("SAP-2-1-4-1")
    private String SAP_2_1_4_1; // 液体治疗时患者体重是否无法确定或无记录
    public String getSAP_2_1_4_1() {  return this.SAP_2_1_4_1;}
    @JsonProperty("SAP-2-1-4-1")
    public void setSAP_2_1_4_1(final String SAP_2_1_4_1) { this.SAP_2_1_4_1=SAP_2_1_4_1;}
    @Column(name = "SAP_2_1_4_2")
    @JsonProperty("SAP-2-1-4-2")
    private String SAP_2_1_4_2; // 患者体重(kg)
    public String getSAP_2_1_4_2() {  return this.SAP_2_1_4_2;}
    @JsonProperty("SAP-2-1-4-2")
    public void setSAP_2_1_4_2(final String SAP_2_1_4_2) { this.SAP_2_1_4_2=SAP_2_1_4_2;}
    @Column(name = "SAP_2_1_5")
    @JsonProperty("SAP-2-1-5")
    private String SAP_2_1_5; // 初始首选液体的种类
    public String getSAP_2_1_5() {  return this.SAP_2_1_5;}
    @JsonProperty("SAP-2-1-5")
    public void setSAP_2_1_5(final String SAP_2_1_5) { this.SAP_2_1_5=SAP_2_1_5;}
    @Column(name = "SAP_2_1_6")
    @JsonProperty("SAP-2-1-6")
    private String SAP_2_1_6; // 是否对液体复苏后的病情评估
    public String getSAP_2_1_6() {  return this.SAP_2_1_6;}
    @JsonProperty("SAP-2-1-6")
    public void setSAP_2_1_6(final String SAP_2_1_6) { this.SAP_2_1_6=SAP_2_1_6;}
    @Column(name = "SAP_2_1_7")
    @JsonProperty("SAP-2-1-7")
    private String SAP_2_1_7; // 液体复苏后评估的要素
    public String getSAP_2_1_7() {  return this.SAP_2_1_7;}
    @JsonProperty("SAP-2-1-7")
    public void setSAP_2_1_7(final String SAP_2_1_7) { this.SAP_2_1_7=SAP_2_1_7;}
    @Column(name = "SAP_2_1_7_1")
    @JsonProperty("SAP-2-1-7-1")
    private String SAP_2_1_7_1; // 中心静脉压（CVP）(mmHg)
    public String getSAP_2_1_7_1() {  return this.SAP_2_1_7_1;}
    @JsonProperty("SAP-2-1-7-1")
    public void setSAP_2_1_7_1(final String SAP_2_1_7_1) { this.SAP_2_1_7_1=SAP_2_1_7_1;}
    @Column(name = "SAP_2_1_7_2")
    @JsonProperty("SAP-2-1-7-2")
    private String SAP_2_1_7_2; // 平均动脉压(mmHg)
    public String getSAP_2_1_7_2() {  return this.SAP_2_1_7_2;}
    @JsonProperty("SAP-2-1-7-2")
    public void setSAP_2_1_7_2(final String SAP_2_1_7_2) { this.SAP_2_1_7_2=SAP_2_1_7_2;}
    @Column(name = "SAP_2_1_7_3")
    @JsonProperty("SAP-2-1-7-3")
    private String SAP_2_1_7_3; // 每小时尿量(mL)
    public String getSAP_2_1_7_3() {  return this.SAP_2_1_7_3;}
    @JsonProperty("SAP-2-1-7-3")
    public void setSAP_2_1_7_3(final String SAP_2_1_7_3) { this.SAP_2_1_7_3=SAP_2_1_7_3;}
    @Column(name = "SAP_2_1_7_4")
    @JsonProperty("SAP-2-1-7-4")
    private String SAP_2_1_7_4; // 红细胞压积(%)
    public String getSAP_2_1_7_4() {  return this.SAP_2_1_7_4;}
    @JsonProperty("SAP-2-1-7-4")
    public void setSAP_2_1_7_4(final String SAP_2_1_7_4) { this.SAP_2_1_7_4=SAP_2_1_7_4;}
    @Column(name = "SAP_2_1_7_5")
    @JsonProperty("SAP-2-1-7-5")
    private String SAP_2_1_7_5; // 尿素氮(mmol/L)
    public String getSAP_2_1_7_5() {  return this.SAP_2_1_7_5;}
    @JsonProperty("SAP-2-1-7-5")
    public void setSAP_2_1_7_5(final String SAP_2_1_7_5) { this.SAP_2_1_7_5=SAP_2_1_7_5;}
    @Column(name = "SAP_2_1_7_6")
    @JsonProperty("SAP-2-1-7-6")
    private String SAP_2_1_7_6; // 血浆乳酸(mmol/L)
    public String getSAP_2_1_7_6() {  return this.SAP_2_1_7_6;}
    @JsonProperty("SAP-2-1-7-6")
    public void setSAP_2_1_7_6(final String SAP_2_1_7_6) { this.SAP_2_1_7_6=SAP_2_1_7_6;}
    @Column(name = "SAP_2_1_7_7")
    @JsonProperty("SAP-2-1-7-7")
    private String SAP_2_1_7_7; // 混合静脉血氧饱和度(%)
    public String getSAP_2_1_7_7() {  return this.SAP_2_1_7_7;}
    @JsonProperty("SAP-2-1-7-7")
    public void setSAP_2_1_7_7(final String SAP_2_1_7_7) { this.SAP_2_1_7_7=SAP_2_1_7_7;}
    @Column(name = "SAP_2_1_8")
    @JsonProperty("SAP-2-1-8")
    private String SAP_2_1_8; // 液体复苏状态评估
    public String getSAP_2_1_8() {  return this.SAP_2_1_8;}
    @JsonProperty("SAP-2-1-8")
    public void setSAP_2_1_8(final String SAP_2_1_8) { this.SAP_2_1_8=SAP_2_1_8;}
    @Column(name = "SAP_2_1_9")
    @JsonProperty("SAP-2-1-9")
    private String SAP_2_1_9; // 评估日期时间
    public String getSAP_2_1_9() {  return this.SAP_2_1_9;}
    @JsonProperty("SAP-2-1-9")
    public void setSAP_2_1_9(final String SAP_2_1_9) { this.SAP_2_1_9=SAP_2_1_9;}
    @Column(name = "CM_8_1_1")
    @JsonProperty("CM-8-1-1")
    private String CM_8_1_1; // 是否进行疼痛强度评估
    public String getCM_8_1_1() {  return this.CM_8_1_1;}
    @JsonProperty("CM-8-1-1")
    public void setCM_8_1_1(final String CM_8_1_1) { this.CM_8_1_1=CM_8_1_1;}
    @Column(name = "CM_8_1_2")
    @JsonProperty("CM-8-1-2")
    private String CM_8_1_2; // 疼痛强度评估方法的选择
    public String getCM_8_1_2() {  return this.CM_8_1_2;}
    @JsonProperty("CM-8-1-2")
    public void setCM_8_1_2(final String CM_8_1_2) { this.CM_8_1_2=CM_8_1_2;}
    @Column(name = "CM_8_1_3")
    @JsonProperty("CM-8-1-3")
    private String CM_8_1_3; // 其他疼痛强度评估方法
    public String getCM_8_1_3() {  return this.CM_8_1_3;}
    @JsonProperty("CM-8-1-3")
    public void setCM_8_1_3(final String CM_8_1_3) { this.CM_8_1_3=CM_8_1_3;}
    @Column(name = "CM_8_1_4")
    @JsonProperty("CM-8-1-4")
    private String CM_8_1_4; // 疼痛强度
    public String getCM_8_1_4() {  return this.CM_8_1_4;}
    @JsonProperty("CM-8-1-4")
    public void setCM_8_1_4(final String CM_8_1_4) { this.CM_8_1_4=CM_8_1_4;}
    @Column(name = "SAP_2_2_1")
    @JsonProperty("SAP-2-2-1")
    private String SAP_2_2_1; // 是否使用镇痛药物
    public String getSAP_2_2_1() {  return this.SAP_2_2_1;}
    @JsonProperty("SAP-2-2-1")
    public void setSAP_2_2_1(final String SAP_2_2_1) { this.SAP_2_2_1=SAP_2_2_1;}
    @Column(name = "SAP_2_2_3")
    @JsonProperty("SAP-2-2-3")
    private String SAP_2_2_3; // 使用阿片类药物还是非阿片类药物
    public String getSAP_2_2_3() {  return this.SAP_2_2_3;}
    @JsonProperty("SAP-2-2-3")
    public void setSAP_2_2_3(final String SAP_2_2_3) { this.SAP_2_2_3=SAP_2_2_3;}
    @Column(name = "CM_8_3_1")
    @JsonProperty("CM-8-3-1")
    private String CM_8_3_1; // 阿片类常用镇痛药物的选择
    public String getCM_8_3_1() {  return this.CM_8_3_1;}
    @JsonProperty("CM-8-3-1")
    public void setCM_8_3_1(final String CM_8_3_1) { this.CM_8_3_1=CM_8_3_1;}
    @Column(name = "CM_8_3_2")
    @JsonProperty("CM-8-3-2")
    private String CM_8_3_2; // 非阿片类常用镇痛药的选择
    public String getCM_8_3_2() {  return this.CM_8_3_2;}
    @JsonProperty("CM-8-3-2")
    public void setCM_8_3_2(final String CM_8_3_2) { this.CM_8_3_2=CM_8_3_2;}
    @Column(name = "CM_8_4_1")
    @JsonProperty("CM-8-4-1")
    private String CM_8_4_1; // 常用给药方法与途径的选择
    public String getCM_8_4_1() {  return this.CM_8_4_1;}
    @JsonProperty("CM-8-4-1")
    public void setCM_8_4_1(final String CM_8_4_1) { this.CM_8_4_1=CM_8_4_1;}
    @Column(name = "CM_8_4_1_1")
    @JsonProperty("CM-8-4-1-1")
    private String CM_8_4_1_1; // 静脉给药
    public String getCM_8_4_1_1() {  return this.CM_8_4_1_1;}
    @JsonProperty("CM-8-4-1-1")
    public void setCM_8_4_1_1(final String CM_8_4_1_1) { this.CM_8_4_1_1=CM_8_4_1_1;}
    @Column(name = "CM_8_4_1_2")
    @JsonProperty("CM-8-4-1-2")
    private String CM_8_4_1_2; // 中枢神经阻滞
    public String getCM_8_4_1_2() {  return this.CM_8_4_1_2;}
    @JsonProperty("CM-8-4-1-2")
    public void setCM_8_4_1_2(final String CM_8_4_1_2) { this.CM_8_4_1_2=CM_8_4_1_2;}
    @Column(name = "CM_8_4_1_3")
    @JsonProperty("CM-8-4-1-3")
    private String CM_8_4_1_3; // 外周神经阻滞
    public String getCM_8_4_1_3() {  return this.CM_8_4_1_3;}
    @JsonProperty("CM-8-4-1-3")
    public void setCM_8_4_1_3(final String CM_8_4_1_3) { this.CM_8_4_1_3=CM_8_4_1_3;}
    @Column(name = "CM_8_4_1_4")
    @JsonProperty("CM-8-4-1-4")
    private String CM_8_4_1_4; // 其他神经阻滞
    public String getCM_8_4_1_4() {  return this.CM_8_4_1_4;}
    @JsonProperty("CM-8-4-1-4")
    public void setCM_8_4_1_4(final String CM_8_4_1_4) { this.CM_8_4_1_4=CM_8_4_1_4;}
    @Column(name = "CM_8_4_1_5")
    @JsonProperty("CM-8-4-1-5")
    private String CM_8_4_1_5; // 患者自控镇痛(PCA)
    public String getCM_8_4_1_5() {  return this.CM_8_4_1_5;}
    @JsonProperty("CM-8-4-1-5")
    public void setCM_8_4_1_5(final String CM_8_4_1_5) { this.CM_8_4_1_5=CM_8_4_1_5;}
    @Column(name = "CM_8_4_1_6")
    @JsonProperty("CM-8-4-1-6")
    private String CM_8_4_1_6; // 其他患者自控镇痛
    public String getCM_8_4_1_6() {  return this.CM_8_4_1_6;}
    @JsonProperty("CM-8-4-1-6")
    public void setCM_8_4_1_6(final String CM_8_4_1_6) { this.CM_8_4_1_6=CM_8_4_1_6;}
    @Column(name = "SAP_2_2_2")
    @JsonProperty("SAP-2-2-2")
    private String SAP_2_2_2; // 接受首剂镇痛治疗日期时间
    public String getSAP_2_2_2() {  return this.SAP_2_2_2;}
    @JsonProperty("SAP-2-2-2")
    public void setSAP_2_2_2(final String SAP_2_2_2) { this.SAP_2_2_2=SAP_2_2_2;}
    @Column(name = "SAP_2_3_1")
    @JsonProperty("SAP-2-3-1")
    private String SAP_2_3_1; // 是否用NRS-2002营养评估进行营养风险筛查
    public String getSAP_2_3_1() {  return this.SAP_2_3_1;}
    @JsonProperty("SAP-2-3-1")
    public void setSAP_2_3_1(final String SAP_2_3_1) { this.SAP_2_3_1=SAP_2_3_1;}
    @Column(name = "SAP_2_3_2_1")
    @JsonProperty("SAP-2-3-2-1")
    private String SAP_2_3_2_1; // 筛查日期时间
    public String getSAP_2_3_2_1() {  return this.SAP_2_3_2_1;}
    @JsonProperty("SAP-2-3-2-1")
    public void setSAP_2_3_2_1(final String SAP_2_3_2_1) { this.SAP_2_3_2_1=SAP_2_3_2_1;}
    @Column(name = "SAP_2_3_2_2")
    @JsonProperty("SAP-2-3-2-2")
    private String SAP_2_3_2_2; // NRS-2002营养风险筛查分值
    public String getSAP_2_3_2_2() {  return this.SAP_2_3_2_2;}
    @JsonProperty("SAP-2-3-2-2")
    public void setSAP_2_3_2_2(final String SAP_2_3_2_2) { this.SAP_2_3_2_2=SAP_2_3_2_2;}
    @Column(name = "SAP_2_3_2_3")
    @JsonProperty("SAP-2-3-2-3")
    private String SAP_2_3_2_3; // 营养风险筛查结论
    public String getSAP_2_3_2_3() {  return this.SAP_2_3_2_3;}
    @JsonProperty("SAP-2-3-2-3")
    public void setSAP_2_3_2_3(final String SAP_2_3_2_3) { this.SAP_2_3_2_3=SAP_2_3_2_3;}
    @Column(name = "SAP_2_3_3_1")
    @JsonProperty("SAP-2-3-3-1")
    private String SAP_2_3_3_1; // 筛查日期时间
    public String getSAP_2_3_3_1() {  return this.SAP_2_3_3_1;}
    @JsonProperty("SAP-2-3-3-1")
    public void setSAP_2_3_3_1(final String SAP_2_3_3_1) { this.SAP_2_3_3_1=SAP_2_3_3_1;}
    @Column(name = "SAP_2_3_3_2")
    @JsonProperty("SAP-2-3-3-2")
    private String SAP_2_3_3_2; // NRS-2002营养风险筛查分值
    public String getSAP_2_3_3_2() {  return this.SAP_2_3_3_2;}
    @JsonProperty("SAP-2-3-3-2")
    public void setSAP_2_3_3_2(final String SAP_2_3_3_2) { this.SAP_2_3_3_2=SAP_2_3_3_2;}
    @Column(name = "SAP_2_3_3_3")
    @JsonProperty("SAP-2-3-3-3")
    private String SAP_2_3_3_3; // 营养风险筛查结论
    public String getSAP_2_3_3_3() {  return this.SAP_2_3_3_3;}
    @JsonProperty("SAP-2-3-3-3")
    public void setSAP_2_3_3_3(final String SAP_2_3_3_3) { this.SAP_2_3_3_3=SAP_2_3_3_3;}
    @Column(name = "SAP_2_3_4_1")
    @JsonProperty("SAP-2-3-4-1")
    private String SAP_2_3_4_1; // 筛查日期时间
    public String getSAP_2_3_4_1() {  return this.SAP_2_3_4_1;}
    @JsonProperty("SAP-2-3-4-1")
    public void setSAP_2_3_4_1(final String SAP_2_3_4_1) { this.SAP_2_3_4_1=SAP_2_3_4_1;}
    @Column(name = "SAP_2_3_4_2")
    @JsonProperty("SAP-2-3-4-2")
    private String SAP_2_3_4_2; // NRS-2002营养风险筛查分值
    public String getSAP_2_3_4_2() {  return this.SAP_2_3_4_2;}
    @JsonProperty("SAP-2-3-4-2")
    public void setSAP_2_3_4_2(final String SAP_2_3_4_2) { this.SAP_2_3_4_2=SAP_2_3_4_2;}
    @Column(name = "SAP_2_3_4_3")
    @JsonProperty("SAP-2-3-4-3")
    private String SAP_2_3_4_3; // 营养风险筛查结论
    public String getSAP_2_3_4_3() {  return this.SAP_2_3_4_3;}
    @JsonProperty("SAP-2-3-4-3")
    public void setSAP_2_3_4_3(final String SAP_2_3_4_3) { this.SAP_2_3_4_3=SAP_2_3_4_3;}
    @Column(name = "SAP_2_3_5")
    @JsonProperty("SAP-2-3-5")
    private String SAP_2_3_5; // 是否营养支持治疗
    public String getSAP_2_3_5() {  return this.SAP_2_3_5;}
    @JsonProperty("SAP-2-3-5")
    public void setSAP_2_3_5(final String SAP_2_3_5) { this.SAP_2_3_5=SAP_2_3_5;}
    @Column(name = "SAP_2_3_6_1")
    @JsonProperty("SAP-2-3-6-1")
    private String SAP_2_3_6_1; // 经口进食起始日期时间
    public String getSAP_2_3_6_1() {  return this.SAP_2_3_6_1;}
    @JsonProperty("SAP-2-3-6-1")
    public void setSAP_2_3_6_1(final String SAP_2_3_6_1) { this.SAP_2_3_6_1=SAP_2_3_6_1;}
    @Column(name = "SAP_2_3_6_2")
    @JsonProperty("SAP-2-3-6-2")
    private String SAP_2_3_6_2; // SAP患者肠内营养适应证的选择
    public String getSAP_2_3_6_2() {  return this.SAP_2_3_6_2;}
    @JsonProperty("SAP-2-3-6-2")
    public void setSAP_2_3_6_2(final String SAP_2_3_6_2) { this.SAP_2_3_6_2=SAP_2_3_6_2;}
    @Column(name = "SAP_2_3_6_3")
    @JsonProperty("SAP-2-3-6-3")
    private String SAP_2_3_6_3; // 医师认定的肠营养其他适应证
    public String getSAP_2_3_6_3() {  return this.SAP_2_3_6_3;}
    @JsonProperty("SAP-2-3-6-3")
    public void setSAP_2_3_6_3(final String SAP_2_3_6_3) { this.SAP_2_3_6_3=SAP_2_3_6_3;}
    @Column(name = "SAP_2_3_6_4")
    @JsonProperty("SAP-2-3-6-4")
    private String SAP_2_3_6_4; // 肠内营养路径的选择
    public String getSAP_2_3_6_4() {  return this.SAP_2_3_6_4;}
    @JsonProperty("SAP-2-3-6-4")
    public void setSAP_2_3_6_4(final String SAP_2_3_6_4) { this.SAP_2_3_6_4=SAP_2_3_6_4;}
    @Column(name = "SAP_2_3_6_5")
    @JsonProperty("SAP-2-3-6-5")
    private String SAP_2_3_6_5; // 肠内营养医嘱起始日期时间
    public String getSAP_2_3_6_5() {  return this.SAP_2_3_6_5;}
    @JsonProperty("SAP-2-3-6-5")
    public void setSAP_2_3_6_5(final String SAP_2_3_6_5) { this.SAP_2_3_6_5=SAP_2_3_6_5;}
    @Column(name = "SAP_2_3_6_6")
    @JsonProperty("SAP-2-3-6-6")
    private String SAP_2_3_6_6; // SAP患者肠外营养适应证的选择
    public String getSAP_2_3_6_6() {  return this.SAP_2_3_6_6;}
    @JsonProperty("SAP-2-3-6-6")
    public void setSAP_2_3_6_6(final String SAP_2_3_6_6) { this.SAP_2_3_6_6=SAP_2_3_6_6;}
    @Column(name = "SAP_2_3_6_7")
    @JsonProperty("SAP-2-3-6-7")
    private String SAP_2_3_6_7; // 医师认定的肠营养其他适应证
    public String getSAP_2_3_6_7() {  return this.SAP_2_3_6_7;}
    @JsonProperty("SAP-2-3-6-7")
    public void setSAP_2_3_6_7(final String SAP_2_3_6_7) { this.SAP_2_3_6_7=SAP_2_3_6_7;}
    @Column(name = "SAP_2_3_6_8")
    @JsonProperty("SAP-2-3-6-8")
    private String SAP_2_3_6_8; // 肠外营养路径的选择
    public String getSAP_2_3_6_8() {  return this.SAP_2_3_6_8;}
    @JsonProperty("SAP-2-3-6-8")
    public void setSAP_2_3_6_8(final String SAP_2_3_6_8) { this.SAP_2_3_6_8=SAP_2_3_6_8;}
    @Column(name = "SAP_2_3_6_9")
    @JsonProperty("SAP-2-3-6-9")
    private String SAP_2_3_6_9; // 肠外营养医嘱起始日期时间
    public String getSAP_2_3_6_9() {  return this.SAP_2_3_6_9;}
    @JsonProperty("SAP-2-3-6-9")
    public void setSAP_2_3_6_9(final String SAP_2_3_6_9) { this.SAP_2_3_6_9=SAP_2_3_6_9;}
    @Column(name = "SAP_2_4_1")
    @JsonProperty("SAP-2-4-1")
    private String SAP_2_4_1; // 是否开展高脂血症性胰腺炎(HTGP)早期治疗
    public String getSAP_2_4_1() {  return this.SAP_2_4_1;}
    @JsonProperty("SAP-2-4-1")
    public void setSAP_2_4_1(final String SAP_2_4_1) { this.SAP_2_4_1=SAP_2_4_1;}
    @Column(name = "SAP_2_4_2")
    @JsonProperty("SAP-2-4-2")
    private String SAP_2_4_2; // HTGP诊断判定标准
    public String getSAP_2_4_2() {  return this.SAP_2_4_2;}
    @JsonProperty("SAP-2-4-2")
    public void setSAP_2_4_2(final String SAP_2_4_2) { this.SAP_2_4_2=SAP_2_4_2;}
    @Column(name = "SAP_2_4_3")
    @JsonProperty("SAP-2-4-3")
    private String SAP_2_4_3; // 早期治疗的主要措施选择
    public String getSAP_2_4_3() {  return this.SAP_2_4_3;}
    @JsonProperty("SAP-2-4-3")
    public void setSAP_2_4_3(final String SAP_2_4_3) { this.SAP_2_4_3=SAP_2_4_3;}
    @Column(name = "SAP_2_4_3_1")
    @JsonProperty("SAP-2-4-3-1")
    private String SAP_2_4_3_1; // 其他早期治疗的主要措施
    public String getSAP_2_4_3_1() {  return this.SAP_2_4_3_1;}
    @JsonProperty("SAP-2-4-3-1")
    public void setSAP_2_4_3_1(final String SAP_2_4_3_1) { this.SAP_2_4_3_1=SAP_2_4_3_1;}
    @Column(name = "SAP_2_4_4")
    @JsonProperty("SAP-2-4-4")
    private String SAP_2_4_4; // 实施（首项措施）日期时间
    public String getSAP_2_4_4() {  return this.SAP_2_4_4;}
    @JsonProperty("SAP-2-4-4")
    public void setSAP_2_4_4(final String SAP_2_4_4) { this.SAP_2_4_4=SAP_2_4_4;}
    @Column(name = "SAP_2_5_1")
    @JsonProperty("SAP-2-5-1")
    private String SAP_2_5_1; // 是否使用中医中药治疗
    public String getSAP_2_5_1() {  return this.SAP_2_5_1;}
    @JsonProperty("SAP-2-5-1")
    public void setSAP_2_5_1(final String SAP_2_5_1) { this.SAP_2_5_1=SAP_2_5_1;}
    @Column(name = "SAP_2_5_2")
    @JsonProperty("SAP-2-5-2")
    private String SAP_2_5_2; // 辨证拟定相应治则
    public String getSAP_2_5_2() {  return this.SAP_2_5_2;}
    @JsonProperty("SAP-2-5-2")
    public void setSAP_2_5_2(final String SAP_2_5_2) { this.SAP_2_5_2=SAP_2_5_2;}
    @Column(name = "SAP_2_5_3")
    @JsonProperty("SAP-2-5-3")
    private String SAP_2_5_3; // 治疗用药途径的选择
    public String getSAP_2_5_3() {  return this.SAP_2_5_3;}
    @JsonProperty("SAP-2-5-3")
    public void setSAP_2_5_3(final String SAP_2_5_3) { this.SAP_2_5_3=SAP_2_5_3;}
    @Column(name = "SAP_2_5_4")
    @JsonProperty("SAP-2-5-4")
    private String SAP_2_5_4; // 常用方剂的选择
    public String getSAP_2_5_4() {  return this.SAP_2_5_4;}
    @JsonProperty("SAP-2-5-4")
    public void setSAP_2_5_4(final String SAP_2_5_4) { this.SAP_2_5_4=SAP_2_5_4;}
    @Column(name = "SAP_2_5_4_1")
    @JsonProperty("SAP-2-5-4-1")
    private String SAP_2_5_4_1; // 其他常用方剂
    public String getSAP_2_5_4_1() {  return this.SAP_2_5_4_1;}
    @JsonProperty("SAP-2-5-4-1")
    public void setSAP_2_5_4_1(final String SAP_2_5_4_1) { this.SAP_2_5_4_1=SAP_2_5_4_1;}
    @Column(name = "SAP_2_5_5")
    @JsonProperty("SAP-2-5-5")
    private String SAP_2_5_5; // 首项措施实施日期时间
    public String getSAP_2_5_5() {  return this.SAP_2_5_5;}
    @JsonProperty("SAP-2-5-5")
    public void setSAP_2_5_5(final String SAP_2_5_5) { this.SAP_2_5_5=SAP_2_5_5;}
    @Column(name = "SAP_3_1_1")
    @JsonProperty("SAP-3-1-1")
    private String SAP_3_1_1; // 是否接受腹部CT复查
    public String getSAP_3_1_1() {  return this.SAP_3_1_1;}
    @JsonProperty("SAP-3-1-1")
    public void setSAP_3_1_1(final String SAP_3_1_1) { this.SAP_3_1_1=SAP_3_1_1;}
    @Column(name = "SAP_3_3_2")
    @JsonProperty("SAP-3-3-2")
    private String SAP_3_3_2; // 是否出现以下临床情况
    public String getSAP_3_3_2() {  return this.SAP_3_3_2;}
    @JsonProperty("SAP-3-3-2")
    public void setSAP_3_3_2(final String SAP_3_3_2) { this.SAP_3_3_2=SAP_3_3_2;}
    @Column(name = "SAP_3_3_2_1")
    @JsonProperty("SAP-3-3-2-1")
    private String SAP_3_3_2_1; // 其他情况
    public String getSAP_3_3_2_1() {  return this.SAP_3_3_2_1;}
    @JsonProperty("SAP-3-3-2-1")
    public void setSAP_3_3_2_1(final String SAP_3_3_2_1) { this.SAP_3_3_2_1=SAP_3_3_2_1;}
    @Column(name = "SAP_3_1_2")
    @JsonProperty("SAP-3-1-2")
    private String SAP_3_1_2; // 腹部CT复查日期时间
    public String getSAP_3_1_2() {  return this.SAP_3_1_2;}
    @JsonProperty("SAP-3-1-2")
    public void setSAP_3_1_2(final String SAP_3_1_2) { this.SAP_3_1_2=SAP_3_1_2;}
    @Column(name = "SAP_3_3_3")
    @JsonProperty("SAP-3-3-3")
    private String SAP_3_3_3; // 选择何种检查
    public String getSAP_3_3_3() {  return this.SAP_3_3_3;}
    @JsonProperty("SAP-3-3-3")
    public void setSAP_3_3_3(final String SAP_3_3_3) { this.SAP_3_3_3=SAP_3_3_3;}
    @Column(name = "SAP_3_1_3")
    @JsonProperty("SAP-3-1-3")
    private String SAP_3_1_3; // 是否进行CT严重指数（MCTSI）评估
    public String getSAP_3_1_3() {  return this.SAP_3_1_3;}
    @JsonProperty("SAP-3-1-3")
    public void setSAP_3_1_3(final String SAP_3_1_3) { this.SAP_3_1_3=SAP_3_1_3;}
    @Column(name = "SAP_3_1_3_1")
    @JsonProperty("SAP-3-1-3-1")
    private String SAP_3_1_3_1; // 改良CT严重指数（MCTSI）分值
    public String getSAP_3_1_3_1() {  return this.SAP_3_1_3_1;}
    @JsonProperty("SAP-3-1-3-1")
    public void setSAP_3_1_3_1(final String SAP_3_1_3_1) { this.SAP_3_1_3_1=SAP_3_1_3_1;}
    @Column(name = "SAP_3_1_3_2")
    @JsonProperty("SAP-3-1-3-2")
    private String SAP_3_1_3_2; // MCTSI指数严重分层
    public String getSAP_3_1_3_2() {  return this.SAP_3_1_3_2;}
    @JsonProperty("SAP-3-1-3-2")
    public void setSAP_3_1_3_2(final String SAP_3_1_3_2) { this.SAP_3_1_3_2=SAP_3_1_3_2;}
    @Column(name = "SAP_3_3_4")
    @JsonProperty("SAP-3-3-4")
    private String SAP_3_3_4; // 是否进行胰腺炎胰外炎症严重程度（EPIC评分）评估
    public String getSAP_3_3_4() {  return this.SAP_3_3_4;}
    @JsonProperty("SAP-3-3-4")
    public void setSAP_3_3_4(final String SAP_3_3_4) { this.SAP_3_3_4=SAP_3_3_4;}
    @Column(name = "SAP_3_1_3_3")
    @JsonProperty("SAP-3-1-3-3")
    private String SAP_3_1_3_3; // 胰腺炎胰外炎症(EPIC评分)分值
    public String getSAP_3_1_3_3() {  return this.SAP_3_1_3_3;}
    @JsonProperty("SAP-3-1-3-3")
    public void setSAP_3_1_3_3(final String SAP_3_1_3_3) { this.SAP_3_1_3_3=SAP_3_1_3_3;}
    @Column(name = "SAP_3_1_3_4")
    @JsonProperty("SAP-3-1-3-4")
    private String SAP_3_1_3_4; // EPIC评分严重分层
    public String getSAP_3_1_3_4() {  return this.SAP_3_1_3_4;}
    @JsonProperty("SAP-3-1-3-4")
    public void setSAP_3_1_3_4(final String SAP_3_1_3_4) { this.SAP_3_1_3_4=SAP_3_1_3_4;}
    @Column(name = "SAP_3_2_1")
    @JsonProperty("SAP-3-2-1")
    private String SAP_3_2_1; // 其他影像检查方法
    public String getSAP_3_2_1() {  return this.SAP_3_2_1;}
    @JsonProperty("SAP-3-2-1")
    public void setSAP_3_2_1(final String SAP_3_2_1) { this.SAP_3_2_1=SAP_3_2_1;}
    @Column(name = "SAP_3_2_1_1")
    @JsonProperty("SAP-3-2-1-1")
    private String SAP_3_2_1_1; // 其他影像检查
    public String getSAP_3_2_1_1() {  return this.SAP_3_2_1_1;}
    @JsonProperty("SAP-3-2-1-1")
    public void setSAP_3_2_1_1(final String SAP_3_2_1_1) { this.SAP_3_2_1_1=SAP_3_2_1_1;}
    @Column(name = "SAP_3_2_2")
    @JsonProperty("SAP-3-2-2")
    private String SAP_3_2_2; // 复查报告中并发症的提示
    public String getSAP_3_2_2() {  return this.SAP_3_2_2;}
    @JsonProperty("SAP-3-2-2")
    public void setSAP_3_2_2(final String SAP_3_2_2) { this.SAP_3_2_2=SAP_3_2_2;}
    @Column(name = "SAP_3_2_2_1")
    @JsonProperty("SAP-3-2-2-1")
    private String SAP_3_2_2_1; // 复查报告中并发症阳性发现1
    public String getSAP_3_2_2_1() {  return this.SAP_3_2_2_1;}
    @JsonProperty("SAP-3-2-2-1")
    public void setSAP_3_2_2_1(final String SAP_3_2_2_1) { this.SAP_3_2_2_1=SAP_3_2_2_1;}
    @Column(name = "SAP_3_2_2_2")
    @JsonProperty("SAP-3-2-2-2")
    private String SAP_3_2_2_2; // 复查报告中并发症阳性发现2
    public String getSAP_3_2_2_2() {  return this.SAP_3_2_2_2;}
    @JsonProperty("SAP-3-2-2-2")
    public void setSAP_3_2_2_2(final String SAP_3_2_2_2) { this.SAP_3_2_2_2=SAP_3_2_2_2;}
    @Column(name = "SAP_3_2_2_3")
    @JsonProperty("SAP-3-2-2-3")
    private String SAP_3_2_2_3; // 复查报告中并发症阳性发现3
    public String getSAP_3_2_2_3() {  return this.SAP_3_2_2_3;}
    @JsonProperty("SAP-3-2-2-3")
    public void setSAP_3_2_2_3(final String SAP_3_2_2_3) { this.SAP_3_2_2_3=SAP_3_2_2_3;}
    @Column(name = "SAP_3_2_3")
    @JsonProperty("SAP-3-2-3")
    private String SAP_3_2_3; // 其他影像复查日期时间
    public String getSAP_3_2_3() {  return this.SAP_3_2_3;}
    @JsonProperty("SAP-3-2-3")
    public void setSAP_3_2_3(final String SAP_3_2_3) { this.SAP_3_2_3=SAP_3_2_3;}
    @Column(name = "SAP_4_1_1")
    @JsonProperty("SAP-4-1-1")
    private String SAP_4_1_1; // 是否有并发症
    public String getSAP_4_1_1() {  return this.SAP_4_1_1;}
    @JsonProperty("SAP-4-1-1")
    public void setSAP_4_1_1(final String SAP_4_1_1) { this.SAP_4_1_1=SAP_4_1_1;}
    @Column(name = "SAP_4_1_2")
    @JsonProperty("SAP-4-1-2")
    private String SAP_4_1_2; // 全身并发症
    public String getSAP_4_1_2() {  return this.SAP_4_1_2;}
    @JsonProperty("SAP-4-1-2")
    public void setSAP_4_1_2(final String SAP_4_1_2) { this.SAP_4_1_2=SAP_4_1_2;}
    @Column(name = "SAP_4_1_2_1")
    @JsonProperty("SAP-4-1-2-1")
    private String SAP_4_1_2_1; // 其他全身并发症
    public String getSAP_4_1_2_1() {  return this.SAP_4_1_2_1;}
    @JsonProperty("SAP-4-1-2-1")
    public void setSAP_4_1_2_1(final String SAP_4_1_2_1) { this.SAP_4_1_2_1=SAP_4_1_2_1;}
    @Column(name = "SAP_4_1_3")
    @JsonProperty("SAP-4-1-3")
    private String SAP_4_1_3; // 局部并发症
    public String getSAP_4_1_3() {  return this.SAP_4_1_3;}
    @JsonProperty("SAP-4-1-3")
    public void setSAP_4_1_3(final String SAP_4_1_3) { this.SAP_4_1_3=SAP_4_1_3;}
    @Column(name = "SAP_4_1_3_1")
    @JsonProperty("SAP-4-1-3-1")
    private String SAP_4_1_3_1; // 其他局部并发症
    public String getSAP_4_1_3_1() {  return this.SAP_4_1_3_1;}
    @JsonProperty("SAP-4-1-3-1")
    public void setSAP_4_1_3_1(final String SAP_4_1_3_1) { this.SAP_4_1_3_1=SAP_4_1_3_1;}
    @Column(name = "SAP_4_1_4")
    @JsonProperty("SAP-4-1-4")
    private String SAP_4_1_4; // 其他并发症
    public String getSAP_4_1_4() {  return this.SAP_4_1_4;}
    @JsonProperty("SAP-4-1-4")
    public void setSAP_4_1_4(final String SAP_4_1_4) { this.SAP_4_1_4=SAP_4_1_4;}
    @Column(name = "SAP_4_1_4_1")
    @JsonProperty("SAP-4-1-4-1")
    private String SAP_4_1_4_1; // 其他并发症
    public String getSAP_4_1_4_1() {  return this.SAP_4_1_4_1;}
    @JsonProperty("SAP-4-1-4-1")
    public void setSAP_4_1_4_1(final String SAP_4_1_4_1) { this.SAP_4_1_4_1=SAP_4_1_4_1;}
    @Column(name = "SAP_4_2_1")
    @JsonProperty("SAP-4-2-1")
    private String SAP_4_2_1; // 是否SAP并发脓毒症(SEP)
    public String getSAP_4_2_1() {  return this.SAP_4_2_1;}
    @JsonProperty("SAP-4-2-1")
    public void setSAP_4_2_1(final String SAP_4_2_1) { this.SAP_4_2_1=SAP_4_2_1;}
    @Column(name = "SAP_4_2_2")
    @JsonProperty("SAP-4-2-2")
    private String SAP_4_2_2; // 是否有血清乳酸测定值
    public String getSAP_4_2_2() {  return this.SAP_4_2_2;}
    @JsonProperty("SAP-4-2-2")
    public void setSAP_4_2_2(final String SAP_4_2_2) { this.SAP_4_2_2=SAP_4_2_2;}
    @Column(name = "SAP_4_2_2_1")
    @JsonProperty("SAP-4-2-2-1")
    private String SAP_4_2_2_1; // 乳酸水平测量值(mmol/L)
    public String getSAP_4_2_2_1() {  return this.SAP_4_2_2_1;}
    @JsonProperty("SAP-4-2-2-1")
    public void setSAP_4_2_2_1(final String SAP_4_2_2_1) { this.SAP_4_2_2_1=SAP_4_2_2_1;}
    @Column(name = "SAP_4_2_2_2")
    @JsonProperty("SAP-4-2-2-2")
    private String SAP_4_2_2_2; // 乳酸水平测值分层
    public String getSAP_4_2_2_2() {  return this.SAP_4_2_2_2;}
    @JsonProperty("SAP-4-2-2-2")
    public void setSAP_4_2_2_2(final String SAP_4_2_2_2) { this.SAP_4_2_2_2=SAP_4_2_2_2;}
    @Column(name = "SAP_4_2_3")
    @JsonProperty("SAP-4-2-3")
    private String SAP_4_2_3; // 评分量表的选择
    public String getSAP_4_2_3() {  return this.SAP_4_2_3;}
    @JsonProperty("SAP-4-2-3")
    public void setSAP_4_2_3(final String SAP_4_2_3) { this.SAP_4_2_3=SAP_4_2_3;}
    @Column(name = "SAP_4_2_3_2")
    @JsonProperty("SAP-4-2-3-2")
    private String SAP_4_2_3_2; // 第一部分 呼吸系统评分值
    public String getSAP_4_2_3_2() {  return this.SAP_4_2_3_2;}
    @JsonProperty("SAP-4-2-3-2")
    public void setSAP_4_2_3_2(final String SAP_4_2_3_2) { this.SAP_4_2_3_2=SAP_4_2_3_2;}
    @Column(name = "SAP_4_2_3_3")
    @JsonProperty("SAP-4-2-3-3")
    private String SAP_4_2_3_3; // 第二部分 血液系统评分值
    public String getSAP_4_2_3_3() {  return this.SAP_4_2_3_3;}
    @JsonProperty("SAP-4-2-3-3")
    public void setSAP_4_2_3_3(final String SAP_4_2_3_3) { this.SAP_4_2_3_3=SAP_4_2_3_3;}
    @Column(name = "SAP_4_2_3_4")
    @JsonProperty("SAP-4-2-3-4")
    private String SAP_4_2_3_4; // 第三部分 肝脏评分值
    public String getSAP_4_2_3_4() {  return this.SAP_4_2_3_4;}
    @JsonProperty("SAP-4-2-3-4")
    public void setSAP_4_2_3_4(final String SAP_4_2_3_4) { this.SAP_4_2_3_4=SAP_4_2_3_4;}
    @Column(name = "SAP_4_2_3_5")
    @JsonProperty("SAP-4-2-3-5")
    private String SAP_4_2_3_5; // 第四部分 心血管系统评分值
    public String getSAP_4_2_3_5() {  return this.SAP_4_2_3_5;}
    @JsonProperty("SAP-4-2-3-5")
    public void setSAP_4_2_3_5(final String SAP_4_2_3_5) { this.SAP_4_2_3_5=SAP_4_2_3_5;}
    @Column(name = "SAP_4_2_3_6")
    @JsonProperty("SAP-4-2-3-6")
    private String SAP_4_2_3_6; // 第五部分 中枢神经系统评分值
    public String getSAP_4_2_3_6() {  return this.SAP_4_2_3_6;}
    @JsonProperty("SAP-4-2-3-6")
    public void setSAP_4_2_3_6(final String SAP_4_2_3_6) { this.SAP_4_2_3_6=SAP_4_2_3_6;}
    @Column(name = "SAP_4_2_3_7")
    @JsonProperty("SAP-4-2-3-7")
    private String SAP_4_2_3_7; // 第六部分 肾脏评分值
    public String getSAP_4_2_3_7() {  return this.SAP_4_2_3_7;}
    @JsonProperty("SAP-4-2-3-7")
    public void setSAP_4_2_3_7(final String SAP_4_2_3_7) { this.SAP_4_2_3_7=SAP_4_2_3_7;}
    @Column(name = "SAP_4_2_3_1")
    @JsonProperty("SAP-4-2-3-1")
    private String SAP_4_2_3_1; // 合计 SOFA评分值
    public String getSAP_4_2_3_1() {  return this.SAP_4_2_3_1;}
    @JsonProperty("SAP-4-2-3-1")
    public void setSAP_4_2_3_1(final String SAP_4_2_3_1) { this.SAP_4_2_3_1=SAP_4_2_3_1;}
    @Column(name = "SAP_4_2_3_8")
    @JsonProperty("SAP-4-2-3-8")
    private String SAP_4_2_3_8; // SOFA评分结果分层
    public String getSAP_4_2_3_8() {  return this.SAP_4_2_3_8;}
    @JsonProperty("SAP-4-2-3-8")
    public void setSAP_4_2_3_8(final String SAP_4_2_3_8) { this.SAP_4_2_3_8=SAP_4_2_3_8;}
    @Column(name = "SAP_4_2_3_9")
    @JsonProperty("SAP-4-2-3-9")
    private String SAP_4_2_3_9; // qSOFA评分值
    public String getSAP_4_2_3_9() {  return this.SAP_4_2_3_9;}
    @JsonProperty("SAP-4-2-3-9")
    public void setSAP_4_2_3_9(final String SAP_4_2_3_9) { this.SAP_4_2_3_9=SAP_4_2_3_9;}
    @Column(name = "SAP_4_2_3_10")
    @JsonProperty("SAP-4-2-3-10")
    private String SAP_4_2_3_10; // qSOFA评分结果分层
    public String getSAP_4_2_3_10() {  return this.SAP_4_2_3_10;}
    @JsonProperty("SAP-4-2-3-10")
    public void setSAP_4_2_3_10(final String SAP_4_2_3_10) { this.SAP_4_2_3_10=SAP_4_2_3_10;}
    @Column(name = "SAP_4_2_3_11")
    @JsonProperty("SAP-4-2-3-11")
    private String SAP_4_2_3_11; // 评分时间
    public String getSAP_4_2_3_11() {  return this.SAP_4_2_3_11;}
    @JsonProperty("SAP-4-2-3-11")
    public void setSAP_4_2_3_11(final String SAP_4_2_3_11) { this.SAP_4_2_3_11=SAP_4_2_3_11;}
    @Column(name = "SAP_4_2_4")
    @JsonProperty("SAP-4-2-4")
    private String SAP_4_2_4; // 是否有炎性标志物检测
    public String getSAP_4_2_4() {  return this.SAP_4_2_4;}
    @JsonProperty("SAP-4-2-4")
    public void setSAP_4_2_4(final String SAP_4_2_4) { this.SAP_4_2_4=SAP_4_2_4;}
    @Column(name = "SAP_4_2_4_1")
    @JsonProperty("SAP-4-2-4-1")
    private String SAP_4_2_4_1; // C反应蛋白浓度(mg/L)
    public String getSAP_4_2_4_1() {  return this.SAP_4_2_4_1;}
    @JsonProperty("SAP-4-2-4-1")
    public void setSAP_4_2_4_1(final String SAP_4_2_4_1) { this.SAP_4_2_4_1=SAP_4_2_4_1;}
    @Column(name = "SAP_4_2_4_2")
    @JsonProperty("SAP-4-2-4-2")
    private String SAP_4_2_4_2; // 血清降钙素原浓度(ng/mL)
    public String getSAP_4_2_4_2() {  return this.SAP_4_2_4_2;}
    @JsonProperty("SAP-4-2-4-2")
    public void setSAP_4_2_4_2(final String SAP_4_2_4_2) { this.SAP_4_2_4_2=SAP_4_2_4_2;}
    @Column(name = "SAP_4_2_5")
    @JsonProperty("SAP-4-2-5")
    private String SAP_4_2_5; // 脓毒症(SEP)的主要处置措施
    public String getSAP_4_2_5() {  return this.SAP_4_2_5;}
    @JsonProperty("SAP-4-2-5")
    public void setSAP_4_2_5(final String SAP_4_2_5) { this.SAP_4_2_5=SAP_4_2_5;}
    @Column(name = "SAP_4_3_1")
    @JsonProperty("SAP-4-3-1")
    private String SAP_4_3_1; // 是否并发急性呼吸窘迫综合征(ARDS)
    public String getSAP_4_3_1() {  return this.SAP_4_3_1;}
    @JsonProperty("SAP-4-3-1")
    public void setSAP_4_3_1(final String SAP_4_3_1) { this.SAP_4_3_1=SAP_4_3_1;}
    @Column(name = "SAP_4_3_2")
    @JsonProperty("SAP-4-3-2")
    private String SAP_4_3_2; // 是否ARDS评估
    public String getSAP_4_3_2() {  return this.SAP_4_3_2;}
    @JsonProperty("SAP-4-3-2")
    public void setSAP_4_3_2(final String SAP_4_3_2) { this.SAP_4_3_2=SAP_4_3_2;}
    @Column(name = "SAP_4_3_3_1")
    @JsonProperty("SAP-4-3-3-1")
    private String SAP_4_3_3_1; // 氧合指数 P/F 数值(mmHg)
    public String getSAP_4_3_3_1() {  return this.SAP_4_3_3_1;}
    @JsonProperty("SAP-4-3-3-1")
    public void setSAP_4_3_3_1(final String SAP_4_3_3_1) { this.SAP_4_3_3_1=SAP_4_3_3_1;}
    @Column(name = "SAP_4_3_3_2")
    @JsonProperty("SAP-4-3-3-2")
    private String SAP_4_3_3_2; // ARDS严重程度（氧合指数(PaO2/FiO2, P/F)mmHg)）
    public String getSAP_4_3_3_2() {  return this.SAP_4_3_3_2;}
    @JsonProperty("SAP-4-3-3-2")
    public void setSAP_4_3_3_2(final String SAP_4_3_3_2) { this.SAP_4_3_3_2=SAP_4_3_3_2;}
    @Column(name = "SAP_4_3_4")
    @JsonProperty("SAP-4-3-4")
    private String SAP_4_3_4; // 器官保护措施
    public String getSAP_4_3_4() {  return this.SAP_4_3_4;}
    @JsonProperty("SAP-4-3-4")
    public void setSAP_4_3_4(final String SAP_4_3_4) { this.SAP_4_3_4=SAP_4_3_4;}
    @Column(name = "SAP_4_3_5")
    @JsonProperty("SAP-4-3-5")
    private String SAP_4_3_5; // 呼吸支持和辅助治疗 
    public String getSAP_4_3_5() {  return this.SAP_4_3_5;}
    @JsonProperty("SAP-4-3-5")
    public void setSAP_4_3_5(final String SAP_4_3_5) { this.SAP_4_3_5=SAP_4_3_5;}
    @Column(name = "SAP_4_3_6_1")
    @JsonProperty("SAP-4-3-6-1")
    private String SAP_4_3_6_1; // 氧合指数 P/F 数值(mmHg)
    public String getSAP_4_3_6_1() {  return this.SAP_4_3_6_1;}
    @JsonProperty("SAP-4-3-6-1")
    public void setSAP_4_3_6_1(final String SAP_4_3_6_1) { this.SAP_4_3_6_1=SAP_4_3_6_1;}
    @Column(name = "SAP_4_3_6_2")
    @JsonProperty("SAP-4-3-6-2")
    private String SAP_4_3_6_2; // ARDS严重程度（氧合指数(PaO2/FiO2, P/F)mmHg)）
    public String getSAP_4_3_6_2() {  return this.SAP_4_3_6_2;}
    @JsonProperty("SAP-4-3-6-2")
    public void setSAP_4_3_6_2(final String SAP_4_3_6_2) { this.SAP_4_3_6_2=SAP_4_3_6_2;}
    @Column(name = "SAP_4_3_7_1")
    @JsonProperty("SAP-4-3-7-1")
    private String SAP_4_3_7_1; // 氧合指数 P/F 数值(mmHg)
    public String getSAP_4_3_7_1() {  return this.SAP_4_3_7_1;}
    @JsonProperty("SAP-4-3-7-1")
    public void setSAP_4_3_7_1(final String SAP_4_3_7_1) { this.SAP_4_3_7_1=SAP_4_3_7_1;}
    @Column(name = "SAP_4_3_7_2")
    @JsonProperty("SAP-4-3-7-2")
    private String SAP_4_3_7_2; // ARDS严重程度（氧合指数(PaO2/FiO2, P/F)mmHg)）
    public String getSAP_4_3_7_2() {  return this.SAP_4_3_7_2;}
    @JsonProperty("SAP-4-3-7-2")
    public void setSAP_4_3_7_2(final String SAP_4_3_7_2) { this.SAP_4_3_7_2=SAP_4_3_7_2;}
    @Column(name = "SAP_4_3_7")
    @JsonProperty("SAP-4-3-7")
    private String SAP_4_3_7; // 再评估日期时间
    public String getSAP_4_3_7() {  return this.SAP_4_3_7;}
    @JsonProperty("SAP-4-3-7")
    public void setSAP_4_3_7(final String SAP_4_3_7) { this.SAP_4_3_7=SAP_4_3_7;}
    @Column(name = "SAP_4_4_1")
    @JsonProperty("SAP-4-4-1")
    private String SAP_4_4_1; // 是否并发器官功能衰竭
    public String getSAP_4_4_1() {  return this.SAP_4_4_1;}
    @JsonProperty("SAP-4-4-1")
    public void setSAP_4_4_1(final String SAP_4_4_1) { this.SAP_4_4_1=SAP_4_4_1;}
    @Column(name = "SAP_4_4_2")
    @JsonProperty("SAP-4-4-2")
    private String SAP_4_4_2; // 是否改良Marshall 评分系统(器官功能障碍的诊断标准)
    public String getSAP_4_4_2() {  return this.SAP_4_4_2;}
    @JsonProperty("SAP-4-4-2")
    public void setSAP_4_4_2(final String SAP_4_4_2) { this.SAP_4_4_2=SAP_4_4_2;}
    @Column(name = "SAP_4_4_3_2")
    @JsonProperty("SAP-4-4-3-2")
    private String SAP_4_4_3_2; // 第一部分 呼吸系统(氧合指数)分值
    public String getSAP_4_4_3_2() {  return this.SAP_4_4_3_2;}
    @JsonProperty("SAP-4-4-3-2")
    public void setSAP_4_4_3_2(final String SAP_4_4_3_2) { this.SAP_4_4_3_2=SAP_4_4_3_2;}
    @Column(name = "SAP_4_4_3_3")
    @JsonProperty("SAP-4-4-3-3")
    private String SAP_4_4_3_3; // 第二部分 肾脏(血肌酐)分值
    public String getSAP_4_4_3_3() {  return this.SAP_4_4_3_3;}
    @JsonProperty("SAP-4-4-3-3")
    public void setSAP_4_4_3_3(final String SAP_4_4_3_3) { this.SAP_4_4_3_3=SAP_4_4_3_3;}
    @Column(name = "SAP_4_4_3_4")
    @JsonProperty("SAP-4-4-3-4")
    private String SAP_4_4_3_4; // 第三部分 心血管系统(收缩压)分值
    public String getSAP_4_4_3_4() {  return this.SAP_4_4_3_4;}
    @JsonProperty("SAP-4-4-3-4")
    public void setSAP_4_4_3_4(final String SAP_4_4_3_4) { this.SAP_4_4_3_4=SAP_4_4_3_4;}
    @Column(name = "SAP_4_4_3_5")
    @JsonProperty("SAP-4-4-3-5")
    private String SAP_4_4_3_5; // Marshall 指数值总分
    public String getSAP_4_4_3_5() {  return this.SAP_4_4_3_5;}
    @JsonProperty("SAP-4-4-3-5")
    public void setSAP_4_4_3_5(final String SAP_4_4_3_5) { this.SAP_4_4_3_5=SAP_4_4_3_5;}
    @Column(name = "SAP_4_4_3_1")
    @JsonProperty("SAP-4-4-3-1")
    private String SAP_4_4_3_1; // 合计：Marshall 评分值
    public String getSAP_4_4_3_1() {  return this.SAP_4_4_3_1;}
    @JsonProperty("SAP-4-4-3-1")
    public void setSAP_4_4_3_1(final String SAP_4_4_3_1) { this.SAP_4_4_3_1=SAP_4_4_3_1;}
    @Column(name = "SAP_4_4_5")
    @JsonProperty("SAP-4-4-5")
    private String SAP_4_4_5; // Marshall 指数严重分层
    public String getSAP_4_4_5() {  return this.SAP_4_4_5;}
    @JsonProperty("SAP-4-4-5")
    public void setSAP_4_4_5(final String SAP_4_4_5) { this.SAP_4_4_5=SAP_4_4_5;}
    @Column(name = "SAP_4_4_6")
    @JsonProperty("SAP-4-4-6")
    private String SAP_4_4_6; // Marshall 评估 日期时间
    public String getSAP_4_4_6() {  return this.SAP_4_4_6;}
    @JsonProperty("SAP-4-4-6")
    public void setSAP_4_4_6(final String SAP_4_4_6) { this.SAP_4_4_6=SAP_4_4_6;}
    @Column(name = "SAP_4_5_1")
    @JsonProperty("SAP-4-5-1")
    private String SAP_4_5_1; // 是否腹内高压(ACS)
    public String getSAP_4_5_1() {  return this.SAP_4_5_1;}
    @JsonProperty("SAP-4-5-1")
    public void setSAP_4_5_1(final String SAP_4_5_1) { this.SAP_4_5_1=SAP_4_5_1;}
    @Column(name = "SAP_4_5_2")
    @JsonProperty("SAP-4-5-2")
    private String SAP_4_5_2; // 是否腹内压（IAP）监测
    public String getSAP_4_5_2() {  return this.SAP_4_5_2;}
    @JsonProperty("SAP-4-5-2")
    public void setSAP_4_5_2(final String SAP_4_5_2) { this.SAP_4_5_2=SAP_4_5_2;}
    @Column(name = "SAP_4_5_3_1")
    @JsonProperty("SAP-4-5-3-1")
    private String SAP_4_5_3_1; // 腹内压 IAP(mmHg)
    public String getSAP_4_5_3_1() {  return this.SAP_4_5_3_1;}
    @JsonProperty("SAP-4-5-3-1")
    public void setSAP_4_5_3_1(final String SAP_4_5_3_1) { this.SAP_4_5_3_1=SAP_4_5_3_1;}
    @Column(name = "SAP_4_5_3_2")
    @JsonProperty("SAP-4-5-3-2")
    private String SAP_4_5_3_2; // IAH分级
    public String getSAP_4_5_3_2() {  return this.SAP_4_5_3_2;}
    @JsonProperty("SAP-4-5-3-2")
    public void setSAP_4_5_3_2(final String SAP_4_5_3_2) { this.SAP_4_5_3_2=SAP_4_5_3_2;}
    @Column(name = "SAP_4_5_4")
    @JsonProperty("SAP-4-5-4")
    private String SAP_4_5_4; // 治疗方法
    public String getSAP_4_5_4() {  return this.SAP_4_5_4;}
    @JsonProperty("SAP-4-5-4")
    public void setSAP_4_5_4(final String SAP_4_5_4) { this.SAP_4_5_4=SAP_4_5_4;}
    @Column(name = "SAP_4_5_4_1")
    @JsonProperty("SAP-4-5-4-1")
    private String SAP_4_5_4_1; // 液体管理
    public String getSAP_4_5_4_1() {  return this.SAP_4_5_4_1;}
    @JsonProperty("SAP-4-5-4-1")
    public void setSAP_4_5_4_1(final String SAP_4_5_4_1) { this.SAP_4_5_4_1=SAP_4_5_4_1;}
    @Column(name = "SAP_4_5_4_2")
    @JsonProperty("SAP-4-5-4-2")
    private String SAP_4_5_4_2; // 增加腹壁顺应性治疗方法
    public String getSAP_4_5_4_2() {  return this.SAP_4_5_4_2;}
    @JsonProperty("SAP-4-5-4-2")
    public void setSAP_4_5_4_2(final String SAP_4_5_4_2) { this.SAP_4_5_4_2=SAP_4_5_4_2;}
    @Column(name = "SAP_4_5_4_3")
    @JsonProperty("SAP-4-5-4-3")
    private String SAP_4_5_4_3; // 促胃肠动力/清除胃肠内容物
    public String getSAP_4_5_4_3() {  return this.SAP_4_5_4_3;}
    @JsonProperty("SAP-4-5-4-3")
    public void setSAP_4_5_4_3(final String SAP_4_5_4_3) { this.SAP_4_5_4_3=SAP_4_5_4_3;}
    @Column(name = "SAP_4_5_4_4")
    @JsonProperty("SAP-4-5-4-4")
    private String SAP_4_5_4_4; // 使用中医药方式
    public String getSAP_4_5_4_4() {  return this.SAP_4_5_4_4;}
    @JsonProperty("SAP-4-5-4-4")
    public void setSAP_4_5_4_4(final String SAP_4_5_4_4) { this.SAP_4_5_4_4=SAP_4_5_4_4;}
    @Column(name = "SAP_4_5_4_5")
    @JsonProperty("SAP-4-5-4-5")
    private String SAP_4_5_4_5; // 介入治疗
    public String getSAP_4_5_4_5() {  return this.SAP_4_5_4_5;}
    @JsonProperty("SAP-4-5-4-5")
    public void setSAP_4_5_4_5(final String SAP_4_5_4_5) { this.SAP_4_5_4_5=SAP_4_5_4_5;}
    @Column(name = "SAP_4_6_1")
    @JsonProperty("SAP-4-6-1")
    private String SAP_4_6_1; // 是否并发急性肾损伤(AKI)
    public String getSAP_4_6_1() {  return this.SAP_4_6_1;}
    @JsonProperty("SAP-4-6-1")
    public void setSAP_4_6_1(final String SAP_4_6_1) { this.SAP_4_6_1=SAP_4_6_1;}
    @Column(name = "SAP_4_6_2")
    @JsonProperty("SAP-4-6-2")
    private String SAP_4_6_2; // 是否AKI评估
    public String getSAP_4_6_2() {  return this.SAP_4_6_2;}
    @JsonProperty("SAP-4-6-2")
    public void setSAP_4_6_2(final String SAP_4_6_2) { this.SAP_4_6_2=SAP_4_6_2;}
    @Column(name = "SAP_4_6_3")
    @JsonProperty("SAP-4-6-3")
    private String SAP_4_6_3; // AKI严重程度
    public String getSAP_4_6_3() {  return this.SAP_4_6_3;}
    @JsonProperty("SAP-4-6-3")
    public void setSAP_4_6_3(final String SAP_4_6_3) { this.SAP_4_6_3=SAP_4_6_3;}
    @Column(name = "SAP_4_6_4")
    @JsonProperty("SAP-4-6-4")
    private String SAP_4_6_4; // 器官支持措施
    public String getSAP_4_6_4() {  return this.SAP_4_6_4;}
    @JsonProperty("SAP-4-6-4")
    public void setSAP_4_6_4(final String SAP_4_6_4) { this.SAP_4_6_4=SAP_4_6_4;}
    @Column(name = "SAP_4_6_5")
    @JsonProperty("SAP-4-6-5")
    private String SAP_4_6_5; // 是否采用CRRT治疗
    public String getSAP_4_6_5() {  return this.SAP_4_6_5;}
    @JsonProperty("SAP-4-6-5")
    public void setSAP_4_6_5(final String SAP_4_6_5) { this.SAP_4_6_5=SAP_4_6_5;}
    @Column(name = "SAP_4_6_6")
    @JsonProperty("SAP-4-6-6")
    private String SAP_4_6_6; // CRRT治疗的指症
    public String getSAP_4_6_6() {  return this.SAP_4_6_6;}
    @JsonProperty("SAP-4-6-6")
    public void setSAP_4_6_6(final String SAP_4_6_6) { this.SAP_4_6_6=SAP_4_6_6;}
    @Column(name = "SAP_4_6_6_1")
    @JsonProperty("SAP-4-6-6-1")
    private String SAP_4_6_6_1; // 其他CRRT治疗的指症
    public String getSAP_4_6_6_1() {  return this.SAP_4_6_6_1;}
    @JsonProperty("SAP-4-6-6-1")
    public void setSAP_4_6_6_1(final String SAP_4_6_6_1) { this.SAP_4_6_6_1=SAP_4_6_6_1;}
    @Column(name = "SAP_4_6_7")
    @JsonProperty("SAP-4-6-7")
    private String SAP_4_6_7; // CRRT的治疗模式
    public String getSAP_4_6_7() {  return this.SAP_4_6_7;}
    @JsonProperty("SAP-4-6-7")
    public void setSAP_4_6_7(final String SAP_4_6_7) { this.SAP_4_6_7=SAP_4_6_7;}
    @Column(name = "SAP_4_6_7_1")
    @JsonProperty("SAP-4-6-7-1")
    private String SAP_4_6_7_1; // 其他CRRT的治疗模式
    public String getSAP_4_6_7_1() {  return this.SAP_4_6_7_1;}
    @JsonProperty("SAP-4-6-7-1")
    public void setSAP_4_6_7_1(final String SAP_4_6_7_1) { this.SAP_4_6_7_1=SAP_4_6_7_1;}
    @Column(name = "SAP_4_6_8")
    @JsonProperty("SAP-4-6-8")
    private String SAP_4_6_8; // CRRT的抗凝方式
    public String getSAP_4_6_8() {  return this.SAP_4_6_8;}
    @JsonProperty("SAP-4-6-8")
    public void setSAP_4_6_8(final String SAP_4_6_8) { this.SAP_4_6_8=SAP_4_6_8;}
    @Column(name = "SAP_4_6_8_1")
    @JsonProperty("SAP-4-6-8-1")
    private String SAP_4_6_8_1; // 其他CRRT的抗凝方式
    public String getSAP_4_6_8_1() {  return this.SAP_4_6_8_1;}
    @JsonProperty("SAP-4-6-8-1")
    public void setSAP_4_6_8_1(final String SAP_4_6_8_1) { this.SAP_4_6_8_1=SAP_4_6_8_1;}
    @Column(name = "SAP_5_1_9")
    @JsonProperty("SAP-5-1-9")
    private String SAP_5_1_9; // 是否进行外科操作
    public String getSAP_5_1_9() {  return this.SAP_5_1_9;}
    @JsonProperty("SAP-5-1-9")
    public void setSAP_5_1_9(final String SAP_5_1_9) { this.SAP_5_1_9=SAP_5_1_9;}
    @Column(name = "SAP_4_7_1")
    @JsonProperty("SAP-4-7-1")
    private String SAP_4_7_1; // 实施何种操作或者外科治疗
    public String getSAP_4_7_1() {  return this.SAP_4_7_1;}
    @JsonProperty("SAP-4-7-1")
    public void setSAP_4_7_1(final String SAP_4_7_1) { this.SAP_4_7_1=SAP_4_7_1;}
    @Column(name = "SAP_5_1_1")
    @JsonProperty("SAP-5-1-1")
    private String SAP_5_1_1; // IPN诊断的选择
    public String getSAP_5_1_1() {  return this.SAP_5_1_1;}
    @JsonProperty("SAP-5-1-1")
    public void setSAP_5_1_1(final String SAP_5_1_1) { this.SAP_5_1_1=SAP_5_1_1;}
    @Column(name = "SAP_5_1_2")
    @JsonProperty("SAP-5-1-2")
    private String SAP_5_1_2; // 是否有炎性标志物检测
    public String getSAP_5_1_2() {  return this.SAP_5_1_2;}
    @JsonProperty("SAP-5-1-2")
    public void setSAP_5_1_2(final String SAP_5_1_2) { this.SAP_5_1_2=SAP_5_1_2;}
    @Column(name = "SAP_5_1_2_1")
    @JsonProperty("SAP-5-1-2-1")
    private String SAP_5_1_2_1; // C反应蛋白浓度(mg/L)
    public String getSAP_5_1_2_1() {  return this.SAP_5_1_2_1;}
    @JsonProperty("SAP-5-1-2-1")
    public void setSAP_5_1_2_1(final String SAP_5_1_2_1) { this.SAP_5_1_2_1=SAP_5_1_2_1;}
    @Column(name = "SAP_5_1_2_2")
    @JsonProperty("SAP-5-1-2-2")
    private String SAP_5_1_2_2; // 血清降钙素原浓度(ng/mL)
    public String getSAP_5_1_2_2() {  return this.SAP_5_1_2_2;}
    @JsonProperty("SAP-5-1-2-2")
    public void setSAP_5_1_2_2(final String SAP_5_1_2_2) { this.SAP_5_1_2_2=SAP_5_1_2_2;}
    @Column(name = "SAP_5_1_3")
    @JsonProperty("SAP-5-1-3")
    private String SAP_5_1_3; // 是否有病原学检测
    public String getSAP_5_1_3() {  return this.SAP_5_1_3;}
    @JsonProperty("SAP-5-1-3")
    public void setSAP_5_1_3(final String SAP_5_1_3) { this.SAP_5_1_3=SAP_5_1_3;}
    @Column(name = "SAP_5_1_4")
    @JsonProperty("SAP-5-1-4")
    private String SAP_5_1_4; // 使用广谱或其他抗生素
    public String getSAP_5_1_4() {  return this.SAP_5_1_4;}
    @JsonProperty("SAP-5-1-4")
    public void setSAP_5_1_4(final String SAP_5_1_4) { this.SAP_5_1_4=SAP_5_1_4;}
    @Column(name = "SAP_5_1_5")
    @JsonProperty("SAP-5-1-5")
    private String SAP_5_1_5; // 手术干预主要指症的选择
    public String getSAP_5_1_5() {  return this.SAP_5_1_5;}
    @JsonProperty("SAP-5-1-5")
    public void setSAP_5_1_5(final String SAP_5_1_5) { this.SAP_5_1_5=SAP_5_1_5;}
    @Column(name = "SAP_5_1_5_1")
    @JsonProperty("SAP-5-1-5-1")
    private String SAP_5_1_5_1; // 其他手术干预主要指症
    public String getSAP_5_1_5_1() {  return this.SAP_5_1_5_1;}
    @JsonProperty("SAP-5-1-5-1")
    public void setSAP_5_1_5_1(final String SAP_5_1_5_1) { this.SAP_5_1_5_1=SAP_5_1_5_1;}
    @Column(name = "SAP_5_1_7")
    @JsonProperty("SAP-5-1-7")
    private String SAP_5_1_7; // 距急性胰腺炎发病时间
    public String getSAP_5_1_7() {  return this.SAP_5_1_7;}
    @JsonProperty("SAP-5-1-7")
    public void setSAP_5_1_7(final String SAP_5_1_7) { this.SAP_5_1_7=SAP_5_1_7;}
    @Column(name = "SAP_5_1_8")
    @JsonProperty("SAP-5-1-8")
    private String SAP_5_1_8; // 干预策略的方式选择
    public String getSAP_5_1_8() {  return this.SAP_5_1_8;}
    @JsonProperty("SAP-5-1-8")
    public void setSAP_5_1_8(final String SAP_5_1_8) { this.SAP_5_1_8=SAP_5_1_8;}
    @Column(name = "SAP_5_1_8_1")
    @JsonProperty("SAP-5-1-8-1")
    private String SAP_5_1_8_1; // Step 1  手术干预方式
    public String getSAP_5_1_8_1() {  return this.SAP_5_1_8_1;}
    @JsonProperty("SAP-5-1-8-1")
    public void setSAP_5_1_8_1(final String SAP_5_1_8_1) { this.SAP_5_1_8_1=SAP_5_1_8_1;}
    @Column(name = "SAP_5_1_8_2")
    @JsonProperty("SAP-5-1-8-2")
    private String SAP_5_1_8_2; // ICD-9-CM-3编码与名称
    public String getSAP_5_1_8_2() {  return this.SAP_5_1_8_2;}
    @JsonProperty("SAP-5-1-8-2")
    public void setSAP_5_1_8_2(final String SAP_5_1_8_2) { this.SAP_5_1_8_2=SAP_5_1_8_2;}
    @Column(name = "SAP_5_1_8_3")
    @JsonProperty("SAP-5-1-8-3")
    private String SAP_5_1_8_3; // Step 1  手术干预日期时间
    public String getSAP_5_1_8_3() {  return this.SAP_5_1_8_3;}
    @JsonProperty("SAP-5-1-8-3")
    public void setSAP_5_1_8_3(final String SAP_5_1_8_3) { this.SAP_5_1_8_3=SAP_5_1_8_3;}
    @Column(name = "SAP_5_1_8_4")
    @JsonProperty("SAP-5-1-8-4")
    private String SAP_5_1_8_4; // Step 2  手术干预方式
    public String getSAP_5_1_8_4() {  return this.SAP_5_1_8_4;}
    @JsonProperty("SAP-5-1-8-4")
    public void setSAP_5_1_8_4(final String SAP_5_1_8_4) { this.SAP_5_1_8_4=SAP_5_1_8_4;}
    @Column(name = "SAP_5_1_8_5")
    @JsonProperty("SAP-5-1-8-5")
    private String SAP_5_1_8_5; // ICD-9-CM-3编码与名称
    public String getSAP_5_1_8_5() {  return this.SAP_5_1_8_5;}
    @JsonProperty("SAP-5-1-8-5")
    public void setSAP_5_1_8_5(final String SAP_5_1_8_5) { this.SAP_5_1_8_5=SAP_5_1_8_5;}
    @Column(name = "SAP_5_1_8_6")
    @JsonProperty("SAP-5-1-8-6")
    private String SAP_5_1_8_6; // Step 2  手术干预日期时间
    public String getSAP_5_1_8_6() {  return this.SAP_5_1_8_6;}
    @JsonProperty("SAP-5-1-8-6")
    public void setSAP_5_1_8_6(final String SAP_5_1_8_6) { this.SAP_5_1_8_6=SAP_5_1_8_6;}
    @Column(name = "SAP_5_1_8_7")
    @JsonProperty("SAP-5-1-8-7")
    private String SAP_5_1_8_7; // Step 3  手术干预方式
    public String getSAP_5_1_8_7() {  return this.SAP_5_1_8_7;}
    @JsonProperty("SAP-5-1-8-7")
    public void setSAP_5_1_8_7(final String SAP_5_1_8_7) { this.SAP_5_1_8_7=SAP_5_1_8_7;}
    @Column(name = "SAP_5_1_8_8")
    @JsonProperty("SAP-5-1-8-8")
    private String SAP_5_1_8_8; // ICD-9-CM-3编码与名称
    public String getSAP_5_1_8_8() {  return this.SAP_5_1_8_8;}
    @JsonProperty("SAP-5-1-8-8")
    public void setSAP_5_1_8_8(final String SAP_5_1_8_8) { this.SAP_5_1_8_8=SAP_5_1_8_8;}
    @Column(name = "SAP_5_1_8_9")
    @JsonProperty("SAP-5-1-8-9")
    private String SAP_5_1_8_9; // Step 3  手术干预日期时间
    public String getSAP_5_1_8_9() {  return this.SAP_5_1_8_9;}
    @JsonProperty("SAP-5-1-8-9")
    public void setSAP_5_1_8_9(final String SAP_5_1_8_9) { this.SAP_5_1_8_9=SAP_5_1_8_9;}
    @Column(name = "SAP_5_1_8_10")
    @JsonProperty("SAP-5-1-8-10")
    private String SAP_5_1_8_10; // Step 4  手术干预方式
    public String getSAP_5_1_8_10() {  return this.SAP_5_1_8_10;}
    @JsonProperty("SAP-5-1-8-10")
    public void setSAP_5_1_8_10(final String SAP_5_1_8_10) { this.SAP_5_1_8_10=SAP_5_1_8_10;}
    @Column(name = "SAP_5_1_8_11")
    @JsonProperty("SAP-5-1-8-11")
    private String SAP_5_1_8_11; // ICD-9-CM-3编码与名称
    public String getSAP_5_1_8_11() {  return this.SAP_5_1_8_11;}
    @JsonProperty("SAP-5-1-8-11")
    public void setSAP_5_1_8_11(final String SAP_5_1_8_11) { this.SAP_5_1_8_11=SAP_5_1_8_11;}
    @Column(name = "SAP_5_1_8_12")
    @JsonProperty("SAP-5-1-8-12")
    private String SAP_5_1_8_12; // Step 4  手术干预日期时间
    public String getSAP_5_1_8_12() {  return this.SAP_5_1_8_12;}
    @JsonProperty("SAP-5-1-8-12")
    public void setSAP_5_1_8_12(final String SAP_5_1_8_12) { this.SAP_5_1_8_12=SAP_5_1_8_12;}
    @Column(name = "SAP_5_2_1")
    @JsonProperty("SAP-5-2-1")
    private String SAP_5_2_1; // 伴有急性胆管炎、胆道梗阻的AP是否ERCP / EST治疗
    public String getSAP_5_2_1() {  return this.SAP_5_2_1;}
    @JsonProperty("SAP-5-2-1")
    public void setSAP_5_2_1(final String SAP_5_2_1) { this.SAP_5_2_1=SAP_5_2_1;}
    @Column(name = "SAP_5_2_2")
    @JsonProperty("SAP-5-2-2")
    private String SAP_5_2_2; // 伴有急性胆管炎、胆道梗阻的ERCP / EST治疗指症
    public String getSAP_5_2_2() {  return this.SAP_5_2_2;}
    @JsonProperty("SAP-5-2-2")
    public void setSAP_5_2_2(final String SAP_5_2_2) { this.SAP_5_2_2=SAP_5_2_2;}
    @Column(name = "SAP_5_2_2_1")
    @JsonProperty("SAP-5-2-2-1")
    private String SAP_5_2_2_1; // 其他指症
    public String getSAP_5_2_2_1() {  return this.SAP_5_2_2_1;}
    @JsonProperty("SAP-5-2-2-1")
    public void setSAP_5_2_2_1(final String SAP_5_2_2_1) { this.SAP_5_2_2_1=SAP_5_2_2_1;}
    @Column(name = "SAP_5_2_3")
    @JsonProperty("SAP-5-2-3")
    private String SAP_5_2_3; // 手术/或治疗性操作名称的选择
    public String getSAP_5_2_3() {  return this.SAP_5_2_3;}
    @JsonProperty("SAP-5-2-3")
    public void setSAP_5_2_3(final String SAP_5_2_3) { this.SAP_5_2_3=SAP_5_2_3;}
    @Column(name = "SAP_5_2_3_1")
    @JsonProperty("SAP-5-2-3-1")
    private String SAP_5_2_3_1; // 其他检查
    public String getSAP_5_2_3_1() {  return this.SAP_5_2_3_1;}
    @JsonProperty("SAP-5-2-3-1")
    public void setSAP_5_2_3_1(final String SAP_5_2_3_1) { this.SAP_5_2_3_1=SAP_5_2_3_1;}
    @Column(name = "SAP_5_2_4")
    @JsonProperty("SAP-5-2-4")
    private String SAP_5_2_4; // 诊疗措施 实施日期时间
    public String getSAP_5_2_4() {  return this.SAP_5_2_4;}
    @JsonProperty("SAP-5-2-4")
    public void setSAP_5_2_4(final String SAP_5_2_4) { this.SAP_5_2_4=SAP_5_2_4;}
    @Column(name = "SAP_5_3_1")
    @JsonProperty("SAP-5-3-1")
    private String SAP_5_3_1; // 是否（腹腔镜）胆囊切除术治疗
    public String getSAP_5_3_1() {  return this.SAP_5_3_1;}
    @JsonProperty("SAP-5-3-1")
    public void setSAP_5_3_1(final String SAP_5_3_1) { this.SAP_5_3_1=SAP_5_3_1;}
    @Column(name = "SAP_5_3_2")
    @JsonProperty("SAP-5-3-2")
    private String SAP_5_3_2; // （腹腔镜）胆囊切除术治疗指征
    public String getSAP_5_3_2() {  return this.SAP_5_3_2;}
    @JsonProperty("SAP-5-3-2")
    public void setSAP_5_3_2(final String SAP_5_3_2) { this.SAP_5_3_2=SAP_5_3_2;}
    @Column(name = "SAP_5_3_2_1")
    @JsonProperty("SAP-5-3-2-1")
    private String SAP_5_3_2_1; // 其他指征
    public String getSAP_5_3_2_1() {  return this.SAP_5_3_2_1;}
    @JsonProperty("SAP-5-3-2-1")
    public void setSAP_5_3_2_1(final String SAP_5_3_2_1) { this.SAP_5_3_2_1=SAP_5_3_2_1;}
    @Column(name = "SAP_5_3_3")
    @JsonProperty("SAP-5-3-3")
    private String SAP_5_3_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_3_3() {  return this.SAP_5_3_3;}
    @JsonProperty("SAP-5-3-3")
    public void setSAP_5_3_3(final String SAP_5_3_3) { this.SAP_5_3_3=SAP_5_3_3;}
    @Column(name = "SAP_5_3_3_1")
    @JsonProperty("SAP-5-3-3-1")
    private String SAP_5_3_3_1; // 其他手术
    public String getSAP_5_3_3_1() {  return this.SAP_5_3_3_1;}
    @JsonProperty("SAP-5-3-3-1")
    public void setSAP_5_3_3_1(final String SAP_5_3_3_1) { this.SAP_5_3_3_1=SAP_5_3_3_1;}
    @Column(name = "SAP_5_3_4")
    @JsonProperty("SAP-5-3-4")
    private String SAP_5_3_4; // 诊疗措施 实施日期时间
    public String getSAP_5_3_4() {  return this.SAP_5_3_4;}
    @JsonProperty("SAP-5-3-4")
    public void setSAP_5_3_4(final String SAP_5_3_4) { this.SAP_5_3_4=SAP_5_3_4;}
    @Column(name = "SAP_5_4_1")
    @JsonProperty("SAP-5-4-1")
    private String SAP_5_4_1; // 是否胆道取石术治疗
    public String getSAP_5_4_1() {  return this.SAP_5_4_1;}
    @JsonProperty("SAP-5-4-1")
    public void setSAP_5_4_1(final String SAP_5_4_1) { this.SAP_5_4_1=SAP_5_4_1;}
    @Column(name = "SAP_5_4_2")
    @JsonProperty("SAP-5-4-2")
    private String SAP_5_4_2; // 胆道取石术指征
    public String getSAP_5_4_2() {  return this.SAP_5_4_2;}
    @JsonProperty("SAP-5-4-2")
    public void setSAP_5_4_2(final String SAP_5_4_2) { this.SAP_5_4_2=SAP_5_4_2;}
    @Column(name = "SAP_5_4_2_1")
    @JsonProperty("SAP-5-4-2-1")
    private String SAP_5_4_2_1; // 其他指征
    public String getSAP_5_4_2_1() {  return this.SAP_5_4_2_1;}
    @JsonProperty("SAP-5-4-2-1")
    public void setSAP_5_4_2_1(final String SAP_5_4_2_1) { this.SAP_5_4_2_1=SAP_5_4_2_1;}
    @Column(name = "SAP_5_4_3")
    @JsonProperty("SAP-5-4-3")
    private String SAP_5_4_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_4_3() {  return this.SAP_5_4_3;}
    @JsonProperty("SAP-5-4-3")
    public void setSAP_5_4_3(final String SAP_5_4_3) { this.SAP_5_4_3=SAP_5_4_3;}
    @Column(name = "SAP_5_4_3_1")
    @JsonProperty("SAP-5-4-3-1")
    private String SAP_5_4_3_1; // 其他手术
    public String getSAP_5_4_3_1() {  return this.SAP_5_4_3_1;}
    @JsonProperty("SAP-5-4-3-1")
    public void setSAP_5_4_3_1(final String SAP_5_4_3_1) { this.SAP_5_4_3_1=SAP_5_4_3_1;}
    @Column(name = "SAP_5_4_4")
    @JsonProperty("SAP-5-4-4")
    private String SAP_5_4_4; // 诊疗措施 实施日期时间
    public String getSAP_5_4_4() {  return this.SAP_5_4_4;}
    @JsonProperty("SAP-5-4-4")
    public void setSAP_5_4_4(final String SAP_5_4_4) { this.SAP_5_4_4=SAP_5_4_4;}
    @Column(name = "SAP_5_5_1")
    @JsonProperty("SAP-5-5-1")
    private String SAP_5_5_1; // 是否慢性胰腺炎急性发作行手术治疗
    public String getSAP_5_5_1() {  return this.SAP_5_5_1;}
    @JsonProperty("SAP-5-5-1")
    public void setSAP_5_5_1(final String SAP_5_5_1) { this.SAP_5_5_1=SAP_5_5_1;}
    @Column(name = "SAP_5_5_2")
    @JsonProperty("SAP-5-5-2")
    private String SAP_5_5_2; // 慢性胰腺炎急性发作手术指征
    public String getSAP_5_5_2() {  return this.SAP_5_5_2;}
    @JsonProperty("SAP-5-5-2")
    public void setSAP_5_5_2(final String SAP_5_5_2) { this.SAP_5_5_2=SAP_5_5_2;}
    @Column(name = "SAP_5_5_2_1")
    @JsonProperty("SAP-5-5-2-1")
    private String SAP_5_5_2_1; // 其他指征
    public String getSAP_5_5_2_1() {  return this.SAP_5_5_2_1;}
    @JsonProperty("SAP-5-5-2-1")
    public void setSAP_5_5_2_1(final String SAP_5_5_2_1) { this.SAP_5_5_2_1=SAP_5_5_2_1;}
    @Column(name = "SAP_5_5_3")
    @JsonProperty("SAP-5-5-3")
    private String SAP_5_5_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_5_3() {  return this.SAP_5_5_3;}
    @JsonProperty("SAP-5-5-3")
    public void setSAP_5_5_3(final String SAP_5_5_3) { this.SAP_5_5_3=SAP_5_5_3;}
    @Column(name = "SAP_5_5_3_1")
    @JsonProperty("SAP-5-5-3-1")
    private String SAP_5_5_3_1; // 其他手术
    public String getSAP_5_5_3_1() {  return this.SAP_5_5_3_1;}
    @JsonProperty("SAP-5-5-3-1")
    public void setSAP_5_5_3_1(final String SAP_5_5_3_1) { this.SAP_5_5_3_1=SAP_5_5_3_1;}
    @Column(name = "SAP_5_5_4")
    @JsonProperty("SAP-5-5-4")
    private String SAP_5_5_4; // 诊疗措施 实施日期时间
    public String getSAP_5_5_4() {  return this.SAP_5_5_4;}
    @JsonProperty("SAP-5-5-4")
    public void setSAP_5_5_4(final String SAP_5_5_4) { this.SAP_5_5_4=SAP_5_5_4;}
    @Column(name = "SAP_5_6_1")
    @JsonProperty("SAP-5-6-1")
    private String SAP_5_6_1; // 是否穿刺治疗
    public String getSAP_5_6_1() {  return this.SAP_5_6_1;}
    @JsonProperty("SAP-5-6-1")
    public void setSAP_5_6_1(final String SAP_5_6_1) { this.SAP_5_6_1=SAP_5_6_1;}
    @Column(name = "SAP_5_6_2")
    @JsonProperty("SAP-5-6-2")
    private String SAP_5_6_2; // 穿刺指征
    public String getSAP_5_6_2() {  return this.SAP_5_6_2;}
    @JsonProperty("SAP-5-6-2")
    public void setSAP_5_6_2(final String SAP_5_6_2) { this.SAP_5_6_2=SAP_5_6_2;}
    @Column(name = "SAP_5_6_2_1")
    @JsonProperty("SAP-5-6-2-1")
    private String SAP_5_6_2_1; // 其他指征
    public String getSAP_5_6_2_1() {  return this.SAP_5_6_2_1;}
    @JsonProperty("SAP-5-6-2-1")
    public void setSAP_5_6_2_1(final String SAP_5_6_2_1) { this.SAP_5_6_2_1=SAP_5_6_2_1;}
    @Column(name = "SAP_5_6_3")
    @JsonProperty("SAP-5-6-3")
    private String SAP_5_6_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_6_3() {  return this.SAP_5_6_3;}
    @JsonProperty("SAP-5-6-3")
    public void setSAP_5_6_3(final String SAP_5_6_3) { this.SAP_5_6_3=SAP_5_6_3;}
    @Column(name = "SAP_5_6_3_1")
    @JsonProperty("SAP-5-6-3-1")
    private String SAP_5_6_3_1; // 其他穿刺手术
    public String getSAP_5_6_3_1() {  return this.SAP_5_6_3_1;}
    @JsonProperty("SAP-5-6-3-1")
    public void setSAP_5_6_3_1(final String SAP_5_6_3_1) { this.SAP_5_6_3_1=SAP_5_6_3_1;}
    @Column(name = "SAP_5_6_4")
    @JsonProperty("SAP-5-6-4")
    private String SAP_5_6_4; // 诊疗措施 实施日期时间
    public String getSAP_5_6_4() {  return this.SAP_5_6_4;}
    @JsonProperty("SAP-5-6-4")
    public void setSAP_5_6_4(final String SAP_5_6_4) { this.SAP_5_6_4=SAP_5_6_4;}
    @Column(name = "SAP_5_6_5")
    @JsonProperty("SAP-5-6-5")
    private String SAP_5_6_5; // 是否外科手术治疗
    public String getSAP_5_6_5() {  return this.SAP_5_6_5;}
    @JsonProperty("SAP-5-6-5")
    public void setSAP_5_6_5(final String SAP_5_6_5) { this.SAP_5_6_5=SAP_5_6_5;}
    @Column(name = "SAP_5_6_6")
    @JsonProperty("SAP-5-6-6")
    private String SAP_5_6_6; // 外科手术指征
    public String getSAP_5_6_6() {  return this.SAP_5_6_6;}
    @JsonProperty("SAP-5-6-6")
    public void setSAP_5_6_6(final String SAP_5_6_6) { this.SAP_5_6_6=SAP_5_6_6;}
    @Column(name = "SAP_5_6_6_1")
    @JsonProperty("SAP-5-6-6-1")
    private String SAP_5_6_6_1; // 其他指征
    public String getSAP_5_6_6_1() {  return this.SAP_5_6_6_1;}
    @JsonProperty("SAP-5-6-6-1")
    public void setSAP_5_6_6_1(final String SAP_5_6_6_1) { this.SAP_5_6_6_1=SAP_5_6_6_1;}
    @Column(name = "SAP_5_6_7")
    @JsonProperty("SAP-5-6-7")
    private String SAP_5_6_7; // 手术或治疗性操作名称的选择
    public String getSAP_5_6_7() {  return this.SAP_5_6_7;}
    @JsonProperty("SAP-5-6-7")
    public void setSAP_5_6_7(final String SAP_5_6_7) { this.SAP_5_6_7=SAP_5_6_7;}
    @Column(name = "SAP_5_6_7_1")
    @JsonProperty("SAP-5-6-7-1")
    private String SAP_5_6_7_1; // 其他手术
    public String getSAP_5_6_7_1() {  return this.SAP_5_6_7_1;}
    @JsonProperty("SAP-5-6-7-1")
    public void setSAP_5_6_7_1(final String SAP_5_6_7_1) { this.SAP_5_6_7_1=SAP_5_6_7_1;}
    @Column(name = "SAP_5_6_8")
    @JsonProperty("SAP-5-6-8")
    private String SAP_5_6_8; // 诊疗措施 实施日期时间
    public String getSAP_5_6_8() {  return this.SAP_5_6_8;}
    @JsonProperty("SAP-5-6-8")
    public void setSAP_5_6_8(final String SAP_5_6_8) { this.SAP_5_6_8=SAP_5_6_8;}
    @Column(name = "SAP_5_7_1")
    @JsonProperty("SAP-5-7-1")
    private String SAP_5_7_1; // 是否穿刺治疗
    public String getSAP_5_7_1() {  return this.SAP_5_7_1;}
    @JsonProperty("SAP-5-7-1")
    public void setSAP_5_7_1(final String SAP_5_7_1) { this.SAP_5_7_1=SAP_5_7_1;}
    @Column(name = "SAP_5_7_2")
    @JsonProperty("SAP-5-7-2")
    private String SAP_5_7_2; // 穿刺指征
    public String getSAP_5_7_2() {  return this.SAP_5_7_2;}
    @JsonProperty("SAP-5-7-2")
    public void setSAP_5_7_2(final String SAP_5_7_2) { this.SAP_5_7_2=SAP_5_7_2;}
    @Column(name = "SAP_5_7_2_1")
    @JsonProperty("SAP-5-7-2-1")
    private String SAP_5_7_2_1; // 其他指征
    public String getSAP_5_7_2_1() {  return this.SAP_5_7_2_1;}
    @JsonProperty("SAP-5-7-2-1")
    public void setSAP_5_7_2_1(final String SAP_5_7_2_1) { this.SAP_5_7_2_1=SAP_5_7_2_1;}
    @Column(name = "SAP_5_7_3")
    @JsonProperty("SAP-5-7-3")
    private String SAP_5_7_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_7_3() {  return this.SAP_5_7_3;}
    @JsonProperty("SAP-5-7-3")
    public void setSAP_5_7_3(final String SAP_5_7_3) { this.SAP_5_7_3=SAP_5_7_3;}
    @Column(name = "SAP_5_7_3_1")
    @JsonProperty("SAP-5-7-3-1")
    private String SAP_5_7_3_1; // 其他穿刺手术
    public String getSAP_5_7_3_1() {  return this.SAP_5_7_3_1;}
    @JsonProperty("SAP-5-7-3-1")
    public void setSAP_5_7_3_1(final String SAP_5_7_3_1) { this.SAP_5_7_3_1=SAP_5_7_3_1;}
    @Column(name = "SAP_5_7_4")
    @JsonProperty("SAP-5-7-4")
    private String SAP_5_7_4; // 诊疗措施 实施日期时间
    public String getSAP_5_7_4() {  return this.SAP_5_7_4;}
    @JsonProperty("SAP-5-7-4")
    public void setSAP_5_7_4(final String SAP_5_7_4) { this.SAP_5_7_4=SAP_5_7_4;}
    @Column(name = "SAP_5_7_5")
    @JsonProperty("SAP-5-7-5")
    private String SAP_5_7_5; // 是否外科手术治疗
    public String getSAP_5_7_5() {  return this.SAP_5_7_5;}
    @JsonProperty("SAP-5-7-5")
    public void setSAP_5_7_5(final String SAP_5_7_5) { this.SAP_5_7_5=SAP_5_7_5;}
    @Column(name = "SAP_5_7_6")
    @JsonProperty("SAP-5-7-6")
    private String SAP_5_7_6; // 外科手术指征
    public String getSAP_5_7_6() {  return this.SAP_5_7_6;}
    @JsonProperty("SAP-5-7-6")
    public void setSAP_5_7_6(final String SAP_5_7_6) { this.SAP_5_7_6=SAP_5_7_6;}
    @Column(name = "SAP_5_7_6_1")
    @JsonProperty("SAP-5-7-6-1")
    private String SAP_5_7_6_1; // 其他指征
    public String getSAP_5_7_6_1() {  return this.SAP_5_7_6_1;}
    @JsonProperty("SAP-5-7-6-1")
    public void setSAP_5_7_6_1(final String SAP_5_7_6_1) { this.SAP_5_7_6_1=SAP_5_7_6_1;}
    @Column(name = "SAP_5_7_7")
    @JsonProperty("SAP-5-7-7")
    private String SAP_5_7_7; // 手术或治疗性操作名称的选择
    public String getSAP_5_7_7() {  return this.SAP_5_7_7;}
    @JsonProperty("SAP-5-7-7")
    public void setSAP_5_7_7(final String SAP_5_7_7) { this.SAP_5_7_7=SAP_5_7_7;}
    @Column(name = "SAP_5_7_7_1")
    @JsonProperty("SAP-5-7-7-1")
    private String SAP_5_7_7_1; // 其他手术
    public String getSAP_5_7_7_1() {  return this.SAP_5_7_7_1;}
    @JsonProperty("SAP-5-7-7-1")
    public void setSAP_5_7_7_1(final String SAP_5_7_7_1) { this.SAP_5_7_7_1=SAP_5_7_7_1;}
    @Column(name = "SAP_5_7_8")
    @JsonProperty("SAP-5-7-8")
    private String SAP_5_7_8; // 诊疗措施 实施日期时间
    public String getSAP_5_7_8() {  return this.SAP_5_7_8;}
    @JsonProperty("SAP-5-7-8")
    public void setSAP_5_7_8(final String SAP_5_7_8) { this.SAP_5_7_8=SAP_5_7_8;}
    @Column(name = "SAP_5_8_1")
    @JsonProperty("SAP-5-8-1")
    private String SAP_5_8_1; // 是否穿刺治疗
    public String getSAP_5_8_1() {  return this.SAP_5_8_1;}
    @JsonProperty("SAP-5-8-1")
    public void setSAP_5_8_1(final String SAP_5_8_1) { this.SAP_5_8_1=SAP_5_8_1;}
    @Column(name = "SAP_5_8_2")
    @JsonProperty("SAP-5-8-2")
    private String SAP_5_8_2; // 穿刺指征
    public String getSAP_5_8_2() {  return this.SAP_5_8_2;}
    @JsonProperty("SAP-5-8-2")
    public void setSAP_5_8_2(final String SAP_5_8_2) { this.SAP_5_8_2=SAP_5_8_2;}
    @Column(name = "SAP_5_8_2_1")
    @JsonProperty("SAP-5-8-2-1")
    private String SAP_5_8_2_1; // 其他指征
    public String getSAP_5_8_2_1() {  return this.SAP_5_8_2_1;}
    @JsonProperty("SAP-5-8-2-1")
    public void setSAP_5_8_2_1(final String SAP_5_8_2_1) { this.SAP_5_8_2_1=SAP_5_8_2_1;}
    @Column(name = "SAP_5_8_3")
    @JsonProperty("SAP-5-8-3")
    private String SAP_5_8_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_8_3() {  return this.SAP_5_8_3;}
    @JsonProperty("SAP-5-8-3")
    public void setSAP_5_8_3(final String SAP_5_8_3) { this.SAP_5_8_3=SAP_5_8_3;}
    @Column(name = "SAP_5_8_3_1")
    @JsonProperty("SAP-5-8-3-1")
    private String SAP_5_8_3_1; // 其他穿刺手术
    public String getSAP_5_8_3_1() {  return this.SAP_5_8_3_1;}
    @JsonProperty("SAP-5-8-3-1")
    public void setSAP_5_8_3_1(final String SAP_5_8_3_1) { this.SAP_5_8_3_1=SAP_5_8_3_1;}
    @Column(name = "SAP_5_8_4")
    @JsonProperty("SAP-5-8-4")
    private String SAP_5_8_4; // 诊疗措施 实施日期时间
    public String getSAP_5_8_4() {  return this.SAP_5_8_4;}
    @JsonProperty("SAP-5-8-4")
    public void setSAP_5_8_4(final String SAP_5_8_4) { this.SAP_5_8_4=SAP_5_8_4;}
    @Column(name = "SAP_5_8_5")
    @JsonProperty("SAP-5-8-5")
    private String SAP_5_8_5; // 是否外科手术治疗
    public String getSAP_5_8_5() {  return this.SAP_5_8_5;}
    @JsonProperty("SAP-5-8-5")
    public void setSAP_5_8_5(final String SAP_5_8_5) { this.SAP_5_8_5=SAP_5_8_5;}
    @Column(name = "SAP_5_8_6")
    @JsonProperty("SAP-5-8-6")
    private String SAP_5_8_6; // 外科手术指征
    public String getSAP_5_8_6() {  return this.SAP_5_8_6;}
    @JsonProperty("SAP-5-8-6")
    public void setSAP_5_8_6(final String SAP_5_8_6) { this.SAP_5_8_6=SAP_5_8_6;}
    @Column(name = "SAP_5_8_6_1")
    @JsonProperty("SAP-5-8-6-1")
    private String SAP_5_8_6_1; // 其他指征
    public String getSAP_5_8_6_1() {  return this.SAP_5_8_6_1;}
    @JsonProperty("SAP-5-8-6-1")
    public void setSAP_5_8_6_1(final String SAP_5_8_6_1) { this.SAP_5_8_6_1=SAP_5_8_6_1;}
    @Column(name = "SAP_5_8_7")
    @JsonProperty("SAP-5-8-7")
    private String SAP_5_8_7; // 手术或治疗性操作名称的选择
    public String getSAP_5_8_7() {  return this.SAP_5_8_7;}
    @JsonProperty("SAP-5-8-7")
    public void setSAP_5_8_7(final String SAP_5_8_7) { this.SAP_5_8_7=SAP_5_8_7;}
    @Column(name = "SAP_5_8_7_1")
    @JsonProperty("SAP-5-8-7-1")
    private String SAP_5_8_7_1; // 其他手术
    public String getSAP_5_8_7_1() {  return this.SAP_5_8_7_1;}
    @JsonProperty("SAP-5-8-7-1")
    public void setSAP_5_8_7_1(final String SAP_5_8_7_1) { this.SAP_5_8_7_1=SAP_5_8_7_1;}
    @Column(name = "SAP_5_8_8")
    @JsonProperty("SAP-5-8-8")
    private String SAP_5_8_8; // 诊疗措施 实施日期时间
    public String getSAP_5_8_8() {  return this.SAP_5_8_8;}
    @JsonProperty("SAP-5-8-8")
    public void setSAP_5_8_8(final String SAP_5_8_8) { this.SAP_5_8_8=SAP_5_8_8;}
    @Column(name = "SAP_5_9_1")
    @JsonProperty("SAP-5-9-1")
    private String SAP_5_9_1; // 是否行胰管断裂综合征手术治疗
    public String getSAP_5_9_1() {  return this.SAP_5_9_1;}
    @JsonProperty("SAP-5-9-1")
    public void setSAP_5_9_1(final String SAP_5_9_1) { this.SAP_5_9_1=SAP_5_9_1;}
    @Column(name = "SAP_5_9_2")
    @JsonProperty("SAP-5-9-2")
    private String SAP_5_9_2; // 手术指征
    public String getSAP_5_9_2() {  return this.SAP_5_9_2;}
    @JsonProperty("SAP-5-9-2")
    public void setSAP_5_9_2(final String SAP_5_9_2) { this.SAP_5_9_2=SAP_5_9_2;}
    @Column(name = "SAP_5_9_2_1")
    @JsonProperty("SAP-5-9-2-1")
    private String SAP_5_9_2_1; // 手术指征
    public String getSAP_5_9_2_1() {  return this.SAP_5_9_2_1;}
    @JsonProperty("SAP-5-9-2-1")
    public void setSAP_5_9_2_1(final String SAP_5_9_2_1) { this.SAP_5_9_2_1=SAP_5_9_2_1;}
    @Column(name = "SAP_5_9_3")
    @JsonProperty("SAP-5-9-3")
    private String SAP_5_9_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_9_3() {  return this.SAP_5_9_3;}
    @JsonProperty("SAP-5-9-3")
    public void setSAP_5_9_3(final String SAP_5_9_3) { this.SAP_5_9_3=SAP_5_9_3;}
    @Column(name = "SAP_5_9_3_1")
    @JsonProperty("SAP-5-9-3-1")
    private String SAP_5_9_3_1; // 其他手术
    public String getSAP_5_9_3_1() {  return this.SAP_5_9_3_1;}
    @JsonProperty("SAP-5-9-3-1")
    public void setSAP_5_9_3_1(final String SAP_5_9_3_1) { this.SAP_5_9_3_1=SAP_5_9_3_1;}
    @Column(name = "SAP_5_9_4")
    @JsonProperty("SAP-5-9-4")
    private String SAP_5_9_4; // 诊疗措施 实施日期时间
    public String getSAP_5_9_4() {  return this.SAP_5_9_4;}
    @JsonProperty("SAP-5-9-4")
    public void setSAP_5_9_4(final String SAP_5_9_4) { this.SAP_5_9_4=SAP_5_9_4;}
    @Column(name = "SAP_5_10_1")
    @JsonProperty("SAP-5-10-1")
    private String SAP_5_10_1; // 是否行胰源性门脉高压手术治疗
    public String getSAP_5_10_1() {  return this.SAP_5_10_1;}
    @JsonProperty("SAP-5-10-1")
    public void setSAP_5_10_1(final String SAP_5_10_1) { this.SAP_5_10_1=SAP_5_10_1;}
    @Column(name = "SAP_5_10_2")
    @JsonProperty("SAP-5-10-2")
    private String SAP_5_10_2; // 手术指征
    public String getSAP_5_10_2() {  return this.SAP_5_10_2;}
    @JsonProperty("SAP-5-10-2")
    public void setSAP_5_10_2(final String SAP_5_10_2) { this.SAP_5_10_2=SAP_5_10_2;}
    @Column(name = "SAP_5_10_2_1")
    @JsonProperty("SAP-5-10-2-1")
    private String SAP_5_10_2_1; // 手术指征
    public String getSAP_5_10_2_1() {  return this.SAP_5_10_2_1;}
    @JsonProperty("SAP-5-10-2-1")
    public void setSAP_5_10_2_1(final String SAP_5_10_2_1) { this.SAP_5_10_2_1=SAP_5_10_2_1;}
    @Column(name = "SAP_5_10_3")
    @JsonProperty("SAP-5-10-3")
    private String SAP_5_10_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_10_3() {  return this.SAP_5_10_3;}
    @JsonProperty("SAP-5-10-3")
    public void setSAP_5_10_3(final String SAP_5_10_3) { this.SAP_5_10_3=SAP_5_10_3;}
    @Column(name = "SAP_5_10_3_1")
    @JsonProperty("SAP-5-10-3-1")
    private String SAP_5_10_3_1; // 其他手术
    public String getSAP_5_10_3_1() {  return this.SAP_5_10_3_1;}
    @JsonProperty("SAP-5-10-3-1")
    public void setSAP_5_10_3_1(final String SAP_5_10_3_1) { this.SAP_5_10_3_1=SAP_5_10_3_1;}
    @Column(name = "SAP_5_10_4")
    @JsonProperty("SAP-5-10-4")
    private String SAP_5_10_4; // 诊疗措施 实施日期时间
    public String getSAP_5_10_4() {  return this.SAP_5_10_4;}
    @JsonProperty("SAP-5-10-4")
    public void setSAP_5_10_4(final String SAP_5_10_4) { this.SAP_5_10_4=SAP_5_10_4;}
    @Column(name = "SAP_5_11_1")
    @JsonProperty("SAP-5-11-1")
    private String SAP_5_11_1; // 是否行腹腔出血的手术治疗
    public String getSAP_5_11_1() {  return this.SAP_5_11_1;}
    @JsonProperty("SAP-5-11-1")
    public void setSAP_5_11_1(final String SAP_5_11_1) { this.SAP_5_11_1=SAP_5_11_1;}
    @Column(name = "SAP_5_11_2")
    @JsonProperty("SAP-5-11-2")
    private String SAP_5_11_2; // 手术指征
    public String getSAP_5_11_2() {  return this.SAP_5_11_2;}
    @JsonProperty("SAP-5-11-2")
    public void setSAP_5_11_2(final String SAP_5_11_2) { this.SAP_5_11_2=SAP_5_11_2;}
    @Column(name = "SAP_5_11_2_1")
    @JsonProperty("SAP-5-11-2-1")
    private String SAP_5_11_2_1; // 手术指征
    public String getSAP_5_11_2_1() {  return this.SAP_5_11_2_1;}
    @JsonProperty("SAP-5-11-2-1")
    public void setSAP_5_11_2_1(final String SAP_5_11_2_1) { this.SAP_5_11_2_1=SAP_5_11_2_1;}
    @Column(name = "SAP_5_11_3")
    @JsonProperty("SAP-5-11-3")
    private String SAP_5_11_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_11_3() {  return this.SAP_5_11_3;}
    @JsonProperty("SAP-5-11-3")
    public void setSAP_5_11_3(final String SAP_5_11_3) { this.SAP_5_11_3=SAP_5_11_3;}
    @Column(name = "SAP_5_11_3_1")
    @JsonProperty("SAP-5-11-3-1")
    private String SAP_5_11_3_1; // 其他手术
    public String getSAP_5_11_3_1() {  return this.SAP_5_11_3_1;}
    @JsonProperty("SAP-5-11-3-1")
    public void setSAP_5_11_3_1(final String SAP_5_11_3_1) { this.SAP_5_11_3_1=SAP_5_11_3_1;}
    @Column(name = "SAP_5_11_4")
    @JsonProperty("SAP-5-11-4")
    private String SAP_5_11_4; // 诊疗措施 实施日期时间
    public String getSAP_5_11_4() {  return this.SAP_5_11_4;}
    @JsonProperty("SAP-5-11-4")
    public void setSAP_5_11_4(final String SAP_5_11_4) { this.SAP_5_11_4=SAP_5_11_4;}
    @Column(name = "SAP_5_12_1")
    @JsonProperty("SAP-5-12-1")
    private String SAP_5_12_1; // 是否行肠梗阻的手术治疗
    public String getSAP_5_12_1() {  return this.SAP_5_12_1;}
    @JsonProperty("SAP-5-12-1")
    public void setSAP_5_12_1(final String SAP_5_12_1) { this.SAP_5_12_1=SAP_5_12_1;}
    @Column(name = "SAP_5_12_2")
    @JsonProperty("SAP-5-12-2")
    private String SAP_5_12_2; // 手术指征
    public String getSAP_5_12_2() {  return this.SAP_5_12_2;}
    @JsonProperty("SAP-5-12-2")
    public void setSAP_5_12_2(final String SAP_5_12_2) { this.SAP_5_12_2=SAP_5_12_2;}
    @Column(name = "SAP_5_12_2_1")
    @JsonProperty("SAP-5-12-2-1")
    private String SAP_5_12_2_1; // 手术指征
    public String getSAP_5_12_2_1() {  return this.SAP_5_12_2_1;}
    @JsonProperty("SAP-5-12-2-1")
    public void setSAP_5_12_2_1(final String SAP_5_12_2_1) { this.SAP_5_12_2_1=SAP_5_12_2_1;}
    @Column(name = "SAP_5_12_3")
    @JsonProperty("SAP-5-12-3")
    private String SAP_5_12_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_12_3() {  return this.SAP_5_12_3;}
    @JsonProperty("SAP-5-12-3")
    public void setSAP_5_12_3(final String SAP_5_12_3) { this.SAP_5_12_3=SAP_5_12_3;}
    @Column(name = "SAP_5_12_3_1")
    @JsonProperty("SAP-5-12-3-1")
    private String SAP_5_12_3_1; // 其他手术
    public String getSAP_5_12_3_1() {  return this.SAP_5_12_3_1;}
    @JsonProperty("SAP-5-12-3-1")
    public void setSAP_5_12_3_1(final String SAP_5_12_3_1) { this.SAP_5_12_3_1=SAP_5_12_3_1;}
    @Column(name = "SAP_5_12_4")
    @JsonProperty("SAP-5-12-4")
    private String SAP_5_12_4; // 诊疗措施 实施日期时间
    public String getSAP_5_12_4() {  return this.SAP_5_12_4;}
    @JsonProperty("SAP-5-12-4")
    public void setSAP_5_12_4(final String SAP_5_12_4) { this.SAP_5_12_4=SAP_5_12_4;}
    @Column(name = "SAP_5_13_1")
    @JsonProperty("SAP-5-13-1")
    private String SAP_5_13_1; // 是否行肠瘘的手术治疗
    public String getSAP_5_13_1() {  return this.SAP_5_13_1;}
    @JsonProperty("SAP-5-13-1")
    public void setSAP_5_13_1(final String SAP_5_13_1) { this.SAP_5_13_1=SAP_5_13_1;}
    @Column(name = "SAP_5_13_2")
    @JsonProperty("SAP-5-13-2")
    private String SAP_5_13_2; // 手术指征
    public String getSAP_5_13_2() {  return this.SAP_5_13_2;}
    @JsonProperty("SAP-5-13-2")
    public void setSAP_5_13_2(final String SAP_5_13_2) { this.SAP_5_13_2=SAP_5_13_2;}
    @Column(name = "SAP_5_13_2_1")
    @JsonProperty("SAP-5-13-2-1")
    private String SAP_5_13_2_1; // 手术指征
    public String getSAP_5_13_2_1() {  return this.SAP_5_13_2_1;}
    @JsonProperty("SAP-5-13-2-1")
    public void setSAP_5_13_2_1(final String SAP_5_13_2_1) { this.SAP_5_13_2_1=SAP_5_13_2_1;}
    @Column(name = "SAP_5_13_3")
    @JsonProperty("SAP-5-13-3")
    private String SAP_5_13_3; // 手术或治疗性操作名称的选择
    public String getSAP_5_13_3() {  return this.SAP_5_13_3;}
    @JsonProperty("SAP-5-13-3")
    public void setSAP_5_13_3(final String SAP_5_13_3) { this.SAP_5_13_3=SAP_5_13_3;}
    @Column(name = "SAP_5_13_3_1")
    @JsonProperty("SAP-5-13-3-1")
    private String SAP_5_13_3_1; // 其他手术
    public String getSAP_5_13_3_1() {  return this.SAP_5_13_3_1;}
    @JsonProperty("SAP-5-13-3-1")
    public void setSAP_5_13_3_1(final String SAP_5_13_3_1) { this.SAP_5_13_3_1=SAP_5_13_3_1;}
    @Column(name = "SAP_5_13_4")
    @JsonProperty("SAP-5-13-4")
    private String SAP_5_13_4; // 诊疗措施 实施日期时间
    public String getSAP_5_13_4() {  return this.SAP_5_13_4;}
    @JsonProperty("SAP-5-13-4")
    public void setSAP_5_13_4(final String SAP_5_13_4) { this.SAP_5_13_4=SAP_5_13_4;}
    @Column(name = "SAP_6_1_1")
    @JsonProperty("SAP-6-1-1")
    private String SAP_6_1_1; // 是否经验性使用抗菌药物
    public String getSAP_6_1_1() {  return this.SAP_6_1_1;}
    @JsonProperty("SAP-6-1-1")
    public void setSAP_6_1_1(final String SAP_6_1_1) { this.SAP_6_1_1=SAP_6_1_1;}
    @Column(name = "SAP_6_1_2")
    @JsonProperty("SAP-6-1-2")
    private String SAP_6_1_2; // 是否有抗生素应用指征
    public String getSAP_6_1_2() {  return this.SAP_6_1_2;}
    @JsonProperty("SAP-6-1-2")
    public void setSAP_6_1_2(final String SAP_6_1_2) { this.SAP_6_1_2=SAP_6_1_2;}
    @Column(name = "SAP_6_1_3")
    @JsonProperty("SAP-6-1-3")
    private String SAP_6_1_3; // 是否有炎性标志物检测
    public String getSAP_6_1_3() {  return this.SAP_6_1_3;}
    @JsonProperty("SAP-6-1-3")
    public void setSAP_6_1_3(final String SAP_6_1_3) { this.SAP_6_1_3=SAP_6_1_3;}
    @Column(name = "SAP_6_1_4")
    @JsonProperty("SAP-6-1-4")
    private String SAP_6_1_4; // 炎性标志物检测
    public String getSAP_6_1_4() {  return this.SAP_6_1_4;}
    @JsonProperty("SAP-6-1-4")
    public void setSAP_6_1_4(final String SAP_6_1_4) { this.SAP_6_1_4=SAP_6_1_4;}
    @Column(name = "SAP_6_1_4_1")
    @JsonProperty("SAP-6-1-4-1")
    private String SAP_6_1_4_1; // C反应蛋白浓度(mg/L)
    public String getSAP_6_1_4_1() {  return this.SAP_6_1_4_1;}
    @JsonProperty("SAP-6-1-4-1")
    public void setSAP_6_1_4_1(final String SAP_6_1_4_1) { this.SAP_6_1_4_1=SAP_6_1_4_1;}
    @Column(name = "SAP_6_1_4_2")
    @JsonProperty("SAP-6-1-4-2")
    private String SAP_6_1_4_2; // 血清降钙素原浓度(ng/mL)
    public String getSAP_6_1_4_2() {  return this.SAP_6_1_4_2;}
    @JsonProperty("SAP-6-1-4-2")
    public void setSAP_6_1_4_2(final String SAP_6_1_4_2) { this.SAP_6_1_4_2=SAP_6_1_4_2;}
    @Column(name = "SAP_6_1_6")
    @JsonProperty("SAP-6-1-6")
    private String SAP_6_1_6; // 使用抗菌物前是否有病原学检测
    public String getSAP_6_1_6() {  return this.SAP_6_1_6;}
    @JsonProperty("SAP-6-1-6")
    public void setSAP_6_1_6(final String SAP_6_1_6) { this.SAP_6_1_6=SAP_6_1_6;}
    @Column(name = "SAP_6_1_5")
    @JsonProperty("SAP-6-1-5")
    private String SAP_6_1_5; // 经验性抗感染药物的选择
    public String getSAP_6_1_5() {  return this.SAP_6_1_5;}
    @JsonProperty("SAP-6-1-5")
    public void setSAP_6_1_5(final String SAP_6_1_5) { this.SAP_6_1_5=SAP_6_1_5;}
    @Column(name = "SAP_6_1_5_2")
    @JsonProperty("SAP-6-1-5-2")
    private String SAP_6_1_5_2; // 使用甲氧苄氨嘧啶-磺胺甲异噁唑药物起始日期时间
    public String getSAP_6_1_5_2() {  return this.SAP_6_1_5_2;}
    @JsonProperty("SAP-6-1-5-2")
    public void setSAP_6_1_5_2(final String SAP_6_1_5_2) { this.SAP_6_1_5_2=SAP_6_1_5_2;}
    @Column(name = "SAP_6_1_5_3")
    @JsonProperty("SAP-6-1-5-3")
    private String SAP_6_1_5_3; // 甲氧苄氨嘧啶-磺胺甲异噁唑药物停止使用日期时间
    public String getSAP_6_1_5_3() {  return this.SAP_6_1_5_3;}
    @JsonProperty("SAP-6-1-5-3")
    public void setSAP_6_1_5_3(final String SAP_6_1_5_3) { this.SAP_6_1_5_3=SAP_6_1_5_3;}
    @Column(name = "SAP_6_1_5_4")
    @JsonProperty("SAP-6-1-5-4")
    private String SAP_6_1_5_4; // 使用头孢西丁药物起始日期时间
    public String getSAP_6_1_5_4() {  return this.SAP_6_1_5_4;}
    @JsonProperty("SAP-6-1-5-4")
    public void setSAP_6_1_5_4(final String SAP_6_1_5_4) { this.SAP_6_1_5_4=SAP_6_1_5_4;}
    @Column(name = "SAP_6_1_5_5")
    @JsonProperty("SAP-6-1-5-5")
    private String SAP_6_1_5_5; // 头孢西丁药物停止使用日期时间
    public String getSAP_6_1_5_5() {  return this.SAP_6_1_5_5;}
    @JsonProperty("SAP-6-1-5-5")
    public void setSAP_6_1_5_5(final String SAP_6_1_5_5) { this.SAP_6_1_5_5=SAP_6_1_5_5;}
    @Column(name = "SAP_6_1_5_6")
    @JsonProperty("SAP-6-1-5-6")
    private String SAP_6_1_5_6; // 使用头孢美唑药物起始日期时间
    public String getSAP_6_1_5_6() {  return this.SAP_6_1_5_6;}
    @JsonProperty("SAP-6-1-5-6")
    public void setSAP_6_1_5_6(final String SAP_6_1_5_6) { this.SAP_6_1_5_6=SAP_6_1_5_6;}
    @Column(name = "SAP_6_1_5_7")
    @JsonProperty("SAP-6-1-5-7")
    private String SAP_6_1_5_7; // 头孢美唑药物停止使用日期时间
    public String getSAP_6_1_5_7() {  return this.SAP_6_1_5_7;}
    @JsonProperty("SAP-6-1-5-7")
    public void setSAP_6_1_5_7(final String SAP_6_1_5_7) { this.SAP_6_1_5_7=SAP_6_1_5_7;}
    @Column(name = "SAP_6_1_5_8")
    @JsonProperty("SAP-6-1-5-8")
    private String SAP_6_1_5_8; // 使用头孢替坦药物起始日期时间
    public String getSAP_6_1_5_8() {  return this.SAP_6_1_5_8;}
    @JsonProperty("SAP-6-1-5-8")
    public void setSAP_6_1_5_8(final String SAP_6_1_5_8) { this.SAP_6_1_5_8=SAP_6_1_5_8;}
    @Column(name = "SAP_6_1_5_9")
    @JsonProperty("SAP-6-1-5-9")
    private String SAP_6_1_5_9; // 头孢替坦药物停止使用日期时间
    public String getSAP_6_1_5_9() {  return this.SAP_6_1_5_9;}
    @JsonProperty("SAP-6-1-5-9")
    public void setSAP_6_1_5_9(final String SAP_6_1_5_9) { this.SAP_6_1_5_9=SAP_6_1_5_9;}
    @Column(name = "SAP_6_1_5_10")
    @JsonProperty("SAP-6-1-5-10")
    private String SAP_6_1_5_10; // 使用头孢米诺药物起始日期时间
    public String getSAP_6_1_5_10() {  return this.SAP_6_1_5_10;}
    @JsonProperty("SAP-6-1-5-10")
    public void setSAP_6_1_5_10(final String SAP_6_1_5_10) { this.SAP_6_1_5_10=SAP_6_1_5_10;}
    @Column(name = "SAP_6_1_5_11")
    @JsonProperty("SAP-6-1-5-11")
    private String SAP_6_1_5_11; // 头孢米诺药物停止使用日期时间
    public String getSAP_6_1_5_11() {  return this.SAP_6_1_5_11;}
    @JsonProperty("SAP-6-1-5-11")
    public void setSAP_6_1_5_11(final String SAP_6_1_5_11) { this.SAP_6_1_5_11=SAP_6_1_5_11;}
    @Column(name = "SAP_6_1_5_12")
    @JsonProperty("SAP-6-1-5-12")
    private String SAP_6_1_5_12; // 使用左氧氟沙星药物起始日期时间
    public String getSAP_6_1_5_12() {  return this.SAP_6_1_5_12;}
    @JsonProperty("SAP-6-1-5-12")
    public void setSAP_6_1_5_12(final String SAP_6_1_5_12) { this.SAP_6_1_5_12=SAP_6_1_5_12;}
    @Column(name = "SAP_6_1_5_13")
    @JsonProperty("SAP-6-1-5-13")
    private String SAP_6_1_5_13; // 左氧氟沙星药物停止使用日期时间
    public String getSAP_6_1_5_13() {  return this.SAP_6_1_5_13;}
    @JsonProperty("SAP-6-1-5-13")
    public void setSAP_6_1_5_13(final String SAP_6_1_5_13) { this.SAP_6_1_5_13=SAP_6_1_5_13;}
    @Column(name = "SAP_6_1_5_14")
    @JsonProperty("SAP-6-1-5-14")
    private String SAP_6_1_5_14; // 使用莫西沙涅药物起始日期时间
    public String getSAP_6_1_5_14() {  return this.SAP_6_1_5_14;}
    @JsonProperty("SAP-6-1-5-14")
    public void setSAP_6_1_5_14(final String SAP_6_1_5_14) { this.SAP_6_1_5_14=SAP_6_1_5_14;}
    @Column(name = "SAP_6_1_5_15")
    @JsonProperty("SAP-6-1-5-15")
    private String SAP_6_1_5_15; // 莫西沙涅药物停止使用日期时间
    public String getSAP_6_1_5_15() {  return this.SAP_6_1_5_15;}
    @JsonProperty("SAP-6-1-5-15")
    public void setSAP_6_1_5_15(final String SAP_6_1_5_15) { this.SAP_6_1_5_15=SAP_6_1_5_15;}
    @Column(name = "SAP_6_1_5_16")
    @JsonProperty("SAP-6-1-5-16")
    private String SAP_6_1_5_16; // 使用吉米沙星药物起始日期时间
    public String getSAP_6_1_5_16() {  return this.SAP_6_1_5_16;}
    @JsonProperty("SAP-6-1-5-16")
    public void setSAP_6_1_5_16(final String SAP_6_1_5_16) { this.SAP_6_1_5_16=SAP_6_1_5_16;}
    @Column(name = "SAP_6_1_5_17")
    @JsonProperty("SAP-6-1-5-17")
    private String SAP_6_1_5_17; // 吉米沙星药物停止使用日期时间
    public String getSAP_6_1_5_17() {  return this.SAP_6_1_5_17;}
    @JsonProperty("SAP-6-1-5-17")
    public void setSAP_6_1_5_17(final String SAP_6_1_5_17) { this.SAP_6_1_5_17=SAP_6_1_5_17;}
    @Column(name = "SAP_6_1_5_18")
    @JsonProperty("SAP-6-1-5-18")
    private String SAP_6_1_5_18; // 使用环丙沙星药物起始日期时间
    public String getSAP_6_1_5_18() {  return this.SAP_6_1_5_18;}
    @JsonProperty("SAP-6-1-5-18")
    public void setSAP_6_1_5_18(final String SAP_6_1_5_18) { this.SAP_6_1_5_18=SAP_6_1_5_18;}
    @Column(name = "SAP_6_1_5_19")
    @JsonProperty("SAP-6-1-5-19")
    private String SAP_6_1_5_19; // 环丙沙星药物停止使用日期时间
    public String getSAP_6_1_5_19() {  return this.SAP_6_1_5_19;}
    @JsonProperty("SAP-6-1-5-19")
    public void setSAP_6_1_5_19(final String SAP_6_1_5_19) { this.SAP_6_1_5_19=SAP_6_1_5_19;}
    @Column(name = "SAP_6_1_5_20")
    @JsonProperty("SAP-6-1-5-20")
    private String SAP_6_1_5_20; // 使用替卡西林药物起始日期时间
    public String getSAP_6_1_5_20() {  return this.SAP_6_1_5_20;}
    @JsonProperty("SAP-6-1-5-20")
    public void setSAP_6_1_5_20(final String SAP_6_1_5_20) { this.SAP_6_1_5_20=SAP_6_1_5_20;}
    @Column(name = "SAP_6_1_5_21")
    @JsonProperty("SAP-6-1-5-21")
    private String SAP_6_1_5_21; // 替卡西林药物停止使用日期时间
    public String getSAP_6_1_5_21() {  return this.SAP_6_1_5_21;}
    @JsonProperty("SAP-6-1-5-21")
    public void setSAP_6_1_5_21(final String SAP_6_1_5_21) { this.SAP_6_1_5_21=SAP_6_1_5_21;}
    @Column(name = "SAP_6_1_5_22")
    @JsonProperty("SAP-6-1-5-22")
    private String SAP_6_1_5_22; // 使用哌拉西林药物起始日期时间
    public String getSAP_6_1_5_22() {  return this.SAP_6_1_5_22;}
    @JsonProperty("SAP-6-1-5-22")
    public void setSAP_6_1_5_22(final String SAP_6_1_5_22) { this.SAP_6_1_5_22=SAP_6_1_5_22;}
    @Column(name = "SAP_6_1_5_23")
    @JsonProperty("SAP-6-1-5-23")
    private String SAP_6_1_5_23; // 哌拉西林药物停止使用日期时间
    public String getSAP_6_1_5_23() {  return this.SAP_6_1_5_23;}
    @JsonProperty("SAP-6-1-5-23")
    public void setSAP_6_1_5_23(final String SAP_6_1_5_23) { this.SAP_6_1_5_23=SAP_6_1_5_23;}
    @Column(name = "SAP_6_1_5_24")
    @JsonProperty("SAP-6-1-5-24")
    private String SAP_6_1_5_24; // 使用哌拉西林/他唑巴坦药物起始日期时间
    public String getSAP_6_1_5_24() {  return this.SAP_6_1_5_24;}
    @JsonProperty("SAP-6-1-5-24")
    public void setSAP_6_1_5_24(final String SAP_6_1_5_24) { this.SAP_6_1_5_24=SAP_6_1_5_24;}
    @Column(name = "SAP_6_1_5_25")
    @JsonProperty("SAP-6-1-5-25")
    private String SAP_6_1_5_25; // 哌拉西林/他唑巴坦药物停止使用日期时间
    public String getSAP_6_1_5_25() {  return this.SAP_6_1_5_25;}
    @JsonProperty("SAP-6-1-5-25")
    public void setSAP_6_1_5_25(final String SAP_6_1_5_25) { this.SAP_6_1_5_25=SAP_6_1_5_25;}
    @Column(name = "SAP_6_1_5_26")
    @JsonProperty("SAP-6-1-5-26")
    private String SAP_6_1_5_26; // 使用氨曲南药物起始日期时间
    public String getSAP_6_1_5_26() {  return this.SAP_6_1_5_26;}
    @JsonProperty("SAP-6-1-5-26")
    public void setSAP_6_1_5_26(final String SAP_6_1_5_26) { this.SAP_6_1_5_26=SAP_6_1_5_26;}
    @Column(name = "SAP_6_1_5_27")
    @JsonProperty("SAP-6-1-5-27")
    private String SAP_6_1_5_27; // 氨曲南药物停止使用日期时间
    public String getSAP_6_1_5_27() {  return this.SAP_6_1_5_27;}
    @JsonProperty("SAP-6-1-5-27")
    public void setSAP_6_1_5_27(final String SAP_6_1_5_27) { this.SAP_6_1_5_27=SAP_6_1_5_27;}
    @Column(name = "SAP_6_1_5_28")
    @JsonProperty("SAP-6-1-5-28")
    private String SAP_6_1_5_28; // 使用头孢他啶药物起始日期时间
    public String getSAP_6_1_5_28() {  return this.SAP_6_1_5_28;}
    @JsonProperty("SAP-6-1-5-28")
    public void setSAP_6_1_5_28(final String SAP_6_1_5_28) { this.SAP_6_1_5_28=SAP_6_1_5_28;}
    @Column(name = "SAP_6_1_5_29")
    @JsonProperty("SAP-6-1-5-29")
    private String SAP_6_1_5_29; // 头孢他啶药物停止使用日期时间
    public String getSAP_6_1_5_29() {  return this.SAP_6_1_5_29;}
    @JsonProperty("SAP-6-1-5-29")
    public void setSAP_6_1_5_29(final String SAP_6_1_5_29) { this.SAP_6_1_5_29=SAP_6_1_5_29;}
    @Column(name = "SAP_6_1_5_30")
    @JsonProperty("SAP-6-1-5-30")
    private String SAP_6_1_5_30; // 使用头孢吡肟药物起始日期时间
    public String getSAP_6_1_5_30() {  return this.SAP_6_1_5_30;}
    @JsonProperty("SAP-6-1-5-30")
    public void setSAP_6_1_5_30(final String SAP_6_1_5_30) { this.SAP_6_1_5_30=SAP_6_1_5_30;}
    @Column(name = "SAP_6_1_5_31")
    @JsonProperty("SAP-6-1-5-31")
    private String SAP_6_1_5_31; // 头孢吡肟药物停止使用日期时间
    public String getSAP_6_1_5_31() {  return this.SAP_6_1_5_31;}
    @JsonProperty("SAP-6-1-5-31")
    public void setSAP_6_1_5_31(final String SAP_6_1_5_31) { this.SAP_6_1_5_31=SAP_6_1_5_31;}
    @Column(name = "SAP_6_1_5_32")
    @JsonProperty("SAP-6-1-5-32")
    private String SAP_6_1_5_32; // 使用头孢哌酮药物起始日期时间
    public String getSAP_6_1_5_32() {  return this.SAP_6_1_5_32;}
    @JsonProperty("SAP-6-1-5-32")
    public void setSAP_6_1_5_32(final String SAP_6_1_5_32) { this.SAP_6_1_5_32=SAP_6_1_5_32;}
    @Column(name = "SAP_6_1_5_33")
    @JsonProperty("SAP-6-1-5-33")
    private String SAP_6_1_5_33; // 头孢哌酮药物停止使用日期时间
    public String getSAP_6_1_5_33() {  return this.SAP_6_1_5_33;}
    @JsonProperty("SAP-6-1-5-33")
    public void setSAP_6_1_5_33(final String SAP_6_1_5_33) { this.SAP_6_1_5_33=SAP_6_1_5_33;}
    @Column(name = "SAP_6_1_5_34")
    @JsonProperty("SAP-6-1-5-34")
    private String SAP_6_1_5_34; // 使用头孢唑肟药物起始日期时间
    public String getSAP_6_1_5_34() {  return this.SAP_6_1_5_34;}
    @JsonProperty("SAP-6-1-5-34")
    public void setSAP_6_1_5_34(final String SAP_6_1_5_34) { this.SAP_6_1_5_34=SAP_6_1_5_34;}
    @Column(name = "SAP_6_1_5_35")
    @JsonProperty("SAP-6-1-5-35")
    private String SAP_6_1_5_35; // 头孢唑肟药物停止使用日期时间
    public String getSAP_6_1_5_35() {  return this.SAP_6_1_5_35;}
    @JsonProperty("SAP-6-1-5-35")
    public void setSAP_6_1_5_35(final String SAP_6_1_5_35) { this.SAP_6_1_5_35=SAP_6_1_5_35;}
    @Column(name = "SAP_6_1_5_36")
    @JsonProperty("SAP-6-1-5-36")
    private String SAP_6_1_5_36; // 使用头孢哌酮/舒巴坦药物起始日期时间
    public String getSAP_6_1_5_36() {  return this.SAP_6_1_5_36;}
    @JsonProperty("SAP-6-1-5-36")
    public void setSAP_6_1_5_36(final String SAP_6_1_5_36) { this.SAP_6_1_5_36=SAP_6_1_5_36;}
    @Column(name = "SAP_6_1_5_37")
    @JsonProperty("SAP-6-1-5-37")
    private String SAP_6_1_5_37; // 头孢哌酮/舒巴坦药物停止使用日期时间
    public String getSAP_6_1_5_37() {  return this.SAP_6_1_5_37;}
    @JsonProperty("SAP-6-1-5-37")
    public void setSAP_6_1_5_37(final String SAP_6_1_5_37) { this.SAP_6_1_5_37=SAP_6_1_5_37;}
    @Column(name = "SAP_6_1_5_38")
    @JsonProperty("SAP-6-1-5-38")
    private String SAP_6_1_5_38; // 使用亚胺培南/西可他丁药物起始日期时间
    public String getSAP_6_1_5_38() {  return this.SAP_6_1_5_38;}
    @JsonProperty("SAP-6-1-5-38")
    public void setSAP_6_1_5_38(final String SAP_6_1_5_38) { this.SAP_6_1_5_38=SAP_6_1_5_38;}
    @Column(name = "SAP_6_1_5_39")
    @JsonProperty("SAP-6-1-5-39")
    private String SAP_6_1_5_39; // 亚胺培南/西可他丁药物停止使用日期时间
    public String getSAP_6_1_5_39() {  return this.SAP_6_1_5_39;}
    @JsonProperty("SAP-6-1-5-39")
    public void setSAP_6_1_5_39(final String SAP_6_1_5_39) { this.SAP_6_1_5_39=SAP_6_1_5_39;}
    @Column(name = "SAP_6_1_5_40")
    @JsonProperty("SAP-6-1-5-40")
    private String SAP_6_1_5_40; // 使用美罗培南药物起始日期时间
    public String getSAP_6_1_5_40() {  return this.SAP_6_1_5_40;}
    @JsonProperty("SAP-6-1-5-40")
    public void setSAP_6_1_5_40(final String SAP_6_1_5_40) { this.SAP_6_1_5_40=SAP_6_1_5_40;}
    @Column(name = "SAP_6_1_5_41")
    @JsonProperty("SAP-6-1-5-41")
    private String SAP_6_1_5_41; // 美罗培南药物停止使用日期时间
    public String getSAP_6_1_5_41() {  return this.SAP_6_1_5_41;}
    @JsonProperty("SAP-6-1-5-41")
    public void setSAP_6_1_5_41(final String SAP_6_1_5_41) { this.SAP_6_1_5_41=SAP_6_1_5_41;}
    @Column(name = "SAP_6_1_5_42")
    @JsonProperty("SAP-6-1-5-42")
    private String SAP_6_1_5_42; // 使用帕尼培南/信他米隆药物起始日期时间
    public String getSAP_6_1_5_42() {  return this.SAP_6_1_5_42;}
    @JsonProperty("SAP-6-1-5-42")
    public void setSAP_6_1_5_42(final String SAP_6_1_5_42) { this.SAP_6_1_5_42=SAP_6_1_5_42;}
    @Column(name = "SAP_6_1_5_43")
    @JsonProperty("SAP-6-1-5-43")
    private String SAP_6_1_5_43; // 帕尼培南/信他米隆药物停止使用日期时间
    public String getSAP_6_1_5_43() {  return this.SAP_6_1_5_43;}
    @JsonProperty("SAP-6-1-5-43")
    public void setSAP_6_1_5_43(final String SAP_6_1_5_43) { this.SAP_6_1_5_43=SAP_6_1_5_43;}
    @Column(name = "SAP_6_1_5_44")
    @JsonProperty("SAP-6-1-5-44")
    private String SAP_6_1_5_44; // 使用比阿培南药物起始日期时间
    public String getSAP_6_1_5_44() {  return this.SAP_6_1_5_44;}
    @JsonProperty("SAP-6-1-5-44")
    public void setSAP_6_1_5_44(final String SAP_6_1_5_44) { this.SAP_6_1_5_44=SAP_6_1_5_44;}
    @Column(name = "SAP_6_1_5_45")
    @JsonProperty("SAP-6-1-5-45")
    private String SAP_6_1_5_45; // 比阿培南药物停止使用日期时间
    public String getSAP_6_1_5_45() {  return this.SAP_6_1_5_45;}
    @JsonProperty("SAP-6-1-5-45")
    public void setSAP_6_1_5_45(final String SAP_6_1_5_45) { this.SAP_6_1_5_45=SAP_6_1_5_45;}
    @Column(name = "SAP_6_1_5_46")
    @JsonProperty("SAP-6-1-5-46")
    private String SAP_6_1_5_46; // 使用庆大霉素/妥布霉素药物起始日期时间
    public String getSAP_6_1_5_46() {  return this.SAP_6_1_5_46;}
    @JsonProperty("SAP-6-1-5-46")
    public void setSAP_6_1_5_46(final String SAP_6_1_5_46) { this.SAP_6_1_5_46=SAP_6_1_5_46;}
    @Column(name = "SAP_6_1_5_47")
    @JsonProperty("SAP-6-1-5-47")
    private String SAP_6_1_5_47; // 庆大霉素/妥布霉素药物停止使用日期时间
    public String getSAP_6_1_5_47() {  return this.SAP_6_1_5_47;}
    @JsonProperty("SAP-6-1-5-47")
    public void setSAP_6_1_5_47(final String SAP_6_1_5_47) { this.SAP_6_1_5_47=SAP_6_1_5_47;}
    @Column(name = "SAP_6_1_5_48")
    @JsonProperty("SAP-6-1-5-48")
    private String SAP_6_1_5_48; // 使用阿米卡星药物起始日期时间
    public String getSAP_6_1_5_48() {  return this.SAP_6_1_5_48;}
    @JsonProperty("SAP-6-1-5-48")
    public void setSAP_6_1_5_48(final String SAP_6_1_5_48) { this.SAP_6_1_5_48=SAP_6_1_5_48;}
    @Column(name = "SAP_6_1_5_49")
    @JsonProperty("SAP-6-1-5-49")
    private String SAP_6_1_5_49; // 阿米卡星药物停止使用日期时间
    public String getSAP_6_1_5_49() {  return this.SAP_6_1_5_49;}
    @JsonProperty("SAP-6-1-5-49")
    public void setSAP_6_1_5_49(final String SAP_6_1_5_49) { this.SAP_6_1_5_49=SAP_6_1_5_49;}
    @Column(name = "SAP_6_1_5_50")
    @JsonProperty("SAP-6-1-5-50")
    private String SAP_6_1_5_50; // 使用依替米星药物起始日期时间
    public String getSAP_6_1_5_50() {  return this.SAP_6_1_5_50;}
    @JsonProperty("SAP-6-1-5-50")
    public void setSAP_6_1_5_50(final String SAP_6_1_5_50) { this.SAP_6_1_5_50=SAP_6_1_5_50;}
    @Column(name = "SAP_6_1_5_51")
    @JsonProperty("SAP-6-1-5-51")
    private String SAP_6_1_5_51; // 依替米星药物停止使用日期时间
    public String getSAP_6_1_5_51() {  return this.SAP_6_1_5_51;}
    @JsonProperty("SAP-6-1-5-51")
    public void setSAP_6_1_5_51(final String SAP_6_1_5_51) { this.SAP_6_1_5_51=SAP_6_1_5_51;}
    @Column(name = "SAP_6_1_5_52")
    @JsonProperty("SAP-6-1-5-52")
    private String SAP_6_1_5_52; // 使用奈替米星药物起始日期时间
    public String getSAP_6_1_5_52() {  return this.SAP_6_1_5_52;}
    @JsonProperty("SAP-6-1-5-52")
    public void setSAP_6_1_5_52(final String SAP_6_1_5_52) { this.SAP_6_1_5_52=SAP_6_1_5_52;}
    @Column(name = "SAP_6_1_5_53")
    @JsonProperty("SAP-6-1-5-53")
    private String SAP_6_1_5_53; // 奈替米星药物停止使用日期时间
    public String getSAP_6_1_5_53() {  return this.SAP_6_1_5_53;}
    @JsonProperty("SAP-6-1-5-53")
    public void setSAP_6_1_5_53(final String SAP_6_1_5_53) { this.SAP_6_1_5_53=SAP_6_1_5_53;}
    @Column(name = "SAP_6_1_5_54")
    @JsonProperty("SAP-6-1-5-54")
    private String SAP_6_1_5_54; // 使用替卡西林/克拉维酸药物起始日期时间
    public String getSAP_6_1_5_54() {  return this.SAP_6_1_5_54;}
    @JsonProperty("SAP-6-1-5-54")
    public void setSAP_6_1_5_54(final String SAP_6_1_5_54) { this.SAP_6_1_5_54=SAP_6_1_5_54;}
    @Column(name = "SAP_6_1_5_55")
    @JsonProperty("SAP-6-1-5-55")
    private String SAP_6_1_5_55; // 替卡西林/克拉维酸药物停止使用日期时间
    public String getSAP_6_1_5_55() {  return this.SAP_6_1_5_55;}
    @JsonProperty("SAP-6-1-5-55")
    public void setSAP_6_1_5_55(final String SAP_6_1_5_55) { this.SAP_6_1_5_55=SAP_6_1_5_55;}
    @Column(name = "SAP_6_1_5_56")
    @JsonProperty("SAP-6-1-5-56")
    private String SAP_6_1_5_56; // 使用氨苄西林/舒巴坦药物起始日期时间
    public String getSAP_6_1_5_56() {  return this.SAP_6_1_5_56;}
    @JsonProperty("SAP-6-1-5-56")
    public void setSAP_6_1_5_56(final String SAP_6_1_5_56) { this.SAP_6_1_5_56=SAP_6_1_5_56;}
    @Column(name = "SAP_6_1_5_57")
    @JsonProperty("SAP-6-1-5-57")
    private String SAP_6_1_5_57; // 氨苄西林/舒巴坦药物停止使用日期时间
    public String getSAP_6_1_5_57() {  return this.SAP_6_1_5_57;}
    @JsonProperty("SAP-6-1-5-57")
    public void setSAP_6_1_5_57(final String SAP_6_1_5_57) { this.SAP_6_1_5_57=SAP_6_1_5_57;}
    @Column(name = "SAP_6_1_5_58")
    @JsonProperty("SAP-6-1-5-58")
    private String SAP_6_1_5_58; // 使用阿莫西林/克拉维酸药物起始日期时间
    public String getSAP_6_1_5_58() {  return this.SAP_6_1_5_58;}
    @JsonProperty("SAP-6-1-5-58")
    public void setSAP_6_1_5_58(final String SAP_6_1_5_58) { this.SAP_6_1_5_58=SAP_6_1_5_58;}
    @Column(name = "SAP_6_1_5_59")
    @JsonProperty("SAP-6-1-5-59")
    private String SAP_6_1_5_59; // 阿莫西林/克拉维酸药物停止使用日期时间
    public String getSAP_6_1_5_59() {  return this.SAP_6_1_5_59;}
    @JsonProperty("SAP-6-1-5-59")
    public void setSAP_6_1_5_59(final String SAP_6_1_5_59) { this.SAP_6_1_5_59=SAP_6_1_5_59;}
    @Column(name = "SAP_6_1_5_60")
    @JsonProperty("SAP-6-1-5-60")
    private String SAP_6_1_5_60; // 使用亚胺培南/西司他丁药物起始日期时间
    public String getSAP_6_1_5_60() {  return this.SAP_6_1_5_60;}
    @JsonProperty("SAP-6-1-5-60")
    public void setSAP_6_1_5_60(final String SAP_6_1_5_60) { this.SAP_6_1_5_60=SAP_6_1_5_60;}
    @Column(name = "SAP_6_1_5_61")
    @JsonProperty("SAP-6-1-5-61")
    private String SAP_6_1_5_61; // 亚胺培南/西司他丁药物停止使用日期时间
    public String getSAP_6_1_5_61() {  return this.SAP_6_1_5_61;}
    @JsonProperty("SAP-6-1-5-61")
    public void setSAP_6_1_5_61(final String SAP_6_1_5_61) { this.SAP_6_1_5_61=SAP_6_1_5_61;}
    @Column(name = "SAP_6_1_5_62")
    @JsonProperty("SAP-6-1-5-62")
    private String SAP_6_1_5_62; // 使用厄他培南药物起始日期时间
    public String getSAP_6_1_5_62() {  return this.SAP_6_1_5_62;}
    @JsonProperty("SAP-6-1-5-62")
    public void setSAP_6_1_5_62(final String SAP_6_1_5_62) { this.SAP_6_1_5_62=SAP_6_1_5_62;}
    @Column(name = "SAP_6_1_5_63")
    @JsonProperty("SAP-6-1-5-63")
    private String SAP_6_1_5_63; // 厄他培南药物停止使用日期时间
    public String getSAP_6_1_5_63() {  return this.SAP_6_1_5_63;}
    @JsonProperty("SAP-6-1-5-63")
    public void setSAP_6_1_5_63(final String SAP_6_1_5_63) { this.SAP_6_1_5_63=SAP_6_1_5_63;}
    @Column(name = "SAP_6_1_5_1")
    @JsonProperty("SAP-6-1-5-1")
    private String SAP_6_1_5_1; // 其他类抗感染药物
    public String getSAP_6_1_5_1() {  return this.SAP_6_1_5_1;}
    @JsonProperty("SAP-6-1-5-1")
    public void setSAP_6_1_5_1(final String SAP_6_1_5_1) { this.SAP_6_1_5_1=SAP_6_1_5_1;}
    @Column(name = "SAP_6_1_5_64")
    @JsonProperty("SAP-6-1-5-64")
    private String SAP_6_1_5_64; // 使用其他抗菌药物起始日期时间
    public String getSAP_6_1_5_64() {  return this.SAP_6_1_5_64;}
    @JsonProperty("SAP-6-1-5-64")
    public void setSAP_6_1_5_64(final String SAP_6_1_5_64) { this.SAP_6_1_5_64=SAP_6_1_5_64;}
    @Column(name = "SAP_6_1_5_65")
    @JsonProperty("SAP-6-1-5-65")
    private String SAP_6_1_5_65; // 其他抗菌药物停止使用日期时间
    public String getSAP_6_1_5_65() {  return this.SAP_6_1_5_65;}
    @JsonProperty("SAP-6-1-5-65")
    public void setSAP_6_1_5_65(final String SAP_6_1_5_65) { this.SAP_6_1_5_65=SAP_6_1_5_65;}
    @Column(name = "SAP_6_2_1")
    @JsonProperty("SAP-6-2-1")
    private String SAP_6_2_1; // 是否有病原学检测
    public String getSAP_6_2_1() {  return this.SAP_6_2_1;}
    @JsonProperty("SAP-6-2-1")
    public void setSAP_6_2_1(final String SAP_6_2_1) { this.SAP_6_2_1=SAP_6_2_1;}
    @Column(name = "SAP_6_2_2")
    @JsonProperty("SAP-6-2-2")
    private String SAP_6_2_2; // 重复病原学诊断结果
    public String getSAP_6_2_2() {  return this.SAP_6_2_2;}
    @JsonProperty("SAP-6-2-2")
    public void setSAP_6_2_2(final String SAP_6_2_2) { this.SAP_6_2_2=SAP_6_2_2;}
    @Column(name = "SAP_6_2_2_1")
    @JsonProperty("SAP-6-2-2-1")
    private String SAP_6_2_2_1; // 重复病原学诊断其他结果
    public String getSAP_6_2_2_1() {  return this.SAP_6_2_2_1;}
    @JsonProperty("SAP-6-2-2-1")
    public void setSAP_6_2_2_1(final String SAP_6_2_2_1) { this.SAP_6_2_2_1=SAP_6_2_2_1;}
    @Column(name = "SAP_6_2_3")
    @JsonProperty("SAP-6-2-3")
    private String SAP_6_2_3; // 目标抗感染药物的选择
    public String getSAP_6_2_3() {  return this.SAP_6_2_3;}
    @JsonProperty("SAP-6-2-3")
    public void setSAP_6_2_3(final String SAP_6_2_3) { this.SAP_6_2_3=SAP_6_2_3;}
    @Column(name = "SAP_6_2_3_2")
    @JsonProperty("SAP-6-2-3-2")
    private String SAP_6_2_3_2; // 使用甲氧苄氨嘧啶-磺胺甲异噁唑药物起始日期时间
    public String getSAP_6_2_3_2() {  return this.SAP_6_2_3_2;}
    @JsonProperty("SAP-6-2-3-2")
    public void setSAP_6_2_3_2(final String SAP_6_2_3_2) { this.SAP_6_2_3_2=SAP_6_2_3_2;}
    @Column(name = "SAP_6_2_3_3")
    @JsonProperty("SAP-6-2-3-3")
    private String SAP_6_2_3_3; // 甲氧苄氨嘧啶-磺胺甲异噁唑药物停止使用日期时间
    public String getSAP_6_2_3_3() {  return this.SAP_6_2_3_3;}
    @JsonProperty("SAP-6-2-3-3")
    public void setSAP_6_2_3_3(final String SAP_6_2_3_3) { this.SAP_6_2_3_3=SAP_6_2_3_3;}
    @Column(name = "SAP_6_2_3_4")
    @JsonProperty("SAP-6-2-3-4")
    private String SAP_6_2_3_4; // 使用头孢西丁药物起始日期时间
    public String getSAP_6_2_3_4() {  return this.SAP_6_2_3_4;}
    @JsonProperty("SAP-6-2-3-4")
    public void setSAP_6_2_3_4(final String SAP_6_2_3_4) { this.SAP_6_2_3_4=SAP_6_2_3_4;}
    @Column(name = "SAP_6_2_3_5")
    @JsonProperty("SAP-6-2-3-5")
    private String SAP_6_2_3_5; // 头孢西丁药物停止使用日期时间
    public String getSAP_6_2_3_5() {  return this.SAP_6_2_3_5;}
    @JsonProperty("SAP-6-2-3-5")
    public void setSAP_6_2_3_5(final String SAP_6_2_3_5) { this.SAP_6_2_3_5=SAP_6_2_3_5;}
    @Column(name = "SAP_6_2_3_6")
    @JsonProperty("SAP-6-2-3-6")
    private String SAP_6_2_3_6; // 使用头孢美唑药物起始日期时间
    public String getSAP_6_2_3_6() {  return this.SAP_6_2_3_6;}
    @JsonProperty("SAP-6-2-3-6")
    public void setSAP_6_2_3_6(final String SAP_6_2_3_6) { this.SAP_6_2_3_6=SAP_6_2_3_6;}
    @Column(name = "SAP_6_2_3_7")
    @JsonProperty("SAP-6-2-3-7")
    private String SAP_6_2_3_7; // 头孢美唑药物停止使用日期时间
    public String getSAP_6_2_3_7() {  return this.SAP_6_2_3_7;}
    @JsonProperty("SAP-6-2-3-7")
    public void setSAP_6_2_3_7(final String SAP_6_2_3_7) { this.SAP_6_2_3_7=SAP_6_2_3_7;}
    @Column(name = "SAP_6_2_3_8")
    @JsonProperty("SAP-6-2-3-8")
    private String SAP_6_2_3_8; // 使用头孢替坦药物起始日期时间
    public String getSAP_6_2_3_8() {  return this.SAP_6_2_3_8;}
    @JsonProperty("SAP-6-2-3-8")
    public void setSAP_6_2_3_8(final String SAP_6_2_3_8) { this.SAP_6_2_3_8=SAP_6_2_3_8;}
    @Column(name = "SAP_6_2_3_9")
    @JsonProperty("SAP-6-2-3-9")
    private String SAP_6_2_3_9; // 头孢替坦药物停止使用日期时间
    public String getSAP_6_2_3_9() {  return this.SAP_6_2_3_9;}
    @JsonProperty("SAP-6-2-3-9")
    public void setSAP_6_2_3_9(final String SAP_6_2_3_9) { this.SAP_6_2_3_9=SAP_6_2_3_9;}
    @Column(name = "SAP_6_2_3_10")
    @JsonProperty("SAP-6-2-3-10")
    private String SAP_6_2_3_10; // 使用头孢米诺药物起始日期时间
    public String getSAP_6_2_3_10() {  return this.SAP_6_2_3_10;}
    @JsonProperty("SAP-6-2-3-10")
    public void setSAP_6_2_3_10(final String SAP_6_2_3_10) { this.SAP_6_2_3_10=SAP_6_2_3_10;}
    @Column(name = "SAP_6_2_3_11")
    @JsonProperty("SAP-6-2-3-11")
    private String SAP_6_2_3_11; // 头孢米诺药物停止使用日期时间
    public String getSAP_6_2_3_11() {  return this.SAP_6_2_3_11;}
    @JsonProperty("SAP-6-2-3-11")
    public void setSAP_6_2_3_11(final String SAP_6_2_3_11) { this.SAP_6_2_3_11=SAP_6_2_3_11;}
    @Column(name = "SAP_6_2_3_12")
    @JsonProperty("SAP-6-2-3-12")
    private String SAP_6_2_3_12; // 使用左氧氟沙星药物起始日期时间
    public String getSAP_6_2_3_12() {  return this.SAP_6_2_3_12;}
    @JsonProperty("SAP-6-2-3-12")
    public void setSAP_6_2_3_12(final String SAP_6_2_3_12) { this.SAP_6_2_3_12=SAP_6_2_3_12;}
    @Column(name = "SAP_6_2_3_13")
    @JsonProperty("SAP-6-2-3-13")
    private String SAP_6_2_3_13; // 左氧氟沙星药物停止使用日期时间
    public String getSAP_6_2_3_13() {  return this.SAP_6_2_3_13;}
    @JsonProperty("SAP-6-2-3-13")
    public void setSAP_6_2_3_13(final String SAP_6_2_3_13) { this.SAP_6_2_3_13=SAP_6_2_3_13;}
    @Column(name = "SAP_6_2_3_14")
    @JsonProperty("SAP-6-2-3-14")
    private String SAP_6_2_3_14; // 使用莫西沙涅药物起始日期时间
    public String getSAP_6_2_3_14() {  return this.SAP_6_2_3_14;}
    @JsonProperty("SAP-6-2-3-14")
    public void setSAP_6_2_3_14(final String SAP_6_2_3_14) { this.SAP_6_2_3_14=SAP_6_2_3_14;}
    @Column(name = "SAP_6_2_3_15")
    @JsonProperty("SAP-6-2-3-15")
    private String SAP_6_2_3_15; // 莫西沙涅药物停止使用日期时间
    public String getSAP_6_2_3_15() {  return this.SAP_6_2_3_15;}
    @JsonProperty("SAP-6-2-3-15")
    public void setSAP_6_2_3_15(final String SAP_6_2_3_15) { this.SAP_6_2_3_15=SAP_6_2_3_15;}
    @Column(name = "SAP_6_2_3_16")
    @JsonProperty("SAP-6-2-3-16")
    private String SAP_6_2_3_16; // 使用吉米沙星药物起始日期时间
    public String getSAP_6_2_3_16() {  return this.SAP_6_2_3_16;}
    @JsonProperty("SAP-6-2-3-16")
    public void setSAP_6_2_3_16(final String SAP_6_2_3_16) { this.SAP_6_2_3_16=SAP_6_2_3_16;}
    @Column(name = "SAP_6_2_3_17")
    @JsonProperty("SAP-6-2-3-17")
    private String SAP_6_2_3_17; // 吉米沙星药物停止使用日期时间
    public String getSAP_6_2_3_17() {  return this.SAP_6_2_3_17;}
    @JsonProperty("SAP-6-2-3-17")
    public void setSAP_6_2_3_17(final String SAP_6_2_3_17) { this.SAP_6_2_3_17=SAP_6_2_3_17;}
    @Column(name = "SAP_6_2_3_18")
    @JsonProperty("SAP-6-2-3-18")
    private String SAP_6_2_3_18; // 使用环丙沙星药物起始日期时间
    public String getSAP_6_2_3_18() {  return this.SAP_6_2_3_18;}
    @JsonProperty("SAP-6-2-3-18")
    public void setSAP_6_2_3_18(final String SAP_6_2_3_18) { this.SAP_6_2_3_18=SAP_6_2_3_18;}
    @Column(name = "SAP_6_2_3_19")
    @JsonProperty("SAP-6-2-3-19")
    private String SAP_6_2_3_19; // 环丙沙星药物停止使用日期时间
    public String getSAP_6_2_3_19() {  return this.SAP_6_2_3_19;}
    @JsonProperty("SAP-6-2-3-19")
    public void setSAP_6_2_3_19(final String SAP_6_2_3_19) { this.SAP_6_2_3_19=SAP_6_2_3_19;}
    @Column(name = "SAP_6_2_3_20")
    @JsonProperty("SAP-6-2-3-20")
    private String SAP_6_2_3_20; // 使用替卡西林药物起始日期时间
    public String getSAP_6_2_3_20() {  return this.SAP_6_2_3_20;}
    @JsonProperty("SAP-6-2-3-20")
    public void setSAP_6_2_3_20(final String SAP_6_2_3_20) { this.SAP_6_2_3_20=SAP_6_2_3_20;}
    @Column(name = "SAP_6_2_3_21")
    @JsonProperty("SAP-6-2-3-21")
    private String SAP_6_2_3_21; // 替卡西林药物停止使用日期时间
    public String getSAP_6_2_3_21() {  return this.SAP_6_2_3_21;}
    @JsonProperty("SAP-6-2-3-21")
    public void setSAP_6_2_3_21(final String SAP_6_2_3_21) { this.SAP_6_2_3_21=SAP_6_2_3_21;}
    @Column(name = "SAP_6_2_3_22")
    @JsonProperty("SAP-6-2-3-22")
    private String SAP_6_2_3_22; // 使用哌拉西林药物起始日期时间
    public String getSAP_6_2_3_22() {  return this.SAP_6_2_3_22;}
    @JsonProperty("SAP-6-2-3-22")
    public void setSAP_6_2_3_22(final String SAP_6_2_3_22) { this.SAP_6_2_3_22=SAP_6_2_3_22;}
    @Column(name = "SAP_6_2_3_23")
    @JsonProperty("SAP-6-2-3-23")
    private String SAP_6_2_3_23; // 哌拉西林药物停止使用日期时间
    public String getSAP_6_2_3_23() {  return this.SAP_6_2_3_23;}
    @JsonProperty("SAP-6-2-3-23")
    public void setSAP_6_2_3_23(final String SAP_6_2_3_23) { this.SAP_6_2_3_23=SAP_6_2_3_23;}
    @Column(name = "SAP_6_2_3_24")
    @JsonProperty("SAP-6-2-3-24")
    private String SAP_6_2_3_24; // 使用哌拉西林/他唑巴坦药物起始日期时间
    public String getSAP_6_2_3_24() {  return this.SAP_6_2_3_24;}
    @JsonProperty("SAP-6-2-3-24")
    public void setSAP_6_2_3_24(final String SAP_6_2_3_24) { this.SAP_6_2_3_24=SAP_6_2_3_24;}
    @Column(name = "SAP_6_2_3_25")
    @JsonProperty("SAP-6-2-3-25")
    private String SAP_6_2_3_25; // 哌拉西林/他唑巴坦药物停止使用日期时间
    public String getSAP_6_2_3_25() {  return this.SAP_6_2_3_25;}
    @JsonProperty("SAP-6-2-3-25")
    public void setSAP_6_2_3_25(final String SAP_6_2_3_25) { this.SAP_6_2_3_25=SAP_6_2_3_25;}
    @Column(name = "SAP_6_2_3_26")
    @JsonProperty("SAP-6-2-3-26")
    private String SAP_6_2_3_26; // 使用氨曲南药物起始日期时间
    public String getSAP_6_2_3_26() {  return this.SAP_6_2_3_26;}
    @JsonProperty("SAP-6-2-3-26")
    public void setSAP_6_2_3_26(final String SAP_6_2_3_26) { this.SAP_6_2_3_26=SAP_6_2_3_26;}
    @Column(name = "SAP_6_2_3_27")
    @JsonProperty("SAP-6-2-3-27")
    private String SAP_6_2_3_27; // 氨曲南药物停止使用日期时间
    public String getSAP_6_2_3_27() {  return this.SAP_6_2_3_27;}
    @JsonProperty("SAP-6-2-3-27")
    public void setSAP_6_2_3_27(final String SAP_6_2_3_27) { this.SAP_6_2_3_27=SAP_6_2_3_27;}
    @Column(name = "SAP_6_2_3_28")
    @JsonProperty("SAP-6-2-3-28")
    private String SAP_6_2_3_28; // 使用头孢他啶药物起始日期时间
    public String getSAP_6_2_3_28() {  return this.SAP_6_2_3_28;}
    @JsonProperty("SAP-6-2-3-28")
    public void setSAP_6_2_3_28(final String SAP_6_2_3_28) { this.SAP_6_2_3_28=SAP_6_2_3_28;}
    @Column(name = "SAP_6_2_3_29")
    @JsonProperty("SAP-6-2-3-29")
    private String SAP_6_2_3_29; // 头孢他啶药物停止使用日期时间
    public String getSAP_6_2_3_29() {  return this.SAP_6_2_3_29;}
    @JsonProperty("SAP-6-2-3-29")
    public void setSAP_6_2_3_29(final String SAP_6_2_3_29) { this.SAP_6_2_3_29=SAP_6_2_3_29;}
    @Column(name = "SAP_6_2_3_30")
    @JsonProperty("SAP-6-2-3-30")
    private String SAP_6_2_3_30; // 使用头孢吡肟药物起始日期时间
    public String getSAP_6_2_3_30() {  return this.SAP_6_2_3_30;}
    @JsonProperty("SAP-6-2-3-30")
    public void setSAP_6_2_3_30(final String SAP_6_2_3_30) { this.SAP_6_2_3_30=SAP_6_2_3_30;}
    @Column(name = "SAP_6_2_3_31")
    @JsonProperty("SAP-6-2-3-31")
    private String SAP_6_2_3_31; // 头孢吡肟药物停止使用日期时间
    public String getSAP_6_2_3_31() {  return this.SAP_6_2_3_31;}
    @JsonProperty("SAP-6-2-3-31")
    public void setSAP_6_2_3_31(final String SAP_6_2_3_31) { this.SAP_6_2_3_31=SAP_6_2_3_31;}
    @Column(name = "SAP_6_2_3_32")
    @JsonProperty("SAP-6-2-3-32")
    private String SAP_6_2_3_32; // 使用头孢哌酮药物起始日期时间
    public String getSAP_6_2_3_32() {  return this.SAP_6_2_3_32;}
    @JsonProperty("SAP-6-2-3-32")
    public void setSAP_6_2_3_32(final String SAP_6_2_3_32) { this.SAP_6_2_3_32=SAP_6_2_3_32;}
    @Column(name = "SAP_6_2_3_33")
    @JsonProperty("SAP-6-2-3-33")
    private String SAP_6_2_3_33; // 头孢哌酮药物停止使用日期时间
    public String getSAP_6_2_3_33() {  return this.SAP_6_2_3_33;}
    @JsonProperty("SAP-6-2-3-33")
    public void setSAP_6_2_3_33(final String SAP_6_2_3_33) { this.SAP_6_2_3_33=SAP_6_2_3_33;}
    @Column(name = "SAP_6_2_3_34")
    @JsonProperty("SAP-6-2-3-34")
    private String SAP_6_2_3_34; // 使用头孢唑肟药物起始日期时间
    public String getSAP_6_2_3_34() {  return this.SAP_6_2_3_34;}
    @JsonProperty("SAP-6-2-3-34")
    public void setSAP_6_2_3_34(final String SAP_6_2_3_34) { this.SAP_6_2_3_34=SAP_6_2_3_34;}
    @Column(name = "SAP_6_2_3_35")
    @JsonProperty("SAP-6-2-3-35")
    private String SAP_6_2_3_35; // 头孢唑肟药物停止使用日期时间
    public String getSAP_6_2_3_35() {  return this.SAP_6_2_3_35;}
    @JsonProperty("SAP-6-2-3-35")
    public void setSAP_6_2_3_35(final String SAP_6_2_3_35) { this.SAP_6_2_3_35=SAP_6_2_3_35;}
    @Column(name = "SAP_6_2_3_36")
    @JsonProperty("SAP-6-2-3-36")
    private String SAP_6_2_3_36; // 使用头孢哌酮/舒巴坦药物起始日期时间
    public String getSAP_6_2_3_36() {  return this.SAP_6_2_3_36;}
    @JsonProperty("SAP-6-2-3-36")
    public void setSAP_6_2_3_36(final String SAP_6_2_3_36) { this.SAP_6_2_3_36=SAP_6_2_3_36;}
    @Column(name = "SAP_6_2_3_37")
    @JsonProperty("SAP-6-2-3-37")
    private String SAP_6_2_3_37; // 头孢哌酮/舒巴坦药物停止使用日期时间
    public String getSAP_6_2_3_37() {  return this.SAP_6_2_3_37;}
    @JsonProperty("SAP-6-2-3-37")
    public void setSAP_6_2_3_37(final String SAP_6_2_3_37) { this.SAP_6_2_3_37=SAP_6_2_3_37;}
    @Column(name = "SAP_6_2_3_38")
    @JsonProperty("SAP-6-2-3-38")
    private String SAP_6_2_3_38; // 使用亚胺培南/西可他丁药物起始日期时间
    public String getSAP_6_2_3_38() {  return this.SAP_6_2_3_38;}
    @JsonProperty("SAP-6-2-3-38")
    public void setSAP_6_2_3_38(final String SAP_6_2_3_38) { this.SAP_6_2_3_38=SAP_6_2_3_38;}
    @Column(name = "SAP_6_2_3_39")
    @JsonProperty("SAP-6-2-3-39")
    private String SAP_6_2_3_39; // 亚胺培南/西可他丁药物停止使用日期时间
    public String getSAP_6_2_3_39() {  return this.SAP_6_2_3_39;}
    @JsonProperty("SAP-6-2-3-39")
    public void setSAP_6_2_3_39(final String SAP_6_2_3_39) { this.SAP_6_2_3_39=SAP_6_2_3_39;}
    @Column(name = "SAP_6_2_3_40")
    @JsonProperty("SAP-6-2-3-40")
    private String SAP_6_2_3_40; // 使用美罗培南药物起始日期时间
    public String getSAP_6_2_3_40() {  return this.SAP_6_2_3_40;}
    @JsonProperty("SAP-6-2-3-40")
    public void setSAP_6_2_3_40(final String SAP_6_2_3_40) { this.SAP_6_2_3_40=SAP_6_2_3_40;}
    @Column(name = "SAP_6_2_3_41")
    @JsonProperty("SAP-6-2-3-41")
    private String SAP_6_2_3_41; // 美罗培南药物停止使用日期时间
    public String getSAP_6_2_3_41() {  return this.SAP_6_2_3_41;}
    @JsonProperty("SAP-6-2-3-41")
    public void setSAP_6_2_3_41(final String SAP_6_2_3_41) { this.SAP_6_2_3_41=SAP_6_2_3_41;}
    @Column(name = "SAP_6_2_3_42")
    @JsonProperty("SAP-6-2-3-42")
    private String SAP_6_2_3_42; // 使用帕尼培南/信他米隆药物起始日期时间
    public String getSAP_6_2_3_42() {  return this.SAP_6_2_3_42;}
    @JsonProperty("SAP-6-2-3-42")
    public void setSAP_6_2_3_42(final String SAP_6_2_3_42) { this.SAP_6_2_3_42=SAP_6_2_3_42;}
    @Column(name = "SAP_6_2_3_43")
    @JsonProperty("SAP-6-2-3-43")
    private String SAP_6_2_3_43; // 帕尼培南/信他米隆药物停止使用日期时间
    public String getSAP_6_2_3_43() {  return this.SAP_6_2_3_43;}
    @JsonProperty("SAP-6-2-3-43")
    public void setSAP_6_2_3_43(final String SAP_6_2_3_43) { this.SAP_6_2_3_43=SAP_6_2_3_43;}
    @Column(name = "SAP_6_2_3_44")
    @JsonProperty("SAP-6-2-3-44")
    private String SAP_6_2_3_44; // 使用比阿培南药物起始日期时间
    public String getSAP_6_2_3_44() {  return this.SAP_6_2_3_44;}
    @JsonProperty("SAP-6-2-3-44")
    public void setSAP_6_2_3_44(final String SAP_6_2_3_44) { this.SAP_6_2_3_44=SAP_6_2_3_44;}
    @Column(name = "SAP_6_2_3_45")
    @JsonProperty("SAP-6-2-3-45")
    private String SAP_6_2_3_45; // 比阿培南药物停止使用日期时间
    public String getSAP_6_2_3_45() {  return this.SAP_6_2_3_45;}
    @JsonProperty("SAP-6-2-3-45")
    public void setSAP_6_2_3_45(final String SAP_6_2_3_45) { this.SAP_6_2_3_45=SAP_6_2_3_45;}
    @Column(name = "SAP_6_2_3_46")
    @JsonProperty("SAP-6-2-3-46")
    private String SAP_6_2_3_46; // 使用庆大霉素/妥布霉素药物起始日期时间
    public String getSAP_6_2_3_46() {  return this.SAP_6_2_3_46;}
    @JsonProperty("SAP-6-2-3-46")
    public void setSAP_6_2_3_46(final String SAP_6_2_3_46) { this.SAP_6_2_3_46=SAP_6_2_3_46;}
    @Column(name = "SAP_6_2_3_47")
    @JsonProperty("SAP-6-2-3-47")
    private String SAP_6_2_3_47; // 庆大霉素/妥布霉素药物停止使用日期时间
    public String getSAP_6_2_3_47() {  return this.SAP_6_2_3_47;}
    @JsonProperty("SAP-6-2-3-47")
    public void setSAP_6_2_3_47(final String SAP_6_2_3_47) { this.SAP_6_2_3_47=SAP_6_2_3_47;}
    @Column(name = "SAP_6_2_3_48")
    @JsonProperty("SAP-6-2-3-48")
    private String SAP_6_2_3_48; // 使用阿米卡星药物起始日期时间
    public String getSAP_6_2_3_48() {  return this.SAP_6_2_3_48;}
    @JsonProperty("SAP-6-2-3-48")
    public void setSAP_6_2_3_48(final String SAP_6_2_3_48) { this.SAP_6_2_3_48=SAP_6_2_3_48;}
    @Column(name = "SAP_6_2_3_49")
    @JsonProperty("SAP-6-2-3-49")
    private String SAP_6_2_3_49; // 阿米卡星药物停止使用日期时间
    public String getSAP_6_2_3_49() {  return this.SAP_6_2_3_49;}
    @JsonProperty("SAP-6-2-3-49")
    public void setSAP_6_2_3_49(final String SAP_6_2_3_49) { this.SAP_6_2_3_49=SAP_6_2_3_49;}
    @Column(name = "SAP_6_2_3_50")
    @JsonProperty("SAP-6-2-3-50")
    private String SAP_6_2_3_50; // 使用依替米星药物起始日期时间
    public String getSAP_6_2_3_50() {  return this.SAP_6_2_3_50;}
    @JsonProperty("SAP-6-2-3-50")
    public void setSAP_6_2_3_50(final String SAP_6_2_3_50) { this.SAP_6_2_3_50=SAP_6_2_3_50;}
    @Column(name = "SAP_6_2_3_51")
    @JsonProperty("SAP-6-2-3-51")
    private String SAP_6_2_3_51; // 依替米星药物停止使用日期时间
    public String getSAP_6_2_3_51() {  return this.SAP_6_2_3_51;}
    @JsonProperty("SAP-6-2-3-51")
    public void setSAP_6_2_3_51(final String SAP_6_2_3_51) { this.SAP_6_2_3_51=SAP_6_2_3_51;}
    @Column(name = "SAP_6_2_3_52")
    @JsonProperty("SAP-6-2-3-52")
    private String SAP_6_2_3_52; // 使用奈替米星药物起始日期时间
    public String getSAP_6_2_3_52() {  return this.SAP_6_2_3_52;}
    @JsonProperty("SAP-6-2-3-52")
    public void setSAP_6_2_3_52(final String SAP_6_2_3_52) { this.SAP_6_2_3_52=SAP_6_2_3_52;}
    @Column(name = "SAP_6_2_3_53")
    @JsonProperty("SAP-6-2-3-53")
    private String SAP_6_2_3_53; // 奈替米星药物停止使用日期时间
    public String getSAP_6_2_3_53() {  return this.SAP_6_2_3_53;}
    @JsonProperty("SAP-6-2-3-53")
    public void setSAP_6_2_3_53(final String SAP_6_2_3_53) { this.SAP_6_2_3_53=SAP_6_2_3_53;}
    @Column(name = "SAP_6_2_3_54")
    @JsonProperty("SAP-6-2-3-54")
    private String SAP_6_2_3_54; // 使用替卡西林/克拉维酸药物起始日期时间
    public String getSAP_6_2_3_54() {  return this.SAP_6_2_3_54;}
    @JsonProperty("SAP-6-2-3-54")
    public void setSAP_6_2_3_54(final String SAP_6_2_3_54) { this.SAP_6_2_3_54=SAP_6_2_3_54;}
    @Column(name = "SAP_6_2_3_55")
    @JsonProperty("SAP-6-2-3-55")
    private String SAP_6_2_3_55; // 替卡西林/克拉维酸药物停止使用日期时间
    public String getSAP_6_2_3_55() {  return this.SAP_6_2_3_55;}
    @JsonProperty("SAP-6-2-3-55")
    public void setSAP_6_2_3_55(final String SAP_6_2_3_55) { this.SAP_6_2_3_55=SAP_6_2_3_55;}
    @Column(name = "SAP_6_2_3_56")
    @JsonProperty("SAP-6-2-3-56")
    private String SAP_6_2_3_56; // 使用氨苄西林/舒巴坦药物起始日期时间
    public String getSAP_6_2_3_56() {  return this.SAP_6_2_3_56;}
    @JsonProperty("SAP-6-2-3-56")
    public void setSAP_6_2_3_56(final String SAP_6_2_3_56) { this.SAP_6_2_3_56=SAP_6_2_3_56;}
    @Column(name = "SAP_6_2_3_57")
    @JsonProperty("SAP-6-2-3-57")
    private String SAP_6_2_3_57; // 氨苄西林/舒巴坦药物停止使用日期时间
    public String getSAP_6_2_3_57() {  return this.SAP_6_2_3_57;}
    @JsonProperty("SAP-6-2-3-57")
    public void setSAP_6_2_3_57(final String SAP_6_2_3_57) { this.SAP_6_2_3_57=SAP_6_2_3_57;}
    @Column(name = "SAP_6_2_3_58")
    @JsonProperty("SAP-6-2-3-58")
    private String SAP_6_2_3_58; // 使用阿莫西林/克拉维酸药物起始日期时间
    public String getSAP_6_2_3_58() {  return this.SAP_6_2_3_58;}
    @JsonProperty("SAP-6-2-3-58")
    public void setSAP_6_2_3_58(final String SAP_6_2_3_58) { this.SAP_6_2_3_58=SAP_6_2_3_58;}
    @Column(name = "SAP_6_2_3_59")
    @JsonProperty("SAP-6-2-3-59")
    private String SAP_6_2_3_59; // 阿莫西林/克拉维酸药物停止使用日期时间
    public String getSAP_6_2_3_59() {  return this.SAP_6_2_3_59;}
    @JsonProperty("SAP-6-2-3-59")
    public void setSAP_6_2_3_59(final String SAP_6_2_3_59) { this.SAP_6_2_3_59=SAP_6_2_3_59;}
    @Column(name = "SAP_6_2_3_60")
    @JsonProperty("SAP-6-2-3-60")
    private String SAP_6_2_3_60; // 使用亚胺培南/西司他丁药物起始日期时间
    public String getSAP_6_2_3_60() {  return this.SAP_6_2_3_60;}
    @JsonProperty("SAP-6-2-3-60")
    public void setSAP_6_2_3_60(final String SAP_6_2_3_60) { this.SAP_6_2_3_60=SAP_6_2_3_60;}
    @Column(name = "SAP_6_2_3_61")
    @JsonProperty("SAP-6-2-3-61")
    private String SAP_6_2_3_61; // 亚胺培南/西司他丁药物停止使用日期时间
    public String getSAP_6_2_3_61() {  return this.SAP_6_2_3_61;}
    @JsonProperty("SAP-6-2-3-61")
    public void setSAP_6_2_3_61(final String SAP_6_2_3_61) { this.SAP_6_2_3_61=SAP_6_2_3_61;}
    @Column(name = "SAP_6_2_3_62")
    @JsonProperty("SAP-6-2-3-62")
    private String SAP_6_2_3_62; // 使用厄他培南药物起始日期时间
    public String getSAP_6_2_3_62() {  return this.SAP_6_2_3_62;}
    @JsonProperty("SAP-6-2-3-62")
    public void setSAP_6_2_3_62(final String SAP_6_2_3_62) { this.SAP_6_2_3_62=SAP_6_2_3_62;}
    @Column(name = "SAP_6_2_3_63")
    @JsonProperty("SAP-6-2-3-63")
    private String SAP_6_2_3_63; // 厄他培南药物停止使用日期时间
    public String getSAP_6_2_3_63() {  return this.SAP_6_2_3_63;}
    @JsonProperty("SAP-6-2-3-63")
    public void setSAP_6_2_3_63(final String SAP_6_2_3_63) { this.SAP_6_2_3_63=SAP_6_2_3_63;}
    @Column(name = "SAP_6_2_3_1")
    @JsonProperty("SAP-6-2-3-1")
    private String SAP_6_2_3_1; // 其他类抗感染药物
    public String getSAP_6_2_3_1() {  return this.SAP_6_2_3_1;}
    @JsonProperty("SAP-6-2-3-1")
    public void setSAP_6_2_3_1(final String SAP_6_2_3_1) { this.SAP_6_2_3_1=SAP_6_2_3_1;}
    @Column(name = "SAP_6_2_3_64")
    @JsonProperty("SAP-6-2-3-64")
    private String SAP_6_2_3_64; // 使用其他抗菌药物起始日期时间
    public String getSAP_6_2_3_64() {  return this.SAP_6_2_3_64;}
    @JsonProperty("SAP-6-2-3-64")
    public void setSAP_6_2_3_64(final String SAP_6_2_3_64) { this.SAP_6_2_3_64=SAP_6_2_3_64;}
    @Column(name = "SAP_6_2_3_65")
    @JsonProperty("SAP-6-2-3-65")
    private String SAP_6_2_3_65; // 其他抗菌药物停止使用日期时间
    public String getSAP_6_2_3_65() {  return this.SAP_6_2_3_65;}
    @JsonProperty("SAP-6-2-3-65")
    public void setSAP_6_2_3_65(final String SAP_6_2_3_65) { this.SAP_6_2_3_65=SAP_6_2_3_65;}
    @Column(name = "SAP_7_1_1")
    @JsonProperty("SAP-7-1-1")
    private String SAP_7_1_1; // 是否有重点护理评估
    public String getSAP_7_1_1() {  return this.SAP_7_1_1;}
    @JsonProperty("SAP-7-1-1")
    public void setSAP_7_1_1(final String SAP_7_1_1) { this.SAP_7_1_1=SAP_7_1_1;}
    @Column(name = "SAP_7_1_2")
    @JsonProperty("SAP-7-1-2")
    private String SAP_7_1_2; // 神志状态评估
    public String getSAP_7_1_2() {  return this.SAP_7_1_2;}
    @JsonProperty("SAP-7-1-2")
    public void setSAP_7_1_2(final String SAP_7_1_2) { this.SAP_7_1_2=SAP_7_1_2;}
    @Column(name = "SAP_7_1_3")
    @JsonProperty("SAP-7-1-3")
    private String SAP_7_1_3; // 呼吸状态评估
    public String getSAP_7_1_3() {  return this.SAP_7_1_3;}
    @JsonProperty("SAP-7-1-3")
    public void setSAP_7_1_3(final String SAP_7_1_3) { this.SAP_7_1_3=SAP_7_1_3;}
    @Column(name = "SAP_7_1_4")
    @JsonProperty("SAP-7-1-4")
    private String SAP_7_1_4; // 脉搏/心率评估
    public String getSAP_7_1_4() {  return this.SAP_7_1_4;}
    @JsonProperty("SAP-7-1-4")
    public void setSAP_7_1_4(final String SAP_7_1_4) { this.SAP_7_1_4=SAP_7_1_4;}
    @Column(name = "SAP_7_1_5")
    @JsonProperty("SAP-7-1-5")
    private String SAP_7_1_5; // 体温评估
    public String getSAP_7_1_5() {  return this.SAP_7_1_5;}
    @JsonProperty("SAP-7-1-5")
    public void setSAP_7_1_5(final String SAP_7_1_5) { this.SAP_7_1_5=SAP_7_1_5;}
    @Column(name = "SAP_7_1_6")
    @JsonProperty("SAP-7-1-6")
    private String SAP_7_1_6; // 血压评估
    public String getSAP_7_1_6() {  return this.SAP_7_1_6;}
    @JsonProperty("SAP-7-1-6")
    public void setSAP_7_1_6(final String SAP_7_1_6) { this.SAP_7_1_6=SAP_7_1_6;}
    @Column(name = "SAP_7_1_7")
    @JsonProperty("SAP-7-1-7")
    private String SAP_7_1_7; // 疼痛评估及处理
    public String getSAP_7_1_7() {  return this.SAP_7_1_7;}
    @JsonProperty("SAP-7-1-7")
    public void setSAP_7_1_7(final String SAP_7_1_7) { this.SAP_7_1_7=SAP_7_1_7;}
    @Column(name = "SAP_7_1_8")
    @JsonProperty("SAP-7-1-8")
    private String SAP_7_1_8; // 疼痛复评
    public String getSAP_7_1_8() {  return this.SAP_7_1_8;}
    @JsonProperty("SAP-7-1-8")
    public void setSAP_7_1_8(final String SAP_7_1_8) { this.SAP_7_1_8=SAP_7_1_8;}
    @Column(name = "SAP_7_1_9")
    @JsonProperty("SAP-7-1-9")
    private String SAP_7_1_9; // 饮食评估结果
    public String getSAP_7_1_9() {  return this.SAP_7_1_9;}
    @JsonProperty("SAP-7-1-9")
    public void setSAP_7_1_9(final String SAP_7_1_9) { this.SAP_7_1_9=SAP_7_1_9;}
    @Column(name = "SAP_7_1_10")
    @JsonProperty("SAP-7-1-10")
    private String SAP_7_1_10; // 肢端循环
    public String getSAP_7_1_10() {  return this.SAP_7_1_10;}
    @JsonProperty("SAP-7-1-10")
    public void setSAP_7_1_10(final String SAP_7_1_10) { this.SAP_7_1_10=SAP_7_1_10;}
    @Column(name = "SAP_7_1_11")
    @JsonProperty("SAP-7-1-11")
    private String SAP_7_1_11; // 皮肤/巩膜是否黄染
    public String getSAP_7_1_11() {  return this.SAP_7_1_11;}
    @JsonProperty("SAP-7-1-11")
    public void setSAP_7_1_11(final String SAP_7_1_11) { this.SAP_7_1_11=SAP_7_1_11;}
    @Column(name = "SAP_7_1_12")
    @JsonProperty("SAP-7-1-12")
    private String SAP_7_1_12; // 口干症状评估
    public String getSAP_7_1_12() {  return this.SAP_7_1_12;}
    @JsonProperty("SAP-7-1-12")
    public void setSAP_7_1_12(final String SAP_7_1_12) { this.SAP_7_1_12=SAP_7_1_12;}
    @Column(name = "SAP_7_1_13")
    @JsonProperty("SAP-7-1-13")
    private String SAP_7_1_13; // 发病前的饮食评估
    public String getSAP_7_1_13() {  return this.SAP_7_1_13;}
    @JsonProperty("SAP-7-1-13")
    public void setSAP_7_1_13(final String SAP_7_1_13) { this.SAP_7_1_13=SAP_7_1_13;}
    @Column(name = "SAP_7_1_14")
    @JsonProperty("SAP-7-1-14")
    private String SAP_7_1_14; // 血糖
    public String getSAP_7_1_14() {  return this.SAP_7_1_14;}
    @JsonProperty("SAP-7-1-14")
    public void setSAP_7_1_14(final String SAP_7_1_14) { this.SAP_7_1_14=SAP_7_1_14;}
    @Column(name = "SAP_7_1_15")
    @JsonProperty("SAP-7-1-15")
    private String SAP_7_1_15; // 血气分析结果
    public String getSAP_7_1_15() {  return this.SAP_7_1_15;}
    @JsonProperty("SAP-7-1-15")
    public void setSAP_7_1_15(final String SAP_7_1_15) { this.SAP_7_1_15=SAP_7_1_15;}
    @Column(name = "SAP_7_1_16")
    @JsonProperty("SAP-7-1-16")
    private String SAP_7_1_16; // 尿量评估
    public String getSAP_7_1_16() {  return this.SAP_7_1_16;}
    @JsonProperty("SAP-7-1-16")
    public void setSAP_7_1_16(final String SAP_7_1_16) { this.SAP_7_1_16=SAP_7_1_16;}
    @Column(name = "SAP_7_1_17")
    @JsonProperty("SAP-7-1-17")
    private String SAP_7_1_17; // 胃肠功能评估
    public String getSAP_7_1_17() {  return this.SAP_7_1_17;}
    @JsonProperty("SAP-7-1-17")
    public void setSAP_7_1_17(final String SAP_7_1_17) { this.SAP_7_1_17=SAP_7_1_17;}
    @Column(name = "SAP_7_1_18")
    @JsonProperty("SAP-7-1-18")
    private String SAP_7_1_18; // 腹内压评估
    public String getSAP_7_1_18() {  return this.SAP_7_1_18;}
    @JsonProperty("SAP-7-1-18")
    public void setSAP_7_1_18(final String SAP_7_1_18) { this.SAP_7_1_18=SAP_7_1_18;}
    @Column(name = "SAP_7_1_19_1")
    @JsonProperty("SAP-7-1-19-1")
    private String SAP_7_1_19_1; // 压疮评估结果选择
    public String getSAP_7_1_19_1() {  return this.SAP_7_1_19_1;}
    @JsonProperty("SAP-7-1-19-1")
    public void setSAP_7_1_19_1(final String SAP_7_1_19_1) { this.SAP_7_1_19_1=SAP_7_1_19_1;}
    @Column(name = "SAP_7_1_19_2")
    @JsonProperty("SAP-7-1-19-2")
    private String SAP_7_1_19_2; // 预防压疮告知
    public String getSAP_7_1_19_2() {  return this.SAP_7_1_19_2;}
    @JsonProperty("SAP-7-1-19-2")
    public void setSAP_7_1_19_2(final String SAP_7_1_19_2) { this.SAP_7_1_19_2=SAP_7_1_19_2;}
    @Column(name = "SAP_7_1_20_1")
    @JsonProperty("SAP-7-1-20-1")
    private String SAP_7_1_20_1; // 非计划拔管风险因素评估
    public String getSAP_7_1_20_1() {  return this.SAP_7_1_20_1;}
    @JsonProperty("SAP-7-1-20-1")
    public void setSAP_7_1_20_1(final String SAP_7_1_20_1) { this.SAP_7_1_20_1=SAP_7_1_20_1;}
    @Column(name = "SAP_7_1_20_2")
    @JsonProperty("SAP-7-1-20-2")
    private String SAP_7_1_20_2; // 预防非计划拔管告知
    public String getSAP_7_1_20_2() {  return this.SAP_7_1_20_2;}
    @JsonProperty("SAP-7-1-20-2")
    public void setSAP_7_1_20_2(final String SAP_7_1_20_2) { this.SAP_7_1_20_2=SAP_7_1_20_2;}
    @Column(name = "SAP_7_1_21")
    @JsonProperty("SAP-7-1-21")
    private String SAP_7_1_21; // 伤口评估
    public String getSAP_7_1_21() {  return this.SAP_7_1_21;}
    @JsonProperty("SAP-7-1-21")
    public void setSAP_7_1_21(final String SAP_7_1_21) { this.SAP_7_1_21=SAP_7_1_21;}
    @Column(name = "SAP_7_1_21_1")
    @JsonProperty("SAP-7-1-21-1")
    private String SAP_7_1_21_1; // 其他伤口评估
    public String getSAP_7_1_21_1() {  return this.SAP_7_1_21_1;}
    @JsonProperty("SAP-7-1-21-1")
    public void setSAP_7_1_21_1(final String SAP_7_1_21_1) { this.SAP_7_1_21_1=SAP_7_1_21_1;}
    @Column(name = "SAP_7_1_22")
    @JsonProperty("SAP-7-1-22")
    private String SAP_7_1_22; // 心理评估
    public String getSAP_7_1_22() {  return this.SAP_7_1_22;}
    @JsonProperty("SAP-7-1-22")
    public void setSAP_7_1_22(final String SAP_7_1_22) { this.SAP_7_1_22=SAP_7_1_22;}
    @Column(name = "SAP_7_2_1")
    @JsonProperty("SAP-7-2-1")
    private String SAP_7_2_1; // 实验室主要检查
    public String getSAP_7_2_1() {  return this.SAP_7_2_1;}
    @JsonProperty("SAP-7-2-1")
    public void setSAP_7_2_1(final String SAP_7_2_1) { this.SAP_7_2_1=SAP_7_2_1;}
    @Column(name = "SAP_7_2_2")
    @JsonProperty("SAP-7-2-2")
    private String SAP_7_2_2; // 血清淀粉酶检测方式
    public String getSAP_7_2_2() {  return this.SAP_7_2_2;}
    @JsonProperty("SAP-7-2-2")
    public void setSAP_7_2_2(final String SAP_7_2_2) { this.SAP_7_2_2=SAP_7_2_2;}
    @Column(name = "SAP_7_2_2_1")
    @JsonProperty("SAP-7-2-2-1")
    private String SAP_7_2_2_1; // 酶速率法 检测值(U/L)
    public String getSAP_7_2_2_1() {  return this.SAP_7_2_2_1;}
    @JsonProperty("SAP-7-2-2-1")
    public void setSAP_7_2_2_1(final String SAP_7_2_2_1) { this.SAP_7_2_2_1=SAP_7_2_2_1;}
    @Column(name = "SAP_7_2_2_2")
    @JsonProperty("SAP-7-2-2-2")
    private String SAP_7_2_2_2; // 碘比色 检测值(U/L)
    public String getSAP_7_2_2_2() {  return this.SAP_7_2_2_2;}
    @JsonProperty("SAP-7-2-2-2")
    public void setSAP_7_2_2_2(final String SAP_7_2_2_2) { this.SAP_7_2_2_2=SAP_7_2_2_2;}
    @Column(name = "SAP_7_2_2_3")
    @JsonProperty("SAP-7-2-2-3")
    private String SAP_7_2_2_3; // BMD法 检测值(U/L)
    public String getSAP_7_2_2_3() {  return this.SAP_7_2_2_3;}
    @JsonProperty("SAP-7-2-2-3")
    public void setSAP_7_2_2_3(final String SAP_7_2_2_3) { this.SAP_7_2_2_3=SAP_7_2_2_3;}
    @Column(name = "SAP_7_2_3")
    @JsonProperty("SAP-7-2-3")
    private String SAP_7_2_3; // 血清脂肪酶检测方式
    public String getSAP_7_2_3() {  return this.SAP_7_2_3;}
    @JsonProperty("SAP-7-2-3")
    public void setSAP_7_2_3(final String SAP_7_2_3) { this.SAP_7_2_3=SAP_7_2_3;}
    @Column(name = "SAP_7_2_3_1")
    @JsonProperty("SAP-7-2-3-1")
    private String SAP_7_2_3_1; // 滴度法测定值(U/L)
    public String getSAP_7_2_3_1() {  return this.SAP_7_2_3_1;}
    @JsonProperty("SAP-7-2-3-1")
    public void setSAP_7_2_3_1(final String SAP_7_2_3_1) { this.SAP_7_2_3_1=SAP_7_2_3_1;}
    @Column(name = "SAP_7_2_3_2")
    @JsonProperty("SAP-7-2-3-2")
    private String SAP_7_2_3_2; // 比色法测定值(U/L)
    public String getSAP_7_2_3_2() {  return this.SAP_7_2_3_2;}
    @JsonProperty("SAP-7-2-3-2")
    public void setSAP_7_2_3_2(final String SAP_7_2_3_2) { this.SAP_7_2_3_2=SAP_7_2_3_2;}
    @Column(name = "SAP_7_2_3_3")
    @JsonProperty("SAP-7-2-3-3")
    private String SAP_7_2_3_3; // C反应蛋白浓度(mg/L)
    public String getSAP_7_2_3_3() {  return this.SAP_7_2_3_3;}
    @JsonProperty("SAP-7-2-3-3")
    public void setSAP_7_2_3_3(final String SAP_7_2_3_3) { this.SAP_7_2_3_3=SAP_7_2_3_3;}
    @Column(name = "SAP_7_2_3_4")
    @JsonProperty("SAP-7-2-3-4")
    private String SAP_7_2_3_4; // 血清降钙素原浓度(ng/mL)
    public String getSAP_7_2_3_4() {  return this.SAP_7_2_3_4;}
    @JsonProperty("SAP-7-2-3-4")
    public void setSAP_7_2_3_4(final String SAP_7_2_3_4) { this.SAP_7_2_3_4=SAP_7_2_3_4;}
    @Column(name = "SAP_7_2_3_5")
    @JsonProperty("SAP-7-2-3-5")
    private String SAP_7_2_3_5; // 白细胞浓度(10⁹/L)
    public String getSAP_7_2_3_5() {  return this.SAP_7_2_3_5;}
    @JsonProperty("SAP-7-2-3-5")
    public void setSAP_7_2_3_5(final String SAP_7_2_3_5) { this.SAP_7_2_3_5=SAP_7_2_3_5;}
    @Column(name = "SAP_7_2_4")
    @JsonProperty("SAP-7-2-4")
    private String SAP_7_2_4; // 医嘱离院/医嘱转院患者离院前病情评估?（非医嘱离院、死亡患者不填写）
    public String getSAP_7_2_4() {  return this.SAP_7_2_4;}
    @JsonProperty("SAP-7-2-4")
    public void setSAP_7_2_4(final String SAP_7_2_4) { this.SAP_7_2_4=SAP_7_2_4;}
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
    private String CM_7_2_3; // 告知何为风险因素与紧急情况
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