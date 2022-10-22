package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：I61.0 至 I61.9 的出院患者。
*/
@ApiModel(value = "11信息")
@Entity
@Table(name = "sd_info_ICH")
public class SdInfoICH implements Serializable {
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
    @Column(name = "ICH_0_1_12_1")
    @JsonProperty("ICH-0-1-12-1")
    private String ICH_0_1_12_1; // 其他主要诊断ICD-10四位亚目编码与名称
    public String getICH_0_1_12_1() {  return this.ICH_0_1_12_1;}
    @JsonProperty("ICH-0-1-12-1")
    public void setICH_0_1_12_1(final String ICH_0_1_12_1) { this.ICH_0_1_12_1=ICH_0_1_12_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "ICH_0_1_8_1")
    @JsonProperty("ICH-0-1-8-1")
    private String ICH_0_1_8_1; // 其他主要诊断ICD-10六位临床扩展编码与名称
    public String getICH_0_1_8_1() {  return this.ICH_0_1_8_1;}
    @JsonProperty("ICH-0-1-8-1")
    public void setICH_0_1_8_1(final String ICH_0_1_8_1) { this.ICH_0_1_8_1=ICH_0_1_8_1;}
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getCM_0_1_4_1() {  return this.CM_0_1_4_1;}
    @JsonProperty("CM-0-1-4-1")
    public void setCM_0_1_4_1(final String CM_0_1_4_1) { this.CM_0_1_4_1=CM_0_1_4_1;}
    @Column(name = "ICH_0_1_11_1")
    @JsonProperty("ICH-0-1-11-1")
    private String ICH_0_1_11_1; // 其他主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getICH_0_1_11_1() {  return this.ICH_0_1_11_1;}
    @JsonProperty("ICH-0-1-11-1")
    public void setICH_0_1_11_1(final String ICH_0_1_11_1) { this.ICH_0_1_11_1=ICH_0_1_11_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "ICH_0_1_7_1")
    @JsonProperty("ICH-0-1-7-1")
    private String ICH_0_1_7_1; // 其他主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getICH_0_1_7_1() {  return this.ICH_0_1_7_1;}
    @JsonProperty("ICH-0-1-7-1")
    public void setICH_0_1_7_1(final String ICH_0_1_7_1) { this.ICH_0_1_7_1=ICH_0_1_7_1;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否ICH出院后31天内重复住院
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
    private String CM_0_2_5_1; // 入住ICU/卒中中心日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU/卒中中心日期时间
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
    @Column(name = "ICH_1_1_1")
    @JsonProperty("ICH-1-1-1")
    private String ICH_1_1_1; // 本院急诊医师接诊日期时间
    public String getICH_1_1_1() {  return this.ICH_1_1_1;}
    @JsonProperty("ICH-1-1-1")
    public void setICH_1_1_1(final String ICH_1_1_1) { this.ICH_1_1_1=ICH_1_1_1;}
    @Column(name = "ICH_1_1_2_1")
    @JsonProperty("ICH-1-1-2-1")
    private String ICH_1_1_2_1; // 身高(单位:厘米(cm))
    public String getICH_1_1_2_1() {  return this.ICH_1_1_2_1;}
    @JsonProperty("ICH-1-1-2-1")
    public void setICH_1_1_2_1(final String ICH_1_1_2_1) { this.ICH_1_1_2_1=ICH_1_1_2_1;}
    @Column(name = "ICH_1_1_2_2")
    @JsonProperty("ICH-1-1-2-2")
    private String ICH_1_1_2_2; // 体重(单位:公斤(kg))
    public String getICH_1_1_2_2() {  return this.ICH_1_1_2_2;}
    @JsonProperty("ICH-1-1-2-2")
    public void setICH_1_1_2_2(final String ICH_1_1_2_2) { this.ICH_1_1_2_2=ICH_1_1_2_2;}
    @Column(name = "ICH_1_1_2_3")
    @JsonProperty("ICH-1-1-2-3")
    private String ICH_1_1_2_3; // 呼吸(单位:次/分)
    public String getICH_1_1_2_3() {  return this.ICH_1_1_2_3;}
    @JsonProperty("ICH-1-1-2-3")
    public void setICH_1_1_2_3(final String ICH_1_1_2_3) { this.ICH_1_1_2_3=ICH_1_1_2_3;}
    @Column(name = "ICH_1_1_2_4")
    @JsonProperty("ICH-1-1-2-4")
    private String ICH_1_1_2_4; // 脉搏(单位:次/分)
    public String getICH_1_1_2_4() {  return this.ICH_1_1_2_4;}
    @JsonProperty("ICH-1-1-2-4")
    public void setICH_1_1_2_4(final String ICH_1_1_2_4) { this.ICH_1_1_2_4=ICH_1_1_2_4;}
    @Column(name = "ICH_1_1_2_5")
    @JsonProperty("ICH-1-1-2-5")
    private String ICH_1_1_2_5; // 收缩压(单位:mmHg)
    public String getICH_1_1_2_5() {  return this.ICH_1_1_2_5;}
    @JsonProperty("ICH-1-1-2-5")
    public void setICH_1_1_2_5(final String ICH_1_1_2_5) { this.ICH_1_1_2_5=ICH_1_1_2_5;}
    @Column(name = "ICH_1_1_2_6")
    @JsonProperty("ICH-1-1-2-6")
    private String ICH_1_1_2_6; // 舒张压(单位:mmHg)
    public String getICH_1_1_2_6() {  return this.ICH_1_1_2_6;}
    @JsonProperty("ICH-1-1-2-6")
    public void setICH_1_1_2_6(final String ICH_1_1_2_6) { this.ICH_1_1_2_6=ICH_1_1_2_6;}
    @Column(name = "ICH_1_2_1")
    @JsonProperty("ICH-1-2-1")
    private String ICH_1_2_1; // 是否实施格拉斯哥昏迷评估
    public String getICH_1_2_1() {  return this.ICH_1_2_1;}
    @JsonProperty("ICH-1-2-1")
    public void setICH_1_2_1(final String ICH_1_2_1) { this.ICH_1_2_1=ICH_1_2_1;}
    @Column(name = "ICH_1_2_2")
    @JsonProperty("ICH-1-2-2")
    private String ICH_1_2_2; // 评估日期时间
    public String getICH_1_2_2() {  return this.ICH_1_2_2;}
    @JsonProperty("ICH-1-2-2")
    public void setICH_1_2_2(final String ICH_1_2_2) { this.ICH_1_2_2=ICH_1_2_2;}
    @Column(name = "ICH_1_2_3")
    @JsonProperty("ICH-1-2-3")
    private String ICH_1_2_3; // 实施"格拉斯哥昏迷"评估分值
    public String getICH_1_2_3() {  return this.ICH_1_2_3;}
    @JsonProperty("ICH-1-2-3")
    public void setICH_1_2_3(final String ICH_1_2_3) { this.ICH_1_2_3=ICH_1_2_3;}
    @Column(name = "ICH_1_2_4")
    @JsonProperty("ICH-1-2-4")
    private String ICH_1_2_4; // 是否实施神经功能缺损NIHSS评估
    public String getICH_1_2_4() {  return this.ICH_1_2_4;}
    @JsonProperty("ICH-1-2-4")
    public void setICH_1_2_4(final String ICH_1_2_4) { this.ICH_1_2_4=ICH_1_2_4;}
    @Column(name = "ICH_1_2_5")
    @JsonProperty("ICH-1-2-5")
    private String ICH_1_2_5; // 评估日期时间
    public String getICH_1_2_5() {  return this.ICH_1_2_5;}
    @JsonProperty("ICH-1-2-5")
    public void setICH_1_2_5(final String ICH_1_2_5) { this.ICH_1_2_5=ICH_1_2_5;}
    @Column(name = "ICH_1_2_6")
    @JsonProperty("ICH-1-2-6")
    private String ICH_1_2_6; // 实施神经功能缺损NIHSS评估分值
    public String getICH_1_2_6() {  return this.ICH_1_2_6;}
    @JsonProperty("ICH-1-2-6")
    public void setICH_1_2_6(final String ICH_1_2_6) { this.ICH_1_2_6=ICH_1_2_6;}
    @Column(name = "ICH_1_3_1")
    @JsonProperty("ICH-1-3-1")
    private String ICH_1_3_1; // 急诊是否实施首次头部影像学检查
    public String getICH_1_3_1() {  return this.ICH_1_3_1;}
    @JsonProperty("ICH-1-3-1")
    public void setICH_1_3_1(final String ICH_1_3_1) { this.ICH_1_3_1=ICH_1_3_1;}
    @Column(name = "ICH_1_3_2")
    @JsonProperty("ICH-1-3-2")
    private String ICH_1_3_2; // 急诊首次头部影像学检查项目
    public String getICH_1_3_2() {  return this.ICH_1_3_2;}
    @JsonProperty("ICH-1-3-2")
    public void setICH_1_3_2(final String ICH_1_3_2) { this.ICH_1_3_2=ICH_1_3_2;}
    @Column(name = "ICH_1_3_3")
    @JsonProperty("ICH-1-3-3")
    private String ICH_1_3_3; // 影像学检查确定血肿部位
    public String getICH_1_3_3() {  return this.ICH_1_3_3;}
    @JsonProperty("ICH-1-3-3")
    public void setICH_1_3_3(final String ICH_1_3_3) { this.ICH_1_3_3=ICH_1_3_3;}
    @Column(name = "ICH_1_3_3_1")
    @JsonProperty("ICH-1-3-3-1")
    private String ICH_1_3_3_1; // 基底节区出血
    public String getICH_1_3_3_1() {  return this.ICH_1_3_3_1;}
    @JsonProperty("ICH-1-3-3-1")
    public void setICH_1_3_3_1(final String ICH_1_3_3_1) { this.ICH_1_3_3_1=ICH_1_3_3_1;}
    @Column(name = "ICH_1_3_3_3")
    @JsonProperty("ICH-1-3-3-3")
    private String ICH_1_3_3_3; // 脑叶出血
    public String getICH_1_3_3_3() {  return this.ICH_1_3_3_3;}
    @JsonProperty("ICH-1-3-3-3")
    public void setICH_1_3_3_3(final String ICH_1_3_3_3) { this.ICH_1_3_3_3=ICH_1_3_3_3;}
    @Column(name = "ICH_1_3_3_4")
    @JsonProperty("ICH-1-3-3-4")
    private String ICH_1_3_3_4; // 脑干出血
    public String getICH_1_3_3_4() {  return this.ICH_1_3_3_4;}
    @JsonProperty("ICH-1-3-3-4")
    public void setICH_1_3_3_4(final String ICH_1_3_3_4) { this.ICH_1_3_3_4=ICH_1_3_3_4;}
    @Column(name = "ICH_1_3_4")
    @JsonProperty("ICH-1-3-4")
    private String ICH_1_3_4; // 血肿量(ml)
    public String getICH_1_3_4() {  return this.ICH_1_3_4;}
    @JsonProperty("ICH-1-3-4")
    public void setICH_1_3_4(final String ICH_1_3_4) { this.ICH_1_3_4=ICH_1_3_4;}
    @Column(name = "ICH_1_3_5")
    @JsonProperty("ICH-1-3-5")
    private String ICH_1_3_5; // 是否血肿破入脑室
    public String getICH_1_3_5() {  return this.ICH_1_3_5;}
    @JsonProperty("ICH-1-3-5")
    public void setICH_1_3_5(final String ICH_1_3_5) { this.ICH_1_3_5=ICH_1_3_5;}
    @Column(name = "ICH_1_3_6")
    @JsonProperty("ICH-1-3-6")
    private String ICH_1_3_6; // 是否血肿源自幕下
    public String getICH_1_3_6() {  return this.ICH_1_3_6;}
    @JsonProperty("ICH-1-3-6")
    public void setICH_1_3_6(final String ICH_1_3_6) { this.ICH_1_3_6=ICH_1_3_6;}
    @Column(name = "ICH_1_3_7")
    @JsonProperty("ICH-1-3-7")
    private String ICH_1_3_7; // 报告日期时间
    public String getICH_1_3_7() {  return this.ICH_1_3_7;}
    @JsonProperty("ICH-1-3-7")
    public void setICH_1_3_7(final String ICH_1_3_7) { this.ICH_1_3_7=ICH_1_3_7;}
    @Column(name = "ICH_1_4_1")
    @JsonProperty("ICH-1-4-1")
    private String ICH_1_4_1; // 是否急诊入住”卒中中心”
    public String getICH_1_4_1() {  return this.ICH_1_4_1;}
    @JsonProperty("ICH-1-4-1")
    public void setICH_1_4_1(final String ICH_1_4_1) { this.ICH_1_4_1=ICH_1_4_1;}
    @Column(name = "ICH_1_4_2")
    @JsonProperty("ICH-1-4-2")
    private String ICH_1_4_2; // 入住”卒中中心”日期时间
    public String getICH_1_4_2() {  return this.ICH_1_4_2;}
    @JsonProperty("ICH-1-4-2")
    public void setICH_1_4_2(final String ICH_1_4_2) { this.ICH_1_4_2=ICH_1_4_2;}
    @Column(name = "ICH_2_1_1")
    @JsonProperty("ICH-2-1-1")
    private String ICH_2_1_1; // 是否为高血压(收缩压大于180mmHg)患者
    public String getICH_2_1_1() {  return this.ICH_2_1_1;}
    @JsonProperty("ICH-2-1-1")
    public void setICH_2_1_1(final String ICH_2_1_1) { this.ICH_2_1_1=ICH_2_1_1;}
    @Column(name = "ICH_2_1_2")
    @JsonProperty("ICH-2-1-2")
    private String ICH_2_1_2; // 是否24小时内有血压监测与用药长期医嘱
    public String getICH_2_1_2() {  return this.ICH_2_1_2;}
    @JsonProperty("ICH-2-1-2")
    public void setICH_2_1_2(final String ICH_2_1_2) { this.ICH_2_1_2=ICH_2_1_2;}
    @Column(name = "ICH_2_1_3")
    @JsonProperty("ICH-2-1-3")
    private String ICH_2_1_3; // 选择降压药物
    public String getICH_2_1_3() {  return this.ICH_2_1_3;}
    @JsonProperty("ICH-2-1-3")
    public void setICH_2_1_3(final String ICH_2_1_3) { this.ICH_2_1_3=ICH_2_1_3;}
    @Column(name = "ICH_2_1_3_1")
    @JsonProperty("ICH-2-1-3-1")
    private String ICH_2_1_3_1; // 其他降压药物
    public String getICH_2_1_3_1() {  return this.ICH_2_1_3_1;}
    @JsonProperty("ICH-2-1-3-1")
    public void setICH_2_1_3_1(final String ICH_2_1_3_1) { this.ICH_2_1_3_1=ICH_2_1_3_1;}
    @Column(name = "ICH_2_1_4")
    @JsonProperty("ICH-2-1-4")
    private String ICH_2_1_4; // 是否为高血压(收缩压大于200mmHg)患者
    public String getICH_2_1_4() {  return this.ICH_2_1_4;}
    @JsonProperty("ICH-2-1-4")
    public void setICH_2_1_4(final String ICH_2_1_4) { this.ICH_2_1_4=ICH_2_1_4;}
    @Column(name = "ICH_2_1_5")
    @JsonProperty("ICH-2-1-5")
    private String ICH_2_1_5; // 是否有使用静脉降压药医嘱
    public String getICH_2_1_5() {  return this.ICH_2_1_5;}
    @JsonProperty("ICH-2-1-5")
    public void setICH_2_1_5(final String ICH_2_1_5) { this.ICH_2_1_5=ICH_2_1_5;}
    @Column(name = "ICH_3_1_1")
    @JsonProperty("ICH-3-1-1")
    private String ICH_3_1_1; // 入院后病情判定
    public String getICH_3_1_1() {  return this.ICH_3_1_1;}
    @JsonProperty("ICH-3-1-1")
    public void setICH_3_1_1(final String ICH_3_1_1) { this.ICH_3_1_1=ICH_3_1_1;}
    @Column(name = "ICH_3_2_1")
    @JsonProperty("ICH-3-2-1")
    private String ICH_3_2_1; // 是否需要做预防DVT治疗
    public String getICH_3_2_1() {  return this.ICH_3_2_1;}
    @JsonProperty("ICH-3-2-1")
    public void setICH_3_2_1(final String ICH_3_2_1) { this.ICH_3_2_1=ICH_3_2_1;}
    @Column(name = "ICH_3_2_2")
    @JsonProperty("ICH-3-2-2")
    private String ICH_3_2_2; // 禁忌证选择
    public String getICH_3_2_2() {  return this.ICH_3_2_2;}
    @JsonProperty("ICH-3-2-2")
    public void setICH_3_2_2(final String ICH_3_2_2) { this.ICH_3_2_2=ICH_3_2_2;}
    @Column(name = "ICH_3_2_3")
    @JsonProperty("ICH-3-2-3")
    private String ICH_3_2_3; // 预防DVT治疗医嘱执行日期与时间
    public String getICH_3_2_3() {  return this.ICH_3_2_3;}
    @JsonProperty("ICH-3-2-3")
    public void setICH_3_2_3(final String ICH_3_2_3) { this.ICH_3_2_3=ICH_3_2_3;}
    @Column(name = "ICH_3_3_1")
    @JsonProperty("ICH-3-3-1")
    private String ICH_3_3_1; // 药物预防选择
    public String getICH_3_3_1() {  return this.ICH_3_3_1;}
    @JsonProperty("ICH-3-3-1")
    public void setICH_3_3_1(final String ICH_3_3_1) { this.ICH_3_3_1=ICH_3_3_1;}
    @Column(name = "ICH_3_3_1_1")
    @JsonProperty("ICH-3-3-1-1")
    private String ICH_3_3_1_1; // 其它预防药物
    public String getICH_3_3_1_1() {  return this.ICH_3_3_1_1;}
    @JsonProperty("ICH-3-3-1-1")
    public void setICH_3_3_1_1(final String ICH_3_3_1_1) { this.ICH_3_3_1_1=ICH_3_3_1_1;}
    @Column(name = "ICH_3_3_2")
    @JsonProperty("ICH-3-3-2")
    private String ICH_3_3_2; // 物理预防选择
    public String getICH_3_3_2() {  return this.ICH_3_3_2;}
    @JsonProperty("ICH-3-3-2")
    public void setICH_3_3_2(final String ICH_3_3_2) { this.ICH_3_3_2=ICH_3_3_2;}
    @Column(name = "ICH_3_3_2_1")
    @JsonProperty("ICH-3-3-2-1")
    private String ICH_3_3_2_1; // 其他物理预防
    public String getICH_3_3_2_1() {  return this.ICH_3_3_2_1;}
    @JsonProperty("ICH-3-3-2-1")
    public void setICH_3_3_2_1(final String ICH_3_3_2_1) { this.ICH_3_3_2_1=ICH_3_3_2_1;}
    @Column(name = "ICH_3_3_3")
    @JsonProperty("ICH-3-3-3")
    private String ICH_3_3_3; // 基本预防
    public String getICH_3_3_3() {  return this.ICH_3_3_3;}
    @JsonProperty("ICH-3-3-3")
    public void setICH_3_3_3(final String ICH_3_3_3) { this.ICH_3_3_3=ICH_3_3_3;}
    @Column(name = "ICH_3_3_3_1")
    @JsonProperty("ICH-3-3-3-1")
    private String ICH_3_3_3_1; // 其他基本预防措施
    public String getICH_3_3_3_1() {  return this.ICH_3_3_3_1;}
    @JsonProperty("ICH-3-3-3-1")
    public void setICH_3_3_3_1(final String ICH_3_3_3_1) { this.ICH_3_3_3_1=ICH_3_3_3_1;}
    @Column(name = "ICH_4_1_1")
    @JsonProperty("ICH-4-1-1")
    private String ICH_4_1_1; // 入院时是否可以正常进食与饮水
    public String getICH_4_1_1() {  return this.ICH_4_1_1;}
    @JsonProperty("ICH-4-1-1")
    public void setICH_4_1_1(final String ICH_4_1_1) { this.ICH_4_1_1=ICH_4_1_1;}
    @Column(name = "ICH_4_2_1")
    @JsonProperty("ICH-4-2-1")
    private String ICH_4_2_1; // 入院24小时内是否进行吞咽评估
    public String getICH_4_2_1() {  return this.ICH_4_2_1;}
    @JsonProperty("ICH-4-2-1")
    public void setICH_4_2_1(final String ICH_4_2_1) { this.ICH_4_2_1=ICH_4_2_1;}
    @Column(name = "ICH_4_3_2")
    @JsonProperty("ICH-4-3-2")
    private String ICH_4_3_2; // 未进行吞咽困难评价原因
    public String getICH_4_3_2() {  return this.ICH_4_3_2;}
    @JsonProperty("ICH-4-3-2")
    public void setICH_4_3_2(final String ICH_4_3_2) { this.ICH_4_3_2=ICH_4_3_2;}
    @Column(name = "ICH_4_3_2_1")
    @JsonProperty("ICH-4-3-2-1")
    private String ICH_4_3_2_1; // 其他未进行吞咽困难评价原因
    public String getICH_4_3_2_1() {  return this.ICH_4_3_2_1;}
    @JsonProperty("ICH-4-3-2-1")
    public void setICH_4_3_2_1(final String ICH_4_3_2_1) { this.ICH_4_3_2_1=ICH_4_3_2_1;}
    @Column(name = "ICH_4_2_2")
    @JsonProperty("ICH-4-2-2")
    private String ICH_4_2_2; // 评估日期时间
    public String getICH_4_2_2() {  return this.ICH_4_2_2;}
    @JsonProperty("ICH-4-2-2")
    public void setICH_4_2_2(final String ICH_4_2_2) { this.ICH_4_2_2=ICH_4_2_2;}
    @Column(name = "ICH_4_3_1")
    @JsonProperty("ICH-4-3-1")
    private String ICH_4_3_1; // 评价方法选择
    public String getICH_4_3_1() {  return this.ICH_4_3_1;}
    @JsonProperty("ICH-4-3-1")
    public void setICH_4_3_1(final String ICH_4_3_1) { this.ICH_4_3_1=ICH_4_3_1;}
    @Column(name = "ICH_4_3_1_1")
    @JsonProperty("ICH-4-3-1-1")
    private String ICH_4_3_1_1; // 其他评价方法
    public String getICH_4_3_1_1() {  return this.ICH_4_3_1_1;}
    @JsonProperty("ICH-4-3-1-1")
    public void setICH_4_3_1_1(final String ICH_4_3_1_1) { this.ICH_4_3_1_1=ICH_4_3_1_1;}
    @Column(name = "ICH_5_1_1")
    @JsonProperty("ICH-5-1-1")
    private String ICH_5_1_1; // 住院48小时内是否接受影像学检测复查
    public String getICH_5_1_1() {  return this.ICH_5_1_1;}
    @JsonProperty("ICH-5-1-1")
    public void setICH_5_1_1(final String ICH_5_1_1) { this.ICH_5_1_1=ICH_5_1_1;}
    @Column(name = "ICH_5_1_2")
    @JsonProperty("ICH-5-1-2")
    private String ICH_5_1_2; // 接受影像学检测复查项目选择
    public String getICH_5_1_2() {  return this.ICH_5_1_2;}
    @JsonProperty("ICH-5-1-2")
    public void setICH_5_1_2(final String ICH_5_1_2) { this.ICH_5_1_2=ICH_5_1_2;}
    @Column(name = "ICH_5_1_2_1")
    @JsonProperty("ICH-5-1-2-1")
    private String ICH_5_1_2_1; // 其他接受影像学检测复查项目名称
    public String getICH_5_1_2_1() {  return this.ICH_5_1_2_1;}
    @JsonProperty("ICH-5-1-2-1")
    public void setICH_5_1_2_1(final String ICH_5_1_2_1) { this.ICH_5_1_2_1=ICH_5_1_2_1;}
    @Column(name = "ICH_5_1_3")
    @JsonProperty("ICH-5-1-3")
    private String ICH_5_1_3; // 复查检测日期时间
    public String getICH_5_1_3() {  return this.ICH_5_1_3;}
    @JsonProperty("ICH-5-1-3")
    public void setICH_5_1_3(final String ICH_5_1_3) { this.ICH_5_1_3=ICH_5_1_3;}
    @Column(name = "ICH_5_1_4")
    @JsonProperty("ICH-5-1-4")
    private String ICH_5_1_4; // 是否血肿扩大
    public String getICH_5_1_4() {  return this.ICH_5_1_4;}
    @JsonProperty("ICH-5-1-4")
    public void setICH_5_1_4(final String ICH_5_1_4) { this.ICH_5_1_4=ICH_5_1_4;}
    @Column(name = "ICH_5_1_5")
    @JsonProperty("ICH-5-1-5")
    private String ICH_5_1_5; // 是否血管畸形
    public String getICH_5_1_5() {  return this.ICH_5_1_5;}
    @JsonProperty("ICH-5-1-5")
    public void setICH_5_1_5(final String ICH_5_1_5) { this.ICH_5_1_5=ICH_5_1_5;}
    @Column(name = "ICH_5_1_6")
    @JsonProperty("ICH-5-1-6")
    private String ICH_5_1_6; // 是否动脉瘤
    public String getICH_5_1_6() {  return this.ICH_5_1_6;}
    @JsonProperty("ICH-5-1-6")
    public void setICH_5_1_6(final String ICH_5_1_6) { this.ICH_5_1_6=ICH_5_1_6;}
    @Column(name = "ICH_5_1_7")
    @JsonProperty("ICH-5-1-7")
    private String ICH_5_1_7; // 是否淀粉样病变
    public String getICH_5_1_7() {  return this.ICH_5_1_7;}
    @JsonProperty("ICH-5-1-7")
    public void setICH_5_1_7(final String ICH_5_1_7) { this.ICH_5_1_7=ICH_5_1_7;}
    @Column(name = "ICH_5_1_8")
    @JsonProperty("ICH-5-1-8")
    private String ICH_5_1_8; // 是否再出血风险
    public String getICH_5_1_8() {  return this.ICH_5_1_8;}
    @JsonProperty("ICH-5-1-8")
    public void setICH_5_1_8(final String ICH_5_1_8) { this.ICH_5_1_8=ICH_5_1_8;}
    @Column(name = "ICH_6_1_1")
    @JsonProperty("ICH-6-1-1")
    private String ICH_6_1_1; // 是否首次ICH评分
    public String getICH_6_1_1() {  return this.ICH_6_1_1;}
    @JsonProperty("ICH-6-1-1")
    public void setICH_6_1_1(final String ICH_6_1_1) { this.ICH_6_1_1=ICH_6_1_1;}
    @Column(name = "ICH_6_1_2")
    @JsonProperty("ICH-6-1-2")
    private String ICH_6_1_2; // 评估日期时间
    public String getICH_6_1_2() {  return this.ICH_6_1_2;}
    @JsonProperty("ICH-6-1-2")
    public void setICH_6_1_2(final String ICH_6_1_2) { this.ICH_6_1_2=ICH_6_1_2;}
    @Column(name = "ICH_6_1_3_1")
    @JsonProperty("ICH-6-1-3-1")
    private String ICH_6_1_3_1; // GCS评分
    public String getICH_6_1_3_1() {  return this.ICH_6_1_3_1;}
    @JsonProperty("ICH-6-1-3-1")
    public void setICH_6_1_3_1(final String ICH_6_1_3_1) { this.ICH_6_1_3_1=ICH_6_1_3_1;}
    @Column(name = "ICH_6_1_3_1_r")
    @JsonProperty("ICH-6-1-3-1-r")
    private String ICH_6_1_3_1_r; // 评分值1
    public String getICH_6_1_3_1_r() {  return this.ICH_6_1_3_1_r;}
    @JsonProperty("ICH-6-1-3-1-r")
    public void setICH_6_1_3_1_r(final String ICH_6_1_3_1_r) { this.ICH_6_1_3_1_r=ICH_6_1_3_1_r;}
    @Column(name = "ICH_6_1_3_2")
    @JsonProperty("ICH-6-1-3-2")
    private String ICH_6_1_3_2; // 血肿量
    public String getICH_6_1_3_2() {  return this.ICH_6_1_3_2;}
    @JsonProperty("ICH-6-1-3-2")
    public void setICH_6_1_3_2(final String ICH_6_1_3_2) { this.ICH_6_1_3_2=ICH_6_1_3_2;}
    @Column(name = "ICH_6_1_3_2_r")
    @JsonProperty("ICH-6-1-3-2-r")
    private String ICH_6_1_3_2_r; // 评分值2
    public String getICH_6_1_3_2_r() {  return this.ICH_6_1_3_2_r;}
    @JsonProperty("ICH-6-1-3-2-r")
    public void setICH_6_1_3_2_r(final String ICH_6_1_3_2_r) { this.ICH_6_1_3_2_r=ICH_6_1_3_2_r;}
    @Column(name = "ICH_6_1_3_3")
    @JsonProperty("ICH-6-1-3-3")
    private String ICH_6_1_3_3; // 是否血肿破入脑室
    public String getICH_6_1_3_3() {  return this.ICH_6_1_3_3;}
    @JsonProperty("ICH-6-1-3-3")
    public void setICH_6_1_3_3(final String ICH_6_1_3_3) { this.ICH_6_1_3_3=ICH_6_1_3_3;}
    @Column(name = "ICH_6_1_3_3_r")
    @JsonProperty("ICH-6-1-3-3-r")
    private String ICH_6_1_3_3_r; // 评分值3
    public String getICH_6_1_3_3_r() {  return this.ICH_6_1_3_3_r;}
    @JsonProperty("ICH-6-1-3-3-r")
    public void setICH_6_1_3_3_r(final String ICH_6_1_3_3_r) { this.ICH_6_1_3_3_r=ICH_6_1_3_3_r;}
    @Column(name = "ICH_6_1_3_4")
    @JsonProperty("ICH-6-1-3-4")
    private String ICH_6_1_3_4; // 是否血肿源自幕下
    public String getICH_6_1_3_4() {  return this.ICH_6_1_3_4;}
    @JsonProperty("ICH-6-1-3-4")
    public void setICH_6_1_3_4(final String ICH_6_1_3_4) { this.ICH_6_1_3_4=ICH_6_1_3_4;}
    @Column(name = "ICH_6_1_3_4_r")
    @JsonProperty("ICH-6-1-3-4-r")
    private String ICH_6_1_3_4_r; // 评分值4
    public String getICH_6_1_3_4_r() {  return this.ICH_6_1_3_4_r;}
    @JsonProperty("ICH-6-1-3-4-r")
    public void setICH_6_1_3_4_r(final String ICH_6_1_3_4_r) { this.ICH_6_1_3_4_r=ICH_6_1_3_4_r;}
    @Column(name = "ICH_6_1_3_5")
    @JsonProperty("ICH-6-1-3-5")
    private String ICH_6_1_3_5; // 年龄
    public String getICH_6_1_3_5() {  return this.ICH_6_1_3_5;}
    @JsonProperty("ICH-6-1-3-5")
    public void setICH_6_1_3_5(final String ICH_6_1_3_5) { this.ICH_6_1_3_5=ICH_6_1_3_5;}
    @Column(name = "ICH_6_1_3_5_r")
    @JsonProperty("ICH-6-1-3-5-r")
    private String ICH_6_1_3_5_r; // 评分值5
    public String getICH_6_1_3_5_r() {  return this.ICH_6_1_3_5_r;}
    @JsonProperty("ICH-6-1-3-5-r")
    public void setICH_6_1_3_5_r(final String ICH_6_1_3_5_r) { this.ICH_6_1_3_5_r=ICH_6_1_3_5_r;}
    @Column(name = "ICH_6_1_4")
    @JsonProperty("ICH-6-1-4")
    private String ICH_6_1_4; // 首次ICH评估分值
    public String getICH_6_1_4() {  return this.ICH_6_1_4;}
    @JsonProperty("ICH-6-1-4")
    public void setICH_6_1_4(final String ICH_6_1_4) { this.ICH_6_1_4=ICH_6_1_4;}
    @Column(name = "ICH_6_1_5_r")
    @JsonProperty("ICH-6-1-5-r")
    private String ICH_6_1_5_r; // 首次ICH评估分值查看
    public String getICH_6_1_5_r() {  return this.ICH_6_1_5_r;}
    @JsonProperty("ICH-6-1-5-r")
    public void setICH_6_1_5_r(final String ICH_6_1_5_r) { this.ICH_6_1_5_r=ICH_6_1_5_r;}
    @Column(name = "ICH_6_1_6")
    @JsonProperty("ICH-6-1-6")
    private String ICH_6_1_6; // 首次ICH 评估分值与30d死亡率(%)
    public String getICH_6_1_6() {  return this.ICH_6_1_6;}
    @JsonProperty("ICH-6-1-6")
    public void setICH_6_1_6(final String ICH_6_1_6) { this.ICH_6_1_6=ICH_6_1_6;}
    @Column(name = "ICH_6_2_6")
    @JsonProperty("ICH-6-2-6")
    private String ICH_6_2_6; // 是否有手术适应证
    public String getICH_6_2_6() {  return this.ICH_6_2_6;}
    @JsonProperty("ICH-6-2-6")
    public void setICH_6_2_6(final String ICH_6_2_6) { this.ICH_6_2_6=ICH_6_2_6;}
    @Column(name = "ICH_6_1_5")
    @JsonProperty("ICH-6-1-5")
    private String ICH_6_1_5; // 手术适应证选择
    public String getICH_6_1_5() {  return this.ICH_6_1_5;}
    @JsonProperty("ICH-6-1-5")
    public void setICH_6_1_5(final String ICH_6_1_5) { this.ICH_6_1_5=ICH_6_1_5;}
    @Column(name = "ICH_6_1_5_1")
    @JsonProperty("ICH-6-1-5-1")
    private String ICH_6_1_5_1; // 其他手术适应证
    public String getICH_6_1_5_1() {  return this.ICH_6_1_5_1;}
    @JsonProperty("ICH-6-1-5-1")
    public void setICH_6_1_5_1(final String ICH_6_1_5_1) { this.ICH_6_1_5_1=ICH_6_1_5_1;}
    @Column(name = "ICH_6_2_3")
    @JsonProperty("ICH-6-2-3")
    private String ICH_6_2_3; // 神经外科干预措施
    public String getICH_6_2_3() {  return this.ICH_6_2_3;}
    @JsonProperty("ICH-6-2-3")
    public void setICH_6_2_3(final String ICH_6_2_3) { this.ICH_6_2_3=ICH_6_2_3;}
    @Column(name = "ICH_6_2_3_1")
    @JsonProperty("ICH-6-2-3-1")
    private String ICH_6_2_3_1; // 其他神经外科干预措施
    public String getICH_6_2_3_1() {  return this.ICH_6_2_3_1;}
    @JsonProperty("ICH-6-2-3-1")
    public void setICH_6_2_3_1(final String ICH_6_2_3_1) { this.ICH_6_2_3_1=ICH_6_2_3_1;}
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
    @Column(name = "CM_2_3_1_1")
    @JsonProperty("CM-2-3-1-1")
    private String CM_2_3_1_1; // 其他手术后并发症类别及ICD-10四位亚目和名称填写
    public String getCM_2_3_1_1() {  return this.CM_2_3_1_1;}
    @JsonProperty("CM-2-3-1-1")
    public void setCM_2_3_1_1(final String CM_2_3_1_1) { this.CM_2_3_1_1=CM_2_3_1_1;}
    @Column(name = "CM_2_3_1")
    @JsonProperty("CM-2-3-1")
    private String CM_2_3_1; // 介入操作与手术其他并发症
    public String getCM_2_3_1() {  return this.CM_2_3_1;}
    @JsonProperty("CM-2-3-1")
    public void setCM_2_3_1(final String CM_2_3_1) { this.CM_2_3_1=CM_2_3_1;}
    @Column(name = "CM_2_3_2")
    @JsonProperty("CM-2-3-2")
    private String CM_2_3_2; // 手术患者手术后肺栓塞例数
    public String getCM_2_3_2() {  return this.CM_2_3_2;}
    @JsonProperty("CM-2-3-2")
    public void setCM_2_3_2(final String CM_2_3_2) { this.CM_2_3_2=CM_2_3_2;}
    @Column(name = "CM_2_3_3")
    @JsonProperty("CM-2-3-3")
    private String CM_2_3_3; // 手术患者手术后深静脉血栓例数
    public String getCM_2_3_3() {  return this.CM_2_3_3;}
    @JsonProperty("CM-2-3-3")
    public void setCM_2_3_3(final String CM_2_3_3) { this.CM_2_3_3=CM_2_3_3;}
    @Column(name = "CM_2_3_4")
    @JsonProperty("CM-2-3-4")
    private String CM_2_3_4; // 手术患者手术后败血症例数
    public String getCM_2_3_4() {  return this.CM_2_3_4;}
    @JsonProperty("CM-2-3-4")
    public void setCM_2_3_4(final String CM_2_3_4) { this.CM_2_3_4=CM_2_3_4;}
    @Column(name = "CM_2_3_5")
    @JsonProperty("CM-2-3-5")
    private String CM_2_3_5; // 手术患者手术后出血或血肿例数
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
    @Column(name = "CM_2_3_14")
    @JsonProperty("CM-2-3-14")
    private String CM_2_3_14; // 住院患者发生压疮
    public String getCM_2_3_14() {  return this.CM_2_3_14;}
    @JsonProperty("CM-2-3-14")
    public void setCM_2_3_14(final String CM_2_3_14) { this.CM_2_3_14=CM_2_3_14;}
    @Column(name = "ICH_6_2_4")
    @JsonProperty("ICH-6-2-4")
    private String ICH_6_2_4; // ICH术后特指并发症
    public String getICH_6_2_4() {  return this.ICH_6_2_4;}
    @JsonProperty("ICH-6-2-4")
    public void setICH_6_2_4(final String ICH_6_2_4) { this.ICH_6_2_4=ICH_6_2_4;}
    @Column(name = "ICH_6_2_4_1")
    @JsonProperty("ICH-6-2-4-1")
    private String ICH_6_2_4_1; // 对腰椎穿刺的其他反应
    public String getICH_6_2_4_1() {  return this.ICH_6_2_4_1;}
    @JsonProperty("ICH-6-2-4-1")
    public void setICH_6_2_4_1(final String ICH_6_2_4_1) { this.ICH_6_2_4_1=ICH_6_2_4_1;}
    @Column(name = "ICH_6_2_4_2")
    @JsonProperty("ICH-6-2-4-2")
    private String ICH_6_2_4_2; // 神经系统的其他操作后疾患
    public String getICH_6_2_4_2() {  return this.ICH_6_2_4_2;}
    @JsonProperty("ICH-6-2-4-2")
    public void setICH_6_2_4_2(final String ICH_6_2_4_2) { this.ICH_6_2_4_2=ICH_6_2_4_2;}
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    public String getCM_2_4() {  return this.CM_2_4;}
    @JsonProperty("CM-2-4")
    public void setCM_2_4(final String CM_2_4) { this.CM_2_4=CM_2_4;}
    @Column(name = "ICH_6_2_5")
    @JsonProperty("ICH-6-2-5")
    private String ICH_6_2_5; // 是否手术后再手术
    public String getICH_6_2_5() {  return this.ICH_6_2_5;}
    @JsonProperty("ICH-6-2-5")
    public void setICH_6_2_5(final String ICH_6_2_5) { this.ICH_6_2_5=ICH_6_2_5;}
    @Column(name = "ICH_7_1_1")
    @JsonProperty("ICH-7-1-1")
    private String ICH_7_1_1; // 是否高血压(收缩压大于180mmHg)患者
    public String getICH_7_1_1() {  return this.ICH_7_1_1;}
    @JsonProperty("ICH-7-1-1")
    public void setICH_7_1_1(final String ICH_7_1_1) { this.ICH_7_1_1=ICH_7_1_1;}
    @Column(name = "ICH_7_1_2")
    @JsonProperty("ICH-7-1-2")
    private String ICH_7_1_2; // 出院医嘱中有血压监测与用药长期医嘱
    public String getICH_7_1_2() {  return this.ICH_7_1_2;}
    @JsonProperty("ICH-7-1-2")
    public void setICH_7_1_2(final String ICH_7_1_2) { this.ICH_7_1_2=ICH_7_1_2;}
    @Column(name = "ICH_7_1_3")
    @JsonProperty("ICH-7-1-3")
    private String ICH_7_1_3; // 选择降压药物
    public String getICH_7_1_3() {  return this.ICH_7_1_3;}
    @JsonProperty("ICH-7-1-3")
    public void setICH_7_1_3(final String ICH_7_1_3) { this.ICH_7_1_3=ICH_7_1_3;}
    @Column(name = "ICH_7_1_3_1")
    @JsonProperty("ICH-7-1-3-1")
    private String ICH_7_1_3_1; // 其他降压药物
    public String getICH_7_1_3_1() {  return this.ICH_7_1_3_1;}
    @JsonProperty("ICH-7-1-3-1")
    public void setICH_7_1_3_1(final String ICH_7_1_3_1) { this.ICH_7_1_3_1=ICH_7_1_3_1;}
    @Column(name = "ICH_8_1_1")
    @JsonProperty("ICH-8-1-1")
    private String ICH_8_1_1; //  原发性
    public String getICH_8_1_1() {  return this.ICH_8_1_1;}
    @JsonProperty("ICH-8-1-1")
    public void setICH_8_1_1(final String ICH_8_1_1) { this.ICH_8_1_1=ICH_8_1_1;}
    @Column(name = "ICH_8_1_2")
    @JsonProperty("ICH-8-1-2")
    private String ICH_8_1_2; // 继发性
    public String getICH_8_1_2() {  return this.ICH_8_1_2;}
    @JsonProperty("ICH-8-1-2")
    public void setICH_8_1_2(final String ICH_8_1_2) { this.ICH_8_1_2=ICH_8_1_2;}
    @Column(name = "ICH_9_1_1")
    @JsonProperty("ICH-9-1-1")
    private String ICH_9_1_1; // 是否有重点护理评估
    public String getICH_9_1_1() {  return this.ICH_9_1_1;}
    @JsonProperty("ICH-9-1-1")
    public void setICH_9_1_1(final String ICH_9_1_1) { this.ICH_9_1_1=ICH_9_1_1;}
    @Column(name = "ICH_9_1_2_1")
    @JsonProperty("ICH-9-1-2-1")
    private String ICH_9_1_2_1; // 行走评估结果
    public String getICH_9_1_2_1() {  return this.ICH_9_1_2_1;}
    @JsonProperty("ICH-9-1-2-1")
    public void setICH_9_1_2_1(final String ICH_9_1_2_1) { this.ICH_9_1_2_1=ICH_9_1_2_1;}
    @Column(name = "ICH_9_1_2_2")
    @JsonProperty("ICH-9-1-2-2")
    private String ICH_9_1_2_2; // 呼吸评估结果
    public String getICH_9_1_2_2() {  return this.ICH_9_1_2_2;}
    @JsonProperty("ICH-9-1-2-2")
    public void setICH_9_1_2_2(final String ICH_9_1_2_2) { this.ICH_9_1_2_2=ICH_9_1_2_2;}
    @Column(name = "ICH_9_1_2_3")
    @JsonProperty("ICH-9-1-2-3")
    private String ICH_9_1_2_3; // 饮食评估结果
    public String getICH_9_1_2_3() {  return this.ICH_9_1_2_3;}
    @JsonProperty("ICH-9-1-2-3")
    public void setICH_9_1_2_3(final String ICH_9_1_2_3) { this.ICH_9_1_2_3=ICH_9_1_2_3;}
    @Column(name = "ICH_9_1_2_4")
    @JsonProperty("ICH-9-1-2-4")
    private String ICH_9_1_2_4; // 吞咽评估结果
    public String getICH_9_1_2_4() {  return this.ICH_9_1_2_4;}
    @JsonProperty("ICH-9-1-2-4")
    public void setICH_9_1_2_4(final String ICH_9_1_2_4) { this.ICH_9_1_2_4=ICH_9_1_2_4;}
    @Column(name = "ICH_9_1_2_5_3")
    @JsonProperty("ICH-9-1-2-5-3")
    private String ICH_9_1_2_5_3; // 压疮评估（Braden评分值）分值是否确定
    public String getICH_9_1_2_5_3() {  return this.ICH_9_1_2_5_3;}
    @JsonProperty("ICH-9-1-2-5-3")
    public void setICH_9_1_2_5_3(final String ICH_9_1_2_5_3) { this.ICH_9_1_2_5_3=ICH_9_1_2_5_3;}
    @Column(name = "ICH_9_1_2_5")
    @JsonProperty("ICH-9-1-2-5")
    private String ICH_9_1_2_5; // 压疮评估（Braden评分值）分值
    public String getICH_9_1_2_5() {  return this.ICH_9_1_2_5;}
    @JsonProperty("ICH-9-1-2-5")
    public void setICH_9_1_2_5(final String ICH_9_1_2_5) { this.ICH_9_1_2_5=ICH_9_1_2_5;}
    @Column(name = "ICH_9_1_2_5_1")
    @JsonProperty("ICH-9-1-2-5-1")
    private String ICH_9_1_2_5_1; // 压疮评估结果选择
    public String getICH_9_1_2_5_1() {  return this.ICH_9_1_2_5_1;}
    @JsonProperty("ICH-9-1-2-5-1")
    public void setICH_9_1_2_5_1(final String ICH_9_1_2_5_1) { this.ICH_9_1_2_5_1=ICH_9_1_2_5_1;}
    @Column(name = "ICH_9_1_2_5_2")
    @JsonProperty("ICH-9-1-2-5-2")
    private String ICH_9_1_2_5_2; // 预防压疮告知
    public String getICH_9_1_2_5_2() {  return this.ICH_9_1_2_5_2;}
    @JsonProperty("ICH-9-1-2-5-2")
    public void setICH_9_1_2_5_2(final String ICH_9_1_2_5_2) { this.ICH_9_1_2_5_2=ICH_9_1_2_5_2;}
    @Column(name = "ICH_9_1_3_1_1")
    @JsonProperty("ICH-9-1-3-1-1")
    private String ICH_9_1_3_1_1; // 是否实施卒中健康教育，且有记录
    public String getICH_9_1_3_1_1() {  return this.ICH_9_1_3_1_1;}
    @JsonProperty("ICH-9-1-3-1-1")
    public void setICH_9_1_3_1_1(final String ICH_9_1_3_1_1) { this.ICH_9_1_3_1_1=ICH_9_1_3_1_1;}
    @Column(name = "ICH_9_1_3_1")
    @JsonProperty("ICH-9-1-3-1")
    private String ICH_9_1_3_1; // 实施卒中健康教育有记录
    public String getICH_9_1_3_1() {  return this.ICH_9_1_3_1;}
    @JsonProperty("ICH-9-1-3-1")
    public void setICH_9_1_3_1(final String ICH_9_1_3_1) { this.ICH_9_1_3_1=ICH_9_1_3_1;}
    @Column(name = "ICH_9_1_3_2")
    @JsonProperty("ICH-9-1-3-2")
    private String ICH_9_1_3_2; // 吸烟史
    public String getICH_9_1_3_2() {  return this.ICH_9_1_3_2;}
    @JsonProperty("ICH-9-1-3-2")
    public void setICH_9_1_3_2(final String ICH_9_1_3_2) { this.ICH_9_1_3_2=ICH_9_1_3_2;}
    @Column(name = "ICH_9_1_3_3")
    @JsonProperty("ICH-9-1-3-3")
    private String ICH_9_1_3_3; // 吸烟程度评估
    public String getICH_9_1_3_3() {  return this.ICH_9_1_3_3;}
    @JsonProperty("ICH-9-1-3-3")
    public void setICH_9_1_3_3(final String ICH_9_1_3_3) { this.ICH_9_1_3_3=ICH_9_1_3_3;}
    @Column(name = "ICH_9_1_3_5")
    @JsonProperty("ICH-9-1-3-5")
    private String ICH_9_1_3_5; // 接受戒烟的建议或者戒烟治疗
    public String getICH_9_1_3_5() {  return this.ICH_9_1_3_5;}
    @JsonProperty("ICH-9-1-3-5")
    public void setICH_9_1_3_5(final String ICH_9_1_3_5) { this.ICH_9_1_3_5=ICH_9_1_3_5;}
    @Column(name = "ICH_9_2_1")
    @JsonProperty("ICH-9-2-1")
    private String ICH_9_2_1; // 出院时是否风险评分
    public String getICH_9_2_1() {  return this.ICH_9_2_1;}
    @JsonProperty("ICH-9-2-1")
    public void setICH_9_2_1(final String ICH_9_2_1) { this.ICH_9_2_1=ICH_9_2_1;}
    @Column(name = "ICH_9_2_1_1")
    @JsonProperty("ICH-9-2-1-1")
    private String ICH_9_2_1_1; // 出院时风险评分选择
    public String getICH_9_2_1_1() {  return this.ICH_9_2_1_1;}
    @JsonProperty("ICH-9-2-1-1")
    public void setICH_9_2_1_1(final String ICH_9_2_1_1) { this.ICH_9_2_1_1=ICH_9_2_1_1;}
    @Column(name = "ICH_9_2_1_2")
    @JsonProperty("ICH-9-2-1-2")
    private String ICH_9_2_1_2; // Essen卒中风险评分值
    public String getICH_9_2_1_2() {  return this.ICH_9_2_1_2;}
    @JsonProperty("ICH-9-2-1-2")
    public void setICH_9_2_1_2(final String ICH_9_2_1_2) { this.ICH_9_2_1_2=ICH_9_2_1_2;}
    @Column(name = "ICH_9_2_1_3")
    @JsonProperty("ICH-9-2-1-3")
    private String ICH_9_2_1_3; // 实施ICH评分评估分值
    public String getICH_9_2_1_3() {  return this.ICH_9_2_1_3;}
    @JsonProperty("ICH-9-2-1-3")
    public void setICH_9_2_1_3(final String ICH_9_2_1_3) { this.ICH_9_2_1_3=ICH_9_2_1_3;}
    @Column(name = "ICH_9_2_1_4")
    @JsonProperty("ICH-9-2-1-4")
    private String ICH_9_2_1_4; // 实施格拉斯哥昏迷评估分值
    public String getICH_9_2_1_4() {  return this.ICH_9_2_1_4;}
    @JsonProperty("ICH-9-2-1-4")
    public void setICH_9_2_1_4(final String ICH_9_2_1_4) { this.ICH_9_2_1_4=ICH_9_2_1_4;}
    @Column(name = "ICH_9_2_2_1")
    @JsonProperty("ICH-9-2-2-1")
    private String ICH_9_2_2_1; // 交与患者“出院小结”的副本，并告知患者出院时风险因素
    public String getICH_9_2_2_1() {  return this.ICH_9_2_2_1;}
    @JsonProperty("ICH-9-2-2-1")
    public void setICH_9_2_2_1(final String ICH_9_2_2_1) { this.ICH_9_2_2_1=ICH_9_2_2_1;}
    @Column(name = "ICH_9_2_2_2")
    @JsonProperty("ICH-9-2-2-2")
    private String ICH_9_2_2_2; // 出院带药
    public String getICH_9_2_2_2() {  return this.ICH_9_2_2_2;}
    @JsonProperty("ICH-9-2-2-2")
    public void setICH_9_2_2_2(final String ICH_9_2_2_2) { this.ICH_9_2_2_2=ICH_9_2_2_2;}
    @Column(name = "ICH_9_2_2_3")
    @JsonProperty("ICH-9-2-2-3")
    private String ICH_9_2_2_3; // 告知发生紧急情况时求援救治途径
    public String getICH_9_2_2_3() {  return this.ICH_9_2_2_3;}
    @JsonProperty("ICH-9-2-2-3")
    public void setICH_9_2_2_3(final String ICH_9_2_2_3) { this.ICH_9_2_2_3=ICH_9_2_2_3;}
    @Column(name = "ICH_9_2_2_4")
    @JsonProperty("ICH-9-2-2-4")
    private String ICH_9_2_2_4; // 出院时教育与随访
    public String getICH_9_2_2_4() {  return this.ICH_9_2_2_4;}
    @JsonProperty("ICH-9-2-2-4")
    public void setICH_9_2_2_4(final String ICH_9_2_2_4) { this.ICH_9_2_2_4=ICH_9_2_2_4;}
    @Column(name = "ICH_9_2_2_5")
    @JsonProperty("ICH-9-2-2-5")
    private String ICH_9_2_2_5; // 告知何为风险因素与紧急情况
    public String getICH_9_2_2_5() {  return this.ICH_9_2_2_5;}
    @JsonProperty("ICH-9-2-2-5")
    public void setICH_9_2_2_5(final String ICH_9_2_2_5) { this.ICH_9_2_2_5=ICH_9_2_2_5;}
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
}