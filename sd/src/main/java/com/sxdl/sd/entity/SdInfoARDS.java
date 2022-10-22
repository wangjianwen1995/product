package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断及其他诊断ICD-10编码：J80.x00x001、J80.x00x002、J81.x00x001、O99.512、J95.800x021的出院患者
*/
@ApiModel(value = "53信息")
@Entity
@Table(name = "sd_info_ARDS")
public class SdInfoARDS implements Serializable {
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
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为出院后31天内重复住院
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
    @Column(name = "ARDS_0_2_2_1")
    @JsonProperty("ARDS-0-2-2-1")
    private String ARDS_0_2_2_1; // ARDS诊断日期时间是否无法确定或无记录
    public String getARDS_0_2_2_1() {  return this.ARDS_0_2_2_1;}
    @JsonProperty("ARDS-0-2-2-1")
    public void setARDS_0_2_2_1(final String ARDS_0_2_2_1) { this.ARDS_0_2_2_1=ARDS_0_2_2_1;}
    @Column(name = "ARDS_0_2_2_2")
    @JsonProperty("ARDS-0-2-2-2")
    private String ARDS_0_2_2_2; // ARDS诊断日期时间
    public String getARDS_0_2_2_2() {  return this.ARDS_0_2_2_2;}
    @JsonProperty("ARDS-0-2-2-2")
    public void setARDS_0_2_2_2(final String ARDS_0_2_2_2) { this.ARDS_0_2_2_2=ARDS_0_2_2_2;}
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
    @Column(name = "ARDS_0_2_5")
    @JsonProperty("ARDS-0-2-5")
    private String ARDS_0_2_5; // 是否入住ICU/或其他监护单元
    public String getARDS_0_2_5() {  return this.ARDS_0_2_5;}
    @JsonProperty("ARDS-0-2-5")
    public void setARDS_0_2_5(final String ARDS_0_2_5) { this.ARDS_0_2_5=ARDS_0_2_5;}
    @Column(name = "CM_0_2_5_1")
    @JsonProperty("CM-0-2-5-1")
    private String CM_0_2_5_1; // 入住ICU/或其他监护单元日期时间
    public String getCM_0_2_5_1() {  return this.CM_0_2_5_1;}
    @JsonProperty("CM-0-2-5-1")
    public void setCM_0_2_5_1(final String CM_0_2_5_1) { this.CM_0_2_5_1=CM_0_2_5_1;}
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU/或其他监护单元日期时间
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
    @Column(name = "ARDS_1_1_1")
    @JsonProperty("ARDS-1-1-1")
    private String ARDS_1_1_1; // 导致ARDS的原发病因
    public String getARDS_1_1_1() {  return this.ARDS_1_1_1;}
    @JsonProperty("ARDS-1-1-1")
    public void setARDS_1_1_1(final String ARDS_1_1_1) { this.ARDS_1_1_1=ARDS_1_1_1;}
    @Column(name = "ARDS_1_1_1_1")
    @JsonProperty("ARDS-1-1-1-1")
    private String ARDS_1_1_1_1; // 其他导致ARDS的原发病因
    public String getARDS_1_1_1_1() {  return this.ARDS_1_1_1_1;}
    @JsonProperty("ARDS-1-1-1-1")
    public void setARDS_1_1_1_1(final String ARDS_1_1_1_1) { this.ARDS_1_1_1_1=ARDS_1_1_1_1;}
    @Column(name = "ARDS_1_1_2_1")
    @JsonProperty("ARDS-1-1-2-1")
    private String ARDS_1_1_2_1; // ARDS 原发病因发病的时间是否无法确定或无记录
    public String getARDS_1_1_2_1() {  return this.ARDS_1_1_2_1;}
    @JsonProperty("ARDS-1-1-2-1")
    public void setARDS_1_1_2_1(final String ARDS_1_1_2_1) { this.ARDS_1_1_2_1=ARDS_1_1_2_1;}
    @Column(name = "ARDS_1_1_2_2")
    @JsonProperty("ARDS-1-1-2-2")
    private String ARDS_1_1_2_2; // ARDS 原发病因发病的时间
    public String getARDS_1_1_2_2() {  return this.ARDS_1_1_2_2;}
    @JsonProperty("ARDS-1-1-2-2")
    public void setARDS_1_1_2_2(final String ARDS_1_1_2_2) { this.ARDS_1_1_2_2=ARDS_1_1_2_2;}
    @Column(name = "ARDS_1_1_3")
    @JsonProperty("ARDS-1-1-3")
    private String ARDS_1_1_3; // CT或者胸片表现
    public String getARDS_1_1_3() {  return this.ARDS_1_1_3;}
    @JsonProperty("ARDS-1-1-3")
    public void setARDS_1_1_3(final String ARDS_1_1_3) { this.ARDS_1_1_3=ARDS_1_1_3;}
    @Column(name = "ARDS_1_1_4")
    @JsonProperty("ARDS-1-1-4")
    private String ARDS_1_1_4; // 肺部侵犯象限数
    public String getARDS_1_1_4() {  return this.ARDS_1_1_4;}
    @JsonProperty("ARDS-1-1-4")
    public void setARDS_1_1_4(final String ARDS_1_1_4) { this.ARDS_1_1_4=ARDS_1_1_4;}
    @Column(name = "ARDS_1_1_5")
    @JsonProperty("ARDS-1-1-5")
    private String ARDS_1_1_5; // 肺水肿原因
    public String getARDS_1_1_5() {  return this.ARDS_1_1_5;}
    @JsonProperty("ARDS-1-1-5")
    public void setARDS_1_1_5(final String ARDS_1_1_5) { this.ARDS_1_1_5=ARDS_1_1_5;}
    @Column(name = "ARDS_1_1_6")
    @JsonProperty("ARDS-1-1-6")
    private String ARDS_1_1_6; // ARDS严重程度（氧合指数(PaO2/FiO2, P/F)mmHg)）
    public String getARDS_1_1_6() {  return this.ARDS_1_1_6;}
    @JsonProperty("ARDS-1-1-6")
    public void setARDS_1_1_6(final String ARDS_1_1_6) { this.ARDS_1_1_6=ARDS_1_1_6;}
    @Column(name = "ARDS_1_1_7_1")
    @JsonProperty("ARDS-1-1-7-1")
    private String ARDS_1_1_7_1; // 评估日期时间是否无法确定或无记录
    public String getARDS_1_1_7_1() {  return this.ARDS_1_1_7_1;}
    @JsonProperty("ARDS-1-1-7-1")
    public void setARDS_1_1_7_1(final String ARDS_1_1_7_1) { this.ARDS_1_1_7_1=ARDS_1_1_7_1;}
    @Column(name = "ARDS_1_1_7_2")
    @JsonProperty("ARDS-1-1-7-2")
    private String ARDS_1_1_7_2; // 评估日期时间
    public String getARDS_1_1_7_2() {  return this.ARDS_1_1_7_2;}
    @JsonProperty("ARDS-1-1-7-2")
    public void setARDS_1_1_7_2(final String ARDS_1_1_7_2) { this.ARDS_1_1_7_2=ARDS_1_1_7_2;}
    @Column(name = "ARDS_1_2_1")
    @JsonProperty("ARDS-1-2-1")
    private String ARDS_1_2_1; // 是否实施急性生理与慢性健康(APACHE-Ⅱ)评分
    public String getARDS_1_2_1() {  return this.ARDS_1_2_1;}
    @JsonProperty("ARDS-1-2-1")
    public void setARDS_1_2_1(final String ARDS_1_2_1) { this.ARDS_1_2_1=ARDS_1_2_1;}
    @Column(name = "ARDS_1_2_2_2")
    @JsonProperty("ARDS-1-2-2-2")
    private String ARDS_1_2_2_2; // 第一部分：急性生理学评分值
    public String getARDS_1_2_2_2() {  return this.ARDS_1_2_2_2;}
    @JsonProperty("ARDS-1-2-2-2")
    public void setARDS_1_2_2_2(final String ARDS_1_2_2_2) { this.ARDS_1_2_2_2=ARDS_1_2_2_2;}
    @Column(name = "ARDS_1_2_2_3")
    @JsonProperty("ARDS-1-2-2-3")
    private String ARDS_1_2_2_3; // 第二部分: 年龄及慢性健康状况评分值
    public String getARDS_1_2_2_3() {  return this.ARDS_1_2_2_3;}
    @JsonProperty("ARDS-1-2-2-3")
    public void setARDS_1_2_2_3(final String ARDS_1_2_2_3) { this.ARDS_1_2_2_3=ARDS_1_2_2_3;}
    @Column(name = "ARDS_1_2_2_4")
    @JsonProperty("ARDS-1-2-2-4")
    private String ARDS_1_2_2_4; // 第三部分: Glasgow 昏迷评分值
    public String getARDS_1_2_2_4() {  return this.ARDS_1_2_2_4;}
    @JsonProperty("ARDS-1-2-2-4")
    public void setARDS_1_2_2_4(final String ARDS_1_2_2_4) { this.ARDS_1_2_2_4=ARDS_1_2_2_4;}
    @Column(name = "ARDS_1_2_2_r")
    @JsonProperty("ARDS-1-2-2-r")
    private String ARDS_1_2_2_r; // 15-GCS评分
    public String getARDS_1_2_2_r() {  return this.ARDS_1_2_2_r;}
    @JsonProperty("ARDS-1-2-2-r")
    public void setARDS_1_2_2_r(final String ARDS_1_2_2_r) { this.ARDS_1_2_2_r=ARDS_1_2_2_r;}
    @Column(name = "ARDS_1_2_2_1")
    @JsonProperty("ARDS-1-2-2-1")
    private String ARDS_1_2_2_1; // 合计：APACHE-Ⅱ 评分值
    public String getARDS_1_2_2_1() {  return this.ARDS_1_2_2_1;}
    @JsonProperty("ARDS-1-2-2-1")
    public void setARDS_1_2_2_1(final String ARDS_1_2_2_1) { this.ARDS_1_2_2_1=ARDS_1_2_2_1;}
    @Column(name = "ARDS_1_2_3")
    @JsonProperty("ARDS-1-2-3")
    private String ARDS_1_2_3; // 预计病死率(%)
    public String getARDS_1_2_3() {  return this.ARDS_1_2_3;}
    @JsonProperty("ARDS-1-2-3")
    public void setARDS_1_2_3(final String ARDS_1_2_3) { this.ARDS_1_2_3=ARDS_1_2_3;}
    @Column(name = "ARDS_1_2_4")
    @JsonProperty("ARDS-1-2-4")
    private String ARDS_1_2_4; // APACHE-Ⅱ评分时间
    public String getARDS_1_2_4() {  return this.ARDS_1_2_4;}
    @JsonProperty("ARDS-1-2-4")
    public void setARDS_1_2_4(final String ARDS_1_2_4) { this.ARDS_1_2_4=ARDS_1_2_4;}
    @Column(name = "ARDS_1_2_5")
    @JsonProperty("ARDS-1-2-5")
    private String ARDS_1_2_5; // 是否实施器官衰竭评分（SOFA） 评分
    public String getARDS_1_2_5() {  return this.ARDS_1_2_5;}
    @JsonProperty("ARDS-1-2-5")
    public void setARDS_1_2_5(final String ARDS_1_2_5) { this.ARDS_1_2_5=ARDS_1_2_5;}
    @Column(name = "ARDS_1_2_6_2")
    @JsonProperty("ARDS-1-2-6-2")
    private String ARDS_1_2_6_2; // 第一部分：呼吸系统评分值
    public String getARDS_1_2_6_2() {  return this.ARDS_1_2_6_2;}
    @JsonProperty("ARDS-1-2-6-2")
    public void setARDS_1_2_6_2(final String ARDS_1_2_6_2) { this.ARDS_1_2_6_2=ARDS_1_2_6_2;}
    @Column(name = "ARDS_1_2_6_3")
    @JsonProperty("ARDS-1-2-6-3")
    private String ARDS_1_2_6_3; // 第二部分：血液系统评分值
    public String getARDS_1_2_6_3() {  return this.ARDS_1_2_6_3;}
    @JsonProperty("ARDS-1-2-6-3")
    public void setARDS_1_2_6_3(final String ARDS_1_2_6_3) { this.ARDS_1_2_6_3=ARDS_1_2_6_3;}
    @Column(name = "ARDS_1_2_6_4")
    @JsonProperty("ARDS-1-2-6-4")
    private String ARDS_1_2_6_4; // 第三部分：肝脏评分值
    public String getARDS_1_2_6_4() {  return this.ARDS_1_2_6_4;}
    @JsonProperty("ARDS-1-2-6-4")
    public void setARDS_1_2_6_4(final String ARDS_1_2_6_4) { this.ARDS_1_2_6_4=ARDS_1_2_6_4;}
    @Column(name = "ARDS_1_2_6_5")
    @JsonProperty("ARDS-1-2-6-5")
    private String ARDS_1_2_6_5; // 第四部分：心血管系统评分值
    public String getARDS_1_2_6_5() {  return this.ARDS_1_2_6_5;}
    @JsonProperty("ARDS-1-2-6-5")
    public void setARDS_1_2_6_5(final String ARDS_1_2_6_5) { this.ARDS_1_2_6_5=ARDS_1_2_6_5;}
    @Column(name = "ARDS_1_2_6_6")
    @JsonProperty("ARDS-1-2-6-6")
    private String ARDS_1_2_6_6; // 第五部分：中枢神经系统评分值
    public String getARDS_1_2_6_6() {  return this.ARDS_1_2_6_6;}
    @JsonProperty("ARDS-1-2-6-6")
    public void setARDS_1_2_6_6(final String ARDS_1_2_6_6) { this.ARDS_1_2_6_6=ARDS_1_2_6_6;}
    @Column(name = "ARDS_1_2_6_7")
    @JsonProperty("ARDS-1-2-6-7")
    private String ARDS_1_2_6_7; // 第六部分：肾脏评分值
    public String getARDS_1_2_6_7() {  return this.ARDS_1_2_6_7;}
    @JsonProperty("ARDS-1-2-6-7")
    public void setARDS_1_2_6_7(final String ARDS_1_2_6_7) { this.ARDS_1_2_6_7=ARDS_1_2_6_7;}
    @Column(name = "ARDS_1_2_6_1")
    @JsonProperty("ARDS-1-2-6-1")
    private String ARDS_1_2_6_1; // 合计：SOFA 评分值
    public String getARDS_1_2_6_1() {  return this.ARDS_1_2_6_1;}
    @JsonProperty("ARDS-1-2-6-1")
    public void setARDS_1_2_6_1(final String ARDS_1_2_6_1) { this.ARDS_1_2_6_1=ARDS_1_2_6_1;}
    @Column(name = "ARDS_1_2_7")
    @JsonProperty("ARDS-1-2-7")
    private String ARDS_1_2_7; // SOFA 评分结果分层
    public String getARDS_1_2_7() {  return this.ARDS_1_2_7;}
    @JsonProperty("ARDS-1-2-7")
    public void setARDS_1_2_7(final String ARDS_1_2_7) { this.ARDS_1_2_7=ARDS_1_2_7;}
    @Column(name = "ARDS_1_2_8")
    @JsonProperty("ARDS-1-2-8")
    private String ARDS_1_2_8; // SOFA 评分时间
    public String getARDS_1_2_8() {  return this.ARDS_1_2_8;}
    @JsonProperty("ARDS-1-2-8")
    public void setARDS_1_2_8(final String ARDS_1_2_8) { this.ARDS_1_2_8=ARDS_1_2_8;}
    @Column(name = "ARDS_1_2_9")
    @JsonProperty("ARDS-1-2-9")
    private String ARDS_1_2_9; // 患者是否合并休克
    public String getARDS_1_2_9() {  return this.ARDS_1_2_9;}
    @JsonProperty("ARDS-1-2-9")
    public void setARDS_1_2_9(final String ARDS_1_2_9) { this.ARDS_1_2_9=ARDS_1_2_9;}
    @Column(name = "ARDS_1_2_10")
    @JsonProperty("ARDS-1-2-10")
    private String ARDS_1_2_10; // 患者是否合并急性肾损伤
    public String getARDS_1_2_10() {  return this.ARDS_1_2_10;}
    @JsonProperty("ARDS-1-2-10")
    public void setARDS_1_2_10(final String ARDS_1_2_10) { this.ARDS_1_2_10=ARDS_1_2_10;}
    @Column(name = "ARDS_2_1_1")
    @JsonProperty("ARDS-2-1-1")
    private String ARDS_2_1_1; // 是否实施呼吸支持和辅助治疗
    public String getARDS_2_1_1() {  return this.ARDS_2_1_1;}
    @JsonProperty("ARDS-2-1-1")
    public void setARDS_2_1_1(final String ARDS_2_1_1) { this.ARDS_2_1_1=ARDS_2_1_1;}
    @Column(name = "ARDS_2_1_2")
    @JsonProperty("ARDS-2-1-2")
    private String ARDS_2_1_2; // 呼吸支持和辅助治疗措施的选择
    public String getARDS_2_1_2() {  return this.ARDS_2_1_2;}
    @JsonProperty("ARDS-2-1-2")
    public void setARDS_2_1_2(final String ARDS_2_1_2) { this.ARDS_2_1_2=ARDS_2_1_2;}
    @Column(name = "ARDS_2_2_2")
    @JsonProperty("ARDS-2-2-2")
    private String ARDS_2_2_2; // 氧疗方法的选择
    public String getARDS_2_2_2() {  return this.ARDS_2_2_2;}
    @JsonProperty("ARDS-2-2-2")
    public void setARDS_2_2_2(final String ARDS_2_2_2) { this.ARDS_2_2_2=ARDS_2_2_2;}
    @Column(name = "ARDS_2_2_3")
    @JsonProperty("ARDS-2-2-3")
    private String ARDS_2_2_3; // 实施氧疗起始日期时间
    public String getARDS_2_2_3() {  return this.ARDS_2_2_3;}
    @JsonProperty("ARDS-2-2-3")
    public void setARDS_2_2_3(final String ARDS_2_2_3) { this.ARDS_2_2_3=ARDS_2_2_3;}
    @Column(name = "ARDS_2_2_4")
    @JsonProperty("ARDS-2-2-4")
    private String ARDS_2_2_4; // 实施氧疗结束日期时间
    public String getARDS_2_2_4() {  return this.ARDS_2_2_4;}
    @JsonProperty("ARDS-2-2-4")
    public void setARDS_2_2_4(final String ARDS_2_2_4) { this.ARDS_2_2_4=ARDS_2_2_4;}
    @Column(name = "ARDS_2_3_2")
    @JsonProperty("ARDS-2-3-2")
    private String ARDS_2_3_2; // 实施高流量氧疗通气开始日期时间
    public String getARDS_2_3_2() {  return this.ARDS_2_3_2;}
    @JsonProperty("ARDS-2-3-2")
    public void setARDS_2_3_2(final String ARDS_2_3_2) { this.ARDS_2_3_2=ARDS_2_3_2;}
    @Column(name = "ARDS_2_3_3")
    @JsonProperty("ARDS-2-3-3")
    private String ARDS_2_3_3; // 高流量氧疗（HFNC）终止日期时间
    public String getARDS_2_3_3() {  return this.ARDS_2_3_3;}
    @JsonProperty("ARDS-2-3-3")
    public void setARDS_2_3_3(final String ARDS_2_3_3) { this.ARDS_2_3_3=ARDS_2_3_3;}
    @Column(name = "ARDS_2_3_4")
    @JsonProperty("ARDS-2-3-4")
    private String ARDS_2_3_4; // 高流量氧疗通气（HFNC）时间（小时）
    public String getARDS_2_3_4() {  return this.ARDS_2_3_4;}
    @JsonProperty("ARDS-2-3-4")
    public void setARDS_2_3_4(final String ARDS_2_3_4) { this.ARDS_2_3_4=ARDS_2_3_4;}
    @Column(name = "ARDS_2_4_2")
    @JsonProperty("ARDS-2-4-2")
    private String ARDS_2_4_2; // 实施无创正压通气起始日期时间
    public String getARDS_2_4_2() {  return this.ARDS_2_4_2;}
    @JsonProperty("ARDS-2-4-2")
    public void setARDS_2_4_2(final String ARDS_2_4_2) { this.ARDS_2_4_2=ARDS_2_4_2;}
    @Column(name = "ARDS_2_4_3")
    @JsonProperty("ARDS-2-4-3")
    private String ARDS_2_4_3; // 实施无创正压通气终止日期时间
    public String getARDS_2_4_3() {  return this.ARDS_2_4_3;}
    @JsonProperty("ARDS-2-4-3")
    public void setARDS_2_4_3(final String ARDS_2_4_3) { this.ARDS_2_4_3=ARDS_2_4_3;}
    @Column(name = "ARDS_2_4_4")
    @JsonProperty("ARDS-2-4-4")
    private String ARDS_2_4_4; // 无创正压通气疗程（小时）
    public String getARDS_2_4_4() {  return this.ARDS_2_4_4;}
    @JsonProperty("ARDS-2-4-4")
    public void setARDS_2_4_4(final String ARDS_2_4_4) { this.ARDS_2_4_4=ARDS_2_4_4;}
    @Column(name = "ARDS_2_5_2")
    @JsonProperty("ARDS-2-5-2")
    private String ARDS_2_5_2; // 实施有创机械通气起始日期时间
    public String getARDS_2_5_2() {  return this.ARDS_2_5_2;}
    @JsonProperty("ARDS-2-5-2")
    public void setARDS_2_5_2(final String ARDS_2_5_2) { this.ARDS_2_5_2=ARDS_2_5_2;}
    @Column(name = "ARDS_2_5_3")
    @JsonProperty("ARDS-2-5-3")
    private String ARDS_2_5_3; // 有创机械通气初始模式
    public String getARDS_2_5_3() {  return this.ARDS_2_5_3;}
    @JsonProperty("ARDS-2-5-3")
    public void setARDS_2_5_3(final String ARDS_2_5_3) { this.ARDS_2_5_3=ARDS_2_5_3;}
    @Column(name = "ARDS_2_5_3_1")
    @JsonProperty("ARDS-2-5-3-1")
    private String ARDS_2_5_3_1; // 其他有创机械通气模式
    public String getARDS_2_5_3_1() {  return this.ARDS_2_5_3_1;}
    @JsonProperty("ARDS-2-5-3-1")
    public void setARDS_2_5_3_1(final String ARDS_2_5_3_1) { this.ARDS_2_5_3_1=ARDS_2_5_3_1;}
    @Column(name = "ARDS_2_5_4")
    @JsonProperty("ARDS-2-5-4")
    private String ARDS_2_5_4; // 有创机械通气后初始设置/监测相关参数
    public String getARDS_2_5_4() {  return this.ARDS_2_5_4;}
    @JsonProperty("ARDS-2-5-4")
    public void setARDS_2_5_4(final String ARDS_2_5_4) { this.ARDS_2_5_4=ARDS_2_5_4;}
    @Column(name = "ARDS_2_5_4_1")
    @JsonProperty("ARDS-2-5-4-1")
    private String ARDS_2_5_4_1; // 潮气量(ml/kg PBW)
    public String getARDS_2_5_4_1() {  return this.ARDS_2_5_4_1;}
    @JsonProperty("ARDS-2-5-4-1")
    public void setARDS_2_5_4_1(final String ARDS_2_5_4_1) { this.ARDS_2_5_4_1=ARDS_2_5_4_1;}
    @Column(name = "ARDS_2_5_4_2")
    @JsonProperty("ARDS-2-5-4-2")
    private String ARDS_2_5_4_2; // 呼气末正压(cmH2O)
    public String getARDS_2_5_4_2() {  return this.ARDS_2_5_4_2;}
    @JsonProperty("ARDS-2-5-4-2")
    public void setARDS_2_5_4_2(final String ARDS_2_5_4_2) { this.ARDS_2_5_4_2=ARDS_2_5_4_2;}
    @Column(name = "ARDS_2_5_4_3")
    @JsonProperty("ARDS-2-5-4-3")
    private String ARDS_2_5_4_3; // 吸入氧气浓度(%)
    public String getARDS_2_5_4_3() {  return this.ARDS_2_5_4_3;}
    @JsonProperty("ARDS-2-5-4-3")
    public void setARDS_2_5_4_3(final String ARDS_2_5_4_3) { this.ARDS_2_5_4_3=ARDS_2_5_4_3;}
    @Column(name = "ARDS_2_5_4_4")
    @JsonProperty("ARDS-2-5-4-4")
    private String ARDS_2_5_4_4; // 平台压(cmH2O)
    public String getARDS_2_5_4_4() {  return this.ARDS_2_5_4_4;}
    @JsonProperty("ARDS-2-5-4-4")
    public void setARDS_2_5_4_4(final String ARDS_2_5_4_4) { this.ARDS_2_5_4_4=ARDS_2_5_4_4;}
    @Column(name = "ARDS_2_5_4_5")
    @JsonProperty("ARDS-2-5-4-5")
    private String ARDS_2_5_4_5; // 气道峰压(cmH2O)
    public String getARDS_2_5_4_5() {  return this.ARDS_2_5_4_5;}
    @JsonProperty("ARDS-2-5-4-5")
    public void setARDS_2_5_4_5(final String ARDS_2_5_4_5) { this.ARDS_2_5_4_5=ARDS_2_5_4_5;}
    @Column(name = "ARDS_2_5_4_6")
    @JsonProperty("ARDS-2-5-4-6")
    private String ARDS_2_5_4_6; // 肺顺应性(ml/cmH2O)
    public String getARDS_2_5_4_6() {  return this.ARDS_2_5_4_6;}
    @JsonProperty("ARDS-2-5-4-6")
    public void setARDS_2_5_4_6(final String ARDS_2_5_4_6) { this.ARDS_2_5_4_6=ARDS_2_5_4_6;}
    @Column(name = "ARDS_2_5_4_7")
    @JsonProperty("ARDS-2-5-4-7")
    private String ARDS_2_5_4_7; // 气道阻力(cmH2O/(L.S))
    public String getARDS_2_5_4_7() {  return this.ARDS_2_5_4_7;}
    @JsonProperty("ARDS-2-5-4-7")
    public void setARDS_2_5_4_7(final String ARDS_2_5_4_7) { this.ARDS_2_5_4_7=ARDS_2_5_4_7;}
    @Column(name = "ARDS_2_5_5")
    @JsonProperty("ARDS-2-5-5")
    private String ARDS_2_5_5; // 有创机械通气后第一份血气分析结果
    public String getARDS_2_5_5() {  return this.ARDS_2_5_5;}
    @JsonProperty("ARDS-2-5-5")
    public void setARDS_2_5_5(final String ARDS_2_5_5) { this.ARDS_2_5_5=ARDS_2_5_5;}
    @Column(name = "ARDS_2_5_5_1")
    @JsonProperty("ARDS-2-5-5-1")
    private String ARDS_2_5_5_1; // 当日动脉血气分析(pH)
    public String getARDS_2_5_5_1() {  return this.ARDS_2_5_5_1;}
    @JsonProperty("ARDS-2-5-5-1")
    public void setARDS_2_5_5_1(final String ARDS_2_5_5_1) { this.ARDS_2_5_5_1=ARDS_2_5_5_1;}
    @Column(name = "ARDS_2_5_5_2")
    @JsonProperty("ARDS-2-5-5-2")
    private String ARDS_2_5_5_2; // 动脉血气分析氧分压(mmHg)
    public String getARDS_2_5_5_2() {  return this.ARDS_2_5_5_2;}
    @JsonProperty("ARDS-2-5-5-2")
    public void setARDS_2_5_5_2(final String ARDS_2_5_5_2) { this.ARDS_2_5_5_2=ARDS_2_5_5_2;}
    @Column(name = "ARDS_2_5_5_3")
    @JsonProperty("ARDS-2-5-5-3")
    private String ARDS_2_5_5_3; // 动脉血气分析二氧化碳分压(mmHg)
    public String getARDS_2_5_5_3() {  return this.ARDS_2_5_5_3;}
    @JsonProperty("ARDS-2-5-5-3")
    public void setARDS_2_5_5_3(final String ARDS_2_5_5_3) { this.ARDS_2_5_5_3=ARDS_2_5_5_3;}
    @Column(name = "ARDS_2_5_5_4")
    @JsonProperty("ARDS-2-5-5-4")
    private String ARDS_2_5_5_4; // 动脉血气分析氧饱和度(%)
    public String getARDS_2_5_5_4() {  return this.ARDS_2_5_5_4;}
    @JsonProperty("ARDS-2-5-5-4")
    public void setARDS_2_5_5_4(final String ARDS_2_5_5_4) { this.ARDS_2_5_5_4=ARDS_2_5_5_4;}
    @Column(name = "ARDS_2_5_5_5")
    @JsonProperty("ARDS-2-5-5-5")
    private String ARDS_2_5_5_5; // 动脉血气分析吸入氧浓度(%)
    public String getARDS_2_5_5_5() {  return this.ARDS_2_5_5_5;}
    @JsonProperty("ARDS-2-5-5-5")
    public void setARDS_2_5_5_5(final String ARDS_2_5_5_5) { this.ARDS_2_5_5_5=ARDS_2_5_5_5;}
    @Column(name = "ARDS_2_5_5_6")
    @JsonProperty("ARDS-2-5-5-6")
    private String ARDS_2_5_5_6; // 动脉血气分析血乳酸(mmol/L)
    public String getARDS_2_5_5_6() {  return this.ARDS_2_5_5_6;}
    @JsonProperty("ARDS-2-5-5-6")
    public void setARDS_2_5_5_6(final String ARDS_2_5_5_6) { this.ARDS_2_5_5_6=ARDS_2_5_5_6;}
    @Column(name = "ARDS_2_5_6")
    @JsonProperty("ARDS-2-5-6")
    private String ARDS_2_5_6; // 是否成功撤离有创机械通气
    public String getARDS_2_5_6() {  return this.ARDS_2_5_6;}
    @JsonProperty("ARDS-2-5-6")
    public void setARDS_2_5_6(final String ARDS_2_5_6) { this.ARDS_2_5_6=ARDS_2_5_6;}
    @Column(name = "ARDS_2_5_7")
    @JsonProperty("ARDS-2-5-7")
    private String ARDS_2_5_7; // 是否进行自主呼吸试验（SBT）
    public String getARDS_2_5_7() {  return this.ARDS_2_5_7;}
    @JsonProperty("ARDS-2-5-7")
    public void setARDS_2_5_7(final String ARDS_2_5_7) { this.ARDS_2_5_7=ARDS_2_5_7;}
    @Column(name = "ARDS_2_5_8")
    @JsonProperty("ARDS-2-5-8")
    private String ARDS_2_5_8; // 自主呼吸试验（SBT）方式
    public String getARDS_2_5_8() {  return this.ARDS_2_5_8;}
    @JsonProperty("ARDS-2-5-8")
    public void setARDS_2_5_8(final String ARDS_2_5_8) { this.ARDS_2_5_8=ARDS_2_5_8;}
    @Column(name = "ARDS_2_5_9")
    @JsonProperty("ARDS-2-5-9")
    private String ARDS_2_5_9; // 有创机械通气撤离日期时间
    public String getARDS_2_5_9() {  return this.ARDS_2_5_9;}
    @JsonProperty("ARDS-2-5-9")
    public void setARDS_2_5_9(final String ARDS_2_5_9) { this.ARDS_2_5_9=ARDS_2_5_9;}
    @Column(name = "ARDS_2_5_10")
    @JsonProperty("ARDS-2-5-10")
    private String ARDS_2_5_10; // 有机械通气时间（小时）
    public String getARDS_2_5_10() {  return this.ARDS_2_5_10;}
    @JsonProperty("ARDS-2-5-10")
    public void setARDS_2_5_10(final String ARDS_2_5_10) { this.ARDS_2_5_10=ARDS_2_5_10;}
    @Column(name = "ARDS_2_6_2")
    @JsonProperty("ARDS-2-6-2")
    private String ARDS_2_6_2; // 早期肺复张是否有效
    public String getARDS_2_6_2() {  return this.ARDS_2_6_2;}
    @JsonProperty("ARDS-2-6-2")
    public void setARDS_2_6_2(final String ARDS_2_6_2) { this.ARDS_2_6_2=ARDS_2_6_2;}
    @Column(name = "ARDS_2_7_2")
    @JsonProperty("ARDS-2-7-2")
    private String ARDS_2_7_2; // 第一天俯卧位通气时间（小时）
    public String getARDS_2_7_2() {  return this.ARDS_2_7_2;}
    @JsonProperty("ARDS-2-7-2")
    public void setARDS_2_7_2(final String ARDS_2_7_2) { this.ARDS_2_7_2=ARDS_2_7_2;}
    @Column(name = "ARDS_2_7_3")
    @JsonProperty("ARDS-2-7-3")
    private String ARDS_2_7_3; // 俯卧位通气天数(天)
    public String getARDS_2_7_3() {  return this.ARDS_2_7_3;}
    @JsonProperty("ARDS-2-7-3")
    public void setARDS_2_7_3(final String ARDS_2_7_3) { this.ARDS_2_7_3=ARDS_2_7_3;}
    @Column(name = "ARDS_2_8_2")
    @JsonProperty("ARDS-2-8-2")
    private String ARDS_2_8_2; // ECMO上机日期时间
    public String getARDS_2_8_2() {  return this.ARDS_2_8_2;}
    @JsonProperty("ARDS-2-8-2")
    public void setARDS_2_8_2(final String ARDS_2_8_2) { this.ARDS_2_8_2=ARDS_2_8_2;}
    @Column(name = "ARDS_2_8_3")
    @JsonProperty("ARDS-2-8-3")
    private String ARDS_2_8_3; // ECMO前机械通气时间(天)
    public String getARDS_2_8_3() {  return this.ARDS_2_8_3;}
    @JsonProperty("ARDS-2-8-3")
    public void setARDS_2_8_3(final String ARDS_2_8_3) { this.ARDS_2_8_3=ARDS_2_8_3;}
    @Column(name = "ARDS_2_8_4")
    @JsonProperty("ARDS-2-8-4")
    private String ARDS_2_8_4; // ECMO后初始机械通气模式
    public String getARDS_2_8_4() {  return this.ARDS_2_8_4;}
    @JsonProperty("ARDS-2-8-4")
    public void setARDS_2_8_4(final String ARDS_2_8_4) { this.ARDS_2_8_4=ARDS_2_8_4;}
    @Column(name = "ARDS_2_8_4_1")
    @JsonProperty("ARDS-2-8-4-1")
    private String ARDS_2_8_4_1; // 其他ECMO后初始通气模式
    public String getARDS_2_8_4_1() {  return this.ARDS_2_8_4_1;}
    @JsonProperty("ARDS-2-8-4-1")
    public void setARDS_2_8_4_1(final String ARDS_2_8_4_1) { this.ARDS_2_8_4_1=ARDS_2_8_4_1;}
    @Column(name = "ARDS_2_8_5")
    @JsonProperty("ARDS-2-8-5")
    private String ARDS_2_8_5; // ECMO后初始设置/监测参数
    public String getARDS_2_8_5() {  return this.ARDS_2_8_5;}
    @JsonProperty("ARDS-2-8-5")
    public void setARDS_2_8_5(final String ARDS_2_8_5) { this.ARDS_2_8_5=ARDS_2_8_5;}
    @Column(name = "ARDS_2_8_5_1")
    @JsonProperty("ARDS-2-8-5-1")
    private String ARDS_2_8_5_1; // 潮气量(ml/kg PBW)
    public String getARDS_2_8_5_1() {  return this.ARDS_2_8_5_1;}
    @JsonProperty("ARDS-2-8-5-1")
    public void setARDS_2_8_5_1(final String ARDS_2_8_5_1) { this.ARDS_2_8_5_1=ARDS_2_8_5_1;}
    @Column(name = "ARDS_2_8_5_2")
    @JsonProperty("ARDS-2-8-5-2")
    private String ARDS_2_8_5_2; // 呼气末正压(cmH2O)
    public String getARDS_2_8_5_2() {  return this.ARDS_2_8_5_2;}
    @JsonProperty("ARDS-2-8-5-2")
    public void setARDS_2_8_5_2(final String ARDS_2_8_5_2) { this.ARDS_2_8_5_2=ARDS_2_8_5_2;}
    @Column(name = "ARDS_2_8_5_3")
    @JsonProperty("ARDS-2-8-5-3")
    private String ARDS_2_8_5_3; // 吸入氧气浓度(%)
    public String getARDS_2_8_5_3() {  return this.ARDS_2_8_5_3;}
    @JsonProperty("ARDS-2-8-5-3")
    public void setARDS_2_8_5_3(final String ARDS_2_8_5_3) { this.ARDS_2_8_5_3=ARDS_2_8_5_3;}
    @Column(name = "ARDS_2_8_5_4")
    @JsonProperty("ARDS-2-8-5-4")
    private String ARDS_2_8_5_4; // 平台压(cmH2O)
    public String getARDS_2_8_5_4() {  return this.ARDS_2_8_5_4;}
    @JsonProperty("ARDS-2-8-5-4")
    public void setARDS_2_8_5_4(final String ARDS_2_8_5_4) { this.ARDS_2_8_5_4=ARDS_2_8_5_4;}
    @Column(name = "ARDS_2_8_5_5")
    @JsonProperty("ARDS-2-8-5-5")
    private String ARDS_2_8_5_5; // 气道峰压(cmH2O)
    public String getARDS_2_8_5_5() {  return this.ARDS_2_8_5_5;}
    @JsonProperty("ARDS-2-8-5-5")
    public void setARDS_2_8_5_5(final String ARDS_2_8_5_5) { this.ARDS_2_8_5_5=ARDS_2_8_5_5;}
    @Column(name = "ARDS_2_8_6")
    @JsonProperty("ARDS-2-8-6")
    private String ARDS_2_8_6; // ECMO期间是否俯卧位
    public String getARDS_2_8_6() {  return this.ARDS_2_8_6;}
    @JsonProperty("ARDS-2-8-6")
    public void setARDS_2_8_6(final String ARDS_2_8_6) { this.ARDS_2_8_6=ARDS_2_8_6;}
    @Column(name = "ARDS_2_8_7")
    @JsonProperty("ARDS-2-8-7")
    private String ARDS_2_8_7; // 第一天俯卧位时间（小时）
    public String getARDS_2_8_7() {  return this.ARDS_2_8_7;}
    @JsonProperty("ARDS-2-8-7")
    public void setARDS_2_8_7(final String ARDS_2_8_7) { this.ARDS_2_8_7=ARDS_2_8_7;}
    @Column(name = "ARDS_2_8_8")
    @JsonProperty("ARDS-2-8-8")
    private String ARDS_2_8_8; // ECMO过程中总俯卧位通气天数(天)
    public String getARDS_2_8_8() {  return this.ARDS_2_8_8;}
    @JsonProperty("ARDS-2-8-8")
    public void setARDS_2_8_8(final String ARDS_2_8_8) { this.ARDS_2_8_8=ARDS_2_8_8;}
    @Column(name = "ARDS_2_8_9")
    @JsonProperty("ARDS-2-8-9")
    private String ARDS_2_8_9; // ECMO撤离日期时间
    public String getARDS_2_8_9() {  return this.ARDS_2_8_9;}
    @JsonProperty("ARDS-2-8-9")
    public void setARDS_2_8_9(final String ARDS_2_8_9) { this.ARDS_2_8_9=ARDS_2_8_9;}
    @Column(name = "ARDS_2_8_10")
    @JsonProperty("ARDS-2-8-10")
    private String ARDS_2_8_10; // ECMO时间（小时）
    public String getARDS_2_8_10() {  return this.ARDS_2_8_10;}
    @JsonProperty("ARDS-2-8-10")
    public void setARDS_2_8_10(final String ARDS_2_8_10) { this.ARDS_2_8_10=ARDS_2_8_10;}
    @Column(name = "ARDS_3_1_1")
    @JsonProperty("ARDS-3-1-1")
    private String ARDS_3_1_1; // 是否实施其他治疗
    public String getARDS_3_1_1() {  return this.ARDS_3_1_1;}
    @JsonProperty("ARDS-3-1-1")
    public void setARDS_3_1_1(final String ARDS_3_1_1) { this.ARDS_3_1_1=ARDS_3_1_1;}
    @Column(name = "ARDS_3_1_2")
    @JsonProperty("ARDS-3-1-2")
    private String ARDS_3_1_2; // 其他治疗措施的选择
    public String getARDS_3_1_2() {  return this.ARDS_3_1_2;}
    @JsonProperty("ARDS-3-1-2")
    public void setARDS_3_1_2(final String ARDS_3_1_2) { this.ARDS_3_1_2=ARDS_3_1_2;}
    @Column(name = "ARDS_3_2_1")
    @JsonProperty("ARDS-3-2-1")
    private String ARDS_3_2_1; // 是否镇静治疗
    public String getARDS_3_2_1() {  return this.ARDS_3_2_1;}
    @JsonProperty("ARDS-3-2-1")
    public void setARDS_3_2_1(final String ARDS_3_2_1) { this.ARDS_3_2_1=ARDS_3_2_1;}
    @Column(name = "ARDS_3_2_2")
    @JsonProperty("ARDS-3-2-2")
    private String ARDS_3_2_2; // RASS评分
    public String getARDS_3_2_2() {  return this.ARDS_3_2_2;}
    @JsonProperty("ARDS-3-2-2")
    public void setARDS_3_2_2(final String ARDS_3_2_2) { this.ARDS_3_2_2=ARDS_3_2_2;}
    @Column(name = "ARDS_3_2_3")
    @JsonProperty("ARDS-3-2-3")
    private String ARDS_3_2_3; // 常用镇静药物
    public String getARDS_3_2_3() {  return this.ARDS_3_2_3;}
    @JsonProperty("ARDS-3-2-3")
    public void setARDS_3_2_3(final String ARDS_3_2_3) { this.ARDS_3_2_3=ARDS_3_2_3;}
    @Column(name = "ARDS_3_2_3_1")
    @JsonProperty("ARDS-3-2-3-1")
    private String ARDS_3_2_3_1; // 其他镇靜药
    public String getARDS_3_2_3_1() {  return this.ARDS_3_2_3_1;}
    @JsonProperty("ARDS-3-2-3-1")
    public void setARDS_3_2_3_1(final String ARDS_3_2_3_1) { this.ARDS_3_2_3_1=ARDS_3_2_3_1;}
    @Column(name = "ARDS_3_3_1")
    @JsonProperty("ARDS-3-3-1")
    private String ARDS_3_3_1; // 是否镇痛治疗
    public String getARDS_3_3_1() {  return this.ARDS_3_3_1;}
    @JsonProperty("ARDS-3-3-1")
    public void setARDS_3_3_1(final String ARDS_3_3_1) { this.ARDS_3_3_1=ARDS_3_3_1;}
    @Column(name = "ARDS_3_3_2")
    @JsonProperty("ARDS-3-3-2")
    private String ARDS_3_3_2; // CPOT评分/NRS评分
    public String getARDS_3_3_2() {  return this.ARDS_3_3_2;}
    @JsonProperty("ARDS-3-3-2")
    public void setARDS_3_3_2(final String ARDS_3_3_2) { this.ARDS_3_3_2=ARDS_3_3_2;}
    @Column(name = "ARDS_3_3_3")
    @JsonProperty("ARDS-3-3-3")
    private String ARDS_3_3_3; // 常用镇痛药物
    public String getARDS_3_3_3() {  return this.ARDS_3_3_3;}
    @JsonProperty("ARDS-3-3-3")
    public void setARDS_3_3_3(final String ARDS_3_3_3) { this.ARDS_3_3_3=ARDS_3_3_3;}
    @Column(name = "ARDS_3_3_3_1")
    @JsonProperty("ARDS-3-3-3-1")
    private String ARDS_3_3_3_1; // 其他镇痛药
    public String getARDS_3_3_3_1() {  return this.ARDS_3_3_3_1;}
    @JsonProperty("ARDS-3-3-3-1")
    public void setARDS_3_3_3_1(final String ARDS_3_3_3_1) { this.ARDS_3_3_3_1=ARDS_3_3_3_1;}
    @Column(name = "ARDS_3_4_1")
    @JsonProperty("ARDS-3-4-1")
    private String ARDS_3_4_1; // 是否雾化治疗
    public String getARDS_3_4_1() {  return this.ARDS_3_4_1;}
    @JsonProperty("ARDS-3-4-1")
    public void setARDS_3_4_1(final String ARDS_3_4_1) { this.ARDS_3_4_1=ARDS_3_4_1;}
    @Column(name = "ARDS_3_4_2_1")
    @JsonProperty("ARDS-3-4-2-1")
    private String ARDS_3_4_2_1; // 雾化治疗使用的药物一
    public String getARDS_3_4_2_1() {  return this.ARDS_3_4_2_1;}
    @JsonProperty("ARDS-3-4-2-1")
    public void setARDS_3_4_2_1(final String ARDS_3_4_2_1) { this.ARDS_3_4_2_1=ARDS_3_4_2_1;}
    @Column(name = "ARDS_3_4_2_2")
    @JsonProperty("ARDS-3-4-2-2")
    private String ARDS_3_4_2_2; // 雾化治疗使用的药物二
    public String getARDS_3_4_2_2() {  return this.ARDS_3_4_2_2;}
    @JsonProperty("ARDS-3-4-2-2")
    public void setARDS_3_4_2_2(final String ARDS_3_4_2_2) { this.ARDS_3_4_2_2=ARDS_3_4_2_2;}
    @Column(name = "ARDS_3_4_2_3")
    @JsonProperty("ARDS-3-4-2-3")
    private String ARDS_3_4_2_3; // 雾化治疗使用的药物三
    public String getARDS_3_4_2_3() {  return this.ARDS_3_4_2_3;}
    @JsonProperty("ARDS-3-4-2-3")
    public void setARDS_3_4_2_3(final String ARDS_3_4_2_3) { this.ARDS_3_4_2_3=ARDS_3_4_2_3;}
    @Column(name = "ARDS_3_4_2_4")
    @JsonProperty("ARDS-3-4-2-4")
    private String ARDS_3_4_2_4; // 雾化治疗使用的药物四
    public String getARDS_3_4_2_4() {  return this.ARDS_3_4_2_4;}
    @JsonProperty("ARDS-3-4-2-4")
    public void setARDS_3_4_2_4(final String ARDS_3_4_2_4) { this.ARDS_3_4_2_4=ARDS_3_4_2_4;}
    @Column(name = "ARDS_3_4_3")
    @JsonProperty("ARDS-3-4-3")
    private String ARDS_3_4_3; // 采用的雾化装置
    public String getARDS_3_4_3() {  return this.ARDS_3_4_3;}
    @JsonProperty("ARDS-3-4-3")
    public void setARDS_3_4_3(final String ARDS_3_4_3) { this.ARDS_3_4_3=ARDS_3_4_3;}
    @Column(name = "ARDS_3_5_1")
    @JsonProperty("ARDS-3-5-1")
    private String ARDS_3_5_1; // 是否使用抗生素
    public String getARDS_3_5_1() {  return this.ARDS_3_5_1;}
    @JsonProperty("ARDS-3-5-1")
    public void setARDS_3_5_1(final String ARDS_3_5_1) { this.ARDS_3_5_1=ARDS_3_5_1;}
    @Column(name = "ARDS_3_5_2")
    @JsonProperty("ARDS-3-5-2")
    private String ARDS_3_5_2; // 抗生素开始使用时间
    public String getARDS_3_5_2() {  return this.ARDS_3_5_2;}
    @JsonProperty("ARDS-3-5-2")
    public void setARDS_3_5_2(final String ARDS_3_5_2) { this.ARDS_3_5_2=ARDS_3_5_2;}
    @Column(name = "ARDS_3_5_3")
    @JsonProperty("ARDS-3-5-3")
    private String ARDS_3_5_3; // 抗生素停止使用时间
    public String getARDS_3_5_3() {  return this.ARDS_3_5_3;}
    @JsonProperty("ARDS-3-5-3")
    public void setARDS_3_5_3(final String ARDS_3_5_3) { this.ARDS_3_5_3=ARDS_3_5_3;}
    @Column(name = "ARDS_3_5_5")
    @JsonProperty("ARDS-3-5-5")
    private String ARDS_3_5_5; // 抗生素药物分类选择
    public String getARDS_3_5_5() {  return this.ARDS_3_5_5;}
    @JsonProperty("ARDS-3-5-5")
    public void setARDS_3_5_5(final String ARDS_3_5_5) { this.ARDS_3_5_5=ARDS_3_5_5;}
    @Column(name = "ARDS_3_5_5_1")
    @JsonProperty("ARDS-3-5-5-1")
    private String ARDS_3_5_5_1; // 青霉素类抗感染药物
    public String getARDS_3_5_5_1() {  return this.ARDS_3_5_5_1;}
    @JsonProperty("ARDS-3-5-5-1")
    public void setARDS_3_5_5_1(final String ARDS_3_5_5_1) { this.ARDS_3_5_5_1=ARDS_3_5_5_1;}
    @Column(name = "ARDS_3_5_5_2")
    @JsonProperty("ARDS-3-5-5-2")
    private String ARDS_3_5_5_2; // 其他青霉素类抗菌药
    public String getARDS_3_5_5_2() {  return this.ARDS_3_5_5_2;}
    @JsonProperty("ARDS-3-5-5-2")
    public void setARDS_3_5_5_2(final String ARDS_3_5_5_2) { this.ARDS_3_5_5_2=ARDS_3_5_5_2;}
    @Column(name = "ARDS_3_5_5_3")
    @JsonProperty("ARDS-3-5-5-3")
    private String ARDS_3_5_5_3; // 头孢菌素类抗感染药物
    public String getARDS_3_5_5_3() {  return this.ARDS_3_5_5_3;}
    @JsonProperty("ARDS-3-5-5-3")
    public void setARDS_3_5_5_3(final String ARDS_3_5_5_3) { this.ARDS_3_5_5_3=ARDS_3_5_5_3;}
    @Column(name = "ARDS_3_5_5_4")
    @JsonProperty("ARDS-3-5-5-4")
    private String ARDS_3_5_5_4; // 其他头孢菌素类抗菌药
    public String getARDS_3_5_5_4() {  return this.ARDS_3_5_5_4;}
    @JsonProperty("ARDS-3-5-5-4")
    public void setARDS_3_5_5_4(final String ARDS_3_5_5_4) { this.ARDS_3_5_5_4=ARDS_3_5_5_4;}
    @Column(name = "ARDS_3_5_5_5")
    @JsonProperty("ARDS-3-5-5-5")
    private String ARDS_3_5_5_5; // 大环内酯类抗感染药物
    public String getARDS_3_5_5_5() {  return this.ARDS_3_5_5_5;}
    @JsonProperty("ARDS-3-5-5-5")
    public void setARDS_3_5_5_5(final String ARDS_3_5_5_5) { this.ARDS_3_5_5_5=ARDS_3_5_5_5;}
    @Column(name = "ARDS_3_5_5_6")
    @JsonProperty("ARDS-3-5-5-6")
    private String ARDS_3_5_5_6; // 其他大环内酯类抗菌药
    public String getARDS_3_5_5_6() {  return this.ARDS_3_5_5_6;}
    @JsonProperty("ARDS-3-5-5-6")
    public void setARDS_3_5_5_6(final String ARDS_3_5_5_6) { this.ARDS_3_5_5_6=ARDS_3_5_5_6;}
    @Column(name = "ARDS_3_5_5_7")
    @JsonProperty("ARDS-3-5-5-7")
    private String ARDS_3_5_5_7; // 喹诺酮类抗感染药物
    public String getARDS_3_5_5_7() {  return this.ARDS_3_5_5_7;}
    @JsonProperty("ARDS-3-5-5-7")
    public void setARDS_3_5_5_7(final String ARDS_3_5_5_7) { this.ARDS_3_5_5_7=ARDS_3_5_5_7;}
    @Column(name = "ARDS_3_5_5_8")
    @JsonProperty("ARDS-3-5-5-8")
    private String ARDS_3_5_5_8; // 其他-喹诺酮类抗菌药
    public String getARDS_3_5_5_8() {  return this.ARDS_3_5_5_8;}
    @JsonProperty("ARDS-3-5-5-8")
    public void setARDS_3_5_5_8(final String ARDS_3_5_5_8) { this.ARDS_3_5_5_8=ARDS_3_5_5_8;}
    @Column(name = "ARDS_3_5_5_9")
    @JsonProperty("ARDS-3-5-5-9")
    private String ARDS_3_5_5_9; // 其他类抗感染药物
    public String getARDS_3_5_5_9() {  return this.ARDS_3_5_5_9;}
    @JsonProperty("ARDS-3-5-5-9")
    public void setARDS_3_5_5_9(final String ARDS_3_5_5_9) { this.ARDS_3_5_5_9=ARDS_3_5_5_9;}
    @Column(name = "ARDS_3_5_5_10")
    @JsonProperty("ARDS-3-5-5-10")
    private String ARDS_3_5_5_10; // 其他抗菌药
    public String getARDS_3_5_5_10() {  return this.ARDS_3_5_5_10;}
    @JsonProperty("ARDS-3-5-5-10")
    public void setARDS_3_5_5_10(final String ARDS_3_5_5_10) { this.ARDS_3_5_5_10=ARDS_3_5_5_10;}
    @Column(name = "ARDS_3_6_1")
    @JsonProperty("ARDS-3-6-1")
    private String ARDS_3_6_1; // 是否抑酸治疗
    public String getARDS_3_6_1() {  return this.ARDS_3_6_1;}
    @JsonProperty("ARDS-3-6-1")
    public void setARDS_3_6_1(final String ARDS_3_6_1) { this.ARDS_3_6_1=ARDS_3_6_1;}
    @Column(name = "ARDS_3_7_1")
    @JsonProperty("ARDS-3-7-1")
    private String ARDS_3_7_1; // 诊断ARDS后是否使用激素
    public String getARDS_3_7_1() {  return this.ARDS_3_7_1;}
    @JsonProperty("ARDS-3-7-1")
    public void setARDS_3_7_1(final String ARDS_3_7_1) { this.ARDS_3_7_1=ARDS_3_7_1;}
    @Column(name = "ARDS_3_7_2")
    @JsonProperty("ARDS-3-7-2")
    private String ARDS_3_7_2; // 激素开始使用时间
    public String getARDS_3_7_2() {  return this.ARDS_3_7_2;}
    @JsonProperty("ARDS-3-7-2")
    public void setARDS_3_7_2(final String ARDS_3_7_2) { this.ARDS_3_7_2=ARDS_3_7_2;}
    @Column(name = "ARDS_3_7_3")
    @JsonProperty("ARDS-3-7-3")
    private String ARDS_3_7_3; // 激素停止使用时间
    public String getARDS_3_7_3() {  return this.ARDS_3_7_3;}
    @JsonProperty("ARDS-3-7-3")
    public void setARDS_3_7_3(final String ARDS_3_7_3) { this.ARDS_3_7_3=ARDS_3_7_3;}
    @Column(name = "ARDS_3_7_5")
    @JsonProperty("ARDS-3-7-5")
    private String ARDS_3_7_5; // 激素药物选择
    public String getARDS_3_7_5() {  return this.ARDS_3_7_5;}
    @JsonProperty("ARDS-3-7-5")
    public void setARDS_3_7_5(final String ARDS_3_7_5) { this.ARDS_3_7_5=ARDS_3_7_5;}
    @Column(name = "ARDS_3_7_4")
    @JsonProperty("ARDS-3-7-4")
    private String ARDS_3_7_4; // 激素总剂量(mg)
    public String getARDS_3_7_4() {  return this.ARDS_3_7_4;}
    @JsonProperty("ARDS-3-7-4")
    public void setARDS_3_7_4(final String ARDS_3_7_4) { this.ARDS_3_7_4=ARDS_3_7_4;}
    @Column(name = "ARDS_3_7_6")
    @JsonProperty("ARDS-3-7-6")
    private String ARDS_3_7_6; // 甲基强的松龙等效剂量
    public String getARDS_3_7_6() {  return this.ARDS_3_7_6;}
    @JsonProperty("ARDS-3-7-6")
    public void setARDS_3_7_6(final String ARDS_3_7_6) { this.ARDS_3_7_6=ARDS_3_7_6;}
    @Column(name = "ARDS_3_7_5_1")
    @JsonProperty("ARDS-3-7-5-1")
    private String ARDS_3_7_5_1; // 甲基强的松龙
    public String getARDS_3_7_5_1() {  return this.ARDS_3_7_5_1;}
    @JsonProperty("ARDS-3-7-5-1")
    public void setARDS_3_7_5_1(final String ARDS_3_7_5_1) { this.ARDS_3_7_5_1=ARDS_3_7_5_1;}
    @Column(name = "ARDS_3_7_5_2")
    @JsonProperty("ARDS-3-7-5-2")
    private String ARDS_3_7_5_2; // 可的松
    public String getARDS_3_7_5_2() {  return this.ARDS_3_7_5_2;}
    @JsonProperty("ARDS-3-7-5-2")
    public void setARDS_3_7_5_2(final String ARDS_3_7_5_2) { this.ARDS_3_7_5_2=ARDS_3_7_5_2;}
    @Column(name = "ARDS_3_7_5_3")
    @JsonProperty("ARDS-3-7-5-3")
    private String ARDS_3_7_5_3; // 氢化可的松
    public String getARDS_3_7_5_3() {  return this.ARDS_3_7_5_3;}
    @JsonProperty("ARDS-3-7-5-3")
    public void setARDS_3_7_5_3(final String ARDS_3_7_5_3) { this.ARDS_3_7_5_3=ARDS_3_7_5_3;}
    @Column(name = "ARDS_3_7_5_4")
    @JsonProperty("ARDS-3-7-5-4")
    private String ARDS_3_7_5_4; // 强的松
    public String getARDS_3_7_5_4() {  return this.ARDS_3_7_5_4;}
    @JsonProperty("ARDS-3-7-5-4")
    public void setARDS_3_7_5_4(final String ARDS_3_7_5_4) { this.ARDS_3_7_5_4=ARDS_3_7_5_4;}
    @Column(name = "ARDS_3_7_5_5")
    @JsonProperty("ARDS-3-7-5-5")
    private String ARDS_3_7_5_5; // 强的松龙
    public String getARDS_3_7_5_5() {  return this.ARDS_3_7_5_5;}
    @JsonProperty("ARDS-3-7-5-5")
    public void setARDS_3_7_5_5(final String ARDS_3_7_5_5) { this.ARDS_3_7_5_5=ARDS_3_7_5_5;}
    @Column(name = "ARDS_3_7_5_6")
    @JsonProperty("ARDS-3-7-5-6")
    private String ARDS_3_7_5_6; // 地塞米松
    public String getARDS_3_7_5_6() {  return this.ARDS_3_7_5_6;}
    @JsonProperty("ARDS-3-7-5-6")
    public void setARDS_3_7_5_6(final String ARDS_3_7_5_6) { this.ARDS_3_7_5_6=ARDS_3_7_5_6;}
    @Column(name = "ARDS_3_8_1")
    @JsonProperty("ARDS-3-8-1")
    private String ARDS_3_8_1; // 是否使用肌松剂
    public String getARDS_3_8_1() {  return this.ARDS_3_8_1;}
    @JsonProperty("ARDS-3-8-1")
    public void setARDS_3_8_1(final String ARDS_3_8_1) { this.ARDS_3_8_1=ARDS_3_8_1;}
    @Column(name = "ARDS_3_8_2")
    @JsonProperty("ARDS-3-8-2")
    private String ARDS_3_8_2; // 使用肌松剂名称
    public String getARDS_3_8_2() {  return this.ARDS_3_8_2;}
    @JsonProperty("ARDS-3-8-2")
    public void setARDS_3_8_2(final String ARDS_3_8_2) { this.ARDS_3_8_2=ARDS_3_8_2;}
    @Column(name = "ARDS_3_8_2_1")
    @JsonProperty("ARDS-3-8-2-1")
    private String ARDS_3_8_2_1; // 其他肌松药
    public String getARDS_3_8_2_1() {  return this.ARDS_3_8_2_1;}
    @JsonProperty("ARDS-3-8-2-1")
    public void setARDS_3_8_2_1(final String ARDS_3_8_2_1) { this.ARDS_3_8_2_1=ARDS_3_8_2_1;}
    @Column(name = "ARDS_3_8_3")
    @JsonProperty("ARDS-3-8-3")
    private String ARDS_3_8_3; // 肌松剂开始时间
    public String getARDS_3_8_3() {  return this.ARDS_3_8_3;}
    @JsonProperty("ARDS-3-8-3")
    public void setARDS_3_8_3(final String ARDS_3_8_3) { this.ARDS_3_8_3=ARDS_3_8_3;}
    @Column(name = "ARDS_3_8_4")
    @JsonProperty("ARDS-3-8-4")
    private String ARDS_3_8_4; // 肌松剂停止时间
    public String getARDS_3_8_4() {  return this.ARDS_3_8_4;}
    @JsonProperty("ARDS-3-8-4")
    public void setARDS_3_8_4(final String ARDS_3_8_4) { this.ARDS_3_8_4=ARDS_3_8_4;}
    @Column(name = "ARDS_3_9_1")
    @JsonProperty("ARDS-3-9-1")
    private String ARDS_3_9_1; // 是否使用血管活性药物
    public String getARDS_3_9_1() {  return this.ARDS_3_9_1;}
    @JsonProperty("ARDS-3-9-1")
    public void setARDS_3_9_1(final String ARDS_3_9_1) { this.ARDS_3_9_1=ARDS_3_9_1;}
    @Column(name = "ARDS_3_9_2")
    @JsonProperty("ARDS-3-9-2")
    private String ARDS_3_9_2; // 血管活性药物的选择
    public String getARDS_3_9_2() {  return this.ARDS_3_9_2;}
    @JsonProperty("ARDS-3-9-2")
    public void setARDS_3_9_2(final String ARDS_3_9_2) { this.ARDS_3_9_2=ARDS_3_9_2;}
    @Column(name = "ARDS_3_9_2_1")
    @JsonProperty("ARDS-3-9-2-1")
    private String ARDS_3_9_2_1; // 其他血管活性药物
    public String getARDS_3_9_2_1() {  return this.ARDS_3_9_2_1;}
    @JsonProperty("ARDS-3-9-2-1")
    public void setARDS_3_9_2_1(final String ARDS_3_9_2_1) { this.ARDS_3_9_2_1=ARDS_3_9_2_1;}
    @Column(name = "ARDS_3_9_3")
    @JsonProperty("ARDS-3-9-3")
    private String ARDS_3_9_3; // 血管活性药开始时间
    public String getARDS_3_9_3() {  return this.ARDS_3_9_3;}
    @JsonProperty("ARDS-3-9-3")
    public void setARDS_3_9_3(final String ARDS_3_9_3) { this.ARDS_3_9_3=ARDS_3_9_3;}
    @Column(name = "ARDS_3_9_4")
    @JsonProperty("ARDS-3-9-4")
    private String ARDS_3_9_4; // 血管活性药停止时间
    public String getARDS_3_9_4() {  return this.ARDS_3_9_4;}
    @JsonProperty("ARDS-3-9-4")
    public void setARDS_3_9_4(final String ARDS_3_9_4) { this.ARDS_3_9_4=ARDS_3_9_4;}
    @Column(name = "ARDS_3_9_5")
    @JsonProperty("ARDS-3-9-5")
    private String ARDS_3_9_5; // 最高血管活性药物评分（VIS）
    public String getARDS_3_9_5() {  return this.ARDS_3_9_5;}
    @JsonProperty("ARDS-3-9-5")
    public void setARDS_3_9_5(final String ARDS_3_9_5) { this.ARDS_3_9_5=ARDS_3_9_5;}
    @Column(name = "ARDS_3_10_1")
    @JsonProperty("ARDS-3-10-1")
    private String ARDS_3_10_1; // 是否使用CRRT
    public String getARDS_3_10_1() {  return this.ARDS_3_10_1;}
    @JsonProperty("ARDS-3-10-1")
    public void setARDS_3_10_1(final String ARDS_3_10_1) { this.ARDS_3_10_1=ARDS_3_10_1;}
    @Column(name = "ARDS_3_10_2")
    @JsonProperty("ARDS-3-10-2")
    private String ARDS_3_10_2; // CRRT开始时间
    public String getARDS_3_10_2() {  return this.ARDS_3_10_2;}
    @JsonProperty("ARDS-3-10-2")
    public void setARDS_3_10_2(final String ARDS_3_10_2) { this.ARDS_3_10_2=ARDS_3_10_2;}
    @Column(name = "ARDS_3_10_3")
    @JsonProperty("ARDS-3-10-3")
    private String ARDS_3_10_3; // CRRT停止时间
    public String getARDS_3_10_3() {  return this.ARDS_3_10_3;}
    @JsonProperty("ARDS-3-10-3")
    public void setARDS_3_10_3(final String ARDS_3_10_3) { this.ARDS_3_10_3=ARDS_3_10_3;}
    @Column(name = "ARDS_3_11_1")
    @JsonProperty("ARDS-3-11-1")
    private String ARDS_3_11_1; // 是否抗凝治疗
    public String getARDS_3_11_1() {  return this.ARDS_3_11_1;}
    @JsonProperty("ARDS-3-11-1")
    public void setARDS_3_11_1(final String ARDS_3_11_1) { this.ARDS_3_11_1=ARDS_3_11_1;}
    @Column(name = "ARDS_4_1_1")
    @JsonProperty("ARDS-4-1-1")
    private String ARDS_4_1_1; // 患者生存或者死亡
    public String getARDS_4_1_1() {  return this.ARDS_4_1_1;}
    @JsonProperty("ARDS-4-1-1")
    public void setARDS_4_1_1(final String ARDS_4_1_1) { this.ARDS_4_1_1=ARDS_4_1_1;}
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