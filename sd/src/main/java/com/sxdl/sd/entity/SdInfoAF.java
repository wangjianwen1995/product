package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：I48 的出院患者。
*/
@ApiModel(value = "04信息")
@Entity
@Table(name = "sd_info_AF")
public class SdInfoAF implements Serializable {
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
    private String CM_0_1_3_1; // 第一诊断或第二诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 第一诊断或第二诊断ICD-10六位临床扩展编码与名称
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
    @Column(name = "AF_1_1_5")
    @JsonProperty("AF-1-1-5")
    private String AF_1_1_5; // 是否为瓣膜性房颤
    public String getAF_1_1_5() {  return this.AF_1_1_5;}
    @JsonProperty("AF-1-1-5")
    public void setAF_1_1_5(final String AF_1_1_5) { this.AF_1_1_5=AF_1_1_5;}
    @Column(name = "AF_1_1_1_3")
    @JsonProperty("AF-1-1-1-3")
    private String AF_1_1_1_3; // 房颤分类
    public String getAF_1_1_1_3() {  return this.AF_1_1_1_3;}
    @JsonProperty("AF-1-1-1-3")
    public void setAF_1_1_1_3(final String AF_1_1_1_3) { this.AF_1_1_1_3=AF_1_1_1_3;}
    @Column(name = "AF_1_1_0")
    @JsonProperty("AF-1-1-0")
    private String AF_1_1_0; // 实施相关检查
    public String getAF_1_1_0() {  return this.AF_1_1_0;}
    @JsonProperty("AF-1-1-0")
    public void setAF_1_1_0(final String AF_1_1_0) { this.AF_1_1_0=AF_1_1_0;}
    @Column(name = "AF_1_1_0_1")
    @JsonProperty("AF-1-1-0-1")
    private String AF_1_1_0_1; // 其他实施相关检查
    public String getAF_1_1_0_1() {  return this.AF_1_1_0_1;}
    @JsonProperty("AF-1-1-0-1")
    public void setAF_1_1_0_1(final String AF_1_1_0_1) { this.AF_1_1_0_1=AF_1_1_0_1;}
    @Column(name = "AF_1_1_2")
    @JsonProperty("AF-1-1-2")
    private String AF_1_1_2; // 症状严重程度（EHRA评分）评估
    public String getAF_1_1_2() {  return this.AF_1_1_2;}
    @JsonProperty("AF-1-1-2")
    public void setAF_1_1_2(final String AF_1_1_2) { this.AF_1_1_2=AF_1_1_2;}
    @Column(name = "AF_1_1_3")
    @JsonProperty("AF-1-1-3")
    private String AF_1_1_3; // 是否为血流动力学不稳定性房颤
    public String getAF_1_1_3() {  return this.AF_1_1_3;}
    @JsonProperty("AF-1-1-3")
    public void setAF_1_1_3(final String AF_1_1_3) { this.AF_1_1_3=AF_1_1_3;}
    @Column(name = "AF_1_1_4")
    @JsonProperty("AF-1-1-4")
    private String AF_1_1_4; // 血流动力学不稳定的临床表现
    public String getAF_1_1_4() {  return this.AF_1_1_4;}
    @JsonProperty("AF-1-1-4")
    public void setAF_1_1_4(final String AF_1_1_4) { this.AF_1_1_4=AF_1_1_4;}
    @Column(name = "AF_1_2_1")
    @JsonProperty("AF-1-2-1")
    private String AF_1_2_1; // 房颤患者脑卒中风险评估工具
    public String getAF_1_2_1() {  return this.AF_1_2_1;}
    @JsonProperty("AF-1-2-1")
    public void setAF_1_2_1(final String AF_1_2_1) { this.AF_1_2_1=AF_1_2_1;}
    @Column(name = "AF_1_2_2")
    @JsonProperty("AF-1-2-2")
    private String AF_1_2_2; // 使用CHADS₂评分工具的房颤患者脑卒中风险评估分值
    public String getAF_1_2_2() {  return this.AF_1_2_2;}
    @JsonProperty("AF-1-2-2")
    public void setAF_1_2_2(final String AF_1_2_2) { this.AF_1_2_2=AF_1_2_2;}
    @Column(name = "AF_1_2_3")
    @JsonProperty("AF-1-2-3")
    private String AF_1_2_3; // CHADS₂评分风险评估分层
    public String getAF_1_2_3() {  return this.AF_1_2_3;}
    @JsonProperty("AF-1-2-3")
    public void setAF_1_2_3(final String AF_1_2_3) { this.AF_1_2_3=AF_1_2_3;}
    @Column(name = "AF_1_2_4")
    @JsonProperty("AF-1-2-4")
    private String AF_1_2_4; // 使用CHA₂DS₂-VASc评分工具的房颤患者脑卒中风险评估分值
    public String getAF_1_2_4() {  return this.AF_1_2_4;}
    @JsonProperty("AF-1-2-4")
    public void setAF_1_2_4(final String AF_1_2_4) { this.AF_1_2_4=AF_1_2_4;}
    @Column(name = "AF_1_2_5")
    @JsonProperty("AF-1-2-5")
    private String AF_1_2_5; // 房颤患者脑卒中风险评估分层
    public String getAF_1_2_5() {  return this.AF_1_2_5;}
    @JsonProperty("AF-1-2-5")
    public void setAF_1_2_5(final String AF_1_2_5) { this.AF_1_2_5=AF_1_2_5;}
    @Column(name = "AF_1_3_1")
    @JsonProperty("AF-1-3-1")
    private String AF_1_3_1; // 是否首次房颤患者 出血风险评估(HAS-BLED 评分)
    public String getAF_1_3_1() {  return this.AF_1_3_1;}
    @JsonProperty("AF-1-3-1")
    public void setAF_1_3_1(final String AF_1_3_1) { this.AF_1_3_1=AF_1_3_1;}
    @Column(name = "AF_1_3_2")
    @JsonProperty("AF-1-3-2")
    private String AF_1_3_2; // 首次房颤患者 出血风险评估分值
    public String getAF_1_3_2() {  return this.AF_1_3_2;}
    @JsonProperty("AF-1-3-2")
    public void setAF_1_3_2(final String AF_1_3_2) { this.AF_1_3_2=AF_1_3_2;}
    @Column(name = "AF_1_3_4")
    @JsonProperty("AF-1-3-4")
    private String AF_1_3_4; // HAS-BLED评分≥3者视为高危患者
    public String getAF_1_3_4() {  return this.AF_1_3_4;}
    @JsonProperty("AF-1-3-4")
    public void setAF_1_3_4(final String AF_1_3_4) { this.AF_1_3_4=AF_1_3_4;}
    @Column(name = "AF_1_6_1")
    @JsonProperty("AF-1-6-1")
    private String AF_1_6_1; // 是否实施超声心动图评估
    public String getAF_1_6_1() {  return this.AF_1_6_1;}
    @JsonProperty("AF-1-6-1")
    public void setAF_1_6_1(final String AF_1_6_1) { this.AF_1_6_1=AF_1_6_1;}
    @Column(name = "AF_1_6_2")
    @JsonProperty("AF-1-6-2")
    private String AF_1_6_2; // 检查方法
    public String getAF_1_6_2() {  return this.AF_1_6_2;}
    @JsonProperty("AF-1-6-2")
    public void setAF_1_6_2(final String AF_1_6_2) { this.AF_1_6_2=AF_1_6_2;}
    @Column(name = "AF_1_6_2_1")
    @JsonProperty("AF-1-6-2-1")
    private String AF_1_6_2_1; // 其他检查方法
    public String getAF_1_6_2_1() {  return this.AF_1_6_2_1;}
    @JsonProperty("AF-1-6-2-1")
    public void setAF_1_6_2_1(final String AF_1_6_2_1) { this.AF_1_6_2_1=AF_1_6_2_1;}
    @Column(name = "AF_1_6_3")
    @JsonProperty("AF-1-6-3")
    private String AF_1_6_3; // 首次超声心动图评估结果
    public String getAF_1_6_3() {  return this.AF_1_6_3;}
    @JsonProperty("AF-1-6-3")
    public void setAF_1_6_3(final String AF_1_6_3) { this.AF_1_6_3=AF_1_6_3;}
    @Column(name = "AF_1_6_3_1")
    @JsonProperty("AF-1-6-3-1")
    private String AF_1_6_3_1; // 左室射血分数(%)
    public String getAF_1_6_3_1() {  return this.AF_1_6_3_1;}
    @JsonProperty("AF-1-6-3-1")
    public void setAF_1_6_3_1(final String AF_1_6_3_1) { this.AF_1_6_3_1=AF_1_6_3_1;}
    @Column(name = "AF_1_6_3_2")
    @JsonProperty("AF-1-6-3-2")
    private String AF_1_6_3_2; // 左室舒张末内径(mm)
    public String getAF_1_6_3_2() {  return this.AF_1_6_3_2;}
    @JsonProperty("AF-1-6-3-2")
    public void setAF_1_6_3_2(final String AF_1_6_3_2) { this.AF_1_6_3_2=AF_1_6_3_2;}
    @Column(name = "AF_1_6_3_3")
    @JsonProperty("AF-1-6-3-3")
    private String AF_1_6_3_3; // 左房内径(mm)
    public String getAF_1_6_3_3() {  return this.AF_1_6_3_3;}
    @JsonProperty("AF-1-6-3-3")
    public void setAF_1_6_3_3(final String AF_1_6_3_3) { this.AF_1_6_3_3=AF_1_6_3_3;}
    @Column(name = "AF_1_6_4")
    @JsonProperty("AF-1-6-4")
    private String AF_1_6_4; // 是否有左心房/左心耳血栓
    public String getAF_1_6_4() {  return this.AF_1_6_4;}
    @JsonProperty("AF-1-6-4")
    public void setAF_1_6_4(final String AF_1_6_4) { this.AF_1_6_4=AF_1_6_4;}
    @Column(name = "AF_1_6_5")
    @JsonProperty("AF-1-6-5")
    private String AF_1_6_5; // 是否有心包积液
    public String getAF_1_6_5() {  return this.AF_1_6_5;}
    @JsonProperty("AF-1-6-5")
    public void setAF_1_6_5(final String AF_1_6_5) { this.AF_1_6_5=AF_1_6_5;}
    @Column(name = "AF_1_6_6")
    @JsonProperty("AF-1-6-6")
    private String AF_1_6_6; // 心包积液分级
    public String getAF_1_6_6() {  return this.AF_1_6_6;}
    @JsonProperty("AF-1-6-6")
    public void setAF_1_6_6(final String AF_1_6_6) { this.AF_1_6_6=AF_1_6_6;}
    @Column(name = "AF_1_6_7")
    @JsonProperty("AF-1-6-7")
    private String AF_1_6_7; // 是否实施冠脉CTA造影评估
    public String getAF_1_6_7() {  return this.AF_1_6_7;}
    @JsonProperty("AF-1-6-7")
    public void setAF_1_6_7(final String AF_1_6_7) { this.AF_1_6_7=AF_1_6_7;}
    @Column(name = "AF_1_6_8")
    @JsonProperty("AF-1-6-8")
    private String AF_1_6_8; // 冠状动脉病变
    public String getAF_1_6_8() {  return this.AF_1_6_8;}
    @JsonProperty("AF-1-6-8")
    public void setAF_1_6_8(final String AF_1_6_8) { this.AF_1_6_8=AF_1_6_8;}
    @Column(name = "AF_1_6_9")
    @JsonProperty("AF-1-6-9")
    private String AF_1_6_9; // 是否实施X线胸片检查评估
    public String getAF_1_6_9() {  return this.AF_1_6_9;}
    @JsonProperty("AF-1-6-9")
    public void setAF_1_6_9(final String AF_1_6_9) { this.AF_1_6_9=AF_1_6_9;}
    @Column(name = "AF_1_6_10")
    @JsonProperty("AF-1-6-10")
    private String AF_1_6_10; // X线胸片检查所见
    public String getAF_1_6_10() {  return this.AF_1_6_10;}
    @JsonProperty("AF-1-6-10")
    public void setAF_1_6_10(final String AF_1_6_10) { this.AF_1_6_10=AF_1_6_10;}
    @Column(name = "AF_1_6_10_1")
    @JsonProperty("AF-1-6-10-1")
    private String AF_1_6_10_1; // X线胸片检查其他所见
    public String getAF_1_6_10_1() {  return this.AF_1_6_10_1;}
    @JsonProperty("AF-1-6-10-1")
    public void setAF_1_6_10_1(final String AF_1_6_10_1) { this.AF_1_6_10_1=AF_1_6_10_1;}
    @Column(name = "AF_1_5_1")
    @JsonProperty("AF-1-5-1")
    private String AF_1_5_1; // 首次实验室检查结果
    public String getAF_1_5_1() {  return this.AF_1_5_1;}
    @JsonProperty("AF-1-5-1")
    public void setAF_1_5_1(final String AF_1_5_1) { this.AF_1_5_1=AF_1_5_1;}
    @Column(name = "AF_1_5_1_1")
    @JsonProperty("AF-1-5-1-1")
    private String AF_1_5_1_1; // 血肌酐值(mg/dL)
    public String getAF_1_5_1_1() {  return this.AF_1_5_1_1;}
    @JsonProperty("AF-1-5-1-1")
    public void setAF_1_5_1_1(final String AF_1_5_1_1) { this.AF_1_5_1_1=AF_1_5_1_1;}
    @Column(name = "AF_1_5_1_2")
    @JsonProperty("AF-1-5-1-2")
    private String AF_1_5_1_2; // 总胆固醇(mg/dL)
    public String getAF_1_5_1_2() {  return this.AF_1_5_1_2;}
    @JsonProperty("AF-1-5-1-2")
    public void setAF_1_5_1_2(final String AF_1_5_1_2) { this.AF_1_5_1_2=AF_1_5_1_2;}
    @Column(name = "AF_1_5_1_3")
    @JsonProperty("AF-1-5-1-3")
    private String AF_1_5_1_3; // 低密度脂蛋白(mg/dL)
    public String getAF_1_5_1_3() {  return this.AF_1_5_1_3;}
    @JsonProperty("AF-1-5-1-3")
    public void setAF_1_5_1_3(final String AF_1_5_1_3) { this.AF_1_5_1_3=AF_1_5_1_3;}
    @Column(name = "AF_1_5_1_4")
    @JsonProperty("AF-1-5-1-4")
    private String AF_1_5_1_4; // 血糖(mg/dL)
    public String getAF_1_5_1_4() {  return this.AF_1_5_1_4;}
    @JsonProperty("AF-1-5-1-4")
    public void setAF_1_5_1_4(final String AF_1_5_1_4) { this.AF_1_5_1_4=AF_1_5_1_4;}
    @Column(name = "AF_1_5_1_5")
    @JsonProperty("AF-1-5-1-5")
    private String AF_1_5_1_5; // 血红蛋白(g/L)
    public String getAF_1_5_1_5() {  return this.AF_1_5_1_5;}
    @JsonProperty("AF-1-5-1-5")
    public void setAF_1_5_1_5(final String AF_1_5_1_5) { this.AF_1_5_1_5=AF_1_5_1_5;}
    @Column(name = "AF_1_5_1_6")
    @JsonProperty("AF-1-5-1-6")
    private String AF_1_5_1_6; // CK-MB(U/L)
    public String getAF_1_5_1_6() {  return this.AF_1_5_1_6;}
    @JsonProperty("AF-1-5-1-6")
    public void setAF_1_5_1_6(final String AF_1_5_1_6) { this.AF_1_5_1_6=AF_1_5_1_6;}
    @Column(name = "AF_1_5_1_7")
    @JsonProperty("AF-1-5-1-7")
    private String AF_1_5_1_7; // cTnI(ug/L)
    public String getAF_1_5_1_7() {  return this.AF_1_5_1_7;}
    @JsonProperty("AF-1-5-1-7")
    public void setAF_1_5_1_7(final String AF_1_5_1_7) { this.AF_1_5_1_7=AF_1_5_1_7;}
    @Column(name = "AF_1_5_1_8")
    @JsonProperty("AF-1-5-1-8")
    private String AF_1_5_1_8; // B型钠尿肽（BNP）检测值(pg/L)
    public String getAF_1_5_1_8() {  return this.AF_1_5_1_8;}
    @JsonProperty("AF-1-5-1-8")
    public void setAF_1_5_1_8(final String AF_1_5_1_8) { this.AF_1_5_1_8=AF_1_5_1_8;}
    @Column(name = "AF_1_5_1_9")
    @JsonProperty("AF-1-5-1-9")
    private String AF_1_5_1_9; // N端B型钠尿肽前体（NT-ProBNP）检测值(ng/L)
    public String getAF_1_5_1_9() {  return this.AF_1_5_1_9;}
    @JsonProperty("AF-1-5-1-9")
    public void setAF_1_5_1_9(final String AF_1_5_1_9) { this.AF_1_5_1_9=AF_1_5_1_9;}
    @Column(name = "AF_1_5_1_10")
    @JsonProperty("AF-1-5-1-10")
    private String AF_1_5_1_10; // TSH检测值(mlU/L)
    public String getAF_1_5_1_10() {  return this.AF_1_5_1_10;}
    @JsonProperty("AF-1-5-1-10")
    public void setAF_1_5_1_10(final String AF_1_5_1_10) { this.AF_1_5_1_10=AF_1_5_1_10;}
    @Column(name = "AF_1_5_1_11")
    @JsonProperty("AF-1-5-1-11")
    private String AF_1_5_1_11; // T3检测值(ng/mL)
    public String getAF_1_5_1_11() {  return this.AF_1_5_1_11;}
    @JsonProperty("AF-1-5-1-11")
    public void setAF_1_5_1_11(final String AF_1_5_1_11) { this.AF_1_5_1_11=AF_1_5_1_11;}
    @Column(name = "AF_1_5_1_12")
    @JsonProperty("AF-1-5-1-12")
    private String AF_1_5_1_12; // T4检测值(ng/mL)
    public String getAF_1_5_1_12() {  return this.AF_1_5_1_12;}
    @JsonProperty("AF-1-5-1-12")
    public void setAF_1_5_1_12(final String AF_1_5_1_12) { this.AF_1_5_1_12=AF_1_5_1_12;}
    @Column(name = "AF_2_1_1")
    @JsonProperty("AF-2-1-1")
    private String AF_2_1_1; // 是否为CHA₂DS₂-VASc评分≥2的男性或≥3的女性房颤患者
    public String getAF_2_1_1() {  return this.AF_2_1_1;}
    @JsonProperty("AF-2-1-1")
    public void setAF_2_1_1(final String AF_2_1_1) { this.AF_2_1_1=AF_2_1_1;}
    @Column(name = "AF_2_2_1")
    @JsonProperty("AF-2-2-1")
    private String AF_2_2_1; // 肌酐清除率(ml／min)
    public String getAF_2_2_1() {  return this.AF_2_2_1;}
    @JsonProperty("AF-2-2-1")
    public void setAF_2_2_1(final String AF_2_2_1) { this.AF_2_2_1=AF_2_2_1;}
    @Column(name = "AF_2_3_1")
    @JsonProperty("AF-2-3-1")
    private String AF_2_3_1; // 是否接受抗凝治疗
    public String getAF_2_3_1() {  return this.AF_2_3_1;}
    @JsonProperty("AF-2-3-1")
    public void setAF_2_3_1(final String AF_2_3_1) { this.AF_2_3_1=AF_2_3_1;}
    @Column(name = "AF_2_3_2_3")
    @JsonProperty("AF-2-3-2-3")
    private String AF_2_3_2_3; // 抗凝药选择
    public String getAF_2_3_2_3() {  return this.AF_2_3_2_3;}
    @JsonProperty("AF-2-3-2-3")
    public void setAF_2_3_2_3(final String AF_2_3_2_3) { this.AF_2_3_2_3=AF_2_3_2_3;}
    @Column(name = "AF_2_3_2_1")
    @JsonProperty("AF-2-3-2-1")
    private String AF_2_3_2_1; // 其他非维生素K拮抗剂口服抗凝药物
    public String getAF_2_3_2_1() {  return this.AF_2_3_2_1;}
    @JsonProperty("AF-2-3-2-1")
    public void setAF_2_3_2_1(final String AF_2_3_2_1) { this.AF_2_3_2_1=AF_2_3_2_1;}
    @Column(name = "AF_2_4_1")
    @JsonProperty("AF-2-4-1")
    private String AF_2_4_1; // 华法林治疗后是否测定INR值
    public String getAF_2_4_1() {  return this.AF_2_4_1;}
    @JsonProperty("AF-2-4-1")
    public void setAF_2_4_1(final String AF_2_4_1) { this.AF_2_4_1=AF_2_4_1;}
    @Column(name = "AF_2_4_2")
    @JsonProperty("AF-2-4-2")
    private String AF_2_4_2; // INR值
    public String getAF_2_4_2() {  return this.AF_2_4_2;}
    @JsonProperty("AF-2-4-2")
    public void setAF_2_4_2(final String AF_2_4_2) { this.AF_2_4_2=AF_2_4_2;}
    @Column(name = "AF_3_1_1")
    @JsonProperty("AF-3-1-1")
    private String AF_3_1_1; // 是否接受抗心律失常药物治疗
    public String getAF_3_1_1() {  return this.AF_3_1_1;}
    @JsonProperty("AF-3-1-1")
    public void setAF_3_1_1(final String AF_3_1_1) { this.AF_3_1_1=AF_3_1_1;}
    @Column(name = "AF_3_1_2")
    @JsonProperty("AF-3-1-2")
    private String AF_3_1_2; // 抗心律失常药物
    public String getAF_3_1_2() {  return this.AF_3_1_2;}
    @JsonProperty("AF-3-1-2")
    public void setAF_3_1_2(final String AF_3_1_2) { this.AF_3_1_2=AF_3_1_2;}
    @Column(name = "AF_3_1_2_1")
    @JsonProperty("AF-3-1-2-1")
    private String AF_3_1_2_1; // Ⅰa类药物选择
    public String getAF_3_1_2_1() {  return this.AF_3_1_2_1;}
    @JsonProperty("AF-3-1-2-1")
    public void setAF_3_1_2_1(final String AF_3_1_2_1) { this.AF_3_1_2_1=AF_3_1_2_1;}
    @Column(name = "AF_3_1_2_2")
    @JsonProperty("AF-3-1-2-2")
    private String AF_3_1_2_2; // Ⅰb类药物选择
    public String getAF_3_1_2_2() {  return this.AF_3_1_2_2;}
    @JsonProperty("AF-3-1-2-2")
    public void setAF_3_1_2_2(final String AF_3_1_2_2) { this.AF_3_1_2_2=AF_3_1_2_2;}
    @Column(name = "AF_3_1_2_3")
    @JsonProperty("AF-3-1-2-3")
    private String AF_3_1_2_3; // Ⅰc类药物选择
    public String getAF_3_1_2_3() {  return this.AF_3_1_2_3;}
    @JsonProperty("AF-3-1-2-3")
    public void setAF_3_1_2_3(final String AF_3_1_2_3) { this.AF_3_1_2_3=AF_3_1_2_3;}
    @Column(name = "AF_3_1_2_4")
    @JsonProperty("AF-3-1-2-4")
    private String AF_3_1_2_4; // Ⅱ类药物选择
    public String getAF_3_1_2_4() {  return this.AF_3_1_2_4;}
    @JsonProperty("AF-3-1-2-4")
    public void setAF_3_1_2_4(final String AF_3_1_2_4) { this.AF_3_1_2_4=AF_3_1_2_4;}
    @Column(name = "AF_3_1_2_5")
    @JsonProperty("AF-3-1-2-5")
    private String AF_3_1_2_5; // Ⅲ类药物选择
    public String getAF_3_1_2_5() {  return this.AF_3_1_2_5;}
    @JsonProperty("AF-3-1-2-5")
    public void setAF_3_1_2_5(final String AF_3_1_2_5) { this.AF_3_1_2_5=AF_3_1_2_5;}
    @Column(name = "AF_3_1_2_6")
    @JsonProperty("AF-3-1-2-6")
    private String AF_3_1_2_6; // Ⅳ类药物选择
    public String getAF_3_1_2_6() {  return this.AF_3_1_2_6;}
    @JsonProperty("AF-3-1-2-6")
    public void setAF_3_1_2_6(final String AF_3_1_2_6) { this.AF_3_1_2_6=AF_3_1_2_6;}
    @Column(name = "AF_3_1_3")
    @JsonProperty("AF-3-1-3")
    private String AF_3_1_3; // 其他常用使用抗心律失常药物
    public String getAF_3_1_3() {  return this.AF_3_1_3;}
    @JsonProperty("AF-3-1-3")
    public void setAF_3_1_3(final String AF_3_1_3) { this.AF_3_1_3=AF_3_1_3;}
    @Column(name = "AF_4_1_1_1")
    @JsonProperty("AF-4-1-1-1")
    private String AF_4_1_1_1; // 是否有ACEI/ARB用药长期医嘱
    public String getAF_4_1_1_1() {  return this.AF_4_1_1_1;}
    @JsonProperty("AF-4-1-1-1")
    public void setAF_4_1_1_1(final String AF_4_1_1_1) { this.AF_4_1_1_1=AF_4_1_1_1;}
    @Column(name = "AF_4_1_1_2")
    @JsonProperty("AF-4-1-1-2")
    private String AF_4_1_1_2; // 长期医嘱药物的选择(ACEI/ARB)
    public String getAF_4_1_1_2() {  return this.AF_4_1_1_2;}
    @JsonProperty("AF-4-1-1-2")
    public void setAF_4_1_1_2(final String AF_4_1_1_2) { this.AF_4_1_1_2=AF_4_1_1_2;}
    @Column(name = "AF_4_1_1_3")
    @JsonProperty("AF-4-1-1-3")
    private String AF_4_1_1_3; // ACEI抑制剂药物的选择
    public String getAF_4_1_1_3() {  return this.AF_4_1_1_3;}
    @JsonProperty("AF-4-1-1-3")
    public void setAF_4_1_1_3(final String AF_4_1_1_3) { this.AF_4_1_1_3=AF_4_1_1_3;}
    @Column(name = "AF_4_1_1_3_1")
    @JsonProperty("AF-4-1-1-3-1")
    private String AF_4_1_1_3_1; // 其他ACEI 药物名称
    public String getAF_4_1_1_3_1() {  return this.AF_4_1_1_3_1;}
    @JsonProperty("AF-4-1-1-3-1")
    public void setAF_4_1_1_3_1(final String AF_4_1_1_3_1) { this.AF_4_1_1_3_1=AF_4_1_1_3_1;}
    @Column(name = "AF_4_1_1_4")
    @JsonProperty("AF-4-1-1-4")
    private String AF_4_1_1_4; // 使用ARB类药物的选择
    public String getAF_4_1_1_4() {  return this.AF_4_1_1_4;}
    @JsonProperty("AF-4-1-1-4")
    public void setAF_4_1_1_4(final String AF_4_1_1_4) { this.AF_4_1_1_4=AF_4_1_1_4;}
    @Column(name = "AF_4_1_1_4_1")
    @JsonProperty("AF-4-1-1-4-1")
    private String AF_4_1_1_4_1; // 其他ARB 药物名称
    public String getAF_4_1_1_4_1() {  return this.AF_4_1_1_4_1;}
    @JsonProperty("AF-4-1-1-4-1")
    public void setAF_4_1_1_4_1(final String AF_4_1_1_4_1) { this.AF_4_1_1_4_1=AF_4_1_1_4_1;}
    @Column(name = "AF_4_1_2_1")
    @JsonProperty("AF-4-1-2-1")
    private String AF_4_1_2_1; // 是否有β受体阻滞剂用药长期医嘱
    public String getAF_4_1_2_1() {  return this.AF_4_1_2_1;}
    @JsonProperty("AF-4-1-2-1")
    public void setAF_4_1_2_1(final String AF_4_1_2_1) { this.AF_4_1_2_1=AF_4_1_2_1;}
    @Column(name = "AF_4_1_2_2")
    @JsonProperty("AF-4-1-2-2")
    private String AF_4_1_2_2; // 使用首剂β-受体阻滞剂药物的选择
    public String getAF_4_1_2_2() {  return this.AF_4_1_2_2;}
    @JsonProperty("AF-4-1-2-2")
    public void setAF_4_1_2_2(final String AF_4_1_2_2) { this.AF_4_1_2_2=AF_4_1_2_2;}
    @Column(name = "AF_4_1_2_2_1")
    @JsonProperty("AF-4-1-2-2-1")
    private String AF_4_1_2_2_1; // 其他β-受体阻滞剂药物名称
    public String getAF_4_1_2_2_1() {  return this.AF_4_1_2_2_1;}
    @JsonProperty("AF-4-1-2-2-1")
    public void setAF_4_1_2_2_1(final String AF_4_1_2_2_1) { this.AF_4_1_2_2_1=AF_4_1_2_2_1;}
    @Column(name = "AF_4_1_3_1")
    @JsonProperty("AF-4-1-3-1")
    private String AF_4_1_3_1; // 是否有固酮拮抗剂药物用药长期医嘱
    public String getAF_4_1_3_1() {  return this.AF_4_1_3_1;}
    @JsonProperty("AF-4-1-3-1")
    public void setAF_4_1_3_1(final String AF_4_1_3_1) { this.AF_4_1_3_1=AF_4_1_3_1;}
    @Column(name = "AF_4_1_3_2")
    @JsonProperty("AF-4-1-3-2")
    private String AF_4_1_3_2; // 使用醛固酮受体拮抗剂的选择
    public String getAF_4_1_3_2() {  return this.AF_4_1_3_2;}
    @JsonProperty("AF-4-1-3-2")
    public void setAF_4_1_3_2(final String AF_4_1_3_2) { this.AF_4_1_3_2=AF_4_1_3_2;}
    @Column(name = "AF_4_1_3_2_1")
    @JsonProperty("AF-4-1-3-2-1")
    private String AF_4_1_3_2_1; // 其他醛固酮受体拮抗剂类药物名称
    public String getAF_4_1_3_2_1() {  return this.AF_4_1_3_2_1;}
    @JsonProperty("AF-4-1-3-2-1")
    public void setAF_4_1_3_2_1(final String AF_4_1_3_2_1) { this.AF_4_1_3_2_1=AF_4_1_3_2_1;}
    @Column(name = "AF_4_2_1_1")
    @JsonProperty("AF-4-2-1-1")
    private String AF_4_2_1_1; // 出院带药医嘱中有继续使用ACEI或ARB药物记录医嘱
    public String getAF_4_2_1_1() {  return this.AF_4_2_1_1;}
    @JsonProperty("AF-4-2-1-1")
    public void setAF_4_2_1_1(final String AF_4_2_1_1) { this.AF_4_2_1_1=AF_4_2_1_1;}
    @Column(name = "AF_4_2_1_2")
    @JsonProperty("AF-4-2-1-2")
    private String AF_4_2_1_2; // 出院带药医嘱药物的选择(ACEI/ARB)
    public String getAF_4_2_1_2() {  return this.AF_4_2_1_2;}
    @JsonProperty("AF-4-2-1-2")
    public void setAF_4_2_1_2(final String AF_4_2_1_2) { this.AF_4_2_1_2=AF_4_2_1_2;}
    @Column(name = "AF_4_2_1_3")
    @JsonProperty("AF-4-2-1-3")
    private String AF_4_2_1_3; // ACEI抑制剂药物的选择
    public String getAF_4_2_1_3() {  return this.AF_4_2_1_3;}
    @JsonProperty("AF-4-2-1-3")
    public void setAF_4_2_1_3(final String AF_4_2_1_3) { this.AF_4_2_1_3=AF_4_2_1_3;}
    @Column(name = "AF_4_2_1_3_1")
    @JsonProperty("AF-4-2-1-3-1")
    private String AF_4_2_1_3_1; // 其他ACEI 药物名称
    public String getAF_4_2_1_3_1() {  return this.AF_4_2_1_3_1;}
    @JsonProperty("AF-4-2-1-3-1")
    public void setAF_4_2_1_3_1(final String AF_4_2_1_3_1) { this.AF_4_2_1_3_1=AF_4_2_1_3_1;}
    @Column(name = "AF_4_2_1_4")
    @JsonProperty("AF-4-2-1-4")
    private String AF_4_2_1_4; // 使用ARB类药物的选择
    public String getAF_4_2_1_4() {  return this.AF_4_2_1_4;}
    @JsonProperty("AF-4-2-1-4")
    public void setAF_4_2_1_4(final String AF_4_2_1_4) { this.AF_4_2_1_4=AF_4_2_1_4;}
    @Column(name = "AF_4_2_1_4_1")
    @JsonProperty("AF-4-2-1-4-1")
    private String AF_4_2_1_4_1; // 其他ARB 药物名称
    public String getAF_4_2_1_4_1() {  return this.AF_4_2_1_4_1;}
    @JsonProperty("AF-4-2-1-4-1")
    public void setAF_4_2_1_4_1(final String AF_4_2_1_4_1) { this.AF_4_2_1_4_1=AF_4_2_1_4_1;}
    @Column(name = "AF_4_2_2_1")
    @JsonProperty("AF-4-2-2-1")
    private String AF_4_2_2_1; // 出院带药医嘱中有继续使用β受体阻滞剂药物医嘱
    public String getAF_4_2_2_1() {  return this.AF_4_2_2_1;}
    @JsonProperty("AF-4-2-2-1")
    public void setAF_4_2_2_1(final String AF_4_2_2_1) { this.AF_4_2_2_1=AF_4_2_2_1;}
    @Column(name = "AF_4_2_2_2")
    @JsonProperty("AF-4-2-2-2")
    private String AF_4_2_2_2; // 使用首剂β-受体阻滞剂药物的选择
    public String getAF_4_2_2_2() {  return this.AF_4_2_2_2;}
    @JsonProperty("AF-4-2-2-2")
    public void setAF_4_2_2_2(final String AF_4_2_2_2) { this.AF_4_2_2_2=AF_4_2_2_2;}
    @Column(name = "AF_4_2_2_2_1")
    @JsonProperty("AF-4-2-2-2-1")
    private String AF_4_2_2_2_1; // 其他β-受体阻滞剂药物名称
    public String getAF_4_2_2_2_1() {  return this.AF_4_2_2_2_1;}
    @JsonProperty("AF-4-2-2-2-1")
    public void setAF_4_2_2_2_1(final String AF_4_2_2_2_1) { this.AF_4_2_2_2_1=AF_4_2_2_2_1;}
    @Column(name = "AF_4_2_3_1")
    @JsonProperty("AF-4-2-3-1")
    private String AF_4_2_3_1; // 出院带药医嘱中有继续使用醛固酮拮抗剂药物医嘱
    public String getAF_4_2_3_1() {  return this.AF_4_2_3_1;}
    @JsonProperty("AF-4-2-3-1")
    public void setAF_4_2_3_1(final String AF_4_2_3_1) { this.AF_4_2_3_1=AF_4_2_3_1;}
    @Column(name = "AF_4_2_3_2")
    @JsonProperty("AF-4-2-3-2")
    private String AF_4_2_3_2; // 使用醛固酮受体拮抗剂的选择
    public String getAF_4_2_3_2() {  return this.AF_4_2_3_2;}
    @JsonProperty("AF-4-2-3-2")
    public void setAF_4_2_3_2(final String AF_4_2_3_2) { this.AF_4_2_3_2=AF_4_2_3_2;}
    @Column(name = "AF_4_2_3_2_1")
    @JsonProperty("AF-4-2-3-2-1")
    private String AF_4_2_3_2_1; // 其他醛固酮受体拮抗剂类药物名称
    public String getAF_4_2_3_2_1() {  return this.AF_4_2_3_2_1;}
    @JsonProperty("AF-4-2-3-2-1")
    public void setAF_4_2_3_2_1(final String AF_4_2_3_2_1) { this.AF_4_2_3_2_1=AF_4_2_3_2_1;}
    @Column(name = "AF_5_1_1")
    @JsonProperty("AF-5-1-1")
    private String AF_5_1_1; // 是否进行房颤导管消融治疗
    public String getAF_5_1_1() {  return this.AF_5_1_1;}
    @JsonProperty("AF-5-1-1")
    public void setAF_5_1_1(final String AF_5_1_1) { this.AF_5_1_1=AF_5_1_1;}
    @Column(name = "AF_5_1_2")
    @JsonProperty("AF-5-1-2")
    private String AF_5_1_2; // 适应证
    public String getAF_5_1_2() {  return this.AF_5_1_2;}
    @JsonProperty("AF-5-1-2")
    public void setAF_5_1_2(final String AF_5_1_2) { this.AF_5_1_2=AF_5_1_2;}
    @Column(name = "AF_5_1_4_2")
    @JsonProperty("AF-5-1-4-2")
    private String AF_5_1_4_2; // 消融治疗入路
    public String getAF_5_1_4_2() {  return this.AF_5_1_4_2;}
    @JsonProperty("AF-5-1-4-2")
    public void setAF_5_1_4_2(final String AF_5_1_4_2) { this.AF_5_1_4_2=AF_5_1_4_2;}
    @Column(name = "AF_5_1_3_2")
    @JsonProperty("AF-5-1-3-2")
    private String AF_5_1_3_2; // 消融治疗能源
    public String getAF_5_1_3_2() {  return this.AF_5_1_3_2;}
    @JsonProperty("AF-5-1-3-2")
    public void setAF_5_1_3_2(final String AF_5_1_3_2) { this.AF_5_1_3_2=AF_5_1_3_2;}
    @Column(name = "AF_5_1_3_3")
    @JsonProperty("AF-5-1-3-3")
    private String AF_5_1_3_3; // 其他消融治疗方法
    public String getAF_5_1_3_3() {  return this.AF_5_1_3_3;}
    @JsonProperty("AF-5-1-3-3")
    public void setAF_5_1_3_3(final String AF_5_1_3_3) { this.AF_5_1_3_3=AF_5_1_3_3;}
    @Column(name = "AF_5_1_3")
    @JsonProperty("AF-5-1-3")
    private String AF_5_1_3; // 房颤导管消融常用术式和终点
    public String getAF_5_1_3() {  return this.AF_5_1_3;}
    @JsonProperty("AF-5-1-3")
    public void setAF_5_1_3(final String AF_5_1_3) { this.AF_5_1_3=AF_5_1_3;}
    @Column(name = "AF_5_1_3_4")
    @JsonProperty("AF-5-1-3-4")
    private String AF_5_1_3_4; // 其他消融术
    public String getAF_5_1_3_4() {  return this.AF_5_1_3_4;}
    @JsonProperty("AF-5-1-3-4")
    public void setAF_5_1_3_4(final String AF_5_1_3_4) { this.AF_5_1_3_4=AF_5_1_3_4;}
    @Column(name = "AF_5_1_4_0")
    @JsonProperty("AF-5-1-4-0")
    private String AF_5_1_4_0; // 是否有治疗并发症
    public String getAF_5_1_4_0() {  return this.AF_5_1_4_0;}
    @JsonProperty("AF-5-1-4-0")
    public void setAF_5_1_4_0(final String AF_5_1_4_0) { this.AF_5_1_4_0=AF_5_1_4_0;}
    @Column(name = "AF_5_1_4")
    @JsonProperty("AF-5-1-4")
    private String AF_5_1_4; // 治疗并发症
    public String getAF_5_1_4() {  return this.AF_5_1_4;}
    @JsonProperty("AF-5-1-4")
    public void setAF_5_1_4(final String AF_5_1_4) { this.AF_5_1_4=AF_5_1_4;}
    @Column(name = "AF_5_1_4_1")
    @JsonProperty("AF-5-1-4-1")
    private String AF_5_1_4_1; // 其他治疗并发症
    public String getAF_5_1_4_1() {  return this.AF_5_1_4_1;}
    @JsonProperty("AF-5-1-4-1")
    public void setAF_5_1_4_1(final String AF_5_1_4_1) { this.AF_5_1_4_1=AF_5_1_4_1;}
    @Column(name = "AF_5_1_5")
    @JsonProperty("AF-5-1-5")
    private String AF_5_1_5; // 影响程度的选择
    public String getAF_5_1_5() {  return this.AF_5_1_5;}
    @JsonProperty("AF-5-1-5")
    public void setAF_5_1_5(final String AF_5_1_5) { this.AF_5_1_5=AF_5_1_5;}
    @Column(name = "AF_5_2_1")
    @JsonProperty("AF-5-2-1")
    private String AF_5_2_1; // 是否进行左心耳封堵治疗
    public String getAF_5_2_1() {  return this.AF_5_2_1;}
    @JsonProperty("AF-5-2-1")
    public void setAF_5_2_1(final String AF_5_2_1) { this.AF_5_2_1=AF_5_2_1;}
    @Column(name = "AF_5_2_2")
    @JsonProperty("AF-5-2-2")
    private String AF_5_2_2; // 应用LAAC预防NVAF血栓事件的适合性评估情况
    public String getAF_5_2_2() {  return this.AF_5_2_2;}
    @JsonProperty("AF-5-2-2")
    public void setAF_5_2_2(final String AF_5_2_2) { this.AF_5_2_2=AF_5_2_2;}
    @Column(name = "AF_5_2_2_1")
    @JsonProperty("AF-5-2-2-1")
    private String AF_5_2_2_1; // 其他应用LAAC预防NVAF血栓事件的适合性评估情
    public String getAF_5_2_2_1() {  return this.AF_5_2_2_1;}
    @JsonProperty("AF-5-2-2-1")
    public void setAF_5_2_2_1(final String AF_5_2_2_1) { this.AF_5_2_2_1=AF_5_2_2_1;}
    @Column(name = "AF_5_3_1")
    @JsonProperty("AF-5-3-1")
    private String AF_5_3_1; // 是否LAAC术中使用TEE等方法监测
    public String getAF_5_3_1() {  return this.AF_5_3_1;}
    @JsonProperty("AF-5-3-1")
    public void setAF_5_3_1(final String AF_5_3_1) { this.AF_5_3_1=AF_5_3_1;}
    @Column(name = "AF_5_2_9")
    @JsonProperty("AF-5-2-9")
    private String AF_5_2_9; // LAAC采用TEE等方法实施术中监测
    public String getAF_5_2_9() {  return this.AF_5_2_9;}
    @JsonProperty("AF-5-2-9")
    public void setAF_5_2_9(final String AF_5_2_9) { this.AF_5_2_9=AF_5_2_9;}
    @Column(name = "AF_5_2_9_1")
    @JsonProperty("AF-5-2-9-1")
    private String AF_5_2_9_1; // 其他方法实施术中监测
    public String getAF_5_2_9_1() {  return this.AF_5_2_9_1;}
    @JsonProperty("AF-5-2-9-1")
    public void setAF_5_2_9_1(final String AF_5_2_9_1) { this.AF_5_2_9_1=AF_5_2_9_1;}
    @Column(name = "AF_5_2_4")
    @JsonProperty("AF-5-2-4")
    private String AF_5_2_4; // TEE在LAAC术中监测
    public String getAF_5_2_4() {  return this.AF_5_2_4;}
    @JsonProperty("AF-5-2-4")
    public void setAF_5_2_4(final String AF_5_2_4) { this.AF_5_2_4=AF_5_2_4;}
    @Column(name = "AF_5_2_4_0")
    @JsonProperty("AF-5-2-4-0")
    private String AF_5_2_4_0; // 是否有治疗并发症
    public String getAF_5_2_4_0() {  return this.AF_5_2_4_0;}
    @JsonProperty("AF-5-2-4-0")
    public void setAF_5_2_4_0(final String AF_5_2_4_0) { this.AF_5_2_4_0=AF_5_2_4_0;}
    @Column(name = "AF_5_2_3")
    @JsonProperty("AF-5-2-3")
    private String AF_5_2_3; // 治疗并发症
    public String getAF_5_2_3() {  return this.AF_5_2_3;}
    @JsonProperty("AF-5-2-3")
    public void setAF_5_2_3(final String AF_5_2_3) { this.AF_5_2_3=AF_5_2_3;}
    @Column(name = "AF_5_2_3_1")
    @JsonProperty("AF-5-2-3-1")
    private String AF_5_2_3_1; // 其他治疗并发症
    public String getAF_5_2_3_1() {  return this.AF_5_2_3_1;}
    @JsonProperty("AF-5-2-3-1")
    public void setAF_5_2_3_1(final String AF_5_2_3_1) { this.AF_5_2_3_1=AF_5_2_3_1;}
    @Column(name = "AF_5_2_5")
    @JsonProperty("AF-5-2-5")
    private String AF_5_2_5; // 影响程度的选择
    public String getAF_5_2_5() {  return this.AF_5_2_5;}
    @JsonProperty("AF-5-2-5")
    public void setAF_5_2_5(final String AF_5_2_5) { this.AF_5_2_5=AF_5_2_5;}
    @Column(name = "AF_5_2_10")
    @JsonProperty("AF-5-2-10")
    private String AF_5_2_10; // 是否围术期抗凝
    public String getAF_5_2_10() {  return this.AF_5_2_10;}
    @JsonProperty("AF-5-2-10")
    public void setAF_5_2_10(final String AF_5_2_10) { this.AF_5_2_10=AF_5_2_10;}
    @Column(name = "AF_5_2_10_1")
    @JsonProperty("AF-5-2-10-1")
    private String AF_5_2_10_1; // 围术期抗凝其他方法
    public String getAF_5_2_10_1() {  return this.AF_5_2_10_1;}
    @JsonProperty("AF-5-2-10-1")
    public void setAF_5_2_10_1(final String AF_5_2_10_1) { this.AF_5_2_10_1=AF_5_2_10_1;}
    @Column(name = "AF_5_2_8")
    @JsonProperty("AF-5-2-8")
    private String AF_5_2_8; // 使用新型口服抗凝药（NOAC）
    public String getAF_5_2_8() {  return this.AF_5_2_8;}
    @JsonProperty("AF-5-2-8")
    public void setAF_5_2_8(final String AF_5_2_8) { this.AF_5_2_8=AF_5_2_8;}
    @Column(name = "AF_5_2_8_1")
    @JsonProperty("AF-5-2-8-1")
    private String AF_5_2_8_1; // 其他非维生素K拮抗剂口服抗凝药物（NOAC）
    public String getAF_5_2_8_1() {  return this.AF_5_2_8_1;}
    @JsonProperty("AF-5-2-8-1")
    public void setAF_5_2_8_1(final String AF_5_2_8_1) { this.AF_5_2_8_1=AF_5_2_8_1;}
    @Column(name = "AF_5_2_8_2")
    @JsonProperty("AF-5-2-8-2")
    private String AF_5_2_8_2; // 其他药物
    public String getAF_5_2_8_2() {  return this.AF_5_2_8_2;}
    @JsonProperty("AF-5-2-8-2")
    public void setAF_5_2_8_2(final String AF_5_2_8_2) { this.AF_5_2_8_2=AF_5_2_8_2;}
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
    @Column(name = "AF_6_1_3")
    @JsonProperty("AF-6-1-3")
    private String AF_6_1_3; // 新型口服抗凝药（NOAC）or华法林
    public String getAF_6_1_3() {  return this.AF_6_1_3;}
    @JsonProperty("AF-6-1-3")
    public void setAF_6_1_3(final String AF_6_1_3) { this.AF_6_1_3=AF_6_1_3;}
    @Column(name = "AF_6_1_1_1")
    @JsonProperty("AF-6-1-1-1")
    private String AF_6_1_1_1; // 其他非维生素K拮抗剂口服抗凝药物
    public String getAF_6_1_1_1() {  return this.AF_6_1_1_1;}
    @JsonProperty("AF-6-1-1-1")
    public void setAF_6_1_1_1(final String AF_6_1_1_1) { this.AF_6_1_1_1=AF_6_1_1_1;}
    @Column(name = "AF_7_1_1")
    @JsonProperty("AF-7-1-1")
    private String AF_7_1_1; // 常見危险因素
    public String getAF_7_1_1() {  return this.AF_7_1_1;}
    @JsonProperty("AF-7-1-1")
    public void setAF_7_1_1(final String AF_7_1_1) { this.AF_7_1_1=AF_7_1_1;}
    @Column(name = "AF_7_1_1_1")
    @JsonProperty("AF-7-1-1-1")
    private String AF_7_1_1_1; // 其他危险因素
    public String getAF_7_1_1_1() {  return this.AF_7_1_1_1;}
    @JsonProperty("AF-7-1-1-1")
    public void setAF_7_1_1_1(final String AF_7_1_1_1) { this.AF_7_1_1_1=AF_7_1_1_1;}
    @Column(name = "AF_7_2_1")
    @JsonProperty("AF-7-2-1")
    private String AF_7_2_1; // 使用新型口服抗凝药（NOAC）or华法林药物治疗的健康教育
    public String getAF_7_2_1() {  return this.AF_7_2_1;}
    @JsonProperty("AF-7-2-1")
    public void setAF_7_2_1(final String AF_7_2_1) { this.AF_7_2_1=AF_7_2_1;}
    @Column(name = "AF_7_2_2")
    @JsonProperty("AF-7-2-2")
    private String AF_7_2_2; // 使用抗心律失常药物治疗的健康教育
    public String getAF_7_2_2() {  return this.AF_7_2_2;}
    @JsonProperty("AF-7-2-2")
    public void setAF_7_2_2(final String AF_7_2_2) { this.AF_7_2_2=AF_7_2_2;}
    @Column(name = "AF_7_3_1")
    @JsonProperty("AF-7-3-1")
    private String AF_7_3_1; // 房颤导管消融治疗（含冷冻球囊）的健康教育
    public String getAF_7_3_1() {  return this.AF_7_3_1;}
    @JsonProperty("AF-7-3-1")
    public void setAF_7_3_1(final String AF_7_3_1) { this.AF_7_3_1=AF_7_3_1;}
    @Column(name = "AF_7_3_2")
    @JsonProperty("AF-7-3-2")
    private String AF_7_3_2; // 左心耳封堵治疗的健康教育左心耳封堵治疗
    public String getAF_7_3_2() {  return this.AF_7_3_2;}
    @JsonProperty("AF-7-3-2")
    public void setAF_7_3_2(final String AF_7_3_2) { this.AF_7_3_2=AF_7_3_2;}
    @Column(name = "AF_7_4_1")
    @JsonProperty("AF-7-4-1")
    private String AF_7_4_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    public String getAF_7_4_1() {  return this.AF_7_4_1;}
    @JsonProperty("AF-7-4-1")
    public void setAF_7_4_1(final String AF_7_4_1) { this.AF_7_4_1=AF_7_4_1;}
    @Column(name = "AF_7_4_2")
    @JsonProperty("AF-7-4-2")
    private String AF_7_4_2; // 出院带药
    public String getAF_7_4_2() {  return this.AF_7_4_2;}
    @JsonProperty("AF-7-4-2")
    public void setAF_7_4_2(final String AF_7_4_2) { this.AF_7_4_2=AF_7_4_2;}
    @Column(name = "AF_7_4_3")
    @JsonProperty("AF-7-4-3")
    private String AF_7_4_3; // 告知何为风险因素与紧急情况
    public String getAF_7_4_3() {  return this.AF_7_4_3;}
    @JsonProperty("AF-7-4-3")
    public void setAF_7_4_3(final String AF_7_4_3) { this.AF_7_4_3=AF_7_4_3;}
    @Column(name = "AF_7_4_4")
    @JsonProperty("AF-7-4-4")
    private String AF_7_4_4; // 告知发生紧急情况时求援救治途径
    public String getAF_7_4_4() {  return this.AF_7_4_4;}
    @JsonProperty("AF-7-4-4")
    public void setAF_7_4_4(final String AF_7_4_4) { this.AF_7_4_4=AF_7_4_4;}
    @Column(name = "AF_7_4_5")
    @JsonProperty("AF-7-4-5")
    private String AF_7_4_5; // 出院时教育与随访
    public String getAF_7_4_5() {  return this.AF_7_4_5;}
    @JsonProperty("AF-7-4-5")
    public void setAF_7_4_5(final String AF_7_4_5) { this.AF_7_4_5=AF_7_4_5;}
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
}