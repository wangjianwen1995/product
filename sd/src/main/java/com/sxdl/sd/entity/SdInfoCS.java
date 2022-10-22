package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要手术 ICD-9-CM-3 编码：74.0，74.1，74.2，74.4，74.99 的手术出院患者。
*/
@ApiModel(value = "26信息")
@Entity
@Table(name = "sd_info_CS")
public class SdInfoCS implements Serializable {
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
    private String CM_0_1_4_1; // 主要手术操作               国家临床版ICD-9.CM-3编码与手术名称
    public String getCM_0_1_4_1() {  return this.CM_0_1_4_1;}
    @JsonProperty("CM-0-1-4-1")
    public void setCM_0_1_4_1(final String CM_0_1_4_1) { this.CM_0_1_4_1=CM_0_1_4_1;}
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
    @Column(name = "CM_0_2_1_6")
    @JsonProperty("CM-0-2-1-6")
    private String CM_0_2_1_6; // 新生儿出生体重（克）
    public String getCM_0_2_1_6() {  return this.CM_0_2_1_6;}
    @JsonProperty("CM-0-2-1-6")
    public void setCM_0_2_1_6(final String CM_0_2_1_6) { this.CM_0_2_1_6=CM_0_2_1_6;}
    @Column(name = "CS_0_2_2_1")
    @JsonProperty("CS-0-2-2-1")
    private String CS_0_2_2_1; // 末次月经日期是否确定
    public String getCS_0_2_2_1() {  return this.CS_0_2_2_1;}
    @JsonProperty("CS-0-2-2-1")
    public void setCS_0_2_2_1(final String CS_0_2_2_1) { this.CS_0_2_2_1=CS_0_2_2_1;}
    @Column(name = "CS_0_2_2")
    @JsonProperty("CS-0-2-2")
    private String CS_0_2_2; // 末次月经日期
    public String getCS_0_2_2() {  return this.CS_0_2_2;}
    @JsonProperty("CS-0-2-2")
    public void setCS_0_2_2(final String CS_0_2_2) { this.CS_0_2_2=CS_0_2_2;}
    @Column(name = "CM_0_2_3_1")
    @JsonProperty("CM-0-2-3-1")
    private String CM_0_2_3_1; // 到达本院急诊或者门诊日期时间是否确定
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
    @Column(name = "CS_1_1_1")
    @JsonProperty("CS-1-1-1")
    private String CS_1_1_1; // 产次
    public String getCS_1_1_1() {  return this.CS_1_1_1;}
    @JsonProperty("CS-1-1-1")
    public void setCS_1_1_1(final String CS_1_1_1) { this.CS_1_1_1=CS_1_1_1;}
    @Column(name = "CS_1_1_8")
    @JsonProperty("CS-1-1-8")
    private String CS_1_1_8; // 有无剖宮产史
    public String getCS_1_1_8() {  return this.CS_1_1_8;}
    @JsonProperty("CS-1-1-8")
    public void setCS_1_1_8(final String CS_1_1_8) { this.CS_1_1_8=CS_1_1_8;}
    @Column(name = "CS_1_1_3")
    @JsonProperty("CS-1-1-3")
    private String CS_1_1_3; // 临产方式
    public String getCS_1_1_3() {  return this.CS_1_1_3;}
    @JsonProperty("CS-1-1-3")
    public void setCS_1_1_3(final String CS_1_1_3) { this.CS_1_1_3=CS_1_1_3;}
    @Column(name = "CS_1_1_4")
    @JsonProperty("CS-1-1-4")
    private String CS_1_1_4; // 孕周
    public String getCS_1_1_4() {  return this.CS_1_1_4;}
    @JsonProperty("CS-1-1-4")
    public void setCS_1_1_4(final String CS_1_1_4) { this.CS_1_1_4=CS_1_1_4;}
    @Column(name = "CS_1_1_5")
    @JsonProperty("CS-1-1-5")
    private String CS_1_1_5; // 胎位
    public String getCS_1_1_5() {  return this.CS_1_1_5;}
    @JsonProperty("CS-1-1-5")
    public void setCS_1_1_5(final String CS_1_1_5) { this.CS_1_1_5=CS_1_1_5;}
    @Column(name = "CS_1_1_6")
    @JsonProperty("CS-1-1-6")
    private String CS_1_1_6; // 胎儿数量
    public String getCS_1_1_6() {  return this.CS_1_1_6;}
    @JsonProperty("CS-1-1-6")
    public void setCS_1_1_6(final String CS_1_1_6) { this.CS_1_1_6=CS_1_1_6;}
    @Column(name = "CS_1_1_9")
    @JsonProperty("CS-1-1-9")
    private String CS_1_1_9; // Robson分类法组别
    public String getCS_1_1_9() {  return this.CS_1_1_9;}
    @JsonProperty("CS-1-1-9")
    public void setCS_1_1_9(final String CS_1_1_9) { this.CS_1_1_9=CS_1_1_9;}
    @Column(name = "CS_1_2_1")
    @JsonProperty("CS-1-2-1")
    private String CS_1_2_1; // 手术前风险评估的检查项目
    public String getCS_1_2_1() {  return this.CS_1_2_1;}
    @JsonProperty("CS-1-2-1")
    public void setCS_1_2_1(final String CS_1_2_1) { this.CS_1_2_1=CS_1_2_1;}
    @Column(name = "CS_1_2_7")
    @JsonProperty("CS-1-2-7")
    private String CS_1_2_7; // 产前胎儿监护有医嘱，且有报告单
    public String getCS_1_2_7() {  return this.CS_1_2_7;}
    @JsonProperty("CS-1-2-7")
    public void setCS_1_2_7(final String CS_1_2_7) { this.CS_1_2_7=CS_1_2_7;}
    @Column(name = "CS_1_2_2")
    @JsonProperty("CS-1-2-2")
    private String CS_1_2_2; // 手术前知情告知
    public String getCS_1_2_2() {  return this.CS_1_2_2;}
    @JsonProperty("CS-1-2-2")
    public void setCS_1_2_2(final String CS_1_2_2) { this.CS_1_2_2=CS_1_2_2;}
    @Column(name = "CS_1_2_31")
    @JsonProperty("CS-1-2-31")
    private String CS_1_2_31; // 麻醉前知情告知
    public String getCS_1_2_31() {  return this.CS_1_2_31;}
    @JsonProperty("CS-1-2-31")
    public void setCS_1_2_31(final String CS_1_2_31) { this.CS_1_2_31=CS_1_2_31;}
    @Column(name = "CS_1_2_4")
    @JsonProperty("CS-1-2-4")
    private String CS_1_2_4; // 麻醉方式
    public String getCS_1_2_4() {  return this.CS_1_2_4;}
    @JsonProperty("CS-1-2-4")
    public void setCS_1_2_4(final String CS_1_2_4) { this.CS_1_2_4=CS_1_2_4;}
    @Column(name = "CS_1_2_4_1")
    @JsonProperty("CS-1-2-4-1")
    private String CS_1_2_4_1; // 其他麻醉方式
    public String getCS_1_2_4_1() {  return this.CS_1_2_4_1;}
    @JsonProperty("CS-1-2-4-1")
    public void setCS_1_2_4_1(final String CS_1_2_4_1) { this.CS_1_2_4_1=CS_1_2_4_1;}
    @Column(name = "CS_1_2_5")
    @JsonProperty("CS-1-2-5")
    private String CS_1_2_5; // 特殊感染评估
    public String getCS_1_2_5() {  return this.CS_1_2_5;}
    @JsonProperty("CS-1-2-5")
    public void setCS_1_2_5(final String CS_1_2_5) { this.CS_1_2_5=CS_1_2_5;}
    @Column(name = "CS_1_2_6")
    @JsonProperty("CS-1-2-6")
    private String CS_1_2_6; // 孕妇伴有特殊感染ICD-10编码及诊断名称
    public String getCS_1_2_6() {  return this.CS_1_2_6;}
    @JsonProperty("CS-1-2-6")
    public void setCS_1_2_6(final String CS_1_2_6) { this.CS_1_2_6=CS_1_2_6;}
    @Column(name = "CS_1_2_6_1")
    @JsonProperty("CS-1-2-6-1")
    private String CS_1_2_6_1; // 孕妇伴有特殊感染ICD-10其他编码与名称
    public String getCS_1_2_6_1() {  return this.CS_1_2_6_1;}
    @JsonProperty("CS-1-2-6-1")
    public void setCS_1_2_6_1(final String CS_1_2_6_1) { this.CS_1_2_6_1=CS_1_2_6_1;}
    @Column(name = "CS_2_1_1_1")
    @JsonProperty("CS-2-1-1-1")
    private String CS_2_1_1_1; // 剖宫产指征
    public String getCS_2_1_1_1() {  return this.CS_2_1_1_1;}
    @JsonProperty("CS-2-1-1-1")
    public void setCS_2_1_1_1(final String CS_2_1_1_1) { this.CS_2_1_1_1=CS_2_1_1_1;}
    @Column(name = "CS_2_5_1")
    @JsonProperty("CS-2-5-1")
    private String CS_2_5_1; // 符合医学指征
    public String getCS_2_5_1() {  return this.CS_2_5_1;}
    @JsonProperty("CS-2-5-1")
    public void setCS_2_5_1(final String CS_2_5_1) { this.CS_2_5_1=CS_2_5_1;}
    @Column(name = "CS_2_1_1_a")
    @JsonProperty("CS-2-1-1-a")
    private String CS_2_1_1_a; // 胎儿窘迫
    public String getCS_2_1_1_a() {  return this.CS_2_1_1_a;}
    @JsonProperty("CS-2-1-1-a")
    public void setCS_2_1_1_a(final String CS_2_1_1_a) { this.CS_2_1_1_a=CS_2_1_1_a;}
    @Column(name = "CS_2_1_1_b")
    @JsonProperty("CS-2-1-1-b")
    private String CS_2_1_1_b; // 头盆不称
    public String getCS_2_1_1_b() {  return this.CS_2_1_1_b;}
    @JsonProperty("CS-2-1-1-b")
    public void setCS_2_1_1_b(final String CS_2_1_1_b) { this.CS_2_1_1_b=CS_2_1_1_b;}
    @Column(name = "CS_2_1_1_c")
    @JsonProperty("CS-2-1-1-c")
    private String CS_2_1_1_c; // 瘢痕子宫
    public String getCS_2_1_1_c() {  return this.CS_2_1_1_c;}
    @JsonProperty("CS-2-1-1-c")
    public void setCS_2_1_1_c(final String CS_2_1_1_c) { this.CS_2_1_1_c=CS_2_1_1_c;}
    @Column(name = "CS_2_1_1_d")
    @JsonProperty("CS-2-1-1-d")
    private String CS_2_1_1_d; // 胎位异常
    public String getCS_2_1_1_d() {  return this.CS_2_1_1_d;}
    @JsonProperty("CS-2-1-1-d")
    public void setCS_2_1_1_d(final String CS_2_1_1_d) { this.CS_2_1_1_d=CS_2_1_1_d;}
    @Column(name = "CS_2_1_1_e")
    @JsonProperty("CS-2-1-1-e")
    private String CS_2_1_1_e; // 前置胎盘及前置血管
    public String getCS_2_1_1_e() {  return this.CS_2_1_1_e;}
    @JsonProperty("CS-2-1-1-e")
    public void setCS_2_1_1_e(final String CS_2_1_1_e) { this.CS_2_1_1_e=CS_2_1_1_e;}
    @Column(name = "CS_2_1_1_f")
    @JsonProperty("CS-2-1-1-f")
    private String CS_2_1_1_f; // 双胎或多胎妊娠
    public String getCS_2_1_1_f() {  return this.CS_2_1_1_f;}
    @JsonProperty("CS-2-1-1-f")
    public void setCS_2_1_1_f(final String CS_2_1_1_f) { this.CS_2_1_1_f=CS_2_1_1_f;}
    @Column(name = "CS_2_1_1_g")
    @JsonProperty("CS-2-1-1-g")
    private String CS_2_1_1_g; // 脐带脱垂
    public String getCS_2_1_1_g() {  return this.CS_2_1_1_g;}
    @JsonProperty("CS-2-1-1-g")
    public void setCS_2_1_1_g(final String CS_2_1_1_g) { this.CS_2_1_1_g=CS_2_1_1_g;}
    @Column(name = "CS_2_1_1_h")
    @JsonProperty("CS-2-1-1-h")
    private String CS_2_1_1_h; // 胎盘早剥
    public String getCS_2_1_1_h() {  return this.CS_2_1_1_h;}
    @JsonProperty("CS-2-1-1-h")
    public void setCS_2_1_1_h(final String CS_2_1_1_h) { this.CS_2_1_1_h=CS_2_1_1_h;}
    @Column(name = "CS_2_1_1_i")
    @JsonProperty("CS-2-1-1-i")
    private String CS_2_1_1_i; // 孕妇存在严重合并症和并发症
    public String getCS_2_1_1_i() {  return this.CS_2_1_1_i;}
    @JsonProperty("CS-2-1-1-i")
    public void setCS_2_1_1_i(final String CS_2_1_1_i) { this.CS_2_1_1_i=CS_2_1_1_i;}
    @Column(name = "CS_2_1_1_j")
    @JsonProperty("CS-2-1-1-j")
    private String CS_2_1_1_j; // 妊娠巨大儿者
    public String getCS_2_1_1_j() {  return this.CS_2_1_1_j;}
    @JsonProperty("CS-2-1-1-j")
    public void setCS_2_1_1_j(final String CS_2_1_1_j) { this.CS_2_1_1_j=CS_2_1_1_j;}
    @Column(name = "CS_2_1_1_k")
    @JsonProperty("CS-2-1-1-k")
    private String CS_2_1_1_k; // 产道畸形
    public String getCS_2_1_1_k() {  return this.CS_2_1_1_k;}
    @JsonProperty("CS-2-1-1-k")
    public void setCS_2_1_1_k(final String CS_2_1_1_k) { this.CS_2_1_1_k=CS_2_1_1_k;}
    @Column(name = "CS_2_1_1_l")
    @JsonProperty("CS-2-1-1-l")
    private String CS_2_1_1_l; // 外阴疾病
    public String getCS_2_1_1_l() {  return this.CS_2_1_1_l;}
    @JsonProperty("CS-2-1-1-l")
    public void setCS_2_1_1_l(final String CS_2_1_1_l) { this.CS_2_1_1_l=CS_2_1_1_l;}
    @Column(name = "CS_2_1_1_n")
    @JsonProperty("CS-2-1-1-n")
    private String CS_2_1_1_n; // 妊娠合并肿瘤
    public String getCS_2_1_1_n() {  return this.CS_2_1_1_n;}
    @JsonProperty("CS-2-1-1-n")
    public void setCS_2_1_1_n(final String CS_2_1_1_n) { this.CS_2_1_1_n=CS_2_1_1_n;}
    @Column(name = "CS_2_1_1_m")
    @JsonProperty("CS-2-1-1-m")
    private String CS_2_1_1_m; // 生殖道严重的感染性疾病
    public String getCS_2_1_1_m() {  return this.CS_2_1_1_m;}
    @JsonProperty("CS-2-1-1-m")
    public void setCS_2_1_1_m(final String CS_2_1_1_m) { this.CS_2_1_1_m=CS_2_1_1_m;}
    @Column(name = "CS_2_1_1_o")
    @JsonProperty("CS-2-1-1-o")
    private String CS_2_1_1_o; // 剖宫产+伴绝育手术
    public String getCS_2_1_1_o() {  return this.CS_2_1_1_o;}
    @JsonProperty("CS-2-1-1-o")
    public void setCS_2_1_1_o(final String CS_2_1_1_o) { this.CS_2_1_1_o=CS_2_1_1_o;}
    @Column(name = "CS_2_1_1_p")
    @JsonProperty("CS-2-1-1-p")
    private String CS_2_1_1_p; // 其他病理状态
    public String getCS_2_1_1_p() {  return this.CS_2_1_1_p;}
    @JsonProperty("CS-2-1-1-p")
    public void setCS_2_1_1_p(final String CS_2_1_1_p) { this.CS_2_1_1_p=CS_2_1_1_p;}
    @Column(name = "CS_2_1_1_q")
    @JsonProperty("CS-2-1-1-q")
    private String CS_2_1_1_q; // 高龄初产妇
    public String getCS_2_1_1_q() {  return this.CS_2_1_1_q;}
    @JsonProperty("CS-2-1-1-q")
    public void setCS_2_1_1_q(final String CS_2_1_1_q) { this.CS_2_1_1_q=CS_2_1_1_q;}
    @Column(name = "CS_2_1_1_r")
    @JsonProperty("CS-2-1-1-r")
    private String CS_2_1_1_r; // 符合DRGs编码的 剖宫产,伴重要合并症与伴隨病
    public String getCS_2_1_1_r() {  return this.CS_2_1_1_r;}
    @JsonProperty("CS-2-1-1-r")
    public void setCS_2_1_1_r(final String CS_2_1_1_r) { this.CS_2_1_1_r=CS_2_1_1_r;}
    @Column(name = "CS_2_1_1_t")
    @JsonProperty("CS-2-1-1-t")
    private String CS_2_1_1_t; // 符合CHS-DRG/DIP 编码的 剖宫产
    public String getCS_2_1_1_t() {  return this.CS_2_1_1_t;}
    @JsonProperty("CS-2-1-1-t")
    public void setCS_2_1_1_t(final String CS_2_1_1_t) { this.CS_2_1_1_t=CS_2_1_1_t;}
    @Column(name = "CS_2_1_1_s")
    @JsonProperty("CS-2-1-1-s")
    private String CS_2_1_1_s; // 医学其他指征
    public String getCS_2_1_1_s() {  return this.CS_2_1_1_s;}
    @JsonProperty("CS-2-1-1-s")
    public void setCS_2_1_1_s(final String CS_2_1_1_s) { this.CS_2_1_1_s=CS_2_1_1_s;}
    @Column(name = "CS_2_2_1")
    @JsonProperty("CS-2-2-1")
    private String CS_2_2_1; // 孕妇要求剖宫产的评估
    public String getCS_2_2_1() {  return this.CS_2_2_1;}
    @JsonProperty("CS-2-2-1")
    public void setCS_2_2_1(final String CS_2_2_1) { this.CS_2_2_1=CS_2_2_1;}
    @Column(name = "CS_2_3_1")
    @JsonProperty("CS-2-3-1")
    private String CS_2_3_1; // 手术方式选择
    public String getCS_2_3_1() {  return this.CS_2_3_1;}
    @JsonProperty("CS-2-3-1")
    public void setCS_2_3_1(final String CS_2_3_1) { this.CS_2_3_1=CS_2_3_1;}
    @Column(name = "CS_2_4_2")
    @JsonProperty("CS-2-4-2")
    private String CS_2_4_2; // 胎儿娩出日期时间
    public String getCS_2_4_2() {  return this.CS_2_4_2;}
    @JsonProperty("CS-2-4-2")
    public void setCS_2_4_2(final String CS_2_4_2) { this.CS_2_4_2=CS_2_4_2;}
    @Column(name = "CS_3_1_1")
    @JsonProperty("CS-3-1-1")
    private String CS_3_1_1; // 感染风险因素
    public String getCS_3_1_1() {  return this.CS_3_1_1;}
    @JsonProperty("CS-3-1-1")
    public void setCS_3_1_1(final String CS_3_1_1) { this.CS_3_1_1=CS_3_1_1;}
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
    private String CM_1_6_3_2; // 术后48小时之后继续使用的原因
    public String getCM_1_6_3_2() {  return this.CM_1_6_3_2;}
    @JsonProperty("CM-1-6-3-2")
    public void setCM_1_6_3_2(final String CM_1_6_3_2) { this.CM_1_6_3_2=CM_1_6_3_2;}
    @Column(name = "CS_4_1")
    @JsonProperty("CS-4-1")
    private String CS_4_1; // 是否实施新生儿Apgar评分
    public String getCS_4_1() {  return this.CS_4_1;}
    @JsonProperty("CS-4-1")
    public void setCS_4_1(final String CS_4_1) { this.CS_4_1=CS_4_1;}
    @Column(name = "CS_4_2")
    @JsonProperty("CS-4-2")
    private String CS_4_2; // 新生儿出生后1、5、10min,Apgar评分值
    public String getCS_4_2() {  return this.CS_4_2;}
    @JsonProperty("CS-4-2")
    public void setCS_4_2(final String CS_4_2) { this.CS_4_2=CS_4_2;}
    @Column(name = "CS_4_3_1")
    @JsonProperty("CS-4-3-1")
    private String CS_4_3_1; // 出生后1min,Apgar评分值
    public String getCS_4_3_1() {  return this.CS_4_3_1;}
    @JsonProperty("CS-4-3-1")
    public void setCS_4_3_1(final String CS_4_3_1) { this.CS_4_3_1=CS_4_3_1;}
    @Column(name = "CS_4_3_2")
    @JsonProperty("CS-4-3-2")
    private String CS_4_3_2; // 出生后5min,Apgar评分值
    public String getCS_4_3_2() {  return this.CS_4_3_2;}
    @JsonProperty("CS-4-3-2")
    public void setCS_4_3_2(final String CS_4_3_2) { this.CS_4_3_2=CS_4_3_2;}
    @Column(name = "CS_4_3_3")
    @JsonProperty("CS-4-3-3")
    private String CS_4_3_3; // 出生后10min,Apgar评分值
    public String getCS_4_3_3() {  return this.CS_4_3_3;}
    @JsonProperty("CS-4-3-3")
    public void setCS_4_3_3(final String CS_4_3_3) { this.CS_4_3_3=CS_4_3_3;}
    @Column(name = "CS_4_4_1")
    @JsonProperty("CS-4-4-1")
    private String CS_4_4_1; // 新生儿是否要复苏
    public String getCS_4_4_1() {  return this.CS_4_4_1;}
    @JsonProperty("CS-4-4-1")
    public void setCS_4_4_1(final String CS_4_4_1) { this.CS_4_4_1=CS_4_4_1;}
    @Column(name = "CS_4_4_2")
    @JsonProperty("CS-4-4-2")
    private String CS_4_4_2; // 新生儿出生后15、20min,Apgar评分值
    public String getCS_4_4_2() {  return this.CS_4_4_2;}
    @JsonProperty("CS-4-4-2")
    public void setCS_4_4_2(final String CS_4_4_2) { this.CS_4_4_2=CS_4_4_2;}
    @Column(name = "CS_4_4_2_1")
    @JsonProperty("CS-4-4-2-1")
    private String CS_4_4_2_1; // 出生后15min,Apgar评分值
    public String getCS_4_4_2_1() {  return this.CS_4_4_2_1;}
    @JsonProperty("CS-4-4-2-1")
    public void setCS_4_4_2_1(final String CS_4_4_2_1) { this.CS_4_4_2_1=CS_4_4_2_1;}
    @Column(name = "CS_4_4_2_2")
    @JsonProperty("CS-4-4-2-2")
    private String CS_4_4_2_2; // 出生后20min,Apgar评分值
    public String getCS_4_4_2_2() {  return this.CS_4_4_2_2;}
    @JsonProperty("CS-4-4-2-2")
    public void setCS_4_4_2_2(final String CS_4_4_2_2) { this.CS_4_4_2_2=CS_4_4_2_2;}
    @Column(name = "CS_4_5_1")
    @JsonProperty("CS-4-5-1")
    private String CS_4_5_1; // 出生后5min新生儿Apgar评分的临床风险分层 
    public String getCS_4_5_1() {  return this.CS_4_5_1;}
    @JsonProperty("CS-4-5-1")
    public void setCS_4_5_1(final String CS_4_5_1) { this.CS_4_5_1=CS_4_5_1;}
    @Column(name = "CS_4_5_2")
    @JsonProperty("CS-4-5-2")
    private String CS_4_5_2; // 新生儿出生体重及分层
    public String getCS_4_5_2() {  return this.CS_4_5_2;}
    @JsonProperty("CS-4-5-2")
    public void setCS_4_5_2(final String CS_4_5_2) { this.CS_4_5_2=CS_4_5_2;}
    @Column(name = "CS_4_5_3")
    @JsonProperty("CS-4-5-3")
    private String CS_4_5_3; // 是否有脐带血气分析
    public String getCS_4_5_3() {  return this.CS_4_5_3;}
    @JsonProperty("CS-4-5-3")
    public void setCS_4_5_3(final String CS_4_5_3) { this.CS_4_5_3=CS_4_5_3;}
    @Column(name = "CS_4_5_4")
    @JsonProperty("CS-4-5-4")
    private String CS_4_5_4; // 脐带血气分析标本采集日期时间
    public String getCS_4_5_4() {  return this.CS_4_5_4;}
    @JsonProperty("CS-4-5-4")
    public void setCS_4_5_4(final String CS_4_5_4) { this.CS_4_5_4=CS_4_5_4;}
    @Column(name = "CS_4_5_5")
    @JsonProperty("CS-4-5-5")
    private String CS_4_5_5; // 脐带血气分析值
    public String getCS_4_5_5() {  return this.CS_4_5_5;}
    @JsonProperty("CS-4-5-5")
    public void setCS_4_5_5(final String CS_4_5_5) { this.CS_4_5_5=CS_4_5_5;}
    @Column(name = "CS_4_5_5_1")
    @JsonProperty("CS-4-5-5-1")
    private String CS_4_5_5_1; // pH值
    public String getCS_4_5_5_1() {  return this.CS_4_5_5_1;}
    @JsonProperty("CS-4-5-5-1")
    public void setCS_4_5_5_1(final String CS_4_5_5_1) { this.CS_4_5_5_1=CS_4_5_5_1;}
    @Column(name = "CS_4_5_5_2")
    @JsonProperty("CS-4-5-5-2")
    private String CS_4_5_5_2; // PaCO₂(mmHg)
    public String getCS_4_5_5_2() {  return this.CS_4_5_5_2;}
    @JsonProperty("CS-4-5-5-2")
    public void setCS_4_5_5_2(final String CS_4_5_5_2) { this.CS_4_5_5_2=CS_4_5_5_2;}
    @Column(name = "CS_4_5_5_3")
    @JsonProperty("CS-4-5-5-3")
    private String CS_4_5_5_3; // PaO₂(mmHg)
    public String getCS_4_5_5_3() {  return this.CS_4_5_5_3;}
    @JsonProperty("CS-4-5-5-3")
    public void setCS_4_5_5_3(final String CS_4_5_5_3) { this.CS_4_5_5_3=CS_4_5_5_3;}
    @Column(name = "CS_4_5_5_4")
    @JsonProperty("CS-4-5-5-4")
    private String CS_4_5_5_4; // HCO₃(mmol/L)
    public String getCS_4_5_5_4() {  return this.CS_4_5_5_4;}
    @JsonProperty("CS-4-5-5-4")
    public void setCS_4_5_5_4(final String CS_4_5_5_4) { this.CS_4_5_5_4=CS_4_5_5_4;}
    @Column(name = "CS_5_1")
    @JsonProperty("CS-5-1")
    private String CS_5_1; // 术后24小时内出血量
    public String getCS_5_1() {  return this.CS_5_1;}
    @JsonProperty("CS-5-1")
    public void setCS_5_1(final String CS_5_1) { this.CS_5_1=CS_5_1;}
    @Column(name = "CS_5_1_1")
    @JsonProperty("CS-5-1-1")
    private String CS_5_1_1; // 术后24小时内实际出血量（ml）
    public String getCS_5_1_1() {  return this.CS_5_1_1;}
    @JsonProperty("CS-5-1-1")
    public void setCS_5_1_1(final String CS_5_1_1) { this.CS_5_1_1=CS_5_1_1;}
    @Column(name = "CS_5_2_1")
    @JsonProperty("CS-5-2-1")
    private String CS_5_2_1; // 剖宫产产后出血可能的原因
    public String getCS_5_2_1() {  return this.CS_5_2_1;}
    @JsonProperty("CS-5-2-1")
    public void setCS_5_2_1(final String CS_5_2_1) { this.CS_5_2_1=CS_5_2_1;}
    @Column(name = "CS_5_3")
    @JsonProperty("CS-5-3")
    private String CS_5_3; // 术后24小时内输血量
    public String getCS_5_3() {  return this.CS_5_3;}
    @JsonProperty("CS-5-3")
    public void setCS_5_3(final String CS_5_3) { this.CS_5_3=CS_5_3;}
    @Column(name = "CS_5_4")
    @JsonProperty("CS-5-4")
    private String CS_5_4; // 术后24小时内实际输血量（ml）
    public String getCS_5_4() {  return this.CS_5_4;}
    @JsonProperty("CS-5-4")
    public void setCS_5_4(final String CS_5_4) { this.CS_5_4=CS_5_4;}
    @Column(name = "CS_5_5")
    @JsonProperty("CS-5-5")
    private String CS_5_5; // 止血干预措施的选择
    public String getCS_5_5() {  return this.CS_5_5;}
    @JsonProperty("CS-5-5")
    public void setCS_5_5(final String CS_5_5) { this.CS_5_5=CS_5_5;}
    @Column(name = "CS_6_1_1")
    @JsonProperty("CS-6-1-1")
    private String CS_6_1_1; // 是否有剖宫产并发症
    public String getCS_6_1_1() {  return this.CS_6_1_1;}
    @JsonProperty("CS-6-1-1")
    public void setCS_6_1_1(final String CS_6_1_1) { this.CS_6_1_1=CS_6_1_1;}
    @Column(name = "CS_6_1_3_1")
    @JsonProperty("CS-6-1-3-1")
    private String CS_6_1_3_1; // 剖宫产并发症ICD-10编码
    public String getCS_6_1_3_1() {  return this.CS_6_1_3_1;}
    @JsonProperty("CS-6-1-3-1")
    public void setCS_6_1_3_1(final String CS_6_1_3_1) { this.CS_6_1_3_1=CS_6_1_3_1;}
    @Column(name = "CS_6_1_2_1_a")
    @JsonProperty("CS-6-1-2-1-a")
    private String CS_6_1_2_1_a; // 产后出血
    public String getCS_6_1_2_1_a() {  return this.CS_6_1_2_1_a;}
    @JsonProperty("CS-6-1-2-1-a")
    public void setCS_6_1_2_1_a(final String CS_6_1_2_1_a) { this.CS_6_1_2_1_a=CS_6_1_2_1_a;}
    @Column(name = "CS_6_1_2_1_b")
    @JsonProperty("CS-6-1-2-1-b")
    private String CS_6_1_2_1_b; // 产褥期感染
    public String getCS_6_1_2_1_b() {  return this.CS_6_1_2_1_b;}
    @JsonProperty("CS-6-1-2-1-b")
    public void setCS_6_1_2_1_b(final String CS_6_1_2_1_b) { this.CS_6_1_2_1_b=CS_6_1_2_1_b;}
    @Column(name = "CS_6_1_2_1_c")
    @JsonProperty("CS-6-1-2-1-c")
    private String CS_6_1_2_1_c; // 产科栓塞
    public String getCS_6_1_2_1_c() {  return this.CS_6_1_2_1_c;}
    @JsonProperty("CS-6-1-2-1-c")
    public void setCS_6_1_2_1_c(final String CS_6_1_2_1_c) { this.CS_6_1_2_1_c=CS_6_1_2_1_c;}
    @Column(name = "CS_6_1_2_1_d")
    @JsonProperty("CS-6-1-2-1-d")
    private String CS_6_1_2_1_d; // 栓塞病
    public String getCS_6_1_2_1_d() {  return this.CS_6_1_2_1_d;}
    @JsonProperty("CS-6-1-2-1-d")
    public void setCS_6_1_2_1_d(final String CS_6_1_2_1_d) { this.CS_6_1_2_1_d=CS_6_1_2_1_d;}
    @Column(name = "CS_6_1_2_1_e")
    @JsonProperty("CS-6-1-2-1-e")
    private String CS_6_1_2_1_e; // 胎盘和胎膜滞留不伴有出血
    public String getCS_6_1_2_1_e() {  return this.CS_6_1_2_1_e;}
    @JsonProperty("CS-6-1-2-1-e")
    public void setCS_6_1_2_1_e(final String CS_6_1_2_1_e) { this.CS_6_1_2_1_e=CS_6_1_2_1_e;}
    @Column(name = "CS_6_1_2_1_f")
    @JsonProperty("CS-6-1-2-1-f")
    private String CS_6_1_2_1_f; // 产科手术伤口的感染
    public String getCS_6_1_2_1_f() {  return this.CS_6_1_2_1_f;}
    @JsonProperty("CS-6-1-2-1-f")
    public void setCS_6_1_2_1_f(final String CS_6_1_2_1_f) { this.CS_6_1_2_1_f=CS_6_1_2_1_f;}
    @Column(name = "CS_6_1_2_1_g")
    @JsonProperty("CS-6-1-2-1-g")
    private String CS_6_1_2_1_g; // 产科伤口裂开
    public String getCS_6_1_2_1_g() {  return this.CS_6_1_2_1_g;}
    @JsonProperty("CS-6-1-2-1-g")
    public void setCS_6_1_2_1_g(final String CS_6_1_2_1_g) { this.CS_6_1_2_1_g=CS_6_1_2_1_g;}
    @Column(name = "CS_6_1_2_1_h")
    @JsonProperty("CS-6-1-2-1-h")
    private String CS_6_1_2_1_h; // 其他并发症
    public String getCS_6_1_2_1_h() {  return this.CS_6_1_2_1_h;}
    @JsonProperty("CS-6-1-2-1-h")
    public void setCS_6_1_2_1_h(final String CS_6_1_2_1_h) { this.CS_6_1_2_1_h=CS_6_1_2_1_h;}
    @Column(name = "CS_6_2")
    @JsonProperty("CS-6-2")
    private String CS_6_2; // 是否再次手术
    public String getCS_6_2() {  return this.CS_6_2;}
    @JsonProperty("CS-6-2")
    public void setCS_6_2(final String CS_6_2) { this.CS_6_2=CS_6_2;}
    @Column(name = "CS_6_3")
    @JsonProperty("CS-6-3")
    private String CS_6_3; // 再次手术原因
    public String getCS_6_3() {  return this.CS_6_3;}
    @JsonProperty("CS-6-3")
    public void setCS_6_3(final String CS_6_3) { this.CS_6_3=CS_6_3;}
    @Column(name = "CS_6_3_1")
    @JsonProperty("CS-6-3-1")
    private String CS_6_3_1; // 其他再次手术原因
    public String getCS_6_3_1() {  return this.CS_6_3_1;}
    @JsonProperty("CS-6-3-1")
    public void setCS_6_3_1(final String CS_6_3_1) { this.CS_6_3_1=CS_6_3_1;}
    @Column(name = "CS_6_4")
    @JsonProperty("CS-6-4")
    private String CS_6_4; // 影响程度的选择
    public String getCS_6_4() {  return this.CS_6_4;}
    @JsonProperty("CS-6-4")
    public void setCS_6_4(final String CS_6_4) { this.CS_6_4=CS_6_4;}
    @Column(name = "CS_7_1")
    @JsonProperty("CS-7-1")
    private String CS_7_1; // 是否有新生儿产伤
    public String getCS_7_1() {  return this.CS_7_1;}
    @JsonProperty("CS-7-1")
    public void setCS_7_1(final String CS_7_1) { this.CS_7_1=CS_7_1;}
    @Column(name = "CS_7_2")
    @JsonProperty("CS-7-2")
    private String CS_7_2; // 产程和分娩期间并发症所列的名称及ICD.10编码
    public String getCS_7_2() {  return this.CS_7_2;}
    @JsonProperty("CS-7-2")
    public void setCS_7_2(final String CS_7_2) { this.CS_7_2=CS_7_2;}
    @Column(name = "CS_7_2_a")
    @JsonProperty("CS-7-2-a")
    private String CS_7_2_a; // ICD-10：P10产伤引起的颅内撕裂和出血
    public String getCS_7_2_a() {  return this.CS_7_2_a;}
    @JsonProperty("CS-7-2-a")
    public void setCS_7_2_a(final String CS_7_2_a) { this.CS_7_2_a=CS_7_2_a;}
    @Column(name = "CS_7_2_b")
    @JsonProperty("CS-7-2-b")
    private String CS_7_2_b; // ICD-10：P11产伤致新生儿脑伤
    public String getCS_7_2_b() {  return this.CS_7_2_b;}
    @JsonProperty("CS-7-2-b")
    public void setCS_7_2_b(final String CS_7_2_b) { this.CS_7_2_b=CS_7_2_b;}
    @Column(name = "CS_7_2_c")
    @JsonProperty("CS-7-2-c")
    private String CS_7_2_c; // ICD-10：P12头皮产伤
    public String getCS_7_2_c() {  return this.CS_7_2_c;}
    @JsonProperty("CS-7-2-c")
    public void setCS_7_2_c(final String CS_7_2_c) { this.CS_7_2_c=CS_7_2_c;}
    @Column(name = "CS_7_2_d")
    @JsonProperty("CS-7-2-d")
    private String CS_7_2_d; // ICD-10：P13颅骨产伤
    public String getCS_7_2_d() {  return this.CS_7_2_d;}
    @JsonProperty("CS-7-2-d")
    public void setCS_7_2_d(final String CS_7_2_d) { this.CS_7_2_d=CS_7_2_d;}
    @Column(name = "CS_7_2_e")
    @JsonProperty("CS-7-2-e")
    private String CS_7_2_e; // ICD-10：P14神经产伤
    public String getCS_7_2_e() {  return this.CS_7_2_e;}
    @JsonProperty("CS-7-2-e")
    public void setCS_7_2_e(final String CS_7_2_e) { this.CS_7_2_e=CS_7_2_e;}
    @Column(name = "CS_7_2_f")
    @JsonProperty("CS-7-2-f")
    private String CS_7_2_f; // ICD-10：P15其他产伤
    public String getCS_7_2_f() {  return this.CS_7_2_f;}
    @JsonProperty("CS-7-2-f")
    public void setCS_7_2_f(final String CS_7_2_f) { this.CS_7_2_f=CS_7_2_f;}
    @Column(name = "CS_7_2_g")
    @JsonProperty("CS-7-2-g")
    private String CS_7_2_g; // ICD-10：P20子宫内低氧症
    public String getCS_7_2_g() {  return this.CS_7_2_g;}
    @JsonProperty("CS-7-2-g")
    public void setCS_7_2_g(final String CS_7_2_g) { this.CS_7_2_g=CS_7_2_g;}
    @Column(name = "CS_7_2_h")
    @JsonProperty("CS-7-2-h")
    private String CS_7_2_h; // ICD-10：P21出生窒息
    public String getCS_7_2_h() {  return this.CS_7_2_h;}
    @JsonProperty("CS-7-2-h")
    public void setCS_7_2_h(final String CS_7_2_h) { this.CS_7_2_h=CS_7_2_h;}
    @Column(name = "CS_7_3")
    @JsonProperty("CS-7-3")
    private String CS_7_3; // 新生儿是否有先天性畸形、变形和染色体异常
    public String getCS_7_3() {  return this.CS_7_3;}
    @JsonProperty("CS-7-3")
    public void setCS_7_3(final String CS_7_3) { this.CS_7_3=CS_7_3;}
    @Column(name = "CS_7_4")
    @JsonProperty("CS-7-4")
    private String CS_7_4; // 新生儿：先天性畸形、变形和染色体异常的名称及ICD.10编码
    public String getCS_7_4() {  return this.CS_7_4;}
    @JsonProperty("CS-7-4")
    public void setCS_7_4(final String CS_7_4) { this.CS_7_4=CS_7_4;}
    @Column(name = "CS_8_2_1")
    @JsonProperty("CS-8-2-1")
    private String CS_8_2_1; // 是否有母乳喂养禁忌证
    public String getCS_8_2_1() {  return this.CS_8_2_1;}
    @JsonProperty("CS-8-2-1")
    public void setCS_8_2_1(final String CS_8_2_1) { this.CS_8_2_1=CS_8_2_1;}
    @Column(name = "CS_8_1_1")
    @JsonProperty("CS-8-1-1")
    private String CS_8_1_1; // 母乳喂养禁忌证选择
    public String getCS_8_1_1() {  return this.CS_8_1_1;}
    @JsonProperty("CS-8-1-1")
    public void setCS_8_1_1(final String CS_8_1_1) { this.CS_8_1_1=CS_8_1_1;}
    @Column(name = "CS_8_1_1_1")
    @JsonProperty("CS-8-1-1-1")
    private String CS_8_1_1_1; // 母乳喂养禁忌证其他
    public String getCS_8_1_1_1() {  return this.CS_8_1_1_1;}
    @JsonProperty("CS-8-1-1-1")
    public void setCS_8_1_1_1(final String CS_8_1_1_1) { this.CS_8_1_1_1=CS_8_1_1_1;}
    @Column(name = "CS_8_2")
    @JsonProperty("CS-8-2")
    private String CS_8_2; // 提供母乳喂养
    public String getCS_8_2() {  return this.CS_8_2;}
    @JsonProperty("CS-8-2")
    public void setCS_8_2(final String CS_8_2) { this.CS_8_2=CS_8_2;}
    @Column(name = "CS_9_1_1")
    @JsonProperty("CS-9-1-1")
    private String CS_9_1_1; // 住院期间为产妇提供术前健康教育
    public String getCS_9_1_1() {  return this.CS_9_1_1;}
    @JsonProperty("CS-9-1-1")
    public void setCS_9_1_1(final String CS_9_1_1) { this.CS_9_1_1=CS_9_1_1;}
    @Column(name = "CS_9_1_2")
    @JsonProperty("CS-9-1-2")
    private String CS_9_1_2; // 提供产后康复健康教育
    public String getCS_9_1_2() {  return this.CS_9_1_2;}
    @JsonProperty("CS-9-1-2")
    public void setCS_9_1_2(final String CS_9_1_2) { this.CS_9_1_2=CS_9_1_2;}
    @Column(name = "CS_9_1_3")
    @JsonProperty("CS-9-1-3")
    private String CS_9_1_3; // 是否提供术后镇痛
    public String getCS_9_1_3() {  return this.CS_9_1_3;}
    @JsonProperty("CS-9-1-3")
    public void setCS_9_1_3(final String CS_9_1_3) { this.CS_9_1_3=CS_9_1_3;}
    @Column(name = "CS_9_1_4")
    @JsonProperty("CS-9-1-4")
    private String CS_9_1_4; // 药物选择
    public String getCS_9_1_4() {  return this.CS_9_1_4;}
    @JsonProperty("CS-9-1-4")
    public void setCS_9_1_4(final String CS_9_1_4) { this.CS_9_1_4=CS_9_1_4;}
    @Column(name = "CS_9_1_4_1")
    @JsonProperty("CS-9-1-4-1")
    private String CS_9_1_4_1; // 其他镇痛药物
    public String getCS_9_1_4_1() {  return this.CS_9_1_4_1;}
    @JsonProperty("CS-9-1-4-1")
    public void setCS_9_1_4_1(final String CS_9_1_4_1) { this.CS_9_1_4_1=CS_9_1_4_1;}
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    public String getCM_7_2_1() {  return this.CM_7_2_1;}
    @JsonProperty("CM-7-2-1")
    public void setCM_7_2_1(final String CM_7_2_1) { this.CM_7_2_1=CM_7_2_1;}
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 母乳喂养与出院带药
    public String getCM_7_2_2() {  return this.CM_7_2_2;}
    @JsonProperty("CM-7-2-2")
    public void setCM_7_2_2(final String CM_7_2_2) { this.CM_7_2_2=CM_7_2_2;}
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知 出院关注事项
    public String getCM_7_2_3() {  return this.CM_7_2_3;}
    @JsonProperty("CM-7-2-3")
    public void setCM_7_2_3(final String CM_7_2_3) { this.CM_7_2_3=CM_7_2_3;}
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 出院时教育
    public String getCM_7_2_4() {  return this.CM_7_2_4;}
    @JsonProperty("CM-7-2-4")
    public void setCM_7_2_4(final String CM_7_2_4) { this.CM_7_2_4=CM_7_2_4;}
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 告知随访
    public String getCM_7_2_5() {  return this.CM_7_2_5;}
    @JsonProperty("CM-7-2-5")
    public void setCM_7_2_5(final String CM_7_2_5) { this.CM_7_2_5=CM_7_2_5;}
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