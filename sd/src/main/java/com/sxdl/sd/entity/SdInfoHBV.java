package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：O98.4，Z22.5 + O80 至 O84+Z37；且伴①阴道分娩操作 ICD-9-CM-3 编码 72.0 至 72.9，73.0，73.1，73.21，73.4 至 73.6,73.9；或伴②剖宫产手术 ICD9-CM-3 编码：74.0，74.1，74.2，74.4，74.99 的出院患者。
*/
@ApiModel(value = "51信息")
@Entity
@Table(name = "sd_info_HBV")
public class SdInfoHBV implements Serializable {
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
    @Column(name = "HBV_0_1_3_1")
    @JsonProperty("HBV-0-1-3-1")
    private String HBV_0_1_3_1; // 病毒性肝炎并发于妊娠、分娩ICD-10四位亚目编码与名称
    public String getHBV_0_1_3_1() {  return this.HBV_0_1_3_1;}
    @JsonProperty("HBV-0-1-3-1")
    public void setHBV_0_1_3_1(final String HBV_0_1_3_1) { this.HBV_0_1_3_1=HBV_0_1_3_1;}
    @Column(name = "HBV_0_1_3_2")
    @JsonProperty("HBV-0-1-3-2")
    private String HBV_0_1_3_2; // 病毒性肝炎并发于妊娠、分娩ICD-10六位临床扩展编码与名称
    public String getHBV_0_1_3_2() {  return this.HBV_0_1_3_2;}
    @JsonProperty("HBV-0-1-3-2")
    public void setHBV_0_1_3_2(final String HBV_0_1_3_2) { this.HBV_0_1_3_2=HBV_0_1_3_2;}
    @Column(name = "HBV_0_1_3_3")
    @JsonProperty("HBV-0-1-3-3")
    private String HBV_0_1_3_3; // 分娩方式ICD-10四位亚目编码与名称
    public String getHBV_0_1_3_3() {  return this.HBV_0_1_3_3;}
    @JsonProperty("HBV-0-1-3-3")
    public void setHBV_0_1_3_3(final String HBV_0_1_3_3) { this.HBV_0_1_3_3=HBV_0_1_3_3;}
    @Column(name = "HBV_0_1_3_4")
    @JsonProperty("HBV-0-1-3-4")
    private String HBV_0_1_3_4; // 分娩方式ICD-10六位临床扩展编码与名称
    public String getHBV_0_1_3_4() {  return this.HBV_0_1_3_4;}
    @JsonProperty("HBV-0-1-3-4")
    public void setHBV_0_1_3_4(final String HBV_0_1_3_4) { this.HBV_0_1_3_4=HBV_0_1_3_4;}
    @Column(name = "CM_0_1_3_1")
    @JsonProperty("CM-0-1-3-1")
    private String CM_0_1_3_1; // 出院诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 出院诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 剖宫产手术操作ICD-9-CM-3四位亚目编码与名称
    public String getCM_0_1_4_1() {  return this.CM_0_1_4_1;}
    @JsonProperty("CM-0-1-4-1")
    public void setCM_0_1_4_1(final String CM_0_1_4_1) { this.CM_0_1_4_1=CM_0_1_4_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 剖宫产手术操作ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "HBV_0_1_4_1")
    @JsonProperty("HBV-0-1-4-1")
    private String HBV_0_1_4_1; // 阴道分娩操作ICD-9-CM-3四位亚目编码与名称
    public String getHBV_0_1_4_1() {  return this.HBV_0_1_4_1;}
    @JsonProperty("HBV-0-1-4-1")
    public void setHBV_0_1_4_1(final String HBV_0_1_4_1) { this.HBV_0_1_4_1=HBV_0_1_4_1;}
    @Column(name = "HBV_0_1_4_2")
    @JsonProperty("HBV-0-1-4-2")
    private String HBV_0_1_4_2; // 其他阴道分娩操作ICD-9-CM-3四位亚目编码与名称
    public String getHBV_0_1_4_2() {  return this.HBV_0_1_4_2;}
    @JsonProperty("HBV-0-1-4-2")
    public void setHBV_0_1_4_2(final String HBV_0_1_4_2) { this.HBV_0_1_4_2=HBV_0_1_4_2;}
    @Column(name = "HBV_0_1_4_3")
    @JsonProperty("HBV-0-1-4-3")
    private String HBV_0_1_4_3; // 阴道分娩操作ICD-9-CM-3六位临床扩展编码与名称
    public String getHBV_0_1_4_3() {  return this.HBV_0_1_4_3;}
    @JsonProperty("HBV-0-1-4-3")
    public void setHBV_0_1_4_3(final String HBV_0_1_4_3) { this.HBV_0_1_4_3=HBV_0_1_4_3;}
    @Column(name = "HBV_0_1_4_4")
    @JsonProperty("HBV-0-1-4-4")
    private String HBV_0_1_4_4; // 其他阴道分娩操作ICD-9-CM-3六位临床扩展编码与名称
    public String getHBV_0_1_4_4() {  return this.HBV_0_1_4_4;}
    @JsonProperty("HBV-0-1-4-4")
    public void setHBV_0_1_4_4(final String HBV_0_1_4_4) { this.HBV_0_1_4_4=HBV_0_1_4_4;}
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
    @Column(name = "HBV_0_2_1_4")
    @JsonProperty("HBV-0-2-1-4")
    private String HBV_0_2_1_4; // 新生儿出生体重(g)
    public String getHBV_0_2_1_4() {  return this.HBV_0_2_1_4;}
    @JsonProperty("HBV-0-2-1-4")
    public void setHBV_0_2_1_4(final String HBV_0_2_1_4) { this.HBV_0_2_1_4=HBV_0_2_1_4;}
    @Column(name = "HBV_0_2_1_5")
    @JsonProperty("HBV-0-2-1-5")
    private String HBV_0_2_1_5; // 新生儿入院体重(g)
    public String getHBV_0_2_1_5() {  return this.HBV_0_2_1_5;}
    @JsonProperty("HBV-0-2-1-5")
    public void setHBV_0_2_1_5(final String HBV_0_2_1_5) { this.HBV_0_2_1_5=HBV_0_2_1_5;}
    @Column(name = "HBV_0_2_2_1")
    @JsonProperty("HBV-0-2-2-1")
    private String HBV_0_2_2_1; // 末次月经日期是否无法确定或无记录
    public String getHBV_0_2_2_1() {  return this.HBV_0_2_2_1;}
    @JsonProperty("HBV-0-2-2-1")
    public void setHBV_0_2_2_1(final String HBV_0_2_2_1) { this.HBV_0_2_2_1=HBV_0_2_2_1;}
    @Column(name = "HBV_0_2_2_2")
    @JsonProperty("HBV-0-2-2-2")
    private String HBV_0_2_2_2; // 末次月经日期
    public String getHBV_0_2_2_2() {  return this.HBV_0_2_2_2;}
    @JsonProperty("HBV-0-2-2-2")
    public void setHBV_0_2_2_2(final String HBV_0_2_2_2) { this.HBV_0_2_2_2=HBV_0_2_2_2;}
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
    @Column(name = "HBV_1_1_1_r")
    @JsonProperty("HBV-1-1-1-r")
    private String HBV_1_1_1_r; // 孕周(天)
    public String getHBV_1_1_1_r() {  return this.HBV_1_1_1_r;}
    @JsonProperty("HBV-1-1-1-r")
    public void setHBV_1_1_1_r(final String HBV_1_1_1_r) { this.HBV_1_1_1_r=HBV_1_1_1_r;}
    @Column(name = "HBV_1_1_1")
    @JsonProperty("HBV-1-1-1")
    private String HBV_1_1_1; // 孕周(周)
    public String getHBV_1_1_1() {  return this.HBV_1_1_1;}
    @JsonProperty("HBV-1-1-1")
    public void setHBV_1_1_1(final String HBV_1_1_1) { this.HBV_1_1_1=HBV_1_1_1;}
    @Column(name = "HBV_1_1_2")
    @JsonProperty("HBV-1-1-2")
    private String HBV_1_1_2; // 乙型肝炎病毒核酸(HBV-DNA) 检测选项
    public String getHBV_1_1_2() {  return this.HBV_1_1_2;}
    @JsonProperty("HBV-1-1-2")
    public void setHBV_1_1_2(final String HBV_1_1_2) { this.HBV_1_1_2=HBV_1_1_2;}
    @Column(name = "HBV_1_1_3_1")
    @JsonProperty("HBV-1-1-3-1")
    private String HBV_1_1_3_1; // 乙肝病毒表面抗原 (HBsAg)检测选择
    public String getHBV_1_1_3_1() {  return this.HBV_1_1_3_1;}
    @JsonProperty("HBV-1-1-3-1")
    public void setHBV_1_1_3_1(final String HBV_1_1_3_1) { this.HBV_1_1_3_1=HBV_1_1_3_1;}
    @Column(name = "HBV_1_1_3_2")
    @JsonProperty("HBV-1-1-3-2")
    private String HBV_1_1_3_2; // 乙肝病毒表面抗原 (HBsAg)定性检测选择
    public String getHBV_1_1_3_2() {  return this.HBV_1_1_3_2;}
    @JsonProperty("HBV-1-1-3-2")
    public void setHBV_1_1_3_2(final String HBV_1_1_3_2) { this.HBV_1_1_3_2=HBV_1_1_3_2;}
    @Column(name = "HBV_1_1_3_3")
    @JsonProperty("HBV-1-1-3-3")
    private String HBV_1_1_3_3; // 乙肝病毒表面抗原 (HBsAg)检测值(IU/ml)
    public String getHBV_1_1_3_3() {  return this.HBV_1_1_3_3;}
    @JsonProperty("HBV-1-1-3-3")
    public void setHBV_1_1_3_3(final String HBV_1_1_3_3) { this.HBV_1_1_3_3=HBV_1_1_3_3;}
    @Column(name = "HBV_1_1_4_1")
    @JsonProperty("HBV-1-1-4-1")
    private String HBV_1_1_4_1; // 乙肝病毒表面抗体(HBsAb)检测选择
    public String getHBV_1_1_4_1() {  return this.HBV_1_1_4_1;}
    @JsonProperty("HBV-1-1-4-1")
    public void setHBV_1_1_4_1(final String HBV_1_1_4_1) { this.HBV_1_1_4_1=HBV_1_1_4_1;}
    @Column(name = "HBV_1_1_4_2")
    @JsonProperty("HBV-1-1-4-2")
    private String HBV_1_1_4_2; // 乙肝病毒表面抗体(HBsAb)定性检测选择
    public String getHBV_1_1_4_2() {  return this.HBV_1_1_4_2;}
    @JsonProperty("HBV-1-1-4-2")
    public void setHBV_1_1_4_2(final String HBV_1_1_4_2) { this.HBV_1_1_4_2=HBV_1_1_4_2;}
    @Column(name = "HBV_1_1_4_3")
    @JsonProperty("HBV-1-1-4-3")
    private String HBV_1_1_4_3; // 乙肝病毒表面抗体(HBsAb)检测值(IU/ml)
    public String getHBV_1_1_4_3() {  return this.HBV_1_1_4_3;}
    @JsonProperty("HBV-1-1-4-3")
    public void setHBV_1_1_4_3(final String HBV_1_1_4_3) { this.HBV_1_1_4_3=HBV_1_1_4_3;}
    @Column(name = "HBV_1_1_5_1")
    @JsonProperty("HBV-1-1-5-1")
    private String HBV_1_1_5_1; // 乙肝病毒e 抗原(HBeAg)检测选择
    public String getHBV_1_1_5_1() {  return this.HBV_1_1_5_1;}
    @JsonProperty("HBV-1-1-5-1")
    public void setHBV_1_1_5_1(final String HBV_1_1_5_1) { this.HBV_1_1_5_1=HBV_1_1_5_1;}
    @Column(name = "HBV_1_1_5_3")
    @JsonProperty("HBV-1-1-5-3")
    private String HBV_1_1_5_3; // 乙肝病毒e 抗原(HBeAg)检测值(IU/ml)
    public String getHBV_1_1_5_3() {  return this.HBV_1_1_5_3;}
    @JsonProperty("HBV-1-1-5-3")
    public void setHBV_1_1_5_3(final String HBV_1_1_5_3) { this.HBV_1_1_5_3=HBV_1_1_5_3;}
    @Column(name = "HBV_1_1_5_2")
    @JsonProperty("HBV-1-1-5-2")
    private String HBV_1_1_5_2; // 乙肝病毒e 抗原(HBeAg)定性检测选择
    public String getHBV_1_1_5_2() {  return this.HBV_1_1_5_2;}
    @JsonProperty("HBV-1-1-5-2")
    public void setHBV_1_1_5_2(final String HBV_1_1_5_2) { this.HBV_1_1_5_2=HBV_1_1_5_2;}
    @Column(name = "HBV_1_1_6_1")
    @JsonProperty("HBV-1-1-6-1")
    private String HBV_1_1_6_1; // 乙肝病毒e抗体(HBeAb)检测选择
    public String getHBV_1_1_6_1() {  return this.HBV_1_1_6_1;}
    @JsonProperty("HBV-1-1-6-1")
    public void setHBV_1_1_6_1(final String HBV_1_1_6_1) { this.HBV_1_1_6_1=HBV_1_1_6_1;}
    @Column(name = "HBV_1_1_6_2")
    @JsonProperty("HBV-1-1-6-2")
    private String HBV_1_1_6_2; // 乙肝病毒e抗体(HBeAb)定性检测选择
    public String getHBV_1_1_6_2() {  return this.HBV_1_1_6_2;}
    @JsonProperty("HBV-1-1-6-2")
    public void setHBV_1_1_6_2(final String HBV_1_1_6_2) { this.HBV_1_1_6_2=HBV_1_1_6_2;}
    @Column(name = "HBV_1_1_6_3")
    @JsonProperty("HBV-1-1-6-3")
    private String HBV_1_1_6_3; // 乙肝病毒e抗体(HBeAb)检测值(IU/ml)
    public String getHBV_1_1_6_3() {  return this.HBV_1_1_6_3;}
    @JsonProperty("HBV-1-1-6-3")
    public void setHBV_1_1_6_3(final String HBV_1_1_6_3) { this.HBV_1_1_6_3=HBV_1_1_6_3;}
    @Column(name = "HBV_1_1_7_1")
    @JsonProperty("HBV-1-1-7-1")
    private String HBV_1_1_7_1; // 乙肝病毒核心抗体(HBcAb)检测选择
    public String getHBV_1_1_7_1() {  return this.HBV_1_1_7_1;}
    @JsonProperty("HBV-1-1-7-1")
    public void setHBV_1_1_7_1(final String HBV_1_1_7_1) { this.HBV_1_1_7_1=HBV_1_1_7_1;}
    @Column(name = "HBV_1_1_7_2")
    @JsonProperty("HBV-1-1-7-2")
    private String HBV_1_1_7_2; // 乙肝病毒核心抗体(HBcAb)定性检测选择
    public String getHBV_1_1_7_2() {  return this.HBV_1_1_7_2;}
    @JsonProperty("HBV-1-1-7-2")
    public void setHBV_1_1_7_2(final String HBV_1_1_7_2) { this.HBV_1_1_7_2=HBV_1_1_7_2;}
    @Column(name = "HBV_1_1_7_3")
    @JsonProperty("HBV-1-1-7-3")
    private String HBV_1_1_7_3; // 乙肝病毒核心抗体(HBcAb)检测值(IU/ml)
    public String getHBV_1_1_7_3() {  return this.HBV_1_1_7_3;}
    @JsonProperty("HBV-1-1-7-3")
    public void setHBV_1_1_7_3(final String HBV_1_1_7_3) { this.HBV_1_1_7_3=HBV_1_1_7_3;}
    @Column(name = "HBV_1_1_3")
    @JsonProperty("HBV-1-1-3")
    private String HBV_1_1_3; // 乙肝病毒含量检测和风险评估 
    public String getHBV_1_1_3() {  return this.HBV_1_1_3;}
    @JsonProperty("HBV-1-1-3")
    public void setHBV_1_1_3(final String HBV_1_1_3) { this.HBV_1_1_3=HBV_1_1_3;}
    @Column(name = "HBV_1_1_4")
    @JsonProperty("HBV-1-1-4")
    private String HBV_1_1_4; // 丙氨酸氨基转移酶（ALT）水平检测值(U/L)
    public String getHBV_1_1_4() {  return this.HBV_1_1_4;}
    @JsonProperty("HBV-1-1-4")
    public void setHBV_1_1_4(final String HBV_1_1_4) { this.HBV_1_1_4=HBV_1_1_4;}
    @Column(name = "HBV_1_1_5")
    @JsonProperty("HBV-1-1-5")
    private String HBV_1_1_5; // 肝癌的肿瘤标志物甲胎蛋白(AFP) 检测值(ng/ml) 
    public String getHBV_1_1_5() {  return this.HBV_1_1_5;}
    @JsonProperty("HBV-1-1-5")
    public void setHBV_1_1_5(final String HBV_1_1_5) { this.HBV_1_1_5=HBV_1_1_5;}
    @Column(name = "HBV_1_1_6")
    @JsonProperty("HBV-1-1-6")
    private String HBV_1_1_6; // 上腹部超声
    public String getHBV_1_1_6() {  return this.HBV_1_1_6;}
    @JsonProperty("HBV-1-1-6")
    public void setHBV_1_1_6(final String HBV_1_1_6) { this.HBV_1_1_6=HBV_1_1_6;}
    @Column(name = "HBV_1_1_7")
    @JsonProperty("HBV-1-1-7")
    private String HBV_1_1_7; // 肝脏储备功能量化评估(Child-Pugh分级)结果分层
    public String getHBV_1_1_7() {  return this.HBV_1_1_7;}
    @JsonProperty("HBV-1-1-7")
    public void setHBV_1_1_7(final String HBV_1_1_7) { this.HBV_1_1_7=HBV_1_1_7;}
    @Column(name = "HBV_1_1_8")
    @JsonProperty("HBV-1-1-8")
    private String HBV_1_1_8; // 母婴传播风险评估
    public String getHBV_1_1_8() {  return this.HBV_1_1_8;}
    @JsonProperty("HBV-1-1-8")
    public void setHBV_1_1_8(final String HBV_1_1_8) { this.HBV_1_1_8=HBV_1_1_8;}
    @Column(name = "HBV_1_2_1")
    @JsonProperty("HBV-1-2-1")
    private String HBV_1_2_1; // 分娩方式的评估
    public String getHBV_1_2_1() {  return this.HBV_1_2_1;}
    @JsonProperty("HBV-1-2-1")
    public void setHBV_1_2_1(final String HBV_1_2_1) { this.HBV_1_2_1=HBV_1_2_1;}
    @Column(name = "HBV_1_2_1_1")
    @JsonProperty("HBV-1-2-1-1")
    private String HBV_1_2_1_1; // 分娩方式其他评估
    public String getHBV_1_2_1_1() {  return this.HBV_1_2_1_1;}
    @JsonProperty("HBV-1-2-1-1")
    public void setHBV_1_2_1_1(final String HBV_1_2_1_1) { this.HBV_1_2_1_1=HBV_1_2_1_1;}
    @Column(name = "HBV_1_2_2")
    @JsonProperty("HBV-1-2-2")
    private String HBV_1_2_2; // 分娩方式的选择
    public String getHBV_1_2_2() {  return this.HBV_1_2_2;}
    @JsonProperty("HBV-1-2-2")
    public void setHBV_1_2_2(final String HBV_1_2_2) { this.HBV_1_2_2=HBV_1_2_2;}
    @Column(name = "HBV_1_2_3")
    @JsonProperty("HBV-1-2-3")
    private String HBV_1_2_3; // 胎儿娩出日期时间
    public String getHBV_1_2_3() {  return this.HBV_1_2_3;}
    @JsonProperty("HBV-1-2-3")
    public void setHBV_1_2_3(final String HBV_1_2_3) { this.HBV_1_2_3=HBV_1_2_3;}
    @Column(name = "HBV_1_3_1")
    @JsonProperty("HBV-1-3-1")
    private String HBV_1_3_1; // 是否实施新生儿Apgar评分
    public String getHBV_1_3_1() {  return this.HBV_1_3_1;}
    @JsonProperty("HBV-1-3-1")
    public void setHBV_1_3_1(final String HBV_1_3_1) { this.HBV_1_3_1=HBV_1_3_1;}
    @Column(name = "HBV_1_3_2")
    @JsonProperty("HBV-1-3-2")
    private String HBV_1_3_2; // 新生儿出生后1min、5min、10min,Apgar评分选择
    public String getHBV_1_3_2() {  return this.HBV_1_3_2;}
    @JsonProperty("HBV-1-3-2")
    public void setHBV_1_3_2(final String HBV_1_3_2) { this.HBV_1_3_2=HBV_1_3_2;}
    @Column(name = "HBV_1_3_2_1")
    @JsonProperty("HBV-1-3-2-1")
    private String HBV_1_3_2_1; // 出生后1min Apgar评分值
    public String getHBV_1_3_2_1() {  return this.HBV_1_3_2_1;}
    @JsonProperty("HBV-1-3-2-1")
    public void setHBV_1_3_2_1(final String HBV_1_3_2_1) { this.HBV_1_3_2_1=HBV_1_3_2_1;}
    @Column(name = "HBV_1_3_2_2")
    @JsonProperty("HBV-1-3-2-2")
    private String HBV_1_3_2_2; // 出生后5min Apgar评分值
    public String getHBV_1_3_2_2() {  return this.HBV_1_3_2_2;}
    @JsonProperty("HBV-1-3-2-2")
    public void setHBV_1_3_2_2(final String HBV_1_3_2_2) { this.HBV_1_3_2_2=HBV_1_3_2_2;}
    @Column(name = "HBV_1_3_2_3")
    @JsonProperty("HBV-1-3-2-3")
    private String HBV_1_3_2_3; // 出生后10min Apgar评分值
    public String getHBV_1_3_2_3() {  return this.HBV_1_3_2_3;}
    @JsonProperty("HBV-1-3-2-3")
    public void setHBV_1_3_2_3(final String HBV_1_3_2_3) { this.HBV_1_3_2_3=HBV_1_3_2_3;}
    @Column(name = "HBV_1_4_1")
    @JsonProperty("HBV-1-4-1")
    private String HBV_1_4_1; // 分娩是否有并发症
    public String getHBV_1_4_1() {  return this.HBV_1_4_1;}
    @JsonProperty("HBV-1-4-1")
    public void setHBV_1_4_1(final String HBV_1_4_1) { this.HBV_1_4_1=HBV_1_4_1;}
    @Column(name = "HBV_1_4_2")
    @JsonProperty("HBV-1-4-2")
    private String HBV_1_4_2; // 分娩并发症ICD.10编码选择
    public String getHBV_1_4_2() {  return this.HBV_1_4_2;}
    @JsonProperty("HBV-1-4-2")
    public void setHBV_1_4_2(final String HBV_1_4_2) { this.HBV_1_4_2=HBV_1_4_2;}
    @Column(name = "HBV_1_4_2_1")
    @JsonProperty("HBV-1-4-2-1")
    private String HBV_1_4_2_1; // 产后出血
    public String getHBV_1_4_2_1() {  return this.HBV_1_4_2_1;}
    @JsonProperty("HBV-1-4-2-1")
    public void setHBV_1_4_2_1(final String HBV_1_4_2_1) { this.HBV_1_4_2_1=HBV_1_4_2_1;}
    @Column(name = "HBV_1_4_2_2")
    @JsonProperty("HBV-1-4-2-2")
    private String HBV_1_4_2_2; // 产褥期感染
    public String getHBV_1_4_2_2() {  return this.HBV_1_4_2_2;}
    @JsonProperty("HBV-1-4-2-2")
    public void setHBV_1_4_2_2(final String HBV_1_4_2_2) { this.HBV_1_4_2_2=HBV_1_4_2_2;}
    @Column(name = "HBV_1_4_2_3")
    @JsonProperty("HBV-1-4-2-3")
    private String HBV_1_4_2_3; // 其他产褥期感染
    public String getHBV_1_4_2_3() {  return this.HBV_1_4_2_3;}
    @JsonProperty("HBV-1-4-2-3")
    public void setHBV_1_4_2_3(final String HBV_1_4_2_3) { this.HBV_1_4_2_3=HBV_1_4_2_3;}
    @Column(name = "HBV_1_4_2_4")
    @JsonProperty("HBV-1-4-2-4")
    private String HBV_1_4_2_4; // 产科栓塞
    public String getHBV_1_4_2_4() {  return this.HBV_1_4_2_4;}
    @JsonProperty("HBV-1-4-2-4")
    public void setHBV_1_4_2_4(final String HBV_1_4_2_4) { this.HBV_1_4_2_4=HBV_1_4_2_4;}
    @Column(name = "HBV_1_4_2_5")
    @JsonProperty("HBV-1-4-2-5")
    private String HBV_1_4_2_5; // 静脉栓塞病
    public String getHBV_1_4_2_5() {  return this.HBV_1_4_2_5;}
    @JsonProperty("HBV-1-4-2-5")
    public void setHBV_1_4_2_5(final String HBV_1_4_2_5) { this.HBV_1_4_2_5=HBV_1_4_2_5;}
    @Column(name = "HBV_1_4_2_6")
    @JsonProperty("HBV-1-4-2-6")
    private String HBV_1_4_2_6; // 胎盘和胎膜滞留不伴有出血
    public String getHBV_1_4_2_6() {  return this.HBV_1_4_2_6;}
    @JsonProperty("HBV-1-4-2-6")
    public void setHBV_1_4_2_6(final String HBV_1_4_2_6) { this.HBV_1_4_2_6=HBV_1_4_2_6;}
    @Column(name = "HBV_1_4_2_7")
    @JsonProperty("HBV-1-4-2-7")
    private String HBV_1_4_2_7; // 产科手术伤口的感染
    public String getHBV_1_4_2_7() {  return this.HBV_1_4_2_7;}
    @JsonProperty("HBV-1-4-2-7")
    public void setHBV_1_4_2_7(final String HBV_1_4_2_7) { this.HBV_1_4_2_7=HBV_1_4_2_7;}
    @Column(name = "HBV_1_4_2_8")
    @JsonProperty("HBV-1-4-2-8")
    private String HBV_1_4_2_8; // 产科伤口裂开
    public String getHBV_1_4_2_8() {  return this.HBV_1_4_2_8;}
    @JsonProperty("HBV-1-4-2-8")
    public void setHBV_1_4_2_8(final String HBV_1_4_2_8) { this.HBV_1_4_2_8=HBV_1_4_2_8;}
    @Column(name = "HBV_1_4_2_9")
    @JsonProperty("HBV-1-4-2-9")
    private String HBV_1_4_2_9; // 其他并发症
    public String getHBV_1_4_2_9() {  return this.HBV_1_4_2_9;}
    @JsonProperty("HBV-1-4-2-9")
    public void setHBV_1_4_2_9(final String HBV_1_4_2_9) { this.HBV_1_4_2_9=HBV_1_4_2_9;}
    @Column(name = "HBV_1_4_2_10")
    @JsonProperty("HBV-1-4-2-10")
    private String HBV_1_4_2_10; // 其他并发症
    public String getHBV_1_4_2_10() {  return this.HBV_1_4_2_10;}
    @JsonProperty("HBV-1-4-2-10")
    public void setHBV_1_4_2_10(final String HBV_1_4_2_10) { this.HBV_1_4_2_10=HBV_1_4_2_10;}
    @Column(name = "HBV_1_5_1")
    @JsonProperty("HBV-1-5-1")
    private String HBV_1_5_1; // 新生儿是否产伤
    public String getHBV_1_5_1() {  return this.HBV_1_5_1;}
    @JsonProperty("HBV-1-5-1")
    public void setHBV_1_5_1(final String HBV_1_5_1) { this.HBV_1_5_1=HBV_1_5_1;}
    @Column(name = "HBV_1_5_2")
    @JsonProperty("HBV-1-5-2")
    private String HBV_1_5_2; // 产程和分娩期间并发症所列的名称及ICD.10编码
    public String getHBV_1_5_2() {  return this.HBV_1_5_2;}
    @JsonProperty("HBV-1-5-2")
    public void setHBV_1_5_2(final String HBV_1_5_2) { this.HBV_1_5_2=HBV_1_5_2;}
    @Column(name = "HBV_1_5_2_1")
    @JsonProperty("HBV-1-5-2-1")
    private String HBV_1_5_2_1; // P10产伤引起的颅内撕裂和出血
    public String getHBV_1_5_2_1() {  return this.HBV_1_5_2_1;}
    @JsonProperty("HBV-1-5-2-1")
    public void setHBV_1_5_2_1(final String HBV_1_5_2_1) { this.HBV_1_5_2_1=HBV_1_5_2_1;}
    @Column(name = "HBV_1_5_2_2")
    @JsonProperty("HBV-1-5-2-2")
    private String HBV_1_5_2_2; // P11产伤致新生儿脑伤
    public String getHBV_1_5_2_2() {  return this.HBV_1_5_2_2;}
    @JsonProperty("HBV-1-5-2-2")
    public void setHBV_1_5_2_2(final String HBV_1_5_2_2) { this.HBV_1_5_2_2=HBV_1_5_2_2;}
    @Column(name = "HBV_1_5_2_3")
    @JsonProperty("HBV-1-5-2-3")
    private String HBV_1_5_2_3; // P12头皮产伤
    public String getHBV_1_5_2_3() {  return this.HBV_1_5_2_3;}
    @JsonProperty("HBV-1-5-2-3")
    public void setHBV_1_5_2_3(final String HBV_1_5_2_3) { this.HBV_1_5_2_3=HBV_1_5_2_3;}
    @Column(name = "HBV_1_5_2_4")
    @JsonProperty("HBV-1-5-2-4")
    private String HBV_1_5_2_4; // P13颅骨产伤
    public String getHBV_1_5_2_4() {  return this.HBV_1_5_2_4;}
    @JsonProperty("HBV-1-5-2-4")
    public void setHBV_1_5_2_4(final String HBV_1_5_2_4) { this.HBV_1_5_2_4=HBV_1_5_2_4;}
    @Column(name = "HBV_1_5_2_5")
    @JsonProperty("HBV-1-5-2-5")
    private String HBV_1_5_2_5; // P14神经产伤
    public String getHBV_1_5_2_5() {  return this.HBV_1_5_2_5;}
    @JsonProperty("HBV-1-5-2-5")
    public void setHBV_1_5_2_5(final String HBV_1_5_2_5) { this.HBV_1_5_2_5=HBV_1_5_2_5;}
    @Column(name = "HBV_1_5_2_6")
    @JsonProperty("HBV-1-5-2-6")
    private String HBV_1_5_2_6; // P15其他产伤
    public String getHBV_1_5_2_6() {  return this.HBV_1_5_2_6;}
    @JsonProperty("HBV-1-5-2-6")
    public void setHBV_1_5_2_6(final String HBV_1_5_2_6) { this.HBV_1_5_2_6=HBV_1_5_2_6;}
    @Column(name = "HBV_1_5_2_7")
    @JsonProperty("HBV-1-5-2-7")
    private String HBV_1_5_2_7; // P20子宫内低氧症
    public String getHBV_1_5_2_7() {  return this.HBV_1_5_2_7;}
    @JsonProperty("HBV-1-5-2-7")
    public void setHBV_1_5_2_7(final String HBV_1_5_2_7) { this.HBV_1_5_2_7=HBV_1_5_2_7;}
    @Column(name = "HBV_1_5_2_8")
    @JsonProperty("HBV-1-5-2-8")
    private String HBV_1_5_2_8; // P21出生窒息
    public String getHBV_1_5_2_8() {  return this.HBV_1_5_2_8;}
    @JsonProperty("HBV-1-5-2-8")
    public void setHBV_1_5_2_8(final String HBV_1_5_2_8) { this.HBV_1_5_2_8=HBV_1_5_2_8;}
    @Column(name = "HBV_1_5_3")
    @JsonProperty("HBV-1-5-3")
    private String HBV_1_5_3; // 是否新生儿先天性畸形、变形和染色体异常
    public String getHBV_1_5_3() {  return this.HBV_1_5_3;}
    @JsonProperty("HBV-1-5-3")
    public void setHBV_1_5_3(final String HBV_1_5_3) { this.HBV_1_5_3=HBV_1_5_3;}
    @Column(name = "HBV_1_5_4")
    @JsonProperty("HBV-1-5-4")
    private String HBV_1_5_4; // 新生儿:先天性畸形、变形和染色体异常的名称及ICD.10编码
    public String getHBV_1_5_4() {  return this.HBV_1_5_4;}
    @JsonProperty("HBV-1-5-4")
    public void setHBV_1_5_4(final String HBV_1_5_4) { this.HBV_1_5_4=HBV_1_5_4;}
    @Column(name = "HBV_2_1_1")
    @JsonProperty("HBV-2-1-1")
    private String HBV_2_1_1; // 是否实施感染母亲使用抗病毒治疗
    public String getHBV_2_1_1() {  return this.HBV_2_1_1;}
    @JsonProperty("HBV-2-1-1")
    public void setHBV_2_1_1(final String HBV_2_1_1) { this.HBV_2_1_1=HBV_2_1_1;}
    @Column(name = "HBV_2_1_2")
    @JsonProperty("HBV-2-1-2")
    private String HBV_2_1_2; // 高病毒载量 HBV感染母亲,母婴传播阻断选择意见
    public String getHBV_2_1_2() {  return this.HBV_2_1_2;}
    @JsonProperty("HBV-2-1-2")
    public void setHBV_2_1_2(final String HBV_2_1_2) { this.HBV_2_1_2=HBV_2_1_2;}
    @Column(name = "HBV_2_1_2_1")
    @JsonProperty("HBV-2-1-2-1")
    private String HBV_2_1_2_1; // 高病毒载量 HBV感染母亲,母婴传播阻断其他意见
    public String getHBV_2_1_2_1() {  return this.HBV_2_1_2_1;}
    @JsonProperty("HBV-2-1-2-1")
    public void setHBV_2_1_2_1(final String HBV_2_1_2_1) { this.HBV_2_1_2_1=HBV_2_1_2_1;}
    @Column(name = "HBV_2_2_1")
    @JsonProperty("HBV-2-2-1")
    private String HBV_2_2_1; // 感染母亲使用抗病毒药物
    public String getHBV_2_2_1() {  return this.HBV_2_2_1;}
    @JsonProperty("HBV-2-2-1")
    public void setHBV_2_2_1(final String HBV_2_2_1) { this.HBV_2_2_1=HBV_2_2_1;}
    @Column(name = "HBV_2_1_3_1")
    @JsonProperty("HBV-2-1-3-1")
    private String HBV_2_1_3_1; // 感染母亲使用其他抗病毒药物
    public String getHBV_2_1_3_1() {  return this.HBV_2_1_3_1;}
    @JsonProperty("HBV-2-1-3-1")
    public void setHBV_2_1_3_1(final String HBV_2_1_3_1) { this.HBV_2_1_3_1=HBV_2_1_3_1;}
    @Column(name = "HBV_2_3_1")
    @JsonProperty("HBV-2-3-1")
    private String HBV_2_3_1; // 入院前是否已经使用抗病毒药物
    public String getHBV_2_3_1() {  return this.HBV_2_3_1;}
    @JsonProperty("HBV-2-3-1")
    public void setHBV_2_3_1(final String HBV_2_3_1) { this.HBV_2_3_1=HBV_2_3_1;}
    @Column(name = "HBV_2_3_2")
    @JsonProperty("HBV-2-3-2")
    private String HBV_2_3_2; // 入院后抗病毒治疗起始日期
    public String getHBV_2_3_2() {  return this.HBV_2_3_2;}
    @JsonProperty("HBV-2-3-2")
    public void setHBV_2_3_2(final String HBV_2_3_2) { this.HBV_2_3_2=HBV_2_3_2;}
    @Column(name = "HBV_3_1_1")
    @JsonProperty("HBV-3-1-1")
    private String HBV_3_1_1; // 是否预防母婴传播的干预措施
    public String getHBV_3_1_1() {  return this.HBV_3_1_1;}
    @JsonProperty("HBV-3-1-1")
    public void setHBV_3_1_1(final String HBV_3_1_1) { this.HBV_3_1_1=HBV_3_1_1;}
    @Column(name = "HBV_3_1_2")
    @JsonProperty("HBV-3-1-2")
    private String HBV_3_1_2; // 新生儿干预措施
    public String getHBV_3_1_2() {  return this.HBV_3_1_2;}
    @JsonProperty("HBV-3-1-2")
    public void setHBV_3_1_2(final String HBV_3_1_2) { this.HBV_3_1_2=HBV_3_1_2;}
    @Column(name = "HBV_3_1_2_1")
    @JsonProperty("HBV-3-1-2-1")
    private String HBV_3_1_2_1; // 新生儿干预其他措施
    public String getHBV_3_1_2_1() {  return this.HBV_3_1_2_1;}
    @JsonProperty("HBV-3-1-2-1")
    public void setHBV_3_1_2_1(final String HBV_3_1_2_1) { this.HBV_3_1_2_1=HBV_3_1_2_1;}
    @Column(name = "HBV_4_1_1")
    @JsonProperty("HBV-4-1-1")
    private String HBV_4_1_1; // 是否有婴儿联合免疫预防接种
    public String getHBV_4_1_1() {  return this.HBV_4_1_1;}
    @JsonProperty("HBV-4-1-1")
    public void setHBV_4_1_1(final String HBV_4_1_1) { this.HBV_4_1_1=HBV_4_1_1;}
    @Column(name = "HBV_4_1_2")
    @JsonProperty("HBV-4-1-2")
    private String HBV_4_1_2; // 预防接种日期时间
    public String getHBV_4_1_2() {  return this.HBV_4_1_2;}
    @JsonProperty("HBV-4-1-2")
    public void setHBV_4_1_2(final String HBV_4_1_2) { this.HBV_4_1_2=HBV_4_1_2;}
    @Column(name = "HBV_4_2_1")
    @JsonProperty("HBV-4-2-1")
    private String HBV_4_2_1; // 预防接种"乙肝免疫"的制剂
    public String getHBV_4_2_1() {  return this.HBV_4_2_1;}
    @JsonProperty("HBV-4-2-1")
    public void setHBV_4_2_1(final String HBV_4_2_1) { this.HBV_4_2_1=HBV_4_2_1;}
    @Column(name = "HBV_4_2_1_1")
    @JsonProperty("HBV-4-2-1-1")
    private String HBV_4_2_1_1; // 其他乙肝免疫制剂
    public String getHBV_4_2_1_1() {  return this.HBV_4_2_1_1;}
    @JsonProperty("HBV-4-2-1-1")
    public void setHBV_4_2_1_1(final String HBV_4_2_1_1) { this.HBV_4_2_1_1=HBV_4_2_1_1;}
    @Column(name = "HBV_4_3_1")
    @JsonProperty("HBV-4-3-1")
    private String HBV_4_3_1; // 是否在住院病历中有乙肝免疫球蛋白电子监管码（每支球蛋白的生产企业、批号、剂量、有效期）的记录
    public String getHBV_4_3_1() {  return this.HBV_4_3_1;}
    @JsonProperty("HBV-4-3-1")
    public void setHBV_4_3_1(final String HBV_4_3_1) { this.HBV_4_3_1=HBV_4_3_1;}
    @Column(name = "HBV_4_3_2")
    @JsonProperty("HBV-4-3-2")
    private String HBV_4_3_2; // 是否有推送至"县、市"免疫规划信息系统
    public String getHBV_4_3_2() {  return this.HBV_4_3_2;}
    @JsonProperty("HBV-4-3-2")
    public void setHBV_4_3_2(final String HBV_4_3_2) { this.HBV_4_3_2=HBV_4_3_2;}
    @Column(name = "HBV_5_1_1")
    @JsonProperty("HBV-5-1-1")
    private String HBV_5_1_1; // 是否预防母婴传播的干预措施
    public String getHBV_5_1_1() {  return this.HBV_5_1_1;}
    @JsonProperty("HBV-5-1-1")
    public void setHBV_5_1_1(final String HBV_5_1_1) { this.HBV_5_1_1=HBV_5_1_1;}
    @Column(name = "HBV_5_1_2")
    @JsonProperty("HBV-5-1-2")
    private String HBV_5_1_2; // 母乳喂养禁忌症
    public String getHBV_5_1_2() {  return this.HBV_5_1_2;}
    @JsonProperty("HBV-5-1-2")
    public void setHBV_5_1_2(final String HBV_5_1_2) { this.HBV_5_1_2=HBV_5_1_2;}
    @Column(name = "HBV_5_1_2_1")
    @JsonProperty("HBV-5-1-2-1")
    private String HBV_5_1_2_1; // 不适宜母乳喂养的其他疾病
    public String getHBV_5_1_2_1() {  return this.HBV_5_1_2_1;}
    @JsonProperty("HBV-5-1-2-1")
    public void setHBV_5_1_2_1(final String HBV_5_1_2_1) { this.HBV_5_1_2_1=HBV_5_1_2_1;}
    @Column(name = "HBV_5_1_3")
    @JsonProperty("HBV-5-1-3")
    private String HBV_5_1_3; // 是否提供母乳喂养
    public String getHBV_5_1_3() {  return this.HBV_5_1_3;}
    @JsonProperty("HBV-5-1-3")
    public void setHBV_5_1_3(final String HBV_5_1_3) { this.HBV_5_1_3=HBV_5_1_3;}
    @Column(name = "HBV_6_1_1")
    @JsonProperty("HBV-6-1-1")
    private String HBV_6_1_1; // HBV 感染女性产后复查
    public String getHBV_6_1_1() {  return this.HBV_6_1_1;}
    @JsonProperty("HBV-6-1-1")
    public void setHBV_6_1_1(final String HBV_6_1_1) { this.HBV_6_1_1=HBV_6_1_1;}
    @Column(name = "HBV_6_1_1_1")
    @JsonProperty("HBV-6-1-1-1")
    private String HBV_6_1_1_1; // 感染女性产后复查告知的其他事项
    public String getHBV_6_1_1_1() {  return this.HBV_6_1_1_1;}
    @JsonProperty("HBV-6-1-1-1")
    public void setHBV_6_1_1_1(final String HBV_6_1_1_1) { this.HBV_6_1_1_1=HBV_6_1_1_1;}
    @Column(name = "HBV_6_1_2")
    @JsonProperty("HBV-6-1-2")
    private String HBV_6_1_2; // HBV感染孕妇所生新生儿的随访
    public String getHBV_6_1_2() {  return this.HBV_6_1_2;}
    @JsonProperty("HBV-6-1-2")
    public void setHBV_6_1_2(final String HBV_6_1_2) { this.HBV_6_1_2=HBV_6_1_2;}
    @Column(name = "HBV_6_1_2_1")
    @JsonProperty("HBV-6-1-2-1")
    private String HBV_6_1_2_1; // 感染孕妇所生新生儿随访告知的其他事项
    public String getHBV_6_1_2_1() {  return this.HBV_6_1_2_1;}
    @JsonProperty("HBV-6-1-2-1")
    public void setHBV_6_1_2_1(final String HBV_6_1_2_1) { this.HBV_6_1_2_1=HBV_6_1_2_1;}
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