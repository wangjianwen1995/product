package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：J13 至 J16，J18；2 岁≤年龄＜18 岁的出院患儿。
*/
@ApiModel(value = "19信息")
@Entity
@Data
@Table(name = "sd_info_CAP2")
public class SdInfoCAP2 implements Serializable {
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
    private String caseId; // 患儿病案号
    @Column(name = "IDCard")
    @JsonProperty("IDCard")
    private String IDCard; // 患儿身份证号
    @Column(name = "CM_0_1_3_1")
    @JsonProperty("CM-0-1-3-1")
    private String CM_0_1_3_1; // 主要诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "Cap_0_1_4_1")
    @JsonProperty("Cap-0-1-4-1")
    private String Cap_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "Cap_0_1_5_1")
    @JsonProperty("Cap-0-1-5-1")
    private String Cap_0_1_5_1; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否出院后31天内重复住院
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM-0-2-1-1")
    private String CM_0_2_1_1; // 出生日期
    @Column(name = "CM_0_2_1_2")
    @JsonProperty("CM-0-2-1-2")
    private String CM_0_2_1_2; // 患儿性别
    @Column(name = "CM_0_2_1_3")
    @JsonProperty("CM-0-2-1-3")
    private String CM_0_2_1_3; // 患儿体重（kg）
    @Column(name = "CM_0_2_1_5")
    @JsonProperty("CM-0-2-1-5")
    private String CM_0_2_1_5; // 患儿身高（cm）
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
    @Column(name = "Cap_0_2_1_2")
    @JsonProperty("Cap-0-2-1-2")
    private String Cap_0_2_1_2; // 年龄分组
    @Column(name = "CM_0_2_4_2")
    @JsonProperty("CM-0-2-4-2")
    private String CM_0_2_4_2; // 出院日期时间
    @Column(name = "CM_0_2_5_1")
    @JsonProperty("CM-0-2-5-1")
    private String CM_0_2_5_1; // 入住ICU/RCU日期时间
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU/RCU日期时间
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "Cap_1_1_0")
    @JsonProperty("Cap-1-1-0")
    private String Cap_1_1_0; // 是否有重症肺炎的高危因素
    @Column(name = "Cap_1_1_1")
    @JsonProperty("Cap-1-1-1")
    private String Cap_1_1_1; // 重症肺炎的高危因素
    @Column(name = "Cap_1_1_1_1")
    @JsonProperty("Cap-1-1-1-1")
    private String Cap_1_1_1_1; // 其他高危因素
    @Column(name = "Cap_1_1_2")
    @JsonProperty("Cap-1-1-2")
    private String Cap_1_1_2; // 符合重症肺炎
    @Column(name = "Cap_1_1_3")
    @JsonProperty("Cap-1-1-3")
    private String Cap_1_1_3; // 符合以下情况之一,需住院
    @Column(name = "Cap_1_2_1")
    @JsonProperty("Cap-1-2-1")
    private String Cap_1_2_1; // 是否为重症住院及住ICU/RCU患儿
    @Column(name = "Cap_1_2_2")
    @JsonProperty("Cap-1-2-2")
    private String Cap_1_2_2; // 重度肺炎表现
    @Column(name = "Cap_1_2_3")
    @JsonProperty("Cap-1-2-3")
    private String Cap_1_2_3; // 符合重症住院及住ICU/RCU标准
    @Column(name = "Cap_1_3_1")
    @JsonProperty("Cap-1-3-1")
    private String Cap_1_3_1; // 是否接种肺炎链球菌疫苗和（或）流感疫苗的
    @Column(name = "Cap_2_1")
    @JsonProperty("Cap-2-1")
    private String Cap_2_1; // 实施首次氧合评估（首次）
    @Column(name = "Cap_2_2")
    @JsonProperty("Cap-2-2")
    private String Cap_2_2; // 实施首次氧合评估时段
    @Column(name = "Cap_2_3")
    @JsonProperty("Cap-2-3")
    private String Cap_2_3; // 实施首次氧合评估时是否吸氧（FiO₂）
    @Column(name = "Cap_2_4")
    @JsonProperty("Cap-2-4")
    private String Cap_2_4; // 动脉血气分析/指氧仪检查
    @Column(name = "Cap_2_4_3")
    @JsonProperty("Cap-2-4-3")
    private String Cap_2_4_3; // 动脉血气分析值(mmHg)
    @Column(name = "Cap_2_4_5")
    @JsonProperty("Cap-2-4-5")
    private String Cap_2_4_5; // 动脉血气分析值是否在正常范围
    @Column(name = "Cap_2_4_4")
    @JsonProperty("Cap-2-4-4")
    private String Cap_2_4_4; // 指氧仪检查值(%)
    @Column(name = "Cap_2_4_6")
    @JsonProperty("Cap-2-4-6")
    private String Cap_2_4_6; // 指氧仪检查值是否在正常范围
    @Column(name = "Cap_3_1_1")
    @JsonProperty("Cap-3-1-1")
    private String Cap_3_1_1; // 是否为重症并收入ICU/RCU的患儿
    @Column(name = "Cap_3_2_1")
    @JsonProperty("Cap-3-2-1")
    private String Cap_3_2_1; // 是否入院之前已经经接受抗菌药物治疗
    @Column(name = "Cap_3_2_2")
    @JsonProperty("Cap-3-2-2")
    private String Cap_3_2_2; // 实施首次采集标本时段
    @Column(name = "Cap_3_2_3")
    @JsonProperty("Cap-3-2-3")
    private String Cap_3_2_3; // 实施首次采集什么标本
    @Column(name = "Cap_3_2_4")
    @JsonProperty("Cap-3-2-4")
    private String Cap_3_2_4; // 采集标本日期时间
    @Column(name = "Cap_3_3_1")
    @JsonProperty("Cap-3-3-1")
    private String Cap_3_3_1; // 细菌学检查项目的选择
    @Column(name = "Cap_3_3_1_1")
    @JsonProperty("Cap-3-3-1-1")
    private String Cap_3_3_1_1; // 其他细菌学检查项目
    @Column(name = "Cap_3_3_2")
    @JsonProperty("Cap-3-3-2")
    private String Cap_3_3_2; // 病毒学检查项目的选择 
    @Column(name = "Cap_3_3_2_1")
    @JsonProperty("Cap-3-3-2-1")
    private String Cap_3_3_2_1; // 其他病毒学检查项目
    @Column(name = "Cap_3_3_3")
    @JsonProperty("Cap-3-3-3")
    private String Cap_3_3_3; // 肺炎支原体检查项目的选择
    @Column(name = "Cap_3_3_3_1")
    @JsonProperty("Cap-3-3-3-1")
    private String Cap_3_3_3_1; // 其他肺炎支原体检查项目
    @Column(name = "Cap_3_4_4")
    @JsonProperty("Cap-3-4-4")
    private String Cap_3_4_4; // 是否进行实验室检查
    @Column(name = "Cap_3_4_2")
    @JsonProperty("Cap-3-4-2")
    private String Cap_3_4_2; // 临床实验室检查项目的选择 
    @Column(name = "Cap_3_4_2_1")
    @JsonProperty("Cap-3-4-2-1")
    private String Cap_3_4_2_1; // 其他临床实验室检查项目
    @Column(name = "Cap_3_5_1")
    @JsonProperty("Cap-3-5-1")
    private String Cap_3_5_1; // 病原学检测结果
    @Column(name = "Cap_3_5_1_1")
    @JsonProperty("Cap-3-5-1-1")
    private String Cap_3_5_1_1; // 其他病原学检测结果
    @Column(name = "Cap_3_5_2")
    @JsonProperty("Cap-3-5-2")
    private String Cap_3_5_2; // 获得病原学诊断报告结果的日期时间
    @Column(name = "Cap_4_0")
    @JsonProperty("Cap-4-0")
    private String Cap_4_0; // 患儿有无接受抗菌药物治疗
    @Column(name = "Cap_4_1_2")
    @JsonProperty("Cap-4-1-2")
    private String Cap_4_1_2; // 患儿入院后接受首剂抗菌药物治疗（注射剂输入/注射）时间
    @Column(name = "Cap_4_1_1_r")
    @JsonProperty("Cap-4-1-1-r")
    private String Cap_4_1_1_r; // 
    @Column(name = "Cap_4_1_3")
    @JsonProperty("Cap-4-1-3")
    private String Cap_4_1_3; // 接受入院后首剂抗菌药物使用时机 DTN
    @Column(name = "Cap_4_1_4")
    @JsonProperty("Cap-4-1-4")
    private String Cap_4_1_4; // 使用首剂抗菌药物治疗途径
    @Column(name = "Cap_4_1_5")
    @JsonProperty("Cap-4-1-5")
    private String Cap_4_1_5; // 抗菌药物注射剂输入/注射治疗终止日期与时间
    @Column(name = "Cap_4_2_1")
    @JsonProperty("Cap-4-2-1")
    private String Cap_4_2_1; // 是否抗菌药物注射剂改口服
    @Column(name = "Cap_4_2_2")
    @JsonProperty("Cap-4-2-2")
    private String Cap_4_2_2; // 抗菌药物注射剂改口服日期与时间
    @Column(name = "Cap_5_1_1")
    @JsonProperty("Cap-5-1-1")
    private String Cap_5_1_1; // 拟诊需抗感染治疗肺炎缘由
    @Column(name = "Cap_5_1_1_1")
    @JsonProperty("Cap-5-1-1-1")
    private String Cap_5_1_1_1; // 其他类型肺炎
    @Column(name = "Cap_5_1_2")
    @JsonProperty("Cap-5-1-2")
    private String Cap_5_1_2; // 是否需进行抗感染治疗
    @Column(name = "Cap_5_2_1")
    @JsonProperty("Cap-5-2-1")
    private String Cap_5_2_1; // 抗感染治疗药物选择
    @Column(name = "Cap_5_2_2")
    @JsonProperty("Cap-5-2-2")
    private String Cap_5_2_2; // 青霉素类抗感染药物
    @Column(name = "Cap_5_2_2_1")
    @JsonProperty("Cap-5-2-2-1")
    private String Cap_5_2_2_1; // 其它青霉素抗菌药
    @Column(name = "Cap_5_2_3")
    @JsonProperty("Cap-5-2-3")
    private String Cap_5_2_3; // 头孢菌素类抗感染药物
    @Column(name = "Cap_5_2_3_1")
    @JsonProperty("Cap-5-2-3-1")
    private String Cap_5_2_3_1; // 其它头孢菌素抗菌药
    @Column(name = "Cap_5_2_4")
    @JsonProperty("Cap-5-2-4")
    private String Cap_5_2_4; // 大环内酯类抗感染药物
    @Column(name = "Cap_5_2_4_1")
    @JsonProperty("Cap-5-2-4-1")
    private String Cap_5_2_4_1; // 其它大环内酯抗菌药
    @Column(name = "Cap_5_2_6")
    @JsonProperty("Cap-5-2-6")
    private String Cap_5_2_6; // 神经氨酸抑制剂
    @Column(name = "Cap_5_2_6_1")
    @JsonProperty("Cap-5-2-6-1")
    private String Cap_5_2_6_1; // 神经氨酸抑制剂
    @Column(name = "Cap_5_2_5")
    @JsonProperty("Cap-5-2-5")
    private String Cap_5_2_5; // 其他类抗感染药物
    @Column(name = "Cap_5_2_5_1")
    @JsonProperty("Cap-5-2-5-1")
    private String Cap_5_2_5_1; // 其他类抗菌药
    @Column(name = "Cap_6_1_1")
    @JsonProperty("Cap-6-1-1")
    private String Cap_6_1_1; // 初始治疗72小时后是否进行评价
    @Column(name = "Cap_6_1_2")
    @JsonProperty("Cap-6-1-2")
    private String Cap_6_1_2; // 评价结论
    @Column(name = "Cap_6_1_3")
    @JsonProperty("Cap-6-1-3")
    private String Cap_6_1_3; // 初始治疗72小时后评价有效者下一步治疗方案
    @Column(name = "Cap_6_1_4")
    @JsonProperty("Cap-6-1-4")
    private String Cap_6_1_4; // 是否进行重复病原学检查
    @Column(name = "Cap_6_1_5")
    @JsonProperty("Cap-6-1-5")
    private String Cap_6_1_5; // 初始治疗72小时后无效常见原因
    @Column(name = "Cap_6_1_5_1")
    @JsonProperty("Cap-6-1-5-1")
    private String Cap_6_1_5_1; // 其它原因
    @Column(name = "Cap_6_1_6")
    @JsonProperty("Cap-6-1-6")
    private String Cap_6_1_6; // 病原学检查项目选择
    @Column(name = "Cap_6_1_6_1")
    @JsonProperty("Cap-6-1-6-1")
    private String Cap_6_1_6_1; // 其它检查
    @Column(name = "Cap_6_1_7")
    @JsonProperty("Cap-6-1-7")
    private String Cap_6_1_7; // 重复病原学诊断结果选择
    @Column(name = "Cap_6_1_7_1")
    @JsonProperty("Cap-6-1-7-1")
    private String Cap_6_1_7_1; // 其它重复病原学诊断结果
    @Column(name = "Cap_6_1_8")
    @JsonProperty("Cap-6-1-8")
    private String Cap_6_1_8; // 获得病原学诊断报告结果的日期时间
    @Column(name = "Cap_6_2_1")
    @JsonProperty("Cap-6-2-1")
    private String Cap_6_2_1; // 病原针对性治疗情况
    @Column(name = "Cap_6_2_2")
    @JsonProperty("Cap-6-2-2")
    private String Cap_6_2_2; // 抗感染治疗药物选择
    @Column(name = "Cap_6_2_3")
    @JsonProperty("Cap-6-2-3")
    private String Cap_6_2_3; // 青霉素类抗感染药物
    @Column(name = "Cap_6_2_3_1")
    @JsonProperty("Cap-6-2-3-1")
    private String Cap_6_2_3_1; // 其它青霉素抗菌药
    @Column(name = "Cap_6_2_4")
    @JsonProperty("Cap-6-2-4")
    private String Cap_6_2_4; // 头孢菌素类抗感染药物
    @Column(name = "Cap_6_2_4_1")
    @JsonProperty("Cap-6-2-4-1")
    private String Cap_6_2_4_1; // 其它头孢菌素抗菌药
    @Column(name = "Cap_6_2_5")
    @JsonProperty("Cap-6-2-5")
    private String Cap_6_2_5; // 大环内酯类抗感染药物
    @Column(name = "Cap_6_2_5_1")
    @JsonProperty("Cap-6-2-5-1")
    private String Cap_6_2_5_1; // 其它大环内酯抗菌药
    @Column(name = "Cap_6_2_6")
    @JsonProperty("Cap-6-2-6")
    private String Cap_6_2_6; // 其他类抗感染药物
    @Column(name = "Cap_6_2_6_1")
    @JsonProperty("Cap-6-2-6-1")
    private String Cap_6_2_6_1; // 其他类抗菌药
    @Column(name = "Cap_6_2_7")
    @JsonProperty("Cap-6-2-7")
    private String Cap_6_2_7; // 神经氨酸抑制剂
    @Column(name = "Cap_6_2_7_1")
    @JsonProperty("Cap-6-2-7-1")
    private String Cap_6_2_7_1; // 神经氨酸抑制剂
    @Column(name = "Cap_7_1_1")
    @JsonProperty("Cap-7-1-1")
    private String Cap_7_1_1; // 是否使用氧疗与呼吸支持治疗
    @Column(name = "Cap_7_2_1")
    @JsonProperty("Cap-7-2-1")
    private String Cap_7_2_1; // 是否使用普通氧疗
    @Column(name = "Cap_7_2_2")
    @JsonProperty("Cap-7-2-2")
    private String Cap_7_2_2; // 普通氧疗指征
    @Column(name = "Cap_7_2_5")
    @JsonProperty("Cap-7-2-5")
    private String Cap_7_2_5; // 给予氧疗医嘱
    @Column(name = "Cap_7_2_6")
    @JsonProperty("Cap-7-2-6")
    private String Cap_7_2_6; // 普通氧疗起始日期与时间
    @Column(name = "Cap_7_2_7")
    @JsonProperty("Cap-7-2-7")
    private String Cap_7_2_7; // 普通氧疗终止日期与时间
    @Column(name = "Cap_7_2_8")
    @JsonProperty("Cap-7-2-8")
    private String Cap_7_2_8; // 使用普通氧疗治疗天数
    @Column(name = "Cap_7_3_1")
    @JsonProperty("Cap-7-3-1")
    private String Cap_7_3_1; // 是否使用无创通气
    @Column(name = "Cap_7_3_2")
    @JsonProperty("Cap-7-3-2")
    private String Cap_7_3_2; // 无创通气指征
    @Column(name = "Cap_7_3_3")
    @JsonProperty("Cap-7-3-3")
    private String Cap_7_3_3; // 无创通气治疗起始日期与时间
    @Column(name = "Cap_7_3_4")
    @JsonProperty("Cap-7-3-4")
    private String Cap_7_3_4; // 无创通气治疗终止日期与时间
    @Column(name = "Cap_7_3_5")
    @JsonProperty("Cap-7-3-5")
    private String Cap_7_3_5; // 使用无创通气治疗小时数
    @Column(name = "Cap_7_4_1")
    @JsonProperty("Cap-7-4-1")
    private String Cap_7_4_1; // 是否使用有创机械通气
    @Column(name = "Cap_7_4_2")
    @JsonProperty("Cap-7-4-2")
    private String Cap_7_4_2; // 机械通气指征
    @Column(name = "Cap_7_4_3")
    @JsonProperty("Cap-7-4-3")
    private String Cap_7_4_3; // 有创机械通气治疗起始日期与时间
    @Column(name = "Cap_7_4_4")
    @JsonProperty("Cap-7-4-4")
    private String Cap_7_4_4; // 有创机械通气治疗终止日期与时间
    @Column(name = "Cap_7_4_5")
    @JsonProperty("Cap-7-4-5")
    private String Cap_7_4_5; // 使用有创机械通气治疗小时数
    @Column(name = "Cap_7_5_1")
    @JsonProperty("Cap-7-5-1")
    private String Cap_7_5_1; // 是否使用体外膜肺
    @Column(name = "Cap_7_5_2")
    @JsonProperty("Cap-7-5-2")
    private String Cap_7_5_2; // ECMO指征
    @Column(name = "Cap_7_5_3")
    @JsonProperty("Cap-7-5-3")
    private String Cap_7_5_3; // 体外膜肺治疗起始日期与时间
    @Column(name = "Cap_7_5_4")
    @JsonProperty("Cap-7-5-4")
    private String Cap_7_5_4; // 体外膜肺治疗终止日期与时间
    @Column(name = "Cap_7_5_5")
    @JsonProperty("Cap-7-5-5")
    private String Cap_7_5_5; // 使用体外膜肺治疗小时数
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患儿/患儿家长“出院小结”的副本告知出院时风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
    @Column(name = "Cap_9_1_1_1")
    @JsonProperty("Cap-9-1-1-1")
    private String Cap_9_1_1_1; // 经有效治疗后，患儿病情明显好转,可以出院
    @Column(name = "Cap_9_1_1_2")
    @JsonProperty("Cap-9-1-1-2")
    private String Cap_9_1_1_2; // 其他出院评估
    @Column(name = "Cap_9_2_1")
    @JsonProperty("Cap-9-2-1")
    private String Cap_9_2_1; // 出院前末次氧合评估
    @Column(name = "Cap_9_2_2")
    @JsonProperty("Cap-9-2-2")
    private String Cap_9_2_2; // 末次氧合评估项目
    @Column(name = "Cap_9_2_2_1")
    @JsonProperty("Cap-9-2-2-1")
    private String Cap_9_2_2_1; // 末次检测脉搏血氧饱和度测定值(%)
    @Column(name = "Cap_9_2_2_4")
    @JsonProperty("Cap-9-2-2-4")
    private String Cap_9_2_2_4; // 末次检测脉搏血氧饱和度测定值是否在正常范围
    @Column(name = "Cap_9_2_2_2")
    @JsonProperty("Cap-9-2-2-2")
    private String Cap_9_2_2_2; // 末次检测动脉血气分析测定值mmHg(mmHg)
    @Column(name = "Cap_9_2_2_3")
    @JsonProperty("Cap-9-2-2-3")
    private String Cap_9_2_2_3; // 末次检测动脉血气分析测定值是否在正常范围
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
    private String CM_5_1; // 患儿家长对服务的体验与评价
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
    @Column(name = "Cap_11_1_1")
    @JsonProperty("Cap-11-1-1")
    private String Cap_11_1_1; // 患儿接受首剂抗菌药物治疗注射剂输入/注射日期时间
    @Column(name = "Cap_11_1_2")
    @JsonProperty("Cap-11-1-2")
    private String Cap_11_1_2; // 患儿接受未剂抗菌药物治疗注射剂输入/注射日期时间
    @Column(name = "Cap_11_1_3")
    @JsonProperty("Cap-11-1-3")
    private String Cap_11_1_3; // 注射剂输入/注射抗菌药物疗程（天数）
    @Column(name = "Cap_11_2_1")
    @JsonProperty("Cap-11-2-1")
    private String Cap_11_2_1; // 是否抗菌药物注射剂改口服
    @Column(name = "Cap_11_2_2")
    @JsonProperty("Cap-11-2-2")
    private String Cap_11_2_2; // 改用抗菌药物口服剂首剂日期与时间
    @Column(name = "Cap_11_2_3")
    @JsonProperty("Cap-11-2-3")
    private String Cap_11_2_3; // 末剂抗菌药物口服剂或出院日期与时间
    @Column(name = "Cap_11_2_4")
    @JsonProperty("Cap-11-2-4")
    private String Cap_11_2_4; // 口服剂抗菌药物疗程（天数）
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