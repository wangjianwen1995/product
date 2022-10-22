package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断及其他诊断ICD-10编码：I26.9的出院患者。
*/
@ApiModel(value = "52信息")
@Entity
@Table(name = "sd_info_APTE")
public class SdInfoAPTE implements Serializable {
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
    private String CM_0_1_3_1; // 主要及其他诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要及其他诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "APTE_0_1_5")
    @JsonProperty("APTE-0-1-5")
    private String APTE_0_1_5; // 急诊肺栓塞诊断类别
    public String getAPTE_0_1_5() {  return this.APTE_0_1_5;}
    @JsonProperty("APTE-0-1-5")
    public void setAPTE_0_1_5(final String APTE_0_1_5) { this.APTE_0_1_5=APTE_0_1_5;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为急性肺血栓栓塞症出院后31天内重复住院
    public String getCM_0_1_5() {  return this.CM_0_1_5;}
    @JsonProperty("CM-0-1-5")
    public void setCM_0_1_5(final String CM_0_1_5) { this.CM_0_1_5=CM_0_1_5;}
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM-0-2-1-1")
    private String CM_0_2_1_1; // 出生日期
    public String getCM_0_2_1_1() {  return this.CM_0_2_1_1;}
    @JsonProperty("CM-0-2-1-1")
    public void setCM_0_2_1_1(final String CM_0_2_1_1) { this.CM_0_2_1_1=CM_0_2_1_1;}
    @Column(name = "age")
    @JsonProperty("age")
    private String age; // 年龄
    public String getage() {  return this.age;}
    @JsonProperty("age")
    public void setage(final String age) { this.age=age;}
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
    @Column(name = "CM_0_2_4_2")
    @JsonProperty("CM-0-2-4-2")
    private String CM_0_2_4_2; // 出院日期时间
    public String getCM_0_2_4_2() {  return this.CM_0_2_4_2;}
    @JsonProperty("CM-0-2-4-2")
    public void setCM_0_2_4_2(final String CM_0_2_4_2) { this.CM_0_2_4_2=CM_0_2_4_2;}
    @Column(name = "CM_0_2_5_1")
    @JsonProperty("CM-0-2-5-1")
    private String CM_0_2_5_1; // 入住RCU/ICU日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开RCU/ICU日期时间
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
    @Column(name = "APTE_1_1_1")
    @JsonProperty("APTE-1-1-1")
    private String APTE_1_1_1; // 入院时相关检测
    public String getAPTE_1_1_1() {  return this.APTE_1_1_1;}
    @JsonProperty("APTE-1-1-1")
    public void setAPTE_1_1_1(final String APTE_1_1_1) { this.APTE_1_1_1=APTE_1_1_1;}
    @Column(name = "APTE_1_1_1_1")
    @JsonProperty("APTE-1-1-1-1")
    private String APTE_1_1_1_1; // 收缩压(mmHg)
    public String getAPTE_1_1_1_1() {  return this.APTE_1_1_1_1;}
    @JsonProperty("APTE-1-1-1-1")
    public void setAPTE_1_1_1_1(final String APTE_1_1_1_1) { this.APTE_1_1_1_1=APTE_1_1_1_1;}
    @Column(name = "APTE_1_1_1_3")
    @JsonProperty("APTE-1-1-1-3")
    private String APTE_1_1_1_3; // 心率(次/分)
    public String getAPTE_1_1_1_3() {  return this.APTE_1_1_1_3;}
    @JsonProperty("APTE-1-1-1-3")
    public void setAPTE_1_1_1_3(final String APTE_1_1_1_3) { this.APTE_1_1_1_3=APTE_1_1_1_3;}
    @Column(name = "APTE_1_1_1_2")
    @JsonProperty("APTE-1-1-1-2")
    private String APTE_1_1_1_2; // 舒张压(mmHg)
    public String getAPTE_1_1_1_2() {  return this.APTE_1_1_1_2;}
    @JsonProperty("APTE-1-1-1-2")
    public void setAPTE_1_1_1_2(final String APTE_1_1_1_2) { this.APTE_1_1_1_2=APTE_1_1_1_2;}
    @Column(name = "APTE_1_1_1_4")
    @JsonProperty("APTE-1-1-1-4")
    private String APTE_1_1_1_4; // 呼吸频率(次/分)
    public String getAPTE_1_1_1_4() {  return this.APTE_1_1_1_4;}
    @JsonProperty("APTE-1-1-1-4")
    public void setAPTE_1_1_1_4(final String APTE_1_1_1_4) { this.APTE_1_1_1_4=APTE_1_1_1_4;}
    @Column(name = "APTE_1_1_1_5")
    @JsonProperty("APTE-1-1-1-5")
    private String APTE_1_1_1_5; // 体温(℃)
    public String getAPTE_1_1_1_5() {  return this.APTE_1_1_1_5;}
    @JsonProperty("APTE-1-1-1-5")
    public void setAPTE_1_1_1_5(final String APTE_1_1_1_5) { this.APTE_1_1_1_5=APTE_1_1_1_5;}
    @Column(name = "APTE_1_1_1_6")
    @JsonProperty("APTE-1-1-1-6")
    private String APTE_1_1_1_6; // 氧气饱和度(%)
    public String getAPTE_1_1_1_6() {  return this.APTE_1_1_1_6;}
    @JsonProperty("APTE-1-1-1-6")
    public void setAPTE_1_1_1_6(final String APTE_1_1_1_6) { this.APTE_1_1_1_6=APTE_1_1_1_6;}
    @Column(name = "APTE_1_1_2")
    @JsonProperty("APTE-1-1-2")
    private String APTE_1_1_2; // 是否行临床可能性评分（简化的Wells评分、修订的Geneva评分量表）
    public String getAPTE_1_1_2() {  return this.APTE_1_1_2;}
    @JsonProperty("APTE-1-1-2")
    public void setAPTE_1_1_2(final String APTE_1_1_2) { this.APTE_1_1_2=APTE_1_1_2;}
    @Column(name = "APTE_1_1_2_1")
    @JsonProperty("APTE-1-1-2-1")
    private String APTE_1_1_2_1; // 简化的Wells评估分值
    public String getAPTE_1_1_2_1() {  return this.APTE_1_1_2_1;}
    @JsonProperty("APTE-1-1-2-1")
    public void setAPTE_1_1_2_1(final String APTE_1_1_2_1) { this.APTE_1_1_2_1=APTE_1_1_2_1;}
    @Column(name = "APTE_1_1_2_2")
    @JsonProperty("APTE-1-1-2-2")
    private String APTE_1_1_2_2; // APTE临床可能性
    public String getAPTE_1_1_2_2() {  return this.APTE_1_1_2_2;}
    @JsonProperty("APTE-1-1-2-2")
    public void setAPTE_1_1_2_2(final String APTE_1_1_2_2) { this.APTE_1_1_2_2=APTE_1_1_2_2;}
    @Column(name = "APTE_1_1_2_3")
    @JsonProperty("APTE-1-1-2-3")
    private String APTE_1_1_2_3; // 修订的Geneva评估分值
    public String getAPTE_1_1_2_3() {  return this.APTE_1_1_2_3;}
    @JsonProperty("APTE-1-1-2-3")
    public void setAPTE_1_1_2_3(final String APTE_1_1_2_3) { this.APTE_1_1_2_3=APTE_1_1_2_3;}
    @Column(name = "APTE_1_1_2_4")
    @JsonProperty("APTE-1-1-2-4")
    private String APTE_1_1_2_4; // APTE临床可能性
    public String getAPTE_1_1_2_4() {  return this.APTE_1_1_2_4;}
    @JsonProperty("APTE-1-1-2-4")
    public void setAPTE_1_1_2_4(final String APTE_1_1_2_4) { this.APTE_1_1_2_4=APTE_1_1_2_4;}
    @Column(name = "APTE_1_1_2_5")
    @JsonProperty("APTE-1-1-2-5")
    private String APTE_1_1_2_5; // 评估日期时间
    public String getAPTE_1_1_2_5() {  return this.APTE_1_1_2_5;}
    @JsonProperty("APTE-1-1-2-5")
    public void setAPTE_1_1_2_5(final String APTE_1_1_2_5) { this.APTE_1_1_2_5=APTE_1_1_2_5;}
    @Column(name = "APTE_1_2_1")
    @JsonProperty("APTE-1-2-1")
    private String APTE_1_2_1; // 是否实施D⁃二聚体检测评估
    public String getAPTE_1_2_1() {  return this.APTE_1_2_1;}
    @JsonProperty("APTE-1-2-1")
    public void setAPTE_1_2_1(final String APTE_1_2_1) { this.APTE_1_2_1=APTE_1_2_1;}
    @Column(name = "APTE_1_2_2_1")
    @JsonProperty("APTE-1-2-2-1")
    private String APTE_1_2_2_1; // D⁃二聚体检测值单位
    public String getAPTE_1_2_2_1() {  return this.APTE_1_2_2_1;}
    @JsonProperty("APTE-1-2-2-1")
    public void setAPTE_1_2_2_1(final String APTE_1_2_2_1) { this.APTE_1_2_2_1=APTE_1_2_2_1;}
    @Column(name = "APTE_1_2_2_2")
    @JsonProperty("APTE-1-2-2-2")
    private String APTE_1_2_2_2; // D⁃二聚体检测值
    public String getAPTE_1_2_2_2() {  return this.APTE_1_2_2_2;}
    @JsonProperty("APTE-1-2-2-2")
    public void setAPTE_1_2_2_2(final String APTE_1_2_2_2) { this.APTE_1_2_2_2=APTE_1_2_2_2;}
    @Column(name = "APTE_1_2_2_3")
    @JsonProperty("APTE-1-2-2-3")
    private String APTE_1_2_2_3; // D⁃二聚体检测参考值范围上限值
    public String getAPTE_1_2_2_3() {  return this.APTE_1_2_2_3;}
    @JsonProperty("APTE-1-2-2-3")
    public void setAPTE_1_2_2_3(final String APTE_1_2_2_3) { this.APTE_1_2_2_3=APTE_1_2_2_3;}
    @Column(name = "APTE_1_2_2_4")
    @JsonProperty("APTE-1-2-2-4")
    private String APTE_1_2_2_4; // D⁃二聚体检测参考值范围下限值
    public String getAPTE_1_2_2_4() {  return this.APTE_1_2_2_4;}
    @JsonProperty("APTE-1-2-2-4")
    public void setAPTE_1_2_2_4(final String APTE_1_2_2_4) { this.APTE_1_2_2_4=APTE_1_2_2_4;}
    @Column(name = "APTE_1_2_2_5")
    @JsonProperty("APTE-1-2-2-5")
    private String APTE_1_2_2_5; // D⁃二聚体检测评估结论
    public String getAPTE_1_2_2_5() {  return this.APTE_1_2_2_5;}
    @JsonProperty("APTE-1-2-2-5")
    public void setAPTE_1_2_2_5(final String APTE_1_2_2_5) { this.APTE_1_2_2_5=APTE_1_2_2_5;}
    @Column(name = "APTE_1_2_2_6")
    @JsonProperty("APTE-1-2-2-6")
    private String APTE_1_2_2_6; // 检测日期时间
    public String getAPTE_1_2_2_6() {  return this.APTE_1_2_2_6;}
    @JsonProperty("APTE-1-2-2-6")
    public void setAPTE_1_2_2_6(final String APTE_1_2_2_6) { this.APTE_1_2_2_6=APTE_1_2_2_6;}
    @Column(name = "APTE_1_2_3")
    @JsonProperty("APTE-1-2-3")
    private String APTE_1_2_3; // 是否实施心脏生物学标志物检测
    public String getAPTE_1_2_3() {  return this.APTE_1_2_3;}
    @JsonProperty("APTE-1-2-3")
    public void setAPTE_1_2_3(final String APTE_1_2_3) { this.APTE_1_2_3=APTE_1_2_3;}
    @Column(name = "APTE_1_2_4")
    @JsonProperty("APTE-1-2-4")
    private String APTE_1_2_4; // 心脏生物学标志物检测项目及检测值（入院首次检测值）
    public String getAPTE_1_2_4() {  return this.APTE_1_2_4;}
    @JsonProperty("APTE-1-2-4")
    public void setAPTE_1_2_4(final String APTE_1_2_4) { this.APTE_1_2_4=APTE_1_2_4;}
    @Column(name = "APTE_1_2_4_1")
    @JsonProperty("APTE-1-2-4-1")
    private String APTE_1_2_4_1; // 肌钙蛋白T（cTnT）检测值(ng/mL)
    public String getAPTE_1_2_4_1() {  return this.APTE_1_2_4_1;}
    @JsonProperty("APTE-1-2-4-1")
    public void setAPTE_1_2_4_1(final String APTE_1_2_4_1) { this.APTE_1_2_4_1=APTE_1_2_4_1;}
    @Column(name = "APTE_1_2_4_2")
    @JsonProperty("APTE-1-2-4-2")
    private String APTE_1_2_4_2; // 肌钙蛋白I（cTnI）检测值(ng/mL)
    public String getAPTE_1_2_4_2() {  return this.APTE_1_2_4_2;}
    @JsonProperty("APTE-1-2-4-2")
    public void setAPTE_1_2_4_2(final String APTE_1_2_4_2) { this.APTE_1_2_4_2=APTE_1_2_4_2;}
    @Column(name = "APTE_1_2_4_3")
    @JsonProperty("APTE-1-2-4-3")
    private String APTE_1_2_4_3; // B型钠尿肽（BNP）检测值(pg/ml)
    public String getAPTE_1_2_4_3() {  return this.APTE_1_2_4_3;}
    @JsonProperty("APTE-1-2-4-3")
    public void setAPTE_1_2_4_3(final String APTE_1_2_4_3) { this.APTE_1_2_4_3=APTE_1_2_4_3;}
    @Column(name = "APTE_1_2_4_4")
    @JsonProperty("APTE-1-2-4-4")
    private String APTE_1_2_4_4; // N端B型钠尿肽前体（NT-ProBNP）检测值(pg/ml)
    public String getAPTE_1_2_4_4() {  return this.APTE_1_2_4_4;}
    @JsonProperty("APTE-1-2-4-4")
    public void setAPTE_1_2_4_4(final String APTE_1_2_4_4) { this.APTE_1_2_4_4=APTE_1_2_4_4;}
    @Column(name = "APTE_1_2_5")
    @JsonProperty("APTE-1-2-5")
    private String APTE_1_2_5; // 检测日期时间
    public String getAPTE_1_2_5() {  return this.APTE_1_2_5;}
    @JsonProperty("APTE-1-2-5")
    public void setAPTE_1_2_5(final String APTE_1_2_5) { this.APTE_1_2_5=APTE_1_2_5;}
    @Column(name = "APTE_1_3_1")
    @JsonProperty("APTE-1-3-1")
    private String APTE_1_3_1; // 是否实施超声心动检测
    public String getAPTE_1_3_1() {  return this.APTE_1_3_1;}
    @JsonProperty("APTE-1-3-1")
    public void setAPTE_1_3_1(final String APTE_1_3_1) { this.APTE_1_3_1=APTE_1_3_1;}
    @Column(name = "APTE_1_3_2")
    @JsonProperty("APTE-1-3-2")
    private String APTE_1_3_2; // 右心功能检测结果（主要数据）
    public String getAPTE_1_3_2() {  return this.APTE_1_3_2;}
    @JsonProperty("APTE-1-3-2")
    public void setAPTE_1_3_2(final String APTE_1_3_2) { this.APTE_1_3_2=APTE_1_3_2;}
    @Column(name = "APTE_1_3_2_1")
    @JsonProperty("APTE-1-3-2-1")
    private String APTE_1_3_2_1; // 右室舒张末内径(mm)
    public String getAPTE_1_3_2_1() {  return this.APTE_1_3_2_1;}
    @JsonProperty("APTE-1-3-2-1")
    public void setAPTE_1_3_2_1(final String APTE_1_3_2_1) { this.APTE_1_3_2_1=APTE_1_3_2_1;}
    @Column(name = "APTE_1_3_2_2")
    @JsonProperty("APTE-1-3-2-2")
    private String APTE_1_3_2_2; // 右心室舒张末内径/左心室舒张末内径(mm)
    public String getAPTE_1_3_2_2() {  return this.APTE_1_3_2_2;}
    @JsonProperty("APTE-1-3-2-2")
    public void setAPTE_1_3_2_2(final String APTE_1_3_2_2) { this.APTE_1_3_2_2=APTE_1_3_2_2;}
    @Column(name = "APTE_1_3_2_3")
    @JsonProperty("APTE-1-3-2-3")
    private String APTE_1_3_2_3; // 三尖瓣环收缩期位移距离(mm)
    public String getAPTE_1_3_2_3() {  return this.APTE_1_3_2_3;}
    @JsonProperty("APTE-1-3-2-3")
    public void setAPTE_1_3_2_3(final String APTE_1_3_2_3) { this.APTE_1_3_2_3=APTE_1_3_2_3;}
    @Column(name = "APTE_1_3_2_4")
    @JsonProperty("APTE-1-3-2-4")
    private String APTE_1_3_2_4; // 三尖瓣反流速度(%)
    public String getAPTE_1_3_2_4() {  return this.APTE_1_3_2_4;}
    @JsonProperty("APTE-1-3-2-4")
    public void setAPTE_1_3_2_4(final String APTE_1_3_2_4) { this.APTE_1_3_2_4=APTE_1_3_2_4;}
    @Column(name = "APTE_1_3_2_5")
    @JsonProperty("APTE-1-3-2-5")
    private String APTE_1_3_2_5; // 右室游离壁运动幅度(mm)
    public String getAPTE_1_3_2_5() {  return this.APTE_1_3_2_5;}
    @JsonProperty("APTE-1-3-2-5")
    public void setAPTE_1_3_2_5(final String APTE_1_3_2_5) { this.APTE_1_3_2_5=APTE_1_3_2_5;}
    @Column(name = "APTE_1_3_2_6")
    @JsonProperty("APTE-1-3-2-6")
    private String APTE_1_3_2_6; // 其他右心功能检测结果
    public String getAPTE_1_3_2_6() {  return this.APTE_1_3_2_6;}
    @JsonProperty("APTE-1-3-2-6")
    public void setAPTE_1_3_2_6(final String APTE_1_3_2_6) { this.APTE_1_3_2_6=APTE_1_3_2_6;}
    @Column(name = "APTE_1_3_3")
    @JsonProperty("APTE-1-3-3")
    private String APTE_1_3_3; // 是否实施下肢静脉超声检测
    public String getAPTE_1_3_3() {  return this.APTE_1_3_3;}
    @JsonProperty("APTE-1-3-3")
    public void setAPTE_1_3_3(final String APTE_1_3_3) { this.APTE_1_3_3=APTE_1_3_3;}
    @Column(name = "APTE_1_3_4")
    @JsonProperty("APTE-1-3-4")
    private String APTE_1_3_4; // 超声描述
    public String getAPTE_1_3_4() {  return this.APTE_1_3_4;}
    @JsonProperty("APTE-1-3-4")
    public void setAPTE_1_3_4(final String APTE_1_3_4) { this.APTE_1_3_4=APTE_1_3_4;}
    @Column(name = "APTE_1_3_4_2")
    @JsonProperty("APTE-1-3-4-2")
    private String APTE_1_3_4_2; // 超声诊断
    public String getAPTE_1_3_4_2() {  return this.APTE_1_3_4_2;}
    @JsonProperty("APTE-1-3-4-2")
    public void setAPTE_1_3_4_2(final String APTE_1_3_4_2) { this.APTE_1_3_4_2=APTE_1_3_4_2;}
    @Column(name = "APTE_1_3_5")
    @JsonProperty("APTE-1-3-5")
    private String APTE_1_3_5; // 是否存在CT肺动脉造影（CTPA）检查相对禁忌
    public String getAPTE_1_3_5() {  return this.APTE_1_3_5;}
    @JsonProperty("APTE-1-3-5")
    public void setAPTE_1_3_5(final String APTE_1_3_5) { this.APTE_1_3_5=APTE_1_3_5;}
    @Column(name = "APTE_1_3_6")
    @JsonProperty("APTE-1-3-6")
    private String APTE_1_3_6; // 是否进行CT肺动脉造影（CTPA）检查
    public String getAPTE_1_3_6() {  return this.APTE_1_3_6;}
    @JsonProperty("APTE-1-3-6")
    public void setAPTE_1_3_6(final String APTE_1_3_6) { this.APTE_1_3_6=APTE_1_3_6;}
    @Column(name = "APTE_1_3_7")
    @JsonProperty("APTE-1-3-7")
    private String APTE_1_3_7; // 实施行CT肺动脉造影（CTPA）检查日期时间
    public String getAPTE_1_3_7() {  return this.APTE_1_3_7;}
    @JsonProperty("APTE-1-3-7")
    public void setAPTE_1_3_7(final String APTE_1_3_7) { this.APTE_1_3_7=APTE_1_3_7;}
    @Column(name = "APTE_1_3_8")
    @JsonProperty("APTE-1-3-8")
    private String APTE_1_3_8; // CTPA检查报告结果：主要阳性发现
    public String getAPTE_1_3_8() {  return this.APTE_1_3_8;}
    @JsonProperty("APTE-1-3-8")
    public void setAPTE_1_3_8(final String APTE_1_3_8) { this.APTE_1_3_8=APTE_1_3_8;}
    @Column(name = "APTE_1_3_8_1")
    @JsonProperty("APTE-1-3-8-1")
    private String APTE_1_3_8_1; // 其他主要阳性发现
    public String getAPTE_1_3_8_1() {  return this.APTE_1_3_8_1;}
    @JsonProperty("APTE-1-3-8-1")
    public void setAPTE_1_3_8_1(final String APTE_1_3_8_1) { this.APTE_1_3_8_1=APTE_1_3_8_1;}
    @Column(name = "APTE_1_3_9_1")
    @JsonProperty("APTE-1-3-9-1")
    private String APTE_1_3_9_1; // PTA累及肺段数量是否无法确定或无记录
    public String getAPTE_1_3_9_1() {  return this.APTE_1_3_9_1;}
    @JsonProperty("APTE-1-3-9-1")
    public void setAPTE_1_3_9_1(final String APTE_1_3_9_1) { this.APTE_1_3_9_1=APTE_1_3_9_1;}
    @Column(name = "APTE_1_3_9")
    @JsonProperty("APTE-1-3-9")
    private String APTE_1_3_9; // PTA累及肺段数量(个)
    public String getAPTE_1_3_9() {  return this.APTE_1_3_9;}
    @JsonProperty("APTE-1-3-9")
    public void setAPTE_1_3_9(final String APTE_1_3_9) { this.APTE_1_3_9=APTE_1_3_9;}
    @Column(name = "APTE_1_3_10")
    @JsonProperty("APTE-1-3-10")
    private String APTE_1_3_10; // CTPA检查报告结果：临床分型
    public String getAPTE_1_3_10() {  return this.APTE_1_3_10;}
    @JsonProperty("APTE-1-3-10")
    public void setAPTE_1_3_10(final String APTE_1_3_10) { this.APTE_1_3_10=APTE_1_3_10;}
    @Column(name = "APTE_1_3_11")
    @JsonProperty("APTE-1-3-11")
    private String APTE_1_3_11; // 是否实施V/Q显像
    public String getAPTE_1_3_11() {  return this.APTE_1_3_11;}
    @JsonProperty("APTE-1-3-11")
    public void setAPTE_1_3_11(final String APTE_1_3_11) { this.APTE_1_3_11=APTE_1_3_11;}
    @Column(name = "APTE_1_3_12")
    @JsonProperty("APTE-1-3-12")
    private String APTE_1_3_12; // V/Q显像方式
    public String getAPTE_1_3_12() {  return this.APTE_1_3_12;}
    @JsonProperty("APTE-1-3-12")
    public void setAPTE_1_3_12(final String APTE_1_3_12) { this.APTE_1_3_12=APTE_1_3_12;}
    @Column(name = "APTE_1_3_12_1")
    @JsonProperty("APTE-1-3-12-1")
    private String APTE_1_3_12_1; // V/Q平面显像结论
    public String getAPTE_1_3_12_1() {  return this.APTE_1_3_12_1;}
    @JsonProperty("APTE-1-3-12-1")
    public void setAPTE_1_3_12_1(final String APTE_1_3_12_1) { this.APTE_1_3_12_1=APTE_1_3_12_1;}
    @Column(name = "APTE_1_3_12_2")
    @JsonProperty("APTE-1-3-12-2")
    private String APTE_1_3_12_2; // V/Q断层显像结论
    public String getAPTE_1_3_12_2() {  return this.APTE_1_3_12_2;}
    @JsonProperty("APTE-1-3-12-2")
    public void setAPTE_1_3_12_2(final String APTE_1_3_12_2) { this.APTE_1_3_12_2=APTE_1_3_12_2;}
    @Column(name = "APTE_1_3_13")
    @JsonProperty("APTE-1-3-13")
    private String APTE_1_3_13; // 是否实施磁共振肺动脉造影（MRPA）
    public String getAPTE_1_3_13() {  return this.APTE_1_3_13;}
    @JsonProperty("APTE-1-3-13")
    public void setAPTE_1_3_13(final String APTE_1_3_13) { this.APTE_1_3_13=APTE_1_3_13;}
    @Column(name = "APTE_1_3_14")
    @JsonProperty("APTE-1-3-14")
    private String APTE_1_3_14; // 磁共振肺动脉造影（MRPA）结论
    public String getAPTE_1_3_14() {  return this.APTE_1_3_14;}
    @JsonProperty("APTE-1-3-14")
    public void setAPTE_1_3_14(final String APTE_1_3_14) { this.APTE_1_3_14=APTE_1_3_14;}
    @Column(name = "APTE_1_3_14_1")
    @JsonProperty("APTE-1-3-14-1")
    private String APTE_1_3_14_1; // 其他磁共振肺动脉造影结论
    public String getAPTE_1_3_14_1() {  return this.APTE_1_3_14_1;}
    @JsonProperty("APTE-1-3-14-1")
    public void setAPTE_1_3_14_1(final String APTE_1_3_14_1) { this.APTE_1_3_14_1=APTE_1_3_14_1;}
    @Column(name = "APTE_1_3_15")
    @JsonProperty("APTE-1-3-15")
    private String APTE_1_3_15; // 是否实施肺动脉造影
    public String getAPTE_1_3_15() {  return this.APTE_1_3_15;}
    @JsonProperty("APTE-1-3-15")
    public void setAPTE_1_3_15(final String APTE_1_3_15) { this.APTE_1_3_15=APTE_1_3_15;}
    @Column(name = "APTE_1_3_16")
    @JsonProperty("APTE-1-3-16")
    private String APTE_1_3_16; // 肺动脉造影结论
    public String getAPTE_1_3_16() {  return this.APTE_1_3_16;}
    @JsonProperty("APTE-1-3-16")
    public void setAPTE_1_3_16(final String APTE_1_3_16) { this.APTE_1_3_16=APTE_1_3_16;}
    @Column(name = "APTE_1_4_1")
    @JsonProperty("APTE-1-4-1")
    private String APTE_1_4_1; // 是否行肺血栓栓塞症危险分层评估
    public String getAPTE_1_4_1() {  return this.APTE_1_4_1;}
    @JsonProperty("APTE-1-4-1")
    public void setAPTE_1_4_1(final String APTE_1_4_1) { this.APTE_1_4_1=APTE_1_4_1;}
    @Column(name = "APTE_1_4_2")
    @JsonProperty("APTE-1-4-2")
    private String APTE_1_4_2; // 低血压/休克
    public String getAPTE_1_4_2() {  return this.APTE_1_4_2;}
    @JsonProperty("APTE-1-4-2")
    public void setAPTE_1_4_2(final String APTE_1_4_2) { this.APTE_1_4_2=APTE_1_4_2;}
    @Column(name = "APTE_1_4_3")
    @JsonProperty("APTE-1-4-3")
    private String APTE_1_4_3; // 影像学-右心功能不全
    public String getAPTE_1_4_3() {  return this.APTE_1_4_3;}
    @JsonProperty("APTE-1-4-3")
    public void setAPTE_1_4_3(final String APTE_1_4_3) { this.APTE_1_4_3=APTE_1_4_3;}
    @Column(name = "APTE_1_4_5_1")
    @JsonProperty("APTE-1-4-5-1")
    private String APTE_1_4_5_1; // 低血压/休克
    public String getAPTE_1_4_5_1() {  return this.APTE_1_4_5_1;}
    @JsonProperty("APTE-1-4-5-1")
    public void setAPTE_1_4_5_1(final String APTE_1_4_5_1) { this.APTE_1_4_5_1=APTE_1_4_5_1;}
    @Column(name = "APTE_1_4_5_2")
    @JsonProperty("APTE-1-4-5-2")
    private String APTE_1_4_5_2; // 影像学-右心功能不全
    public String getAPTE_1_4_5_2() {  return this.APTE_1_4_5_2;}
    @JsonProperty("APTE-1-4-5-2")
    public void setAPTE_1_4_5_2(final String APTE_1_4_5_2) { this.APTE_1_4_5_2=APTE_1_4_5_2;}
    @Column(name = "APTE_1_4_5_3")
    @JsonProperty("APTE-1-4-5-3")
    private String APTE_1_4_5_3; // 组合二项
    public String getAPTE_1_4_5_3() {  return this.APTE_1_4_5_3;}
    @JsonProperty("APTE-1-4-5-3")
    public void setAPTE_1_4_5_3(final String APTE_1_4_5_3) { this.APTE_1_4_5_3=APTE_1_4_5_3;}
    @Column(name = "APTE_1_4_3_1")
    @JsonProperty("APTE-1-4-3-1")
    private String APTE_1_4_3_1; // 右心功能不全(RTD)的诊断标准（影像学证据包括超声心动图或 CT 提示 RTD）
    public String getAPTE_1_4_3_1() {  return this.APTE_1_4_3_1;}
    @JsonProperty("APTE-1-4-3-1")
    public void setAPTE_1_4_3_1(final String APTE_1_4_3_1) { this.APTE_1_4_3_1=APTE_1_4_3_1;}
    @Column(name = "APTE_1_4_3_2")
    @JsonProperty("APTE-1-4-3-2")
    private String APTE_1_4_3_2; // 其他阳性结论
    public String getAPTE_1_4_3_2() {  return this.APTE_1_4_3_2;}
    @JsonProperty("APTE-1-4-3-2")
    public void setAPTE_1_4_3_2(final String APTE_1_4_3_2) { this.APTE_1_4_3_2=APTE_1_4_3_2;}
    @Column(name = "APTE_1_4_3_3")
    @JsonProperty("APTE-1-4-3-3")
    private String APTE_1_4_3_3; // CTPA检查诊断 RTD 符合条件
    public String getAPTE_1_4_3_3() {  return this.APTE_1_4_3_3;}
    @JsonProperty("APTE-1-4-3-3")
    public void setAPTE_1_4_3_3(final String APTE_1_4_3_3) { this.APTE_1_4_3_3=APTE_1_4_3_3;}
    @Column(name = "APTE_1_4_3_4")
    @JsonProperty("APTE-1-4-3-4")
    private String APTE_1_4_3_4; // 其他阳性结论
    public String getAPTE_1_4_3_4() {  return this.APTE_1_4_3_4;}
    @JsonProperty("APTE-1-4-3-4")
    public void setAPTE_1_4_3_4(final String APTE_1_4_3_4) { this.APTE_1_4_3_4=APTE_1_4_3_4;}
    @Column(name = "APTE_1_4_4")
    @JsonProperty("APTE-1-4-4")
    private String APTE_1_4_4; // 实验室指标-心脏生物学标志物升高
    public String getAPTE_1_4_4() {  return this.APTE_1_4_4;}
    @JsonProperty("APTE-1-4-4")
    public void setAPTE_1_4_4(final String APTE_1_4_4) { this.APTE_1_4_4=APTE_1_4_4;}
    @Column(name = "APTE_1_4_5_4")
    @JsonProperty("APTE-1-4-5-4")
    private String APTE_1_4_5_4; // 实验室指标-心脏生物学标志物升高
    public String getAPTE_1_4_5_4() {  return this.APTE_1_4_5_4;}
    @JsonProperty("APTE-1-4-5-4")
    public void setAPTE_1_4_5_4(final String APTE_1_4_5_4) { this.APTE_1_4_5_4=APTE_1_4_5_4;}
    @Column(name = "APTE_1_4_5_5")
    @JsonProperty("APTE-1-4-5-5")
    private String APTE_1_4_5_5; // 组合赋值
    public String getAPTE_1_4_5_5() {  return this.APTE_1_4_5_5;}
    @JsonProperty("APTE-1-4-5-5")
    public void setAPTE_1_4_5_5(final String APTE_1_4_5_5) { this.APTE_1_4_5_5=APTE_1_4_5_5;}
    @Column(name = "APTE_1_4_5")
    @JsonProperty("APTE-1-4-5")
    private String APTE_1_4_5; // 肺血栓栓塞症危险分层评估结论
    public String getAPTE_1_4_5() {  return this.APTE_1_4_5;}
    @JsonProperty("APTE-1-4-5")
    public void setAPTE_1_4_5(final String APTE_1_4_5) { this.APTE_1_4_5=APTE_1_4_5;}
    @Column(name = "APTE_2_1_1")
    @JsonProperty("APTE-2-1-1")
    private String APTE_2_1_1; // 是否实施氧合评估
    public String getAPTE_2_1_1() {  return this.APTE_2_1_1;}
    @JsonProperty("APTE-2-1-1")
    public void setAPTE_2_1_1(final String APTE_2_1_1) { this.APTE_2_1_1=APTE_2_1_1;}
    @Column(name = "APTE_2_1_2")
    @JsonProperty("APTE-2-1-2")
    private String APTE_2_1_2; // 首次氧合评估日期时间
    public String getAPTE_2_1_2() {  return this.APTE_2_1_2;}
    @JsonProperty("APTE-2-1-2")
    public void setAPTE_2_1_2(final String APTE_2_1_2) { this.APTE_2_1_2=APTE_2_1_2;}
    @Column(name = "APTE_2_1_3")
    @JsonProperty("APTE-2-1-3")
    private String APTE_2_1_3; // 实施首次氧合评估时是否有吸氧(FiO₂)
    public String getAPTE_2_1_3() {  return this.APTE_2_1_3;}
    @JsonProperty("APTE-2-1-3")
    public void setAPTE_2_1_3(final String APTE_2_1_3) { this.APTE_2_1_3=APTE_2_1_3;}
    @Column(name = "APTE_2_1_4")
    @JsonProperty("APTE-2-1-4")
    private String APTE_2_1_4; // 吸入氧浓度 FiO₂(%)
    public String getAPTE_2_1_4() {  return this.APTE_2_1_4;}
    @JsonProperty("APTE-2-1-4")
    public void setAPTE_2_1_4(final String APTE_2_1_4) { this.APTE_2_1_4=APTE_2_1_4;}
    @Column(name = "APTE_2_1_5")
    @JsonProperty("APTE-2-1-5")
    private String APTE_2_1_5; // 动脉血气分析/指氧仪检查
    public String getAPTE_2_1_5() {  return this.APTE_2_1_5;}
    @JsonProperty("APTE-2-1-5")
    public void setAPTE_2_1_5(final String APTE_2_1_5) { this.APTE_2_1_5=APTE_2_1_5;}
    @Column(name = "APTE_2_1_5_1")
    @JsonProperty("APTE-2-1-5-1")
    private String APTE_2_1_5_1; // PaO₂动脉血氧分压 (mmHg)
    public String getAPTE_2_1_5_1() {  return this.APTE_2_1_5_1;}
    @JsonProperty("APTE-2-1-5-1")
    public void setAPTE_2_1_5_1(final String APTE_2_1_5_1) { this.APTE_2_1_5_1=APTE_2_1_5_1;}
    @Column(name = "APTE_2_1_5_2")
    @JsonProperty("APTE-2-1-5-2")
    private String APTE_2_1_5_2; // 氧合指数(mmHg)
    public String getAPTE_2_1_5_2() {  return this.APTE_2_1_5_2;}
    @JsonProperty("APTE-2-1-5-2")
    public void setAPTE_2_1_5_2(final String APTE_2_1_5_2) { this.APTE_2_1_5_2=APTE_2_1_5_2;}
    @Column(name = "APTE_2_1_5_3")
    @JsonProperty("APTE-2-1-5-3")
    private String APTE_2_1_5_3; // SpO₂ 氧气饱和度(%)
    public String getAPTE_2_1_5_3() {  return this.APTE_2_1_5_3;}
    @JsonProperty("APTE-2-1-5-3")
    public void setAPTE_2_1_5_3(final String APTE_2_1_5_3) { this.APTE_2_1_5_3=APTE_2_1_5_3;}
    @Column(name = "APTE_2_2_1")
    @JsonProperty("APTE-2-2-1")
    private String APTE_2_2_1; // 是否实施氧疗
    public String getAPTE_2_2_1() {  return this.APTE_2_2_1;}
    @JsonProperty("APTE-2-2-1")
    public void setAPTE_2_2_1(final String APTE_2_2_1) { this.APTE_2_2_1=APTE_2_2_1;}
    @Column(name = "APTE_2_2_2")
    @JsonProperty("APTE-2-2-2")
    private String APTE_2_2_2; // 氧疗方法的选择
    public String getAPTE_2_2_2() {  return this.APTE_2_2_2;}
    @JsonProperty("APTE-2-2-2")
    public void setAPTE_2_2_2(final String APTE_2_2_2) { this.APTE_2_2_2=APTE_2_2_2;}
    @Column(name = "APTE_2_2_3")
    @JsonProperty("APTE-2-2-3")
    private String APTE_2_2_3; // 实施氧疗起始日期时间
    public String getAPTE_2_2_3() {  return this.APTE_2_2_3;}
    @JsonProperty("APTE-2-2-3")
    public void setAPTE_2_2_3(final String APTE_2_2_3) { this.APTE_2_2_3=APTE_2_2_3;}
    @Column(name = "APTE_2_3_1")
    @JsonProperty("APTE-2-3-1")
    private String APTE_2_3_1; // 是否实施无创正压通气（NIV）
    public String getAPTE_2_3_1() {  return this.APTE_2_3_1;}
    @JsonProperty("APTE-2-3-1")
    public void setAPTE_2_3_1(final String APTE_2_3_1) { this.APTE_2_3_1=APTE_2_3_1;}
    @Column(name = "APTE_2_3_2")
    @JsonProperty("APTE-2-3-2")
    private String APTE_2_3_2; // 实施无创正压通气起始日期时间
    public String getAPTE_2_3_2() {  return this.APTE_2_3_2;}
    @JsonProperty("APTE-2-3-2")
    public void setAPTE_2_3_2(final String APTE_2_3_2) { this.APTE_2_3_2=APTE_2_3_2;}
    @Column(name = "APTE_2_3_3")
    @JsonProperty("APTE-2-3-3")
    private String APTE_2_3_3; // 实施无创正压通气终止日期时间
    public String getAPTE_2_3_3() {  return this.APTE_2_3_3;}
    @JsonProperty("APTE-2-3-3")
    public void setAPTE_2_3_3(final String APTE_2_3_3) { this.APTE_2_3_3=APTE_2_3_3;}
    @Column(name = "APTE_2_3_4")
    @JsonProperty("APTE-2-3-4")
    private String APTE_2_3_4; // 无创正压通气疗程（小时）
    public String getAPTE_2_3_4() {  return this.APTE_2_3_4;}
    @JsonProperty("APTE-2-3-4")
    public void setAPTE_2_3_4(final String APTE_2_3_4) { this.APTE_2_3_4=APTE_2_3_4;}
    @Column(name = "APTE_2_4_1")
    @JsonProperty("APTE-2-4-1")
    private String APTE_2_4_1; // 是否实施有创机械通气
    public String getAPTE_2_4_1() {  return this.APTE_2_4_1;}
    @JsonProperty("APTE-2-4-1")
    public void setAPTE_2_4_1(final String APTE_2_4_1) { this.APTE_2_4_1=APTE_2_4_1;}
    @Column(name = "APTE_2_4_2")
    @JsonProperty("APTE-2-4-2")
    private String APTE_2_4_2; // 实施机械通气起始日期时间
    public String getAPTE_2_4_2() {  return this.APTE_2_4_2;}
    @JsonProperty("APTE-2-4-2")
    public void setAPTE_2_4_2(final String APTE_2_4_2) { this.APTE_2_4_2=APTE_2_4_2;}
    @Column(name = "APTE_2_4_3")
    @JsonProperty("APTE-2-4-3")
    private String APTE_2_4_3; // 实施机械通气终止日期时间
    public String getAPTE_2_4_3() {  return this.APTE_2_4_3;}
    @JsonProperty("APTE-2-4-3")
    public void setAPTE_2_4_3(final String APTE_2_4_3) { this.APTE_2_4_3=APTE_2_4_3;}
    @Column(name = "APTE_2_4_4")
    @JsonProperty("APTE-2-4-4")
    private String APTE_2_4_4; // 有机械通气疗程（小时）
    public String getAPTE_2_4_4() {  return this.APTE_2_4_4;}
    @JsonProperty("APTE-2-4-4")
    public void setAPTE_2_4_4(final String APTE_2_4_4) { this.APTE_2_4_4=APTE_2_4_4;}
    @Column(name = "APTE_3_4_1")
    @JsonProperty("APTE-3-4-1")
    private String APTE_3_4_1; // 是否合并抗凝治疗的出血高危因素
    public String getAPTE_3_4_1() {  return this.APTE_3_4_1;}
    @JsonProperty("APTE-3-4-1")
    public void setAPTE_3_4_1(final String APTE_3_4_1) { this.APTE_3_4_1=APTE_3_4_1;}
    @Column(name = "APTE_3_4_2")
    @JsonProperty("APTE-3-4-2")
    private String APTE_3_4_2; // 合并出血的高危因素
    public String getAPTE_3_4_2() {  return this.APTE_3_4_2;}
    @JsonProperty("APTE-3-4-2")
    public void setAPTE_3_4_2(final String APTE_3_4_2) { this.APTE_3_4_2=APTE_3_4_2;}
    @Column(name = "APTE_3_1_1")
    @JsonProperty("APTE-3-1-1")
    private String APTE_3_1_1; // 是否应用抗凝治疗
    public String getAPTE_3_1_1() {  return this.APTE_3_1_1;}
    @JsonProperty("APTE-3-1-1")
    public void setAPTE_3_1_1(final String APTE_3_1_1) { this.APTE_3_1_1=APTE_3_1_1;}
    @Column(name = "APTE_3_1_2")
    @JsonProperty("APTE-3-1-2")
    private String APTE_3_1_2; // 初始抗凝药物的选择
    public String getAPTE_3_1_2() {  return this.APTE_3_1_2;}
    @JsonProperty("APTE-3-1-2")
    public void setAPTE_3_1_2(final String APTE_3_1_2) { this.APTE_3_1_2=APTE_3_1_2;}
    @Column(name = "APTE_3_1_2_1")
    @JsonProperty("APTE-3-1-2-1")
    private String APTE_3_1_2_1; // 肠道外抗凝剂
    public String getAPTE_3_1_2_1() {  return this.APTE_3_1_2_1;}
    @JsonProperty("APTE-3-1-2-1")
    public void setAPTE_3_1_2_1(final String APTE_3_1_2_1) { this.APTE_3_1_2_1=APTE_3_1_2_1;}
    @Column(name = "APTE_3_1_3")
    @JsonProperty("APTE-3-1-3")
    private String APTE_3_1_3; // 首剂用药医嘱执行日期时间
    public String getAPTE_3_1_3() {  return this.APTE_3_1_3;}
    @JsonProperty("APTE-3-1-3")
    public void setAPTE_3_1_3(final String APTE_3_1_3) { this.APTE_3_1_3=APTE_3_1_3;}
    @Column(name = "APTE_3_1_2_2")
    @JsonProperty("APTE-3-1-2-2")
    private String APTE_3_1_2_2; // 口服抗凝药
    public String getAPTE_3_1_2_2() {  return this.APTE_3_1_2_2;}
    @JsonProperty("APTE-3-1-2-2")
    public void setAPTE_3_1_2_2(final String APTE_3_1_2_2) { this.APTE_3_1_2_2=APTE_3_1_2_2;}
    @Column(name = "APTE_3_1_2_3")
    @JsonProperty("APTE-3-1-2-3")
    private String APTE_3_1_2_3; // 其他口服抗凝药
    public String getAPTE_3_1_2_3() {  return this.APTE_3_1_2_3;}
    @JsonProperty("APTE-3-1-2-3")
    public void setAPTE_3_1_2_3(final String APTE_3_1_2_3) { this.APTE_3_1_2_3=APTE_3_1_2_3;}
    @Column(name = "APTE_3_1_4")
    @JsonProperty("APTE-3-1-4")
    private String APTE_3_1_4; // 首剂用药医嘱执行日期时间
    public String getAPTE_3_1_4() {  return this.APTE_3_1_4;}
    @JsonProperty("APTE-3-1-4")
    public void setAPTE_3_1_4(final String APTE_3_1_4) { this.APTE_3_1_4=APTE_3_1_4;}
    @Column(name = "APTE_3_2_1")
    @JsonProperty("APTE-3-2-1")
    private String APTE_3_2_1; // 使用华法林治疗后是否行INR测定
    public String getAPTE_3_2_1() {  return this.APTE_3_2_1;}
    @JsonProperty("APTE-3-2-1")
    public void setAPTE_3_2_1(final String APTE_3_2_1) { this.APTE_3_2_1=APTE_3_2_1;}
    @Column(name = "APTE_3_2_2")
    @JsonProperty("APTE-3-2-2")
    private String APTE_3_2_2; // 出院前INR测量值
    public String getAPTE_3_2_2() {  return this.APTE_3_2_2;}
    @JsonProperty("APTE-3-2-2")
    public void setAPTE_3_2_2(final String APTE_3_2_2) { this.APTE_3_2_2=APTE_3_2_2;}
    @Column(name = "APTE_3_3_1")
    @JsonProperty("APTE-3-3-1")
    private String APTE_3_3_1; // 出院时是否继续应用抗凝治疗
    public String getAPTE_3_3_1() {  return this.APTE_3_3_1;}
    @JsonProperty("APTE-3-3-1")
    public void setAPTE_3_3_1(final String APTE_3_3_1) { this.APTE_3_3_1=APTE_3_3_1;}
    @Column(name = "APTE_3_3_2")
    @JsonProperty("APTE-3-3-2")
    private String APTE_3_3_2; // 出院后继续应用抗凝药物的选择
    public String getAPTE_3_3_2() {  return this.APTE_3_3_2;}
    @JsonProperty("APTE-3-3-2")
    public void setAPTE_3_3_2(final String APTE_3_3_2) { this.APTE_3_3_2=APTE_3_3_2;}
    @Column(name = "APTE_3_3_2_1")
    @JsonProperty("APTE-3-3-2-1")
    private String APTE_3_3_2_1; // 肠道外抗凝剂
    public String getAPTE_3_3_2_1() {  return this.APTE_3_3_2_1;}
    @JsonProperty("APTE-3-3-2-1")
    public void setAPTE_3_3_2_1(final String APTE_3_3_2_1) { this.APTE_3_3_2_1=APTE_3_3_2_1;}
    @Column(name = "APTE_3_3_2_2")
    @JsonProperty("APTE-3-3-2-2")
    private String APTE_3_3_2_2; // 口服抗凝药
    public String getAPTE_3_3_2_2() {  return this.APTE_3_3_2_2;}
    @JsonProperty("APTE-3-3-2-2")
    public void setAPTE_3_3_2_2(final String APTE_3_3_2_2) { this.APTE_3_3_2_2=APTE_3_3_2_2;}
    @Column(name = "APTE_3_3_2_3")
    @JsonProperty("APTE-3-3-2-3")
    private String APTE_3_3_2_3; // 其他口服抗凝药
    public String getAPTE_3_3_2_3() {  return this.APTE_3_3_2_3;}
    @JsonProperty("APTE-3-3-2-3")
    public void setAPTE_3_3_2_3(final String APTE_3_3_2_3) { this.APTE_3_3_2_3=APTE_3_3_2_3;}
    @Column(name = "APTE_4_1_1")
    @JsonProperty("APTE-4-1-1")
    private String APTE_4_1_1; // APTE溶栓适应证
    public String getAPTE_4_1_1() {  return this.APTE_4_1_1;}
    @JsonProperty("APTE-4-1-1")
    public void setAPTE_4_1_1(final String APTE_4_1_1) { this.APTE_4_1_1=APTE_4_1_1;}
    @Column(name = "APTE_4_1_2")
    @JsonProperty("APTE-4-1-2")
    private String APTE_4_1_2; // 是否有溶栓禁忌证
    public String getAPTE_4_1_2() {  return this.APTE_4_1_2;}
    @JsonProperty("APTE-4-1-2")
    public void setAPTE_4_1_2(final String APTE_4_1_2) { this.APTE_4_1_2=APTE_4_1_2;}
    @Column(name = "APTE_4_1_3")
    @JsonProperty("APTE-4-1-3")
    private String APTE_4_1_3; // 绝对禁忌证
    public String getAPTE_4_1_3() {  return this.APTE_4_1_3;}
    @JsonProperty("APTE-4-1-3")
    public void setAPTE_4_1_3(final String APTE_4_1_3) { this.APTE_4_1_3=APTE_4_1_3;}
    @Column(name = "APTE_4_2_1")
    @JsonProperty("APTE-4-2-1")
    private String APTE_4_2_1; // 是否实施溶栓治疗
    public String getAPTE_4_2_1() {  return this.APTE_4_2_1;}
    @JsonProperty("APTE-4-2-1")
    public void setAPTE_4_2_1(final String APTE_4_2_1) { this.APTE_4_2_1=APTE_4_2_1;}
    @Column(name = "APTE_4_2_2")
    @JsonProperty("APTE-4-2-2")
    private String APTE_4_2_2; // 溶栓药物的选择
    public String getAPTE_4_2_2() {  return this.APTE_4_2_2;}
    @JsonProperty("APTE-4-2-2")
    public void setAPTE_4_2_2(final String APTE_4_2_2) { this.APTE_4_2_2=APTE_4_2_2;}
    @Column(name = "APTE_4_2_2_1")
    @JsonProperty("APTE-4-2-2-1")
    private String APTE_4_2_2_1; // 其他溶栓药物
    public String getAPTE_4_2_2_1() {  return this.APTE_4_2_2_1;}
    @JsonProperty("APTE-4-2-2-1")
    public void setAPTE_4_2_2_1(final String APTE_4_2_2_1) { this.APTE_4_2_2_1=APTE_4_2_2_1;}
    @Column(name = "APTE_4_2_3_1")
    @JsonProperty("APTE-4-2-3-1")
    private String APTE_4_2_3_1; // 输注溶栓剂开始日期时间
    public String getAPTE_4_2_3_1() {  return this.APTE_4_2_3_1;}
    @JsonProperty("APTE-4-2-3-1")
    public void setAPTE_4_2_3_1(final String APTE_4_2_3_1) { this.APTE_4_2_3_1=APTE_4_2_3_1;}
    @Column(name = "APTE_4_2_3_2")
    @JsonProperty("APTE-4-2-3-2")
    private String APTE_4_2_3_2; // 输注溶栓剂完成日期时间
    public String getAPTE_4_2_3_2() {  return this.APTE_4_2_3_2;}
    @JsonProperty("APTE-4-2-3-2")
    public void setAPTE_4_2_3_2(final String APTE_4_2_3_2) { this.APTE_4_2_3_2=APTE_4_2_3_2;}
    @Column(name = "APTE_4_3_1")
    @JsonProperty("APTE-4-3-1")
    private String APTE_4_3_1; // 是否实施影像学复查
    public String getAPTE_4_3_1() {  return this.APTE_4_3_1;}
    @JsonProperty("APTE-4-3-1")
    public void setAPTE_4_3_1(final String APTE_4_3_1) { this.APTE_4_3_1=APTE_4_3_1;}
    @Column(name = "APTE_4_3_2")
    @JsonProperty("APTE-4-3-2")
    private String APTE_4_3_2; // 影像学评估方式
    public String getAPTE_4_3_2() {  return this.APTE_4_3_2;}
    @JsonProperty("APTE-4-3-2")
    public void setAPTE_4_3_2(final String APTE_4_3_2) { this.APTE_4_3_2=APTE_4_3_2;}
    @Column(name = "APTE_4_3_3")
    @JsonProperty("APTE-4-3-3")
    private String APTE_4_3_3; // 溶栓效果评价
    public String getAPTE_4_3_3() {  return this.APTE_4_3_3;}
    @JsonProperty("APTE-4-3-3")
    public void setAPTE_4_3_3(final String APTE_4_3_3) { this.APTE_4_3_3=APTE_4_3_3;}
    @Column(name = "APTE_5_1_1")
    @JsonProperty("APTE-5-1-1")
    private String APTE_5_1_1; // 治疗过程中是否发生活动性出血
    public String getAPTE_5_1_1() {  return this.APTE_5_1_1;}
    @JsonProperty("APTE-5-1-1")
    public void setAPTE_5_1_1(final String APTE_5_1_1) { this.APTE_5_1_1=APTE_5_1_1;}
    @Column(name = "APTE_5_1_2")
    @JsonProperty("APTE-5-1-2")
    private String APTE_5_1_2; // 临床出血事件
    public String getAPTE_5_1_2() {  return this.APTE_5_1_2;}
    @JsonProperty("APTE-5-1-2")
    public void setAPTE_5_1_2(final String APTE_5_1_2) { this.APTE_5_1_2=APTE_5_1_2;}
    @Column(name = "APTE_5_1_2_1")
    @JsonProperty("APTE-5-1-2-1")
    private String APTE_5_1_2_1; // 大出血
    public String getAPTE_5_1_2_1() {  return this.APTE_5_1_2_1;}
    @JsonProperty("APTE-5-1-2-1")
    public void setAPTE_5_1_2_1(final String APTE_5_1_2_1) { this.APTE_5_1_2_1=APTE_5_1_2_1;}
    @Column(name = "APTE_5_1_2_2")
    @JsonProperty("APTE-5-1-2-2")
    private String APTE_5_1_2_2; // 临床相关性非大出血
    public String getAPTE_5_1_2_2() {  return this.APTE_5_1_2_2;}
    @JsonProperty("APTE-5-1-2-2")
    public void setAPTE_5_1_2_2(final String APTE_5_1_2_2) { this.APTE_5_1_2_2=APTE_5_1_2_2;}
    @Column(name = "APTE_5_1_2_3")
    @JsonProperty("APTE-5-1-2-3")
    private String APTE_5_1_2_3; // 其他临床相关性非大出血
    public String getAPTE_5_1_2_3() {  return this.APTE_5_1_2_3;}
    @JsonProperty("APTE-5-1-2-3")
    public void setAPTE_5_1_2_3(final String APTE_5_1_2_3) { this.APTE_5_1_2_3=APTE_5_1_2_3;}
    @Column(name = "APTE_5_1_3")
    @JsonProperty("APTE-5-1-3")
    private String APTE_5_1_3; // 发生日期时间
    public String getAPTE_5_1_3() {  return this.APTE_5_1_3;}
    @JsonProperty("APTE-5-1-3")
    public void setAPTE_5_1_3(final String APTE_5_1_3) { this.APTE_5_1_3=APTE_5_1_3;}
    @Column(name = "APTE_5_1_4")
    @JsonProperty("APTE-5-1-4")
    private String APTE_5_1_4; // 影响程度的选择
    public String getAPTE_5_1_4() {  return this.APTE_5_1_4;}
    @JsonProperty("APTE-5-1-4")
    public void setAPTE_5_1_4(final String APTE_5_1_4) { this.APTE_5_1_4=APTE_5_1_4;}
    @Column(name = "APTE_6_1_1")
    @JsonProperty("APTE-6-1-1")
    private String APTE_6_1_1; // 入院后是否实施教育及指导
    public String getAPTE_6_1_1() {  return this.APTE_6_1_1;}
    @JsonProperty("APTE-6-1-1")
    public void setAPTE_6_1_1(final String APTE_6_1_1) { this.APTE_6_1_1=APTE_6_1_1;}
    @Column(name = "APTE_6_1_2")
    @JsonProperty("APTE-6-1-2")
    private String APTE_6_1_2; // 入院后教育及指导
    public String getAPTE_6_1_2() {  return this.APTE_6_1_2;}
    @JsonProperty("APTE-6-1-2")
    public void setAPTE_6_1_2(final String APTE_6_1_2) { this.APTE_6_1_2=APTE_6_1_2;}
    @Column(name = "APTE_6_1_3")
    @JsonProperty("APTE-6-1-3")
    private String APTE_6_1_3; // 是否实施溶栓、抗凝治疗
    public String getAPTE_6_1_3() {  return this.APTE_6_1_3;}
    @JsonProperty("APTE-6-1-3")
    public void setAPTE_6_1_3(final String APTE_6_1_3) { this.APTE_6_1_3=APTE_6_1_3;}
    @Column(name = "APTE_6_1_5")
    @JsonProperty("APTE-6-1-5")
    private String APTE_6_1_5; // 溶栓、抗凝治疗教育及指导
    public String getAPTE_6_1_5() {  return this.APTE_6_1_5;}
    @JsonProperty("APTE-6-1-5")
    public void setAPTE_6_1_5(final String APTE_6_1_5) { this.APTE_6_1_5=APTE_6_1_5;}
    @Column(name = "APTE_6_2_1")
    @JsonProperty("APTE-6-2-1")
    private String APTE_6_2_1; // 出院前是否行病情严重程度评估（PESI评分）
    public String getAPTE_6_2_1() {  return this.APTE_6_2_1;}
    @JsonProperty("APTE-6-2-1")
    public void setAPTE_6_2_1(final String APTE_6_2_1) { this.APTE_6_2_1=APTE_6_2_1;}
    @Column(name = "APTE_6_2_2")
    @JsonProperty("APTE-6-2-2")
    private String APTE_6_2_2; // PESI评分值
    public String getAPTE_6_2_2() {  return this.APTE_6_2_2;}
    @JsonProperty("APTE-6-2-2")
    public void setAPTE_6_2_2(final String APTE_6_2_2) { this.APTE_6_2_2=APTE_6_2_2;}
    @Column(name = "APTE_6_2_3")
    @JsonProperty("APTE-6-2-3")
    private String APTE_6_2_3; // PESI评分值的分层
    public String getAPTE_6_2_3() {  return this.APTE_6_2_3;}
    @JsonProperty("APTE-6-2-3")
    public void setAPTE_6_2_3(final String APTE_6_2_3) { this.APTE_6_2_3=APTE_6_2_3;}
    @Column(name = "APTE_6_2_4")
    @JsonProperty("APTE-6-2-4")
    private String APTE_6_2_4; // 评估日期时间
    public String getAPTE_6_2_4() {  return this.APTE_6_2_4;}
    @JsonProperty("APTE-6-2-4")
    public void setAPTE_6_2_4(final String APTE_6_2_4) { this.APTE_6_2_4=APTE_6_2_4;}
    @Column(name = "APTE_6_2_5")
    @JsonProperty("APTE-6-2-5")
    private String APTE_6_2_5; // 出院前是否行末次N端B型钠尿肽前体（NT-ProBNP）检测
    public String getAPTE_6_2_5() {  return this.APTE_6_2_5;}
    @JsonProperty("APTE-6-2-5")
    public void setAPTE_6_2_5(final String APTE_6_2_5) { this.APTE_6_2_5=APTE_6_2_5;}
    @Column(name = "APTE_6_2_6")
    @JsonProperty("APTE-6-2-6")
    private String APTE_6_2_6; // 末次NT－proBNP检测值(pg/ml)
    public String getAPTE_6_2_6() {  return this.APTE_6_2_6;}
    @JsonProperty("APTE-6-2-6")
    public void setAPTE_6_2_6(final String APTE_6_2_6) { this.APTE_6_2_6=APTE_6_2_6;}
    @Column(name = "APTE_6_2_7")
    @JsonProperty("APTE-6-2-7")
    private String APTE_6_2_7; // 患者NT－proBNP参考值范围<(pg/ml)
    public String getAPTE_6_2_7() {  return this.APTE_6_2_7;}
    @JsonProperty("APTE-6-2-7")
    public void setAPTE_6_2_7(final String APTE_6_2_7) { this.APTE_6_2_7=APTE_6_2_7;}
    @Column(name = "APTE_6_2_8")
    @JsonProperty("APTE-6-2-8")
    private String APTE_6_2_8; // 末次NT－proBNP水平分层
    public String getAPTE_6_2_8() {  return this.APTE_6_2_8;}
    @JsonProperty("APTE-6-2-8")
    public void setAPTE_6_2_8(final String APTE_6_2_8) { this.APTE_6_2_8=APTE_6_2_8;}
    @Column(name = "APTE_6_2_9")
    @JsonProperty("APTE-6-2-9")
    private String APTE_6_2_9; // 末次评估日期时间
    public String getAPTE_6_2_9() {  return this.APTE_6_2_9;}
    @JsonProperty("APTE-6-2-9")
    public void setAPTE_6_2_9(final String APTE_6_2_9) { this.APTE_6_2_9=APTE_6_2_9;}
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
    @Column(name = "APTE_6_3_5")
    @JsonProperty("APTE-6-3-5")
    private String APTE_6_3_5; // 告知常见危险因素
    public String getAPTE_6_3_5() {  return this.APTE_6_3_5;}
    @JsonProperty("APTE-6-3-5")
    public void setAPTE_6_3_5(final String APTE_6_3_5) { this.APTE_6_3_5=APTE_6_3_5;}
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
    @Column(name = "APTE_7_2_1")
    @JsonProperty("APTE-7-2-1")
    private String APTE_7_2_1; // 出院标准
    public String getAPTE_7_2_1() {  return this.APTE_7_2_1;}
    @JsonProperty("APTE-7-2-1")
    public void setAPTE_7_2_1(final String APTE_7_2_1) { this.APTE_7_2_1=APTE_7_2_1;}
    @Column(name = "APTE_7_2_2")
    @JsonProperty("APTE-7-2-2")
    private String APTE_7_2_2; // 其他标准
    public String getAPTE_7_2_2() {  return this.APTE_7_2_2;}
    @JsonProperty("APTE-7-2-2")
    public void setAPTE_7_2_2(final String APTE_7_2_2) { this.APTE_7_2_2=APTE_7_2_2;}
    @Column(name = "CM_4_6")
    @JsonProperty("CM-4-6")
    private String CM_4_6; // 死亡可能涉及因素
    public String getCM_4_6() {  return this.CM_4_6;}
    @JsonProperty("CM-4-6")
    public void setCM_4_6(final String CM_4_6) { this.CM_4_6=CM_4_6;}
    @Column(name = "CM_5_1")
    @JsonProperty("CM-5-1")
    private String CM_5_1; // 医院是否记录患者对服务的体验与评价
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
    @Column(name = "APTE_9_1_4")
    @JsonProperty("APTE-9-1-4")
    private String APTE_9_1_4; // 是否使用抗菌药物
    public String getAPTE_9_1_4() {  return this.APTE_9_1_4;}
    @JsonProperty("APTE-9-1-4")
    public void setAPTE_9_1_4(final String APTE_9_1_4) { this.APTE_9_1_4=APTE_9_1_4;}
    @Column(name = "APTE_9_1_1")
    @JsonProperty("APTE-9-1-1")
    private String APTE_9_1_1; // 患者接受首剂抗菌药物治疗（注射剂输入/注射）时间
    public String getAPTE_9_1_1() {  return this.APTE_9_1_1;}
    @JsonProperty("APTE-9-1-1")
    public void setAPTE_9_1_1(final String APTE_9_1_1) { this.APTE_9_1_1=APTE_9_1_1;}
    @Column(name = "APTE_9_1_2")
    @JsonProperty("APTE-9-1-2")
    private String APTE_9_1_2; // 患者终止抗菌药物治疗（注射剂输入/注射）日期时间
    public String getAPTE_9_1_2() {  return this.APTE_9_1_2;}
    @JsonProperty("APTE-9-1-2")
    public void setAPTE_9_1_2(final String APTE_9_1_2) { this.APTE_9_1_2=APTE_9_1_2;}
    @Column(name = "APTE_9_1_3")
    @JsonProperty("APTE-9-1-3")
    private String APTE_9_1_3; // 注射剂输入/注射抗菌药物疗程(天)
    public String getAPTE_9_1_3() {  return this.APTE_9_1_3;}
    @JsonProperty("APTE-9-1-3")
    public void setAPTE_9_1_3(final String APTE_9_1_3) { this.APTE_9_1_3=APTE_9_1_3;}
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