package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：I21.0 至 I21.3、I21.9 的出院患者。
*/
@ApiModel(value = "01信息")
@Entity
@Table(name = "sd_info_STEMI")
public class SdInfoSTEMI implements Serializable {
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
    @Column(name = "STEMI_0_4_6")
    @JsonProperty("STEMI-0-4-6")
    private String STEMI_0_4_6; // 救护车类型
    public String getSTEMI_0_4_6() {  return this.STEMI_0_4_6;}
    @JsonProperty("STEMI-0-4-6")
    public void setSTEMI_0_4_6(final String STEMI_0_4_6) { this.STEMI_0_4_6=STEMI_0_4_6;}
    @Column(name = "STEMI_0_4_1")
    @JsonProperty("STEMI-0-4-1")
    private String STEMI_0_4_1; // 是否现场评估生命体征，施行急救
    public String getSTEMI_0_4_1() {  return this.STEMI_0_4_1;}
    @JsonProperty("STEMI-0-4-1")
    public void setSTEMI_0_4_1(final String STEMI_0_4_1) { this.STEMI_0_4_1=STEMI_0_4_1;}
    @Column(name = "STEMI_0_4_2")
    @JsonProperty("STEMI-0-4-2")
    private String STEMI_0_4_2; // 到达现场后10分钟内是否完成心电图检查
    public String getSTEMI_0_4_2() {  return this.STEMI_0_4_2;}
    @JsonProperty("STEMI-0-4-2")
    public void setSTEMI_0_4_2(final String STEMI_0_4_2) { this.STEMI_0_4_2=STEMI_0_4_2;}
    @Column(name = "STEMI_0_4_3")
    @JsonProperty("STEMI-0-4-3")
    private String STEMI_0_4_3; // 现场急救维持生命体征稳定措施选择
    public String getSTEMI_0_4_3() {  return this.STEMI_0_4_3;}
    @JsonProperty("STEMI-0-4-3")
    public void setSTEMI_0_4_3(final String STEMI_0_4_3) { this.STEMI_0_4_3=STEMI_0_4_3;}
    @Column(name = "STEMI_0_4_4")
    @JsonProperty("STEMI-0-4-4")
    private String STEMI_0_4_4; // 对持续胸痛＞15分钟和心电图ST段抬高，且无“阿斯匹林”禁忌症的患者用药
    public String getSTEMI_0_4_4() {  return this.STEMI_0_4_4;}
    @JsonProperty("STEMI-0-4-4")
    public void setSTEMI_0_4_4(final String STEMI_0_4_4) { this.STEMI_0_4_4=STEMI_0_4_4;}
    @Column(name = "STEMI_0_4_5")
    @JsonProperty("STEMI-0-4-5")
    private String STEMI_0_4_5; // 是否利用救护车中车载信息系统、微信、彩信等多种形式传输心电图等院前信息至目标医院
    public String getSTEMI_0_4_5() {  return this.STEMI_0_4_5;}
    @JsonProperty("STEMI-0-4-5")
    public void setSTEMI_0_4_5(final String STEMI_0_4_5) { this.STEMI_0_4_5=STEMI_0_4_5;}
    @Column(name = "STEMI_0_4_7")
    @JsonProperty("STEMI-0-4-7")
    private String STEMI_0_4_7; // 是否入院前在救护车上开始溶栓治疗
    public String getSTEMI_0_4_7() {  return this.STEMI_0_4_7;}
    @JsonProperty("STEMI-0-4-7")
    public void setSTEMI_0_4_7(final String STEMI_0_4_7) { this.STEMI_0_4_7=STEMI_0_4_7;}
    @Column(name = "STEMI_1_1_4")
    @JsonProperty("STEMI-1-1-4")
    private String STEMI_1_1_4; // 是否有症状和病史
    public String getSTEMI_1_1_4() {  return this.STEMI_1_1_4;}
    @JsonProperty("STEMI-1-1-4")
    public void setSTEMI_1_1_4(final String STEMI_1_1_4) { this.STEMI_1_1_4=STEMI_1_1_4;}
    @Column(name = "STEMI_1_1_5")
    @JsonProperty("STEMI-1-1-5")
    private String STEMI_1_1_5; // 症状和体征选择
    public String getSTEMI_1_1_5() {  return this.STEMI_1_1_5;}
    @JsonProperty("STEMI-1-1-5")
    public void setSTEMI_1_1_5(final String STEMI_1_1_5) { this.STEMI_1_1_5=STEMI_1_1_5;}
    @Column(name = "STEMI_1_1_6")
    @JsonProperty("STEMI-1-1-6")
    private String STEMI_1_1_6; // 是否实施首次采用Killip分级法评估心功能
    public String getSTEMI_1_1_6() {  return this.STEMI_1_1_6;}
    @JsonProperty("STEMI-1-1-6")
    public void setSTEMI_1_1_6(final String STEMI_1_1_6) { this.STEMI_1_1_6=STEMI_1_1_6;}
    @Column(name = "STEMI_1_1_7")
    @JsonProperty("STEMI-1-1-7")
    private String STEMI_1_1_7; // Killip分级，症状及体征选择
    public String getSTEMI_1_1_7() {  return this.STEMI_1_1_7;}
    @JsonProperty("STEMI-1-1-7")
    public void setSTEMI_1_1_7(final String STEMI_1_1_7) { this.STEMI_1_1_7=STEMI_1_1_7;}
    @Column(name = "STEMI_1_1_1")
    @JsonProperty("STEMI-1-1-1")
    private String STEMI_1_1_1; // 是否实施首次心电图检查
    public String getSTEMI_1_1_1() {  return this.STEMI_1_1_1;}
    @JsonProperty("STEMI-1-1-1")
    public void setSTEMI_1_1_1(final String STEMI_1_1_1) { this.STEMI_1_1_1=STEMI_1_1_1;}
    @Column(name = "STEMI_1_1_2_1")
    @JsonProperty("STEMI-1-1-2-1")
    private String STEMI_1_1_2_1; // 心电图检查结果确诊STEMI报告日期时间
    public String getSTEMI_1_1_2_1() {  return this.STEMI_1_1_2_1;}
    @JsonProperty("STEMI-1-1-2-1")
    public void setSTEMI_1_1_2_1(final String STEMI_1_1_2_1) { this.STEMI_1_1_2_1=STEMI_1_1_2_1;}
    @Column(name = "STEMI_1_1_3")
    @JsonProperty("STEMI-1-1-3")
    private String STEMI_1_1_3; // 心电图检查结果，具有STEMI特征性诊断标准的选择
    public String getSTEMI_1_1_3() {  return this.STEMI_1_1_3;}
    @JsonProperty("STEMI-1-1-3")
    public void setSTEMI_1_1_3(final String STEMI_1_1_3) { this.STEMI_1_1_3=STEMI_1_1_3;}
    @Column(name = "STEMI_1_1_3_1")
    @JsonProperty("STEMI-1-1-3-1")
    private String STEMI_1_1_3_1; // 其他心电图检查结果填写
    public String getSTEMI_1_1_3_1() {  return this.STEMI_1_1_3_1;}
    @JsonProperty("STEMI-1-1-3-1")
    public void setSTEMI_1_1_3_1(final String STEMI_1_1_3_1) { this.STEMI_1_1_3_1=STEMI_1_1_3_1;}
    @Column(name = "STEMI_1_2_1")
    @JsonProperty("STEMI-1-2-1")
    private String STEMI_1_2_1; // 是否有P2Y12受体拮抗剂禁忌证
    public String getSTEMI_1_2_1() {  return this.STEMI_1_2_1;}
    @JsonProperty("STEMI-1-2-1")
    public void setSTEMI_1_2_1(final String STEMI_1_2_1) { this.STEMI_1_2_1=STEMI_1_2_1;}
    @Column(name = "STEMI_1_2_2")
    @JsonProperty("STEMI-1-2-2")
    private String STEMI_1_2_2; // P2Y12受体拮抗剂禁忌证
    public String getSTEMI_1_2_2() {  return this.STEMI_1_2_2;}
    @JsonProperty("STEMI-1-2-2")
    public void setSTEMI_1_2_2(final String STEMI_1_2_2) { this.STEMI_1_2_2=STEMI_1_2_2;}
    @Column(name = "STEMI_1_2_2_1")
    @JsonProperty("STEMI-1-2-2-1")
    private String STEMI_1_2_2_1; // 其他P2Y12受体拮抗剂禁忌证填写
    public String getSTEMI_1_2_2_1() {  return this.STEMI_1_2_2_1;}
    @JsonProperty("STEMI-1-2-2-1")
    public void setSTEMI_1_2_2_1(final String STEMI_1_2_2_1) { this.STEMI_1_2_2_1=STEMI_1_2_2_1;}
    @Column(name = "STEMI_1_2_3")
    @JsonProperty("STEMI-1-2-3")
    private String STEMI_1_2_3; // 首剂给予双联抗血小板药负荷剂量
    public String getSTEMI_1_2_3() {  return this.STEMI_1_2_3;}
    @JsonProperty("STEMI-1-2-3")
    public void setSTEMI_1_2_3(final String STEMI_1_2_3) { this.STEMI_1_2_3=STEMI_1_2_3;}
    @Column(name = "STEMI_1_2_3_1")
    @JsonProperty("STEMI-1-2-3-1")
    private String STEMI_1_2_3_1; // 其他抗血小板药物填写
    public String getSTEMI_1_2_3_1() {  return this.STEMI_1_2_3_1;}
    @JsonProperty("STEMI-1-2-3-1")
    public void setSTEMI_1_2_3_1(final String STEMI_1_2_3_1) { this.STEMI_1_2_3_1=STEMI_1_2_3_1;}
    @Column(name = "STEMI_1_2_4_1")
    @JsonProperty("STEMI-1-2-4-1")
    private String STEMI_1_2_4_1; // 用药日期时间
    public String getSTEMI_1_2_4_1() {  return this.STEMI_1_2_4_1;}
    @JsonProperty("STEMI-1-2-4-1")
    public void setSTEMI_1_2_4_1(final String STEMI_1_2_4_1) { this.STEMI_1_2_4_1=STEMI_1_2_4_1;}
    @Column(name = "STEMI_1_3_1_1")
    @JsonProperty("STEMI-1-3-1-1")
    private String STEMI_1_3_1_1; // 是否实施首次心脏标志物检测
    public String getSTEMI_1_3_1_1() {  return this.STEMI_1_3_1_1;}
    @JsonProperty("STEMI-1-3-1-1")
    public void setSTEMI_1_3_1_1(final String STEMI_1_3_1_1) { this.STEMI_1_3_1_1=STEMI_1_3_1_1;}
    @Column(name = "STEMI_1_3_1_2_1")
    @JsonProperty("STEMI-1-3-1-2-1")
    private String STEMI_1_3_1_2_1; // 首次心脏标志物检测结果报告日期时间
    public String getSTEMI_1_3_1_2_1() {  return this.STEMI_1_3_1_2_1;}
    @JsonProperty("STEMI-1-3-1-2-1")
    public void setSTEMI_1_3_1_2_1(final String STEMI_1_3_1_2_1) { this.STEMI_1_3_1_2_1=STEMI_1_3_1_2_1;}
    @Column(name = "STEMI_1_3_2")
    @JsonProperty("STEMI-1-3-2")
    private String STEMI_1_3_2; // 首次心脏标志物检测选项和数值
    public String getSTEMI_1_3_2() {  return this.STEMI_1_3_2;}
    @JsonProperty("STEMI-1-3-2")
    public void setSTEMI_1_3_2(final String STEMI_1_3_2) { this.STEMI_1_3_2=STEMI_1_3_2;}
    @Column(name = "STEMI_1_4_1_1")
    @JsonProperty("STEMI-1-4-1-1")
    private String STEMI_1_4_1_1; // 肌钙蛋白T检测选项
    public String getSTEMI_1_4_1_1() {  return this.STEMI_1_4_1_1;}
    @JsonProperty("STEMI-1-4-1-1")
    public void setSTEMI_1_4_1_1(final String STEMI_1_4_1_1) { this.STEMI_1_4_1_1=STEMI_1_4_1_1;}
    @Column(name = "STEMI_1_3_3_1")
    @JsonProperty("STEMI-1-3-3-1")
    private String STEMI_1_3_3_1; // 肌钙蛋白T检测值(ng/Ml)
    public String getSTEMI_1_3_3_1() {  return this.STEMI_1_3_3_1;}
    @JsonProperty("STEMI-1-3-3-1")
    public void setSTEMI_1_3_3_1(final String STEMI_1_3_3_1) { this.STEMI_1_3_3_1=STEMI_1_3_3_1;}
    @Column(name = "STEMI_1_4_1_2")
    @JsonProperty("STEMI-1-4-1-2")
    private String STEMI_1_4_1_2; // 肌钙蛋白T定性检测选择
    public String getSTEMI_1_4_1_2() {  return this.STEMI_1_4_1_2;}
    @JsonProperty("STEMI-1-4-1-2")
    public void setSTEMI_1_4_1_2(final String STEMI_1_4_1_2) { this.STEMI_1_4_1_2=STEMI_1_4_1_2;}
    @Column(name = "STEMI_1_4_2_1")
    @JsonProperty("STEMI-1-4-2-1")
    private String STEMI_1_4_2_1; // 肌钙蛋白I检测选项
    public String getSTEMI_1_4_2_1() {  return this.STEMI_1_4_2_1;}
    @JsonProperty("STEMI-1-4-2-1")
    public void setSTEMI_1_4_2_1(final String STEMI_1_4_2_1) { this.STEMI_1_4_2_1=STEMI_1_4_2_1;}
    @Column(name = "STEMI_1_3_3_2")
    @JsonProperty("STEMI-1-3-3-2")
    private String STEMI_1_3_3_2; // 肌钙蛋白I检测值(ng/mL)
    public String getSTEMI_1_3_3_2() {  return this.STEMI_1_3_3_2;}
    @JsonProperty("STEMI-1-3-3-2")
    public void setSTEMI_1_3_3_2(final String STEMI_1_3_3_2) { this.STEMI_1_3_3_2=STEMI_1_3_3_2;}
    @Column(name = "STEMI_1_4_2_2")
    @JsonProperty("STEMI-1-4-2-2")
    private String STEMI_1_4_2_2; // 肌钙蛋白I定性检测选择
    public String getSTEMI_1_4_2_2() {  return this.STEMI_1_4_2_2;}
    @JsonProperty("STEMI-1-4-2-2")
    public void setSTEMI_1_4_2_2(final String STEMI_1_4_2_2) { this.STEMI_1_4_2_2=STEMI_1_4_2_2;}
    @Column(name = "STEMI_1_4_3_1")
    @JsonProperty("STEMI-1-4-3-1")
    private String STEMI_1_4_3_1; // 肌酸激酶同工酶检测选项
    public String getSTEMI_1_4_3_1() {  return this.STEMI_1_4_3_1;}
    @JsonProperty("STEMI-1-4-3-1")
    public void setSTEMI_1_4_3_1(final String STEMI_1_4_3_1) { this.STEMI_1_4_3_1=STEMI_1_4_3_1;}
    @Column(name = "STEMI_1_3_3_3")
    @JsonProperty("STEMI-1-3-3-3")
    private String STEMI_1_3_3_3; // 肌酸激酶同工酶检测值(ng/mL)
    public String getSTEMI_1_3_3_3() {  return this.STEMI_1_3_3_3;}
    @JsonProperty("STEMI-1-3-3-3")
    public void setSTEMI_1_3_3_3(final String STEMI_1_3_3_3) { this.STEMI_1_3_3_3=STEMI_1_3_3_3;}
    @Column(name = "STEMI_1_4_3_2")
    @JsonProperty("STEMI-1-4-3-2")
    private String STEMI_1_4_3_2; // 肌酸激酶同工酶定性检测选择
    public String getSTEMI_1_4_3_2() {  return this.STEMI_1_4_3_2;}
    @JsonProperty("STEMI-1-4-3-2")
    public void setSTEMI_1_4_3_2(final String STEMI_1_4_3_2) { this.STEMI_1_4_3_2=STEMI_1_4_3_2;}
    @Column(name = "STEMI_1_4_4_1")
    @JsonProperty("STEMI-1-4-4-1")
    private String STEMI_1_4_4_1; // 心肌肌红蛋白检测选项
    public String getSTEMI_1_4_4_1() {  return this.STEMI_1_4_4_1;}
    @JsonProperty("STEMI-1-4-4-1")
    public void setSTEMI_1_4_4_1(final String STEMI_1_4_4_1) { this.STEMI_1_4_4_1=STEMI_1_4_4_1;}
    @Column(name = "STEMI_1_3_3_4")
    @JsonProperty("STEMI-1-3-3-4")
    private String STEMI_1_3_3_4; // 心肌肌红蛋白检测值(ng/mL)
    public String getSTEMI_1_3_3_4() {  return this.STEMI_1_3_3_4;}
    @JsonProperty("STEMI-1-3-3-4")
    public void setSTEMI_1_3_3_4(final String STEMI_1_3_3_4) { this.STEMI_1_3_3_4=STEMI_1_3_3_4;}
    @Column(name = "STEMI_1_4_4_2")
    @JsonProperty("STEMI-1-4-4-2")
    private String STEMI_1_4_4_2; // 心肌肌红蛋白定性检测选择
    public String getSTEMI_1_4_4_2() {  return this.STEMI_1_4_4_2;}
    @JsonProperty("STEMI-1-4-4-2")
    public void setSTEMI_1_4_4_2(final String STEMI_1_4_4_2) { this.STEMI_1_4_4_2=STEMI_1_4_4_2;}
    @Column(name = "STEMI_1_4_5_1")
    @JsonProperty("STEMI-1-4-5-1")
    private String STEMI_1_4_5_1; // B型钠尿肽检测选项
    public String getSTEMI_1_4_5_1() {  return this.STEMI_1_4_5_1;}
    @JsonProperty("STEMI-1-4-5-1")
    public void setSTEMI_1_4_5_1(final String STEMI_1_4_5_1) { this.STEMI_1_4_5_1=STEMI_1_4_5_1;}
    @Column(name = "STEMI_1_3_3_5")
    @JsonProperty("STEMI-1-3-3-5")
    private String STEMI_1_3_3_5; // B型钠尿肽检测值(ng/L)
    public String getSTEMI_1_3_3_5() {  return this.STEMI_1_3_3_5;}
    @JsonProperty("STEMI-1-3-3-5")
    public void setSTEMI_1_3_3_5(final String STEMI_1_3_3_5) { this.STEMI_1_3_3_5=STEMI_1_3_3_5;}
    @Column(name = "STEMI_1_4_5_2")
    @JsonProperty("STEMI-1-4-5-2")
    private String STEMI_1_4_5_2; // B型钠尿肽定性检测选择
    public String getSTEMI_1_4_5_2() {  return this.STEMI_1_4_5_2;}
    @JsonProperty("STEMI-1-4-5-2")
    public void setSTEMI_1_4_5_2(final String STEMI_1_4_5_2) { this.STEMI_1_4_5_2=STEMI_1_4_5_2;}
    @Column(name = "STEMI_1_4_6_1")
    @JsonProperty("STEMI-1-4-6-1")
    private String STEMI_1_4_6_1; // N端B型钠尿肽前体检测选项
    public String getSTEMI_1_4_6_1() {  return this.STEMI_1_4_6_1;}
    @JsonProperty("STEMI-1-4-6-1")
    public void setSTEMI_1_4_6_1(final String STEMI_1_4_6_1) { this.STEMI_1_4_6_1=STEMI_1_4_6_1;}
    @Column(name = "STEMI_1_3_3_6")
    @JsonProperty("STEMI-1-3-3-6")
    private String STEMI_1_3_3_6; // N端B型钠尿肽前体检测值(ng/L)
    public String getSTEMI_1_3_3_6() {  return this.STEMI_1_3_3_6;}
    @JsonProperty("STEMI-1-3-3-6")
    public void setSTEMI_1_3_3_6(final String STEMI_1_3_3_6) { this.STEMI_1_3_3_6=STEMI_1_3_3_6;}
    @Column(name = "STEMI_1_4_6_2")
    @JsonProperty("STEMI-1-4-6-2")
    private String STEMI_1_4_6_2; // N端B型钠尿肽前体定性检测选择
    public String getSTEMI_1_4_6_2() {  return this.STEMI_1_4_6_2;}
    @JsonProperty("STEMI-1-4-6-2")
    public void setSTEMI_1_4_6_2(final String STEMI_1_4_6_2) { this.STEMI_1_4_6_2=STEMI_1_4_6_2;}
    @Column(name = "STEMI_2_1_1")
    @JsonProperty("STEMI-2-1-1")
    private String STEMI_2_1_1; // 是否实施首次X线胸片检查
    public String getSTEMI_2_1_1() {  return this.STEMI_2_1_1;}
    @JsonProperty("STEMI-2-1-1")
    public void setSTEMI_2_1_1(final String STEMI_2_1_1) { this.STEMI_2_1_1=STEMI_2_1_1;}
    @Column(name = "STEMI_2_1_2_1")
    @JsonProperty("STEMI-2-1-2-1")
    private String STEMI_2_1_2_1; // 首次X线胸片检查报告日期时间
    public String getSTEMI_2_1_2_1() {  return this.STEMI_2_1_2_1;}
    @JsonProperty("STEMI-2-1-2-1")
    public void setSTEMI_2_1_2_1(final String STEMI_2_1_2_1) { this.STEMI_2_1_2_1=STEMI_2_1_2_1;}
    @Column(name = "STEMI_2_1_3")
    @JsonProperty("STEMI-2-1-3")
    private String STEMI_2_1_3; // 是否有肺淤血或肺水肿
    public String getSTEMI_2_1_3() {  return this.STEMI_2_1_3;}
    @JsonProperty("STEMI-2-1-3")
    public void setSTEMI_2_1_3(final String STEMI_2_1_3) { this.STEMI_2_1_3=STEMI_2_1_3;}
    @Column(name = "STEMI_2_2_1")
    @JsonProperty("STEMI-2-2-1")
    private String STEMI_2_2_1; // 是否实施首次超声心动图(CDFA)检查
    public String getSTEMI_2_2_1() {  return this.STEMI_2_2_1;}
    @JsonProperty("STEMI-2-2-1")
    public void setSTEMI_2_2_1(final String STEMI_2_2_1) { this.STEMI_2_2_1=STEMI_2_2_1;}
    @Column(name = "STEMI_2_2_2_1")
    @JsonProperty("STEMI-2-2-2-1")
    private String STEMI_2_2_2_1; // 报告日期时间
    public String getSTEMI_2_2_2_1() {  return this.STEMI_2_2_2_1;}
    @JsonProperty("STEMI-2-2-2-1")
    public void setSTEMI_2_2_2_1(final String STEMI_2_2_2_1) { this.STEMI_2_2_2_1=STEMI_2_2_2_1;}
    @Column(name = "STEMI_2_2_3_1")
    @JsonProperty("STEMI-2-2-3-1")
    private String STEMI_2_2_3_1; // 左室射血分（LVEF）测量值(%)
    public String getSTEMI_2_2_3_1() {  return this.STEMI_2_2_3_1;}
    @JsonProperty("STEMI-2-2-3-1")
    public void setSTEMI_2_2_3_1(final String STEMI_2_2_3_1) { this.STEMI_2_2_3_1=STEMI_2_2_3_1;}
    @Column(name = "STEMI_2_2_3_3_1")
    @JsonProperty("STEMI-2-2-3-3-1")
    private String STEMI_2_2_3_3_1; // 左室舒张末径（LVEDd）数值(mm)
    public String getSTEMI_2_2_3_3_1() {  return this.STEMI_2_2_3_3_1;}
    @JsonProperty("STEMI-2-2-3-3-1")
    public void setSTEMI_2_2_3_3_1(final String STEMI_2_2_3_3_1) { this.STEMI_2_2_3_3_1=STEMI_2_2_3_3_1;}
    @Column(name = "STEMI_2_2_3_4")
    @JsonProperty("STEMI-2-2-3-4")
    private String STEMI_2_2_3_4; // 是否有左室室壁瘤
    public String getSTEMI_2_2_3_4() {  return this.STEMI_2_2_3_4;}
    @JsonProperty("STEMI-2-2-3-4")
    public void setSTEMI_2_2_3_4(final String STEMI_2_2_3_4) { this.STEMI_2_2_3_4=STEMI_2_2_3_4;}
    @Column(name = "STEMI_2_2_3_5")
    @JsonProperty("STEMI-2-2-3-5")
    private String STEMI_2_2_3_5; // 是否有左心室内血栓
    public String getSTEMI_2_2_3_5() {  return this.STEMI_2_2_3_5;}
    @JsonProperty("STEMI-2-2-3-5")
    public void setSTEMI_2_2_3_5(final String STEMI_2_2_3_5) { this.STEMI_2_2_3_5=STEMI_2_2_3_5;}
    @Column(name = "STEMI_2_3_1_1")
    @JsonProperty("STEMI-2-3-1-1")
    private String STEMI_2_3_1_1; // 是否实施GRACE危险评分评估
    public String getSTEMI_2_3_1_1() {  return this.STEMI_2_3_1_1;}
    @JsonProperty("STEMI-2-3-1-1")
    public void setSTEMI_2_3_1_1(final String STEMI_2_3_1_1) { this.STEMI_2_3_1_1=STEMI_2_3_1_1;}
    @Column(name = "STEMI_2_3_1_2_1")
    @JsonProperty("STEMI-2-3-1-2-1")
    private String STEMI_2_3_1_2_1; // 评估日期时间
    public String getSTEMI_2_3_1_2_1() {  return this.STEMI_2_3_1_2_1;}
    @JsonProperty("STEMI-2-3-1-2-1")
    public void setSTEMI_2_3_1_2_1(final String STEMI_2_3_1_2_1) { this.STEMI_2_3_1_2_1=STEMI_2_3_1_2_1;}
    @Column(name = "STEMI_2_3_1_3_1")
    @JsonProperty("STEMI-2-3-1-3-1")
    private String STEMI_2_3_1_3_1; // 实施首次GRACE危险评分值
    public String getSTEMI_2_3_1_3_1() {  return this.STEMI_2_3_1_3_1;}
    @JsonProperty("STEMI-2-3-1-3-1")
    public void setSTEMI_2_3_1_3_1(final String STEMI_2_3_1_3_1) { this.STEMI_2_3_1_3_1=STEMI_2_3_1_3_1;}
    @Column(name = "STEMI_2_3_1_4")
    @JsonProperty("STEMI-2-3-1-4")
    private String STEMI_2_3_1_4; // GRACE危险评估分层的选择
    public String getSTEMI_2_3_1_4() {  return this.STEMI_2_3_1_4;}
    @JsonProperty("STEMI-2-3-1-4")
    public void setSTEMI_2_3_1_4(final String STEMI_2_3_1_4) { this.STEMI_2_3_1_4=STEMI_2_3_1_4;}
    @Column(name = "STEMI_2_3_3_1")
    @JsonProperty("STEMI-2-3-3-1")
    private String STEMI_2_3_3_1; // 是否实施CRUSADE出血风险评分
    public String getSTEMI_2_3_3_1() {  return this.STEMI_2_3_3_1;}
    @JsonProperty("STEMI-2-3-3-1")
    public void setSTEMI_2_3_3_1(final String STEMI_2_3_3_1) { this.STEMI_2_3_3_1=STEMI_2_3_3_1;}
    @Column(name = "STEMI_2_3_3_2_1")
    @JsonProperty("STEMI-2-3-3-2-1")
    private String STEMI_2_3_3_2_1; // 评估日期时间
    public String getSTEMI_2_3_3_2_1() {  return this.STEMI_2_3_3_2_1;}
    @JsonProperty("STEMI-2-3-3-2-1")
    public void setSTEMI_2_3_3_2_1(final String STEMI_2_3_3_2_1) { this.STEMI_2_3_3_2_1=STEMI_2_3_3_2_1;}
    @Column(name = "STEMI_2_3_3_3_1")
    @JsonProperty("STEMI-2-3-3-3-1")
    private String STEMI_2_3_3_3_1; // 实施首次CRUSADE出血风险评分值
    public String getSTEMI_2_3_3_3_1() {  return this.STEMI_2_3_3_3_1;}
    @JsonProperty("STEMI-2-3-3-3-1")
    public void setSTEMI_2_3_3_3_1(final String STEMI_2_3_3_3_1) { this.STEMI_2_3_3_3_1=STEMI_2_3_3_3_1;}
    @Column(name = "STEMI_2_3_3_4")
    @JsonProperty("STEMI-2-3-3-4")
    private String STEMI_2_3_3_4; // CRUSADE出血风险评分分层的选择
    public String getSTEMI_2_3_3_4() {  return this.STEMI_2_3_3_4;}
    @JsonProperty("STEMI-2-3-3-4")
    public void setSTEMI_2_3_3_4(final String STEMI_2_3_3_4) { this.STEMI_2_3_3_4=STEMI_2_3_3_4;}
    @Column(name = "STEMI_3_5_1")
    @JsonProperty("STEMI-3-5-1")
    private String STEMI_3_5_1; // 是否实施再灌注治疗
    public String getSTEMI_3_5_1() {  return this.STEMI_3_5_1;}
    @JsonProperty("STEMI-3-5-1")
    public void setSTEMI_3_5_1(final String STEMI_3_5_1) { this.STEMI_3_5_1=STEMI_3_5_1;}
    @Column(name = "STEMI_3_0_1_dump")
    @JsonProperty("STEMI-3-0-1-dump")
    private String STEMI_3_0_1_dump; // 发病时间评估结论
    public String getSTEMI_3_0_1_dump() {  return this.STEMI_3_0_1_dump;}
    @JsonProperty("STEMI-3-0-1-dump")
    public void setSTEMI_3_0_1_dump(final String STEMI_3_0_1_dump) { this.STEMI_3_0_1_dump=STEMI_3_0_1_dump;}
    @Column(name = "STEMI_3_0_1")
    @JsonProperty("STEMI-3-0-1")
    private String STEMI_3_0_1; // 发病时间评估结论
    public String getSTEMI_3_0_1() {  return this.STEMI_3_0_1;}
    @JsonProperty("STEMI-3-0-1")
    public void setSTEMI_3_0_1(final String STEMI_3_0_1) { this.STEMI_3_0_1=STEMI_3_0_1;}
    @Column(name = "STEMI_3_0_2")
    @JsonProperty("STEMI-3-0-2")
    private String STEMI_3_0_2; // 实施再灌注治疗的模式
    public String getSTEMI_3_0_2() {  return this.STEMI_3_0_2;}
    @JsonProperty("STEMI-3-0-2")
    public void setSTEMI_3_0_2(final String STEMI_3_0_2) { this.STEMI_3_0_2=STEMI_3_0_2;}
    @Column(name = "STEMI_3_1_1")
    @JsonProperty("STEMI-3-1-1")
    private String STEMI_3_1_1; // STEMI溶栓适应证
    public String getSTEMI_3_1_1() {  return this.STEMI_3_1_1;}
    @JsonProperty("STEMI-3-1-1")
    public void setSTEMI_3_1_1(final String STEMI_3_1_1) { this.STEMI_3_1_1=STEMI_3_1_1;}
    @Column(name = "STEMI_3_1_2_1")
    @JsonProperty("STEMI-3-1-2-1")
    private String STEMI_3_1_2_1; // 是否有溶栓治疗禁忌症
    public String getSTEMI_3_1_2_1() {  return this.STEMI_3_1_2_1;}
    @JsonProperty("STEMI-3-1-2-1")
    public void setSTEMI_3_1_2_1(final String STEMI_3_1_2_1) { this.STEMI_3_1_2_1=STEMI_3_1_2_1;}
    @Column(name = "STEMI_3_1_2_2")
    @JsonProperty("STEMI-3-1-2-2")
    private String STEMI_3_1_2_2; // 绝对禁忌证选择
    public String getSTEMI_3_1_2_2() {  return this.STEMI_3_1_2_2;}
    @JsonProperty("STEMI-3-1-2-2")
    public void setSTEMI_3_1_2_2(final String STEMI_3_1_2_2) { this.STEMI_3_1_2_2=STEMI_3_1_2_2;}
    @Column(name = "STEMI_3_1_2_3")
    @JsonProperty("STEMI-3-1-2-3")
    private String STEMI_3_1_2_3; // 相对禁忌证选择
    public String getSTEMI_3_1_2_3() {  return this.STEMI_3_1_2_3;}
    @JsonProperty("STEMI-3-1-2-3")
    public void setSTEMI_3_1_2_3(final String STEMI_3_1_2_3) { this.STEMI_3_1_2_3=STEMI_3_1_2_3;}
    @Column(name = "STEMI_3_1_3")
    @JsonProperty("STEMI-3-1-3")
    private String STEMI_3_1_3; // 是否实施溶栓治疗
    public String getSTEMI_3_1_3() {  return this.STEMI_3_1_3;}
    @JsonProperty("STEMI-3-1-3")
    public void setSTEMI_3_1_3(final String STEMI_3_1_3) { this.STEMI_3_1_3=STEMI_3_1_3;}
    @Column(name = "STEMI_3_1_4")
    @JsonProperty("STEMI-3-1-4")
    private String STEMI_3_1_4; // 溶栓药物选择
    public String getSTEMI_3_1_4() {  return this.STEMI_3_1_4;}
    @JsonProperty("STEMI-3-1-4")
    public void setSTEMI_3_1_4(final String STEMI_3_1_4) { this.STEMI_3_1_4=STEMI_3_1_4;}
    @Column(name = "STEMI_3_1_4_1")
    @JsonProperty("STEMI-3-1-4-1")
    private String STEMI_3_1_4_1; // 其他溶栓药物
    public String getSTEMI_3_1_4_1() {  return this.STEMI_3_1_4_1;}
    @JsonProperty("STEMI-3-1-4-1")
    public void setSTEMI_3_1_4_1(final String STEMI_3_1_4_1) { this.STEMI_3_1_4_1=STEMI_3_1_4_1;}
    @Column(name = "STEMI_3_1_5_1")
    @JsonProperty("STEMI-3-1-5-1")
    private String STEMI_3_1_5_1; // 输注开始日期时间
    public String getSTEMI_3_1_5_1() {  return this.STEMI_3_1_5_1;}
    @JsonProperty("STEMI-3-1-5-1")
    public void setSTEMI_3_1_5_1(final String STEMI_3_1_5_1) { this.STEMI_3_1_5_1=STEMI_3_1_5_1;}
    @Column(name = "STEMI_3_1_6_1")
    @JsonProperty("STEMI-3-1-6-1")
    private String STEMI_3_1_6_1; // 输注完成日期时间
    public String getSTEMI_3_1_6_1() {  return this.STEMI_3_1_6_1;}
    @JsonProperty("STEMI-3-1-6-1")
    public void setSTEMI_3_1_6_1(final String STEMI_3_1_6_1) { this.STEMI_3_1_6_1=STEMI_3_1_6_1;}
    @Column(name = "STEMI_3_1_7_1")
    @JsonProperty("STEMI-3-1-7-1")
    private String STEMI_3_1_7_1; // 到达医院STEMI确诊报告日期与时间至溶栓时间（D2N）
    public String getSTEMI_3_1_7_1() {  return this.STEMI_3_1_7_1;}
    @JsonProperty("STEMI-3-1-7-1")
    public void setSTEMI_3_1_7_1(final String STEMI_3_1_7_1) { this.STEMI_3_1_7_1=STEMI_3_1_7_1;}
    @Column(name = "STEMI_3_1_8")
    @JsonProperty("STEMI-3-1-8")
    private String STEMI_3_1_8; // 临床评估溶栓成功(60~90 min)
    public String getSTEMI_3_1_8() {  return this.STEMI_3_1_8;}
    @JsonProperty("STEMI-3-1-8")
    public void setSTEMI_3_1_8(final String STEMI_3_1_8) { this.STEMI_3_1_8=STEMI_3_1_8;}
    @Column(name = "STEMI_3_1_9")
    @JsonProperty("STEMI-3-1-9")
    private String STEMI_3_1_9; // 溶栓治疗并发症的选择
    public String getSTEMI_3_1_9() {  return this.STEMI_3_1_9;}
    @JsonProperty("STEMI-3-1-9")
    public void setSTEMI_3_1_9(final String STEMI_3_1_9) { this.STEMI_3_1_9=STEMI_3_1_9;}
    @Column(name = "STEMI_3_1_10")
    @JsonProperty("STEMI-3-1-10")
    private String STEMI_3_1_10; // 溶栓治疗延迟原因
    public String getSTEMI_3_1_10() {  return this.STEMI_3_1_10;}
    @JsonProperty("STEMI-3-1-10")
    public void setSTEMI_3_1_10(final String STEMI_3_1_10) { this.STEMI_3_1_10=STEMI_3_1_10;}
    @Column(name = "STEMI_3_2_1")
    @JsonProperty("STEMI-3-2-1")
    private String STEMI_3_2_1; // 是否实施PCI治疗
    public String getSTEMI_3_2_1() {  return this.STEMI_3_2_1;}
    @JsonProperty("STEMI-3-2-1")
    public void setSTEMI_3_2_1(final String STEMI_3_2_1) { this.STEMI_3_2_1=STEMI_3_2_1;}
    @Column(name = "STEMI_3_2_2_1_3")
    @JsonProperty("STEMI-3-2-2-1-3")
    private String STEMI_3_2_2_1_3; // PCI适应证
    public String getSTEMI_3_2_2_1_3() {  return this.STEMI_3_2_2_1_3;}
    @JsonProperty("STEMI-3-2-2-1-3")
    public void setSTEMI_3_2_2_1_3(final String STEMI_3_2_2_1_3) { this.STEMI_3_2_2_1_3=STEMI_3_2_2_1_3;}
    @Column(name = "STEMI_3_2_2_1_1")
    @JsonProperty("STEMI-3-2-2-1-1")
    private String STEMI_3_2_2_1_1; // 直接PCI适应证
    public String getSTEMI_3_2_2_1_1() {  return this.STEMI_3_2_2_1_1;}
    @JsonProperty("STEMI-3-2-2-1-1")
    public void setSTEMI_3_2_2_1_1(final String STEMI_3_2_2_1_1) { this.STEMI_3_2_2_1_1=STEMI_3_2_2_1_1;}
    @Column(name = "STEMI_3_2_2_1_2")
    @JsonProperty("STEMI-3-2-2-1-2")
    private String STEMI_3_2_2_1_2; // 溶栓后PCI适应证
    public String getSTEMI_3_2_2_1_2() {  return this.STEMI_3_2_2_1_2;}
    @JsonProperty("STEMI-3-2-2-1-2")
    public void setSTEMI_3_2_2_1_2(final String STEMI_3_2_2_1_2) { this.STEMI_3_2_2_1_2=STEMI_3_2_2_1_2;}
    @Column(name = "STEMI_3_2_2")
    @JsonProperty("STEMI-3-2-2")
    private String STEMI_3_2_2; // 是否有PCI禁忌证
    public String getSTEMI_3_2_2() {  return this.STEMI_3_2_2;}
    @JsonProperty("STEMI-3-2-2")
    public void setSTEMI_3_2_2(final String STEMI_3_2_2) { this.STEMI_3_2_2=STEMI_3_2_2;}
    @Column(name = "STEMI_3_2_2_1")
    @JsonProperty("STEMI-3-2-2-1")
    private String STEMI_3_2_2_1; // PCI禁忌证选择
    public String getSTEMI_3_2_2_1() {  return this.STEMI_3_2_2_1;}
    @JsonProperty("STEMI-3-2-2-1")
    public void setSTEMI_3_2_2_1(final String STEMI_3_2_2_1) { this.STEMI_3_2_2_1=STEMI_3_2_2_1;}
    @Column(name = "STEMI_3_2_2_2_1")
    @JsonProperty("STEMI-3-2-2-2-1")
    private String STEMI_3_2_2_2_1; // PCI导丝通过靶病变日期时间
    public String getSTEMI_3_2_2_2_1() {  return this.STEMI_3_2_2_2_1;}
    @JsonProperty("STEMI-3-2-2-2-1")
    public void setSTEMI_3_2_2_2_1(final String STEMI_3_2_2_2_1) { this.STEMI_3_2_2_2_1=STEMI_3_2_2_2_1;}
    @Column(name = "STEMI_3_2_2_3_1")
    @JsonProperty("STEMI-3-2-2-3-1")
    private String STEMI_3_2_2_3_1; // PCI完成时间
    public String getSTEMI_3_2_2_3_1() {  return this.STEMI_3_2_2_3_1;}
    @JsonProperty("STEMI-3-2-2-3-1")
    public void setSTEMI_3_2_2_3_1(final String STEMI_3_2_2_3_1) { this.STEMI_3_2_2_3_1=STEMI_3_2_2_3_1;}
    @Column(name = "STEMI_3_2_2_4_1")
    @JsonProperty("STEMI-3-2-2-4-1")
    private String STEMI_3_2_2_4_1; // 确诊STEMI至PCI导丝通过靶病变（D2B）时间（分钟）
    public String getSTEMI_3_2_2_4_1() {  return this.STEMI_3_2_2_4_1;}
    @JsonProperty("STEMI-3-2-2-4-1")
    public void setSTEMI_3_2_2_4_1(final String STEMI_3_2_2_4_1) { this.STEMI_3_2_2_4_1=STEMI_3_2_2_4_1;}
    @Column(name = "STEMI_3_2_2_5")
    @JsonProperty("STEMI-3-2-2-5")
    private String STEMI_3_2_2_5; // 治疗延迟原因选择
    public String getSTEMI_3_2_2_5() {  return this.STEMI_3_2_2_5;}
    @JsonProperty("STEMI-3-2-2-5")
    public void setSTEMI_3_2_2_5(final String STEMI_3_2_2_5) { this.STEMI_3_2_2_5=STEMI_3_2_2_5;}
    @Column(name = "STEMI_3_2_3_1")
    @JsonProperty("STEMI-3-2-3-1")
    private String STEMI_3_2_3_1; // 主要病变血管
    public String getSTEMI_3_2_3_1() {  return this.STEMI_3_2_3_1;}
    @JsonProperty("STEMI-3-2-3-1")
    public void setSTEMI_3_2_3_1(final String STEMI_3_2_3_1) { this.STEMI_3_2_3_1=STEMI_3_2_3_1;}
    @Column(name = "STEMI_3_2_3_2_1")
    @JsonProperty("STEMI-3-2-3-2-1")
    private String STEMI_3_2_3_2_1; // LAD-冠状动脉狭窄程度分级
    public String getSTEMI_3_2_3_2_1() {  return this.STEMI_3_2_3_2_1;}
    @JsonProperty("STEMI-3-2-3-2-1")
    public void setSTEMI_3_2_3_2_1(final String STEMI_3_2_3_2_1) { this.STEMI_3_2_3_2_1=STEMI_3_2_3_2_1;}
    @Column(name = "STEMI_3_2_3_2_5")
    @JsonProperty("STEMI-3-2-3-2-5")
    private String STEMI_3_2_3_2_5; // LAD-术前主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_2_5() {  return this.STEMI_3_2_3_2_5;}
    @JsonProperty("STEMI-3-2-3-2-5")
    public void setSTEMI_3_2_3_2_5(final String STEMI_3_2_3_2_5) { this.STEMI_3_2_3_2_5=STEMI_3_2_3_2_5;}
    @Column(name = "STEMI_3_2_3_2_2")
    @JsonProperty("STEMI-3-2-3-2-2")
    private String STEMI_3_2_3_2_2; // LCX-冠状动脉狭窄程度分级
    public String getSTEMI_3_2_3_2_2() {  return this.STEMI_3_2_3_2_2;}
    @JsonProperty("STEMI-3-2-3-2-2")
    public void setSTEMI_3_2_3_2_2(final String STEMI_3_2_3_2_2) { this.STEMI_3_2_3_2_2=STEMI_3_2_3_2_2;}
    @Column(name = "STEMI_3_2_3_2_6")
    @JsonProperty("STEMI-3-2-3-2-6")
    private String STEMI_3_2_3_2_6; // LCX-术前主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_2_6() {  return this.STEMI_3_2_3_2_6;}
    @JsonProperty("STEMI-3-2-3-2-6")
    public void setSTEMI_3_2_3_2_6(final String STEMI_3_2_3_2_6) { this.STEMI_3_2_3_2_6=STEMI_3_2_3_2_6;}
    @Column(name = "STEMI_3_2_3_2_3")
    @JsonProperty("STEMI-3-2-3-2-3")
    private String STEMI_3_2_3_2_3; // RCA-冠状动脉狭窄程度分级
    public String getSTEMI_3_2_3_2_3() {  return this.STEMI_3_2_3_2_3;}
    @JsonProperty("STEMI-3-2-3-2-3")
    public void setSTEMI_3_2_3_2_3(final String STEMI_3_2_3_2_3) { this.STEMI_3_2_3_2_3=STEMI_3_2_3_2_3;}
    @Column(name = "STEMI_3_2_3_2_7")
    @JsonProperty("STEMI-3-2-3-2-7")
    private String STEMI_3_2_3_2_7; // RCA-术前主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_2_7() {  return this.STEMI_3_2_3_2_7;}
    @JsonProperty("STEMI-3-2-3-2-7")
    public void setSTEMI_3_2_3_2_7(final String STEMI_3_2_3_2_7) { this.STEMI_3_2_3_2_7=STEMI_3_2_3_2_7;}
    @Column(name = "STEMI_3_2_3_2_4")
    @JsonProperty("STEMI-3-2-3-2-4")
    private String STEMI_3_2_3_2_4; // LM-冠状动脉狭窄程度分级
    public String getSTEMI_3_2_3_2_4() {  return this.STEMI_3_2_3_2_4;}
    @JsonProperty("STEMI-3-2-3-2-4")
    public void setSTEMI_3_2_3_2_4(final String STEMI_3_2_3_2_4) { this.STEMI_3_2_3_2_4=STEMI_3_2_3_2_4;}
    @Column(name = "STEMI_3_2_3_2_8")
    @JsonProperty("STEMI-3-2-3-2-8")
    private String STEMI_3_2_3_2_8; // LM-术前主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_2_8() {  return this.STEMI_3_2_3_2_8;}
    @JsonProperty("STEMI-3-2-3-2-8")
    public void setSTEMI_3_2_3_2_8(final String STEMI_3_2_3_2_8) { this.STEMI_3_2_3_2_8=STEMI_3_2_3_2_8;}
    @Column(name = "STEMI_3_2_3_3")
    @JsonProperty("STEMI-3-2-3-3")
    private String STEMI_3_2_3_3; // PCI治疗主要靶血管
    public String getSTEMI_3_2_3_3() {  return this.STEMI_3_2_3_3;}
    @JsonProperty("STEMI-3-2-3-3")
    public void setSTEMI_3_2_3_3(final String STEMI_3_2_3_3) { this.STEMI_3_2_3_3=STEMI_3_2_3_3;}
    @Column(name = "STEMI_3_2_3_3_1")
    @JsonProperty("STEMI-3-2-3-3-1")
    private String STEMI_3_2_3_3_1; // LM-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_3_1() {  return this.STEMI_3_2_3_3_1;}
    @JsonProperty("STEMI-3-2-3-3-1")
    public void setSTEMI_3_2_3_3_1(final String STEMI_3_2_3_3_1) { this.STEMI_3_2_3_3_1=STEMI_3_2_3_3_1;}
    @Column(name = "STEMI_3_2_3_3_2")
    @JsonProperty("STEMI-3-2-3-3-2")
    private String STEMI_3_2_3_3_2; // LM-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_2() {  return this.STEMI_3_2_3_3_2;}
    @JsonProperty("STEMI-3-2-3-3-2")
    public void setSTEMI_3_2_3_3_2(final String STEMI_3_2_3_3_2) { this.STEMI_3_2_3_3_2=STEMI_3_2_3_3_2;}
    @Column(name = "STEMI_3_2_3_3_2_1")
    @JsonProperty("STEMI-3-2-3-3-2-1")
    private String STEMI_3_2_3_3_2_1; // LM-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_2_1() {  return this.STEMI_3_2_3_3_2_1;}
    @JsonProperty("STEMI-3-2-3-3-2-1")
    public void setSTEMI_3_2_3_3_2_1(final String STEMI_3_2_3_3_2_1) { this.STEMI_3_2_3_3_2_1=STEMI_3_2_3_3_2_1;}
    @Column(name = "STEMI_3_2_3_3_3")
    @JsonProperty("STEMI-3-2-3-3-3")
    private String STEMI_3_2_3_3_3; // LAD-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_3_3() {  return this.STEMI_3_2_3_3_3;}
    @JsonProperty("STEMI-3-2-3-3-3")
    public void setSTEMI_3_2_3_3_3(final String STEMI_3_2_3_3_3) { this.STEMI_3_2_3_3_3=STEMI_3_2_3_3_3;}
    @Column(name = "STEMI_3_2_3_3_4")
    @JsonProperty("STEMI-3-2-3-3-4")
    private String STEMI_3_2_3_3_4; // LAD-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_4() {  return this.STEMI_3_2_3_3_4;}
    @JsonProperty("STEMI-3-2-3-3-4")
    public void setSTEMI_3_2_3_3_4(final String STEMI_3_2_3_3_4) { this.STEMI_3_2_3_3_4=STEMI_3_2_3_3_4;}
    @Column(name = "STEMI_3_2_3_3_4_1")
    @JsonProperty("STEMI-3-2-3-3-4-1")
    private String STEMI_3_2_3_3_4_1; // LAD-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_4_1() {  return this.STEMI_3_2_3_3_4_1;}
    @JsonProperty("STEMI-3-2-3-3-4-1")
    public void setSTEMI_3_2_3_3_4_1(final String STEMI_3_2_3_3_4_1) { this.STEMI_3_2_3_3_4_1=STEMI_3_2_3_3_4_1;}
    @Column(name = "STEMI_3_2_3_3_5")
    @JsonProperty("STEMI-3-2-3-3-5")
    private String STEMI_3_2_3_3_5; // LCX-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_3_5() {  return this.STEMI_3_2_3_3_5;}
    @JsonProperty("STEMI-3-2-3-3-5")
    public void setSTEMI_3_2_3_3_5(final String STEMI_3_2_3_3_5) { this.STEMI_3_2_3_3_5=STEMI_3_2_3_3_5;}
    @Column(name = "STEMI_3_2_3_3_6")
    @JsonProperty("STEMI-3-2-3-3-6")
    private String STEMI_3_2_3_3_6; // LCX-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_6() {  return this.STEMI_3_2_3_3_6;}
    @JsonProperty("STEMI-3-2-3-3-6")
    public void setSTEMI_3_2_3_3_6(final String STEMI_3_2_3_3_6) { this.STEMI_3_2_3_3_6=STEMI_3_2_3_3_6;}
    @Column(name = "STEMI_3_2_3_3_6_1")
    @JsonProperty("STEMI-3-2-3-3-6-1")
    private String STEMI_3_2_3_3_6_1; // LCX-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_6_1() {  return this.STEMI_3_2_3_3_6_1;}
    @JsonProperty("STEMI-3-2-3-3-6-1")
    public void setSTEMI_3_2_3_3_6_1(final String STEMI_3_2_3_3_6_1) { this.STEMI_3_2_3_3_6_1=STEMI_3_2_3_3_6_1;}
    @Column(name = "STEMI_3_2_3_3_7")
    @JsonProperty("STEMI-3-2-3-3-7")
    private String STEMI_3_2_3_3_7; // LM-LAD-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_3_7() {  return this.STEMI_3_2_3_3_7;}
    @JsonProperty("STEMI-3-2-3-3-7")
    public void setSTEMI_3_2_3_3_7(final String STEMI_3_2_3_3_7) { this.STEMI_3_2_3_3_7=STEMI_3_2_3_3_7;}
    @Column(name = "STEMI_3_2_3_3_8")
    @JsonProperty("STEMI-3-2-3-3-8")
    private String STEMI_3_2_3_3_8; // LM-LAD-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_8() {  return this.STEMI_3_2_3_3_8;}
    @JsonProperty("STEMI-3-2-3-3-8")
    public void setSTEMI_3_2_3_3_8(final String STEMI_3_2_3_3_8) { this.STEMI_3_2_3_3_8=STEMI_3_2_3_3_8;}
    @Column(name = "STEMI_3_2_3_3_8_1")
    @JsonProperty("STEMI-3-2-3-3-8-1")
    private String STEMI_3_2_3_3_8_1; // LM-LAD-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_8_1() {  return this.STEMI_3_2_3_3_8_1;}
    @JsonProperty("STEMI-3-2-3-3-8-1")
    public void setSTEMI_3_2_3_3_8_1(final String STEMI_3_2_3_3_8_1) { this.STEMI_3_2_3_3_8_1=STEMI_3_2_3_3_8_1;}
    @Column(name = "STEMI_3_2_3_9_1")
    @JsonProperty("STEMI-3-2-3-9-1")
    private String STEMI_3_2_3_9_1; // LM-LCX-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_9_1() {  return this.STEMI_3_2_3_9_1;}
    @JsonProperty("STEMI-3-2-3-9-1")
    public void setSTEMI_3_2_3_9_1(final String STEMI_3_2_3_9_1) { this.STEMI_3_2_3_9_1=STEMI_3_2_3_9_1;}
    @Column(name = "STEMI_3_2_3_3_10")
    @JsonProperty("STEMI-3-2-3-3-10")
    private String STEMI_3_2_3_3_10; // LM-LCX-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_10() {  return this.STEMI_3_2_3_3_10;}
    @JsonProperty("STEMI-3-2-3-3-10")
    public void setSTEMI_3_2_3_3_10(final String STEMI_3_2_3_3_10) { this.STEMI_3_2_3_3_10=STEMI_3_2_3_3_10;}
    @Column(name = "STEMI_3_2_3_3_10_1")
    @JsonProperty("STEMI-3-2-3-3-10-1")
    private String STEMI_3_2_3_3_10_1; // LM-LCX-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_10_1() {  return this.STEMI_3_2_3_3_10_1;}
    @JsonProperty("STEMI-3-2-3-3-10-1")
    public void setSTEMI_3_2_3_3_10_1(final String STEMI_3_2_3_3_10_1) { this.STEMI_3_2_3_3_10_1=STEMI_3_2_3_3_10_1;}
    @Column(name = "STEMI_3_2_3_3_11")
    @JsonProperty("STEMI-3-2-3-3-11")
    private String STEMI_3_2_3_3_11; // RCA-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_3_11() {  return this.STEMI_3_2_3_3_11;}
    @JsonProperty("STEMI-3-2-3-3-11")
    public void setSTEMI_3_2_3_3_11(final String STEMI_3_2_3_3_11) { this.STEMI_3_2_3_3_11=STEMI_3_2_3_3_11;}
    @Column(name = "STEMI_3_2_3_3_12")
    @JsonProperty("STEMI-3-2-3-3-12")
    private String STEMI_3_2_3_3_12; // RCA-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_12() {  return this.STEMI_3_2_3_3_12;}
    @JsonProperty("STEMI-3-2-3-3-12")
    public void setSTEMI_3_2_3_3_12(final String STEMI_3_2_3_3_12) { this.STEMI_3_2_3_3_12=STEMI_3_2_3_3_12;}
    @Column(name = "STEMI_3_2_3_3_12_1")
    @JsonProperty("STEMI-3-2-3-3-12-1")
    private String STEMI_3_2_3_3_12_1; // RCA-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_12_1() {  return this.STEMI_3_2_3_3_12_1;}
    @JsonProperty("STEMI-3-2-3-3-12-1")
    public void setSTEMI_3_2_3_3_12_1(final String STEMI_3_2_3_3_12_1) { this.STEMI_3_2_3_3_12_1=STEMI_3_2_3_3_12_1;}
    @Column(name = "STEMI_3_2_3_3_13")
    @JsonProperty("STEMI-3-2-3-3-13")
    private String STEMI_3_2_3_3_13; // LM-中间支-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_3_13() {  return this.STEMI_3_2_3_3_13;}
    @JsonProperty("STEMI-3-2-3-3-13")
    public void setSTEMI_3_2_3_3_13(final String STEMI_3_2_3_3_13) { this.STEMI_3_2_3_3_13=STEMI_3_2_3_3_13;}
    @Column(name = "STEMI_3_2_3_3_14")
    @JsonProperty("STEMI-3-2-3-3-14")
    private String STEMI_3_2_3_3_14; // LM-中间支-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_14() {  return this.STEMI_3_2_3_3_14;}
    @JsonProperty("STEMI-3-2-3-3-14")
    public void setSTEMI_3_2_3_3_14(final String STEMI_3_2_3_3_14) { this.STEMI_3_2_3_3_14=STEMI_3_2_3_3_14;}
    @Column(name = "STEMI_3_2_3_3_14_1")
    @JsonProperty("STEMI-3-2-3-3-14-1")
    private String STEMI_3_2_3_3_14_1; // LM-中间支-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_14_1() {  return this.STEMI_3_2_3_3_14_1;}
    @JsonProperty("STEMI-3-2-3-3-14-1")
    public void setSTEMI_3_2_3_3_14_1(final String STEMI_3_2_3_3_14_1) { this.STEMI_3_2_3_3_14_1=STEMI_3_2_3_3_14_1;}
    @Column(name = "STEMI_3_2_3_15_1")
    @JsonProperty("STEMI-3-2-3-15-1")
    private String STEMI_3_2_3_15_1; // 中间支-PCI术后即刻主要靶血管TIMI血流分级的选择
    public String getSTEMI_3_2_3_15_1() {  return this.STEMI_3_2_3_15_1;}
    @JsonProperty("STEMI-3-2-3-15-1")
    public void setSTEMI_3_2_3_15_1(final String STEMI_3_2_3_15_1) { this.STEMI_3_2_3_15_1=STEMI_3_2_3_15_1;}
    @Column(name = "STEMI_3_2_3_3_16")
    @JsonProperty("STEMI-3-2-3-3-16")
    private String STEMI_3_2_3_3_16; // 中间支-置入冠状动脉支架选择
    public String getSTEMI_3_2_3_3_16() {  return this.STEMI_3_2_3_3_16;}
    @JsonProperty("STEMI-3-2-3-3-16")
    public void setSTEMI_3_2_3_3_16(final String STEMI_3_2_3_3_16) { this.STEMI_3_2_3_3_16=STEMI_3_2_3_3_16;}
    @Column(name = "STEMI_3_2_3_3_16_1")
    @JsonProperty("STEMI-3-2-3-3-16-1")
    private String STEMI_3_2_3_3_16_1; // 中间支-置入冠状动脉支架填写
    public String getSTEMI_3_2_3_3_16_1() {  return this.STEMI_3_2_3_3_16_1;}
    @JsonProperty("STEMI-3-2-3-3-16-1")
    public void setSTEMI_3_2_3_3_16_1(final String STEMI_3_2_3_3_16_1) { this.STEMI_3_2_3_3_16_1=STEMI_3_2_3_3_16_1;}
    @Column(name = "STEMI_3_2_4_1")
    @JsonProperty("STEMI-3-2-4-1")
    private String STEMI_3_2_4_1; // ICD-9-CM-3编码与名称
    public String getSTEMI_3_2_4_1() {  return this.STEMI_3_2_4_1;}
    @JsonProperty("STEMI-3-2-4-1")
    public void setSTEMI_3_2_4_1(final String STEMI_3_2_4_1) { this.STEMI_3_2_4_1=STEMI_3_2_4_1;}
    @Column(name = "STEMI_3_2_4_2")
    @JsonProperty("STEMI-3-2-4-2")
    private String STEMI_3_2_4_2; // 治疗血管的数量的选择
    public String getSTEMI_3_2_4_2() {  return this.STEMI_3_2_4_2;}
    @JsonProperty("STEMI-3-2-4-2")
    public void setSTEMI_3_2_4_2(final String STEMI_3_2_4_2) { this.STEMI_3_2_4_2=STEMI_3_2_4_2;}
    @Column(name = "STEMI_3_2_4_3")
    @JsonProperty("STEMI-3-2-4-3")
    private String STEMI_3_2_4_3; // 置入血管支架的数量
    public String getSTEMI_3_2_4_3() {  return this.STEMI_3_2_4_3;}
    @JsonProperty("STEMI-3-2-4-3")
    public void setSTEMI_3_2_4_3(final String STEMI_3_2_4_3) { this.STEMI_3_2_4_3=STEMI_3_2_4_3;}
    @Column(name = "STEMI_111")
    @JsonProperty("STEMI-111")
    private String STEMI_111; // 两下拉联动
    public String getSTEMI_111() {  return this.STEMI_111;}
    @JsonProperty("STEMI-111")
    public void setSTEMI_111(final String STEMI_111) { this.STEMI_111=STEMI_111;}
    @Column(name = "STEMI_3_2_4_4")
    @JsonProperty("STEMI-3-2-4-4")
    private String STEMI_3_2_4_4; // 心脏团队讨论决策模式的选择
    public String getSTEMI_3_2_4_4() {  return this.STEMI_3_2_4_4;}
    @JsonProperty("STEMI-3-2-4-4")
    public void setSTEMI_3_2_4_4(final String STEMI_3_2_4_4) { this.STEMI_3_2_4_4=STEMI_3_2_4_4;}
    @Column(name = "STEMI_3_2_5_1")
    @JsonProperty("STEMI-3-2-5-1")
    private String STEMI_3_2_5_1; // 近期主要并发症的选择
    public String getSTEMI_3_2_5_1() {  return this.STEMI_3_2_5_1;}
    @JsonProperty("STEMI-3-2-5-1")
    public void setSTEMI_3_2_5_1(final String STEMI_3_2_5_1) { this.STEMI_3_2_5_1=STEMI_3_2_5_1;}
    @Column(name = "STEMI_3_2_5_1_1")
    @JsonProperty("STEMI-3-2-5-1-1")
    private String STEMI_3_2_5_1_1; // 其他近期主要并发症
    public String getSTEMI_3_2_5_1_1() {  return this.STEMI_3_2_5_1_1;}
    @JsonProperty("STEMI-3-2-5-1-1")
    public void setSTEMI_3_2_5_1_1(final String STEMI_3_2_5_1_1) { this.STEMI_3_2_5_1_1=STEMI_3_2_5_1_1;}
    @Column(name = "STEMI_3_2_5_2")
    @JsonProperty("STEMI-3-2-5-2")
    private String STEMI_3_2_5_2; // 近期并发症治疗主要措施的选择
    public String getSTEMI_3_2_5_2() {  return this.STEMI_3_2_5_2;}
    @JsonProperty("STEMI-3-2-5-2")
    public void setSTEMI_3_2_5_2(final String STEMI_3_2_5_2) { this.STEMI_3_2_5_2=STEMI_3_2_5_2;}
    @Column(name = "STEMI_3_2_5_2_1")
    @JsonProperty("STEMI-3-2-5-2-1")
    private String STEMI_3_2_5_2_1; // 其他近期并发症治疗主要措施
    public String getSTEMI_3_2_5_2_1() {  return this.STEMI_3_2_5_2_1;}
    @JsonProperty("STEMI-3-2-5-2-1")
    public void setSTEMI_3_2_5_2_1(final String STEMI_3_2_5_2_1) { this.STEMI_3_2_5_2_1=STEMI_3_2_5_2_1;}
    @Column(name = "STEMI_3_2_6_1")
    @JsonProperty("STEMI-3-2-6-1")
    private String STEMI_3_2_6_1; // 是否实施CathPCI风险评估
    public String getSTEMI_3_2_6_1() {  return this.STEMI_3_2_6_1;}
    @JsonProperty("STEMI-3-2-6-1")
    public void setSTEMI_3_2_6_1(final String STEMI_3_2_6_1) { this.STEMI_3_2_6_1=STEMI_3_2_6_1;}
    @Column(name = "STEMI_3_2_6_2_1_1")
    @JsonProperty("STEMI-3-2-6-2-1-1")
    private String STEMI_3_2_6_2_1_1; // 总分值
    public String getSTEMI_3_2_6_2_1_1() {  return this.STEMI_3_2_6_2_1_1;}
    @JsonProperty("STEMI-3-2-6-2-1-1")
    public void setSTEMI_3_2_6_2_1_1(final String STEMI_3_2_6_2_1_1) { this.STEMI_3_2_6_2_1_1=STEMI_3_2_6_2_1_1;}
    @Column(name = "STEMI_3_2_6_2_2")
    @JsonProperty("STEMI-3-2-6-2-2")
    private String STEMI_3_2_6_2_2; // 院内患者死亡风险(%)
    public String getSTEMI_3_2_6_2_2() {  return this.STEMI_3_2_6_2_2;}
    @JsonProperty("STEMI-3-2-6-2-2")
    public void setSTEMI_3_2_6_2_2(final String STEMI_3_2_6_2_2) { this.STEMI_3_2_6_2_2=STEMI_3_2_6_2_2;}
    @Column(name = "STEMI_3_2_7_1")
    @JsonProperty("STEMI-3-2-7-1")
    private String STEMI_3_2_7_1; // 是否实施围术期抗凝治疗
    public String getSTEMI_3_2_7_1() {  return this.STEMI_3_2_7_1;}
    @JsonProperty("STEMI-3-2-7-1")
    public void setSTEMI_3_2_7_1(final String STEMI_3_2_7_1) { this.STEMI_3_2_7_1=STEMI_3_2_7_1;}
    @Column(name = "STEMI_3_2_7_2")
    @JsonProperty("STEMI-3-2-7-2")
    private String STEMI_3_2_7_2; // 肠外抗凝药物选择
    public String getSTEMI_3_2_7_2() {  return this.STEMI_3_2_7_2;}
    @JsonProperty("STEMI-3-2-7-2")
    public void setSTEMI_3_2_7_2(final String STEMI_3_2_7_2) { this.STEMI_3_2_7_2=STEMI_3_2_7_2;}
    @Column(name = "STEMI_3_2_7_3")
    @JsonProperty("STEMI-3-2-7-3")
    private String STEMI_3_2_7_3; // 其他肠外抗凝药物
    public String getSTEMI_3_2_7_3() {  return this.STEMI_3_2_7_3;}
    @JsonProperty("STEMI-3-2-7-3")
    public void setSTEMI_3_2_7_3(final String STEMI_3_2_7_3) { this.STEMI_3_2_7_3=STEMI_3_2_7_3;}
    @Column(name = "STEMI_3_3_0")
    @JsonProperty("STEMI-3-3-0")
    private String STEMI_3_3_0; // （本院）无条件实施时，是否将患者转往有条件行PCI的医院
    public String getSTEMI_3_3_0() {  return this.STEMI_3_3_0;}
    @JsonProperty("STEMI-3-3-0")
    public void setSTEMI_3_3_0(final String STEMI_3_3_0) { this.STEMI_3_3_0=STEMI_3_3_0;}
    @Column(name = "STEMI_3_3_1_1")
    @JsonProperty("STEMI-3-3-1-1")
    private String STEMI_3_3_1_1; // 医院自身原因
    public String getSTEMI_3_3_1_1() {  return this.STEMI_3_3_1_1;}
    @JsonProperty("STEMI-3-3-1-1")
    public void setSTEMI_3_3_1_1(final String STEMI_3_3_1_1) { this.STEMI_3_3_1_1=STEMI_3_3_1_1;}
    @Column(name = "STEMI_3_3_1_1_1")
    @JsonProperty("STEMI-3-3-1-1-1")
    private String STEMI_3_3_1_1_1; // 其他医院自身原因
    public String getSTEMI_3_3_1_1_1() {  return this.STEMI_3_3_1_1_1;}
    @JsonProperty("STEMI-3-3-1-1-1")
    public void setSTEMI_3_3_1_1_1(final String STEMI_3_3_1_1_1) { this.STEMI_3_3_1_1_1=STEMI_3_3_1_1_1;}
    @Column(name = "STEMI_3_3_1_2")
    @JsonProperty("STEMI-3-3-1-2")
    private String STEMI_3_3_1_2; // 患者自身原因转院
    public String getSTEMI_3_3_1_2() {  return this.STEMI_3_3_1_2;}
    @JsonProperty("STEMI-3-3-1-2")
    public void setSTEMI_3_3_1_2(final String STEMI_3_3_1_2) { this.STEMI_3_3_1_2=STEMI_3_3_1_2;}
    @Column(name = "STEMI_3_3_1_2_1")
    @JsonProperty("STEMI-3-3-1-2-1")
    private String STEMI_3_3_1_2_1; // 其他患者自身原因
    public String getSTEMI_3_3_1_2_1() {  return this.STEMI_3_3_1_2_1;}
    @JsonProperty("STEMI-3-3-1-2-1")
    public void setSTEMI_3_3_1_2_1(final String STEMI_3_3_1_2_1) { this.STEMI_3_3_1_2_1=STEMI_3_3_1_2_1;}
    @Column(name = "STEMI_3_3_2")
    @JsonProperty("STEMI-3-3-2")
    private String STEMI_3_3_2; // 转院类型及适应症
    public String getSTEMI_3_3_2() {  return this.STEMI_3_3_2;}
    @JsonProperty("STEMI-3-3-2")
    public void setSTEMI_3_3_2(final String STEMI_3_3_2) { this.STEMI_3_3_2=STEMI_3_3_2;}
    @Column(name = "STEMI_3_3_3_1")
    @JsonProperty("STEMI-3-3-3-1")
    private String STEMI_3_3_3_1; // 转院日期时间
    public String getSTEMI_3_3_3_1() {  return this.STEMI_3_3_3_1;}
    @JsonProperty("STEMI-3-3-3-1")
    public void setSTEMI_3_3_3_1(final String STEMI_3_3_3_1) { this.STEMI_3_3_3_1=STEMI_3_3_3_1;}
    @Column(name = "STEMI_3_3_4_1")
    @JsonProperty("STEMI-3-3-4-1")
    private String STEMI_3_3_4_1; // 到医院就诊至转出时间（分钟）
    public String getSTEMI_3_3_4_1() {  return this.STEMI_3_3_4_1;}
    @JsonProperty("STEMI-3-3-4-1")
    public void setSTEMI_3_3_4_1(final String STEMI_3_3_4_1) { this.STEMI_3_3_4_1=STEMI_3_3_4_1;}
    @Column(name = "STEMI_3_4")
    @JsonProperty("STEMI-3-4")
    private String STEMI_3_4; // 医院是否具备接受外院“转院PCI”患者的能力
    public String getSTEMI_3_4() {  return this.STEMI_3_4;}
    @JsonProperty("STEMI-3-4")
    public void setSTEMI_3_4(final String STEMI_3_4) { this.STEMI_3_4=STEMI_3_4;}
    @Column(name = "STEMI_3_4_1_1")
    @JsonProperty("STEMI-3-4-1-1")
    private String STEMI_3_4_1_1; // 患者从不具备实施PCI能力医院转运到本院急诊或门诊日期 
    public String getSTEMI_3_4_1_1() {  return this.STEMI_3_4_1_1;}
    @JsonProperty("STEMI-3-4-1-1")
    public void setSTEMI_3_4_1_1(final String STEMI_3_4_1_1) { this.STEMI_3_4_1_1=STEMI_3_4_1_1;}
    @Column(name = "STEMI_3_4_2_1")
    @JsonProperty("STEMI-3-4-2-1")
    private String STEMI_3_4_2_1; // PCI导丝通过梗死相关动脉的时间
    public String getSTEMI_3_4_2_1() {  return this.STEMI_3_4_2_1;}
    @JsonProperty("STEMI-3-4-2-1")
    public void setSTEMI_3_4_2_1(final String STEMI_3_4_2_1) { this.STEMI_3_4_2_1=STEMI_3_4_2_1;}
    @Column(name = "STEMI_3_4_3_1")
    @JsonProperty("STEMI-3-4-3-1")
    private String STEMI_3_4_3_1; // 医院转出时间至PCI导丝通过梗死相关动脉（D2B1）时间（分钟）
    public String getSTEMI_3_4_3_1() {  return this.STEMI_3_4_3_1;}
    @JsonProperty("STEMI-3-4-3-1")
    public void setSTEMI_3_4_3_1(final String STEMI_3_4_3_1) { this.STEMI_3_4_3_1=STEMI_3_4_3_1;}
    @Column(name = "STEMI_3_4_4")
    @JsonProperty("STEMI-3-4-4")
    private String STEMI_3_4_4; // 治疗延迟原因选择
    public String getSTEMI_3_4_4() {  return this.STEMI_3_4_4;}
    @JsonProperty("STEMI-3-4-4")
    public void setSTEMI_3_4_4(final String STEMI_3_4_4) { this.STEMI_3_4_4=STEMI_3_4_4;}
    @Column(name = "STEMI_4_1_1")
    @JsonProperty("STEMI-4-1-1")
    private String STEMI_4_1_1; // 是否有β-受体阻滞剂禁忌证
    public String getSTEMI_4_1_1() {  return this.STEMI_4_1_1;}
    @JsonProperty("STEMI-4-1-1")
    public void setSTEMI_4_1_1(final String STEMI_4_1_1) { this.STEMI_4_1_1=STEMI_4_1_1;}
    @Column(name = "STEMI_4_1_2_1")
    @JsonProperty("STEMI-4-1-2-1")
    private String STEMI_4_1_2_1; // β-受体阻滞剂禁忌症
    public String getSTEMI_4_1_2_1() {  return this.STEMI_4_1_2_1;}
    @JsonProperty("STEMI-4-1-2-1")
    public void setSTEMI_4_1_2_1(final String STEMI_4_1_2_1) { this.STEMI_4_1_2_1=STEMI_4_1_2_1;}
    @Column(name = "STEMI_4_1_2_1_1")
    @JsonProperty("STEMI-4-1-2-1-1")
    private String STEMI_4_1_2_1_1; // 其他β-受体阻滞剂禁忌症
    public String getSTEMI_4_1_2_1_1() {  return this.STEMI_4_1_2_1_1;}
    @JsonProperty("STEMI-4-1-2-1-1")
    public void setSTEMI_4_1_2_1_1(final String STEMI_4_1_2_1_1) { this.STEMI_4_1_2_1_1=STEMI_4_1_2_1_1;}
    @Column(name = "STEMI_4_1_2_2")
    @JsonProperty("STEMI-4-1-2-2")
    private String STEMI_4_1_2_2; // β-受体阻滞剂相对禁忌症
    public String getSTEMI_4_1_2_2() {  return this.STEMI_4_1_2_2;}
    @JsonProperty("STEMI-4-1-2-2")
    public void setSTEMI_4_1_2_2(final String STEMI_4_1_2_2) { this.STEMI_4_1_2_2=STEMI_4_1_2_2;}
    @Column(name = "STEMI_4_1_2_2_1")
    @JsonProperty("STEMI-4-1-2-2-1")
    private String STEMI_4_1_2_2_1; // 其他β-受体阻滞剂相对禁忌症
    public String getSTEMI_4_1_2_2_1() {  return this.STEMI_4_1_2_2_1;}
    @JsonProperty("STEMI-4-1-2-2-1")
    public void setSTEMI_4_1_2_2_1(final String STEMI_4_1_2_2_1) { this.STEMI_4_1_2_2_1=STEMI_4_1_2_2_1;}
    @Column(name = "STEMI_4_2")
    @JsonProperty("STEMI-4-2")
    private String STEMI_4_2; // 使用首剂β-受体阻滞剂
    public String getSTEMI_4_2() {  return this.STEMI_4_2;}
    @JsonProperty("STEMI-4-2")
    public void setSTEMI_4_2(final String STEMI_4_2) { this.STEMI_4_2=STEMI_4_2;}
    @Column(name = "STEMI_4_2_1")
    @JsonProperty("STEMI-4-2-1")
    private String STEMI_4_2_1; // 其他受体阻滞剂
    public String getSTEMI_4_2_1() {  return this.STEMI_4_2_1;}
    @JsonProperty("STEMI-4-2-1")
    public void setSTEMI_4_2_1(final String STEMI_4_2_1) { this.STEMI_4_2_1=STEMI_4_2_1;}
    @Column(name = "STEMI_4_3_1")
    @JsonProperty("STEMI-4-3-1")
    private String STEMI_4_3_1; // 首剂用药日期时间
    public String getSTEMI_4_3_1() {  return this.STEMI_4_3_1;}
    @JsonProperty("STEMI-4-3-1")
    public void setSTEMI_4_3_1(final String STEMI_4_3_1) { this.STEMI_4_3_1=STEMI_4_3_1;}
    @Column(name = "STEMI_5_1_1")
    @JsonProperty("STEMI-5-1-1")
    private String STEMI_5_1_1; // 双联抗血小板药物是否有用药长期医嘱
    public String getSTEMI_5_1_1() {  return this.STEMI_5_1_1;}
    @JsonProperty("STEMI-5-1-1")
    public void setSTEMI_5_1_1(final String STEMI_5_1_1) { this.STEMI_5_1_1=STEMI_5_1_1;}
    @Column(name = "STEMI_5_1_2")
    @JsonProperty("STEMI-5-1-2")
    private String STEMI_5_1_2; // 双联抗血小板药物品名的选择
    public String getSTEMI_5_1_2() {  return this.STEMI_5_1_2;}
    @JsonProperty("STEMI-5-1-2")
    public void setSTEMI_5_1_2(final String STEMI_5_1_2) { this.STEMI_5_1_2=STEMI_5_1_2;}
    @Column(name = "STEMI_5_1_2_1")
    @JsonProperty("STEMI-5-1-2-1")
    private String STEMI_5_1_2_1; // 双联抗血小板药物品名填写
    public String getSTEMI_5_1_2_1() {  return this.STEMI_5_1_2_1;}
    @JsonProperty("STEMI-5-1-2-1")
    public void setSTEMI_5_1_2_1(final String STEMI_5_1_2_1) { this.STEMI_5_1_2_1=STEMI_5_1_2_1;}
    @Column(name = "STEMI_5_2_1")
    @JsonProperty("STEMI-5-2-1")
    private String STEMI_5_2_1; // β阻滞剂是否有用药长期医嘱
    public String getSTEMI_5_2_1() {  return this.STEMI_5_2_1;}
    @JsonProperty("STEMI-5-2-1")
    public void setSTEMI_5_2_1(final String STEMI_5_2_1) { this.STEMI_5_2_1=STEMI_5_2_1;}
    @Column(name = "STEMI_5_2_2")
    @JsonProperty("STEMI-5-2-2")
    private String STEMI_5_2_2; // 长期医嘱中使用β-受体阻滞剂品名的选择
    public String getSTEMI_5_2_2() {  return this.STEMI_5_2_2;}
    @JsonProperty("STEMI-5-2-2")
    public void setSTEMI_5_2_2(final String STEMI_5_2_2) { this.STEMI_5_2_2=STEMI_5_2_2;}
    @Column(name = "STEMI_5_2_2_1")
    @JsonProperty("STEMI-5-2-2-1")
    private String STEMI_5_2_2_1; // 其他受体阻滞剂品名
    public String getSTEMI_5_2_2_1() {  return this.STEMI_5_2_2_1;}
    @JsonProperty("STEMI-5-2-2-1")
    public void setSTEMI_5_2_2_1(final String STEMI_5_2_2_1) { this.STEMI_5_2_2_1=STEMI_5_2_2_1;}
    @Column(name = "STEMI_5_3_1")
    @JsonProperty("STEMI-5-3-1")
    private String STEMI_5_3_1; // 是否有ACEI抑制剂/ARB类药物禁忌症
    public String getSTEMI_5_3_1() {  return this.STEMI_5_3_1;}
    @JsonProperty("STEMI-5-3-1")
    public void setSTEMI_5_3_1(final String STEMI_5_3_1) { this.STEMI_5_3_1=STEMI_5_3_1;}
    @Column(name = "STEMI_5_3_2")
    @JsonProperty("STEMI-5-3-2")
    private String STEMI_5_3_2; // ACE抑制剂/ARB类药物禁忌症的选择
    public String getSTEMI_5_3_2() {  return this.STEMI_5_3_2;}
    @JsonProperty("STEMI-5-3-2")
    public void setSTEMI_5_3_2(final String STEMI_5_3_2) { this.STEMI_5_3_2=STEMI_5_3_2;}
    @Column(name = "STEMI_5_3_3")
    @JsonProperty("STEMI-5-3-3")
    private String STEMI_5_3_3; // 是否有ACEI抑制剂/ARB类药物长期医嘱
    public String getSTEMI_5_3_3() {  return this.STEMI_5_3_3;}
    @JsonProperty("STEMI-5-3-3")
    public void setSTEMI_5_3_3(final String STEMI_5_3_3) { this.STEMI_5_3_3=STEMI_5_3_3;}
    @Column(name = "STEMI_5_3_4_A")
    @JsonProperty("STEMI-5-3-4-A")
    private String STEMI_5_3_4_A; // 使用ACE抑制剂药物名称的选择
    public String getSTEMI_5_3_4_A() {  return this.STEMI_5_3_4_A;}
    @JsonProperty("STEMI-5-3-4-A")
    public void setSTEMI_5_3_4_A(final String STEMI_5_3_4_A) { this.STEMI_5_3_4_A=STEMI_5_3_4_A;}
    @Column(name = "STEMI_5_3_4_A_1")
    @JsonProperty("STEMI-5-3-4-A-1")
    private String STEMI_5_3_4_A_1; // 其他ACE抑制剂药物
    public String getSTEMI_5_3_4_A_1() {  return this.STEMI_5_3_4_A_1;}
    @JsonProperty("STEMI-5-3-4-A-1")
    public void setSTEMI_5_3_4_A_1(final String STEMI_5_3_4_A_1) { this.STEMI_5_3_4_A_1=STEMI_5_3_4_A_1;}
    @Column(name = "STEMI_5_3_4_B")
    @JsonProperty("STEMI-5-3-4-B")
    private String STEMI_5_3_4_B; // 使用ARB类药物名称的选择
    public String getSTEMI_5_3_4_B() {  return this.STEMI_5_3_4_B;}
    @JsonProperty("STEMI-5-3-4-B")
    public void setSTEMI_5_3_4_B(final String STEMI_5_3_4_B) { this.STEMI_5_3_4_B=STEMI_5_3_4_B;}
    @Column(name = "STEMI_5_3_4_B_1")
    @JsonProperty("STEMI-5-3-4-B-1")
    private String STEMI_5_3_4_B_1; // 其他ARB类药物
    public String getSTEMI_5_3_4_B_1() {  return this.STEMI_5_3_4_B_1;}
    @JsonProperty("STEMI-5-3-4-B-1")
    public void setSTEMI_5_3_4_B_1(final String STEMI_5_3_4_B_1) { this.STEMI_5_3_4_B_1=STEMI_5_3_4_B_1;}
    @Column(name = "STEMI_5_4_1")
    @JsonProperty("STEMI-5-4-1")
    private String STEMI_5_4_1; // 是否有他汀类药禁忌证
    public String getSTEMI_5_4_1() {  return this.STEMI_5_4_1;}
    @JsonProperty("STEMI-5-4-1")
    public void setSTEMI_5_4_1(final String STEMI_5_4_1) { this.STEMI_5_4_1=STEMI_5_4_1;}
    @Column(name = "STEMI_5_4_2")
    @JsonProperty("STEMI-5-4-2")
    private String STEMI_5_4_2; // 他汀类药物禁忌证的选择
    public String getSTEMI_5_4_2() {  return this.STEMI_5_4_2;}
    @JsonProperty("STEMI-5-4-2")
    public void setSTEMI_5_4_2(final String STEMI_5_4_2) { this.STEMI_5_4_2=STEMI_5_4_2;}
    @Column(name = "STEMI_5_4_3")
    @JsonProperty("STEMI-5-4-3")
    private String STEMI_5_4_3; // 是否有用药长期医嘱
    public String getSTEMI_5_4_3() {  return this.STEMI_5_4_3;}
    @JsonProperty("STEMI-5-4-3")
    public void setSTEMI_5_4_3(final String STEMI_5_4_3) { this.STEMI_5_4_3=STEMI_5_4_3;}
    @Column(name = "STEMI_5_4_4")
    @JsonProperty("STEMI-5-4-4")
    private String STEMI_5_4_4; // 给予他汀类药物名称的选择
    public String getSTEMI_5_4_4() {  return this.STEMI_5_4_4;}
    @JsonProperty("STEMI-5-4-4")
    public void setSTEMI_5_4_4(final String STEMI_5_4_4) { this.STEMI_5_4_4=STEMI_5_4_4;}
    @Column(name = "STEMI_5_4_4_1")
    @JsonProperty("STEMI-5-4-4-1")
    private String STEMI_5_4_4_1; // 其他其他降脂药物
    public String getSTEMI_5_4_4_1() {  return this.STEMI_5_4_4_1;}
    @JsonProperty("STEMI-5-4-4-1")
    public void setSTEMI_5_4_4_1(final String STEMI_5_4_4_1) { this.STEMI_5_4_4_1=STEMI_5_4_4_1;}
    @Column(name = "STEMI_6_1")
    @JsonProperty("STEMI-6-1")
    private String STEMI_6_1; // 是否有出院带药医嘱-抗血小板药物
    public String getSTEMI_6_1() {  return this.STEMI_6_1;}
    @JsonProperty("STEMI-6-1")
    public void setSTEMI_6_1(final String STEMI_6_1) { this.STEMI_6_1=STEMI_6_1;}
    @Column(name = "STEMI_6_1_2")
    @JsonProperty("STEMI-6-1-2")
    private String STEMI_6_1_2; // 双联抗血小板药物品名的选择
    public String getSTEMI_6_1_2() {  return this.STEMI_6_1_2;}
    @JsonProperty("STEMI-6-1-2")
    public void setSTEMI_6_1_2(final String STEMI_6_1_2) { this.STEMI_6_1_2=STEMI_6_1_2;}
    @Column(name = "STEMI_6_1_2_1")
    @JsonProperty("STEMI-6-1-2-1")
    private String STEMI_6_1_2_1; // 其他双联抗血小板药物品
    public String getSTEMI_6_1_2_1() {  return this.STEMI_6_1_2_1;}
    @JsonProperty("STEMI-6-1-2-1")
    public void setSTEMI_6_1_2_1(final String STEMI_6_1_2_1) { this.STEMI_6_1_2_1=STEMI_6_1_2_1;}
    @Column(name = "STEMI_6_2")
    @JsonProperty("STEMI-6-2")
    private String STEMI_6_2; // 是否有β阻滞剂出院带药医嘱
    public String getSTEMI_6_2() {  return this.STEMI_6_2;}
    @JsonProperty("STEMI-6-2")
    public void setSTEMI_6_2(final String STEMI_6_2) { this.STEMI_6_2=STEMI_6_2;}
    @Column(name = "STEMI_6_2_2")
    @JsonProperty("STEMI-6-2-2")
    private String STEMI_6_2_2; // 使用β-受体阻滞剂品名的选择
    public String getSTEMI_6_2_2() {  return this.STEMI_6_2_2;}
    @JsonProperty("STEMI-6-2-2")
    public void setSTEMI_6_2_2(final String STEMI_6_2_2) { this.STEMI_6_2_2=STEMI_6_2_2;}
    @Column(name = "STEMI_6_3")
    @JsonProperty("STEMI-6-3")
    private String STEMI_6_3; // 是否有出院带药医嘱-ACEI抑制剂/ARB类药物医嘱
    public String getSTEMI_6_3() {  return this.STEMI_6_3;}
    @JsonProperty("STEMI-6-3")
    public void setSTEMI_6_3(final String STEMI_6_3) { this.STEMI_6_3=STEMI_6_3;}
    @Column(name = "STEMI_6_3_2")
    @JsonProperty("STEMI-6-3-2")
    private String STEMI_6_3_2; // 使用ACEI抑制剂或者ARB类药物
    public String getSTEMI_6_3_2() {  return this.STEMI_6_3_2;}
    @JsonProperty("STEMI-6-3-2")
    public void setSTEMI_6_3_2(final String STEMI_6_3_2) { this.STEMI_6_3_2=STEMI_6_3_2;}
    @Column(name = "STEMI_6_3_2_A")
    @JsonProperty("STEMI-6-3-2-A")
    private String STEMI_6_3_2_A; // 使用ACE抑制剂药物名称的选择
    public String getSTEMI_6_3_2_A() {  return this.STEMI_6_3_2_A;}
    @JsonProperty("STEMI-6-3-2-A")
    public void setSTEMI_6_3_2_A(final String STEMI_6_3_2_A) { this.STEMI_6_3_2_A=STEMI_6_3_2_A;}
    @Column(name = "STEMI_6_3_2_A_1")
    @JsonProperty("STEMI-6-3-2-A-1")
    private String STEMI_6_3_2_A_1; // 其他ACE抑制剂药物
    public String getSTEMI_6_3_2_A_1() {  return this.STEMI_6_3_2_A_1;}
    @JsonProperty("STEMI-6-3-2-A-1")
    public void setSTEMI_6_3_2_A_1(final String STEMI_6_3_2_A_1) { this.STEMI_6_3_2_A_1=STEMI_6_3_2_A_1;}
    @Column(name = "STEMI_6_3_2_B")
    @JsonProperty("STEMI-6-3-2-B")
    private String STEMI_6_3_2_B; // 使用ARB类药物名称的选择
    public String getSTEMI_6_3_2_B() {  return this.STEMI_6_3_2_B;}
    @JsonProperty("STEMI-6-3-2-B")
    public void setSTEMI_6_3_2_B(final String STEMI_6_3_2_B) { this.STEMI_6_3_2_B=STEMI_6_3_2_B;}
    @Column(name = "STEMI_6_3_2_B_1")
    @JsonProperty("STEMI-6-3-2-B-1")
    private String STEMI_6_3_2_B_1; // 其他ARB类药物
    public String getSTEMI_6_3_2_B_1() {  return this.STEMI_6_3_2_B_1;}
    @JsonProperty("STEMI-6-3-2-B-1")
    public void setSTEMI_6_3_2_B_1(final String STEMI_6_3_2_B_1) { this.STEMI_6_3_2_B_1=STEMI_6_3_2_B_1;}
    @Column(name = "STEMI_6_4")
    @JsonProperty("STEMI-6-4")
    private String STEMI_6_4; // 是否有出院带药医嘱-他汀类药物医嘱
    public String getSTEMI_6_4() {  return this.STEMI_6_4;}
    @JsonProperty("STEMI-6-4")
    public void setSTEMI_6_4(final String STEMI_6_4) { this.STEMI_6_4=STEMI_6_4;}
    @Column(name = "STEMI_6_4_2")
    @JsonProperty("STEMI-6-4-2")
    private String STEMI_6_4_2; // 给予他汀类药物名称的选择
    public String getSTEMI_6_4_2() {  return this.STEMI_6_4_2;}
    @JsonProperty("STEMI-6-4-2")
    public void setSTEMI_6_4_2(final String STEMI_6_4_2) { this.STEMI_6_4_2=STEMI_6_4_2;}
    @Column(name = "STEMI_6_4_2_1")
    @JsonProperty("STEMI-6-4-2-1")
    private String STEMI_6_4_2_1; // 其他降脂药物
    public String getSTEMI_6_4_2_1() {  return this.STEMI_6_4_2_1;}
    @JsonProperty("STEMI-6-4-2-1")
    public void setSTEMI_6_4_2_1(final String STEMI_6_4_2_1) { this.STEMI_6_4_2_1=STEMI_6_4_2_1;}
    @Column(name = "STEMI_6_5_1")
    @JsonProperty("STEMI-6-5-1")
    private String STEMI_6_5_1; // 是否有醛固酮受体拮抗剂药物禁忌证
    public String getSTEMI_6_5_1() {  return this.STEMI_6_5_1;}
    @JsonProperty("STEMI-6-5-1")
    public void setSTEMI_6_5_1(final String STEMI_6_5_1) { this.STEMI_6_5_1=STEMI_6_5_1;}
    @Column(name = "STEMI_6_5_2")
    @JsonProperty("STEMI-6-5-2")
    private String STEMI_6_5_2; // 醛固酮受体拮抗剂药物禁忌证的选择
    public String getSTEMI_6_5_2() {  return this.STEMI_6_5_2;}
    @JsonProperty("STEMI-6-5-2")
    public void setSTEMI_6_5_2(final String STEMI_6_5_2) { this.STEMI_6_5_2=STEMI_6_5_2;}
    @Column(name = "STEMI_6_5_2_1")
    @JsonProperty("STEMI-6-5-2-1")
    private String STEMI_6_5_2_1; // 醛固酮受体拮抗剂药物禁忌证填写
    public String getSTEMI_6_5_2_1() {  return this.STEMI_6_5_2_1;}
    @JsonProperty("STEMI-6-5-2-1")
    public void setSTEMI_6_5_2_1(final String STEMI_6_5_2_1) { this.STEMI_6_5_2_1=STEMI_6_5_2_1;}
    @Column(name = "STEMI_6_5_3")
    @JsonProperty("STEMI-6-5-3")
    private String STEMI_6_5_3; // 是否有醛固酮受体拮抗剂药物适应证
    public String getSTEMI_6_5_3() {  return this.STEMI_6_5_3;}
    @JsonProperty("STEMI-6-5-3")
    public void setSTEMI_6_5_3(final String STEMI_6_5_3) { this.STEMI_6_5_3=STEMI_6_5_3;}
    @Column(name = "STEMI_6_5_4")
    @JsonProperty("STEMI-6-5-4")
    private String STEMI_6_5_4; // 醛固酮受体拮抗剂药物适应证的选择
    public String getSTEMI_6_5_4() {  return this.STEMI_6_5_4;}
    @JsonProperty("STEMI-6-5-4")
    public void setSTEMI_6_5_4(final String STEMI_6_5_4) { this.STEMI_6_5_4=STEMI_6_5_4;}
    @Column(name = "STEMI_6_5_5")
    @JsonProperty("STEMI-6-5-5")
    private String STEMI_6_5_5; // 是否有出院带药医嘱-醛固酮受体拮抗剂
    public String getSTEMI_6_5_5() {  return this.STEMI_6_5_5;}
    @JsonProperty("STEMI-6-5-5")
    public void setSTEMI_6_5_5(final String STEMI_6_5_5) { this.STEMI_6_5_5=STEMI_6_5_5;}
    @Column(name = "STEMI_6_5_6")
    @JsonProperty("STEMI-6-5-6")
    private String STEMI_6_5_6; // 出院带药医嘱中使用醛固酮受体拮抗剂品名的选择
    public String getSTEMI_6_5_6() {  return this.STEMI_6_5_6;}
    @JsonProperty("STEMI-6-5-6")
    public void setSTEMI_6_5_6(final String STEMI_6_5_6) { this.STEMI_6_5_6=STEMI_6_5_6;}
    @Column(name = "STEMI_6_5_6_1")
    @JsonProperty("STEMI-6-5-6-1")
    private String STEMI_6_5_6_1; // 其他醛固酮受体拮抗剂品名
    public String getSTEMI_6_5_6_1() {  return this.STEMI_6_5_6_1;}
    @JsonProperty("STEMI-6-5-6-1")
    public void setSTEMI_6_5_6_1(final String STEMI_6_5_6_1) { this.STEMI_6_5_6_1=STEMI_6_5_6_1;}
    @Column(name = "STEMI_7_1")
    @JsonProperty("STEMI-7-1")
    private String STEMI_7_1; // 血脂评价时间
    public String getSTEMI_7_1() {  return this.STEMI_7_1;}
    @JsonProperty("STEMI-7-1")
    public void setSTEMI_7_1(final String STEMI_7_1) { this.STEMI_7_1=STEMI_7_1;}
    @Column(name = "STEMI_7_2")
    @JsonProperty("STEMI-7-2")
    private String STEMI_7_2; // 血脂评价结果
    public String getSTEMI_7_2() {  return this.STEMI_7_2;}
    @JsonProperty("STEMI-7-2")
    public void setSTEMI_7_2(final String STEMI_7_2) { this.STEMI_7_2=STEMI_7_2;}
    @Column(name = "STEMI_7_3_1")
    @JsonProperty("STEMI-7-3-1")
    private String STEMI_7_3_1; // 是否有他汀药物禁忌症
    public String getSTEMI_7_3_1() {  return this.STEMI_7_3_1;}
    @JsonProperty("STEMI-7-3-1")
    public void setSTEMI_7_3_1(final String STEMI_7_3_1) { this.STEMI_7_3_1=STEMI_7_3_1;}
    @Column(name = "STEMI_7_3_2")
    @JsonProperty("STEMI-7-3-2")
    private String STEMI_7_3_2; // 他汀类药物禁忌证的选择
    public String getSTEMI_7_3_2() {  return this.STEMI_7_3_2;}
    @JsonProperty("STEMI-7-3-2")
    public void setSTEMI_7_3_2(final String STEMI_7_3_2) { this.STEMI_7_3_2=STEMI_7_3_2;}
    @Column(name = "STEMI_7_4")
    @JsonProperty("STEMI-7-4")
    private String STEMI_7_4; // 是否有他汀类药物长期医嘱
    public String getSTEMI_7_4() {  return this.STEMI_7_4;}
    @JsonProperty("STEMI-7-4")
    public void setSTEMI_7_4(final String STEMI_7_4) { this.STEMI_7_4=STEMI_7_4;}
    @Column(name = "STEMI_7_5")
    @JsonProperty("STEMI-7-5")
    private String STEMI_7_5; // 是否有他汀类药物出院带药医嘱
    public String getSTEMI_7_5() {  return this.STEMI_7_5;}
    @JsonProperty("STEMI-7-5")
    public void setSTEMI_7_5(final String STEMI_7_5) { this.STEMI_7_5=STEMI_7_5;}
    @Column(name = "STEMI_8_5_1_1")
    @JsonProperty("STEMI-8-5-1-1")
    private String STEMI_8_5_1_1; // 是否提供住院期间急性期康复
    public String getSTEMI_8_5_1_1() {  return this.STEMI_8_5_1_1;}
    @JsonProperty("STEMI-8-5-1-1")
    public void setSTEMI_8_5_1_1(final String STEMI_8_5_1_1) { this.STEMI_8_5_1_1=STEMI_8_5_1_1;}
    @Column(name = "STEMI_8_5_1_2")
    @JsonProperty("STEMI-8-5-1-2")
    private String STEMI_8_5_1_2; // 急性期康复时间窗
    public String getSTEMI_8_5_1_2() {  return this.STEMI_8_5_1_2;}
    @JsonProperty("STEMI-8-5-1-2")
    public void setSTEMI_8_5_1_2(final String STEMI_8_5_1_2) { this.STEMI_8_5_1_2=STEMI_8_5_1_2;}
    @Column(name = "STEMI_8_5_1_3")
    @JsonProperty("STEMI-8-5-1-3")
    private String STEMI_8_5_1_3; // 运动指导适应证
    public String getSTEMI_8_5_1_3() {  return this.STEMI_8_5_1_3;}
    @JsonProperty("STEMI-8-5-1-3")
    public void setSTEMI_8_5_1_3(final String STEMI_8_5_1_3) { this.STEMI_8_5_1_3=STEMI_8_5_1_3;}
    @Column(name = "STEMI_8_5_1_4")
    @JsonProperty("STEMI-8-5-1-4")
    private String STEMI_8_5_1_4; // 具体步骤
    public String getSTEMI_8_5_1_4() {  return this.STEMI_8_5_1_4;}
    @JsonProperty("STEMI-8-5-1-4")
    public void setSTEMI_8_5_1_4(final String STEMI_8_5_1_4) { this.STEMI_8_5_1_4=STEMI_8_5_1_4;}
    @Column(name = "STEMI_8_5_2_1")
    @JsonProperty("STEMI-8-5-2-1")
    private String STEMI_8_5_2_1; // 是否告知出院后稳定期心脏康复要求
    public String getSTEMI_8_5_2_1() {  return this.STEMI_8_5_2_1;}
    @JsonProperty("STEMI-8-5-2-1")
    public void setSTEMI_8_5_2_1(final String STEMI_8_5_2_1) { this.STEMI_8_5_2_1=STEMI_8_5_2_1;}
    @Column(name = "STEMI_8_5_2_2")
    @JsonProperty("STEMI-8-5-2-2")
    private String STEMI_8_5_2_2; // 稳定期心脏康复要求时间窗
    public String getSTEMI_8_5_2_2() {  return this.STEMI_8_5_2_2;}
    @JsonProperty("STEMI-8-5-2-2")
    public void setSTEMI_8_5_2_2(final String STEMI_8_5_2_2) { this.STEMI_8_5_2_2=STEMI_8_5_2_2;}
    @Column(name = "STEMI_8_5_2_3")
    @JsonProperty("STEMI-8-5-2-3")
    private String STEMI_8_5_2_3; // 稳定期心脏康复要求其他时间窗
    public String getSTEMI_8_5_2_3() {  return this.STEMI_8_5_2_3;}
    @JsonProperty("STEMI-8-5-2-3")
    public void setSTEMI_8_5_2_3(final String STEMI_8_5_2_3) { this.STEMI_8_5_2_3=STEMI_8_5_2_3;}
    @Column(name = "STEMI_8_5_2_4")
    @JsonProperty("STEMI-8-5-2-4")
    private String STEMI_8_5_2_4; // 运动训练内容
    public String getSTEMI_8_5_2_4() {  return this.STEMI_8_5_2_4;}
    @JsonProperty("STEMI-8-5-2-4")
    public void setSTEMI_8_5_2_4(final String STEMI_8_5_2_4) { this.STEMI_8_5_2_4=STEMI_8_5_2_4;}
    @Column(name = "STEMI_8_5_2_5")
    @JsonProperty("STEMI-8-5-2-5")
    private String STEMI_8_5_2_5; // 其他运动训练内容
    public String getSTEMI_8_5_2_5() {  return this.STEMI_8_5_2_5;}
    @JsonProperty("STEMI-8-5-2-5")
    public void setSTEMI_8_5_2_5(final String STEMI_8_5_2_5) { this.STEMI_8_5_2_5=STEMI_8_5_2_5;}
    @Column(name = "STEMI_8_1_1")
    @JsonProperty("STEMI-8-1-1")
    private String STEMI_8_1_1; // 吸烟史
    public String getSTEMI_8_1_1() {  return this.STEMI_8_1_1;}
    @JsonProperty("STEMI-8-1-1")
    public void setSTEMI_8_1_1(final String STEMI_8_1_1) { this.STEMI_8_1_1=STEMI_8_1_1;}
    @Column(name = "STEMI_8_1_2")
    @JsonProperty("STEMI-8-1-2")
    private String STEMI_8_1_2; // 吸烟程度评估有记录
    public String getSTEMI_8_1_2() {  return this.STEMI_8_1_2;}
    @JsonProperty("STEMI-8-1-2")
    public void setSTEMI_8_1_2(final String STEMI_8_1_2) { this.STEMI_8_1_2=STEMI_8_1_2;}
    @Column(name = "STEMI_8_1_3")
    @JsonProperty("STEMI-8-1-3")
    private String STEMI_8_1_3; // 接受戒烟的建议或者戒烟治疗有记录
    public String getSTEMI_8_1_3() {  return this.STEMI_8_1_3;}
    @JsonProperty("STEMI-8-1-3")
    public void setSTEMI_8_1_3(final String STEMI_8_1_3) { this.STEMI_8_1_3=STEMI_8_1_3;}
    @Column(name = "STEMI_8_5_3_1")
    @JsonProperty("STEMI-8-5-3-1")
    private String STEMI_8_5_3_1; // 严重ASCVD事件
    public String getSTEMI_8_5_3_1() {  return this.STEMI_8_5_3_1;}
    @JsonProperty("STEMI-8-5-3-1")
    public void setSTEMI_8_5_3_1(final String STEMI_8_5_3_1) { this.STEMI_8_5_3_1=STEMI_8_5_3_1;}
    @Column(name = "STEMI_8_2_3_2")
    @JsonProperty("STEMI-8-2-3-2")
    private String STEMI_8_2_3_2; // 高风险因素
    public String getSTEMI_8_2_3_2() {  return this.STEMI_8_2_3_2;}
    @JsonProperty("STEMI-8-2-3-2")
    public void setSTEMI_8_2_3_2(final String STEMI_8_2_3_2) { this.STEMI_8_2_3_2=STEMI_8_2_3_2;}
    @Column(name = "STEMI_8_2_2")
    @JsonProperty("STEMI-8-2-2")
    private String STEMI_8_2_2; // 实施针对控制危险因素评估结果的教育
    public String getSTEMI_8_2_2() {  return this.STEMI_8_2_2;}
    @JsonProperty("STEMI-8-2-2")
    public void setSTEMI_8_2_2(final String STEMI_8_2_2) { this.STEMI_8_2_2=STEMI_8_2_2;}
    @Column(name = "STEMI_8_3")
    @JsonProperty("STEMI-8-3")
    private String STEMI_8_3; // 二级预防
    public String getSTEMI_8_3() {  return this.STEMI_8_3;}
    @JsonProperty("STEMI-8-3")
    public void setSTEMI_8_3(final String STEMI_8_3) { this.STEMI_8_3=STEMI_8_3;}
    @Column(name = "STEMI_8_4_1")
    @JsonProperty("STEMI-8-4-1")
    private String STEMI_8_4_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    public String getSTEMI_8_4_1() {  return this.STEMI_8_4_1;}
    @JsonProperty("STEMI-8-4-1")
    public void setSTEMI_8_4_1(final String STEMI_8_4_1) { this.STEMI_8_4_1=STEMI_8_4_1;}
    @Column(name = "STEMI_8_4_2")
    @JsonProperty("STEMI-8-4-2")
    private String STEMI_8_4_2; // 出院带药
    public String getSTEMI_8_4_2() {  return this.STEMI_8_4_2;}
    @JsonProperty("STEMI-8-4-2")
    public void setSTEMI_8_4_2(final String STEMI_8_4_2) { this.STEMI_8_4_2=STEMI_8_4_2;}
    @Column(name = "STEMI_8_4_3")
    @JsonProperty("STEMI-8-4-3")
    private String STEMI_8_4_3; // 告知发生紧急情况时求援救治途径
    public String getSTEMI_8_4_3() {  return this.STEMI_8_4_3;}
    @JsonProperty("STEMI-8-4-3")
    public void setSTEMI_8_4_3(final String STEMI_8_4_3) { this.STEMI_8_4_3=STEMI_8_4_3;}
    @Column(name = "STEMI_8_4_4")
    @JsonProperty("STEMI-8-4-4")
    private String STEMI_8_4_4; // 出院时教育与随访
    public String getSTEMI_8_4_4() {  return this.STEMI_8_4_4;}
    @JsonProperty("STEMI-8-4-4")
    public void setSTEMI_8_4_4(final String STEMI_8_4_4) { this.STEMI_8_4_4=STEMI_8_4_4;}
    @Column(name = "STEMI_8_4_5")
    @JsonProperty("STEMI-8-4-5")
    private String STEMI_8_4_5; // 告知何为风险因素与紧急情况
    public String getSTEMI_8_4_5() {  return this.STEMI_8_4_5;}
    @JsonProperty("STEMI-8-4-5")
    public void setSTEMI_8_4_5(final String STEMI_8_4_5) { this.STEMI_8_4_5=STEMI_8_4_5;}
    @Column(name = "STEMI_9_2_1")
    @JsonProperty("STEMI-9-2-1")
    private String STEMI_9_2_1; // 出院时状态评估结果
    public String getSTEMI_9_2_1() {  return this.STEMI_9_2_1;}
    @JsonProperty("STEMI-9-2-1")
    public void setSTEMI_9_2_1(final String STEMI_9_2_1) { this.STEMI_9_2_1=STEMI_9_2_1;}
    @Column(name = "STEMI_9_2_1_2")
    @JsonProperty("STEMI-9-2-1-2")
    private String STEMI_9_2_1_2; // 其他出院时状态填写
    public String getSTEMI_9_2_1_2() {  return this.STEMI_9_2_1_2;}
    @JsonProperty("STEMI-9-2-1-2")
    public void setSTEMI_9_2_1_2(final String STEMI_9_2_1_2) { this.STEMI_9_2_1_2=STEMI_9_2_1_2;}
    @Column(name = "STEMI_9_2_2_A_2")
    @JsonProperty("STEMI-9-2-2-A-2")
    private String STEMI_9_2_2_A_2; // 末次GRACE危险评估是否有记录
    public String getSTEMI_9_2_2_A_2() {  return this.STEMI_9_2_2_A_2;}
    @JsonProperty("STEMI-9-2-2-A-2")
    public void setSTEMI_9_2_2_A_2(final String STEMI_9_2_2_A_2) { this.STEMI_9_2_2_A_2=STEMI_9_2_2_A_2;}
    @Column(name = "STEMI_9_2_2_A_1_1")
    @JsonProperty("STEMI-9-2-2-A-1-1")
    private String STEMI_9_2_2_A_1_1; // 末次GRACE危险评估
    public String getSTEMI_9_2_2_A_1_1() {  return this.STEMI_9_2_2_A_1_1;}
    @JsonProperty("STEMI-9-2-2-A-1-1")
    public void setSTEMI_9_2_2_A_1_1(final String STEMI_9_2_2_A_1_1) { this.STEMI_9_2_2_A_1_1=STEMI_9_2_2_A_1_1;}
    @Column(name = "STEMI_9_2_2_A_3")
    @JsonProperty("STEMI-9-2-2-A-3")
    private String STEMI_9_2_2_A_3; // GRACE危险评估分层的选择
    public String getSTEMI_9_2_2_A_3() {  return this.STEMI_9_2_2_A_3;}
    @JsonProperty("STEMI-9-2-2-A-3")
    public void setSTEMI_9_2_2_A_3(final String STEMI_9_2_2_A_3) { this.STEMI_9_2_2_A_3=STEMI_9_2_2_A_3;}
    @Column(name = "CM_4_1")
    @JsonProperty("CM-4-1")
    private String CM_4_1; // 住院天数
    public String getCM_4_1() {  return this.CM_4_1;}
    @JsonProperty("CM-4-1")
    public void setCM_4_1(final String CM_4_1) { this.CM_4_1=CM_4_1;}
    @Column(name = "CM_4_2")
    @JsonProperty("CM-4-2")
    private String CM_4_2; // 其中:术后（含介入）住院天数
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