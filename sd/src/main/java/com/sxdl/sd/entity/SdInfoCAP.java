package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：J13 至 J16，J18；年龄≥18 岁的出院患者。
*/
@ApiModel(value = "18信息")
@Entity
@Table(name = "sd_info_CAP")
public class SdInfoCAP implements Serializable {
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
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "CM_0_1_4_3")
    @JsonProperty("CM-0-1-4-3")
    private String CM_0_1_4_3; // 其他主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_3() {  return this.CM_0_1_4_3;}
    @JsonProperty("CM-0-1-4-3")
    public void setCM_0_1_4_3(final String CM_0_1_4_3) { this.CM_0_1_4_3=CM_0_1_4_3;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 肺炎出院后是否31天内重复住院
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
    @Column(name = "Cap_Adult_1_3_1")
    @JsonProperty("Cap-Adult-1-3-1")
    private String Cap_Adult_1_3_1; // 是否社区发病
    public String getCap_Adult_1_3_1() {  return this.Cap_Adult_1_3_1;}
    @JsonProperty("Cap-Adult-1-3-1")
    public void setCap_Adult_1_3_1(final String Cap_Adult_1_3_1) { this.Cap_Adult_1_3_1=Cap_Adult_1_3_1;}
    @Column(name = "Cap_Adult_1_3_2")
    @JsonProperty("Cap-Adult-1-3-2")
    private String Cap_Adult_1_3_2; // 肺炎相关临床表现
    public String getCap_Adult_1_3_2() {  return this.Cap_Adult_1_3_2;}
    @JsonProperty("Cap-Adult-1-3-2")
    public void setCap_Adult_1_3_2(final String Cap_Adult_1_3_2) { this.Cap_Adult_1_3_2=Cap_Adult_1_3_2;}
    @Column(name = "Cap_Adult_1_3_3")
    @JsonProperty("Cap-Adult-1-3-3")
    private String Cap_Adult_1_3_3; // 是否有胸部影像学检查<br>注:胸片或者胸部CT
    public String getCap_Adult_1_3_3() {  return this.Cap_Adult_1_3_3;}
    @JsonProperty("Cap-Adult-1-3-3")
    public void setCap_Adult_1_3_3(final String Cap_Adult_1_3_3) { this.Cap_Adult_1_3_3=Cap_Adult_1_3_3;}
    @Column(name = "Cap_Adult_1_3_4")
    @JsonProperty("Cap-Adult-1-3-4")
    private String Cap_Adult_1_3_4; // 胸部影像学检查
    public String getCap_Adult_1_3_4() {  return this.Cap_Adult_1_3_4;}
    @JsonProperty("Cap-Adult-1-3-4")
    public void setCap_Adult_1_3_4(final String Cap_Adult_1_3_4) { this.Cap_Adult_1_3_4=Cap_Adult_1_3_4;}
    @Column(name = "Cap_Adult_1_3_5")
    @JsonProperty("Cap-Adult-1-3-5")
    private String Cap_Adult_1_3_5; // 影像学检查信息
    public String getCap_Adult_1_3_5() {  return this.Cap_Adult_1_3_5;}
    @JsonProperty("Cap-Adult-1-3-5")
    public void setCap_Adult_1_3_5(final String Cap_Adult_1_3_5) { this.Cap_Adult_1_3_5=Cap_Adult_1_3_5;}
    @Column(name = "Cap_Adult_1_1")
    @JsonProperty("Cap-Adult-1-1")
    private String Cap_Adult_1_1; // 是否实施CAP病情严重程度的评价
    public String getCap_Adult_1_1() {  return this.Cap_Adult_1_1;}
    @JsonProperty("Cap-Adult-1-1")
    public void setCap_Adult_1_1(final String Cap_Adult_1_1) { this.Cap_Adult_1_1=Cap_Adult_1_1;}
    @Column(name = "Cap_Adult_1")
    @JsonProperty("Cap-Adult-1")
    private String Cap_Adult_1; // 病情严重程度的评价
    public String getCap_Adult_1() {  return this.Cap_Adult_1;}
    @JsonProperty("Cap-Adult-1")
    public void setCap_Adult_1(final String Cap_Adult_1) { this.Cap_Adult_1=Cap_Adult_1;}
    @Column(name = "Cap_Adult_1_1_1")
    @JsonProperty("Cap-Adult-1-1-1")
    private String Cap_Adult_1_1_1; // CURB-65评分数值（首选）
    public String getCap_Adult_1_1_1() {  return this.Cap_Adult_1_1_1;}
    @JsonProperty("Cap-Adult-1-1-1")
    public void setCap_Adult_1_1_1(final String Cap_Adult_1_1_1) { this.Cap_Adult_1_1_1=Cap_Adult_1_1_1;}
    @Column(name = "Cap_Adult_1_1_1_1")
    @JsonProperty("Cap-Adult-1-1-1-1")
    private String Cap_Adult_1_1_1_1; // 风险程度评估
    public String getCap_Adult_1_1_1_1() {  return this.Cap_Adult_1_1_1_1;}
    @JsonProperty("Cap-Adult-1-1-1-1")
    public void setCap_Adult_1_1_1_1(final String Cap_Adult_1_1_1_1) { this.Cap_Adult_1_1_1_1=Cap_Adult_1_1_1_1;}
    @Column(name = "Cap_Adult_1_1_2")
    @JsonProperty("Cap-Adult-1-1-2")
    private String Cap_Adult_1_1_2; // 首次PSI评分数值
    public String getCap_Adult_1_1_2() {  return this.Cap_Adult_1_1_2;}
    @JsonProperty("Cap-Adult-1-1-2")
    public void setCap_Adult_1_1_2(final String Cap_Adult_1_1_2) { this.Cap_Adult_1_1_2=Cap_Adult_1_1_2;}
    @Column(name = "Cap_Adult_1_1_2_1")
    @JsonProperty("Cap-Adult-1-1-2-1")
    private String Cap_Adult_1_1_2_1; // 风险程度评估
    public String getCap_Adult_1_1_2_1() {  return this.Cap_Adult_1_1_2_1;}
    @JsonProperty("Cap-Adult-1-1-2-1")
    public void setCap_Adult_1_1_2_1(final String Cap_Adult_1_1_2_1) { this.Cap_Adult_1_1_2_1=Cap_Adult_1_1_2_1;}
    @Column(name = "Cap_Adult_1_1_3")
    @JsonProperty("Cap-Adult-1-1-3")
    private String Cap_Adult_1_1_3; // CRB-65 评分数值
    public String getCap_Adult_1_1_3() {  return this.Cap_Adult_1_1_3;}
    @JsonProperty("Cap-Adult-1-1-3")
    public void setCap_Adult_1_1_3(final String Cap_Adult_1_1_3) { this.Cap_Adult_1_1_3=Cap_Adult_1_1_3;}
    @Column(name = "Cap_Adult_1_1_3_1")
    @JsonProperty("Cap-Adult-1-1-3-1")
    private String Cap_Adult_1_1_3_1; // 风险程度评估
    public String getCap_Adult_1_1_3_1() {  return this.Cap_Adult_1_1_3_1;}
    @JsonProperty("Cap-Adult-1-1-3-1")
    public void setCap_Adult_1_1_3_1(final String Cap_Adult_1_1_3_1) { this.Cap_Adult_1_1_3_1=Cap_Adult_1_1_3_1;}
    @Column(name = "Cap_Adult_1_1_4")
    @JsonProperty("Cap-Adult-1-1-4")
    private String Cap_Adult_1_1_4; // SMART-COP评分数值
    public String getCap_Adult_1_1_4() {  return this.Cap_Adult_1_1_4;}
    @JsonProperty("Cap-Adult-1-1-4")
    public void setCap_Adult_1_1_4(final String Cap_Adult_1_1_4) { this.Cap_Adult_1_1_4=Cap_Adult_1_1_4;}
    @Column(name = "Cap_Adult_1_1_4_1")
    @JsonProperty("Cap-Adult-1-1-4-1")
    private String Cap_Adult_1_1_4_1; // 风险程度评估
    public String getCap_Adult_1_1_4_1() {  return this.Cap_Adult_1_1_4_1;}
    @JsonProperty("Cap-Adult-1-1-4-1")
    public void setCap_Adult_1_1_4_1(final String Cap_Adult_1_1_4_1) { this.Cap_Adult_1_1_4_1=Cap_Adult_1_1_4_1;}
    @Column(name = "Cap_Adult_1_2_1")
    @JsonProperty("Cap-Adult-1-2-1")
    private String Cap_Adult_1_2_1; // 是否重症肺炎诊断
    public String getCap_Adult_1_2_1() {  return this.Cap_Adult_1_2_1;}
    @JsonProperty("Cap-Adult-1-2-1")
    public void setCap_Adult_1_2_1(final String Cap_Adult_1_2_1) { this.Cap_Adult_1_2_1=Cap_Adult_1_2_1;}
    @Column(name = "Cap_Adult_1_2_4")
    @JsonProperty("Cap-Adult-1-2-4")
    private String Cap_Adult_1_2_4; // 重症肺炎诊断标准 选项
    public String getCap_Adult_1_2_4() {  return this.Cap_Adult_1_2_4;}
    @JsonProperty("Cap-Adult-1-2-4")
    public void setCap_Adult_1_2_4(final String Cap_Adult_1_2_4) { this.Cap_Adult_1_2_4=Cap_Adult_1_2_4;}
    @Column(name = "Cap_Adult_1_2_2")
    @JsonProperty("Cap-Adult-1-2-2")
    private String Cap_Adult_1_2_2; // 重症肺炎诊断主要标准
    public String getCap_Adult_1_2_2() {  return this.Cap_Adult_1_2_2;}
    @JsonProperty("Cap-Adult-1-2-2")
    public void setCap_Adult_1_2_2(final String Cap_Adult_1_2_2) { this.Cap_Adult_1_2_2=Cap_Adult_1_2_2;}
    @Column(name = "Cap_Adult_1_2_3")
    @JsonProperty("Cap-Adult-1-2-3")
    private String Cap_Adult_1_2_3; // 重症肺炎诊断次要标准
    public String getCap_Adult_1_2_3() {  return this.Cap_Adult_1_2_3;}
    @JsonProperty("Cap-Adult-1-2-3")
    public void setCap_Adult_1_2_3(final String Cap_Adult_1_2_3) { this.Cap_Adult_1_2_3=Cap_Adult_1_2_3;}
    @Column(name = "Cap_Adult_1_4_1")
    @JsonProperty("Cap-Adult-1-4-1")
    private String Cap_Adult_1_4_1; // 是否入住ICU
    public String getCap_Adult_1_4_1() {  return this.Cap_Adult_1_4_1;}
    @JsonProperty("Cap-Adult-1-4-1")
    public void setCap_Adult_1_4_1(final String Cap_Adult_1_4_1) { this.Cap_Adult_1_4_1=Cap_Adult_1_4_1;}
    @Column(name = "Cap_Adult_1_4_2")
    @JsonProperty("Cap-Adult-1-4-2")
    private String Cap_Adult_1_4_2; // 入住ICU时机
    public String getCap_Adult_1_4_2() {  return this.Cap_Adult_1_4_2;}
    @JsonProperty("Cap-Adult-1-4-2")
    public void setCap_Adult_1_4_2(final String Cap_Adult_1_4_2) { this.Cap_Adult_1_4_2=Cap_Adult_1_4_2;}
    @Column(name = "Cap_Adult_1_4_3")
    @JsonProperty("Cap-Adult-1-4-3")
    private String Cap_Adult_1_4_3; // 转入ICU时间
    public String getCap_Adult_1_4_3() {  return this.Cap_Adult_1_4_3;}
    @JsonProperty("Cap-Adult-1-4-3")
    public void setCap_Adult_1_4_3(final String Cap_Adult_1_4_3) { this.Cap_Adult_1_4_3=Cap_Adult_1_4_3;}
    @Column(name = "Cap_Adult_2_1")
    @JsonProperty("Cap-Adult-2-1")
    private String Cap_Adult_2_1; // 是否实施首次氧合评估（首次）
    public String getCap_Adult_2_1() {  return this.Cap_Adult_2_1;}
    @JsonProperty("Cap-Adult-2-1")
    public void setCap_Adult_2_1(final String Cap_Adult_2_1) { this.Cap_Adult_2_1=Cap_Adult_2_1;}
    @Column(name = "Cap_Adult_2_2")
    @JsonProperty("Cap-Adult-2-2")
    private String Cap_Adult_2_2; // 实施首次氧合评估时段
    public String getCap_Adult_2_2() {  return this.Cap_Adult_2_2;}
    @JsonProperty("Cap-Adult-2-2")
    public void setCap_Adult_2_2(final String Cap_Adult_2_2) { this.Cap_Adult_2_2=Cap_Adult_2_2;}
    @Column(name = "Cap_Adult_2_3")
    @JsonProperty("Cap-Adult-2-3")
    private String Cap_Adult_2_3; // 实施首次氧合评估时是否吸氧（FiO2）
    public String getCap_Adult_2_3() {  return this.Cap_Adult_2_3;}
    @JsonProperty("Cap-Adult-2-3")
    public void setCap_Adult_2_3(final String Cap_Adult_2_3) { this.Cap_Adult_2_3=Cap_Adult_2_3;}
    @Column(name = "Cap_Adult_2_3_1")
    @JsonProperty("Cap-Adult-2-3-1")
    private String Cap_Adult_2_3_1; // 氧合评估时的吸氧浓度(%)
    public String getCap_Adult_2_3_1() {  return this.Cap_Adult_2_3_1;}
    @JsonProperty("Cap-Adult-2-3-1")
    public void setCap_Adult_2_3_1(final String Cap_Adult_2_3_1) { this.Cap_Adult_2_3_1=Cap_Adult_2_3_1;}
    @Column(name = "Cap_Adult_2_4")
    @JsonProperty("Cap-Adult-2-4")
    private String Cap_Adult_2_4; // 动脉血气分析/指氧仪检查
    public String getCap_Adult_2_4() {  return this.Cap_Adult_2_4;}
    @JsonProperty("Cap-Adult-2-4")
    public void setCap_Adult_2_4(final String Cap_Adult_2_4) { this.Cap_Adult_2_4=Cap_Adult_2_4;}
    @Column(name = "Cap_Adult_2_4_5")
    @JsonProperty("Cap-Adult-2-4-5")
    private String Cap_Adult_2_4_5; // 动脉氧分压 PaO₂(mmHg)
    public String getCap_Adult_2_4_5() {  return this.Cap_Adult_2_4_5;}
    @JsonProperty("Cap-Adult-2-4-5")
    public void setCap_Adult_2_4_5(final String Cap_Adult_2_4_5) { this.Cap_Adult_2_4_5=Cap_Adult_2_4_5;}
    @Column(name = "Cap_Adult_2_4_6")
    @JsonProperty("Cap-Adult-2-4-6")
    private String Cap_Adult_2_4_6; // 动脉二氧化碳分压 PaCO₂(mmHg)
    public String getCap_Adult_2_4_6() {  return this.Cap_Adult_2_4_6;}
    @JsonProperty("Cap-Adult-2-4-6")
    public void setCap_Adult_2_4_6(final String Cap_Adult_2_4_6) { this.Cap_Adult_2_4_6=Cap_Adult_2_4_6;}
    @Column(name = "Cap_Adult_2_4_7")
    @JsonProperty("Cap-Adult-2-4-7")
    private String Cap_Adult_2_4_7; // 酸碱度 PH
    public String getCap_Adult_2_4_7() {  return this.Cap_Adult_2_4_7;}
    @JsonProperty("Cap-Adult-2-4-7")
    public void setCap_Adult_2_4_7(final String Cap_Adult_2_4_7) { this.Cap_Adult_2_4_7=Cap_Adult_2_4_7;}
    @Column(name = "Cap_Adult_2_4_8")
    @JsonProperty("Cap-Adult-2-4-8")
    private String Cap_Adult_2_4_8; // 标准剩余碱 SBE
    public String getCap_Adult_2_4_8() {  return this.Cap_Adult_2_4_8;}
    @JsonProperty("Cap-Adult-2-4-8")
    public void setCap_Adult_2_4_8(final String Cap_Adult_2_4_8) { this.Cap_Adult_2_4_8=Cap_Adult_2_4_8;}
    @Column(name = "Cap_Adult_2_4_9")
    @JsonProperty("Cap-Adult-2-4-9")
    private String Cap_Adult_2_4_9; // 氧合指数 (mmHg)
    public String getCap_Adult_2_4_9() {  return this.Cap_Adult_2_4_9;}
    @JsonProperty("Cap-Adult-2-4-9")
    public void setCap_Adult_2_4_9(final String Cap_Adult_2_4_9) { this.Cap_Adult_2_4_9=Cap_Adult_2_4_9;}
    @Column(name = "Cap_Adult_2_4_4")
    @JsonProperty("Cap-Adult-2-4-4")
    private String Cap_Adult_2_4_4; // 指氧仪检查 SpO₂（%）
    public String getCap_Adult_2_4_4() {  return this.Cap_Adult_2_4_4;}
    @JsonProperty("Cap-Adult-2-4-4")
    public void setCap_Adult_2_4_4(final String Cap_Adult_2_4_4) { this.Cap_Adult_2_4_4=Cap_Adult_2_4_4;}
    @Column(name = "Cap_Adult_3_1_1")
    @JsonProperty("Cap-Adult-3-1-1")
    private String Cap_Adult_3_1_1; // 住院的患者, 是否首次采集标本
    public String getCap_Adult_3_1_1() {  return this.Cap_Adult_3_1_1;}
    @JsonProperty("Cap-Adult-3-1-1")
    public void setCap_Adult_3_1_1(final String Cap_Adult_3_1_1) { this.Cap_Adult_3_1_1=Cap_Adult_3_1_1;}
    @Column(name = "Cap_Adult_3_1_4")
    @JsonProperty("Cap-Adult-3-1-4")
    private String Cap_Adult_3_1_4; // 实施首次采集标本时段
    public String getCap_Adult_3_1_4() {  return this.Cap_Adult_3_1_4;}
    @JsonProperty("Cap-Adult-3-1-4")
    public void setCap_Adult_3_1_4(final String Cap_Adult_3_1_4) { this.Cap_Adult_3_1_4=Cap_Adult_3_1_4;}
    @Column(name = "Cap_Adult_3_1_2")
    @JsonProperty("Cap-Adult-3-1-2")
    private String Cap_Adult_3_1_2; // 实施首次采集标本时段
    public String getCap_Adult_3_1_2() {  return this.Cap_Adult_3_1_2;}
    @JsonProperty("Cap-Adult-3-1-2")
    public void setCap_Adult_3_1_2(final String Cap_Adult_3_1_2) { this.Cap_Adult_3_1_2=Cap_Adult_3_1_2;}
    @Column(name = "Cap_Adult_3_1_3")
    @JsonProperty("Cap-Adult-3-1-3")
    private String Cap_Adult_3_1_3; // 实施首次采集什么标本
    public String getCap_Adult_3_1_3() {  return this.Cap_Adult_3_1_3;}
    @JsonProperty("Cap-Adult-3-1-3")
    public void setCap_Adult_3_1_3(final String Cap_Adult_3_1_3) { this.Cap_Adult_3_1_3=Cap_Adult_3_1_3;}
    @Column(name = "Cap_Adult_3_1_3_1")
    @JsonProperty("Cap-Adult-3-1-3-1")
    private String Cap_Adult_3_1_3_1; // 其他首次采集标本
    public String getCap_Adult_3_1_3_1() {  return this.Cap_Adult_3_1_3_1;}
    @JsonProperty("Cap-Adult-3-1-3-1")
    public void setCap_Adult_3_1_3_1(final String Cap_Adult_3_1_3_1) { this.Cap_Adult_3_1_3_1=Cap_Adult_3_1_3_1;}
    @Column(name = "Cap_Adult_3_2_1")
    @JsonProperty("Cap-Adult-3-2-1")
    private String Cap_Adult_3_2_1; // 是否 CAP伴有特定临床情况
    public String getCap_Adult_3_2_1() {  return this.Cap_Adult_3_2_1;}
    @JsonProperty("Cap-Adult-3-2-1")
    public void setCap_Adult_3_2_1(final String Cap_Adult_3_2_1) { this.Cap_Adult_3_2_1=Cap_Adult_3_2_1;}
    @Column(name = "Cap_Adult_3_2_2")
    @JsonProperty("Cap-Adult-3-2-2")
    private String Cap_Adult_3_2_2; // 特定临床情况选项
    public String getCap_Adult_3_2_2() {  return this.Cap_Adult_3_2_2;}
    @JsonProperty("Cap-Adult-3-2-2")
    public void setCap_Adult_3_2_2(final String Cap_Adult_3_2_2) { this.Cap_Adult_3_2_2=Cap_Adult_3_2_2;}
    @Column(name = "Cap_Adult_3_2_3")
    @JsonProperty("Cap-Adult-3-2-3")
    private String Cap_Adult_3_2_3; // 特殊影像学表现
    public String getCap_Adult_3_2_3() {  return this.Cap_Adult_3_2_3;}
    @JsonProperty("Cap-Adult-3-2-3")
    public void setCap_Adult_3_2_3(final String Cap_Adult_3_2_3) { this.Cap_Adult_3_2_3=Cap_Adult_3_2_3;}
    @Column(name = "Cap_Adult_3_2_4")
    @JsonProperty("Cap-Adult-3-2-4")
    private String Cap_Adult_3_2_4; // 基础疾病
    public String getCap_Adult_3_2_4() {  return this.Cap_Adult_3_2_4;}
    @JsonProperty("Cap-Adult-3-2-4")
    public void setCap_Adult_3_2_4(final String Cap_Adult_3_2_4) { this.Cap_Adult_3_2_4=Cap_Adult_3_2_4;}
    @Column(name = "Cap_Adult_3_3_1")
    @JsonProperty("Cap-Adult-3-3-1")
    private String Cap_Adult_3_3_1; // 是否进行侵入性病原学检测
    public String getCap_Adult_3_3_1() {  return this.Cap_Adult_3_3_1;}
    @JsonProperty("Cap-Adult-3-3-1")
    public void setCap_Adult_3_3_1(final String Cap_Adult_3_3_1) { this.Cap_Adult_3_3_1=Cap_Adult_3_3_1;}
    @Column(name = "Cap_Adult_3_3_2")
    @JsonProperty("Cap-Adult-3-3-2")
    private String Cap_Adult_3_3_2; // 实施侵入性病原学检测(ⅢB)的理由
    public String getCap_Adult_3_3_2() {  return this.Cap_Adult_3_3_2;}
    @JsonProperty("Cap-Adult-3-3-2")
    public void setCap_Adult_3_3_2(final String Cap_Adult_3_3_2) { this.Cap_Adult_3_3_2=Cap_Adult_3_3_2;}
    @Column(name = "Cap_Adult_3_3_2_1")
    @JsonProperty("Cap-Adult-3-3-2-1")
    private String Cap_Adult_3_3_2_1; // 其他实施侵入性病原学检测(ⅢB)的理由
    public String getCap_Adult_3_3_2_1() {  return this.Cap_Adult_3_3_2_1;}
    @JsonProperty("Cap-Adult-3-3-2-1")
    public void setCap_Adult_3_3_2_1(final String Cap_Adult_3_3_2_1) { this.Cap_Adult_3_3_2_1=Cap_Adult_3_3_2_1;}
    @Column(name = "Cap_Adult_3_3_3")
    @JsonProperty("Cap-Adult-3-3-3")
    private String Cap_Adult_3_3_3; // 侵入性病原学检测送检标本来源
    public String getCap_Adult_3_3_3() {  return this.Cap_Adult_3_3_3;}
    @JsonProperty("Cap-Adult-3-3-3")
    public void setCap_Adult_3_3_3(final String Cap_Adult_3_3_3) { this.Cap_Adult_3_3_3=Cap_Adult_3_3_3;}
    @Column(name = "Cap_Adult_3_3_3_1")
    @JsonProperty("Cap-Adult-3-3-3-1")
    private String Cap_Adult_3_3_3_1; // 其它侵入性病原学检测送检标本来源
    public String getCap_Adult_3_3_3_1() {  return this.Cap_Adult_3_3_3_1;}
    @JsonProperty("Cap-Adult-3-3-3-1")
    public void setCap_Adult_3_3_3_1(final String Cap_Adult_3_3_3_1) { this.Cap_Adult_3_3_3_1=Cap_Adult_3_3_3_1;}
    @Column(name = "Cap_Adult_3_4_1")
    @JsonProperty("Cap-Adult-3-4-1")
    private String Cap_Adult_3_4_1; // 是否送检病原学标本
    public String getCap_Adult_3_4_1() {  return this.Cap_Adult_3_4_1;}
    @JsonProperty("Cap-Adult-3-4-1")
    public void setCap_Adult_3_4_1(final String Cap_Adult_3_4_1) { this.Cap_Adult_3_4_1=Cap_Adult_3_4_1;}
    @Column(name = "Cap_Adult_3_4_2")
    @JsonProperty("Cap-Adult-3-4-2")
    private String Cap_Adult_3_4_2; // 送检病原学检测项目选择
    public String getCap_Adult_3_4_2() {  return this.Cap_Adult_3_4_2;}
    @JsonProperty("Cap-Adult-3-4-2")
    public void setCap_Adult_3_4_2(final String Cap_Adult_3_4_2) { this.Cap_Adult_3_4_2=Cap_Adult_3_4_2;}
    @Column(name = "Cap_Adult_3_4_2_1")
    @JsonProperty("Cap-Adult-3-4-2-1")
    private String Cap_Adult_3_4_2_1; // 其它送检病原学检测项目
    public String getCap_Adult_3_4_2_1() {  return this.Cap_Adult_3_4_2_1;}
    @JsonProperty("Cap-Adult-3-4-2-1")
    public void setCap_Adult_3_4_2_1(final String Cap_Adult_3_4_2_1) { this.Cap_Adult_3_4_2_1=Cap_Adult_3_4_2_1;}
    @Column(name = "Cap_Adult_3_5_1")
    @JsonProperty("Cap-Adult-3-5-1")
    private String Cap_Adult_3_5_1; // 病原学检测结果的选择
    public String getCap_Adult_3_5_1() {  return this.Cap_Adult_3_5_1;}
    @JsonProperty("Cap-Adult-3-5-1")
    public void setCap_Adult_3_5_1(final String Cap_Adult_3_5_1) { this.Cap_Adult_3_5_1=Cap_Adult_3_5_1;}
    @Column(name = "Cap_Adult_3_5_1_1")
    @JsonProperty("Cap-Adult-3-5-1-1")
    private String Cap_Adult_3_5_1_1; // 其它病原学检测结果
    public String getCap_Adult_3_5_1_1() {  return this.Cap_Adult_3_5_1_1;}
    @JsonProperty("Cap-Adult-3-5-1-1")
    public void setCap_Adult_3_5_1_1(final String Cap_Adult_3_5_1_1) { this.Cap_Adult_3_5_1_1=Cap_Adult_3_5_1_1;}
    @Column(name = "Cap_Adult_4_1")
    @JsonProperty("Cap-Adult-4-1")
    private String Cap_Adult_4_1; // 患者有无接受抗菌药物治疗
    public String getCap_Adult_4_1() {  return this.Cap_Adult_4_1;}
    @JsonProperty("Cap-Adult-4-1")
    public void setCap_Adult_4_1(final String Cap_Adult_4_1) { this.Cap_Adult_4_1=Cap_Adult_4_1;}
    @Column(name = "Cap_Adult_4_1_3")
    @JsonProperty("Cap-Adult-4-1-3")
    private String Cap_Adult_4_1_3; // 注射剂输入/注射起始日期
    public String getCap_Adult_4_1_3() {  return this.Cap_Adult_4_1_3;}
    @JsonProperty("Cap-Adult-4-1-3")
    public void setCap_Adult_4_1_3(final String Cap_Adult_4_1_3) { this.Cap_Adult_4_1_3=Cap_Adult_4_1_3;}
    @Column(name = "Cap_Adult_4_2")
    @JsonProperty("Cap-Adult-4-2")
    private String Cap_Adult_4_2; // 接受首剂抗菌药物使用时机
    public String getCap_Adult_4_2() {  return this.Cap_Adult_4_2;}
    @JsonProperty("Cap-Adult-4-2")
    public void setCap_Adult_4_2(final String Cap_Adult_4_2) { this.Cap_Adult_4_2=Cap_Adult_4_2;}
    @Column(name = "Cap_Adult_4_2_r")
    @JsonProperty("Cap-Adult-4-2-r")
    private String Cap_Adult_4_2_r; // 
    public String getCap_Adult_4_2_r() {  return this.Cap_Adult_4_2_r;}
    @JsonProperty("Cap-Adult-4-2-r")
    public void setCap_Adult_4_2_r(final String Cap_Adult_4_2_r) { this.Cap_Adult_4_2_r=Cap_Adult_4_2_r;}
    @Column(name = "Cap_Adult_4_3")
    @JsonProperty("Cap-Adult-4-3")
    private String Cap_Adult_4_3; // 治疗途径
    public String getCap_Adult_4_3() {  return this.Cap_Adult_4_3;}
    @JsonProperty("Cap-Adult-4-3")
    public void setCap_Adult_4_3(final String Cap_Adult_4_3) { this.Cap_Adult_4_3=Cap_Adult_4_3;}
    @Column(name = "Cap_Adult_4_4")
    @JsonProperty("Cap-Adult-4-4")
    private String Cap_Adult_4_4; // 注射剂输入/注射终止日期
    public String getCap_Adult_4_4() {  return this.Cap_Adult_4_4;}
    @JsonProperty("Cap-Adult-4-4")
    public void setCap_Adult_4_4(final String Cap_Adult_4_4) { this.Cap_Adult_4_4=Cap_Adult_4_4;}
    @Column(name = "Cap_Adult_4_2_3")
    @JsonProperty("Cap-Adult-4-2-3")
    private String Cap_Adult_4_2_3; // 入院后使用抗菌药物（口服剂）首剂日期与时间
    public String getCap_Adult_4_2_3() {  return this.Cap_Adult_4_2_3;}
    @JsonProperty("Cap-Adult-4-2-3")
    public void setCap_Adult_4_2_3(final String Cap_Adult_4_2_3) { this.Cap_Adult_4_2_3=Cap_Adult_4_2_3;}
    @Column(name = "Cap_Adult_4_2_4")
    @JsonProperty("Cap-Adult-4-2-4")
    private String Cap_Adult_4_2_4; // 末剂抗菌药物（口服剂）或出院日期与时间
    public String getCap_Adult_4_2_4() {  return this.Cap_Adult_4_2_4;}
    @JsonProperty("Cap-Adult-4-2-4")
    public void setCap_Adult_4_2_4(final String Cap_Adult_4_2_4) { this.Cap_Adult_4_2_4=Cap_Adult_4_2_4;}
    @Column(name = "Cap_Adult_4_2_5")
    @JsonProperty("Cap-Adult-4-2-5")
    private String Cap_Adult_4_2_5; // 口服剂抗菌药物疗程（天数）
    public String getCap_Adult_4_2_5() {  return this.Cap_Adult_4_2_5;}
    @JsonProperty("Cap-Adult-4-2-5")
    public void setCap_Adult_4_2_5(final String Cap_Adult_4_2_5) { this.Cap_Adult_4_2_5=Cap_Adult_4_2_5;}
    @Column(name = "Cap_Adult_5_1")
    @JsonProperty("Cap-Adult-5-1")
    private String Cap_Adult_5_1; // 用药前病情判定分层
    public String getCap_Adult_5_1() {  return this.Cap_Adult_5_1;}
    @JsonProperty("Cap-Adult-5-1")
    public void setCap_Adult_5_1(final String Cap_Adult_5_1) { this.Cap_Adult_5_1=Cap_Adult_5_1;}
    @Column(name = "Cap_Adult_5_2")
    @JsonProperty("Cap-Adult-5-2")
    private String Cap_Adult_5_2; // 经验性抗感染药物的选择
    public String getCap_Adult_5_2() {  return this.Cap_Adult_5_2;}
    @JsonProperty("Cap-Adult-5-2")
    public void setCap_Adult_5_2(final String Cap_Adult_5_2) { this.Cap_Adult_5_2=Cap_Adult_5_2;}
    @Column(name = "Cap_Adult_5_2_1")
    @JsonProperty("Cap-Adult-5-2-1")
    private String Cap_Adult_5_2_1; // 一代头孢菌素选择
    public String getCap_Adult_5_2_1() {  return this.Cap_Adult_5_2_1;}
    @JsonProperty("Cap-Adult-5-2-1")
    public void setCap_Adult_5_2_1(final String Cap_Adult_5_2_1) { this.Cap_Adult_5_2_1=Cap_Adult_5_2_1;}
    @Column(name = "Cap_Adult_5_2_2")
    @JsonProperty("Cap-Adult-5-2-2")
    private String Cap_Adult_5_2_2; // 二代头孢菌素选择
    public String getCap_Adult_5_2_2() {  return this.Cap_Adult_5_2_2;}
    @JsonProperty("Cap-Adult-5-2-2")
    public void setCap_Adult_5_2_2(final String Cap_Adult_5_2_2) { this.Cap_Adult_5_2_2=Cap_Adult_5_2_2;}
    @Column(name = "Cap_Adult_5_2_3")
    @JsonProperty("Cap-Adult-5-2-3")
    private String Cap_Adult_5_2_3; // 三代头孢菌素选择
    public String getCap_Adult_5_2_3() {  return this.Cap_Adult_5_2_3;}
    @JsonProperty("Cap-Adult-5-2-3")
    public void setCap_Adult_5_2_3(final String Cap_Adult_5_2_3) { this.Cap_Adult_5_2_3=Cap_Adult_5_2_3;}
    @Column(name = "Cap_Adult_5_2_4")
    @JsonProperty("Cap-Adult-5-2-4")
    private String Cap_Adult_5_2_4; // 头霉素类选择
    public String getCap_Adult_5_2_4() {  return this.Cap_Adult_5_2_4;}
    @JsonProperty("Cap-Adult-5-2-4")
    public void setCap_Adult_5_2_4(final String Cap_Adult_5_2_4) { this.Cap_Adult_5_2_4=Cap_Adult_5_2_4;}
    @Column(name = "Cap_Adult_5_2_5")
    @JsonProperty("Cap-Adult-5-2-5")
    private String Cap_Adult_5_2_5; // 呼吸喹诺酮类选择
    public String getCap_Adult_5_2_5() {  return this.Cap_Adult_5_2_5;}
    @JsonProperty("Cap-Adult-5-2-5")
    public void setCap_Adult_5_2_5(final String Cap_Adult_5_2_5) { this.Cap_Adult_5_2_5=Cap_Adult_5_2_5;}
    @Column(name = "Cap_Adult_5_2_6")
    @JsonProperty("Cap-Adult-5-2-6")
    private String Cap_Adult_5_2_6; // 氨基青霉素选择
    public String getCap_Adult_5_2_6() {  return this.Cap_Adult_5_2_6;}
    @JsonProperty("Cap-Adult-5-2-6")
    public void setCap_Adult_5_2_6(final String Cap_Adult_5_2_6) { this.Cap_Adult_5_2_6=Cap_Adult_5_2_6;}
    @Column(name = "Cap_Adult_5_2_7")
    @JsonProperty("Cap-Adult-5-2-7")
    private String Cap_Adult_5_2_7; // 青霉素类/酶抑制剂受合物选择
    public String getCap_Adult_5_2_7() {  return this.Cap_Adult_5_2_7;}
    @JsonProperty("Cap-Adult-5-2-7")
    public void setCap_Adult_5_2_7(final String Cap_Adult_5_2_7) { this.Cap_Adult_5_2_7=Cap_Adult_5_2_7;}
    @Column(name = "Cap_Adult_5_2_8")
    @JsonProperty("Cap-Adult-5-2-8")
    private String Cap_Adult_5_2_8; // 大环内酯类选择
    public String getCap_Adult_5_2_8() {  return this.Cap_Adult_5_2_8;}
    @JsonProperty("Cap-Adult-5-2-8")
    public void setCap_Adult_5_2_8(final String Cap_Adult_5_2_8) { this.Cap_Adult_5_2_8=Cap_Adult_5_2_8;}
    @Column(name = "Cap_Adult_5_2_9")
    @JsonProperty("Cap-Adult-5-2-9")
    private String Cap_Adult_5_2_9; // 有抗假单胞菌活性的喹诺酮类选择
    public String getCap_Adult_5_2_9() {  return this.Cap_Adult_5_2_9;}
    @JsonProperty("Cap-Adult-5-2-9")
    public void setCap_Adult_5_2_9(final String Cap_Adult_5_2_9) { this.Cap_Adult_5_2_9=Cap_Adult_5_2_9;}
    @Column(name = "Cap_Adult_5_2_10")
    @JsonProperty("Cap-Adult-5-2-10")
    private String Cap_Adult_5_2_10; // 有抗假单胞菌活性的β-内酰胺类选择
    public String getCap_Adult_5_2_10() {  return this.Cap_Adult_5_2_10;}
    @JsonProperty("Cap-Adult-5-2-10")
    public void setCap_Adult_5_2_10(final String Cap_Adult_5_2_10) { this.Cap_Adult_5_2_10=Cap_Adult_5_2_10;}
    @Column(name = "Cap_Adult_5_2_11")
    @JsonProperty("Cap-Adult-5-2-11")
    private String Cap_Adult_5_2_11; // 氧头孢类选择
    public String getCap_Adult_5_2_11() {  return this.Cap_Adult_5_2_11;}
    @JsonProperty("Cap-Adult-5-2-11")
    public void setCap_Adult_5_2_11(final String Cap_Adult_5_2_11) { this.Cap_Adult_5_2_11=Cap_Adult_5_2_11;}
    @Column(name = "Cap_Adult_5_2_12")
    @JsonProperty("Cap-Adult-5-2-12")
    private String Cap_Adult_5_2_12; // 氨基糖苷类选择
    public String getCap_Adult_5_2_12() {  return this.Cap_Adult_5_2_12;}
    @JsonProperty("Cap-Adult-5-2-12")
    public void setCap_Adult_5_2_12(final String Cap_Adult_5_2_12) { this.Cap_Adult_5_2_12=Cap_Adult_5_2_12;}
    @Column(name = "Cap_Adult_5_2_13")
    @JsonProperty("Cap-Adult-5-2-13")
    private String Cap_Adult_5_2_13; // 四环类选择
    public String getCap_Adult_5_2_13() {  return this.Cap_Adult_5_2_13;}
    @JsonProperty("Cap-Adult-5-2-13")
    public void setCap_Adult_5_2_13(final String Cap_Adult_5_2_13) { this.Cap_Adult_5_2_13=Cap_Adult_5_2_13;}
    @Column(name = "Cap_Adult_5_2_14")
    @JsonProperty("Cap-Adult-5-2-14")
    private String Cap_Adult_5_2_14; // 神经氨酸抑制剂选择
    public String getCap_Adult_5_2_14() {  return this.Cap_Adult_5_2_14;}
    @JsonProperty("Cap-Adult-5-2-14")
    public void setCap_Adult_5_2_14(final String Cap_Adult_5_2_14) { this.Cap_Adult_5_2_14=Cap_Adult_5_2_14;}
    @Column(name = "Cap_Adult_5_2_17")
    @JsonProperty("Cap-Adult-5-2-17")
    private String Cap_Adult_5_2_17; // 选用"特殊类使用种抗菌药物"药物
    public String getCap_Adult_5_2_17() {  return this.Cap_Adult_5_2_17;}
    @JsonProperty("Cap-Adult-5-2-17")
    public void setCap_Adult_5_2_17(final String Cap_Adult_5_2_17) { this.Cap_Adult_5_2_17=Cap_Adult_5_2_17;}
    @Column(name = "Cap_Adult_5_2_18")
    @JsonProperty("Cap-Adult-5-2-18")
    private String Cap_Adult_5_2_18; // 头孢菌素
    public String getCap_Adult_5_2_18() {  return this.Cap_Adult_5_2_18;}
    @JsonProperty("Cap-Adult-5-2-18")
    public void setCap_Adult_5_2_18(final String Cap_Adult_5_2_18) { this.Cap_Adult_5_2_18=Cap_Adult_5_2_18;}
    @Column(name = "Cap_Adult_5_2_19")
    @JsonProperty("Cap-Adult-5-2-19")
    private String Cap_Adult_5_2_19; // 其他四代或五代头孢菌素
    public String getCap_Adult_5_2_19() {  return this.Cap_Adult_5_2_19;}
    @JsonProperty("Cap-Adult-5-2-19")
    public void setCap_Adult_5_2_19(final String Cap_Adult_5_2_19) { this.Cap_Adult_5_2_19=Cap_Adult_5_2_19;}
    @Column(name = "Cap_Adult_5_2_20")
    @JsonProperty("Cap-Adult-5-2-20")
    private String Cap_Adult_5_2_20; // 碳青霉烯类抗菌药物
    public String getCap_Adult_5_2_20() {  return this.Cap_Adult_5_2_20;}
    @JsonProperty("Cap-Adult-5-2-20")
    public void setCap_Adult_5_2_20(final String Cap_Adult_5_2_20) { this.Cap_Adult_5_2_20=Cap_Adult_5_2_20;}
    @Column(name = "Cap_Adult_5_2_21")
    @JsonProperty("Cap-Adult-5-2-21")
    private String Cap_Adult_5_2_21; // 甘酰胺类抗菌药物
    public String getCap_Adult_5_2_21() {  return this.Cap_Adult_5_2_21;}
    @JsonProperty("Cap-Adult-5-2-21")
    public void setCap_Adult_5_2_21(final String Cap_Adult_5_2_21) { this.Cap_Adult_5_2_21=Cap_Adult_5_2_21;}
    @Column(name = "Cap_Adult_5_2_22")
    @JsonProperty("Cap-Adult-5-2-22")
    private String Cap_Adult_5_2_22; // 糖肽类与恶唑烷酮类抗菌药
    public String getCap_Adult_5_2_22() {  return this.Cap_Adult_5_2_22;}
    @JsonProperty("Cap-Adult-5-2-22")
    public void setCap_Adult_5_2_22(final String Cap_Adult_5_2_22) { this.Cap_Adult_5_2_22=Cap_Adult_5_2_22;}
    @Column(name = "Cap_Adult_5_2_23")
    @JsonProperty("Cap-Adult-5-2-23")
    private String Cap_Adult_5_2_23; // 抗真菌药物
    public String getCap_Adult_5_2_23() {  return this.Cap_Adult_5_2_23;}
    @JsonProperty("Cap-Adult-5-2-23")
    public void setCap_Adult_5_2_23(final String Cap_Adult_5_2_23) { this.Cap_Adult_5_2_23=Cap_Adult_5_2_23;}
    @Column(name = "Cap_Adult_5_2_16")
    @JsonProperty("Cap-Adult-5-2-16")
    private String Cap_Adult_5_2_16; // 其他抗菌药物
    public String getCap_Adult_5_2_16() {  return this.Cap_Adult_5_2_16;}
    @JsonProperty("Cap-Adult-5-2-16")
    public void setCap_Adult_5_2_16(final String Cap_Adult_5_2_16) { this.Cap_Adult_5_2_16=Cap_Adult_5_2_16;}
    @Column(name = "Cap_Adult_6_1_1")
    @JsonProperty("Cap-Adult-6-1-1")
    private String Cap_Adult_6_1_1; // 是否初始治疗48~72小时进行评价
    public String getCap_Adult_6_1_1() {  return this.Cap_Adult_6_1_1;}
    @JsonProperty("Cap-Adult-6-1-1")
    public void setCap_Adult_6_1_1(final String Cap_Adult_6_1_1) { this.Cap_Adult_6_1_1=Cap_Adult_6_1_1;}
    @Column(name = "Cap_Adult_6_1_2")
    @JsonProperty("Cap-Adult-6-1-2")
    private String Cap_Adult_6_1_2; // 评价结论
    public String getCap_Adult_6_1_2() {  return this.Cap_Adult_6_1_2;}
    @JsonProperty("Cap-Adult-6-1-2")
    public void setCap_Adult_6_1_2(final String Cap_Adult_6_1_2) { this.Cap_Adult_6_1_2=Cap_Adult_6_1_2;}
    @Column(name = "Cap_Adult_6_5_3")
    @JsonProperty("Cap-Adult-6-5-3")
    private String Cap_Adult_6_5_3; // 初始治疗48~72小时评价有效
    public String getCap_Adult_6_5_3() {  return this.Cap_Adult_6_5_3;}
    @JsonProperty("Cap-Adult-6-5-3")
    public void setCap_Adult_6_5_3(final String Cap_Adult_6_5_3) { this.Cap_Adult_6_5_3=Cap_Adult_6_5_3;}
    @Column(name = "Cap_Adult_6_5_1")
    @JsonProperty("Cap-Adult-6-5-1")
    private String Cap_Adult_6_5_1; // 初始治疗48~72小时评价有效的处理
    public String getCap_Adult_6_5_1() {  return this.Cap_Adult_6_5_1;}
    @JsonProperty("Cap-Adult-6-5-1")
    public void setCap_Adult_6_5_1(final String Cap_Adult_6_5_1) { this.Cap_Adult_6_5_1=Cap_Adult_6_5_1;}
    @Column(name = "Cap_Adult_6_2_6")
    @JsonProperty("Cap-Adult-6-2-6")
    private String Cap_Adult_6_2_6; // 初始治疗48~72小时评价无效
    public String getCap_Adult_6_2_6() {  return this.Cap_Adult_6_2_6;}
    @JsonProperty("Cap-Adult-6-2-6")
    public void setCap_Adult_6_2_6(final String Cap_Adult_6_2_6) { this.Cap_Adult_6_2_6=Cap_Adult_6_2_6;}
    @Column(name = "Cap_Adult_6_2_1")
    @JsonProperty("Cap-Adult-6-2-1")
    private String Cap_Adult_6_2_1; // 重复病原学检查
    public String getCap_Adult_6_2_1() {  return this.Cap_Adult_6_2_1;}
    @JsonProperty("Cap-Adult-6-2-1")
    public void setCap_Adult_6_2_1(final String Cap_Adult_6_2_1) { this.Cap_Adult_6_2_1=Cap_Adult_6_2_1;}
    @Column(name = "Cap_Adult_6_2_2")
    @JsonProperty("Cap-Adult-6-2-2")
    private String Cap_Adult_6_2_2; // 常见原因
    public String getCap_Adult_6_2_2() {  return this.Cap_Adult_6_2_2;}
    @JsonProperty("Cap-Adult-6-2-2")
    public void setCap_Adult_6_2_2(final String Cap_Adult_6_2_2) { this.Cap_Adult_6_2_2=Cap_Adult_6_2_2;}
    @Column(name = "Cap_Adult_6_2_2_1")
    @JsonProperty("Cap-Adult-6-2-2-1")
    private String Cap_Adult_6_2_2_1; // 其它原因和处理
    public String getCap_Adult_6_2_2_1() {  return this.Cap_Adult_6_2_2_1;}
    @JsonProperty("Cap-Adult-6-2-2-1")
    public void setCap_Adult_6_2_2_1(final String Cap_Adult_6_2_2_1) { this.Cap_Adult_6_2_2_1=Cap_Adult_6_2_2_1;}
    @Column(name = "Cap_Adult_6_2_3")
    @JsonProperty("Cap-Adult-6-2-3")
    private String Cap_Adult_6_2_3; // 病原学检查项目
    public String getCap_Adult_6_2_3() {  return this.Cap_Adult_6_2_3;}
    @JsonProperty("Cap-Adult-6-2-3")
    public void setCap_Adult_6_2_3(final String Cap_Adult_6_2_3) { this.Cap_Adult_6_2_3=Cap_Adult_6_2_3;}
    @Column(name = "Cap_Adult_6_2_3_1")
    @JsonProperty("Cap-Adult-6-2-3-1")
    private String Cap_Adult_6_2_3_1; // 其它病原学检查项目
    public String getCap_Adult_6_2_3_1() {  return this.Cap_Adult_6_2_3_1;}
    @JsonProperty("Cap-Adult-6-2-3-1")
    public void setCap_Adult_6_2_3_1(final String Cap_Adult_6_2_3_1) { this.Cap_Adult_6_2_3_1=Cap_Adult_6_2_3_1;}
    @Column(name = "Cap_Adult_6_3_1")
    @JsonProperty("Cap-Adult-6-3-1")
    private String Cap_Adult_6_3_1; // 重复病原学诊断结果选择
    public String getCap_Adult_6_3_1() {  return this.Cap_Adult_6_3_1;}
    @JsonProperty("Cap-Adult-6-3-1")
    public void setCap_Adult_6_3_1(final String Cap_Adult_6_3_1) { this.Cap_Adult_6_3_1=Cap_Adult_6_3_1;}
    @Column(name = "Cap_Adult_6_3_1_1")
    @JsonProperty("Cap-Adult-6-3-1-1")
    private String Cap_Adult_6_3_1_1; // 其它重复病原学诊断结果
    public String getCap_Adult_6_3_1_1() {  return this.Cap_Adult_6_3_1_1;}
    @JsonProperty("Cap-Adult-6-3-1-1")
    public void setCap_Adult_6_3_1_1(final String Cap_Adult_6_3_1_1) { this.Cap_Adult_6_3_1_1=Cap_Adult_6_3_1_1;}
    @Column(name = "Cap_Adult_6_3_2")
    @JsonProperty("Cap-Adult-6-3-2")
    private String Cap_Adult_6_3_2; // 重复病原学诊断（耐药）结果(2)
    public String getCap_Adult_6_3_2() {  return this.Cap_Adult_6_3_2;}
    @JsonProperty("Cap-Adult-6-3-2")
    public void setCap_Adult_6_3_2(final String Cap_Adult_6_3_2) { this.Cap_Adult_6_3_2=Cap_Adult_6_3_2;}
    @Column(name = "Cap_Adult_6_3_2_1")
    @JsonProperty("Cap-Adult-6-3-2-1")
    private String Cap_Adult_6_3_2_1; // 其他耐药菌
    public String getCap_Adult_6_3_2_1() {  return this.Cap_Adult_6_3_2_1;}
    @JsonProperty("Cap-Adult-6-3-2-1")
    public void setCap_Adult_6_3_2_1(final String Cap_Adult_6_3_2_1) { this.Cap_Adult_6_3_2_1=Cap_Adult_6_3_2_1;}
    @Column(name = "Cap_Adult_6_4")
    @JsonProperty("Cap-Adult-6-4")
    private String Cap_Adult_6_4; // 目标抗感染药物的选择
    public String getCap_Adult_6_4() {  return this.Cap_Adult_6_4;}
    @JsonProperty("Cap-Adult-6-4")
    public void setCap_Adult_6_4(final String Cap_Adult_6_4) { this.Cap_Adult_6_4=Cap_Adult_6_4;}
    @Column(name = "Cap_Adult_6_4_7")
    @JsonProperty("Cap-Adult-6-4-7")
    private String Cap_Adult_6_4_7; // 其他目标抗感染药物
    public String getCap_Adult_6_4_7() {  return this.Cap_Adult_6_4_7;}
    @JsonProperty("Cap-Adult-6-4-7")
    public void setCap_Adult_6_4_7(final String Cap_Adult_6_4_7) { this.Cap_Adult_6_4_7=Cap_Adult_6_4_7;}
    @Column(name = "Cap_Adult_7_1_1_1")
    @JsonProperty("Cap-Adult-7-1-1-1")
    private String Cap_Adult_7_1_1_1; // 是否实施氧疗
    public String getCap_Adult_7_1_1_1() {  return this.Cap_Adult_7_1_1_1;}
    @JsonProperty("Cap-Adult-7-1-1-1")
    public void setCap_Adult_7_1_1_1(final String Cap_Adult_7_1_1_1) { this.Cap_Adult_7_1_1_1=Cap_Adult_7_1_1_1;}
    @Column(name = "Cap_Adult_7_1_2_1")
    @JsonProperty("Cap-Adult-7-1-2-1")
    private String Cap_Adult_7_1_2_1; // 氧疗方法
    public String getCap_Adult_7_1_2_1() {  return this.Cap_Adult_7_1_2_1;}
    @JsonProperty("Cap-Adult-7-1-2-1")
    public void setCap_Adult_7_1_2_1(final String Cap_Adult_7_1_2_1) { this.Cap_Adult_7_1_2_1=Cap_Adult_7_1_2_1;}
    @Column(name = "Cap_Adult_7_1_3_1")
    @JsonProperty("Cap-Adult-7-1-3-1")
    private String Cap_Adult_7_1_3_1; // 氧疗 2小时后是否复查血氧情况以及复查时间
    public String getCap_Adult_7_1_3_1() {  return this.Cap_Adult_7_1_3_1;}
    @JsonProperty("Cap-Adult-7-1-3-1")
    public void setCap_Adult_7_1_3_1(final String Cap_Adult_7_1_3_1) { this.Cap_Adult_7_1_3_1=Cap_Adult_7_1_3_1;}
    @Column(name = "Cap_Adult_7_1_3_2")
    @JsonProperty("Cap-Adult-7-1-3-2")
    private String Cap_Adult_7_1_3_2; // 复查动脉血气方式
    public String getCap_Adult_7_1_3_2() {  return this.Cap_Adult_7_1_3_2;}
    @JsonProperty("Cap-Adult-7-1-3-2")
    public void setCap_Adult_7_1_3_2(final String Cap_Adult_7_1_3_2) { this.Cap_Adult_7_1_3_2=Cap_Adult_7_1_3_2;}
    @Column(name = "Cap_Adult_7_1_3_3")
    @JsonProperty("Cap-Adult-7-1-3-3")
    private String Cap_Adult_7_1_3_3; // 指氧仪检查 SpO₂ (%)
    public String getCap_Adult_7_1_3_3() {  return this.Cap_Adult_7_1_3_3;}
    @JsonProperty("Cap-Adult-7-1-3-3")
    public void setCap_Adult_7_1_3_3(final String Cap_Adult_7_1_3_3) { this.Cap_Adult_7_1_3_3=Cap_Adult_7_1_3_3;}
    @Column(name = "Cap_Adult_7_1_3_4")
    @JsonProperty("Cap-Adult-7-1-3-4")
    private String Cap_Adult_7_1_3_4; // 血气分析-动脉氧分压 PaO₂(mmHg)
    public String getCap_Adult_7_1_3_4() {  return this.Cap_Adult_7_1_3_4;}
    @JsonProperty("Cap-Adult-7-1-3-4")
    public void setCap_Adult_7_1_3_4(final String Cap_Adult_7_1_3_4) { this.Cap_Adult_7_1_3_4=Cap_Adult_7_1_3_4;}
    @Column(name = "Cap_Adult_7_5_4")
    @JsonProperty("Cap-Adult-7-5-4")
    private String Cap_Adult_7_5_4; // 是否使用呼吸支持治疗
    public String getCap_Adult_7_5_4() {  return this.Cap_Adult_7_5_4;}
    @JsonProperty("Cap-Adult-7-5-4")
    public void setCap_Adult_7_5_4(final String Cap_Adult_7_5_4) { this.Cap_Adult_7_5_4=Cap_Adult_7_5_4;}
    @Column(name = "Cap_Adult_7_5_5")
    @JsonProperty("Cap-Adult-7-5-5")
    private String Cap_Adult_7_5_5; // 呼吸支持治疗方式
    public String getCap_Adult_7_5_5() {  return this.Cap_Adult_7_5_5;}
    @JsonProperty("Cap-Adult-7-5-5")
    public void setCap_Adult_7_5_5(final String Cap_Adult_7_5_5) { this.Cap_Adult_7_5_5=Cap_Adult_7_5_5;}
    @Column(name = "Cap_Adult_7_2_1_1")
    @JsonProperty("Cap-Adult-7-2-1-1")
    private String Cap_Adult_7_2_1_1; // 是否实施无创正压通气（NIV）
    public String getCap_Adult_7_2_1_1() {  return this.Cap_Adult_7_2_1_1;}
    @JsonProperty("Cap-Adult-7-2-1-1")
    public void setCap_Adult_7_2_1_1(final String Cap_Adult_7_2_1_1) { this.Cap_Adult_7_2_1_1=Cap_Adult_7_2_1_1;}
    @Column(name = "Cap_Adult_7_2_2_0")
    @JsonProperty("Cap-Adult-7-2-2-0")
    private String Cap_Adult_7_2_2_0; // 无创正压通气的应用指征
    public String getCap_Adult_7_2_2_0() {  return this.Cap_Adult_7_2_2_0;}
    @JsonProperty("Cap-Adult-7-2-2-0")
    public void setCap_Adult_7_2_2_0(final String Cap_Adult_7_2_2_0) { this.Cap_Adult_7_2_2_0=Cap_Adult_7_2_2_0;}
    @Column(name = "Cap_Adult_7_2_2_1")
    @JsonProperty("Cap-Adult-7-2-2-1")
    private String Cap_Adult_7_2_2_1; // 其它无创正压通气的应用指征
    public String getCap_Adult_7_2_2_1() {  return this.Cap_Adult_7_2_2_1;}
    @JsonProperty("Cap-Adult-7-2-2-1")
    public void setCap_Adult_7_2_2_1(final String Cap_Adult_7_2_2_1) { this.Cap_Adult_7_2_2_1=Cap_Adult_7_2_2_1;}
    @Column(name = "Cap_Adult_6_2_5_1")
    @JsonProperty("Cap-Adult-6-2-5-1")
    private String Cap_Adult_6_2_5_1; // 患者无创正压通气起始日期时间
    public String getCap_Adult_6_2_5_1() {  return this.Cap_Adult_6_2_5_1;}
    @JsonProperty("Cap-Adult-6-2-5-1")
    public void setCap_Adult_6_2_5_1(final String Cap_Adult_6_2_5_1) { this.Cap_Adult_6_2_5_1=Cap_Adult_6_2_5_1;}
    @Column(name = "Cap_Adult_6_2_4_2")
    @JsonProperty("Cap-Adult-6-2-4-2")
    private String Cap_Adult_6_2_4_2; // 患者无创正压通气终止日期时间
    public String getCap_Adult_6_2_4_2() {  return this.Cap_Adult_6_2_4_2;}
    @JsonProperty("Cap-Adult-6-2-4-2")
    public void setCap_Adult_6_2_4_2(final String Cap_Adult_6_2_4_2) { this.Cap_Adult_6_2_4_2=Cap_Adult_6_2_4_2;}
    @Column(name = "Cap_Adult_6_2_5")
    @JsonProperty("Cap-Adult-6-2-5")
    private String Cap_Adult_6_2_5; // 无创正压通气疗程（小时）
    public String getCap_Adult_6_2_5() {  return this.Cap_Adult_6_2_5;}
    @JsonProperty("Cap-Adult-6-2-5")
    public void setCap_Adult_6_2_5(final String Cap_Adult_6_2_5) { this.Cap_Adult_6_2_5=Cap_Adult_6_2_5;}
    @Column(name = "Cap_Adult_7_3_1")
    @JsonProperty("Cap-Adult-7-3-1")
    private String Cap_Adult_7_3_1; // 是否实施有创机械通气
    public String getCap_Adult_7_3_1() {  return this.Cap_Adult_7_3_1;}
    @JsonProperty("Cap-Adult-7-3-1")
    public void setCap_Adult_7_3_1(final String Cap_Adult_7_3_1) { this.Cap_Adult_7_3_1=Cap_Adult_7_3_1;}
    @Column(name = "Cap_Adult_7_3_2")
    @JsonProperty("Cap-Adult-7-3-2")
    private String Cap_Adult_7_3_2; // 有创机械通气的具体应用指征
    public String getCap_Adult_7_3_2() {  return this.Cap_Adult_7_3_2;}
    @JsonProperty("Cap-Adult-7-3-2")
    public void setCap_Adult_7_3_2(final String Cap_Adult_7_3_2) { this.Cap_Adult_7_3_2=Cap_Adult_7_3_2;}
    @Column(name = "Cap_Adult_7_3_2_1")
    @JsonProperty("Cap-Adult-7-3-2-1")
    private String Cap_Adult_7_3_2_1; // 其它有创机械通气的具体应用指征
    public String getCap_Adult_7_3_2_1() {  return this.Cap_Adult_7_3_2_1;}
    @JsonProperty("Cap-Adult-7-3-2-1")
    public void setCap_Adult_7_3_2_1(final String Cap_Adult_7_3_2_1) { this.Cap_Adult_7_3_2_1=Cap_Adult_7_3_2_1;}
    @Column(name = "Cap_Adult_6_3_4_1")
    @JsonProperty("Cap-Adult-6-3-4-1")
    private String Cap_Adult_6_3_4_1; // 患者有机械通气起始日期时间
    public String getCap_Adult_6_3_4_1() {  return this.Cap_Adult_6_3_4_1;}
    @JsonProperty("Cap-Adult-6-3-4-1")
    public void setCap_Adult_6_3_4_1(final String Cap_Adult_6_3_4_1) { this.Cap_Adult_6_3_4_1=Cap_Adult_6_3_4_1;}
    @Column(name = "Cap_Adult_6_3_4_2")
    @JsonProperty("Cap-Adult-6-3-4-2")
    private String Cap_Adult_6_3_4_2; // 患者有机械通气终止日期时间
    public String getCap_Adult_6_3_4_2() {  return this.Cap_Adult_6_3_4_2;}
    @JsonProperty("Cap-Adult-6-3-4-2")
    public void setCap_Adult_6_3_4_2(final String Cap_Adult_6_3_4_2) { this.Cap_Adult_6_3_4_2=Cap_Adult_6_3_4_2;}
    @Column(name = "Cap_Adult_6_3_5")
    @JsonProperty("Cap-Adult-6-3-5")
    private String Cap_Adult_6_3_5; // 有机械通气疗程（小时）
    public String getCap_Adult_6_3_5() {  return this.Cap_Adult_6_3_5;}
    @JsonProperty("Cap-Adult-6-3-5")
    public void setCap_Adult_6_3_5(final String Cap_Adult_6_3_5) { this.Cap_Adult_6_3_5=Cap_Adult_6_3_5;}
    @Column(name = "Cap_Adult_7_4_1")
    @JsonProperty("Cap-Adult-7-4-1")
    private String Cap_Adult_7_4_1; // 是否实施体外膜肺氧合ECMO
    public String getCap_Adult_7_4_1() {  return this.Cap_Adult_7_4_1;}
    @JsonProperty("Cap-Adult-7-4-1")
    public void setCap_Adult_7_4_1(final String Cap_Adult_7_4_1) { this.Cap_Adult_7_4_1=Cap_Adult_7_4_1;}
    @Column(name = "Cap_Adult_7_4_2")
    @JsonProperty("Cap-Adult-7-4-2")
    private String Cap_Adult_7_4_2; // 体外膜肺氧合应用指征
    public String getCap_Adult_7_4_2() {  return this.Cap_Adult_7_4_2;}
    @JsonProperty("Cap-Adult-7-4-2")
    public void setCap_Adult_7_4_2(final String Cap_Adult_7_4_2) { this.Cap_Adult_7_4_2=Cap_Adult_7_4_2;}
    @Column(name = "Cap_Adult_7_4_2_1")
    @JsonProperty("Cap-Adult-7-4-2-1")
    private String Cap_Adult_7_4_2_1; // 其它体外膜肺氧合应用指征
    public String getCap_Adult_7_4_2_1() {  return this.Cap_Adult_7_4_2_1;}
    @JsonProperty("Cap-Adult-7-4-2-1")
    public void setCap_Adult_7_4_2_1(final String Cap_Adult_7_4_2_1) { this.Cap_Adult_7_4_2_1=Cap_Adult_7_4_2_1;}
    @Column(name = "Cap_Adult_6_4_8")
    @JsonProperty("Cap-Adult-6-4-8")
    private String Cap_Adult_6_4_8; // 患者体外膜肺氧合起始日期时间
    public String getCap_Adult_6_4_8() {  return this.Cap_Adult_6_4_8;}
    @JsonProperty("Cap-Adult-6-4-8")
    public void setCap_Adult_6_4_8(final String Cap_Adult_6_4_8) { this.Cap_Adult_6_4_8=Cap_Adult_6_4_8;}
    @Column(name = "Cap_Adult_6_4_4_2")
    @JsonProperty("Cap-Adult-6-4-4-2")
    private String Cap_Adult_6_4_4_2; // 患者体外膜肺氧合终止日期时间
    public String getCap_Adult_6_4_4_2() {  return this.Cap_Adult_6_4_4_2;}
    @JsonProperty("Cap-Adult-6-4-4-2")
    public void setCap_Adult_6_4_4_2(final String Cap_Adult_6_4_4_2) { this.Cap_Adult_6_4_4_2=Cap_Adult_6_4_4_2;}
    @Column(name = "Cap_Adult_6_4_9")
    @JsonProperty("Cap-Adult-6-4-9")
    private String Cap_Adult_6_4_9; // 体外膜肺氧合疗程（小时）
    public String getCap_Adult_6_4_9() {  return this.Cap_Adult_6_4_9;}
    @JsonProperty("Cap-Adult-6-4-9")
    public void setCap_Adult_6_4_9(final String Cap_Adult_6_4_9) { this.Cap_Adult_6_4_9=Cap_Adult_6_4_9;}
    @Column(name = "Cap_Adult_8_1")
    @JsonProperty("Cap-Adult-8-1")
    private String Cap_Adult_8_1; // 吸烟史
    public String getCap_Adult_8_1() {  return this.Cap_Adult_8_1;}
    @JsonProperty("Cap-Adult-8-1")
    public void setCap_Adult_8_1(final String Cap_Adult_8_1) { this.Cap_Adult_8_1=Cap_Adult_8_1;}
    @Column(name = "Cap_Adult_8_2")
    @JsonProperty("Cap-Adult-8-2")
    private String Cap_Adult_8_2; // 吸烟程度评估有记录
    public String getCap_Adult_8_2() {  return this.Cap_Adult_8_2;}
    @JsonProperty("Cap-Adult-8-2")
    public void setCap_Adult_8_2(final String Cap_Adult_8_2) { this.Cap_Adult_8_2=Cap_Adult_8_2;}
    @Column(name = "Cap_Adult_8_3")
    @JsonProperty("Cap-Adult-8-3")
    private String Cap_Adult_8_3; // 接受戒烟的建议或者戒烟治疗有记录
    public String getCap_Adult_8_3() {  return this.Cap_Adult_8_3;}
    @JsonProperty("Cap-Adult-8-3")
    public void setCap_Adult_8_3(final String Cap_Adult_8_3) { this.Cap_Adult_8_3=Cap_Adult_8_3;}
    @Column(name = "Cap_Adult_8_2_1")
    @JsonProperty("Cap-Adult-8-2-1")
    private String Cap_Adult_8_2_1; // 是否接种肺炎链球菌疫苗
    public String getCap_Adult_8_2_1() {  return this.Cap_Adult_8_2_1;}
    @JsonProperty("Cap-Adult-8-2-1")
    public void setCap_Adult_8_2_1(final String Cap_Adult_8_2_1) { this.Cap_Adult_8_2_1=Cap_Adult_8_2_1;}
    @Column(name = "Cap_Adult_8_2_2")
    @JsonProperty("Cap-Adult-8-2-2")
    private String Cap_Adult_8_2_2; // 患者接受肺炎链球菌疫苗接种的缘由
    public String getCap_Adult_8_2_2() {  return this.Cap_Adult_8_2_2;}
    @JsonProperty("Cap-Adult-8-2-2")
    public void setCap_Adult_8_2_2(final String Cap_Adult_8_2_2) { this.Cap_Adult_8_2_2=Cap_Adult_8_2_2;}
    @Column(name = "Cap_Adult_8_3_1")
    @JsonProperty("Cap-Adult-8-3-1")
    private String Cap_Adult_8_3_1; // 是否接种流感疫苗
    public String getCap_Adult_8_3_1() {  return this.Cap_Adult_8_3_1;}
    @JsonProperty("Cap-Adult-8-3-1")
    public void setCap_Adult_8_3_1(final String Cap_Adult_8_3_1) { this.Cap_Adult_8_3_1=Cap_Adult_8_3_1;}
    @Column(name = "Cap_Adult_8_3_2")
    @JsonProperty("Cap-Adult-8-3-2")
    private String Cap_Adult_8_3_2; // 患者接受流感疫苗接种的缘由
    public String getCap_Adult_8_3_2() {  return this.Cap_Adult_8_3_2;}
    @JsonProperty("Cap-Adult-8-3-2")
    public void setCap_Adult_8_3_2(final String Cap_Adult_8_3_2) { this.Cap_Adult_8_3_2=Cap_Adult_8_3_2;}
    @Column(name = "Cap_Adult_9_3_1")
    @JsonProperty("Cap-Adult-9-3-1")
    private String Cap_Adult_9_3_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    public String getCap_Adult_9_3_1() {  return this.Cap_Adult_9_3_1;}
    @JsonProperty("Cap-Adult-9-3-1")
    public void setCap_Adult_9_3_1(final String Cap_Adult_9_3_1) { this.Cap_Adult_9_3_1=Cap_Adult_9_3_1;}
    @Column(name = "Cap_Adult_9_3_2")
    @JsonProperty("Cap-Adult-9-3-2")
    private String Cap_Adult_9_3_2; // 出院带药
    public String getCap_Adult_9_3_2() {  return this.Cap_Adult_9_3_2;}
    @JsonProperty("Cap-Adult-9-3-2")
    public void setCap_Adult_9_3_2(final String Cap_Adult_9_3_2) { this.Cap_Adult_9_3_2=Cap_Adult_9_3_2;}
    @Column(name = "Cap_Adult_9_3_5")
    @JsonProperty("Cap-Adult-9-3-5")
    private String Cap_Adult_9_3_5; // 告知何为发生紧急意外情况或者疾病复发
    public String getCap_Adult_9_3_5() {  return this.Cap_Adult_9_3_5;}
    @JsonProperty("Cap-Adult-9-3-5")
    public void setCap_Adult_9_3_5(final String Cap_Adult_9_3_5) { this.Cap_Adult_9_3_5=Cap_Adult_9_3_5;}
    @Column(name = "Cap_Adult_9_3_3")
    @JsonProperty("Cap-Adult-9-3-3")
    private String Cap_Adult_9_3_3; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    public String getCap_Adult_9_3_3() {  return this.Cap_Adult_9_3_3;}
    @JsonProperty("Cap-Adult-9-3-3")
    public void setCap_Adult_9_3_3(final String Cap_Adult_9_3_3) { this.Cap_Adult_9_3_3=Cap_Adult_9_3_3;}
    @Column(name = "Cap_Adult_9_3_4")
    @JsonProperty("Cap-Adult-9-3-4")
    private String Cap_Adult_9_3_4; // 出院时教育与随访
    public String getCap_Adult_9_3_4() {  return this.Cap_Adult_9_3_4;}
    @JsonProperty("Cap-Adult-9-3-4")
    public void setCap_Adult_9_3_4(final String Cap_Adult_9_3_4) { this.Cap_Adult_9_3_4=Cap_Adult_9_3_4;}
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
    @Column(name = "Cap_Adult_9_1")
    @JsonProperty("Cap-Adult-9-1")
    private String Cap_Adult_9_1; // 出院标准
    public String getCap_Adult_9_1() {  return this.Cap_Adult_9_1;}
    @JsonProperty("Cap-Adult-9-1")
    public void setCap_Adult_9_1(final String Cap_Adult_9_1) { this.Cap_Adult_9_1=Cap_Adult_9_1;}
    @Column(name = "Cap_Adult_9_1_1")
    @JsonProperty("Cap-Adult-9-1-1")
    private String Cap_Adult_9_1_1; // 其他标准
    public String getCap_Adult_9_1_1() {  return this.Cap_Adult_9_1_1;}
    @JsonProperty("Cap-Adult-9-1-1")
    public void setCap_Adult_9_1_1(final String Cap_Adult_9_1_1) { this.Cap_Adult_9_1_1=Cap_Adult_9_1_1;}
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
    @Column(name = "Cap_Adult_10_1")
    @JsonProperty("Cap-Adult-10-1")
    private String Cap_Adult_10_1; // 患者接受首剂抗菌药物治疗注射剂输入/注射起始日期
    public String getCap_Adult_10_1() {  return this.Cap_Adult_10_1;}
    @JsonProperty("Cap-Adult-10-1")
    public void setCap_Adult_10_1(final String Cap_Adult_10_1) { this.Cap_Adult_10_1=Cap_Adult_10_1;}
    @Column(name = "Cap_Adult_10_3")
    @JsonProperty("Cap-Adult-10-3")
    private String Cap_Adult_10_3; // 患者终止抗菌药物治疗注射剂输入/注射日期时间
    public String getCap_Adult_10_3() {  return this.Cap_Adult_10_3;}
    @JsonProperty("Cap-Adult-10-3")
    public void setCap_Adult_10_3(final String Cap_Adult_10_3) { this.Cap_Adult_10_3=Cap_Adult_10_3;}
    @Column(name = "Cap_Adult_10_1_5")
    @JsonProperty("Cap-Adult-10-1-5")
    private String Cap_Adult_10_1_5; // 注射剂输入/注射抗菌药物疗程（天数）
    public String getCap_Adult_10_1_5() {  return this.Cap_Adult_10_1_5;}
    @JsonProperty("Cap-Adult-10-1-5")
    public void setCap_Adult_10_1_5(final String Cap_Adult_10_1_5) { this.Cap_Adult_10_1_5=Cap_Adult_10_1_5;}
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