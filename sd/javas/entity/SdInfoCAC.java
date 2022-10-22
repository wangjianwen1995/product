package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：J45，J46；年龄≥18 岁的出院患者。
*/
@ApiModel(value = "21信息")
@Entity
@Data
@Table(name = "sd_info_CAC")
public class SdInfoCAC implements Serializable {
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
    @Column(name = "CM_0_2_3_1")
    @JsonProperty("CM-0-2-3-1")
    private String CM_0_2_3_1; // 到达本院急诊或者门诊日期时间是否无法确定或无记录
    @Column(name = "CM_0_2_3_2")
    @JsonProperty("CM-0-2-3-2")
    private String CM_0_2_3_2; // 到达本院急诊或者门诊日期时间
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
    @Column(name = "CAC_1_1_1")
    @JsonProperty("CAC-1-1-1")
    private String CAC_1_1_1; // 入院后是否实施首次病情严重程度评估
    @Column(name = "CAC_1_1_2")
    @JsonProperty("CAC-1-1-2")
    private String CAC_1_1_2; // 哮喘患者病情严重程度分级
    @Column(name = "CAC_1_2_1")
    @JsonProperty("CAC-1-2-1")
    private String CAC_1_2_1; // 哮喘急性发作时,是否有病情严重程度的分级评估
    @Column(name = "CAC_1_2_2")
    @JsonProperty("CAC-1-2-2")
    private String CAC_1_2_2; // 哮喘急性发作时病情严重程度的分级评估结果
    @Column(name = "CAC_1_3_1")
    @JsonProperty("CAC-1-3-1")
    private String CAC_1_3_1; // 是否对具有急性发作风险的高危患者评估
    @Column(name = "CAC_1_3_2")
    @JsonProperty("CAC-1-3-2")
    private String CAC_1_3_2; // 具有急性发作风险的高危患者评估
    @Column(name = "CAC_2_1_1")
    @JsonProperty("CAC-2-1-1")
    private String CAC_2_1_1; // 是否入住ICU/RICU 
    @Column(name = "CAC_2_2_1")
    @JsonProperty("CAC-2-2-1")
    private String CAC_2_2_1; // 收住ICU/RICU符合指征
    @Column(name = "CAC_2_2_2")
    @JsonProperty("CAC-2-2-2")
    private String CAC_2_2_2; // 入住ICU/RICU时机
    @Column(name = "CAC_3_1_1")
    @JsonProperty("CAC-3-1-1")
    private String CAC_3_1_1; // 是否给予氧疗
    @Column(name = "CAC_3_2_1")
    @JsonProperty("CAC-3-2-1")
    private String CAC_3_2_1; // 氧疗方法
    @Column(name = "CAC_3_3_1")
    @JsonProperty("CAC-3-3-1")
    private String CAC_3_3_1; // 氧疗30min后是否评估氧合状态
    @Column(name = "CAC_3_3_2")
    @JsonProperty("CAC-3-3-2")
    private String CAC_3_3_2; // 氧合状态评估方法
    @Column(name = "CAC_3_3_2_1")
    @JsonProperty("CAC-3-3-2-1")
    private String CAC_3_3_2_1; // 外周氧饱和度值(%)
    @Column(name = "CAC_3_3_2_2")
    @JsonProperty("CAC-3-3-2-2")
    private String CAC_3_3_2_2; // 动脉氧分压(mmHg)
    @Column(name = "CAC_4_1_1")
    @JsonProperty("CAC-4-1-1")
    private String CAC_4_1_1; // 是否吸入支气管舒张剂
    @Column(name = "CAC_4_1_2")
    @JsonProperty("CAC-4-1-2")
    private String CAC_4_1_2; // 吸入支气管舒张剂种类
    @Column(name = "CAC_4_1_2_1")
    @JsonProperty("CAC-4-1-2-1")
    private String CAC_4_1_2_1; // 其它支气管舒张剂
    @Column(name = "CAC_4_2_1")
    @JsonProperty("CAC-4-2-1")
    private String CAC_4_2_1; // 是否吸入糖皮质激素
    @Column(name = "CAC_4_2_2")
    @JsonProperty("CAC-4-2-2")
    private String CAC_4_2_2; // 吸入糖皮质激素种类
    @Column(name = "CAC_4_2_2_1")
    @JsonProperty("CAC-4-2-2-1")
    private String CAC_4_2_2_1; // 其他吸入糖皮质激素
    @Column(name = "CAC_5_1_1")
    @JsonProperty("CAC-5-1-1")
    private String CAC_5_1_1; // 是否使用全身糖皮质激素
    @Column(name = "CAC_5_1_2")
    @JsonProperty("CAC-5-1-2")
    private String CAC_5_1_2; // 糖皮质激素选择
    @Column(name = "CAC_5_1_2_1")
    @JsonProperty("CAC-5-1-2-1")
    private String CAC_5_1_2_1; // 其他糖皮质激素治疗途径
    @Column(name = "CAC_5_2_1")
    @JsonProperty("CAC-5-2-1")
    private String CAC_5_2_1; // 全身糖皮质激素使用医嘱起始日期时间
    @Column(name = "CAC_5_2_2")
    @JsonProperty("CAC-5-2-2")
    private String CAC_5_2_2; // 全身糖皮质激素使用医嘱终止日期
    @Column(name = "CAC_5_2_3")
    @JsonProperty("CAC-5-2-3")
    private String CAC_5_2_3; // 全身糖皮质激素使用天数
    @Column(name = "CAC_6_1_1")
    @JsonProperty("CAC-6-1-1")
    private String CAC_6_1_1; // 患者病情稳定出院前是否开始应用控制性药物
    @Column(name = "CAC_6_2_1")
    @JsonProperty("CAC-6-2-1")
    private String CAC_6_2_1; // 控制药物使用情况
    @Column(name = "CAC_6_2_1_1")
    @JsonProperty("CAC-6-2-1-1")
    private String CAC_6_2_1_1; // 其他控制药物使用情况
    @Column(name = "CAC_7_1_1")
    @JsonProperty("CAC-7-1-1")
    private String CAC_7_1_1; // 是否使用茶碱   
    @Column(name = "CAC_7_1_2")
    @JsonProperty("CAC-7-1-2")
    private String CAC_7_1_2; // 茶碱制剂种类
    @Column(name = "CAC_7_1_2_1")
    @JsonProperty("CAC-7-1-2-1")
    private String CAC_7_1_2_1; // 其他茶碱制剂
    @Column(name = "CAC_7_1_3")
    @JsonProperty("CAC-7-1-3")
    private String CAC_7_1_3; // 用药途径
    @Column(name = "CAC_7_1_4")
    @JsonProperty("CAC-7-1-4")
    private String CAC_7_1_4; // 是否监测茶碱血药浓度
    @Column(name = "CAC_7_1_5")
    @JsonProperty("CAC-7-1-5")
    private String CAC_7_1_5; // 茶碱血药浓度(μg/ml)
    @Column(name = "CAC_8_1_1")
    @JsonProperty("CAC-8-1-1")
    private String CAC_8_1_1; // 是否入院后实施首次实验室检查评估
    @Column(name = "CAC_8_1_2")
    @JsonProperty("CAC-8-1-2")
    private String CAC_8_1_2; // 实验室检查评估
    @Column(name = "CAC_8_1_2_1")
    @JsonProperty("CAC-8-1-2-1")
    private String CAC_8_1_2_1; // 其他实验室检查评估
    @Column(name = "CAC_8_1_3")
    @JsonProperty("CAC-8-1-3")
    private String CAC_8_1_3; // 是否入院后实施首次胸部影像学检查
    @Column(name = "CAC_8_1_4")
    @JsonProperty("CAC-8-1-4")
    private String CAC_8_1_4; // 胸部影像学检查评估
    @Column(name = "CAC_8_1_4_1")
    @JsonProperty("CAC-8-1-4-1")
    private String CAC_8_1_4_1; // 其他胸部影像学检查评估
    @Column(name = "CAC_8_2_1")
    @JsonProperty("CAC-8-2-1")
    private String CAC_8_2_1; // 是否入院24小时内是否应用抗菌药物
    @Column(name = "CAC_8_2_2")
    @JsonProperty("CAC-8-2-2")
    private String CAC_8_2_2; // 患者接受首剂抗菌药物治疗（注射剂输入/注射）时间
    @Column(name = "CAC_8_2_3")
    @JsonProperty("CAC-8-2-3")
    private String CAC_8_2_3; // 接受首剂抗菌药物使用时机
    @Column(name = "CAC_8_2_3_r")
    @JsonProperty("CAC-8-2-3-r")
    private String CAC_8_2_3_r; // 
    @Column(name = "CAC_8_3_1")
    @JsonProperty("CAC-8-3-1")
    private String CAC_8_3_1; // 入院后是否进行首次病原学检测
    @Column(name = "CAC_8_3_4")
    @JsonProperty("CAC-8-3-4")
    private String CAC_8_3_4; // 病原学诊断结果选择
    @Column(name = "CAC_8_3_3")
    @JsonProperty("CAC-8-3-3")
    private String CAC_8_3_3; // 依据病原学诊断结果，选择目标抗感染药物
    @Column(name = "CAC_8_3_2")
    @JsonProperty("CAC-8-3-2")
    private String CAC_8_3_2; // 使用抗感染药物种类
    @Column(name = "CAC_8_3_2_1")
    @JsonProperty("CAC-8-3-2-1")
    private String CAC_8_3_2_1; // 青霉素类抗感染药物
    @Column(name = "CAC_8_3_2_1_1")
    @JsonProperty("CAC-8-3-2-1-1")
    private String CAC_8_3_2_1_1; // 其它青霉素类抗感染药物名称
    @Column(name = "CAC_8_3_2_2")
    @JsonProperty("CAC-8-3-2-2")
    private String CAC_8_3_2_2; // 头孢菌素类抗感染药物
    @Column(name = "CAC_8_3_2_2_1")
    @JsonProperty("CAC-8-3-2-2-1")
    private String CAC_8_3_2_2_1; // 其它头孢菌素类抗感染药物名称
    @Column(name = "CAC_8_3_2_3")
    @JsonProperty("CAC-8-3-2-3")
    private String CAC_8_3_2_3; // 大环内酯类抗感染药物
    @Column(name = "CAC_8_3_2_3_1")
    @JsonProperty("CAC-8-3-2-3-1")
    private String CAC_8_3_2_3_1; // 其它大环内酯类抗感染药物名称
    @Column(name = "CAC_8_3_2_4")
    @JsonProperty("CAC-8-3-2-4")
    private String CAC_8_3_2_4; // 喹诺酮类抗感染药物
    @Column(name = "CAC_8_3_2_4_1")
    @JsonProperty("CAC-8-3-2-4-1")
    private String CAC_8_3_2_4_1; // 其它喹诺酮类抗感染药物名称
    @Column(name = "CAC_8_3_2_5")
    @JsonProperty("CAC-8-3-2-5")
    private String CAC_8_3_2_5; // 其他类抗感染药物
    @Column(name = "CAC_8_3_2_5_1")
    @JsonProperty("CAC-8-3-2-5-1")
    private String CAC_8_3_2_5_1; // 其他类其它抗感染药物名称
    @Column(name = "CAC_8_3_2_6")
    @JsonProperty("CAC-8-3-2-6")
    private String CAC_8_3_2_6; // 抗真菌药物
    @Column(name = "CAC_8_3_2_6_1")
    @JsonProperty("CAC-8-3-2-6-1")
    private String CAC_8_3_2_6_1; // 其它抗真菌药物名称
    @Column(name = "CAC_9_1_1")
    @JsonProperty("CAC-9-1-1")
    private String CAC_9_1_1; // 是否实施机械通气
    @Column(name = "CAC_9_1_2")
    @JsonProperty("CAC-9-1-2")
    private String CAC_9_1_2; // 机械通气应用指征
    @Column(name = "CAC_9_1_2_1")
    @JsonProperty("CAC-9-1-2-1")
    private String CAC_9_1_2_1; // 其他机械通气应用指征
    @Column(name = "CAC_9_1_3")
    @JsonProperty("CAC-9-1-3")
    private String CAC_9_1_3; // 患者机械通气起始日期时间
    @Column(name = "CAC_9_1_4")
    @JsonProperty("CAC-9-1-4")
    private String CAC_9_1_4; // 患者机械通气终止日期时间
    @Column(name = "CAC_9_1_5")
    @JsonProperty("CAC-9-1-5")
    private String CAC_9_1_5; // 机械通气疗程（小时）
    @Column(name = "CAC_10_1_1")
    @JsonProperty("CAC-10-1-1")
    private String CAC_10_1_1; // 是否有肺动脉高压和右心功能不全
    @Column(name = "CAC_10_1_2")
    @JsonProperty("CAC-10-1-2")
    private String CAC_10_1_2; // 首次处置血管扩张剂（无禁忌症）的选择
    @Column(name = "CAC_10_1_2_1")
    @JsonProperty("CAC-10-1-2-1")
    private String CAC_10_1_2_1; // 其他首次处置血管扩张剂
    @Column(name = "CAC_10_2_1")
    @JsonProperty("CAC-10-2-1")
    private String CAC_10_2_1; // 是否有气胸
    @Column(name = "CAC_10_2_2")
    @JsonProperty("CAC-10-2-2")
    private String CAC_10_2_2; // 首位处置项目的选择
    @Column(name = "CAC_10_2_2_1")
    @JsonProperty("CAC-10-2-2-1")
    private String CAC_10_2_2_1; // 其他首位处置项目
    @Column(name = "CAC_10_3_1")
    @JsonProperty("CAC-10-3-1")
    private String CAC_10_3_1; // 是否有胃食管反流病
    @Column(name = "CAC_10_3_2")
    @JsonProperty("CAC-10-3-2")
    private String CAC_10_3_2; // 首位处置项目的选择
    @Column(name = "CAC_10_3_2_1")
    @JsonProperty("CAC-10-3-2-1")
    private String CAC_10_3_2_1; // 其它首位处置项目
    @Column(name = "CAC_11_1_1")
    @JsonProperty("CAC-11-1-1")
    private String CAC_11_1_1; // 住院期间是否为患者提供健康教育
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CAC_11_2_4")
    @JsonProperty("CAC-11-2-4")
    private String CAC_11_2_4; // 告知患者进入慢性持续期和临床缓解期，需要进一步控制治疗
    @Column(name = "CAC_11_2_5")
    @JsonProperty("CAC-11-2-5")
    private String CAC_11_2_5; // 告知患者哮喘教育管理途径
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