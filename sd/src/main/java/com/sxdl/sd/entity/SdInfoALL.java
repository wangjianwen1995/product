package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：C91.0，且伴主要操作 ICD-9-CM-3编码：99.25 的出院患儿。
*/
@ApiModel(value = "48信息")
@Entity
@Table(name = "sd_info_ALL")
public class SdInfoALL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    public void setId(final Integer id) {this.id = id;}
    public Integer getId() {return this.id;}
    @Column(name = "ALL_0_1_1")
    @JsonProperty("ALL-0-1-1")
    private String ALL_0_1_1; // 治疗模式
    public String getALL_0_1_1() {  return this.ALL_0_1_1;}
    @JsonProperty("ALL-0-1-1")
    public void setALL_0_1_1(final String ALL_0_1_1) { this.ALL_0_1_1=ALL_0_1_1;}
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
    private String caseId; // 患儿病案号
    public String getCaseId() {  return this.caseId;}
    @JsonProperty("caseId")
    public void setCaseId(final String caseId) { this.caseId=caseId;}
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard; // 患儿身份证号
    public String getIDCard() {  return this.IDCard;}
    @JsonProperty("IDCard")
    public void setIDCard(final String IDCard) { this.IDCard=IDCard;}
    @Column(name = "CM_0_1_3_1")
    @JsonProperty("CM-0-1-3-1")
    private String CM_0_1_3_1; // 主要诊断ICD-10四位亚目编码与名称
    public String getCM_0_1_3_1() {  return this.CM_0_1_3_1;}
    @JsonProperty("CM-0-1-3-1")
    public void setCM_0_1_3_1(final String CM_0_1_3_1) { this.CM_0_1_3_1=CM_0_1_3_1;}
    @Column(name = "ALL_0_1_3_1")
    @JsonProperty("ALL-0-1-3-1")
    private String ALL_0_1_3_1; // 其他主要诊断ICD-10四位亚目编码与名称
    public String getALL_0_1_3_1() {  return this.ALL_0_1_3_1;}
    @JsonProperty("ALL-0-1-3-1")
    public void setALL_0_1_3_1(final String ALL_0_1_3_1) { this.ALL_0_1_3_1=ALL_0_1_3_1;}
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    public String getCM_0_1_3_2() {  return this.CM_0_1_3_2;}
    @JsonProperty("CM-0-1-3-2")
    public void setCM_0_1_3_2(final String CM_0_1_3_2) { this.CM_0_1_3_2=CM_0_1_3_2;}
    @Column(name = "ALL_0_1_3_2")
    @JsonProperty("ALL-0-1-3-2")
    private String ALL_0_1_3_2; // 其他主要诊断ICD-10六位临床扩展编码与名称
    public String getALL_0_1_3_2() {  return this.ALL_0_1_3_2;}
    @JsonProperty("ALL-0-1-3-2")
    public void setALL_0_1_3_2(final String ALL_0_1_3_2) { this.ALL_0_1_3_2=ALL_0_1_3_2;}
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    public String getCM_0_1_4_1() {  return this.CM_0_1_4_1;}
    @JsonProperty("CM-0-1-4-1")
    public void setCM_0_1_4_1(final String CM_0_1_4_1) { this.CM_0_1_4_1=CM_0_1_4_1;}
    @Column(name = "ALL_0_1_4_1")
    @JsonProperty("ALL-0-1-4-1")
    private String ALL_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    public String getALL_0_1_4_1() {  return this.ALL_0_1_4_1;}
    @JsonProperty("ALL-0-1-4-1")
    public void setALL_0_1_4_1(final String ALL_0_1_4_1) { this.ALL_0_1_4_1=ALL_0_1_4_1;}
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    public String getCM_0_1_4_2() {  return this.CM_0_1_4_2;}
    @JsonProperty("CM-0-1-4-2")
    public void setCM_0_1_4_2(final String CM_0_1_4_2) { this.CM_0_1_4_2=CM_0_1_4_2;}
    @Column(name = "ALL_0_1_4_2")
    @JsonProperty("ALL-0-1-4-2")
    private String ALL_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
    public String getALL_0_1_4_2() {  return this.ALL_0_1_4_2;}
    @JsonProperty("ALL-0-1-4-2")
    public void setALL_0_1_4_2(final String ALL_0_1_4_2) { this.ALL_0_1_4_2=ALL_0_1_4_2;}
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否出院后31天内非计划重复住院
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
    private String CM_0_2_1_2; // 患儿性别
    public String getCM_0_2_1_2() {  return this.CM_0_2_1_2;}
    @JsonProperty("CM-0-2-1-2")
    public void setCM_0_2_1_2(final String CM_0_2_1_2) { this.CM_0_2_1_2=CM_0_2_1_2;}
    @Column(name = "CM_0_2_1_3")
    @JsonProperty("CM-0-2-1-3")
    private String CM_0_2_1_3; // 患儿体重（kg）
    public String getCM_0_2_1_3() {  return this.CM_0_2_1_3;}
    @JsonProperty("CM-0-2-1-3")
    public void setCM_0_2_1_3(final String CM_0_2_1_3) { this.CM_0_2_1_3=CM_0_2_1_3;}
    @Column(name = "CM_0_2_1_5")
    @JsonProperty("CM-0-2-1-5")
    private String CM_0_2_1_5; // 患儿身高（cm）
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
    @Column(name = "ALL_0_2_3_1")
    @JsonProperty("ALL-0-2-3-1")
    private String ALL_0_2_3_1; // 入住日间化疗日期时间是否无法确定或无记录
    public String getALL_0_2_3_1() {  return this.ALL_0_2_3_1;}
    @JsonProperty("ALL-0-2-3-1")
    public void setALL_0_2_3_1(final String ALL_0_2_3_1) { this.ALL_0_2_3_1=ALL_0_2_3_1;}
    @Column(name = "ALL_0_2_3_2")
    @JsonProperty("ALL-0-2-3-2")
    private String ALL_0_2_3_2; // 入住日间化疗日期时间
    public String getALL_0_2_3_2() {  return this.ALL_0_2_3_2;}
    @JsonProperty("ALL-0-2-3-2")
    public void setALL_0_2_3_2(final String ALL_0_2_3_2) { this.ALL_0_2_3_2=ALL_0_2_3_2;}
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
    @Column(name = "ALL_1_1_1")
    @JsonProperty("ALL-1-1-1")
    private String ALL_1_1_1; // 临床主要症状体征
    public String getALL_1_1_1() {  return this.ALL_1_1_1;}
    @JsonProperty("ALL-1-1-1")
    public void setALL_1_1_1(final String ALL_1_1_1) { this.ALL_1_1_1=ALL_1_1_1;}
    @Column(name = "ALL_1_1_1_1")
    @JsonProperty("ALL-1-1-1-1")
    private String ALL_1_1_1_1; // 临床主要症状其他体征
    public String getALL_1_1_1_1() {  return this.ALL_1_1_1_1;}
    @JsonProperty("ALL-1-1-1-1")
    public void setALL_1_1_1_1(final String ALL_1_1_1_1) { this.ALL_1_1_1_1=ALL_1_1_1_1;}
    @Column(name = "ALL_1_1_2")
    @JsonProperty("ALL-1-1-2")
    private String ALL_1_1_2; // 血液常规、生化、凝血检查
    public String getALL_1_1_2() {  return this.ALL_1_1_2;}
    @JsonProperty("ALL-1-1-2")
    public void setALL_1_1_2(final String ALL_1_1_2) { this.ALL_1_1_2=ALL_1_1_2;}
    @Column(name = "ALL_1_1_2_1")
    @JsonProperty("ALL-1-1-2-1")
    private String ALL_1_1_2_1; // 血液常规、生化、凝血其他检查
    public String getALL_1_1_2_1() {  return this.ALL_1_1_2_1;}
    @JsonProperty("ALL-1-1-2-1")
    public void setALL_1_1_2_1(final String ALL_1_1_2_1) { this.ALL_1_1_2_1=ALL_1_1_2_1;}
    @Column(name = "ALL_1_1_3")
    @JsonProperty("ALL-1-1-3")
    private String ALL_1_1_3; // 影像学检查
    public String getALL_1_1_3() {  return this.ALL_1_1_3;}
    @JsonProperty("ALL-1-1-3")
    public void setALL_1_1_3(final String ALL_1_1_3) { this.ALL_1_1_3=ALL_1_1_3;}
    @Column(name = "ALL_1_1_3_1")
    @JsonProperty("ALL-1-1-3-1")
    private String ALL_1_1_3_1; // 影像学其他检查
    public String getALL_1_1_3_1() {  return this.ALL_1_1_3_1;}
    @JsonProperty("ALL-1-1-3-1")
    public void setALL_1_1_3_1(final String ALL_1_1_3_1) { this.ALL_1_1_3_1=ALL_1_1_3_1;}
    @Column(name = "ALL_1_1_4")
    @JsonProperty("ALL-1-1-4")
    private String ALL_1_1_4; // 脑脊液检查
    public String getALL_1_1_4() {  return this.ALL_1_1_4;}
    @JsonProperty("ALL-1-1-4")
    public void setALL_1_1_4(final String ALL_1_1_4) { this.ALL_1_1_4=ALL_1_1_4;}
    @Column(name = "ALL_1_1_4_1")
    @JsonProperty("ALL-1-1-4-1")
    private String ALL_1_1_4_1; // 脑脊液其他检查
    public String getALL_1_1_4_1() {  return this.ALL_1_1_4_1;}
    @JsonProperty("ALL-1-1-4-1")
    public void setALL_1_1_4_1(final String ALL_1_1_4_1) { this.ALL_1_1_4_1=ALL_1_1_4_1;}
    @Column(name = "ALL_1_1_5")
    @JsonProperty("ALL-1-1-5")
    private String ALL_1_1_5; // 上述三项，最末一项检查完成日期
    public String getALL_1_1_5() {  return this.ALL_1_1_5;}
    @JsonProperty("ALL-1-1-5")
    public void setALL_1_1_5(final String ALL_1_1_5) { this.ALL_1_1_5=ALL_1_1_5;}
    @Column(name = "ALL_1_2_1")
    @JsonProperty("ALL-1-2-1")
    private String ALL_1_2_1; // 骨髓细胞学及细胞化学检查
    public String getALL_1_2_1() {  return this.ALL_1_2_1;}
    @JsonProperty("ALL-1-2-1")
    public void setALL_1_2_1(final String ALL_1_2_1) { this.ALL_1_2_1=ALL_1_2_1;}
    @Column(name = "ALL_1_2_2")
    @JsonProperty("ALL-1-2-2")
    private String ALL_1_2_2; // 免疫分型检查
    public String getALL_1_2_2() {  return this.ALL_1_2_2;}
    @JsonProperty("ALL-1-2-2")
    public void setALL_1_2_2(final String ALL_1_2_2) { this.ALL_1_2_2=ALL_1_2_2;}
    @Column(name = "ALL_1_2_2_1")
    @JsonProperty("ALL-1-2-2-1")
    private String ALL_1_2_2_1; // 免疫分型-B细胞型 ALL型别
    public String getALL_1_2_2_1() {  return this.ALL_1_2_2_1;}
    @JsonProperty("ALL-1-2-2-1")
    public void setALL_1_2_2_1(final String ALL_1_2_2_1) { this.ALL_1_2_2_1=ALL_1_2_2_1;}
    @Column(name = "ALL_1_2_2_2")
    @JsonProperty("ALL-1-2-2-2")
    private String ALL_1_2_2_2; // 免疫分型-T细胞型 ALL型别
    public String getALL_1_2_2_2() {  return this.ALL_1_2_2_2;}
    @JsonProperty("ALL-1-2-2-2")
    public void setALL_1_2_2_2(final String ALL_1_2_2_2) { this.ALL_1_2_2_2=ALL_1_2_2_2;}
    @Column(name = "ALL_1_2_2_5")
    @JsonProperty("ALL-1-2-2-5")
    private String ALL_1_2_2_5; // 细胞遗传学和分子生物学检查
    public String getALL_1_2_2_5() {  return this.ALL_1_2_2_5;}
    @JsonProperty("ALL-1-2-2-5")
    public void setALL_1_2_2_5(final String ALL_1_2_2_5) { this.ALL_1_2_2_5=ALL_1_2_2_5;}
    @Column(name = "ALL_1_2_2_4")
    @JsonProperty("ALL-1-2-2-4")
    private String ALL_1_2_2_4; // 细胞遗传学和分子生物学其他检查
    public String getALL_1_2_2_4() {  return this.ALL_1_2_2_4;}
    @JsonProperty("ALL-1-2-2-4")
    public void setALL_1_2_2_4(final String ALL_1_2_2_4) { this.ALL_1_2_2_4=ALL_1_2_2_4;}
    @Column(name = "ALL_1_2_5")
    @JsonProperty("ALL-1-2-5")
    private String ALL_1_2_5; // 上述最末一项检查完成日期
    public String getALL_1_2_5() {  return this.ALL_1_2_5;}
    @JsonProperty("ALL-1-2-5")
    public void setALL_1_2_5(final String ALL_1_2_5) { this.ALL_1_2_5=ALL_1_2_5;}
    @Column(name = "ALL_2_1_1")
    @JsonProperty("ALL-2-1-1")
    private String ALL_2_1_1; // 诊断与分型符合WHO2016诊断标准
    public String getALL_2_1_1() {  return this.ALL_2_1_1;}
    @JsonProperty("ALL-2-1-1")
    public void setALL_2_1_1(final String ALL_2_1_1) { this.ALL_2_1_1=ALL_2_1_1;}
    @Column(name = "ALL_2_1_2")
    @JsonProperty("ALL-2-1-2")
    private String ALL_2_1_2; // 临床危险度分层
    public String getALL_2_1_2() {  return this.ALL_2_1_2;}
    @JsonProperty("ALL-2-1-2")
    public void setALL_2_1_2(final String ALL_2_1_2) { this.ALL_2_1_2=ALL_2_1_2;}
    @Column(name = "ALL_2_2_1")
    @JsonProperty("ALL-2-2-1")
    private String ALL_2_2_1; // 低危（Low Risk，LR）判断条件
    public String getALL_2_2_1() {  return this.ALL_2_2_1;}
    @JsonProperty("ALL-2-2-1")
    public void setALL_2_2_1(final String ALL_2_2_1) { this.ALL_2_2_1=ALL_2_2_1;}
    @Column(name = "ALL_2_2_1_1")
    @JsonProperty("ALL-2-2-1-1")
    private String ALL_2_2_1_1; // 其他低危判断条件
    public String getALL_2_2_1_1() {  return this.ALL_2_2_1_1;}
    @JsonProperty("ALL-2-2-1-1")
    public void setALL_2_2_1_1(final String ALL_2_2_1_1) { this.ALL_2_2_1_1=ALL_2_2_1_1;}
    @Column(name = "ALL_2_2_2")
    @JsonProperty("ALL-2-2-2")
    private String ALL_2_2_2; // 中危（Intermediate risk，IR）判断条件
    public String getALL_2_2_2() {  return this.ALL_2_2_2;}
    @JsonProperty("ALL-2-2-2")
    public void setALL_2_2_2(final String ALL_2_2_2) { this.ALL_2_2_2=ALL_2_2_2;}
    @Column(name = "ALL_2_2_2_1")
    @JsonProperty("ALL-2-2-2-1")
    private String ALL_2_2_2_1; // 其他中危判断条件
    public String getALL_2_2_2_1() {  return this.ALL_2_2_2_1;}
    @JsonProperty("ALL-2-2-2-1")
    public void setALL_2_2_2_1(final String ALL_2_2_2_1) { this.ALL_2_2_2_1=ALL_2_2_2_1;}
    @Column(name = "ALL_2_2_3")
    @JsonProperty("ALL-2-2-3")
    private String ALL_2_2_3; // 高危（High Risk，HR）判断条件
    public String getALL_2_2_3() {  return this.ALL_2_2_3;}
    @JsonProperty("ALL-2-2-3")
    public void setALL_2_2_3(final String ALL_2_2_3) { this.ALL_2_2_3=ALL_2_2_3;}
    @Column(name = "ALL_2_2_3_1")
    @JsonProperty("ALL-2-2-3-1")
    private String ALL_2_2_3_1; // 其他高危判断条件
    public String getALL_2_2_3_1() {  return this.ALL_2_2_3_1;}
    @JsonProperty("ALL-2-2-3-1")
    public void setALL_2_2_3_1(final String ALL_2_2_3_1) { this.ALL_2_2_3_1=ALL_2_2_3_1;}
    @Column(name = "ALL_2_3_1")
    @JsonProperty("ALL-2-3-1")
    private String ALL_2_3_1; // 是否有治疗过程中更改危险度
    public String getALL_2_3_1() {  return this.ALL_2_3_1;}
    @JsonProperty("ALL-2-3-1")
    public void setALL_2_3_1(final String ALL_2_3_1) { this.ALL_2_3_1=ALL_2_3_1;}
    @Column(name = "ALL_2_3_2")
    @JsonProperty("ALL-2-3-2")
    private String ALL_2_3_2; // 符合更改危险度判断条件
    public String getALL_2_3_2() {  return this.ALL_2_3_2;}
    @JsonProperty("ALL-2-3-2")
    public void setALL_2_3_2(final String ALL_2_3_2) { this.ALL_2_3_2=ALL_2_3_2;}
    @Column(name = "ALL_2_3_3")
    @JsonProperty("ALL-2-3-3")
    private String ALL_2_3_3; // 更改危险度的日期
    public String getALL_2_3_3() {  return this.ALL_2_3_3;}
    @JsonProperty("ALL-2-3-3")
    public void setALL_2_3_3(final String ALL_2_3_3) { this.ALL_2_3_3=ALL_2_3_3;}
    @Column(name = "ALL_3_1_1")
    @JsonProperty("ALL-3-1-1")
    private String ALL_3_1_1; // 是否有诱导期化疗方案
    public String getALL_3_1_1() {  return this.ALL_3_1_1;}
    @JsonProperty("ALL-3-1-1")
    public void setALL_3_1_1(final String ALL_3_1_1) { this.ALL_3_1_1=ALL_3_1_1;}
    @Column(name = "ALL_3_1_2")
    @JsonProperty("ALL-3-1-2")
    private String ALL_3_1_2; // 化疗方案
    public String getALL_3_1_2() {  return this.ALL_3_1_2;}
    @JsonProperty("ALL-3-1-2")
    public void setALL_3_1_2(final String ALL_3_1_2) { this.ALL_3_1_2=ALL_3_1_2;}
    @Column(name = "ALL_3_1_2_1")
    @JsonProperty("ALL-3-1-2-1")
    private String ALL_3_1_2_1; // 其他化疗方案名称
    public String getALL_3_1_2_1() {  return this.ALL_3_1_2_1;}
    @JsonProperty("ALL-3-1-2-1")
    public void setALL_3_1_2_1(final String ALL_3_1_2_1) { this.ALL_3_1_2_1=ALL_3_1_2_1;}
    @Column(name = "ALL_3_2_1")
    @JsonProperty("ALL-3-2-1")
    private String ALL_3_2_1; // 治疗用药的选择
    public String getALL_3_2_1() {  return this.ALL_3_2_1;}
    @JsonProperty("ALL-3-2-1")
    public void setALL_3_2_1(final String ALL_3_2_1) { this.ALL_3_2_1=ALL_3_2_1;}
    @Column(name = "ALL_3_2_1_1")
    @JsonProperty("ALL-3-2-1-1")
    private String ALL_3_2_1_1; // 环磷酰胺
    public String getALL_3_2_1_1() {  return this.ALL_3_2_1_1;}
    @JsonProperty("ALL-3-2-1-1")
    public void setALL_3_2_1_1(final String ALL_3_2_1_1) { this.ALL_3_2_1_1=ALL_3_2_1_1;}
    @Column(name = "ALL_3_2_1_2")
    @JsonProperty("ALL-3-2-1-2")
    private String ALL_3_2_1_2; // 其他环磷酰胺用药输注方式
    public String getALL_3_2_1_2() {  return this.ALL_3_2_1_2;}
    @JsonProperty("ALL-3-2-1-2")
    public void setALL_3_2_1_2(final String ALL_3_2_1_2) { this.ALL_3_2_1_2=ALL_3_2_1_2;}
    @Column(name = "ALL_3_2_1_3")
    @JsonProperty("ALL-3-2-1-3")
    private String ALL_3_2_1_3; // 其他环磷酰胺用药(mg/m²/次)
    public String getALL_3_2_1_3() {  return this.ALL_3_2_1_3;}
    @JsonProperty("ALL-3-2-1-3")
    public void setALL_3_2_1_3(final String ALL_3_2_1_3) { this.ALL_3_2_1_3=ALL_3_2_1_3;}
    @Column(name = "ALL_3_2_1_4")
    @JsonProperty("ALL-3-2-1-4")
    private String ALL_3_2_1_4; // 其他环磷酰胺用药次数(次)
    public String getALL_3_2_1_4() {  return this.ALL_3_2_1_4;}
    @JsonProperty("ALL-3-2-1-4")
    public void setALL_3_2_1_4(final String ALL_3_2_1_4) { this.ALL_3_2_1_4=ALL_3_2_1_4;}
    @Column(name = "ALL_3_2_1_5")
    @JsonProperty("ALL-3-2-1-5")
    private String ALL_3_2_1_5; // 长春新碱
    public String getALL_3_2_1_5() {  return this.ALL_3_2_1_5;}
    @JsonProperty("ALL-3-2-1-5")
    public void setALL_3_2_1_5(final String ALL_3_2_1_5) { this.ALL_3_2_1_5=ALL_3_2_1_5;}
    @Column(name = "ALL_3_2_1_6")
    @JsonProperty("ALL-3-2-1-6")
    private String ALL_3_2_1_6; // 其他长春新碱用药(mg/m²/次)
    public String getALL_3_2_1_6() {  return this.ALL_3_2_1_6;}
    @JsonProperty("ALL-3-2-1-6")
    public void setALL_3_2_1_6(final String ALL_3_2_1_6) { this.ALL_3_2_1_6=ALL_3_2_1_6;}
    @Column(name = "ALL_3_2_1_7")
    @JsonProperty("ALL-3-2-1-7")
    private String ALL_3_2_1_7; // 其他长春新碱用药每周次数(次)
    public String getALL_3_2_1_7() {  return this.ALL_3_2_1_7;}
    @JsonProperty("ALL-3-2-1-7")
    public void setALL_3_2_1_7(final String ALL_3_2_1_7) { this.ALL_3_2_1_7=ALL_3_2_1_7;}
    @Column(name = "ALL_3_2_1_8")
    @JsonProperty("ALL-3-2-1-8")
    private String ALL_3_2_1_8; // 其他长春新碱用药共计次数(次)
    public String getALL_3_2_1_8() {  return this.ALL_3_2_1_8;}
    @JsonProperty("ALL-3-2-1-8")
    public void setALL_3_2_1_8(final String ALL_3_2_1_8) { this.ALL_3_2_1_8=ALL_3_2_1_8;}
    @Column(name = "ALL_3_2_1_9")
    @JsonProperty("ALL-3-2-1-9")
    private String ALL_3_2_1_9; // 长春地辛
    public String getALL_3_2_1_9() {  return this.ALL_3_2_1_9;}
    @JsonProperty("ALL-3-2-1-9")
    public void setALL_3_2_1_9(final String ALL_3_2_1_9) { this.ALL_3_2_1_9=ALL_3_2_1_9;}
    @Column(name = "ALL_3_2_1_10")
    @JsonProperty("ALL-3-2-1-10")
    private String ALL_3_2_1_10; // 其他长春地辛用药(mg/m²/次)
    public String getALL_3_2_1_10() {  return this.ALL_3_2_1_10;}
    @JsonProperty("ALL-3-2-1-10")
    public void setALL_3_2_1_10(final String ALL_3_2_1_10) { this.ALL_3_2_1_10=ALL_3_2_1_10;}
    @Column(name = "ALL_3_2_1_11")
    @JsonProperty("ALL-3-2-1-11")
    private String ALL_3_2_1_11; // 其他长春地辛用药每周次数(次)
    public String getALL_3_2_1_11() {  return this.ALL_3_2_1_11;}
    @JsonProperty("ALL-3-2-1-11")
    public void setALL_3_2_1_11(final String ALL_3_2_1_11) { this.ALL_3_2_1_11=ALL_3_2_1_11;}
    @Column(name = "ALL_3_2_1_12")
    @JsonProperty("ALL-3-2-1-12")
    private String ALL_3_2_1_12; // 其他长春地辛用药共计次数(次)
    public String getALL_3_2_1_12() {  return this.ALL_3_2_1_12;}
    @JsonProperty("ALL-3-2-1-12")
    public void setALL_3_2_1_12(final String ALL_3_2_1_12) { this.ALL_3_2_1_12=ALL_3_2_1_12;}
    @Column(name = "ALL_3_2_1_13")
    @JsonProperty("ALL-3-2-1-13")
    private String ALL_3_2_1_13; // 柔红霉素
    public String getALL_3_2_1_13() {  return this.ALL_3_2_1_13;}
    @JsonProperty("ALL-3-2-1-13")
    public void setALL_3_2_1_13(final String ALL_3_2_1_13) { this.ALL_3_2_1_13=ALL_3_2_1_13;}
    @Column(name = "ALL_3_2_1_14")
    @JsonProperty("ALL-3-2-1-14")
    private String ALL_3_2_1_14; // 其他柔红霉素用药(mg/m²/次)
    public String getALL_3_2_1_14() {  return this.ALL_3_2_1_14;}
    @JsonProperty("ALL-3-2-1-14")
    public void setALL_3_2_1_14(final String ALL_3_2_1_14) { this.ALL_3_2_1_14=ALL_3_2_1_14;}
    @Column(name = "ALL_3_2_1_15")
    @JsonProperty("ALL-3-2-1-15")
    private String ALL_3_2_1_15; // 其他柔红霉素用药每周次数(次)
    public String getALL_3_2_1_15() {  return this.ALL_3_2_1_15;}
    @JsonProperty("ALL-3-2-1-15")
    public void setALL_3_2_1_15(final String ALL_3_2_1_15) { this.ALL_3_2_1_15=ALL_3_2_1_15;}
    @Column(name = "ALL_3_2_1_16")
    @JsonProperty("ALL-3-2-1-16")
    private String ALL_3_2_1_16; // 其他柔红霉素用药共计次数(次)
    public String getALL_3_2_1_16() {  return this.ALL_3_2_1_16;}
    @JsonProperty("ALL-3-2-1-16")
    public void setALL_3_2_1_16(final String ALL_3_2_1_16) { this.ALL_3_2_1_16=ALL_3_2_1_16;}
    @Column(name = "ALL_3_2_1_17")
    @JsonProperty("ALL-3-2-1-17")
    private String ALL_3_2_1_17; // 左旋门冬酰胺酶
    public String getALL_3_2_1_17() {  return this.ALL_3_2_1_17;}
    @JsonProperty("ALL-3-2-1-17")
    public void setALL_3_2_1_17(final String ALL_3_2_1_17) { this.ALL_3_2_1_17=ALL_3_2_1_17;}
    @Column(name = "ALL_3_2_1_18")
    @JsonProperty("ALL-3-2-1-18")
    private String ALL_3_2_1_18; // 其他左旋门冬酰胺酶用药(u/m²/次)
    public String getALL_3_2_1_18() {  return this.ALL_3_2_1_18;}
    @JsonProperty("ALL-3-2-1-18")
    public void setALL_3_2_1_18(final String ALL_3_2_1_18) { this.ALL_3_2_1_18=ALL_3_2_1_18;}
    @Column(name = "ALL_3_2_1_19")
    @JsonProperty("ALL-3-2-1-19")
    private String ALL_3_2_1_19; // 其他左旋门冬酰胺酶用药共计次数(次)
    public String getALL_3_2_1_19() {  return this.ALL_3_2_1_19;}
    @JsonProperty("ALL-3-2-1-19")
    public void setALL_3_2_1_19(final String ALL_3_2_1_19) { this.ALL_3_2_1_19=ALL_3_2_1_19;}
    @Column(name = "ALL_3_2_1_20")
    @JsonProperty("ALL-3-2-1-20")
    private String ALL_3_2_1_20; // 培门冬
    public String getALL_3_2_1_20() {  return this.ALL_3_2_1_20;}
    @JsonProperty("ALL-3-2-1-20")
    public void setALL_3_2_1_20(final String ALL_3_2_1_20) { this.ALL_3_2_1_20=ALL_3_2_1_20;}
    @Column(name = "ALL_3_2_1_21")
    @JsonProperty("ALL-3-2-1-21")
    private String ALL_3_2_1_21; // 其他培门冬用药输注方式
    public String getALL_3_2_1_21() {  return this.ALL_3_2_1_21;}
    @JsonProperty("ALL-3-2-1-21")
    public void setALL_3_2_1_21(final String ALL_3_2_1_21) { this.ALL_3_2_1_21=ALL_3_2_1_21;}
    @Column(name = "ALL_3_2_1_22")
    @JsonProperty("ALL-3-2-1-22")
    private String ALL_3_2_1_22; // 其他培门冬用药(u/m²/次)
    public String getALL_3_2_1_22() {  return this.ALL_3_2_1_22;}
    @JsonProperty("ALL-3-2-1-22")
    public void setALL_3_2_1_22(final String ALL_3_2_1_22) { this.ALL_3_2_1_22=ALL_3_2_1_22;}
    @Column(name = "ALL_3_2_1_23")
    @JsonProperty("ALL-3-2-1-23")
    private String ALL_3_2_1_23; // 其他培门冬用药天数(d)
    public String getALL_3_2_1_23() {  return this.ALL_3_2_1_23;}
    @JsonProperty("ALL-3-2-1-23")
    public void setALL_3_2_1_23(final String ALL_3_2_1_23) { this.ALL_3_2_1_23=ALL_3_2_1_23;}
    @Column(name = "ALL_3_2_1_24")
    @JsonProperty("ALL-3-2-1-24")
    private String ALL_3_2_1_24; // 其他培门冬用药(d)
    public String getALL_3_2_1_24() {  return this.ALL_3_2_1_24;}
    @JsonProperty("ALL-3-2-1-24")
    public void setALL_3_2_1_24(final String ALL_3_2_1_24) { this.ALL_3_2_1_24=ALL_3_2_1_24;}
    @Column(name = "ALL_3_2_1_25")
    @JsonProperty("ALL-3-2-1-25")
    private String ALL_3_2_1_25; // 泼尼松
    public String getALL_3_2_1_25() {  return this.ALL_3_2_1_25;}
    @JsonProperty("ALL-3-2-1-25")
    public void setALL_3_2_1_25(final String ALL_3_2_1_25) { this.ALL_3_2_1_25=ALL_3_2_1_25;}
    @Column(name = "ALL_3_2_1_26")
    @JsonProperty("ALL-3-2-1-26")
    private String ALL_3_2_1_26; // 其他泼尼松用药(mg/m²/d)
    public String getALL_3_2_1_26() {  return this.ALL_3_2_1_26;}
    @JsonProperty("ALL-3-2-1-26")
    public void setALL_3_2_1_26(final String ALL_3_2_1_26) { this.ALL_3_2_1_26=ALL_3_2_1_26;}
    @Column(name = "ALL_3_2_1_27")
    @JsonProperty("ALL-3-2-1-27")
    private String ALL_3_2_1_27; // 其他泼尼松用药天数(d)
    public String getALL_3_2_1_27() {  return this.ALL_3_2_1_27;}
    @JsonProperty("ALL-3-2-1-27")
    public void setALL_3_2_1_27(final String ALL_3_2_1_27) { this.ALL_3_2_1_27=ALL_3_2_1_27;}
    @Column(name = "ALL_3_2_1_28")
    @JsonProperty("ALL-3-2-1-28")
    private String ALL_3_2_1_28; // 其他泼尼松用药递减至停天数(天)
    public String getALL_3_2_1_28() {  return this.ALL_3_2_1_28;}
    @JsonProperty("ALL-3-2-1-28")
    public void setALL_3_2_1_28(final String ALL_3_2_1_28) { this.ALL_3_2_1_28=ALL_3_2_1_28;}
    @Column(name = "ALL_3_2_1_29")
    @JsonProperty("ALL-3-2-1-29")
    private String ALL_3_2_1_29; // 地塞米松
    public String getALL_3_2_1_29() {  return this.ALL_3_2_1_29;}
    @JsonProperty("ALL-3-2-1-29")
    public void setALL_3_2_1_29(final String ALL_3_2_1_29) { this.ALL_3_2_1_29=ALL_3_2_1_29;}
    @Column(name = "ALL_3_2_1_30")
    @JsonProperty("ALL-3-2-1-30")
    private String ALL_3_2_1_30; // 其他地塞米松用药(mg/m²/d)
    public String getALL_3_2_1_30() {  return this.ALL_3_2_1_30;}
    @JsonProperty("ALL-3-2-1-30")
    public void setALL_3_2_1_30(final String ALL_3_2_1_30) { this.ALL_3_2_1_30=ALL_3_2_1_30;}
    @Column(name = "ALL_3_2_1_31")
    @JsonProperty("ALL-3-2-1-31")
    private String ALL_3_2_1_31; // 其他地塞米松用药天数(d)
    public String getALL_3_2_1_31() {  return this.ALL_3_2_1_31;}
    @JsonProperty("ALL-3-2-1-31")
    public void setALL_3_2_1_31(final String ALL_3_2_1_31) { this.ALL_3_2_1_31=ALL_3_2_1_31;}
    @Column(name = "ALL_3_2_1_32")
    @JsonProperty("ALL-3-2-1-32")
    private String ALL_3_2_1_32; // 其他地塞米松用药递减至停天数(天)
    public String getALL_3_2_1_32() {  return this.ALL_3_2_1_32;}
    @JsonProperty("ALL-3-2-1-32")
    public void setALL_3_2_1_32(final String ALL_3_2_1_32) { this.ALL_3_2_1_32=ALL_3_2_1_32;}
    @Column(name = "ALL_3_2_1_33")
    @JsonProperty("ALL-3-2-1-33")
    private String ALL_3_2_1_33; // 其他治疗药品名称
    public String getALL_3_2_1_33() {  return this.ALL_3_2_1_33;}
    @JsonProperty("ALL-3-2-1-33")
    public void setALL_3_2_1_33(final String ALL_3_2_1_33) { this.ALL_3_2_1_33=ALL_3_2_1_33;}
    @Column(name = "ALL_3_2_1_34")
    @JsonProperty("ALL-3-2-1-34")
    private String ALL_3_2_1_34; // 其他治疗用药输注方式
    public String getALL_3_2_1_34() {  return this.ALL_3_2_1_34;}
    @JsonProperty("ALL-3-2-1-34")
    public void setALL_3_2_1_34(final String ALL_3_2_1_34) { this.ALL_3_2_1_34=ALL_3_2_1_34;}
    @Column(name = "ALL_3_2_1_35")
    @JsonProperty("ALL-3-2-1-35")
    private String ALL_3_2_1_35; // 其他治疗药品规格
    public String getALL_3_2_1_35() {  return this.ALL_3_2_1_35;}
    @JsonProperty("ALL-3-2-1-35")
    public void setALL_3_2_1_35(final String ALL_3_2_1_35) { this.ALL_3_2_1_35=ALL_3_2_1_35;}
    @Column(name = "ALL_3_2_1_36")
    @JsonProperty("ALL-3-2-1-36")
    private String ALL_3_2_1_36; // 其他治疗用药天数(天)
    public String getALL_3_2_1_36() {  return this.ALL_3_2_1_36;}
    @JsonProperty("ALL-3-2-1-36")
    public void setALL_3_2_1_36(final String ALL_3_2_1_36) { this.ALL_3_2_1_36=ALL_3_2_1_36;}
    @Column(name = "ALL_3_2_1_37")
    @JsonProperty("ALL-3-2-1-37")
    private String ALL_3_2_1_37; // 其他治疗用药次数(次)
    public String getALL_3_2_1_37() {  return this.ALL_3_2_1_37;}
    @JsonProperty("ALL-3-2-1-37")
    public void setALL_3_2_1_37(final String ALL_3_2_1_37) { this.ALL_3_2_1_37=ALL_3_2_1_37;}
    @Column(name = "ALL_3_2_1_38")
    @JsonProperty("ALL-3-2-1-38")
    private String ALL_3_2_1_38; // 其他治疗用药递减至停天数(天)
    public String getALL_3_2_1_38() {  return this.ALL_3_2_1_38;}
    @JsonProperty("ALL-3-2-1-38")
    public void setALL_3_2_1_38(final String ALL_3_2_1_38) { this.ALL_3_2_1_38=ALL_3_2_1_38;}
    @Column(name = "ALL_4_1_1")
    @JsonProperty("ALL-4-1-1")
    private String ALL_4_1_1; // 是否有早期强化治疗方案
    public String getALL_4_1_1() {  return this.ALL_4_1_1;}
    @JsonProperty("ALL-4-1-1")
    public void setALL_4_1_1(final String ALL_4_1_1) { this.ALL_4_1_1=ALL_4_1_1;}
    @Column(name = "ALL_4_1_2")
    @JsonProperty("ALL-4-1-2")
    private String ALL_4_1_2; // 化疗方案
    public String getALL_4_1_2() {  return this.ALL_4_1_2;}
    @JsonProperty("ALL-4-1-2")
    public void setALL_4_1_2(final String ALL_4_1_2) { this.ALL_4_1_2=ALL_4_1_2;}
    @Column(name = "ALL_4_1_2_1")
    @JsonProperty("ALL-4-1-2-1")
    private String ALL_4_1_2_1; // 其他化疗方案名称
    public String getALL_4_1_2_1() {  return this.ALL_4_1_2_1;}
    @JsonProperty("ALL-4-1-2-1")
    public void setALL_4_1_2_1(final String ALL_4_1_2_1) { this.ALL_4_1_2_1=ALL_4_1_2_1;}
    @Column(name = "ALL_4_2_1")
    @JsonProperty("ALL-4-2-1")
    private String ALL_4_2_1; // 治疗用药的选择
    public String getALL_4_2_1() {  return this.ALL_4_2_1;}
    @JsonProperty("ALL-4-2-1")
    public void setALL_4_2_1(final String ALL_4_2_1) { this.ALL_4_2_1=ALL_4_2_1;}
    @Column(name = "ALL_4_2_1_1")
    @JsonProperty("ALL-4-2-1-1")
    private String ALL_4_2_1_1; // 环磷酰胺
    public String getALL_4_2_1_1() {  return this.ALL_4_2_1_1;}
    @JsonProperty("ALL-4-2-1-1")
    public void setALL_4_2_1_1(final String ALL_4_2_1_1) { this.ALL_4_2_1_1=ALL_4_2_1_1;}
    @Column(name = "ALL_4_2_1_2")
    @JsonProperty("ALL-4-2-1-2")
    private String ALL_4_2_1_2; // 其他环磷酰胺用药输注方式
    public String getALL_4_2_1_2() {  return this.ALL_4_2_1_2;}
    @JsonProperty("ALL-4-2-1-2")
    public void setALL_4_2_1_2(final String ALL_4_2_1_2) { this.ALL_4_2_1_2=ALL_4_2_1_2;}
    @Column(name = "ALL_4_2_1_3")
    @JsonProperty("ALL-4-2-1-3")
    private String ALL_4_2_1_3; // 其他环磷酰胺用药(mg/m²/d)
    public String getALL_4_2_1_3() {  return this.ALL_4_2_1_3;}
    @JsonProperty("ALL-4-2-1-3")
    public void setALL_4_2_1_3(final String ALL_4_2_1_3) { this.ALL_4_2_1_3=ALL_4_2_1_3;}
    @Column(name = "ALL_4_2_1_4")
    @JsonProperty("ALL-4-2-1-4")
    private String ALL_4_2_1_4; // 其他环磷酰胺用药次数(次)
    public String getALL_4_2_1_4() {  return this.ALL_4_2_1_4;}
    @JsonProperty("ALL-4-2-1-4")
    public void setALL_4_2_1_4(final String ALL_4_2_1_4) { this.ALL_4_2_1_4=ALL_4_2_1_4;}
    @Column(name = "ALL_4_2_1_5")
    @JsonProperty("ALL-4-2-1-5")
    private String ALL_4_2_1_5; // 阿糖胞苷
    public String getALL_4_2_1_5() {  return this.ALL_4_2_1_5;}
    @JsonProperty("ALL-4-2-1-5")
    public void setALL_4_2_1_5(final String ALL_4_2_1_5) { this.ALL_4_2_1_5=ALL_4_2_1_5;}
    @Column(name = "ALL_4_2_1_6")
    @JsonProperty("ALL-4-2-1-6")
    private String ALL_4_2_1_6; // 其他阿糖胞苷用药输注方式
    public String getALL_4_2_1_6() {  return this.ALL_4_2_1_6;}
    @JsonProperty("ALL-4-2-1-6")
    public void setALL_4_2_1_6(final String ALL_4_2_1_6) { this.ALL_4_2_1_6=ALL_4_2_1_6;}
    @Column(name = "ALL_4_2_1_7")
    @JsonProperty("ALL-4-2-1-7")
    private String ALL_4_2_1_7; // 其他阿糖胞苷用药(mg/m²/次)
    public String getALL_4_2_1_7() {  return this.ALL_4_2_1_7;}
    @JsonProperty("ALL-4-2-1-7")
    public void setALL_4_2_1_7(final String ALL_4_2_1_7) { this.ALL_4_2_1_7=ALL_4_2_1_7;}
    @Column(name = "ALL_4_2_1_8")
    @JsonProperty("ALL-4-2-1-8")
    private String ALL_4_2_1_8; // 其他阿糖胞苷用药天数(天)
    public String getALL_4_2_1_8() {  return this.ALL_4_2_1_8;}
    @JsonProperty("ALL-4-2-1-8")
    public void setALL_4_2_1_8(final String ALL_4_2_1_8) { this.ALL_4_2_1_8=ALL_4_2_1_8;}
    @Column(name = "ALL_4_2_1_9")
    @JsonProperty("ALL-4-2-1-9")
    private String ALL_4_2_1_9; // 其他阿糖胞苷每天用药次数(次)
    public String getALL_4_2_1_9() {  return this.ALL_4_2_1_9;}
    @JsonProperty("ALL-4-2-1-9")
    public void setALL_4_2_1_9(final String ALL_4_2_1_9) { this.ALL_4_2_1_9=ALL_4_2_1_9;}
    @Column(name = "ALL_4_2_1_10")
    @JsonProperty("ALL-4-2-1-10")
    private String ALL_4_2_1_10; // 6-巯基嘌呤
    public String getALL_4_2_1_10() {  return this.ALL_4_2_1_10;}
    @JsonProperty("ALL-4-2-1-10")
    public void setALL_4_2_1_10(final String ALL_4_2_1_10) { this.ALL_4_2_1_10=ALL_4_2_1_10;}
    @Column(name = "ALL_4_2_1_11")
    @JsonProperty("ALL-4-2-1-11")
    private String ALL_4_2_1_11; // 其他6-巯基嘌呤用药输注方式
    public String getALL_4_2_1_11() {  return this.ALL_4_2_1_11;}
    @JsonProperty("ALL-4-2-1-11")
    public void setALL_4_2_1_11(final String ALL_4_2_1_11) { this.ALL_4_2_1_11=ALL_4_2_1_11;}
    @Column(name = "ALL_4_2_1_12")
    @JsonProperty("ALL-4-2-1-12")
    private String ALL_4_2_1_12; // 其他6-巯基嘌呤用药(mg/m²/d)
    public String getALL_4_2_1_12() {  return this.ALL_4_2_1_12;}
    @JsonProperty("ALL-4-2-1-12")
    public void setALL_4_2_1_12(final String ALL_4_2_1_12) { this.ALL_4_2_1_12=ALL_4_2_1_12;}
    @Column(name = "ALL_4_2_1_13")
    @JsonProperty("ALL-4-2-1-13")
    private String ALL_4_2_1_13; // 其他6-巯基嘌呤用药天数(天)
    public String getALL_4_2_1_13() {  return this.ALL_4_2_1_13;}
    @JsonProperty("ALL-4-2-1-13")
    public void setALL_4_2_1_13(final String ALL_4_2_1_13) { this.ALL_4_2_1_13=ALL_4_2_1_13;}
    @Column(name = "ALL_4_2_1_14")
    @JsonProperty("ALL-4-2-1-14")
    private String ALL_4_2_1_14; // 培门冬酶
    public String getALL_4_2_1_14() {  return this.ALL_4_2_1_14;}
    @JsonProperty("ALL-4-2-1-14")
    public void setALL_4_2_1_14(final String ALL_4_2_1_14) { this.ALL_4_2_1_14=ALL_4_2_1_14;}
    @Column(name = "ALL_4_2_1_15")
    @JsonProperty("ALL-4-2-1-15")
    private String ALL_4_2_1_15; // 其他培门冬酶用药输注方式
    public String getALL_4_2_1_15() {  return this.ALL_4_2_1_15;}
    @JsonProperty("ALL-4-2-1-15")
    public void setALL_4_2_1_15(final String ALL_4_2_1_15) { this.ALL_4_2_1_15=ALL_4_2_1_15;}
    @Column(name = "ALL_4_2_1_16")
    @JsonProperty("ALL-4-2-1-16")
    private String ALL_4_2_1_16; // 其他培门冬酶用药(u/m2/d)
    public String getALL_4_2_1_16() {  return this.ALL_4_2_1_16;}
    @JsonProperty("ALL-4-2-1-16")
    public void setALL_4_2_1_16(final String ALL_4_2_1_16) { this.ALL_4_2_1_16=ALL_4_2_1_16;}
    @Column(name = "ALL_4_2_1_17")
    @JsonProperty("ALL-4-2-1-17")
    private String ALL_4_2_1_17; // 其他培门冬酶用药天数(d)
    public String getALL_4_2_1_17() {  return this.ALL_4_2_1_17;}
    @JsonProperty("ALL-4-2-1-17")
    public void setALL_4_2_1_17(final String ALL_4_2_1_17) { this.ALL_4_2_1_17=ALL_4_2_1_17;}
    @Column(name = "ALL_4_2_1_18")
    @JsonProperty("ALL-4-2-1-18")
    private String ALL_4_2_1_18; // 其他培门冬酶用药次数(次)
    public String getALL_4_2_1_18() {  return this.ALL_4_2_1_18;}
    @JsonProperty("ALL-4-2-1-18")
    public void setALL_4_2_1_18(final String ALL_4_2_1_18) { this.ALL_4_2_1_18=ALL_4_2_1_18;}
    @Column(name = "ALL_4_2_1_19")
    @JsonProperty("ALL-4-2-1-19")
    private String ALL_4_2_1_19; // 其他治疗药品名称
    public String getALL_4_2_1_19() {  return this.ALL_4_2_1_19;}
    @JsonProperty("ALL-4-2-1-19")
    public void setALL_4_2_1_19(final String ALL_4_2_1_19) { this.ALL_4_2_1_19=ALL_4_2_1_19;}
    @Column(name = "ALL_4_2_1_20")
    @JsonProperty("ALL-4-2-1-20")
    private String ALL_4_2_1_20; // 其他治疗用药输注方式
    public String getALL_4_2_1_20() {  return this.ALL_4_2_1_20;}
    @JsonProperty("ALL-4-2-1-20")
    public void setALL_4_2_1_20(final String ALL_4_2_1_20) { this.ALL_4_2_1_20=ALL_4_2_1_20;}
    @Column(name = "ALL_4_2_1_21")
    @JsonProperty("ALL-4-2-1-21")
    private String ALL_4_2_1_21; // 其他治疗药品规格
    public String getALL_4_2_1_21() {  return this.ALL_4_2_1_21;}
    @JsonProperty("ALL-4-2-1-21")
    public void setALL_4_2_1_21(final String ALL_4_2_1_21) { this.ALL_4_2_1_21=ALL_4_2_1_21;}
    @Column(name = "ALL_4_2_1_22")
    @JsonProperty("ALL-4-2-1-22")
    private String ALL_4_2_1_22; // 其他治疗用药天数(天)
    public String getALL_4_2_1_22() {  return this.ALL_4_2_1_22;}
    @JsonProperty("ALL-4-2-1-22")
    public void setALL_4_2_1_22(final String ALL_4_2_1_22) { this.ALL_4_2_1_22=ALL_4_2_1_22;}
    @Column(name = "ALL_4_2_1_23")
    @JsonProperty("ALL-4-2-1-23")
    private String ALL_4_2_1_23; // 其他治疗用药次数(次)
    public String getALL_4_2_1_23() {  return this.ALL_4_2_1_23;}
    @JsonProperty("ALL-4-2-1-23")
    public void setALL_4_2_1_23(final String ALL_4_2_1_23) { this.ALL_4_2_1_23=ALL_4_2_1_23;}
    @Column(name = "ALL_5_1_1")
    @JsonProperty("ALL-5-1-1")
    private String ALL_5_1_1; // 骨髓细胞形态学评估时间点
    public String getALL_5_1_1() {  return this.ALL_5_1_1;}
    @JsonProperty("ALL-5-1-1")
    public void setALL_5_1_1(final String ALL_5_1_1) { this.ALL_5_1_1=ALL_5_1_1;}
    @Column(name = "ALL_5_1_1_1")
    @JsonProperty("ALL-5-1-1-1")
    private String ALL_5_1_1_1; // 其他评估时间点名称
    public String getALL_5_1_1_1() {  return this.ALL_5_1_1_1;}
    @JsonProperty("ALL-5-1-1-1")
    public void setALL_5_1_1_1(final String ALL_5_1_1_1) { this.ALL_5_1_1_1=ALL_5_1_1_1;}
    @Column(name = "ALL_5_1_2")
    @JsonProperty("ALL-5-1-2")
    private String ALL_5_1_2; // 治疗反应及白血病微小残留（MRD）水平评估时间点
    public String getALL_5_1_2() {  return this.ALL_5_1_2;}
    @JsonProperty("ALL-5-1-2")
    public void setALL_5_1_2(final String ALL_5_1_2) { this.ALL_5_1_2=ALL_5_1_2;}
    @Column(name = "ALL_5_1_2_1")
    @JsonProperty("ALL-5-1-2-1")
    private String ALL_5_1_2_1; // 其他评估时间点名称
    public String getALL_5_1_2_1() {  return this.ALL_5_1_2_1;}
    @JsonProperty("ALL-5-1-2-1")
    public void setALL_5_1_2_1(final String ALL_5_1_2_1) { this.ALL_5_1_2_1=ALL_5_1_2_1;}
    @Column(name = "ALL_5_1_3")
    @JsonProperty("ALL-5-1-3")
    private String ALL_5_1_3; // MRD评估方法
    public String getALL_5_1_3() {  return this.ALL_5_1_3;}
    @JsonProperty("ALL-5-1-3")
    public void setALL_5_1_3(final String ALL_5_1_3) { this.ALL_5_1_3=ALL_5_1_3;}
    @Column(name = "ALL_5_1_3_1")
    @JsonProperty("ALL-5-1-3-1")
    private String ALL_5_1_3_1; // 其他评估方法名称
    public String getALL_5_1_3_1() {  return this.ALL_5_1_3_1;}
    @JsonProperty("ALL-5-1-3-1")
    public void setALL_5_1_3_1(final String ALL_5_1_3_1) { this.ALL_5_1_3_1=ALL_5_1_3_1;}
    @Column(name = "ALL_6_1_1")
    @JsonProperty("ALL-6-1-1")
    private String ALL_6_1_1; // 是否有化疗相关的不良反应
    public String getALL_6_1_1() {  return this.ALL_6_1_1;}
    @JsonProperty("ALL-6-1-1")
    public void setALL_6_1_1(final String ALL_6_1_1) { this.ALL_6_1_1=ALL_6_1_1;}
    @Column(name = "ALL_6_1_2")
    @JsonProperty("ALL-6-1-2")
    private String ALL_6_1_2; // 化疗相关的不良反应种类
    public String getALL_6_1_2() {  return this.ALL_6_1_2;}
    @JsonProperty("ALL-6-1-2")
    public void setALL_6_1_2(final String ALL_6_1_2) { this.ALL_6_1_2=ALL_6_1_2;}
    @Column(name = "ALL_6_1_2_1")
    @JsonProperty("ALL-6-1-2-1")
    private String ALL_6_1_2_1; // 心脏毒性
    public String getALL_6_1_2_1() {  return this.ALL_6_1_2_1;}
    @JsonProperty("ALL-6-1-2-1")
    public void setALL_6_1_2_1(final String ALL_6_1_2_1) { this.ALL_6_1_2_1=ALL_6_1_2_1;}
    @Column(name = "ALL_6_1_2_3")
    @JsonProperty("ALL-6-1-2-3")
    private String ALL_6_1_2_3; // 肝脏毒性
    public String getALL_6_1_2_3() {  return this.ALL_6_1_2_3;}
    @JsonProperty("ALL-6-1-2-3")
    public void setALL_6_1_2_3(final String ALL_6_1_2_3) { this.ALL_6_1_2_3=ALL_6_1_2_3;}
    @Column(name = "ALL_6_1_2_5")
    @JsonProperty("ALL-6-1-2-5")
    private String ALL_6_1_2_5; // 神经毒性
    public String getALL_6_1_2_5() {  return this.ALL_6_1_2_5;}
    @JsonProperty("ALL-6-1-2-5")
    public void setALL_6_1_2_5(final String ALL_6_1_2_5) { this.ALL_6_1_2_5=ALL_6_1_2_5;}
    @Column(name = "ALL_6_1_2_7")
    @JsonProperty("ALL-6-1-2-7")
    private String ALL_6_1_2_7; // 肾脏毒性
    public String getALL_6_1_2_7() {  return this.ALL_6_1_2_7;}
    @JsonProperty("ALL-6-1-2-7")
    public void setALL_6_1_2_7(final String ALL_6_1_2_7) { this.ALL_6_1_2_7=ALL_6_1_2_7;}
    @Column(name = "ALL_6_1_2_9")
    @JsonProperty("ALL-6-1-2-9")
    private String ALL_6_1_2_9; // 门冬酰胺酶相关副作用
    public String getALL_6_1_2_9() {  return this.ALL_6_1_2_9;}
    @JsonProperty("ALL-6-1-2-9")
    public void setALL_6_1_2_9(final String ALL_6_1_2_9) { this.ALL_6_1_2_9=ALL_6_1_2_9;}
    @Column(name = "ALL_6_1_2_11")
    @JsonProperty("ALL-6-1-2-11")
    private String ALL_6_1_2_11; // 血液副作用
    public String getALL_6_1_2_11() {  return this.ALL_6_1_2_11;}
    @JsonProperty("ALL-6-1-2-11")
    public void setALL_6_1_2_11(final String ALL_6_1_2_11) { this.ALL_6_1_2_11=ALL_6_1_2_11;}
    @Column(name = "ALL_6_1_2_13")
    @JsonProperty("ALL-6-1-2-13")
    private String ALL_6_1_2_13; // 化疗相关的不良反应其他种类
    public String getALL_6_1_2_13() {  return this.ALL_6_1_2_13;}
    @JsonProperty("ALL-6-1-2-13")
    public void setALL_6_1_2_13(final String ALL_6_1_2_13) { this.ALL_6_1_2_13=ALL_6_1_2_13;}
    @Column(name = "ALL_6_2_1")
    @JsonProperty("ALL-6-2-1")
    private String ALL_6_2_1; // 是否有WHO化疗毒副作用评估
    public String getALL_6_2_1() {  return this.ALL_6_2_1;}
    @JsonProperty("ALL-6-2-1")
    public void setALL_6_2_1(final String ALL_6_2_1) { this.ALL_6_2_1=ALL_6_2_1;}
    @Column(name = "ALL_6_2_2")
    @JsonProperty("ALL-6-2-2")
    private String ALL_6_2_2; // 粘膜损害程度
    public String getALL_6_2_2() {  return this.ALL_6_2_2;}
    @JsonProperty("ALL-6-2-2")
    public void setALL_6_2_2(final String ALL_6_2_2) { this.ALL_6_2_2=ALL_6_2_2;}
    @Column(name = "ALL_6_2_3")
    @JsonProperty("ALL-6-2-3")
    private String ALL_6_2_3; // 感染程度
    public String getALL_6_2_3() {  return this.ALL_6_2_3;}
    @JsonProperty("ALL-6-2-3")
    public void setALL_6_2_3(final String ALL_6_2_3) { this.ALL_6_2_3=ALL_6_2_3;}
    @Column(name = "ALL_6_2_4")
    @JsonProperty("ALL-6-2-4")
    private String ALL_6_2_4; // 肝功能损伤
    public String getALL_6_2_4() {  return this.ALL_6_2_4;}
    @JsonProperty("ALL-6-2-4")
    public void setALL_6_2_4(final String ALL_6_2_4) { this.ALL_6_2_4=ALL_6_2_4;}
    @Column(name = "ALL_6_2_5")
    @JsonProperty("ALL-6-2-5")
    private String ALL_6_2_5; // 肾功能损伤
    public String getALL_6_2_5() {  return this.ALL_6_2_5;}
    @JsonProperty("ALL-6-2-5")
    public void setALL_6_2_5(final String ALL_6_2_5) { this.ALL_6_2_5=ALL_6_2_5;}
    @Column(name = "ALL_6_2_6")
    @JsonProperty("ALL-6-2-6")
    private String ALL_6_2_6; // 胃肠道反应
    public String getALL_6_2_6() {  return this.ALL_6_2_6;}
    @JsonProperty("ALL-6-2-6")
    public void setALL_6_2_6(final String ALL_6_2_6) { this.ALL_6_2_6=ALL_6_2_6;}
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM-1-1-1")
    private String CM_1_1_1; // 是否使用抗菌药物
    public String getCM_1_1_1() {  return this.CM_1_1_1;}
    @JsonProperty("CM-1-1-1")
    public void setCM_1_1_1(final String CM_1_1_1) { this.CM_1_1_1=CM_1_1_1;}
    @Column(name = "ALL_7_1_2")
    @JsonProperty("ALL-7-1-2")
    private String ALL_7_1_2; // 抗菌药物选择
    public String getALL_7_1_2() {  return this.ALL_7_1_2;}
    @JsonProperty("ALL-7-1-2")
    public void setALL_7_1_2(final String ALL_7_1_2) { this.ALL_7_1_2=ALL_7_1_2;}
    @Column(name = "ALL_7_1_3")
    @JsonProperty("ALL-7-1-3")
    private String ALL_7_1_3; // 抗霉菌药物选择
    public String getALL_7_1_3() {  return this.ALL_7_1_3;}
    @JsonProperty("ALL-7-1-3")
    public void setALL_7_1_3(final String ALL_7_1_3) { this.ALL_7_1_3=ALL_7_1_3;}
    @Column(name = "ALL_7_2_1_1")
    @JsonProperty("ALL-7-2-1-1")
    private String ALL_7_2_1_1; // 其他抗霉菌药物
    public String getALL_7_2_1_1() {  return this.ALL_7_2_1_1;}
    @JsonProperty("ALL-7-2-1-1")
    public void setALL_7_2_1_1(final String ALL_7_2_1_1) { this.ALL_7_2_1_1=ALL_7_2_1_1;}
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
    @Column(name = "CM_1_6_1")
    @JsonProperty("CM-1-6-1")
    private String CM_1_6_1; // 术后抗菌药物停止使用时间
    public String getCM_1_6_1() {  return this.CM_1_6_1;}
    @JsonProperty("CM-1-6-1")
    public void setCM_1_6_1(final String CM_1_6_1) { this.CM_1_6_1=CM_1_6_1;}
    @Column(name = "ALL_8_1_1")
    @JsonProperty("ALL-8-1-1")
    private String ALL_8_1_1; // 是否输血及成份血
    public String getALL_8_1_1() {  return this.ALL_8_1_1;}
    @JsonProperty("ALL-8-1-1")
    public void setALL_8_1_1(final String ALL_8_1_1) { this.ALL_8_1_1=ALL_8_1_1;}
    @Column(name = "ALL_8_1_2")
    @JsonProperty("ALL-8-1-2")
    private String ALL_8_1_2; // 输血及成份血指征
    public String getALL_8_1_2() {  return this.ALL_8_1_2;}
    @JsonProperty("ALL-8-1-2")
    public void setALL_8_1_2(final String ALL_8_1_2) { this.ALL_8_1_2=ALL_8_1_2;}
    @Column(name = "ALL_8_1_2_1")
    @JsonProperty("ALL-8-1-2-1")
    private String ALL_8_1_2_1; // 输血及成份血其他指征
    public String getALL_8_1_2_1() {  return this.ALL_8_1_2_1;}
    @JsonProperty("ALL-8-1-2-1")
    public void setALL_8_1_2_1(final String ALL_8_1_2_1) { this.ALL_8_1_2_1=ALL_8_1_2_1;}
    @Column(name = "ALL_8_1_3")
    @JsonProperty("ALL-8-1-3")
    private String ALL_8_1_3; // 临床用血类别与输血量
    public String getALL_8_1_3() {  return this.ALL_8_1_3;}
    @JsonProperty("ALL-8-1-3")
    public void setALL_8_1_3(final String ALL_8_1_3) { this.ALL_8_1_3=ALL_8_1_3;}
    @Column(name = "ALL_8_1_3_1")
    @JsonProperty("ALL-8-1-3-1")
    private String ALL_8_1_3_1; // 全血 输血量(ml)
    public String getALL_8_1_3_1() {  return this.ALL_8_1_3_1;}
    @JsonProperty("ALL-8-1-3-1")
    public void setALL_8_1_3_1(final String ALL_8_1_3_1) { this.ALL_8_1_3_1=ALL_8_1_3_1;}
    @Column(name = "ALL_8_1_3_2")
    @JsonProperty("ALL-8-1-3-2")
    private String ALL_8_1_3_2; // 成份血 输血量(ml)
    public String getALL_8_1_3_2() {  return this.ALL_8_1_3_2;}
    @JsonProperty("ALL-8-1-3-2")
    public void setALL_8_1_3_2(final String ALL_8_1_3_2) { this.ALL_8_1_3_2=ALL_8_1_3_2;}
    @Column(name = "ALL_8_1_3_3")
    @JsonProperty("ALL-8-1-3-3")
    private String ALL_8_1_3_3; // 血浆 输血量(ml)
    public String getALL_8_1_3_3() {  return this.ALL_8_1_3_3;}
    @JsonProperty("ALL-8-1-3-3")
    public void setALL_8_1_3_3(final String ALL_8_1_3_3) { this.ALL_8_1_3_3=ALL_8_1_3_3;}
    @Column(name = "ALL_8_1_3_4")
    @JsonProperty("ALL-8-1-3-4")
    private String ALL_8_1_3_4; // 其他 用血类别
    public String getALL_8_1_3_4() {  return this.ALL_8_1_3_4;}
    @JsonProperty("ALL-8-1-3-4")
    public void setALL_8_1_3_4(final String ALL_8_1_3_4) { this.ALL_8_1_3_4=ALL_8_1_3_4;}
    @Column(name = "ALL_8_1_3_5")
    @JsonProperty("ALL-8-1-3-5")
    private String ALL_8_1_3_5; // 其他 输血量(ml)
    public String getALL_8_1_3_5() {  return this.ALL_8_1_3_5;}
    @JsonProperty("ALL-8-1-3-5")
    public void setALL_8_1_3_5(final String ALL_8_1_3_5) { this.ALL_8_1_3_5=ALL_8_1_3_5;}
    @Column(name = "ALL_8_2_1")
    @JsonProperty("ALL-8-2-1")
    private String ALL_8_2_1; // 是否造血干细胞移植
    public String getALL_8_2_1() {  return this.ALL_8_2_1;}
    @JsonProperty("ALL-8-2-1")
    public void setALL_8_2_1(final String ALL_8_2_1) { this.ALL_8_2_1=ALL_8_2_1;}
    @Column(name = "ALL_8_2_2")
    @JsonProperty("ALL-8-2-2")
    private String ALL_8_2_2; // 造血干细胞移植指征
    public String getALL_8_2_2() {  return this.ALL_8_2_2;}
    @JsonProperty("ALL-8-2-2")
    public void setALL_8_2_2(final String ALL_8_2_2) { this.ALL_8_2_2=ALL_8_2_2;}
    @Column(name = "ALL_8_2_2_1")
    @JsonProperty("ALL-8-2-2-1")
    private String ALL_8_2_2_1; // 造血干细胞移植其他指征
    public String getALL_8_2_2_1() {  return this.ALL_8_2_2_1;}
    @JsonProperty("ALL-8-2-2-1")
    public void setALL_8_2_2_1(final String ALL_8_2_2_1) { this.ALL_8_2_2_1=ALL_8_2_2_1;}
    @Column(name = "ALL_8_2_3")
    @JsonProperty("ALL-8-2-3")
    private String ALL_8_2_3; // 造血干细胞的来源
    public String getALL_8_2_3() {  return this.ALL_8_2_3;}
    @JsonProperty("ALL-8-2-3")
    public void setALL_8_2_3(final String ALL_8_2_3) { this.ALL_8_2_3=ALL_8_2_3;}
    @Column(name = "ALL_8_2_3_1")
    @JsonProperty("ALL-8-2-3-1")
    private String ALL_8_2_3_1; // 造血干细胞的其他来源
    public String getALL_8_2_3_1() {  return this.ALL_8_2_3_1;}
    @JsonProperty("ALL-8-2-3-1")
    public void setALL_8_2_3_1(final String ALL_8_2_3_1) { this.ALL_8_2_3_1=ALL_8_2_3_1;}
    @Column(name = "CM_7_1_1")
    @JsonProperty("CM-7-1-1")
    private String CM_7_1_1; // 术前健康教育
    public String getCM_7_1_1() {  return this.CM_7_1_1;}
    @JsonProperty("CM-7-1-1")
    public void setCM_7_1_1(final String CM_7_1_1) { this.CM_7_1_1=CM_7_1_1;}
    @Column(name = "ALL_9_1_1_1")
    @JsonProperty("ALL-9-1-1-1")
    private String ALL_9_1_1_1; // 术前其他健康教育
    public String getALL_9_1_1_1() {  return this.ALL_9_1_1_1;}
    @JsonProperty("ALL-9-1-1-1")
    public void setALL_9_1_1_1(final String ALL_9_1_1_1) { this.ALL_9_1_1_1=ALL_9_1_1_1;}
    @Column(name = "CM_7_1_2")
    @JsonProperty("CM-7-1-2")
    private String CM_7_1_2; // 术后健康教育
    public String getCM_7_1_2() {  return this.CM_7_1_2;}
    @JsonProperty("CM-7-1-2")
    public void setCM_7_1_2(final String CM_7_1_2) { this.CM_7_1_2=CM_7_1_2;}
    @Column(name = "ALL_9_1_2_1")
    @JsonProperty("ALL-9-1-2-1")
    private String ALL_9_1_2_1; // 术后其他健康教育
    public String getALL_9_1_2_1() {  return this.ALL_9_1_2_1;}
    @JsonProperty("ALL-9-1-2-1")
    public void setALL_9_1_2_1(final String ALL_9_1_2_1) { this.ALL_9_1_2_1=ALL_9_1_2_1;}
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    public String getCM_7_2_1() {  return this.CM_7_2_1;}
    @JsonProperty("CM-7-2-1")
    public void setCM_7_2_1(final String CM_7_2_1) { this.CM_7_2_1=CM_7_2_1;}
    @Column(name = "ALL_9_2_1_1")
    @JsonProperty("ALL-9-2-1-1")
    private String ALL_9_2_1_1; // 其他告知患者出院时风险因素
    public String getALL_9_2_1_1() {  return this.ALL_9_2_1_1;}
    @JsonProperty("ALL-9-2-1-1")
    public void setALL_9_2_1_1(final String ALL_9_2_1_1) { this.ALL_9_2_1_1=ALL_9_2_1_1;}
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    public String getCM_7_2_2() {  return this.CM_7_2_2;}
    @JsonProperty("CM-7-2-2")
    public void setCM_7_2_2(final String CM_7_2_2) { this.CM_7_2_2=CM_7_2_2;}
    @Column(name = "ALL_9_2_2_1")
    @JsonProperty("ALL-9-2-2-1")
    private String ALL_9_2_2_1; // 出院带药其他
    public String getALL_9_2_2_1() {  return this.ALL_9_2_2_1;}
    @JsonProperty("ALL-9-2-2-1")
    public void setALL_9_2_2_1(final String ALL_9_2_2_1) { this.ALL_9_2_2_1=ALL_9_2_2_1;}
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    public String getCM_7_2_3() {  return this.CM_7_2_3;}
    @JsonProperty("CM-7-2-3")
    public void setCM_7_2_3(final String CM_7_2_3) { this.CM_7_2_3=CM_7_2_3;}
    @Column(name = "ALL_9_2_3_1")
    @JsonProperty("ALL-9-2-3-1")
    private String ALL_9_2_3_1; // 其他发生紧急意外情况或者疾病复发
    public String getALL_9_2_3_1() {  return this.ALL_9_2_3_1;}
    @JsonProperty("ALL-9-2-3-1")
    public void setALL_9_2_3_1(final String ALL_9_2_3_1) { this.ALL_9_2_3_1=ALL_9_2_3_1;}
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    public String getCM_7_2_4() {  return this.CM_7_2_4;}
    @JsonProperty("CM-7-2-4")
    public void setCM_7_2_4(final String CM_7_2_4) { this.CM_7_2_4=CM_7_2_4;}
    @Column(name = "ALL_9_2_4_1")
    @JsonProperty("ALL-9-2-4-1")
    private String ALL_9_2_4_1; // 其他发生紧急意外情况或者疾病复发如何救治及前途经
    public String getALL_9_2_4_1() {  return this.ALL_9_2_4_1;}
    @JsonProperty("ALL-9-2-4-1")
    public void setALL_9_2_4_1(final String ALL_9_2_4_1) { this.ALL_9_2_4_1=ALL_9_2_4_1;}
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
    public String getCM_7_2_5() {  return this.CM_7_2_5;}
    @JsonProperty("CM-7-2-5")
    public void setCM_7_2_5(final String CM_7_2_5) { this.CM_7_2_5=CM_7_2_5;}
    @Column(name = "ALL_9_2_5_1")
    @JsonProperty("ALL-9-2-5-1")
    private String ALL_9_2_5_1; // 其他教育与随访
    public String getALL_9_2_5_1() {  return this.ALL_9_2_5_1;}
    @JsonProperty("ALL-9-2-5-1")
    public void setALL_9_2_5_1(final String ALL_9_2_5_1) { this.ALL_9_2_5_1=ALL_9_2_5_1;}
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
    private String CM_5_1; // 患儿家长是否对服务的体验与评价
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
    private String CM_5_2_2; // 患儿家长推荐
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