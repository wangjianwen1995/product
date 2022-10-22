package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要手术ICD-9-CM-3编码：：39.73，39.78，39.71的手术出院患者。
*/
@ApiModel(value = "54信息")
@Entity
@Table(name = "sd_info_EAR")
public class SdInfoEAR implements Serializable {
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
    @Column(name = "CM_0_1_6")
    @JsonProperty("CM-0-1-6")
    private String CM_0_1_6; // 患者年龄是否大于等于18岁
    public String getCM_0_1_6() {  return this.CM_0_1_6;}
    @JsonProperty("CM-0-1-6")
    public void setCM_0_1_6(final String CM_0_1_6) { this.CM_0_1_6=CM_0_1_6;}
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard; // 患者身份证号
    public String getIDCard() {  return this.IDCard;}
    @JsonProperty("IDCard")
    public void setIDCard(final String IDCard) { this.IDCard=IDCard;}
    @Column(name = "EAR_0_1_4_1")
    @JsonProperty("EAR-0-1-4-1")
    private String EAR_0_1_4_1; // 胸主动脉/腹主动脉 腔内修复术 ICD-9-CM-3 四位亚目编码与名称选择
    public String getEAR_0_1_4_1() {  return this.EAR_0_1_4_1;}
    @JsonProperty("EAR-0-1-4-1")
    public void setEAR_0_1_4_1(final String EAR_0_1_4_1) { this.EAR_0_1_4_1=EAR_0_1_4_1;}
    @Column(name = "EAR_0_1_4_3")
    @JsonProperty("EAR-0-1-4-3")
    private String EAR_0_1_4_3; // 胸主动脉主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getEAR_0_1_4_3() {  return this.EAR_0_1_4_3;}
    @JsonProperty("EAR-0-1-4-3")
    public void setEAR_0_1_4_3(final String EAR_0_1_4_3) { this.EAR_0_1_4_3=EAR_0_1_4_3;}
    @Column(name = "EAR_0_1_4_4")
    @JsonProperty("EAR-0-1-4-4")
    private String EAR_0_1_4_4; // 其他胸主动脉主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getEAR_0_1_4_4() {  return this.EAR_0_1_4_4;}
    @JsonProperty("EAR-0-1-4-4")
    public void setEAR_0_1_4_4(final String EAR_0_1_4_4) { this.EAR_0_1_4_4=EAR_0_1_4_4;}
    @Column(name = "EAR_0_1_4_8")
    @JsonProperty("EAR-0-1-4-8")
    private String EAR_0_1_4_8; // 胸主动脉主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getEAR_0_1_4_8() {  return this.EAR_0_1_4_8;}
    @JsonProperty("EAR-0-1-4-8")
    public void setEAR_0_1_4_8(final String EAR_0_1_4_8) { this.EAR_0_1_4_8=EAR_0_1_4_8;}
    @Column(name = "EAR_0_1_4_9")
    @JsonProperty("EAR-0-1-4-9")
    private String EAR_0_1_4_9; // 其他胸主动脉主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getEAR_0_1_4_9() {  return this.EAR_0_1_4_9;}
    @JsonProperty("EAR-0-1-4-9")
    public void setEAR_0_1_4_9(final String EAR_0_1_4_9) { this.EAR_0_1_4_9=EAR_0_1_4_9;}
    @Column(name = "EAR_0_1_4_5")
    @JsonProperty("EAR-0-1-4-5")
    private String EAR_0_1_4_5; // 腹主动脉主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getEAR_0_1_4_5() {  return this.EAR_0_1_4_5;}
    @JsonProperty("EAR-0-1-4-5")
    public void setEAR_0_1_4_5(final String EAR_0_1_4_5) { this.EAR_0_1_4_5=EAR_0_1_4_5;}
    @Column(name = "EAR_0_1_4_6")
    @JsonProperty("EAR-0-1-4-6")
    private String EAR_0_1_4_6; // 其他腹主动脉主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getEAR_0_1_4_6() {  return this.EAR_0_1_4_6;}
    @JsonProperty("EAR-0-1-4-6")
    public void setEAR_0_1_4_6(final String EAR_0_1_4_6) { this.EAR_0_1_4_6=EAR_0_1_4_6;}
    @Column(name = "EAR_0_1_4_10")
    @JsonProperty("EAR-0-1-4-10")
    private String EAR_0_1_4_10; // 腹主动脉主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getEAR_0_1_4_10() {  return this.EAR_0_1_4_10;}
    @JsonProperty("EAR-0-1-4-10")
    public void setEAR_0_1_4_10(final String EAR_0_1_4_10) { this.EAR_0_1_4_10=EAR_0_1_4_10;}
    @Column(name = "EAR_0_1_4_11")
    @JsonProperty("EAR-0-1-4-11")
    private String EAR_0_1_4_11; // 其他腹主动脉主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getEAR_0_1_4_11() {  return this.EAR_0_1_4_11;}
    @JsonProperty("EAR-0-1-4-11")
    public void setEAR_0_1_4_11(final String EAR_0_1_4_11) { this.EAR_0_1_4_11=EAR_0_1_4_11;}
    @Column(name = "CM_0_1_3_1")
    @JsonProperty("CM-0-1-3-1")
    private String CM_0_1_3_1; // 主要诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "EAR_0_1_3_1")
    @JsonProperty("EAR-0-1-3-1")
    private String EAR_0_1_3_1; // 其他主要诊断ICD-10四位亚目编码与名称
    public String getEAR_0_1_3_1() {  return this.EAR_0_1_3_1;}
    @JsonProperty("EAR-0-1-3-1")
    public void setEAR_0_1_3_1(final String EAR_0_1_3_1) { this.EAR_0_1_3_1=EAR_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "EAR_0_1_3_2")
    @JsonProperty("EAR-0-1-3-2")
    private String EAR_0_1_3_2; // 其他主要诊断ICD-10六位临床扩展编码与名称
    public String getEAR_0_1_3_2() {  return this.EAR_0_1_3_2;}
    @JsonProperty("EAR-0-1-3-2")
    public void setEAR_0_1_3_2(final String EAR_0_1_3_2) { this.EAR_0_1_3_2=EAR_0_1_3_2;}
    @Column(name = "EAR_0_4_1")
    @JsonProperty("EAR-0-4-1")
    private String EAR_0_4_1; // 是否手术前合并糖尿病
    public String getEAR_0_4_1() {  return this.EAR_0_4_1;}
    @JsonProperty("EAR-0-4-1")
    public void setEAR_0_4_1(final String EAR_0_4_1) { this.EAR_0_4_1=EAR_0_4_1;}
    @Column(name = "EAR_0_4_2")
    @JsonProperty("EAR-0-4-2")
    private String EAR_0_4_2; // 合并糖尿病ICD-10四位临床编码与名称
    public String getEAR_0_4_2() {  return this.EAR_0_4_2;}
    @JsonProperty("EAR-0-4-2")
    public void setEAR_0_4_2(final String EAR_0_4_2) { this.EAR_0_4_2=EAR_0_4_2;}
    @Column(name = "EAR_0_4_3")
    @JsonProperty("EAR-0-4-3")
    private String EAR_0_4_3; // 是否手术前合并高血压
    public String getEAR_0_4_3() {  return this.EAR_0_4_3;}
    @JsonProperty("EAR-0-4-3")
    public void setEAR_0_4_3(final String EAR_0_4_3) { this.EAR_0_4_3=EAR_0_4_3;}
    @Column(name = "EAR_0_4_4")
    @JsonProperty("EAR-0-4-4")
    private String EAR_0_4_4; // 合并高血压ICD-10四位临床编码与名称
    public String getEAR_0_4_4() {  return this.EAR_0_4_4;}
    @JsonProperty("EAR-0-4-4")
    public void setEAR_0_4_4(final String EAR_0_4_4) { this.EAR_0_4_4=EAR_0_4_4;}
    @Column(name = "EAR_0_4_5")
    @JsonProperty("EAR-0-4-5")
    private String EAR_0_4_5; // 是否手术前合并高脂血症
    public String getEAR_0_4_5() {  return this.EAR_0_4_5;}
    @JsonProperty("EAR-0-4-5")
    public void setEAR_0_4_5(final String EAR_0_4_5) { this.EAR_0_4_5=EAR_0_4_5;}
    @Column(name = "EAR_0_4_6")
    @JsonProperty("EAR-0-4-6")
    private String EAR_0_4_6; // 合并高脂血症ICD-10四位临床编码与名称
    public String getEAR_0_4_6() {  return this.EAR_0_4_6;}
    @JsonProperty("EAR-0-4-6")
    public void setEAR_0_4_6(final String EAR_0_4_6) { this.EAR_0_4_6=EAR_0_4_6;}
    @Column(name = "EAR_0_4_7")
    @JsonProperty("EAR-0-4-7")
    private String EAR_0_4_7; // 是否手术前合并冠状动脉性心脏病
    public String getEAR_0_4_7() {  return this.EAR_0_4_7;}
    @JsonProperty("EAR-0-4-7")
    public void setEAR_0_4_7(final String EAR_0_4_7) { this.EAR_0_4_7=EAR_0_4_7;}
    @Column(name = "EAR_0_4_8")
    @JsonProperty("EAR-0-4-8")
    private String EAR_0_4_8; // 合并冠状动脉性心脏病ICD-10四位临床编码与名称
    public String getEAR_0_4_8() {  return this.EAR_0_4_8;}
    @JsonProperty("EAR-0-4-8")
    public void setEAR_0_4_8(final String EAR_0_4_8) { this.EAR_0_4_8=EAR_0_4_8;}
    @Column(name = "EAR_0_4_9")
    @JsonProperty("EAR-0-4-9")
    private String EAR_0_4_9; // 是否手术前既往发生过脑血管事件
    public String getEAR_0_4_9() {  return this.EAR_0_4_9;}
    @JsonProperty("EAR-0-4-9")
    public void setEAR_0_4_9(final String EAR_0_4_9) { this.EAR_0_4_9=EAR_0_4_9;}
    @Column(name = "EAR_0_4_10")
    @JsonProperty("EAR-0-4-10")
    private String EAR_0_4_10; // 既往发生过脑血管事件ICD-10四位临床编码与名称
    public String getEAR_0_4_10() {  return this.EAR_0_4_10;}
    @JsonProperty("EAR-0-4-10")
    public void setEAR_0_4_10(final String EAR_0_4_10) { this.EAR_0_4_10=EAR_0_4_10;}
    @Column(name = "EAR_0_4_11")
    @JsonProperty("EAR-0-4-11")
    private String EAR_0_4_11; // 是否手术前合并慢性阻塞性肺疾病
    public String getEAR_0_4_11() {  return this.EAR_0_4_11;}
    @JsonProperty("EAR-0-4-11")
    public void setEAR_0_4_11(final String EAR_0_4_11) { this.EAR_0_4_11=EAR_0_4_11;}
    @Column(name = "EAR_0_4_12")
    @JsonProperty("EAR-0-4-12")
    private String EAR_0_4_12; // 合并慢性阻塞性肺疾病ICD-10四位临床编码与名称
    public String getEAR_0_4_12() {  return this.EAR_0_4_12;}
    @JsonProperty("EAR-0-4-12")
    public void setEAR_0_4_12(final String EAR_0_4_12) { this.EAR_0_4_12=EAR_0_4_12;}
    @Column(name = "EAR_0_4_13")
    @JsonProperty("EAR-0-4-13")
    private String EAR_0_4_13; // 是否手术前合并肾功能不全
    public String getEAR_0_4_13() {  return this.EAR_0_4_13;}
    @JsonProperty("EAR-0-4-13")
    public void setEAR_0_4_13(final String EAR_0_4_13) { this.EAR_0_4_13=EAR_0_4_13;}
    @Column(name = "EAR_0_4_14")
    @JsonProperty("EAR-0-4-14")
    private String EAR_0_4_14; // 合并肾功能不全ICD-10四位临床编码与名称
    public String getEAR_0_4_14() {  return this.EAR_0_4_14;}
    @JsonProperty("EAR-0-4-14")
    public void setEAR_0_4_14(final String EAR_0_4_14) { this.EAR_0_4_14=EAR_0_4_14;}
    @Column(name = "EAR_0_4_15")
    @JsonProperty("EAR-0-4-15")
    private String EAR_0_4_15; // 是否合并遗传性主动脉疾病
    public String getEAR_0_4_15() {  return this.EAR_0_4_15;}
    @JsonProperty("EAR-0-4-15")
    public void setEAR_0_4_15(final String EAR_0_4_15) { this.EAR_0_4_15=EAR_0_4_15;}
    @Column(name = "EAR_0_4_16")
    @JsonProperty("EAR-0-4-16")
    private String EAR_0_4_16; // 合并遗传性主动脉疾病选择
    public String getEAR_0_4_16() {  return this.EAR_0_4_16;}
    @JsonProperty("EAR-0-4-16")
    public void setEAR_0_4_16(final String EAR_0_4_16) { this.EAR_0_4_16=EAR_0_4_16;}
    @Column(name = "EAR_0_4_16_1")
    @JsonProperty("EAR-0-4-16-1")
    private String EAR_0_4_16_1; // Marfan综合征 ICD-10六位临床编码与名称
    public String getEAR_0_4_16_1() {  return this.EAR_0_4_16_1;}
    @JsonProperty("EAR-0-4-16-1")
    public void setEAR_0_4_16_1(final String EAR_0_4_16_1) { this.EAR_0_4_16_1=EAR_0_4_16_1;}
    @Column(name = "EAR_0_4_16_2")
    @JsonProperty("EAR-0-4-16-2")
    private String EAR_0_4_16_2; // Ehlers-Danlos综合征 ICD-10六位临床编码与名称
    public String getEAR_0_4_16_2() {  return this.EAR_0_4_16_2;}
    @JsonProperty("EAR-0-4-16-2")
    public void setEAR_0_4_16_2(final String EAR_0_4_16_2) { this.EAR_0_4_16_2=EAR_0_4_16_2;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为EAR出院后30天内重复住院
    public String getCM_0_1_5() {  return this.CM_0_1_5;}
    @JsonProperty("CM-0-1-5")
    public void setCM_0_1_5(final String CM_0_1_5) { this.CM_0_1_5=CM_0_1_5;}
    @Column(name = "EAR_0_1_6")
    @JsonProperty("EAR-0-1-6")
    private String EAR_0_1_6; // EAR的手术类别
    public String getEAR_0_1_6() {  return this.EAR_0_1_6;}
    @JsonProperty("EAR-0-1-6")
    public void setEAR_0_1_6(final String EAR_0_1_6) { this.EAR_0_1_6=EAR_0_1_6;}
    @Column(name = "EAR_0_1_8")
    @JsonProperty("EAR-0-1-8")
    private String EAR_0_1_8; // EAR的开展科室
    public String getEAR_0_1_8() {  return this.EAR_0_1_8;}
    @JsonProperty("EAR-0-1-8")
    public void setEAR_0_1_8(final String EAR_0_1_8) { this.EAR_0_1_8=EAR_0_1_8;}
    @Column(name = "EAR_0_1_9_1")
    @JsonProperty("EAR-0-1-9-1")
    private String EAR_0_1_9_1; // EAR手术是否为主动脉杂交手术的一部分
    public String getEAR_0_1_9_1() {  return this.EAR_0_1_9_1;}
    @JsonProperty("EAR-0-1-9-1")
    public void setEAR_0_1_9_1(final String EAR_0_1_9_1) { this.EAR_0_1_9_1=EAR_0_1_9_1;}
    @Column(name = "EAR_0_1_9_2")
    @JsonProperty("EAR-0-1-9-2")
    private String EAR_0_1_9_2; // 本次住院期间是否行其他非主动脉手术（不包括因术后并发症而实施的手术）
    public String getEAR_0_1_9_2() {  return this.EAR_0_1_9_2;}
    @JsonProperty("EAR-0-1-9-2")
    public void setEAR_0_1_9_2(final String EAR_0_1_9_2) { this.EAR_0_1_9_2=EAR_0_1_9_2;}
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
    private String CM_0_2_5_1; // 入住ICU/麻醉复苏室日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU/麻醉复苏室日期时间
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
    @Column(name = "EAR_1_5_1")
    @JsonProperty("EAR-1-5-1")
    private String EAR_1_5_1; // 术前全身状态（ASA）评估
    public String getEAR_1_5_1() {  return this.EAR_1_5_1;}
    @JsonProperty("EAR-1-5-1")
    public void setEAR_1_5_1(final String EAR_1_5_1) { this.EAR_1_5_1=EAR_1_5_1;}
    @Column(name = "EAR_1_5_2")
    @JsonProperty("EAR-1-5-2")
    private String EAR_1_5_2; // ASA分级
    public String getEAR_1_5_2() {  return this.EAR_1_5_2;}
    @JsonProperty("EAR-1-5-2")
    public void setEAR_1_5_2(final String EAR_1_5_2) { this.EAR_1_5_2=EAR_1_5_2;}
    @Column(name = "EAR_1_1_1")
    @JsonProperty("EAR-1-1-1")
    private String EAR_1_1_1; // 是否实施手术前的主动脉CTA
    public String getEAR_1_1_1() {  return this.EAR_1_1_1;}
    @JsonProperty("EAR-1-1-1")
    public void setEAR_1_1_1(final String EAR_1_1_1) { this.EAR_1_1_1=EAR_1_1_1;}
    @Column(name = "EAR_1_1_4")
    @JsonProperty("EAR-1-1-4")
    private String EAR_1_1_4; // 主动脉CTA检查日期时间
    public String getEAR_1_1_4() {  return this.EAR_1_1_4;}
    @JsonProperty("EAR-1-1-4")
    public void setEAR_1_1_4(final String EAR_1_1_4) { this.EAR_1_1_4=EAR_1_1_4;}
    @Column(name = "EAR_1_1_5")
    @JsonProperty("EAR-1-1-5")
    private String EAR_1_1_5; // 主动脉CTA影像学初步印象
    public String getEAR_1_1_5() {  return this.EAR_1_1_5;}
    @JsonProperty("EAR-1-1-5")
    public void setEAR_1_1_5(final String EAR_1_1_5) { this.EAR_1_1_5=EAR_1_1_5;}
    @Column(name = "EAR_1_1_5_1")
    @JsonProperty("EAR-1-1-5-1")
    private String EAR_1_1_5_1; // 主动脉夹层分型
    public String getEAR_1_1_5_1() {  return this.EAR_1_1_5_1;}
    @JsonProperty("EAR-1-1-5-1")
    public void setEAR_1_1_5_1(final String EAR_1_1_5_1) { this.EAR_1_1_5_1=EAR_1_1_5_1;}
    @Column(name = "EAR_1_1_5_2")
    @JsonProperty("EAR-1-1-5-2")
    private String EAR_1_1_5_2; // 是否有主动脉瘤最大直径记录
    public String getEAR_1_1_5_2() {  return this.EAR_1_1_5_2;}
    @JsonProperty("EAR-1-1-5-2")
    public void setEAR_1_1_5_2(final String EAR_1_1_5_2) { this.EAR_1_1_5_2=EAR_1_1_5_2;}
    @Column(name = "EAR_1_1_5_3")
    @JsonProperty("EAR-1-1-5-3")
    private String EAR_1_1_5_3; // 主动脉瘤最大直径(mm)
    public String getEAR_1_1_5_3() {  return this.EAR_1_1_5_3;}
    @JsonProperty("EAR-1-1-5-3")
    public void setEAR_1_1_5_3(final String EAR_1_1_5_3) { this.EAR_1_1_5_3=EAR_1_1_5_3;}
    @Column(name = "EAR_1_1_5_4")
    @JsonProperty("EAR-1-1-5-4")
    private String EAR_1_1_5_4; // 有无主动脉瘤破裂
    public String getEAR_1_1_5_4() {  return this.EAR_1_1_5_4;}
    @JsonProperty("EAR-1-1-5-4")
    public void setEAR_1_1_5_4(final String EAR_1_1_5_4) { this.EAR_1_1_5_4=EAR_1_1_5_4;}
    @Column(name = "EAR_1_1_6_1")
    @JsonProperty("EAR-1-1-6-1")
    private String EAR_1_1_6_1; // 主动脉瘤（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_1() {  return this.EAR_1_1_6_1;}
    @JsonProperty("EAR-1-1-6-1")
    public void setEAR_1_1_6_1(final String EAR_1_1_6_1) { this.EAR_1_1_6_1=EAR_1_1_6_1;}
    @Column(name = "EAR_1_1_6_2")
    @JsonProperty("EAR-1-1-6-2")
    private String EAR_1_1_6_2; // 主动脉瘤（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_2() {  return this.EAR_1_1_6_2;}
    @JsonProperty("EAR-1-1-6-2")
    public void setEAR_1_1_6_2(final String EAR_1_1_6_2) { this.EAR_1_1_6_2=EAR_1_1_6_2;}
    @Column(name = "EAR_1_1_5_5")
    @JsonProperty("EAR-1-1-5-5")
    private String EAR_1_1_5_5; // 是否有主动脉溃疡深度记录
    public String getEAR_1_1_5_5() {  return this.EAR_1_1_5_5;}
    @JsonProperty("EAR-1-1-5-5")
    public void setEAR_1_1_5_5(final String EAR_1_1_5_5) { this.EAR_1_1_5_5=EAR_1_1_5_5;}
    @Column(name = "EAR_1_1_5_6")
    @JsonProperty("EAR-1-1-5-6")
    private String EAR_1_1_5_6; // 主动脉溃疡深度(mm)
    public String getEAR_1_1_5_6() {  return this.EAR_1_1_5_6;}
    @JsonProperty("EAR-1-1-5-6")
    public void setEAR_1_1_5_6(final String EAR_1_1_5_6) { this.EAR_1_1_5_6=EAR_1_1_5_6;}
    @Column(name = "EAR_1_1_5_7")
    @JsonProperty("EAR-1-1-5-7")
    private String EAR_1_1_5_7; // 是否有主动脉溃疡宽度记录
    public String getEAR_1_1_5_7() {  return this.EAR_1_1_5_7;}
    @JsonProperty("EAR-1-1-5-7")
    public void setEAR_1_1_5_7(final String EAR_1_1_5_7) { this.EAR_1_1_5_7=EAR_1_1_5_7;}
    @Column(name = "EAR_1_1_5_8")
    @JsonProperty("EAR-1-1-5-8")
    private String EAR_1_1_5_8; // 主动脉溃疡宽度(mm)
    public String getEAR_1_1_5_8() {  return this.EAR_1_1_5_8;}
    @JsonProperty("EAR-1-1-5-8")
    public void setEAR_1_1_5_8(final String EAR_1_1_5_8) { this.EAR_1_1_5_8=EAR_1_1_5_8;}
    @Column(name = "EAR_1_1_6_3")
    @JsonProperty("EAR-1-1-6-3")
    private String EAR_1_1_6_3; // 主动脉溃疡（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_3() {  return this.EAR_1_1_6_3;}
    @JsonProperty("EAR-1-1-6-3")
    public void setEAR_1_1_6_3(final String EAR_1_1_6_3) { this.EAR_1_1_6_3=EAR_1_1_6_3;}
    @Column(name = "EAR_1_1_6_4")
    @JsonProperty("EAR-1-1-6-4")
    private String EAR_1_1_6_4; // 主动脉溃疡（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_4() {  return this.EAR_1_1_6_4;}
    @JsonProperty("EAR-1-1-6-4")
    public void setEAR_1_1_6_4(final String EAR_1_1_6_4) { this.EAR_1_1_6_4=EAR_1_1_6_4;}
    @Column(name = "EAR_1_1_5_9")
    @JsonProperty("EAR-1-1-5-9")
    private String EAR_1_1_5_9; // 是否有主动脉壁间血肿最大厚度记录
    public String getEAR_1_1_5_9() {  return this.EAR_1_1_5_9;}
    @JsonProperty("EAR-1-1-5-9")
    public void setEAR_1_1_5_9(final String EAR_1_1_5_9) { this.EAR_1_1_5_9=EAR_1_1_5_9;}
    @Column(name = "EAR_1_1_5_10")
    @JsonProperty("EAR-1-1-5-10")
    private String EAR_1_1_5_10; // 主动脉壁间血肿最大厚度(mm)
    public String getEAR_1_1_5_10() {  return this.EAR_1_1_5_10;}
    @JsonProperty("EAR-1-1-5-10")
    public void setEAR_1_1_5_10(final String EAR_1_1_5_10) { this.EAR_1_1_5_10=EAR_1_1_5_10;}
    @Column(name = "EAR_1_1_6_5")
    @JsonProperty("EAR-1-1-6-5")
    private String EAR_1_1_6_5; // 主动脉壁间血肿（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_5() {  return this.EAR_1_1_6_5;}
    @JsonProperty("EAR-1-1-6-5")
    public void setEAR_1_1_6_5(final String EAR_1_1_6_5) { this.EAR_1_1_6_5=EAR_1_1_6_5;}
    @Column(name = "EAR_1_1_6_6")
    @JsonProperty("EAR-1-1-6-6")
    private String EAR_1_1_6_6; // 主动脉壁间血肿（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_6() {  return this.EAR_1_1_6_6;}
    @JsonProperty("EAR-1-1-6-6")
    public void setEAR_1_1_6_6(final String EAR_1_1_6_6) { this.EAR_1_1_6_6=EAR_1_1_6_6;}
    @Column(name = "EAR_1_1_6_7")
    @JsonProperty("EAR-1-1-6-7")
    private String EAR_1_1_6_7; // 主动脉假性动脉瘤（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_7() {  return this.EAR_1_1_6_7;}
    @JsonProperty("EAR-1-1-6-7")
    public void setEAR_1_1_6_7(final String EAR_1_1_6_7) { this.EAR_1_1_6_7=EAR_1_1_6_7;}
    @Column(name = "EAR_1_1_6_8")
    @JsonProperty("EAR-1-1-6-8")
    private String EAR_1_1_6_8; // 主动脉假性动脉瘤（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_8() {  return this.EAR_1_1_6_8;}
    @JsonProperty("EAR-1-1-6-8")
    public void setEAR_1_1_6_8(final String EAR_1_1_6_8) { this.EAR_1_1_6_8=EAR_1_1_6_8;}
    @Column(name = "EAR_1_1_5_11")
    @JsonProperty("EAR-1-1-5-11")
    private String EAR_1_1_5_11; // 是否有主动脉缩窄部位最小直径记录
    public String getEAR_1_1_5_11() {  return this.EAR_1_1_5_11;}
    @JsonProperty("EAR-1-1-5-11")
    public void setEAR_1_1_5_11(final String EAR_1_1_5_11) { this.EAR_1_1_5_11=EAR_1_1_5_11;}
    @Column(name = "EAR_1_1_5_12")
    @JsonProperty("EAR-1-1-5-12")
    private String EAR_1_1_5_12; // 主动脉缩窄部位最小直径(mm)
    public String getEAR_1_1_5_12() {  return this.EAR_1_1_5_12;}
    @JsonProperty("EAR-1-1-5-12")
    public void setEAR_1_1_5_12(final String EAR_1_1_5_12) { this.EAR_1_1_5_12=EAR_1_1_5_12;}
    @Column(name = "EAR_1_1_6_9")
    @JsonProperty("EAR-1-1-6-9")
    private String EAR_1_1_6_9; // 主动脉缩窄（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_9() {  return this.EAR_1_1_6_9;}
    @JsonProperty("EAR-1-1-6-9")
    public void setEAR_1_1_6_9(final String EAR_1_1_6_9) { this.EAR_1_1_6_9=EAR_1_1_6_9;}
    @Column(name = "EAR_1_1_6_10")
    @JsonProperty("EAR-1-1-6-10")
    private String EAR_1_1_6_10; // 主动脉缩窄（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_10() {  return this.EAR_1_1_6_10;}
    @JsonProperty("EAR-1-1-6-10")
    public void setEAR_1_1_6_10(final String EAR_1_1_6_10) { this.EAR_1_1_6_10=EAR_1_1_6_10;}
    @Column(name = "EAR_1_1_6_11")
    @JsonProperty("EAR-1-1-6-11")
    private String EAR_1_1_6_11; // 主动脉闭塞（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_11() {  return this.EAR_1_1_6_11;}
    @JsonProperty("EAR-1-1-6-11")
    public void setEAR_1_1_6_11(final String EAR_1_1_6_11) { this.EAR_1_1_6_11=EAR_1_1_6_11;}
    @Column(name = "EAR_1_1_6_12")
    @JsonProperty("EAR-1-1-6-12")
    private String EAR_1_1_6_12; // 主动脉闭塞（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_12() {  return this.EAR_1_1_6_12;}
    @JsonProperty("EAR-1-1-6-12")
    public void setEAR_1_1_6_12(final String EAR_1_1_6_12) { this.EAR_1_1_6_12=EAR_1_1_6_12;}
    @Column(name = "EAR_1_1_6_13")
    @JsonProperty("EAR-1-1-6-13")
    private String EAR_1_1_6_13; // 主动脉损伤（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_13() {  return this.EAR_1_1_6_13;}
    @JsonProperty("EAR-1-1-6-13")
    public void setEAR_1_1_6_13(final String EAR_1_1_6_13) { this.EAR_1_1_6_13=EAR_1_1_6_13;}
    @Column(name = "EAR_1_1_6_14")
    @JsonProperty("EAR-1-1-6-14")
    private String EAR_1_1_6_14; // 主动脉损伤（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_14() {  return this.EAR_1_1_6_14;}
    @JsonProperty("EAR-1-1-6-14")
    public void setEAR_1_1_6_14(final String EAR_1_1_6_14) { this.EAR_1_1_6_14=EAR_1_1_6_14;}
    @Column(name = "EAR_1_1_5_13")
    @JsonProperty("EAR-1-1-5-13")
    private String EAR_1_1_5_13; // 其他主动脉疾病
    public String getEAR_1_1_5_13() {  return this.EAR_1_1_5_13;}
    @JsonProperty("EAR-1-1-5-13")
    public void setEAR_1_1_5_13(final String EAR_1_1_5_13) { this.EAR_1_1_5_13=EAR_1_1_5_13;}
    @Column(name = "EAR_1_1_6_15")
    @JsonProperty("EAR-1-1-6-15")
    private String EAR_1_1_6_15; // 其他（主动脉病变）的累及部位（近端）
    public String getEAR_1_1_6_15() {  return this.EAR_1_1_6_15;}
    @JsonProperty("EAR-1-1-6-15")
    public void setEAR_1_1_6_15(final String EAR_1_1_6_15) { this.EAR_1_1_6_15=EAR_1_1_6_15;}
    @Column(name = "EAR_1_1_6_16")
    @JsonProperty("EAR-1-1-6-16")
    private String EAR_1_1_6_16; // 其他（主动脉病变）的累及部位（远端）
    public String getEAR_1_1_6_16() {  return this.EAR_1_1_6_16;}
    @JsonProperty("EAR-1-1-6-16")
    public void setEAR_1_1_6_16(final String EAR_1_1_6_16) { this.EAR_1_1_6_16=EAR_1_1_6_16;}
    @Column(name = "EAR_1_6_1")
    @JsonProperty("EAR-1-6-1")
    private String EAR_1_6_1; // 是否实施术前超声心动图(CDFA)检查
    public String getEAR_1_6_1() {  return this.EAR_1_6_1;}
    @JsonProperty("EAR-1-6-1")
    public void setEAR_1_6_1(final String EAR_1_6_1) { this.EAR_1_6_1=EAR_1_6_1;}
    @Column(name = "EAR_1_6_2")
    @JsonProperty("EAR-1-6-2")
    private String EAR_1_6_2; // 检查日期时间
    public String getEAR_1_6_2() {  return this.EAR_1_6_2;}
    @JsonProperty("EAR-1-6-2")
    public void setEAR_1_6_2(final String EAR_1_6_2) { this.EAR_1_6_2=EAR_1_6_2;}
    @Column(name = "EAR_1_6_3")
    @JsonProperty("EAR-1-6-3")
    private String EAR_1_6_3; // 左室舒张末内径 LVEDD(mm)
    public String getEAR_1_6_3() {  return this.EAR_1_6_3;}
    @JsonProperty("EAR-1-6-3")
    public void setEAR_1_6_3(final String EAR_1_6_3) { this.EAR_1_6_3=EAR_1_6_3;}
    @Column(name = "EAR_1_6_4")
    @JsonProperty("EAR-1-6-4")
    private String EAR_1_6_4; // 左室射血分（LVEF）测量值(%)
    public String getEAR_1_6_4() {  return this.EAR_1_6_4;}
    @JsonProperty("EAR-1-6-4")
    public void setEAR_1_6_4(final String EAR_1_6_4) { this.EAR_1_6_4=EAR_1_6_4;}
    @Column(name = "EAR_1_6_5")
    @JsonProperty("EAR-1-6-5")
    private String EAR_1_6_5; // 左室射血分数评估的分层
    public String getEAR_1_6_5() {  return this.EAR_1_6_5;}
    @JsonProperty("EAR-1-6-5")
    public void setEAR_1_6_5(final String EAR_1_6_5) { this.EAR_1_6_5=EAR_1_6_5;}
    @Column(name = "EAR_1_6_6")
    @JsonProperty("EAR-1-6-6")
    private String EAR_1_6_6; // 是否有心包积液
    public String getEAR_1_6_6() {  return this.EAR_1_6_6;}
    @JsonProperty("EAR-1-6-6")
    public void setEAR_1_6_6(final String EAR_1_6_6) { this.EAR_1_6_6=EAR_1_6_6;}
    @Column(name = "EAR_1_6_7")
    @JsonProperty("EAR-1-6-7")
    private String EAR_1_6_7; // 是否有室壁运动异常
    public String getEAR_1_6_7() {  return this.EAR_1_6_7;}
    @JsonProperty("EAR-1-6-7")
    public void setEAR_1_6_7(final String EAR_1_6_7) { this.EAR_1_6_7=EAR_1_6_7;}
    @Column(name = "EAR_1_6_8")
    @JsonProperty("EAR-1-6-8")
    private String EAR_1_6_8; // 术前实验室检查（填写本次住院期间首次检查的结果）
    public String getEAR_1_6_8() {  return this.EAR_1_6_8;}
    @JsonProperty("EAR-1-6-8")
    public void setEAR_1_6_8(final String EAR_1_6_8) { this.EAR_1_6_8=EAR_1_6_8;}
    @Column(name = "EAR_1_6_8_1")
    @JsonProperty("EAR-1-6-8-1")
    private String EAR_1_6_8_1; // 丙氨酸氨基转移酶(IU/L)
    public String getEAR_1_6_8_1() {  return this.EAR_1_6_8_1;}
    @JsonProperty("EAR-1-6-8-1")
    public void setEAR_1_6_8_1(final String EAR_1_6_8_1) { this.EAR_1_6_8_1=EAR_1_6_8_1;}
    @Column(name = "EAR_1_6_8_2")
    @JsonProperty("EAR-1-6-8-2")
    private String EAR_1_6_8_2; // 天门冬氨酸氨基转移酶(IU/L)
    public String getEAR_1_6_8_2() {  return this.EAR_1_6_8_2;}
    @JsonProperty("EAR-1-6-8-2")
    public void setEAR_1_6_8_2(final String EAR_1_6_8_2) { this.EAR_1_6_8_2=EAR_1_6_8_2;}
    @Column(name = "EAR_1_6_8_3")
    @JsonProperty("EAR-1-6-8-3")
    private String EAR_1_6_8_3; // 肌酐(umol/L)
    public String getEAR_1_6_8_3() {  return this.EAR_1_6_8_3;}
    @JsonProperty("EAR-1-6-8-3")
    public void setEAR_1_6_8_3(final String EAR_1_6_8_3) { this.EAR_1_6_8_3=EAR_1_6_8_3;}
    @Column(name = "EAR_1_6_8_4")
    @JsonProperty("EAR-1-6-8-4")
    private String EAR_1_6_8_4; // 尿素氮(mmol/L)
    public String getEAR_1_6_8_4() {  return this.EAR_1_6_8_4;}
    @JsonProperty("EAR-1-6-8-4")
    public void setEAR_1_6_8_4(final String EAR_1_6_8_4) { this.EAR_1_6_8_4=EAR_1_6_8_4;}
    @Column(name = "EAR_1_6_8_5")
    @JsonProperty("EAR-1-6-8-5")
    private String EAR_1_6_8_5; // 高敏肌钙蛋白(ng/ml)
    public String getEAR_1_6_8_5() {  return this.EAR_1_6_8_5;}
    @JsonProperty("EAR-1-6-8-5")
    public void setEAR_1_6_8_5(final String EAR_1_6_8_5) { this.EAR_1_6_8_5=EAR_1_6_8_5;}
    @Column(name = "EAR_1_6_8_6")
    @JsonProperty("EAR-1-6-8-6")
    private String EAR_1_6_8_6; // 白细胞总数(10⁹/L)
    public String getEAR_1_6_8_6() {  return this.EAR_1_6_8_6;}
    @JsonProperty("EAR-1-6-8-6")
    public void setEAR_1_6_8_6(final String EAR_1_6_8_6) { this.EAR_1_6_8_6=EAR_1_6_8_6;}
    @Column(name = "EAR_1_6_8_7")
    @JsonProperty("EAR-1-6-8-7")
    private String EAR_1_6_8_7; // 红细胞总数(10¹²/L)
    public String getEAR_1_6_8_7() {  return this.EAR_1_6_8_7;}
    @JsonProperty("EAR-1-6-8-7")
    public void setEAR_1_6_8_7(final String EAR_1_6_8_7) { this.EAR_1_6_8_7=EAR_1_6_8_7;}
    @Column(name = "EAR_1_6_8_8")
    @JsonProperty("EAR-1-6-8-8")
    private String EAR_1_6_8_8; // 血红蛋白浓度(g/L)
    public String getEAR_1_6_8_8() {  return this.EAR_1_6_8_8;}
    @JsonProperty("EAR-1-6-8-8")
    public void setEAR_1_6_8_8(final String EAR_1_6_8_8) { this.EAR_1_6_8_8=EAR_1_6_8_8;}
    @Column(name = "EAR_1_6_8_9")
    @JsonProperty("EAR-1-6-8-9")
    private String EAR_1_6_8_9; // 血小板总数(10⁹/L)
    public String getEAR_1_6_8_9() {  return this.EAR_1_6_8_9;}
    @JsonProperty("EAR-1-6-8-9")
    public void setEAR_1_6_8_9(final String EAR_1_6_8_9) { this.EAR_1_6_8_9=EAR_1_6_8_9;}
    @Column(name = "EAR_1_6_8_10")
    @JsonProperty("EAR-1-6-8-10")
    private String EAR_1_6_8_10; // 白蛋白(g/L)
    public String getEAR_1_6_8_10() {  return this.EAR_1_6_8_10;}
    @JsonProperty("EAR-1-6-8-10")
    public void setEAR_1_6_8_10(final String EAR_1_6_8_10) { this.EAR_1_6_8_10=EAR_1_6_8_10;}
    @Column(name = "EAR_1_6_8_11")
    @JsonProperty("EAR-1-6-8-11")
    private String EAR_1_6_8_11; // 甘油三酯(mmol/L)
    public String getEAR_1_6_8_11() {  return this.EAR_1_6_8_11;}
    @JsonProperty("EAR-1-6-8-11")
    public void setEAR_1_6_8_11(final String EAR_1_6_8_11) { this.EAR_1_6_8_11=EAR_1_6_8_11;}
    @Column(name = "EAR_1_6_8_12")
    @JsonProperty("EAR-1-6-8-12")
    private String EAR_1_6_8_12; // 总胆固醇(mmol/L)
    public String getEAR_1_6_8_12() {  return this.EAR_1_6_8_12;}
    @JsonProperty("EAR-1-6-8-12")
    public void setEAR_1_6_8_12(final String EAR_1_6_8_12) { this.EAR_1_6_8_12=EAR_1_6_8_12;}
    @Column(name = "EAR_1_6_8_13")
    @JsonProperty("EAR-1-6-8-13")
    private String EAR_1_6_8_13; // 低密度脂蛋白胆固醇(mmol/L)
    public String getEAR_1_6_8_13() {  return this.EAR_1_6_8_13;}
    @JsonProperty("EAR-1-6-8-13")
    public void setEAR_1_6_8_13(final String EAR_1_6_8_13) { this.EAR_1_6_8_13=EAR_1_6_8_13;}
    @Column(name = "EAR_2_4_1")
    @JsonProperty("EAR-2-4-1")
    private String EAR_2_4_1; // 是否有β-受体阻滞剂禁忌证
    public String getEAR_2_4_1() {  return this.EAR_2_4_1;}
    @JsonProperty("EAR-2-4-1")
    public void setEAR_2_4_1(final String EAR_2_4_1) { this.EAR_2_4_1=EAR_2_4_1;}
    @Column(name = "EAR_2_4_2")
    @JsonProperty("EAR-2-4-2")
    private String EAR_2_4_2; // β-受体阻滞剂禁忌证的选择
    public String getEAR_2_4_2() {  return this.EAR_2_4_2;}
    @JsonProperty("EAR-2-4-2")
    public void setEAR_2_4_2(final String EAR_2_4_2) { this.EAR_2_4_2=EAR_2_4_2;}
    @Column(name = "EAR_2_4_2_1")
    @JsonProperty("EAR-2-4-2-1")
    private String EAR_2_4_2_1; // β-受体阻滞剂其他禁忌证
    public String getEAR_2_4_2_1() {  return this.EAR_2_4_2_1;}
    @JsonProperty("EAR-2-4-2-1")
    public void setEAR_2_4_2_1(final String EAR_2_4_2_1) { this.EAR_2_4_2_1=EAR_2_4_2_1;}
    @Column(name = "EAR_2_4_3")
    @JsonProperty("EAR-2-4-3")
    private String EAR_2_4_3; // β-受体阻滞剂相对禁忌证的选择
    public String getEAR_2_4_3() {  return this.EAR_2_4_3;}
    @JsonProperty("EAR-2-4-3")
    public void setEAR_2_4_3(final String EAR_2_4_3) { this.EAR_2_4_3=EAR_2_4_3;}
    @Column(name = "EAR_2_4_3_1")
    @JsonProperty("EAR-2-4-3-1")
    private String EAR_2_4_3_1; // β-受体阻滞剂其他相对禁忌证
    public String getEAR_2_4_3_1() {  return this.EAR_2_4_3_1;}
    @JsonProperty("EAR-2-4-3-1")
    public void setEAR_2_4_3_1(final String EAR_2_4_3_1) { this.EAR_2_4_3_1=EAR_2_4_3_1;}
    @Column(name = "EAR_2_4_4")
    @JsonProperty("EAR-2-4-4")
    private String EAR_2_4_4; // 是否在术前使用β受体阻滞剂
    public String getEAR_2_4_4() {  return this.EAR_2_4_4;}
    @JsonProperty("EAR-2-4-4")
    public void setEAR_2_4_4(final String EAR_2_4_4) { this.EAR_2_4_4=EAR_2_4_4;}
    @Column(name = "EAR_2_4_5")
    @JsonProperty("EAR-2-4-5")
    private String EAR_2_4_5; // 使用β-受体阻滞剂的选择
    public String getEAR_2_4_5() {  return this.EAR_2_4_5;}
    @JsonProperty("EAR-2-4-5")
    public void setEAR_2_4_5(final String EAR_2_4_5) { this.EAR_2_4_5=EAR_2_4_5;}
    @Column(name = "EAR_2_4_5_1")
    @JsonProperty("EAR-2-4-5-1")
    private String EAR_2_4_5_1; // 其他β-受体阻滞剂
    public String getEAR_2_4_5_1() {  return this.EAR_2_4_5_1;}
    @JsonProperty("EAR-2-4-5-1")
    public void setEAR_2_4_5_1(final String EAR_2_4_5_1) { this.EAR_2_4_5_1=EAR_2_4_5_1;}
    @Column(name = "EAR_2_4_6")
    @JsonProperty("EAR-2-4-6")
    private String EAR_2_4_6; // 入院后 首剂β-受体阻滞剂用药日期
    public String getEAR_2_4_6() {  return this.EAR_2_4_6;}
    @JsonProperty("EAR-2-4-6")
    public void setEAR_2_4_6(final String EAR_2_4_6) { this.EAR_2_4_6=EAR_2_4_6;}
    @Column(name = "EAR_2_5_1")
    @JsonProperty("EAR-2-5-1")
    private String EAR_2_5_1; // 是否有他汀药物禁忌证
    public String getEAR_2_5_1() {  return this.EAR_2_5_1;}
    @JsonProperty("EAR-2-5-1")
    public void setEAR_2_5_1(final String EAR_2_5_1) { this.EAR_2_5_1=EAR_2_5_1;}
    @Column(name = "EAR_2_5_2")
    @JsonProperty("EAR-2-5-2")
    private String EAR_2_5_2; // 他汀类药物禁忌证的选择
    public String getEAR_2_5_2() {  return this.EAR_2_5_2;}
    @JsonProperty("EAR-2-5-2")
    public void setEAR_2_5_2(final String EAR_2_5_2) { this.EAR_2_5_2=EAR_2_5_2;}
    @Column(name = "EAR_2_5_3")
    @JsonProperty("EAR-2-5-3")
    private String EAR_2_5_3; // 是否在术前使用他汀类药物
    public String getEAR_2_5_3() {  return this.EAR_2_5_3;}
    @JsonProperty("EAR-2-5-3")
    public void setEAR_2_5_3(final String EAR_2_5_3) { this.EAR_2_5_3=EAR_2_5_3;}
    @Column(name = "EAR_2_5_4")
    @JsonProperty("EAR-2-5-4")
    private String EAR_2_5_4; // 使用他汀类药物的选择
    public String getEAR_2_5_4() {  return this.EAR_2_5_4;}
    @JsonProperty("EAR-2-5-4")
    public void setEAR_2_5_4(final String EAR_2_5_4) { this.EAR_2_5_4=EAR_2_5_4;}
    @Column(name = "EAR_2_5_4_1")
    @JsonProperty("EAR-2-5-4-1")
    private String EAR_2_5_4_1; // 其他降脂药物
    public String getEAR_2_5_4_1() {  return this.EAR_2_5_4_1;}
    @JsonProperty("EAR-2-5-4-1")
    public void setEAR_2_5_4_1(final String EAR_2_5_4_1) { this.EAR_2_5_4_1=EAR_2_5_4_1;}
    @Column(name = "EAR_2_5_5")
    @JsonProperty("EAR-2-5-5")
    private String EAR_2_5_5; // 入院后 首剂他汀类药物用药日期
    public String getEAR_2_5_5() {  return this.EAR_2_5_5;}
    @JsonProperty("EAR-2-5-5")
    public void setEAR_2_5_5(final String EAR_2_5_5) { this.EAR_2_5_5=EAR_2_5_5;}
    @Column(name = "EAR_3_8_1")
    @JsonProperty("EAR-3-8-1")
    private String EAR_3_8_1; // 是否多学科(MDT)综合评估
    public String getEAR_3_8_1() {  return this.EAR_3_8_1;}
    @JsonProperty("EAR-3-8-1")
    public void setEAR_3_8_1(final String EAR_3_8_1) { this.EAR_3_8_1=EAR_3_8_1;}
    @Column(name = "EAR_3_8_2")
    @JsonProperty("EAR-3-8-2")
    private String EAR_3_8_2; // 参与讨论的专业个数
    public String getEAR_3_8_2() {  return this.EAR_3_8_2;}
    @JsonProperty("EAR-3-8-2")
    public void setEAR_3_8_2(final String EAR_3_8_2) { this.EAR_3_8_2=EAR_3_8_2;}
    @Column(name = "EAR_3_8_3")
    @JsonProperty("EAR-3-8-3")
    private String EAR_3_8_3; // 是否急诊手术
    public String getEAR_3_8_3() {  return this.EAR_3_8_3;}
    @JsonProperty("EAR-3-8-3")
    public void setEAR_3_8_3(final String EAR_3_8_3) { this.EAR_3_8_3=EAR_3_8_3;}
    @Column(name = "EAR_3_8_4")
    @JsonProperty("EAR-3-8-4")
    private String EAR_3_8_4; // 是否初次手术/再次手术
    public String getEAR_3_8_4() {  return this.EAR_3_8_4;}
    @JsonProperty("EAR-3-8-4")
    public void setEAR_3_8_4(final String EAR_3_8_4) { this.EAR_3_8_4=EAR_3_8_4;}
    @Column(name = "EAR_3_9_1")
    @JsonProperty("EAR-3-9-1")
    private String EAR_3_9_1; // 符合本次住院期间TEVAR手术指征的主要诊断
    public String getEAR_3_9_1() {  return this.EAR_3_9_1;}
    @JsonProperty("EAR-3-9-1")
    public void setEAR_3_9_1(final String EAR_3_9_1) { this.EAR_3_9_1=EAR_3_9_1;}
    @Column(name = "EAR_3_9_1_1")
    @JsonProperty("EAR-3-9-1-1")
    private String EAR_3_9_1_1; // 主动脉夹层指征选择
    public String getEAR_3_9_1_1() {  return this.EAR_3_9_1_1;}
    @JsonProperty("EAR-3-9-1-1")
    public void setEAR_3_9_1_1(final String EAR_3_9_1_1) { this.EAR_3_9_1_1=EAR_3_9_1_1;}
    @Column(name = "EAR_3_9_1_2")
    @JsonProperty("EAR-3-9-1-2")
    private String EAR_3_9_1_2; // 其他主动脉夹层
    public String getEAR_3_9_1_2() {  return this.EAR_3_9_1_2;}
    @JsonProperty("EAR-3-9-1-2")
    public void setEAR_3_9_1_2(final String EAR_3_9_1_2) { this.EAR_3_9_1_2=EAR_3_9_1_2;}
    @Column(name = "EAR_3_9_1_3")
    @JsonProperty("EAR-3-9-1-3")
    private String EAR_3_9_1_3; // 主动脉夹层的临床分型
    public String getEAR_3_9_1_3() {  return this.EAR_3_9_1_3;}
    @JsonProperty("EAR-3-9-1-3")
    public void setEAR_3_9_1_3(final String EAR_3_9_1_3) { this.EAR_3_9_1_3=EAR_3_9_1_3;}
    @Column(name = "EAR_3_9_1_4")
    @JsonProperty("EAR-3-9-1-4")
    private String EAR_3_9_1_4; // 是否为急性主动脉夹层
    public String getEAR_3_9_1_4() {  return this.EAR_3_9_1_4;}
    @JsonProperty("EAR-3-9-1-4")
    public void setEAR_3_9_1_4(final String EAR_3_9_1_4) { this.EAR_3_9_1_4=EAR_3_9_1_4;}
    @Column(name = "EAR_3_9_2_1")
    @JsonProperty("EAR-3-9-2-1")
    private String EAR_3_9_2_1; // 胸主动脉瘤指征选择
    public String getEAR_3_9_2_1() {  return this.EAR_3_9_2_1;}
    @JsonProperty("EAR-3-9-2-1")
    public void setEAR_3_9_2_1(final String EAR_3_9_2_1) { this.EAR_3_9_2_1=EAR_3_9_2_1;}
    @Column(name = "EAR_3_9_2_2")
    @JsonProperty("EAR-3-9-2-2")
    private String EAR_3_9_2_2; // 其他胸主动脉瘤
    public String getEAR_3_9_2_2() {  return this.EAR_3_9_2_2;}
    @JsonProperty("EAR-3-9-2-2")
    public void setEAR_3_9_2_2(final String EAR_3_9_2_2) { this.EAR_3_9_2_2=EAR_3_9_2_2;}
    @Column(name = "EAR_3_9_2_3")
    @JsonProperty("EAR-3-9-2-3")
    private String EAR_3_9_2_3; // 是否有主动脉瘤最大直径记录
    public String getEAR_3_9_2_3() {  return this.EAR_3_9_2_3;}
    @JsonProperty("EAR-3-9-2-3")
    public void setEAR_3_9_2_3(final String EAR_3_9_2_3) { this.EAR_3_9_2_3=EAR_3_9_2_3;}
    @Column(name = "EAR_3_9_2_4")
    @JsonProperty("EAR-3-9-2-4")
    private String EAR_3_9_2_4; // 主动脉瘤最大直径(mm)
    public String getEAR_3_9_2_4() {  return this.EAR_3_9_2_4;}
    @JsonProperty("EAR-3-9-2-4")
    public void setEAR_3_9_2_4(final String EAR_3_9_2_4) { this.EAR_3_9_2_4=EAR_3_9_2_4;}
    @Column(name = "EAR_3_9_2_5")
    @JsonProperty("EAR-3-9-2-5")
    private String EAR_3_9_2_5; // 是否为主动脉瘤破裂
    public String getEAR_3_9_2_5() {  return this.EAR_3_9_2_5;}
    @JsonProperty("EAR-3-9-2-5")
    public void setEAR_3_9_2_5(final String EAR_3_9_2_5) { this.EAR_3_9_2_5=EAR_3_9_2_5;}
    @Column(name = "EAR_3_9_3_1")
    @JsonProperty("EAR-3-9-3-1")
    private String EAR_3_9_3_1; // 主动脉溃疡指征选择
    public String getEAR_3_9_3_1() {  return this.EAR_3_9_3_1;}
    @JsonProperty("EAR-3-9-3-1")
    public void setEAR_3_9_3_1(final String EAR_3_9_3_1) { this.EAR_3_9_3_1=EAR_3_9_3_1;}
    @Column(name = "EAR_3_9_3_2")
    @JsonProperty("EAR-3-9-3-2")
    private String EAR_3_9_3_2; // 急性主动脉溃疡
    public String getEAR_3_9_3_2() {  return this.EAR_3_9_3_2;}
    @JsonProperty("EAR-3-9-3-2")
    public void setEAR_3_9_3_2(final String EAR_3_9_3_2) { this.EAR_3_9_3_2=EAR_3_9_3_2;}
    @Column(name = "EAR_3_9_3_3")
    @JsonProperty("EAR-3-9-3-3")
    private String EAR_3_9_3_3; // 慢性/无症状性主动脉溃疡
    public String getEAR_3_9_3_3() {  return this.EAR_3_9_3_3;}
    @JsonProperty("EAR-3-9-3-3")
    public void setEAR_3_9_3_3(final String EAR_3_9_3_3) { this.EAR_3_9_3_3=EAR_3_9_3_3;}
    @Column(name = "EAR_3_9_3_4")
    @JsonProperty("EAR-3-9-3-4")
    private String EAR_3_9_3_4; // 其他主动脉溃疡
    public String getEAR_3_9_3_4() {  return this.EAR_3_9_3_4;}
    @JsonProperty("EAR-3-9-3-4")
    public void setEAR_3_9_3_4(final String EAR_3_9_3_4) { this.EAR_3_9_3_4=EAR_3_9_3_4;}
    @Column(name = "EAR_3_9_3_5")
    @JsonProperty("EAR-3-9-3-5")
    private String EAR_3_9_3_5; // 是否有主动脉溃疡深度记录
    public String getEAR_3_9_3_5() {  return this.EAR_3_9_3_5;}
    @JsonProperty("EAR-3-9-3-5")
    public void setEAR_3_9_3_5(final String EAR_3_9_3_5) { this.EAR_3_9_3_5=EAR_3_9_3_5;}
    @Column(name = "EAR_3_9_3_6")
    @JsonProperty("EAR-3-9-3-6")
    private String EAR_3_9_3_6; // 主动脉溃疡深度(mm)
    public String getEAR_3_9_3_6() {  return this.EAR_3_9_3_6;}
    @JsonProperty("EAR-3-9-3-6")
    public void setEAR_3_9_3_6(final String EAR_3_9_3_6) { this.EAR_3_9_3_6=EAR_3_9_3_6;}
    @Column(name = "EAR_3_9_3_8")
    @JsonProperty("EAR-3-9-3-8")
    private String EAR_3_9_3_8; // 是否有主动脉溃疡宽度记录
    public String getEAR_3_9_3_8() {  return this.EAR_3_9_3_8;}
    @JsonProperty("EAR-3-9-3-8")
    public void setEAR_3_9_3_8(final String EAR_3_9_3_8) { this.EAR_3_9_3_8=EAR_3_9_3_8;}
    @Column(name = "EAR_3_9_3_9")
    @JsonProperty("EAR-3-9-3-9")
    private String EAR_3_9_3_9; // 主动脉溃疡宽度(mm)
    public String getEAR_3_9_3_9() {  return this.EAR_3_9_3_9;}
    @JsonProperty("EAR-3-9-3-9")
    public void setEAR_3_9_3_9(final String EAR_3_9_3_9) { this.EAR_3_9_3_9=EAR_3_9_3_9;}
    @Column(name = "EAR_3_9_4_1")
    @JsonProperty("EAR-3-9-4-1")
    private String EAR_3_9_4_1; // 主动脉壁间血肿指征选择
    public String getEAR_3_9_4_1() {  return this.EAR_3_9_4_1;}
    @JsonProperty("EAR-3-9-4-1")
    public void setEAR_3_9_4_1(final String EAR_3_9_4_1) { this.EAR_3_9_4_1=EAR_3_9_4_1;}
    @Column(name = "EAR_3_9_4_2")
    @JsonProperty("EAR-3-9-4-2")
    private String EAR_3_9_4_2; // 其他主动脉壁间血肿
    public String getEAR_3_9_4_2() {  return this.EAR_3_9_4_2;}
    @JsonProperty("EAR-3-9-4-2")
    public void setEAR_3_9_4_2(final String EAR_3_9_4_2) { this.EAR_3_9_4_2=EAR_3_9_4_2;}
    @Column(name = "EAR_3_9_4_3")
    @JsonProperty("EAR-3-9-4-3")
    private String EAR_3_9_4_3; // 是否有主动脉壁间血肿最大厚度记录
    public String getEAR_3_9_4_3() {  return this.EAR_3_9_4_3;}
    @JsonProperty("EAR-3-9-4-3")
    public void setEAR_3_9_4_3(final String EAR_3_9_4_3) { this.EAR_3_9_4_3=EAR_3_9_4_3;}
    @Column(name = "EAR_3_9_4_4")
    @JsonProperty("EAR-3-9-4-4")
    private String EAR_3_9_4_4; // 主动脉壁间血肿最大厚度(mm)
    public String getEAR_3_9_4_4() {  return this.EAR_3_9_4_4;}
    @JsonProperty("EAR-3-9-4-4")
    public void setEAR_3_9_4_4(final String EAR_3_9_4_4) { this.EAR_3_9_4_4=EAR_3_9_4_4;}
    @Column(name = "EAR_3_9_6_1")
    @JsonProperty("EAR-3-9-6-1")
    private String EAR_3_9_6_1; // 主动脉假性动脉瘤指征选择
    public String getEAR_3_9_6_1() {  return this.EAR_3_9_6_1;}
    @JsonProperty("EAR-3-9-6-1")
    public void setEAR_3_9_6_1(final String EAR_3_9_6_1) { this.EAR_3_9_6_1=EAR_3_9_6_1;}
    @Column(name = "EAR_3_9_6_2")
    @JsonProperty("EAR-3-9-6-2")
    private String EAR_3_9_6_2; // 其他主动脉假性动脉瘤
    public String getEAR_3_9_6_2() {  return this.EAR_3_9_6_2;}
    @JsonProperty("EAR-3-9-6-2")
    public void setEAR_3_9_6_2(final String EAR_3_9_6_2) { this.EAR_3_9_6_2=EAR_3_9_6_2;}
    @Column(name = "EAR_3_9_5_1")
    @JsonProperty("EAR-3-9-5-1")
    private String EAR_3_9_5_1; // 主动脉缩窄指征选择
    public String getEAR_3_9_5_1() {  return this.EAR_3_9_5_1;}
    @JsonProperty("EAR-3-9-5-1")
    public void setEAR_3_9_5_1(final String EAR_3_9_5_1) { this.EAR_3_9_5_1=EAR_3_9_5_1;}
    @Column(name = "EAR_3_9_5_2")
    @JsonProperty("EAR-3-9-5-2")
    private String EAR_3_9_5_2; // 上肢和下肢的无创压差>20 mm Hg的患者
    public String getEAR_3_9_5_2() {  return this.EAR_3_9_5_2;}
    @JsonProperty("EAR-3-9-5-2")
    public void setEAR_3_9_5_2(final String EAR_3_9_5_2) { this.EAR_3_9_5_2=EAR_3_9_5_2;}
    @Column(name = "EAR_3_9_5_3")
    @JsonProperty("EAR-3-9-5-3")
    private String EAR_3_9_5_3; // 其他主动脉缩窄
    public String getEAR_3_9_5_3() {  return this.EAR_3_9_5_3;}
    @JsonProperty("EAR-3-9-5-3")
    public void setEAR_3_9_5_3(final String EAR_3_9_5_3) { this.EAR_3_9_5_3=EAR_3_9_5_3;}
    @Column(name = "EAR_3_9_5_4")
    @JsonProperty("EAR-3-9-5-4")
    private String EAR_3_9_5_4; // 是否有主动脉缩窄部位最小直径记录
    public String getEAR_3_9_5_4() {  return this.EAR_3_9_5_4;}
    @JsonProperty("EAR-3-9-5-4")
    public void setEAR_3_9_5_4(final String EAR_3_9_5_4) { this.EAR_3_9_5_4=EAR_3_9_5_4;}
    @Column(name = "EAR_3_9_5_5")
    @JsonProperty("EAR-3-9-5-5")
    private String EAR_3_9_5_5; // 主动脉缩窄部位最小直径(mm)
    public String getEAR_3_9_5_5() {  return this.EAR_3_9_5_5;}
    @JsonProperty("EAR-3-9-5-5")
    public void setEAR_3_9_5_5(final String EAR_3_9_5_5) { this.EAR_3_9_5_5=EAR_3_9_5_5;}
    @Column(name = "EAR_3_9_7_1")
    @JsonProperty("EAR-3-9-7-1")
    private String EAR_3_9_7_1; // 主动脉闭塞指征选择
    public String getEAR_3_9_7_1() {  return this.EAR_3_9_7_1;}
    @JsonProperty("EAR-3-9-7-1")
    public void setEAR_3_9_7_1(final String EAR_3_9_7_1) { this.EAR_3_9_7_1=EAR_3_9_7_1;}
    @Column(name = "EAR_3_9_7_2")
    @JsonProperty("EAR-3-9-7-2")
    private String EAR_3_9_7_2; // 其他主动脉闭塞
    public String getEAR_3_9_7_2() {  return this.EAR_3_9_7_2;}
    @JsonProperty("EAR-3-9-7-2")
    public void setEAR_3_9_7_2(final String EAR_3_9_7_2) { this.EAR_3_9_7_2=EAR_3_9_7_2;}
    @Column(name = "EAR_3_9_8_1")
    @JsonProperty("EAR-3-9-8-1")
    private String EAR_3_9_8_1; // 主动脉损伤指征选择
    public String getEAR_3_9_8_1() {  return this.EAR_3_9_8_1;}
    @JsonProperty("EAR-3-9-8-1")
    public void setEAR_3_9_8_1(final String EAR_3_9_8_1) { this.EAR_3_9_8_1=EAR_3_9_8_1;}
    @Column(name = "EAR_3_9_8_2")
    @JsonProperty("EAR-3-9-8-2")
    private String EAR_3_9_8_2; // 其他主动脉损伤
    public String getEAR_3_9_8_2() {  return this.EAR_3_9_8_2;}
    @JsonProperty("EAR-3-9-8-2")
    public void setEAR_3_9_8_2(final String EAR_3_9_8_2) { this.EAR_3_9_8_2=EAR_3_9_8_2;}
    @Column(name = "EAR_3_9_9")
    @JsonProperty("EAR-3-9-9")
    private String EAR_3_9_9; // 其他主动脉疾病(ICD-10编码及名称)
    public String getEAR_3_9_9() {  return this.EAR_3_9_9;}
    @JsonProperty("EAR-3-9-9")
    public void setEAR_3_9_9(final String EAR_3_9_9) { this.EAR_3_9_9=EAR_3_9_9;}
    @Column(name = "EAR_3_10_1")
    @JsonProperty("EAR-3-10-1")
    private String EAR_3_10_1; // 符合本次住院期间EVAR手术指征的主要诊断
    public String getEAR_3_10_1() {  return this.EAR_3_10_1;}
    @JsonProperty("EAR-3-10-1")
    public void setEAR_3_10_1(final String EAR_3_10_1) { this.EAR_3_10_1=EAR_3_10_1;}
    @Column(name = "EAR_3_10_1_1")
    @JsonProperty("EAR-3-10-1-1")
    private String EAR_3_10_1_1; // 主动脉夹层指征选择
    public String getEAR_3_10_1_1() {  return this.EAR_3_10_1_1;}
    @JsonProperty("EAR-3-10-1-1")
    public void setEAR_3_10_1_1(final String EAR_3_10_1_1) { this.EAR_3_10_1_1=EAR_3_10_1_1;}
    @Column(name = "EAR_3_10_1_2")
    @JsonProperty("EAR-3-10-1-2")
    private String EAR_3_10_1_2; // 其他主动脉夹层
    public String getEAR_3_10_1_2() {  return this.EAR_3_10_1_2;}
    @JsonProperty("EAR-3-10-1-2")
    public void setEAR_3_10_1_2(final String EAR_3_10_1_2) { this.EAR_3_10_1_2=EAR_3_10_1_2;}
    @Column(name = "EAR_3_10_1_3")
    @JsonProperty("EAR-3-10-1-3")
    private String EAR_3_10_1_3; // 主动脉夹层的临床分型
    public String getEAR_3_10_1_3() {  return this.EAR_3_10_1_3;}
    @JsonProperty("EAR-3-10-1-3")
    public void setEAR_3_10_1_3(final String EAR_3_10_1_3) { this.EAR_3_10_1_3=EAR_3_10_1_3;}
    @Column(name = "EAR_3_10_1_4")
    @JsonProperty("EAR-3-10-1-4")
    private String EAR_3_10_1_4; // 是否为急性主动脉夹层
    public String getEAR_3_10_1_4() {  return this.EAR_3_10_1_4;}
    @JsonProperty("EAR-3-10-1-4")
    public void setEAR_3_10_1_4(final String EAR_3_10_1_4) { this.EAR_3_10_1_4=EAR_3_10_1_4;}
    @Column(name = "EAR_3_10_2_1")
    @JsonProperty("EAR-3-10-2-1")
    private String EAR_3_10_2_1; // 腹主动脉瘤指征选择
    public String getEAR_3_10_2_1() {  return this.EAR_3_10_2_1;}
    @JsonProperty("EAR-3-10-2-1")
    public void setEAR_3_10_2_1(final String EAR_3_10_2_1) { this.EAR_3_10_2_1=EAR_3_10_2_1;}
    @Column(name = "EAR_3_10_2_2")
    @JsonProperty("EAR-3-10-2-2")
    private String EAR_3_10_2_2; // 其他腹主动脉瘤
    public String getEAR_3_10_2_2() {  return this.EAR_3_10_2_2;}
    @JsonProperty("EAR-3-10-2-2")
    public void setEAR_3_10_2_2(final String EAR_3_10_2_2) { this.EAR_3_10_2_2=EAR_3_10_2_2;}
    @Column(name = "EAR_3_10_2_3")
    @JsonProperty("EAR-3-10-2-3")
    private String EAR_3_10_2_3; // 是否有腹主动脉瘤最大直径记录
    public String getEAR_3_10_2_3() {  return this.EAR_3_10_2_3;}
    @JsonProperty("EAR-3-10-2-3")
    public void setEAR_3_10_2_3(final String EAR_3_10_2_3) { this.EAR_3_10_2_3=EAR_3_10_2_3;}
    @Column(name = "EAR_3_10_2_4")
    @JsonProperty("EAR-3-10-2-4")
    private String EAR_3_10_2_4; // 腹主动脉瘤最大直径(mm)
    public String getEAR_3_10_2_4() {  return this.EAR_3_10_2_4;}
    @JsonProperty("EAR-3-10-2-4")
    public void setEAR_3_10_2_4(final String EAR_3_10_2_4) { this.EAR_3_10_2_4=EAR_3_10_2_4;}
    @Column(name = "EAR_3_10_2_5")
    @JsonProperty("EAR-3-10-2-5")
    private String EAR_3_10_2_5; // 是否有腹主动脉瘤最大直径近1年内增长记录
    public String getEAR_3_10_2_5() {  return this.EAR_3_10_2_5;}
    @JsonProperty("EAR-3-10-2-5")
    public void setEAR_3_10_2_5(final String EAR_3_10_2_5) { this.EAR_3_10_2_5=EAR_3_10_2_5;}
    @Column(name = "EAR_3_10_2_6")
    @JsonProperty("EAR-3-10-2-6")
    private String EAR_3_10_2_6; // 腹主动脉瘤最大直径近1年内增长(mm)
    public String getEAR_3_10_2_6() {  return this.EAR_3_10_2_6;}
    @JsonProperty("EAR-3-10-2-6")
    public void setEAR_3_10_2_6(final String EAR_3_10_2_6) { this.EAR_3_10_2_6=EAR_3_10_2_6;}
    @Column(name = "EAR_3_10_2_7")
    @JsonProperty("EAR-3-10-2-7")
    private String EAR_3_10_2_7; // 是否为腹主动脉瘤破裂
    public String getEAR_3_10_2_7() {  return this.EAR_3_10_2_7;}
    @JsonProperty("EAR-3-10-2-7")
    public void setEAR_3_10_2_7(final String EAR_3_10_2_7) { this.EAR_3_10_2_7=EAR_3_10_2_7;}
    @Column(name = "EAR_3_10_3_1")
    @JsonProperty("EAR-3-10-3-1")
    private String EAR_3_10_3_1; // 主动脉溃疡指征选择
    public String getEAR_3_10_3_1() {  return this.EAR_3_10_3_1;}
    @JsonProperty("EAR-3-10-3-1")
    public void setEAR_3_10_3_1(final String EAR_3_10_3_1) { this.EAR_3_10_3_1=EAR_3_10_3_1;}
    @Column(name = "EAR_3_10_3_2")
    @JsonProperty("EAR-3-10-3-2")
    private String EAR_3_10_3_2; // 急性主动脉溃疡
    public String getEAR_3_10_3_2() {  return this.EAR_3_10_3_2;}
    @JsonProperty("EAR-3-10-3-2")
    public void setEAR_3_10_3_2(final String EAR_3_10_3_2) { this.EAR_3_10_3_2=EAR_3_10_3_2;}
    @Column(name = "EAR_3_10_3_3")
    @JsonProperty("EAR-3-10-3-3")
    private String EAR_3_10_3_3; // 慢性/无症状性主动脉溃疡
    public String getEAR_3_10_3_3() {  return this.EAR_3_10_3_3;}
    @JsonProperty("EAR-3-10-3-3")
    public void setEAR_3_10_3_3(final String EAR_3_10_3_3) { this.EAR_3_10_3_3=EAR_3_10_3_3;}
    @Column(name = "EAR_3_10_3_4")
    @JsonProperty("EAR-3-10-3-4")
    private String EAR_3_10_3_4; // 其他主动脉溃疡
    public String getEAR_3_10_3_4() {  return this.EAR_3_10_3_4;}
    @JsonProperty("EAR-3-10-3-4")
    public void setEAR_3_10_3_4(final String EAR_3_10_3_4) { this.EAR_3_10_3_4=EAR_3_10_3_4;}
    @Column(name = "EAR_3_10_3_5")
    @JsonProperty("EAR-3-10-3-5")
    private String EAR_3_10_3_5; // 是否有主动脉溃疡深度记录
    public String getEAR_3_10_3_5() {  return this.EAR_3_10_3_5;}
    @JsonProperty("EAR-3-10-3-5")
    public void setEAR_3_10_3_5(final String EAR_3_10_3_5) { this.EAR_3_10_3_5=EAR_3_10_3_5;}
    @Column(name = "EAR_3_10_3_6")
    @JsonProperty("EAR-3-10-3-6")
    private String EAR_3_10_3_6; // 主动脉溃疡深度(mm)
    public String getEAR_3_10_3_6() {  return this.EAR_3_10_3_6;}
    @JsonProperty("EAR-3-10-3-6")
    public void setEAR_3_10_3_6(final String EAR_3_10_3_6) { this.EAR_3_10_3_6=EAR_3_10_3_6;}
    @Column(name = "EAR_3_10_3_8")
    @JsonProperty("EAR-3-10-3-8")
    private String EAR_3_10_3_8; // 是否有主动脉溃疡宽度记录
    public String getEAR_3_10_3_8() {  return this.EAR_3_10_3_8;}
    @JsonProperty("EAR-3-10-3-8")
    public void setEAR_3_10_3_8(final String EAR_3_10_3_8) { this.EAR_3_10_3_8=EAR_3_10_3_8;}
    @Column(name = "EAR_3_10_3_9")
    @JsonProperty("EAR-3-10-3-9")
    private String EAR_3_10_3_9; // 主动脉溃疡宽度(mm)
    public String getEAR_3_10_3_9() {  return this.EAR_3_10_3_9;}
    @JsonProperty("EAR-3-10-3-9")
    public void setEAR_3_10_3_9(final String EAR_3_10_3_9) { this.EAR_3_10_3_9=EAR_3_10_3_9;}
    @Column(name = "EAR_3_10_4_1")
    @JsonProperty("EAR-3-10-4-1")
    private String EAR_3_10_4_1; // 主动脉壁间血肿指征选择
    public String getEAR_3_10_4_1() {  return this.EAR_3_10_4_1;}
    @JsonProperty("EAR-3-10-4-1")
    public void setEAR_3_10_4_1(final String EAR_3_10_4_1) { this.EAR_3_10_4_1=EAR_3_10_4_1;}
    @Column(name = "EAR_3_10_4_2")
    @JsonProperty("EAR-3-10-4-2")
    private String EAR_3_10_4_2; // 其他主动脉壁间血肿
    public String getEAR_3_10_4_2() {  return this.EAR_3_10_4_2;}
    @JsonProperty("EAR-3-10-4-2")
    public void setEAR_3_10_4_2(final String EAR_3_10_4_2) { this.EAR_3_10_4_2=EAR_3_10_4_2;}
    @Column(name = "EAR_3_10_4_3")
    @JsonProperty("EAR-3-10-4-3")
    private String EAR_3_10_4_3; // 是否有主动脉壁间血肿最大厚度记录
    public String getEAR_3_10_4_3() {  return this.EAR_3_10_4_3;}
    @JsonProperty("EAR-3-10-4-3")
    public void setEAR_3_10_4_3(final String EAR_3_10_4_3) { this.EAR_3_10_4_3=EAR_3_10_4_3;}
    @Column(name = "EAR_3_10_4_4")
    @JsonProperty("EAR-3-10-4-4")
    private String EAR_3_10_4_4; // 主动脉壁间血肿最大厚度(mm)
    public String getEAR_3_10_4_4() {  return this.EAR_3_10_4_4;}
    @JsonProperty("EAR-3-10-4-4")
    public void setEAR_3_10_4_4(final String EAR_3_10_4_4) { this.EAR_3_10_4_4=EAR_3_10_4_4;}
    @Column(name = "EAR_3_10_6_1")
    @JsonProperty("EAR-3-10-6-1")
    private String EAR_3_10_6_1; // 主动脉假性动脉瘤指征选择
    public String getEAR_3_10_6_1() {  return this.EAR_3_10_6_1;}
    @JsonProperty("EAR-3-10-6-1")
    public void setEAR_3_10_6_1(final String EAR_3_10_6_1) { this.EAR_3_10_6_1=EAR_3_10_6_1;}
    @Column(name = "EAR_3_10_6_2")
    @JsonProperty("EAR-3-10-6-2")
    private String EAR_3_10_6_2; // 其他主动脉假性动脉瘤
    public String getEAR_3_10_6_2() {  return this.EAR_3_10_6_2;}
    @JsonProperty("EAR-3-10-6-2")
    public void setEAR_3_10_6_2(final String EAR_3_10_6_2) { this.EAR_3_10_6_2=EAR_3_10_6_2;}
    @Column(name = "EAR_3_10_7_1")
    @JsonProperty("EAR-3-10-7-1")
    private String EAR_3_10_7_1; // 主动脉闭塞指征选择
    public String getEAR_3_10_7_1() {  return this.EAR_3_10_7_1;}
    @JsonProperty("EAR-3-10-7-1")
    public void setEAR_3_10_7_1(final String EAR_3_10_7_1) { this.EAR_3_10_7_1=EAR_3_10_7_1;}
    @Column(name = "EAR_3_10_7_2")
    @JsonProperty("EAR-3-10-7-2")
    private String EAR_3_10_7_2; // 其他主动脉闭塞
    public String getEAR_3_10_7_2() {  return this.EAR_3_10_7_2;}
    @JsonProperty("EAR-3-10-7-2")
    public void setEAR_3_10_7_2(final String EAR_3_10_7_2) { this.EAR_3_10_7_2=EAR_3_10_7_2;}
    @Column(name = "EAR_3_10_8_1")
    @JsonProperty("EAR-3-10-8-1")
    private String EAR_3_10_8_1; // 主动脉损伤指征选择
    public String getEAR_3_10_8_1() {  return this.EAR_3_10_8_1;}
    @JsonProperty("EAR-3-10-8-1")
    public void setEAR_3_10_8_1(final String EAR_3_10_8_1) { this.EAR_3_10_8_1=EAR_3_10_8_1;}
    @Column(name = "EAR_3_10_8_2")
    @JsonProperty("EAR-3-10-8-2")
    private String EAR_3_10_8_2; // 其他主动脉损伤
    public String getEAR_3_10_8_2() {  return this.EAR_3_10_8_2;}
    @JsonProperty("EAR-3-10-8-2")
    public void setEAR_3_10_8_2(final String EAR_3_10_8_2) { this.EAR_3_10_8_2=EAR_3_10_8_2;}
    @Column(name = "EAR_3_10_9")
    @JsonProperty("EAR-3-10-9")
    private String EAR_3_10_9; // 其他主动脉疾病(ICD-10编码及名称)
    public String getEAR_3_10_9() {  return this.EAR_3_10_9;}
    @JsonProperty("EAR-3-10-9")
    public void setEAR_3_10_9(final String EAR_3_10_9) { this.EAR_3_10_9=EAR_3_10_9;}
    @Column(name = "EAR_3_11_1")
    @JsonProperty("EAR-3-11-1")
    private String EAR_3_11_1; // 是否有手术可能的禁忌证
    public String getEAR_3_11_1() {  return this.EAR_3_11_1;}
    @JsonProperty("EAR-3-11-1")
    public void setEAR_3_11_1(final String EAR_3_11_1) { this.EAR_3_11_1=EAR_3_11_1;}
    @Column(name = "EAR_3_11_2")
    @JsonProperty("EAR-3-11-2")
    private String EAR_3_11_2; // 手术可能存在的禁忌证
    public String getEAR_3_11_2() {  return this.EAR_3_11_2;}
    @JsonProperty("EAR-3-11-2")
    public void setEAR_3_11_2(final String EAR_3_11_2) { this.EAR_3_11_2=EAR_3_11_2;}
    @Column(name = "EAR_3_11_3")
    @JsonProperty("EAR-3-11-3")
    private String EAR_3_11_3; // 其他可能存在的禁忌证
    public String getEAR_3_11_3() {  return this.EAR_3_11_3;}
    @JsonProperty("EAR-3-11-3")
    public void setEAR_3_11_3(final String EAR_3_11_3) { this.EAR_3_11_3=EAR_3_11_3;}
    @Column(name = "EAR_4_3_1")
    @JsonProperty("EAR-4-3-1")
    private String EAR_4_3_1; // 术中使用麻醉方式
    public String getEAR_4_3_1() {  return this.EAR_4_3_1;}
    @JsonProperty("EAR-4-3-1")
    public void setEAR_4_3_1(final String EAR_4_3_1) { this.EAR_4_3_1=EAR_4_3_1;}
    @Column(name = "EAR_4_3_1_1")
    @JsonProperty("EAR-4-3-1-1")
    private String EAR_4_3_1_1; // 其他麻醉方式
    public String getEAR_4_3_1_1() {  return this.EAR_4_3_1_1;}
    @JsonProperty("EAR-4-3-1-1")
    public void setEAR_4_3_1_1(final String EAR_4_3_1_1) { this.EAR_4_3_1_1=EAR_4_3_1_1;}
    @Column(name = "EAR_4_3_2")
    @JsonProperty("EAR-4-3-2")
    private String EAR_4_3_2; // 是否采用 体外循环
    public String getEAR_4_3_2() {  return this.EAR_4_3_2;}
    @JsonProperty("EAR-4-3-2")
    public void setEAR_4_3_2(final String EAR_4_3_2) { this.EAR_4_3_2=EAR_4_3_2;}
    @Column(name = "EAR_4_3_3_1")
    @JsonProperty("EAR-4-3-3-1")
    private String EAR_4_3_3_1; // 体外循环  起始日期时间
    public String getEAR_4_3_3_1() {  return this.EAR_4_3_3_1;}
    @JsonProperty("EAR-4-3-3-1")
    public void setEAR_4_3_3_1(final String EAR_4_3_3_1) { this.EAR_4_3_3_1=EAR_4_3_3_1;}
    @Column(name = "EAR_4_3_3_2")
    @JsonProperty("EAR-4-3-3-2")
    private String EAR_4_3_3_2; // 体外循环  终止日期时间
    public String getEAR_4_3_3_2() {  return this.EAR_4_3_3_2;}
    @JsonProperty("EAR-4-3-3-2")
    public void setEAR_4_3_3_2(final String EAR_4_3_3_2) { this.EAR_4_3_3_2=EAR_4_3_3_2;}
    @Column(name = "EAR_4_4_1")
    @JsonProperty("EAR-4-4-1")
    private String EAR_4_4_1; // 术中是否有主动脉重要分支血管的重建
    public String getEAR_4_4_1() {  return this.EAR_4_4_1;}
    @JsonProperty("EAR-4-4-1")
    public void setEAR_4_4_1(final String EAR_4_4_1) { this.EAR_4_4_1=EAR_4_4_1;}
    @Column(name = "EAR_4_5_3_r")
    @JsonProperty("EAR-4-5-3-r")
    private String EAR_4_5_3_r; // EAR的手术类别
    public String getEAR_4_5_3_r() {  return this.EAR_4_5_3_r;}
    @JsonProperty("EAR-4-5-3-r")
    public void setEAR_4_5_3_r(final String EAR_4_5_3_r) { this.EAR_4_5_3_r=EAR_4_5_3_r;}
    @Column(name = "EAR_4_4_3")
    @JsonProperty("EAR-4-4-3")
    private String EAR_4_4_3; // TEVAR术中重建的主动脉重要分支血管选择
    public String getEAR_4_4_3() {  return this.EAR_4_4_3;}
    @JsonProperty("EAR-4-4-3")
    public void setEAR_4_4_3(final String EAR_4_4_3) { this.EAR_4_4_3=EAR_4_4_3;}
    @Column(name = "EAR_4_4_3_1")
    @JsonProperty("EAR-4-4-3-1")
    private String EAR_4_4_3_1; // 其他变异分支血管
    public String getEAR_4_4_3_1() {  return this.EAR_4_4_3_1;}
    @JsonProperty("EAR-4-4-3-1")
    public void setEAR_4_4_3_1(final String EAR_4_4_3_1) { this.EAR_4_4_3_1=EAR_4_4_3_1;}
    @Column(name = "EAR_4_4_5")
    @JsonProperty("EAR-4-4-5")
    private String EAR_4_4_5; // EVAR术中重建的主动脉重要分支血管选择
    public String getEAR_4_4_5() {  return this.EAR_4_4_5;}
    @JsonProperty("EAR-4-4-5")
    public void setEAR_4_4_5(final String EAR_4_4_5) { this.EAR_4_4_5=EAR_4_4_5;}
    @Column(name = "EAR_4_4_5_1")
    @JsonProperty("EAR-4-4-5-1")
    private String EAR_4_4_5_1; // 其他变异分支血管
    public String getEAR_4_4_5_1() {  return this.EAR_4_4_5_1;}
    @JsonProperty("EAR-4-4-5-1")
    public void setEAR_4_4_5_1(final String EAR_4_4_5_1) { this.EAR_4_4_5_1=EAR_4_4_5_1;}
    @Column(name = "EAR_3_12_1")
    @JsonProperty("EAR-3-12-1")
    private String EAR_3_12_1; // 术中是否有牺牲主动脉重要分支血管
    public String getEAR_3_12_1() {  return this.EAR_3_12_1;}
    @JsonProperty("EAR-3-12-1")
    public void setEAR_3_12_1(final String EAR_3_12_1) { this.EAR_3_12_1=EAR_3_12_1;}
    @Column(name = "EAR_3_12_2")
    @JsonProperty("EAR-3-12-2")
    private String EAR_3_12_2; // TEVAR术中牺牲的主动脉重要分支血管
    public String getEAR_3_12_2() {  return this.EAR_3_12_2;}
    @JsonProperty("EAR-3-12-2")
    public void setEAR_3_12_2(final String EAR_3_12_2) { this.EAR_3_12_2=EAR_3_12_2;}
    @Column(name = "EAR_3_12_2_1")
    @JsonProperty("EAR-3-12-2-1")
    private String EAR_3_12_2_1; // 其他变异分支血管
    public String getEAR_3_12_2_1() {  return this.EAR_3_12_2_1;}
    @JsonProperty("EAR-3-12-2-1")
    public void setEAR_3_12_2_1(final String EAR_3_12_2_1) { this.EAR_3_12_2_1=EAR_3_12_2_1;}
    @Column(name = "EAR_3_12_3")
    @JsonProperty("EAR-3-12-3")
    private String EAR_3_12_3; // EVAR术中牺牲的主动脉重要分支血管
    public String getEAR_3_12_3() {  return this.EAR_3_12_3;}
    @JsonProperty("EAR-3-12-3")
    public void setEAR_3_12_3(final String EAR_3_12_3) { this.EAR_3_12_3=EAR_3_12_3;}
    @Column(name = "EAR_3_12_3_1")
    @JsonProperty("EAR-3-12-3-1")
    private String EAR_3_12_3_1; // 其他变异分支血管
    public String getEAR_3_12_3_1() {  return this.EAR_3_12_3_1;}
    @JsonProperty("EAR-3-12-3-1")
    public void setEAR_3_12_3_1(final String EAR_3_12_3_1) { this.EAR_3_12_3_1=EAR_3_12_3_1;}
    @Column(name = "EAR_4_4_4")
    @JsonProperty("EAR-4-4-4")
    private String EAR_4_4_4; // TEVAR支架直径的选择
    public String getEAR_4_4_4() {  return this.EAR_4_4_4;}
    @JsonProperty("EAR-4-4-4")
    public void setEAR_4_4_4(final String EAR_4_4_4) { this.EAR_4_4_4=EAR_4_4_4;}
    @Column(name = "EAR_4_4_4_1")
    @JsonProperty("EAR-4-4-4-1")
    private String EAR_4_4_4_1; // TEVAR 手术患者的锚定区直径(mm)
    public String getEAR_4_4_4_1() {  return this.EAR_4_4_4_1;}
    @JsonProperty("EAR-4-4-4-1")
    public void setEAR_4_4_4_1(final String EAR_4_4_4_1) { this.EAR_4_4_4_1=EAR_4_4_4_1;}
    @Column(name = "EAR_4_4_4_2")
    @JsonProperty("EAR-4-4-4-2")
    private String EAR_4_4_4_2; // TEVAR 术中支架直径(mm)
    public String getEAR_4_4_4_2() {  return this.EAR_4_4_4_2;}
    @JsonProperty("EAR-4-4-4-2")
    public void setEAR_4_4_4_2(final String EAR_4_4_4_2) { this.EAR_4_4_4_2=EAR_4_4_4_2;}
    @Column(name = "EAR_4_4_4_3")
    @JsonProperty("EAR-4-4-4-3")
    private String EAR_4_4_4_3; // TEVAR 术中支架直径放大率(%)
    public String getEAR_4_4_4_3() {  return this.EAR_4_4_4_3;}
    @JsonProperty("EAR-4-4-4-3")
    public void setEAR_4_4_4_3(final String EAR_4_4_4_3) { this.EAR_4_4_4_3=EAR_4_4_4_3;}
    @Column(name = "EAR_4_4_4_4")
    @JsonProperty("EAR-4-4-4-4")
    private String EAR_4_4_4_4; // TEVAR 术中支架长度(mm)
    public String getEAR_4_4_4_4() {  return this.EAR_4_4_4_4;}
    @JsonProperty("EAR-4-4-4-4")
    public void setEAR_4_4_4_4(final String EAR_4_4_4_4) { this.EAR_4_4_4_4=EAR_4_4_4_4;}
    @Column(name = "EAR_4_4_6")
    @JsonProperty("EAR-4-4-6")
    private String EAR_4_4_6; // EVAR支架直径的选择
    public String getEAR_4_4_6() {  return this.EAR_4_4_6;}
    @JsonProperty("EAR-4-4-6")
    public void setEAR_4_4_6(final String EAR_4_4_6) { this.EAR_4_4_6=EAR_4_4_6;}
    @Column(name = "EAR_4_4_6_1")
    @JsonProperty("EAR-4-4-6-1")
    private String EAR_4_4_6_1; // EVAR 手术患者的锚定区直径(mm)
    public String getEAR_4_4_6_1() {  return this.EAR_4_4_6_1;}
    @JsonProperty("EAR-4-4-6-1")
    public void setEAR_4_4_6_1(final String EAR_4_4_6_1) { this.EAR_4_4_6_1=EAR_4_4_6_1;}
    @Column(name = "EAR_4_4_6_2")
    @JsonProperty("EAR-4-4-6-2")
    private String EAR_4_4_6_2; // EVAR 术中支架直径(mm)
    public String getEAR_4_4_6_2() {  return this.EAR_4_4_6_2;}
    @JsonProperty("EAR-4-4-6-2")
    public void setEAR_4_4_6_2(final String EAR_4_4_6_2) { this.EAR_4_4_6_2=EAR_4_4_6_2;}
    @Column(name = "EAR_4_4_6_3")
    @JsonProperty("EAR-4-4-6-3")
    private String EAR_4_4_6_3; // EVAR 术中支架直径放大率(%)
    public String getEAR_4_4_6_3() {  return this.EAR_4_4_6_3;}
    @JsonProperty("EAR-4-4-6-3")
    public void setEAR_4_4_6_3(final String EAR_4_4_6_3) { this.EAR_4_4_6_3=EAR_4_4_6_3;}
    @Column(name = "EAR_4_4_6_4")
    @JsonProperty("EAR-4-4-6-4")
    private String EAR_4_4_6_4; // EVAR 术中支架长度mm)
    public String getEAR_4_4_6_4() {  return this.EAR_4_4_6_4;}
    @JsonProperty("EAR-4-4-6-4")
    public void setEAR_4_4_6_4(final String EAR_4_4_6_4) { this.EAR_4_4_6_4=EAR_4_4_6_4;}
    @Column(name = "EAR_4_5_1")
    @JsonProperty("EAR-4-5-1")
    private String EAR_4_5_1; // 是否中转主动脉开放手术
    public String getEAR_4_5_1() {  return this.EAR_4_5_1;}
    @JsonProperty("EAR-4-5-1")
    public void setEAR_4_5_1(final String EAR_4_5_1) { this.EAR_4_5_1=EAR_4_5_1;}
    @Column(name = "EAR_4_5_2")
    @JsonProperty("EAR-4-5-2")
    private String EAR_4_5_2; // 开放手术ICD-9-CM-3编码及名称
    public String getEAR_4_5_2() {  return this.EAR_4_5_2;}
    @JsonProperty("EAR-4-5-2")
    public void setEAR_4_5_2(final String EAR_4_5_2) { this.EAR_4_5_2=EAR_4_5_2;}
    @Column(name = "EAR_4_5_2_1")
    @JsonProperty("EAR-4-5-2-1")
    private String EAR_4_5_2_1; // 其他ICD-9-CM-3编码及名称
    public String getEAR_4_5_2_1() {  return this.EAR_4_5_2_1;}
    @JsonProperty("EAR-4-5-2-1")
    public void setEAR_4_5_2_1(final String EAR_4_5_2_1) { this.EAR_4_5_2_1=EAR_4_5_2_1;}
    @Column(name = "EAR_5_1_1")
    @JsonProperty("EAR-5-1-1")
    private String EAR_5_1_1; // 是否EAR术后实施机械通气
    public String getEAR_5_1_1() {  return this.EAR_5_1_1;}
    @JsonProperty("EAR-5-1-1")
    public void setEAR_5_1_1(final String EAR_5_1_1) { this.EAR_5_1_1=EAR_5_1_1;}
    @Column(name = "EAR_5_1_2")
    @JsonProperty("EAR-5-1-2")
    private String EAR_5_1_2; // 机械通气 起始日期时间
    public String getEAR_5_1_2() {  return this.EAR_5_1_2;}
    @JsonProperty("EAR-5-1-2")
    public void setEAR_5_1_2(final String EAR_5_1_2) { this.EAR_5_1_2=EAR_5_1_2;}
    @Column(name = "EAR_5_1_3")
    @JsonProperty("EAR-5-1-3")
    private String EAR_5_1_3; // 机械通气 终止日期时间
    public String getEAR_5_1_3() {  return this.EAR_5_1_3;}
    @JsonProperty("EAR-5-1-3")
    public void setEAR_5_1_3(final String EAR_5_1_3) { this.EAR_5_1_3=EAR_5_1_3;}
    @Column(name = "EAR_5_2_1")
    @JsonProperty("EAR-5-2-1")
    private String EAR_5_2_1; // 是否术中主动脉支架植入后再次造影
    public String getEAR_5_2_1() {  return this.EAR_5_2_1;}
    @JsonProperty("EAR-5-2-1")
    public void setEAR_5_2_1(final String EAR_5_2_1) { this.EAR_5_2_1=EAR_5_2_1;}
    @Column(name = "EAR_5_2_2")
    @JsonProperty("EAR-5-2-2")
    private String EAR_5_2_2; // 术中末次造影是否存在内漏
    public String getEAR_5_2_2() {  return this.EAR_5_2_2;}
    @JsonProperty("EAR-5-2-2")
    public void setEAR_5_2_2(final String EAR_5_2_2) { this.EAR_5_2_2=EAR_5_2_2;}
    @Column(name = "EAR_5_2_3")
    @JsonProperty("EAR-5-2-3")
    private String EAR_5_2_3; // 是否进行术后主动脉CTA复查
    public String getEAR_5_2_3() {  return this.EAR_5_2_3;}
    @JsonProperty("EAR-5-2-3")
    public void setEAR_5_2_3(final String EAR_5_2_3) { this.EAR_5_2_3=EAR_5_2_3;}
    @Column(name = "EAR_5_2_4")
    @JsonProperty("EAR-5-2-4")
    private String EAR_5_2_4; // 术后首次主动脉CTA复查是否存在内漏
    public String getEAR_5_2_4() {  return this.EAR_5_2_4;}
    @JsonProperty("EAR-5-2-4")
    public void setEAR_5_2_4(final String EAR_5_2_4) { this.EAR_5_2_4=EAR_5_2_4;}
    @Column(name = "EAR_5_2_5")
    @JsonProperty("EAR-5-2-5")
    private String EAR_5_2_5; // 主动脉支架术后内漏CT诊断及分型
    public String getEAR_5_2_5() {  return this.EAR_5_2_5;}
    @JsonProperty("EAR-5-2-5")
    public void setEAR_5_2_5(final String EAR_5_2_5) { this.EAR_5_2_5=EAR_5_2_5;}
    @Column(name = "EAR_5_3_1")
    @JsonProperty("EAR-5-3-1")
    private String EAR_5_3_1; // 术后主动脉再干预情况
    public String getEAR_5_3_1() {  return this.EAR_5_3_1;}
    @JsonProperty("EAR-5-3-1")
    public void setEAR_5_3_1(final String EAR_5_3_1) { this.EAR_5_3_1=EAR_5_3_1;}
    @Column(name = "EAR_5_3_2")
    @JsonProperty("EAR-5-3-2")
    private String EAR_5_3_2; // 主动脉再干预的手术次数 ICD-9-CM-3编码与名称
    public String getEAR_5_3_2() {  return this.EAR_5_3_2;}
    @JsonProperty("EAR-5-3-2")
    public void setEAR_5_3_2(final String EAR_5_3_2) { this.EAR_5_3_2=EAR_5_3_2;}
    @Column(name = "EAR_5_3_2_2")
    @JsonProperty("EAR-5-3-2-2")
    private String EAR_5_3_2_2; // 主动脉再干预ICD-9-CM-3编码及名称
    public String getEAR_5_3_2_2() {  return this.EAR_5_3_2_2;}
    @JsonProperty("EAR-5-3-2-2")
    public void setEAR_5_3_2_2(final String EAR_5_3_2_2) { this.EAR_5_3_2_2=EAR_5_3_2_2;}
    @Column(name = "EAR_5_3_2_3")
    @JsonProperty("EAR-5-3-2-3")
    private String EAR_5_3_2_3; // 第1次主动脉再干预 起始日期时间
    public String getEAR_5_3_2_3() {  return this.EAR_5_3_2_3;}
    @JsonProperty("EAR-5-3-2-3")
    public void setEAR_5_3_2_3(final String EAR_5_3_2_3) { this.EAR_5_3_2_3=EAR_5_3_2_3;}
    @Column(name = "EAR_5_3_2_4")
    @JsonProperty("EAR-5-3-2-4")
    private String EAR_5_3_2_4; // 第1次主动脉再干预 终止日期时间
    public String getEAR_5_3_2_4() {  return this.EAR_5_3_2_4;}
    @JsonProperty("EAR-5-3-2-4")
    public void setEAR_5_3_2_4(final String EAR_5_3_2_4) { this.EAR_5_3_2_4=EAR_5_3_2_4;}
    @Column(name = "EAR_5_3_2_6")
    @JsonProperty("EAR-5-3-2-6")
    private String EAR_5_3_2_6; // 主动脉再干预ICD-9-CM-3编码及名称
    public String getEAR_5_3_2_6() {  return this.EAR_5_3_2_6;}
    @JsonProperty("EAR-5-3-2-6")
    public void setEAR_5_3_2_6(final String EAR_5_3_2_6) { this.EAR_5_3_2_6=EAR_5_3_2_6;}
    @Column(name = "EAR_5_3_2_7")
    @JsonProperty("EAR-5-3-2-7")
    private String EAR_5_3_2_7; // 第2次主动脉再干预 起始日期时间
    public String getEAR_5_3_2_7() {  return this.EAR_5_3_2_7;}
    @JsonProperty("EAR-5-3-2-7")
    public void setEAR_5_3_2_7(final String EAR_5_3_2_7) { this.EAR_5_3_2_7=EAR_5_3_2_7;}
    @Column(name = "EAR_5_3_2_8")
    @JsonProperty("EAR-5-3-2-8")
    private String EAR_5_3_2_8; // 第2次主动脉再干预 终止日期时间
    public String getEAR_5_3_2_8() {  return this.EAR_5_3_2_8;}
    @JsonProperty("EAR-5-3-2-8")
    public void setEAR_5_3_2_8(final String EAR_5_3_2_8) { this.EAR_5_3_2_8=EAR_5_3_2_8;}
    @Column(name = "EAR_5_3_2_10")
    @JsonProperty("EAR-5-3-2-10")
    private String EAR_5_3_2_10; // 主动脉再干预ICD-9-CM-3编码及名称
    public String getEAR_5_3_2_10() {  return this.EAR_5_3_2_10;}
    @JsonProperty("EAR-5-3-2-10")
    public void setEAR_5_3_2_10(final String EAR_5_3_2_10) { this.EAR_5_3_2_10=EAR_5_3_2_10;}
    @Column(name = "EAR_5_3_2_11")
    @JsonProperty("EAR-5-3-2-11")
    private String EAR_5_3_2_11; // 第3次主动脉再干预 起始日期时间
    public String getEAR_5_3_2_11() {  return this.EAR_5_3_2_11;}
    @JsonProperty("EAR-5-3-2-11")
    public void setEAR_5_3_2_11(final String EAR_5_3_2_11) { this.EAR_5_3_2_11=EAR_5_3_2_11;}
    @Column(name = "EAR_5_3_2_12")
    @JsonProperty("EAR-5-3-2-12")
    private String EAR_5_3_2_12; // 第3次主动脉再干预 终止日期时间
    public String getEAR_5_3_2_12() {  return this.EAR_5_3_2_12;}
    @JsonProperty("EAR-5-3-2-12")
    public void setEAR_5_3_2_12(final String EAR_5_3_2_12) { this.EAR_5_3_2_12=EAR_5_3_2_12;}
    @Column(name = "EAR_5_3_2_14")
    @JsonProperty("EAR-5-3-2-14")
    private String EAR_5_3_2_14; // 主动脉再干预ICD-9-CM-3编码及名称
    public String getEAR_5_3_2_14() {  return this.EAR_5_3_2_14;}
    @JsonProperty("EAR-5-3-2-14")
    public void setEAR_5_3_2_14(final String EAR_5_3_2_14) { this.EAR_5_3_2_14=EAR_5_3_2_14;}
    @Column(name = "EAR_5_3_2_15")
    @JsonProperty("EAR-5-3-2-15")
    private String EAR_5_3_2_15; // 第4次主动脉再干预 起始日期时间
    public String getEAR_5_3_2_15() {  return this.EAR_5_3_2_15;}
    @JsonProperty("EAR-5-3-2-15")
    public void setEAR_5_3_2_15(final String EAR_5_3_2_15) { this.EAR_5_3_2_15=EAR_5_3_2_15;}
    @Column(name = "EAR_5_3_2_16")
    @JsonProperty("EAR-5-3-2-16")
    private String EAR_5_3_2_16; // 第4次主动脉再干预 终止日期时间
    public String getEAR_5_3_2_16() {  return this.EAR_5_3_2_16;}
    @JsonProperty("EAR-5-3-2-16")
    public void setEAR_5_3_2_16(final String EAR_5_3_2_16) { this.EAR_5_3_2_16=EAR_5_3_2_16;}
    @Column(name = "EAR_5_3_2_18")
    @JsonProperty("EAR-5-3-2-18")
    private String EAR_5_3_2_18; // 主动脉再干预ICD-9-CM-3编码及名称
    public String getEAR_5_3_2_18() {  return this.EAR_5_3_2_18;}
    @JsonProperty("EAR-5-3-2-18")
    public void setEAR_5_3_2_18(final String EAR_5_3_2_18) { this.EAR_5_3_2_18=EAR_5_3_2_18;}
    @Column(name = "EAR_5_3_2_19")
    @JsonProperty("EAR-5-3-2-19")
    private String EAR_5_3_2_19; // 第5次主动脉再干预 起始日期时间
    public String getEAR_5_3_2_19() {  return this.EAR_5_3_2_19;}
    @JsonProperty("EAR-5-3-2-19")
    public void setEAR_5_3_2_19(final String EAR_5_3_2_19) { this.EAR_5_3_2_19=EAR_5_3_2_19;}
    @Column(name = "EAR_5_3_2_20")
    @JsonProperty("EAR-5-3-2-20")
    private String EAR_5_3_2_20; // 第5次主动脉再干预 终止日期时间
    public String getEAR_5_3_2_20() {  return this.EAR_5_3_2_20;}
    @JsonProperty("EAR-5-3-2-20")
    public void setEAR_5_3_2_20(final String EAR_5_3_2_20) { this.EAR_5_3_2_20=EAR_5_3_2_20;}
    @Column(name = "EAR_5_4_1")
    @JsonProperty("EAR-5-4-1")
    private String EAR_5_4_1; // 是否有术后入路血管再次干预
    public String getEAR_5_4_1() {  return this.EAR_5_4_1;}
    @JsonProperty("EAR-5-4-1")
    public void setEAR_5_4_1(final String EAR_5_4_1) { this.EAR_5_4_1=EAR_5_4_1;}
    @Column(name = "EAR_5_4_2")
    @JsonProperty("EAR-5-4-2")
    private String EAR_5_4_2; // 进入血管通路
    public String getEAR_5_4_2() {  return this.EAR_5_4_2;}
    @JsonProperty("EAR-5-4-2")
    public void setEAR_5_4_2(final String EAR_5_4_2) { this.EAR_5_4_2=EAR_5_4_2;}
    @Column(name = "EAR_5_4_2_1")
    @JsonProperty("EAR-5-4-2-1")
    private String EAR_5_4_2_1; // 其他通路
    public String getEAR_5_4_2_1() {  return this.EAR_5_4_2_1;}
    @JsonProperty("EAR-5-4-2-1")
    public void setEAR_5_4_2_1(final String EAR_5_4_2_1) { this.EAR_5_4_2_1=EAR_5_4_2_1;}
    @Column(name = "EAR_5_4_3")
    @JsonProperty("EAR-5-4-3")
    private String EAR_5_4_3; // 入路血管再次干预可能的原因
    public String getEAR_5_4_3() {  return this.EAR_5_4_3;}
    @JsonProperty("EAR-5-4-3")
    public void setEAR_5_4_3(final String EAR_5_4_3) { this.EAR_5_4_3=EAR_5_4_3;}
    @Column(name = "EAR_5_4_3_1")
    @JsonProperty("EAR-5-4-3-1")
    private String EAR_5_4_3_1; // 其他可能的原因
    public String getEAR_5_4_3_1() {  return this.EAR_5_4_3_1;}
    @JsonProperty("EAR-5-4-3-1")
    public void setEAR_5_4_3_1(final String EAR_5_4_3_1) { this.EAR_5_4_3_1=EAR_5_4_3_1;}
    @Column(name = "EAR_5_4_4")
    @JsonProperty("EAR-5-4-4")
    private String EAR_5_4_4; // 入路血管再次干预模式
    public String getEAR_5_4_4() {  return this.EAR_5_4_4;}
    @JsonProperty("EAR-5-4-4")
    public void setEAR_5_4_4(final String EAR_5_4_4) { this.EAR_5_4_4=EAR_5_4_4;}
    @Column(name = "EAR_5_4_4_1")
    @JsonProperty("EAR-5-4-4-1")
    private String EAR_5_4_4_1; // 其他干预模式
    public String getEAR_5_4_4_1() {  return this.EAR_5_4_4_1;}
    @JsonProperty("EAR-5-4-4-1")
    public void setEAR_5_4_4_1(final String EAR_5_4_4_1) { this.EAR_5_4_4_1=EAR_5_4_4_1;}
    @Column(name = "EAR_5_4_5")
    @JsonProperty("EAR-5-4-5")
    private String EAR_5_4_5; // 入路血管再次干预日期时间
    public String getEAR_5_4_5() {  return this.EAR_5_4_5;}
    @JsonProperty("EAR-5-4-5")
    public void setEAR_5_4_5(final String EAR_5_4_5) { this.EAR_5_4_5=EAR_5_4_5;}
    @Column(name = "EAR_5_5_1")
    @JsonProperty("EAR-5-5-1")
    private String EAR_5_5_1; // 术后首次实验室检查结果
    public String getEAR_5_5_1() {  return this.EAR_5_5_1;}
    @JsonProperty("EAR-5-5-1")
    public void setEAR_5_5_1(final String EAR_5_5_1) { this.EAR_5_5_1=EAR_5_5_1;}
    @Column(name = "EAR_5_5_2_1")
    @JsonProperty("EAR-5-5-2-1")
    private String EAR_5_5_2_1; // 丙氨酸氨基转移酶(IU/L)
    public String getEAR_5_5_2_1() {  return this.EAR_5_5_2_1;}
    @JsonProperty("EAR-5-5-2-1")
    public void setEAR_5_5_2_1(final String EAR_5_5_2_1) { this.EAR_5_5_2_1=EAR_5_5_2_1;}
    @Column(name = "EAR_5_5_2_2")
    @JsonProperty("EAR-5-5-2-2")
    private String EAR_5_5_2_2; // 天门冬氨酸氨基转移酶(IU/L)
    public String getEAR_5_5_2_2() {  return this.EAR_5_5_2_2;}
    @JsonProperty("EAR-5-5-2-2")
    public void setEAR_5_5_2_2(final String EAR_5_5_2_2) { this.EAR_5_5_2_2=EAR_5_5_2_2;}
    @Column(name = "EAR_5_5_2_3")
    @JsonProperty("EAR-5-5-2-3")
    private String EAR_5_5_2_3; // 肌酐(umol/L)
    public String getEAR_5_5_2_3() {  return this.EAR_5_5_2_3;}
    @JsonProperty("EAR-5-5-2-3")
    public void setEAR_5_5_2_3(final String EAR_5_5_2_3) { this.EAR_5_5_2_3=EAR_5_5_2_3;}
    @Column(name = "EAR_5_5_2_4")
    @JsonProperty("EAR-5-5-2-4")
    private String EAR_5_5_2_4; // 尿素氮(mmol/L)
    public String getEAR_5_5_2_4() {  return this.EAR_5_5_2_4;}
    @JsonProperty("EAR-5-5-2-4")
    public void setEAR_5_5_2_4(final String EAR_5_5_2_4) { this.EAR_5_5_2_4=EAR_5_5_2_4;}
    @Column(name = "EAR_5_5_2_5")
    @JsonProperty("EAR-5-5-2-5")
    private String EAR_5_5_2_5; // 高敏肌钙蛋白(ng/ml)
    public String getEAR_5_5_2_5() {  return this.EAR_5_5_2_5;}
    @JsonProperty("EAR-5-5-2-5")
    public void setEAR_5_5_2_5(final String EAR_5_5_2_5) { this.EAR_5_5_2_5=EAR_5_5_2_5;}
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
    @Column(name = "CM_1_6_4")
    @JsonProperty("CM-1-6-4")
    private String CM_1_6_4; // 术后是否使用抗菌药物
    public String getCM_1_6_4() {  return this.CM_1_6_4;}
    @JsonProperty("CM-1-6-4")
    public void setCM_1_6_4(final String CM_1_6_4) { this.CM_1_6_4=CM_1_6_4;}
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
    @Column(name = "EAR_7_1_1")
    @JsonProperty("EAR-7-1-1")
    private String EAR_7_1_1; // 出血量(ml)
    public String getEAR_7_1_1() {  return this.EAR_7_1_1;}
    @JsonProperty("EAR-7-1-1")
    public void setEAR_7_1_1(final String EAR_7_1_1) { this.EAR_7_1_1=EAR_7_1_1;}
    @Column(name = "EAR_7_1_2")
    @JsonProperty("EAR-7-1-2")
    private String EAR_7_1_2; // 是否实施输血
    public String getEAR_7_1_2() {  return this.EAR_7_1_2;}
    @JsonProperty("EAR-7-1-2")
    public void setEAR_7_1_2(final String EAR_7_1_2) { this.EAR_7_1_2=EAR_7_1_2;}
    @Column(name = "EAR_7_1_3")
    @JsonProperty("EAR-7-1-3")
    private String EAR_7_1_3; // 用血类别与输血量的选择
    public String getEAR_7_1_3() {  return this.EAR_7_1_3;}
    @JsonProperty("EAR-7-1-3")
    public void setEAR_7_1_3(final String EAR_7_1_3) { this.EAR_7_1_3=EAR_7_1_3;}
    @Column(name = "EAR_7_1_4_1")
    @JsonProperty("EAR-7-1-4-1")
    private String EAR_7_1_4_1; // 全血(ml)
    public String getEAR_7_1_4_1() {  return this.EAR_7_1_4_1;}
    @JsonProperty("EAR-7-1-4-1")
    public void setEAR_7_1_4_1(final String EAR_7_1_4_1) { this.EAR_7_1_4_1=EAR_7_1_4_1;}
    @Column(name = "EAR_7_1_4_2")
    @JsonProperty("EAR-7-1-4-2")
    private String EAR_7_1_4_2; // 成份血(ml)
    public String getEAR_7_1_4_2() {  return this.EAR_7_1_4_2;}
    @JsonProperty("EAR-7-1-4-2")
    public void setEAR_7_1_4_2(final String EAR_7_1_4_2) { this.EAR_7_1_4_2=EAR_7_1_4_2;}
    @Column(name = "EAR_7_1_4_3")
    @JsonProperty("EAR-7-1-4-3")
    private String EAR_7_1_4_3; // 血浆(ml)
    public String getEAR_7_1_4_3() {  return this.EAR_7_1_4_3;}
    @JsonProperty("EAR-7-1-4-3")
    public void setEAR_7_1_4_3(final String EAR_7_1_4_3) { this.EAR_7_1_4_3=EAR_7_1_4_3;}
    @Column(name = "EAR_7_1_4_4")
    @JsonProperty("EAR-7-1-4-4")
    private String EAR_7_1_4_4; // 自体输血(ml)
    public String getEAR_7_1_4_4() {  return this.EAR_7_1_4_4;}
    @JsonProperty("EAR-7-1-4-4")
    public void setEAR_7_1_4_4(final String EAR_7_1_4_4) { this.EAR_7_1_4_4=EAR_7_1_4_4;}
    @Column(name = "EAR_7_1_4_5")
    @JsonProperty("EAR-7-1-4-5")
    private String EAR_7_1_4_5; // 术中回收血(ml)
    public String getEAR_7_1_4_5() {  return this.EAR_7_1_4_5;}
    @JsonProperty("EAR-7-1-4-5")
    public void setEAR_7_1_4_5(final String EAR_7_1_4_5) { this.EAR_7_1_4_5=EAR_7_1_4_5;}
    @Column(name = "CM_2_1")
    @JsonProperty("CM-2-1")
    private String CM_2_1; // 是否有（通用）手术后并发症
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
    @Column(name = "EAR_3_6_14")
    @JsonProperty("EAR-3-6-14")
    private String EAR_3_6_14; // 住院患者发生压疮
    public String getEAR_3_6_14() {  return this.EAR_3_6_14;}
    @JsonProperty("EAR-3-6-14")
    public void setEAR_3_6_14(final String EAR_3_6_14) { this.EAR_3_6_14=EAR_3_6_14;}
    @Column(name = "EAR_3_6_15")
    @JsonProperty("EAR-3-6-15")
    private String EAR_3_6_15; // 循环系统术后并发症
    public String getEAR_3_6_15() {  return this.EAR_3_6_15;}
    @JsonProperty("EAR-3-6-15")
    public void setEAR_3_6_15(final String EAR_3_6_15) { this.EAR_3_6_15=EAR_3_6_15;}
    @Column(name = "EAR_3_6_16")
    @JsonProperty("EAR-3-6-16")
    private String EAR_3_6_16; // 心脏和血管植入物的并发症(不包括脓毒症)
    public String getEAR_3_6_16() {  return this.EAR_3_6_16;}
    @JsonProperty("EAR-3-6-16")
    public void setEAR_3_6_16(final String EAR_3_6_16) { this.EAR_3_6_16=EAR_3_6_16;}
    @Column(name = "EAR_3_6_17")
    @JsonProperty("EAR-3-6-17")
    private String EAR_3_6_17; // 术后并发脑卒中/脑血管事件
    public String getEAR_3_6_17() {  return this.EAR_3_6_17;}
    @JsonProperty("EAR-3-6-17")
    public void setEAR_3_6_17(final String EAR_3_6_17) { this.EAR_3_6_17=EAR_3_6_17;}
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
    @Column(name = "EAR_8_2_1")
    @JsonProperty("EAR-8-2-1")
    private String EAR_8_2_1; // 是否有手术后脑卒中/脑血管事件
    public String getEAR_8_2_1() {  return this.EAR_8_2_1;}
    @JsonProperty("EAR-8-2-1")
    public void setEAR_8_2_1(final String EAR_8_2_1) { this.EAR_8_2_1=EAR_8_2_1;}
    @Column(name = "EAR_8_2_2")
    @JsonProperty("EAR-8-2-2")
    private String EAR_8_2_2; // 头颅影像CT检查结果
    public String getEAR_8_2_2() {  return this.EAR_8_2_2;}
    @JsonProperty("EAR-8-2-2")
    public void setEAR_8_2_2(final String EAR_8_2_2) { this.EAR_8_2_2=EAR_8_2_2;}
    @Column(name = "EAR_8_2_2_1")
    @JsonProperty("EAR-8-2-2-1")
    private String EAR_8_2_2_1; // 其他检查结果
    public String getEAR_8_2_2_1() {  return this.EAR_8_2_2_1;}
    @JsonProperty("EAR-8-2-2-1")
    public void setEAR_8_2_2_1(final String EAR_8_2_2_1) { this.EAR_8_2_2_1=EAR_8_2_2_1;}
    @Column(name = "EAR_8_2_3")
    @JsonProperty("EAR-8-2-3")
    private String EAR_8_2_3; // 出院诊断/术后特指并发症 ICD-10 编码与名称
    public String getEAR_8_2_3() {  return this.EAR_8_2_3;}
    @JsonProperty("EAR-8-2-3")
    public void setEAR_8_2_3(final String EAR_8_2_3) { this.EAR_8_2_3=EAR_8_2_3;}
    @Column(name = "EAR_8_2_4")
    @JsonProperty("EAR-8-2-4")
    private String EAR_8_2_4; // 出院时是否进行卒中后功能评估(mRS评分)★
    public String getEAR_8_2_4() {  return this.EAR_8_2_4;}
    @JsonProperty("EAR-8-2-4")
    public void setEAR_8_2_4(final String EAR_8_2_4) { this.EAR_8_2_4=EAR_8_2_4;}
    @Column(name = "EAR_8_2_5")
    @JsonProperty("EAR-8-2-5")
    private String EAR_8_2_5; // 卒中后功能评估(mRS评分)★
    public String getEAR_8_2_5() {  return this.EAR_8_2_5;}
    @JsonProperty("EAR-8-2-5")
    public void setEAR_8_2_5(final String EAR_8_2_5) { this.EAR_8_2_5=EAR_8_2_5;}
    @Column(name = "EAR_8_3_1")
    @JsonProperty("EAR-8-3-1")
    private String EAR_8_3_1; // 是否有手术后急性肾损伤
    public String getEAR_8_3_1() {  return this.EAR_8_3_1;}
    @JsonProperty("EAR-8-3-1")
    public void setEAR_8_3_1(final String EAR_8_3_1) { this.EAR_8_3_1=EAR_8_3_1;}
    @Column(name = "EAR_8_3_2")
    @JsonProperty("EAR-8-3-2")
    private String EAR_8_3_2; // 出院诊断/手术后急性肾损伤 ICD-10 编码与名称
    public String getEAR_8_3_2() {  return this.EAR_8_3_2;}
    @JsonProperty("EAR-8-3-2")
    public void setEAR_8_3_2(final String EAR_8_3_2) { this.EAR_8_3_2=EAR_8_3_2;}
    @Column(name = "EAR_8_3_3")
    @JsonProperty("EAR-8-3-3")
    private String EAR_8_3_3; // 出院治疗性操作 ICD-9-CM-3 编码与名称
    public String getEAR_8_3_3() {  return this.EAR_8_3_3;}
    @JsonProperty("EAR-8-3-3")
    public void setEAR_8_3_3(final String EAR_8_3_3) { this.EAR_8_3_3=EAR_8_3_3;}
    @Column(name = "EAR_8_4_1")
    @JsonProperty("EAR-8-4-1")
    private String EAR_8_4_1; // 是否有手术后脊髓损伤
    public String getEAR_8_4_1() {  return this.EAR_8_4_1;}
    @JsonProperty("EAR-8-4-1")
    public void setEAR_8_4_1(final String EAR_8_4_1) { this.EAR_8_4_1=EAR_8_4_1;}
    @Column(name = "EAR_8_4_2")
    @JsonProperty("EAR-8-4-2")
    private String EAR_8_4_2; // 出院诊断/手术后脊髓损伤 ICD-10 编码与名称
    public String getEAR_8_4_2() {  return this.EAR_8_4_2;}
    @JsonProperty("EAR-8-4-2")
    public void setEAR_8_4_2(final String EAR_8_4_2) { this.EAR_8_4_2=EAR_8_4_2;}
    @Column(name = "EAR_8_4_3_1")
    @JsonProperty("EAR-8-4-3-1")
    private String EAR_8_4_3_1; // 颈椎C
    public String getEAR_8_4_3_1() {  return this.EAR_8_4_3_1;}
    @JsonProperty("EAR-8-4-3-1")
    public void setEAR_8_4_3_1(final String EAR_8_4_3_1) { this.EAR_8_4_3_1=EAR_8_4_3_1;}
    @Column(name = "EAR_8_4_3_2")
    @JsonProperty("EAR-8-4-3-2")
    private String EAR_8_4_3_2; // 胸椎T
    public String getEAR_8_4_3_2() {  return this.EAR_8_4_3_2;}
    @JsonProperty("EAR-8-4-3-2")
    public void setEAR_8_4_3_2(final String EAR_8_4_3_2) { this.EAR_8_4_3_2=EAR_8_4_3_2;}
    @Column(name = "EAR_8_4_3_3")
    @JsonProperty("EAR-8-4-3-3")
    private String EAR_8_4_3_3; // 腰椎L
    public String getEAR_8_4_3_3() {  return this.EAR_8_4_3_3;}
    @JsonProperty("EAR-8-4-3-3")
    public void setEAR_8_4_3_3(final String EAR_8_4_3_3) { this.EAR_8_4_3_3=EAR_8_4_3_3;}
    @Column(name = "EAR_8_4_4")
    @JsonProperty("EAR-8-4-4")
    private String EAR_8_4_4; // 是否进行脊髓损伤评估
    public String getEAR_8_4_4() {  return this.EAR_8_4_4;}
    @JsonProperty("EAR-8-4-4")
    public void setEAR_8_4_4(final String EAR_8_4_4) { this.EAR_8_4_4=EAR_8_4_4;}
    @Column(name = "EAR_8_4_5")
    @JsonProperty("EAR-8-4-5")
    private String EAR_8_4_5; // 脊髓损伤ASIA分级★
    public String getEAR_8_4_5() {  return this.EAR_8_4_5;}
    @JsonProperty("EAR-8-4-5")
    public void setEAR_8_4_5(final String EAR_8_4_5) { this.EAR_8_4_5=EAR_8_4_5;}
    @Column(name = "EAR_8_5_1")
    @JsonProperty("EAR-8-5-1")
    private String EAR_8_5_1; // 是否有手术后急性心机梗死
    public String getEAR_8_5_1() {  return this.EAR_8_5_1;}
    @JsonProperty("EAR-8-5-1")
    public void setEAR_8_5_1(final String EAR_8_5_1) { this.EAR_8_5_1=EAR_8_5_1;}
    @Column(name = "EAR_8_5_2")
    @JsonProperty("EAR-8-5-2")
    private String EAR_8_5_2; // 出院诊断/手术后急性心机梗死 ICD-10 编码与名称
    public String getEAR_8_5_2() {  return this.EAR_8_5_2;}
    @JsonProperty("EAR-8-5-2")
    public void setEAR_8_5_2(final String EAR_8_5_2) { this.EAR_8_5_2=EAR_8_5_2;}
    @Column(name = "EAR_8_5_3_2")
    @JsonProperty("EAR-8-5-3-2")
    private String EAR_8_5_3_2; // 末次GRACE危险评估是否有记录
    public String getEAR_8_5_3_2() {  return this.EAR_8_5_3_2;}
    @JsonProperty("EAR-8-5-3-2")
    public void setEAR_8_5_3_2(final String EAR_8_5_3_2) { this.EAR_8_5_3_2=EAR_8_5_3_2;}
    @Column(name = "EAR_8_5_3_1")
    @JsonProperty("EAR-8-5-3-1")
    private String EAR_8_5_3_1; // 末次GRACE危险评估
    public String getEAR_8_5_3_1() {  return this.EAR_8_5_3_1;}
    @JsonProperty("EAR-8-5-3-1")
    public void setEAR_8_5_3_1(final String EAR_8_5_3_1) { this.EAR_8_5_3_1=EAR_8_5_3_1;}
    @Column(name = "EAR_8_5_3_3")
    @JsonProperty("EAR-8-5-3-3")
    private String EAR_8_5_3_3; // GRACE危险评估分层的选择
    public String getEAR_8_5_3_3() {  return this.EAR_8_5_3_3;}
    @JsonProperty("EAR-8-5-3-3")
    public void setEAR_8_5_3_3(final String EAR_8_5_3_3) { this.EAR_8_5_3_3=EAR_8_5_3_3;}
    @Column(name = "EAR_8_6_1")
    @JsonProperty("EAR-8-6-1")
    private String EAR_8_6_1; // 是否因手术后并发症再次手术
    public String getEAR_8_6_1() {  return this.EAR_8_6_1;}
    @JsonProperty("EAR-8-6-1")
    public void setEAR_8_6_1(final String EAR_8_6_1) { this.EAR_8_6_1=EAR_8_6_1;}
    @Column(name = "EAR_8_6_2")
    @JsonProperty("EAR-8-6-2")
    private String EAR_8_6_2; // 再次手术开始（切皮）日期时间 
    public String getEAR_8_6_2() {  return this.EAR_8_6_2;}
    @JsonProperty("EAR-8-6-2")
    public void setEAR_8_6_2(final String EAR_8_6_2) { this.EAR_8_6_2=EAR_8_6_2;}
    @Column(name = "EAR_8_6_3")
    @JsonProperty("EAR-8-6-3")
    private String EAR_8_6_3; // 再次手术结束（缝皮结束）日期时间
    public String getEAR_8_6_3() {  return this.EAR_8_6_3;}
    @JsonProperty("EAR-8-6-3")
    public void setEAR_8_6_3(final String EAR_8_6_3) { this.EAR_8_6_3=EAR_8_6_3;}
    @Column(name = "EAR_8_6_4")
    @JsonProperty("EAR-8-6-4")
    private String EAR_8_6_4; // 再次手术的ICD-9-CM-3编码与名称
    public String getEAR_8_6_4() {  return this.EAR_8_6_4;}
    @JsonProperty("EAR-8-6-4")
    public void setEAR_8_6_4(final String EAR_8_6_4) { this.EAR_8_6_4=EAR_8_6_4;}
    @Column(name = "EAR_8_6_5")
    @JsonProperty("EAR-8-6-5")
    private String EAR_8_6_5; // 术后实验室检查
    public String getEAR_8_6_5() {  return this.EAR_8_6_5;}
    @JsonProperty("EAR-8-6-5")
    public void setEAR_8_6_5(final String EAR_8_6_5) { this.EAR_8_6_5=EAR_8_6_5;}
    @Column(name = "EAR_8_6_5_1")
    @JsonProperty("EAR-8-6-5-1")
    private String EAR_8_6_5_1; // 丙氨酸氨基转移酶(IU/L)
    public String getEAR_8_6_5_1() {  return this.EAR_8_6_5_1;}
    @JsonProperty("EAR-8-6-5-1")
    public void setEAR_8_6_5_1(final String EAR_8_6_5_1) { this.EAR_8_6_5_1=EAR_8_6_5_1;}
    @Column(name = "EAR_8_6_5_2")
    @JsonProperty("EAR-8-6-5-2")
    private String EAR_8_6_5_2; // 天门冬氨酸氨基转移酶(IU/L)
    public String getEAR_8_6_5_2() {  return this.EAR_8_6_5_2;}
    @JsonProperty("EAR-8-6-5-2")
    public void setEAR_8_6_5_2(final String EAR_8_6_5_2) { this.EAR_8_6_5_2=EAR_8_6_5_2;}
    @Column(name = "EAR_8_6_5_3")
    @JsonProperty("EAR-8-6-5-3")
    private String EAR_8_6_5_3; // 肌酐(umol/L)
    public String getEAR_8_6_5_3() {  return this.EAR_8_6_5_3;}
    @JsonProperty("EAR-8-6-5-3")
    public void setEAR_8_6_5_3(final String EAR_8_6_5_3) { this.EAR_8_6_5_3=EAR_8_6_5_3;}
    @Column(name = "EAR_8_6_5_4")
    @JsonProperty("EAR-8-6-5-4")
    private String EAR_8_6_5_4; // 尿素氮(mmol/L)
    public String getEAR_8_6_5_4() {  return this.EAR_8_6_5_4;}
    @JsonProperty("EAR-8-6-5-4")
    public void setEAR_8_6_5_4(final String EAR_8_6_5_4) { this.EAR_8_6_5_4=EAR_8_6_5_4;}
    @Column(name = "EAR_8_6_5_5")
    @JsonProperty("EAR-8-6-5-5")
    private String EAR_8_6_5_5; // 高敏肌钙蛋白(ng/ml)
    public String getEAR_8_6_5_5() {  return this.EAR_8_6_5_5;}
    @JsonProperty("EAR-8-6-5-5")
    public void setEAR_8_6_5_5(final String EAR_8_6_5_5) { this.EAR_8_6_5_5=EAR_8_6_5_5;}
    @Column(name = "CM_8_1_1")
    @JsonProperty("CM-8-1-1")
    private String CM_8_1_1; // 是否进行手术后疼痛强度评估
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
    @Column(name = "CM_8_2_1")
    @JsonProperty("CM-8-2-1")
    private String CM_8_2_1; // 是否进行手术后镇痛治疗
    public String getCM_8_2_1() {  return this.CM_8_2_1;}
    @JsonProperty("CM-8-2-1")
    public void setCM_8_2_1(final String CM_8_2_1) { this.CM_8_2_1=CM_8_2_1;}
    @Column(name = "CM_8_2_2")
    @JsonProperty("CM-8-2-2")
    private String CM_8_2_2; // 手术后镇痛治疗方式的选择
    public String getCM_8_2_2() {  return this.CM_8_2_2;}
    @JsonProperty("CM-8-2-2")
    public void setCM_8_2_2(final String CM_8_2_2) { this.CM_8_2_2=CM_8_2_2;}
    @Column(name = "CM_8_2_3")
    @JsonProperty("CM-8-2-3")
    private String CM_8_2_3; // 其他镇痛方法
    public String getCM_8_2_3() {  return this.CM_8_2_3;}
    @JsonProperty("CM-8-2-3")
    public void setCM_8_2_3(final String CM_8_2_3) { this.CM_8_2_3=CM_8_2_3;}
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
    @Column(name = "EAR_10_1_1")
    @JsonProperty("EAR-10-1-1")
    private String EAR_10_1_1; // 手术前健康教育项目的选择
    public String getEAR_10_1_1() {  return this.EAR_10_1_1;}
    @JsonProperty("EAR-10-1-1")
    public void setEAR_10_1_1(final String EAR_10_1_1) { this.EAR_10_1_1=EAR_10_1_1;}
    @Column(name = "EAR_10_2_1")
    @JsonProperty("EAR-10-2-1")
    private String EAR_10_2_1; // 手术后主要护理措施选择
    public String getEAR_10_2_1() {  return this.EAR_10_2_1;}
    @JsonProperty("EAR-10-2-1")
    public void setEAR_10_2_1(final String EAR_10_2_1) { this.EAR_10_2_1=EAR_10_2_1;}
    @Column(name = "EAR_10_2_2_1")
    @JsonProperty("EAR-10-2-2-1")
    private String EAR_10_2_2_1; // 心电监测、血压监测与循环维护
    public String getEAR_10_2_2_1() {  return this.EAR_10_2_2_1;}
    @JsonProperty("EAR-10-2-2-1")
    public void setEAR_10_2_2_1(final String EAR_10_2_2_1) { this.EAR_10_2_2_1=EAR_10_2_2_1;}
    @Column(name = "EAR_10_2_2_2")
    @JsonProperty("EAR-10-2-2-2")
    private String EAR_10_2_2_2; // 肾功能监护
    public String getEAR_10_2_2_2() {  return this.EAR_10_2_2_2;}
    @JsonProperty("EAR-10-2-2-2")
    public void setEAR_10_2_2_2(final String EAR_10_2_2_2) { this.EAR_10_2_2_2=EAR_10_2_2_2;}
    @Column(name = "EAR_10_2_2_3")
    @JsonProperty("EAR-10-2-2-3")
    private String EAR_10_2_2_3; // 脊髓的监测
    public String getEAR_10_2_2_3() {  return this.EAR_10_2_2_3;}
    @JsonProperty("EAR-10-2-2-3")
    public void setEAR_10_2_2_3(final String EAR_10_2_2_3) { this.EAR_10_2_2_3=EAR_10_2_2_3;}
    @Column(name = "EAR_10_2_2_4")
    @JsonProperty("EAR-10-2-2-4")
    private String EAR_10_2_2_4; // 下肢组织灌注量改变
    public String getEAR_10_2_2_4() {  return this.EAR_10_2_2_4;}
    @JsonProperty("EAR-10-2-2-4")
    public void setEAR_10_2_2_4(final String EAR_10_2_2_4) { this.EAR_10_2_2_4=EAR_10_2_2_4;}
    @Column(name = "EAR_10_2_2_5")
    @JsonProperty("EAR-10-2-2-5")
    private String EAR_10_2_2_5; // 合并糖尿病的护理
    public String getEAR_10_2_2_5() {  return this.EAR_10_2_2_5;}
    @JsonProperty("EAR-10-2-2-5")
    public void setEAR_10_2_2_5(final String EAR_10_2_2_5) { this.EAR_10_2_2_5=EAR_10_2_2_5;}
    @Column(name = "EAR_10_3_1")
    @JsonProperty("EAR-10-3-1")
    private String EAR_10_3_1; // 血运重建术后应当定期进行全面的临床和预后评估的选择
    public String getEAR_10_3_1() {  return this.EAR_10_3_1;}
    @JsonProperty("EAR-10-3-1")
    public void setEAR_10_3_1(final String EAR_10_3_1) { this.EAR_10_3_1=EAR_10_3_1;}
    @Column(name = "EAR_10_3_2")
    @JsonProperty("EAR-10-3-2")
    private String EAR_10_3_2; // 推荐选择健康食品，改变生活方式、饮食疗法及药物治疗的选择
    public String getEAR_10_3_2() {  return this.EAR_10_3_2;}
    @JsonProperty("EAR-10-3-2")
    public void setEAR_10_3_2(final String EAR_10_3_2) { this.EAR_10_3_2=EAR_10_3_2;}
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
    @Column(name = "EAR_4_1_1")
    @JsonProperty("EAR-4-1-1")
    private String EAR_4_1_1; // 是否EAR术后30天内实施主动脉CTA复查（包括住院期间和出院后）
    public String getEAR_4_1_1() {  return this.EAR_4_1_1;}
    @JsonProperty("EAR-4-1-1")
    public void setEAR_4_1_1(final String EAR_4_1_1) { this.EAR_4_1_1=EAR_4_1_1;}
    @Column(name = "EAR_4_1_2")
    @JsonProperty("EAR-4-1-2")
    private String EAR_4_1_2; // 术后第几天行主动脉CTA复查(天)
    public String getEAR_4_1_2() {  return this.EAR_4_1_2;}
    @JsonProperty("EAR-4-1-2")
    public void setEAR_4_1_2(final String EAR_4_1_2) { this.EAR_4_1_2=EAR_4_1_2;}
    @Column(name = "EAR_4_1_3")
    @JsonProperty("EAR-4-1-3")
    private String EAR_4_1_3; // 是否发现内漏
    public String getEAR_4_1_3() {  return this.EAR_4_1_3;}
    @JsonProperty("EAR-4-1-3")
    public void setEAR_4_1_3(final String EAR_4_1_3) { this.EAR_4_1_3=EAR_4_1_3;}
    @Column(name = "EAR_4_1_4")
    @JsonProperty("EAR-4-1-4")
    private String EAR_4_1_4; // 内漏CT诊断及分型
    public String getEAR_4_1_4() {  return this.EAR_4_1_4;}
    @JsonProperty("EAR-4-1-4")
    public void setEAR_4_1_4(final String EAR_4_1_4) { this.EAR_4_1_4=EAR_4_1_4;}
    @Column(name = "EAR_4_1_5")
    @JsonProperty("EAR-4-1-5")
    private String EAR_4_1_5; // 是否发现支架移位
    public String getEAR_4_1_5() {  return this.EAR_4_1_5;}
    @JsonProperty("EAR-4-1-5")
    public void setEAR_4_1_5(final String EAR_4_1_5) { this.EAR_4_1_5=EAR_4_1_5;}
    @Column(name = "EAR_4_1_6")
    @JsonProperty("EAR-4-1-6")
    private String EAR_4_1_6; // 是否发现逆撕夹层
    public String getEAR_4_1_6() {  return this.EAR_4_1_6;}
    @JsonProperty("EAR-4-1-6")
    public void setEAR_4_1_6(final String EAR_4_1_6) { this.EAR_4_1_6=EAR_4_1_6;}
    @Column(name = "EAR_4_2_1")
    @JsonProperty("EAR-4-2-1")
    private String EAR_4_2_1; // 术后30天随访情况
    public String getEAR_4_2_1() {  return this.EAR_4_2_1;}
    @JsonProperty("EAR-4-2-1")
    public void setEAR_4_2_1(final String EAR_4_2_1) { this.EAR_4_2_1=EAR_4_2_1;}
    @Column(name = "EAR_4_2_1_1")
    @JsonProperty("EAR-4-2-1-1")
    private String EAR_4_2_1_1; // 其他方式随访
    public String getEAR_4_2_1_1() {  return this.EAR_4_2_1_1;}
    @JsonProperty("EAR-4-2-1-1")
    public void setEAR_4_2_1_1(final String EAR_4_2_1_1) { this.EAR_4_2_1_1=EAR_4_2_1_1;}
    @Column(name = "EAR_4_2_2")
    @JsonProperty("EAR-4-2-2")
    private String EAR_4_2_2; // 术后30天随访是否死亡
    public String getEAR_4_2_2() {  return this.EAR_4_2_2;}
    @JsonProperty("EAR-4-2-2")
    public void setEAR_4_2_2(final String EAR_4_2_2) { this.EAR_4_2_2=EAR_4_2_2;}
    @Column(name = "EAR_4_2_2_1")
    @JsonProperty("EAR-4-2-2-1")
    private String EAR_4_2_2_1; // 死亡原因
    public String getEAR_4_2_2_1() {  return this.EAR_4_2_2_1;}
    @JsonProperty("EAR-4-2-2-1")
    public void setEAR_4_2_2_1(final String EAR_4_2_2_1) { this.EAR_4_2_2_1=EAR_4_2_2_1;}
    @Column(name = "EAR_4_2_2_2")
    @JsonProperty("EAR-4-2-2-2")
    private String EAR_4_2_2_2; // 非主动脉相关死亡
    public String getEAR_4_2_2_2() {  return this.EAR_4_2_2_2;}
    @JsonProperty("EAR-4-2-2-2")
    public void setEAR_4_2_2_2(final String EAR_4_2_2_2) { this.EAR_4_2_2_2=EAR_4_2_2_2;}
    @Column(name = "EAR_4_2_2_4")
    @JsonProperty("EAR-4-2-2-4")
    private String EAR_4_2_2_4; // 其他非主动脉相关
    public String getEAR_4_2_2_4() {  return this.EAR_4_2_2_4;}
    @JsonProperty("EAR-4-2-2-4")
    public void setEAR_4_2_2_4(final String EAR_4_2_2_4) { this.EAR_4_2_2_4=EAR_4_2_2_4;}
    @Column(name = "EAR_4_2_3")
    @JsonProperty("EAR-4-2-3")
    private String EAR_4_2_3; // 术后30天随访是否再入院
    public String getEAR_4_2_3() {  return this.EAR_4_2_3;}
    @JsonProperty("EAR-4-2-3")
    public void setEAR_4_2_3(final String EAR_4_2_3) { this.EAR_4_2_3=EAR_4_2_3;}
    @Column(name = "EAR_4_2_4")
    @JsonProperty("EAR-4-2-4")
    private String EAR_4_2_4; // 再入院原因
    public String getEAR_4_2_4() {  return this.EAR_4_2_4;}
    @JsonProperty("EAR-4-2-4")
    public void setEAR_4_2_4(final String EAR_4_2_4) { this.EAR_4_2_4=EAR_4_2_4;}
    @Column(name = "EAR_4_2_4_1")
    @JsonProperty("EAR-4-2-4-1")
    private String EAR_4_2_4_1; // 再入院其他原因
    public String getEAR_4_2_4_1() {  return this.EAR_4_2_4_1;}
    @JsonProperty("EAR-4-2-4-1")
    public void setEAR_4_2_4_1(final String EAR_4_2_4_1) { this.EAR_4_2_4_1=EAR_4_2_4_1;}
    @Column(name = "EAR_4_2_5")
    @JsonProperty("EAR-4-2-5")
    private String EAR_4_2_5; // 术后30天随访主动脉/入路血管再干预情况
    public String getEAR_4_2_5() {  return this.EAR_4_2_5;}
    @JsonProperty("EAR-4-2-5")
    public void setEAR_4_2_5(final String EAR_4_2_5) { this.EAR_4_2_5=EAR_4_2_5;}
    @Column(name = "EAR_4_2_6")
    @JsonProperty("EAR-4-2-6")
    private String EAR_4_2_6; // 术后30天并发症情况
    public String getEAR_4_2_6() {  return this.EAR_4_2_6;}
    @JsonProperty("EAR-4-2-6")
    public void setEAR_4_2_6(final String EAR_4_2_6) { this.EAR_4_2_6=EAR_4_2_6;}
    @Column(name = "EAR_4_2_6_1")
    @JsonProperty("EAR-4-2-6-1")
    private String EAR_4_2_6_1; // 心血管意外
    public String getEAR_4_2_6_1() {  return this.EAR_4_2_6_1;}
    @JsonProperty("EAR-4-2-6-1")
    public void setEAR_4_2_6_1(final String EAR_4_2_6_1) { this.EAR_4_2_6_1=EAR_4_2_6_1;}
    @Column(name = "EAR_4_2_6_2")
    @JsonProperty("EAR-4-2-6-2")
    private String EAR_4_2_6_2; // 其他心血管意外
    public String getEAR_4_2_6_2() {  return this.EAR_4_2_6_2;}
    @JsonProperty("EAR-4-2-6-2")
    public void setEAR_4_2_6_2(final String EAR_4_2_6_2) { this.EAR_4_2_6_2=EAR_4_2_6_2;}
    @Column(name = "EAR_4_2_6_3")
    @JsonProperty("EAR-4-2-6-3")
    private String EAR_4_2_6_3; // 脑卒中
    public String getEAR_4_2_6_3() {  return this.EAR_4_2_6_3;}
    @JsonProperty("EAR-4-2-6-3")
    public void setEAR_4_2_6_3(final String EAR_4_2_6_3) { this.EAR_4_2_6_3=EAR_4_2_6_3;}
    @Column(name = "EAR_4_2_7")
    @JsonProperty("EAR-4-2-7")
    private String EAR_4_2_7; // 卒中后功能评估(mRS评分)★
    public String getEAR_4_2_7() {  return this.EAR_4_2_7;}
    @JsonProperty("EAR-4-2-7")
    public void setEAR_4_2_7(final String EAR_4_2_7) { this.EAR_4_2_7=EAR_4_2_7;}
    @Column(name = "EAR_4_2_6_4")
    @JsonProperty("EAR-4-2-6-4")
    private String EAR_4_2_6_4; // 严重肺部并发症
    public String getEAR_4_2_6_4() {  return this.EAR_4_2_6_4;}
    @JsonProperty("EAR-4-2-6-4")
    public void setEAR_4_2_6_4(final String EAR_4_2_6_4) { this.EAR_4_2_6_4=EAR_4_2_6_4;}
    @Column(name = "EAR_4_2_6_5")
    @JsonProperty("EAR-4-2-6-5")
    private String EAR_4_2_6_5; // 其他肺部并发症
    public String getEAR_4_2_6_5() {  return this.EAR_4_2_6_5;}
    @JsonProperty("EAR-4-2-6-5")
    public void setEAR_4_2_6_5(final String EAR_4_2_6_5) { this.EAR_4_2_6_5=EAR_4_2_6_5;}
    @Column(name = "EAR_4_2_6_6")
    @JsonProperty("EAR-4-2-6-6")
    private String EAR_4_2_6_6; // 脊髓损伤
    public String getEAR_4_2_6_6() {  return this.EAR_4_2_6_6;}
    @JsonProperty("EAR-4-2-6-6")
    public void setEAR_4_2_6_6(final String EAR_4_2_6_6) { this.EAR_4_2_6_6=EAR_4_2_6_6;}
    @Column(name = "EAR_4_2_8")
    @JsonProperty("EAR-4-2-8")
    private String EAR_4_2_8; // 脊髓损伤ASIA分级★
    public String getEAR_4_2_8() {  return this.EAR_4_2_8;}
    @JsonProperty("EAR-4-2-8")
    public void setEAR_4_2_8(final String EAR_4_2_8) { this.EAR_4_2_8=EAR_4_2_8;}
    @Column(name = "EAR_4_2_6_9")
    @JsonProperty("EAR-4-2-6-9")
    private String EAR_4_2_6_9; // 急性肾衰竭是否接受肾脏替代治疗
    public String getEAR_4_2_6_9() {  return this.EAR_4_2_6_9;}
    @JsonProperty("EAR-4-2-6-9")
    public void setEAR_4_2_6_9(final String EAR_4_2_6_9) { this.EAR_4_2_6_9=EAR_4_2_6_9;}
    @Column(name = "EAR_4_2_6_10")
    @JsonProperty("EAR-4-2-6-10")
    private String EAR_4_2_6_10; // 消化道严重并发症
    public String getEAR_4_2_6_10() {  return this.EAR_4_2_6_10;}
    @JsonProperty("EAR-4-2-6-10")
    public void setEAR_4_2_6_10(final String EAR_4_2_6_10) { this.EAR_4_2_6_10=EAR_4_2_6_10;}
    @Column(name = "EAR_4_2_6_11")
    @JsonProperty("EAR-4-2-6-11")
    private String EAR_4_2_6_11; // 消化道其他并发症
    public String getEAR_4_2_6_11() {  return this.EAR_4_2_6_11;}
    @JsonProperty("EAR-4-2-6-11")
    public void setEAR_4_2_6_11(final String EAR_4_2_6_11) { this.EAR_4_2_6_11=EAR_4_2_6_11;}
    @Column(name = "EAR_4_2_6_12")
    @JsonProperty("EAR-4-2-6-12")
    private String EAR_4_2_6_12; // 肢体严重并发症
    public String getEAR_4_2_6_12() {  return this.EAR_4_2_6_12;}
    @JsonProperty("EAR-4-2-6-12")
    public void setEAR_4_2_6_12(final String EAR_4_2_6_12) { this.EAR_4_2_6_12=EAR_4_2_6_12;}
    @Column(name = "EAR_4_2_6_13")
    @JsonProperty("EAR-4-2-6-13")
    private String EAR_4_2_6_13; // 肢体其他并发症
    public String getEAR_4_2_6_13() {  return this.EAR_4_2_6_13;}
    @JsonProperty("EAR-4-2-6-13")
    public void setEAR_4_2_6_13(final String EAR_4_2_6_13) { this.EAR_4_2_6_13=EAR_4_2_6_13;}
    @Column(name = "EAR_4_2_6_14")
    @JsonProperty("EAR-4-2-6-14")
    private String EAR_4_2_6_14; // 其他术后并发症
    public String getEAR_4_2_6_14() {  return this.EAR_4_2_6_14;}
    @JsonProperty("EAR-4-2-6-14")
    public void setEAR_4_2_6_14(final String EAR_4_2_6_14) { this.EAR_4_2_6_14=EAR_4_2_6_14;}
}