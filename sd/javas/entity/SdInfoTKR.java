package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要手术 ICD-9-CM-3 编码：00.80 至 00.83，81.54，81.55 的手术出院患者。
*/
@ApiModel(value = "24信息")
@Entity
@Data
@Table(name = "sd_info_TKR")
public class SdInfoTKR implements Serializable {
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
    @Column(name = "Knee_0_1_4_1")
    @JsonProperty("Knee-0-1-4-1")
    private String Knee_0_1_4_1; // 其他主耍诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "Knee_0_1_3_1")
    @JsonProperty("Knee-0-1-3-1")
    private String Knee_0_1_3_1; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
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
    @Column(name = "Knee_1_1")
    @JsonProperty("Knee-1-1")
    private String Knee_1_1; // 人工膝关节置换术适应证的选择
    @Column(name = "Knee_1_1_1")
    @JsonProperty("Knee-1-1-1")
    private String Knee_1_1_1; // 其他人工膝关节置换术适应证
    @Column(name = "Knee_1_2_2_0")
    @JsonProperty("Knee-1-2-2-0")
    private String Knee_1_2_2_0; // 手术病变侧别
    @Column(name = "Knee_1_2_1")
    @JsonProperty("Knee-1-2-1")
    private String Knee_1_2_1; // 是否实施膝关节功能评估
    @Column(name = "Knee_1_2_2_2")
    @JsonProperty("Knee-1-2-2-2")
    private String Knee_1_2_2_2; // 左HSS评分值
    @Column(name = "Knee_1_2_2_4")
    @JsonProperty("Knee-1-2-2-4")
    private String Knee_1_2_2_4; // 左评估结果
    @Column(name = "Knee_1_2_2_1")
    @JsonProperty("Knee-1-2-2-1")
    private String Knee_1_2_2_1; // 右HSS评分值
    @Column(name = "Knee_1_2_2_3")
    @JsonProperty("Knee-1-2-2-3")
    private String Knee_1_2_2_3; // 右评估结果
    @Column(name = "Knee_1_3_1")
    @JsonProperty("Knee-1-3-1")
    private String Knee_1_3_1; // 麻醉方式的选择
    @Column(name = "Knee_1_3_2")
    @JsonProperty("Knee-1-3-2")
    private String Knee_1_3_2; // 手术部位的选择
    @Column(name = "Knee_1_3_3")
    @JsonProperty("Knee-1-3-3")
    private String Knee_1_3_3; // 止血带使用时间的选择
    @Column(name = "Knee_1_4_1")
    @JsonProperty("Knee-1-4-1")
    private String Knee_1_4_1; // 决定手术方案的医师资质
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
    @Column(name = "Knee_3_1_1")
    @JsonProperty("Knee-3-1-1")
    private String Knee_3_1_1; // 有无实施手术患者静脉血栓栓塞症风险评估
    @Column(name = "Knee_3_1_2")
    @JsonProperty("Knee-3-1-2")
    private String Knee_3_1_2; // Caprini评估分值
    @Column(name = "Knee_3_1_3")
    @JsonProperty("Knee-3-1-3")
    private String Knee_3_1_3; // Caprini评估风险分层
    @Column(name = "Knee_3_1_8")
    @JsonProperty("Knee-3-1-8")
    private String Knee_3_1_8; // 临床常用检测方法
    @Column(name = "Knee_3_2_1")
    @JsonProperty("Knee-3-2-1")
    private String Knee_3_2_1; // 实施预防术后深静脉血栓措施是否有禁忌
    @Column(name = "Knee_3_2_3")
    @JsonProperty("Knee-3-2-3")
    private String Knee_3_2_3; // 实施机械预防措施应用禁忌
    @Column(name = "Knee_3_2_2")
    @JsonProperty("Knee-3-2-2")
    private String Knee_3_2_2; // 实施药物应用绝对禁忌证
    @Column(name = "Knee_3_2_4")
    @JsonProperty("Knee-3-2-4")
    private String Knee_3_2_4; // 实施药物应用相对禁忌证
    @Column(name = "Knee_3_3_1")
    @JsonProperty("Knee-3-3-1")
    private String Knee_3_3_1; // 预防深静脉栓塞医嘱执行时间
    @Column(name = "Knee_3_4_1")
    @JsonProperty("Knee-3-4-1")
    private String Knee_3_4_1; // 基本预防措施
    @Column(name = "Knee_3_4_1_1")
    @JsonProperty("Knee-3-4-1-1")
    private String Knee_3_4_1_1; // 其他基本预防措施
    @Column(name = "Knee_3_4_1_2")
    @JsonProperty("Knee-3-4-1-2")
    private String Knee_3_4_1_2; // 基本预防措施医嘱执行日期
    @Column(name = "Knee_3_4_2")
    @JsonProperty("Knee-3-4-2")
    private String Knee_3_4_2; // 机械预防措施
    @Column(name = "Knee_3_4_2_1")
    @JsonProperty("Knee-3-4-2-1")
    private String Knee_3_4_2_1; // 其他机械预防措施
    @Column(name = "Knee_3_4_2_2")
    @JsonProperty("Knee-3-4-2-2")
    private String Knee_3_4_2_2; // 机械预防措施医嘱执行日期
    @Column(name = "Knee_3_4_3")
    @JsonProperty("Knee-3-4-3")
    private String Knee_3_4_3; // 预防性地给予药物治疗
    @Column(name = "Knee_3_4_3_1")
    @JsonProperty("Knee-3-4-3-1")
    private String Knee_3_4_3_1; // 预防性地给予药物治疗填写
    @Column(name = "Knee_3_4_3_2")
    @JsonProperty("Knee-3-4-3-2")
    private String Knee_3_4_3_2; // 预防性地给予药物医嘱执行日期
    @Column(name = "Knee_3_5_1")
    @JsonProperty("Knee-3-5-1")
    private String Knee_3_5_1; // 出院后继续使用抗凝药
    @Column(name = "Knee_3_5_1_1")
    @JsonProperty("Knee-3-5-1-1")
    private String Knee_3_5_1_1; // 其他出院后使用的抗凝药
    @Column(name = "Knee_4_1_1")
    @JsonProperty("Knee-4-1-1")
    private String Knee_4_1_1; // 是否实施输血
    @Column(name = "Knee_4_2_1")
    @JsonProperty("Knee-4-2-1")
    private String Knee_4_2_1; // 用血类别的选择
    @Column(name = "Knee_4_2_1_1")
    @JsonProperty("Knee-4-2-1-1")
    private String Knee_4_2_1_1; // 手术输血侧别
    @Column(name = "Knee_4_2_2_1")
    @JsonProperty("Knee-4-2-2-1")
    private String Knee_4_2_2_1; // 单侧手术术中输血量（ml）
    @Column(name = "Knee_4_2_2_2")
    @JsonProperty("Knee-4-2-2-2")
    private String Knee_4_2_2_2; // 单侧手术术后输血量（ml）
    @Column(name = "Knee_4_2_3_1")
    @JsonProperty("Knee-4-2-3-1")
    private String Knee_4_2_3_1; // 双侧手术术中输血量（ml）
    @Column(name = "Knee_4_2_3_2")
    @JsonProperty("Knee-4-2-3-2")
    private String Knee_4_2_3_2; // 双侧手术术后输血量（ml）
    @Column(name = "Knee_5_1_1")
    @JsonProperty("Knee-5-1-1")
    private String Knee_5_1_1; // 康复治疗前是否评估
    @Column(name = "Knee_5_1_2")
    @JsonProperty("Knee-5-1-2")
    private String Knee_5_1_2; // 康复治疗适宜性评估结果
    @Column(name = "Knee_5_1_3")
    @JsonProperty("Knee-5-1-3")
    private String Knee_5_1_3; // 康复实施人员实施康复的方式
    @Column(name = "Knee_5_1_4")
    @JsonProperty("Knee-5-1-4")
    private String Knee_5_1_4; // 康复实施日期(首次)
    @Column(name = "Knee_5_1_5")
    @JsonProperty("Knee-5-1-5")
    private String Knee_5_1_5; // 选择未能进行康复原因
    @Column(name = "Knee_5_2_1_1")
    @JsonProperty("Knee-5-2-1-1")
    private String Knee_5_2_1_1; // 是否进行手术后镇痛治疗
    @Column(name = "Knee_5_2_2_2")
    @JsonProperty("Knee-5-2-2-2")
    private String Knee_5_2_2_2; // 疼痛强度评估方法的选择
    @Column(name = "Knee_5_2_2_1")
    @JsonProperty("Knee-5-2-2-1")
    private String Knee_5_2_2_1; // 其他疼痛强度评估方法
    @Column(name = "Knee_5_2_3")
    @JsonProperty("Knee-5-2-3")
    private String Knee_5_2_3; // 药物选择多模式的选择
    @Column(name = "Knee_5_2_3_1")
    @JsonProperty("Knee-5-2-3-1")
    private String Knee_5_2_3_1; // 其他药物选择多模式
    @Column(name = "Knee_5_2_4")
    @JsonProperty("Knee-5-2-4")
    private String Knee_5_2_4; // 镇痛用药多途径的选择
    @Column(name = "Knee_5_5_1")
    @JsonProperty("Knee-5-5-1")
    private String Knee_5_5_1; // 药物选择多模式填写
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
    @Column(name = "CM_2_3_14")
    @JsonProperty("CM-2-3-14")
    private String CM_2_3_14; // 住院患者发生压疮
    @Column(name = "CM_2_3_15")
    @JsonProperty("CM-2-3-15")
    private String CM_2_3_15; // 肌肉骨骼系统术后并发症
    @Column(name = "CM_2_3_16")
    @JsonProperty("CM-2-3-16")
    private String CM_2_3_16; // 骨科植入物的并发症（不包括脓毒症）
    @Column(name = "Knee_6_1")
    @JsonProperty("Knee-6-1")
    private String Knee_6_1; // 是否伴有内科原有疾病治疗
    @Column(name = "Knee_6_2_1")
    @JsonProperty("Knee-6-2-1")
    private String Knee_6_2_1; // 主要的内科疾患
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    @Column(name = "Knee_8_1")
    @JsonProperty("Knee-8-1")
    private String Knee_8_1; // 入院宣教选择
    @Column(name = "Knee_8_2")
    @JsonProperty("Knee-8-2")
    private String Knee_8_2; // 术前一日的健康教育选择
    @Column(name = "Knee_8_3")
    @JsonProperty("Knee-8-3")
    private String Knee_8_3; // 术后六小时内的健康教育
    @Column(name = "Knee_8_4")
    @JsonProperty("Knee-8-4")
    private String Knee_8_4; // 术后六小时至二十四小时的健康教育 
    @Column(name = "Knee_8_5")
    @JsonProperty("Knee-8-5")
    private String Knee_8_5; // 术后一周内健康教育
    @Column(name = "Knee_8_6")
    @JsonProperty("Knee-8-6")
    private String Knee_8_6; // 术后一周后健康教育
    @Column(name = "Knee_8_7")
    @JsonProperty("Knee-8-7")
    private String Knee_8_7; // 为患者提供出院前健康教育
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