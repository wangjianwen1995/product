package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码 ： C16 开头，且伴主要手术ICD-9-CM-3 编码：43.4 至 43.9 的手术出院患者。
*/
@ApiModel(value = "32信息")
@Entity
@Data
@Table(name = "sd_info_GC")
public class SdInfoGC implements Serializable {
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
    @Column(name = "GC_1_1_1")
    @JsonProperty("GC-1-1-1")
    private String GC_1_1_1; // 临床TNM分期前主要检查项目
    @Column(name = "GC_1_2_1")
    @JsonProperty("GC-1-2-1")
    private String GC_1_2_1; // 治疗前是否完成临床 TNM分期
    @Column(name = "GC_1_2_2")
    @JsonProperty("GC-1-2-2")
    private String GC_1_2_2; // 原发肿瘤（T）分期
    @Column(name = "GC_1_2_3")
    @JsonProperty("GC-1-2-3")
    private String GC_1_2_3; // 区域淋巴结（N）分期 
    @Column(name = "GC_1_2_3_r")
    @JsonProperty("GC-1-2-3-r")
    private String GC_1_2_3_r; // 
    @Column(name = "GC_1_2_4")
    @JsonProperty("GC-1-2-4")
    private String GC_1_2_4; // 远处转移（M）分期
    @Column(name = "GC_1_2_4_r")
    @JsonProperty("GC-1-2-4-r")
    private String GC_1_2_4_r; // 
    @Column(name = "GC_1_2_5")
    @JsonProperty("GC-1-2-5")
    private String GC_1_2_5; // 胃癌治疗前 cTNM 分期结论
    @Column(name = "GC_1_3_1_1")
    @JsonProperty("GC-1-3-1-1")
    private String GC_1_3_1_1; // 治疗前是否完成胃癌CT分期
    @Column(name = "GC_1_3_1")
    @JsonProperty("GC-1-3-1")
    private String GC_1_3_1; // cT分期病理学定义
    @Column(name = "GC_1_4_1_1")
    @JsonProperty("GC-1-4-1-1")
    private String GC_1_4_1_1; // 治疗前是否完成胃癌超声内镜（EUS）分期
    @Column(name = "GC_1_4_1")
    @JsonProperty("GC-1-4-1")
    private String GC_1_4_1; // uT分期病理学定义
    @Column(name = "GC_1_5_1")
    @JsonProperty("GC-1-5-1")
    private String GC_1_5_1; // 是否是治疗前接受过2个或以上治疗科室会诊的患者
    @Column(name = "GC_2_2_1")
    @JsonProperty("GC-2-2-1")
    private String GC_2_2_1; // 治疗前是否有病理组织形态学/细胞学诊断报告
    @Column(name = "GC_2_2_2")
    @JsonProperty("GC-2-2-2")
    private String GC_2_2_2; // 采集组织或细胞学标本来源途径
    @Column(name = "GC_2_2_2_1")
    @JsonProperty("GC-2-2-2-1")
    private String GC_2_2_2_1; // 其他细胞学标本来源途径
    @Column(name = "GC_2_2_3")
    @JsonProperty("GC-2-2-3")
    private String GC_2_2_3; // 是否有pTNM 临床分期结论
    @Column(name = "GC_2_2_4")
    @JsonProperty("GC-2-2-4")
    private String GC_2_2_4; // pTNM 临床分期结论
    @Column(name = "GC_2_2_4_2")
    @JsonProperty("GC-2-2-4-2")
    private String GC_2_2_4_2; // 病理组织形态学/细胞学诊断报告单pTNM 临床分期结论距本次治疗前的时限
    @Column(name = "GC_3_1_0")
    @JsonProperty("GC-3-1-0")
    private String GC_3_1_0; // 是否治疗手术
    @Column(name = "GC_3_1_1_1")
    @JsonProperty("GC-3-1-1-1")
    private String GC_3_1_1_1; // 手术路径的选择
    @Column(name = "GC_3_1_2_2")
    @JsonProperty("GC-3-1-2-2")
    private String GC_3_1_2_2; // 手术其他路径
    @Column(name = "GC_3_1_1_2")
    @JsonProperty("GC-3-1-1-2")
    private String GC_3_1_1_2; // 术中探及胃癌病变涉及的范围
    @Column(name = "GC_3_1_2_1")
    @JsonProperty("GC-3-1-2-1")
    private String GC_3_1_2_1; // 手术治疗符合原则规范选择
    @Column(name = "GC_3_1_2_3")
    @JsonProperty("GC-3-1-2-3")
    private String GC_3_1_2_3; // 根治性手术治疗符合原则规范
    @Column(name = "GC_3_1_2_4")
    @JsonProperty("GC-3-1-2-4")
    private String GC_3_1_2_4; // 非根治性手术治疗符合原则规范
    @Column(name = "GC_3_2_1")
    @JsonProperty("GC-3-2-1")
    private String GC_3_2_1; // 实施的胃癌根治性术式的选择
    @Column(name = "GC_3_2_2")
    @JsonProperty("GC-3-2-2")
    private String GC_3_2_2; // 术后消化道重建的方式的选择
    @Column(name = "GC_3_2_2_1")
    @JsonProperty("GC-3-2-2-1")
    private String GC_3_2_2_1; // 其他术后消化道重建的方式
    @Column(name = "GC_3_3_3")
    @JsonProperty("GC-3-3-3")
    private String GC_3_3_3; // 安全切缘符合的要求
    @Column(name = "GC_3_3_1")
    @JsonProperty("GC-3-3-1")
    private String GC_3_3_1; // 胃癌手术中达到安全切缘是否有证实措施
    @Column(name = "GC_3_3_2")
    @JsonProperty("GC-3-3-2")
    private String GC_3_3_2; // 记入手术记录中安全切缘证实措施的选择
    @Column(name = "GC_3_4_1")
    @JsonProperty("GC-3-4-1")
    private String GC_3_4_1; // 是否使用各种吻合器
    @Column(name = "GC_4_2_1")
    @JsonProperty("GC-4-2-1")
    private String GC_4_2_1; // 是否进行手术淋巴结清扫
    @Column(name = "GC_4_2_2")
    @JsonProperty("GC-4-2-2")
    private String GC_4_2_2; // 淋巴结清扫组别
    @Column(name = "GC_4_2_3")
    @JsonProperty("GC-4-2-3")
    private String GC_4_2_3; // 淋巴结清扫范围达到层别的结论
    @Column(name = "GC_5_1_1")
    @JsonProperty("GC-5-1-1")
    private String GC_5_1_1; // 是否有病理学诊断
    @Column(name = "GC_5_1_2")
    @JsonProperty("GC-5-1-2")
    private String GC_5_1_2; // 采集组织或细胞学标本途经的选择
    @Column(name = "GC_5_4_1")
    @JsonProperty("GC-5-4-1")
    private String GC_5_4_1; // 肿瘤
    @Column(name = "GC_5_4_1_1")
    @JsonProperty("GC-5-4-1-1")
    private String GC_5_4_1_1; // 其他肿瘤
    @Column(name = "GC_5_4_2")
    @JsonProperty("GC-5-4-2")
    private String GC_5_4_2; // 切缘
    @Column(name = "GC_5_4_2_1")
    @JsonProperty("GC-5-4-2-1")
    private String GC_5_4_2_1; // 其他切缘
    @Column(name = "GC_5_4_3")
    @JsonProperty("GC-5-4-3")
    private String GC_5_4_3; // 区域淋巴结
    @Column(name = "GC_5_4_3_1")
    @JsonProperty("GC-5-4-3-1")
    private String GC_5_4_3_1; // 其他区域淋巴结
    @Column(name = "GC_5_4_4")
    @JsonProperty("GC-5-4-4")
    private String GC_5_4_4; // 特殊的辅助检查结果
    @Column(name = "GC_5_4_4_1")
    @JsonProperty("GC-5-4-4-1")
    private String GC_5_4_4_1; // 其他特殊的辅助检查结果
    @Column(name = "GC_5_4_5")
    @JsonProperty("GC-5-4-5")
    private String GC_5_4_5; // 是否有远处转移
    @Column(name = "GC_5_4_6")
    @JsonProperty("GC-5-4-6")
    private String GC_5_4_6; // 其他病理所见
    @Column(name = "GC_5_4_6_1")
    @JsonProperty("GC-5-4-6-1")
    private String GC_5_4_6_1; // 其他病理
    @Column(name = "GC_5_4_7")
    @JsonProperty("GC-5-4-7")
    private String GC_5_4_7; // 是否有其他组织/器官
    @Column(name = "GC_5_4_8")
    @JsonProperty("GC-5-4-8")
    private String GC_5_4_8; // 是否上级医院会诊
    @Column(name = "GC_5_4_9")
    @JsonProperty("GC-5-4-9")
    private String GC_5_4_9; // 是否有新辅助治疗反应
    @Column(name = "GC_5_2_1")
    @JsonProperty("GC-5-2-1")
    private String GC_5_2_1; // 是否有胃癌病理pTNM分期
    @Column(name = "GC_5_2_3")
    @JsonProperty("GC-5-2-3")
    private String GC_5_2_3; // pTNM 分期结论
    @Column(name = "GC_5_3_1")
    @JsonProperty("GC-5-3-1")
    private String GC_5_3_1; // 是否有组织学分级（G）
    @Column(name = "GC_5_3_2")
    @JsonProperty("GC-5-3-2")
    private String GC_5_3_2; // 组织学分级（G）
    @Column(name = "GC_6_4_1")
    @JsonProperty("GC-6-4-1")
    private String GC_6_4_1; // 是否为 0-IA期胃癌
    @Column(name = "GC_6_4_2")
    @JsonProperty("GC-6-4-2")
    private String GC_6_4_2; // 是否选择内镜下治疗胃癌
    @Column(name = "GC_6_1_1")
    @JsonProperty("GC-6-1-1")
    private String GC_6_1_1; // 是否有术前评估
    @Column(name = "GC_6_1_2")
    @JsonProperty("GC-6-1-2")
    private String GC_6_1_2; // 术前评估内容
    @Column(name = "GC_6_1_3")
    @JsonProperty("GC-6-1-3")
    private String GC_6_1_3; // 治疗的适应证
    @Column(name = "GC_6_2_1")
    @JsonProperty("GC-6-2-1")
    private String GC_6_2_1; // 是否有内镜治疗禁忌证
    @Column(name = "GC_6_2_2")
    @JsonProperty("GC-6-2-2")
    private String GC_6_2_2; // 治疗禁忌证
    @Column(name = "GC_6_2_2_1")
    @JsonProperty("GC-6-2-2-1")
    private String GC_6_2_2_1; // 其他治疗禁忌证
    @Column(name = "GC_6_3_1")
    @JsonProperty("GC-6-3-1")
    private String GC_6_3_1; // 术式选择
    @Column(name = "GC_6_3_1_1")
    @JsonProperty("GC-6-3-1-1")
    private String GC_6_3_1_1; // 其他术式选择
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
    @Column(name = "CM_2_2_1")
    @JsonProperty("CM-2-2-1")
    private String CM_2_2_1; // 胃癌手术特指的并发症
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    @Column(name = "GC_8_2_1")
    @JsonProperty("GC-8-2-1")
    private String GC_8_2_1; // 是否是非计划二次手术
    @Column(name = "GC_8_2_2")
    @JsonProperty("GC-8-2-2")
    private String GC_8_2_2; // 非计划二次手术主要原因的选择
    @Column(name = "GC_8_2_2_1")
    @JsonProperty("GC-8-2-2-1")
    private String GC_8_2_2_1; // 其他非计划二次手术主要原因
    @Column(name = "GC_8_2_3")
    @JsonProperty("GC-8-2-3")
    private String GC_8_2_3; // 二次手术开始（切皮）日期时间 
    @Column(name = "GC_8_2_4")
    @JsonProperty("GC-8-2-4")
    private String GC_8_2_4; // 二次手术结束（缝皮结束）日期时间
    @Column(name = "GC_8_3_1")
    @JsonProperty("GC-8-3-1")
    private String GC_8_3_1; // 内镜治疗术后并发症
    @Column(name = "GC_8_3_2")
    @JsonProperty("GC-8-3-2")
    private String GC_8_3_2; // 并发症
    @Column(name = "GC_8_3_2_1")
    @JsonProperty("GC-8-3-2-1")
    private String GC_8_3_2_1; // 其他并发症
    @Column(name = "GC_8_3_3")
    @JsonProperty("GC-8-3-3")
    private String GC_8_3_3; // 术后并发症处理
    @Column(name = "GC_8_3_3_1")
    @JsonProperty("GC-8-3-3-1")
    private String GC_8_3_3_1; // 其他术后并发症处理
    @Column(name = "GC_9_1_1")
    @JsonProperty("GC-9-1-1")
    private String GC_9_1_1; // 术前是否进行营养评估
    @Column(name = "GC_9_1_2")
    @JsonProperty("GC-9-1-2")
    private String GC_9_1_2; // NRS-2002评估分值
    @Column(name = "GC_9_1_3")
    @JsonProperty("GC-9-1-3")
    private String GC_9_1_3; // PG-SGA评估分级
    @Column(name = "GC_9_1_4")
    @JsonProperty("GC-9-1-4")
    private String GC_9_1_4; // NUTRIC Score评估分值
    @Column(name = "GC_9_2_1")
    @JsonProperty("GC-9-2-1")
    private String GC_9_2_1; // 术前是否给予营养支持
    @Column(name = "GC_9_2_2")
    @JsonProperty("GC-9-2-2")
    private String GC_9_2_2; // 术前给予营养支持符合原则规范
    @Column(name = "GC_9_2_3")
    @JsonProperty("GC-9-2-3")
    private String GC_9_2_3; // 其他术前给予营养支持符合原则规范
    @Column(name = "GC_9_3_1")
    @JsonProperty("GC-9-3-1")
    private String GC_9_3_1; // 是否给予补充性肠外营养（SPN）
    @Column(name = "GC_9_3_2")
    @JsonProperty("GC-9-3-2")
    private String GC_9_3_2; // 补充性肠外营养（SPN）给予条件
    @Column(name = "GC_9_3_3")
    @JsonProperty("GC-9-3-3")
    private String GC_9_3_3; // 其他补充性肠外营养（SPN）给予条件
    @Column(name = "GC_10_1_1")
    @JsonProperty("GC-10-1-1")
    private String GC_10_1_1; // 是否进行术后辅助放疗
    @Column(name = "GC_10_1_2")
    @JsonProperty("GC-10-1-2")
    private String GC_10_1_2; // 术后辅助放疗指征的选择
    @Column(name = "GC_10_2_1")
    @JsonProperty("GC-10-2-1")
    private String GC_10_2_1; // 精确放疗技术的选择
    @Column(name = "GC_11_1_7")
    @JsonProperty("GC-11-1-7")
    private String GC_11_1_7; // 是否有关于放疗总剂量的记录
    @Column(name = "GC_11_1_2")
    @JsonProperty("GC-11-1-2")
    private String GC_11_1_2; // 是否有关于剂量分割方式的记录
    @Column(name = "GC_11_1_3")
    @JsonProperty("GC-11-1-3")
    private String GC_11_1_3; // 是否明确记录肿瘤区（GTV）
    @Column(name = "GC_11_1_4")
    @JsonProperty("GC-11-1-4")
    private String GC_11_1_4; // 是否有临床靶区（CTV）的记录
    @Column(name = "GC_11_1_5")
    @JsonProperty("GC-11-1-5")
    private String GC_11_1_5; // 是否有计划靶区（PTV）的记录
    @Column(name = "GC_11_1_6")
    @JsonProperty("GC-11-1-6")
    private String GC_11_1_6; // 常规二维放疗的放疗靶区范围是否明确记录了放疗野范围
    @Column(name = "GC_12_1_1")
    @JsonProperty("GC-12-1-1")
    private String GC_12_1_1; // 是否为临床或病理分期为M1的胃癌病例
    @Column(name = "GC_12_1_2")
    @JsonProperty("GC-12-1-2")
    private String GC_12_1_2; // 是否为胃癌初次化疗
    @Column(name = "GC_12_1_3")
    @JsonProperty("GC-12-1-3")
    private String GC_12_1_3; // 胃癌初次化疗采用方案
    @Column(name = "GC_12_1_3_2")
    @JsonProperty("GC-12-1-3-2")
    private String GC_12_1_3_2; // 顺铂＋氟尿嘧啶类
    @Column(name = "GC_12_1_3_3")
    @JsonProperty("GC-12-1-3-3")
    private String GC_12_1_3_3; // 奥沙利铂＋氟尿嘧啶类
    @Column(name = "GC_12_1_3_4")
    @JsonProperty("GC-12-1-3-4")
    private String GC_12_1_3_4; // 三药联合方案
    @Column(name = "GC_12_1_3_5")
    @JsonProperty("GC-12-1-3-5")
    private String GC_12_1_3_5; // 单药方案
    @Column(name = "GC_12_1_3_1")
    @JsonProperty("GC-12-1-3-1")
    private String GC_12_1_3_1; // 其他胃癌初次化疗采用方案
    @Column(name = "GC_12_2_1")
    @JsonProperty("GC-12-2-1")
    private String GC_12_2_1; // 手术后是否使用靶向治疗药物
    @Column(name = "GC_12_2_2")
    @JsonProperty("GC-12-2-2")
    private String GC_12_2_2; // 胃癌常用靶向治疗药物
    @Column(name = "GC_12_2_2_1")
    @JsonProperty("GC-12-2-2-1")
    private String GC_12_2_2_1; // 其他靶向治疗药物
    @Column(name = "GC_13_1_1")
    @JsonProperty("GC-13-1-1")
    private String GC_13_1_1; // 抗肿瘤药物疗效的选择
    @Column(name = "GC_13_1_1_1")
    @JsonProperty("GC-13-1-1-1")
    private String GC_13_1_1_1; // 其它抗肿瘤药物疗效
    @Column(name = "GC_13_2_1")
    @JsonProperty("GC-13-2-1")
    private String GC_13_2_1; // 目标病灶的评价
    @Column(name = "GC_13_2_2")
    @JsonProperty("GC-13-2-2")
    private String GC_13_2_2; // 非目标病灶的评价
    @Column(name = "GC_13_2_3")
    @JsonProperty("GC-13-2-3")
    private String GC_13_2_3; // 新病灶
    @Column(name = "GC_13_2_4")
    @JsonProperty("GC-13-2-4")
    private String GC_13_2_4; // 总疗效
    @Column(name = "GC_13_3_1")
    @JsonProperty("GC-13-3-1")
    private String GC_13_3_1; // 免疫治疗(iRECIST)--靶病灶
    @Column(name = "GC_13_3_2")
    @JsonProperty("GC-13-3-2")
    private String GC_13_3_2; // 免疫治疗(iRECIST)--非靶病灶
    @Column(name = "GC_14_1_1")
    @JsonProperty("GC-14-1-1")
    private String GC_14_1_1; // 是否使用了抗癌药的药物
    @Column(name = "GC_14_1_2")
    @JsonProperty("GC-14-1-2")
    private String GC_14_1_2; // 有无抗癌药的药物不良反应
    @Column(name = "GC_14_1_3")
    @JsonProperty("GC-14-1-3")
    private String GC_14_1_3; // 抗癌药的药物不良反应
    @Column(name = "GC_14_1_3_1")
    @JsonProperty("GC-14-1-3-1")
    private String GC_14_1_3_1; // 其它抗癌药的药物不良反应
    @Column(name = "GC_14_2_1")
    @JsonProperty("GC-14-2-1")
    private String GC_14_2_1; // 不良反应定级
    @Column(name = "GC_15_1_1")
    @JsonProperty("GC-15-1-1")
    private String GC_15_1_1; // 胃癌患者履行出院知情告知
    @Column(name = "GC_15_1_2_1")
    @JsonProperty("GC-15-1-2-1")
    private String GC_15_1_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "GC_15_1_2_2")
    @JsonProperty("GC-15-1-2-2")
    private String GC_15_1_2_2; // 告知出院时的病情风险情况
    @Column(name = "GC_15_1_2_3")
    @JsonProperty("GC-15-1-2-3")
    private String GC_15_1_2_3; // 出院后合理的进餐制度和正确的进餐方式预防合并症
    @Column(name = "GC_15_1_2_4")
    @JsonProperty("GC-15-1-2-4")
    private String GC_15_1_2_4; // 告知胃癌术后常见并发症的应对措施
    @Column(name = "GC_15_1_2_5")
    @JsonProperty("GC-15-1-2-5")
    private String GC_15_1_2_5; // 出院时教育与随访
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