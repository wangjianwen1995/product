package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：N18.0，且伴主要操作 ICD-9-CM-3编码：54.98 的腹膜透析患者。
*/
@ApiModel(value = "37信息")
@Entity
@Table(name = "sd_info_ESRD_PD")
public class SdInfoESRD_PD implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    public void setId(final Integer id) {this.id = id;}
    public Integer getId() {return this.id;}
    @Column(name = "DPD_0_1_10")
    @JsonProperty("DPD-0-1-10")
    private String DPD_0_1_10; // 请选择上报季度
    public String getDPD_0_1_10() {  return this.DPD_0_1_10;}
    @JsonProperty("DPD-0-1-10")
    public void setDPD_0_1_10(final String DPD_0_1_10) { this.DPD_0_1_10=DPD_0_1_10;}
    @Column(name = "DPD_0_1_1")
    @JsonProperty("DPD-0-1-1")
    private String DPD_0_1_1; // 是否填写医院相关信息
    public String getDPD_0_1_1() {  return this.DPD_0_1_1;}
    @JsonProperty("DPD-0-1-1")
    public void setDPD_0_1_1(final String DPD_0_1_1) { this.DPD_0_1_1=DPD_0_1_1;}
    @Column(name = "DPD_0_1_3")
    @JsonProperty("DPD-0-1-3")
    private String DPD_0_1_3; // 所属医院
    public String getDPD_0_1_3() {  return this.DPD_0_1_3;}
    @JsonProperty("DPD-0-1-3")
    public void setDPD_0_1_3(final String DPD_0_1_3) { this.DPD_0_1_3=DPD_0_1_3;}
    @Column(name = "provinceId")
    @JsonProperty("provinceId")
    private String provinceId; // 所在省
    public String getprovinceId() {  return this.provinceId;}
    @JsonProperty("provinceId")
    public void setprovinceId(final String provinceId) { this.provinceId=provinceId;}
    @Column(name = "cityId")
    @JsonProperty("cityId")
    private String cityId; // 所在市
    public String getcityId() {  return this.cityId;}
    @JsonProperty("cityId")
    public void setcityId(final String cityId) { this.cityId=cityId;}
    @Column(name = "areaId")
    @JsonProperty("areaId")
    private String areaId; // 所在区县
    public String getareaId() {  return this.areaId;}
    @JsonProperty("areaId")
    public void setareaId(final String areaId) { this.areaId=areaId;}
    @Column(name = "DPD_0_1_5")
    @JsonProperty("DPD-0-1-5")
    private String DPD_0_1_5; // 中心性质
    public String getDPD_0_1_5() {  return this.DPD_0_1_5;}
    @JsonProperty("DPD-0-1-5")
    public void setDPD_0_1_5(final String DPD_0_1_5) { this.DPD_0_1_5=DPD_0_1_5;}
    @Column(name = "DPD_0_1_6")
    @JsonProperty("DPD-0-1-6")
    private String DPD_0_1_6; // 医院级别
    public String getDPD_0_1_6() {  return this.DPD_0_1_6;}
    @JsonProperty("DPD-0-1-6")
    public void setDPD_0_1_6(final String DPD_0_1_6) { this.DPD_0_1_6=DPD_0_1_6;}
    @Column(name = "DPD_0_1_7")
    @JsonProperty("DPD-0-1-7")
    private String DPD_0_1_7; // 所有制形式
    public String getDPD_0_1_7() {  return this.DPD_0_1_7;}
    @JsonProperty("DPD-0-1-7")
    public void setDPD_0_1_7(final String DPD_0_1_7) { this.DPD_0_1_7=DPD_0_1_7;}
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
    @Column(name = "DPD_0_2_10")
    @JsonProperty("DPD-0-2-10")
    private String DPD_0_2_10; // 身份证号类别
    public String getDPD_0_2_10() {  return this.DPD_0_2_10;}
    @JsonProperty("DPD-0-2-10")
    public void setDPD_0_2_10(final String DPD_0_2_10) { this.DPD_0_2_10=DPD_0_2_10;}
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard; // 患者身份证号
    public String getIDCard() {  return this.IDCard;}
    @JsonProperty("IDCard")
    public void setIDCard(final String IDCard) { this.IDCard=IDCard;}
    @Column(name = "DPD_0_2_11")
    @JsonProperty("DPD-0-2-11")
    private String DPD_0_2_11; // 其他身份证号
    public String getDPD_0_2_11() {  return this.DPD_0_2_11;}
    @JsonProperty("DPD-0-2-11")
    public void setDPD_0_2_11(final String DPD_0_2_11) { this.DPD_0_2_11=DPD_0_2_11;}
    @Column(name = "DPD_0_2_2")
    @JsonProperty("DPD-0-2-2")
    private String DPD_0_2_2; // 患者姓名
    public String getDPD_0_2_2() {  return this.DPD_0_2_2;}
    @JsonProperty("DPD-0-2-2")
    public void setDPD_0_2_2(final String DPD_0_2_2) { this.DPD_0_2_2=DPD_0_2_2;}
    @Column(name = "CM_0_2_1_2")
    @JsonProperty("CM-0-2-1-2")
    private String CM_0_2_1_2; // 患者性别
    public String getCM_0_2_1_2() {  return this.CM_0_2_1_2;}
    @JsonProperty("CM-0-2-1-2")
    public void setCM_0_2_1_2(final String CM_0_2_1_2) { this.CM_0_2_1_2=CM_0_2_1_2;}
    @Column(name = "DPD_0_2_4")
    @JsonProperty("DPD-0-2-4")
    private String DPD_0_2_4; // 民族
    public String getDPD_0_2_4() {  return this.DPD_0_2_4;}
    @JsonProperty("DPD-0-2-4")
    public void setDPD_0_2_4(final String DPD_0_2_4) { this.DPD_0_2_4=DPD_0_2_4;}
    @Column(name = "age")
    @JsonProperty("age")
    private String age; // 患者年龄
    public String getage() {  return this.age;}
    @JsonProperty("age")
    public void setage(final String age) { this.age=age;}
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM-0-2-1-1")
    private String CM_0_2_1_1; // 出生日期
    public String getCM_0_2_1_1() {  return this.CM_0_2_1_1;}
    @JsonProperty("CM-0-2-1-1")
    public void setCM_0_2_1_1(final String CM_0_2_1_1) { this.CM_0_2_1_1=CM_0_2_1_1;}
    @Column(name = "DPD_0_2_8")
    @JsonProperty("DPD-0-2-8")
    private String DPD_0_2_8; // 腹膜透析置管日期
    public String getDPD_0_2_8() {  return this.DPD_0_2_8;}
    @JsonProperty("DPD-0-2-8")
    public void setDPD_0_2_8(final String DPD_0_2_8) { this.DPD_0_2_8=DPD_0_2_8;}
    @Column(name = "DPD_0_2_9")
    @JsonProperty("DPD-0-2-9")
    private String DPD_0_2_9; // 腹膜透析置管手术方式
    public String getDPD_0_2_9() {  return this.DPD_0_2_9;}
    @JsonProperty("DPD-0-2-9")
    public void setDPD_0_2_9(final String DPD_0_2_9) { this.DPD_0_2_9=DPD_0_2_9;}
    @Column(name = "DPD_1_1_2")
    @JsonProperty("DPD-1-1-2")
    private String DPD_1_1_2; // 首次肾脏替代治疗时检查结果
    public String getDPD_1_1_2() {  return this.DPD_1_1_2;}
    @JsonProperty("DPD-1-1-2")
    public void setDPD_1_1_2(final String DPD_1_1_2) { this.DPD_1_1_2=DPD_1_1_2;}
    @Column(name = "DPD_1_1_2_1")
    @JsonProperty("DPD-1-1-2-1")
    private String DPD_1_1_2_1; // 肾功能 eGFR检测值(ml/min)
    public String getDPD_1_1_2_1() {  return this.DPD_1_1_2_1;}
    @JsonProperty("DPD-1-1-2-1")
    public void setDPD_1_1_2_1(final String DPD_1_1_2_1) { this.DPD_1_1_2_1=DPD_1_1_2_1;}
    @Column(name = "DPD_1_1_2_2")
    @JsonProperty("DPD-1-1-2-2")
    private String DPD_1_1_2_2; // 血肌酐水平 SCr检测值(umol/L)
    public String getDPD_1_1_2_2() {  return this.DPD_1_1_2_2;}
    @JsonProperty("DPD-1-1-2-2")
    public void setDPD_1_1_2_2(final String DPD_1_1_2_2) { this.DPD_1_1_2_2=DPD_1_1_2_2;}
    @Column(name = "DPD_1_1_2_3")
    @JsonProperty("DPD-1-1-2-3")
    private String DPD_1_1_2_3; // 血尿素氮水平 BUN检测值(mmol/L)
    public String getDPD_1_1_2_3() {  return this.DPD_1_1_2_3;}
    @JsonProperty("DPD-1-1-2-3")
    public void setDPD_1_1_2_3(final String DPD_1_1_2_3) { this.DPD_1_1_2_3=DPD_1_1_2_3;}
    @Column(name = "DPD_0_3_1")
    @JsonProperty("DPD-0-3-1")
    private String DPD_0_3_1; // 患者状态
    public String getDPD_0_3_1() {  return this.DPD_0_3_1;}
    @JsonProperty("DPD-0-3-1")
    public void setDPD_0_3_1(final String DPD_0_3_1) { this.DPD_0_3_1=DPD_0_3_1;}
    @Column(name = "DPD_0_3_1_1")
    @JsonProperty("DPD-0-3-1-1")
    private String DPD_0_3_1_1; // 患者其他状态
    public String getDPD_0_3_1_1() {  return this.DPD_0_3_1_1;}
    @JsonProperty("DPD-0-3-1-1")
    public void setDPD_0_3_1_1(final String DPD_0_3_1_1) { this.DPD_0_3_1_1=DPD_0_3_1_1;}
    @Column(name = "DPD_0_3_2")
    @JsonProperty("DPD-0-3-2")
    private String DPD_0_3_2; // 转归日期
    public String getDPD_0_3_2() {  return this.DPD_0_3_2;}
    @JsonProperty("DPD-0-3-2")
    public void setDPD_0_3_2(final String DPD_0_3_2) { this.DPD_0_3_2=DPD_0_3_2;}
    @Column(name = "DPD_0_3_3_r")
    @JsonProperty("DPD-0-3-3-r")
    private String DPD_0_3_3_r; // 腹膜透析治疗时间（天）
    public String getDPD_0_3_3_r() {  return this.DPD_0_3_3_r;}
    @JsonProperty("DPD-0-3-3-r")
    public void setDPD_0_3_3_r(final String DPD_0_3_3_r) { this.DPD_0_3_3_r=DPD_0_3_3_r;}
    @Column(name = "DPD_0_3_4_r")
    @JsonProperty("DPD-0-3-4-r")
    private String DPD_0_3_4_r; // 腹膜透析治疗时间（月）
    public String getDPD_0_3_4_r() {  return this.DPD_0_3_4_r;}
    @JsonProperty("DPD-0-3-4-r")
    public void setDPD_0_3_4_r(final String DPD_0_3_4_r) { this.DPD_0_3_4_r=DPD_0_3_4_r;}
    @Column(name = "DPD_0_3_3")
    @JsonProperty("DPD-0-3-3")
    private String DPD_0_3_3; // 腹膜透析治疗时间（月）
    public String getDPD_0_3_3() {  return this.DPD_0_3_3;}
    @JsonProperty("DPD-0-3-3")
    public void setDPD_0_3_3(final String DPD_0_3_3) { this.DPD_0_3_3=DPD_0_3_3;}
    @Column(name = "DPD_0_4_1")
    @JsonProperty("DPD-0-4-1")
    private String DPD_0_4_1; // 原发病诊断时间
    public String getDPD_0_4_1() {  return this.DPD_0_4_1;}
    @JsonProperty("DPD-0-4-1")
    public void setDPD_0_4_1(final String DPD_0_4_1) { this.DPD_0_4_1=DPD_0_4_1;}
    @Column(name = "DPD_0_4_2")
    @JsonProperty("DPD-0-4-2")
    private String DPD_0_4_2; // 原发病诊断
    public String getDPD_0_4_2() {  return this.DPD_0_4_2;}
    @JsonProperty("DPD-0-4-2")
    public void setDPD_0_4_2(final String DPD_0_4_2) { this.DPD_0_4_2=DPD_0_4_2;}
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    public String getCM_0_3_1() {  return this.CM_0_3_1;}
    @JsonProperty("CM-0-3-1")
    public void setCM_0_3_1(final String CM_0_3_1) { this.CM_0_3_1=CM_0_3_1;}
    @Column(name = "DPD_1_1_1_1")
    @JsonProperty("DPD-1-1-1-1")
    private String DPD_1_1_1_1; // 一月份腹膜透析治疗室消毒合格情况
    public String getDPD_1_1_1_1() {  return this.DPD_1_1_1_1;}
    @JsonProperty("DPD-1-1-1-1")
    public void setDPD_1_1_1_1(final String DPD_1_1_1_1) { this.DPD_1_1_1_1=DPD_1_1_1_1;}
    @Column(name = "DPD_1_1_1_2")
    @JsonProperty("DPD-1-1-1-2")
    private String DPD_1_1_1_2; // 二月份腹膜透析治疗室消毒合格情况
    public String getDPD_1_1_1_2() {  return this.DPD_1_1_1_2;}
    @JsonProperty("DPD-1-1-1-2")
    public void setDPD_1_1_1_2(final String DPD_1_1_1_2) { this.DPD_1_1_1_2=DPD_1_1_1_2;}
    @Column(name = "DPD_1_1_1_3")
    @JsonProperty("DPD-1-1-1-3")
    private String DPD_1_1_1_3; // 三月份腹膜透析治疗室消毒合格情况
    public String getDPD_1_1_1_3() {  return this.DPD_1_1_1_3;}
    @JsonProperty("DPD-1-1-1-3")
    public void setDPD_1_1_1_3(final String DPD_1_1_1_3) { this.DPD_1_1_1_3=DPD_1_1_1_3;}
    @Column(name = "DPD_1_2_1_1")
    @JsonProperty("DPD-1-2-1-1")
    private String DPD_1_2_1_1; // 1季度/随访日期
    public String getDPD_1_2_1_1() {  return this.DPD_1_2_1_1;}
    @JsonProperty("DPD-1-2-1-1")
    public void setDPD_1_2_1_1(final String DPD_1_2_1_1) { this.DPD_1_2_1_1=DPD_1_2_1_1;}
    @Column(name = "DPD_1_2_1_2")
    @JsonProperty("DPD-1-2-1-2")
    private String DPD_1_2_1_2; // 1季度/腹透液种类
    public String getDPD_1_2_1_2() {  return this.DPD_1_2_1_2;}
    @JsonProperty("DPD-1-2-1-2")
    public void setDPD_1_2_1_2(final String DPD_1_2_1_2) { this.DPD_1_2_1_2=DPD_1_2_1_2;}
    @Column(name = "DPD_1_2_1_3")
    @JsonProperty("DPD-1-2-1-3")
    private String DPD_1_2_1_3; // 1季度/腹膜透析模式
    public String getDPD_1_2_1_3() {  return this.DPD_1_2_1_3;}
    @JsonProperty("DPD-1-2-1-3")
    public void setDPD_1_2_1_3(final String DPD_1_2_1_3) { this.DPD_1_2_1_3=DPD_1_2_1_3;}
    @Column(name = "DPD_1_2_2_1")
    @JsonProperty("DPD-1-2-2-1")
    private String DPD_1_2_2_1; // 1季度/血常规检验完成情况
    public String getDPD_1_2_2_1() {  return this.DPD_1_2_2_1;}
    @JsonProperty("DPD-1-2-2-1")
    public void setDPD_1_2_2_1(final String DPD_1_2_2_1) { this.DPD_1_2_2_1=DPD_1_2_2_1;}
    @Column(name = "DPD_1_2_2_2")
    @JsonProperty("DPD-1-2-2-2")
    private String DPD_1_2_2_2; // 血常规检验完成日期
    public String getDPD_1_2_2_2() {  return this.DPD_1_2_2_2;}
    @JsonProperty("DPD-1-2-2-2")
    public void setDPD_1_2_2_2(final String DPD_1_2_2_2) { this.DPD_1_2_2_2=DPD_1_2_2_2;}
    @Column(name = "DPD_1_2_2_3")
    @JsonProperty("DPD-1-2-2-3")
    private String DPD_1_2_2_3; // 1季度/血生化检验完成情况
    public String getDPD_1_2_2_3() {  return this.DPD_1_2_2_3;}
    @JsonProperty("DPD-1-2-2-3")
    public void setDPD_1_2_2_3(final String DPD_1_2_2_3) { this.DPD_1_2_2_3=DPD_1_2_2_3;}
    @Column(name = "DPD_1_2_2_4")
    @JsonProperty("DPD-1-2-2-4")
    private String DPD_1_2_2_4; // 血生化检验完成日期
    public String getDPD_1_2_2_4() {  return this.DPD_1_2_2_4;}
    @JsonProperty("DPD-1-2-2-4")
    public void setDPD_1_2_2_4(final String DPD_1_2_2_4) { this.DPD_1_2_2_4=DPD_1_2_2_4;}
    @Column(name = "DPD_1_3_1_2")
    @JsonProperty("DPD-1-3-1-2")
    private String DPD_1_3_1_2; // 血压SBP
    public String getDPD_1_3_1_2() {  return this.DPD_1_3_1_2;}
    @JsonProperty("DPD-1-3-1-2")
    public void setDPD_1_3_1_2(final String DPD_1_3_1_2) { this.DPD_1_3_1_2=DPD_1_3_1_2;}
    @Column(name = "DPD_1_3_1_3")
    @JsonProperty("DPD-1-3-1-3")
    private String DPD_1_3_1_3; // 血压DBP
    public String getDPD_1_3_1_3() {  return this.DPD_1_3_1_3;}
    @JsonProperty("DPD-1-3-1-3")
    public void setDPD_1_3_1_3(final String DPD_1_3_1_3) { this.DPD_1_3_1_3=DPD_1_3_1_3;}
    @Column(name = "DPD_1_3_1_4")
    @JsonProperty("DPD-1-3-1-4")
    private String DPD_1_3_1_4; // 项目完成日期
    public String getDPD_1_3_1_4() {  return this.DPD_1_3_1_4;}
    @JsonProperty("DPD-1-3-1-4")
    public void setDPD_1_3_1_4(final String DPD_1_3_1_4) { this.DPD_1_3_1_4=DPD_1_3_1_4;}
    @Column(name = "DPD_1_3_1_5")
    @JsonProperty("DPD-1-3-1-5")
    private String DPD_1_3_1_5; // 高血压是否达标
    public String getDPD_1_3_1_5() {  return this.DPD_1_3_1_5;}
    @JsonProperty("DPD-1-3-1-5")
    public void setDPD_1_3_1_5(final String DPD_1_3_1_5) { this.DPD_1_3_1_5=DPD_1_3_1_5;}
    @Column(name = "DPD_1_3_2_1")
    @JsonProperty("DPD-1-3-2-1")
    private String DPD_1_3_2_1; // 是否有抗高血压药治疗医嘱
    public String getDPD_1_3_2_1() {  return this.DPD_1_3_2_1;}
    @JsonProperty("DPD-1-3-2-1")
    public void setDPD_1_3_2_1(final String DPD_1_3_2_1) { this.DPD_1_3_2_1=DPD_1_3_2_1;}
    @Column(name = "DPD_1_3_2_2")
    @JsonProperty("DPD-1-3-2-2")
    private String DPD_1_3_2_2; // 抗高血压药治疗医嘱起始日期
    public String getDPD_1_3_2_2() {  return this.DPD_1_3_2_2;}
    @JsonProperty("DPD-1-3-2-2")
    public void setDPD_1_3_2_2(final String DPD_1_3_2_2) { this.DPD_1_3_2_2=DPD_1_3_2_2;}
    @Column(name = "DPD_1_3_2_3")
    @JsonProperty("DPD-1-3-2-3")
    private String DPD_1_3_2_3; // 抗高血压药
    public String getDPD_1_3_2_3() {  return this.DPD_1_3_2_3;}
    @JsonProperty("DPD-1-3-2-3")
    public void setDPD_1_3_2_3(final String DPD_1_3_2_3) { this.DPD_1_3_2_3=DPD_1_3_2_3;}
    @Column(name = "DPD_1_3_2_4")
    @JsonProperty("DPD-1-3-2-4")
    private String DPD_1_3_2_4; // 其他抗高血压药
    public String getDPD_1_3_2_4() {  return this.DPD_1_3_2_4;}
    @JsonProperty("DPD-1-3-2-4")
    public void setDPD_1_3_2_4(final String DPD_1_3_2_4) { this.DPD_1_3_2_4=DPD_1_3_2_4;}
    @Column(name = "DPD_1_4_1_1")
    @JsonProperty("DPD-1-4-1-1")
    private String DPD_1_4_1_1; // 血红蛋白
    public String getDPD_1_4_1_1() {  return this.DPD_1_4_1_1;}
    @JsonProperty("DPD-1-4-1-1")
    public void setDPD_1_4_1_1(final String DPD_1_4_1_1) { this.DPD_1_4_1_1=DPD_1_4_1_1;}
    @Column(name = "DPD_1_4_1_2")
    @JsonProperty("DPD-1-4-1-2")
    private String DPD_1_4_1_2; // 血红蛋白检测值(g/L )
    public String getDPD_1_4_1_2() {  return this.DPD_1_4_1_2;}
    @JsonProperty("DPD-1-4-1-2")
    public void setDPD_1_4_1_2(final String DPD_1_4_1_2) { this.DPD_1_4_1_2=DPD_1_4_1_2;}
    @Column(name = "DPD_1_4_1_3")
    @JsonProperty("DPD-1-4-1-3")
    private String DPD_1_4_1_3; // 项目完成日期
    public String getDPD_1_4_1_3() {  return this.DPD_1_4_1_3;}
    @JsonProperty("DPD-1-4-1-3")
    public void setDPD_1_4_1_3(final String DPD_1_4_1_3) { this.DPD_1_4_1_3=DPD_1_4_1_3;}
    @Column(name = "DPD_1_4_1_4")
    @JsonProperty("DPD-1-4-1-4")
    private String DPD_1_4_1_4; // 血红蛋白是否达标
    public String getDPD_1_4_1_4() {  return this.DPD_1_4_1_4;}
    @JsonProperty("DPD-1-4-1-4")
    public void setDPD_1_4_1_4(final String DPD_1_4_1_4) { this.DPD_1_4_1_4=DPD_1_4_1_4;}
    @Column(name = "DPD_1_4_2_1")
    @JsonProperty("DPD-1-4-2-1")
    private String DPD_1_4_2_1; // 是否有ESA治疗医嘱
    public String getDPD_1_4_2_1() {  return this.DPD_1_4_2_1;}
    @JsonProperty("DPD-1-4-2-1")
    public void setDPD_1_4_2_1(final String DPD_1_4_2_1) { this.DPD_1_4_2_1=DPD_1_4_2_1;}
    @Column(name = "DPD_1_4_2_2")
    @JsonProperty("DPD-1-4-2-2")
    private String DPD_1_4_2_2; // ESA治疗医嘱起始日期
    public String getDPD_1_4_2_2() {  return this.DPD_1_4_2_2;}
    @JsonProperty("DPD-1-4-2-2")
    public void setDPD_1_4_2_2(final String DPD_1_4_2_2) { this.DPD_1_4_2_2=DPD_1_4_2_2;}
    @Column(name = "DPD_1_4_2_3")
    @JsonProperty("DPD-1-4-2-3")
    private String DPD_1_4_2_3; // ESA治疗药物
    public String getDPD_1_4_2_3() {  return this.DPD_1_4_2_3;}
    @JsonProperty("DPD-1-4-2-3")
    public void setDPD_1_4_2_3(final String DPD_1_4_2_3) { this.DPD_1_4_2_3=DPD_1_4_2_3;}
    @Column(name = "DPD_1_4_2_4")
    @JsonProperty("DPD-1-4-2-4")
    private String DPD_1_4_2_4; // ESA治疗其他药物
    public String getDPD_1_4_2_4() {  return this.DPD_1_4_2_4;}
    @JsonProperty("DPD-1-4-2-4")
    public void setDPD_1_4_2_4(final String DPD_1_4_2_4) { this.DPD_1_4_2_4=DPD_1_4_2_4;}
    @Column(name = "DPD_1_4_3_1")
    @JsonProperty("DPD-1-4-3-1")
    private String DPD_1_4_3_1; // 是否有铁剂治疗医嘱
    public String getDPD_1_4_3_1() {  return this.DPD_1_4_3_1;}
    @JsonProperty("DPD-1-4-3-1")
    public void setDPD_1_4_3_1(final String DPD_1_4_3_1) { this.DPD_1_4_3_1=DPD_1_4_3_1;}
    @Column(name = "DPD_1_4_3_2")
    @JsonProperty("DPD-1-4-3-2")
    private String DPD_1_4_3_2; // 铁剂治疗医嘱起始日期
    public String getDPD_1_4_3_2() {  return this.DPD_1_4_3_2;}
    @JsonProperty("DPD-1-4-3-2")
    public void setDPD_1_4_3_2(final String DPD_1_4_3_2) { this.DPD_1_4_3_2=DPD_1_4_3_2;}
    @Column(name = "DPD_1_4_3_3")
    @JsonProperty("DPD-1-4-3-3")
    private String DPD_1_4_3_3; // 铁剂治疗选择
    public String getDPD_1_4_3_3() {  return this.DPD_1_4_3_3;}
    @JsonProperty("DPD-1-4-3-3")
    public void setDPD_1_4_3_3(final String DPD_1_4_3_3) { this.DPD_1_4_3_3=DPD_1_4_3_3;}
    @Column(name = "DPD_1_4_3_4")
    @JsonProperty("DPD-1-4-3-4")
    private String DPD_1_4_3_4; // 口服铁剂治疗药物
    public String getDPD_1_4_3_4() {  return this.DPD_1_4_3_4;}
    @JsonProperty("DPD-1-4-3-4")
    public void setDPD_1_4_3_4(final String DPD_1_4_3_4) { this.DPD_1_4_3_4=DPD_1_4_3_4;}
    @Column(name = "DPD_1_4_3_5")
    @JsonProperty("DPD-1-4-3-5")
    private String DPD_1_4_3_5; // 口服铁剂治疗其他药物
    public String getDPD_1_4_3_5() {  return this.DPD_1_4_3_5;}
    @JsonProperty("DPD-1-4-3-5")
    public void setDPD_1_4_3_5(final String DPD_1_4_3_5) { this.DPD_1_4_3_5=DPD_1_4_3_5;}
    @Column(name = "DPD_1_4_3_6")
    @JsonProperty("DPD-1-4-3-6")
    private String DPD_1_4_3_6; // 静脉铁剂治疗药物
    public String getDPD_1_4_3_6() {  return this.DPD_1_4_3_6;}
    @JsonProperty("DPD-1-4-3-6")
    public void setDPD_1_4_3_6(final String DPD_1_4_3_6) { this.DPD_1_4_3_6=DPD_1_4_3_6;}
    @Column(name = "DPD_1_4_3_7")
    @JsonProperty("DPD-1-4-3-7")
    private String DPD_1_4_3_7; // 静脉铁剂治疗其他药物
    public String getDPD_1_4_3_7() {  return this.DPD_1_4_3_7;}
    @JsonProperty("DPD-1-4-3-7")
    public void setDPD_1_4_3_7(final String DPD_1_4_3_7) { this.DPD_1_4_3_7=DPD_1_4_3_7;}
    @Column(name = "DPD_1_6_1_1")
    @JsonProperty("DPD-1-6-1-1")
    private String DPD_1_6_1_1; // 血清白蛋白
    public String getDPD_1_6_1_1() {  return this.DPD_1_6_1_1;}
    @JsonProperty("DPD-1-6-1-1")
    public void setDPD_1_6_1_1(final String DPD_1_6_1_1) { this.DPD_1_6_1_1=DPD_1_6_1_1;}
    @Column(name = "DPD_1_6_1_2")
    @JsonProperty("DPD-1-6-1-2")
    private String DPD_1_6_1_2; // 血清白蛋白检测值(g/L )
    public String getDPD_1_6_1_2() {  return this.DPD_1_6_1_2;}
    @JsonProperty("DPD-1-6-1-2")
    public void setDPD_1_6_1_2(final String DPD_1_6_1_2) { this.DPD_1_6_1_2=DPD_1_6_1_2;}
    @Column(name = "DPD_1_6_1_3")
    @JsonProperty("DPD-1-6-1-3")
    private String DPD_1_6_1_3; // 项目完成日期
    public String getDPD_1_6_1_3() {  return this.DPD_1_6_1_3;}
    @JsonProperty("DPD-1-6-1-3")
    public void setDPD_1_6_1_3(final String DPD_1_6_1_3) { this.DPD_1_6_1_3=DPD_1_6_1_3;}
    @Column(name = "DPD_1_6_1_4")
    @JsonProperty("DPD-1-6-1-4")
    private String DPD_1_6_1_4; // 血清白蛋白是否达标
    public String getDPD_1_6_1_4() {  return this.DPD_1_6_1_4;}
    @JsonProperty("DPD-1-6-1-4")
    public void setDPD_1_6_1_4(final String DPD_1_6_1_4) { this.DPD_1_6_1_4=DPD_1_6_1_4;}
    @Column(name = "DPD_1_6_2_1")
    @JsonProperty("DPD-1-6-2-1")
    private String DPD_1_6_2_1; // 是否有营养支持药物治疗医嘱
    public String getDPD_1_6_2_1() {  return this.DPD_1_6_2_1;}
    @JsonProperty("DPD-1-6-2-1")
    public void setDPD_1_6_2_1(final String DPD_1_6_2_1) { this.DPD_1_6_2_1=DPD_1_6_2_1;}
    @Column(name = "DPD_1_6_2_2")
    @JsonProperty("DPD-1-6-2-2")
    private String DPD_1_6_2_2; // 营养支持药物治疗医嘱起始日期
    public String getDPD_1_6_2_2() {  return this.DPD_1_6_2_2;}
    @JsonProperty("DPD-1-6-2-2")
    public void setDPD_1_6_2_2(final String DPD_1_6_2_2) { this.DPD_1_6_2_2=DPD_1_6_2_2;}
    @Column(name = "DPD_1_6_2_3")
    @JsonProperty("DPD-1-6-2-3")
    private String DPD_1_6_2_3; // 营养支持药物
    public String getDPD_1_6_2_3() {  return this.DPD_1_6_2_3;}
    @JsonProperty("DPD-1-6-2-3")
    public void setDPD_1_6_2_3(final String DPD_1_6_2_3) { this.DPD_1_6_2_3=DPD_1_6_2_3;}
    @Column(name = "DPD_1_6_2_4")
    @JsonProperty("DPD-1-6-2-4")
    private String DPD_1_6_2_4; // 其他营养支持药物
    public String getDPD_1_6_2_4() {  return this.DPD_1_6_2_4;}
    @JsonProperty("DPD-1-6-2-4")
    public void setDPD_1_6_2_4(final String DPD_1_6_2_4) { this.DPD_1_6_2_4=DPD_1_6_2_4;}
    @Column(name = "DPD_1_8_1_1")
    @JsonProperty("DPD-1-8-1-1")
    private String DPD_1_8_1_1; // 是否有腹膜炎
    public String getDPD_1_8_1_1() {  return this.DPD_1_8_1_1;}
    @JsonProperty("DPD-1-8-1-1")
    public void setDPD_1_8_1_1(final String DPD_1_8_1_1) { this.DPD_1_8_1_1=DPD_1_8_1_1;}
    @Column(name = "DPD_1_8_1_2")
    @JsonProperty("DPD-1-8-1-2")
    private String DPD_1_8_1_2; // 报告的日期
    public String getDPD_1_8_1_2() {  return this.DPD_1_8_1_2;}
    @JsonProperty("DPD-1-8-1-2")
    public void setDPD_1_8_1_2(final String DPD_1_8_1_2) { this.DPD_1_8_1_2=DPD_1_8_1_2;}
    @Column(name = "DPD_1_8_1_3")
    @JsonProperty("DPD-1-8-1-3")
    private String DPD_1_8_1_3; // 感染类型
    public String getDPD_1_8_1_3() {  return this.DPD_1_8_1_3;}
    @JsonProperty("DPD-1-8-1-3")
    public void setDPD_1_8_1_3(final String DPD_1_8_1_3) { this.DPD_1_8_1_3=DPD_1_8_1_3;}
    @Column(name = "DPD_1_8_1_4")
    @JsonProperty("DPD-1-8-1-4")
    private String DPD_1_8_1_4; // 病原检出
    public String getDPD_1_8_1_4() {  return this.DPD_1_8_1_4;}
    @JsonProperty("DPD-1-8-1-4")
    public void setDPD_1_8_1_4(final String DPD_1_8_1_4) { this.DPD_1_8_1_4=DPD_1_8_1_4;}
    @Column(name = "DPD_1_8_1_5")
    @JsonProperty("DPD-1-8-1-5")
    private String DPD_1_8_1_5; // 培养结果
    public String getDPD_1_8_1_5() {  return this.DPD_1_8_1_5;}
    @JsonProperty("DPD-1-8-1-5")
    public void setDPD_1_8_1_5(final String DPD_1_8_1_5) { this.DPD_1_8_1_5=DPD_1_8_1_5;}
    @Column(name = "DPD_1_8_2_1")
    @JsonProperty("DPD-1-8-2-1")
    private String DPD_1_8_2_1; // 腹膜炎患者透析龄(月)
    public String getDPD_1_8_2_1() {  return this.DPD_1_8_2_1;}
    @JsonProperty("DPD-1-8-2-1")
    public void setDPD_1_8_2_1(final String DPD_1_8_2_1) { this.DPD_1_8_2_1=DPD_1_8_2_1;}
    @Column(name = "DPD_1_8_2_2")
    @JsonProperty("DPD-1-8-2-2")
    private String DPD_1_8_2_2; // 腹膜炎患者透析次数(次)
    public String getDPD_1_8_2_2() {  return this.DPD_1_8_2_2;}
    @JsonProperty("DPD-1-8-2-2")
    public void setDPD_1_8_2_2(final String DPD_1_8_2_2) { this.DPD_1_8_2_2=DPD_1_8_2_2;}
    @Column(name = "DPD_1_8_2_3_r")
    @JsonProperty("DPD-1-8-2-3-r")
    private String DPD_1_8_2_3_r; // 患者腹膜炎次数（月/次）
    public String getDPD_1_8_2_3_r() {  return this.DPD_1_8_2_3_r;}
    @JsonProperty("DPD-1-8-2-3-r")
    public void setDPD_1_8_2_3_r(final String DPD_1_8_2_3_r) { this.DPD_1_8_2_3_r=DPD_1_8_2_3_r;}
    @Column(name = "DPD_1_8_2_3")
    @JsonProperty("DPD-1-8-2-3")
    private String DPD_1_8_2_3; // 患者腹膜炎次数（月/次）
    public String getDPD_1_8_2_3() {  return this.DPD_1_8_2_3;}
    @JsonProperty("DPD-1-8-2-3")
    public void setDPD_1_8_2_3(final String DPD_1_8_2_3) { this.DPD_1_8_2_3=DPD_1_8_2_3;}
    @Column(name = "DPD_2_1_2_1")
    @JsonProperty("DPD-2-1-2-1")
    private String DPD_2_1_2_1; // 四月份腹膜透析治疗室消毒合格情况
    public String getDPD_2_1_2_1() {  return this.DPD_2_1_2_1;}
    @JsonProperty("DPD-2-1-2-1")
    public void setDPD_2_1_2_1(final String DPD_2_1_2_1) { this.DPD_2_1_2_1=DPD_2_1_2_1;}
    @Column(name = "DPD_2_1_2_2")
    @JsonProperty("DPD-2-1-2-2")
    private String DPD_2_1_2_2; // 五月份腹膜透析治疗室消毒合格情况
    public String getDPD_2_1_2_2() {  return this.DPD_2_1_2_2;}
    @JsonProperty("DPD-2-1-2-2")
    public void setDPD_2_1_2_2(final String DPD_2_1_2_2) { this.DPD_2_1_2_2=DPD_2_1_2_2;}
    @Column(name = "DPD_2_1_2_3")
    @JsonProperty("DPD-2-1-2-3")
    private String DPD_2_1_2_3; // 六月份腹膜透析治疗室消毒合格情况
    public String getDPD_2_1_2_3() {  return this.DPD_2_1_2_3;}
    @JsonProperty("DPD-2-1-2-3")
    public void setDPD_2_1_2_3(final String DPD_2_1_2_3) { this.DPD_2_1_2_3=DPD_2_1_2_3;}
    @Column(name = "DPD_2_2_1_1")
    @JsonProperty("DPD-2-2-1-1")
    private String DPD_2_2_1_1; // 2季度/随访日期
    public String getDPD_2_2_1_1() {  return this.DPD_2_2_1_1;}
    @JsonProperty("DPD-2-2-1-1")
    public void setDPD_2_2_1_1(final String DPD_2_2_1_1) { this.DPD_2_2_1_1=DPD_2_2_1_1;}
    @Column(name = "DPD_2_2_1_2")
    @JsonProperty("DPD-2-2-1-2")
    private String DPD_2_2_1_2; // 2季度/透析液种类
    public String getDPD_2_2_1_2() {  return this.DPD_2_2_1_2;}
    @JsonProperty("DPD-2-2-1-2")
    public void setDPD_2_2_1_2(final String DPD_2_2_1_2) { this.DPD_2_2_1_2=DPD_2_2_1_2;}
    @Column(name = "DPD_2_2_1_3")
    @JsonProperty("DPD-2-2-1-3")
    private String DPD_2_2_1_3; // 2季度/腹透模式
    public String getDPD_2_2_1_3() {  return this.DPD_2_2_1_3;}
    @JsonProperty("DPD-2-2-1-3")
    public void setDPD_2_2_1_3(final String DPD_2_2_1_3) { this.DPD_2_2_1_3=DPD_2_2_1_3;}
    @Column(name = "DPD_2_2_2_1")
    @JsonProperty("DPD-2-2-2-1")
    private String DPD_2_2_2_1; // 腹膜平衡试验/上半年/标准平衡试验/转运类型
    public String getDPD_2_2_2_1() {  return this.DPD_2_2_2_1;}
    @JsonProperty("DPD-2-2-2-1")
    public void setDPD_2_2_2_1(final String DPD_2_2_2_1) { this.DPD_2_2_2_1=DPD_2_2_2_1;}
    @Column(name = "DPD_2_2_3_1")
    @JsonProperty("DPD-2-2-3-1")
    private String DPD_2_2_3_1; // 2季度/血常规检验完成情况
    public String getDPD_2_2_3_1() {  return this.DPD_2_2_3_1;}
    @JsonProperty("DPD-2-2-3-1")
    public void setDPD_2_2_3_1(final String DPD_2_2_3_1) { this.DPD_2_2_3_1=DPD_2_2_3_1;}
    @Column(name = "DPD_2_2_3_2")
    @JsonProperty("DPD-2-2-3-2")
    private String DPD_2_2_3_2; // 血常规检验完成日期
    public String getDPD_2_2_3_2() {  return this.DPD_2_2_3_2;}
    @JsonProperty("DPD-2-2-3-2")
    public void setDPD_2_2_3_2(final String DPD_2_2_3_2) { this.DPD_2_2_3_2=DPD_2_2_3_2;}
    @Column(name = "DPD_2_2_3_3")
    @JsonProperty("DPD-2-2-3-3")
    private String DPD_2_2_3_3; // 2季度/血生化检验完成情况
    public String getDPD_2_2_3_3() {  return this.DPD_2_2_3_3;}
    @JsonProperty("DPD-2-2-3-3")
    public void setDPD_2_2_3_3(final String DPD_2_2_3_3) { this.DPD_2_2_3_3=DPD_2_2_3_3;}
    @Column(name = "DPD_2_2_3_4")
    @JsonProperty("DPD-2-2-3-4")
    private String DPD_2_2_3_4; // 血生化检完成日期
    public String getDPD_2_2_3_4() {  return this.DPD_2_2_3_4;}
    @JsonProperty("DPD-2-2-3-4")
    public void setDPD_2_2_3_4(final String DPD_2_2_3_4) { this.DPD_2_2_3_4=DPD_2_2_3_4;}
    @Column(name = "DPD_2_2_3_5")
    @JsonProperty("DPD-2-2-3-5")
    private String DPD_2_2_3_5; // 2季度/前白蛋白检验完成情况
    public String getDPD_2_2_3_5() {  return this.DPD_2_2_3_5;}
    @JsonProperty("DPD-2-2-3-5")
    public void setDPD_2_2_3_5(final String DPD_2_2_3_5) { this.DPD_2_2_3_5=DPD_2_2_3_5;}
    @Column(name = "DPD_2_2_3_6")
    @JsonProperty("DPD-2-2-3-6")
    private String DPD_2_2_3_6; // 前白蛋白检验完成日期
    public String getDPD_2_2_3_6() {  return this.DPD_2_2_3_6;}
    @JsonProperty("DPD-2-2-3-6")
    public void setDPD_2_2_3_6(final String DPD_2_2_3_6) { this.DPD_2_2_3_6=DPD_2_2_3_6;}
    @Column(name = "DPD_2_2_3_7")
    @JsonProperty("DPD-2-2-3-7")
    private String DPD_2_2_3_7; // 2季度/β2微球蛋白检验完成情况
    public String getDPD_2_2_3_7() {  return this.DPD_2_2_3_7;}
    @JsonProperty("DPD-2-2-3-7")
    public void setDPD_2_2_3_7(final String DPD_2_2_3_7) { this.DPD_2_2_3_7=DPD_2_2_3_7;}
    @Column(name = "DPD_2_2_3_8")
    @JsonProperty("DPD-2-2-3-8")
    private String DPD_2_2_3_8; // β2微球蛋白检验完成日期
    public String getDPD_2_2_3_8() {  return this.DPD_2_2_3_8;}
    @JsonProperty("DPD-2-2-3-8")
    public void setDPD_2_2_3_8(final String DPD_2_2_3_8) { this.DPD_2_2_3_8=DPD_2_2_3_8;}
    @Column(name = "DPD_2_2_3_9")
    @JsonProperty("DPD-2-2-3-9")
    private String DPD_2_2_3_9; // 2季度/C反应蛋白检验完成情况
    public String getDPD_2_2_3_9() {  return this.DPD_2_2_3_9;}
    @JsonProperty("DPD-2-2-3-9")
    public void setDPD_2_2_3_9(final String DPD_2_2_3_9) { this.DPD_2_2_3_9=DPD_2_2_3_9;}
    @Column(name = "DPD_2_2_3_10")
    @JsonProperty("DPD-2-2-3-10")
    private String DPD_2_2_3_10; // C反应蛋白检验完成日期
    public String getDPD_2_2_3_10() {  return this.DPD_2_2_3_10;}
    @JsonProperty("DPD-2-2-3-10")
    public void setDPD_2_2_3_10(final String DPD_2_2_3_10) { this.DPD_2_2_3_10=DPD_2_2_3_10;}
    @Column(name = "DPD_2_2_3_11")
    @JsonProperty("DPD-2-2-3-11")
    private String DPD_2_2_3_11; // 2季度/血清铁蛋白检验完成情况
    public String getDPD_2_2_3_11() {  return this.DPD_2_2_3_11;}
    @JsonProperty("DPD-2-2-3-11")
    public void setDPD_2_2_3_11(final String DPD_2_2_3_11) { this.DPD_2_2_3_11=DPD_2_2_3_11;}
    @Column(name = "DPD_2_2_3_12")
    @JsonProperty("DPD-2-2-3-12")
    private String DPD_2_2_3_12; // 血清铁蛋白检验完成日期
    public String getDPD_2_2_3_12() {  return this.DPD_2_2_3_12;}
    @JsonProperty("DPD-2-2-3-12")
    public void setDPD_2_2_3_12(final String DPD_2_2_3_12) { this.DPD_2_2_3_12=DPD_2_2_3_12;}
    @Column(name = "DPD_2_2_3_13")
    @JsonProperty("DPD-2-2-3-13")
    private String DPD_2_2_3_13; // 2季度/转铁蛋白饱和度检验完成情况
    public String getDPD_2_2_3_13() {  return this.DPD_2_2_3_13;}
    @JsonProperty("DPD-2-2-3-13")
    public void setDPD_2_2_3_13(final String DPD_2_2_3_13) { this.DPD_2_2_3_13=DPD_2_2_3_13;}
    @Column(name = "DPD_2_2_3_14")
    @JsonProperty("DPD-2-2-3-14")
    private String DPD_2_2_3_14; // 转铁蛋白饱和度检验完成日期
    public String getDPD_2_2_3_14() {  return this.DPD_2_2_3_14;}
    @JsonProperty("DPD-2-2-3-14")
    public void setDPD_2_2_3_14(final String DPD_2_2_3_14) { this.DPD_2_2_3_14=DPD_2_2_3_14;}
    @Column(name = "DPD_2_3_1_2")
    @JsonProperty("DPD-2-3-1-2")
    private String DPD_2_3_1_2; // 血压SBP
    public String getDPD_2_3_1_2() {  return this.DPD_2_3_1_2;}
    @JsonProperty("DPD-2-3-1-2")
    public void setDPD_2_3_1_2(final String DPD_2_3_1_2) { this.DPD_2_3_1_2=DPD_2_3_1_2;}
    @Column(name = "DPD_2_3_1_3")
    @JsonProperty("DPD-2-3-1-3")
    private String DPD_2_3_1_3; // 血压DBP
    public String getDPD_2_3_1_3() {  return this.DPD_2_3_1_3;}
    @JsonProperty("DPD-2-3-1-3")
    public void setDPD_2_3_1_3(final String DPD_2_3_1_3) { this.DPD_2_3_1_3=DPD_2_3_1_3;}
    @Column(name = "DPD_2_3_1_4")
    @JsonProperty("DPD-2-3-1-4")
    private String DPD_2_3_1_4; // 项目完成日期
    public String getDPD_2_3_1_4() {  return this.DPD_2_3_1_4;}
    @JsonProperty("DPD-2-3-1-4")
    public void setDPD_2_3_1_4(final String DPD_2_3_1_4) { this.DPD_2_3_1_4=DPD_2_3_1_4;}
    @Column(name = "DPD_2_3_1_5")
    @JsonProperty("DPD-2-3-1-5")
    private String DPD_2_3_1_5; // 高血压是否达标
    public String getDPD_2_3_1_5() {  return this.DPD_2_3_1_5;}
    @JsonProperty("DPD-2-3-1-5")
    public void setDPD_2_3_1_5(final String DPD_2_3_1_5) { this.DPD_2_3_1_5=DPD_2_3_1_5;}
    @Column(name = "DPD_2_3_2_1")
    @JsonProperty("DPD-2-3-2-1")
    private String DPD_2_3_2_1; // 是否有抗高血压药治疗医嘱
    public String getDPD_2_3_2_1() {  return this.DPD_2_3_2_1;}
    @JsonProperty("DPD-2-3-2-1")
    public void setDPD_2_3_2_1(final String DPD_2_3_2_1) { this.DPD_2_3_2_1=DPD_2_3_2_1;}
    @Column(name = "DPD_2_3_2_2")
    @JsonProperty("DPD-2-3-2-2")
    private String DPD_2_3_2_2; // 抗高血压药治疗医嘱起始日期
    public String getDPD_2_3_2_2() {  return this.DPD_2_3_2_2;}
    @JsonProperty("DPD-2-3-2-2")
    public void setDPD_2_3_2_2(final String DPD_2_3_2_2) { this.DPD_2_3_2_2=DPD_2_3_2_2;}
    @Column(name = "DPD_2_3_2_3")
    @JsonProperty("DPD-2-3-2-3")
    private String DPD_2_3_2_3; // 抗高血压药
    public String getDPD_2_3_2_3() {  return this.DPD_2_3_2_3;}
    @JsonProperty("DPD-2-3-2-3")
    public void setDPD_2_3_2_3(final String DPD_2_3_2_3) { this.DPD_2_3_2_3=DPD_2_3_2_3;}
    @Column(name = "DPD_2_3_2_4")
    @JsonProperty("DPD-2-3-2-4")
    private String DPD_2_3_2_4; // 其他抗高血压药
    public String getDPD_2_3_2_4() {  return this.DPD_2_3_2_4;}
    @JsonProperty("DPD-2-3-2-4")
    public void setDPD_2_3_2_4(final String DPD_2_3_2_4) { this.DPD_2_3_2_4=DPD_2_3_2_4;}
    @Column(name = "DPD_2_4_1_1")
    @JsonProperty("DPD-2-4-1-1")
    private String DPD_2_4_1_1; // 血红蛋白
    public String getDPD_2_4_1_1() {  return this.DPD_2_4_1_1;}
    @JsonProperty("DPD-2-4-1-1")
    public void setDPD_2_4_1_1(final String DPD_2_4_1_1) { this.DPD_2_4_1_1=DPD_2_4_1_1;}
    @Column(name = "DPD_2_4_1_2")
    @JsonProperty("DPD-2-4-1-2")
    private String DPD_2_4_1_2; // 血红蛋白检测值(g/L )
    public String getDPD_2_4_1_2() {  return this.DPD_2_4_1_2;}
    @JsonProperty("DPD-2-4-1-2")
    public void setDPD_2_4_1_2(final String DPD_2_4_1_2) { this.DPD_2_4_1_2=DPD_2_4_1_2;}
    @Column(name = "DPD_2_4_1_3")
    @JsonProperty("DPD-2-4-1-3")
    private String DPD_2_4_1_3; // 项目完成日期
    public String getDPD_2_4_1_3() {  return this.DPD_2_4_1_3;}
    @JsonProperty("DPD-2-4-1-3")
    public void setDPD_2_4_1_3(final String DPD_2_4_1_3) { this.DPD_2_4_1_3=DPD_2_4_1_3;}
    @Column(name = "DPD_2_4_1_4")
    @JsonProperty("DPD-2-4-1-4")
    private String DPD_2_4_1_4; // 血红蛋白是否达标
    public String getDPD_2_4_1_4() {  return this.DPD_2_4_1_4;}
    @JsonProperty("DPD-2-4-1-4")
    public void setDPD_2_4_1_4(final String DPD_2_4_1_4) { this.DPD_2_4_1_4=DPD_2_4_1_4;}
    @Column(name = "DPD_2_4_2_1")
    @JsonProperty("DPD-2-4-2-1")
    private String DPD_2_4_2_1; // 是否有ESA治疗医嘱
    public String getDPD_2_4_2_1() {  return this.DPD_2_4_2_1;}
    @JsonProperty("DPD-2-4-2-1")
    public void setDPD_2_4_2_1(final String DPD_2_4_2_1) { this.DPD_2_4_2_1=DPD_2_4_2_1;}
    @Column(name = "DPD_2_4_2_2")
    @JsonProperty("DPD-2-4-2-2")
    private String DPD_2_4_2_2; // ESA治疗医嘱起始日期
    public String getDPD_2_4_2_2() {  return this.DPD_2_4_2_2;}
    @JsonProperty("DPD-2-4-2-2")
    public void setDPD_2_4_2_2(final String DPD_2_4_2_2) { this.DPD_2_4_2_2=DPD_2_4_2_2;}
    @Column(name = "DPD_2_4_2_3")
    @JsonProperty("DPD-2-4-2-3")
    private String DPD_2_4_2_3; // ESA治疗药物
    public String getDPD_2_4_2_3() {  return this.DPD_2_4_2_3;}
    @JsonProperty("DPD-2-4-2-3")
    public void setDPD_2_4_2_3(final String DPD_2_4_2_3) { this.DPD_2_4_2_3=DPD_2_4_2_3;}
    @Column(name = "DPD_2_4_2_4")
    @JsonProperty("DPD-2-4-2-4")
    private String DPD_2_4_2_4; // ESA治疗其他药物
    public String getDPD_2_4_2_4() {  return this.DPD_2_4_2_4;}
    @JsonProperty("DPD-2-4-2-4")
    public void setDPD_2_4_2_4(final String DPD_2_4_2_4) { this.DPD_2_4_2_4=DPD_2_4_2_4;}
    @Column(name = "DPD_2_4_3_1")
    @JsonProperty("DPD-2-4-3-1")
    private String DPD_2_4_3_1; // 是否有铁剂治疗医嘱
    public String getDPD_2_4_3_1() {  return this.DPD_2_4_3_1;}
    @JsonProperty("DPD-2-4-3-1")
    public void setDPD_2_4_3_1(final String DPD_2_4_3_1) { this.DPD_2_4_3_1=DPD_2_4_3_1;}
    @Column(name = "DPD_2_4_3_2")
    @JsonProperty("DPD-2-4-3-2")
    private String DPD_2_4_3_2; // 铁剂治疗医嘱起始日期
    public String getDPD_2_4_3_2() {  return this.DPD_2_4_3_2;}
    @JsonProperty("DPD-2-4-3-2")
    public void setDPD_2_4_3_2(final String DPD_2_4_3_2) { this.DPD_2_4_3_2=DPD_2_4_3_2;}
    @Column(name = "DPD_2_4_3_3")
    @JsonProperty("DPD-2-4-3-3")
    private String DPD_2_4_3_3; // 铁剂治疗选择
    public String getDPD_2_4_3_3() {  return this.DPD_2_4_3_3;}
    @JsonProperty("DPD-2-4-3-3")
    public void setDPD_2_4_3_3(final String DPD_2_4_3_3) { this.DPD_2_4_3_3=DPD_2_4_3_3;}
    @Column(name = "DPD_2_4_3_4")
    @JsonProperty("DPD-2-4-3-4")
    private String DPD_2_4_3_4; // 口服铁剂治疗药物
    public String getDPD_2_4_3_4() {  return this.DPD_2_4_3_4;}
    @JsonProperty("DPD-2-4-3-4")
    public void setDPD_2_4_3_4(final String DPD_2_4_3_4) { this.DPD_2_4_3_4=DPD_2_4_3_4;}
    @Column(name = "DPD_2_4_3_5")
    @JsonProperty("DPD-2-4-3-5")
    private String DPD_2_4_3_5; // 口服铁剂治疗其他药物
    public String getDPD_2_4_3_5() {  return this.DPD_2_4_3_5;}
    @JsonProperty("DPD-2-4-3-5")
    public void setDPD_2_4_3_5(final String DPD_2_4_3_5) { this.DPD_2_4_3_5=DPD_2_4_3_5;}
    @Column(name = "DPD_2_4_3_6")
    @JsonProperty("DPD-2-4-3-6")
    private String DPD_2_4_3_6; // 静脉铁剂治疗药物
    public String getDPD_2_4_3_6() {  return this.DPD_2_4_3_6;}
    @JsonProperty("DPD-2-4-3-6")
    public void setDPD_2_4_3_6(final String DPD_2_4_3_6) { this.DPD_2_4_3_6=DPD_2_4_3_6;}
    @Column(name = "DPD_2_4_3_7")
    @JsonProperty("DPD-2-4-3-7")
    private String DPD_2_4_3_7; // 静脉铁剂治疗其他药物
    public String getDPD_2_4_3_7() {  return this.DPD_2_4_3_7;}
    @JsonProperty("DPD-2-4-3-7")
    public void setDPD_2_4_3_7(final String DPD_2_4_3_7) { this.DPD_2_4_3_7=DPD_2_4_3_7;}
    @Column(name = "DPD_2_5_1_1")
    @JsonProperty("DPD-2-5-1-1")
    private String DPD_2_5_1_1; // 检验情况
    public String getDPD_2_5_1_1() {  return this.DPD_2_5_1_1;}
    @JsonProperty("DPD-2-5-1-1")
    public void setDPD_2_5_1_1(final String DPD_2_5_1_1) { this.DPD_2_5_1_1=DPD_2_5_1_1;}
    @Column(name = "DPD_2_5_1_2")
    @JsonProperty("DPD-2-5-1-2")
    private String DPD_2_5_1_2; // 血总钙检测值(mmol/L)
    public String getDPD_2_5_1_2() {  return this.DPD_2_5_1_2;}
    @JsonProperty("DPD-2-5-1-2")
    public void setDPD_2_5_1_2(final String DPD_2_5_1_2) { this.DPD_2_5_1_2=DPD_2_5_1_2;}
    @Column(name = "DPD_2_5_1_3")
    @JsonProperty("DPD-2-5-1-3")
    private String DPD_2_5_1_3; // 血磷检测值(mmol/L)
    public String getDPD_2_5_1_3() {  return this.DPD_2_5_1_3;}
    @JsonProperty("DPD-2-5-1-3")
    public void setDPD_2_5_1_3(final String DPD_2_5_1_3) { this.DPD_2_5_1_3=DPD_2_5_1_3;}
    @Column(name = "DPD_2_5_1_4")
    @JsonProperty("DPD-2-5-1-4")
    private String DPD_2_5_1_4; // IPTH检测值(pg/ml)
    public String getDPD_2_5_1_4() {  return this.DPD_2_5_1_4;}
    @JsonProperty("DPD-2-5-1-4")
    public void setDPD_2_5_1_4(final String DPD_2_5_1_4) { this.DPD_2_5_1_4=DPD_2_5_1_4;}
    @Column(name = "DPD_2_5_1_5")
    @JsonProperty("DPD-2-5-1-5")
    private String DPD_2_5_1_5; // 项目完成日期
    public String getDPD_2_5_1_5() {  return this.DPD_2_5_1_5;}
    @JsonProperty("DPD-2-5-1-5")
    public void setDPD_2_5_1_5(final String DPD_2_5_1_5) { this.DPD_2_5_1_5=DPD_2_5_1_5;}
    @Column(name = "DPD_2_5_1_6")
    @JsonProperty("DPD-2-5-1-6")
    private String DPD_2_5_1_6; // 血总钙是否达标
    public String getDPD_2_5_1_6() {  return this.DPD_2_5_1_6;}
    @JsonProperty("DPD-2-5-1-6")
    public void setDPD_2_5_1_6(final String DPD_2_5_1_6) { this.DPD_2_5_1_6=DPD_2_5_1_6;}
    @Column(name = "DPD_2_5_1_7")
    @JsonProperty("DPD-2-5-1-7")
    private String DPD_2_5_1_7; // 血磷是否达标
    public String getDPD_2_5_1_7() {  return this.DPD_2_5_1_7;}
    @JsonProperty("DPD-2-5-1-7")
    public void setDPD_2_5_1_7(final String DPD_2_5_1_7) { this.DPD_2_5_1_7=DPD_2_5_1_7;}
    @Column(name = "DPD_2_5_1_8")
    @JsonProperty("DPD-2-5-1-8")
    private String DPD_2_5_1_8; // 全段甲状旁腺激素（IPTH）是否达标
    public String getDPD_2_5_1_8() {  return this.DPD_2_5_1_8;}
    @JsonProperty("DPD-2-5-1-8")
    public void setDPD_2_5_1_8(final String DPD_2_5_1_8) { this.DPD_2_5_1_8=DPD_2_5_1_8;}
    @Column(name = "DPD_2_5_2_1")
    @JsonProperty("DPD-2-5-2-1")
    private String DPD_2_5_2_1; // 是否有MBD干预药治疗医嘱
    public String getDPD_2_5_2_1() {  return this.DPD_2_5_2_1;}
    @JsonProperty("DPD-2-5-2-1")
    public void setDPD_2_5_2_1(final String DPD_2_5_2_1) { this.DPD_2_5_2_1=DPD_2_5_2_1;}
    @Column(name = "DPD_2_5_2_2")
    @JsonProperty("DPD-2-5-2-2")
    private String DPD_2_5_2_2; // MBD干预药治疗医嘱起始日期
    public String getDPD_2_5_2_2() {  return this.DPD_2_5_2_2;}
    @JsonProperty("DPD-2-5-2-2")
    public void setDPD_2_5_2_2(final String DPD_2_5_2_2) { this.DPD_2_5_2_2=DPD_2_5_2_2;}
    @Column(name = "DPD_2_5_2_3")
    @JsonProperty("DPD-2-5-2-3")
    private String DPD_2_5_2_3; // MBD干预药选择
    public String getDPD_2_5_2_3() {  return this.DPD_2_5_2_3;}
    @JsonProperty("DPD-2-5-2-3")
    public void setDPD_2_5_2_3(final String DPD_2_5_2_3) { this.DPD_2_5_2_3=DPD_2_5_2_3;}
    @Column(name = "DPD_2_5_2_4")
    @JsonProperty("DPD-2-5-2-4")
    private String DPD_2_5_2_4; // MBD干预药_维生素D及衍生物
    public String getDPD_2_5_2_4() {  return this.DPD_2_5_2_4;}
    @JsonProperty("DPD-2-5-2-4")
    public void setDPD_2_5_2_4(final String DPD_2_5_2_4) { this.DPD_2_5_2_4=DPD_2_5_2_4;}
    @Column(name = "DPD_2_5_2_5")
    @JsonProperty("DPD-2-5-2-5")
    private String DPD_2_5_2_5; // 其他维生素D及衍生物
    public String getDPD_2_5_2_5() {  return this.DPD_2_5_2_5;}
    @JsonProperty("DPD-2-5-2-5")
    public void setDPD_2_5_2_5(final String DPD_2_5_2_5) { this.DPD_2_5_2_5=DPD_2_5_2_5;}
    @Column(name = "DPD_2_5_2_6")
    @JsonProperty("DPD-2-5-2-6")
    private String DPD_2_5_2_6; // MBD干预药_含钙的磷结合剂
    public String getDPD_2_5_2_6() {  return this.DPD_2_5_2_6;}
    @JsonProperty("DPD-2-5-2-6")
    public void setDPD_2_5_2_6(final String DPD_2_5_2_6) { this.DPD_2_5_2_6=DPD_2_5_2_6;}
    @Column(name = "DPD_2_5_2_7")
    @JsonProperty("DPD-2-5-2-7")
    private String DPD_2_5_2_7; // 其他含钙的磷结合剂
    public String getDPD_2_5_2_7() {  return this.DPD_2_5_2_7;}
    @JsonProperty("DPD-2-5-2-7")
    public void setDPD_2_5_2_7(final String DPD_2_5_2_7) { this.DPD_2_5_2_7=DPD_2_5_2_7;}
    @Column(name = "DPD_2_5_2_8")
    @JsonProperty("DPD-2-5-2-8")
    private String DPD_2_5_2_8; // MBD干预药_含铝的磷结合剂
    public String getDPD_2_5_2_8() {  return this.DPD_2_5_2_8;}
    @JsonProperty("DPD-2-5-2-8")
    public void setDPD_2_5_2_8(final String DPD_2_5_2_8) { this.DPD_2_5_2_8=DPD_2_5_2_8;}
    @Column(name = "DPD_2_5_2_9")
    @JsonProperty("DPD-2-5-2-9")
    private String DPD_2_5_2_9; // 其他含铝的磷结合剂
    public String getDPD_2_5_2_9() {  return this.DPD_2_5_2_9;}
    @JsonProperty("DPD-2-5-2-9")
    public void setDPD_2_5_2_9(final String DPD_2_5_2_9) { this.DPD_2_5_2_9=DPD_2_5_2_9;}
    @Column(name = "DPD_2_5_2_10")
    @JsonProperty("DPD-2-5-2-10")
    private String DPD_2_5_2_10; // MBD干预药_不含钙铝的磷结合剂
    public String getDPD_2_5_2_10() {  return this.DPD_2_5_2_10;}
    @JsonProperty("DPD-2-5-2-10")
    public void setDPD_2_5_2_10(final String DPD_2_5_2_10) { this.DPD_2_5_2_10=DPD_2_5_2_10;}
    @Column(name = "DPD_2_5_2_11")
    @JsonProperty("DPD-2-5-2-11")
    private String DPD_2_5_2_11; // 其他不含钙铝的磷结合剂
    public String getDPD_2_5_2_11() {  return this.DPD_2_5_2_11;}
    @JsonProperty("DPD-2-5-2-11")
    public void setDPD_2_5_2_11(final String DPD_2_5_2_11) { this.DPD_2_5_2_11=DPD_2_5_2_11;}
    @Column(name = "DPD_2_5_2_12")
    @JsonProperty("DPD-2-5-2-12")
    private String DPD_2_5_2_12; // MBD干预药_拟钙剂
    public String getDPD_2_5_2_12() {  return this.DPD_2_5_2_12;}
    @JsonProperty("DPD-2-5-2-12")
    public void setDPD_2_5_2_12(final String DPD_2_5_2_12) { this.DPD_2_5_2_12=DPD_2_5_2_12;}
    @Column(name = "DPD_2_5_2_13")
    @JsonProperty("DPD-2-5-2-13")
    private String DPD_2_5_2_13; // 其他拟钙剂
    public String getDPD_2_5_2_13() {  return this.DPD_2_5_2_13;}
    @JsonProperty("DPD-2-5-2-13")
    public void setDPD_2_5_2_13(final String DPD_2_5_2_13) { this.DPD_2_5_2_13=DPD_2_5_2_13;}
    @Column(name = "DPD_2_6_1_1")
    @JsonProperty("DPD-2-6-1-1")
    private String DPD_2_6_1_1; // 血清白蛋白
    public String getDPD_2_6_1_1() {  return this.DPD_2_6_1_1;}
    @JsonProperty("DPD-2-6-1-1")
    public void setDPD_2_6_1_1(final String DPD_2_6_1_1) { this.DPD_2_6_1_1=DPD_2_6_1_1;}
    @Column(name = "DPD_2_6_1_2")
    @JsonProperty("DPD-2-6-1-2")
    private String DPD_2_6_1_2; // 血清白蛋白检测值(g/L )
    public String getDPD_2_6_1_2() {  return this.DPD_2_6_1_2;}
    @JsonProperty("DPD-2-6-1-2")
    public void setDPD_2_6_1_2(final String DPD_2_6_1_2) { this.DPD_2_6_1_2=DPD_2_6_1_2;}
    @Column(name = "DPD_2_6_1_3")
    @JsonProperty("DPD-2-6-1-3")
    private String DPD_2_6_1_3; // 项目完成日期
    public String getDPD_2_6_1_3() {  return this.DPD_2_6_1_3;}
    @JsonProperty("DPD-2-6-1-3")
    public void setDPD_2_6_1_3(final String DPD_2_6_1_3) { this.DPD_2_6_1_3=DPD_2_6_1_3;}
    @Column(name = "DPD_2_6_1_4")
    @JsonProperty("DPD-2-6-1-4")
    private String DPD_2_6_1_4; // 血清白蛋白是否达标
    public String getDPD_2_6_1_4() {  return this.DPD_2_6_1_4;}
    @JsonProperty("DPD-2-6-1-4")
    public void setDPD_2_6_1_4(final String DPD_2_6_1_4) { this.DPD_2_6_1_4=DPD_2_6_1_4;}
    @Column(name = "DPD_2_6_2_1")
    @JsonProperty("DPD-2-6-2-1")
    private String DPD_2_6_2_1; // 是否有营养支持药物治疗医嘱
    public String getDPD_2_6_2_1() {  return this.DPD_2_6_2_1;}
    @JsonProperty("DPD-2-6-2-1")
    public void setDPD_2_6_2_1(final String DPD_2_6_2_1) { this.DPD_2_6_2_1=DPD_2_6_2_1;}
    @Column(name = "DPD_2_6_2_2")
    @JsonProperty("DPD-2-6-2-2")
    private String DPD_2_6_2_2; // 营养支持药物治疗医嘱起始日期
    public String getDPD_2_6_2_2() {  return this.DPD_2_6_2_2;}
    @JsonProperty("DPD-2-6-2-2")
    public void setDPD_2_6_2_2(final String DPD_2_6_2_2) { this.DPD_2_6_2_2=DPD_2_6_2_2;}
    @Column(name = "DPD_2_6_2_3")
    @JsonProperty("DPD-2-6-2-3")
    private String DPD_2_6_2_3; // 营养支持药物
    public String getDPD_2_6_2_3() {  return this.DPD_2_6_2_3;}
    @JsonProperty("DPD-2-6-2-3")
    public void setDPD_2_6_2_3(final String DPD_2_6_2_3) { this.DPD_2_6_2_3=DPD_2_6_2_3;}
    @Column(name = "DPD_2_6_2_4")
    @JsonProperty("DPD-2-6-2-4")
    private String DPD_2_6_2_4; // 其他营养支持药物
    public String getDPD_2_6_2_4() {  return this.DPD_2_6_2_4;}
    @JsonProperty("DPD-2-6-2-4")
    public void setDPD_2_6_2_4(final String DPD_2_6_2_4) { this.DPD_2_6_2_4=DPD_2_6_2_4;}
    @Column(name = "DPD_2_7_1_2")
    @JsonProperty("DPD-2-7-1-2")
    private String DPD_2_7_1_2; // 身高(cm)
    public String getDPD_2_7_1_2() {  return this.DPD_2_7_1_2;}
    @JsonProperty("DPD-2-7-1-2")
    public void setDPD_2_7_1_2(final String DPD_2_7_1_2) { this.DPD_2_7_1_2=DPD_2_7_1_2;}
    @Column(name = "DPD_2_7_1_1_r")
    @JsonProperty("DPD-2-7-1-1-r")
    private String DPD_2_7_1_1_r; // 身高转换
    public String getDPD_2_7_1_1_r() {  return this.DPD_2_7_1_1_r;}
    @JsonProperty("DPD-2-7-1-1-r")
    public void setDPD_2_7_1_1_r(final String DPD_2_7_1_1_r) { this.DPD_2_7_1_1_r=DPD_2_7_1_1_r;}
    @Column(name = "DPD_2_7_1_3")
    @JsonProperty("DPD-2-7-1-3")
    private String DPD_2_7_1_3; // 体重(kg)
    public String getDPD_2_7_1_3() {  return this.DPD_2_7_1_3;}
    @JsonProperty("DPD-2-7-1-3")
    public void setDPD_2_7_1_3(final String DPD_2_7_1_3) { this.DPD_2_7_1_3=DPD_2_7_1_3;}
    @Column(name = "DPD_2_7_1_3_r")
    @JsonProperty("DPD-2-7-1-3-r")
    private String DPD_2_7_1_3_r; // 体重指数(BMI)
    public String getDPD_2_7_1_3_r() {  return this.DPD_2_7_1_3_r;}
    @JsonProperty("DPD-2-7-1-3-r")
    public void setDPD_2_7_1_3_r(final String DPD_2_7_1_3_r) { this.DPD_2_7_1_3_r=DPD_2_7_1_3_r;}
    @Column(name = "DPD_2_7_1_4")
    @JsonProperty("DPD-2-7-1-4")
    private String DPD_2_7_1_4; // 体重指数(BMI)
    public String getDPD_2_7_1_4() {  return this.DPD_2_7_1_4;}
    @JsonProperty("DPD-2-7-1-4")
    public void setDPD_2_7_1_4(final String DPD_2_7_1_4) { this.DPD_2_7_1_4=DPD_2_7_1_4;}
    @Column(name = "DPD_2_7_1_4_r")
    @JsonProperty("DPD-2-7-1-4-r")
    private String DPD_2_7_1_4_r; // 0.0061倍身高(cm)
    public String getDPD_2_7_1_4_r() {  return this.DPD_2_7_1_4_r;}
    @JsonProperty("DPD-2-7-1-4-r")
    public void setDPD_2_7_1_4_r(final String DPD_2_7_1_4_r) { this.DPD_2_7_1_4_r=DPD_2_7_1_4_r;}
    @Column(name = "DPD_2_7_1_5_r")
    @JsonProperty("DPD-2-7-1-5-r")
    private String DPD_2_7_1_5_r; // 0.0128倍体重(kg)
    public String getDPD_2_7_1_5_r() {  return this.DPD_2_7_1_5_r;}
    @JsonProperty("DPD-2-7-1-5-r")
    public void setDPD_2_7_1_5_r(final String DPD_2_7_1_5_r) { this.DPD_2_7_1_5_r=DPD_2_7_1_5_r;}
    @Column(name = "DPD_2_7_1_6_r")
    @JsonProperty("DPD-2-7-1-6-r")
    private String DPD_2_7_1_6_r; // 体表面积公式
    public String getDPD_2_7_1_6_r() {  return this.DPD_2_7_1_6_r;}
    @JsonProperty("DPD-2-7-1-6-r")
    public void setDPD_2_7_1_6_r(final String DPD_2_7_1_6_r) { this.DPD_2_7_1_6_r=DPD_2_7_1_6_r;}
    @Column(name = "DPD_2_7_1_7_r")
    @JsonProperty("DPD-2-7-1-7-r")
    private String DPD_2_7_1_7_r; // 体表面积(m²)
    public String getDPD_2_7_1_7_r() {  return this.DPD_2_7_1_7_r;}
    @JsonProperty("DPD-2-7-1-7-r")
    public void setDPD_2_7_1_7_r(final String DPD_2_7_1_7_r) { this.DPD_2_7_1_7_r=DPD_2_7_1_7_r;}
    @Column(name = "DPD_2_7_1_5")
    @JsonProperty("DPD-2-7-1-5")
    private String DPD_2_7_1_5; // 体表面积(m²)
    public String getDPD_2_7_1_5() {  return this.DPD_2_7_1_5;}
    @JsonProperty("DPD-2-7-1-5")
    public void setDPD_2_7_1_5(final String DPD_2_7_1_5) { this.DPD_2_7_1_5=DPD_2_7_1_5;}
    @Column(name = "DPD_2_7_1_6")
    @JsonProperty("DPD-2-7-1-6")
    private String DPD_2_7_1_6; // 总体水(V)
    public String getDPD_2_7_1_6() {  return this.DPD_2_7_1_6;}
    @JsonProperty("DPD-2-7-1-6")
    public void setDPD_2_7_1_6(final String DPD_2_7_1_6) { this.DPD_2_7_1_6=DPD_2_7_1_6;}
    @Column(name = "DPD_2_7_1_7")
    @JsonProperty("DPD-2-7-1-7")
    private String DPD_2_7_1_7; // 血尿素氮(mmoL/L)
    public String getDPD_2_7_1_7() {  return this.DPD_2_7_1_7;}
    @JsonProperty("DPD-2-7-1-7")
    public void setDPD_2_7_1_7(final String DPD_2_7_1_7) { this.DPD_2_7_1_7=DPD_2_7_1_7;}
    @Column(name = "DPD_2_7_1_8")
    @JsonProperty("DPD-2-7-1-8")
    private String DPD_2_7_1_8; // 血肌酐(μmoL/L)
    public String getDPD_2_7_1_8() {  return this.DPD_2_7_1_8;}
    @JsonProperty("DPD-2-7-1-8")
    public void setDPD_2_7_1_8(final String DPD_2_7_1_8) { this.DPD_2_7_1_8=DPD_2_7_1_8;}
    @Column(name = "DPD_2_7_1_9")
    @JsonProperty("DPD-2-7-1-9")
    private String DPD_2_7_1_9; // 24小时尿量(L)
    public String getDPD_2_7_1_9() {  return this.DPD_2_7_1_9;}
    @JsonProperty("DPD-2-7-1-9")
    public void setDPD_2_7_1_9(final String DPD_2_7_1_9) { this.DPD_2_7_1_9=DPD_2_7_1_9;}
    @Column(name = "DPD_2_7_1_10")
    @JsonProperty("DPD-2-7-1-10")
    private String DPD_2_7_1_10; // 24小时尿中尿素氮(mmoL/L)
    public String getDPD_2_7_1_10() {  return this.DPD_2_7_1_10;}
    @JsonProperty("DPD-2-7-1-10")
    public void setDPD_2_7_1_10(final String DPD_2_7_1_10) { this.DPD_2_7_1_10=DPD_2_7_1_10;}
    @Column(name = "DPD_2_7_1_11")
    @JsonProperty("DPD-2-7-1-11")
    private String DPD_2_7_1_11; // 24小时尿肌酐(μmoL/L)
    public String getDPD_2_7_1_11() {  return this.DPD_2_7_1_11;}
    @JsonProperty("DPD-2-7-1-11")
    public void setDPD_2_7_1_11(final String DPD_2_7_1_11) { this.DPD_2_7_1_11=DPD_2_7_1_11;}
    @Column(name = "DPD_2_7_1_12")
    @JsonProperty("DPD-2-7-1-12")
    private String DPD_2_7_1_12; // 24小时腹透液排出总量(L)
    public String getDPD_2_7_1_12() {  return this.DPD_2_7_1_12;}
    @JsonProperty("DPD-2-7-1-12")
    public void setDPD_2_7_1_12(final String DPD_2_7_1_12) { this.DPD_2_7_1_12=DPD_2_7_1_12;}
    @Column(name = "DPD_2_7_1_13")
    @JsonProperty("DPD-2-7-1-13")
    private String DPD_2_7_1_13; // 24小时透出液尿素氮(mmoL/L)
    public String getDPD_2_7_1_13() {  return this.DPD_2_7_1_13;}
    @JsonProperty("DPD-2-7-1-13")
    public void setDPD_2_7_1_13(final String DPD_2_7_1_13) { this.DPD_2_7_1_13=DPD_2_7_1_13;}
    @Column(name = "DPD_2_7_1_14")
    @JsonProperty("DPD-2-7-1-14")
    private String DPD_2_7_1_14; // 24小时透出液肌酐(μmoL/L)
    public String getDPD_2_7_1_14() {  return this.DPD_2_7_1_14;}
    @JsonProperty("DPD-2-7-1-14")
    public void setDPD_2_7_1_14(final String DPD_2_7_1_14) { this.DPD_2_7_1_14=DPD_2_7_1_14;}
    @Column(name = "DPD_2_7_1_18")
    @JsonProperty("DPD-2-7-1-18")
    private String DPD_2_7_1_18; // 每周透析天数(天)
    public String getDPD_2_7_1_18() {  return this.DPD_2_7_1_18;}
    @JsonProperty("DPD-2-7-1-18")
    public void setDPD_2_7_1_18(final String DPD_2_7_1_18) { this.DPD_2_7_1_18=DPD_2_7_1_18;}
    @Column(name = "DPD_2_7_1_15")
    @JsonProperty("DPD-2-7-1-15")
    private String DPD_2_7_1_15; // 每周总Kt/V尿素清除指数
    public String getDPD_2_7_1_15() {  return this.DPD_2_7_1_15;}
    @JsonProperty("DPD-2-7-1-15")
    public void setDPD_2_7_1_15(final String DPD_2_7_1_15) { this.DPD_2_7_1_15=DPD_2_7_1_15;}
    @Column(name = "DPD_2_7_1_16")
    @JsonProperty("DPD-2-7-1-16")
    private String DPD_2_7_1_16; // 总内生肌酐清除率（Ccr）
    public String getDPD_2_7_1_16() {  return this.DPD_2_7_1_16;}
    @JsonProperty("DPD-2-7-1-16")
    public void setDPD_2_7_1_16(final String DPD_2_7_1_16) { this.DPD_2_7_1_16=DPD_2_7_1_16;}
    @Column(name = "DPD_2_7_1_17")
    @JsonProperty("DPD-2-7-1-17")
    private String DPD_2_7_1_17; // 完成日期
    public String getDPD_2_7_1_17() {  return this.DPD_2_7_1_17;}
    @JsonProperty("DPD-2-7-1-17")
    public void setDPD_2_7_1_17(final String DPD_2_7_1_17) { this.DPD_2_7_1_17=DPD_2_7_1_17;}
    @Column(name = "DPD_2_7_2_1")
    @JsonProperty("DPD-2-7-2-1")
    private String DPD_2_7_2_1; // 尿素清除指数 总ktv是否达标
    public String getDPD_2_7_2_1() {  return this.DPD_2_7_2_1;}
    @JsonProperty("DPD-2-7-2-1")
    public void setDPD_2_7_2_1(final String DPD_2_7_2_1) { this.DPD_2_7_2_1=DPD_2_7_2_1;}
    @Column(name = "DPD_2_7_2_2")
    @JsonProperty("DPD-2-7-2-2")
    private String DPD_2_7_2_2; // 总内生肌酐清除率 总ccr是否达标
    public String getDPD_2_7_2_2() {  return this.DPD_2_7_2_2;}
    @JsonProperty("DPD-2-7-2-2")
    public void setDPD_2_7_2_2(final String DPD_2_7_2_2) { this.DPD_2_7_2_2=DPD_2_7_2_2;}
    @Column(name = "DPD_2_8_1_1")
    @JsonProperty("DPD-2-8-1-1")
    private String DPD_2_8_1_1; // 是否有腹膜炎
    public String getDPD_2_8_1_1() {  return this.DPD_2_8_1_1;}
    @JsonProperty("DPD-2-8-1-1")
    public void setDPD_2_8_1_1(final String DPD_2_8_1_1) { this.DPD_2_8_1_1=DPD_2_8_1_1;}
    @Column(name = "DPD_2_8_1_2")
    @JsonProperty("DPD-2-8-1-2")
    private String DPD_2_8_1_2; // 报告的日期
    public String getDPD_2_8_1_2() {  return this.DPD_2_8_1_2;}
    @JsonProperty("DPD-2-8-1-2")
    public void setDPD_2_8_1_2(final String DPD_2_8_1_2) { this.DPD_2_8_1_2=DPD_2_8_1_2;}
    @Column(name = "DPD_2_8_1_3")
    @JsonProperty("DPD-2-8-1-3")
    private String DPD_2_8_1_3; // 感染类型
    public String getDPD_2_8_1_3() {  return this.DPD_2_8_1_3;}
    @JsonProperty("DPD-2-8-1-3")
    public void setDPD_2_8_1_3(final String DPD_2_8_1_3) { this.DPD_2_8_1_3=DPD_2_8_1_3;}
    @Column(name = "DPD_2_8_1_4")
    @JsonProperty("DPD-2-8-1-4")
    private String DPD_2_8_1_4; // 病原检出
    public String getDPD_2_8_1_4() {  return this.DPD_2_8_1_4;}
    @JsonProperty("DPD-2-8-1-4")
    public void setDPD_2_8_1_4(final String DPD_2_8_1_4) { this.DPD_2_8_1_4=DPD_2_8_1_4;}
    @Column(name = "DPD_2_8_1_5")
    @JsonProperty("DPD-2-8-1-5")
    private String DPD_2_8_1_5; // 培养结果
    public String getDPD_2_8_1_5() {  return this.DPD_2_8_1_5;}
    @JsonProperty("DPD-2-8-1-5")
    public void setDPD_2_8_1_5(final String DPD_2_8_1_5) { this.DPD_2_8_1_5=DPD_2_8_1_5;}
    @Column(name = "DPD_2_8_2_1")
    @JsonProperty("DPD-2-8-2-1")
    private String DPD_2_8_2_1; // 腹膜炎患者透析龄(月)
    public String getDPD_2_8_2_1() {  return this.DPD_2_8_2_1;}
    @JsonProperty("DPD-2-8-2-1")
    public void setDPD_2_8_2_1(final String DPD_2_8_2_1) { this.DPD_2_8_2_1=DPD_2_8_2_1;}
    @Column(name = "DPD_2_8_2_2")
    @JsonProperty("DPD-2-8-2-2")
    private String DPD_2_8_2_2; // 腹膜炎患者透析次数(次)
    public String getDPD_2_8_2_2() {  return this.DPD_2_8_2_2;}
    @JsonProperty("DPD-2-8-2-2")
    public void setDPD_2_8_2_2(final String DPD_2_8_2_2) { this.DPD_2_8_2_2=DPD_2_8_2_2;}
    @Column(name = "DPD_2_8_2_3_r")
    @JsonProperty("DPD-2-8-2-3-r")
    private String DPD_2_8_2_3_r; // 患者腹膜炎次数（月/次）
    public String getDPD_2_8_2_3_r() {  return this.DPD_2_8_2_3_r;}
    @JsonProperty("DPD-2-8-2-3-r")
    public void setDPD_2_8_2_3_r(final String DPD_2_8_2_3_r) { this.DPD_2_8_2_3_r=DPD_2_8_2_3_r;}
    @Column(name = "DPD_2_8_2_3")
    @JsonProperty("DPD-2-8-2-3")
    private String DPD_2_8_2_3; // 患者腹膜炎次数（月/次）
    public String getDPD_2_8_2_3() {  return this.DPD_2_8_2_3;}
    @JsonProperty("DPD-2-8-2-3")
    public void setDPD_2_8_2_3(final String DPD_2_8_2_3) { this.DPD_2_8_2_3=DPD_2_8_2_3;}
    @Column(name = "DPD_3_1_2_1")
    @JsonProperty("DPD-3-1-2-1")
    private String DPD_3_1_2_1; // 七月份腹膜透析治疗室消毒合格情况
    public String getDPD_3_1_2_1() {  return this.DPD_3_1_2_1;}
    @JsonProperty("DPD-3-1-2-1")
    public void setDPD_3_1_2_1(final String DPD_3_1_2_1) { this.DPD_3_1_2_1=DPD_3_1_2_1;}
    @Column(name = "DPD_3_1_2_2")
    @JsonProperty("DPD-3-1-2-2")
    private String DPD_3_1_2_2; // 八月份腹膜透析治疗室消毒合格情况
    public String getDPD_3_1_2_2() {  return this.DPD_3_1_2_2;}
    @JsonProperty("DPD-3-1-2-2")
    public void setDPD_3_1_2_2(final String DPD_3_1_2_2) { this.DPD_3_1_2_2=DPD_3_1_2_2;}
    @Column(name = "DPD_3_1_2_3")
    @JsonProperty("DPD-3-1-2-3")
    private String DPD_3_1_2_3; // 九月份腹膜透析治疗室消毒合格情况
    public String getDPD_3_1_2_3() {  return this.DPD_3_1_2_3;}
    @JsonProperty("DPD-3-1-2-3")
    public void setDPD_3_1_2_3(final String DPD_3_1_2_3) { this.DPD_3_1_2_3=DPD_3_1_2_3;}
    @Column(name = "DPD_3_2_1_1")
    @JsonProperty("DPD-3-2-1-1")
    private String DPD_3_2_1_1; // 3季度/随访日期
    public String getDPD_3_2_1_1() {  return this.DPD_3_2_1_1;}
    @JsonProperty("DPD-3-2-1-1")
    public void setDPD_3_2_1_1(final String DPD_3_2_1_1) { this.DPD_3_2_1_1=DPD_3_2_1_1;}
    @Column(name = "DPD_3_2_1_2")
    @JsonProperty("DPD-3-2-1-2")
    private String DPD_3_2_1_2; // 3季度/腹透液种类
    public String getDPD_3_2_1_2() {  return this.DPD_3_2_1_2;}
    @JsonProperty("DPD-3-2-1-2")
    public void setDPD_3_2_1_2(final String DPD_3_2_1_2) { this.DPD_3_2_1_2=DPD_3_2_1_2;}
    @Column(name = "DPD_3_2_1_3")
    @JsonProperty("DPD-3-2-1-3")
    private String DPD_3_2_1_3; // 3季度/腹膜透析模式
    public String getDPD_3_2_1_3() {  return this.DPD_3_2_1_3;}
    @JsonProperty("DPD-3-2-1-3")
    public void setDPD_3_2_1_3(final String DPD_3_2_1_3) { this.DPD_3_2_1_3=DPD_3_2_1_3;}
    @Column(name = "DPD_3_2_2_1")
    @JsonProperty("DPD-3-2-2-1")
    private String DPD_3_2_2_1; // 3季度/血常规检验完成情况
    public String getDPD_3_2_2_1() {  return this.DPD_3_2_2_1;}
    @JsonProperty("DPD-3-2-2-1")
    public void setDPD_3_2_2_1(final String DPD_3_2_2_1) { this.DPD_3_2_2_1=DPD_3_2_2_1;}
    @Column(name = "DPD_3_2_2_2")
    @JsonProperty("DPD-3-2-2-2")
    private String DPD_3_2_2_2; // 血常规检验完成日期
    public String getDPD_3_2_2_2() {  return this.DPD_3_2_2_2;}
    @JsonProperty("DPD-3-2-2-2")
    public void setDPD_3_2_2_2(final String DPD_3_2_2_2) { this.DPD_3_2_2_2=DPD_3_2_2_2;}
    @Column(name = "DPD_3_2_2_3")
    @JsonProperty("DPD-3-2-2-3")
    private String DPD_3_2_2_3; // 3季度/血生化检验完成情况
    public String getDPD_3_2_2_3() {  return this.DPD_3_2_2_3;}
    @JsonProperty("DPD-3-2-2-3")
    public void setDPD_3_2_2_3(final String DPD_3_2_2_3) { this.DPD_3_2_2_3=DPD_3_2_2_3;}
    @Column(name = "DPD_3_2_2_4")
    @JsonProperty("DPD-3-2-2-4")
    private String DPD_3_2_2_4; // 血生化检验完成日期
    public String getDPD_3_2_2_4() {  return this.DPD_3_2_2_4;}
    @JsonProperty("DPD-3-2-2-4")
    public void setDPD_3_2_2_4(final String DPD_3_2_2_4) { this.DPD_3_2_2_4=DPD_3_2_2_4;}
    @Column(name = "DPD_3_3_1_2")
    @JsonProperty("DPD-3-3-1-2")
    private String DPD_3_3_1_2; // 血压SBP
    public String getDPD_3_3_1_2() {  return this.DPD_3_3_1_2;}
    @JsonProperty("DPD-3-3-1-2")
    public void setDPD_3_3_1_2(final String DPD_3_3_1_2) { this.DPD_3_3_1_2=DPD_3_3_1_2;}
    @Column(name = "DPD_3_3_1_3")
    @JsonProperty("DPD-3-3-1-3")
    private String DPD_3_3_1_3; // 血压DBP
    public String getDPD_3_3_1_3() {  return this.DPD_3_3_1_3;}
    @JsonProperty("DPD-3-3-1-3")
    public void setDPD_3_3_1_3(final String DPD_3_3_1_3) { this.DPD_3_3_1_3=DPD_3_3_1_3;}
    @Column(name = "DPD_3_3_1_4")
    @JsonProperty("DPD-3-3-1-4")
    private String DPD_3_3_1_4; // 项目完成日期
    public String getDPD_3_3_1_4() {  return this.DPD_3_3_1_4;}
    @JsonProperty("DPD-3-3-1-4")
    public void setDPD_3_3_1_4(final String DPD_3_3_1_4) { this.DPD_3_3_1_4=DPD_3_3_1_4;}
    @Column(name = "DPD_3_3_1_5")
    @JsonProperty("DPD-3-3-1-5")
    private String DPD_3_3_1_5; // 高血压是否达标
    public String getDPD_3_3_1_5() {  return this.DPD_3_3_1_5;}
    @JsonProperty("DPD-3-3-1-5")
    public void setDPD_3_3_1_5(final String DPD_3_3_1_5) { this.DPD_3_3_1_5=DPD_3_3_1_5;}
    @Column(name = "DPD_3_3_2_1")
    @JsonProperty("DPD-3-3-2-1")
    private String DPD_3_3_2_1; // 是否有抗高血压药治疗医嘱
    public String getDPD_3_3_2_1() {  return this.DPD_3_3_2_1;}
    @JsonProperty("DPD-3-3-2-1")
    public void setDPD_3_3_2_1(final String DPD_3_3_2_1) { this.DPD_3_3_2_1=DPD_3_3_2_1;}
    @Column(name = "DPD_3_3_2_2")
    @JsonProperty("DPD-3-3-2-2")
    private String DPD_3_3_2_2; // 抗高血压药治疗医嘱起始日期
    public String getDPD_3_3_2_2() {  return this.DPD_3_3_2_2;}
    @JsonProperty("DPD-3-3-2-2")
    public void setDPD_3_3_2_2(final String DPD_3_3_2_2) { this.DPD_3_3_2_2=DPD_3_3_2_2;}
    @Column(name = "DPD_3_3_2_3")
    @JsonProperty("DPD-3-3-2-3")
    private String DPD_3_3_2_3; // 抗高血压药
    public String getDPD_3_3_2_3() {  return this.DPD_3_3_2_3;}
    @JsonProperty("DPD-3-3-2-3")
    public void setDPD_3_3_2_3(final String DPD_3_3_2_3) { this.DPD_3_3_2_3=DPD_3_3_2_3;}
    @Column(name = "DPD_3_3_2_4")
    @JsonProperty("DPD-3-3-2-4")
    private String DPD_3_3_2_4; // 其他抗高血压药
    public String getDPD_3_3_2_4() {  return this.DPD_3_3_2_4;}
    @JsonProperty("DPD-3-3-2-4")
    public void setDPD_3_3_2_4(final String DPD_3_3_2_4) { this.DPD_3_3_2_4=DPD_3_3_2_4;}
    @Column(name = "DPD_3_4_1_1")
    @JsonProperty("DPD-3-4-1-1")
    private String DPD_3_4_1_1; // 血红蛋白
    public String getDPD_3_4_1_1() {  return this.DPD_3_4_1_1;}
    @JsonProperty("DPD-3-4-1-1")
    public void setDPD_3_4_1_1(final String DPD_3_4_1_1) { this.DPD_3_4_1_1=DPD_3_4_1_1;}
    @Column(name = "DPD_3_4_1_2")
    @JsonProperty("DPD-3-4-1-2")
    private String DPD_3_4_1_2; // 血红蛋白检测值(g/L )
    public String getDPD_3_4_1_2() {  return this.DPD_3_4_1_2;}
    @JsonProperty("DPD-3-4-1-2")
    public void setDPD_3_4_1_2(final String DPD_3_4_1_2) { this.DPD_3_4_1_2=DPD_3_4_1_2;}
    @Column(name = "DPD_3_4_1_3")
    @JsonProperty("DPD-3-4-1-3")
    private String DPD_3_4_1_3; // 项目完成日期
    public String getDPD_3_4_1_3() {  return this.DPD_3_4_1_3;}
    @JsonProperty("DPD-3-4-1-3")
    public void setDPD_3_4_1_3(final String DPD_3_4_1_3) { this.DPD_3_4_1_3=DPD_3_4_1_3;}
    @Column(name = "DPD_3_4_1_4")
    @JsonProperty("DPD-3-4-1-4")
    private String DPD_3_4_1_4; // 血红蛋白是否达标
    public String getDPD_3_4_1_4() {  return this.DPD_3_4_1_4;}
    @JsonProperty("DPD-3-4-1-4")
    public void setDPD_3_4_1_4(final String DPD_3_4_1_4) { this.DPD_3_4_1_4=DPD_3_4_1_4;}
    @Column(name = "DPD_3_4_2_1")
    @JsonProperty("DPD-3-4-2-1")
    private String DPD_3_4_2_1; // 是否有ESA治疗医嘱
    public String getDPD_3_4_2_1() {  return this.DPD_3_4_2_1;}
    @JsonProperty("DPD-3-4-2-1")
    public void setDPD_3_4_2_1(final String DPD_3_4_2_1) { this.DPD_3_4_2_1=DPD_3_4_2_1;}
    @Column(name = "DPD_3_4_2_2")
    @JsonProperty("DPD-3-4-2-2")
    private String DPD_3_4_2_2; // ESA治疗医嘱起始日期
    public String getDPD_3_4_2_2() {  return this.DPD_3_4_2_2;}
    @JsonProperty("DPD-3-4-2-2")
    public void setDPD_3_4_2_2(final String DPD_3_4_2_2) { this.DPD_3_4_2_2=DPD_3_4_2_2;}
    @Column(name = "DPD_3_4_2_3")
    @JsonProperty("DPD-3-4-2-3")
    private String DPD_3_4_2_3; // ESA治疗药物
    public String getDPD_3_4_2_3() {  return this.DPD_3_4_2_3;}
    @JsonProperty("DPD-3-4-2-3")
    public void setDPD_3_4_2_3(final String DPD_3_4_2_3) { this.DPD_3_4_2_3=DPD_3_4_2_3;}
    @Column(name = "DPD_3_4_2_4")
    @JsonProperty("DPD-3-4-2-4")
    private String DPD_3_4_2_4; // ESA治疗其他药物
    public String getDPD_3_4_2_4() {  return this.DPD_3_4_2_4;}
    @JsonProperty("DPD-3-4-2-4")
    public void setDPD_3_4_2_4(final String DPD_3_4_2_4) { this.DPD_3_4_2_4=DPD_3_4_2_4;}
    @Column(name = "DPD_3_4_3_1")
    @JsonProperty("DPD-3-4-3-1")
    private String DPD_3_4_3_1; // 是否有铁剂治疗医嘱
    public String getDPD_3_4_3_1() {  return this.DPD_3_4_3_1;}
    @JsonProperty("DPD-3-4-3-1")
    public void setDPD_3_4_3_1(final String DPD_3_4_3_1) { this.DPD_3_4_3_1=DPD_3_4_3_1;}
    @Column(name = "DPD_3_4_3_2")
    @JsonProperty("DPD-3-4-3-2")
    private String DPD_3_4_3_2; // 铁剂治疗医嘱起始日期
    public String getDPD_3_4_3_2() {  return this.DPD_3_4_3_2;}
    @JsonProperty("DPD-3-4-3-2")
    public void setDPD_3_4_3_2(final String DPD_3_4_3_2) { this.DPD_3_4_3_2=DPD_3_4_3_2;}
    @Column(name = "DPD_3_4_3_3")
    @JsonProperty("DPD-3-4-3-3")
    private String DPD_3_4_3_3; // 铁剂治疗选择
    public String getDPD_3_4_3_3() {  return this.DPD_3_4_3_3;}
    @JsonProperty("DPD-3-4-3-3")
    public void setDPD_3_4_3_3(final String DPD_3_4_3_3) { this.DPD_3_4_3_3=DPD_3_4_3_3;}
    @Column(name = "DPD_3_4_3_4")
    @JsonProperty("DPD-3-4-3-4")
    private String DPD_3_4_3_4; // 口服铁剂治疗药物
    public String getDPD_3_4_3_4() {  return this.DPD_3_4_3_4;}
    @JsonProperty("DPD-3-4-3-4")
    public void setDPD_3_4_3_4(final String DPD_3_4_3_4) { this.DPD_3_4_3_4=DPD_3_4_3_4;}
    @Column(name = "DPD_3_4_3_5")
    @JsonProperty("DPD-3-4-3-5")
    private String DPD_3_4_3_5; // 口服铁剂治疗其他药物
    public String getDPD_3_4_3_5() {  return this.DPD_3_4_3_5;}
    @JsonProperty("DPD-3-4-3-5")
    public void setDPD_3_4_3_5(final String DPD_3_4_3_5) { this.DPD_3_4_3_5=DPD_3_4_3_5;}
    @Column(name = "DPD_3_4_3_6")
    @JsonProperty("DPD-3-4-3-6")
    private String DPD_3_4_3_6; // 静脉铁剂治疗药物
    public String getDPD_3_4_3_6() {  return this.DPD_3_4_3_6;}
    @JsonProperty("DPD-3-4-3-6")
    public void setDPD_3_4_3_6(final String DPD_3_4_3_6) { this.DPD_3_4_3_6=DPD_3_4_3_6;}
    @Column(name = "DPD_3_4_3_7")
    @JsonProperty("DPD-3-4-3-7")
    private String DPD_3_4_3_7; // 静脉铁剂治疗其他药物
    public String getDPD_3_4_3_7() {  return this.DPD_3_4_3_7;}
    @JsonProperty("DPD-3-4-3-7")
    public void setDPD_3_4_3_7(final String DPD_3_4_3_7) { this.DPD_3_4_3_7=DPD_3_4_3_7;}
    @Column(name = "DPD_3_6_1_1")
    @JsonProperty("DPD-3-6-1-1")
    private String DPD_3_6_1_1; // 血清白蛋白
    public String getDPD_3_6_1_1() {  return this.DPD_3_6_1_1;}
    @JsonProperty("DPD-3-6-1-1")
    public void setDPD_3_6_1_1(final String DPD_3_6_1_1) { this.DPD_3_6_1_1=DPD_3_6_1_1;}
    @Column(name = "DPD_3_6_1_2")
    @JsonProperty("DPD-3-6-1-2")
    private String DPD_3_6_1_2; // 血清白蛋白检测值(g/L )
    public String getDPD_3_6_1_2() {  return this.DPD_3_6_1_2;}
    @JsonProperty("DPD-3-6-1-2")
    public void setDPD_3_6_1_2(final String DPD_3_6_1_2) { this.DPD_3_6_1_2=DPD_3_6_1_2;}
    @Column(name = "DPD_3_6_1_3")
    @JsonProperty("DPD-3-6-1-3")
    private String DPD_3_6_1_3; // 项目完成日期
    public String getDPD_3_6_1_3() {  return this.DPD_3_6_1_3;}
    @JsonProperty("DPD-3-6-1-3")
    public void setDPD_3_6_1_3(final String DPD_3_6_1_3) { this.DPD_3_6_1_3=DPD_3_6_1_3;}
    @Column(name = "DPD_3_6_1_4")
    @JsonProperty("DPD-3-6-1-4")
    private String DPD_3_6_1_4; // 血清白蛋白是否达标
    public String getDPD_3_6_1_4() {  return this.DPD_3_6_1_4;}
    @JsonProperty("DPD-3-6-1-4")
    public void setDPD_3_6_1_4(final String DPD_3_6_1_4) { this.DPD_3_6_1_4=DPD_3_6_1_4;}
    @Column(name = "DPD_3_6_2_1")
    @JsonProperty("DPD-3-6-2-1")
    private String DPD_3_6_2_1; // 是否有营养支持药物治疗医嘱
    public String getDPD_3_6_2_1() {  return this.DPD_3_6_2_1;}
    @JsonProperty("DPD-3-6-2-1")
    public void setDPD_3_6_2_1(final String DPD_3_6_2_1) { this.DPD_3_6_2_1=DPD_3_6_2_1;}
    @Column(name = "DPD_3_6_2_2")
    @JsonProperty("DPD-3-6-2-2")
    private String DPD_3_6_2_2; // 营养支持药物治疗医嘱起始日期
    public String getDPD_3_6_2_2() {  return this.DPD_3_6_2_2;}
    @JsonProperty("DPD-3-6-2-2")
    public void setDPD_3_6_2_2(final String DPD_3_6_2_2) { this.DPD_3_6_2_2=DPD_3_6_2_2;}
    @Column(name = "DPD_3_6_2_3")
    @JsonProperty("DPD-3-6-2-3")
    private String DPD_3_6_2_3; // 营养支持药物
    public String getDPD_3_6_2_3() {  return this.DPD_3_6_2_3;}
    @JsonProperty("DPD-3-6-2-3")
    public void setDPD_3_6_2_3(final String DPD_3_6_2_3) { this.DPD_3_6_2_3=DPD_3_6_2_3;}
    @Column(name = "DPD_3_6_2_4")
    @JsonProperty("DPD-3-6-2-4")
    private String DPD_3_6_2_4; // 其他营养支持药物
    public String getDPD_3_6_2_4() {  return this.DPD_3_6_2_4;}
    @JsonProperty("DPD-3-6-2-4")
    public void setDPD_3_6_2_4(final String DPD_3_6_2_4) { this.DPD_3_6_2_4=DPD_3_6_2_4;}
    @Column(name = "DPD_3_8_1_1")
    @JsonProperty("DPD-3-8-1-1")
    private String DPD_3_8_1_1; // 是否有腹膜炎
    public String getDPD_3_8_1_1() {  return this.DPD_3_8_1_1;}
    @JsonProperty("DPD-3-8-1-1")
    public void setDPD_3_8_1_1(final String DPD_3_8_1_1) { this.DPD_3_8_1_1=DPD_3_8_1_1;}
    @Column(name = "DPD_3_8_1_2")
    @JsonProperty("DPD-3-8-1-2")
    private String DPD_3_8_1_2; // 报告的日期
    public String getDPD_3_8_1_2() {  return this.DPD_3_8_1_2;}
    @JsonProperty("DPD-3-8-1-2")
    public void setDPD_3_8_1_2(final String DPD_3_8_1_2) { this.DPD_3_8_1_2=DPD_3_8_1_2;}
    @Column(name = "DPD_3_8_1_3")
    @JsonProperty("DPD-3-8-1-3")
    private String DPD_3_8_1_3; // 感染类型
    public String getDPD_3_8_1_3() {  return this.DPD_3_8_1_3;}
    @JsonProperty("DPD-3-8-1-3")
    public void setDPD_3_8_1_3(final String DPD_3_8_1_3) { this.DPD_3_8_1_3=DPD_3_8_1_3;}
    @Column(name = "DPD_3_8_1_4")
    @JsonProperty("DPD-3-8-1-4")
    private String DPD_3_8_1_4; // 病原检出
    public String getDPD_3_8_1_4() {  return this.DPD_3_8_1_4;}
    @JsonProperty("DPD-3-8-1-4")
    public void setDPD_3_8_1_4(final String DPD_3_8_1_4) { this.DPD_3_8_1_4=DPD_3_8_1_4;}
    @Column(name = "DPD_3_8_1_5")
    @JsonProperty("DPD-3-8-1-5")
    private String DPD_3_8_1_5; // 培养结果
    public String getDPD_3_8_1_5() {  return this.DPD_3_8_1_5;}
    @JsonProperty("DPD-3-8-1-5")
    public void setDPD_3_8_1_5(final String DPD_3_8_1_5) { this.DPD_3_8_1_5=DPD_3_8_1_5;}
    @Column(name = "DPD_3_8_2_1")
    @JsonProperty("DPD-3-8-2-1")
    private String DPD_3_8_2_1; // 腹膜炎患者透析龄(月)
    public String getDPD_3_8_2_1() {  return this.DPD_3_8_2_1;}
    @JsonProperty("DPD-3-8-2-1")
    public void setDPD_3_8_2_1(final String DPD_3_8_2_1) { this.DPD_3_8_2_1=DPD_3_8_2_1;}
    @Column(name = "DPD_3_8_2_2")
    @JsonProperty("DPD-3-8-2-2")
    private String DPD_3_8_2_2; // 腹膜炎患者透析次数(次)
    public String getDPD_3_8_2_2() {  return this.DPD_3_8_2_2;}
    @JsonProperty("DPD-3-8-2-2")
    public void setDPD_3_8_2_2(final String DPD_3_8_2_2) { this.DPD_3_8_2_2=DPD_3_8_2_2;}
    @Column(name = "DPD_3_8_2_3_r")
    @JsonProperty("DPD-3-8-2-3-r")
    private String DPD_3_8_2_3_r; // 患者腹膜炎次数（月/次）
    public String getDPD_3_8_2_3_r() {  return this.DPD_3_8_2_3_r;}
    @JsonProperty("DPD-3-8-2-3-r")
    public void setDPD_3_8_2_3_r(final String DPD_3_8_2_3_r) { this.DPD_3_8_2_3_r=DPD_3_8_2_3_r;}
    @Column(name = "DPD_3_8_2_3")
    @JsonProperty("DPD-3-8-2-3")
    private String DPD_3_8_2_3; // 患者腹膜炎次数（月/次）
    public String getDPD_3_8_2_3() {  return this.DPD_3_8_2_3;}
    @JsonProperty("DPD-3-8-2-3")
    public void setDPD_3_8_2_3(final String DPD_3_8_2_3) { this.DPD_3_8_2_3=DPD_3_8_2_3;}
    @Column(name = "DPD_4_1_1_2")
    @JsonProperty("DPD-4-1-1-2")
    private String DPD_4_1_1_2; // 十月份腹膜透析治疗室消毒合格情况
    public String getDPD_4_1_1_2() {  return this.DPD_4_1_1_2;}
    @JsonProperty("DPD-4-1-1-2")
    public void setDPD_4_1_1_2(final String DPD_4_1_1_2) { this.DPD_4_1_1_2=DPD_4_1_1_2;}
    @Column(name = "DPD_4_1_1_3")
    @JsonProperty("DPD-4-1-1-3")
    private String DPD_4_1_1_3; // 十一月份腹膜透析治疗室消毒合格情况
    public String getDPD_4_1_1_3() {  return this.DPD_4_1_1_3;}
    @JsonProperty("DPD-4-1-1-3")
    public void setDPD_4_1_1_3(final String DPD_4_1_1_3) { this.DPD_4_1_1_3=DPD_4_1_1_3;}
    @Column(name = "DPD_4_1_1_4")
    @JsonProperty("DPD-4-1-1-4")
    private String DPD_4_1_1_4; // 十二月份腹膜透析治疗室消毒合格情况
    public String getDPD_4_1_1_4() {  return this.DPD_4_1_1_4;}
    @JsonProperty("DPD-4-1-1-4")
    public void setDPD_4_1_1_4(final String DPD_4_1_1_4) { this.DPD_4_1_1_4=DPD_4_1_1_4;}
    @Column(name = "DPD_4_2_1_1")
    @JsonProperty("DPD-4-2-1-1")
    private String DPD_4_2_1_1; // 4季度/随访日期
    public String getDPD_4_2_1_1() {  return this.DPD_4_2_1_1;}
    @JsonProperty("DPD-4-2-1-1")
    public void setDPD_4_2_1_1(final String DPD_4_2_1_1) { this.DPD_4_2_1_1=DPD_4_2_1_1;}
    @Column(name = "DPD_4_2_1_2")
    @JsonProperty("DPD-4-2-1-2")
    private String DPD_4_2_1_2; // 4季度/透析液种类
    public String getDPD_4_2_1_2() {  return this.DPD_4_2_1_2;}
    @JsonProperty("DPD-4-2-1-2")
    public void setDPD_4_2_1_2(final String DPD_4_2_1_2) { this.DPD_4_2_1_2=DPD_4_2_1_2;}
    @Column(name = "DPD_4_2_1_3")
    @JsonProperty("DPD-4-2-1-3")
    private String DPD_4_2_1_3; // 4季度/腹透模式
    public String getDPD_4_2_1_3() {  return this.DPD_4_2_1_3;}
    @JsonProperty("DPD-4-2-1-3")
    public void setDPD_4_2_1_3(final String DPD_4_2_1_3) { this.DPD_4_2_1_3=DPD_4_2_1_3;}
    @Column(name = "DPD_4_2_2_1")
    @JsonProperty("DPD-4-2-2-1")
    private String DPD_4_2_2_1; // 腹膜平衡试验/下半年/标准平衡试验/转运类型
    public String getDPD_4_2_2_1() {  return this.DPD_4_2_2_1;}
    @JsonProperty("DPD-4-2-2-1")
    public void setDPD_4_2_2_1(final String DPD_4_2_2_1) { this.DPD_4_2_2_1=DPD_4_2_2_1;}
    @Column(name = "DPD_4_2_2_2")
    @JsonProperty("DPD-4-2-2-2")
    private String DPD_4_2_2_2; // 4季度/血常规检验完成情况
    public String getDPD_4_2_2_2() {  return this.DPD_4_2_2_2;}
    @JsonProperty("DPD-4-2-2-2")
    public void setDPD_4_2_2_2(final String DPD_4_2_2_2) { this.DPD_4_2_2_2=DPD_4_2_2_2;}
    @Column(name = "DPD_4_2_3_2")
    @JsonProperty("DPD-4-2-3-2")
    private String DPD_4_2_3_2; // 血常规检验完成日期
    public String getDPD_4_2_3_2() {  return this.DPD_4_2_3_2;}
    @JsonProperty("DPD-4-2-3-2")
    public void setDPD_4_2_3_2(final String DPD_4_2_3_2) { this.DPD_4_2_3_2=DPD_4_2_3_2;}
    @Column(name = "DPD_4_2_3_3")
    @JsonProperty("DPD-4-2-3-3")
    private String DPD_4_2_3_3; // 4季度/血生化检验完成情况
    public String getDPD_4_2_3_3() {  return this.DPD_4_2_3_3;}
    @JsonProperty("DPD-4-2-3-3")
    public void setDPD_4_2_3_3(final String DPD_4_2_3_3) { this.DPD_4_2_3_3=DPD_4_2_3_3;}
    @Column(name = "DPD_4_2_3_4")
    @JsonProperty("DPD-4-2-3-4")
    private String DPD_4_2_3_4; // 血生化检完成日期
    public String getDPD_4_2_3_4() {  return this.DPD_4_2_3_4;}
    @JsonProperty("DPD-4-2-3-4")
    public void setDPD_4_2_3_4(final String DPD_4_2_3_4) { this.DPD_4_2_3_4=DPD_4_2_3_4;}
    @Column(name = "DPD_4_2_3_5")
    @JsonProperty("DPD-4-2-3-5")
    private String DPD_4_2_3_5; // 4季度/前白蛋白检验完成情况
    public String getDPD_4_2_3_5() {  return this.DPD_4_2_3_5;}
    @JsonProperty("DPD-4-2-3-5")
    public void setDPD_4_2_3_5(final String DPD_4_2_3_5) { this.DPD_4_2_3_5=DPD_4_2_3_5;}
    @Column(name = "DPD_4_2_3_6")
    @JsonProperty("DPD-4-2-3-6")
    private String DPD_4_2_3_6; // 前白蛋白检验完成日期
    public String getDPD_4_2_3_6() {  return this.DPD_4_2_3_6;}
    @JsonProperty("DPD-4-2-3-6")
    public void setDPD_4_2_3_6(final String DPD_4_2_3_6) { this.DPD_4_2_3_6=DPD_4_2_3_6;}
    @Column(name = "DPD_4_2_3_7")
    @JsonProperty("DPD-4-2-3-7")
    private String DPD_4_2_3_7; // 4季度/β2微球蛋白检验完成情况
    public String getDPD_4_2_3_7() {  return this.DPD_4_2_3_7;}
    @JsonProperty("DPD-4-2-3-7")
    public void setDPD_4_2_3_7(final String DPD_4_2_3_7) { this.DPD_4_2_3_7=DPD_4_2_3_7;}
    @Column(name = "DPD_4_2_3_8")
    @JsonProperty("DPD-4-2-3-8")
    private String DPD_4_2_3_8; // β2微球蛋白检验完成日期
    public String getDPD_4_2_3_8() {  return this.DPD_4_2_3_8;}
    @JsonProperty("DPD-4-2-3-8")
    public void setDPD_4_2_3_8(final String DPD_4_2_3_8) { this.DPD_4_2_3_8=DPD_4_2_3_8;}
    @Column(name = "DPD_4_2_3_9")
    @JsonProperty("DPD-4-2-3-9")
    private String DPD_4_2_3_9; // 4季度/C反应蛋白检验完成情况
    public String getDPD_4_2_3_9() {  return this.DPD_4_2_3_9;}
    @JsonProperty("DPD-4-2-3-9")
    public void setDPD_4_2_3_9(final String DPD_4_2_3_9) { this.DPD_4_2_3_9=DPD_4_2_3_9;}
    @Column(name = "DPD_4_2_3_10")
    @JsonProperty("DPD-4-2-3-10")
    private String DPD_4_2_3_10; // C反应蛋白检验完成日期
    public String getDPD_4_2_3_10() {  return this.DPD_4_2_3_10;}
    @JsonProperty("DPD-4-2-3-10")
    public void setDPD_4_2_3_10(final String DPD_4_2_3_10) { this.DPD_4_2_3_10=DPD_4_2_3_10;}
    @Column(name = "DPD_4_2_3_11")
    @JsonProperty("DPD-4-2-3-11")
    private String DPD_4_2_3_11; // 4季度/血清铁蛋白检验完成情况
    public String getDPD_4_2_3_11() {  return this.DPD_4_2_3_11;}
    @JsonProperty("DPD-4-2-3-11")
    public void setDPD_4_2_3_11(final String DPD_4_2_3_11) { this.DPD_4_2_3_11=DPD_4_2_3_11;}
    @Column(name = "DPD_4_2_3_12")
    @JsonProperty("DPD-4-2-3-12")
    private String DPD_4_2_3_12; // 血清铁蛋白检验完成日期
    public String getDPD_4_2_3_12() {  return this.DPD_4_2_3_12;}
    @JsonProperty("DPD-4-2-3-12")
    public void setDPD_4_2_3_12(final String DPD_4_2_3_12) { this.DPD_4_2_3_12=DPD_4_2_3_12;}
    @Column(name = "DPD_4_2_3_13")
    @JsonProperty("DPD-4-2-3-13")
    private String DPD_4_2_3_13; // 4季度/转铁蛋白饱和度检验完成情况
    public String getDPD_4_2_3_13() {  return this.DPD_4_2_3_13;}
    @JsonProperty("DPD-4-2-3-13")
    public void setDPD_4_2_3_13(final String DPD_4_2_3_13) { this.DPD_4_2_3_13=DPD_4_2_3_13;}
    @Column(name = "DPD_4_2_3_14")
    @JsonProperty("DPD-4-2-3-14")
    private String DPD_4_2_3_14; // 转铁蛋白饱和度检验完成日期
    public String getDPD_4_2_3_14() {  return this.DPD_4_2_3_14;}
    @JsonProperty("DPD-4-2-3-14")
    public void setDPD_4_2_3_14(final String DPD_4_2_3_14) { this.DPD_4_2_3_14=DPD_4_2_3_14;}
    @Column(name = "DPD_4_3_1_2")
    @JsonProperty("DPD-4-3-1-2")
    private String DPD_4_3_1_2; // 血压SBP
    public String getDPD_4_3_1_2() {  return this.DPD_4_3_1_2;}
    @JsonProperty("DPD-4-3-1-2")
    public void setDPD_4_3_1_2(final String DPD_4_3_1_2) { this.DPD_4_3_1_2=DPD_4_3_1_2;}
    @Column(name = "DPD_4_3_1_3")
    @JsonProperty("DPD-4-3-1-3")
    private String DPD_4_3_1_3; // 血压DBP
    public String getDPD_4_3_1_3() {  return this.DPD_4_3_1_3;}
    @JsonProperty("DPD-4-3-1-3")
    public void setDPD_4_3_1_3(final String DPD_4_3_1_3) { this.DPD_4_3_1_3=DPD_4_3_1_3;}
    @Column(name = "DPD_4_3_1_4")
    @JsonProperty("DPD-4-3-1-4")
    private String DPD_4_3_1_4; // 项目完成日期
    public String getDPD_4_3_1_4() {  return this.DPD_4_3_1_4;}
    @JsonProperty("DPD-4-3-1-4")
    public void setDPD_4_3_1_4(final String DPD_4_3_1_4) { this.DPD_4_3_1_4=DPD_4_3_1_4;}
    @Column(name = "DPD_4_3_1_5")
    @JsonProperty("DPD-4-3-1-5")
    private String DPD_4_3_1_5; // 高血压是否达标
    public String getDPD_4_3_1_5() {  return this.DPD_4_3_1_5;}
    @JsonProperty("DPD-4-3-1-5")
    public void setDPD_4_3_1_5(final String DPD_4_3_1_5) { this.DPD_4_3_1_5=DPD_4_3_1_5;}
    @Column(name = "DPD_4_3_2_1")
    @JsonProperty("DPD-4-3-2-1")
    private String DPD_4_3_2_1; // 是否有抗高血压药治疗医嘱
    public String getDPD_4_3_2_1() {  return this.DPD_4_3_2_1;}
    @JsonProperty("DPD-4-3-2-1")
    public void setDPD_4_3_2_1(final String DPD_4_3_2_1) { this.DPD_4_3_2_1=DPD_4_3_2_1;}
    @Column(name = "DPD_4_3_2_2")
    @JsonProperty("DPD-4-3-2-2")
    private String DPD_4_3_2_2; // 抗高血压药治疗医嘱起始日期
    public String getDPD_4_3_2_2() {  return this.DPD_4_3_2_2;}
    @JsonProperty("DPD-4-3-2-2")
    public void setDPD_4_3_2_2(final String DPD_4_3_2_2) { this.DPD_4_3_2_2=DPD_4_3_2_2;}
    @Column(name = "DPD_4_3_2_3")
    @JsonProperty("DPD-4-3-2-3")
    private String DPD_4_3_2_3; // 抗高血压药
    public String getDPD_4_3_2_3() {  return this.DPD_4_3_2_3;}
    @JsonProperty("DPD-4-3-2-3")
    public void setDPD_4_3_2_3(final String DPD_4_3_2_3) { this.DPD_4_3_2_3=DPD_4_3_2_3;}
    @Column(name = "DPD_4_3_2_4")
    @JsonProperty("DPD-4-3-2-4")
    private String DPD_4_3_2_4; // 其他抗高血压药
    public String getDPD_4_3_2_4() {  return this.DPD_4_3_2_4;}
    @JsonProperty("DPD-4-3-2-4")
    public void setDPD_4_3_2_4(final String DPD_4_3_2_4) { this.DPD_4_3_2_4=DPD_4_3_2_4;}
    @Column(name = "DPD_4_4_1_1")
    @JsonProperty("DPD-4-4-1-1")
    private String DPD_4_4_1_1; // 血红蛋白
    public String getDPD_4_4_1_1() {  return this.DPD_4_4_1_1;}
    @JsonProperty("DPD-4-4-1-1")
    public void setDPD_4_4_1_1(final String DPD_4_4_1_1) { this.DPD_4_4_1_1=DPD_4_4_1_1;}
    @Column(name = "DPD_4_4_1_2")
    @JsonProperty("DPD-4-4-1-2")
    private String DPD_4_4_1_2; // 血红蛋白检测值(g/L )
    public String getDPD_4_4_1_2() {  return this.DPD_4_4_1_2;}
    @JsonProperty("DPD-4-4-1-2")
    public void setDPD_4_4_1_2(final String DPD_4_4_1_2) { this.DPD_4_4_1_2=DPD_4_4_1_2;}
    @Column(name = "DPD_4_4_1_3")
    @JsonProperty("DPD-4-4-1-3")
    private String DPD_4_4_1_3; // 项目完成日期
    public String getDPD_4_4_1_3() {  return this.DPD_4_4_1_3;}
    @JsonProperty("DPD-4-4-1-3")
    public void setDPD_4_4_1_3(final String DPD_4_4_1_3) { this.DPD_4_4_1_3=DPD_4_4_1_3;}
    @Column(name = "DPD_4_4_1_4")
    @JsonProperty("DPD-4-4-1-4")
    private String DPD_4_4_1_4; // 血红蛋白是否达标
    public String getDPD_4_4_1_4() {  return this.DPD_4_4_1_4;}
    @JsonProperty("DPD-4-4-1-4")
    public void setDPD_4_4_1_4(final String DPD_4_4_1_4) { this.DPD_4_4_1_4=DPD_4_4_1_4;}
    @Column(name = "DPD_4_4_2_1")
    @JsonProperty("DPD-4-4-2-1")
    private String DPD_4_4_2_1; // 是否有ESA治疗医嘱
    public String getDPD_4_4_2_1() {  return this.DPD_4_4_2_1;}
    @JsonProperty("DPD-4-4-2-1")
    public void setDPD_4_4_2_1(final String DPD_4_4_2_1) { this.DPD_4_4_2_1=DPD_4_4_2_1;}
    @Column(name = "DPD_4_4_2_2")
    @JsonProperty("DPD-4-4-2-2")
    private String DPD_4_4_2_2; // ESA治疗医嘱起始日期
    public String getDPD_4_4_2_2() {  return this.DPD_4_4_2_2;}
    @JsonProperty("DPD-4-4-2-2")
    public void setDPD_4_4_2_2(final String DPD_4_4_2_2) { this.DPD_4_4_2_2=DPD_4_4_2_2;}
    @Column(name = "DPD_4_4_2_3")
    @JsonProperty("DPD-4-4-2-3")
    private String DPD_4_4_2_3; // ESA治疗药物
    public String getDPD_4_4_2_3() {  return this.DPD_4_4_2_3;}
    @JsonProperty("DPD-4-4-2-3")
    public void setDPD_4_4_2_3(final String DPD_4_4_2_3) { this.DPD_4_4_2_3=DPD_4_4_2_3;}
    @Column(name = "DPD_4_4_2_4")
    @JsonProperty("DPD-4-4-2-4")
    private String DPD_4_4_2_4; // ESA治疗其他药物
    public String getDPD_4_4_2_4() {  return this.DPD_4_4_2_4;}
    @JsonProperty("DPD-4-4-2-4")
    public void setDPD_4_4_2_4(final String DPD_4_4_2_4) { this.DPD_4_4_2_4=DPD_4_4_2_4;}
    @Column(name = "DPD_4_4_3_1")
    @JsonProperty("DPD-4-4-3-1")
    private String DPD_4_4_3_1; // 是否有铁剂治疗医嘱
    public String getDPD_4_4_3_1() {  return this.DPD_4_4_3_1;}
    @JsonProperty("DPD-4-4-3-1")
    public void setDPD_4_4_3_1(final String DPD_4_4_3_1) { this.DPD_4_4_3_1=DPD_4_4_3_1;}
    @Column(name = "DPD_4_4_3_2")
    @JsonProperty("DPD-4-4-3-2")
    private String DPD_4_4_3_2; // 铁剂治疗医嘱起始日期
    public String getDPD_4_4_3_2() {  return this.DPD_4_4_3_2;}
    @JsonProperty("DPD-4-4-3-2")
    public void setDPD_4_4_3_2(final String DPD_4_4_3_2) { this.DPD_4_4_3_2=DPD_4_4_3_2;}
    @Column(name = "DPD_4_4_3_3")
    @JsonProperty("DPD-4-4-3-3")
    private String DPD_4_4_3_3; // 铁剂治疗选择
    public String getDPD_4_4_3_3() {  return this.DPD_4_4_3_3;}
    @JsonProperty("DPD-4-4-3-3")
    public void setDPD_4_4_3_3(final String DPD_4_4_3_3) { this.DPD_4_4_3_3=DPD_4_4_3_3;}
    @Column(name = "DPD_4_4_3_4")
    @JsonProperty("DPD-4-4-3-4")
    private String DPD_4_4_3_4; // 口服铁剂治疗药物
    public String getDPD_4_4_3_4() {  return this.DPD_4_4_3_4;}
    @JsonProperty("DPD-4-4-3-4")
    public void setDPD_4_4_3_4(final String DPD_4_4_3_4) { this.DPD_4_4_3_4=DPD_4_4_3_4;}
    @Column(name = "DPD_4_4_3_5")
    @JsonProperty("DPD-4-4-3-5")
    private String DPD_4_4_3_5; // 口服铁剂治疗其他药物
    public String getDPD_4_4_3_5() {  return this.DPD_4_4_3_5;}
    @JsonProperty("DPD-4-4-3-5")
    public void setDPD_4_4_3_5(final String DPD_4_4_3_5) { this.DPD_4_4_3_5=DPD_4_4_3_5;}
    @Column(name = "DPD_4_4_3_6")
    @JsonProperty("DPD-4-4-3-6")
    private String DPD_4_4_3_6; // 静脉铁剂治疗药物
    public String getDPD_4_4_3_6() {  return this.DPD_4_4_3_6;}
    @JsonProperty("DPD-4-4-3-6")
    public void setDPD_4_4_3_6(final String DPD_4_4_3_6) { this.DPD_4_4_3_6=DPD_4_4_3_6;}
    @Column(name = "DPD_4_4_3_7")
    @JsonProperty("DPD-4-4-3-7")
    private String DPD_4_4_3_7; // 静脉铁剂治疗其他药物
    public String getDPD_4_4_3_7() {  return this.DPD_4_4_3_7;}
    @JsonProperty("DPD-4-4-3-7")
    public void setDPD_4_4_3_7(final String DPD_4_4_3_7) { this.DPD_4_4_3_7=DPD_4_4_3_7;}
    @Column(name = "DPD_4_5_1_1")
    @JsonProperty("DPD-4-5-1-1")
    private String DPD_4_5_1_1; // 检验情况
    public String getDPD_4_5_1_1() {  return this.DPD_4_5_1_1;}
    @JsonProperty("DPD-4-5-1-1")
    public void setDPD_4_5_1_1(final String DPD_4_5_1_1) { this.DPD_4_5_1_1=DPD_4_5_1_1;}
    @Column(name = "DPD_4_5_1_2")
    @JsonProperty("DPD-4-5-1-2")
    private String DPD_4_5_1_2; // 血总钙检测值(mmol/L)
    public String getDPD_4_5_1_2() {  return this.DPD_4_5_1_2;}
    @JsonProperty("DPD-4-5-1-2")
    public void setDPD_4_5_1_2(final String DPD_4_5_1_2) { this.DPD_4_5_1_2=DPD_4_5_1_2;}
    @Column(name = "DPD_4_5_1_3")
    @JsonProperty("DPD-4-5-1-3")
    private String DPD_4_5_1_3; // 血磷检测值(mmol/L)
    public String getDPD_4_5_1_3() {  return this.DPD_4_5_1_3;}
    @JsonProperty("DPD-4-5-1-3")
    public void setDPD_4_5_1_3(final String DPD_4_5_1_3) { this.DPD_4_5_1_3=DPD_4_5_1_3;}
    @Column(name = "DPD_4_5_1_4")
    @JsonProperty("DPD-4-5-1-4")
    private String DPD_4_5_1_4; // IPTH检测值(pg/ml)
    public String getDPD_4_5_1_4() {  return this.DPD_4_5_1_4;}
    @JsonProperty("DPD-4-5-1-4")
    public void setDPD_4_5_1_4(final String DPD_4_5_1_4) { this.DPD_4_5_1_4=DPD_4_5_1_4;}
    @Column(name = "DPD_4_5_1_5")
    @JsonProperty("DPD-4-5-1-5")
    private String DPD_4_5_1_5; // 项目完成日期
    public String getDPD_4_5_1_5() {  return this.DPD_4_5_1_5;}
    @JsonProperty("DPD-4-5-1-5")
    public void setDPD_4_5_1_5(final String DPD_4_5_1_5) { this.DPD_4_5_1_5=DPD_4_5_1_5;}
    @Column(name = "DPD_4_5_1_6")
    @JsonProperty("DPD-4-5-1-6")
    private String DPD_4_5_1_6; // 血总钙是否达标
    public String getDPD_4_5_1_6() {  return this.DPD_4_5_1_6;}
    @JsonProperty("DPD-4-5-1-6")
    public void setDPD_4_5_1_6(final String DPD_4_5_1_6) { this.DPD_4_5_1_6=DPD_4_5_1_6;}
    @Column(name = "DPD_4_5_1_7")
    @JsonProperty("DPD-4-5-1-7")
    private String DPD_4_5_1_7; // 血磷是否达标
    public String getDPD_4_5_1_7() {  return this.DPD_4_5_1_7;}
    @JsonProperty("DPD-4-5-1-7")
    public void setDPD_4_5_1_7(final String DPD_4_5_1_7) { this.DPD_4_5_1_7=DPD_4_5_1_7;}
    @Column(name = "DPD_4_5_1_8")
    @JsonProperty("DPD-4-5-1-8")
    private String DPD_4_5_1_8; // 全段甲状旁腺激素（IPTH）是否达标
    public String getDPD_4_5_1_8() {  return this.DPD_4_5_1_8;}
    @JsonProperty("DPD-4-5-1-8")
    public void setDPD_4_5_1_8(final String DPD_4_5_1_8) { this.DPD_4_5_1_8=DPD_4_5_1_8;}
    @Column(name = "DPD_4_5_2_1")
    @JsonProperty("DPD-4-5-2-1")
    private String DPD_4_5_2_1; // 是否有MBD干预药治疗医嘱
    public String getDPD_4_5_2_1() {  return this.DPD_4_5_2_1;}
    @JsonProperty("DPD-4-5-2-1")
    public void setDPD_4_5_2_1(final String DPD_4_5_2_1) { this.DPD_4_5_2_1=DPD_4_5_2_1;}
    @Column(name = "DPD_4_5_2_2")
    @JsonProperty("DPD-4-5-2-2")
    private String DPD_4_5_2_2; // MBD干预药治疗医嘱起始日期
    public String getDPD_4_5_2_2() {  return this.DPD_4_5_2_2;}
    @JsonProperty("DPD-4-5-2-2")
    public void setDPD_4_5_2_2(final String DPD_4_5_2_2) { this.DPD_4_5_2_2=DPD_4_5_2_2;}
    @Column(name = "DPD_4_5_2_3")
    @JsonProperty("DPD-4-5-2-3")
    private String DPD_4_5_2_3; // MBD干预药选择
    public String getDPD_4_5_2_3() {  return this.DPD_4_5_2_3;}
    @JsonProperty("DPD-4-5-2-3")
    public void setDPD_4_5_2_3(final String DPD_4_5_2_3) { this.DPD_4_5_2_3=DPD_4_5_2_3;}
    @Column(name = "DPD_4_5_2_4")
    @JsonProperty("DPD-4-5-2-4")
    private String DPD_4_5_2_4; // MBD干预药_维生素D及衍生物
    public String getDPD_4_5_2_4() {  return this.DPD_4_5_2_4;}
    @JsonProperty("DPD-4-5-2-4")
    public void setDPD_4_5_2_4(final String DPD_4_5_2_4) { this.DPD_4_5_2_4=DPD_4_5_2_4;}
    @Column(name = "DPD_4_5_2_5")
    @JsonProperty("DPD-4-5-2-5")
    private String DPD_4_5_2_5; // 其他维生素D及衍生物
    public String getDPD_4_5_2_5() {  return this.DPD_4_5_2_5;}
    @JsonProperty("DPD-4-5-2-5")
    public void setDPD_4_5_2_5(final String DPD_4_5_2_5) { this.DPD_4_5_2_5=DPD_4_5_2_5;}
    @Column(name = "DPD_4_5_2_6")
    @JsonProperty("DPD-4-5-2-6")
    private String DPD_4_5_2_6; // MBD干预药_含钙的磷结合剂
    public String getDPD_4_5_2_6() {  return this.DPD_4_5_2_6;}
    @JsonProperty("DPD-4-5-2-6")
    public void setDPD_4_5_2_6(final String DPD_4_5_2_6) { this.DPD_4_5_2_6=DPD_4_5_2_6;}
    @Column(name = "DPD_4_5_2_7")
    @JsonProperty("DPD-4-5-2-7")
    private String DPD_4_5_2_7; // 其他含钙的磷结合剂
    public String getDPD_4_5_2_7() {  return this.DPD_4_5_2_7;}
    @JsonProperty("DPD-4-5-2-7")
    public void setDPD_4_5_2_7(final String DPD_4_5_2_7) { this.DPD_4_5_2_7=DPD_4_5_2_7;}
    @Column(name = "DPD_4_5_2_8")
    @JsonProperty("DPD-4-5-2-8")
    private String DPD_4_5_2_8; // MBD干预药_含铝的磷结合剂
    public String getDPD_4_5_2_8() {  return this.DPD_4_5_2_8;}
    @JsonProperty("DPD-4-5-2-8")
    public void setDPD_4_5_2_8(final String DPD_4_5_2_8) { this.DPD_4_5_2_8=DPD_4_5_2_8;}
    @Column(name = "DPD_4_5_2_9")
    @JsonProperty("DPD-4-5-2-9")
    private String DPD_4_5_2_9; // 其他含铝的磷结合剂
    public String getDPD_4_5_2_9() {  return this.DPD_4_5_2_9;}
    @JsonProperty("DPD-4-5-2-9")
    public void setDPD_4_5_2_9(final String DPD_4_5_2_9) { this.DPD_4_5_2_9=DPD_4_5_2_9;}
    @Column(name = "DPD_4_5_2_10")
    @JsonProperty("DPD-4-5-2-10")
    private String DPD_4_5_2_10; // MBD干预药_不含钙铝的磷结合剂
    public String getDPD_4_5_2_10() {  return this.DPD_4_5_2_10;}
    @JsonProperty("DPD-4-5-2-10")
    public void setDPD_4_5_2_10(final String DPD_4_5_2_10) { this.DPD_4_5_2_10=DPD_4_5_2_10;}
    @Column(name = "DPD_4_5_2_11")
    @JsonProperty("DPD-4-5-2-11")
    private String DPD_4_5_2_11; // 其他不含钙铝的磷结合剂
    public String getDPD_4_5_2_11() {  return this.DPD_4_5_2_11;}
    @JsonProperty("DPD-4-5-2-11")
    public void setDPD_4_5_2_11(final String DPD_4_5_2_11) { this.DPD_4_5_2_11=DPD_4_5_2_11;}
    @Column(name = "DPD_4_5_2_12")
    @JsonProperty("DPD-4-5-2-12")
    private String DPD_4_5_2_12; // MBD干预药_拟钙剂
    public String getDPD_4_5_2_12() {  return this.DPD_4_5_2_12;}
    @JsonProperty("DPD-4-5-2-12")
    public void setDPD_4_5_2_12(final String DPD_4_5_2_12) { this.DPD_4_5_2_12=DPD_4_5_2_12;}
    @Column(name = "DPD_4_5_2_13")
    @JsonProperty("DPD-4-5-2-13")
    private String DPD_4_5_2_13; // 其他拟钙剂
    public String getDPD_4_5_2_13() {  return this.DPD_4_5_2_13;}
    @JsonProperty("DPD-4-5-2-13")
    public void setDPD_4_5_2_13(final String DPD_4_5_2_13) { this.DPD_4_5_2_13=DPD_4_5_2_13;}
    @Column(name = "DPD_4_6_1_1")
    @JsonProperty("DPD-4-6-1-1")
    private String DPD_4_6_1_1; // 血清白蛋白
    public String getDPD_4_6_1_1() {  return this.DPD_4_6_1_1;}
    @JsonProperty("DPD-4-6-1-1")
    public void setDPD_4_6_1_1(final String DPD_4_6_1_1) { this.DPD_4_6_1_1=DPD_4_6_1_1;}
    @Column(name = "DPD_4_6_1_2")
    @JsonProperty("DPD-4-6-1-2")
    private String DPD_4_6_1_2; // 血清白蛋白检测值(g/L )
    public String getDPD_4_6_1_2() {  return this.DPD_4_6_1_2;}
    @JsonProperty("DPD-4-6-1-2")
    public void setDPD_4_6_1_2(final String DPD_4_6_1_2) { this.DPD_4_6_1_2=DPD_4_6_1_2;}
    @Column(name = "DPD_4_6_1_3")
    @JsonProperty("DPD-4-6-1-3")
    private String DPD_4_6_1_3; // 项目完成日期
    public String getDPD_4_6_1_3() {  return this.DPD_4_6_1_3;}
    @JsonProperty("DPD-4-6-1-3")
    public void setDPD_4_6_1_3(final String DPD_4_6_1_3) { this.DPD_4_6_1_3=DPD_4_6_1_3;}
    @Column(name = "DPD_4_6_1_4")
    @JsonProperty("DPD-4-6-1-4")
    private String DPD_4_6_1_4; // 血清白蛋白是否达标
    public String getDPD_4_6_1_4() {  return this.DPD_4_6_1_4;}
    @JsonProperty("DPD-4-6-1-4")
    public void setDPD_4_6_1_4(final String DPD_4_6_1_4) { this.DPD_4_6_1_4=DPD_4_6_1_4;}
    @Column(name = "DPD_4_6_2_1")
    @JsonProperty("DPD-4-6-2-1")
    private String DPD_4_6_2_1; // 是否有营养支持药物治疗医嘱
    public String getDPD_4_6_2_1() {  return this.DPD_4_6_2_1;}
    @JsonProperty("DPD-4-6-2-1")
    public void setDPD_4_6_2_1(final String DPD_4_6_2_1) { this.DPD_4_6_2_1=DPD_4_6_2_1;}
    @Column(name = "DPD_4_6_2_2")
    @JsonProperty("DPD-4-6-2-2")
    private String DPD_4_6_2_2; // 营养支持药物治疗医嘱起始日期
    public String getDPD_4_6_2_2() {  return this.DPD_4_6_2_2;}
    @JsonProperty("DPD-4-6-2-2")
    public void setDPD_4_6_2_2(final String DPD_4_6_2_2) { this.DPD_4_6_2_2=DPD_4_6_2_2;}
    @Column(name = "DPD_4_6_2_3")
    @JsonProperty("DPD-4-6-2-3")
    private String DPD_4_6_2_3; // 营养支持药物
    public String getDPD_4_6_2_3() {  return this.DPD_4_6_2_3;}
    @JsonProperty("DPD-4-6-2-3")
    public void setDPD_4_6_2_3(final String DPD_4_6_2_3) { this.DPD_4_6_2_3=DPD_4_6_2_3;}
    @Column(name = "DPD_4_6_2_4")
    @JsonProperty("DPD-4-6-2-4")
    private String DPD_4_6_2_4; // 其他营养支持药物
    public String getDPD_4_6_2_4() {  return this.DPD_4_6_2_4;}
    @JsonProperty("DPD-4-6-2-4")
    public void setDPD_4_6_2_4(final String DPD_4_6_2_4) { this.DPD_4_6_2_4=DPD_4_6_2_4;}
    @Column(name = "DPD_4_7_1_2")
    @JsonProperty("DPD-4-7-1-2")
    private String DPD_4_7_1_2; // 身高(cm)
    public String getDPD_4_7_1_2() {  return this.DPD_4_7_1_2;}
    @JsonProperty("DPD-4-7-1-2")
    public void setDPD_4_7_1_2(final String DPD_4_7_1_2) { this.DPD_4_7_1_2=DPD_4_7_1_2;}
    @Column(name = "DPD_4_7_1_1_r")
    @JsonProperty("DPD-4-7-1-1-r")
    private String DPD_4_7_1_1_r; // 身高转换
    public String getDPD_4_7_1_1_r() {  return this.DPD_4_7_1_1_r;}
    @JsonProperty("DPD-4-7-1-1-r")
    public void setDPD_4_7_1_1_r(final String DPD_4_7_1_1_r) { this.DPD_4_7_1_1_r=DPD_4_7_1_1_r;}
    @Column(name = "DPD_4_7_1_3")
    @JsonProperty("DPD-4-7-1-3")
    private String DPD_4_7_1_3; // 体重(kg)
    public String getDPD_4_7_1_3() {  return this.DPD_4_7_1_3;}
    @JsonProperty("DPD-4-7-1-3")
    public void setDPD_4_7_1_3(final String DPD_4_7_1_3) { this.DPD_4_7_1_3=DPD_4_7_1_3;}
    @Column(name = "DPD_4_7_1_3_r")
    @JsonProperty("DPD-4-7-1-3-r")
    private String DPD_4_7_1_3_r; // 体重指数(BMI)
    public String getDPD_4_7_1_3_r() {  return this.DPD_4_7_1_3_r;}
    @JsonProperty("DPD-4-7-1-3-r")
    public void setDPD_4_7_1_3_r(final String DPD_4_7_1_3_r) { this.DPD_4_7_1_3_r=DPD_4_7_1_3_r;}
    @Column(name = "DPD_4_7_1_4")
    @JsonProperty("DPD-4-7-1-4")
    private String DPD_4_7_1_4; // 体重指数(BMI)
    public String getDPD_4_7_1_4() {  return this.DPD_4_7_1_4;}
    @JsonProperty("DPD-4-7-1-4")
    public void setDPD_4_7_1_4(final String DPD_4_7_1_4) { this.DPD_4_7_1_4=DPD_4_7_1_4;}
    @Column(name = "DPD_4_7_1_4_r")
    @JsonProperty("DPD-4-7-1-4-r")
    private String DPD_4_7_1_4_r; // 0.0061倍身高(cm)
    public String getDPD_4_7_1_4_r() {  return this.DPD_4_7_1_4_r;}
    @JsonProperty("DPD-4-7-1-4-r")
    public void setDPD_4_7_1_4_r(final String DPD_4_7_1_4_r) { this.DPD_4_7_1_4_r=DPD_4_7_1_4_r;}
    @Column(name = "DPD_4_7_1_5_r")
    @JsonProperty("DPD-4-7-1-5-r")
    private String DPD_4_7_1_5_r; // 0.0128倍体重(kg)
    public String getDPD_4_7_1_5_r() {  return this.DPD_4_7_1_5_r;}
    @JsonProperty("DPD-4-7-1-5-r")
    public void setDPD_4_7_1_5_r(final String DPD_4_7_1_5_r) { this.DPD_4_7_1_5_r=DPD_4_7_1_5_r;}
    @Column(name = "DPD_4_7_1_6_r")
    @JsonProperty("DPD-4-7-1-6-r")
    private String DPD_4_7_1_6_r; // 体表面积公式
    public String getDPD_4_7_1_6_r() {  return this.DPD_4_7_1_6_r;}
    @JsonProperty("DPD-4-7-1-6-r")
    public void setDPD_4_7_1_6_r(final String DPD_4_7_1_6_r) { this.DPD_4_7_1_6_r=DPD_4_7_1_6_r;}
    @Column(name = "DPD_4_7_1_7_r")
    @JsonProperty("DPD-4-7-1-7-r")
    private String DPD_4_7_1_7_r; // 体表面积(m²)
    public String getDPD_4_7_1_7_r() {  return this.DPD_4_7_1_7_r;}
    @JsonProperty("DPD-4-7-1-7-r")
    public void setDPD_4_7_1_7_r(final String DPD_4_7_1_7_r) { this.DPD_4_7_1_7_r=DPD_4_7_1_7_r;}
    @Column(name = "DPD_4_7_1_5")
    @JsonProperty("DPD-4-7-1-5")
    private String DPD_4_7_1_5; // 体表面积(m²)
    public String getDPD_4_7_1_5() {  return this.DPD_4_7_1_5;}
    @JsonProperty("DPD-4-7-1-5")
    public void setDPD_4_7_1_5(final String DPD_4_7_1_5) { this.DPD_4_7_1_5=DPD_4_7_1_5;}
    @Column(name = "DPD_4_7_1_6")
    @JsonProperty("DPD-4-7-1-6")
    private String DPD_4_7_1_6; // 总体水(V)
    public String getDPD_4_7_1_6() {  return this.DPD_4_7_1_6;}
    @JsonProperty("DPD-4-7-1-6")
    public void setDPD_4_7_1_6(final String DPD_4_7_1_6) { this.DPD_4_7_1_6=DPD_4_7_1_6;}
    @Column(name = "DPD_4_7_1_7")
    @JsonProperty("DPD-4-7-1-7")
    private String DPD_4_7_1_7; // 血尿素氮(mmoL/L)
    public String getDPD_4_7_1_7() {  return this.DPD_4_7_1_7;}
    @JsonProperty("DPD-4-7-1-7")
    public void setDPD_4_7_1_7(final String DPD_4_7_1_7) { this.DPD_4_7_1_7=DPD_4_7_1_7;}
    @Column(name = "DPD_4_7_1_8")
    @JsonProperty("DPD-4-7-1-8")
    private String DPD_4_7_1_8; // 血肌酐(μmoL/L)
    public String getDPD_4_7_1_8() {  return this.DPD_4_7_1_8;}
    @JsonProperty("DPD-4-7-1-8")
    public void setDPD_4_7_1_8(final String DPD_4_7_1_8) { this.DPD_4_7_1_8=DPD_4_7_1_8;}
    @Column(name = "DPD_4_7_1_9")
    @JsonProperty("DPD-4-7-1-9")
    private String DPD_4_7_1_9; // 24小时尿量(L)
    public String getDPD_4_7_1_9() {  return this.DPD_4_7_1_9;}
    @JsonProperty("DPD-4-7-1-9")
    public void setDPD_4_7_1_9(final String DPD_4_7_1_9) { this.DPD_4_7_1_9=DPD_4_7_1_9;}
    @Column(name = "DPD_4_7_1_10")
    @JsonProperty("DPD-4-7-1-10")
    private String DPD_4_7_1_10; // 24小时尿中尿素氮(mmoL/L)
    public String getDPD_4_7_1_10() {  return this.DPD_4_7_1_10;}
    @JsonProperty("DPD-4-7-1-10")
    public void setDPD_4_7_1_10(final String DPD_4_7_1_10) { this.DPD_4_7_1_10=DPD_4_7_1_10;}
    @Column(name = "DPD_4_7_1_11")
    @JsonProperty("DPD-4-7-1-11")
    private String DPD_4_7_1_11; // 24小时尿肌酐(μmoL/L)
    public String getDPD_4_7_1_11() {  return this.DPD_4_7_1_11;}
    @JsonProperty("DPD-4-7-1-11")
    public void setDPD_4_7_1_11(final String DPD_4_7_1_11) { this.DPD_4_7_1_11=DPD_4_7_1_11;}
    @Column(name = "DPD_4_7_1_12")
    @JsonProperty("DPD-4-7-1-12")
    private String DPD_4_7_1_12; // 24小时腹透液排出总量(L)
    public String getDPD_4_7_1_12() {  return this.DPD_4_7_1_12;}
    @JsonProperty("DPD-4-7-1-12")
    public void setDPD_4_7_1_12(final String DPD_4_7_1_12) { this.DPD_4_7_1_12=DPD_4_7_1_12;}
    @Column(name = "DPD_4_7_1_13")
    @JsonProperty("DPD-4-7-1-13")
    private String DPD_4_7_1_13; // 24小时透出液尿素氮(mmoL/L)
    public String getDPD_4_7_1_13() {  return this.DPD_4_7_1_13;}
    @JsonProperty("DPD-4-7-1-13")
    public void setDPD_4_7_1_13(final String DPD_4_7_1_13) { this.DPD_4_7_1_13=DPD_4_7_1_13;}
    @Column(name = "DPD_4_7_1_14")
    @JsonProperty("DPD-4-7-1-14")
    private String DPD_4_7_1_14; // 24小时透出液肌酐(μmoL/L)
    public String getDPD_4_7_1_14() {  return this.DPD_4_7_1_14;}
    @JsonProperty("DPD-4-7-1-14")
    public void setDPD_4_7_1_14(final String DPD_4_7_1_14) { this.DPD_4_7_1_14=DPD_4_7_1_14;}
    @Column(name = "DPD_4_7_1_18")
    @JsonProperty("DPD-4-7-1-18")
    private String DPD_4_7_1_18; // 每周透析天数(天)
    public String getDPD_4_7_1_18() {  return this.DPD_4_7_1_18;}
    @JsonProperty("DPD-4-7-1-18")
    public void setDPD_4_7_1_18(final String DPD_4_7_1_18) { this.DPD_4_7_1_18=DPD_4_7_1_18;}
    @Column(name = "DPD_4_7_1_15")
    @JsonProperty("DPD-4-7-1-15")
    private String DPD_4_7_1_15; // 每周总Kt/V尿素清除指数
    public String getDPD_4_7_1_15() {  return this.DPD_4_7_1_15;}
    @JsonProperty("DPD-4-7-1-15")
    public void setDPD_4_7_1_15(final String DPD_4_7_1_15) { this.DPD_4_7_1_15=DPD_4_7_1_15;}
    @Column(name = "DPD_4_7_1_16")
    @JsonProperty("DPD-4-7-1-16")
    private String DPD_4_7_1_16; // 总内生肌酐清除率（Ccr）
    public String getDPD_4_7_1_16() {  return this.DPD_4_7_1_16;}
    @JsonProperty("DPD-4-7-1-16")
    public void setDPD_4_7_1_16(final String DPD_4_7_1_16) { this.DPD_4_7_1_16=DPD_4_7_1_16;}
    @Column(name = "DPD_4_7_1_17")
    @JsonProperty("DPD-4-7-1-17")
    private String DPD_4_7_1_17; // 完成日期
    public String getDPD_4_7_1_17() {  return this.DPD_4_7_1_17;}
    @JsonProperty("DPD-4-7-1-17")
    public void setDPD_4_7_1_17(final String DPD_4_7_1_17) { this.DPD_4_7_1_17=DPD_4_7_1_17;}
    @Column(name = "DPD_4_7_2_1")
    @JsonProperty("DPD-4-7-2-1")
    private String DPD_4_7_2_1; // 尿素清除指数 总ktv是否达标
    public String getDPD_4_7_2_1() {  return this.DPD_4_7_2_1;}
    @JsonProperty("DPD-4-7-2-1")
    public void setDPD_4_7_2_1(final String DPD_4_7_2_1) { this.DPD_4_7_2_1=DPD_4_7_2_1;}
    @Column(name = "DPD_4_7_2_2")
    @JsonProperty("DPD-4-7-2-2")
    private String DPD_4_7_2_2; // 总内生肌酐清除率 总ccr是否达标
    public String getDPD_4_7_2_2() {  return this.DPD_4_7_2_2;}
    @JsonProperty("DPD-4-7-2-2")
    public void setDPD_4_7_2_2(final String DPD_4_7_2_2) { this.DPD_4_7_2_2=DPD_4_7_2_2;}
    @Column(name = "DPD_4_8_1_1")
    @JsonProperty("DPD-4-8-1-1")
    private String DPD_4_8_1_1; // 是否有腹膜炎
    public String getDPD_4_8_1_1() {  return this.DPD_4_8_1_1;}
    @JsonProperty("DPD-4-8-1-1")
    public void setDPD_4_8_1_1(final String DPD_4_8_1_1) { this.DPD_4_8_1_1=DPD_4_8_1_1;}
    @Column(name = "DPD_4_8_1_2")
    @JsonProperty("DPD-4-8-1-2")
    private String DPD_4_8_1_2; // 报告的日期
    public String getDPD_4_8_1_2() {  return this.DPD_4_8_1_2;}
    @JsonProperty("DPD-4-8-1-2")
    public void setDPD_4_8_1_2(final String DPD_4_8_1_2) { this.DPD_4_8_1_2=DPD_4_8_1_2;}
    @Column(name = "DPD_4_8_1_3")
    @JsonProperty("DPD-4-8-1-3")
    private String DPD_4_8_1_3; // 感染类型
    public String getDPD_4_8_1_3() {  return this.DPD_4_8_1_3;}
    @JsonProperty("DPD-4-8-1-3")
    public void setDPD_4_8_1_3(final String DPD_4_8_1_3) { this.DPD_4_8_1_3=DPD_4_8_1_3;}
    @Column(name = "DPD_4_8_1_4")
    @JsonProperty("DPD-4-8-1-4")
    private String DPD_4_8_1_4; // 病原检出
    public String getDPD_4_8_1_4() {  return this.DPD_4_8_1_4;}
    @JsonProperty("DPD-4-8-1-4")
    public void setDPD_4_8_1_4(final String DPD_4_8_1_4) { this.DPD_4_8_1_4=DPD_4_8_1_4;}
    @Column(name = "DPD_4_8_1_5")
    @JsonProperty("DPD-4-8-1-5")
    private String DPD_4_8_1_5; // 培养结果
    public String getDPD_4_8_1_5() {  return this.DPD_4_8_1_5;}
    @JsonProperty("DPD-4-8-1-5")
    public void setDPD_4_8_1_5(final String DPD_4_8_1_5) { this.DPD_4_8_1_5=DPD_4_8_1_5;}
    @Column(name = "DPD_4_8_2_1")
    @JsonProperty("DPD-4-8-2-1")
    private String DPD_4_8_2_1; // 腹膜炎患者透析龄(月)
    public String getDPD_4_8_2_1() {  return this.DPD_4_8_2_1;}
    @JsonProperty("DPD-4-8-2-1")
    public void setDPD_4_8_2_1(final String DPD_4_8_2_1) { this.DPD_4_8_2_1=DPD_4_8_2_1;}
    @Column(name = "DPD_4_8_2_2")
    @JsonProperty("DPD-4-8-2-2")
    private String DPD_4_8_2_2; // 腹膜炎患者透析次数(次)
    public String getDPD_4_8_2_2() {  return this.DPD_4_8_2_2;}
    @JsonProperty("DPD-4-8-2-2")
    public void setDPD_4_8_2_2(final String DPD_4_8_2_2) { this.DPD_4_8_2_2=DPD_4_8_2_2;}
    @Column(name = "DPD_4_8_2_3_r")
    @JsonProperty("DPD-4-8-2-3-r")
    private String DPD_4_8_2_3_r; // 患者腹膜炎次数（月/次）
    public String getDPD_4_8_2_3_r() {  return this.DPD_4_8_2_3_r;}
    @JsonProperty("DPD-4-8-2-3-r")
    public void setDPD_4_8_2_3_r(final String DPD_4_8_2_3_r) { this.DPD_4_8_2_3_r=DPD_4_8_2_3_r;}
    @Column(name = "DPD_4_8_2_3")
    @JsonProperty("DPD-4-8-2-3")
    private String DPD_4_8_2_3; // 患者腹膜炎次数（月/次）
    public String getDPD_4_8_2_3() {  return this.DPD_4_8_2_3;}
    @JsonProperty("DPD-4-8-2-3")
    public void setDPD_4_8_2_3(final String DPD_4_8_2_3) { this.DPD_4_8_2_3=DPD_4_8_2_3;}
}