package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：D35.2、C75.1、D44.3、E22.0、E23.6，伴 ICD-9-CM-3 编码：07.61 至 07.69、07.71、07.72、07.79 和 01.59 的手术出院患者。
*/
@ApiModel(value = "14信息")
@Entity
@Data
@Table(name = "sd_info_PA")
public class SdInfoPA implements Serializable {
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
    @Column(name = "PA_0_1_7_1")
    @JsonProperty("PA-0-1-7-1")
    private String PA_0_1_7_1; // 其他主要诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "PA_0_1_8_1")
    @JsonProperty("PA-0-1-8-1")
    private String PA_0_1_8_1; // 其他主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "PA_0_1_9_1")
    @JsonProperty("PA-0-1-9-1")
    private String PA_0_1_9_1; // 其他主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "PA_0_1_10_1")
    @JsonProperty("PA-0-1-10-1")
    private String PA_0_1_10_1; // 其他主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // PA出院后是否31天内重复住院
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
    @Column(name = "PA_1_1_1")
    @JsonProperty("PA-1-1-1")
    private String PA_1_1_1; // 主要临床表现
    @Column(name = "PA_1_2_1")
    @JsonProperty("PA-1-2-1")
    private String PA_1_2_1; // 首次磁共振扫描
    @Column(name = "PA_1_2_2_1")
    @JsonProperty("PA-1-2-2-1")
    private String PA_1_2_2_1; // 获得首次磁共振检查报告的日期时间是否确定
    @Column(name = "PA_1_2_2")
    @JsonProperty("PA-1-2-2")
    private String PA_1_2_2; // 获得首次磁共振检查报告的日期时间
    @Column(name = "PA_1_2_3")
    @JsonProperty("PA-1-2-3")
    private String PA_1_2_3; // 首次磁共振扫描模式
    @Column(name = "PA_1_2_4")
    @JsonProperty("PA-1-2-4")
    private String PA_1_2_4; // 肿瘤大小
    @Column(name = "PA_2_1_1")
    @JsonProperty("PA-2-1-1")
    private String PA_2_1_1; // 是否进行术前双侧视力与视野评估
    @Column(name = "PA_2_1_2")
    @JsonProperty("PA-2-1-2")
    private String PA_2_1_2; // 左眼视力数值
    @Column(name = "PA_2_1_3")
    @JsonProperty("PA-2-1-3")
    private String PA_2_1_3; // 右眼视力数值
    @Column(name = "PA_2_2_1")
    @JsonProperty("PA-2-2-1")
    private String PA_2_2_1; // 是否进行术前内分泌检查（垂体激素）评估
    @Column(name = "PA_2_2_1_1")
    @JsonProperty("PA-2-2-1-1")
    private String PA_2_2_1_1; // 血清催乳素PRL(ng/ml)
    @Column(name = "PA_2_2_1_2")
    @JsonProperty("PA-2-2-1-2")
    private String PA_2_2_1_2; // 黄体生成素LH(mIU/mL)
    @Column(name = "PA_2_2_1_3")
    @JsonProperty("PA-2-2-1-3")
    private String PA_2_2_1_3; // 促卵泡成熟激素FSH(mIU/mL)
    @Column(name = "PA_2_2_1_4")
    @JsonProperty("PA-2-2-1-4")
    private String PA_2_2_1_4; // 雌二醇E2(pg/ml)
    @Column(name = "PA_2_2_1_5")
    @JsonProperty("PA-2-2-1-5")
    private String PA_2_2_1_5; // 孕酮P4(ng/ml)
    @Column(name = "PA_2_2_1_6")
    @JsonProperty("PA-2-2-1-6")
    private String PA_2_2_1_6; // 生长激素HGH(ng/ml)
    @Column(name = "PA_2_2_1_7")
    @JsonProperty("PA-2-2-1-7")
    private String PA_2_2_1_7; // 皮质醇COR(ng/ml)
    @Column(name = "PA_2_2_1_8")
    @JsonProperty("PA-2-2-1-8")
    private String PA_2_2_1_8; // 睾酮T(ng/ml)
    @Column(name = "PA_2_3_1")
    @JsonProperty("PA-2-3-1")
    private String PA_2_3_1; // 是否进行术前内分泌检查（甲状腺激素）评估
    @Column(name = "PA_2_3_1_1")
    @JsonProperty("PA-2-3-1-1")
    private String PA_2_3_1_1; // 促甲状腺激素（或超敏促甲状腺激素）TSH(uIU/ml)
    @Column(name = "PA_2_3_1_2")
    @JsonProperty("PA-2-3-1-2")
    private String PA_2_3_1_2; // 三碘甲状腺原氨酸T3(nmol/L)
    @Column(name = "PA_2_3_1_3")
    @JsonProperty("PA-2-3-1-3")
    private String PA_2_3_1_3; // 游离T3   FT3(pmol/L)
    @Column(name = "PA_2_3_1_4")
    @JsonProperty("PA-2-3-1-4")
    private String PA_2_3_1_4; // 甲状腺素T4(nmol/L)
    @Column(name = "PA_2_3_1_5")
    @JsonProperty("PA-2-3-1-5")
    private String PA_2_3_1_5; // 游离T4  FT4(pmol/L)
    @Column(name = "PA_2_4_1")
    @JsonProperty("PA-2-4-1")
    private String PA_2_4_1; // 是否进行术前内分泌检查（IGF-1）评估
    @Column(name = "PA_2_4_2")
    @JsonProperty("PA-2-4-2")
    private String PA_2_4_2; // 胰岛素生长因子IGF-1(ng/ml)
    @Column(name = "PA_2_4_3")
    @JsonProperty("PA-2-4-3")
    private String PA_2_4_3; // 术前评估肾上腺功能不全或显著的垂体功能低减的患者是否需给予激素替代治疗
    @Column(name = "PA_2_4_4")
    @JsonProperty("PA-2-4-4")
    private String PA_2_4_4; // 生长激素腺瘤是否评估心肺等功能
    @Column(name = "PA_2_5_1")
    @JsonProperty("PA-2-5-1")
    private String PA_2_5_1; // 是否进行术前多学科（MDT）诊疗讨论
    @Column(name = "PA_2_5_2")
    @JsonProperty("PA-2-5-2")
    private String PA_2_5_2; // 讨论日期时间
    @Column(name = "PA_2_5_3")
    @JsonProperty("PA-2-5-3")
    private String PA_2_5_3; // 术前多学科（MDT）诊疗讨论主要内容
    @Column(name = "PA_2_5_3_1")
    @JsonProperty("PA-2-5-3-1")
    private String PA_2_5_3_1; // 其他术前多学科（MDT）诊疗讨论主要内容
    @Column(name = "PA_2_5_4")
    @JsonProperty("PA-2-5-4")
    private String PA_2_5_4; // 参加术前多学科（MDT）诊疗讨论的科室
    @Column(name = "PA_2_5_4_1")
    @JsonProperty("PA-2-5-4-1")
    private String PA_2_5_4_1; // 其他参加术前多学科（MDT）诊疗讨论的科室
    @Column(name = "PA_3_1_1")
    @JsonProperty("PA-3-1-1")
    private String PA_3_1_1; // 手术治疗适应证的选择因素
    @Column(name = "PA_3_2_1")
    @JsonProperty("PA-3-2-1")
    private String PA_3_2_1; // 是否有手术治疗禁忌证
    @Column(name = "PA_3_2_2")
    @JsonProperty("PA-3-2-2")
    private String PA_3_2_2; // 经鼻蝶人路手术治疗禁忌征的选择
    @Column(name = "PA_3_2_3")
    @JsonProperty("PA-3-2-3")
    private String PA_3_2_3; // 开颅垂体 腺瘤切除手术治疗禁忌征的选择
    @Column(name = "PA_4_1_1")
    @JsonProperty("PA-4-1-1")
    private String PA_4_1_1; // 是否有可能并发术中出血评估及安全处置预案
    @Column(name = "PA_4_1_2")
    @JsonProperty("PA-4-1-2")
    private String PA_4_1_2; // 是否有可能并发术中脑脊液漏评估及安全处置预案
    @Column(name = "PA_4_1_3")
    @JsonProperty("PA-4-1-3")
    private String PA_4_1_3; // 是否有可能并发额叶挫伤评估及安全处置预案
    @Column(name = "PA_4_1_4")
    @JsonProperty("PA-4-1-4")
    private String PA_4_1_4; // 是否有可能并发视神经损伤评估及安全处置预案
    @Column(name = "PA_4_1_5")
    @JsonProperty("PA-4-1-5")
    private String PA_4_1_5; // 是否有可能并发颈内动脉损伤评估及安全处置预案
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
    private String CM_2_3_15; // 急性肾功能衰竭（手术后）
    @Column(name = "CM_2_5")
    @JsonProperty("CM-2-5")
    private String CM_2_5; // PA术后特指并发症
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    @Column(name = "PA_6_4_1")
    @JsonProperty("PA-6-4-1")
    private String PA_6_4_1; // 是否有手术后再手术
    @Column(name = "PA_6_4_2")
    @JsonProperty("PA-6-4-2")
    private String PA_6_4_2; // 手术后再手术名称
    @Column(name = "PA_6_4_3")
    @JsonProperty("PA-6-4-3")
    private String PA_6_4_3; // 再手术日期时间
    @Column(name = "PA_7_1_1")
    @JsonProperty("PA-7-1-1")
    private String PA_7_1_1; // 是否有病理报告记录单
    @Column(name = "PA_7_1_2")
    @JsonProperty("PA-7-1-2")
    private String PA_7_1_2; // 病理报告记录单中基本内容
    @Column(name = "PA_7_1_3")
    @JsonProperty("PA-7-1-3")
    private String PA_7_1_3; // 垂体腺瘤免疫组化情况
    @Column(name = "PA_7_2_1")
    @JsonProperty("PA-7-2-1")
    private String PA_7_2_1; // 垂体瘤Ki-67阳性细胞比例是否确定
    @Column(name = "PA_7_2_2")
    @JsonProperty("PA-7-2-2")
    private String PA_7_2_2; // 垂体瘤Ki-67阳性细胞比例(%)
    @Column(name = "PA_8_1_1")
    @JsonProperty("PA-8-1-1")
    private String PA_8_1_1; // 手术中出血量(ml)
    @Column(name = "PA_8_1_2")
    @JsonProperty("PA-8-1-2")
    private String PA_8_1_2; // 手术中输血量(ml)
    @Column(name = "PA_8_1_3")
    @JsonProperty("PA-8-1-3")
    private String PA_8_1_3; // 手术后出血量(ml)
    @Column(name = "PA_8_1_4")
    @JsonProperty("PA-8-1-4")
    private String PA_8_1_4; // 手术后输血量(ml)
    @Column(name = "PA_8_2_1")
    @JsonProperty("PA-8-2-1")
    private String PA_8_2_1; // 全血(ml)
    @Column(name = "PA_8_2_2")
    @JsonProperty("PA-8-2-2")
    private String PA_8_2_2; // 成份血(ml)
    @Column(name = "PA_8_2_3")
    @JsonProperty("PA-8-2-3")
    private String PA_8_2_3; // 血浆(ml)
    @Column(name = "PA_9_1_1")
    @JsonProperty("PA-9-1-1")
    private String PA_9_1_1; // 是否进行术后视力视野的复查及评估
    @Column(name = "PA_9_1_2")
    @JsonProperty("PA-9-1-2")
    private String PA_9_1_2; // 复查及评估结果是否确定
    @Column(name = "PA_9_1_2_1")
    @JsonProperty("PA-9-1-2-1")
    private String PA_9_1_2_1; // 术后左眼视力数值
    @Column(name = "PA_9_1_2_2")
    @JsonProperty("PA-9-1-2-2")
    private String PA_9_1_2_2; // 术后右眼视力数值
    @Column(name = "PA_9_2_1")
    @JsonProperty("PA-9-2-1")
    private String PA_9_2_1; // 术后2-3天,是否复查内分泌激素
    @Column(name = "PA_9_2_1_1")
    @JsonProperty("PA-9-2-1-1")
    private String PA_9_2_1_1; // 血清催乳素PRL(ng/ml)
    @Column(name = "PA_9_2_1_2")
    @JsonProperty("PA-9-2-1-2")
    private String PA_9_2_1_2; // 黄体生成素LH(mIU/mL)
    @Column(name = "PA_9_2_1_3")
    @JsonProperty("PA-9-2-1-3")
    private String PA_9_2_1_3; // 促卵泡成熟激素FSH(mIU/mL)
    @Column(name = "PA_9_2_1_4")
    @JsonProperty("PA-9-2-1-4")
    private String PA_9_2_1_4; // 雌二醇E2(pg/ml)
    @Column(name = "PA_9_2_1_5")
    @JsonProperty("PA-9-2-1-5")
    private String PA_9_2_1_5; // 孕酮P4(ng/ml)
    @Column(name = "PA_9_2_1_6")
    @JsonProperty("PA-9-2-1-6")
    private String PA_9_2_1_6; // 生长激素HGH(ng/ml)
    @Column(name = "PA_9_2_1_7")
    @JsonProperty("PA-9-2-1-7")
    private String PA_9_2_1_7; // 皮质醇COR(ng/ml)
    @Column(name = "PA_9_2_1_8")
    @JsonProperty("PA-9-2-1-8")
    private String PA_9_2_1_8; // 睾酮T(ng/ml)
    @Column(name = "PA_9_2_1_9")
    @JsonProperty("PA-9-2-1-9")
    private String PA_9_2_1_9; // 促甲状腺激素（或超敏促甲状腺激素）TSH(uIU/ml)
    @Column(name = "PA_9_2_1_10")
    @JsonProperty("PA-9-2-1-10")
    private String PA_9_2_1_10; // 三碘甲状腺原氨酸T3(nmol/L)
    @Column(name = "PA_9_2_1_11")
    @JsonProperty("PA-9-2-1-11")
    private String PA_9_2_1_11; // 游离三碘甲状腺原氨酸     FT3(pmol/L)
    @Column(name = "PA_9_2_1_12")
    @JsonProperty("PA-9-2-1-12")
    private String PA_9_2_1_12; // 甲状腺素T4(nmol/L)
    @Column(name = "PA_9_2_1_13")
    @JsonProperty("PA-9-2-1-13")
    private String PA_9_2_1_13; // 游离甲状腺素 FT4(pmol/L)
    @Column(name = "PA_9_3_1")
    @JsonProperty("PA-9-3-1")
    private String PA_9_3_1; // 是否进行电解质水平监测
    @Column(name = "PA_9_3_3")
    @JsonProperty("PA-9-3-3")
    private String PA_9_3_3; // 电解质水平监测的时段
    @Column(name = "PA_9_3_2")
    @JsonProperty("PA-9-3-2")
    private String PA_9_3_2; // 电解质水平监测的时段
    @Column(name = "PA_9_3_2_1")
    @JsonProperty("PA-9-3-2-1")
    private String PA_9_3_2_1; // 钾离子(mmol/L)
    @Column(name = "PA_9_3_2_2")
    @JsonProperty("PA-9-3-2-2")
    private String PA_9_3_2_2; // 钠离子(mmol/L)
    @Column(name = "PA_9_3_2_3")
    @JsonProperty("PA-9-3-2-3")
    private String PA_9_3_2_3; // 氯离子(mmol/L)
    @Column(name = "PA_10_1_1")
    @JsonProperty("PA-10-1-1")
    private String PA_10_1_1; // 是否进行术后辅助放疗
    @Column(name = "PA_10_1_2")
    @JsonProperty("PA-10-1-2")
    private String PA_10_1_2; // 术后辅助放疗指征的选择
    @Column(name = "PA_10_1_3")
    @JsonProperty("PA-10-1-3")
    private String PA_10_1_3; // 术后辅助放疗模式的选择
    @Column(name = "PA_10_2_1")
    @JsonProperty("PA-10-2-1")
    private String PA_10_2_1; // 是否进行术后辅助药物治疗
    @Column(name = "PA_10_2_2")
    @JsonProperty("PA-10-2-2")
    private String PA_10_2_2; // 药物治疗符合指征
    @Column(name = "PA_11_1_0")
    @JsonProperty("PA-11-1-0")
    private String PA_11_1_0; // 是否入院时进行重点护理评估且有记录
    @Column(name = "PA_11_1_1")
    @JsonProperty("PA-11-1-1")
    private String PA_11_1_1; // 行走评估结果
    @Column(name = "PA_11_1_2")
    @JsonProperty("PA-11-1-2")
    private String PA_11_1_2; // 呼吸评估结果
    @Column(name = "PA_11_1_3")
    @JsonProperty("PA-11-1-3")
    private String PA_11_1_3; // 评估视力视野障碍对患者的影响
    @Column(name = "PA_11_1_4")
    @JsonProperty("PA-11-1-4")
    private String PA_11_1_4; // 入院后第一个24小时液体出入量
    @Column(name = "PA_11_1_5")
    @JsonProperty("PA-11-1-5")
    private String PA_11_1_5; // 其中，每小时液体出入量
    @Column(name = "PA_11_1_6")
    @JsonProperty("PA-11-1-6")
    private String PA_11_1_6; // 实施卒中健康教育记录内容
    @Column(name = "PA_11_1_7")
    @JsonProperty("PA-11-1-7")
    private String PA_11_1_7; // 经蝶手术患者强化鼻腔护理,减少术后脑脊液鼻漏并发症的护理措施
    @Column(name = "PA_11_1_9")
    @JsonProperty("PA-11-1-9")
    private String PA_11_1_9; // 尿量异常患者的长期护理
    @Column(name = "PA_11_1_10")
    @JsonProperty("PA-11-1-10")
    private String PA_11_1_10; // 饮食指导
    @Column(name = "PA_11_1_11_3")
    @JsonProperty("PA-11-1-11-3")
    private String PA_11_1_11_3; // 压疮评估分值是否确定
    @Column(name = "PA_11_1_11")
    @JsonProperty("PA-11-1-11")
    private String PA_11_1_11; // 压疮评估（Braden评分值）分值
    @Column(name = "PA_11_1_11_1")
    @JsonProperty("PA-11-1-11-1")
    private String PA_11_1_11_1; // 压疮评估结果选择
    @Column(name = "PA_11_1_11_2")
    @JsonProperty("PA-11-1-11-2")
    private String PA_11_1_11_2; // 是否进行预防压疮告知
    @Column(name = "PA_11_2_1")
    @JsonProperty("PA-11-2-1")
    private String PA_11_2_1; // 是否实施手术前健康教育且有记录
    @Column(name = "PA_11_1_3_1")
    @JsonProperty("PA-11-1-3-1")
    private String PA_11_1_3_1; // 实施卒中健康教育记录内容
    @Column(name = "PA_11_1_2_1")
    @JsonProperty("PA-11-1-2-1")
    private String PA_11_1_2_1; // 其他实施卒中健康教育记录内容
    @Column(name = "PA_11_1_3_4")
    @JsonProperty("PA-11-1-3-4")
    private String PA_11_1_3_4; // 是否实施术后健康教育且有记录
    @Column(name = "PA_11_1_3_2")
    @JsonProperty("PA-11-1-3-2")
    private String PA_11_1_3_2; // 吸烟史
    @Column(name = "PA_11_1_3_3")
    @JsonProperty("PA-11-1-3-3")
    private String PA_11_1_3_3; // 吸烟程度评估
    @Column(name = "PA_11_1_3_5")
    @JsonProperty("PA-11-1-3-5")
    private String PA_11_1_3_5; // 接受戒烟的建议或者戒烟治疗
    @Column(name = "PA_11_2_2_1")
    @JsonProperty("PA-11-2-2-1")
    private String PA_11_2_2_1; // 交与患者“出院小结”的副本，并告知患者出院时风险因素
    @Column(name = "PA_11_2_2_2")
    @JsonProperty("PA-11-2-2-2")
    private String PA_11_2_2_2; // 出院带药
    @Column(name = "PA_11_2_2_3")
    @JsonProperty("PA-11-2-2-3")
    private String PA_11_2_2_3; // 告知发生紧急情况时求援救治途径
    @Column(name = "PA_11_2_2_4")
    @JsonProperty("PA-11-2-2-4")
    private String PA_11_2_2_4; // 出院时教育与随访
    @Column(name = "PA_11_2_2_5")
    @JsonProperty("PA-11-2-2-5")
    private String PA_11_2_2_5; // 告知何为风险因素与紧急情况
    @Column(name = "PA_12_1_1")
    @JsonProperty("PA-12-1-1")
    private String PA_12_1_1; // 符合治愈标准的选项
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