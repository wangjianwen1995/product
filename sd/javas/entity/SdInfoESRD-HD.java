package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

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
@Data
@Table(name = "sd_info_ESRD-HD")
public class SdInfoESRD-HD implements Serializable {
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
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM-0-2-1-1")
    private String CM_0_2_1_1; // 出生日期
    @Column(name = "age")
    @JsonProperty("age")
    private String age; // 患者年龄
    @Column(name = "CM_0_2_1_2")
    @JsonProperty("CM-0-2-1-2")
    private String CM_0_2_1_2; // 患者性别
    @Column(name = "CM_0_2_1_3")
    @JsonProperty("CM-0-2-1-3")
    private String CM_0_2_1_3; // 患者体重（kg）
    @Column(name = "CM_0_2_2_1")
    @JsonProperty("CM-0-2-2-1")
    private String CM_0_2_2_1; // 发病日期时间是否无法确定或无记录
    @Column(name = "CM_0_2_2_2")
    @JsonProperty("CM-0-2-2-2")
    private String CM_0_2_2_2; // 发病日期时间
    @Column(name = "HD_0_1_5")
    @JsonProperty("HD-0-1-5")
    private String HD_0_1_5; // 住院病案首页/日间治疗中心的病案记录中原发病名称
    @Column(name = "HD_0_1_5_1")
    @JsonProperty("HD-0-1-5-1")
    private String HD_0_1_5_1; // 原发性肾小球疾病
    @Column(name = "HD_0_1_5_2")
    @JsonProperty("HD-0-1-5-2")
    private String HD_0_1_5_2; // 其他原发性肾小球疾病
    @Column(name = "HD_0_1_5_3")
    @JsonProperty("HD-0-1-5-3")
    private String HD_0_1_5_3; // 继发性肾小球疾病
    @Column(name = "HD_0_1_5_4")
    @JsonProperty("HD-0-1-5-4")
    private String HD_0_1_5_4; // 其他继发性肾小球疾病
    @Column(name = "HD_0_1_5_5")
    @JsonProperty("HD-0-1-5-5")
    private String HD_0_1_5_5; // 遗传性及先天性肾病
    @Column(name = "HD_0_1_5_6")
    @JsonProperty("HD-0-1-5-6")
    private String HD_0_1_5_6; // 其他遗传性及先天性肾病
    @Column(name = "HD_0_1_5_7")
    @JsonProperty("HD-0-1-5-7")
    private String HD_0_1_5_7; // 肾小管间质疾病
    @Column(name = "HD_0_1_5_8")
    @JsonProperty("HD-0-1-5-8")
    private String HD_0_1_5_8; // 其他肾小管间质疾病
    @Column(name = "HD_0_1_5_9")
    @JsonProperty("HD-0-1-5-9")
    private String HD_0_1_5_9; // 药物性肾损害
    @Column(name = "HD_0_1_5_10")
    @JsonProperty("HD-0-1-5-10")
    private String HD_0_1_5_10; // 其他药物性肾损害
    @Column(name = "HD_0_1_5_11")
    @JsonProperty("HD-0-1-5-11")
    private String HD_0_1_5_11; // 泌尿系感染和结石
    @Column(name = "HD_0_1_5_13")
    @JsonProperty("HD-0-1-5-13")
    private String HD_0_1_5_13; // 传染病
    @Column(name = "HD_0_1_5_14")
    @JsonProperty("HD-0-1-5-14")
    private String HD_0_1_5_14; // 其他传染病
    @Column(name = "HD_0_1_5_15")
    @JsonProperty("HD-0-1-5-15")
    private String HD_0_1_5_15; // 其他疾病
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "HD_0_1_7")
    @JsonProperty("HD-0-1-7")
    private String HD_0_1_7; // 透析状态
    @Column(name = "HD_0_1_7_1")
    @JsonProperty("HD-0-1-7-1")
    private String HD_0_1_7_1; // 转出原因
    @Column(name = "HD_0_1_7_2")
    @JsonProperty("HD-0-1-7-2")
    private String HD_0_1_7_2; // 其他转出原因
    @Column(name = "HD_0_1_7_3")
    @JsonProperty("HD-0-1-7-3")
    private String HD_0_1_7_3; // 死亡原因
    @Column(name = "HD_0_1_7_4")
    @JsonProperty("HD-0-1-7-4")
    private String HD_0_1_7_4; // 心血管事件
    @Column(name = "HD_0_1_7_5")
    @JsonProperty("HD-0-1-7-5")
    private String HD_0_1_7_5; // 心血管其他事件
    @Column(name = "HD_0_1_7_6")
    @JsonProperty("HD-0-1-7-6")
    private String HD_0_1_7_6; // 脑血管事件
    @Column(name = "HD_0_1_7_7")
    @JsonProperty("HD-0-1-7-7")
    private String HD_0_1_7_7; // 脑血管其他事件
    @Column(name = "HD_0_1_7_8")
    @JsonProperty("HD-0-1-7-8")
    private String HD_0_1_7_8; // 感染
    @Column(name = "HD_0_1_7_9")
    @JsonProperty("HD-0-1-7-9")
    private String HD_0_1_7_9; // 其他感染
    @Column(name = "HD_0_1_7_10")
    @JsonProperty("HD-0-1-7-10")
    private String HD_0_1_7_10; // 其他死亡原因
    @Column(name = "HD_1_1_1")
    @JsonProperty("HD-1-1-1")
    private String HD_1_1_1; // 透析起始日期
    @Column(name = "HD_1_1_2")
    @JsonProperty("HD-1-1-2")
    private String HD_1_1_2; // 首次肾脏替代治疗时基本情况
    @Column(name = "HD_1_1_2_1")
    @JsonProperty("HD-1-1-2-1")
    private String HD_1_1_2_1; // 肾功能Egfr检测值
    @Column(name = "HD_1_1_2_2")
    @JsonProperty("HD-1-1-2-2")
    private String HD_1_1_2_2; // 血肌酐水平SCr检测值
    @Column(name = "HD_1_1_2_3")
    @JsonProperty("HD-1-1-2-3")
    private String HD_1_1_2_3; // 血尿素氮水平BUN检测值
    @Column(name = "HD_2_1_1")
    @JsonProperty("HD-2-1-1")
    private String HD_2_1_1; // 透析处方_透析治疗频次
    @Column(name = "HD_2_1_1_1")
    @JsonProperty("HD-2-1-1-1")
    private String HD_2_1_1_1; // 其他透析治疗频次
    @Column(name = "HD_2_1_2")
    @JsonProperty("HD-2-1-2")
    private String HD_2_1_2; // 透析处方_血液透析每次治疗时间（小时）
    @Column(name = "HD_2_1_3")
    @JsonProperty("HD-2-1-3")
    private String HD_2_1_3; // 透析处方_HDF治疗次数
    @Column(name = "HD_2_1_3_1")
    @JsonProperty("HD-2-1-3-1")
    private String HD_2_1_3_1; // 其他HDF治疗次数
    @Column(name = "HD_2_1_4")
    @JsonProperty("HD-2-1-4")
    private String HD_2_1_4; // 透析处方_HDF治疗时间（小时）
    @Column(name = "HD_2_1_5")
    @JsonProperty("HD-2-1-5")
    private String HD_2_1_5; // 透析处方_透析浓缩液
    @Column(name = "HD_2_1_6")
    @JsonProperty("HD-2-1-6")
    private String HD_2_1_6; // 中心供液--钾离子浓度
    @Column(name = "HD_2_1_6_1")
    @JsonProperty("HD-2-1-6-1")
    private String HD_2_1_6_1; // 其他钾离子浓度(mmol/L)
    @Column(name = "HD_2_1_7")
    @JsonProperty("HD-2-1-7")
    private String HD_2_1_7; // 中心供液--钙离子浓度
    @Column(name = "HD_2_1_7_1")
    @JsonProperty("HD-2-1-7-1")
    private String HD_2_1_7_1; // 其他钙离子浓度(mmol/L)
    @Column(name = "HD_2_1_8")
    @JsonProperty("HD-2-1-8")
    private String HD_2_1_8; // 中心供液--碳酸氢根浓度
    @Column(name = "HD_2_1_8_1")
    @JsonProperty("HD-2-1-8-1")
    private String HD_2_1_8_1; // 其他碳酸氢根浓度(%)
    @Column(name = "HD_2_1_9")
    @JsonProperty("HD-2-1-9")
    private String HD_2_1_9; // 透析浓缩A液--钾离子浓度
    @Column(name = "HD_2_1_9_1")
    @JsonProperty("HD-2-1-9-1")
    private String HD_2_1_9_1; // 其他钾离子浓度(mmol/L)
    @Column(name = "HD_2_1_10")
    @JsonProperty("HD-2-1-10")
    private String HD_2_1_10; // 透析浓缩A液--钙离子浓度
    @Column(name = "HD_2_1_10_1")
    @JsonProperty("HD-2-1-10-1")
    private String HD_2_1_10_1; // 其他钙离子浓度(mmol/L)
    @Column(name = "HD_2_1_11")
    @JsonProperty("HD-2-1-11")
    private String HD_2_1_11; // 透析处方_通量
    @Column(name = "HD_2_1_12")
    @JsonProperty("HD-2-1-12")
    private String HD_2_1_12; // 透析处方_使用
    @Column(name = "HD_2_1_13")
    @JsonProperty("HD-2-1-13")
    private String HD_2_1_13; // 透析处方_类型
    @Column(name = "HD_2_1_14")
    @JsonProperty("HD-2-1-14")
    private String HD_2_1_14; // 透析处方_透析膜
    @Column(name = "HD_2_1_14_1")
    @JsonProperty("HD-2-1-14-1")
    private String HD_2_1_14_1; // 其他透析膜
    @Column(name = "HD_2_1_15")
    @JsonProperty("HD-2-1-15")
    private String HD_2_1_15; // 透析处方_膜面积
    @Column(name = "HD_2_1_16")
    @JsonProperty("HD-2-1-16")
    private String HD_2_1_16; // 透析处方_抗凝剂
    @Column(name = "HD_2_1_16_1")
    @JsonProperty("HD-2-1-16-1")
    private String HD_2_1_16_1; // 其他抗凝剂
    @Column(name = "HD_3_1_1")
    @JsonProperty("HD-3-1-1")
    private String HD_3_1_1; // 血源性传染病标志物检验
    @Column(name = "HD_3_1_1_1")
    @JsonProperty("HD-3-1-1-1")
    private String HD_3_1_1_1; // HBsAg检测值
    @Column(name = "HD_3_1_1_2")
    @JsonProperty("HD-3-1-1-2")
    private String HD_3_1_1_2; // AntiHCV检测值
    @Column(name = "HD_3_1_1_3")
    @JsonProperty("HD-3-1-1-3")
    private String HD_3_1_1_3; // 梅毒检测值
    @Column(name = "HD_3_1_1_4")
    @JsonProperty("HD-3-1-1-4")
    private String HD_3_1_1_4; // HIV抗体检测值
    @Column(name = "HD_3_1_2")
    @JsonProperty("HD-3-1-2")
    private String HD_3_1_2; // 四项“血源性传染病标志物检测”最后一个项目完成日期
    @Column(name = "HD_4_1_1")
    @JsonProperty("HD-4-1-1")
    private String HD_4_1_1; // 每3个月完成检验情况
    @Column(name = "HD_4_1_1_1")
    @JsonProperty("HD-4-1-1-1")
    private String HD_4_1_1_1; // 血红蛋白检测值
    @Column(name = "HD_4_1_1_2")
    @JsonProperty("HD-4-1-1-2")
    private String HD_4_1_1_2; // 血白蛋白检测值
    @Column(name = "HD_4_1_2")
    @JsonProperty("HD-4-1-2")
    private String HD_4_1_2; // 最后一个项目完成日期
    @Column(name = "HD_4_2_1")
    @JsonProperty("HD-4-2-1")
    private String HD_4_2_1; // 每6个月完成检验情况
    @Column(name = "HD_4_2_1_1")
    @JsonProperty("HD-4-2-1-1")
    private String HD_4_2_1_1; // HBsAg检测值
    @Column(name = "HD_4_2_1_2")
    @JsonProperty("HD-4-2-1-2")
    private String HD_4_2_1_2; // AntiHCV检测值
    @Column(name = "HD_4_2_1_3")
    @JsonProperty("HD-4-2-1-3")
    private String HD_4_2_1_3; // 梅毒检测值
    @Column(name = "HD_4_2_1_4")
    @JsonProperty("HD-4-2-1-4")
    private String HD_4_2_1_4; // HIV抗体检测值
    @Column(name = "HD_4_2_1_5")
    @JsonProperty("HD-4-2-1-5")
    private String HD_4_2_1_5; // β2微球蛋白检测值
    @Column(name = "HD_4_2_1_6")
    @JsonProperty("HD-4-2-1-6")
    private String HD_4_2_1_6; // 全段甲状旁腺素(iPTH)检测值(pg/ml)
    @Column(name = "HD_4_2_1_7")
    @JsonProperty("HD-4-2-1-7")
    private String HD_4_2_1_7; // 血清铁蛋白检测值(μg/L)
    @Column(name = "HD_4_2_1_8")
    @JsonProperty("HD-4-2-1-8")
    private String HD_4_2_1_8; // 转铁蛋白饱和度检测值(％)
    @Column(name = "HD_4_2_1_9")
    @JsonProperty("HD-4-2-1-9")
    private String HD_4_2_1_9; // 血清前白蛋白检测值(mg/dl)
    @Column(name = "HD_4_2_1_10")
    @JsonProperty("HD-4-2-1-10")
    private String HD_4_2_1_10; // C反应蛋白（CRP）检测值(mg/L)
    @Column(name = "HD_4_2_2")
    @JsonProperty("HD-4-2-2")
    private String HD_4_2_2; // 最后一个项目完成日期
    @Column(name = "HD_5_1_1")
    @JsonProperty("HD-5-1-1")
    private String HD_5_1_1; // 每3个月一次透析前后的血压情况
    @Column(name = "HD_5_1_1_1")
    @JsonProperty("HD-5-1-1-1")
    private String HD_5_1_1_1; // 透析前SBP
    @Column(name = "HD_5_1_1_2")
    @JsonProperty("HD-5-1-1-2")
    private String HD_5_1_1_2; // 透析前DBP
    @Column(name = "HD_5_1_1_3")
    @JsonProperty("HD-5-1-1-3")
    private String HD_5_1_1_3; // 透析后SBP
    @Column(name = "HD_5_1_1_4")
    @JsonProperty("HD-5-1-1-4")
    private String HD_5_1_1_4; // 透析后DBP
    @Column(name = "HD_5_1_2")
    @JsonProperty("HD-5-1-2")
    private String HD_5_1_2; // 项目完成日期
    @Column(name = "HD_5_1_3")
    @JsonProperty("HD-5-1-3")
    private String HD_5_1_3; // 高血压是否达标
    @Column(name = "HD_5_2_1")
    @JsonProperty("HD-5-2-1")
    private String HD_5_2_1; // 高血压是否达标
    @Column(name = "HD_5_2_2")
    @JsonProperty("HD-5-2-2")
    private String HD_5_2_2; // 抗高血压药治疗医嘱起始日期
    @Column(name = "HD_5_2_3")
    @JsonProperty("HD-5-2-3")
    private String HD_5_2_3; // 抗高血压药
    @Column(name = "HD_5_2_3_1")
    @JsonProperty("HD-5-2-3-1")
    private String HD_5_2_3_1; // 其他抗高血压药
    @Column(name = "HD_6_1_1")
    @JsonProperty("HD-6-1-1")
    private String HD_6_1_1; // 每3个月的最末一次血红蛋白情况
    @Column(name = "HD_6_1_1_1")
    @JsonProperty("HD-6-1-1-1")
    private String HD_6_1_1_1; // 血红蛋白检测值
    @Column(name = "HD_6_1_2")
    @JsonProperty("HD-6-1-2")
    private String HD_6_1_2; // 项目完成日期
    @Column(name = "HD_6_1_3")
    @JsonProperty("HD-6-1-3")
    private String HD_6_1_3; // 血红蛋白是否达标
    @Column(name = "HD_6_2_1")
    @JsonProperty("HD-6-2-1")
    private String HD_6_2_1; // 是否有ESA治疗医嘱
    @Column(name = "HD_6_2_2")
    @JsonProperty("HD-6-2-2")
    private String HD_6_2_2; // ESA治疗医嘱起始日期
    @Column(name = "HD_6_2_3")
    @JsonProperty("HD-6-2-3")
    private String HD_6_2_3; // ESA治疗药物
    @Column(name = "HD_6_2_3_1")
    @JsonProperty("HD-6-2-3-1")
    private String HD_6_2_3_1; // ESA治疗其他药物
    @Column(name = "HD_6_3_1")
    @JsonProperty("HD-6-3-1")
    private String HD_6_3_1; // 是否有铁剂治疗医嘱
    @Column(name = "HD_6_3_2")
    @JsonProperty("HD-6-3-2")
    private String HD_6_3_2; // 铁剂治疗医嘱起始日期
    @Column(name = "HD_6_3_3_1")
    @JsonProperty("HD-6-3-3-1")
    private String HD_6_3_3_1; // 口服铁剂治疗药物
    @Column(name = "HD_6_3_3_2")
    @JsonProperty("HD-6-3-3-2")
    private String HD_6_3_3_2; // 口服铁剂治疗其他药物
    @Column(name = "HD_6_3_3_3")
    @JsonProperty("HD-6-3-3-3")
    private String HD_6_3_3_3; // 静脉铁剂治疗药物
    @Column(name = "HD_6_3_3_4")
    @JsonProperty("HD-6-3-3-4")
    private String HD_6_3_3_4; // 静脉铁剂治疗其他药物
    @Column(name = "HD_7_1_1")
    @JsonProperty("HD-7-1-1")
    private String HD_7_1_1; // 每6个月完成检验情况
    @Column(name = "HD_7_1_1_1")
    @JsonProperty("HD-7-1-1-1")
    private String HD_7_1_1_1; // 血总钙检测值
    @Column(name = "HD_7_1_1_2")
    @JsonProperty("HD-7-1-1-2")
    private String HD_7_1_1_2; // 血磷检测值
    @Column(name = "HD_7_1_1_3")
    @JsonProperty("HD-7-1-1-3")
    private String HD_7_1_1_3; // PTH检测值
    @Column(name = "HD_7_1_2")
    @JsonProperty("HD-7-1-2")
    private String HD_7_1_2; // 最后一个项目完成日期
    @Column(name = "HD_7_1_3")
    @JsonProperty("HD-7-1-3")
    private String HD_7_1_3; // 血总钙是否达标
    @Column(name = "HD_7_1_4")
    @JsonProperty("HD-7-1-4")
    private String HD_7_1_4; // 血磷是否达标
    @Column(name = "HD_7_1_5")
    @JsonProperty("HD-7-1-5")
    private String HD_7_1_5; // 全段甲状旁腺激素（IPTH）是否达标
    @Column(name = "HD_7_2_1")
    @JsonProperty("HD-7-2-1")
    private String HD_7_2_1; // 是否有MBD干预药治疗医嘱
    @Column(name = "HD_7_2_2")
    @JsonProperty("HD-7-2-2")
    private String HD_7_2_2; // MBD干预药治疗医嘱起始日期
    @Column(name = "HD_7_2_3")
    @JsonProperty("HD-7-2-3")
    private String HD_7_2_3; // MBD干预药选择
    @Column(name = "HD_7_2_3_1")
    @JsonProperty("HD-7-2-3-1")
    private String HD_7_2_3_1; // MBD干预药_维生素D及衍生物
    @Column(name = "HD_7_2_3_2")
    @JsonProperty("HD-7-2-3-2")
    private String HD_7_2_3_2; // 其他维生素D及衍生物
    @Column(name = "HD_7_2_3_3")
    @JsonProperty("HD-7-2-3-3")
    private String HD_7_2_3_3; // MBD干预药_含钙的磷结合剂
    @Column(name = "HD_7_2_3_4")
    @JsonProperty("HD-7-2-3-4")
    private String HD_7_2_3_4; // 其他含钙的磷结合剂
    @Column(name = "HD_7_2_3_5")
    @JsonProperty("HD-7-2-3-5")
    private String HD_7_2_3_5; // MBD干预药_含铝的磷结合剂
    @Column(name = "HD_7_2_3_6")
    @JsonProperty("HD-7-2-3-6")
    private String HD_7_2_3_6; // 其他含铝的磷结合剂
    @Column(name = "HD_7_2_3_7")
    @JsonProperty("HD-7-2-3-7")
    private String HD_7_2_3_7; // MBD干预药_不含钙铝的磷结合剂
    @Column(name = "HD_7_2_3_8")
    @JsonProperty("HD-7-2-3-8")
    private String HD_7_2_3_8; // 其他不含钙铝的磷结合剂
    @Column(name = "HD_7_2_3_9")
    @JsonProperty("HD-7-2-3-9")
    private String HD_7_2_3_9; // MBD干预药_拟钙剂
    @Column(name = "HD_7_2_3_10")
    @JsonProperty("HD-7-2-3-10")
    private String HD_7_2_3_10; // 其他拟钙剂
    @Column(name = "HD_8_1_1")
    @JsonProperty("HD-8-1-1")
    private String HD_8_1_1; // 每6个月完成检验情况
    @Column(name = "HD_8_1_1_1")
    @JsonProperty("HD-8-1-1-1")
    private String HD_8_1_1_1; // 血白蛋白检测值(g/L)
    @Column(name = "HD_8_1_1_2")
    @JsonProperty("HD-8-1-1-2")
    private String HD_8_1_1_2; // 球蛋白检测值(g/L)
    @Column(name = "HD_8_1_1_3")
    @JsonProperty("HD-8-1-1-3")
    private String HD_8_1_1_3; // 白球比值
    @Column(name = "HD_8_1_2")
    @JsonProperty("HD-8-1-2")
    private String HD_8_1_2; // 最后一个项目完成日期
    @Column(name = "HD_8_1_3")
    @JsonProperty("HD-8-1-3")
    private String HD_8_1_3; // 血白蛋白是否达标
    @Column(name = "HD_8_2_1")
    @JsonProperty("HD-8-2-1")
    private String HD_8_2_1; // 是否有营养支持药物治疗医嘱
    @Column(name = "HD_8_2_2")
    @JsonProperty("HD-8-2-2")
    private String HD_8_2_2; // 营养支持药物治疗医嘱起始日期
    @Column(name = "HD_8_2_3")
    @JsonProperty("HD-8-2-3")
    private String HD_8_2_3; // 营养支持药物
    @Column(name = "HD_8_2_3_1")
    @JsonProperty("HD-8-2-3-1")
    private String HD_8_2_3_1; // 其他营养支持药物
    @Column(name = "HD_9_1_1")
    @JsonProperty("HD-9-1-1")
    private String HD_9_1_1; // 每6个月透析充分性(尿素清除指数（Kt/V）和尿素（URR）检验)
    @Column(name = "HD_9_1_1_1")
    @JsonProperty("HD-9-1-1-1")
    private String HD_9_1_1_1; // 身高(cm)
    @Column(name = "HD_9_1_1_r")
    @JsonProperty("HD-9-1-1-r")
    private String HD_9_1_1_r; // 身高转换
    @Column(name = "HD_9_1_1_2")
    @JsonProperty("HD-9-1-1-2")
    private String HD_9_1_1_2; // 体重(kg)
    @Column(name = "HD_9_1_3_r")
    @JsonProperty("HD-9-1-3-r")
    private String HD_9_1_3_r; // 体重指数(BMI)
    @Column(name = "HD_9_1_1_3")
    @JsonProperty("HD-9-1-1-3")
    private String HD_9_1_1_3; // 体重指数(BMI)
    @Column(name = "HD_9_1_4_r")
    @JsonProperty("HD-9-1-4-r")
    private String HD_9_1_4_r; // 0.0061倍身高(cm)
    @Column(name = "HD_9_1_5_r")
    @JsonProperty("HD-9-1-5-r")
    private String HD_9_1_5_r; // 0.0128倍体重(kg)
    @Column(name = "HD_9_1_6_r")
    @JsonProperty("HD-9-1-6-r")
    private String HD_9_1_6_r; // 体表面积公式
    @Column(name = "HD_9_1_7_r")
    @JsonProperty("HD-9-1-7-r")
    private String HD_9_1_7_r; // 体表面积(m²)
    @Column(name = "HD_9_1_1_4")
    @JsonProperty("HD-9-1-1-4")
    private String HD_9_1_1_4; // 体表面积(m²)
    @Column(name = "HD_9_1_1_5")
    @JsonProperty("HD-9-1-1-5")
    private String HD_9_1_1_5; // 透前尿素（URR）检测值
    @Column(name = "HD_9_1_1_6")
    @JsonProperty("HD-9-1-1-6")
    private String HD_9_1_1_6; // 透后尿素（URR）检测值
    @Column(name = "HD_9_1_1_7")
    @JsonProperty("HD-9-1-1-7")
    private String HD_9_1_1_7; // 透析时间(h)
    @Column(name = "HD_9_1_1_8")
    @JsonProperty("HD-9-1-1-8")
    private String HD_9_1_1_8; // 超滤量(kg)
    @Column(name = "HD_9_1_1_9")
    @JsonProperty("HD-9-1-1-9")
    private String HD_9_1_1_9; // KT/V尿素清除指数
    @Column(name = "HD_9_1_1_10")
    @JsonProperty("HD-9-1-1-10")
    private String HD_9_1_1_10; // 总内生肌酐清除率（Ccr）(ml/1.73m²)
    @Column(name = "HD_9_1_2")
    @JsonProperty("HD-9-1-2")
    private String HD_9_1_2; // 最后一项实验室检查报告的日期
    @Column(name = "HD_9_1_3")
    @JsonProperty("HD-9-1-3")
    private String HD_9_1_3; // 总ktv是否达标
    @Column(name = "HD_9_1_4")
    @JsonProperty("HD-9-1-4")
    private String HD_9_1_4; // 总ccr是否达标
    @Column(name = "HD_10_1_1")
    @JsonProperty("HD-10-1-1")
    private String HD_10_1_1; // 体重检测值
    @Column(name = "HD_10_1_1_1")
    @JsonProperty("HD-10-1-1-1")
    private String HD_10_1_1_1; // 体重（Kg）
    @Column(name = "HD_10_1_2")
    @JsonProperty("HD-10-1-2")
    private String HD_10_1_2; // 完成日期
    @Column(name = "HD_11_1_1")
    @JsonProperty("HD-11-1-1")
    private String HD_11_1_1; // 实验室检查_传染学指标_HBsAg和AntiHCV检测值
    @Column(name = "HD_11_1_1_1")
    @JsonProperty("HD-11-1-1-1")
    private String HD_11_1_1_1; // HBsAg检测值
    @Column(name = "HD_11_1_1_2")
    @JsonProperty("HD-11-1-1-2")
    private String HD_11_1_1_2; // AntiHCV检测值
    @Column(name = "HD_11_1_2")
    @JsonProperty("HD-11-1-2")
    private String HD_11_1_2; // 最后一个项目完成日期
    @Column(name = "HD_12_1_1")
    @JsonProperty("HD-12-1-1")
    private String HD_12_1_1; // 通路使用时间
    @Column(name = "HD_12_1_2")
    @JsonProperty("HD-12-1-2")
    private String HD_12_1_2; // 血管通路类型
    @Column(name = "HD_12_1_3")
    @JsonProperty("HD-12-1-3")
    private String HD_12_1_3; // 血管通路位置(中心静脉置管)
    @Column(name = "HD_12_1_3_1")
    @JsonProperty("HD-12-1-3-1")
    private String HD_12_1_3_1; // 其他血管通路位置
    @Column(name = "HD_12_1_4")
    @JsonProperty("HD-12-1-4")
    private String HD_12_1_4; // 中心静脉置管方法
    @Column(name = "HD_12_1_5")
    @JsonProperty("HD-12-1-5")
    private String HD_12_1_5; // 血管通路位置_内瘘
    @Column(name = "HD_12_1_2_1")
    @JsonProperty("HD-12-1-2-1")
    private String HD_12_1_2_1; // 其他血管通路类型
    @Column(name = "HD_12_1_6")
    @JsonProperty("HD-12-1-6")
    private String HD_12_1_6; // 近半年是否改变通路
    @Column(name = "HD_12_1_7")
    @JsonProperty("HD-12-1-7")
    private String HD_12_1_7; // 通路改变时间
    @Column(name = "HD_12_1_8")
    @JsonProperty("HD-12-1-8")
    private String HD_12_1_8; // 通路改变原因
    @Column(name = "HD_12_1_8_1")
    @JsonProperty("HD-12-1-8-1")
    private String HD_12_1_8_1; // 通路改变其他原因
    @Column(name = "HD_12_2_1")
    @JsonProperty("HD-12-2-1")
    private String HD_12_2_1; // 血液透析并发症ICD-10-四位亚目
    @Column(name = "HD_12_2_1_1")
    @JsonProperty("HD-12-2-1-1")
    private String HD_12_2_1_1; // 其他血液透析并发症ICD-10-四位亚目
    @Column(name = "HD_12_2_2")
    @JsonProperty("HD-12-2-2")
    private String HD_12_2_2; // 血液透析并发症ICD-10六位临床扩展编码与名称
    @Column(name = "HD_12_2_2_1")
    @JsonProperty("HD-12-2-2-1")
    private String HD_12_2_2_1; // 其他血液透析并发症ICD-10六位临床扩展编码与名称
}