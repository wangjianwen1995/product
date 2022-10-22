package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码 ： C53 开头，且伴主要手术ICD-9-CM-3 编码：67.2 至 67.4，68.4，68.5，68.6，68.7的手术出院患者。
*/
@ApiModel(value = "33信息")
@Entity
@Table(name = "sd_info_CC")
public class SdInfoCC implements Serializable {
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
    @Column(name = "CC_0_1_4_1")
    @JsonProperty("CC-0-1-4-1")
    private String CC_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    public String getCC_0_1_4_1() {  return this.CC_0_1_4_1;}
    @JsonProperty("CC-0-1-4-1")
    public void setCC_0_1_4_1(final String CC_0_1_4_1) { this.CC_0_1_4_1=CC_0_1_4_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "CC_0_1_4_2")
    @JsonProperty("CC-0-1-4-2")
    private String CC_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
    public String getCC_0_1_4_2() {  return this.CC_0_1_4_2;}
    @JsonProperty("CC-0-1-4-2")
    public void setCC_0_1_4_2(final String CC_0_1_4_2) { this.CC_0_1_4_2=CC_0_1_4_2;}
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
    @Column(name = "CC_1_1_1")
    @JsonProperty("CC-1-1-1")
    private String CC_1_1_1; // 治疗前是否有病理组织形态学/细胞学诊断报告
    public String getCC_1_1_1() {  return this.CC_1_1_1;}
    @JsonProperty("CC-1-1-1")
    public void setCC_1_1_1(final String CC_1_1_1) { this.CC_1_1_1=CC_1_1_1;}
    @Column(name = "CC_1_1_2")
    @JsonProperty("CC-1-1-2")
    private String CC_1_1_2; // 采集组织或细胞学标本来源途经
    public String getCC_1_1_2() {  return this.CC_1_1_2;}
    @JsonProperty("CC-1-1-2")
    public void setCC_1_1_2(final String CC_1_1_2) { this.CC_1_1_2=CC_1_1_2;}
    @Column(name = "CC_1_1_2_1")
    @JsonProperty("CC-1-1-2-1")
    private String CC_1_1_2_1; // 其他来源标本
    public String getCC_1_1_2_1() {  return this.CC_1_1_2_1;}
    @JsonProperty("CC-1-1-2-1")
    public void setCC_1_1_2_1(final String CC_1_1_2_1) { this.CC_1_1_2_1=CC_1_1_2_1;}
    @Column(name = "CC_1_1_3")
    @JsonProperty("CC-1-1-3")
    private String CC_1_1_3; // 是否有FIGO(pTNM) 临床分期结论
    public String getCC_1_1_3() {  return this.CC_1_1_3;}
    @JsonProperty("CC-1-1-3")
    public void setCC_1_1_3(final String CC_1_1_3) { this.CC_1_1_3=CC_1_1_3;}
    @Column(name = "CC_1_1_4")
    @JsonProperty("CC-1-1-4")
    private String CC_1_1_4; // FIGO(pTNM)  临床分期结论
    public String getCC_1_1_4() {  return this.CC_1_1_4;}
    @JsonProperty("CC-1-1-4")
    public void setCC_1_1_4(final String CC_1_1_4) { this.CC_1_1_4=CC_1_1_4;}
    @Column(name = "CC_1_1_5")
    @JsonProperty("CC-1-1-5")
    private String CC_1_1_5; // 病理组织形态学/细胞学诊断报告单FIGO(pTNM) 临床分期结论距本次治疗前的时限
    public String getCC_1_1_5() {  return this.CC_1_1_5;}
    @JsonProperty("CC-1-1-5")
    public void setCC_1_1_5(final String CC_1_1_5) { this.CC_1_1_5=CC_1_1_5;}
    @Column(name = "CC_1_2_1")
    @JsonProperty("CC-1-2-1")
    private String CC_1_2_1; // 治疗前是否有影像学诊断报告
    public String getCC_1_2_1() {  return this.CC_1_2_1;}
    @JsonProperty("CC-1-2-1")
    public void setCC_1_2_1(final String CC_1_2_1) { this.CC_1_2_1=CC_1_2_1;}
    @Column(name = "CC_1_2_2")
    @JsonProperty("CC-1-2-2")
    private String CC_1_2_2; // 影像学检查项目
    public String getCC_1_2_2() {  return this.CC_1_2_2;}
    @JsonProperty("CC-1-2-2")
    public void setCC_1_2_2(final String CC_1_2_2) { this.CC_1_2_2=CC_1_2_2;}
    @Column(name = "CC_1_2_2_1")
    @JsonProperty("CC-1-2-2-1")
    private String CC_1_2_2_1; // 其他影像学检查项目
    public String getCC_1_2_2_1() {  return this.CC_1_2_2_1;}
    @JsonProperty("CC-1-2-2-1")
    public void setCC_1_2_2_1(final String CC_1_2_2_1) { this.CC_1_2_2_1=CC_1_2_2_1;}
    @Column(name = "CC_1_2_3")
    @JsonProperty("CC-1-2-3")
    private String CC_1_2_3; // 是否有FIGO(rTNM) 临床分期结论
    public String getCC_1_2_3() {  return this.CC_1_2_3;}
    @JsonProperty("CC-1-2-3")
    public void setCC_1_2_3(final String CC_1_2_3) { this.CC_1_2_3=CC_1_2_3;}
    @Column(name = "CC_1_2_4")
    @JsonProperty("CC-1-2-4")
    private String CC_1_2_4; // FIGO(rTNM)  临床分期结论
    public String getCC_1_2_4() {  return this.CC_1_2_4;}
    @JsonProperty("CC-1-2-4")
    public void setCC_1_2_4(final String CC_1_2_4) { this.CC_1_2_4=CC_1_2_4;}
    @Column(name = "CC_1_3_1")
    @JsonProperty("CC-1-3-1")
    private String CC_1_3_1; //  治疗前是否完成妇科检查
    public String getCC_1_3_1() {  return this.CC_1_3_1;}
    @JsonProperty("CC-1-3-1")
    public void setCC_1_3_1(final String CC_1_3_1) { this.CC_1_3_1=CC_1_3_1;}
    @Column(name = "CC_1_3_2")
    @JsonProperty("CC-1-3-2")
    private String CC_1_3_2; // 治疗前妇科检查内容
    public String getCC_1_3_2() {  return this.CC_1_3_2;}
    @JsonProperty("CC-1-3-2")
    public void setCC_1_3_2(final String CC_1_3_2) { this.CC_1_3_2=CC_1_3_2;}
    @Column(name = "CC_1_3_3")
    @JsonProperty("CC-1-3-3")
    private String CC_1_3_3; // 治疗前是否完成体能评估
    public String getCC_1_3_3() {  return this.CC_1_3_3;}
    @JsonProperty("CC-1-3-3")
    public void setCC_1_3_3(final String CC_1_3_3) { this.CC_1_3_3=CC_1_3_3;}
    @Column(name = "CC_1_3_4")
    @JsonProperty("CC-1-3-4")
    private String CC_1_3_4; // 治疗前体能评估内容
    public String getCC_1_3_4() {  return this.CC_1_3_4;}
    @JsonProperty("CC-1-3-4")
    public void setCC_1_3_4(final String CC_1_3_4) { this.CC_1_3_4=CC_1_3_4;}
    @Column(name = "CC_1_3_4_1")
    @JsonProperty("CC-1-3-4-1")
    private String CC_1_3_4_1; // KPS评分值(分)
    public String getCC_1_3_4_1() {  return this.CC_1_3_4_1;}
    @JsonProperty("CC-1-3-4-1")
    public void setCC_1_3_4_1(final String CC_1_3_4_1) { this.CC_1_3_4_1=CC_1_3_4_1;}
    @Column(name = "CC_1_3_4_2")
    @JsonProperty("CC-1-3-4-2")
    private String CC_1_3_4_2; // PS评分值(分)
    public String getCC_1_3_4_2() {  return this.CC_1_3_4_2;}
    @JsonProperty("CC-1-3-4-2")
    public void setCC_1_3_4_2(final String CC_1_3_4_2) { this.CC_1_3_4_2=CC_1_3_4_2;}
    @Column(name = "CC_1_3_5")
    @JsonProperty("CC-1-3-5")
    private String CC_1_3_5; // 治疗前是否完成生化检查
    public String getCC_1_3_5() {  return this.CC_1_3_5;}
    @JsonProperty("CC-1-3-5")
    public void setCC_1_3_5(final String CC_1_3_5) { this.CC_1_3_5=CC_1_3_5;}
    @Column(name = "CC_1_3_6")
    @JsonProperty("CC-1-3-6")
    private String CC_1_3_6; // 生化检查项目
    public String getCC_1_3_6() {  return this.CC_1_3_6;}
    @JsonProperty("CC-1-3-6")
    public void setCC_1_3_6(final String CC_1_3_6) { this.CC_1_3_6=CC_1_3_6;}
    @Column(name = "CC_1_3_6_1")
    @JsonProperty("CC-1-3-6-1")
    private String CC_1_3_6_1; // 其他生化检查项目
    public String getCC_1_3_6_1() {  return this.CC_1_3_6_1;}
    @JsonProperty("CC-1-3-6-1")
    public void setCC_1_3_6_1(final String CC_1_3_6_1) { this.CC_1_3_6_1=CC_1_3_6_1;}
    @Column(name = "CC_1_4_1")
    @JsonProperty("CC-1-4-1")
    private String CC_1_4_1; // 治疗前是否完成深静脉栓塞（VTE）风险评估
    public String getCC_1_4_1() {  return this.CC_1_4_1;}
    @JsonProperty("CC-1-4-1")
    public void setCC_1_4_1(final String CC_1_4_1) { this.CC_1_4_1=CC_1_4_1;}
    @Column(name = "CC_1_4_2")
    @JsonProperty("CC-1-4-2")
    private String CC_1_4_2; // VET风险评估结果
    public String getCC_1_4_2() {  return this.CC_1_4_2;}
    @JsonProperty("CC-1-4-2")
    public void setCC_1_4_2(final String CC_1_4_2) { this.CC_1_4_2=CC_1_4_2;}
    @Column(name = "CC_1_4_3")
    @JsonProperty("CC-1-4-3")
    private String CC_1_4_3; // 采取措施
    public String getCC_1_4_3() {  return this.CC_1_4_3;}
    @JsonProperty("CC-1-4-3")
    public void setCC_1_4_3(final String CC_1_4_3) { this.CC_1_4_3=CC_1_4_3;}
    @Column(name = "CC_1_5_1")
    @JsonProperty("CC-1-5-1")
    private String CC_1_5_1; // 治疗前是否完成临床FIGO(cTNM) 分期
    public String getCC_1_5_1() {  return this.CC_1_5_1;}
    @JsonProperty("CC-1-5-1")
    public void setCC_1_5_1(final String CC_1_5_1) { this.CC_1_5_1=CC_1_5_1;}
    @Column(name = "CC_1_5_2")
    @JsonProperty("CC-1-5-2")
    private String CC_1_5_2; // 原发肿瘤（T）分期
    public String getCC_1_5_2() {  return this.CC_1_5_2;}
    @JsonProperty("CC-1-5-2")
    public void setCC_1_5_2(final String CC_1_5_2) { this.CC_1_5_2=CC_1_5_2;}
    @Column(name = "CC_1_5_3")
    @JsonProperty("CC-1-5-3")
    private String CC_1_5_3; // 区域淋巴结（N）分期 
    public String getCC_1_5_3() {  return this.CC_1_5_3;}
    @JsonProperty("CC-1-5-3")
    public void setCC_1_5_3(final String CC_1_5_3) { this.CC_1_5_3=CC_1_5_3;}
    @Column(name = "CC_1_5_3_1")
    @JsonProperty("CC-1-5-3-1")
    private String CC_1_5_3_1; // 累及盆腔和/或腹主动脉旁淋巴结（注明r或p）
    public String getCC_1_5_3_1() {  return this.CC_1_5_3_1;}
    @JsonProperty("CC-1-5-3-1")
    public void setCC_1_5_3_1(final String CC_1_5_3_1) { this.CC_1_5_3_1=CC_1_5_3_1;}
    @Column(name = "CC_1_5_4")
    @JsonProperty("CC-1-5-4")
    private String CC_1_5_4; // 远处转移（M）分期
    public String getCC_1_5_4() {  return this.CC_1_5_4;}
    @JsonProperty("CC-1-5-4")
    public void setCC_1_5_4(final String CC_1_5_4) { this.CC_1_5_4=CC_1_5_4;}
    @Column(name = "CC_1_5_4_r")
    @JsonProperty("CC-1-5-4-r")
    private String CC_1_5_4_r; // 
    public String getCC_1_5_4_r() {  return this.CC_1_5_4_r;}
    @JsonProperty("CC-1-5-4-r")
    public void setCC_1_5_4_r(final String CC_1_5_4_r) { this.CC_1_5_4_r=CC_1_5_4_r;}
    @Column(name = "CC_1_5_5")
    @JsonProperty("CC-1-5-5")
    private String CC_1_5_5; // 治疗前 cTNM 临床分期结论
    public String getCC_1_5_5() {  return this.CC_1_5_5;}
    @JsonProperty("CC-1-5-5")
    public void setCC_1_5_5(final String CC_1_5_5) { this.CC_1_5_5=CC_1_5_5;}
    @Column(name = "CC_1_6_1")
    @JsonProperty("CC-1-6-1")
    private String CC_1_6_1; // 是否将替代治疗方案的益处和风险明确告知患者
    public String getCC_1_6_1() {  return this.CC_1_6_1;}
    @JsonProperty("CC-1-6-1")
    public void setCC_1_6_1(final String CC_1_6_1) { this.CC_1_6_1=CC_1_6_1;}
    @Column(name = "CC_1_6_2")
    @JsonProperty("CC-1-6-2")
    private String CC_1_6_2; // 是否将不同手术途径和术式的风险和益处明确告知患者
    public String getCC_1_6_2() {  return this.CC_1_6_2;}
    @JsonProperty("CC-1-6-2")
    public void setCC_1_6_2(final String CC_1_6_2) { this.CC_1_6_2=CC_1_6_2;}
    @Column(name = "CC_1_6_3")
    @JsonProperty("CC-1-6-3")
    private String CC_1_6_3; // 是否与患者充分讨论保留生育力的治疗方案
    public String getCC_1_6_3() {  return this.CC_1_6_3;}
    @JsonProperty("CC-1-6-3")
    public void setCC_1_6_3(final String CC_1_6_3) { this.CC_1_6_3=CC_1_6_3;}
    @Column(name = "CC_1_7_1")
    @JsonProperty("CC-1-7-1")
    private String CC_1_7_1; // 是否治疗前接受过MDT会诊的患者
    public String getCC_1_7_1() {  return this.CC_1_7_1;}
    @JsonProperty("CC-1-7-1")
    public void setCC_1_7_1(final String CC_1_7_1) { this.CC_1_7_1=CC_1_7_1;}
    @Column(name = "CC_1_8_1")
    @JsonProperty("CC-1-8-1")
    private String CC_1_8_1; // 是否治疗前接受过新辅助化疗的患者
    public String getCC_1_8_1() {  return this.CC_1_8_1;}
    @JsonProperty("CC-1-8-1")
    public void setCC_1_8_1(final String CC_1_8_1) { this.CC_1_8_1=CC_1_8_1;}
    @Column(name = "CC_1_8_2")
    @JsonProperty("CC-1-8-2")
    private String CC_1_8_2; // 是否治疗前接受过介入的患者
    public String getCC_1_8_2() {  return this.CC_1_8_2;}
    @JsonProperty("CC-1-8-2")
    public void setCC_1_8_2(final String CC_1_8_2) { this.CC_1_8_2=CC_1_8_2;}
    @Column(name = "CC_1_8_3")
    @JsonProperty("CC-1-8-3")
    private String CC_1_8_3; // 是否治疗前接受过根治性放疗的患者
    public String getCC_1_8_3() {  return this.CC_1_8_3;}
    @JsonProperty("CC-1-8-3")
    public void setCC_1_8_3(final String CC_1_8_3) { this.CC_1_8_3=CC_1_8_3;}
    @Column(name = "CC_2_1_1")
    @JsonProperty("CC-2-1-1")
    private String CC_2_1_1; // 手术适应证选择
    public String getCC_2_1_1() {  return this.CC_2_1_1;}
    @JsonProperty("CC-2-1-1")
    public void setCC_2_1_1(final String CC_2_1_1) { this.CC_2_1_1=CC_2_1_1;}
    @Column(name = "CC_2_1_1_1")
    @JsonProperty("CC-2-1-1-1")
    private String CC_2_1_1_1; // 其他手术适应证
    public String getCC_2_1_1_1() {  return this.CC_2_1_1_1;}
    @JsonProperty("CC-2-1-1-1")
    public void setCC_2_1_1_1(final String CC_2_1_1_1) { this.CC_2_1_1_1=CC_2_1_1_1;}
    @Column(name = "CC_2_1_2")
    @JsonProperty("CC-2-1-2")
    private String CC_2_1_2; // 保留生育的手术适应证选择
    public String getCC_2_1_2() {  return this.CC_2_1_2;}
    @JsonProperty("CC-2-1-2")
    public void setCC_2_1_2(final String CC_2_1_2) { this.CC_2_1_2=CC_2_1_2;}
    @Column(name = "CC_2_1_2_1")
    @JsonProperty("CC-2-1-2-1")
    private String CC_2_1_2_1; // 保留生育的其他手术适应证
    public String getCC_2_1_2_1() {  return this.CC_2_1_2_1;}
    @JsonProperty("CC-2-1-2-1")
    public void setCC_2_1_2_1(final String CC_2_1_2_1) { this.CC_2_1_2_1=CC_2_1_2_1;}
    @Column(name = "CC_2_1_3")
    @JsonProperty("CC-2-1-3")
    private String CC_2_1_3; // 是否有手术禁忌证
    public String getCC_2_1_3() {  return this.CC_2_1_3;}
    @JsonProperty("CC-2-1-3")
    public void setCC_2_1_3(final String CC_2_1_3) { this.CC_2_1_3=CC_2_1_3;}
    @Column(name = "CC_2_1_4")
    @JsonProperty("CC-2-1-4")
    private String CC_2_1_4; // 手术禁忌证
    public String getCC_2_1_4() {  return this.CC_2_1_4;}
    @JsonProperty("CC-2-1-4")
    public void setCC_2_1_4(final String CC_2_1_4) { this.CC_2_1_4=CC_2_1_4;}
    @Column(name = "CC_2_2_1")
    @JsonProperty("CC-2-2-1")
    private String CC_2_2_1; // 宫颈癌手术方式的选择
    public String getCC_2_2_1() {  return this.CC_2_2_1;}
    @JsonProperty("CC-2-2-1")
    public void setCC_2_2_1(final String CC_2_2_1) { this.CC_2_2_1=CC_2_2_1;}
    @Column(name = "CC_2_2_2")
    @JsonProperty("CC-2-2-2")
    private String CC_2_2_2; // 根治性手术治疗符合原则规范
    public String getCC_2_2_2() {  return this.CC_2_2_2;}
    @JsonProperty("CC-2-2-2")
    public void setCC_2_2_2(final String CC_2_2_2) { this.CC_2_2_2=CC_2_2_2;}
    @Column(name = "CC_2_2_3")
    @JsonProperty("CC-2-2-3")
    private String CC_2_2_3; // 保育性手术治疗符合原则规范
    public String getCC_2_2_3() {  return this.CC_2_2_3;}
    @JsonProperty("CC-2-2-3")
    public void setCC_2_2_3(final String CC_2_2_3) { this.CC_2_2_3=CC_2_2_3;}
    @Column(name = "CC_2_3_1")
    @JsonProperty("CC-2-3-1")
    private String CC_2_3_1; // 是否有手术淋巴结清扫
    public String getCC_2_3_1() {  return this.CC_2_3_1;}
    @JsonProperty("CC-2-3-1")
    public void setCC_2_3_1(final String CC_2_3_1) { this.CC_2_3_1=CC_2_3_1;}
    @Column(name = "CC_2_3_2")
    @JsonProperty("CC-2-3-2")
    private String CC_2_3_2; // 淋巴结清扫组别
    public String getCC_2_3_2() {  return this.CC_2_3_2;}
    @JsonProperty("CC-2-3-2")
    public void setCC_2_3_2(final String CC_2_3_2) { this.CC_2_3_2=CC_2_3_2;}
    @Column(name = "CC_2_3_2_1")
    @JsonProperty("CC-2-3-2-1")
    private String CC_2_3_2_1; // 其他淋巴结清扫组别
    public String getCC_2_3_2_1() {  return this.CC_2_3_2_1;}
    @JsonProperty("CC-2-3-2-1")
    public void setCC_2_3_2_1(final String CC_2_3_2_1) { this.CC_2_3_2_1=CC_2_3_2_1;}
    @Column(name = "CC_2_3_3")
    @JsonProperty("CC-2-3-3")
    private String CC_2_3_3; // 淋巴结清扫范围达到层别的结论
    public String getCC_2_3_3() {  return this.CC_2_3_3;}
    @JsonProperty("CC-2-3-3")
    public void setCC_2_3_3(final String CC_2_3_3) { this.CC_2_3_3=CC_2_3_3;}
    @Column(name = "CC_2_3_4")
    @JsonProperty("CC-2-3-4")
    private String CC_2_3_4; // 前哨淋巴结示踪剂选择
    public String getCC_2_3_4() {  return this.CC_2_3_4;}
    @JsonProperty("CC-2-3-4")
    public void setCC_2_3_4(final String CC_2_3_4) { this.CC_2_3_4=CC_2_3_4;}
    @Column(name = "CC_2_3_4_1")
    @JsonProperty("CC-2-3-4-1")
    private String CC_2_3_4_1; // 其他前哨淋巴结示踪剂
    public String getCC_2_3_4_1() {  return this.CC_2_3_4_1;}
    @JsonProperty("CC-2-3-4-1")
    public void setCC_2_3_4_1(final String CC_2_3_4_1) { this.CC_2_3_4_1=CC_2_3_4_1;}
    @Column(name = "CC_2_3_5")
    @JsonProperty("CC-2-3-5")
    private String CC_2_3_5; // 前哨淋巴结示踪剂注射部位选择
    public String getCC_2_3_5() {  return this.CC_2_3_5;}
    @JsonProperty("CC-2-3-5")
    public void setCC_2_3_5(final String CC_2_3_5) { this.CC_2_3_5=CC_2_3_5;}
    @Column(name = "CC_2_3_5_1")
    @JsonProperty("CC-2-3-5-1")
    private String CC_2_3_5_1; // 前哨淋巴结示踪剂注射其他部位
    public String getCC_2_3_5_1() {  return this.CC_2_3_5_1;}
    @JsonProperty("CC-2-3-5-1")
    public void setCC_2_3_5_1(final String CC_2_3_5_1) { this.CC_2_3_5_1=CC_2_3_5_1;}
    @Column(name = "CC_2_3_6")
    @JsonProperty("CC-2-3-6")
    private String CC_2_3_6; // 前哨淋巴结显示部位
    public String getCC_2_3_6() {  return this.CC_2_3_6;}
    @JsonProperty("CC-2-3-6")
    public void setCC_2_3_6(final String CC_2_3_6) { this.CC_2_3_6=CC_2_3_6;}
    @Column(name = "CC_2_3_6_1")
    @JsonProperty("CC-2-3-6-1")
    private String CC_2_3_6_1; // 前哨淋巴结其他显示部位
    public String getCC_2_3_6_1() {  return this.CC_2_3_6_1;}
    @JsonProperty("CC-2-3-6-1")
    public void setCC_2_3_6_1(final String CC_2_3_6_1) { this.CC_2_3_6_1=CC_2_3_6_1;}
    @Column(name = "CC_2_4_1")
    @JsonProperty("CC-2-4-1")
    private String CC_2_4_1; // 术中探查宫颈癌病变涉及的范围
    public String getCC_2_4_1() {  return this.CC_2_4_1;}
    @JsonProperty("CC-2-4-1")
    public void setCC_2_4_1(final String CC_2_4_1) { this.CC_2_4_1=CC_2_4_1;}
    @Column(name = "CC_2_4_1_1")
    @JsonProperty("CC-2-4-1-1")
    private String CC_2_4_1_1; // 术中探查宫颈癌病变涉及的其他范围
    public String getCC_2_4_1_1() {  return this.CC_2_4_1_1;}
    @JsonProperty("CC-2-4-1-1")
    public void setCC_2_4_1_1(final String CC_2_4_1_1) { this.CC_2_4_1_1=CC_2_4_1_1;}
    @Column(name = "CC_2_4_2")
    @JsonProperty("CC-2-4-2")
    private String CC_2_4_2; // 实施的宫颈癌术式的选择
    public String getCC_2_4_2() {  return this.CC_2_4_2;}
    @JsonProperty("CC-2-4-2")
    public void setCC_2_4_2(final String CC_2_4_2) { this.CC_2_4_2=CC_2_4_2;}
    @Column(name = "CC_2_4_2_1")
    @JsonProperty("CC-2-4-2-1")
    private String CC_2_4_2_1; // 其他的宫颈癌术式
    public String getCC_2_4_2_1() {  return this.CC_2_4_2_1;}
    @JsonProperty("CC-2-4-2-1")
    public void setCC_2_4_2_1(final String CC_2_4_2_1) { this.CC_2_4_2_1=CC_2_4_2_1;}
    @Column(name = "CC_2_4_3")
    @JsonProperty("CC-2-4-3")
    private String CC_2_4_3; // 手术标本剖视情况描述
    public String getCC_2_4_3() {  return this.CC_2_4_3;}
    @JsonProperty("CC-2-4-3")
    public void setCC_2_4_3(final String CC_2_4_3) { this.CC_2_4_3=CC_2_4_3;}
    @Column(name = "CC_2_4_4")
    @JsonProperty("CC-2-4-4")
    private String CC_2_4_4; // 手术记录描述宫旁切除类型
    public String getCC_2_4_4() {  return this.CC_2_4_4;}
    @JsonProperty("CC-2-4-4")
    public void setCC_2_4_4(final String CC_2_4_4) { this.CC_2_4_4=CC_2_4_4;}
    @Column(name = "CC_2_4_5")
    @JsonProperty("CC-2-4-5")
    private String CC_2_4_5; // 术中是否阴道重建
    public String getCC_2_4_5() {  return this.CC_2_4_5;}
    @JsonProperty("CC-2-4-5")
    public void setCC_2_4_5(final String CC_2_4_5) { this.CC_2_4_5=CC_2_4_5;}
    @Column(name = "CC_2_4_6")
    @JsonProperty("CC-2-4-6")
    private String CC_2_4_6; // 术中阴道重建方式的选择
    public String getCC_2_4_6() {  return this.CC_2_4_6;}
    @JsonProperty("CC-2-4-6")
    public void setCC_2_4_6(final String CC_2_4_6) { this.CC_2_4_6=CC_2_4_6;}
    @Column(name = "CC_2_4_6_1")
    @JsonProperty("CC-2-4-6-1")
    private String CC_2_4_6_1; // 术中其他阴道重建方式
    public String getCC_2_4_6_1() {  return this.CC_2_4_6_1;}
    @JsonProperty("CC-2-4-6-1")
    public void setCC_2_4_6_1(final String CC_2_4_6_1) { this.CC_2_4_6_1=CC_2_4_6_1;}
    @Column(name = "CC_2_4_7")
    @JsonProperty("CC-2-4-7")
    private String CC_2_4_7; // 术中是否卵巢悬吊
    public String getCC_2_4_7() {  return this.CC_2_4_7;}
    @JsonProperty("CC-2-4-7")
    public void setCC_2_4_7(final String CC_2_4_7) { this.CC_2_4_7=CC_2_4_7;}
    @Column(name = "CC_2_4_8")
    @JsonProperty("CC-2-4-8")
    private String CC_2_4_8; // 术中卵巢悬吊的定位选择
    public String getCC_2_4_8() {  return this.CC_2_4_8;}
    @JsonProperty("CC-2-4-8")
    public void setCC_2_4_8(final String CC_2_4_8) { this.CC_2_4_8=CC_2_4_8;}
    @Column(name = "CC_2_4_8_1")
    @JsonProperty("CC-2-4-8-1")
    private String CC_2_4_8_1; // 术中卵巢悬吊的其他定位
    public String getCC_2_4_8_1() {  return this.CC_2_4_8_1;}
    @JsonProperty("CC-2-4-8-1")
    public void setCC_2_4_8_1(final String CC_2_4_8_1) { this.CC_2_4_8_1=CC_2_4_8_1;}
    @Column(name = "CC_2_4_9")
    @JsonProperty("CC-2-4-9")
    private String CC_2_4_9; // 术后其他重建方式的选择
    public String getCC_2_4_9() {  return this.CC_2_4_9;}
    @JsonProperty("CC-2-4-9")
    public void setCC_2_4_9(final String CC_2_4_9) { this.CC_2_4_9=CC_2_4_9;}
    @Column(name = "CC_2_4_9_1")
    @JsonProperty("CC-2-4-9-1")
    private String CC_2_4_9_1; // 术后其他重建的其他方式
    public String getCC_2_4_9_1() {  return this.CC_2_4_9_1;}
    @JsonProperty("CC-2-4-9-1")
    public void setCC_2_4_9_1(final String CC_2_4_9_1) { this.CC_2_4_9_1=CC_2_4_9_1;}
    @Column(name = "CC_2_5_1")
    @JsonProperty("CC-2-5-1")
    private String CC_2_5_1; // 是否有术中实施其他治疗性操作
    public String getCC_2_5_1() {  return this.CC_2_5_1;}
    @JsonProperty("CC-2-5-1")
    public void setCC_2_5_1(final String CC_2_5_1) { this.CC_2_5_1=CC_2_5_1;}
    @Column(name = "CC_2_5_3")
    @JsonProperty("CC-2-5-3")
    private String CC_2_5_3; // 实施其他治疗性操作
    public String getCC_2_5_3() {  return this.CC_2_5_3;}
    @JsonProperty("CC-2-5-3")
    public void setCC_2_5_3(final String CC_2_5_3) { this.CC_2_5_3=CC_2_5_3;}
    @Column(name = "CC_2_5_3_1")
    @JsonProperty("CC-2-5-3-1")
    private String CC_2_5_3_1; // 其他治疗性其他操作
    public String getCC_2_5_3_1() {  return this.CC_2_5_3_1;}
    @JsonProperty("CC-2-5-3-1")
    public void setCC_2_5_3_1(final String CC_2_5_3_1) { this.CC_2_5_3_1=CC_2_5_3_1;}
    @Column(name = "CC_2_6_1")
    @JsonProperty("CC-2-6-1")
    private String CC_2_6_1; // 手术切除范围选择符合原则规范
    public String getCC_2_6_1() {  return this.CC_2_6_1;}
    @JsonProperty("CC-2-6-1")
    public void setCC_2_6_1(final String CC_2_6_1) { this.CC_2_6_1=CC_2_6_1;}
    @Column(name = "CC_2_6_1_1")
    @JsonProperty("CC-2-6-1-1")
    private String CC_2_6_1_1; // 手术切除范围其他符合原则规范
    public String getCC_2_6_1_1() {  return this.CC_2_6_1_1;}
    @JsonProperty("CC-2-6-1-1")
    public void setCC_2_6_1_1(final String CC_2_6_1_1) { this.CC_2_6_1_1=CC_2_6_1_1;}
    @Column(name = "CC_2_7_1")
    @JsonProperty("CC-2-7-1")
    private String CC_2_7_1; // 手术路径选择
    public String getCC_2_7_1() {  return this.CC_2_7_1;}
    @JsonProperty("CC-2-7-1")
    public void setCC_2_7_1(final String CC_2_7_1) { this.CC_2_7_1=CC_2_7_1;}
    @Column(name = "CC_2_7_1_1")
    @JsonProperty("CC-2-7-1-1")
    private String CC_2_7_1_1; // 其他手术路径
    public String getCC_2_7_1_1() {  return this.CC_2_7_1_1;}
    @JsonProperty("CC-2-7-1-1")
    public void setCC_2_7_1_1(final String CC_2_7_1_1) { this.CC_2_7_1_1=CC_2_7_1_1;}
    @Column(name = "CC_2_8_1")
    @JsonProperty("CC-2-8-1")
    private String CC_2_8_1; // 是否有术中避免肿瘤播散的措施
    public String getCC_2_8_1() {  return this.CC_2_8_1;}
    @JsonProperty("CC-2-8-1")
    public void setCC_2_8_1(final String CC_2_8_1) { this.CC_2_8_1=CC_2_8_1;}
    @Column(name = "CC_2_8_2")
    @JsonProperty("CC-2-8-2")
    private String CC_2_8_2; // 采取的避免术中肿瘤播散的措施
    public String getCC_2_8_2() {  return this.CC_2_8_2;}
    @JsonProperty("CC-2-8-2")
    public void setCC_2_8_2(final String CC_2_8_2) { this.CC_2_8_2=CC_2_8_2;}
    @Column(name = "CC_2_8_2_1")
    @JsonProperty("CC-2-8-2-1")
    private String CC_2_8_2_1; // 采取的避免术中肿瘤播散的其他措施
    public String getCC_2_8_2_1() {  return this.CC_2_8_2_1;}
    @JsonProperty("CC-2-8-2-1")
    public void setCC_2_8_2_1(final String CC_2_8_2_1) { this.CC_2_8_2_1=CC_2_8_2_1;}
    @Column(name = "CC_2_9_1")
    @JsonProperty("CC-2-9-1")
    private String CC_2_9_1; // 是否主刀手术者具有相应手术资质
    public String getCC_2_9_1() {  return this.CC_2_9_1;}
    @JsonProperty("CC-2-9-1")
    public void setCC_2_9_1(final String CC_2_9_1) { this.CC_2_9_1=CC_2_9_1;}
    @Column(name = "CC_2_10_1")
    @JsonProperty("CC-2-10-1")
    private String CC_2_10_1; // 是否有手术中并发症
    public String getCC_2_10_1() {  return this.CC_2_10_1;}
    @JsonProperty("CC-2-10-1")
    public void setCC_2_10_1(final String CC_2_10_1) { this.CC_2_10_1=CC_2_10_1;}
    @Column(name = "CC_2_10_2")
    @JsonProperty("CC-2-10-2")
    private String CC_2_10_2; // 术中并发症类别及ICD-10四位亚目的选择
    public String getCC_2_10_2() {  return this.CC_2_10_2;}
    @JsonProperty("CC-2-10-2")
    public void setCC_2_10_2(final String CC_2_10_2) { this.CC_2_10_2=CC_2_10_2;}
    @Column(name = "CC_2_10_2_1")
    @JsonProperty("CC-2-10-2-1")
    private String CC_2_10_2_1; // 其他术中并发症类别及ICD-10四位亚目
    public String getCC_2_10_2_1() {  return this.CC_2_10_2_1;}
    @JsonProperty("CC-2-10-2-1")
    public void setCC_2_10_2_1(final String CC_2_10_2_1) { this.CC_2_10_2_1=CC_2_10_2_1;}
    @Column(name = "CC_2_10_3")
    @JsonProperty("CC-2-10-3")
    private String CC_2_10_3; // 影响程度的选择
    public String getCC_2_10_3() {  return this.CC_2_10_3;}
    @JsonProperty("CC-2-10-3")
    public void setCC_2_10_3(final String CC_2_10_3) { this.CC_2_10_3=CC_2_10_3;}
    @Column(name = "CC_2_10_4")
    @JsonProperty("CC-2-10-4")
    private String CC_2_10_4; // 术中并发症处理
    public String getCC_2_10_4() {  return this.CC_2_10_4;}
    @JsonProperty("CC-2-10-4")
    public void setCC_2_10_4(final String CC_2_10_4) { this.CC_2_10_4=CC_2_10_4;}
    @Column(name = "CC_2_10_4_1")
    @JsonProperty("CC-2-10-4-1")
    private String CC_2_10_4_1; // 其他术中并发症处理
    public String getCC_2_10_4_1() {  return this.CC_2_10_4_1;}
    @JsonProperty("CC-2-10-4-1")
    public void setCC_2_10_4_1(final String CC_2_10_4_1) { this.CC_2_10_4_1=CC_2_10_4_1;}
    @Column(name = "CC_2_11_1")
    @JsonProperty("CC-2-11-1")
    private String CC_2_11_1; // 术中是否更改手术治疗方案
    public String getCC_2_11_1() {  return this.CC_2_11_1;}
    @JsonProperty("CC-2-11-1")
    public void setCC_2_11_1(final String CC_2_11_1) { this.CC_2_11_1=CC_2_11_1;}
    @Column(name = "CC_2_11_2")
    @JsonProperty("CC-2-11-2")
    private String CC_2_11_2; // 是否将更改手术治疗方案的原因、方式及利弊明确告知患者
    public String getCC_2_11_2() {  return this.CC_2_11_2;}
    @JsonProperty("CC-2-11-2")
    public void setCC_2_11_2(final String CC_2_11_2) { this.CC_2_11_2=CC_2_11_2;}
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM-1-1-1")
    private String CM_1_1_1; // 是否使用预防性抗菌药物
    public String getCM_1_1_1() {  return this.CM_1_1_1;}
    @JsonProperty("CM-1-1-1")
    public void setCM_1_1_1(final String CM_1_1_1) { this.CM_1_1_1=CM_1_1_1;}
    @Column(name = "CM_1_2_1_2")
    @JsonProperty("CM-1-2-1-2")
    private String CM_1_2_1_2; // 预防性抗菌药物选择
    public String getCM_1_2_1_2() {  return this.CM_1_2_1_2;}
    @JsonProperty("CM-1-2-1-2")
    public void setCM_1_2_1_2(final String CM_1_2_1_2) { this.CM_1_2_1_2=CM_1_2_1_2;}
    @Column(name = "CM_1_2_2_2")
    @JsonProperty("CM-1-2-2-2")
    private String CM_1_2_2_2; // 选择碳青霉烯类及替加环素等特殊使用级抗菌药物 
    public String getCM_1_2_2_2() {  return this.CM_1_2_2_2;}
    @JsonProperty("CM-1-2-2-2")
    public void setCM_1_2_2_2(final String CM_1_2_2_2) { this.CM_1_2_2_2=CM_1_2_2_2;}
    @Column(name = "CM_1_2_2_1")
    @JsonProperty("CM-1-2-2-1")
    private String CM_1_2_2_1; // 其他特殊使用级抗菌药物名称
    public String getCM_1_2_2_1() {  return this.CM_1_2_2_1;}
    @JsonProperty("CM-1-2-2-1")
    public void setCM_1_2_2_1(final String CM_1_2_2_1) { this.CM_1_2_2_1=CM_1_2_2_1;}
    @Column(name = "CM_1_3_1_2")
    @JsonProperty("CM-1-3-1-2")
    private String CM_1_3_1_2; // 选用“特殊使用级抗菌药物”或者其他类抗菌药物的因素
    public String getCM_1_3_1_2() {  return this.CM_1_3_1_2;}
    @JsonProperty("CM-1-3-1-2")
    public void setCM_1_3_1_2(final String CM_1_3_1_2) { this.CM_1_3_1_2=CM_1_3_1_2;}
    @Column(name = "CM_1_3_1_1")
    @JsonProperty("CM-1-3-1-1")
    private String CM_1_3_1_1; // 选用“特殊使用级抗菌药物”或者其他类抗菌药物的因素填写
    public String getCM_1_3_1_1() {  return this.CM_1_3_1_1;}
    @JsonProperty("CM-1-3-1-1")
    public void setCM_1_3_1_1(final String CM_1_3_1_1) { this.CM_1_3_1_1=CM_1_3_1_1;}
    @Column(name = "CM_1_4_1")
    @JsonProperty("CM-1-4-1")
    private String CM_1_4_1; // 使用首剂抗菌药物起始时间
    public String getCM_1_4_1() {  return this.CM_1_4_1;}
    @JsonProperty("CM-1-4-1")
    public void setCM_1_4_1(final String CM_1_4_1) { this.CM_1_4_1=CM_1_4_1;}
    @Column(name = "CM_1_5_1")
    @JsonProperty("CM-1-5-1")
    private String CM_1_5_1; // 手术时间是否≥3小时
    public String getCM_1_5_1() {  return this.CM_1_5_1;}
    @JsonProperty("CM-1-5-1")
    public void setCM_1_5_1(final String CM_1_5_1) { this.CM_1_5_1=CM_1_5_1;}
    @Column(name = "CM_1_5_2")
    @JsonProperty("CM-1-5-2")
    private String CM_1_5_2; // 是否术中追加抗菌药物
    public String getCM_1_5_2() {  return this.CM_1_5_2;}
    @JsonProperty("CM-1-5-2")
    public void setCM_1_5_2(final String CM_1_5_2) { this.CM_1_5_2=CM_1_5_2;}
    @Column(name = "CM_1_5_3")
    @JsonProperty("CM-1-5-3")
    private String CM_1_5_3; // 术中出血量是否≥1500ml
    public String getCM_1_5_3() {  return this.CM_1_5_3;}
    @JsonProperty("CM-1-5-3")
    public void setCM_1_5_3(final String CM_1_5_3) { this.CM_1_5_3=CM_1_5_3;}
    @Column(name = "CM_1_5_4")
    @JsonProperty("CM-1-5-4")
    private String CM_1_5_4; // 是否术中追加抗菌药物
    public String getCM_1_5_4() {  return this.CM_1_5_4;}
    @JsonProperty("CM-1-5-4")
    public void setCM_1_5_4(final String CM_1_5_4) { this.CM_1_5_4=CM_1_5_4;}
    @Column(name = "CM_1_6_1")
    @JsonProperty("CM-1-6-1")
    private String CM_1_6_1; // 术后抗菌药物停止使用时间
    public String getCM_1_6_1() {  return this.CM_1_6_1;}
    @JsonProperty("CM-1-6-1")
    public void setCM_1_6_1(final String CM_1_6_1) { this.CM_1_6_1=CM_1_6_1;}
    @Column(name = "CM_1_6_1_dump")
    @JsonProperty("CM-1-6-1-dump")
    private String CM_1_6_1_dump; // 使用抗菌药物时间
    public String getCM_1_6_1_dump() {  return this.CM_1_6_1_dump;}
    @JsonProperty("CM-1-6-1-dump")
    public void setCM_1_6_1_dump(final String CM_1_6_1_dump) { this.CM_1_6_1_dump=CM_1_6_1_dump;}
    @Column(name = "CM_1_6_2")
    @JsonProperty("CM-1-6-2")
    private String CM_1_6_2; // 使用抗菌药物时间使用时间分层
    public String getCM_1_6_2() {  return this.CM_1_6_2;}
    @JsonProperty("CM-1-6-2")
    public void setCM_1_6_2(final String CM_1_6_2) { this.CM_1_6_2=CM_1_6_2;}
    @Column(name = "CM_1_6_3_2")
    @JsonProperty("CM-1-6-3-2")
    private String CM_1_6_3_2; // 术后72小时之后继续使用的原因
    public String getCM_1_6_3_2() {  return this.CM_1_6_3_2;}
    @JsonProperty("CM-1-6-3-2")
    public void setCM_1_6_3_2(final String CM_1_6_3_2) { this.CM_1_6_3_2=CM_1_6_3_2;}
    @Column(name = "CC_4_1_1")
    @JsonProperty("CC-4-1-1")
    private String CC_4_1_1; // 是否有术后病理报告
    public String getCC_4_1_1() {  return this.CC_4_1_1;}
    @JsonProperty("CC-4-1-1")
    public void setCC_4_1_1(final String CC_4_1_1) { this.CC_4_1_1=CC_4_1_1;}
    @Column(name = "CC_4_1_2")
    @JsonProperty("CC-4-1-2")
    private String CC_4_1_2; // 合格的病理报告包括以下主要内容
    public String getCC_4_1_2() {  return this.CC_4_1_2;}
    @JsonProperty("CC-4-1-2")
    public void setCC_4_1_2(final String CC_4_1_2) { this.CC_4_1_2=CC_4_1_2;}
    @Column(name = "CC_4_2_1")
    @JsonProperty("CC-4-2-1")
    private String CC_4_2_1; // 是否有根据术后病理进行pTNM分期
    public String getCC_4_2_1() {  return this.CC_4_2_1;}
    @JsonProperty("CC-4-2-1")
    public void setCC_4_2_1(final String CC_4_2_1) { this.CC_4_2_1=CC_4_2_1;}
    @Column(name = "CC_4_2_2")
    @JsonProperty("CC-4-2-2")
    private String CC_4_2_2; // pTNM 分期结论
    public String getCC_4_2_2() {  return this.CC_4_2_2;}
    @JsonProperty("CC-4-2-2")
    public void setCC_4_2_2(final String CC_4_2_2) { this.CC_4_2_2=CC_4_2_2;}
    @Column(name = "CC_4_3_1")
    @JsonProperty("CC-4-3-1")
    private String CC_4_3_1; // 术后病理是否存在危险因素
    public String getCC_4_3_1() {  return this.CC_4_3_1;}
    @JsonProperty("CC-4-3-1")
    public void setCC_4_3_1(final String CC_4_3_1) { this.CC_4_3_1=CC_4_3_1;}
    @Column(name = "CC_4_3_2")
    @JsonProperty("CC-4-3-2")
    private String CC_4_3_2; // 术后病理存在危险因素
    public String getCC_4_3_2() {  return this.CC_4_3_2;}
    @JsonProperty("CC-4-3-2")
    public void setCC_4_3_2(final String CC_4_3_2) { this.CC_4_3_2=CC_4_3_2;}
    @Column(name = "CC_4_3_2_1")
    @JsonProperty("CC-4-3-2-1")
    private String CC_4_3_2_1; // 术后病理其他危险因素
    public String getCC_4_3_2_1() {  return this.CC_4_3_2_1;}
    @JsonProperty("CC-4-3-2-1")
    public void setCC_4_3_2_1(final String CC_4_3_2_1) { this.CC_4_3_2_1=CC_4_3_2_1;}
    @Column(name = "CC_4_3_3")
    @JsonProperty("CC-4-3-3")
    private String CC_4_3_3; // 术后病理存在高危因素
    public String getCC_4_3_3() {  return this.CC_4_3_3;}
    @JsonProperty("CC-4-3-3")
    public void setCC_4_3_3(final String CC_4_3_3) { this.CC_4_3_3=CC_4_3_3;}
    @Column(name = "CC_4_3_3_1")
    @JsonProperty("CC-4-3-3-1")
    private String CC_4_3_3_1; // 术后病理其他高危因素
    public String getCC_4_3_3_1() {  return this.CC_4_3_3_1;}
    @JsonProperty("CC-4-3-3-1")
    public void setCC_4_3_3_1(final String CC_4_3_3_1) { this.CC_4_3_3_1=CC_4_3_3_1;}
    @Column(name = "CC_5_1_1")
    @JsonProperty("CC-5-1-1")
    private String CC_5_1_1; // 术后是否应给予辅助治疗<br/>(注：仅限本次住院期间，手术后即行术后综合治疗的患者！ 不包含手术出院后再次住院行综合治疗患者)
    public String getCC_5_1_1() {  return this.CC_5_1_1;}
    @JsonProperty("CC-5-1-1")
    public void setCC_5_1_1(final String CC_5_1_1) { this.CC_5_1_1=CC_5_1_1;}
    @Column(name = "CC_5_1_2")
    @JsonProperty("CC-5-1-2")
    private String CC_5_1_2; // 术后给予辅助治疗符合原则规范
    public String getCC_5_1_2() {  return this.CC_5_1_2;}
    @JsonProperty("CC-5-1-2")
    public void setCC_5_1_2(final String CC_5_1_2) { this.CC_5_1_2=CC_5_1_2;}
    @Column(name = "CC_5_1_2_1")
    @JsonProperty("CC-5-1-2-1")
    private String CC_5_1_2_1; // 术后其他给予辅助治疗符合原则
    public String getCC_5_1_2_1() {  return this.CC_5_1_2_1;}
    @JsonProperty("CC-5-1-2-1")
    public void setCC_5_1_2_1(final String CC_5_1_2_1) { this.CC_5_1_2_1=CC_5_1_2_1;}
    @Column(name = "CC_5_1_3")
    @JsonProperty("CC-5-1-3")
    private String CC_5_1_3; // 是否化疗
    public String getCC_5_1_3() {  return this.CC_5_1_3;}
    @JsonProperty("CC-5-1-3")
    public void setCC_5_1_3(final String CC_5_1_3) { this.CC_5_1_3=CC_5_1_3;}
    @Column(name = "CC_5_1_4")
    @JsonProperty("CC-5-1-4")
    private String CC_5_1_4; // 是否放疗
    public String getCC_5_1_4() {  return this.CC_5_1_4;}
    @JsonProperty("CC-5-1-4")
    public void setCC_5_1_4(final String CC_5_1_4) { this.CC_5_1_4=CC_5_1_4;}
    @Column(name = "CM_2_1")
    @JsonProperty("CM-2-1")
    private String CM_2_1; // 是否有手术后并发症
    public String getCM_2_1() {  return this.CM_2_1;}
    @JsonProperty("CM-2-1")
    public void setCM_2_1(final String CM_2_1) { this.CM_2_1=CM_2_1;}
    @Column(name = "CM_2_2")
    @JsonProperty("CM-2-2")
    private String CM_2_2; // 手术后并发症类别及ICD-10四位亚目的选择
    public String getCM_2_2() {  return this.CM_2_2;}
    @JsonProperty("CM-2-2")
    public void setCM_2_2(final String CM_2_2) { this.CM_2_2=CM_2_2;}
    @Column(name = "CM_2_3_1")
    @JsonProperty("CM-2-3-1")
    private String CM_2_3_1; // 介入操作与手术其他并发症
    public String getCM_2_3_1() {  return this.CM_2_3_1;}
    @JsonProperty("CM-2-3-1")
    public void setCM_2_3_1(final String CM_2_3_1) { this.CM_2_3_1=CM_2_3_1;}
    @Column(name = "CM_2_3_2")
    @JsonProperty("CM-2-3-2")
    private String CM_2_3_2; // 手术患者手术后肺栓塞
    public String getCM_2_3_2() {  return this.CM_2_3_2;}
    @JsonProperty("CM-2-3-2")
    public void setCM_2_3_2(final String CM_2_3_2) { this.CM_2_3_2=CM_2_3_2;}
    @Column(name = "CM_2_3_3")
    @JsonProperty("CM-2-3-3")
    private String CM_2_3_3; // 手术患者手术后深静脉血栓
    public String getCM_2_3_3() {  return this.CM_2_3_3;}
    @JsonProperty("CM-2-3-3")
    public void setCM_2_3_3(final String CM_2_3_3) { this.CM_2_3_3=CM_2_3_3;}
    @Column(name = "CM_2_3_4")
    @JsonProperty("CM-2-3-4")
    private String CM_2_3_4; // 手术患者手术后败血症
    public String getCM_2_3_4() {  return this.CM_2_3_4;}
    @JsonProperty("CM-2-3-4")
    public void setCM_2_3_4(final String CM_2_3_4) { this.CM_2_3_4=CM_2_3_4;}
    @Column(name = "CM_2_3_5")
    @JsonProperty("CM-2-3-5")
    private String CM_2_3_5; // 手术患者手术后出血或血肿
    public String getCM_2_3_5() {  return this.CM_2_3_5;}
    @JsonProperty("CM-2-3-5")
    public void setCM_2_3_5(final String CM_2_3_5) { this.CM_2_3_5=CM_2_3_5;}
    @Column(name = "CM_2_3_6")
    @JsonProperty("CM-2-3-6")
    private String CM_2_3_6; // 手术患者手术伤口裂开
    public String getCM_2_3_6() {  return this.CM_2_3_6;}
    @JsonProperty("CM-2-3-6")
    public void setCM_2_3_6(final String CM_2_3_6) { this.CM_2_3_6=CM_2_3_6;}
    @Column(name = "CM_2_3_7")
    @JsonProperty("CM-2-3-7")
    private String CM_2_3_7; // 手术患者猝死
    public String getCM_2_3_7() {  return this.CM_2_3_7;}
    @JsonProperty("CM-2-3-7")
    public void setCM_2_3_7(final String CM_2_3_7) { this.CM_2_3_7=CM_2_3_7;}
    @Column(name = "CM_2_3_8")
    @JsonProperty("CM-2-3-8")
    private String CM_2_3_8; // 手术患者手术后呼吸道并发症
    public String getCM_2_3_8() {  return this.CM_2_3_8;}
    @JsonProperty("CM-2-3-8")
    public void setCM_2_3_8(final String CM_2_3_8) { this.CM_2_3_8=CM_2_3_8;}
    @Column(name = "CM_2_3_9")
    @JsonProperty("CM-2-3-9")
    private String CM_2_3_9; // 手术患者手术后生理/代谢紊乱
    public String getCM_2_3_9() {  return this.CM_2_3_9;}
    @JsonProperty("CM-2-3-9")
    public void setCM_2_3_9(final String CM_2_3_9) { this.CM_2_3_9=CM_2_3_9;}
    @Column(name = "CM_2_3_10")
    @JsonProperty("CM-2-3-10")
    private String CM_2_3_10; // 与手术/操作相关感染
    public String getCM_2_3_10() {  return this.CM_2_3_10;}
    @JsonProperty("CM-2-3-10")
    public void setCM_2_3_10(final String CM_2_3_10) { this.CM_2_3_10=CM_2_3_10;}
    @Column(name = "CM_2_3_11")
    @JsonProperty("CM-2-3-11")
    private String CM_2_3_11; // 手术过程中异物遗留
    public String getCM_2_3_11() {  return this.CM_2_3_11;}
    @JsonProperty("CM-2-3-11")
    public void setCM_2_3_11(final String CM_2_3_11) { this.CM_2_3_11=CM_2_3_11;}
    @Column(name = "CM_2_3_12")
    @JsonProperty("CM-2-3-12")
    private String CM_2_3_12; // 麻醉并发症
    public String getCM_2_3_12() {  return this.CM_2_3_12;}
    @JsonProperty("CM-2-3-12")
    public void setCM_2_3_12(final String CM_2_3_12) { this.CM_2_3_12=CM_2_3_12;}
    @Column(name = "CM_2_3_13")
    @JsonProperty("CM-2-3-13")
    private String CM_2_3_13; // 输注、输血反应
    public String getCM_2_3_13() {  return this.CM_2_3_13;}
    @JsonProperty("CM-2-3-13")
    public void setCM_2_3_13(final String CM_2_3_13) { this.CM_2_3_13=CM_2_3_13;}
    @Column(name = "CC_6_1_3")
    @JsonProperty("CC-6-1-3")
    private String CC_6_1_3; // CC手术特指的并发症
    public String getCC_6_1_3() {  return this.CC_6_1_3;}
    @JsonProperty("CC-6-1-3")
    public void setCC_6_1_3(final String CC_6_1_3) { this.CC_6_1_3=CC_6_1_3;}
    @Column(name = "CM_2_3_1_1")
    @JsonProperty("CM-2-3-1-1")
    private String CM_2_3_1_1; // 其他手术后并发症类别及ICD-10四位亚目和名称填写
    public String getCM_2_3_1_1() {  return this.CM_2_3_1_1;}
    @JsonProperty("CM-2-3-1-1")
    public void setCM_2_3_1_1(final String CM_2_3_1_1) { this.CM_2_3_1_1=CM_2_3_1_1;}
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    public String getCM_2_4() {  return this.CM_2_4;}
    @JsonProperty("CM-2-4")
    public void setCM_2_4(final String CM_2_4) { this.CM_2_4=CM_2_4;}
    @Column(name = "CC_6_2_1")
    @JsonProperty("CC-6-2-1")
    private String CC_6_2_1; // 是否是非计划二次手术
    public String getCC_6_2_1() {  return this.CC_6_2_1;}
    @JsonProperty("CC-6-2-1")
    public void setCC_6_2_1(final String CC_6_2_1) { this.CC_6_2_1=CC_6_2_1;}
    @Column(name = "CC_6_2_2")
    @JsonProperty("CC-6-2-2")
    private String CC_6_2_2; // 非计划二次手术主要原因的选择
    public String getCC_6_2_2() {  return this.CC_6_2_2;}
    @JsonProperty("CC-6-2-2")
    public void setCC_6_2_2(final String CC_6_2_2) { this.CC_6_2_2=CC_6_2_2;}
    @Column(name = "CC_6_2_3")
    @JsonProperty("CC-6-2-3")
    private String CC_6_2_3; // 二次手术开始（切皮）日期时间 
    public String getCC_6_2_3() {  return this.CC_6_2_3;}
    @JsonProperty("CC-6-2-3")
    public void setCC_6_2_3(final String CC_6_2_3) { this.CC_6_2_3=CC_6_2_3;}
    @Column(name = "CC_6_2_4")
    @JsonProperty("CC-6-2-4")
    private String CC_6_2_4; // 二次手术结束（缝皮结束）日期时间
    public String getCC_6_2_4() {  return this.CC_6_2_4;}
    @JsonProperty("CC-6-2-4")
    public void setCC_6_2_4(final String CC_6_2_4) { this.CC_6_2_4=CC_6_2_4;}
    @Column(name = "CC_6_2_5")
    @JsonProperty("CC-6-2-5")
    private String CC_6_2_5; // 手术路径选择
    public String getCC_6_2_5() {  return this.CC_6_2_5;}
    @JsonProperty("CC-6-2-5")
    public void setCC_6_2_5(final String CC_6_2_5) { this.CC_6_2_5=CC_6_2_5;}
    @Column(name = "CC_6_2_5_1")
    @JsonProperty("CC-6-2-5-1")
    private String CC_6_2_5_1; // 其他手术路径
    public String getCC_6_2_5_1() {  return this.CC_6_2_5_1;}
    @JsonProperty("CC-6-2-5-1")
    public void setCC_6_2_5_1(final String CC_6_2_5_1) { this.CC_6_2_5_1=CC_6_2_5_1;}
    @Column(name = "CC_7_1_1")
    @JsonProperty("CC-7-1-1")
    private String CC_7_1_1; // 术中出血量(ml)
    public String getCC_7_1_1() {  return this.CC_7_1_1;}
    @JsonProperty("CC-7-1-1")
    public void setCC_7_1_1(final String CC_7_1_1) { this.CC_7_1_1=CC_7_1_1;}
    @Column(name = "CC_7_1_2")
    @JsonProperty("CC-7-1-2")
    private String CC_7_1_2; // 术后出血量(ml)
    public String getCC_7_1_2() {  return this.CC_7_1_2;}
    @JsonProperty("CC-7-1-2")
    public void setCC_7_1_2(final String CC_7_1_2) { this.CC_7_1_2=CC_7_1_2;}
    @Column(name = "CC_7_1_3")
    @JsonProperty("CC-7-1-3")
    private String CC_7_1_3; // 是否实施输血
    public String getCC_7_1_3() {  return this.CC_7_1_3;}
    @JsonProperty("CC-7-1-3")
    public void setCC_7_1_3(final String CC_7_1_3) { this.CC_7_1_3=CC_7_1_3;}
    @Column(name = "CC_7_1_4")
    @JsonProperty("CC-7-1-4")
    private String CC_7_1_4; // 用血类别的选择
    public String getCC_7_1_4() {  return this.CC_7_1_4;}
    @JsonProperty("CC-7-1-4")
    public void setCC_7_1_4(final String CC_7_1_4) { this.CC_7_1_4=CC_7_1_4;}
    @Column(name = "CC_7_1_5")
    @JsonProperty("CC-7-1-5")
    private String CC_7_1_5; // 输血量(ml)
    public String getCC_7_1_5() {  return this.CC_7_1_5;}
    @JsonProperty("CC-7-1-5")
    public void setCC_7_1_5(final String CC_7_1_5) { this.CC_7_1_5=CC_7_1_5;}
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
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    public String getCM_7_2_3() {  return this.CM_7_2_3;}
    @JsonProperty("CM-7-2-3")
    public void setCM_7_2_3(final String CM_7_2_3) { this.CM_7_2_3=CM_7_2_3;}
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
    @Column(name = "CM_3_1")
    @JsonProperty("CM-3-1")
    private String CM_3_1; // 手术野皮肤准备常用方法的选择
    public String getCM_3_1() {  return this.CM_3_1;}
    @JsonProperty("CM-3-1")
    public void setCM_3_1(final String CM_3_1) { this.CM_3_1=CM_3_1;}
    @Column(name = "CM_3_2")
    @JsonProperty("CM-3-2")
    private String CM_3_2; // 使用含抗菌剂（三氯生）缝线
    public String getCM_3_2() {  return this.CM_3_2;}
    @JsonProperty("CM-3-2")
    public void setCM_3_2(final String CM_3_2) { this.CM_3_2=CM_3_2;}
    @Column(name = "CM_3_2_1")
    @JsonProperty("CM-3-2-1")
    private String CM_3_2_1; // 其他含抗菌剂缝线填写
    public String getCM_3_2_1() {  return this.CM_3_2_1;}
    @JsonProperty("CM-3-2-1")
    public void setCM_3_2_1(final String CM_3_2_1) { this.CM_3_2_1=CM_3_2_1;}
    @Column(name = "CM_3_3")
    @JsonProperty("CM-3-3")
    private String CM_3_3; // 手术切口类别的选择
    public String getCM_3_3() {  return this.CM_3_3;}
    @JsonProperty("CM-3-3")
    public void setCM_3_3(final String CM_3_3) { this.CM_3_3=CM_3_3;}
    @Column(name = "CM_3_4")
    @JsonProperty("CM-3-4")
    private String CM_3_4; // 手术切口愈合情况的选择
    public String getCM_3_4() {  return this.CM_3_4;}
    @JsonProperty("CM-3-4")
    public void setCM_3_4(final String CM_3_4) { this.CM_3_4=CM_3_4;}
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
    @Column(name = "CM_7_1_1")
    @JsonProperty("CM-7-1-1")
    private String CM_7_1_1; // 术前健康教育
    public String getCM_7_1_1() {  return this.CM_7_1_1;}
    @JsonProperty("CM-7-1-1")
    public void setCM_7_1_1(final String CM_7_1_1) { this.CM_7_1_1=CM_7_1_1;}
    @Column(name = "CM_7_1_2")
    @JsonProperty("CM-7-1-2")
    private String CM_7_1_2; // 术后健康教育
    public String getCM_7_1_2() {  return this.CM_7_1_2;}
    @JsonProperty("CM-7-1-2")
    public void setCM_7_1_2(final String CM_7_1_2) { this.CM_7_1_2=CM_7_1_2;}
}