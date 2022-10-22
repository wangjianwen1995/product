package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码 ： C34 开头，且伴主要手术ICD-9-CM-3 编码：32.2 至 32.6，32.9 的手术出院患者。
*/
@ApiModel(value = "29信息")
@Entity
@Data
@Table(name = "sd_info_LC")
public class SdInfoLC implements Serializable {
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
    @Column(name = "LC_0_1_4_1")
    @JsonProperty("LC-0-1-4-1")
    private String LC_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "LC_0_1_4_2")
    @JsonProperty("LC-0-1-4-2")
    private String LC_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
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
    @Column(name = "LC_1_1_1")
    @JsonProperty("LC-1-1-1")
    private String LC_1_1_1; // 是否治疗前完成临床TNM分期
    @Column(name = "LC_1_1_2")
    @JsonProperty("LC-1-1-2")
    private String LC_1_1_2; // 原发肿瘤（T）分期
    @Column(name = "LC_1_1_3")
    @JsonProperty("LC-1-1-3")
    private String LC_1_1_3; // 区域淋巴结（N）分期 
    @Column(name = "LC_1_1_2_r")
    @JsonProperty("LC-1-1-2-r")
    private String LC_1_1_2_r; // 
    @Column(name = "LC_1_1_4")
    @JsonProperty("LC-1-1-4")
    private String LC_1_1_4; // 远处转移（M）分期
    @Column(name = "LC_1_1_4_r")
    @JsonProperty("LC-1-1-4-r")
    private String LC_1_1_4_r; // 
    @Column(name = "LC_1_1_5")
    @JsonProperty("LC-1-1-5")
    private String LC_1_1_5; // 肺癌治疗前 TNM 临床分期结论
    @Column(name = "LC_1_2_1")
    @JsonProperty("LC-1-2-1")
    private String LC_1_2_1; // 治疗前是否接受过2个或以上治疗科室会诊的患者
    @Column(name = "LC_2_1_1")
    @JsonProperty("LC-2-1-1")
    private String LC_2_1_1; // 是否治疗前病理组织形态学/细胞学诊断
    @Column(name = "LC_2_1_2")
    @JsonProperty("LC-2-1-2")
    private String LC_2_1_2; // 采集组织或细胞学标本途经
    @Column(name = "LC_2_1_2_1")
    @JsonProperty("LC-2-1-2-1")
    private String LC_2_1_2_1; // 其他采集组织/细胞学标本途经
    @Column(name = "LC_2_1_3")
    @JsonProperty("LC-2-1-3")
    private String LC_2_1_3; // 是否非小细胞肺癌患者组织细胞学或病理学无法再细分
    @Column(name = "LC_3_1_1")
    @JsonProperty("LC-3-1-1")
    private String LC_3_1_1; // 治疗前肺癌患者是否进行胸部CT检查
    @Column(name = "LC_3_1_2")
    @JsonProperty("LC-3-1-2")
    private String LC_3_1_2; // 肺癌的传统影像学分型(根据肺癌的发生部位)
    @Column(name = "LC_3_1_2_1")
    @JsonProperty("LC-3-1-2-1")
    private String LC_3_1_2_1; // 其他特定部位
    @Column(name = "LC_3_1_3")
    @JsonProperty("LC-3-1-3")
    private String LC_3_1_3; // 是否在CT引导下经皮肺穿刺活检
    @Column(name = "LC_3_1_4")
    @JsonProperty("LC-3-1-4")
    private String LC_3_1_4; // 获取细胞学或组织是否送病理检查
    @Column(name = "LC_4_1_1")
    @JsonProperty("LC-4-1-1")
    private String LC_4_1_1; // TNM 临床分期结论
    @Column(name = "LC_4_1_1_1")
    @JsonProperty("LC-4-1-1-1")
    private String LC_4_1_1_1; // 其他TNM 临床分期结论
    @Column(name = "LC_4_2_1")
    @JsonProperty("LC-4-2-1")
    private String LC_4_2_1; // 是否行肺癌手术
    @Column(name = "LC_4_2_2")
    @JsonProperty("LC-4-2-2")
    private String LC_4_2_2; // 行肺切除术情况
    @Column(name = "LC_4_2_2_1")
    @JsonProperty("LC-4-2-2-1")
    private String LC_4_2_2_1; // 其他行肺切除术情况
    @Column(name = "LC_4_3_1")
    @JsonProperty("LC-4-3-1")
    private String LC_4_3_1; // 纵隔淋巴结清除范围选择部位
    @Column(name = "LC_4_3_2_1")
    @JsonProperty("LC-4-3-2-1")
    private String LC_4_3_2_1; // 左胸清除纵隔淋巴结范围
    @Column(name = "LC_4_3_3_1")
    @JsonProperty("LC-4-3-3-1")
    private String LC_4_3_3_1; // 右胸清除纵隔淋巴结范围
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
    private String CM_1_6_3_2; // 术后48小时之后继续使用的原因
    @Column(name = "CM_2_1")
    @JsonProperty("CM-2-1")
    private String CM_2_1; // 是否有手术后并发症
    @Column(name = "CM_2_2")
    @JsonProperty("CM-2-2")
    private String CM_2_2; // 手术后并发症类别及ICD-10四位亚目的选择
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
    @Column(name = "LC_6_1_2")
    @JsonProperty("LC-6-1-2")
    private String LC_6_1_2; // 肺癌手术特指的手术后并发症
    @Column(name = "CM_2_3_1_1")
    @JsonProperty("CM-2-3-1-1")
    private String CM_2_3_1_1; // 其他手术后并发症类别及ICD-10四位亚目和名称填写
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    @Column(name = "LC_6_2_1")
    @JsonProperty("LC-6-2-1")
    private String LC_6_2_1; // 是否为0-31天内非计划二次手术
    @Column(name = "LC_6_2_2_1")
    @JsonProperty("LC-6-2-2-1")
    private String LC_6_2_2_1; // 非计划二次手术的原因
    @Column(name = "LC_6_2_3")
    @JsonProperty("LC-6-2-3")
    private String LC_6_2_3; // 手术起始(切皮)日期时间
    @Column(name = "LC_6_2_4")
    @JsonProperty("LC-6-2-4")
    private String LC_6_2_4; // 手术结束(切口闭合)日期时间
    @Column(name = "LC_7_1_1")
    @JsonProperty("LC-7-1-1")
    private String LC_7_1_1; // 术后标本是否送病理检查
    @Column(name = "LC_7_1_2")
    @JsonProperty("LC-7-1-2")
    private String LC_7_1_2; // 是否有术后病理报告的记录
    @Column(name = "LC_7_1_3")
    @JsonProperty("LC-7-1-3")
    private String LC_7_1_3; // 病理报告结论中是否有pTNM分期
    @Column(name = "LC_7_1_4")
    @JsonProperty("LC-7-1-4")
    private String LC_7_1_4; // 肺癌手术后病理pTNM分期结论
    @Column(name = "LC_7_2_1")
    @JsonProperty("LC-7-2-1")
    private String LC_7_2_1; // 术后区域淋巴结是否送病理检查
    @Column(name = "LC_7_2_2")
    @JsonProperty("LC-7-2-2")
    private String LC_7_2_2; // 淋巴结总数(个)
    @Column(name = "LC_7_2_3")
    @JsonProperty("LC-7-2-3")
    private String LC_7_2_3; // 受累的淋巴结数目(个)
    @Column(name = "LC_8_1_1")
    @JsonProperty("LC-8-1-1")
    private String LC_8_1_1; // 肺癌非手术治疗前是否接受基因检测
    @Column(name = "LC_8_1_2")
    @JsonProperty("LC-8-1-2")
    private String LC_8_1_2; // 接受基因检测人群的选择
    @Column(name = "LC_8_1_2_1")
    @JsonProperty("LC-8-1-2-1")
    private String LC_8_1_2_1; // 其他接受基因检测人群
    @Column(name = "LC_8_1_3")
    @JsonProperty("LC-8-1-3")
    private String LC_8_1_3; // 接受基因检测的标本选择
    @Column(name = "LC_8_1_4")
    @JsonProperty("LC-8-1-4")
    private String LC_8_1_4; // 检测类别的选择
    @Column(name = "LC_8_1_5")
    @JsonProperty("LC-8-1-5")
    private String LC_8_1_5; // 检测项目的选择
    @Column(name = "LC_8_1_5_1")
    @JsonProperty("LC-8-1-5-1")
    private String LC_8_1_5_1; // 其他检测项目
    @Column(name = "LC_8_1_6")
    @JsonProperty("LC-8-1-6")
    private String LC_8_1_6; // 结果阳性的选择
    @Column(name = "LC_8_1_6_1")
    @JsonProperty("LC-8-1-6-1")
    private String LC_8_1_6_1; // 其他结果阳性
    @Column(name = "LC_9_1_1")
    @JsonProperty("LC-9-1-1")
    private String LC_9_1_1; // 肺癌患者手术后行放疗
    @Column(name = "LC_9_1_2")
    @JsonProperty("LC-9-1-2")
    private String LC_9_1_2; // 放疗指征的选择
    @Column(name = "LC_9_1_3")
    @JsonProperty("LC-9-1-3")
    private String LC_9_1_3; // 非小细胞肺癌放疗指征的选择
    @Column(name = "LC_9_1_3_1")
    @JsonProperty("LC-9-1-3-1")
    private String LC_9_1_3_1; // 其他非小细胞肺癌放疗指征
    @Column(name = "LC_9_1_4")
    @JsonProperty("LC-9-1-4")
    private String LC_9_1_4; // 小细胞肺癌放疗指征的选择
    @Column(name = "LC_9_1_4_1")
    @JsonProperty("LC-9-1-4-1")
    private String LC_9_1_4_1; // 其他小细胞肺癌放疗指征
    @Column(name = "LC_9_2_1")
    @JsonProperty("LC-9-2-1")
    private String LC_9_2_1; // 采用放疗技术的选择
    @Column(name = "LC_9_2_1_1")
    @JsonProperty("LC-9-2-1-1")
    private String LC_9_2_1_1; // 采用其他放疗技术
    @Column(name = "LC_9_2_2")
    @JsonProperty("LC-9-2-2")
    private String LC_9_2_2; // 放射治疗记录内容选择
    @Column(name = "LC_9_2_2_1")
    @JsonProperty("LC-9-2-2-1")
    private String LC_9_2_2_1; // 其他放射治疗记录内容
    @Column(name = "LC_10_1_1")
    @JsonProperty("LC-10-1-1")
    private String LC_10_1_1; // 是否使用基因检测阳性结果指导用药的靶向治疗
    @Column(name = "LC_10_1_2")
    @JsonProperty("LC-10-1-2")
    private String LC_10_1_2; // 接受基因检测并阳性的种类
    @Column(name = "LC_10_1_2_1")
    @JsonProperty("LC-10-1-2-1")
    private String LC_10_1_2_1; // 其他接受基因检测并阳性的种类
    @Column(name = "LC_10_1_3")
    @JsonProperty("LC-10-1-3")
    private String LC_10_1_3; // 药物选择
    @Column(name = "LC_10_1_3_1")
    @JsonProperty("LC-10-1-3-1")
    private String LC_10_1_3_1; // 其他药物选择
    @Column(name = "LC_11_1_1")
    @JsonProperty("LC-11-1-1")
    private String LC_11_1_1; // 是否实施抗肿瘤药物治疗
    @Column(name = "LC_11_1_2")
    @JsonProperty("LC-11-1-2")
    private String LC_11_1_2; // 抗肿瘤药物治疗选择的依据
    @Column(name = "LC_11_1_2_1")
    @JsonProperty("LC-11-1-2-1")
    private String LC_11_1_2_1; // 其他抗肿瘤药物治疗
    @Column(name = "LC_11_2_1")
    @JsonProperty("LC-11-2-1")
    private String LC_11_2_1; // 目标病灶的评价
    @Column(name = "LC_11_2_2")
    @JsonProperty("LC-11-2-2")
    private String LC_11_2_2; // 非目标病灶的评价
    @Column(name = "LC_11_2_3")
    @JsonProperty("LC-11-2-3")
    private String LC_11_2_3; // 新病灶
    @Column(name = "LC_11_2_4")
    @JsonProperty("LC-11-2-4")
    private String LC_11_2_4; // 总疗效
    @Column(name = "LC_11_3_1")
    @JsonProperty("LC-11-3-1")
    private String LC_11_3_1; // 免疫治疗(iRECIST)--靶病灶
    @Column(name = "LC_11_3_2")
    @JsonProperty("LC-11-3-2")
    private String LC_11_3_2; // 免疫治疗(iRECIST)--非靶病灶
    @Column(name = "LC_12_1_1")
    @JsonProperty("LC-12-1-1")
    private String LC_12_1_1; // 是否使用了抗肿瘤药物
    @Column(name = "LC_12_1_2")
    @JsonProperty("LC-12-1-2")
    private String LC_12_1_2; // 有无抗肿瘤药物的药物不良反应
    @Column(name = "LC_12_1_3")
    @JsonProperty("LC-12-1-3")
    private String LC_12_1_3; // 抗肿瘤药物的药物不良反应
    @Column(name = "LC_12_1_3_1")
    @JsonProperty("LC-12-1-3-1")
    private String LC_12_1_3_1; // 其他抗癌药的药物不良反应
    @Column(name = "LC_12_2_1")
    @JsonProperty("LC-12-2-1")
    private String LC_12_2_1; // 不良反应定级
    @Column(name = "LC_13_1_1")
    @JsonProperty("LC-13-1-1")
    private String LC_13_1_1; // 肺癌患者履行出院知情告知
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "LC_13_1_2")
    @JsonProperty("LC-13-1-2")
    private String LC_13_1_2; // 术后化疗与放疗
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
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