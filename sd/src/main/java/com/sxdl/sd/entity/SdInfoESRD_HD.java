package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：N18.0，且伴主要操作 ICD-9-CM-3编码：38.95，39.27，39.42，39.95 的血液透析患者。
*/
@ApiModel(value = "36信息")
@Entity
@Table(name = "sd_info_ESRD_HD")
public class SdInfoESRD_HD implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    public void setId(final Integer id) {this.id = id;}
    public Integer getId() {return this.id;}
    @Column(name = "HD_0_1_10")
    @JsonProperty("HD-0-1-10")
    private String HD_0_1_10; // 请选择上报年份
    public String getHD_0_1_10() {  return this.HD_0_1_10;}
    @JsonProperty("HD-0-1-10")
    public void setHD_0_1_10(final String HD_0_1_10) { this.HD_0_1_10=HD_0_1_10;}
    @Column(name = "HD_0_1_1")
    @JsonProperty("HD-0-1-1")
    private String HD_0_1_1; // 请选择上报季度
    public String getHD_0_1_1() {  return this.HD_0_1_1;}
    @JsonProperty("HD-0-1-1")
    public void setHD_0_1_1(final String HD_0_1_1) { this.HD_0_1_1=HD_0_1_1;}
    @Column(name = "HD_0_1_2")
    @JsonProperty("HD-0-1-2")
    private String HD_0_1_2; // 是否填写医院相关信息
    public String getHD_0_1_2() {  return this.HD_0_1_2;}
    @JsonProperty("HD-0-1-2")
    public void setHD_0_1_2(final String HD_0_1_2) { this.HD_0_1_2=HD_0_1_2;}
    @Column(name = "HD_0_1_3")
    @JsonProperty("HD-0-1-3")
    private String HD_0_1_3; // 中心名称
    public String getHD_0_1_3() {  return this.HD_0_1_3;}
    @JsonProperty("HD-0-1-3")
    public void setHD_0_1_3(final String HD_0_1_3) { this.HD_0_1_3=HD_0_1_3;}
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
    @Column(name = "HD_0_1_6")
    @JsonProperty("HD-0-1-6")
    private String HD_0_1_6; // 中心性质
    public String getHD_0_1_6() {  return this.HD_0_1_6;}
    @JsonProperty("HD-0-1-6")
    public void setHD_0_1_6(final String HD_0_1_6) { this.HD_0_1_6=HD_0_1_6;}
    @Column(name = "HD_0_1_8")
    @JsonProperty("HD-0-1-8")
    private String HD_0_1_8; // 医院级别
    public String getHD_0_1_8() {  return this.HD_0_1_8;}
    @JsonProperty("HD-0-1-8")
    public void setHD_0_1_8(final String HD_0_1_8) { this.HD_0_1_8=HD_0_1_8;}
    @Column(name = "HD_0_1_9")
    @JsonProperty("HD-0-1-9")
    private String HD_0_1_9; // 所有制形式
    public String getHD_0_1_9() {  return this.HD_0_1_9;}
    @JsonProperty("HD-0-1-9")
    public void setHD_0_1_9(final String HD_0_1_9) { this.HD_0_1_9=HD_0_1_9;}
    @Column(name = "HD_0_2_1")
    @JsonProperty("HD-0-2-1")
    private String HD_0_2_1; // 患者姓名
    public String getHD_0_2_1() {  return this.HD_0_2_1;}
    @JsonProperty("HD-0-2-1")
    public void setHD_0_2_1(final String HD_0_2_1) { this.HD_0_2_1=HD_0_2_1;}
    @Column(name = "HD_0_2_4")
    @JsonProperty("HD-0-2-4")
    private String HD_0_2_4; // 身份证号类别
    public String getHD_0_2_4() {  return this.HD_0_2_4;}
    @JsonProperty("HD-0-2-4")
    public void setHD_0_2_4(final String HD_0_2_4) { this.HD_0_2_4=HD_0_2_4;}
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard; // 患者身份证号
    public String getIDCard() {  return this.IDCard;}
    @JsonProperty("IDCard")
    public void setIDCard(final String IDCard) { this.IDCard=IDCard;}
    @Column(name = "HD_0_2_5")
    @JsonProperty("HD-0-2-5")
    private String HD_0_2_5; // 其他身份证号
    public String getHD_0_2_5() {  return this.HD_0_2_5;}
    @JsonProperty("HD-0-2-5")
    public void setHD_0_2_5(final String HD_0_2_5) { this.HD_0_2_5=HD_0_2_5;}
    @Column(name = "CM_0_2_1_2")
    @JsonProperty("CM-0-2-1-2")
    private String CM_0_2_1_2; // 患者性别
    public String getCM_0_2_1_2() {  return this.CM_0_2_1_2;}
    @JsonProperty("CM-0-2-1-2")
    public void setCM_0_2_1_2(final String CM_0_2_1_2) { this.CM_0_2_1_2=CM_0_2_1_2;}
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
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 患者费别
    public String getCM_0_3_1() {  return this.CM_0_3_1;}
    @JsonProperty("CM-0-3-1")
    public void setCM_0_3_1(final String CM_0_3_1) { this.CM_0_3_1=CM_0_3_1;}
    @Column(name = "HD_0_2_2")
    @JsonProperty("HD-0-2-2")
    private String HD_0_2_2; // 门诊号
    public String getHD_0_2_2() {  return this.HD_0_2_2;}
    @JsonProperty("HD-0-2-2")
    public void setHD_0_2_2(final String HD_0_2_2) { this.HD_0_2_2=HD_0_2_2;}
    @Column(name = "HD_0_2_3")
    @JsonProperty("HD-0-2-3")
    private String HD_0_2_3; // 透析病案号
    public String getHD_0_2_3() {  return this.HD_0_2_3;}
    @JsonProperty("HD-0-2-3")
    public void setHD_0_2_3(final String HD_0_2_3) { this.HD_0_2_3=HD_0_2_3;}
    @Column(name = "HD_0_3_1")
    @JsonProperty("HD-0-3-1")
    private String HD_0_3_1; // 首次肾脏替代治疗日期
    public String getHD_0_3_1() {  return this.HD_0_3_1;}
    @JsonProperty("HD-0-3-1")
    public void setHD_0_3_1(final String HD_0_3_1) { this.HD_0_3_1=HD_0_3_1;}
    @Column(name = "HD_0_3_2")
    @JsonProperty("HD-0-3-2")
    private String HD_0_3_2; // 进入本透析室日期
    public String getHD_0_3_2() {  return this.HD_0_3_2;}
    @JsonProperty("HD-0-3-2")
    public void setHD_0_3_2(final String HD_0_3_2) { this.HD_0_3_2=HD_0_3_2;}
    @Column(name = "HD_0_3_3")
    @JsonProperty("HD-0-3-3")
    private String HD_0_3_3; // 原发病诊断
    public String getHD_0_3_3() {  return this.HD_0_3_3;}
    @JsonProperty("HD-0-3-3")
    public void setHD_0_3_3(final String HD_0_3_3) { this.HD_0_3_3=HD_0_3_3;}
    @Column(name = "HD_0_3_4")
    @JsonProperty("HD-0-3-4")
    private String HD_0_3_4; // 原发病初始诊断日期
    public String getHD_0_3_4() {  return this.HD_0_3_4;}
    @JsonProperty("HD-0-3-4")
    public void setHD_0_3_4(final String HD_0_3_4) { this.HD_0_3_4=HD_0_3_4;}
    @Column(name = "HD_0_4_1")
    @JsonProperty("HD-0-4-1")
    private String HD_0_4_1; // 透析状态是否在透析中
    public String getHD_0_4_1() {  return this.HD_0_4_1;}
    @JsonProperty("HD-0-4-1")
    public void setHD_0_4_1(final String HD_0_4_1) { this.HD_0_4_1=HD_0_4_1;}
    @Column(name = "HD_0_4_2")
    @JsonProperty("HD-0-4-2")
    private String HD_0_4_2; // 患者转归
    public String getHD_0_4_2() {  return this.HD_0_4_2;}
    @JsonProperty("HD-0-4-2")
    public void setHD_0_4_2(final String HD_0_4_2) { this.HD_0_4_2=HD_0_4_2;}
    @Column(name = "HD_0_4_3")
    @JsonProperty("HD-0-4-3")
    private String HD_0_4_3; // 转归日期
    public String getHD_0_4_3() {  return this.HD_0_4_3;}
    @JsonProperty("HD-0-4-3")
    public void setHD_0_4_3(final String HD_0_4_3) { this.HD_0_4_3=HD_0_4_3;}
    @Column(name = "HD_0_4_4")
    @JsonProperty("HD-0-4-4")
    private String HD_0_4_4; // 首要死亡原因
    public String getHD_0_4_4() {  return this.HD_0_4_4;}
    @JsonProperty("HD-0-4-4")
    public void setHD_0_4_4(final String HD_0_4_4) { this.HD_0_4_4=HD_0_4_4;}
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
    @Column(name = "HD_1_0_3_1")
    @JsonProperty("HD-1-0-3-1")
    private String HD_1_0_3_1; // 一月份治疗室空气平均菌落数合格情况
    public String getHD_1_0_3_1() {  return this.HD_1_0_3_1;}
    @JsonProperty("HD-1-0-3-1")
    public void setHD_1_0_3_1(final String HD_1_0_3_1) { this.HD_1_0_3_1=HD_1_0_3_1;}
    @Column(name = "HD_1_0_3_3")
    @JsonProperty("HD-1-0-3-3")
    private String HD_1_0_3_3; // 二月份治疗室空气平均菌落数合格情况
    public String getHD_1_0_3_3() {  return this.HD_1_0_3_3;}
    @JsonProperty("HD-1-0-3-3")
    public void setHD_1_0_3_3(final String HD_1_0_3_3) { this.HD_1_0_3_3=HD_1_0_3_3;}
    @Column(name = "HD_1_0_3_5")
    @JsonProperty("HD-1-0-3-5")
    private String HD_1_0_3_5; // 三月份治疗室空气平均菌落数合格情况
    public String getHD_1_0_3_5() {  return this.HD_1_0_3_5;}
    @JsonProperty("HD-1-0-3-5")
    public void setHD_1_0_3_5(final String HD_1_0_3_5) { this.HD_1_0_3_5=HD_1_0_3_5;}
    @Column(name = "HD_1_0_3_2")
    @JsonProperty("HD-1-0-3-2")
    private String HD_1_0_3_2; // 一月份物品表面平均菌落数合格情况
    public String getHD_1_0_3_2() {  return this.HD_1_0_3_2;}
    @JsonProperty("HD-1-0-3-2")
    public void setHD_1_0_3_2(final String HD_1_0_3_2) { this.HD_1_0_3_2=HD_1_0_3_2;}
    @Column(name = "HD_1_0_3_4")
    @JsonProperty("HD-1-0-3-4")
    private String HD_1_0_3_4; // 二月份物品表面平均菌落数合格情况
    public String getHD_1_0_3_4() {  return this.HD_1_0_3_4;}
    @JsonProperty("HD-1-0-3-4")
    public void setHD_1_0_3_4(final String HD_1_0_3_4) { this.HD_1_0_3_4=HD_1_0_3_4;}
    @Column(name = "HD_1_0_3_6")
    @JsonProperty("HD-1-0-3-6")
    private String HD_1_0_3_6; // 三月份物品表面平均菌落数合格情况
    public String getHD_1_0_3_6() {  return this.HD_1_0_3_6;}
    @JsonProperty("HD-1-0-3-6")
    public void setHD_1_0_3_6(final String HD_1_0_3_6) { this.HD_1_0_3_6=HD_1_0_3_6;}
    @Column(name = "HD_1_0_4_1")
    @JsonProperty("HD-1-0-4-1")
    private String HD_1_0_4_1; // 一月份透析用水细菌培养合格情况
    public String getHD_1_0_4_1() {  return this.HD_1_0_4_1;}
    @JsonProperty("HD-1-0-4-1")
    public void setHD_1_0_4_1(final String HD_1_0_4_1) { this.HD_1_0_4_1=HD_1_0_4_1;}
    @Column(name = "HD_1_0_4_3")
    @JsonProperty("HD-1-0-4-3")
    private String HD_1_0_4_3; // 二月份透析用水细菌培养合格情况
    public String getHD_1_0_4_3() {  return this.HD_1_0_4_3;}
    @JsonProperty("HD-1-0-4-3")
    public void setHD_1_0_4_3(final String HD_1_0_4_3) { this.HD_1_0_4_3=HD_1_0_4_3;}
    @Column(name = "HD_1_0_4_5")
    @JsonProperty("HD-1-0-4-5")
    private String HD_1_0_4_5; // 三月份透析用水细菌培养合格情况
    public String getHD_1_0_4_5() {  return this.HD_1_0_4_5;}
    @JsonProperty("HD-1-0-4-5")
    public void setHD_1_0_4_5(final String HD_1_0_4_5) { this.HD_1_0_4_5=HD_1_0_4_5;}
    @Column(name = "HD_1_0_4_2")
    @JsonProperty("HD-1-0-4-2")
    private String HD_1_0_4_2; // 一月份透析用水内毒素合格情况
    public String getHD_1_0_4_2() {  return this.HD_1_0_4_2;}
    @JsonProperty("HD-1-0-4-2")
    public void setHD_1_0_4_2(final String HD_1_0_4_2) { this.HD_1_0_4_2=HD_1_0_4_2;}
    @Column(name = "HD_1_0_4_4")
    @JsonProperty("HD-1-0-4-4")
    private String HD_1_0_4_4; // 二月份透析用水内毒素合格情况
    public String getHD_1_0_4_4() {  return this.HD_1_0_4_4;}
    @JsonProperty("HD-1-0-4-4")
    public void setHD_1_0_4_4(final String HD_1_0_4_4) { this.HD_1_0_4_4=HD_1_0_4_4;}
    @Column(name = "HD_1_0_4_6")
    @JsonProperty("HD-1-0-4-6")
    private String HD_1_0_4_6; // 三月份透析用水内毒素合格情况
    public String getHD_1_0_4_6() {  return this.HD_1_0_4_6;}
    @JsonProperty("HD-1-0-4-6")
    public void setHD_1_0_4_6(final String HD_1_0_4_6) { this.HD_1_0_4_6=HD_1_0_4_6;}
    @Column(name = "HD_1_1_1_1")
    @JsonProperty("HD-1-1-1-1")
    private String HD_1_1_1_1; // 1季度/是否改变通路
    public String getHD_1_1_1_1() {  return this.HD_1_1_1_1;}
    @JsonProperty("HD-1-1-1-1")
    public void setHD_1_1_1_1(final String HD_1_1_1_1) { this.HD_1_1_1_1=HD_1_1_1_1;}
    @Column(name = "HD_1_1_1_2")
    @JsonProperty("HD-1-1-1-2")
    private String HD_1_1_1_2; // 1季度/血管通路类型
    public String getHD_1_1_1_2() {  return this.HD_1_1_1_2;}
    @JsonProperty("HD-1-1-1-2")
    public void setHD_1_1_1_2(final String HD_1_1_1_2) { this.HD_1_1_1_2=HD_1_1_1_2;}
    @Column(name = "HD_1_1_1_3")
    @JsonProperty("HD-1-1-1-3")
    private String HD_1_1_1_3; // 其他血管通路类型
    public String getHD_1_1_1_3() {  return this.HD_1_1_1_3;}
    @JsonProperty("HD-1-1-1-3")
    public void setHD_1_1_1_3(final String HD_1_1_1_3) { this.HD_1_1_1_3=HD_1_1_1_3;}
    @Column(name = "HD_1_1_1_4")
    @JsonProperty("HD-1-1-1-4")
    private String HD_1_1_1_4; // 该血管通路开始使用时间
    public String getHD_1_1_1_4() {  return this.HD_1_1_1_4;}
    @JsonProperty("HD-1-1-1-4")
    public void setHD_1_1_1_4(final String HD_1_1_1_4) { this.HD_1_1_1_4=HD_1_1_1_4;}
    @Column(name = "HD_1_1_1_5")
    @JsonProperty("HD-1-1-1-5")
    private String HD_1_1_1_5; // 1季度/通路改变原因
    public String getHD_1_1_1_5() {  return this.HD_1_1_1_5;}
    @JsonProperty("HD-1-1-1-5")
    public void setHD_1_1_1_5(final String HD_1_1_1_5) { this.HD_1_1_1_5=HD_1_1_1_5;}
    @Column(name = "HD_1_1_1_6")
    @JsonProperty("HD-1-1-1-6")
    private String HD_1_1_1_6; // 通路改变其他原因
    public String getHD_1_1_1_6() {  return this.HD_1_1_1_6;}
    @JsonProperty("HD-1-1-1-6")
    public void setHD_1_1_1_6(final String HD_1_1_1_6) { this.HD_1_1_1_6=HD_1_1_1_6;}
    @Column(name = "HD_1_2_1_1")
    @JsonProperty("HD-1-2-1-1")
    private String HD_1_2_1_1; // 1季度/检查日期
    public String getHD_1_2_1_1() {  return this.HD_1_2_1_1;}
    @JsonProperty("HD-1-2-1-1")
    public void setHD_1_2_1_1(final String HD_1_2_1_1) { this.HD_1_2_1_1=HD_1_2_1_1;}
    @Column(name = "HD_1_2_1_2")
    @JsonProperty("HD-1-2-1-2")
    private String HD_1_2_1_2; // 1季度/透析前SBP(mmHg)
    public String getHD_1_2_1_2() {  return this.HD_1_2_1_2;}
    @JsonProperty("HD-1-2-1-2")
    public void setHD_1_2_1_2(final String HD_1_2_1_2) { this.HD_1_2_1_2=HD_1_2_1_2;}
    @Column(name = "HD_1_2_1_3")
    @JsonProperty("HD-1-2-1-3")
    private String HD_1_2_1_3; // 1季度/透析前DBP(mmHg)
    public String getHD_1_2_1_3() {  return this.HD_1_2_1_3;}
    @JsonProperty("HD-1-2-1-3")
    public void setHD_1_2_1_3(final String HD_1_2_1_3) { this.HD_1_2_1_3=HD_1_2_1_3;}
    @Column(name = "HD_1_3_1_1")
    @JsonProperty("HD-1-3-1-1")
    private String HD_1_3_1_1; // 透析治疗频次
    public String getHD_1_3_1_1() {  return this.HD_1_3_1_1;}
    @JsonProperty("HD-1-3-1-1")
    public void setHD_1_3_1_1(final String HD_1_3_1_1) { this.HD_1_3_1_1=HD_1_3_1_1;}
    @Column(name = "HD_1_3_1_2")
    @JsonProperty("HD-1-3-1-2")
    private String HD_1_3_1_2; // 其他透析治疗频次
    public String getHD_1_3_1_2() {  return this.HD_1_3_1_2;}
    @JsonProperty("HD-1-3-1-2")
    public void setHD_1_3_1_2(final String HD_1_3_1_2) { this.HD_1_3_1_2=HD_1_3_1_2;}
    @Column(name = "HD_1_3_1_3")
    @JsonProperty("HD-1-3-1-3")
    private String HD_1_3_1_3; // 透析治疗时间
    public String getHD_1_3_1_3() {  return this.HD_1_3_1_3;}
    @JsonProperty("HD-1-3-1-3")
    public void setHD_1_3_1_3(final String HD_1_3_1_3) { this.HD_1_3_1_3=HD_1_3_1_3;}
    @Column(name = "HD_1_3_1_4")
    @JsonProperty("HD-1-3-1-4")
    private String HD_1_3_1_4; // 检查日期
    public String getHD_1_3_1_4() {  return this.HD_1_3_1_4;}
    @JsonProperty("HD-1-3-1-4")
    public void setHD_1_3_1_4(final String HD_1_3_1_4) { this.HD_1_3_1_4=HD_1_3_1_4;}
    @Column(name = "HD_1_3_1_6")
    @JsonProperty("HD-1-3-1-6")
    private String HD_1_3_1_6; // 透后体重(kg)
    public String getHD_1_3_1_6() {  return this.HD_1_3_1_6;}
    @JsonProperty("HD-1-3-1-6")
    public void setHD_1_3_1_6(final String HD_1_3_1_6) { this.HD_1_3_1_6=HD_1_3_1_6;}
    @Column(name = "HD_1_3_1_7")
    @JsonProperty("HD-1-3-1-7")
    private String HD_1_3_1_7; // 超滤量(L)
    public String getHD_1_3_1_7() {  return this.HD_1_3_1_7;}
    @JsonProperty("HD-1-3-1-7")
    public void setHD_1_3_1_7(final String HD_1_3_1_7) { this.HD_1_3_1_7=HD_1_3_1_7;}
    @Column(name = "HD_1_3_1_8")
    @JsonProperty("HD-1-3-1-8")
    private String HD_1_3_1_8; // 透前血尿素氮(mmol/L)
    public String getHD_1_3_1_8() {  return this.HD_1_3_1_8;}
    @JsonProperty("HD-1-3-1-8")
    public void setHD_1_3_1_8(final String HD_1_3_1_8) { this.HD_1_3_1_8=HD_1_3_1_8;}
    @Column(name = "HD_1_3_1_9")
    @JsonProperty("HD-1-3-1-9")
    private String HD_1_3_1_9; // 透后血尿素氮(mmol/L)
    public String getHD_1_3_1_9() {  return this.HD_1_3_1_9;}
    @JsonProperty("HD-1-3-1-9")
    public void setHD_1_3_1_9(final String HD_1_3_1_9) { this.HD_1_3_1_9=HD_1_3_1_9;}
    @Column(name = "HD_1_3_1_10")
    @JsonProperty("HD-1-3-1-10")
    private String HD_1_3_1_10; // URR(%)
    public String getHD_1_3_1_10() {  return this.HD_1_3_1_10;}
    @JsonProperty("HD-1-3-1-10")
    public void setHD_1_3_1_10(final String HD_1_3_1_10) { this.HD_1_3_1_10=HD_1_3_1_10;}
    @Column(name = "HD_1_3_1_11")
    @JsonProperty("HD-1-3-1-11")
    private String HD_1_3_1_11; // spKt/V
    public String getHD_1_3_1_11() {  return this.HD_1_3_1_11;}
    @JsonProperty("HD-1-3-1-11")
    public void setHD_1_3_1_11(final String HD_1_3_1_11) { this.HD_1_3_1_11=HD_1_3_1_11;}
    @Column(name = "HD_1_4_1_1")
    @JsonProperty("HD-1-4-1-1")
    private String HD_1_4_1_1; // 实验室指标选择
    public String getHD_1_4_1_1() {  return this.HD_1_4_1_1;}
    @JsonProperty("HD-1-4-1-1")
    public void setHD_1_4_1_1(final String HD_1_4_1_1) { this.HD_1_4_1_1=HD_1_4_1_1;}
    @Column(name = "HD_1_4_1_2")
    @JsonProperty("HD-1-4-1-2")
    private String HD_1_4_1_2; // 血常规_检查日期
    public String getHD_1_4_1_2() {  return this.HD_1_4_1_2;}
    @JsonProperty("HD-1-4-1-2")
    public void setHD_1_4_1_2(final String HD_1_4_1_2) { this.HD_1_4_1_2=HD_1_4_1_2;}
    @Column(name = "HD_1_4_1_3")
    @JsonProperty("HD-1-4-1-3")
    private String HD_1_4_1_3; // 血红蛋白_检测结果(g/L)
    public String getHD_1_4_1_3() {  return this.HD_1_4_1_3;}
    @JsonProperty("HD-1-4-1-3")
    public void setHD_1_4_1_3(final String HD_1_4_1_3) { this.HD_1_4_1_3=HD_1_4_1_3;}
    @Column(name = "HD_1_4_1_4")
    @JsonProperty("HD-1-4-1-4")
    private String HD_1_4_1_4; // 铁代谢_检查日期
    public String getHD_1_4_1_4() {  return this.HD_1_4_1_4;}
    @JsonProperty("HD-1-4-1-4")
    public void setHD_1_4_1_4(final String HD_1_4_1_4) { this.HD_1_4_1_4=HD_1_4_1_4;}
    @Column(name = "HD_1_4_1_5")
    @JsonProperty("HD-1-4-1-5")
    private String HD_1_4_1_5; // 转铁饱和度_检测结果(%)
    public String getHD_1_4_1_5() {  return this.HD_1_4_1_5;}
    @JsonProperty("HD-1-4-1-5")
    public void setHD_1_4_1_5(final String HD_1_4_1_5) { this.HD_1_4_1_5=HD_1_4_1_5;}
    @Column(name = "HD_1_4_1_6")
    @JsonProperty("HD-1-4-1-6")
    private String HD_1_4_1_6; // 铁蛋白_检测结果(μg/L)
    public String getHD_1_4_1_6() {  return this.HD_1_4_1_6;}
    @JsonProperty("HD-1-4-1-6")
    public void setHD_1_4_1_6(final String HD_1_4_1_6) { this.HD_1_4_1_6=HD_1_4_1_6;}
    @Column(name = "HD_1_4_2_1")
    @JsonProperty("HD-1-4-2-1")
    private String HD_1_4_2_1; // 钙磷代谢_检查日期
    public String getHD_1_4_2_1() {  return this.HD_1_4_2_1;}
    @JsonProperty("HD-1-4-2-1")
    public void setHD_1_4_2_1(final String HD_1_4_2_1) { this.HD_1_4_2_1=HD_1_4_2_1;}
    @Column(name = "HD_1_4_2_2")
    @JsonProperty("HD-1-4-2-2")
    private String HD_1_4_2_2; // 血钙_检测结果(mmol/L)
    public String getHD_1_4_2_2() {  return this.HD_1_4_2_2;}
    @JsonProperty("HD-1-4-2-2")
    public void setHD_1_4_2_2(final String HD_1_4_2_2) { this.HD_1_4_2_2=HD_1_4_2_2;}
    @Column(name = "HD_1_4_2_3")
    @JsonProperty("HD-1-4-2-3")
    private String HD_1_4_2_3; // 血磷_检测结果(mmol/L)
    public String getHD_1_4_2_3() {  return this.HD_1_4_2_3;}
    @JsonProperty("HD-1-4-2-3")
    public void setHD_1_4_2_3(final String HD_1_4_2_3) { this.HD_1_4_2_3=HD_1_4_2_3;}
    @Column(name = "HD_1_4_2_4")
    @JsonProperty("HD-1-4-2-4")
    private String HD_1_4_2_4; // 甲状旁腺激素(PTH)_检查日期
    public String getHD_1_4_2_4() {  return this.HD_1_4_2_4;}
    @JsonProperty("HD-1-4-2-4")
    public void setHD_1_4_2_4(final String HD_1_4_2_4) { this.HD_1_4_2_4=HD_1_4_2_4;}
    @Column(name = "HD_1_4_2_5")
    @JsonProperty("HD-1-4-2-5")
    private String HD_1_4_2_5; // PTH_检测结果(pg/mL)
    public String getHD_1_4_2_5() {  return this.HD_1_4_2_5;}
    @JsonProperty("HD-1-4-2-5")
    public void setHD_1_4_2_5(final String HD_1_4_2_5) { this.HD_1_4_2_5=HD_1_4_2_5;}
    @Column(name = "HD_1_4_3_1")
    @JsonProperty("HD-1-4-3-1")
    private String HD_1_4_3_1; // 血清白蛋白_检查日期
    public String getHD_1_4_3_1() {  return this.HD_1_4_3_1;}
    @JsonProperty("HD-1-4-3-1")
    public void setHD_1_4_3_1(final String HD_1_4_3_1) { this.HD_1_4_3_1=HD_1_4_3_1;}
    @Column(name = "HD_1_4_3_2")
    @JsonProperty("HD-1-4-3-2")
    private String HD_1_4_3_2; // 血清白蛋白_检测结果(g/L)
    public String getHD_1_4_3_2() {  return this.HD_1_4_3_2;}
    @JsonProperty("HD-1-4-3-2")
    public void setHD_1_4_3_2(final String HD_1_4_3_2) { this.HD_1_4_3_2=HD_1_4_3_2;}
    @Column(name = "HD_1_4_4_1")
    @JsonProperty("HD-1-4-4-1")
    private String HD_1_4_4_1; // C反应蛋白_检查日期
    public String getHD_1_4_4_1() {  return this.HD_1_4_4_1;}
    @JsonProperty("HD-1-4-4-1")
    public void setHD_1_4_4_1(final String HD_1_4_4_1) { this.HD_1_4_4_1=HD_1_4_4_1;}
    @Column(name = "HD_1_4_4_2")
    @JsonProperty("HD-1-4-4-2")
    private String HD_1_4_4_2; // C反应蛋白_检测结果(mg/dL)
    public String getHD_1_4_4_2() {  return this.HD_1_4_4_2;}
    @JsonProperty("HD-1-4-4-2")
    public void setHD_1_4_4_2(final String HD_1_4_4_2) { this.HD_1_4_4_2=HD_1_4_4_2;}
    @Column(name = "HD_1_4_4_3")
    @JsonProperty("HD-1-4-4-3")
    private String HD_1_4_4_3; // 前白蛋白_检查日期
    public String getHD_1_4_4_3() {  return this.HD_1_4_4_3;}
    @JsonProperty("HD-1-4-4-3")
    public void setHD_1_4_4_3(final String HD_1_4_4_3) { this.HD_1_4_4_3=HD_1_4_4_3;}
    @Column(name = "HD_1_4_4_4")
    @JsonProperty("HD-1-4-4-4")
    private String HD_1_4_4_4; // 前白蛋白_检测结果(mg/dL)
    public String getHD_1_4_4_4() {  return this.HD_1_4_4_4;}
    @JsonProperty("HD-1-4-4-4")
    public void setHD_1_4_4_4(final String HD_1_4_4_4) { this.HD_1_4_4_4=HD_1_4_4_4;}
    @Column(name = "HD_1_4_4_5")
    @JsonProperty("HD-1-4-4-5")
    private String HD_1_4_4_5; // β2微球蛋白_检查日期
    public String getHD_1_4_4_5() {  return this.HD_1_4_4_5;}
    @JsonProperty("HD-1-4-4-5")
    public void setHD_1_4_4_5(final String HD_1_4_4_5) { this.HD_1_4_4_5=HD_1_4_4_5;}
    @Column(name = "HD_1_4_4_6")
    @JsonProperty("HD-1-4-4-6")
    private String HD_1_4_4_6; // β2微球蛋白_检测结果(mg/dL)
    public String getHD_1_4_4_6() {  return this.HD_1_4_4_6;}
    @JsonProperty("HD-1-4-4-6")
    public void setHD_1_4_4_6(final String HD_1_4_4_6) { this.HD_1_4_4_6=HD_1_4_4_6;}
    @Column(name = "HD_1_5_1_1")
    @JsonProperty("HD-1-5-1-1")
    private String HD_1_5_1_1; // 血源性传染病标志物检查
    public String getHD_1_5_1_1() {  return this.HD_1_5_1_1;}
    @JsonProperty("HD-1-5-1-1")
    public void setHD_1_5_1_1(final String HD_1_5_1_1) { this.HD_1_5_1_1=HD_1_5_1_1;}
    @Column(name = "HD_1_5_1_2")
    @JsonProperty("HD-1-5-1-2")
    private String HD_1_5_1_2; // 乙肝标志物_检查日期
    public String getHD_1_5_1_2() {  return this.HD_1_5_1_2;}
    @JsonProperty("HD-1-5-1-2")
    public void setHD_1_5_1_2(final String HD_1_5_1_2) { this.HD_1_5_1_2=HD_1_5_1_2;}
    @Column(name = "HD_1_5_1_3")
    @JsonProperty("HD-1-5-1-3")
    private String HD_1_5_1_3; // HBsAg_检测结果
    public String getHD_1_5_1_3() {  return this.HD_1_5_1_3;}
    @JsonProperty("HD-1-5-1-3")
    public void setHD_1_5_1_3(final String HD_1_5_1_3) { this.HD_1_5_1_3=HD_1_5_1_3;}
    @Column(name = "HD_1_5_1_4")
    @JsonProperty("HD-1-5-1-4")
    private String HD_1_5_1_4; // 丙肝标志物_检查日期
    public String getHD_1_5_1_4() {  return this.HD_1_5_1_4;}
    @JsonProperty("HD-1-5-1-4")
    public void setHD_1_5_1_4(final String HD_1_5_1_4) { this.HD_1_5_1_4=HD_1_5_1_4;}
    @Column(name = "HD_1_5_1_5")
    @JsonProperty("HD-1-5-1-5")
    private String HD_1_5_1_5; // AntiHCV_检测结果
    public String getHD_1_5_1_5() {  return this.HD_1_5_1_5;}
    @JsonProperty("HD-1-5-1-5")
    public void setHD_1_5_1_5(final String HD_1_5_1_5) { this.HD_1_5_1_5=HD_1_5_1_5;}
    @Column(name = "HD_1_5_1_6")
    @JsonProperty("HD-1-5-1-6")
    private String HD_1_5_1_6; // HIV标志物_检查日期
    public String getHD_1_5_1_6() {  return this.HD_1_5_1_6;}
    @JsonProperty("HD-1-5-1-6")
    public void setHD_1_5_1_6(final String HD_1_5_1_6) { this.HD_1_5_1_6=HD_1_5_1_6;}
    @Column(name = "HD_1_5_1_7")
    @JsonProperty("HD-1-5-1-7")
    private String HD_1_5_1_7; // HIV抗体_检测结果
    public String getHD_1_5_1_7() {  return this.HD_1_5_1_7;}
    @JsonProperty("HD-1-5-1-7")
    public void setHD_1_5_1_7(final String HD_1_5_1_7) { this.HD_1_5_1_7=HD_1_5_1_7;}
    @Column(name = "HD_1_5_1_8")
    @JsonProperty("HD-1-5-1-8")
    private String HD_1_5_1_8; // 梅毒标志物_检查日期
    public String getHD_1_5_1_8() {  return this.HD_1_5_1_8;}
    @JsonProperty("HD-1-5-1-8")
    public void setHD_1_5_1_8(final String HD_1_5_1_8) { this.HD_1_5_1_8=HD_1_5_1_8;}
    @Column(name = "HD_1_5_1_9")
    @JsonProperty("HD-1-5-1-9")
    private String HD_1_5_1_9; // 梅毒_检测结果
    public String getHD_1_5_1_9() {  return this.HD_1_5_1_9;}
    @JsonProperty("HD-1-5-1-9")
    public void setHD_1_5_1_9(final String HD_1_5_1_9) { this.HD_1_5_1_9=HD_1_5_1_9;}
    @Column(name = "HD_1_6_1_1")
    @JsonProperty("HD-1-6-1-1")
    private String HD_1_6_1_1; // 是否为患者提供血液透析治疗健康教育
    public String getHD_1_6_1_1() {  return this.HD_1_6_1_1;}
    @JsonProperty("HD-1-6-1-1")
    public void setHD_1_6_1_1(final String HD_1_6_1_1) { this.HD_1_6_1_1=HD_1_6_1_1;}
    @Column(name = "HD_1_6_1_2")
    @JsonProperty("HD-1-6-1-2")
    private String HD_1_6_1_2; // 血液透析治疗前健康教育
    public String getHD_1_6_1_2() {  return this.HD_1_6_1_2;}
    @JsonProperty("HD-1-6-1-2")
    public void setHD_1_6_1_2(final String HD_1_6_1_2) { this.HD_1_6_1_2=HD_1_6_1_2;}
    @Column(name = "HD_1_6_1_3")
    @JsonProperty("HD-1-6-1-3")
    private String HD_1_6_1_3; // 血液透析治疗后健康教育
    public String getHD_1_6_1_3() {  return this.HD_1_6_1_3;}
    @JsonProperty("HD-1-6-1-3")
    public void setHD_1_6_1_3(final String HD_1_6_1_3) { this.HD_1_6_1_3=HD_1_6_1_3;}
    @Column(name = "HD_2_0_3_1")
    @JsonProperty("HD-2-0-3-1")
    private String HD_2_0_3_1; // 四月份治疗室空气平均菌落数合格情况
    public String getHD_2_0_3_1() {  return this.HD_2_0_3_1;}
    @JsonProperty("HD-2-0-3-1")
    public void setHD_2_0_3_1(final String HD_2_0_3_1) { this.HD_2_0_3_1=HD_2_0_3_1;}
    @Column(name = "HD_2_0_3_3")
    @JsonProperty("HD-2-0-3-3")
    private String HD_2_0_3_3; // 五月份治疗室空气平均菌落数合格情况
    public String getHD_2_0_3_3() {  return this.HD_2_0_3_3;}
    @JsonProperty("HD-2-0-3-3")
    public void setHD_2_0_3_3(final String HD_2_0_3_3) { this.HD_2_0_3_3=HD_2_0_3_3;}
    @Column(name = "HD_2_0_3_5")
    @JsonProperty("HD-2-0-3-5")
    private String HD_2_0_3_5; // 六月份治疗室空气平均菌落数合格情况
    public String getHD_2_0_3_5() {  return this.HD_2_0_3_5;}
    @JsonProperty("HD-2-0-3-5")
    public void setHD_2_0_3_5(final String HD_2_0_3_5) { this.HD_2_0_3_5=HD_2_0_3_5;}
    @Column(name = "HD_2_0_3_2")
    @JsonProperty("HD-2-0-3-2")
    private String HD_2_0_3_2; // 四月份物品表面平均菌落数合格情况
    public String getHD_2_0_3_2() {  return this.HD_2_0_3_2;}
    @JsonProperty("HD-2-0-3-2")
    public void setHD_2_0_3_2(final String HD_2_0_3_2) { this.HD_2_0_3_2=HD_2_0_3_2;}
    @Column(name = "HD_2_0_3_4")
    @JsonProperty("HD-2-0-3-4")
    private String HD_2_0_3_4; // 五月份物品表面平均菌落数合格情况
    public String getHD_2_0_3_4() {  return this.HD_2_0_3_4;}
    @JsonProperty("HD-2-0-3-4")
    public void setHD_2_0_3_4(final String HD_2_0_3_4) { this.HD_2_0_3_4=HD_2_0_3_4;}
    @Column(name = "HD_2_0_3_6")
    @JsonProperty("HD-2-0-3-6")
    private String HD_2_0_3_6; // 六月份物品表面平均菌落数合格情况
    public String getHD_2_0_3_6() {  return this.HD_2_0_3_6;}
    @JsonProperty("HD-2-0-3-6")
    public void setHD_2_0_3_6(final String HD_2_0_3_6) { this.HD_2_0_3_6=HD_2_0_3_6;}
    @Column(name = "HD_2_0_4_1")
    @JsonProperty("HD-2-0-4-1")
    private String HD_2_0_4_1; // 四月份透析用水细菌培养合格情况
    public String getHD_2_0_4_1() {  return this.HD_2_0_4_1;}
    @JsonProperty("HD-2-0-4-1")
    public void setHD_2_0_4_1(final String HD_2_0_4_1) { this.HD_2_0_4_1=HD_2_0_4_1;}
    @Column(name = "HD_2_0_4_3")
    @JsonProperty("HD-2-0-4-3")
    private String HD_2_0_4_3; // 五月份透析用水细菌培养合格情况
    public String getHD_2_0_4_3() {  return this.HD_2_0_4_3;}
    @JsonProperty("HD-2-0-4-3")
    public void setHD_2_0_4_3(final String HD_2_0_4_3) { this.HD_2_0_4_3=HD_2_0_4_3;}
    @Column(name = "HD_2_0_4_5")
    @JsonProperty("HD-2-0-4-5")
    private String HD_2_0_4_5; // 六月份透析用水细菌培养合格情况
    public String getHD_2_0_4_5() {  return this.HD_2_0_4_5;}
    @JsonProperty("HD-2-0-4-5")
    public void setHD_2_0_4_5(final String HD_2_0_4_5) { this.HD_2_0_4_5=HD_2_0_4_5;}
    @Column(name = "HD_2_0_4_2")
    @JsonProperty("HD-2-0-4-2")
    private String HD_2_0_4_2; // 四月份透析用水内毒素合格情况
    public String getHD_2_0_4_2() {  return this.HD_2_0_4_2;}
    @JsonProperty("HD-2-0-4-2")
    public void setHD_2_0_4_2(final String HD_2_0_4_2) { this.HD_2_0_4_2=HD_2_0_4_2;}
    @Column(name = "HD_2_0_4_4")
    @JsonProperty("HD-2-0-4-4")
    private String HD_2_0_4_4; // 五月份透析用水内毒素合格情况
    public String getHD_2_0_4_4() {  return this.HD_2_0_4_4;}
    @JsonProperty("HD-2-0-4-4")
    public void setHD_2_0_4_4(final String HD_2_0_4_4) { this.HD_2_0_4_4=HD_2_0_4_4;}
    @Column(name = "HD_2_0_4_6")
    @JsonProperty("HD-2-0-4-6")
    private String HD_2_0_4_6; // 六月份透析用水内毒素合格情况
    public String getHD_2_0_4_6() {  return this.HD_2_0_4_6;}
    @JsonProperty("HD-2-0-4-6")
    public void setHD_2_0_4_6(final String HD_2_0_4_6) { this.HD_2_0_4_6=HD_2_0_4_6;}
    @Column(name = "HD_2_1_1_2")
    @JsonProperty("HD-2-1-1-2")
    private String HD_2_1_1_2; // 2季度/是否改变通路
    public String getHD_2_1_1_2() {  return this.HD_2_1_1_2;}
    @JsonProperty("HD-2-1-1-2")
    public void setHD_2_1_1_2(final String HD_2_1_1_2) { this.HD_2_1_1_2=HD_2_1_1_2;}
    @Column(name = "HD_2_1_1_3")
    @JsonProperty("HD-2-1-1-3")
    private String HD_2_1_1_3; // 2季度/血管通路类型
    public String getHD_2_1_1_3() {  return this.HD_2_1_1_3;}
    @JsonProperty("HD-2-1-1-3")
    public void setHD_2_1_1_3(final String HD_2_1_1_3) { this.HD_2_1_1_3=HD_2_1_1_3;}
    @Column(name = "HD_2_1_1_4")
    @JsonProperty("HD-2-1-1-4")
    private String HD_2_1_1_4; // 其他血管通路类型
    public String getHD_2_1_1_4() {  return this.HD_2_1_1_4;}
    @JsonProperty("HD-2-1-1-4")
    public void setHD_2_1_1_4(final String HD_2_1_1_4) { this.HD_2_1_1_4=HD_2_1_1_4;}
    @Column(name = "HD_2_1_1_5")
    @JsonProperty("HD-2-1-1-5")
    private String HD_2_1_1_5; // 该血管通路开始使用时间
    public String getHD_2_1_1_5() {  return this.HD_2_1_1_5;}
    @JsonProperty("HD-2-1-1-5")
    public void setHD_2_1_1_5(final String HD_2_1_1_5) { this.HD_2_1_1_5=HD_2_1_1_5;}
    @Column(name = "HD_2_1_1_6")
    @JsonProperty("HD-2-1-1-6")
    private String HD_2_1_1_6; // 2季度/通路改变原因
    public String getHD_2_1_1_6() {  return this.HD_2_1_1_6;}
    @JsonProperty("HD-2-1-1-6")
    public void setHD_2_1_1_6(final String HD_2_1_1_6) { this.HD_2_1_1_6=HD_2_1_1_6;}
    @Column(name = "HD_2_1_1_7")
    @JsonProperty("HD-2-1-1-7")
    private String HD_2_1_1_7; // 通路改变其他原因
    public String getHD_2_1_1_7() {  return this.HD_2_1_1_7;}
    @JsonProperty("HD-2-1-1-7")
    public void setHD_2_1_1_7(final String HD_2_1_1_7) { this.HD_2_1_1_7=HD_2_1_1_7;}
    @Column(name = "HD_2_2_1_1")
    @JsonProperty("HD-2-2-1-1")
    private String HD_2_2_1_1; // 2季度/检查日期
    public String getHD_2_2_1_1() {  return this.HD_2_2_1_1;}
    @JsonProperty("HD-2-2-1-1")
    public void setHD_2_2_1_1(final String HD_2_2_1_1) { this.HD_2_2_1_1=HD_2_2_1_1;}
    @Column(name = "HD_2_2_1_2")
    @JsonProperty("HD-2-2-1-2")
    private String HD_2_2_1_2; // 2季度/透析前SBP(mmHg)
    public String getHD_2_2_1_2() {  return this.HD_2_2_1_2;}
    @JsonProperty("HD-2-2-1-2")
    public void setHD_2_2_1_2(final String HD_2_2_1_2) { this.HD_2_2_1_2=HD_2_2_1_2;}
    @Column(name = "HD_2_2_1_3")
    @JsonProperty("HD-2-2-1-3")
    private String HD_2_2_1_3; // 2季度/透析前DBP(mmHg)
    public String getHD_2_2_1_3() {  return this.HD_2_2_1_3;}
    @JsonProperty("HD-2-2-1-3")
    public void setHD_2_2_1_3(final String HD_2_2_1_3) { this.HD_2_2_1_3=HD_2_2_1_3;}
    @Column(name = "HD_2_3_1_1")
    @JsonProperty("HD-2-3-1-1")
    private String HD_2_3_1_1; // 透析治疗频次
    public String getHD_2_3_1_1() {  return this.HD_2_3_1_1;}
    @JsonProperty("HD-2-3-1-1")
    public void setHD_2_3_1_1(final String HD_2_3_1_1) { this.HD_2_3_1_1=HD_2_3_1_1;}
    @Column(name = "HD_2_3_1_2")
    @JsonProperty("HD-2-3-1-2")
    private String HD_2_3_1_2; // 其他透析治疗频次
    public String getHD_2_3_1_2() {  return this.HD_2_3_1_2;}
    @JsonProperty("HD-2-3-1-2")
    public void setHD_2_3_1_2(final String HD_2_3_1_2) { this.HD_2_3_1_2=HD_2_3_1_2;}
    @Column(name = "HD_2_3_1_3")
    @JsonProperty("HD-2-3-1-3")
    private String HD_2_3_1_3; // 透析治疗时间
    public String getHD_2_3_1_3() {  return this.HD_2_3_1_3;}
    @JsonProperty("HD-2-3-1-3")
    public void setHD_2_3_1_3(final String HD_2_3_1_3) { this.HD_2_3_1_3=HD_2_3_1_3;}
    @Column(name = "HD_2_3_1_4")
    @JsonProperty("HD-2-3-1-4")
    private String HD_2_3_1_4; // 检查日期
    public String getHD_2_3_1_4() {  return this.HD_2_3_1_4;}
    @JsonProperty("HD-2-3-1-4")
    public void setHD_2_3_1_4(final String HD_2_3_1_4) { this.HD_2_3_1_4=HD_2_3_1_4;}
    @Column(name = "HD_2_3_1_6")
    @JsonProperty("HD-2-3-1-6")
    private String HD_2_3_1_6; // 透后体重(kg)
    public String getHD_2_3_1_6() {  return this.HD_2_3_1_6;}
    @JsonProperty("HD-2-3-1-6")
    public void setHD_2_3_1_6(final String HD_2_3_1_6) { this.HD_2_3_1_6=HD_2_3_1_6;}
    @Column(name = "HD_2_3_1_7")
    @JsonProperty("HD-2-3-1-7")
    private String HD_2_3_1_7; // 超滤量(L)
    public String getHD_2_3_1_7() {  return this.HD_2_3_1_7;}
    @JsonProperty("HD-2-3-1-7")
    public void setHD_2_3_1_7(final String HD_2_3_1_7) { this.HD_2_3_1_7=HD_2_3_1_7;}
    @Column(name = "HD_2_3_1_8")
    @JsonProperty("HD-2-3-1-8")
    private String HD_2_3_1_8; // 透前血尿素氮(mmol/L)
    public String getHD_2_3_1_8() {  return this.HD_2_3_1_8;}
    @JsonProperty("HD-2-3-1-8")
    public void setHD_2_3_1_8(final String HD_2_3_1_8) { this.HD_2_3_1_8=HD_2_3_1_8;}
    @Column(name = "HD_2_3_1_9")
    @JsonProperty("HD-2-3-1-9")
    private String HD_2_3_1_9; // 透后血尿素氮(mmol/L)
    public String getHD_2_3_1_9() {  return this.HD_2_3_1_9;}
    @JsonProperty("HD-2-3-1-9")
    public void setHD_2_3_1_9(final String HD_2_3_1_9) { this.HD_2_3_1_9=HD_2_3_1_9;}
    @Column(name = "HD_2_3_1_10")
    @JsonProperty("HD-2-3-1-10")
    private String HD_2_3_1_10; // URR(%)
    public String getHD_2_3_1_10() {  return this.HD_2_3_1_10;}
    @JsonProperty("HD-2-3-1-10")
    public void setHD_2_3_1_10(final String HD_2_3_1_10) { this.HD_2_3_1_10=HD_2_3_1_10;}
    @Column(name = "HD_2_3_1_11")
    @JsonProperty("HD-2-3-1-11")
    private String HD_2_3_1_11; // spKt/V
    public String getHD_2_3_1_11() {  return this.HD_2_3_1_11;}
    @JsonProperty("HD-2-3-1-11")
    public void setHD_2_3_1_11(final String HD_2_3_1_11) { this.HD_2_3_1_11=HD_2_3_1_11;}
    @Column(name = "HD_2_4_1_1")
    @JsonProperty("HD-2-4-1-1")
    private String HD_2_4_1_1; // 实验室指标选择
    public String getHD_2_4_1_1() {  return this.HD_2_4_1_1;}
    @JsonProperty("HD-2-4-1-1")
    public void setHD_2_4_1_1(final String HD_2_4_1_1) { this.HD_2_4_1_1=HD_2_4_1_1;}
    @Column(name = "HD_2_4_1_2")
    @JsonProperty("HD-2-4-1-2")
    private String HD_2_4_1_2; // 血常规_检查日期
    public String getHD_2_4_1_2() {  return this.HD_2_4_1_2;}
    @JsonProperty("HD-2-4-1-2")
    public void setHD_2_4_1_2(final String HD_2_4_1_2) { this.HD_2_4_1_2=HD_2_4_1_2;}
    @Column(name = "HD_2_4_1_3")
    @JsonProperty("HD-2-4-1-3")
    private String HD_2_4_1_3; // 血红蛋白_检测结果(g/L)
    public String getHD_2_4_1_3() {  return this.HD_2_4_1_3;}
    @JsonProperty("HD-2-4-1-3")
    public void setHD_2_4_1_3(final String HD_2_4_1_3) { this.HD_2_4_1_3=HD_2_4_1_3;}
    @Column(name = "HD_2_4_1_4")
    @JsonProperty("HD-2-4-1-4")
    private String HD_2_4_1_4; // 铁代谢_检查日期
    public String getHD_2_4_1_4() {  return this.HD_2_4_1_4;}
    @JsonProperty("HD-2-4-1-4")
    public void setHD_2_4_1_4(final String HD_2_4_1_4) { this.HD_2_4_1_4=HD_2_4_1_4;}
    @Column(name = "HD_2_4_1_5")
    @JsonProperty("HD-2-4-1-5")
    private String HD_2_4_1_5; // 转铁饱和度_检测结果(%)
    public String getHD_2_4_1_5() {  return this.HD_2_4_1_5;}
    @JsonProperty("HD-2-4-1-5")
    public void setHD_2_4_1_5(final String HD_2_4_1_5) { this.HD_2_4_1_5=HD_2_4_1_5;}
    @Column(name = "HD_2_4_1_6")
    @JsonProperty("HD-2-4-1-6")
    private String HD_2_4_1_6; // 铁蛋白_检测结果(μg/L)
    public String getHD_2_4_1_6() {  return this.HD_2_4_1_6;}
    @JsonProperty("HD-2-4-1-6")
    public void setHD_2_4_1_6(final String HD_2_4_1_6) { this.HD_2_4_1_6=HD_2_4_1_6;}
    @Column(name = "HD_2_4_2_1")
    @JsonProperty("HD-2-4-2-1")
    private String HD_2_4_2_1; // 钙磷代谢_检查日期
    public String getHD_2_4_2_1() {  return this.HD_2_4_2_1;}
    @JsonProperty("HD-2-4-2-1")
    public void setHD_2_4_2_1(final String HD_2_4_2_1) { this.HD_2_4_2_1=HD_2_4_2_1;}
    @Column(name = "HD_2_4_2_2")
    @JsonProperty("HD-2-4-2-2")
    private String HD_2_4_2_2; // 血钙_检测结果(mmol/L)
    public String getHD_2_4_2_2() {  return this.HD_2_4_2_2;}
    @JsonProperty("HD-2-4-2-2")
    public void setHD_2_4_2_2(final String HD_2_4_2_2) { this.HD_2_4_2_2=HD_2_4_2_2;}
    @Column(name = "HD_2_4_2_3")
    @JsonProperty("HD-2-4-2-3")
    private String HD_2_4_2_3; // 血磷_检测结果(mmol/L)
    public String getHD_2_4_2_3() {  return this.HD_2_4_2_3;}
    @JsonProperty("HD-2-4-2-3")
    public void setHD_2_4_2_3(final String HD_2_4_2_3) { this.HD_2_4_2_3=HD_2_4_2_3;}
    @Column(name = "HD_2_4_2_4")
    @JsonProperty("HD-2-4-2-4")
    private String HD_2_4_2_4; // 甲状旁腺激素(PTH)_检查日期
    public String getHD_2_4_2_4() {  return this.HD_2_4_2_4;}
    @JsonProperty("HD-2-4-2-4")
    public void setHD_2_4_2_4(final String HD_2_4_2_4) { this.HD_2_4_2_4=HD_2_4_2_4;}
    @Column(name = "HD_2_4_2_5")
    @JsonProperty("HD-2-4-2-5")
    private String HD_2_4_2_5; // PTH_检测结果(pg/mL)
    public String getHD_2_4_2_5() {  return this.HD_2_4_2_5;}
    @JsonProperty("HD-2-4-2-5")
    public void setHD_2_4_2_5(final String HD_2_4_2_5) { this.HD_2_4_2_5=HD_2_4_2_5;}
    @Column(name = "HD_2_4_3_1")
    @JsonProperty("HD-2-4-3-1")
    private String HD_2_4_3_1; // 血清白蛋白_检查日期
    public String getHD_2_4_3_1() {  return this.HD_2_4_3_1;}
    @JsonProperty("HD-2-4-3-1")
    public void setHD_2_4_3_1(final String HD_2_4_3_1) { this.HD_2_4_3_1=HD_2_4_3_1;}
    @Column(name = "HD_2_4_3_2")
    @JsonProperty("HD-2-4-3-2")
    private String HD_2_4_3_2; // 血清白蛋白_检测结果(g/L)
    public String getHD_2_4_3_2() {  return this.HD_2_4_3_2;}
    @JsonProperty("HD-2-4-3-2")
    public void setHD_2_4_3_2(final String HD_2_4_3_2) { this.HD_2_4_3_2=HD_2_4_3_2;}
    @Column(name = "HD_2_4_4_1")
    @JsonProperty("HD-2-4-4-1")
    private String HD_2_4_4_1; // C反应蛋白_检查日期
    public String getHD_2_4_4_1() {  return this.HD_2_4_4_1;}
    @JsonProperty("HD-2-4-4-1")
    public void setHD_2_4_4_1(final String HD_2_4_4_1) { this.HD_2_4_4_1=HD_2_4_4_1;}
    @Column(name = "HD_2_4_4_2")
    @JsonProperty("HD-2-4-4-2")
    private String HD_2_4_4_2; // C反应蛋白_检测结果(mg/dL)
    public String getHD_2_4_4_2() {  return this.HD_2_4_4_2;}
    @JsonProperty("HD-2-4-4-2")
    public void setHD_2_4_4_2(final String HD_2_4_4_2) { this.HD_2_4_4_2=HD_2_4_4_2;}
    @Column(name = "HD_2_4_4_3")
    @JsonProperty("HD-2-4-4-3")
    private String HD_2_4_4_3; // 前白蛋白_检查日期
    public String getHD_2_4_4_3() {  return this.HD_2_4_4_3;}
    @JsonProperty("HD-2-4-4-3")
    public void setHD_2_4_4_3(final String HD_2_4_4_3) { this.HD_2_4_4_3=HD_2_4_4_3;}
    @Column(name = "HD_2_4_4_4")
    @JsonProperty("HD-2-4-4-4")
    private String HD_2_4_4_4; // 前白蛋白_检测结果(mg/dL)
    public String getHD_2_4_4_4() {  return this.HD_2_4_4_4;}
    @JsonProperty("HD-2-4-4-4")
    public void setHD_2_4_4_4(final String HD_2_4_4_4) { this.HD_2_4_4_4=HD_2_4_4_4;}
    @Column(name = "HD_2_4_4_5")
    @JsonProperty("HD-2-4-4-5")
    private String HD_2_4_4_5; // β2微球蛋白_检查日期
    public String getHD_2_4_4_5() {  return this.HD_2_4_4_5;}
    @JsonProperty("HD-2-4-4-5")
    public void setHD_2_4_4_5(final String HD_2_4_4_5) { this.HD_2_4_4_5=HD_2_4_4_5;}
    @Column(name = "HD_2_4_4_6")
    @JsonProperty("HD-2-4-4-6")
    private String HD_2_4_4_6; // β2微球蛋白_检测结果(mg/dL)
    public String getHD_2_4_4_6() {  return this.HD_2_4_4_6;}
    @JsonProperty("HD-2-4-4-6")
    public void setHD_2_4_4_6(final String HD_2_4_4_6) { this.HD_2_4_4_6=HD_2_4_4_6;}
    @Column(name = "HD_2_5_1_1")
    @JsonProperty("HD-2-5-1-1")
    private String HD_2_5_1_1; // 血源性传染病标志物检查
    public String getHD_2_5_1_1() {  return this.HD_2_5_1_1;}
    @JsonProperty("HD-2-5-1-1")
    public void setHD_2_5_1_1(final String HD_2_5_1_1) { this.HD_2_5_1_1=HD_2_5_1_1;}
    @Column(name = "HD_2_5_1_2")
    @JsonProperty("HD-2-5-1-2")
    private String HD_2_5_1_2; // 乙肝标志物_检查日期
    public String getHD_2_5_1_2() {  return this.HD_2_5_1_2;}
    @JsonProperty("HD-2-5-1-2")
    public void setHD_2_5_1_2(final String HD_2_5_1_2) { this.HD_2_5_1_2=HD_2_5_1_2;}
    @Column(name = "HD_2_5_1_3")
    @JsonProperty("HD-2-5-1-3")
    private String HD_2_5_1_3; // HBsAg_检测结果
    public String getHD_2_5_1_3() {  return this.HD_2_5_1_3;}
    @JsonProperty("HD-2-5-1-3")
    public void setHD_2_5_1_3(final String HD_2_5_1_3) { this.HD_2_5_1_3=HD_2_5_1_3;}
    @Column(name = "HD_2_5_1_4")
    @JsonProperty("HD-2-5-1-4")
    private String HD_2_5_1_4; // 丙肝标志物_检查日期
    public String getHD_2_5_1_4() {  return this.HD_2_5_1_4;}
    @JsonProperty("HD-2-5-1-4")
    public void setHD_2_5_1_4(final String HD_2_5_1_4) { this.HD_2_5_1_4=HD_2_5_1_4;}
    @Column(name = "HD_2_5_1_5")
    @JsonProperty("HD-2-5-1-5")
    private String HD_2_5_1_5; // AntiHCV_检测结果
    public String getHD_2_5_1_5() {  return this.HD_2_5_1_5;}
    @JsonProperty("HD-2-5-1-5")
    public void setHD_2_5_1_5(final String HD_2_5_1_5) { this.HD_2_5_1_5=HD_2_5_1_5;}
    @Column(name = "HD_2_5_1_6")
    @JsonProperty("HD-2-5-1-6")
    private String HD_2_5_1_6; // HIV标志物_检查日期
    public String getHD_2_5_1_6() {  return this.HD_2_5_1_6;}
    @JsonProperty("HD-2-5-1-6")
    public void setHD_2_5_1_6(final String HD_2_5_1_6) { this.HD_2_5_1_6=HD_2_5_1_6;}
    @Column(name = "HD_2_5_1_7")
    @JsonProperty("HD-2-5-1-7")
    private String HD_2_5_1_7; // HIV抗体_检测结果
    public String getHD_2_5_1_7() {  return this.HD_2_5_1_7;}
    @JsonProperty("HD-2-5-1-7")
    public void setHD_2_5_1_7(final String HD_2_5_1_7) { this.HD_2_5_1_7=HD_2_5_1_7;}
    @Column(name = "HD_2_5_1_8")
    @JsonProperty("HD-2-5-1-8")
    private String HD_2_5_1_8; // 梅毒标志物_检查日期
    public String getHD_2_5_1_8() {  return this.HD_2_5_1_8;}
    @JsonProperty("HD-2-5-1-8")
    public void setHD_2_5_1_8(final String HD_2_5_1_8) { this.HD_2_5_1_8=HD_2_5_1_8;}
    @Column(name = "HD_2_5_1_9")
    @JsonProperty("HD-2-5-1-9")
    private String HD_2_5_1_9; // 梅毒_检测结果
    public String getHD_2_5_1_9() {  return this.HD_2_5_1_9;}
    @JsonProperty("HD-2-5-1-9")
    public void setHD_2_5_1_9(final String HD_2_5_1_9) { this.HD_2_5_1_9=HD_2_5_1_9;}
    @Column(name = "HD_2_6_1_1")
    @JsonProperty("HD-2-6-1-1")
    private String HD_2_6_1_1; // 是否为患者提供血液透析治疗健康教育
    public String getHD_2_6_1_1() {  return this.HD_2_6_1_1;}
    @JsonProperty("HD-2-6-1-1")
    public void setHD_2_6_1_1(final String HD_2_6_1_1) { this.HD_2_6_1_1=HD_2_6_1_1;}
    @Column(name = "HD_2_6_1_2")
    @JsonProperty("HD-2-6-1-2")
    private String HD_2_6_1_2; // 血液透析治疗前健康教育
    public String getHD_2_6_1_2() {  return this.HD_2_6_1_2;}
    @JsonProperty("HD-2-6-1-2")
    public void setHD_2_6_1_2(final String HD_2_6_1_2) { this.HD_2_6_1_2=HD_2_6_1_2;}
    @Column(name = "HD_2_6_1_3")
    @JsonProperty("HD-2-6-1-3")
    private String HD_2_6_1_3; // 血液透析治疗后健康教育
    public String getHD_2_6_1_3() {  return this.HD_2_6_1_3;}
    @JsonProperty("HD-2-6-1-3")
    public void setHD_2_6_1_3(final String HD_2_6_1_3) { this.HD_2_6_1_3=HD_2_6_1_3;}
    @Column(name = "HD_3_0_3_1")
    @JsonProperty("HD-3-0-3-1")
    private String HD_3_0_3_1; // 七月份治疗室空气平均菌落数合格情况
    public String getHD_3_0_3_1() {  return this.HD_3_0_3_1;}
    @JsonProperty("HD-3-0-3-1")
    public void setHD_3_0_3_1(final String HD_3_0_3_1) { this.HD_3_0_3_1=HD_3_0_3_1;}
    @Column(name = "HD_3_0_3_3")
    @JsonProperty("HD-3-0-3-3")
    private String HD_3_0_3_3; // 八月份治疗室空气平均菌落数合格情况
    public String getHD_3_0_3_3() {  return this.HD_3_0_3_3;}
    @JsonProperty("HD-3-0-3-3")
    public void setHD_3_0_3_3(final String HD_3_0_3_3) { this.HD_3_0_3_3=HD_3_0_3_3;}
    @Column(name = "HD_3_0_3_5")
    @JsonProperty("HD-3-0-3-5")
    private String HD_3_0_3_5; // 九月份治疗室空气平均菌落数合格情况
    public String getHD_3_0_3_5() {  return this.HD_3_0_3_5;}
    @JsonProperty("HD-3-0-3-5")
    public void setHD_3_0_3_5(final String HD_3_0_3_5) { this.HD_3_0_3_5=HD_3_0_3_5;}
    @Column(name = "HD_3_0_3_2")
    @JsonProperty("HD-3-0-3-2")
    private String HD_3_0_3_2; // 七月份物品表面平均菌落数合格情况
    public String getHD_3_0_3_2() {  return this.HD_3_0_3_2;}
    @JsonProperty("HD-3-0-3-2")
    public void setHD_3_0_3_2(final String HD_3_0_3_2) { this.HD_3_0_3_2=HD_3_0_3_2;}
    @Column(name = "HD_3_0_3_4")
    @JsonProperty("HD-3-0-3-4")
    private String HD_3_0_3_4; // 八月份物品表面平均菌落数合格情况
    public String getHD_3_0_3_4() {  return this.HD_3_0_3_4;}
    @JsonProperty("HD-3-0-3-4")
    public void setHD_3_0_3_4(final String HD_3_0_3_4) { this.HD_3_0_3_4=HD_3_0_3_4;}
    @Column(name = "HD_3_0_3_6")
    @JsonProperty("HD-3-0-3-6")
    private String HD_3_0_3_6; // 九月份物品表面平均菌落数合格情况
    public String getHD_3_0_3_6() {  return this.HD_3_0_3_6;}
    @JsonProperty("HD-3-0-3-6")
    public void setHD_3_0_3_6(final String HD_3_0_3_6) { this.HD_3_0_3_6=HD_3_0_3_6;}
    @Column(name = "HD_3_0_4_1")
    @JsonProperty("HD-3-0-4-1")
    private String HD_3_0_4_1; // 七月份透析用水细菌培养合格情况
    public String getHD_3_0_4_1() {  return this.HD_3_0_4_1;}
    @JsonProperty("HD-3-0-4-1")
    public void setHD_3_0_4_1(final String HD_3_0_4_1) { this.HD_3_0_4_1=HD_3_0_4_1;}
    @Column(name = "HD_3_0_4_3")
    @JsonProperty("HD-3-0-4-3")
    private String HD_3_0_4_3; // 八月份透析用水细菌培养合格情况
    public String getHD_3_0_4_3() {  return this.HD_3_0_4_3;}
    @JsonProperty("HD-3-0-4-3")
    public void setHD_3_0_4_3(final String HD_3_0_4_3) { this.HD_3_0_4_3=HD_3_0_4_3;}
    @Column(name = "HD_3_0_4_5")
    @JsonProperty("HD-3-0-4-5")
    private String HD_3_0_4_5; // 九月份透析用水细菌培养合格情况
    public String getHD_3_0_4_5() {  return this.HD_3_0_4_5;}
    @JsonProperty("HD-3-0-4-5")
    public void setHD_3_0_4_5(final String HD_3_0_4_5) { this.HD_3_0_4_5=HD_3_0_4_5;}
    @Column(name = "HD_3_0_4_2")
    @JsonProperty("HD-3-0-4-2")
    private String HD_3_0_4_2; // 七月份透析用水内毒素合格情况
    public String getHD_3_0_4_2() {  return this.HD_3_0_4_2;}
    @JsonProperty("HD-3-0-4-2")
    public void setHD_3_0_4_2(final String HD_3_0_4_2) { this.HD_3_0_4_2=HD_3_0_4_2;}
    @Column(name = "HD_3_0_4_4")
    @JsonProperty("HD-3-0-4-4")
    private String HD_3_0_4_4; // 八月份透析用水内毒素合格情况
    public String getHD_3_0_4_4() {  return this.HD_3_0_4_4;}
    @JsonProperty("HD-3-0-4-4")
    public void setHD_3_0_4_4(final String HD_3_0_4_4) { this.HD_3_0_4_4=HD_3_0_4_4;}
    @Column(name = "HD_3_0_4_6")
    @JsonProperty("HD-3-0-4-6")
    private String HD_3_0_4_6; // 九月份透析用水内毒素合格情况
    public String getHD_3_0_4_6() {  return this.HD_3_0_4_6;}
    @JsonProperty("HD-3-0-4-6")
    public void setHD_3_0_4_6(final String HD_3_0_4_6) { this.HD_3_0_4_6=HD_3_0_4_6;}
    @Column(name = "HD_3_1_1_1")
    @JsonProperty("HD-3-1-1-1")
    private String HD_3_1_1_1; // 3季度/是否改变通路
    public String getHD_3_1_1_1() {  return this.HD_3_1_1_1;}
    @JsonProperty("HD-3-1-1-1")
    public void setHD_3_1_1_1(final String HD_3_1_1_1) { this.HD_3_1_1_1=HD_3_1_1_1;}
    @Column(name = "HD_3_1_1_2")
    @JsonProperty("HD-3-1-1-2")
    private String HD_3_1_1_2; // 3季度/血管通路类型
    public String getHD_3_1_1_2() {  return this.HD_3_1_1_2;}
    @JsonProperty("HD-3-1-1-2")
    public void setHD_3_1_1_2(final String HD_3_1_1_2) { this.HD_3_1_1_2=HD_3_1_1_2;}
    @Column(name = "HD_3_1_1_5")
    @JsonProperty("HD-3-1-1-5")
    private String HD_3_1_1_5; // 其他血管通路类型
    public String getHD_3_1_1_5() {  return this.HD_3_1_1_5;}
    @JsonProperty("HD-3-1-1-5")
    public void setHD_3_1_1_5(final String HD_3_1_1_5) { this.HD_3_1_1_5=HD_3_1_1_5;}
    @Column(name = "HD_3_1_1_6")
    @JsonProperty("HD-3-1-1-6")
    private String HD_3_1_1_6; // 该血管通路开始使用时间
    public String getHD_3_1_1_6() {  return this.HD_3_1_1_6;}
    @JsonProperty("HD-3-1-1-6")
    public void setHD_3_1_1_6(final String HD_3_1_1_6) { this.HD_3_1_1_6=HD_3_1_1_6;}
    @Column(name = "HD_3_1_1_7")
    @JsonProperty("HD-3-1-1-7")
    private String HD_3_1_1_7; // 3季度/通路改变原因
    public String getHD_3_1_1_7() {  return this.HD_3_1_1_7;}
    @JsonProperty("HD-3-1-1-7")
    public void setHD_3_1_1_7(final String HD_3_1_1_7) { this.HD_3_1_1_7=HD_3_1_1_7;}
    @Column(name = "HD_3_1_1_8")
    @JsonProperty("HD-3-1-1-8")
    private String HD_3_1_1_8; // 通路改变其他原因
    public String getHD_3_1_1_8() {  return this.HD_3_1_1_8;}
    @JsonProperty("HD-3-1-1-8")
    public void setHD_3_1_1_8(final String HD_3_1_1_8) { this.HD_3_1_1_8=HD_3_1_1_8;}
    @Column(name = "HD_3_2_1_1")
    @JsonProperty("HD-3-2-1-1")
    private String HD_3_2_1_1; // 3季度/检查日期
    public String getHD_3_2_1_1() {  return this.HD_3_2_1_1;}
    @JsonProperty("HD-3-2-1-1")
    public void setHD_3_2_1_1(final String HD_3_2_1_1) { this.HD_3_2_1_1=HD_3_2_1_1;}
    @Column(name = "HD_3_2_1_2")
    @JsonProperty("HD-3-2-1-2")
    private String HD_3_2_1_2; // 3季度/透析前SBP(mmHg)
    public String getHD_3_2_1_2() {  return this.HD_3_2_1_2;}
    @JsonProperty("HD-3-2-1-2")
    public void setHD_3_2_1_2(final String HD_3_2_1_2) { this.HD_3_2_1_2=HD_3_2_1_2;}
    @Column(name = "HD_3_2_1_3")
    @JsonProperty("HD-3-2-1-3")
    private String HD_3_2_1_3; // 3季度/透析前DBP(mmHg)
    public String getHD_3_2_1_3() {  return this.HD_3_2_1_3;}
    @JsonProperty("HD-3-2-1-3")
    public void setHD_3_2_1_3(final String HD_3_2_1_3) { this.HD_3_2_1_3=HD_3_2_1_3;}
    @Column(name = "HD_3_3_1_1")
    @JsonProperty("HD-3-3-1-1")
    private String HD_3_3_1_1; // 透析治疗频次
    public String getHD_3_3_1_1() {  return this.HD_3_3_1_1;}
    @JsonProperty("HD-3-3-1-1")
    public void setHD_3_3_1_1(final String HD_3_3_1_1) { this.HD_3_3_1_1=HD_3_3_1_1;}
    @Column(name = "HD_3_3_1_2")
    @JsonProperty("HD-3-3-1-2")
    private String HD_3_3_1_2; // 其他透析治疗频次
    public String getHD_3_3_1_2() {  return this.HD_3_3_1_2;}
    @JsonProperty("HD-3-3-1-2")
    public void setHD_3_3_1_2(final String HD_3_3_1_2) { this.HD_3_3_1_2=HD_3_3_1_2;}
    @Column(name = "HD_3_3_1_3")
    @JsonProperty("HD-3-3-1-3")
    private String HD_3_3_1_3; // 透析治疗时间
    public String getHD_3_3_1_3() {  return this.HD_3_3_1_3;}
    @JsonProperty("HD-3-3-1-3")
    public void setHD_3_3_1_3(final String HD_3_3_1_3) { this.HD_3_3_1_3=HD_3_3_1_3;}
    @Column(name = "HD_3_3_1_4")
    @JsonProperty("HD-3-3-1-4")
    private String HD_3_3_1_4; // 检查日期
    public String getHD_3_3_1_4() {  return this.HD_3_3_1_4;}
    @JsonProperty("HD-3-3-1-4")
    public void setHD_3_3_1_4(final String HD_3_3_1_4) { this.HD_3_3_1_4=HD_3_3_1_4;}
    @Column(name = "HD_3_3_1_6")
    @JsonProperty("HD-3-3-1-6")
    private String HD_3_3_1_6; // 透后体重(kg)
    public String getHD_3_3_1_6() {  return this.HD_3_3_1_6;}
    @JsonProperty("HD-3-3-1-6")
    public void setHD_3_3_1_6(final String HD_3_3_1_6) { this.HD_3_3_1_6=HD_3_3_1_6;}
    @Column(name = "HD_3_3_1_7")
    @JsonProperty("HD-3-3-1-7")
    private String HD_3_3_1_7; // 超滤量(L)
    public String getHD_3_3_1_7() {  return this.HD_3_3_1_7;}
    @JsonProperty("HD-3-3-1-7")
    public void setHD_3_3_1_7(final String HD_3_3_1_7) { this.HD_3_3_1_7=HD_3_3_1_7;}
    @Column(name = "HD_3_3_1_8")
    @JsonProperty("HD-3-3-1-8")
    private String HD_3_3_1_8; // 透前血尿素氮(mmol/L)
    public String getHD_3_3_1_8() {  return this.HD_3_3_1_8;}
    @JsonProperty("HD-3-3-1-8")
    public void setHD_3_3_1_8(final String HD_3_3_1_8) { this.HD_3_3_1_8=HD_3_3_1_8;}
    @Column(name = "HD_3_3_1_9")
    @JsonProperty("HD-3-3-1-9")
    private String HD_3_3_1_9; // 透后血尿素氮(mmol/L)
    public String getHD_3_3_1_9() {  return this.HD_3_3_1_9;}
    @JsonProperty("HD-3-3-1-9")
    public void setHD_3_3_1_9(final String HD_3_3_1_9) { this.HD_3_3_1_9=HD_3_3_1_9;}
    @Column(name = "HD_3_3_1_10")
    @JsonProperty("HD-3-3-1-10")
    private String HD_3_3_1_10; // URR(%)
    public String getHD_3_3_1_10() {  return this.HD_3_3_1_10;}
    @JsonProperty("HD-3-3-1-10")
    public void setHD_3_3_1_10(final String HD_3_3_1_10) { this.HD_3_3_1_10=HD_3_3_1_10;}
    @Column(name = "HD_3_3_1_11")
    @JsonProperty("HD-3-3-1-11")
    private String HD_3_3_1_11; // spKt/V
    public String getHD_3_3_1_11() {  return this.HD_3_3_1_11;}
    @JsonProperty("HD-3-3-1-11")
    public void setHD_3_3_1_11(final String HD_3_3_1_11) { this.HD_3_3_1_11=HD_3_3_1_11;}
    @Column(name = "HD_3_4_1_1")
    @JsonProperty("HD-3-4-1-1")
    private String HD_3_4_1_1; // 实验室指标选择
    public String getHD_3_4_1_1() {  return this.HD_3_4_1_1;}
    @JsonProperty("HD-3-4-1-1")
    public void setHD_3_4_1_1(final String HD_3_4_1_1) { this.HD_3_4_1_1=HD_3_4_1_1;}
    @Column(name = "HD_3_4_1_2")
    @JsonProperty("HD-3-4-1-2")
    private String HD_3_4_1_2; // 血常规_检查日期
    public String getHD_3_4_1_2() {  return this.HD_3_4_1_2;}
    @JsonProperty("HD-3-4-1-2")
    public void setHD_3_4_1_2(final String HD_3_4_1_2) { this.HD_3_4_1_2=HD_3_4_1_2;}
    @Column(name = "HD_3_4_1_3")
    @JsonProperty("HD-3-4-1-3")
    private String HD_3_4_1_3; // 血红蛋白_检测结果(g/L)
    public String getHD_3_4_1_3() {  return this.HD_3_4_1_3;}
    @JsonProperty("HD-3-4-1-3")
    public void setHD_3_4_1_3(final String HD_3_4_1_3) { this.HD_3_4_1_3=HD_3_4_1_3;}
    @Column(name = "HD_3_4_1_4")
    @JsonProperty("HD-3-4-1-4")
    private String HD_3_4_1_4; // 铁代谢_检查日期
    public String getHD_3_4_1_4() {  return this.HD_3_4_1_4;}
    @JsonProperty("HD-3-4-1-4")
    public void setHD_3_4_1_4(final String HD_3_4_1_4) { this.HD_3_4_1_4=HD_3_4_1_4;}
    @Column(name = "HD_3_4_1_5")
    @JsonProperty("HD-3-4-1-5")
    private String HD_3_4_1_5; // 转铁饱和度_检测结果(%)
    public String getHD_3_4_1_5() {  return this.HD_3_4_1_5;}
    @JsonProperty("HD-3-4-1-5")
    public void setHD_3_4_1_5(final String HD_3_4_1_5) { this.HD_3_4_1_5=HD_3_4_1_5;}
    @Column(name = "HD_3_4_1_6")
    @JsonProperty("HD-3-4-1-6")
    private String HD_3_4_1_6; // 铁蛋白_检测结果(μg/L)
    public String getHD_3_4_1_6() {  return this.HD_3_4_1_6;}
    @JsonProperty("HD-3-4-1-6")
    public void setHD_3_4_1_6(final String HD_3_4_1_6) { this.HD_3_4_1_6=HD_3_4_1_6;}
    @Column(name = "HD_3_4_2_1")
    @JsonProperty("HD-3-4-2-1")
    private String HD_3_4_2_1; // 钙磷代谢_检查日期
    public String getHD_3_4_2_1() {  return this.HD_3_4_2_1;}
    @JsonProperty("HD-3-4-2-1")
    public void setHD_3_4_2_1(final String HD_3_4_2_1) { this.HD_3_4_2_1=HD_3_4_2_1;}
    @Column(name = "HD_3_4_2_2")
    @JsonProperty("HD-3-4-2-2")
    private String HD_3_4_2_2; // 血钙_检测结果(mmol/L)
    public String getHD_3_4_2_2() {  return this.HD_3_4_2_2;}
    @JsonProperty("HD-3-4-2-2")
    public void setHD_3_4_2_2(final String HD_3_4_2_2) { this.HD_3_4_2_2=HD_3_4_2_2;}
    @Column(name = "HD_3_4_2_3")
    @JsonProperty("HD-3-4-2-3")
    private String HD_3_4_2_3; // 血磷_检测结果(mmol/L)
    public String getHD_3_4_2_3() {  return this.HD_3_4_2_3;}
    @JsonProperty("HD-3-4-2-3")
    public void setHD_3_4_2_3(final String HD_3_4_2_3) { this.HD_3_4_2_3=HD_3_4_2_3;}
    @Column(name = "HD_3_4_2_4")
    @JsonProperty("HD-3-4-2-4")
    private String HD_3_4_2_4; // 甲状旁腺激素(PTH)_检查日期
    public String getHD_3_4_2_4() {  return this.HD_3_4_2_4;}
    @JsonProperty("HD-3-4-2-4")
    public void setHD_3_4_2_4(final String HD_3_4_2_4) { this.HD_3_4_2_4=HD_3_4_2_4;}
    @Column(name = "HD_3_4_2_5")
    @JsonProperty("HD-3-4-2-5")
    private String HD_3_4_2_5; // PTH_检测结果(pg/mL)
    public String getHD_3_4_2_5() {  return this.HD_3_4_2_5;}
    @JsonProperty("HD-3-4-2-5")
    public void setHD_3_4_2_5(final String HD_3_4_2_5) { this.HD_3_4_2_5=HD_3_4_2_5;}
    @Column(name = "HD_3_4_3_1")
    @JsonProperty("HD-3-4-3-1")
    private String HD_3_4_3_1; // 血清白蛋白_检查日期
    public String getHD_3_4_3_1() {  return this.HD_3_4_3_1;}
    @JsonProperty("HD-3-4-3-1")
    public void setHD_3_4_3_1(final String HD_3_4_3_1) { this.HD_3_4_3_1=HD_3_4_3_1;}
    @Column(name = "HD_3_4_3_2")
    @JsonProperty("HD-3-4-3-2")
    private String HD_3_4_3_2; // 血清白蛋白_检测结果(g/L)
    public String getHD_3_4_3_2() {  return this.HD_3_4_3_2;}
    @JsonProperty("HD-3-4-3-2")
    public void setHD_3_4_3_2(final String HD_3_4_3_2) { this.HD_3_4_3_2=HD_3_4_3_2;}
    @Column(name = "HD_3_4_4_1")
    @JsonProperty("HD-3-4-4-1")
    private String HD_3_4_4_1; // C反应蛋白_检查日期
    public String getHD_3_4_4_1() {  return this.HD_3_4_4_1;}
    @JsonProperty("HD-3-4-4-1")
    public void setHD_3_4_4_1(final String HD_3_4_4_1) { this.HD_3_4_4_1=HD_3_4_4_1;}
    @Column(name = "HD_3_4_4_2")
    @JsonProperty("HD-3-4-4-2")
    private String HD_3_4_4_2; // C反应蛋白_检测结果(mg/dL)
    public String getHD_3_4_4_2() {  return this.HD_3_4_4_2;}
    @JsonProperty("HD-3-4-4-2")
    public void setHD_3_4_4_2(final String HD_3_4_4_2) { this.HD_3_4_4_2=HD_3_4_4_2;}
    @Column(name = "HD_3_4_4_3")
    @JsonProperty("HD-3-4-4-3")
    private String HD_3_4_4_3; // 前白蛋白_检查日期
    public String getHD_3_4_4_3() {  return this.HD_3_4_4_3;}
    @JsonProperty("HD-3-4-4-3")
    public void setHD_3_4_4_3(final String HD_3_4_4_3) { this.HD_3_4_4_3=HD_3_4_4_3;}
    @Column(name = "HD_3_4_4_4")
    @JsonProperty("HD-3-4-4-4")
    private String HD_3_4_4_4; // 前白蛋白_检测结果(mg/dL)
    public String getHD_3_4_4_4() {  return this.HD_3_4_4_4;}
    @JsonProperty("HD-3-4-4-4")
    public void setHD_3_4_4_4(final String HD_3_4_4_4) { this.HD_3_4_4_4=HD_3_4_4_4;}
    @Column(name = "HD_3_4_4_5")
    @JsonProperty("HD-3-4-4-5")
    private String HD_3_4_4_5; // β2微球蛋白_检查日期
    public String getHD_3_4_4_5() {  return this.HD_3_4_4_5;}
    @JsonProperty("HD-3-4-4-5")
    public void setHD_3_4_4_5(final String HD_3_4_4_5) { this.HD_3_4_4_5=HD_3_4_4_5;}
    @Column(name = "HD_3_4_4_6")
    @JsonProperty("HD-3-4-4-6")
    private String HD_3_4_4_6; // β2微球蛋白_检测结果(mg/dL)
    public String getHD_3_4_4_6() {  return this.HD_3_4_4_6;}
    @JsonProperty("HD-3-4-4-6")
    public void setHD_3_4_4_6(final String HD_3_4_4_6) { this.HD_3_4_4_6=HD_3_4_4_6;}
    @Column(name = "HD_3_5_1_1")
    @JsonProperty("HD-3-5-1-1")
    private String HD_3_5_1_1; // 血源性传染病标志物检查
    public String getHD_3_5_1_1() {  return this.HD_3_5_1_1;}
    @JsonProperty("HD-3-5-1-1")
    public void setHD_3_5_1_1(final String HD_3_5_1_1) { this.HD_3_5_1_1=HD_3_5_1_1;}
    @Column(name = "HD_3_5_1_2")
    @JsonProperty("HD-3-5-1-2")
    private String HD_3_5_1_2; // 乙肝标志物_检查日期
    public String getHD_3_5_1_2() {  return this.HD_3_5_1_2;}
    @JsonProperty("HD-3-5-1-2")
    public void setHD_3_5_1_2(final String HD_3_5_1_2) { this.HD_3_5_1_2=HD_3_5_1_2;}
    @Column(name = "HD_3_5_1_3")
    @JsonProperty("HD-3-5-1-3")
    private String HD_3_5_1_3; // HBsAg_检测结果
    public String getHD_3_5_1_3() {  return this.HD_3_5_1_3;}
    @JsonProperty("HD-3-5-1-3")
    public void setHD_3_5_1_3(final String HD_3_5_1_3) { this.HD_3_5_1_3=HD_3_5_1_3;}
    @Column(name = "HD_3_5_1_4")
    @JsonProperty("HD-3-5-1-4")
    private String HD_3_5_1_4; // 丙肝标志物_检查日期
    public String getHD_3_5_1_4() {  return this.HD_3_5_1_4;}
    @JsonProperty("HD-3-5-1-4")
    public void setHD_3_5_1_4(final String HD_3_5_1_4) { this.HD_3_5_1_4=HD_3_5_1_4;}
    @Column(name = "HD_3_5_1_5")
    @JsonProperty("HD-3-5-1-5")
    private String HD_3_5_1_5; // AntiHCV_检测结果
    public String getHD_3_5_1_5() {  return this.HD_3_5_1_5;}
    @JsonProperty("HD-3-5-1-5")
    public void setHD_3_5_1_5(final String HD_3_5_1_5) { this.HD_3_5_1_5=HD_3_5_1_5;}
    @Column(name = "HD_3_5_1_6")
    @JsonProperty("HD-3-5-1-6")
    private String HD_3_5_1_6; // HIV标志物_检查日期
    public String getHD_3_5_1_6() {  return this.HD_3_5_1_6;}
    @JsonProperty("HD-3-5-1-6")
    public void setHD_3_5_1_6(final String HD_3_5_1_6) { this.HD_3_5_1_6=HD_3_5_1_6;}
    @Column(name = "HD_3_5_1_7")
    @JsonProperty("HD-3-5-1-7")
    private String HD_3_5_1_7; // HIV抗体_检测结果
    public String getHD_3_5_1_7() {  return this.HD_3_5_1_7;}
    @JsonProperty("HD-3-5-1-7")
    public void setHD_3_5_1_7(final String HD_3_5_1_7) { this.HD_3_5_1_7=HD_3_5_1_7;}
    @Column(name = "HD_3_5_1_8")
    @JsonProperty("HD-3-5-1-8")
    private String HD_3_5_1_8; // 梅毒标志物_检查日期
    public String getHD_3_5_1_8() {  return this.HD_3_5_1_8;}
    @JsonProperty("HD-3-5-1-8")
    public void setHD_3_5_1_8(final String HD_3_5_1_8) { this.HD_3_5_1_8=HD_3_5_1_8;}
    @Column(name = "HD_3_5_1_9")
    @JsonProperty("HD-3-5-1-9")
    private String HD_3_5_1_9; // 梅毒_检测结果
    public String getHD_3_5_1_9() {  return this.HD_3_5_1_9;}
    @JsonProperty("HD-3-5-1-9")
    public void setHD_3_5_1_9(final String HD_3_5_1_9) { this.HD_3_5_1_9=HD_3_5_1_9;}
    @Column(name = "HD_3_6_1_1")
    @JsonProperty("HD-3-6-1-1")
    private String HD_3_6_1_1; // 是否为患者提供血液透析治疗健康教育
    public String getHD_3_6_1_1() {  return this.HD_3_6_1_1;}
    @JsonProperty("HD-3-6-1-1")
    public void setHD_3_6_1_1(final String HD_3_6_1_1) { this.HD_3_6_1_1=HD_3_6_1_1;}
    @Column(name = "HD_3_6_1_2")
    @JsonProperty("HD-3-6-1-2")
    private String HD_3_6_1_2; // 血液透析治疗前健康教育
    public String getHD_3_6_1_2() {  return this.HD_3_6_1_2;}
    @JsonProperty("HD-3-6-1-2")
    public void setHD_3_6_1_2(final String HD_3_6_1_2) { this.HD_3_6_1_2=HD_3_6_1_2;}
    @Column(name = "HD_3_6_1_3")
    @JsonProperty("HD-3-6-1-3")
    private String HD_3_6_1_3; // 血液透析治疗后健康教育
    public String getHD_3_6_1_3() {  return this.HD_3_6_1_3;}
    @JsonProperty("HD-3-6-1-3")
    public void setHD_3_6_1_3(final String HD_3_6_1_3) { this.HD_3_6_1_3=HD_3_6_1_3;}
    @Column(name = "HD_4_0_3_1")
    @JsonProperty("HD-4-0-3-1")
    private String HD_4_0_3_1; // 十月份治疗室空气平均菌落数合格情况
    public String getHD_4_0_3_1() {  return this.HD_4_0_3_1;}
    @JsonProperty("HD-4-0-3-1")
    public void setHD_4_0_3_1(final String HD_4_0_3_1) { this.HD_4_0_3_1=HD_4_0_3_1;}
    @Column(name = "HD_4_0_3_3")
    @JsonProperty("HD-4-0-3-3")
    private String HD_4_0_3_3; // 十一月份治疗室空气平均菌落数合格情况
    public String getHD_4_0_3_3() {  return this.HD_4_0_3_3;}
    @JsonProperty("HD-4-0-3-3")
    public void setHD_4_0_3_3(final String HD_4_0_3_3) { this.HD_4_0_3_3=HD_4_0_3_3;}
    @Column(name = "HD_4_0_3_5")
    @JsonProperty("HD-4-0-3-5")
    private String HD_4_0_3_5; // 十二月份治疗室空气平均菌落数合格情况
    public String getHD_4_0_3_5() {  return this.HD_4_0_3_5;}
    @JsonProperty("HD-4-0-3-5")
    public void setHD_4_0_3_5(final String HD_4_0_3_5) { this.HD_4_0_3_5=HD_4_0_3_5;}
    @Column(name = "HD_4_0_3_2")
    @JsonProperty("HD-4-0-3-2")
    private String HD_4_0_3_2; // 十月份物品表面平均菌落数合格情况
    public String getHD_4_0_3_2() {  return this.HD_4_0_3_2;}
    @JsonProperty("HD-4-0-3-2")
    public void setHD_4_0_3_2(final String HD_4_0_3_2) { this.HD_4_0_3_2=HD_4_0_3_2;}
    @Column(name = "HD_4_0_3_4")
    @JsonProperty("HD-4-0-3-4")
    private String HD_4_0_3_4; // 十一月份物品表面平均菌落数合格情况
    public String getHD_4_0_3_4() {  return this.HD_4_0_3_4;}
    @JsonProperty("HD-4-0-3-4")
    public void setHD_4_0_3_4(final String HD_4_0_3_4) { this.HD_4_0_3_4=HD_4_0_3_4;}
    @Column(name = "HD_4_0_3_6")
    @JsonProperty("HD-4-0-3-6")
    private String HD_4_0_3_6; // 十二月份物品表面平均菌落数合格情况
    public String getHD_4_0_3_6() {  return this.HD_4_0_3_6;}
    @JsonProperty("HD-4-0-3-6")
    public void setHD_4_0_3_6(final String HD_4_0_3_6) { this.HD_4_0_3_6=HD_4_0_3_6;}
    @Column(name = "HD_4_0_4_1")
    @JsonProperty("HD-4-0-4-1")
    private String HD_4_0_4_1; // 十月份透析用水细菌培养合格情况
    public String getHD_4_0_4_1() {  return this.HD_4_0_4_1;}
    @JsonProperty("HD-4-0-4-1")
    public void setHD_4_0_4_1(final String HD_4_0_4_1) { this.HD_4_0_4_1=HD_4_0_4_1;}
    @Column(name = "HD_4_0_4_3")
    @JsonProperty("HD-4-0-4-3")
    private String HD_4_0_4_3; // 十一月份透析用水细菌培养合格情况
    public String getHD_4_0_4_3() {  return this.HD_4_0_4_3;}
    @JsonProperty("HD-4-0-4-3")
    public void setHD_4_0_4_3(final String HD_4_0_4_3) { this.HD_4_0_4_3=HD_4_0_4_3;}
    @Column(name = "HD_4_0_4_5")
    @JsonProperty("HD-4-0-4-5")
    private String HD_4_0_4_5; // 十二月份透析用水细菌培养合格情况
    public String getHD_4_0_4_5() {  return this.HD_4_0_4_5;}
    @JsonProperty("HD-4-0-4-5")
    public void setHD_4_0_4_5(final String HD_4_0_4_5) { this.HD_4_0_4_5=HD_4_0_4_5;}
    @Column(name = "HD_4_0_4_2")
    @JsonProperty("HD-4-0-4-2")
    private String HD_4_0_4_2; // 十月份透析用水内毒素合格情况
    public String getHD_4_0_4_2() {  return this.HD_4_0_4_2;}
    @JsonProperty("HD-4-0-4-2")
    public void setHD_4_0_4_2(final String HD_4_0_4_2) { this.HD_4_0_4_2=HD_4_0_4_2;}
    @Column(name = "HD_4_0_4_4")
    @JsonProperty("HD-4-0-4-4")
    private String HD_4_0_4_4; // 十一月份透析用水内毒素合格情况
    public String getHD_4_0_4_4() {  return this.HD_4_0_4_4;}
    @JsonProperty("HD-4-0-4-4")
    public void setHD_4_0_4_4(final String HD_4_0_4_4) { this.HD_4_0_4_4=HD_4_0_4_4;}
    @Column(name = "HD_4_0_4_6")
    @JsonProperty("HD-4-0-4-6")
    private String HD_4_0_4_6; // 十二月份透析用水内毒素合格情况
    public String getHD_4_0_4_6() {  return this.HD_4_0_4_6;}
    @JsonProperty("HD-4-0-4-6")
    public void setHD_4_0_4_6(final String HD_4_0_4_6) { this.HD_4_0_4_6=HD_4_0_4_6;}
    @Column(name = "HD_4_1_2_1")
    @JsonProperty("HD-4-1-2-1")
    private String HD_4_1_2_1; // 4季度/是否改变通路
    public String getHD_4_1_2_1() {  return this.HD_4_1_2_1;}
    @JsonProperty("HD-4-1-2-1")
    public void setHD_4_1_2_1(final String HD_4_1_2_1) { this.HD_4_1_2_1=HD_4_1_2_1;}
    @Column(name = "HD_4_1_2_2")
    @JsonProperty("HD-4-1-2-2")
    private String HD_4_1_2_2; // 4季度/血管通路类型
    public String getHD_4_1_2_2() {  return this.HD_4_1_2_2;}
    @JsonProperty("HD-4-1-2-2")
    public void setHD_4_1_2_2(final String HD_4_1_2_2) { this.HD_4_1_2_2=HD_4_1_2_2;}
    @Column(name = "HD_4_1_2_3")
    @JsonProperty("HD-4-1-2-3")
    private String HD_4_1_2_3; // 其他血管通路类型
    public String getHD_4_1_2_3() {  return this.HD_4_1_2_3;}
    @JsonProperty("HD-4-1-2-3")
    public void setHD_4_1_2_3(final String HD_4_1_2_3) { this.HD_4_1_2_3=HD_4_1_2_3;}
    @Column(name = "HD_4_1_2_4")
    @JsonProperty("HD-4-1-2-4")
    private String HD_4_1_2_4; // 该血管通路开始使用时间
    public String getHD_4_1_2_4() {  return this.HD_4_1_2_4;}
    @JsonProperty("HD-4-1-2-4")
    public void setHD_4_1_2_4(final String HD_4_1_2_4) { this.HD_4_1_2_4=HD_4_1_2_4;}
    @Column(name = "HD_4_1_2_5")
    @JsonProperty("HD-4-1-2-5")
    private String HD_4_1_2_5; // 4季度/通路改变原因
    public String getHD_4_1_2_5() {  return this.HD_4_1_2_5;}
    @JsonProperty("HD-4-1-2-5")
    public void setHD_4_1_2_5(final String HD_4_1_2_5) { this.HD_4_1_2_5=HD_4_1_2_5;}
    @Column(name = "HD_4_1_2_6")
    @JsonProperty("HD-4-1-2-6")
    private String HD_4_1_2_6; // 通路改变其他原因
    public String getHD_4_1_2_6() {  return this.HD_4_1_2_6;}
    @JsonProperty("HD-4-1-2-6")
    public void setHD_4_1_2_6(final String HD_4_1_2_6) { this.HD_4_1_2_6=HD_4_1_2_6;}
    @Column(name = "HD_4_2_2_1")
    @JsonProperty("HD-4-2-2-1")
    private String HD_4_2_2_1; // 4季度/检查日期
    public String getHD_4_2_2_1() {  return this.HD_4_2_2_1;}
    @JsonProperty("HD-4-2-2-1")
    public void setHD_4_2_2_1(final String HD_4_2_2_1) { this.HD_4_2_2_1=HD_4_2_2_1;}
    @Column(name = "HD_4_2_2_2")
    @JsonProperty("HD-4-2-2-2")
    private String HD_4_2_2_2; // 4季度/透析前SBP(mmHg)
    public String getHD_4_2_2_2() {  return this.HD_4_2_2_2;}
    @JsonProperty("HD-4-2-2-2")
    public void setHD_4_2_2_2(final String HD_4_2_2_2) { this.HD_4_2_2_2=HD_4_2_2_2;}
    @Column(name = "HD_4_2_2_3")
    @JsonProperty("HD-4-2-2-3")
    private String HD_4_2_2_3; // 4季度/透析前DBP(mmHg)
    public String getHD_4_2_2_3() {  return this.HD_4_2_2_3;}
    @JsonProperty("HD-4-2-2-3")
    public void setHD_4_2_2_3(final String HD_4_2_2_3) { this.HD_4_2_2_3=HD_4_2_2_3;}
    @Column(name = "HD_4_3_1_1")
    @JsonProperty("HD-4-3-1-1")
    private String HD_4_3_1_1; // 透析治疗频次
    public String getHD_4_3_1_1() {  return this.HD_4_3_1_1;}
    @JsonProperty("HD-4-3-1-1")
    public void setHD_4_3_1_1(final String HD_4_3_1_1) { this.HD_4_3_1_1=HD_4_3_1_1;}
    @Column(name = "HD_4_3_1_2")
    @JsonProperty("HD-4-3-1-2")
    private String HD_4_3_1_2; // 其他透析治疗频次
    public String getHD_4_3_1_2() {  return this.HD_4_3_1_2;}
    @JsonProperty("HD-4-3-1-2")
    public void setHD_4_3_1_2(final String HD_4_3_1_2) { this.HD_4_3_1_2=HD_4_3_1_2;}
    @Column(name = "HD_4_3_1_3")
    @JsonProperty("HD-4-3-1-3")
    private String HD_4_3_1_3; // 透析治疗时间
    public String getHD_4_3_1_3() {  return this.HD_4_3_1_3;}
    @JsonProperty("HD-4-3-1-3")
    public void setHD_4_3_1_3(final String HD_4_3_1_3) { this.HD_4_3_1_3=HD_4_3_1_3;}
    @Column(name = "HD_4_3_1_4")
    @JsonProperty("HD-4-3-1-4")
    private String HD_4_3_1_4; // 检查日期
    public String getHD_4_3_1_4() {  return this.HD_4_3_1_4;}
    @JsonProperty("HD-4-3-1-4")
    public void setHD_4_3_1_4(final String HD_4_3_1_4) { this.HD_4_3_1_4=HD_4_3_1_4;}
    @Column(name = "HD_4_3_1_6")
    @JsonProperty("HD-4-3-1-6")
    private String HD_4_3_1_6; // 透后体重(kg)
    public String getHD_4_3_1_6() {  return this.HD_4_3_1_6;}
    @JsonProperty("HD-4-3-1-6")
    public void setHD_4_3_1_6(final String HD_4_3_1_6) { this.HD_4_3_1_6=HD_4_3_1_6;}
    @Column(name = "HD_4_3_1_7")
    @JsonProperty("HD-4-3-1-7")
    private String HD_4_3_1_7; // 超滤量(L)
    public String getHD_4_3_1_7() {  return this.HD_4_3_1_7;}
    @JsonProperty("HD-4-3-1-7")
    public void setHD_4_3_1_7(final String HD_4_3_1_7) { this.HD_4_3_1_7=HD_4_3_1_7;}
    @Column(name = "HD_4_3_1_8")
    @JsonProperty("HD-4-3-1-8")
    private String HD_4_3_1_8; // 透前血尿素氮(mmol/L)
    public String getHD_4_3_1_8() {  return this.HD_4_3_1_8;}
    @JsonProperty("HD-4-3-1-8")
    public void setHD_4_3_1_8(final String HD_4_3_1_8) { this.HD_4_3_1_8=HD_4_3_1_8;}
    @Column(name = "HD_4_3_1_9")
    @JsonProperty("HD-4-3-1-9")
    private String HD_4_3_1_9; // 透后血尿素氮(mmol/L)
    public String getHD_4_3_1_9() {  return this.HD_4_3_1_9;}
    @JsonProperty("HD-4-3-1-9")
    public void setHD_4_3_1_9(final String HD_4_3_1_9) { this.HD_4_3_1_9=HD_4_3_1_9;}
    @Column(name = "HD_4_3_1_10")
    @JsonProperty("HD-4-3-1-10")
    private String HD_4_3_1_10; // URR(%)
    public String getHD_4_3_1_10() {  return this.HD_4_3_1_10;}
    @JsonProperty("HD-4-3-1-10")
    public void setHD_4_3_1_10(final String HD_4_3_1_10) { this.HD_4_3_1_10=HD_4_3_1_10;}
    @Column(name = "HD_4_3_1_11")
    @JsonProperty("HD-4-3-1-11")
    private String HD_4_3_1_11; // spKt/V
    public String getHD_4_3_1_11() {  return this.HD_4_3_1_11;}
    @JsonProperty("HD-4-3-1-11")
    public void setHD_4_3_1_11(final String HD_4_3_1_11) { this.HD_4_3_1_11=HD_4_3_1_11;}
    @Column(name = "HD_4_4_1_1")
    @JsonProperty("HD-4-4-1-1")
    private String HD_4_4_1_1; // 实验室指标选择
    public String getHD_4_4_1_1() {  return this.HD_4_4_1_1;}
    @JsonProperty("HD-4-4-1-1")
    public void setHD_4_4_1_1(final String HD_4_4_1_1) { this.HD_4_4_1_1=HD_4_4_1_1;}
    @Column(name = "HD_4_4_1_2")
    @JsonProperty("HD-4-4-1-2")
    private String HD_4_4_1_2; // 血常规_检查日期
    public String getHD_4_4_1_2() {  return this.HD_4_4_1_2;}
    @JsonProperty("HD-4-4-1-2")
    public void setHD_4_4_1_2(final String HD_4_4_1_2) { this.HD_4_4_1_2=HD_4_4_1_2;}
    @Column(name = "HD_4_4_1_3")
    @JsonProperty("HD-4-4-1-3")
    private String HD_4_4_1_3; // 血红蛋白_检测结果(g/L)
    public String getHD_4_4_1_3() {  return this.HD_4_4_1_3;}
    @JsonProperty("HD-4-4-1-3")
    public void setHD_4_4_1_3(final String HD_4_4_1_3) { this.HD_4_4_1_3=HD_4_4_1_3;}
    @Column(name = "HD_4_4_1_4")
    @JsonProperty("HD-4-4-1-4")
    private String HD_4_4_1_4; // 铁代谢_检查日期
    public String getHD_4_4_1_4() {  return this.HD_4_4_1_4;}
    @JsonProperty("HD-4-4-1-4")
    public void setHD_4_4_1_4(final String HD_4_4_1_4) { this.HD_4_4_1_4=HD_4_4_1_4;}
    @Column(name = "HD_4_4_1_5")
    @JsonProperty("HD-4-4-1-5")
    private String HD_4_4_1_5; // 转铁饱和度_检测结果(%)
    public String getHD_4_4_1_5() {  return this.HD_4_4_1_5;}
    @JsonProperty("HD-4-4-1-5")
    public void setHD_4_4_1_5(final String HD_4_4_1_5) { this.HD_4_4_1_5=HD_4_4_1_5;}
    @Column(name = "HD_4_4_1_6")
    @JsonProperty("HD-4-4-1-6")
    private String HD_4_4_1_6; // 铁蛋白_检测结果(μg/L)
    public String getHD_4_4_1_6() {  return this.HD_4_4_1_6;}
    @JsonProperty("HD-4-4-1-6")
    public void setHD_4_4_1_6(final String HD_4_4_1_6) { this.HD_4_4_1_6=HD_4_4_1_6;}
    @Column(name = "HD_4_4_2_1")
    @JsonProperty("HD-4-4-2-1")
    private String HD_4_4_2_1; // 钙磷代谢_检查日期
    public String getHD_4_4_2_1() {  return this.HD_4_4_2_1;}
    @JsonProperty("HD-4-4-2-1")
    public void setHD_4_4_2_1(final String HD_4_4_2_1) { this.HD_4_4_2_1=HD_4_4_2_1;}
    @Column(name = "HD_4_4_2_2")
    @JsonProperty("HD-4-4-2-2")
    private String HD_4_4_2_2; // 血钙_检测结果(mmol/L)
    public String getHD_4_4_2_2() {  return this.HD_4_4_2_2;}
    @JsonProperty("HD-4-4-2-2")
    public void setHD_4_4_2_2(final String HD_4_4_2_2) { this.HD_4_4_2_2=HD_4_4_2_2;}
    @Column(name = "HD_4_4_2_3")
    @JsonProperty("HD-4-4-2-3")
    private String HD_4_4_2_3; // 血磷_检测结果(mmol/L)
    public String getHD_4_4_2_3() {  return this.HD_4_4_2_3;}
    @JsonProperty("HD-4-4-2-3")
    public void setHD_4_4_2_3(final String HD_4_4_2_3) { this.HD_4_4_2_3=HD_4_4_2_3;}
    @Column(name = "HD_4_4_2_4")
    @JsonProperty("HD-4-4-2-4")
    private String HD_4_4_2_4; // 甲状旁腺激素(PTH)_检查日期
    public String getHD_4_4_2_4() {  return this.HD_4_4_2_4;}
    @JsonProperty("HD-4-4-2-4")
    public void setHD_4_4_2_4(final String HD_4_4_2_4) { this.HD_4_4_2_4=HD_4_4_2_4;}
    @Column(name = "HD_4_4_2_5")
    @JsonProperty("HD-4-4-2-5")
    private String HD_4_4_2_5; // PTH_检测结果(pg/mL)
    public String getHD_4_4_2_5() {  return this.HD_4_4_2_5;}
    @JsonProperty("HD-4-4-2-5")
    public void setHD_4_4_2_5(final String HD_4_4_2_5) { this.HD_4_4_2_5=HD_4_4_2_5;}
    @Column(name = "HD_4_4_3_1")
    @JsonProperty("HD-4-4-3-1")
    private String HD_4_4_3_1; // 血清白蛋白_检查日期
    public String getHD_4_4_3_1() {  return this.HD_4_4_3_1;}
    @JsonProperty("HD-4-4-3-1")
    public void setHD_4_4_3_1(final String HD_4_4_3_1) { this.HD_4_4_3_1=HD_4_4_3_1;}
    @Column(name = "HD_4_4_3_2")
    @JsonProperty("HD-4-4-3-2")
    private String HD_4_4_3_2; // 血清白蛋白_检测结果(g/L)
    public String getHD_4_4_3_2() {  return this.HD_4_4_3_2;}
    @JsonProperty("HD-4-4-3-2")
    public void setHD_4_4_3_2(final String HD_4_4_3_2) { this.HD_4_4_3_2=HD_4_4_3_2;}
    @Column(name = "HD_4_4_4_1")
    @JsonProperty("HD-4-4-4-1")
    private String HD_4_4_4_1; // C反应蛋白_检查日期
    public String getHD_4_4_4_1() {  return this.HD_4_4_4_1;}
    @JsonProperty("HD-4-4-4-1")
    public void setHD_4_4_4_1(final String HD_4_4_4_1) { this.HD_4_4_4_1=HD_4_4_4_1;}
    @Column(name = "HD_4_4_4_2")
    @JsonProperty("HD-4-4-4-2")
    private String HD_4_4_4_2; // C反应蛋白_检测结果(mg/dL)
    public String getHD_4_4_4_2() {  return this.HD_4_4_4_2;}
    @JsonProperty("HD-4-4-4-2")
    public void setHD_4_4_4_2(final String HD_4_4_4_2) { this.HD_4_4_4_2=HD_4_4_4_2;}
    @Column(name = "HD_4_4_4_3")
    @JsonProperty("HD-4-4-4-3")
    private String HD_4_4_4_3; // 前白蛋白_检查日期
    public String getHD_4_4_4_3() {  return this.HD_4_4_4_3;}
    @JsonProperty("HD-4-4-4-3")
    public void setHD_4_4_4_3(final String HD_4_4_4_3) { this.HD_4_4_4_3=HD_4_4_4_3;}
    @Column(name = "HD_4_4_4_4")
    @JsonProperty("HD-4-4-4-4")
    private String HD_4_4_4_4; // 前白蛋白_检测结果(mg/dL)
    public String getHD_4_4_4_4() {  return this.HD_4_4_4_4;}
    @JsonProperty("HD-4-4-4-4")
    public void setHD_4_4_4_4(final String HD_4_4_4_4) { this.HD_4_4_4_4=HD_4_4_4_4;}
    @Column(name = "HD_4_4_4_5")
    @JsonProperty("HD-4-4-4-5")
    private String HD_4_4_4_5; // β2微球蛋白_检查日期
    public String getHD_4_4_4_5() {  return this.HD_4_4_4_5;}
    @JsonProperty("HD-4-4-4-5")
    public void setHD_4_4_4_5(final String HD_4_4_4_5) { this.HD_4_4_4_5=HD_4_4_4_5;}
    @Column(name = "HD_4_4_4_6")
    @JsonProperty("HD-4-4-4-6")
    private String HD_4_4_4_6; // β2微球蛋白_检测结果(mg/dL)
    public String getHD_4_4_4_6() {  return this.HD_4_4_4_6;}
    @JsonProperty("HD-4-4-4-6")
    public void setHD_4_4_4_6(final String HD_4_4_4_6) { this.HD_4_4_4_6=HD_4_4_4_6;}
    @Column(name = "HD_4_5_1_1")
    @JsonProperty("HD-4-5-1-1")
    private String HD_4_5_1_1; // 血源性传染病标志物检查
    public String getHD_4_5_1_1() {  return this.HD_4_5_1_1;}
    @JsonProperty("HD-4-5-1-1")
    public void setHD_4_5_1_1(final String HD_4_5_1_1) { this.HD_4_5_1_1=HD_4_5_1_1;}
    @Column(name = "HD_4_5_1_2")
    @JsonProperty("HD-4-5-1-2")
    private String HD_4_5_1_2; // 乙肝标志物_检查日期
    public String getHD_4_5_1_2() {  return this.HD_4_5_1_2;}
    @JsonProperty("HD-4-5-1-2")
    public void setHD_4_5_1_2(final String HD_4_5_1_2) { this.HD_4_5_1_2=HD_4_5_1_2;}
    @Column(name = "HD_4_5_1_3")
    @JsonProperty("HD-4-5-1-3")
    private String HD_4_5_1_3; // HBsAg_检测结果
    public String getHD_4_5_1_3() {  return this.HD_4_5_1_3;}
    @JsonProperty("HD-4-5-1-3")
    public void setHD_4_5_1_3(final String HD_4_5_1_3) { this.HD_4_5_1_3=HD_4_5_1_3;}
    @Column(name = "HD_4_5_1_4")
    @JsonProperty("HD-4-5-1-4")
    private String HD_4_5_1_4; // 丙肝标志物_检查日期
    public String getHD_4_5_1_4() {  return this.HD_4_5_1_4;}
    @JsonProperty("HD-4-5-1-4")
    public void setHD_4_5_1_4(final String HD_4_5_1_4) { this.HD_4_5_1_4=HD_4_5_1_4;}
    @Column(name = "HD_4_5_1_5")
    @JsonProperty("HD-4-5-1-5")
    private String HD_4_5_1_5; // AntiHCV_检测结果
    public String getHD_4_5_1_5() {  return this.HD_4_5_1_5;}
    @JsonProperty("HD-4-5-1-5")
    public void setHD_4_5_1_5(final String HD_4_5_1_5) { this.HD_4_5_1_5=HD_4_5_1_5;}
    @Column(name = "HD_4_5_1_6")
    @JsonProperty("HD-4-5-1-6")
    private String HD_4_5_1_6; // HIV标志物_检查日期
    public String getHD_4_5_1_6() {  return this.HD_4_5_1_6;}
    @JsonProperty("HD-4-5-1-6")
    public void setHD_4_5_1_6(final String HD_4_5_1_6) { this.HD_4_5_1_6=HD_4_5_1_6;}
    @Column(name = "HD_4_5_1_7")
    @JsonProperty("HD-4-5-1-7")
    private String HD_4_5_1_7; // HIV抗体_检测结果
    public String getHD_4_5_1_7() {  return this.HD_4_5_1_7;}
    @JsonProperty("HD-4-5-1-7")
    public void setHD_4_5_1_7(final String HD_4_5_1_7) { this.HD_4_5_1_7=HD_4_5_1_7;}
    @Column(name = "HD_4_5_1_8")
    @JsonProperty("HD-4-5-1-8")
    private String HD_4_5_1_8; // 梅毒标志物_检查日期
    public String getHD_4_5_1_8() {  return this.HD_4_5_1_8;}
    @JsonProperty("HD-4-5-1-8")
    public void setHD_4_5_1_8(final String HD_4_5_1_8) { this.HD_4_5_1_8=HD_4_5_1_8;}
    @Column(name = "HD_4_5_1_9")
    @JsonProperty("HD-4-5-1-9")
    private String HD_4_5_1_9; // 梅毒_检测结果
    public String getHD_4_5_1_9() {  return this.HD_4_5_1_9;}
    @JsonProperty("HD-4-5-1-9")
    public void setHD_4_5_1_9(final String HD_4_5_1_9) { this.HD_4_5_1_9=HD_4_5_1_9;}
    @Column(name = "HD_4_6_1_1")
    @JsonProperty("HD-4-6-1-1")
    private String HD_4_6_1_1; // 是否为患者提供血液透析治疗健康教育
    public String getHD_4_6_1_1() {  return this.HD_4_6_1_1;}
    @JsonProperty("HD-4-6-1-1")
    public void setHD_4_6_1_1(final String HD_4_6_1_1) { this.HD_4_6_1_1=HD_4_6_1_1;}
    @Column(name = "HD_4_6_1_2")
    @JsonProperty("HD-4-6-1-2")
    private String HD_4_6_1_2; // 血液透析治疗前健康教育
    public String getHD_4_6_1_2() {  return this.HD_4_6_1_2;}
    @JsonProperty("HD-4-6-1-2")
    public void setHD_4_6_1_2(final String HD_4_6_1_2) { this.HD_4_6_1_2=HD_4_6_1_2;}
    @Column(name = "HD_4_6_1_3")
    @JsonProperty("HD-4-6-1-3")
    private String HD_4_6_1_3; // 血液透析治疗后健康教育
    public String getHD_4_6_1_3() {  return this.HD_4_6_1_3;}
    @JsonProperty("HD-4-6-1-3")
    public void setHD_4_6_1_3(final String HD_4_6_1_3) { this.HD_4_6_1_3=HD_4_6_1_3;}
}