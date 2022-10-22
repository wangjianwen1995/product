package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：C70.0、C70.9、D32.0、D32.9、D42.9，伴 ICD-9-CM-3 编码：01.51、01.59 的手术出院患者。
*/
@ApiModel(value = "12信息")
@Entity
@Data
@Table(name = "sd_info_MEN")
public class SdInfoMEN implements Serializable {
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
    private String CM_0_2_1_2; // 患者/患儿性别
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
    @Column(name = "CM_0_2_2_1")
    @JsonProperty("CM-0-2-2-1")
    private String CM_0_2_2_1; // 发病日期时间是否无法确定或无记录
    @Column(name = "CM_0_2_2_2")
    @JsonProperty("CM-0-2-2-2")
    private String CM_0_2_2_2; // 发病日期时间
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
    @Column(name = "MEN_1_1_1")
    @JsonProperty("MEN-1-1-1")
    private String MEN_1_1_1; // 是否实施首次头部影像学检查
    @Column(name = "MEN_1_1_2")
    @JsonProperty("MEN-1-1-2")
    private String MEN_1_1_2; // 基础影像学检查项目的选择
    @Column(name = "MEN_1_1_3")
    @JsonProperty("MEN-1-1-3")
    private String MEN_1_1_3; // 完成被选项影像学检查的日期时间
    @Column(name = "MEN_2_1_1")
    @JsonProperty("MEN-2-1-1")
    private String MEN_2_1_1; // 肿瘤大小
    @Column(name = "MEN_2_1_2")
    @JsonProperty("MEN-2-1-2")
    private String MEN_2_1_2; // 肿瘤部位
    @Column(name = "MEN_2_1_2_1")
    @JsonProperty("MEN-2-1-2-1")
    private String MEN_2_1_2_1; // 其他肿瘤部位
    @Column(name = "MEN_2_1_3")
    @JsonProperty("MEN-2-1-3")
    private String MEN_2_1_3; // 主要症状
    @Column(name = "MEN_2_1_4")
    @JsonProperty("MEN-2-1-4")
    private String MEN_2_1_4; // 癫痫类型
    @Column(name = "MEN_2_1_3_2")
    @JsonProperty("MEN-2-1-3-2")
    private String MEN_2_1_3_2; // 其他主要症状
    @Column(name = "MEN_2_1_5")
    @JsonProperty("MEN-2-1-5")
    private String MEN_2_1_5; // 是否术前告知患者或家属，手术必要性及潜在相关风险的知情同意
    @Column(name = "MEN_3_1_1")
    @JsonProperty("MEN-3-1-1")
    private String MEN_3_1_1; // 肿瘤切除手术适应证
    @Column(name = "MEN_3_1_2")
    @JsonProperty("MEN-3-1-2")
    private String MEN_3_1_2; // 是否有开颅手术的禁忌证
    @Column(name = "MEN_3_1_3")
    @JsonProperty("MEN-3-1-3")
    private String MEN_3_1_3; //  禁忌证选择
    @Column(name = "MEN_4_1_1")
    @JsonProperty("MEN-4-1-1")
    private String MEN_4_1_1; // 是否是要术中神经功能保护
    @Column(name = "MEN_4_1_2")
    @JsonProperty("MEN-4-1-2")
    private String MEN_4_1_2; // 哪种类型脑膜瘤需要术中使用的神经功能保护措施
    @Column(name = "MEN_4_1_2_1")
    @JsonProperty("MEN-4-1-2-1")
    private String MEN_4_1_2_1; // 其它类型
    @Column(name = "MEN_4_1_3")
    @JsonProperty("MEN-4-1-3")
    private String MEN_4_1_3; // 术中使用的神经功能保护措施
    @Column(name = "MEN_4_2_1")
    @JsonProperty("MEN-4-2-1")
    private String MEN_4_2_1; // 肿瘤切除率Simpson 分级
    @Column(name = "MEN_5_1_1")
    @JsonProperty("MEN-5-1-1")
    private String MEN_5_1_1; // 手术中出血量(ml)
    @Column(name = "MEN_5_1_2")
    @JsonProperty("MEN-5-1-2")
    private String MEN_5_1_2; // 手术中输血量(ml)
    @Column(name = "MEN_5_1_3")
    @JsonProperty("MEN-5-1-3")
    private String MEN_5_1_3; // 手术后出血量(ml)
    @Column(name = "MEN_5_1_4")
    @JsonProperty("MEN-5-1-4")
    private String MEN_5_1_4; // 手术后输血量(ml)
    @Column(name = "MEN_5_2_1")
    @JsonProperty("MEN-5-2-1")
    private String MEN_5_2_1; // 全血(ml)
    @Column(name = "MEN_5_2_2")
    @JsonProperty("MEN-5-2-2")
    private String MEN_5_2_2; // 成份血(ml)
    @Column(name = "MEN_5_2_3")
    @JsonProperty("MEN-5-2-3")
    private String MEN_5_2_3; // 血浆(ml)
    @Column(name = "MEN_6_1_1")
    @JsonProperty("MEN-6-1-1")
    private String MEN_6_1_1; // 是否进行复查头颅平扫CT
    @Column(name = "MEN_6_1_2")
    @JsonProperty("MEN-6-1-2")
    private String MEN_6_1_2; // 评估日期时间
    @Column(name = "MEN_6_1_3")
    @JsonProperty("MEN-6-1-3")
    private String MEN_6_1_3; // 评估结果
    @Column(name = "MEN_6_1_5")
    @JsonProperty("MEN-6-1-5")
    private String MEN_6_1_5; // 其他评估结果
    @Column(name = "MEN_6_1_4")
    @JsonProperty("MEN-6-1-4")
    private String MEN_6_1_4; // 是否需要二次手术
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM-1-1-1")
    private String CM_1_1_1; // 是否使用预防性抗菌药物
    @Column(name = "CM_1_2_1_2")
    @JsonProperty("CM-1-2-1-2")
    private String CM_1_2_1_2; // 预防性抗菌药物选择
    @Column(name = "CM_1_2_2_2")
    @JsonProperty("CM-1-2-2-2")
    private String CM_1_2_2_2; // 选择碳青霉烯类及替加环素等特殊使用级抗菌药物 
    @Column(name = "CM_1_2_2_1")
    @JsonProperty("CM-1-2-2-1")
    private String CM_1_2_2_1; // 其他特殊使用级抗菌药物名称
    @Column(name = "CM_1_3_1_2")
    @JsonProperty("CM-1-3-1-2")
    private String CM_1_3_1_2; // 选用“特殊使用级抗菌药物”或者其他类抗菌药物的因素
    @Column(name = "CM_1_3_1_1")
    @JsonProperty("CM-1-3-1-1")
    private String CM_1_3_1_1; // 选用“特殊使用级抗菌药物”或者其他类抗菌药物的因素填写
    @Column(name = "CM_1_4_1")
    @JsonProperty("CM-1-4-1")
    private String CM_1_4_1; // 使用首剂抗菌药物起始时间
    @Column(name = "CM_1_5_1")
    @JsonProperty("CM-1-5-1")
    private String CM_1_5_1; // 手术时间是否≥3小时
    @Column(name = "CM_1_5_2")
    @JsonProperty("CM-1-5-2")
    private String CM_1_5_2; // 是否术中追加抗菌药物
    @Column(name = "CM_1_5_3")
    @JsonProperty("CM-1-5-3")
    private String CM_1_5_3; // 术中出血量是否≥1500ml
    @Column(name = "CM_1_5_4")
    @JsonProperty("CM-1-5-4")
    private String CM_1_5_4; // 是否术中追加抗菌药物
    @Column(name = "CM_1_6_1")
    @JsonProperty("CM-1-6-1")
    private String CM_1_6_1; // 术后抗菌药物停止使用时间
    @Column(name = "CM_1_6_1_dump")
    @JsonProperty("CM-1-6-1-dump")
    private String CM_1_6_1_dump; // 使用抗菌药物时间
    @Column(name = "CM_1_6_2")
    @JsonProperty("CM-1-6-2")
    private String CM_1_6_2; // 使用抗菌药物时间使用时间分层
    @Column(name = "CM_1_6_3_2")
    @JsonProperty("CM-1-6-3-2")
    private String CM_1_6_3_2; // 术后72小时之后继续使用的原因
    @Column(name = "CM_2_1")
    @JsonProperty("CM-2-1")
    private String CM_2_1; // 是否有手术后并发症
    @Column(name = "CM_2_2")
    @JsonProperty("CM-2-2")
    private String CM_2_2; // 手术后并发症类别及ICD-10四位亚目的选择
    @Column(name = "CM_2_3_1_1")
    @JsonProperty("CM-2-3-1-1")
    private String CM_2_3_1_1; // 其他手术后并发症类别及ICD-10四位亚目和名称填写
    @Column(name = "CM_2_3_1")
    @JsonProperty("CM-2-3-1")
    private String CM_2_3_1; // 介入操作与手术其他并发症
    @Column(name = "CM_2_3_2")
    @JsonProperty("CM-2-3-2")
    private String CM_2_3_2; // 手术患者手术后肺栓塞
    @Column(name = "CM_2_3_3")
    @JsonProperty("CM-2-3-3")
    private String CM_2_3_3; // 手术患者手术后深静脉血栓
    @Column(name = "CM_2_3_4")
    @JsonProperty("CM-2-3-4")
    private String CM_2_3_4; // 手术患者手术后败血症
    @Column(name = "CM_2_3_5")
    @JsonProperty("CM-2-3-5")
    private String CM_2_3_5; // 手术患者手术后出血或血肿
    @Column(name = "CM_2_3_6")
    @JsonProperty("CM-2-3-6")
    private String CM_2_3_6; // 手术患者手术伤口裂开
    @Column(name = "CM_2_3_7")
    @JsonProperty("CM-2-3-7")
    private String CM_2_3_7; // 手术患者猝死
    @Column(name = "CM_2_3_8")
    @JsonProperty("CM-2-3-8")
    private String CM_2_3_8; // 手术患者手术后呼吸道并发症
    @Column(name = "CM_2_3_9")
    @JsonProperty("CM-2-3-9")
    private String CM_2_3_9; // 手术患者手术后生理/代谢紊乱
    @Column(name = "CM_2_3_10")
    @JsonProperty("CM-2-3-10")
    private String CM_2_3_10; // 与手术/操作相关感染
    @Column(name = "CM_2_3_11")
    @JsonProperty("CM-2-3-11")
    private String CM_2_3_11; // 手术过程中异物遗留
    @Column(name = "CM_2_3_12")
    @JsonProperty("CM-2-3-12")
    private String CM_2_3_12; // 麻醉并发症
    @Column(name = "CM_2_3_13")
    @JsonProperty("CM-2-3-13")
    private String CM_2_3_13; // 输注、输血反应
    @Column(name = "CM_2_3_14")
    @JsonProperty("CM-2-3-14")
    private String CM_2_3_14; // 住院患者发生压疮
    @Column(name = "CM_2_3_15")
    @JsonProperty("CM-2-3-15")
    private String CM_2_3_15; // 术后急性肾功能损害
    @Column(name = "CM_2_3")
    @JsonProperty("CM-2-3")
    private String CM_2_3; // 神经系统术后特指并发症
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    @Column(name = "CM_2_5_1")
    @JsonProperty("CM-2-5-1")
    private String CM_2_5_1; // 是否手术后再手术
    @Column(name = "CM_2_5_2")
    @JsonProperty("CM-2-5-2")
    private String CM_2_5_2; // 手术后再手术名称
    @Column(name = "CM_2_5_3")
    @JsonProperty("CM-2-5-3")
    private String CM_2_5_3; // 再手术日期时间
    @Column(name = "MEN_9_1_1")
    @JsonProperty("MEN-9-1-1")
    private String MEN_9_1_1; // 病理诊断包含的基本内容
    @Column(name = "MEN_9_1_2")
    @JsonProperty("MEN-9-1-2")
    private String MEN_9_1_2; // 病理诊断是否按照2016 CNS WHO肿瘤分类标准名称
    @Column(name = "MEN_9_1_3")
    @JsonProperty("MEN-9-1-3")
    private String MEN_9_1_3; // 脑膜瘤WHO分级
    @Column(name = "MEN_9_1_4")
    @JsonProperty("MEN-9-1-4")
    private String MEN_9_1_4; // 病理组织学类型
    @Column(name = "MEN_9_1_5")
    @JsonProperty("MEN-9-1-5")
    private String MEN_9_1_5; // 病理诊断报告日期时间
    @Column(name = "MEN_10_1_1_0")
    @JsonProperty("MEN-10-1-1-0")
    private String MEN_10_1_1_0; // 出院前是否存在功能残损
    @Column(name = "MEN_10_1_1")
    @JsonProperty("MEN-10-1-1")
    private String MEN_10_1_1; // 出院前存在功能残损
    @Column(name = "MEN_10_1_1_1")
    @JsonProperty("MEN-10-1-1-1")
    private String MEN_10_1_1_1; // 其他出院前存在功能残损
    @Column(name = "MEN_10_1_2")
    @JsonProperty("MEN-10-1-2")
    private String MEN_10_1_2; // 出院前是否完成KPS评分
    @Column(name = "MEN_10_1_2_3")
    @JsonProperty("MEN-10-1-2-3")
    private String MEN_10_1_2_3; // KPS评分功能状态
    @Column(name = "MEN_10_2_1")
    @JsonProperty("MEN-10-2-1")
    private String MEN_10_2_1; // 出院前是否完成MRI T1/T2加权平扫+增强扫描影像学评估
    @Column(name = "MEN_10_2_2")
    @JsonProperty("MEN-10-2-2")
    private String MEN_10_2_2; // 影像学评估日期时间
    @Column(name = "MEN_10_2_3")
    @JsonProperty("MEN-10-2-3")
    private String MEN_10_2_3; // 肿瘤全切率(%)
    @Column(name = "MEN_10_2_4")
    @JsonProperty("MEN-10-2-4")
    private String MEN_10_2_4; // 肿瘤全切率分类
    @Column(name = "MEN_11_1_1")
    @JsonProperty("MEN-11-1-1")
    private String MEN_11_1_1; // 入院时是否有重点护理评估
    @Column(name = "MEN_11_1_2_1")
    @JsonProperty("MEN-11-1-2-1")
    private String MEN_11_1_2_1; // 行走评估结果
    @Column(name = "MEN_11_1_2_2")
    @JsonProperty("MEN-11-1-2-2")
    private String MEN_11_1_2_2; // 呼吸评估结果
    @Column(name = "MEN_11_1_2_3")
    @JsonProperty("MEN-11-1-2-3")
    private String MEN_11_1_2_3; // 饮食评估结果
    @Column(name = "MEN_11_1_2_4")
    @JsonProperty("MEN-11-1-2-4")
    private String MEN_11_1_2_4; // 吞咽评估结果
    @Column(name = "MEN_11_1_2_6")
    @JsonProperty("MEN-11-1-2-6")
    private String MEN_11_1_2_6; // 压疮评估无法确定
    @Column(name = "MEN_11_1_2_5")
    @JsonProperty("MEN-11-1-2-5")
    private String MEN_11_1_2_5; // 压疮评估（Braden评分值）分值
    @Column(name = "MEN_11_1_2_5_1")
    @JsonProperty("MEN-11-1-2-5-1")
    private String MEN_11_1_2_5_1; // 压疮评估结果选择
    @Column(name = "MEN_11_1_2_5_2")
    @JsonProperty("MEN-11-1-2-5-2")
    private String MEN_11_1_2_5_2; // 预防压疮告知
    @Column(name = "MEN_11_1_2")
    @JsonProperty("MEN-11-1-2")
    private String MEN_11_1_2; // 是否进行术前健康教育，且有记录
    @Column(name = "MEN_11_1_3_2")
    @JsonProperty("MEN-11-1-3-2")
    private String MEN_11_1_3_2; // 实施术前健康教育有记录
    @Column(name = "MEN_11_1_3_2_1")
    @JsonProperty("MEN-11-1-3-2-1")
    private String MEN_11_1_3_2_1; // 其他术前健康教育记录
    @Column(name = "MEN_11_1_3_4")
    @JsonProperty("MEN-11-1-3-4")
    private String MEN_11_1_3_4; // 是否进行术后健康教育，且有记录
    @Column(name = "MEN_11_1_3_3")
    @JsonProperty("MEN-11-1-3-3")
    private String MEN_11_1_3_3; // 实施术后健康教育有记录
    @Column(name = "MEN_11_1_3_3_1")
    @JsonProperty("MEN-11-1-3-3-1")
    private String MEN_11_1_3_3_1; // 其他术后健康教育记录
    @Column(name = "MEN_11_2")
    @JsonProperty("MEN-11-2")
    private String MEN_11_2; // 是否履行出院教育与告知责任，且有记录
    @Column(name = "MEN_11_2_2_1")
    @JsonProperty("MEN-11-2-2-1")
    private String MEN_11_2_2_1; // 交与患者“出院小结”的副本，并告知患者出院时风险因素
    @Column(name = "MEN_11_2_2_2")
    @JsonProperty("MEN-11-2-2-2")
    private String MEN_11_2_2_2; // 出院带药
    @Column(name = "MEN_11_2_2_3")
    @JsonProperty("MEN-11-2-2-3")
    private String MEN_11_2_2_3; // 告知发生紧急情况时求援救治途径
    @Column(name = "MEN_11_2_2_4")
    @JsonProperty("MEN-11-2-2-4")
    private String MEN_11_2_2_4; // 出院时教育与随访
    @Column(name = "MEN_11_2_2_5")
    @JsonProperty("MEN-11-2-2-5")
    private String MEN_11_2_2_5; // 告知何为风险因素与紧急情况
    @Column(name = "CM_3_1")
    @JsonProperty("CM-3-1")
    private String CM_3_1; // 手术野皮肤准备常用方法的选择
    @Column(name = "CM_3_2")
    @JsonProperty("CM-3-2")
    private String CM_3_2; // 使用含抗菌剂（三氯生）缝线
    @Column(name = "CM_3_2_1")
    @JsonProperty("CM-3-2-1")
    private String CM_3_2_1; // 其他含抗菌剂缝线填写
    @Column(name = "CM_3_3")
    @JsonProperty("CM-3-3")
    private String CM_3_3; // 手术切口类别的选择
    @Column(name = "CM_3_4")
    @JsonProperty("CM-3-4")
    private String CM_3_4; // 手术切口愈合情况的选择
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