package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：J44.0，J44.1 的出院患者。
*/
@ApiModel(value = "20信息")
@Entity
@Data
@Table(name = "sd_info_AECOPD")
public class SdInfoAECOPD implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    @Column(name = "CM_0_1_1_1")
    @JsonProperty("CM-0-1-1-1")
    private String CM_0_1_1_1; // 质控医师
    @Column(name = "CM_0_1_1_2")
    @JsonProperty("CM-0-1-1-2")
    private String CM_0_1_1_2; // 质控护士
    @Column(name = "CM_0_1_1_3")
    @JsonProperty("CM-0-1-1-3")
    private String CM_0_1_1_3; // 主治医师
    @Column(name = "CM_0_1_1_4")
    @JsonProperty("CM-0-1-1-4")
    private String CM_0_1_1_4; // 责任护士
    @Column(name = "CM_0_1_1_5")
    @JsonProperty("CM-0-1-1-5")
    private String CM_0_1_1_5; // 上报科室
    @Column(name = "caseId")
    @JsonProperty("caseId")
    private String caseId; // 患者病案号
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard; // 患者身份证号
    @Column(name = "CM_0_1_3_1")
    @JsonProperty("CM-0-1-3-1")
    private String CM_0_1_3_1; // 主要诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否出院后31天内重复住院
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM-0-2-1-1")
    private String CM_0_2_1_1; // 出生日期
    @Column(name = "CM_0_2_1_2")
    @JsonProperty("CM-0-2-1-2")
    private String CM_0_2_1_2; // 患者性别
    @Column(name = "CM_0_2_1_3")
    @JsonProperty("CM-0-2-1-3")
    private String CM_0_2_1_3; // 患者体重（kg）
    @Column(name = "CM_0_2_1_5")
    @JsonProperty("CM-0-2-1-5")
    private String CM_0_2_1_5; // 患者身高（cm）
    @Column(name = "CM_0_2_1_3_1")
    @JsonProperty("CM-0-2-1-3-1")
    private String CM_0_2_1_3_1; // 身高转换
    @Column(name = "CM_0_2_1_4")
    @JsonProperty("CM-0-2-1-4")
    private String CM_0_2_1_4; // 体重指数(Kg/m2)
    @Column(name = "CM_0_2_4_1")
    @JsonProperty("CM-0-2-4-1")
    private String CM_0_2_4_1; // 入院日期时间
    @Column(name = "age")
    @JsonProperty("age")
    private String age; // 年龄
    @Column(name = "CM_0_2_4_2")
    @JsonProperty("CM-0-2-4-2")
    private String CM_0_2_4_2; // 出院日期时间
    @Column(name = "CM_0_2_5_1")
    @JsonProperty("CM-0-2-5-1")
    private String CM_0_2_5_1; // 入住ICU/RICU日期时间
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU/RICU日期时间
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "AECOPD_1_1_1")
    @JsonProperty("AECOPD-1-1-1")
    private String AECOPD_1_1_1; // 入院后是否实施首次病情严重程度评估
    @Column(name = "AECOPD_1_1_2")
    @JsonProperty("AECOPD-1-1-2")
    private String AECOPD_1_1_2; // 评价结果
    @Column(name = "AECOPD_1_2_1")
    @JsonProperty("AECOPD-1-2-1")
    private String AECOPD_1_2_1; // 入院后是否实施首次氧合评估（首次）
    @Column(name = "AECOPD_1_2_2")
    @JsonProperty("AECOPD-1-2-2")
    private String AECOPD_1_2_2; // 实施首次氧合评估时是否吸氧
    @Column(name = "AECOPD_1_2_3")
    @JsonProperty("AECOPD-1-2-3")
    private String AECOPD_1_2_3; // 动脉血气分析/指氧仪检查
    @Column(name = "AECOPD_1_2_3_3")
    @JsonProperty("AECOPD-1-2-3-3")
    private String AECOPD_1_2_3_3; // 动脉血气分析（mmHg）
    @Column(name = "AECOPD_1_2_3_4")
    @JsonProperty("AECOPD-1-2-3-4")
    private String AECOPD_1_2_3_4; // 指氧仪检查（%）
    @Column(name = "AECOPD_1_2_4")
    @JsonProperty("AECOPD-1-2-4")
    private String AECOPD_1_2_4; // 入院后首次氧合评估结论的判定
    @Column(name = "AECOPD_1_3_1")
    @JsonProperty("AECOPD-1-3-1")
    private String AECOPD_1_3_1; // 入院后是否实施首次胸部影像学检查
    @Column(name = "AECOPD_1_3_2")
    @JsonProperty("AECOPD-1-3-2")
    private String AECOPD_1_3_2; // 首次胸部影像学检查模式
    @Column(name = "AECOPD_1_3_3")
    @JsonProperty("AECOPD-1-3-3")
    private String AECOPD_1_3_3; // 胸部影像学检查评估
    @Column(name = "AECOPD_1_3_3_1")
    @JsonProperty("AECOPD-1-3-3-1")
    private String AECOPD_1_3_3_1; // 其它胸部影像学检查评估
    @Column(name = "AECOPD_1_4_1")
    @JsonProperty("AECOPD-1-4-1")
    private String AECOPD_1_4_1; // 入院后是否实施首次心电图检查评估
    @Column(name = "AECOPD_1_4_2")
    @JsonProperty("AECOPD-1-4-2")
    private String AECOPD_1_4_2; // 心电图检查评估
    @Column(name = "AECOPD_1_4_2_1")
    @JsonProperty("AECOPD-1-4-2-1")
    private String AECOPD_1_4_2_1; // 其它心电图检查评估
    @Column(name = "AECOPD_1_5_1")
    @JsonProperty("AECOPD-1-5-1")
    private String AECOPD_1_5_1; // 入院后是否实施首次实验室检查评估
    @Column(name = "AECOPD_1_5_2")
    @JsonProperty("AECOPD-1-5-2")
    private String AECOPD_1_5_2; // 实验室检查评估
    @Column(name = "AECOPD_1_5_2_1")
    @JsonProperty("AECOPD-1-5-2-1")
    private String AECOPD_1_5_2_1; // 其它实验室检查评估
    @Column(name = "AECOPD_2_1_1")
    @JsonProperty("AECOPD-2-1-1")
    private String AECOPD_2_1_1; // 是否入住ICU
    @Column(name = "AECOPD_2_1_2")
    @JsonProperty("AECOPD-2-1-2")
    private String AECOPD_2_1_2; // 收住ICU符合指征的选择
    @Column(name = "AECOPD_2_1_3")
    @JsonProperty("AECOPD-2-1-3")
    private String AECOPD_2_1_3; // 入住ICU时机
    @Column(name = "AECOPD_2_2_1")
    @JsonProperty("AECOPD-2-2-1")
    private String AECOPD_2_2_1; // 选择AECOPD治疗的分级
    @Column(name = "AECOPD_3_1_1")
    @JsonProperty("AECOPD-3-1-1")
    private String AECOPD_3_1_1; // 氧疗方法
    @Column(name = "AECOPD_3_2_1")
    @JsonProperty("AECOPD-3-2-1")
    private String AECOPD_3_2_1; // 氧疗 30min 后是否复查动脉血气
    @Column(name = "AECOPD_4_1_1")
    @JsonProperty("AECOPD-4-1-1")
    private String AECOPD_4_1_1; // 用药前病情判定分层
    @Column(name = "AECOPD_4_1_2")
    @JsonProperty("AECOPD-4-1-2")
    private String AECOPD_4_1_2; // 患者经验性起始抗菌药物选择
    @Column(name = "AECOPD_4_2_2_2")
    @JsonProperty("AECOPD-4-2-2-2")
    private String AECOPD_4_2_2_2; // 轻度及中度COPD急性加重
    @Column(name = "AECOPD_4_1_2_1_1")
    @JsonProperty("AECOPD-4-1-2-1-1")
    private String AECOPD_4_1_2_1_1; // 其他轻度及中度COPD急性加重抗菌药物
    @Column(name = "AECOPD_4_1_2_3")
    @JsonProperty("AECOPD-4-1-2-3")
    private String AECOPD_4_1_2_3; // 重度及极重度COPD急性加重，无铜绿假单孢菌感染危险因素患者抗菌药物选择
    @Column(name = "AECOPD_4_1_2_4")
    @JsonProperty("AECOPD-4-1-2-4")
    private String AECOPD_4_1_2_4; // 其他重度及极重度COPD急性加重，无铜绿假单孢菌感染危险因素患者抗菌药物
    @Column(name = "AECOPD_4_1_2_5")
    @JsonProperty("AECOPD-4-1-2-5")
    private String AECOPD_4_1_2_5; // 重度及极重度COPD急性加重，有铜绿假单孢菌感染危险因素患者抗菌药物选择
    @Column(name = "AECOPD_4_1_2_6")
    @JsonProperty("AECOPD-4-1-2-6")
    private String AECOPD_4_1_2_6; // 其他重度及极重度COPD急性加重，有铜绿假单孢菌感染危险因素患者抗菌药物
    @Column(name = "AECOPD_4_1_3")
    @JsonProperty("AECOPD-4-1-3")
    private String AECOPD_4_1_3; // 患者接受首剂抗菌药物治疗（注射剂输入/注射）日期时间
    @Column(name = "AECOPD_4_1_4")
    @JsonProperty("AECOPD-4-1-4")
    private String AECOPD_4_1_4; // 接受首剂抗菌药物使用时机的分层
    @Column(name = "AECOPD_4_1_5")
    @JsonProperty("AECOPD-4-1-5")
    private String AECOPD_4_1_5; // 患者停止使用抗菌药物日期
    @Column(name = "AECOPD_5_1_1")
    @JsonProperty("AECOPD-5-1-1")
    private String AECOPD_5_1_1; // 支气管舒张剂、吸入糖皮质激素使用的选择
    @Column(name = "AECOPD_5_1_1_1")
    @JsonProperty("AECOPD-5-1-1-1")
    private String AECOPD_5_1_1_1; //  其他支气管舒张剂、吸入糖皮质激素使用
    @Column(name = "AECOPD_5_1_2")
    @JsonProperty("AECOPD-5-1-2")
    private String AECOPD_5_1_2; // 是否实施血清茶碱浓度监测
    @Column(name = "AECOPD_5_2_1")
    @JsonProperty("AECOPD-5-2-1")
    private String AECOPD_5_2_1; // 全身使用糖皮质激素药物的选择
    @Column(name = "AECOPD_5_2_1_1")
    @JsonProperty("AECOPD-5-2-1-1")
    private String AECOPD_5_2_1_1; // 其他使用糖皮质激素药物
    @Column(name = "AECOPD_5_2_2")
    @JsonProperty("AECOPD-5-2-2")
    private String AECOPD_5_2_2; // 全身使用糖皮质激素药物起始日期
    @Column(name = "AECOPD_5_2_3")
    @JsonProperty("AECOPD-5-2-3")
    private String AECOPD_5_2_3; // 全身使用糖皮质激素药物终止日期
    @Column(name = "AECOPD_6_1_1")
    @JsonProperty("AECOPD-6-1-1")
    private String AECOPD_6_1_1; // 是否有有心功不全
    @Column(name = "AECOPD_6_1_2")
    @JsonProperty("AECOPD-6-1-2")
    private String AECOPD_6_1_2; // 首位处置项目
    @Column(name = "AECOPD_6_1_2_1")
    @JsonProperty("AECOPD-6-1-2-1")
    private String AECOPD_6_1_2_1; // 有心功不全时,其他处置项目
    @Column(name = "AECOPD_6_2_1")
    @JsonProperty("AECOPD-6-2-1")
    private String AECOPD_6_2_1; // 是否有有肺动脉高压和右心功能不全
    @Column(name = "AECOPD_6_2_2")
    @JsonProperty("AECOPD-6-2-2")
    private String AECOPD_6_2_2; // 使用血管扩张剂（无禁忌症）的选择
    @Column(name = "AECOPD_6_2_2_1")
    @JsonProperty("AECOPD-6-2-2-1")
    private String AECOPD_6_2_2_1; // 有肺动脉高压和右心功能不全时,使用其他血管扩张剂
    @Column(name = "AECOPD_6_3_1")
    @JsonProperty("AECOPD-6-3-1")
    private String AECOPD_6_3_1; // 是否有血栓形成高危因素
    @Column(name = "AECOPD_6_3_2")
    @JsonProperty("AECOPD-6-3-2")
    private String AECOPD_6_3_2; // 首位处置项目
    @Column(name = "AECOPD_6_3_2_1")
    @JsonProperty("AECOPD-6-3-2-1")
    private String AECOPD_6_3_2_1; // 有血栓形成高危因素时,其他处置项目
    @Column(name = "AECOPD_6_4_1")
    @JsonProperty("AECOPD-6-4-1")
    private String AECOPD_6_4_1; // 是否有呼吸功能不全
    @Column(name = "AECOPD_6_4_2")
    @JsonProperty("AECOPD-6-4-2")
    private String AECOPD_6_4_2; // 首位处置项目
    @Column(name = "AECOPD_6_4_2_1")
    @JsonProperty("AECOPD-6-4-2-1")
    private String AECOPD_6_4_2_1; // 有呼吸功能不全时,其他处置项目
    @Column(name = "AECOPD_6_5_1")
    @JsonProperty("AECOPD-6-5-1")
    private String AECOPD_6_5_1; // 是否有气胸
    @Column(name = "AECOPD_6_5_2")
    @JsonProperty("AECOPD-6-5-2")
    private String AECOPD_6_5_2; // 首位处置项目
    @Column(name = "AECOPD_6_5_2_1")
    @JsonProperty("AECOPD-6-5-2-1")
    private String AECOPD_6_5_2_1; // 有气胸时,其他处置项目
    @Column(name = "AECOPD_7_1_1")
    @JsonProperty("AECOPD-7-1-1")
    private String AECOPD_7_1_1; // 是否实施无创正压通气（NIV）
    @Column(name = "AECOPD_7_1_2")
    @JsonProperty("AECOPD-7-1-2")
    private String AECOPD_7_1_2; // 无创正压通气的应用指征
    @Column(name = "AECOPD_7_1_3_1")
    @JsonProperty("AECOPD-7-1-3-1")
    private String AECOPD_7_1_3_1; // NIV相对禁忌证 
    @Column(name = "AECOPD_7_1_6")
    @JsonProperty("AECOPD-7-1-6")
    private String AECOPD_7_1_6; // 患者无创正压通气起始日期时间
    @Column(name = "AECOPD_7_1_7")
    @JsonProperty("AECOPD-7-1-7")
    private String AECOPD_7_1_7; // 患者无创正压通气终止日期时间
    @Column(name = "AECOPD_7_1_8_r")
    @JsonProperty("AECOPD-7-1-8-r")
    private String AECOPD_7_1_8_r; // 无创正压通气疗程（小时）
    @Column(name = "AECOPD_7_1_8")
    @JsonProperty("AECOPD-7-1-8")
    private String AECOPD_7_1_8; // 无创正压通气疗程（小时）
    @Column(name = "AECOPD_7_2_1")
    @JsonProperty("AECOPD-7-2-1")
    private String AECOPD_7_2_1; // 是否实施有创机械通气
    @Column(name = "AECOPD_7_2_2")
    @JsonProperty("AECOPD-7-2-2")
    private String AECOPD_7_2_2; // 有创机械通气指征
    @Column(name = "AECOPD_7_2_5_1")
    @JsonProperty("AECOPD-7-2-5-1")
    private String AECOPD_7_2_5_1; // 患者有机械通气起始日期时间
    @Column(name = "AECOPD_7_2_6")
    @JsonProperty("AECOPD-7-2-6")
    private String AECOPD_7_2_6; // 患者有机械通气终止日期时间
    @Column(name = "AECOPD_7_2_7_r")
    @JsonProperty("AECOPD-7-2-7-r")
    private String AECOPD_7_2_7_r; // 有机械通气疗程（小时）
    @Column(name = "AECOPD_7_2_7")
    @JsonProperty("AECOPD-7-2-7")
    private String AECOPD_7_2_7; // 有机械通气疗程（小时）
    @Column(name = "AECOPD_7_3_1")
    @JsonProperty("AECOPD-7-3-1")
    private String AECOPD_7_3_1; // 是否实施有创-无创序贯通气疗法
    @Column(name = "AECOPD_8_1_1")
    @JsonProperty("AECOPD-8-1-1")
    private String AECOPD_8_1_1; // 有无吸烟史
    @Column(name = "AECOPD_8_2")
    @JsonProperty("AECOPD-8-2")
    private String AECOPD_8_2; // 吸烟程度评估有记录
    @Column(name = "AECOPD_8_3")
    @JsonProperty("AECOPD-8-3")
    private String AECOPD_8_3; // 接受戒烟的建议或者戒烟治疗有记录
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    @Column(name = "CM_4_1")
    @JsonProperty("CM-4-1")
    private String CM_4_1; // 住院天数
    @Column(name = "CM_4_3")
    @JsonProperty("CM-4-3")
    private String CM_4_3; // 离院方式选择
    @Column(name = "CM_4_5")
    @JsonProperty("CM-4-5")
    private String CM_4_5; // 非医嘱离院可能涉及因素
    @Column(name = "CM_4_4_1")
    @JsonProperty("CM-4-4-1")
    private String CM_4_4_1; // 其他非医嘱离院因素填写
    @Column(name = "CM_4_6")
    @JsonProperty("CM-4-6")
    private String CM_4_6; // 死亡可能涉及因素
    @Column(name = "AECOPD_9_1_1")
    @JsonProperty("AECOPD-9-1-1")
    private String AECOPD_9_1_1; // 符合出院标准
    @Column(name = "CM_5_1")
    @JsonProperty("CM-5-1")
    private String CM_5_1; // 患者是否对服务的体验与评价
    @Column(name = "CM_5_2_1")
    @JsonProperty("CM-5-2-1")
    private String CM_5_2_1; // 整体医院评级
    @Column(name = "CM_5_2_2")
    @JsonProperty("CM-5-2-2")
    private String CM_5_2_2; // 患者推荐
    @Column(name = "CM_5_2_3")
    @JsonProperty("CM-5-2-3")
    private String CM_5_2_3; // 病房、床单元和卫生间清洁度
    @Column(name = "CM_5_2_5")
    @JsonProperty("CM-5-2-5")
    private String CM_5_2_5; // 病房与周边噪音
    @Column(name = "CM_5_2_6")
    @JsonProperty("CM-5-2-6")
    private String CM_5_2_6; // 医生沟通
    @Column(name = "CM_5_2_7")
    @JsonProperty("CM-5-2-7")
    private String CM_5_2_7; // 护士沟通
    @Column(name = "CM_5_2_8")
    @JsonProperty("CM-5-2-8")
    private String CM_5_2_8; // 药师沟通
    @Column(name = "CM_5_2_9")
    @JsonProperty("CM-5-2-9")
    private String CM_5_2_9; // 康复计划
    @Column(name = "CM_5_2_10")
    @JsonProperty("CM-5-2-10")
    private String CM_5_2_10; // 出院时的知情告知
    @Column(name = "CM_5_2_11")
    @JsonProperty("CM-5-2-11")
    private String CM_5_2_11; // 膳食评价
    @Column(name = "CM_6_1")
    @JsonProperty("CM-6-1")
    private String CM_6_1; // 住院总费用
    @Column(name = "CM_6_2")
    @JsonProperty("CM-6-2")
    private String CM_6_2; // 住院总费用其中自付金额
    @Column(name = "CM_6_3")
    @JsonProperty("CM-6-3")
    private String CM_6_3; // 一般医疗服务费
    @Column(name = "CM_6_4")
    @JsonProperty("CM-6-4")
    private String CM_6_4; // 一般治疗操作费
    @Column(name = "CM_6_5")
    @JsonProperty("CM-6-5")
    private String CM_6_5; // 护理费
    @Column(name = "CM_6_6")
    @JsonProperty("CM-6-6")
    private String CM_6_6; // 综合医疗服务类其他费用
    @Column(name = "CM_6_7")
    @JsonProperty("CM-6-7")
    private String CM_6_7; // 病理诊断费
    @Column(name = "CM_6_8")
    @JsonProperty("CM-6-8")
    private String CM_6_8; // 实验室诊断费
    @Column(name = "CM_6_9")
    @JsonProperty("CM-6-9")
    private String CM_6_9; // 影像学诊断费
    @Column(name = "CM_6_10")
    @JsonProperty("CM-6-10")
    private String CM_6_10; // 临床诊断项目费
    @Column(name = "CM_6_11")
    @JsonProperty("CM-6-11")
    private String CM_6_11; // 非手术治疗项目费
    @Column(name = "CM_6_12")
    @JsonProperty("CM-6-12")
    private String CM_6_12; // 其中：临床物理治疗费
    @Column(name = "CM_6_13")
    @JsonProperty("CM-6-13")
    private String CM_6_13; // 手术治疗费
    @Column(name = "CM_6_14")
    @JsonProperty("CM-6-14")
    private String CM_6_14; // 其中：麻醉费
    @Column(name = "CM_6_15")
    @JsonProperty("CM-6-15")
    private String CM_6_15; // 其中：手术费
    @Column(name = "CM_6_16")
    @JsonProperty("CM-6-16")
    private String CM_6_16; // 康复费
    @Column(name = "CM_6_17")
    @JsonProperty("CM-6-17")
    private String CM_6_17; // 中医治疗费
    @Column(name = "CM_6_18")
    @JsonProperty("CM-6-18")
    private String CM_6_18; // 西药费
    @Column(name = "CM_6_19")
    @JsonProperty("CM-6-19")
    private String CM_6_19; // 其中：抗菌药物费
    @Column(name = "CM_6_20")
    @JsonProperty("CM-6-20")
    private String CM_6_20; // 中成药费
    @Column(name = "CM_6_21")
    @JsonProperty("CM-6-21")
    private String CM_6_21; // 中草药费
    @Column(name = "CM_6_22")
    @JsonProperty("CM-6-22")
    private String CM_6_22; // 血费
    @Column(name = "CM_6_23")
    @JsonProperty("CM-6-23")
    private String CM_6_23; // 白蛋白类制品费
    @Column(name = "CM_6_24")
    @JsonProperty("CM-6-24")
    private String CM_6_24; // 球蛋白类制品费
    @Column(name = "CM_6_25")
    @JsonProperty("CM-6-25")
    private String CM_6_25; // 凝血因子类制品费
    @Column(name = "CM_6_26")
    @JsonProperty("CM-6-26")
    private String CM_6_26; // 细胞因子类制品费
    @Column(name = "CM_6_27")
    @JsonProperty("CM-6-27")
    private String CM_6_27; // 检查用一次性医用材料费
    @Column(name = "CM_6_28")
    @JsonProperty("CM-6-28")
    private String CM_6_28; // 治疗用一次性医用材料费
    @Column(name = "CM_6_29")
    @JsonProperty("CM-6-29")
    private String CM_6_29; // 手术用一次性医用材料费
    @Column(name = "CM_6_30")
    @JsonProperty("CM-6-30")
    private String CM_6_30; // 其他费
}