package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断原发病 ICD-10 编码：I05 至 I09、或 I11 至 I13、或 I20 至 I21、或 I40 至 I41、或 I42 至 I43 伴第二诊断为I50 的出院患者。
*/
@ApiModel(value = "02信息")
@Entity
@Table(name = "sd_info_HF")
public class SdInfoHF implements Serializable {
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
    private String CM_0_1_3_1; // 主要诊断或其他诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断或其他诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "HF_0_1_4_1")
    @JsonProperty("HF-0-1-4-1")
    private String HF_0_1_4_1; // 第一诊断或第二诊断对应的原发疾病ICD-10的三位类亚目编码与名称
    public String getHF_0_1_4_1() {  return this.HF_0_1_4_1;}
    @JsonProperty("HF-0-1-4-1")
    public void setHF_0_1_4_1(final String HF_0_1_4_1) { this.HF_0_1_4_1=HF_0_1_4_1;}
    @Column(name = "HF_0_1_4_2")
    @JsonProperty("HF-0-1-4-2")
    private String HF_0_1_4_2; // 第一诊断或第二诊断对应的原发疾病ICD-10的三位类目编码与名称
    public String getHF_0_1_4_2() {  return this.HF_0_1_4_2;}
    @JsonProperty("HF-0-1-4-2")
    public void setHF_0_1_4_2(final String HF_0_1_4_2) { this.HF_0_1_4_2=HF_0_1_4_2;}
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
    private String CM_0_1_5; // 是否为出院后31天内非计划重复住院
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
    private String CM_0_2_5_1; // 入住CCU日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开CCU日期时间
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
    @Column(name = "HF_1_6_1")
    @JsonProperty("HF-1-6-1")
    private String HF_1_6_1; // 收缩压(mmHg)
    public String getHF_1_6_1() {  return this.HF_1_6_1;}
    @JsonProperty("HF-1-6-1")
    public void setHF_1_6_1(final String HF_1_6_1) { this.HF_1_6_1=HF_1_6_1;}
    @Column(name = "HF_1_6_2")
    @JsonProperty("HF-1-6-2")
    private String HF_1_6_2; // 舒张压(mmHg)
    public String getHF_1_6_2() {  return this.HF_1_6_2;}
    @JsonProperty("HF-1-6-2")
    public void setHF_1_6_2(final String HF_1_6_2) { this.HF_1_6_2=HF_1_6_2;}
    @Column(name = "HF_1_6_3")
    @JsonProperty("HF-1-6-3")
    private String HF_1_6_3; // 心率(次/分)
    public String getHF_1_6_3() {  return this.HF_1_6_3;}
    @JsonProperty("HF-1-6-3")
    public void setHF_1_6_3(final String HF_1_6_3) { this.HF_1_6_3=HF_1_6_3;}
    @Column(name = "HF_1_1_1")
    @JsonProperty("HF-1-1-1")
    private String HF_1_1_1; // 是否实施首次X线胸片检查
    public String getHF_1_1_1() {  return this.HF_1_1_1;}
    @JsonProperty("HF-1-1-1")
    public void setHF_1_1_1(final String HF_1_1_1) { this.HF_1_1_1=HF_1_1_1;}
    @Column(name = "HF_1_1_2")
    @JsonProperty("HF-1-1-2")
    private String HF_1_1_2; // 首次X线胸片检查报告日期时间
    public String getHF_1_1_2() {  return this.HF_1_1_2;}
    @JsonProperty("HF-1-1-2")
    public void setHF_1_1_2(final String HF_1_1_2) { this.HF_1_1_2=HF_1_1_2;}
    @Column(name = "HF_1_1_3")
    @JsonProperty("HF-1-1-3")
    private String HF_1_1_3; // 首次X线胸片检查报告是否有肺淤血或肺水肿
    public String getHF_1_1_3() {  return this.HF_1_1_3;}
    @JsonProperty("HF-1-1-3")
    public void setHF_1_1_3(final String HF_1_1_3) { this.HF_1_1_3=HF_1_1_3;}
    @Column(name = "HF_1_2_1")
    @JsonProperty("HF-1-2-1")
    private String HF_1_2_1; // 是否实施首次超声心动图(CDFA)检查
    public String getHF_1_2_1() {  return this.HF_1_2_1;}
    @JsonProperty("HF-1-2-1")
    public void setHF_1_2_1(final String HF_1_2_1) { this.HF_1_2_1=HF_1_2_1;}
    @Column(name = "HF_1_2_2")
    @JsonProperty("HF-1-2-2")
    private String HF_1_2_2; // 报告日期时间
    public String getHF_1_2_2() {  return this.HF_1_2_2;}
    @JsonProperty("HF-1-2-2")
    public void setHF_1_2_2(final String HF_1_2_2) { this.HF_1_2_2=HF_1_2_2;}
    @Column(name = "HF_1_2_3_4")
    @JsonProperty("HF-1-2-3-4")
    private String HF_1_2_3_4; // 左室舒张末内径（LVEDD）(mm)
    public String getHF_1_2_3_4() {  return this.HF_1_2_3_4;}
    @JsonProperty("HF-1-2-3-4")
    public void setHF_1_2_3_4(final String HF_1_2_3_4) { this.HF_1_2_3_4=HF_1_2_3_4;}
    @Column(name = "HF_1_2_3_1")
    @JsonProperty("HF-1-2-3-1")
    private String HF_1_2_3_1; // 左室射血分（LVEF）测量值(%)
    public String getHF_1_2_3_1() {  return this.HF_1_2_3_1;}
    @JsonProperty("HF-1-2-3-1")
    public void setHF_1_2_3_1(final String HF_1_2_3_1) { this.HF_1_2_3_1=HF_1_2_3_1;}
    @Column(name = "HF_1_2_3_2")
    @JsonProperty("HF-1-2-3-2")
    private String HF_1_2_3_2; // 左室射血分数评估结论
    public String getHF_1_2_3_2() {  return this.HF_1_2_3_2;}
    @JsonProperty("HF-1-2-3-2")
    public void setHF_1_2_3_2(final String HF_1_2_3_2) { this.HF_1_2_3_2=HF_1_2_3_2;}
    @Column(name = "HF_1_2_3_3")
    @JsonProperty("HF-1-2-3-3")
    private String HF_1_2_3_3; // 是否有左心室室壁瘤
    public String getHF_1_2_3_3() {  return this.HF_1_2_3_3;}
    @JsonProperty("HF-1-2-3-3")
    public void setHF_1_2_3_3(final String HF_1_2_3_3) { this.HF_1_2_3_3=HF_1_2_3_3;}
    @Column(name = "HF_1_3_1")
    @JsonProperty("HF-1-3-1")
    private String HF_1_3_1; // 实施首次评估患者的危险程度
    public String getHF_1_3_1() {  return this.HF_1_3_1;}
    @JsonProperty("HF-1-3-1")
    public void setHF_1_3_1(final String HF_1_3_1) { this.HF_1_3_1=HF_1_3_1;}
    @Column(name = "HF_1_3_3")
    @JsonProperty("HF-1-3-3")
    private String HF_1_3_3; // Killip分级评估结果的选择
    public String getHF_1_3_3() {  return this.HF_1_3_3;}
    @JsonProperty("HF-1-3-3")
    public void setHF_1_3_3(final String HF_1_3_3) { this.HF_1_3_3=HF_1_3_3;}
    @Column(name = "HF_1_3_2")
    @JsonProperty("HF-1-3-2")
    private String HF_1_3_2; // NYHA分级结果的选择
    public String getHF_1_3_2() {  return this.HF_1_3_2;}
    @JsonProperty("HF-1-3-2")
    public void setHF_1_3_2(final String HF_1_3_2) { this.HF_1_3_2=HF_1_3_2;}
    @Column(name = "HF_1_3_5")
    @JsonProperty("HF-1-3-5")
    private String HF_1_3_5; // 是否为非瓣膜性房颤/房扑患者
    public String getHF_1_3_5() {  return this.HF_1_3_5;}
    @JsonProperty("HF-1-3-5")
    public void setHF_1_3_5(final String HF_1_3_5) { this.HF_1_3_5=HF_1_3_5;}
    @Column(name = "HF_1_3_6_1")
    @JsonProperty("HF-1-3-6-1")
    private String HF_1_3_6_1; // 是否实施房颤患者风险评估
    public String getHF_1_3_6_1() {  return this.HF_1_3_6_1;}
    @JsonProperty("HF-1-3-6-1")
    public void setHF_1_3_6_1(final String HF_1_3_6_1) { this.HF_1_3_6_1=HF_1_3_6_1;}
    @Column(name = "HF_1_3_6_2")
    @JsonProperty("HF-1-3-6-2")
    private String HF_1_3_6_2; // 房颤患者脑险评估分值
    public String getHF_1_3_6_2() {  return this.HF_1_3_6_2;}
    @JsonProperty("HF-1-3-6-2")
    public void setHF_1_3_6_2(final String HF_1_3_6_2) { this.HF_1_3_6_2=HF_1_3_6_2;}
    @Column(name = "HF_1_3_6_3")
    @JsonProperty("HF-1-3-6-3")
    private String HF_1_3_6_3; // CHA2DS2-VASc评分大于2分
    public String getHF_1_3_6_3() {  return this.HF_1_3_6_3;}
    @JsonProperty("HF-1-3-6-3")
    public void setHF_1_3_6_3(final String HF_1_3_6_3) { this.HF_1_3_6_3=HF_1_3_6_3;}
    @Column(name = "HF_1_4_1")
    @JsonProperty("HF-1-4-1")
    private String HF_1_4_1; // 急诊或入院后是否首次心电图（ECG）检查
    public String getHF_1_4_1() {  return this.HF_1_4_1;}
    @JsonProperty("HF-1-4-1")
    public void setHF_1_4_1(final String HF_1_4_1) { this.HF_1_4_1=HF_1_4_1;}
    @Column(name = "HF_1_4_2")
    @JsonProperty("HF-1-4-2")
    private String HF_1_4_2; // 报告日期时间
    public String getHF_1_4_2() {  return this.HF_1_4_2;}
    @JsonProperty("HF-1-4-2")
    public void setHF_1_4_2(final String HF_1_4_2) { this.HF_1_4_2=HF_1_4_2;}
    @Column(name = "HF_1_4_3")
    @JsonProperty("HF-1-4-3")
    private String HF_1_4_3; // QRS宽度(ms)
    public String getHF_1_4_3() {  return this.HF_1_4_3;}
    @JsonProperty("HF-1-4-3")
    public void setHF_1_4_3(final String HF_1_4_3) { this.HF_1_4_3=HF_1_4_3;}
    @Column(name = "HF_1_4_4")
    @JsonProperty("HF-1-4-4")
    private String HF_1_4_4; // 心电图（ECG）检查结果选择
    public String getHF_1_4_4() {  return this.HF_1_4_4;}
    @JsonProperty("HF-1-4-4")
    public void setHF_1_4_4(final String HF_1_4_4) { this.HF_1_4_4=HF_1_4_4;}
    @Column(name = "HF_1_4_4_1")
    @JsonProperty("HF-1-4-4-1")
    private String HF_1_4_4_1; // 其他心电图检查结果
    public String getHF_1_4_4_1() {  return this.HF_1_4_4_1;}
    @JsonProperty("HF-1-4-4-1")
    public void setHF_1_4_4_1(final String HF_1_4_4_1) { this.HF_1_4_4_1=HF_1_4_4_1;}
    @Column(name = "HF_1_5_1_1")
    @JsonProperty("HF-1-5-1-1")
    private String HF_1_5_1_1; // 是否实施首次检测
    public String getHF_1_5_1_1() {  return this.HF_1_5_1_1;}
    @JsonProperty("HF-1-5-1-1")
    public void setHF_1_5_1_1(final String HF_1_5_1_1) { this.HF_1_5_1_1=HF_1_5_1_1;}
    @Column(name = "HF_1_5_1_2")
    @JsonProperty("HF-1-5-1-2")
    private String HF_1_5_1_2; // 首次检测结果报告日期
    public String getHF_1_5_1_2() {  return this.HF_1_5_1_2;}
    @JsonProperty("HF-1-5-1-2")
    public void setHF_1_5_1_2(final String HF_1_5_1_2) { this.HF_1_5_1_2=HF_1_5_1_2;}
    @Column(name = "HF_1_5_3")
    @JsonProperty("HF-1-5-3")
    private String HF_1_5_3; // 首次检测选择
    public String getHF_1_5_3() {  return this.HF_1_5_3;}
    @JsonProperty("HF-1-5-3")
    public void setHF_1_5_3(final String HF_1_5_3) { this.HF_1_5_3=HF_1_5_3;}
    @Column(name = "HF_1_5_2_1")
    @JsonProperty("HF-1-5-2-1")
    private String HF_1_5_2_1; // 肌钙蛋白T（TnT）检测值(ng/mL)
    public String getHF_1_5_2_1() {  return this.HF_1_5_2_1;}
    @JsonProperty("HF-1-5-2-1")
    public void setHF_1_5_2_1(final String HF_1_5_2_1) { this.HF_1_5_2_1=HF_1_5_2_1;}
    @Column(name = "HF_1_5_2_2")
    @JsonProperty("HF-1-5-2-2")
    private String HF_1_5_2_2; // 肌钙蛋白I（TnI）检测值(ng/mL)
    public String getHF_1_5_2_2() {  return this.HF_1_5_2_2;}
    @JsonProperty("HF-1-5-2-2")
    public void setHF_1_5_2_2(final String HF_1_5_2_2) { this.HF_1_5_2_2=HF_1_5_2_2;}
    @Column(name = "HF_1_5_2_3")
    @JsonProperty("HF-1-5-2-3")
    private String HF_1_5_2_3; // 肌酸激酶同工酶（CK-MB）检测值(ng/mL)
    public String getHF_1_5_2_3() {  return this.HF_1_5_2_3;}
    @JsonProperty("HF-1-5-2-3")
    public void setHF_1_5_2_3(final String HF_1_5_2_3) { this.HF_1_5_2_3=HF_1_5_2_3;}
    @Column(name = "HF_1_5_2_4")
    @JsonProperty("HF-1-5-2-4")
    private String HF_1_5_2_4; // 心肌肌红蛋白（Myo）检测值(ng/mL)
    public String getHF_1_5_2_4() {  return this.HF_1_5_2_4;}
    @JsonProperty("HF-1-5-2-4")
    public void setHF_1_5_2_4(final String HF_1_5_2_4) { this.HF_1_5_2_4=HF_1_5_2_4;}
    @Column(name = "HF_1_5_2_5")
    @JsonProperty("HF-1-5-2-5")
    private String HF_1_5_2_5; // B型钠尿肽（BNP）检测值(ng/mL)
    public String getHF_1_5_2_5() {  return this.HF_1_5_2_5;}
    @JsonProperty("HF-1-5-2-5")
    public void setHF_1_5_2_5(final String HF_1_5_2_5) { this.HF_1_5_2_5=HF_1_5_2_5;}
    @Column(name = "HF_1_5_2_6")
    @JsonProperty("HF-1-5-2-6")
    private String HF_1_5_2_6; // N端B型钠尿肽前体（NT-ProBNP）检测值(ng/L)
    public String getHF_1_5_2_6() {  return this.HF_1_5_2_6;}
    @JsonProperty("HF-1-5-2-6")
    public void setHF_1_5_2_6(final String HF_1_5_2_6) { this.HF_1_5_2_6=HF_1_5_2_6;}
    @Column(name = "HF_1_5_2_7")
    @JsonProperty("HF-1-5-2-7")
    private String HF_1_5_2_7; // 血糖 检测值(mmol/L)
    public String getHF_1_5_2_7() {  return this.HF_1_5_2_7;}
    @JsonProperty("HF-1-5-2-7")
    public void setHF_1_5_2_7(final String HF_1_5_2_7) { this.HF_1_5_2_7=HF_1_5_2_7;}
    @Column(name = "HF_1_5_2_8")
    @JsonProperty("HF-1-5-2-8")
    private String HF_1_5_2_8; // D-二聚体 检测值(ug/mL)
    public String getHF_1_5_2_8() {  return this.HF_1_5_2_8;}
    @JsonProperty("HF-1-5-2-8")
    public void setHF_1_5_2_8(final String HF_1_5_2_8) { this.HF_1_5_2_8=HF_1_5_2_8;}
    @Column(name = "HF_1_5_2_9")
    @JsonProperty("HF-1-5-2-9")
    private String HF_1_5_2_9; // 血肌酐 检测值(umol/L)
    public String getHF_1_5_2_9() {  return this.HF_1_5_2_9;}
    @JsonProperty("HF-1-5-2-9")
    public void setHF_1_5_2_9(final String HF_1_5_2_9) { this.HF_1_5_2_9=HF_1_5_2_9;}
    @Column(name = "HF_1_5_2_10")
    @JsonProperty("HF-1-5-2-10")
    private String HF_1_5_2_10; // 血钾 检测值(mmol/L)
    public String getHF_1_5_2_10() {  return this.HF_1_5_2_10;}
    @JsonProperty("HF-1-5-2-10")
    public void setHF_1_5_2_10(final String HF_1_5_2_10) { this.HF_1_5_2_10=HF_1_5_2_10;}
    @Column(name = "HF_1_5_2_11")
    @JsonProperty("HF-1-5-2-11")
    private String HF_1_5_2_11; // 其他项目名称
    public String getHF_1_5_2_11() {  return this.HF_1_5_2_11;}
    @JsonProperty("HF-1-5-2-11")
    public void setHF_1_5_2_11(final String HF_1_5_2_11) { this.HF_1_5_2_11=HF_1_5_2_11;}
    @Column(name = "HF_1_5_2_12")
    @JsonProperty("HF-1-5-2-12")
    private String HF_1_5_2_12; // 其他项 检测值
    public String getHF_1_5_2_12() {  return this.HF_1_5_2_12;}
    @JsonProperty("HF-1-5-2-12")
    public void setHF_1_5_2_12(final String HF_1_5_2_12) { this.HF_1_5_2_12=HF_1_5_2_12;}
    @Column(name = "HF_2_2_1")
    @JsonProperty("HF-2-2-1")
    private String HF_2_2_1; // 是否有液体潴留的症状及体征
    public String getHF_2_2_1() {  return this.HF_2_2_1;}
    @JsonProperty("HF-2-2-1")
    public void setHF_2_2_1(final String HF_2_2_1) { this.HF_2_2_1=HF_2_2_1;}
    @Column(name = "HF_2_1_A")
    @JsonProperty("HF-2-1-A")
    private String HF_2_1_A; // 是否有利尿剂的禁忌证
    public String getHF_2_1_A() {  return this.HF_2_1_A;}
    @JsonProperty("HF-2-1-A")
    public void setHF_2_1_A(final String HF_2_1_A) { this.HF_2_1_A=HF_2_1_A;}
    @Column(name = "HF_2_1")
    @JsonProperty("HF-2-1")
    private String HF_2_1; // 使用利尿剂的禁忌证选择
    public String getHF_2_1() {  return this.HF_2_1;}
    @JsonProperty("HF-2-1")
    public void setHF_2_1(final String HF_2_1) { this.HF_2_1=HF_2_1;}
    @Column(name = "HF_2_1_1")
    @JsonProperty("HF-2-1-1")
    private String HF_2_1_1; // 其他使用利尿剂的禁忌证
    public String getHF_2_1_1() {  return this.HF_2_1_1;}
    @JsonProperty("HF-2-1-1")
    public void setHF_2_1_1(final String HF_2_1_1) { this.HF_2_1_1=HF_2_1_1;}
    @Column(name = "HF_2_2")
    @JsonProperty("HF-2-2")
    private String HF_2_2; // 首剂用药日期时间
    public String getHF_2_2() {  return this.HF_2_2;}
    @JsonProperty("HF-2-2")
    public void setHF_2_2(final String HF_2_2) { this.HF_2_2=HF_2_2;}
    @Column(name = "HF_2_3")
    @JsonProperty("HF-2-3")
    private String HF_2_3; // 常用利尿剂药物
    public String getHF_2_3() {  return this.HF_2_3;}
    @JsonProperty("HF-2-3")
    public void setHF_2_3(final String HF_2_3) { this.HF_2_3=HF_2_3;}
    @Column(name = "HF_2_3_1")
    @JsonProperty("HF-2-3-1")
    private String HF_2_3_1; // 其他利尿剂药物填写
    public String getHF_2_3_1() {  return this.HF_2_3_1;}
    @JsonProperty("HF-2-3-1")
    public void setHF_2_3_1(final String HF_2_3_1) { this.HF_2_3_1=HF_2_3_1;}
    @Column(name = "HF_2_2_dump")
    @JsonProperty("HF-2-2-dump")
    private String HF_2_2_dump; // 首剂利尿剂时长
    public String getHF_2_2_dump() {  return this.HF_2_2_dump;}
    @JsonProperty("HF-2-2-dump")
    public void setHF_2_2_dump(final String HF_2_2_dump) { this.HF_2_2_dump=HF_2_2_dump;}
    @Column(name = "HF_2_5")
    @JsonProperty("HF-2-5")
    private String HF_2_5; // 入院至使用首剂利尿剂时间大于24小时
    public String getHF_2_5() {  return this.HF_2_5;}
    @JsonProperty("HF-2-5")
    public void setHF_2_5(final String HF_2_5) { this.HF_2_5=HF_2_5;}
    @Column(name = "HF_2_4")
    @JsonProperty("HF-2-4")
    private String HF_2_4; // 延迟治疗原因的选择
    public String getHF_2_4() {  return this.HF_2_4;}
    @JsonProperty("HF-2-4")
    public void setHF_2_4(final String HF_2_4) { this.HF_2_4=HF_2_4;}
    @Column(name = "HF_2_4_1")
    @JsonProperty("HF-2-4-1")
    private String HF_2_4_1; // 其他延迟治疗原因
    public String getHF_2_4_1() {  return this.HF_2_4_1;}
    @JsonProperty("HF-2-4-1")
    public void setHF_2_4_1(final String HF_2_4_1) { this.HF_2_4_1=HF_2_4_1;}
    @Column(name = "HF_3_1")
    @JsonProperty("HF-3-1")
    private String HF_3_1; // 左心室收缩功能障碍
    public String getHF_3_1() {  return this.HF_3_1;}
    @JsonProperty("HF-3-1")
    public void setHF_3_1(final String HF_3_1) { this.HF_3_1=HF_3_1;}
    @Column(name = "HF_3_2_A")
    @JsonProperty("HF-3-2-A")
    private String HF_3_2_A; // 是否有ACEI抑制剂类药物禁忌证
    public String getHF_3_2_A() {  return this.HF_3_2_A;}
    @JsonProperty("HF-3-2-A")
    public void setHF_3_2_A(final String HF_3_2_A) { this.HF_3_2_A=HF_3_2_A;}
    @Column(name = "HF_3_2_1")
    @JsonProperty("HF-3-2-1")
    private String HF_3_2_1; // ACEI抑制剂类药物禁忌证与须慎用的情况
    public String getHF_3_2_1() {  return this.HF_3_2_1;}
    @JsonProperty("HF-3-2-1")
    public void setHF_3_2_1(final String HF_3_2_1) { this.HF_3_2_1=HF_3_2_1;}
    @Column(name = "HF_3_2_B")
    @JsonProperty("HF-3-2-B")
    private String HF_3_2_B; // 是否有ARNI类药物禁忌证
    public String getHF_3_2_B() {  return this.HF_3_2_B;}
    @JsonProperty("HF-3-2-B")
    public void setHF_3_2_B(final String HF_3_2_B) { this.HF_3_2_B=HF_3_2_B;}
    @Column(name = "HF_3_2_2")
    @JsonProperty("HF-3-2-2")
    private String HF_3_2_2; // ARNI类药物禁忌证与须慎用的情况
    public String getHF_3_2_2() {  return this.HF_3_2_2;}
    @JsonProperty("HF-3-2-2")
    public void setHF_3_2_2(final String HF_3_2_2) { this.HF_3_2_2=HF_3_2_2;}
    @Column(name = "HF_3_4_6")
    @JsonProperty("HF-3-4-6")
    private String HF_3_4_6; // 是否使用肾素-血管紧张素系统抑制剂药物
    public String getHF_3_4_6() {  return this.HF_3_4_6;}
    @JsonProperty("HF-3-4-6")
    public void setHF_3_4_6(final String HF_3_4_6) { this.HF_3_4_6=HF_3_4_6;}
    @Column(name = "HF_3_4_5")
    @JsonProperty("HF-3-4-5")
    private String HF_3_4_5; // 使用肾素-血管紧张素系统抑制剂药物
    public String getHF_3_4_5() {  return this.HF_3_4_5;}
    @JsonProperty("HF-3-4-5")
    public void setHF_3_4_5(final String HF_3_4_5) { this.HF_3_4_5=HF_3_4_5;}
    @Column(name = "HF_3_4_A")
    @JsonProperty("HF-3-4-A")
    private String HF_3_4_A; // ACE抑制剂药物
    public String getHF_3_4_A() {  return this.HF_3_4_A;}
    @JsonProperty("HF-3-4-A")
    public void setHF_3_4_A(final String HF_3_4_A) { this.HF_3_4_A=HF_3_4_A;}
    @Column(name = "HF_3_4_A_1")
    @JsonProperty("HF-3-4-A-1")
    private String HF_3_4_A_1; // 其他ACEI药物
    public String getHF_3_4_A_1() {  return this.HF_3_4_A_1;}
    @JsonProperty("HF-3-4-A-1")
    public void setHF_3_4_A_1(final String HF_3_4_A_1) { this.HF_3_4_A_1=HF_3_4_A_1;}
    @Column(name = "HF_3_4_B")
    @JsonProperty("HF-3-4-B")
    private String HF_3_4_B; // ARB类药物
    public String getHF_3_4_B() {  return this.HF_3_4_B;}
    @JsonProperty("HF-3-4-B")
    public void setHF_3_4_B(final String HF_3_4_B) { this.HF_3_4_B=HF_3_4_B;}
    @Column(name = "HF_3_4_B_1")
    @JsonProperty("HF-3-4-B-1")
    private String HF_3_4_B_1; // 其他ARB类药物填写
    public String getHF_3_4_B_1() {  return this.HF_3_4_B_1;}
    @JsonProperty("HF-3-4-B-1")
    public void setHF_3_4_B_1(final String HF_3_4_B_1) { this.HF_3_4_B_1=HF_3_4_B_1;}
    @Column(name = "HF_3_4_C")
    @JsonProperty("HF-3-4-C")
    private String HF_3_4_C; // 使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物的选择
    public String getHF_3_4_C() {  return this.HF_3_4_C;}
    @JsonProperty("HF-3-4-C")
    public void setHF_3_4_C(final String HF_3_4_C) { this.HF_3_4_C=HF_3_4_C;}
    @Column(name = "HF_3_4_C_1")
    @JsonProperty("HF-3-4-C-1")
    private String HF_3_4_C_1; // 其他使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物
    public String getHF_3_4_C_1() {  return this.HF_3_4_C_1;}
    @JsonProperty("HF-3-4-C-1")
    public void setHF_3_4_C_1(final String HF_3_4_C_1) { this.HF_3_4_C_1=HF_3_4_C_1;}
    @Column(name = "HF_3_3_1")
    @JsonProperty("HF-3-3-1")
    private String HF_3_3_1; // 首剂用药日期是否未确定
    public String getHF_3_3_1() {  return this.HF_3_3_1;}
    @JsonProperty("HF-3-3-1")
    public void setHF_3_3_1(final String HF_3_3_1) { this.HF_3_3_1=HF_3_3_1;}
    @Column(name = "HF_3_3")
    @JsonProperty("HF-3-3")
    private String HF_3_3; // 首剂用药日期时间
    public String getHF_3_3() {  return this.HF_3_3;}
    @JsonProperty("HF-3-3")
    public void setHF_3_3(final String HF_3_3) { this.HF_3_3=HF_3_3;}
    @Column(name = "HF_jump_2")
    @JsonProperty("HF-jump-2")
    private String HF_jump_2; // HF-jump-2
    public String getHF_jump_2() {  return this.HF_jump_2;}
    @JsonProperty("HF-jump-2")
    public void setHF_jump_2(final String HF_jump_2) { this.HF_jump_2=HF_jump_2;}
    @Column(name = "HF_3_6")
    @JsonProperty("HF-3-6")
    private String HF_3_6; // 入院至使用首剂ACEI/ARB类药物时间大于24小时
    public String getHF_3_6() {  return this.HF_3_6;}
    @JsonProperty("HF-3-6")
    public void setHF_3_6(final String HF_3_6) { this.HF_3_6=HF_3_6;}
    @Column(name = "HF_3_5")
    @JsonProperty("HF-3-5")
    private String HF_3_5; // 延迟治疗原因
    public String getHF_3_5() {  return this.HF_3_5;}
    @JsonProperty("HF-3-5")
    public void setHF_3_5(final String HF_3_5) { this.HF_3_5=HF_3_5;}
    @Column(name = "HF_3_5_1")
    @JsonProperty("HF-3-5-1")
    private String HF_3_5_1; // 其他延迟治疗原因
    public String getHF_3_5_1() {  return this.HF_3_5_1;}
    @JsonProperty("HF-3-5-1")
    public void setHF_3_5_1(final String HF_3_5_1) { this.HF_3_5_1=HF_3_5_1;}
    @Column(name = "HF_4_1_1")
    @JsonProperty("HF-4-1-1")
    private String HF_4_1_1; // 是否有禁忌证与须慎用的情况
    public String getHF_4_1_1() {  return this.HF_4_1_1;}
    @JsonProperty("HF-4-1-1")
    public void setHF_4_1_1(final String HF_4_1_1) { this.HF_4_1_1=HF_4_1_1;}
    @Column(name = "HF_4_1_2")
    @JsonProperty("HF-4-1-2")
    private String HF_4_1_2; // β-受体阻滞剂禁忌证选择
    public String getHF_4_1_2() {  return this.HF_4_1_2;}
    @JsonProperty("HF-4-1-2")
    public void setHF_4_1_2(final String HF_4_1_2) { this.HF_4_1_2=HF_4_1_2;}
    @Column(name = "HF_4_3")
    @JsonProperty("HF-4-3")
    private String HF_4_3; // 使用首剂β-受体阻滞剂药物
    public String getHF_4_3() {  return this.HF_4_3;}
    @JsonProperty("HF-4-3")
    public void setHF_4_3(final String HF_4_3) { this.HF_4_3=HF_4_3;}
    @Column(name = "HF_4_3_1")
    @JsonProperty("HF-4-3-1")
    private String HF_4_3_1; // 其他β-受体阻滞剂药物
    public String getHF_4_3_1() {  return this.HF_4_3_1;}
    @JsonProperty("HF-4-3-1")
    public void setHF_4_3_1(final String HF_4_3_1) { this.HF_4_3_1=HF_4_3_1;}
    @Column(name = "HF_4_2_1")
    @JsonProperty("HF-4-2-1")
    private String HF_4_2_1; // 首剂用药日期是否未确定
    public String getHF_4_2_1() {  return this.HF_4_2_1;}
    @JsonProperty("HF-4-2-1")
    public void setHF_4_2_1(final String HF_4_2_1) { this.HF_4_2_1=HF_4_2_1;}
    @Column(name = "HF_4_2")
    @JsonProperty("HF-4-2")
    private String HF_4_2; // 首剂用药日期时间
    public String getHF_4_2() {  return this.HF_4_2;}
    @JsonProperty("HF-4-2")
    public void setHF_4_2(final String HF_4_2) { this.HF_4_2=HF_4_2;}
    @Column(name = "HF_jump_3")
    @JsonProperty("HF-jump-3")
    private String HF_jump_3; // HF-jump-3
    public String getHF_jump_3() {  return this.HF_jump_3;}
    @JsonProperty("HF-jump-3")
    public void setHF_jump_3(final String HF_jump_3) { this.HF_jump_3=HF_jump_3;}
    @Column(name = "HF_4_5")
    @JsonProperty("HF-4-5")
    private String HF_4_5; // 入院至使用首剂β-受体阻滞剂时间大于24小时
    public String getHF_4_5() {  return this.HF_4_5;}
    @JsonProperty("HF-4-5")
    public void setHF_4_5(final String HF_4_5) { this.HF_4_5=HF_4_5;}
    @Column(name = "HF_4_4")
    @JsonProperty("HF-4-4")
    private String HF_4_4; // 延迟治疗原因
    public String getHF_4_4() {  return this.HF_4_4;}
    @JsonProperty("HF-4-4")
    public void setHF_4_4(final String HF_4_4) { this.HF_4_4=HF_4_4;}
    @Column(name = "HF_4_4_1")
    @JsonProperty("HF-4-4-1")
    private String HF_4_4_1; // 其他延迟治疗原因
    public String getHF_4_4_1() {  return this.HF_4_4_1;}
    @JsonProperty("HF-4-4-1")
    public void setHF_4_4_1(final String HF_4_4_1) { this.HF_4_4_1=HF_4_4_1;}
    @Column(name = "HF_5_6_1")
    @JsonProperty("HF-5-6-1")
    private String HF_5_6_1; // 是否有醛固酮受体拮抗剂的禁忌证
    public String getHF_5_6_1() {  return this.HF_5_6_1;}
    @JsonProperty("HF-5-6-1")
    public void setHF_5_6_1(final String HF_5_6_1) { this.HF_5_6_1=HF_5_6_1;}
    @Column(name = "HF_5_1_2")
    @JsonProperty("HF-5-1-2")
    private String HF_5_1_2; // 醛固酮受体拮抗剂的禁忌证
    public String getHF_5_1_2() {  return this.HF_5_1_2;}
    @JsonProperty("HF-5-1-2")
    public void setHF_5_1_2(final String HF_5_1_2) { this.HF_5_1_2=HF_5_1_2;}
    @Column(name = "HF_5_2")
    @JsonProperty("HF-5-2")
    private String HF_5_2; // 重度心衰使用醛固酮受体拮抗剂适用症
    public String getHF_5_2() {  return this.HF_5_2;}
    @JsonProperty("HF-5-2")
    public void setHF_5_2(final String HF_5_2) { this.HF_5_2=HF_5_2;}
    @Column(name = "HF_5_2_1_1")
    @JsonProperty("HF-5-2-1-1")
    private String HF_5_2_1_1; // 其他重度心衰使用醛固酮受体拮抗剂适用症
    public String getHF_5_2_1_1() {  return this.HF_5_2_1_1;}
    @JsonProperty("HF-5-2-1-1")
    public void setHF_5_2_1_1(final String HF_5_2_1_1) { this.HF_5_2_1_1=HF_5_2_1_1;}
    @Column(name = "HF_5_3_1")
    @JsonProperty("HF-5-3-1")
    private String HF_5_3_1; // 首剂用药日期是否未确定
    public String getHF_5_3_1() {  return this.HF_5_3_1;}
    @JsonProperty("HF-5-3-1")
    public void setHF_5_3_1(final String HF_5_3_1) { this.HF_5_3_1=HF_5_3_1;}
    @Column(name = "HF_5_3_1_r")
    @JsonProperty("HF-5-3-1-r")
    private String HF_5_3_1_r; // HF-jump-4
    public String getHF_5_3_1_r() {  return this.HF_5_3_1_r;}
    @JsonProperty("HF-5-3-1-r")
    public void setHF_5_3_1_r(final String HF_5_3_1_r) { this.HF_5_3_1_r=HF_5_3_1_r;}
    @Column(name = "HF_5_3")
    @JsonProperty("HF-5-3")
    private String HF_5_3; // 首剂用药日期时间
    public String getHF_5_3() {  return this.HF_5_3;}
    @JsonProperty("HF-5-3")
    public void setHF_5_3(final String HF_5_3) { this.HF_5_3=HF_5_3;}
    @Column(name = "HF_5_6")
    @JsonProperty("HF-5-6")
    private String HF_5_6; // 入院至使用首剂醛固酮受体拮抗剂时间大于24小时
    public String getHF_5_6() {  return this.HF_5_6;}
    @JsonProperty("HF-5-6")
    public void setHF_5_6(final String HF_5_6) { this.HF_5_6=HF_5_6;}
    @Column(name = "HF_5_4")
    @JsonProperty("HF-5-4")
    private String HF_5_4; // 使用醛固酮受体拮抗剂
    public String getHF_5_4() {  return this.HF_5_4;}
    @JsonProperty("HF-5-4")
    public void setHF_5_4(final String HF_5_4) { this.HF_5_4=HF_5_4;}
    @Column(name = "HF_5_4_1")
    @JsonProperty("HF-5-4-1")
    private String HF_5_4_1; // 其他醛固酮受体拮抗剂类药物
    public String getHF_5_4_1() {  return this.HF_5_4_1;}
    @JsonProperty("HF-5-4-1")
    public void setHF_5_4_1(final String HF_5_4_1) { this.HF_5_4_1=HF_5_4_1;}
    @Column(name = "HF_5_5")
    @JsonProperty("HF-5-5")
    private String HF_5_5; // 延迟治疗原因
    public String getHF_5_5() {  return this.HF_5_5;}
    @JsonProperty("HF-5-5")
    public void setHF_5_5(final String HF_5_5) { this.HF_5_5=HF_5_5;}
    @Column(name = "HF_5_5_1")
    @JsonProperty("HF-5-5-1")
    private String HF_5_5_1; // 其他延迟治疗原因
    public String getHF_5_5_1() {  return this.HF_5_5_1;}
    @JsonProperty("HF-5-5-1")
    public void setHF_5_5_1(final String HF_5_5_1) { this.HF_5_5_1=HF_5_5_1;}
    @Column(name = "HF_5_6_2")
    @JsonProperty("HF-5-6-2")
    private String HF_5_6_2; // 是否有SGLT-2拮抗剂抑制剂药物的禁忌证
    public String getHF_5_6_2() {  return this.HF_5_6_2;}
    @JsonProperty("HF-5-6-2")
    public void setHF_5_6_2(final String HF_5_6_2) { this.HF_5_6_2=HF_5_6_2;}
    @Column(name = "HF_5_6_3")
    @JsonProperty("HF-5-6-3")
    private String HF_5_6_3; // SGLT-2拮抗剂抑制剂药物的禁忌证
    public String getHF_5_6_3() {  return this.HF_5_6_3;}
    @JsonProperty("HF-5-6-3")
    public void setHF_5_6_3(final String HF_5_6_3) { this.HF_5_6_3=HF_5_6_3;}
    @Column(name = "HF_5_7_1")
    @JsonProperty("HF-5-7-1")
    private String HF_5_7_1; // SGLT-2抑制剂药物用药日期是否无法确定或无记录
    public String getHF_5_7_1() {  return this.HF_5_7_1;}
    @JsonProperty("HF-5-7-1")
    public void setHF_5_7_1(final String HF_5_7_1) { this.HF_5_7_1=HF_5_7_1;}
    @Column(name = "HF_5_7_4")
    @JsonProperty("HF-5-7-4")
    private String HF_5_7_4; // SGLT-2抑制剂药物用药日期
    public String getHF_5_7_4() {  return this.HF_5_7_4;}
    @JsonProperty("HF-5-7-4")
    public void setHF_5_7_4(final String HF_5_7_4) { this.HF_5_7_4=HF_5_7_4;}
    @Column(name = "HF_5_7_3_r")
    @JsonProperty("HF-5-7-3-r")
    private String HF_5_7_3_r; // 抑制剂药物时间-入院时间
    public String getHF_5_7_3_r() {  return this.HF_5_7_3_r;}
    @JsonProperty("HF-5-7-3-r")
    public void setHF_5_7_3_r(final String HF_5_7_3_r) { this.HF_5_7_3_r=HF_5_7_3_r;}
    @Column(name = "HF_5_7_3")
    @JsonProperty("HF-5-7-3")
    private String HF_5_7_3; // SGLT-2拮抗剂抑制剂药物的选择
    public String getHF_5_7_3() {  return this.HF_5_7_3;}
    @JsonProperty("HF-5-7-3")
    public void setHF_5_7_3(final String HF_5_7_3) { this.HF_5_7_3=HF_5_7_3;}
    @Column(name = "HF_5_7_3_1")
    @JsonProperty("HF-5-7-3-1")
    private String HF_5_7_3_1; // 其他SGLT-2 抑制剂药物
    public String getHF_5_7_3_1() {  return this.HF_5_7_3_1;}
    @JsonProperty("HF-5-7-3-1")
    public void setHF_5_7_3_1(final String HF_5_7_3_1) { this.HF_5_7_3_1=HF_5_7_3_1;}
    @Column(name = "HF_5_8_1")
    @JsonProperty("HF-5-8-1")
    private String HF_5_8_1; // 入院至使用首剂SGLT-2抑制剂药物时间大于24小时
    public String getHF_5_8_1() {  return this.HF_5_8_1;}
    @JsonProperty("HF-5-8-1")
    public void setHF_5_8_1(final String HF_5_8_1) { this.HF_5_8_1=HF_5_8_1;}
    @Column(name = "HF_5_8_2")
    @JsonProperty("HF-5-8-2")
    private String HF_5_8_2; // 延迟治疗的原因
    public String getHF_5_8_2() {  return this.HF_5_8_2;}
    @JsonProperty("HF-5-8-2")
    public void setHF_5_8_2(final String HF_5_8_2) { this.HF_5_8_2=HF_5_8_2;}
    @Column(name = "HF_5_8_2_1")
    @JsonProperty("HF-5-8-2-1")
    private String HF_5_8_2_1; // 延迟治疗的其他原因
    public String getHF_5_8_2_1() {  return this.HF_5_8_2_1;}
    @JsonProperty("HF-5-8-2-1")
    public void setHF_5_8_2_1(final String HF_5_8_2_1) { this.HF_5_8_2_1=HF_5_8_2_1;}
    @Column(name = "HF_6_1_1")
    @JsonProperty("HF-6-1-1")
    private String HF_6_1_1; // 是否有用药长期医嘱
    public String getHF_6_1_1() {  return this.HF_6_1_1;}
    @JsonProperty("HF-6-1-1")
    public void setHF_6_1_1(final String HF_6_1_1) { this.HF_6_1_1=HF_6_1_1;}
    @Column(name = "HF_6_1_2")
    @JsonProperty("HF-6-1-2")
    private String HF_6_1_2; // 常用利尿剂药物的选择
    public String getHF_6_1_2() {  return this.HF_6_1_2;}
    @JsonProperty("HF-6-1-2")
    public void setHF_6_1_2(final String HF_6_1_2) { this.HF_6_1_2=HF_6_1_2;}
    @Column(name = "HF_6_1_2_1")
    @JsonProperty("HF-6-1-2-1")
    private String HF_6_1_2_1; // 其他常用利尿剂
    public String getHF_6_1_2_1() {  return this.HF_6_1_2_1;}
    @JsonProperty("HF-6-1-2-1")
    public void setHF_6_1_2_1(final String HF_6_1_2_1) { this.HF_6_1_2_1=HF_6_1_2_1;}
    @Column(name = "HF_6_2_1")
    @JsonProperty("HF-6-2-1")
    private String HF_6_2_1; // 是否有ACEI或ARB药物长期医嘱
    public String getHF_6_2_1() {  return this.HF_6_2_1;}
    @JsonProperty("HF-6-2-1")
    public void setHF_6_2_1(final String HF_6_2_1) { this.HF_6_2_1=HF_6_2_1;}
    @Column(name = "HF_6_2_2")
    @JsonProperty("HF-6-2-2")
    private String HF_6_2_2; // 使用ACEI抑制剂或者ARB或者ARNI类药物选择
    public String getHF_6_2_2() {  return this.HF_6_2_2;}
    @JsonProperty("HF-6-2-2")
    public void setHF_6_2_2(final String HF_6_2_2) { this.HF_6_2_2=HF_6_2_2;}
    @Column(name = "HF_6_2_2_A")
    @JsonProperty("HF-6-2-2-A")
    private String HF_6_2_2_A; // ACE抑制剂药物
    public String getHF_6_2_2_A() {  return this.HF_6_2_2_A;}
    @JsonProperty("HF-6-2-2-A")
    public void setHF_6_2_2_A(final String HF_6_2_2_A) { this.HF_6_2_2_A=HF_6_2_2_A;}
    @Column(name = "HF_6_2_2_A_1")
    @JsonProperty("HF-6-2-2-A-1")
    private String HF_6_2_2_A_1; // 其他ACEI药物填写
    public String getHF_6_2_2_A_1() {  return this.HF_6_2_2_A_1;}
    @JsonProperty("HF-6-2-2-A-1")
    public void setHF_6_2_2_A_1(final String HF_6_2_2_A_1) { this.HF_6_2_2_A_1=HF_6_2_2_A_1;}
    @Column(name = "HF_6_2_2_B")
    @JsonProperty("HF-6-2-2-B")
    private String HF_6_2_2_B; // ARB类药物
    public String getHF_6_2_2_B() {  return this.HF_6_2_2_B;}
    @JsonProperty("HF-6-2-2-B")
    public void setHF_6_2_2_B(final String HF_6_2_2_B) { this.HF_6_2_2_B=HF_6_2_2_B;}
    @Column(name = "HF_6_2_2_B_1")
    @JsonProperty("HF-6-2-2-B-1")
    private String HF_6_2_2_B_1; // 其他ARB药物填写
    public String getHF_6_2_2_B_1() {  return this.HF_6_2_2_B_1;}
    @JsonProperty("HF-6-2-2-B-1")
    public void setHF_6_2_2_B_1(final String HF_6_2_2_B_1) { this.HF_6_2_2_B_1=HF_6_2_2_B_1;}
    @Column(name = "HF_6_2_2_C")
    @JsonProperty("HF-6-2-2-C")
    private String HF_6_2_2_C; // 使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物的选择
    public String getHF_6_2_2_C() {  return this.HF_6_2_2_C;}
    @JsonProperty("HF-6-2-2-C")
    public void setHF_6_2_2_C(final String HF_6_2_2_C) { this.HF_6_2_2_C=HF_6_2_2_C;}
    @Column(name = "HF_6_2_2_C_1")
    @JsonProperty("HF-6-2-2-C-1")
    private String HF_6_2_2_C_1; // 其他使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物
    public String getHF_6_2_2_C_1() {  return this.HF_6_2_2_C_1;}
    @JsonProperty("HF-6-2-2-C-1")
    public void setHF_6_2_2_C_1(final String HF_6_2_2_C_1) { this.HF_6_2_2_C_1=HF_6_2_2_C_1;}
    @Column(name = "HF_6_3_1")
    @JsonProperty("HF-6-3-1")
    private String HF_6_3_1; // 是否有β受体阻滞剂药物医嘱
    public String getHF_6_3_1() {  return this.HF_6_3_1;}
    @JsonProperty("HF-6-3-1")
    public void setHF_6_3_1(final String HF_6_3_1) { this.HF_6_3_1=HF_6_3_1;}
    @Column(name = "HF_6_3_2")
    @JsonProperty("HF-6-3-2")
    private String HF_6_3_2; // 使用首剂β-受体阻滞剂药物
    public String getHF_6_3_2() {  return this.HF_6_3_2;}
    @JsonProperty("HF-6-3-2")
    public void setHF_6_3_2(final String HF_6_3_2) { this.HF_6_3_2=HF_6_3_2;}
    @Column(name = "HF_6_3_2_1")
    @JsonProperty("HF-6-3-2-1")
    private String HF_6_3_2_1; // 其他β-受体阻滞剂药物填写
    public String getHF_6_3_2_1() {  return this.HF_6_3_2_1;}
    @JsonProperty("HF-6-3-2-1")
    public void setHF_6_3_2_1(final String HF_6_3_2_1) { this.HF_6_3_2_1=HF_6_3_2_1;}
    @Column(name = "HF_6_4_1")
    @JsonProperty("HF-6-4-1")
    private String HF_6_4_1; // 是否有醛固酮拮抗剂药物医嘱
    public String getHF_6_4_1() {  return this.HF_6_4_1;}
    @JsonProperty("HF-6-4-1")
    public void setHF_6_4_1(final String HF_6_4_1) { this.HF_6_4_1=HF_6_4_1;}
    @Column(name = "HF_6_4_2")
    @JsonProperty("HF-6-4-2")
    private String HF_6_4_2; // 使用醛固酮受体拮抗剂
    public String getHF_6_4_2() {  return this.HF_6_4_2;}
    @JsonProperty("HF-6-4-2")
    public void setHF_6_4_2(final String HF_6_4_2) { this.HF_6_4_2=HF_6_4_2;}
    @Column(name = "HF_6_4_2_1")
    @JsonProperty("HF-6-4-2-1")
    private String HF_6_4_2_1; // 其他醛固酮受体拮抗剂类药物填写
    public String getHF_6_4_2_1() {  return this.HF_6_4_2_1;}
    @JsonProperty("HF-6-4-2-1")
    public void setHF_6_4_2_1(final String HF_6_4_2_1) { this.HF_6_4_2_1=HF_6_4_2_1;}
    @Column(name = "HF_6_5_1")
    @JsonProperty("HF-6-5-1")
    private String HF_6_5_1; // 是否常用抗凝药物
    public String getHF_6_5_1() {  return this.HF_6_5_1;}
    @JsonProperty("HF-6-5-1")
    public void setHF_6_5_1(final String HF_6_5_1) { this.HF_6_5_1=HF_6_5_1;}
    @Column(name = "HF_6_5_2")
    @JsonProperty("HF-6-5-2")
    private String HF_6_5_2; // 选择抗凝药物
    public String getHF_6_5_2() {  return this.HF_6_5_2;}
    @JsonProperty("HF-6-5-2")
    public void setHF_6_5_2(final String HF_6_5_2) { this.HF_6_5_2=HF_6_5_2;}
    @Column(name = "HF_6_5_2_1")
    @JsonProperty("HF-6-5-2-1")
    private String HF_6_5_2_1; // 其他抗凝药物
    public String getHF_6_5_2_1() {  return this.HF_6_5_2_1;}
    @JsonProperty("HF-6-5-2-1")
    public void setHF_6_5_2_1(final String HF_6_5_2_1) { this.HF_6_5_2_1=HF_6_5_2_1;}
    @Column(name = "HF_6_6_1")
    @JsonProperty("HF-6-6-1")
    private String HF_6_6_1; // 是否有用药长期医嘱
    public String getHF_6_6_1() {  return this.HF_6_6_1;}
    @JsonProperty("HF-6-6-1")
    public void setHF_6_6_1(final String HF_6_6_1) { this.HF_6_6_1=HF_6_6_1;}
    @Column(name = "HF_6_6_2")
    @JsonProperty("HF-6-6-2")
    private String HF_6_6_2; // 使用SGLT-2 抑制剂
    public String getHF_6_6_2() {  return this.HF_6_6_2;}
    @JsonProperty("HF-6-6-2")
    public void setHF_6_6_2(final String HF_6_6_2) { this.HF_6_6_2=HF_6_6_2;}
    @Column(name = "HF_6_6_2_1")
    @JsonProperty("HF-6-6-2-1")
    private String HF_6_6_2_1; // 其他SGLT-2 抑制剂药物
    public String getHF_6_6_2_1() {  return this.HF_6_6_2_1;}
    @JsonProperty("HF-6-6-2-1")
    public void setHF_6_6_2_1(final String HF_6_6_2_1) { this.HF_6_6_2_1=HF_6_6_2_1;}
    @Column(name = "HF_7_1_1")
    @JsonProperty("HF-7-1-1")
    private String HF_7_1_1; // 出院带药医嘱中是否有继续使用利尿剂记录医嘱
    public String getHF_7_1_1() {  return this.HF_7_1_1;}
    @JsonProperty("HF-7-1-1")
    public void setHF_7_1_1(final String HF_7_1_1) { this.HF_7_1_1=HF_7_1_1;}
    @Column(name = "HF_7_1_2")
    @JsonProperty("HF-7-1-2")
    private String HF_7_1_2; // 常用利尿剂药物
    public String getHF_7_1_2() {  return this.HF_7_1_2;}
    @JsonProperty("HF-7-1-2")
    public void setHF_7_1_2(final String HF_7_1_2) { this.HF_7_1_2=HF_7_1_2;}
    @Column(name = "HF_7_1_2_1")
    @JsonProperty("HF-7-1-2-1")
    private String HF_7_1_2_1; // 其他常用利尿剂
    public String getHF_7_1_2_1() {  return this.HF_7_1_2_1;}
    @JsonProperty("HF-7-1-2-1")
    public void setHF_7_1_2_1(final String HF_7_1_2_1) { this.HF_7_1_2_1=HF_7_1_2_1;}
    @Column(name = "HF_7_2_1")
    @JsonProperty("HF-7-2-1")
    private String HF_7_2_1; // 出院带药医嘱中是否有继续使用ACEI或ARB药物记录医嘱
    public String getHF_7_2_1() {  return this.HF_7_2_1;}
    @JsonProperty("HF-7-2-1")
    public void setHF_7_2_1(final String HF_7_2_1) { this.HF_7_2_1=HF_7_2_1;}
    @Column(name = "HF_7_2_2")
    @JsonProperty("HF-7-2-2")
    private String HF_7_2_2; // 使用ACEI抑制剂或者ARB或者ARNI类药物选择
    public String getHF_7_2_2() {  return this.HF_7_2_2;}
    @JsonProperty("HF-7-2-2")
    public void setHF_7_2_2(final String HF_7_2_2) { this.HF_7_2_2=HF_7_2_2;}
    @Column(name = "HF_7_2_2_A")
    @JsonProperty("HF-7-2-2-A")
    private String HF_7_2_2_A; // ACE抑制剂药物
    public String getHF_7_2_2_A() {  return this.HF_7_2_2_A;}
    @JsonProperty("HF-7-2-2-A")
    public void setHF_7_2_2_A(final String HF_7_2_2_A) { this.HF_7_2_2_A=HF_7_2_2_A;}
    @Column(name = "HF_7_2_2_A_1")
    @JsonProperty("HF-7-2-2-A-1")
    private String HF_7_2_2_A_1; // 其他ACEI药物
    public String getHF_7_2_2_A_1() {  return this.HF_7_2_2_A_1;}
    @JsonProperty("HF-7-2-2-A-1")
    public void setHF_7_2_2_A_1(final String HF_7_2_2_A_1) { this.HF_7_2_2_A_1=HF_7_2_2_A_1;}
    @Column(name = "HF_7_2_2_B")
    @JsonProperty("HF-7-2-2-B")
    private String HF_7_2_2_B; // ARB类药物
    public String getHF_7_2_2_B() {  return this.HF_7_2_2_B;}
    @JsonProperty("HF-7-2-2-B")
    public void setHF_7_2_2_B(final String HF_7_2_2_B) { this.HF_7_2_2_B=HF_7_2_2_B;}
    @Column(name = "HF_7_2_2_B_1")
    @JsonProperty("HF-7-2-2-B-1")
    private String HF_7_2_2_B_1; // 其他ARB药物填写
    public String getHF_7_2_2_B_1() {  return this.HF_7_2_2_B_1;}
    @JsonProperty("HF-7-2-2-B-1")
    public void setHF_7_2_2_B_1(final String HF_7_2_2_B_1) { this.HF_7_2_2_B_1=HF_7_2_2_B_1;}
    @Column(name = "HF_7_2_2_C")
    @JsonProperty("HF-7-2-2-C")
    private String HF_7_2_2_C; // 使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物的选择
    public String getHF_7_2_2_C() {  return this.HF_7_2_2_C;}
    @JsonProperty("HF-7-2-2-C")
    public void setHF_7_2_2_C(final String HF_7_2_2_C) { this.HF_7_2_2_C=HF_7_2_2_C;}
    @Column(name = "HF_7_2_2_C_1")
    @JsonProperty("HF-7-2-2-C-1")
    private String HF_7_2_2_C_1; // 其他使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物
    public String getHF_7_2_2_C_1() {  return this.HF_7_2_2_C_1;}
    @JsonProperty("HF-7-2-2-C-1")
    public void setHF_7_2_2_C_1(final String HF_7_2_2_C_1) { this.HF_7_2_2_C_1=HF_7_2_2_C_1;}
    @Column(name = "HF_7_3_1")
    @JsonProperty("HF-7-3-1")
    private String HF_7_3_1; // 出院带药医嘱中是否有继续使用β受体阻滞剂药物医嘱
    public String getHF_7_3_1() {  return this.HF_7_3_1;}
    @JsonProperty("HF-7-3-1")
    public void setHF_7_3_1(final String HF_7_3_1) { this.HF_7_3_1=HF_7_3_1;}
    @Column(name = "HF_7_3_2")
    @JsonProperty("HF-7-3-2")
    private String HF_7_3_2; // 使用首剂β-受体阻滞剂药物
    public String getHF_7_3_2() {  return this.HF_7_3_2;}
    @JsonProperty("HF-7-3-2")
    public void setHF_7_3_2(final String HF_7_3_2) { this.HF_7_3_2=HF_7_3_2;}
    @Column(name = "HF_7_3_2_1")
    @JsonProperty("HF-7-3-2-1")
    private String HF_7_3_2_1; // 其他β-受体阻滞剂药物填写
    public String getHF_7_3_2_1() {  return this.HF_7_3_2_1;}
    @JsonProperty("HF-7-3-2-1")
    public void setHF_7_3_2_1(final String HF_7_3_2_1) { this.HF_7_3_2_1=HF_7_3_2_1;}
    @Column(name = "HF_7_4_1")
    @JsonProperty("HF-7-4-1")
    private String HF_7_4_1; // 出院带药医嘱中是否有继续使用醛固酮拮抗剂药物医嘱
    public String getHF_7_4_1() {  return this.HF_7_4_1;}
    @JsonProperty("HF-7-4-1")
    public void setHF_7_4_1(final String HF_7_4_1) { this.HF_7_4_1=HF_7_4_1;}
    @Column(name = "HF_7_4_2")
    @JsonProperty("HF-7-4-2")
    private String HF_7_4_2; // 使用醛固酮受体拮抗剂
    public String getHF_7_4_2() {  return this.HF_7_4_2;}
    @JsonProperty("HF-7-4-2")
    public void setHF_7_4_2(final String HF_7_4_2) { this.HF_7_4_2=HF_7_4_2;}
    @Column(name = "HF_7_4_2_1")
    @JsonProperty("HF-7-4-2-1")
    private String HF_7_4_2_1; // 其他醛固酮受体拮抗剂
    public String getHF_7_4_2_1() {  return this.HF_7_4_2_1;}
    @JsonProperty("HF-7-4-2-1")
    public void setHF_7_4_2_1(final String HF_7_4_2_1) { this.HF_7_4_2_1=HF_7_4_2_1;}
    @Column(name = "HF_7_5_1")
    @JsonProperty("HF-7-5-1")
    private String HF_7_5_1; // 出院带药医嘱中是否有继续使用使用抗凝药物医嘱
    public String getHF_7_5_1() {  return this.HF_7_5_1;}
    @JsonProperty("HF-7-5-1")
    public void setHF_7_5_1(final String HF_7_5_1) { this.HF_7_5_1=HF_7_5_1;}
    @Column(name = "HF_7_5_2")
    @JsonProperty("HF-7-5-2")
    private String HF_7_5_2; // 选择抗凝药物
    public String getHF_7_5_2() {  return this.HF_7_5_2;}
    @JsonProperty("HF-7-5-2")
    public void setHF_7_5_2(final String HF_7_5_2) { this.HF_7_5_2=HF_7_5_2;}
    @Column(name = "HF_7_5_2_1")
    @JsonProperty("HF-7-5-2-1")
    private String HF_7_5_2_1; // 其他抗凝药物
    public String getHF_7_5_2_1() {  return this.HF_7_5_2_1;}
    @JsonProperty("HF-7-5-2-1")
    public void setHF_7_5_2_1(final String HF_7_5_2_1) { this.HF_7_5_2_1=HF_7_5_2_1;}
    @Column(name = "HF_7_6_1")
    @JsonProperty("HF-7-6-1")
    private String HF_7_6_1; // 出院带药医嘱中是否有继续使用使用SGLT-2 抑制剂
    public String getHF_7_6_1() {  return this.HF_7_6_1;}
    @JsonProperty("HF-7-6-1")
    public void setHF_7_6_1(final String HF_7_6_1) { this.HF_7_6_1=HF_7_6_1;}
    @Column(name = "HF_7_6_2")
    @JsonProperty("HF-7-6-2")
    private String HF_7_6_2; // 使用SGLT-2 抑制剂
    public String getHF_7_6_2() {  return this.HF_7_6_2;}
    @JsonProperty("HF-7-6-2")
    public void setHF_7_6_2(final String HF_7_6_2) { this.HF_7_6_2=HF_7_6_2;}
    @Column(name = "HF_7_6_2_1")
    @JsonProperty("HF-7-6-2-1")
    private String HF_7_6_2_1; // 其他SGLT-2 抑制剂药物
    public String getHF_7_6_2_1() {  return this.HF_7_6_2_1;}
    @JsonProperty("HF-7-6-2-1")
    public void setHF_7_6_2_1(final String HF_7_6_2_1) { this.HF_7_6_2_1=HF_7_6_2_1;}
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
    @Column(name = "HF_8_1_1")
    @JsonProperty("HF-8-1-1")
    private String HF_8_1_1; // 是否有吸烟史
    public String getHF_8_1_1() {  return this.HF_8_1_1;}
    @JsonProperty("HF-8-1-1")
    public void setHF_8_1_1(final String HF_8_1_1) { this.HF_8_1_1=HF_8_1_1;}
    @Column(name = "HF_8_1_2")
    @JsonProperty("HF-8-1-2")
    private String HF_8_1_2; // 吸烟程度评估有记录
    public String getHF_8_1_2() {  return this.HF_8_1_2;}
    @JsonProperty("HF-8-1-2")
    public void setHF_8_1_2(final String HF_8_1_2) { this.HF_8_1_2=HF_8_1_2;}
    @Column(name = "HF_8_1_3")
    @JsonProperty("HF-8-1-3")
    private String HF_8_1_3; // 接受戒烟的建议或者戒烟治疗有记录
    public String getHF_8_1_3() {  return this.HF_8_1_3;}
    @JsonProperty("HF-8-1-3")
    public void setHF_8_1_3(final String HF_8_1_3) { this.HF_8_1_3=HF_8_1_3;}
    @Column(name = "HF_8_2_1_A")
    @JsonProperty("HF-8-2-1-A")
    private String HF_8_2_1_A; // 心衰原发疾病评估与教育
    public String getHF_8_2_1_A() {  return this.HF_8_2_1_A;}
    @JsonProperty("HF-8-2-1-A")
    public void setHF_8_2_1_A(final String HF_8_2_1_A) { this.HF_8_2_1_A=HF_8_2_1_A;}
    @Column(name = "HF_8_2_1_3")
    @JsonProperty("HF-8-2-1-3")
    private String HF_8_2_1_3; // 心衰原发其他疾病
    public String getHF_8_2_1_3() {  return this.HF_8_2_1_3;}
    @JsonProperty("HF-8-2-1-3")
    public void setHF_8_2_1_3(final String HF_8_2_1_3) { this.HF_8_2_1_3=HF_8_2_1_3;}
    @Column(name = "HF_8_2_1_B")
    @JsonProperty("HF-8-2-1-B")
    private String HF_8_2_1_B; // 实施控制主要危险因素评估与教育
    public String getHF_8_2_1_B() {  return this.HF_8_2_1_B;}
    @JsonProperty("HF-8-2-1-B")
    public void setHF_8_2_1_B(final String HF_8_2_1_B) { this.HF_8_2_1_B=HF_8_2_1_B;}
    @Column(name = "HF_8_2_2")
    @JsonProperty("HF-8-2-2")
    private String HF_8_2_2; // 对控制危险因素评估的结果进行针对性的教育
    public String getHF_8_2_2() {  return this.HF_8_2_2;}
    @JsonProperty("HF-8-2-2")
    public void setHF_8_2_2(final String HF_8_2_2) { this.HF_8_2_2=HF_8_2_2;}
    @Column(name = "HF_8_3")
    @JsonProperty("HF-8-3")
    private String HF_8_3; // 二级预防
    public String getHF_8_3() {  return this.HF_8_3;}
    @JsonProperty("HF-8-3")
    public void setHF_8_3(final String HF_8_3) { this.HF_8_3=HF_8_3;}
    @Column(name = "HF_8_4_1")
    @JsonProperty("HF-8-4-1")
    private String HF_8_4_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    public String getHF_8_4_1() {  return this.HF_8_4_1;}
    @JsonProperty("HF-8-4-1")
    public void setHF_8_4_1(final String HF_8_4_1) { this.HF_8_4_1=HF_8_4_1;}
    @Column(name = "HF_8_4_2")
    @JsonProperty("HF-8-4-2")
    private String HF_8_4_2; // 出院带药
    public String getHF_8_4_2() {  return this.HF_8_4_2;}
    @JsonProperty("HF-8-4-2")
    public void setHF_8_4_2(final String HF_8_4_2) { this.HF_8_4_2=HF_8_4_2;}
    @Column(name = "HF_8_4_3")
    @JsonProperty("HF-8-4-3")
    private String HF_8_4_3; // 告知发生紧急情况时求援救治途径
    public String getHF_8_4_3() {  return this.HF_8_4_3;}
    @JsonProperty("HF-8-4-3")
    public void setHF_8_4_3(final String HF_8_4_3) { this.HF_8_4_3=HF_8_4_3;}
    @Column(name = "HF_8_4_4")
    @JsonProperty("HF-8-4-4")
    private String HF_8_4_4; // 出院时教育与随访
    public String getHF_8_4_4() {  return this.HF_8_4_4;}
    @JsonProperty("HF-8-4-4")
    public void setHF_8_4_4(final String HF_8_4_4) { this.HF_8_4_4=HF_8_4_4;}
    @Column(name = "HF_8_4_5")
    @JsonProperty("HF-8-4-5")
    private String HF_8_4_5; // 告知何为风险因素与紧急情况
    public String getHF_8_4_5() {  return this.HF_8_4_5;}
    @JsonProperty("HF-8-4-5")
    public void setHF_8_4_5(final String HF_8_4_5) { this.HF_8_4_5=HF_8_4_5;}
    @Column(name = "HF_9_2_1_1")
    @JsonProperty("HF-9-2-1-1")
    private String HF_9_2_1_1; // 实施末次X线胸片检查
    public String getHF_9_2_1_1() {  return this.HF_9_2_1_1;}
    @JsonProperty("HF-9-2-1-1")
    public void setHF_9_2_1_1(final String HF_9_2_1_1) { this.HF_9_2_1_1=HF_9_2_1_1;}
    @Column(name = "HF_9_2_1_2")
    @JsonProperty("HF-9-2-1-2")
    private String HF_9_2_1_2; // 是否有肺淤血或肺水肿
    public String getHF_9_2_1_2() {  return this.HF_9_2_1_2;}
    @JsonProperty("HF-9-2-1-2")
    public void setHF_9_2_1_2(final String HF_9_2_1_2) { this.HF_9_2_1_2=HF_9_2_1_2;}
    @Column(name = "HF_9_2_2_1")
    @JsonProperty("HF-9-2-2-1")
    private String HF_9_2_2_1; // 是否实施末次超声心动图(CDFA)检查
    public String getHF_9_2_2_1() {  return this.HF_9_2_2_1;}
    @JsonProperty("HF-9-2-2-1")
    public void setHF_9_2_2_1(final String HF_9_2_2_1) { this.HF_9_2_2_1=HF_9_2_2_1;}
    @Column(name = "HF_9_2_2_2_4")
    @JsonProperty("HF-9-2-2-2-4")
    private String HF_9_2_2_2_4; // QRS宽度(ms)
    public String getHF_9_2_2_2_4() {  return this.HF_9_2_2_2_4;}
    @JsonProperty("HF-9-2-2-2-4")
    public void setHF_9_2_2_2_4(final String HF_9_2_2_2_4) { this.HF_9_2_2_2_4=HF_9_2_2_2_4;}
    @Column(name = "HF_9_2_2_2_1")
    @JsonProperty("HF-9-2-2-2-1")
    private String HF_9_2_2_2_1; // 左室射血分（LVEF）测量值(%)
    public String getHF_9_2_2_2_1() {  return this.HF_9_2_2_2_1;}
    @JsonProperty("HF-9-2-2-2-1")
    public void setHF_9_2_2_2_1(final String HF_9_2_2_2_1) { this.HF_9_2_2_2_1=HF_9_2_2_2_1;}
    @Column(name = "HF_9_2_2_2_2")
    @JsonProperty("HF-9-2-2-2-2")
    private String HF_9_2_2_2_2; // 左室射血分数评估结论
    public String getHF_9_2_2_2_2() {  return this.HF_9_2_2_2_2;}
    @JsonProperty("HF-9-2-2-2-2")
    public void setHF_9_2_2_2_2(final String HF_9_2_2_2_2) { this.HF_9_2_2_2_2=HF_9_2_2_2_2;}
    @Column(name = "HF_9_2_2_2_3")
    @JsonProperty("HF-9-2-2-2-3")
    private String HF_9_2_2_2_3; // 是否有左心室室壁瘤
    public String getHF_9_2_2_2_3() {  return this.HF_9_2_2_2_3;}
    @JsonProperty("HF-9-2-2-2-3")
    public void setHF_9_2_2_2_3(final String HF_9_2_2_2_3) { this.HF_9_2_2_2_3=HF_9_2_2_2_3;}
    @Column(name = "HF_9_2_3_1")
    @JsonProperty("HF-9-2-3-1")
    private String HF_9_2_3_1; // 是否实施末次风险程度评估
    public String getHF_9_2_3_1() {  return this.HF_9_2_3_1;}
    @JsonProperty("HF-9-2-3-1")
    public void setHF_9_2_3_1(final String HF_9_2_3_1) { this.HF_9_2_3_1=HF_9_2_3_1;}
    @Column(name = "HF_9_2_3_2_AB")
    @JsonProperty("HF-9-2-3-2-AB")
    private String HF_9_2_3_2_AB; // 末次风险程度评估
    public String getHF_9_2_3_2_AB() {  return this.HF_9_2_3_2_AB;}
    @JsonProperty("HF-9-2-3-2-AB")
    public void setHF_9_2_3_2_AB(final String HF_9_2_3_2_AB) { this.HF_9_2_3_2_AB=HF_9_2_3_2_AB;}
    @Column(name = "HF_9_2_3_2")
    @JsonProperty("HF-9-2-3-2")
    private String HF_9_2_3_2; // NYHA分级结果
    public String getHF_9_2_3_2() {  return this.HF_9_2_3_2;}
    @JsonProperty("HF-9-2-3-2")
    public void setHF_9_2_3_2(final String HF_9_2_3_2) { this.HF_9_2_3_2=HF_9_2_3_2;}
    @Column(name = "HF_9_2_3_3")
    @JsonProperty("HF-9-2-3-3")
    private String HF_9_2_3_3; // Killip分级评估结果
    public String getHF_9_2_3_3() {  return this.HF_9_2_3_3;}
    @JsonProperty("HF-9-2-3-3")
    public void setHF_9_2_3_3(final String HF_9_2_3_3) { this.HF_9_2_3_3=HF_9_2_3_3;}
    @Column(name = "HF_9_2_4_1")
    @JsonProperty("HF-9-2-4-1")
    private String HF_9_2_4_1; // 是否实施末次检测
    public String getHF_9_2_4_1() {  return this.HF_9_2_4_1;}
    @JsonProperty("HF-9-2-4-1")
    public void setHF_9_2_4_1(final String HF_9_2_4_1) { this.HF_9_2_4_1=HF_9_2_4_1;}
    @Column(name = "HF_9_2_4_2")
    @JsonProperty("HF-9-2-4-2")
    private String HF_9_2_4_2; // 末次检测选择
    public String getHF_9_2_4_2() {  return this.HF_9_2_4_2;}
    @JsonProperty("HF-9-2-4-2")
    public void setHF_9_2_4_2(final String HF_9_2_4_2) { this.HF_9_2_4_2=HF_9_2_4_2;}
    @Column(name = "HF_9_2_4_2_1")
    @JsonProperty("HF-9-2-4-2-1")
    private String HF_9_2_4_2_1; // 肌钙蛋白T（TnT）检测值(ng/mL)
    public String getHF_9_2_4_2_1() {  return this.HF_9_2_4_2_1;}
    @JsonProperty("HF-9-2-4-2-1")
    public void setHF_9_2_4_2_1(final String HF_9_2_4_2_1) { this.HF_9_2_4_2_1=HF_9_2_4_2_1;}
    @Column(name = "HF_9_2_4_2_2")
    @JsonProperty("HF-9-2-4-2-2")
    private String HF_9_2_4_2_2; // 肌钙蛋白I（TnI）检测值(ng/mL)
    public String getHF_9_2_4_2_2() {  return this.HF_9_2_4_2_2;}
    @JsonProperty("HF-9-2-4-2-2")
    public void setHF_9_2_4_2_2(final String HF_9_2_4_2_2) { this.HF_9_2_4_2_2=HF_9_2_4_2_2;}
    @Column(name = "HF_9_2_4_2_3")
    @JsonProperty("HF-9-2-4-2-3")
    private String HF_9_2_4_2_3; // 肌酸激酶同工酶（CK-MB）检测值(ng/mL)
    public String getHF_9_2_4_2_3() {  return this.HF_9_2_4_2_3;}
    @JsonProperty("HF-9-2-4-2-3")
    public void setHF_9_2_4_2_3(final String HF_9_2_4_2_3) { this.HF_9_2_4_2_3=HF_9_2_4_2_3;}
    @Column(name = "HF_9_2_4_2_4")
    @JsonProperty("HF-9-2-4-2-4")
    private String HF_9_2_4_2_4; // 心肌肌红蛋白（Myo）检测值(ng/mL)
    public String getHF_9_2_4_2_4() {  return this.HF_9_2_4_2_4;}
    @JsonProperty("HF-9-2-4-2-4")
    public void setHF_9_2_4_2_4(final String HF_9_2_4_2_4) { this.HF_9_2_4_2_4=HF_9_2_4_2_4;}
    @Column(name = "HF_9_2_4_2_5")
    @JsonProperty("HF-9-2-4-2-5")
    private String HF_9_2_4_2_5; // B型钠尿肽（BNP）检测值(ng/L)
    public String getHF_9_2_4_2_5() {  return this.HF_9_2_4_2_5;}
    @JsonProperty("HF-9-2-4-2-5")
    public void setHF_9_2_4_2_5(final String HF_9_2_4_2_5) { this.HF_9_2_4_2_5=HF_9_2_4_2_5;}
    @Column(name = "HF_9_2_4_2_6")
    @JsonProperty("HF-9-2-4-2-6")
    private String HF_9_2_4_2_6; // N端B型钠尿肽前体（NT-ProBNP）检测值(ng/L)
    public String getHF_9_2_4_2_6() {  return this.HF_9_2_4_2_6;}
    @JsonProperty("HF-9-2-4-2-6")
    public void setHF_9_2_4_2_6(final String HF_9_2_4_2_6) { this.HF_9_2_4_2_6=HF_9_2_4_2_6;}
    @Column(name = "HF_9_2_4_2_7")
    @JsonProperty("HF-9-2-4-2-7")
    private String HF_9_2_4_2_7; // 血肌酐 检测值(umol/L)
    public String getHF_9_2_4_2_7() {  return this.HF_9_2_4_2_7;}
    @JsonProperty("HF-9-2-4-2-7")
    public void setHF_9_2_4_2_7(final String HF_9_2_4_2_7) { this.HF_9_2_4_2_7=HF_9_2_4_2_7;}
    @Column(name = "HF_9_2_4_2_8")
    @JsonProperty("HF-9-2-4-2-8")
    private String HF_9_2_4_2_8; // 血钾 检测值(mmol/L)
    public String getHF_9_2_4_2_8() {  return this.HF_9_2_4_2_8;}
    @JsonProperty("HF-9-2-4-2-8")
    public void setHF_9_2_4_2_8(final String HF_9_2_4_2_8) { this.HF_9_2_4_2_8=HF_9_2_4_2_8;}
    @Column(name = "HF_9_5_1")
    @JsonProperty("HF-9-5-1")
    private String HF_9_5_1; // 是否实施末次心电图（ECG）检查
    public String getHF_9_5_1() {  return this.HF_9_5_1;}
    @JsonProperty("HF-9-5-1")
    public void setHF_9_5_1(final String HF_9_5_1) { this.HF_9_5_1=HF_9_5_1;}
    @Column(name = "HF_9_5_2")
    @JsonProperty("HF-9-5-2")
    private String HF_9_5_2; // QRS宽度(ms)
    public String getHF_9_5_2() {  return this.HF_9_5_2;}
    @JsonProperty("HF-9-5-2")
    public void setHF_9_5_2(final String HF_9_5_2) { this.HF_9_5_2=HF_9_5_2;}
    @Column(name = "HF_9_5_3")
    @JsonProperty("HF-9-5-3")
    private String HF_9_5_3; // 心电图（ECG）检查结果选择
    public String getHF_9_5_3() {  return this.HF_9_5_3;}
    @JsonProperty("HF-9-5-3")
    public void setHF_9_5_3(final String HF_9_5_3) { this.HF_9_5_3=HF_9_5_3;}
    @Column(name = "HF_9_5_3_1")
    @JsonProperty("HF-9-5-3-1")
    private String HF_9_5_3_1; // 其他心电图（ECG）检查结果
    public String getHF_9_5_3_1() {  return this.HF_9_5_3_1;}
    @JsonProperty("HF-9-5-3-1")
    public void setHF_9_5_3_1(final String HF_9_5_3_1) { this.HF_9_5_3_1=HF_9_5_3_1;}
    @Column(name = "HF_9_5_4_1")
    @JsonProperty("HF-9-5-4-1")
    private String HF_9_5_4_1; // 收缩压(mmHg)
    public String getHF_9_5_4_1() {  return this.HF_9_5_4_1;}
    @JsonProperty("HF-9-5-4-1")
    public void setHF_9_5_4_1(final String HF_9_5_4_1) { this.HF_9_5_4_1=HF_9_5_4_1;}
    @Column(name = "HF_9_5_4_2")
    @JsonProperty("HF-9-5-4-2")
    private String HF_9_5_4_2; // 舒张压(mmHg)
    public String getHF_9_5_4_2() {  return this.HF_9_5_4_2;}
    @JsonProperty("HF-9-5-4-2")
    public void setHF_9_5_4_2(final String HF_9_5_4_2) { this.HF_9_5_4_2=HF_9_5_4_2;}
    @Column(name = "HF_9_5_4_3")
    @JsonProperty("HF-9-5-4-3")
    private String HF_9_5_4_3; // 心率(次/分)
    public String getHF_9_5_4_3() {  return this.HF_9_5_4_3;}
    @JsonProperty("HF-9-5-4-3")
    public void setHF_9_5_4_3(final String HF_9_5_4_3) { this.HF_9_5_4_3=HF_9_5_4_3;}
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
    @Column(name = "HF_11_4_2")
    @JsonProperty("HF-11-4-2")
    private String HF_11_4_2; // 是否有在药物优化治疗超过3个月后实施CRT的记录
    public String getHF_11_4_2() {  return this.HF_11_4_2;}
    @JsonProperty("HF-11-4-2")
    public void setHF_11_4_2(final String HF_11_4_2) { this.HF_11_4_2=HF_11_4_2;}
    @Column(name = "HF_11_4_3")
    @JsonProperty("HF-11-4-3")
    private String HF_11_4_3; // CRT临床应用指南推荐意见的选择
    public String getHF_11_4_3() {  return this.HF_11_4_3;}
    @JsonProperty("HF-11-4-3")
    public void setHF_11_4_3(final String HF_11_4_3) { this.HF_11_4_3=HF_11_4_3;}
    @Column(name = "HF_11_1_2")
    @JsonProperty("HF-11-1-2")
    private String HF_11_1_2; // 安装心脏再同步治疗（CRT）装置
    public String getHF_11_1_2() {  return this.HF_11_1_2;}
    @JsonProperty("HF-11-1-2")
    public void setHF_11_1_2(final String HF_11_1_2) { this.HF_11_1_2=HF_11_1_2;}
    @Column(name = "HF_11_1_3")
    @JsonProperty("HF-11-1-3")
    private String HF_11_1_3; // 安装日期时间
    public String getHF_11_1_3() {  return this.HF_11_1_3;}
    @JsonProperty("HF-11-1-3")
    public void setHF_11_1_3(final String HF_11_1_3) { this.HF_11_1_3=HF_11_1_3;}
    @Column(name = "HF_11_1_4_1")
    @JsonProperty("HF-11-1-4-1")
    private String HF_11_1_4_1; // 心脏再同步治疗（CRT）装置生产企业
    public String getHF_11_1_4_1() {  return this.HF_11_1_4_1;}
    @JsonProperty("HF-11-1-4-1")
    public void setHF_11_1_4_1(final String HF_11_1_4_1) { this.HF_11_1_4_1=HF_11_1_4_1;}
    @Column(name = "HF_11_1_4_2")
    @JsonProperty("HF-11-1-4-2")
    private String HF_11_1_4_2; // 心脏再同步治疗（CRT）装置型号
    public String getHF_11_1_4_2() {  return this.HF_11_1_4_2;}
    @JsonProperty("HF-11-1-4-2")
    public void setHF_11_1_4_2(final String HF_11_1_4_2) { this.HF_11_1_4_2=HF_11_1_4_2;}
    @Column(name = "HF_11_1_4_3")
    @JsonProperty("HF-11-1-4-3")
    private String HF_11_1_4_3; // 心脏再同步治疗（CRT）装置的费用(元)<br/>(注：仅为患者支付CRT装置的费用)
    public String getHF_11_1_4_3() {  return this.HF_11_1_4_3;}
    @JsonProperty("HF-11-1-4-3")
    public void setHF_11_1_4_3(final String HF_11_1_4_3) { this.HF_11_1_4_3=HF_11_1_4_3;}
    @Column(name = "HF_11_5_1")
    @JsonProperty("HF-11-5-1")
    private String HF_11_5_1; // 是否有在药物优化治疗超过3个月后实施埋藏式心律转复除颤器（ICD）的记录
    public String getHF_11_5_1() {  return this.HF_11_5_1;}
    @JsonProperty("HF-11-5-1")
    public void setHF_11_5_1(final String HF_11_5_1) { this.HF_11_5_1=HF_11_5_1;}
    @Column(name = "HF_11_5_2")
    @JsonProperty("HF-11-5-2")
    private String HF_11_5_2; // 心衰患者植入ICD适应证
    public String getHF_11_5_2() {  return this.HF_11_5_2;}
    @JsonProperty("HF-11-5-2")
    public void setHF_11_5_2(final String HF_11_5_2) { this.HF_11_5_2=HF_11_5_2;}
    @Column(name = "HF_11_5_4")
    @JsonProperty("HF-11-5-4")
    private String HF_11_5_4; // 二级预防适应证
    public String getHF_11_5_4() {  return this.HF_11_5_4;}
    @JsonProperty("HF-11-5-4")
    public void setHF_11_5_4(final String HF_11_5_4) { this.HF_11_5_4=HF_11_5_4;}
    @Column(name = "HF_11_5_3")
    @JsonProperty("HF-11-5-3")
    private String HF_11_5_3; // 一级预防适应证
    public String getHF_11_5_3() {  return this.HF_11_5_3;}
    @JsonProperty("HF-11-5-3")
    public void setHF_11_5_3(final String HF_11_5_3) { this.HF_11_5_3=HF_11_5_3;}
    @Column(name = "HF_11_5_3_1")
    @JsonProperty("HF-11-5-3-1")
    private String HF_11_5_3_1; // 缺血性心脏病患者
    public String getHF_11_5_3_1() {  return this.HF_11_5_3_1;}
    @JsonProperty("HF-11-5-3-1")
    public void setHF_11_5_3_1(final String HF_11_5_3_1) { this.HF_11_5_3_1=HF_11_5_3_1;}
    @Column(name = "HF_11_5_3_2")
    @JsonProperty("HF-11-5-3-2")
    private String HF_11_5_3_2; // 非缺血性心衰患者
    public String getHF_11_5_3_2() {  return this.HF_11_5_3_2;}
    @JsonProperty("HF-11-5-3-2")
    public void setHF_11_5_3_2(final String HF_11_5_3_2) { this.HF_11_5_3_2=HF_11_5_3_2;}
    @Column(name = "HF_11_2_2")
    @JsonProperty("HF-11-2-2")
    private String HF_11_2_2; // 是否安装埋藏式心律转复除颤器（ICD）装置
    public String getHF_11_2_2() {  return this.HF_11_2_2;}
    @JsonProperty("HF-11-2-2")
    public void setHF_11_2_2(final String HF_11_2_2) { this.HF_11_2_2=HF_11_2_2;}
    @Column(name = "HF_11_2_3")
    @JsonProperty("HF-11-2-3")
    private String HF_11_2_3; // 安装日期时间
    public String getHF_11_2_3() {  return this.HF_11_2_3;}
    @JsonProperty("HF-11-2-3")
    public void setHF_11_2_3(final String HF_11_2_3) { this.HF_11_2_3=HF_11_2_3;}
    @Column(name = "HF_11_2_4_1")
    @JsonProperty("HF-11-2-4-1")
    private String HF_11_2_4_1; // 埋藏式心律转复除颤器（ICD）装置生产企业
    public String getHF_11_2_4_1() {  return this.HF_11_2_4_1;}
    @JsonProperty("HF-11-2-4-1")
    public void setHF_11_2_4_1(final String HF_11_2_4_1) { this.HF_11_2_4_1=HF_11_2_4_1;}
    @Column(name = "HF_11_2_4_2")
    @JsonProperty("HF-11-2-4-2")
    private String HF_11_2_4_2; // 埋藏式心律转复除颤器（ICD）装置型号
    public String getHF_11_2_4_2() {  return this.HF_11_2_4_2;}
    @JsonProperty("HF-11-2-4-2")
    public void setHF_11_2_4_2(final String HF_11_2_4_2) { this.HF_11_2_4_2=HF_11_2_4_2;}
    @Column(name = "HF_11_2_5")
    @JsonProperty("HF-11-2-5")
    private String HF_11_2_5; // 埋藏式心律转复除颤器（ICD）装置的费用(元)<br/>(注:仅为患者支付ICD装置的费用)
    public String getHF_11_2_5() {  return this.HF_11_2_5;}
    @JsonProperty("HF-11-2-5")
    public void setHF_11_2_5(final String HF_11_2_5) { this.HF_11_2_5=HF_11_2_5;}
    @Column(name = "HF_11_3_1")
    @JsonProperty("HF-11-3-1")
    private String HF_11_3_1; // 通过优化流程实现从医院到社区的无缝衔接
    public String getHF_11_3_1() {  return this.HF_11_3_1;}
    @JsonProperty("HF-11-3-1")
    public void setHF_11_3_1(final String HF_11_3_1) { this.HF_11_3_1=HF_11_3_1;}
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