package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*需要落实预防静脉血栓措施的重点患者：
1.入住 ICU 的患者
2.中高危风险患者：
（1） 高龄（≥70 岁）
（2） 既往 VTE 病史或 VTE 家族史
（3） 恶性肿瘤(ICD-10 类目编码:C00-C97)
（4） 严重创伤
（5） 脓毒症(ICD-10 亚目编码：“A40.0、A40.1、A40.2、A40.3、A40.8、A40.9、A41.0、A41.1、A41.2、A41.3、A41.4、A41.5、A41.8、A41.9，R65.2、R65.3、R65.9)
（6） 急性生理和慢性健康评分⁃ Ⅱ（APACHE⁃ Ⅱ）＞12 分
（7） 急诊手术及麻醉复苏室转入
（8） 转入 ICU 前住院时间长（>30 天）
（9） 制动
（10）机械通气(ICD-9-CM-3 亚目编码：96.7 其他持续侵入性机械性通气,93.90、93.91 无创机械性通气)
（11）留置中心静脉导管(ICD-9-CM-3亚目编码89.60-89.69)
（12）血液净化治疗（ICD-9-CM-3 亚目编码：“39.95”）
（13）使用肌肉松弛和镇静药物
（14）应用收缩血管药物
（15）输注血小板
（16）血栓预防失败
（17）医师认为需评估的其他中高风险患者
*/
@ApiModel(value = "46信息")
@Entity
@Data
@Table(name = "sd_info_VTE")
public class SdInfoVTE implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    @Column(name = "VTE_0_1_2")
    @JsonProperty("VTE-0-1-2")
    private String VTE_0_1_2; // 适用临床科室患者凡符合下列条件者，应首先进行VTE风险评估<br/>(注：手术科室不在此上报范围，请按手术名称填报"围手术期预防深靜栓塞（DVT))
    @Column(name = "VTE_0_1_2_1")
    @JsonProperty("VTE-0-1-2-1")
    private String VTE_0_1_2_1; // 其他临床科室的其他中高风险患者的科室名称
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
    @Column(name = "VTE_0_1_1")
    @JsonProperty("VTE-0-1-1")
    private String VTE_0_1_1; // 中高风险患者和入住ICU的患者的主要风险项选择
    @Column(name = "VTE_0_1_1_t")
    @JsonProperty("VTE-0-1-1-t")
    private String VTE_0_1_1_t; // 严重创伤 (累及身体多个部位损伤)
    @Column(name = "VTE_0_1_1_c")
    @JsonProperty("VTE-0-1-1-c")
    private String VTE_0_1_1_c; // 恶性肿瘤ICD-10类目编码
    @Column(name = "VTE_0_1_1_d")
    @JsonProperty("VTE-0-1-1-d")
    private String VTE_0_1_1_d; // 脓毒症ICD-10亚目编码
    @Column(name = "VTE_0_1_1_e")
    @JsonProperty("VTE-0-1-1-e")
    private String VTE_0_1_1_e; // 累及身体多个部位损伤ICD-10类目编码
    @Column(name = "VTE_0_1_1_i")
    @JsonProperty("VTE-0-1-1-i")
    private String VTE_0_1_1_i; // 制动选择
    @Column(name = "VTE_0_1_1_j")
    @JsonProperty("VTE-0-1-1-j")
    private String VTE_0_1_1_j; // 机械通气ICD-9-CM-3亚目编码
    @Column(name = "VTE_0_1_1_k")
    @JsonProperty("VTE-0-1-1-k")
    private String VTE_0_1_1_k; // 留置中心静脉导管ICD-9-CM-3亚目编码
    @Column(name = "VTE_0_1_1_l")
    @JsonProperty("VTE-0-1-1-l")
    private String VTE_0_1_1_l; // 血液净化治疗ICD-9-CM-3亚目编码
    @Column(name = "VTE_0_1_1_m")
    @JsonProperty("VTE-0-1-1-m")
    private String VTE_0_1_1_m; // 使用肌肉松弛和镇静药物选择
    @Column(name = "VTE_0_1_1_n")
    @JsonProperty("VTE-0-1-1-n")
    private String VTE_0_1_1_n; // 应用收缩血管药物选择
    @Column(name = "VTE_0_1_1_q")
    @JsonProperty("VTE-0-1-1-q")
    private String VTE_0_1_1_q; // 医师认为需评估的其他中高风险患者--高危孕产妇记录
    @Column(name = "VTE_0_1_3")
    @JsonProperty("VTE-0-1-3")
    private String VTE_0_1_3; // 出院时主要诊断ICD-10编码及名称
    @Column(name = "VTE_0_1_4")
    @JsonProperty("VTE-0-1-4")
    private String VTE_0_1_4; // 出院时其他诊断ICD-10编码及名称
    @Column(name = "VTE_0_1_5")
    @JsonProperty("VTE-0-1-5")
    private String VTE_0_1_5; // 出院时主要手术及操作ICD-9-CM-3编码及名称
    @Column(name = "VTE_0_1_6")
    @JsonProperty("VTE-0-1-6")
    private String VTE_0_1_6; // 出院时其他手术及操作ICD-9-CM-3编码及名称
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
    private String CM_0_2_5_1; // 入住ICU日期时间
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU日期时间
    @Column(name = "CM_0_2_6_1")
    @JsonProperty("CM-0-2-6-1")
    private String CM_0_2_6_1; // 手术开始（切皮）日期时间 
    @Column(name = "CM_0_2_6_2")
    @JsonProperty("CM-0-2-6-2")
    private String CM_0_2_6_2; // 手术结束（缝皮结束）日期时间
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "VTE_1_1_1")
    @JsonProperty("VTE-1-1-1")
    private String VTE_1_1_1; // 实施血栓风险因素评估工具选择
    @Column(name = "VTE_1_1_2")
    @JsonProperty("VTE-1-1-2")
    private String VTE_1_1_2; // Caprini评估分值
    @Column(name = "VTE_1_1_3")
    @JsonProperty("VTE-1-1-3")
    private String VTE_1_1_3; // 风险分层
    @Column(name = "VTE_1_1_4")
    @JsonProperty("VTE-1-1-4")
    private String VTE_1_1_4; // Padua评分分值
    @Column(name = "VTE_1_1_5")
    @JsonProperty("VTE-1-1-5")
    private String VTE_1_1_5; // 风险分层
    @Column(name = "VTE_1_2_1")
    @JsonProperty("VTE-1-2-1")
    private String VTE_1_2_1; // 呼吸(次/分)
    @Column(name = "VTE_1_2_2")
    @JsonProperty("VTE-1-2-2")
    private String VTE_1_2_2; // 脉搏(次/分)
    @Column(name = "VTE_1_2_3")
    @JsonProperty("VTE-1-2-3")
    private String VTE_1_2_3; // 收缩压(mmHg)
    @Column(name = "VTE_1_2_4")
    @JsonProperty("VTE-1-2-4")
    private String VTE_1_2_4; // 舒张压(mmHg)
    @Column(name = "VTE_2_1_1")
    @JsonProperty("VTE-2-1-1")
    private String VTE_2_1_1; // 是否实施下肢静脉血管多普勒超声检查评估
    @Column(name = "VTE_2_1_2")
    @JsonProperty("VTE-2-1-2")
    private String VTE_2_1_2; // 实施多普勒超声检查评估日期时间
    @Column(name = "VTE_2_1_3")
    @JsonProperty("VTE-2-1-3")
    private String VTE_2_1_3; // 有无多普勒超声检查阳性发现
    @Column(name = "VTE_2_2_1")
    @JsonProperty("VTE-2-2-1")
    private String VTE_2_2_1; // 实施D⁃二聚体检测评估
    @Column(name = "VTE_2_2_2")
    @JsonProperty("VTE-2-2-2")
    private String VTE_2_2_2; // D⁃二聚体检测评估日期时间
    @Column(name = "VTE_2_2_3")
    @JsonProperty("VTE-2-2-3")
    private String VTE_2_2_3; // D⁃二聚体检测值(μg／L)
    @Column(name = "VTE_2_2_4")
    @JsonProperty("VTE-2-2-4")
    private String VTE_2_2_4; // D⁃二聚体检测评估结论
    @Column(name = "VTE_2_2_5")
    @JsonProperty("VTE-2-2-5")
    private String VTE_2_2_5; // 是否实施氧合评估
    @Column(name = "VTE_2_2_6")
    @JsonProperty("VTE-2-2-6")
    private String VTE_2_2_6; // 氧合评估
    @Column(name = "VTE_2_2_6_1")
    @JsonProperty("VTE-2-2-6-1")
    private String VTE_2_2_6_1; // 动脉血气分析值(mmHg)
    @Column(name = "VTE_2_2_6_2")
    @JsonProperty("VTE-2-2-6-2")
    private String VTE_2_2_6_2; // 指氧仪检查值(%)
    @Column(name = "VTE_2_2_7")
    @JsonProperty("VTE-2-2-7")
    private String VTE_2_2_7; // 是否实施心脏生物学标志物检测
    @Column(name = "VTE_2_2_8")
    @JsonProperty("VTE-2-2-8")
    private String VTE_2_2_8; // 心脏生物学标志物检测项目
    @Column(name = "VTE_2_2_8_1")
    @JsonProperty("VTE-2-2-8-1")
    private String VTE_2_2_8_1; // 肌钙蛋白T（TnT）检测值
    @Column(name = "VTE_2_2_8_2")
    @JsonProperty("VTE-2-2-8-2")
    private String VTE_2_2_8_2; // 肌钙蛋白I（TnI）检测值
    @Column(name = "VTE_2_2_8_3")
    @JsonProperty("VTE-2-2-8-3")
    private String VTE_2_2_8_3; // 肌酸激酶同工酶（CK-MB）检测值
    @Column(name = "VTE_2_2_8_4")
    @JsonProperty("VTE-2-2-8-4")
    private String VTE_2_2_8_4; // 心肌肌红蛋白（Myo）检测值
    @Column(name = "VTE_2_2_8_5")
    @JsonProperty("VTE-2-2-8-5")
    private String VTE_2_2_8_5; // B型钠尿肽（BNP）检测值
    @Column(name = "VTE_2_2_8_6")
    @JsonProperty("VTE-2-2-8-6")
    private String VTE_2_2_8_6; // N端B型钠尿肽前体（NT-ProBNP）检测值
    @Column(name = "VTE_2_2_9")
    @JsonProperty("VTE-2-2-9")
    private String VTE_2_2_9; // 是否实施凝血功能检测
    @Column(name = "VTE_2_2_10")
    @JsonProperty("VTE-2-2-10")
    private String VTE_2_2_10; // 凝血功能检测项目
    @Column(name = "VTE_2_2_10_1")
    @JsonProperty("VTE-2-2-10-1")
    private String VTE_2_2_10_1; // 血浆凝血酶原时间（PT）检测值
    @Column(name = "VTE_2_2_10_2")
    @JsonProperty("VTE-2-2-10-2")
    private String VTE_2_2_10_2; // 纤维蛋白原（FIB）检测值
    @Column(name = "VTE_2_2_10_3")
    @JsonProperty("VTE-2-2-10-3")
    private String VTE_2_2_10_3; // 活化部分凝血活酶时间（APTT）检测值
    @Column(name = "VTE_2_2_10_4")
    @JsonProperty("VTE-2-2-10-4")
    private String VTE_2_2_10_4; // 血浆凝血酶时间（TT）检测值
    @Column(name = "VTE_2_3_1")
    @JsonProperty("VTE-2-3-1")
    private String VTE_2_3_1; // 是否行CT肺动脉造影（CTPA）检查评估
    @Column(name = "VTE_2_3_2")
    @JsonProperty("VTE-2-3-2")
    private String VTE_2_3_2; // 实施行CT肺动脉造影（CTPA）检查日期时间
    @Column(name = "VTE_2_3_3")
    @JsonProperty("VTE-2-3-3")
    private String VTE_2_3_3; // CT肺动脉造影（CTPA）检查阳性发现
    @Column(name = "VTE_3_1_1")
    @JsonProperty("VTE-3-1-1")
    private String VTE_3_1_1; // 有无履行VTE预防相关的患者/家属知情同意
    @Column(name = "VTE_3_1_2")
    @JsonProperty("VTE-3-1-2")
    private String VTE_3_1_2; // VTE预防相关的患者/家属知情同意
    @Column(name = "VTE_3_2_1")
    @JsonProperty("VTE-3-2-1")
    private String VTE_3_2_1; // 有无实施出血风险和其他可能影响预防的因素评估
    @Column(name = "VTE_3_2_2")
    @JsonProperty("VTE-3-2-2")
    private String VTE_3_2_2; // 实施出血风险和其他可能影响预防的因素评估
    @Column(name = "VTE_3_2_2_1")
    @JsonProperty("VTE-3-2-2-1")
    private String VTE_3_2_2_1; // 患者因素选择
    @Column(name = "VTE_3_2_2_2")
    @JsonProperty("VTE-3-2-2-2")
    private String VTE_3_2_2_2; // 基础疾病
    @Column(name = "VTE_3_2_2_3")
    @JsonProperty("VTE-3-2-2-3")
    private String VTE_3_2_2_3; // 合并用药
    @Column(name = "VTE_3_2_2_4")
    @JsonProperty("VTE-3-2-2-4")
    private String VTE_3_2_2_4; // 侵入性操作
    @Column(name = "VTE_3_2_2_5")
    @JsonProperty("VTE-3-2-2-5")
    private String VTE_3_2_2_5; // 其他实施出血风险和其他可能影响预防的因素评估
    @Column(name = "VTE_3_2_3_1")
    @JsonProperty("VTE-3-2-3-1")
    private String VTE_3_2_3_1; // 是否有物理性预防禁忌证
    @Column(name = "VTE_3_2_3_2")
    @JsonProperty("VTE-3-2-3-2")
    private String VTE_3_2_3_2; // 物理性预防措施应用禁忌证
    @Column(name = "VTE_3_3_0")
    @JsonProperty("VTE-3-3-0")
    private String VTE_3_3_0; // 是否需要三级预防深静脉栓塞
    @Column(name = "VTE_3_3_1")
    @JsonProperty("VTE-3-3-1")
    private String VTE_3_3_1; // 三级预防深静脉栓塞措施选择
    @Column(name = "VTE_3_3_2")
    @JsonProperty("VTE-3-3-2")
    private String VTE_3_3_2; // 基本预防措施的选择
    @Column(name = "VTE_3_3_2_1")
    @JsonProperty("VTE-3-3-2-1")
    private String VTE_3_3_2_1; // 其他基本预防措施
    @Column(name = "VTE_3_3_3")
    @JsonProperty("VTE-3-3-3")
    private String VTE_3_3_3; // 医嘱执行起始日期
    @Column(name = "VTE_3_3_4")
    @JsonProperty("VTE-3-3-4")
    private String VTE_3_3_4; // 机械预防措施的选择
    @Column(name = "VTE_3_3_4_1")
    @JsonProperty("VTE-3-3-4-1")
    private String VTE_3_3_4_1; // 其他机械预防措施
    @Column(name = "VTE_3_3_5")
    @JsonProperty("VTE-3-3-5")
    private String VTE_3_3_5; // 医嘱执行日期
    @Column(name = "VTE_3_3_6")
    @JsonProperty("VTE-3-3-6")
    private String VTE_3_3_6; // 预防性地药物的选择
    @Column(name = "VTE_3_3_6_1")
    @JsonProperty("VTE-3-3-6-1")
    private String VTE_3_3_6_1; // 其他预防性地药物
    @Column(name = "VTE_3_2_7")
    @JsonProperty("VTE-3-2-7")
    private String VTE_3_2_7; // 医嘱执行日期
    @Column(name = "VTE_3_3_8")
    @JsonProperty("VTE-3-3-8")
    private String VTE_3_3_8; // 出院后继续使用抗凝药
    @Column(name = "VTE_3_3_8_1")
    @JsonProperty("VTE-3-3-8-1")
    private String VTE_3_3_8_1; // 其他出院后继续使用抗凝药
    @Column(name = "VTE_3_4_1")
    @JsonProperty("VTE-3-4-1")
    private String VTE_3_4_1; // 预防依从性评估
    @Column(name = "VTE_3_4_2")
    @JsonProperty("VTE-3-4-2")
    private String VTE_3_4_2; // 预防安全性主要监测项目
    @Column(name = "VTE_3_4_2_1")
    @JsonProperty("VTE-3-4-2-1")
    private String VTE_3_4_2_1; // 其他预防安全性主要监测项目
    @Column(name = "VTE_3_4_3")
    @JsonProperty("VTE-3-4-3")
    private String VTE_3_4_3; // 是否进行预防效果评估
    @Column(name = "VTE_3_4_4")
    @JsonProperty("VTE-3-4-4")
    private String VTE_3_4_4; // 预防效果评估及相关不良事件
    @Column(name = "VTE_3_4_4_1")
    @JsonProperty("VTE-3-4-4-1")
    private String VTE_3_4_4_1; // 与预防相关的不良事件
    @Column(name = "VTE_3_4_4_2")
    @JsonProperty("VTE-3-4-4-2")
    private String VTE_3_4_4_2; // 与预防不相关的不良事件
    @Column(name = "VTE_3_4_4_3")
    @JsonProperty("VTE-3-4-4-3")
    private String VTE_3_4_4_3; // 其他预防效果评估及相关不良事件
    @Column(name = "VTE_4_1_1")
    @JsonProperty("VTE-4-1-1")
    private String VTE_4_1_1; // 是否为临床高度拟诊"VTE"的患者
    @Column(name = "VTE_4_1_2")
    @JsonProperty("VTE-4-1-2")
    private String VTE_4_1_2; // DVT临床高度可疑患者的识别检查项目
    @Column(name = "VTE_4_1_2_1")
    @JsonProperty("VTE-4-1-2-1")
    private String VTE_4_1_2_1; // 其他DVT临床高度可疑患者的识别检查项目
    @Column(name = "VTE_4_1_3")
    @JsonProperty("VTE-4-1-3")
    private String VTE_4_1_3; // 急性PTE临床高度可疑患者的识别检查项目
    @Column(name = "VTE_4_1_3_1")
    @JsonProperty("VTE-4-1-3-1")
    private String VTE_4_1_3_1; // 其他急性PTE临床高度可疑患者的识别检查项目
    @Column(name = "VTE_4_1_4")
    @JsonProperty("VTE-4-1-4")
    private String VTE_4_1_4; // 出现首个VTE的临床表现时间
    @Column(name = "VTE_4_2_1")
    @JsonProperty("VTE-4-2-1")
    private String VTE_4_2_1; // 是否经MDT制定VTE 针对性紧急处理方案
    @Column(name = "VTE_4_2_2")
    @JsonProperty("VTE-4-2-2")
    private String VTE_4_2_2; // 临床高度可疑为VTE后,针对性紧急处理的方法
    @Column(name = "VTE_4_2_2_1")
    @JsonProperty("VTE-4-2-2-1")
    private String VTE_4_2_2_1; // 其他临床高度可疑为VTE后,针对性紧急处理的方法
    @Column(name = "VTE_4_5_1")
    @JsonProperty("VTE-4-5-1")
    private String VTE_4_5_1; // 抗凝重叠治疗医嘱的执行起始的时间选择
    @Column(name = "VTE_4_5_1_a")
    @JsonProperty("VTE-4-5-1-a")
    private String VTE_4_5_1_a; // 溶栓剂（rt-PA+尿激酶）治疗医嘱的执行起始的时间
    @Column(name = "VTE_4_5_1_b")
    @JsonProperty("VTE-4-5-1-b")
    private String VTE_4_5_1_b; // 溶栓剂（rt-PA使用普通肝素（UFH）治疗医嘱的执行起始的时间+尿激酶）治疗医嘱的执行起始的时间
    @Column(name = "VTE_4_5_1_c")
    @JsonProperty("VTE-4-5-1-c")
    private String VTE_4_5_1_c; // 低分子肝素钙（LMWH）治疗医嘱的执行起始的时间
    @Column(name = "VTE_4_5_1_d")
    @JsonProperty("VTE-4-5-1-d")
    private String VTE_4_5_1_d; // 维生素K拮抗剂（VKA）治疗医嘱的执行起始的时间
    @Column(name = "VTE_4_5_1_e")
    @JsonProperty("VTE-4-5-1-e")
    private String VTE_4_5_1_e; // 华法林（Warfarin）治疗医嘱的执行起始的时间
    @Column(name = "VTE_4_5_1_f")
    @JsonProperty("VTE-4-5-1-f")
    private String VTE_4_5_1_f; // 其他抗凝剂治疗医嘱的执行起始的时间
    @Column(name = "VTE_4_6_1")
    @JsonProperty("VTE-4-6-1")
    private String VTE_4_6_1; // 放置静脉滤器（IVCF）预防PTE的执行起始的时间
    @Column(name = "VTE_4_6_2")
    @JsonProperty("VTE-4-6-2")
    private String VTE_4_6_2; // 放置静脉滤器（IVCF）预防PTE的术式
    @Column(name = "CM_4_1")
    @JsonProperty("CM-4-1")
    private String CM_4_1; // 住院天数
    @Column(name = "CM_4_2")
    @JsonProperty("CM-4-2")
    private String CM_4_2; // 其中:术后住院天数
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