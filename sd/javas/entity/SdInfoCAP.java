package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：J13 至 J16，J18；年龄≥18 岁的出院患者。
*/
@ApiModel(value = "18信息")
@Entity
@Data
@Table(name = "sd_info_CAP")
public class SdInfoCAP implements Serializable {
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
    @Column(name = "CM_0_1_4_3")
    @JsonProperty("CM-0-1-4-3")
    private String CM_0_1_4_3; // 其他主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 肺炎出院后是否31天内重复住院
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
    private String CM_0_2_5_1; // 入住ICU日期时间
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU日期时间
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "Cap_Adult_1_1")
    @JsonProperty("Cap-Adult-1-1")
    private String Cap_Adult_1_1; // 是否实施CAP病情严重程度的评价
    @Column(name = "Cap_Adult_1")
    @JsonProperty("Cap-Adult-1")
    private String Cap_Adult_1; // 病情严重程度的评价
    @Column(name = "Cap_Adult_1_1_1")
    @JsonProperty("Cap-Adult-1-1-1")
    private String Cap_Adult_1_1_1; // 首次CURB-65评分数值
    @Column(name = "Cap_Adult_1_1_1_1")
    @JsonProperty("Cap-Adult-1-1-1-1")
    private String Cap_Adult_1_1_1_1; // 风险程度评估
    @Column(name = "Cap_Adult_1_1_2")
    @JsonProperty("Cap-Adult-1-1-2")
    private String Cap_Adult_1_1_2; // 首次PSI评分数值
    @Column(name = "Cap_Adult_1_1_2_1")
    @JsonProperty("Cap-Adult-1-1-2-1")
    private String Cap_Adult_1_1_2_1; // 风险程度评估
    @Column(name = "Cap_Adult_1_1_3")
    @JsonProperty("Cap-Adult-1-1-3")
    private String Cap_Adult_1_1_3; // CRB-65 评分数值
    @Column(name = "Cap_Adult_1_1_3_1")
    @JsonProperty("Cap-Adult-1-1-3-1")
    private String Cap_Adult_1_1_3_1; // 风险程度评估
    @Column(name = "Cap_Adult_1_1_4")
    @JsonProperty("Cap-Adult-1-1-4")
    private String Cap_Adult_1_1_4; // SMART-COP评分数值
    @Column(name = "Cap_Adult_1_1_4_1")
    @JsonProperty("Cap-Adult-1-1-4-1")
    private String Cap_Adult_1_1_4_1; // 风险程度评估
    @Column(name = "Cap_Adult_1_2_1")
    @JsonProperty("Cap-Adult-1-2-1")
    private String Cap_Adult_1_2_1; // 是否重症肺炎诊断
    @Column(name = "Cap_Adult_1_2_2")
    @JsonProperty("Cap-Adult-1-2-2")
    private String Cap_Adult_1_2_2; // 重症肺炎诊断主要标准
    @Column(name = "Cap_Adult_1_2_3")
    @JsonProperty("Cap-Adult-1-2-3")
    private String Cap_Adult_1_2_3; // 重症肺炎诊断次要标准
    @Column(name = "Cap_Adult_2_1")
    @JsonProperty("Cap-Adult-2-1")
    private String Cap_Adult_2_1; // 是否实施首次氧合评估（首次）
    @Column(name = "Cap_Adult_2_2")
    @JsonProperty("Cap-Adult-2-2")
    private String Cap_Adult_2_2; // 实施首次氧合评估时段
    @Column(name = "Cap_Adult_2_3")
    @JsonProperty("Cap-Adult-2-3")
    private String Cap_Adult_2_3; // 实施首次氧合评估时是否吸氧（FiO2）
    @Column(name = "Cap_Adult_2_4")
    @JsonProperty("Cap-Adult-2-4")
    private String Cap_Adult_2_4; // 动脉血气分析/指氧仪检查
    @Column(name = "Cap_Adult_2_4_3")
    @JsonProperty("Cap-Adult-2-4-3")
    private String Cap_Adult_2_4_3; // 动脉血气分析值(mmhg)
    @Column(name = "Cap_Adult_2_4_4")
    @JsonProperty("Cap-Adult-2-4-4")
    private String Cap_Adult_2_4_4; // 指氧仪检查值(%)
    @Column(name = "Cap_Adult_3_1_1")
    @JsonProperty("Cap-Adult-3-1-1")
    private String Cap_Adult_3_1_1; // 住院的患者, 是否实施病原学诊断
    @Column(name = "Cap_Adult_3_1_2")
    @JsonProperty("Cap-Adult-3-1-2")
    private String Cap_Adult_3_1_2; // 实施首次采集标本时段
    @Column(name = "Cap_Adult_3_1_3")
    @JsonProperty("Cap-Adult-3-1-3")
    private String Cap_Adult_3_1_3; // 实施首次采集什么标本
    @Column(name = "Cap_Adult_3_1_3_1")
    @JsonProperty("Cap-Adult-3-1-3-1")
    private String Cap_Adult_3_1_3_1; // 其他首次采集标本
    @Column(name = "Cap_Adult_3_2_1")
    @JsonProperty("Cap-Adult-3-2-1")
    private String Cap_Adult_3_2_1; // 是否重症 CAP伴有特定临床情况
    @Column(name = "Cap_Adult_3_2_2")
    @JsonProperty("Cap-Adult-3-2-2")
    private String Cap_Adult_3_2_2; // 特定临床情况选项
    @Column(name = "Cap_Adult_3_3_1")
    @JsonProperty("Cap-Adult-3-3-1")
    private String Cap_Adult_3_3_1; // 是否进行侵入性病原学检测
    @Column(name = "Cap_Adult_3_3_2")
    @JsonProperty("Cap-Adult-3-3-2")
    private String Cap_Adult_3_3_2; // 实施侵入性病原学检测(ⅢB)的理由
    @Column(name = "Cap_Adult_3_3_3")
    @JsonProperty("Cap-Adult-3-3-3")
    private String Cap_Adult_3_3_3; // 侵入性病原学检测送检标本来源
    @Column(name = "Cap_Adult_3_3_3_1")
    @JsonProperty("Cap-Adult-3-3-3-1")
    private String Cap_Adult_3_3_3_1; // 其它侵入性病原学检测送检标本来源
    @Column(name = "Cap_Adult_3_4_1")
    @JsonProperty("Cap-Adult-3-4-1")
    private String Cap_Adult_3_4_1; // 是否送检病原学标本
    @Column(name = "Cap_Adult_3_4_2")
    @JsonProperty("Cap-Adult-3-4-2")
    private String Cap_Adult_3_4_2; // 送检病原学检测项目选择
    @Column(name = "Cap_Adult_3_4_2_1")
    @JsonProperty("Cap-Adult-3-4-2-1")
    private String Cap_Adult_3_4_2_1; // 其它送检病原学检测项目
    @Column(name = "Cap_Adult_3_5_1")
    @JsonProperty("Cap-Adult-3-5-1")
    private String Cap_Adult_3_5_1; // 病原学检测结果的选择
    @Column(name = "Cap_Adult_3_5_1_1")
    @JsonProperty("Cap-Adult-3-5-1-1")
    private String Cap_Adult_3_5_1_1; // 其它病原学检测结果
    @Column(name = "Cap_Adult_4_1")
    @JsonProperty("Cap-Adult-4-1")
    private String Cap_Adult_4_1; // 患者有无接受抗菌药物治疗
    @Column(name = "Cap_Adult_4_1_3")
    @JsonProperty("Cap-Adult-4-1-3")
    private String Cap_Adult_4_1_3; // 注射剂输入/注射起始日期
    @Column(name = "Cap_Adult_4_2")
    @JsonProperty("Cap-Adult-4-2")
    private String Cap_Adult_4_2; // 接受首剂抗菌药物使用时机
    @Column(name = "Cap_Adult_4_2_r")
    @JsonProperty("Cap-Adult-4-2-r")
    private String Cap_Adult_4_2_r; // 
    @Column(name = "Cap_Adult_4_3")
    @JsonProperty("Cap-Adult-4-3")
    private String Cap_Adult_4_3; // 治疗途径
    @Column(name = "Cap_Adult_4_4")
    @JsonProperty("Cap-Adult-4-4")
    private String Cap_Adult_4_4; // 注射剂输入/注射终止日期
    @Column(name = "Cap_Adult_4_2_3")
    @JsonProperty("Cap-Adult-4-2-3")
    private String Cap_Adult_4_2_3; // 入院后使用抗菌药物（口服剂）首剂日期与时间
    @Column(name = "Cap_Adult_4_2_4")
    @JsonProperty("Cap-Adult-4-2-4")
    private String Cap_Adult_4_2_4; // 末剂抗菌药物（口服剂）或出院日期与时间
    @Column(name = "Cap_Adult_4_2_5")
    @JsonProperty("Cap-Adult-4-2-5")
    private String Cap_Adult_4_2_5; // 口服剂抗菌药物疗程（天数）
    @Column(name = "Cap_Adult_5_1")
    @JsonProperty("Cap-Adult-5-1")
    private String Cap_Adult_5_1; // 用药前病情判定分层
    @Column(name = "Cap_Adult_5_2")
    @JsonProperty("Cap-Adult-5-2")
    private String Cap_Adult_5_2; // 经验性抗感染药物的选择
    @Column(name = "Cap_Adult_5_2_1")
    @JsonProperty("Cap-Adult-5-2-1")
    private String Cap_Adult_5_2_1; // 一代头孢菌素选择
    @Column(name = "Cap_Adult_5_2_2")
    @JsonProperty("Cap-Adult-5-2-2")
    private String Cap_Adult_5_2_2; // 二代头孢菌素选择
    @Column(name = "Cap_Adult_5_2_3")
    @JsonProperty("Cap-Adult-5-2-3")
    private String Cap_Adult_5_2_3; // 三代头孢菌素选择
    @Column(name = "Cap_Adult_5_2_4")
    @JsonProperty("Cap-Adult-5-2-4")
    private String Cap_Adult_5_2_4; // 头霉素类选择
    @Column(name = "Cap_Adult_5_2_5")
    @JsonProperty("Cap-Adult-5-2-5")
    private String Cap_Adult_5_2_5; // 呼吸喹诺酮类选择
    @Column(name = "Cap_Adult_5_2_6")
    @JsonProperty("Cap-Adult-5-2-6")
    private String Cap_Adult_5_2_6; // 氨基青霉素选择
    @Column(name = "Cap_Adult_5_2_7")
    @JsonProperty("Cap-Adult-5-2-7")
    private String Cap_Adult_5_2_7; // 青霉素类/酶抑制剂受合物选择
    @Column(name = "Cap_Adult_5_2_8")
    @JsonProperty("Cap-Adult-5-2-8")
    private String Cap_Adult_5_2_8; // 大环内酯类选择
    @Column(name = "Cap_Adult_5_2_9")
    @JsonProperty("Cap-Adult-5-2-9")
    private String Cap_Adult_5_2_9; // 有抗假单胞菌活性的喹诺酮类选择
    @Column(name = "Cap_Adult_5_2_10")
    @JsonProperty("Cap-Adult-5-2-10")
    private String Cap_Adult_5_2_10; // 有抗假单胞菌活性的-内酰胺类选择
    @Column(name = "Cap_Adult_5_2_11")
    @JsonProperty("Cap-Adult-5-2-11")
    private String Cap_Adult_5_2_11; // 氧头孢类选择
    @Column(name = "Cap_Adult_5_2_12")
    @JsonProperty("Cap-Adult-5-2-12")
    private String Cap_Adult_5_2_12; // 氨基糖苷类选择
    @Column(name = "Cap_Adult_5_2_13")
    @JsonProperty("Cap-Adult-5-2-13")
    private String Cap_Adult_5_2_13; // 四环类选择
    @Column(name = "Cap_Adult_5_2_14")
    @JsonProperty("Cap-Adult-5-2-14")
    private String Cap_Adult_5_2_14; // 神经氨酸抑制剂选择
    @Column(name = "Cap_Adult_5_2_15")
    @JsonProperty("Cap-Adult-5-2-15")
    private String Cap_Adult_5_2_15; // 经验性用药选用"特殊类使用种抗菌药物"药物选择
    @Column(name = "Cap_Adult_5_2_16")
    @JsonProperty("Cap-Adult-5-2-16")
    private String Cap_Adult_5_2_16; // 其他抗菌药物
    @Column(name = "Cap_Adult_6_1_1")
    @JsonProperty("Cap-Adult-6-1-1")
    private String Cap_Adult_6_1_1; // 是否初始治疗72小时后进行评价
    @Column(name = "Cap_Adult_6_1_2")
    @JsonProperty("Cap-Adult-6-1-2")
    private String Cap_Adult_6_1_2; // 评价结论
    @Column(name = "Cap_Adult_6_5_1")
    @JsonProperty("Cap-Adult-6-5-1")
    private String Cap_Adult_6_5_1; // 初始治疗72小时后评价有效
    @Column(name = "Cap_Adult_6_2_1")
    @JsonProperty("Cap-Adult-6-2-1")
    private String Cap_Adult_6_2_1; // 重复病原学检查
    @Column(name = "Cap_Adult_6_2_2")
    @JsonProperty("Cap-Adult-6-2-2")
    private String Cap_Adult_6_2_2; // 常见原因
    @Column(name = "Cap_Adult_6_2_2_1")
    @JsonProperty("Cap-Adult-6-2-2-1")
    private String Cap_Adult_6_2_2_1; // 其它原因和处理
    @Column(name = "Cap_Adult_6_2_3")
    @JsonProperty("Cap-Adult-6-2-3")
    private String Cap_Adult_6_2_3; // 病原学检查项目
    @Column(name = "Cap_Adult_6_2_3_1")
    @JsonProperty("Cap-Adult-6-2-3-1")
    private String Cap_Adult_6_2_3_1; // 其它病原学检查项目
    @Column(name = "Cap_Adult_6_3_1")
    @JsonProperty("Cap-Adult-6-3-1")
    private String Cap_Adult_6_3_1; // 重复病原学诊断结果选择
    @Column(name = "Cap_Adult_6_3_1_1")
    @JsonProperty("Cap-Adult-6-3-1-1")
    private String Cap_Adult_6_3_1_1; // 其它重复病原学诊断结果
    @Column(name = "Cap_Adult_6_4")
    @JsonProperty("Cap-Adult-6-4")
    private String Cap_Adult_6_4; // 目标抗感染药物的选择
    @Column(name = "Cap_Adult_6_4_7")
    @JsonProperty("Cap-Adult-6-4-7")
    private String Cap_Adult_6_4_7; // 其他目标抗感染药物
    @Column(name = "Cap_Adult_7_1_1_1")
    @JsonProperty("Cap-Adult-7-1-1-1")
    private String Cap_Adult_7_1_1_1; // 是否实施氧疗
    @Column(name = "Cap_Adult_7_1_2_1")
    @JsonProperty("Cap-Adult-7-1-2-1")
    private String Cap_Adult_7_1_2_1; // 氧疗方法
    @Column(name = "Cap_Adult_7_1_3_1")
    @JsonProperty("Cap-Adult-7-1-3-1")
    private String Cap_Adult_7_1_3_1; // 氧疗 30min 后是否复查动脉血气
    @Column(name = "Cap_Adult_7_2_1_1")
    @JsonProperty("Cap-Adult-7-2-1-1")
    private String Cap_Adult_7_2_1_1; // 是否实施无创正压通气（NIV）
    @Column(name = "Cap_Adult_7_2_2_0")
    @JsonProperty("Cap-Adult-7-2-2-0")
    private String Cap_Adult_7_2_2_0; // 无创正压通气的应用指征
    @Column(name = "Cap_Adult_7_2_2_1")
    @JsonProperty("Cap-Adult-7-2-2-1")
    private String Cap_Adult_7_2_2_1; // 其它无创正压通气的应用指征
    @Column(name = "Cap_Adult_6_2_5_1")
    @JsonProperty("Cap-Adult-6-2-5-1")
    private String Cap_Adult_6_2_5_1; // 患者无创正压通气起始日期时间
    @Column(name = "Cap_Adult_6_2_4_2")
    @JsonProperty("Cap-Adult-6-2-4-2")
    private String Cap_Adult_6_2_4_2; // 患者无创正压通气终止日期时间
    @Column(name = "Cap_Adult_6_2_5")
    @JsonProperty("Cap-Adult-6-2-5")
    private String Cap_Adult_6_2_5; // 无创正压通气疗程（小时）
    @Column(name = "Cap_Adult_7_3_1")
    @JsonProperty("Cap-Adult-7-3-1")
    private String Cap_Adult_7_3_1; // 是否实施有创机械通气
    @Column(name = "Cap_Adult_7_3_2")
    @JsonProperty("Cap-Adult-7-3-2")
    private String Cap_Adult_7_3_2; // 有创机械通气的具体应用指征
    @Column(name = "Cap_Adult_7_3_2_1")
    @JsonProperty("Cap-Adult-7-3-2-1")
    private String Cap_Adult_7_3_2_1; // 其它有创机械通气的具体应用指征
    @Column(name = "Cap_Adult_6_3_4_1")
    @JsonProperty("Cap-Adult-6-3-4-1")
    private String Cap_Adult_6_3_4_1; // 患者有机械通气起始日期时间
    @Column(name = "Cap_Adult_6_3_4_2")
    @JsonProperty("Cap-Adult-6-3-4-2")
    private String Cap_Adult_6_3_4_2; // 患者有机械通气终止日期时间
    @Column(name = "Cap_Adult_6_3_5")
    @JsonProperty("Cap-Adult-6-3-5")
    private String Cap_Adult_6_3_5; // 有机械通气疗程（小时）
    @Column(name = "Cap_Adult_7_4_1")
    @JsonProperty("Cap-Adult-7-4-1")
    private String Cap_Adult_7_4_1; // 是否实施体外膜肺氧合ECMO
    @Column(name = "Cap_Adult_7_4_2")
    @JsonProperty("Cap-Adult-7-4-2")
    private String Cap_Adult_7_4_2; // 体外膜肺氧合应用指征
    @Column(name = "Cap_Adult_7_4_2_1")
    @JsonProperty("Cap-Adult-7-4-2-1")
    private String Cap_Adult_7_4_2_1; // 其它体外膜肺氧合应用指征
    @Column(name = "Cap_Adult_6_4_8")
    @JsonProperty("Cap-Adult-6-4-8")
    private String Cap_Adult_6_4_8; // 患者体外膜肺氧合起始日期时间
    @Column(name = "Cap_Adult_6_4_4_2")
    @JsonProperty("Cap-Adult-6-4-4-2")
    private String Cap_Adult_6_4_4_2; // 患者体外膜肺氧合终止日期时间
    @Column(name = "Cap_Adult_6_4_9")
    @JsonProperty("Cap-Adult-6-4-9")
    private String Cap_Adult_6_4_9; // 体外膜肺氧合疗程（小时）
    @Column(name = "Cap_Adult_8_1")
    @JsonProperty("Cap-Adult-8-1")
    private String Cap_Adult_8_1; // 吸烟史
    @Column(name = "Cap_Adult_8_2")
    @JsonProperty("Cap-Adult-8-2")
    private String Cap_Adult_8_2; // 吸烟程度评估有记录
    @Column(name = "Cap_Adult_8_3")
    @JsonProperty("Cap-Adult-8-3")
    private String Cap_Adult_8_3; // 接受戒烟的建议或者戒烟治疗有记录
    @Column(name = "Cap_Adult_8_2_1")
    @JsonProperty("Cap-Adult-8-2-1")
    private String Cap_Adult_8_2_1; // 是否接种肺炎链球菌疫苗
    @Column(name = "Cap_Adult_8_2_2")
    @JsonProperty("Cap-Adult-8-2-2")
    private String Cap_Adult_8_2_2; // 患者接受肺炎链球菌疫苗接种的缘由
    @Column(name = "Cap_Adult_8_3_1")
    @JsonProperty("Cap-Adult-8-3-1")
    private String Cap_Adult_8_3_1; // 是否接种流感疫苗
    @Column(name = "Cap_Adult_8_3_2")
    @JsonProperty("Cap-Adult-8-3-2")
    private String Cap_Adult_8_3_2; // 患者接受流感疫苗接种的缘由
    @Column(name = "Cap_Adult_9_3_1")
    @JsonProperty("Cap-Adult-9-3-1")
    private String Cap_Adult_9_3_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "Cap_Adult_9_3_2")
    @JsonProperty("Cap-Adult-9-3-2")
    private String Cap_Adult_9_3_2; // 出院带药
    @Column(name = "Cap_Adult_9_3_5")
    @JsonProperty("Cap-Adult-9-3-5")
    private String Cap_Adult_9_3_5; // 告知何为发生紧急意外情况或者疾病复发
    @Column(name = "Cap_Adult_9_3_3")
    @JsonProperty("Cap-Adult-9-3-3")
    private String Cap_Adult_9_3_3; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "Cap_Adult_9_3_4")
    @JsonProperty("Cap-Adult-9-3-4")
    private String Cap_Adult_9_3_4; // 出院时教育与随访
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
    @Column(name = "Cap_Adult_9_1")
    @JsonProperty("Cap-Adult-9-1")
    private String Cap_Adult_9_1; // 出院标准
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
    @Column(name = "Cap_Adult_10_1")
    @JsonProperty("Cap-Adult-10-1")
    private String Cap_Adult_10_1; // 患者接受首剂抗菌药物治疗注射剂输入/注射起始日期
    @Column(name = "Cap_Adult_10_3")
    @JsonProperty("Cap-Adult-10-3")
    private String Cap_Adult_10_3; // 患者终止抗菌药物治疗注射剂输入/注射日期时间
    @Column(name = "Cap_Adult_10_1_5")
    @JsonProperty("Cap-Adult-10-1-5")
    private String Cap_Adult_10_1_5; // 注射剂输入/注射抗菌药物疗程（天数）
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