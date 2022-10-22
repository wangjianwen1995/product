package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要手术 ICD-9-CM-3 编码：23.5，23.6 的门诊患者或者 76.09，76.91，76.92，22.79 的手术出院患者。
*/
@ApiModel(value = "40信息")
@Entity
@Table(name = "sd_info_OIT")
public class SdInfoOIT implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    public void setId(final Integer id) {this.id = id;}
    public Integer getId() {return this.id;}
    @Column(name = "OIT_0_1_1")
    @JsonProperty("OIT-0-1-1")
    private String OIT_0_1_1; // 是否填写医疗机构相关信息
    public String getOIT_0_1_1() {  return this.OIT_0_1_1;}
    @JsonProperty("OIT-0-1-1")
    public void setOIT_0_1_1(final String OIT_0_1_1) { this.OIT_0_1_1=OIT_0_1_1;}
    @Column(name = "OIT_0_1_2")
    @JsonProperty("OIT-0-1-2")
    private String OIT_0_1_2; // 机构名称
    public String getOIT_0_1_2() {  return this.OIT_0_1_2;}
    @JsonProperty("OIT-0-1-2")
    public void setOIT_0_1_2(final String OIT_0_1_2) { this.OIT_0_1_2=OIT_0_1_2;}
    @Column(name = "OIT_0_1_3")
    @JsonProperty("OIT-0-1-3")
    private String OIT_0_1_3; // 机构类别
    public String getOIT_0_1_3() {  return this.OIT_0_1_3;}
    @JsonProperty("OIT-0-1-3")
    public void setOIT_0_1_3(final String OIT_0_1_3) { this.OIT_0_1_3=OIT_0_1_3;}
    @Column(name = "OIT_0_1_4")
    @JsonProperty("OIT-0-1-4")
    private String OIT_0_1_4; // 机构性质
    public String getOIT_0_1_4() {  return this.OIT_0_1_4;}
    @JsonProperty("OIT-0-1-4")
    public void setOIT_0_1_4(final String OIT_0_1_4) { this.OIT_0_1_4=OIT_0_1_4;}
    @Column(name = "OIT_0_1_5")
    @JsonProperty("OIT-0-1-5")
    private String OIT_0_1_5; // 牙椅数
    public String getOIT_0_1_5() {  return this.OIT_0_1_5;}
    @JsonProperty("OIT-0-1-5")
    public void setOIT_0_1_5(final String OIT_0_1_5) { this.OIT_0_1_5=OIT_0_1_5;}
    @Column(name = "OIT_0_1_6_1")
    @JsonProperty("OIT-0-1-6-1")
    private String OIT_0_1_6_1; // 所在省
    public String getOIT_0_1_6_1() {  return this.OIT_0_1_6_1;}
    @JsonProperty("OIT-0-1-6-1")
    public void setOIT_0_1_6_1(final String OIT_0_1_6_1) { this.OIT_0_1_6_1=OIT_0_1_6_1;}
    @Column(name = "OIT_0_1_6_2")
    @JsonProperty("OIT-0-1-6-2")
    private String OIT_0_1_6_2; // 所在市
    public String getOIT_0_1_6_2() {  return this.OIT_0_1_6_2;}
    @JsonProperty("OIT-0-1-6-2")
    public void setOIT_0_1_6_2(final String OIT_0_1_6_2) { this.OIT_0_1_6_2=OIT_0_1_6_2;}
    @Column(name = "OIT_0_1_6_3")
    @JsonProperty("OIT-0-1-6-3")
    private String OIT_0_1_6_3; // 所在区县
    public String getOIT_0_1_6_3() {  return this.OIT_0_1_6_3;}
    @JsonProperty("OIT-0-1-6-3")
    public void setOIT_0_1_6_3(final String OIT_0_1_6_3) { this.OIT_0_1_6_3=OIT_0_1_6_3;}
    @Column(name = "OIT_0_1_7")
    @JsonProperty("OIT-0-1-7")
    private String OIT_0_1_7; // 所有制形式
    public String getOIT_0_1_7() {  return this.OIT_0_1_7;}
    @JsonProperty("OIT-0-1-7")
    public void setOIT_0_1_7(final String OIT_0_1_7) { this.OIT_0_1_7=OIT_0_1_7;}
    @Column(name = "OIT_0_2_1")
    @JsonProperty("OIT-0-2-1")
    private String OIT_0_2_1; // 治疗模式
    public String getOIT_0_2_1() {  return this.OIT_0_2_1;}
    @JsonProperty("OIT-0-2-1")
    public void setOIT_0_2_1(final String OIT_0_2_1) { this.OIT_0_2_1=OIT_0_2_1;}
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
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getCM_0_1_4_1() {  return this.CM_0_1_4_1;}
    @JsonProperty("CM-0-1-4-1")
    public void setCM_0_1_4_1(final String CM_0_1_4_1) { this.CM_0_1_4_1=CM_0_1_4_1;}
    @Column(name = "OIT_0_1_4_1")
    @JsonProperty("OIT-0-1-4-1")
    private String OIT_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    public String getOIT_0_1_4_1() {  return this.OIT_0_1_4_1;}
    @JsonProperty("OIT-0-1-4-1")
    public void setOIT_0_1_4_1(final String OIT_0_1_4_1) { this.OIT_0_1_4_1=OIT_0_1_4_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "OIT_0_1_4_2")
    @JsonProperty("OIT-0-1-4-2")
    private String OIT_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
    public String getOIT_0_1_4_2() {  return this.OIT_0_1_4_2;}
    @JsonProperty("OIT-0-1-4-2")
    public void setOIT_0_1_4_2(final String OIT_0_1_4_2) { this.OIT_0_1_4_2=OIT_0_1_4_2;}
    @Column(name = "OIT_0_2_4_1")
    @JsonProperty("OIT-0-2-4-1")
    private String OIT_0_2_4_1; // 门诊初诊日期时间
    public String getOIT_0_2_4_1() {  return this.OIT_0_2_4_1;}
    @JsonProperty("OIT-0-2-4-1")
    public void setOIT_0_2_4_1(final String OIT_0_2_4_1) { this.OIT_0_2_4_1=OIT_0_2_4_1;}
    @Column(name = "OIT_0_2_4_2")
    @JsonProperty("OIT-0-2-4-2")
    private String OIT_0_2_4_2; // 种植一期手术日期时间 
    public String getOIT_0_2_4_2() {  return this.OIT_0_2_4_2;}
    @JsonProperty("OIT-0-2-4-2")
    public void setOIT_0_2_4_2(final String OIT_0_2_4_2) { this.OIT_0_2_4_2=OIT_0_2_4_2;}
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
    @Column(name = "OIT_1_1_1")
    @JsonProperty("OIT-1-1-1")
    private String OIT_1_1_1; // 既往史与现病史的其他相关情况记录
    public String getOIT_1_1_1() {  return this.OIT_1_1_1;}
    @JsonProperty("OIT-1-1-1")
    public void setOIT_1_1_1(final String OIT_1_1_1) { this.OIT_1_1_1=OIT_1_1_1;}
    @Column(name = "OIT_1_1_1_1")
    @JsonProperty("OIT-1-1-1-1")
    private String OIT_1_1_1_1; // 既往史与现病史的其他相关情况记录
    public String getOIT_1_1_1_1() {  return this.OIT_1_1_1_1;}
    @JsonProperty("OIT-1-1-1-1")
    public void setOIT_1_1_1_1(final String OIT_1_1_1_1) { this.OIT_1_1_1_1=OIT_1_1_1_1;}
    @Column(name = "OIT_1_1_2")
    @JsonProperty("OIT-1-1-2")
    private String OIT_1_1_2; // 是否有血液系统疾病的记录
    public String getOIT_1_1_2() {  return this.OIT_1_1_2;}
    @JsonProperty("OIT-1-1-2")
    public void setOIT_1_1_2(final String OIT_1_1_2) { this.OIT_1_1_2=OIT_1_1_2;}
    @Column(name = "OIT_1_1_3")
    @JsonProperty("OIT-1-1-3")
    private String OIT_1_1_3; // 血液系统疾病的记录
    public String getOIT_1_1_3() {  return this.OIT_1_1_3;}
    @JsonProperty("OIT-1-1-3")
    public void setOIT_1_1_3(final String OIT_1_1_3) { this.OIT_1_1_3=OIT_1_1_3;}
    @Column(name = "OIT_1_1_3_1")
    @JsonProperty("OIT-1-1-3-1")
    private String OIT_1_1_3_1; // 血液系统疾病的其他相关情况记录
    public String getOIT_1_1_3_1() {  return this.OIT_1_1_3_1;}
    @JsonProperty("OIT-1-1-3-1")
    public void setOIT_1_1_3_1(final String OIT_1_1_3_1) { this.OIT_1_1_3_1=OIT_1_1_3_1;}
    @Column(name = "OIT_1_1_4")
    @JsonProperty("OIT-1-1-4")
    private String OIT_1_1_4; // 是否有骨质疏松的记录
    public String getOIT_1_1_4() {  return this.OIT_1_1_4;}
    @JsonProperty("OIT-1-1-4")
    public void setOIT_1_1_4(final String OIT_1_1_4) { this.OIT_1_1_4=OIT_1_1_4;}
    @Column(name = "OIT_1_1_5")
    @JsonProperty("OIT-1-1-5")
    private String OIT_1_1_5; // 是否有药品、食物等过敏史的记录
    public String getOIT_1_1_5() {  return this.OIT_1_1_5;}
    @JsonProperty("OIT-1-1-5")
    public void setOIT_1_1_5(final String OIT_1_1_5) { this.OIT_1_1_5=OIT_1_1_5;}
    @Column(name = "OIT_1_1_6")
    @JsonProperty("OIT-1-1-6")
    private String OIT_1_1_6; // 药品、食物等过敏史的记录
    public String getOIT_1_1_6() {  return this.OIT_1_1_6;}
    @JsonProperty("OIT-1-1-6")
    public void setOIT_1_1_6(final String OIT_1_1_6) { this.OIT_1_1_6=OIT_1_1_6;}
    @Column(name = "OIT_1_1_6_1")
    @JsonProperty("OIT-1-1-6-1")
    private String OIT_1_1_6_1; // 其他药品、食物等过敏史
    public String getOIT_1_1_6_1() {  return this.OIT_1_1_6_1;}
    @JsonProperty("OIT-1-1-6-1")
    public void setOIT_1_1_6_1(final String OIT_1_1_6_1) { this.OIT_1_1_6_1=OIT_1_1_6_1;}
    @Column(name = "OIT_1_1_7")
    @JsonProperty("OIT-1-1-7")
    private String OIT_1_1_7; // 是否在月经或妊娠期
    public String getOIT_1_1_7() {  return this.OIT_1_1_7;}
    @JsonProperty("OIT-1-1-7")
    public void setOIT_1_1_7(final String OIT_1_1_7) { this.OIT_1_1_7=OIT_1_1_7;}
    @Column(name = "OIT_1_2_1")
    @JsonProperty("OIT-1-2-1")
    private String OIT_1_2_1; // 余留牙情况是否有异常
    public String getOIT_1_2_1() {  return this.OIT_1_2_1;}
    @JsonProperty("OIT-1-2-1")
    public void setOIT_1_2_1(final String OIT_1_2_1) { this.OIT_1_2_1=OIT_1_2_1;}
    @Column(name = "OIT_1_2_1_1")
    @JsonProperty("OIT-1-2-1-1")
    private String OIT_1_2_1_1; // 其他余留牙异常
    public String getOIT_1_2_1_1() {  return this.OIT_1_2_1_1;}
    @JsonProperty("OIT-1-2-1-1")
    public void setOIT_1_2_1_1(final String OIT_1_2_1_1) { this.OIT_1_2_1_1=OIT_1_2_1_1;}
    @Column(name = "OIT_1_3_1")
    @JsonProperty("OIT-1-3-1")
    private String OIT_1_3_1; // 血液学检查是否有异常
    public String getOIT_1_3_1() {  return this.OIT_1_3_1;}
    @JsonProperty("OIT-1-3-1")
    public void setOIT_1_3_1(final String OIT_1_3_1) { this.OIT_1_3_1=OIT_1_3_1;}
    @Column(name = "OIT_1_3_1_1")
    @JsonProperty("OIT-1-3-1-1")
    private String OIT_1_3_1_1; // 其他血液学检查异常
    public String getOIT_1_3_1_1() {  return this.OIT_1_3_1_1;}
    @JsonProperty("OIT-1-3-1-1")
    public void setOIT_1_3_1_1(final String OIT_1_3_1_1) { this.OIT_1_3_1_1=OIT_1_3_1_1;}
    @Column(name = "OIT_2_1_1")
    @JsonProperty("OIT-2-1-1")
    private String OIT_2_1_1; // 是否有全口牙位曲面体层X线片
    public String getOIT_2_1_1() {  return this.OIT_2_1_1;}
    @JsonProperty("OIT-2-1-1")
    public void setOIT_2_1_1(final String OIT_2_1_1) { this.OIT_2_1_1=OIT_2_1_1;}
    @Column(name = "OIT_2_1_2")
    @JsonProperty("OIT-2-1-2")
    private String OIT_2_1_2; // 全口牙位曲面体层X线片有无异常情况
    public String getOIT_2_1_2() {  return this.OIT_2_1_2;}
    @JsonProperty("OIT-2-1-2")
    public void setOIT_2_1_2(final String OIT_2_1_2) { this.OIT_2_1_2=OIT_2_1_2;}
    @Column(name = "OIT_2_1_2_1")
    @JsonProperty("OIT-2-1-2-1")
    private String OIT_2_1_2_1; // X线片其他异常情况
    public String getOIT_2_1_2_1() {  return this.OIT_2_1_2_1;}
    @JsonProperty("OIT-2-1-2-1")
    public void setOIT_2_1_2_1(final String OIT_2_1_2_1) { this.OIT_2_1_2_1=OIT_2_1_2_1;}
    @Column(name = "OIT_2_1_3")
    @JsonProperty("OIT-2-1-3")
    private String OIT_2_1_3; // 是否有锥形束CT
    public String getOIT_2_1_3() {  return this.OIT_2_1_3;}
    @JsonProperty("OIT-2-1-3")
    public void setOIT_2_1_3(final String OIT_2_1_3) { this.OIT_2_1_3=OIT_2_1_3;}
    @Column(name = "OIT_2_1_4")
    @JsonProperty("OIT-2-1-4")
    private String OIT_2_1_4; // 锥形束CT有无异常情况
    public String getOIT_2_1_4() {  return this.OIT_2_1_4;}
    @JsonProperty("OIT-2-1-4")
    public void setOIT_2_1_4(final String OIT_2_1_4) { this.OIT_2_1_4=OIT_2_1_4;}
    @Column(name = "OIT_2_1_4_1")
    @JsonProperty("OIT-2-1-4-1")
    private String OIT_2_1_4_1; // 锥形束CT其他异常情况
    public String getOIT_2_1_4_1() {  return this.OIT_2_1_4_1;}
    @JsonProperty("OIT-2-1-4-1")
    public void setOIT_2_1_4_1(final String OIT_2_1_4_1) { this.OIT_2_1_4_1=OIT_2_1_4_1;}
    @Column(name = "OIT_2_1_5")
    @JsonProperty("OIT-2-1-5")
    private String OIT_2_1_5; // 是否有根尖片是否有
    public String getOIT_2_1_5() {  return this.OIT_2_1_5;}
    @JsonProperty("OIT-2-1-5")
    public void setOIT_2_1_5(final String OIT_2_1_5) { this.OIT_2_1_5=OIT_2_1_5;}
    @Column(name = "OIT_2_1_6")
    @JsonProperty("OIT-2-1-6")
    private String OIT_2_1_6; // 根尖片有无异常情况
    public String getOIT_2_1_6() {  return this.OIT_2_1_6;}
    @JsonProperty("OIT-2-1-6")
    public void setOIT_2_1_6(final String OIT_2_1_6) { this.OIT_2_1_6=OIT_2_1_6;}
    @Column(name = "OIT_2_1_6_1")
    @JsonProperty("OIT-2-1-6-1")
    private String OIT_2_1_6_1; // 根尖片其他异常情况
    public String getOIT_2_1_6_1() {  return this.OIT_2_1_6_1;}
    @JsonProperty("OIT-2-1-6-1")
    public void setOIT_2_1_6_1(final String OIT_2_1_6_1) { this.OIT_2_1_6_1=OIT_2_1_6_1;}
    @Column(name = "OIT_2_2_1")
    @JsonProperty("OIT-2-2-1")
    private String OIT_2_2_1; // 是否存在下或上颌牙列缺损
    public String getOIT_2_2_1() {  return this.OIT_2_2_1;}
    @JsonProperty("OIT-2-2-1")
    public void setOIT_2_2_1(final String OIT_2_2_1) { this.OIT_2_2_1=OIT_2_2_1;}
    @Column(name = "OIT_2_2_2")
    @JsonProperty("OIT-2-2-2")
    private String OIT_2_2_2; // 是否存在颌牙列缺损伴水平向骨量不足
    public String getOIT_2_2_2() {  return this.OIT_2_2_2;}
    @JsonProperty("OIT-2-2-2")
    public void setOIT_2_2_2(final String OIT_2_2_2) { this.OIT_2_2_2=OIT_2_2_2;}
    @Column(name = "OIT_2_2_3")
    @JsonProperty("OIT-2-2-3")
    private String OIT_2_2_3; // 是否存在颌牙列缺损伴垂直向骨量不足
    public String getOIT_2_2_3() {  return this.OIT_2_2_3;}
    @JsonProperty("OIT-2-2-3")
    public void setOIT_2_2_3(final String OIT_2_2_3) { this.OIT_2_2_3=OIT_2_2_3;}
    @Column(name = "OIT_2_2_5")
    @JsonProperty("OIT-2-2-5")
    private String OIT_2_2_5; // 是否存在颌牙列缺损伴垂直向与水平向骨量都存在不足
    public String getOIT_2_2_5() {  return this.OIT_2_2_5;}
    @JsonProperty("OIT-2-2-5")
    public void setOIT_2_2_5(final String OIT_2_2_5) { this.OIT_2_2_5=OIT_2_2_5;}
    @Column(name = "OIT_2_2_4")
    @JsonProperty("OIT-2-2-4")
    private String OIT_2_2_4; // 是否存在颌牙列缺损伴软组织量不足
    public String getOIT_2_2_4() {  return this.OIT_2_2_4;}
    @JsonProperty("OIT-2-2-4")
    public void setOIT_2_2_4(final String OIT_2_2_4) { this.OIT_2_2_4=OIT_2_2_4;}
    @Column(name = "OIT_3_1_1")
    @JsonProperty("OIT-3-1-1")
    private String OIT_3_1_1; // 种植手术适应证的类型
    public String getOIT_3_1_1() {  return this.OIT_3_1_1;}
    @JsonProperty("OIT-3-1-1")
    public void setOIT_3_1_1(final String OIT_3_1_1) { this.OIT_3_1_1=OIT_3_1_1;}
    @Column(name = "OIT_3_2_1")
    @JsonProperty("OIT-3-2-1")
    private String OIT_3_2_1; // 是否有关术中骨组织增量的记录
    public String getOIT_3_2_1() {  return this.OIT_3_2_1;}
    @JsonProperty("OIT-3-2-1")
    public void setOIT_3_2_1(final String OIT_3_2_1) { this.OIT_3_2_1=OIT_3_2_1;}
    @Column(name = "OIT_3_2_2")
    @JsonProperty("OIT-3-2-2")
    private String OIT_3_2_2; // 是否有关术中软组织增量的记录
    public String getOIT_3_2_2() {  return this.OIT_3_2_2;}
    @JsonProperty("OIT-3-2-2")
    public void setOIT_3_2_2(final String OIT_3_2_2) { this.OIT_3_2_2=OIT_3_2_2;}
    @Column(name = "OIT_3_2_3")
    @JsonProperty("OIT-3-2-3")
    private String OIT_3_2_3; // 简单种植手术适应证内容
    public String getOIT_3_2_3() {  return this.OIT_3_2_3;}
    @JsonProperty("OIT-3-2-3")
    public void setOIT_3_2_3(final String OIT_3_2_3) { this.OIT_3_2_3=OIT_3_2_3;}
    @Column(name = "OIT_3_2_3_1")
    @JsonProperty("OIT-3-2-3-1")
    private String OIT_3_2_3_1; // 其他简单种植手术适应证内容
    public String getOIT_3_2_3_1() {  return this.OIT_3_2_3_1;}
    @JsonProperty("OIT-3-2-3-1")
    public void setOIT_3_2_3_1(final String OIT_3_2_3_1) { this.OIT_3_2_3_1=OIT_3_2_3_1;}
    @Column(name = "OIT_3_3_1")
    @JsonProperty("OIT-3-3-1")
    private String OIT_3_3_1; // 是否有关术中骨组织增量的记录
    public String getOIT_3_3_1() {  return this.OIT_3_3_1;}
    @JsonProperty("OIT-3-3-1")
    public void setOIT_3_3_1(final String OIT_3_3_1) { this.OIT_3_3_1=OIT_3_3_1;}
    @Column(name = "OIT_3_3_2")
    @JsonProperty("OIT-3-3-2")
    private String OIT_3_3_2; // 是否有关术中软组织增量的记录
    public String getOIT_3_3_2() {  return this.OIT_3_3_2;}
    @JsonProperty("OIT-3-3-2")
    public void setOIT_3_3_2(final String OIT_3_3_2) { this.OIT_3_3_2=OIT_3_3_2;}
    @Column(name = "OIT_3_3_3")
    @JsonProperty("OIT-3-3-3")
    private String OIT_3_3_3; // 复杂种植手术适应证内容
    public String getOIT_3_3_3() {  return this.OIT_3_3_3;}
    @JsonProperty("OIT-3-3-3")
    public void setOIT_3_3_3(final String OIT_3_3_3) { this.OIT_3_3_3=OIT_3_3_3;}
    @Column(name = "OIT_3_3_3_1")
    @JsonProperty("OIT-3-3-3-1")
    private String OIT_3_3_3_1; // 其他复杂种植手术适应证内容
    public String getOIT_3_3_3_1() {  return this.OIT_3_3_3_1;}
    @JsonProperty("OIT-3-3-3-1")
    public void setOIT_3_3_3_1(final String OIT_3_3_3_1) { this.OIT_3_3_3_1=OIT_3_3_3_1;}
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM-1-1-1")
    private String CM_1_1_1; // 是否有预防性使用抗菌药物
    public String getCM_1_1_1() {  return this.CM_1_1_1;}
    @JsonProperty("CM-1-1-1")
    public void setCM_1_1_1(final String CM_1_1_1) { this.CM_1_1_1=CM_1_1_1;}
    @Column(name = "CM_1_2_1_2")
    @JsonProperty("CM-1-2-1-2")
    private String CM_1_2_1_2; // 预防性抗菌药物选择
    public String getCM_1_2_1_2() {  return this.CM_1_2_1_2;}
    @JsonProperty("CM-1-2-1-2")
    public void setCM_1_2_1_2(final String CM_1_2_1_2) { this.CM_1_2_1_2=CM_1_2_1_2;}
    @Column(name = "OIT_4_2_1_1")
    @JsonProperty("OIT-4-2-1-1")
    private String OIT_4_2_1_1; // 其他预防性抗菌药物
    public String getOIT_4_2_1_1() {  return this.OIT_4_2_1_1;}
    @JsonProperty("OIT-4-2-1-1")
    public void setOIT_4_2_1_1(final String OIT_4_2_1_1) { this.OIT_4_2_1_1=OIT_4_2_1_1;}
    @Column(name = "OIT_4_2_2")
    @JsonProperty("OIT-4-2-2")
    private String OIT_4_2_2; // 药物使用途径
    public String getOIT_4_2_2() {  return this.OIT_4_2_2;}
    @JsonProperty("OIT-4-2-2")
    public void setOIT_4_2_2(final String OIT_4_2_2) { this.OIT_4_2_2=OIT_4_2_2;}
    @Column(name = "OIT_4_2_2_1")
    @JsonProperty("OIT-4-2-2-1")
    private String OIT_4_2_2_1; // 药物使用其他途径
    public String getOIT_4_2_2_1() {  return this.OIT_4_2_2_1;}
    @JsonProperty("OIT-4-2-2-1")
    public void setOIT_4_2_2_1(final String OIT_4_2_2_1) { this.OIT_4_2_2_1=OIT_4_2_2_1;}
    @Column(name = "CM_1_4_1")
    @JsonProperty("CM-1-4-1")
    private String CM_1_4_1; // 使用首剂抗菌药物起始时间
    public String getCM_1_4_1() {  return this.CM_1_4_1;}
    @JsonProperty("CM-1-4-1")
    public void setCM_1_4_1(final String CM_1_4_1) { this.CM_1_4_1=CM_1_4_1;}
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
    @Column(name = "OIT_5_1_1")
    @JsonProperty("OIT-5-1-1")
    private String OIT_5_1_1; // 是否有影像学诊断
    public String getOIT_5_1_1() {  return this.OIT_5_1_1;}
    @JsonProperty("OIT-5-1-1")
    public void setOIT_5_1_1(final String OIT_5_1_1) { this.OIT_5_1_1=OIT_5_1_1;}
    @Column(name = "OIT_5_1_2")
    @JsonProperty("OIT-5-1-2")
    private String OIT_5_1_2; // 是否有高值耗材使用同意书的签署
    public String getOIT_5_1_2() {  return this.OIT_5_1_2;}
    @JsonProperty("OIT-5-1-2")
    public void setOIT_5_1_2(final String OIT_5_1_2) { this.OIT_5_1_2=OIT_5_1_2;}
    @Column(name = "OIT_5_4_1")
    @JsonProperty("OIT-5-4-1")
    private String OIT_5_4_1; // 种植体系统
    public String getOIT_5_4_1() {  return this.OIT_5_4_1;}
    @JsonProperty("OIT-5-4-1")
    public void setOIT_5_4_1(final String OIT_5_4_1) { this.OIT_5_4_1=OIT_5_4_1;}
    @Column(name = "OIT_5_2_1_1")
    @JsonProperty("OIT-5-2-1-1")
    private String OIT_5_2_1_1; // 其他种植体系统
    public String getOIT_5_2_1_1() {  return this.OIT_5_2_1_1;}
    @JsonProperty("OIT-5-2-1-1")
    public void setOIT_5_2_1_1(final String OIT_5_2_1_1) { this.OIT_5_2_1_1=OIT_5_2_1_1;}
    @Column(name = "OIT_5_2_2")
    @JsonProperty("OIT-5-2-2")
    private String OIT_5_2_2; // 种植体植入部位
    public String getOIT_5_2_2() {  return this.OIT_5_2_2;}
    @JsonProperty("OIT-5-2-2")
    public void setOIT_5_2_2(final String OIT_5_2_2) { this.OIT_5_2_2=OIT_5_2_2;}
    @Column(name = "OIT_5_2_3")
    @JsonProperty("OIT-5-2-3")
    private String OIT_5_2_3; // 种植体型号
    public String getOIT_5_2_3() {  return this.OIT_5_2_3;}
    @JsonProperty("OIT-5-2-3")
    public void setOIT_5_2_3(final String OIT_5_2_3) { this.OIT_5_2_3=OIT_5_2_3;}
    @Column(name = "OIT_5_2_4")
    @JsonProperty("OIT-5-2-4")
    private String OIT_5_2_4; // 种植体植入数量
    public String getOIT_5_2_4() {  return this.OIT_5_2_4;}
    @JsonProperty("OIT-5-2-4")
    public void setOIT_5_2_4(final String OIT_5_2_4) { this.OIT_5_2_4=OIT_5_2_4;}
    @Column(name = "OIT_5_3_1")
    @JsonProperty("OIT-5-3-1")
    private String OIT_5_3_1; // 是否有骨粉材料使用的记录
    public String getOIT_5_3_1() {  return this.OIT_5_3_1;}
    @JsonProperty("OIT-5-3-1")
    public void setOIT_5_3_1(final String OIT_5_3_1) { this.OIT_5_3_1=OIT_5_3_1;}
    @Column(name = "OIT_5_3_2")
    @JsonProperty("OIT-5-3-2")
    private String OIT_5_3_2; // 是否有其他高值耗材使用的记录
    public String getOIT_5_3_2() {  return this.OIT_5_3_2;}
    @JsonProperty("OIT-5-3-2")
    public void setOIT_5_3_2(final String OIT_5_3_2) { this.OIT_5_3_2=OIT_5_3_2;}
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
    @Column(name = "OIT_6_1_3")
    @JsonProperty("OIT-6-1-3")
    private String OIT_6_1_3; // 口腔种植术特指的并发症
    public String getOIT_6_1_3() {  return this.OIT_6_1_3;}
    @JsonProperty("OIT-6-1-3")
    public void setOIT_6_1_3(final String OIT_6_1_3) { this.OIT_6_1_3=OIT_6_1_3;}
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
    @Column(name = "OIT_7_1_1")
    @JsonProperty("OIT-7-1-1")
    private String OIT_7_1_1; // 是否对患者进行宣教
    public String getOIT_7_1_1() {  return this.OIT_7_1_1;}
    @JsonProperty("OIT-7-1-1")
    public void setOIT_7_1_1(final String OIT_7_1_1) { this.OIT_7_1_1=OIT_7_1_1;}
    @Column(name = "OIT_7_1_2")
    @JsonProperty("OIT-7-1-2")
    private String OIT_7_1_2; // 术前告知患者治疗流程
    public String getOIT_7_1_2() {  return this.OIT_7_1_2;}
    @JsonProperty("OIT-7-1-2")
    public void setOIT_7_1_2(final String OIT_7_1_2) { this.OIT_7_1_2=OIT_7_1_2;}
    @Column(name = "OIT_7_1_3")
    @JsonProperty("OIT-7-1-3")
    private String OIT_7_1_3; // 术前告知患者手术风险
    public String getOIT_7_1_3() {  return this.OIT_7_1_3;}
    @JsonProperty("OIT-7-1-3")
    public void setOIT_7_1_3(final String OIT_7_1_3) { this.OIT_7_1_3=OIT_7_1_3;}
    @Column(name = "OIT_7_1_4")
    @JsonProperty("OIT-7-1-4")
    private String OIT_7_1_4; // 术后告知患者术后注意事项
    public String getOIT_7_1_4() {  return this.OIT_7_1_4;}
    @JsonProperty("OIT-7-1-4")
    public void setOIT_7_1_4(final String OIT_7_1_4) { this.OIT_7_1_4=OIT_7_1_4;}
    @Column(name = "OIT_7_1_5")
    @JsonProperty("OIT-7-1-5")
    private String OIT_7_1_5; // 告知患者种植戴牙后注意事项
    public String getOIT_7_1_5() {  return this.OIT_7_1_5;}
    @JsonProperty("OIT-7-1-5")
    public void setOIT_7_1_5(final String OIT_7_1_5) { this.OIT_7_1_5=OIT_7_1_5;}
    @Column(name = "CM_3_1")
    @JsonProperty("CM-3-1")
    private String CM_3_1; // 手术野皮肤准备常用方法的选择
    public String getCM_3_1() {  return this.CM_3_1;}
    @JsonProperty("CM-3-1")
    public void setCM_3_1(final String CM_3_1) { this.CM_3_1=CM_3_1;}
    @Column(name = "OIT_8_1_2")
    @JsonProperty("OIT-8-1-2")
    private String OIT_8_1_2; // 使用微创缝线
    public String getOIT_8_1_2() {  return this.OIT_8_1_2;}
    @JsonProperty("OIT-8-1-2")
    public void setOIT_8_1_2(final String OIT_8_1_2) { this.OIT_8_1_2=OIT_8_1_2;}
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
    @Column(name = "OIT_9_1_1")
    @JsonProperty("OIT-9-1-1")
    private String OIT_9_1_1; // 评价日期
    public String getOIT_9_1_1() {  return this.OIT_9_1_1;}
    @JsonProperty("OIT-9-1-1")
    public void setOIT_9_1_1(final String OIT_9_1_1) { this.OIT_9_1_1=OIT_9_1_1;}
    @Column(name = "OIT_9_1_2")
    @JsonProperty("OIT-9-1-2")
    private String OIT_9_1_2; // 种植成功评价标准
    public String getOIT_9_1_2() {  return this.OIT_9_1_2;}
    @JsonProperty("OIT-9-1-2")
    public void setOIT_9_1_2(final String OIT_9_1_2) { this.OIT_9_1_2=OIT_9_1_2;}
    @Column(name = "CM_6_1")
    @JsonProperty("CM-6-1")
    private String CM_6_1; // 门诊或住院总费用
    public String getCM_6_1() {  return this.CM_6_1;}
    @JsonProperty("CM-6-1")
    public void setCM_6_1(final String CM_6_1) { this.CM_6_1=CM_6_1;}
    @Column(name = "OIT_10_1_1")
    @JsonProperty("OIT-10-1-1")
    private String OIT_10_1_1; // 其中：手术治疗费用
    public String getOIT_10_1_1() {  return this.OIT_10_1_1;}
    @JsonProperty("OIT-10-1-1")
    public void setOIT_10_1_1(final String OIT_10_1_1) { this.OIT_10_1_1=OIT_10_1_1;}
    @Column(name = "OIT_10_1_2")
    @JsonProperty("OIT-10-1-2")
    private String OIT_10_1_2; // 其中：药费
    public String getOIT_10_1_2() {  return this.OIT_10_1_2;}
    @JsonProperty("OIT-10-1-2")
    public void setOIT_10_1_2(final String OIT_10_1_2) { this.OIT_10_1_2=OIT_10_1_2;}
    @Column(name = "OIT_10_1_3")
    @JsonProperty("OIT-10-1-3")
    private String OIT_10_1_3; // 其中：种植体费用
    public String getOIT_10_1_3() {  return this.OIT_10_1_3;}
    @JsonProperty("OIT-10-1-3")
    public void setOIT_10_1_3(final String OIT_10_1_3) { this.OIT_10_1_3=OIT_10_1_3;}
}