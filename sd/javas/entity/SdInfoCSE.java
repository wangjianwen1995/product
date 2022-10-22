package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：G41.0、G41.8、G41.9 的出院患者。
*/
@ApiModel(value = "16信息")
@Entity
@Data
@Table(name = "sd_info_CSE")
public class SdInfoCSE implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    @Column(name = "CSE_0_3_4")
    @JsonProperty("CSE-0-3-4")
    private String CSE_0_3_4; // 纳入标准
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
    private String CM_0_1_3_1; // 主要诊断或其他诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断或其他诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_1_1")
    @JsonProperty("CM-0-1-4-1-1")
    private String CM_0_1_4_1_1; // 其他ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_2_1")
    @JsonProperty("CM-0-1-4-2-1")
    private String CM_0_1_4_2_1; // 其他ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // CSE出院后31天内是否重复住院
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
    @Column(name = "CSE_0_4_1")
    @JsonProperty("CSE-0-4-1")
    private String CSE_0_4_1; // 是否现场评估生命体征
    @Column(name = "CSE_0_4_2")
    @JsonProperty("CSE-0-4-2")
    private String CSE_0_4_2; // 是否现场记录发作开始时间
    @Column(name = "CSE_0_4_3")
    @JsonProperty("CSE-0-4-3")
    private String CSE_0_4_3; // 现场急救维持生命体征稳定
    @Column(name = "CSE_1_1_1")
    @JsonProperty("CSE-1-1-1")
    private String CSE_1_1_1; // 本院首诊医师接诊日期时间
    @Column(name = "CSE_1_1_2")
    @JsonProperty("CSE-1-1-2")
    private String CSE_1_1_2; // 既往诊断过癫痫
    @Column(name = "CSE_1_1_3")
    @JsonProperty("CSE-1-1-3")
    private String CSE_1_1_3; // 是否服用过抗癫痫药物
    @Column(name = "CSE_1_1_4")
    @JsonProperty("CSE-1-1-4")
    private String CSE_1_1_4; // 评估发作起始日期
    @Column(name = "CSE_1_2_1")
    @JsonProperty("CSE-1-2-1")
    private String CSE_1_2_1; // 绿色通道中观察期所采取的紧急救治措施
    @Column(name = "CSE_1_2_1_1")
    @JsonProperty("CSE-1-2-1-1")
    private String CSE_1_2_1_1; // 其它绿色通道中观察期所可采取的紧急救治措施
    @Column(name = "CSE_1_2_2")
    @JsonProperty("CSE-1-2-2")
    private String CSE_1_2_2; // 完成紧急救治措施的日期时间
    @Column(name = "CSE_1_2_3")
    @JsonProperty("CSE-1-2-3")
    private String CSE_1_2_3; // 实施严重程度STESS评估
    @Column(name = "CSE_1_2_4")
    @JsonProperty("CSE-1-2-4")
    private String CSE_1_2_4; // 完成评估日期时间
    @Column(name = "CSE_1_2_5")
    @JsonProperty("CSE-1-2-5")
    private String CSE_1_2_5; // 实施严重程度STESS评估分值
    @Column(name = "CSE_1_2_3_1")
    @JsonProperty("CSE-1-2-3-1")
    private String CSE_1_2_3_1; // 是否实施EMSE评估
    @Column(name = "CSE_1_2_3_2")
    @JsonProperty("CSE-1-2-3-2")
    private String CSE_1_2_3_2; // 完成评估日期时间
    @Column(name = "CSE_1_2_3_3")
    @JsonProperty("CSE-1-2-3-3")
    private String CSE_1_2_3_3; // 实施严重程度EMSE评估分值
    @Column(name = "CSE_1_2_6_1")
    @JsonProperty("CSE-1-2-6-1")
    private String CSE_1_2_6_1; // 呼吸(单位:次/分)
    @Column(name = "CSE_1_2_6_2")
    @JsonProperty("CSE-1-2-6-2")
    private String CSE_1_2_6_2; // 脉搏(单位:次/分)
    @Column(name = "CSE_1_2_6_3")
    @JsonProperty("CSE-1-2-6-3")
    private String CSE_1_2_6_3; // 收缩压(单位:mmHg)
    @Column(name = "CSE_1_2_6_4")
    @JsonProperty("CSE-1-2-6-4")
    private String CSE_1_2_6_4; // 舒张压(单位:mmHg)
    @Column(name = "CSE_1_2_6_5")
    @JsonProperty("CSE-1-2-6-5")
    private String CSE_1_2_6_5; // 身高(单位:厘米(cm))
    @Column(name = "CSE_1_2_6_6")
    @JsonProperty("CSE-1-2-6-6")
    private String CSE_1_2_6_6; // 体重(单位:公斤(kg))
    @Column(name = "CSE_1_2_7")
    @JsonProperty("CSE-1-2-7")
    private String CSE_1_2_7; // 是否进行血/尿药物浓度筛查
    @Column(name = "CSE_1_2_8_1")
    @JsonProperty("CSE-1-2-8-1")
    private String CSE_1_2_8_1; // 药物浓度筛查报告日期时间是否确定
    @Column(name = "CSE_1_2_8")
    @JsonProperty("CSE-1-2-8")
    private String CSE_1_2_8; // 药物浓度筛查报告日期时间
    @Column(name = "CSE_1_2_9")
    @JsonProperty("CSE-1-2-9")
    private String CSE_1_2_9; // 是否进行毒物筛查
    @Column(name = "CSE_1_2_10")
    @JsonProperty("CSE-1-2-10")
    private String CSE_1_2_10; // 是否实施首次心电图（ECG）检查
    @Column(name = "CSE_1_2_11")
    @JsonProperty("CSE-1-2-11")
    private String CSE_1_2_11; // 报告日期时间
    @Column(name = "CSE_1_2_12")
    @JsonProperty("CSE-1-2-12")
    private String CSE_1_2_12; // 心电图（ECG）检查结果选择
    @Column(name = "CSE_1_2_12_1")
    @JsonProperty("CSE-1-2-12-1")
    private String CSE_1_2_12_1; // 其他心电图（ECG）检查结果选择
    @Column(name = "CSE_2_1_1")
    @JsonProperty("CSE-2-1-1")
    private String CSE_2_1_1; // 初始治疗选择
    @Column(name = "CSE_2_1_2")
    @JsonProperty("CSE-2-1-2")
    private String CSE_2_1_2; // 有静脉通路：静脉注射地西泮
    @Column(name = "CSE_2_1_2_1")
    @JsonProperty("CSE-2-1-2-1")
    private String CSE_2_1_2_1; // 其他有静脉通路
    @Column(name = "CSE_2_1_3")
    @JsonProperty("CSE-2-1-3")
    private String CSE_2_1_3; // 静脉注射时间
    @Column(name = "CSE_2_1_4")
    @JsonProperty("CSE-2-1-4")
    private String CSE_2_1_4; // 无静脉通路:肌肉注射米达唑仑
    @Column(name = "CSE_2_1_4_1")
    @JsonProperty("CSE-2-1-4-1")
    private String CSE_2_1_4_1; // 其他无静脉通路
    @Column(name = "CSE_2_1_5")
    @JsonProperty("CSE-2-1-5")
    private String CSE_2_1_5; // 肌肉注射时间
    @Column(name = "CSE_2_2_0")
    @JsonProperty("CSE-2-2-0")
    private String CSE_2_2_0; // 是否达到终止标准
    @Column(name = "CSE_2_2_1")
    @JsonProperty("CSE-2-2-1")
    private String CSE_2_2_1; // 达到终止标准依据
    @Column(name = "CSE_2_2_2")
    @JsonProperty("CSE-2-2-2")
    private String CSE_2_2_2; // 脑电图（EEG）检查结果选择
    @Column(name = "CSE_2_2_2_1")
    @JsonProperty("CSE-2-2-2-1")
    private String CSE_2_2_2_1; // 其他脑电图（EEG）检查结果
    @Column(name = "CSE_2_2_3")
    @JsonProperty("CSE-2-2-3")
    private String CSE_2_2_3; // 治疗后发作缓解时间
    @Column(name = "CSE_2_2_4")
    @JsonProperty("CSE-2-2-4")
    private String CSE_2_2_4; // 终止发作后是否进行过渡治疗
    @Column(name = "CSE_2_2_4_1")
    @JsonProperty("CSE-2-2-4-1")
    private String CSE_2_2_4_1; // 其他终止发作后是否进行过渡治疗
    @Column(name = "CSE_3_1_1")
    @JsonProperty("CSE-3-1-1")
    private String CSE_3_1_1; // 实施初始治疗失败
    @Column(name = "CSE_3_1_2")
    @JsonProperty("CSE-3-1-2")
    private String CSE_3_1_2; // 给予第二阶段（20-40min) 静脉治疗
    @Column(name = "CSE_3_1_2_1")
    @JsonProperty("CSE-3-1-2-1")
    private String CSE_3_1_2_1; // 其他第二阶段（20-40min) 静脉治疗
    @Column(name = "CSE_3_1_3")
    @JsonProperty("CSE-3-1-3")
    private String CSE_3_1_3; // 静脉治疗时间
    @Column(name = "CSE_3_2_1")
    @JsonProperty("CSE-3-2-1")
    private String CSE_3_2_1; // 是否达到终止标准
    @Column(name = "CSE_3_2_2")
    @JsonProperty("CSE-3-2-2")
    private String CSE_3_2_2; // 脑电图（EEG）检查结果选择
    @Column(name = "CSE_3_2_2_1")
    @JsonProperty("CSE-3-2-2-1")
    private String CSE_3_2_2_1; // 其他脑电图（EEG）检查结果
    @Column(name = "CSE_3_2_3")
    @JsonProperty("CSE-3-2-3")
    private String CSE_3_2_3; // 治疗后发作缓解时间
    @Column(name = "CSE_3_2_4")
    @JsonProperty("CSE-3-2-4")
    private String CSE_3_2_4; // 终止发作后是否进行过渡治疗
    @Column(name = "CSE_3_2_4_1")
    @JsonProperty("CSE-3-2-4-1")
    private String CSE_3_2_4_1; // 其他终止发作后是否进行过渡治疗
    @Column(name = "CSE_4_1_1")
    @JsonProperty("CSE-4-1-1")
    private String CSE_4_1_1; // 第二阶段静脉治疗失败
    @Column(name = "CSE_4_1_2")
    @JsonProperty("CSE-4-1-2")
    private String CSE_4_1_2; // 给予第三阶段（40-60min) 治疗
    @Column(name = "CSE_4_1_2_1")
    @JsonProperty("CSE-4-1-2-1")
    private String CSE_4_1_2_1; // 其他第三阶段（40-60min) 治疗
    @Column(name = "CSE_4_1_3")
    @JsonProperty("CSE-4-1-3")
    private String CSE_4_1_3; // super-RSE治疗
    @Column(name = "CSE_4_1_3_2")
    @JsonProperty("CSE-4-1-3-2")
    private String CSE_4_1_3_2; // 外科手术
    @Column(name = "CSE_4_1_3_1")
    @JsonProperty("CSE-4-1-3-1")
    private String CSE_4_1_3_1; // 其他super-RSE治疗
    @Column(name = "CSE_4_1_4")
    @JsonProperty("CSE-4-1-4")
    private String CSE_4_1_4; // 进入难治性癫痫持续状态RSE治疗时间
    @Column(name = "CSE_4_2_1")
    @JsonProperty("CSE-4-2-1")
    private String CSE_4_2_1; // 是否达到终止标准
    @Column(name = "CSE_4_2_2")
    @JsonProperty("CSE-4-2-2")
    private String CSE_4_2_2; // 脑电图（EEG）检查结果选择
    @Column(name = "CSE_4_2_2_1")
    @JsonProperty("CSE-4-2-2-1")
    private String CSE_4_2_2_1; // 其他脑电图（EEG）检查结果
    @Column(name = "CSE_4_2_3")
    @JsonProperty("CSE-4-2-3")
    private String CSE_4_2_3; // 治疗后发作缓解时间
    @Column(name = "CSE_4_2_4")
    @JsonProperty("CSE-4-2-4")
    private String CSE_4_2_4; // RSE终止发作后是否进行过渡治疗
    @Column(name = "CSE_4_2_4_1")
    @JsonProperty("CSE-4-2-4-1")
    private String CSE_4_2_4_1; // 其他RSE终止发作后是否进行过渡治疗
    @Column(name = "CSE_5_1_1")
    @JsonProperty("CSE-5-1-1")
    private String CSE_5_1_1; // 是否进入ICU提供相应生命支持
    @Column(name = "CSE_5_1_2")
    @JsonProperty("CSE-5-1-2")
    private String CSE_5_1_2; // 入住ICU日期时间
    @Column(name = "CSE_5_1_3")
    @JsonProperty("CSE-5-1-3")
    private String CSE_5_1_3; // 提供相应生命支持
    @Column(name = "CSE_5_1_3_1")
    @JsonProperty("CSE-5-1-3-1")
    private String CSE_5_1_3_1; // 其他提供相应生命支持
    @Column(name = "CSE_5_2_1")
    @JsonProperty("CSE-5-2-1")
    private String CSE_5_2_1; // 是否实施无创正压通气（NIPPV）
    @Column(name = "CSE_5_2_2")
    @JsonProperty("CSE-5-2-2")
    private String CSE_5_2_2; // 患者无创正压通气起始日期时间
    @Column(name = "CSE_5_2_3")
    @JsonProperty("CSE-5-2-3")
    private String CSE_5_2_3; // 患者无创正压通气终止日期时间
    @Column(name = "CSE_5_2_4")
    @JsonProperty("CSE-5-2-4")
    private String CSE_5_2_4; // 无创正压通气疗程（天数）
    @Column(name = "CSE_5_3_1")
    @JsonProperty("CSE-5-3-1")
    private String CSE_5_3_1; // 是否实施有创机械通气
    @Column(name = "CSE_5_3_2")
    @JsonProperty("CSE-5-3-2")
    private String CSE_5_3_2; // 患者有机械通气起始日期时间
    @Column(name = "CSE_5_3_3")
    @JsonProperty("CSE-5-3-3")
    private String CSE_5_3_3; // 患者有机械通气终止日期时间
    @Column(name = "CSE_5_3_4")
    @JsonProperty("CSE-5-3-4")
    private String CSE_5_3_4; // 有机械通气疗程（天数）
    @Column(name = "CSE_6_1_1")
    @JsonProperty("CSE-6-1-1")
    private String CSE_6_1_1; // 是否实施首次头部影像学检查
    @Column(name = "CSE_6_1_4")
    @JsonProperty("CSE-6-1-4")
    private String CSE_6_1_4; // 头部影像学检查项目
    @Column(name = "CSE_6_1_3")
    @JsonProperty("CSE-6-1-3")
    private String CSE_6_1_3; // 报告日期时间
    @Column(name = "CSE_6_2_1")
    @JsonProperty("CSE-6-2-1")
    private String CSE_6_2_1; // 实施首次脑脊液检查
    @Column(name = "CSE_6_2_2")
    @JsonProperty("CSE-6-2-2")
    private String CSE_6_2_2; // 脑脊液检查项目
    @Column(name = "CSE_6_2_3")
    @JsonProperty("CSE-6-2-3")
    private String CSE_6_2_3; // 报告日期时间
    @Column(name = "CSE_6_3_1")
    @JsonProperty("CSE-6-3-1")
    private String CSE_6_3_1; // 既往是否诊断癫痫
    @Column(name = "CSE_6_3_6")
    @JsonProperty("CSE-6-3-6")
    private String CSE_6_3_6; // 近期发作情况为
    @Column(name = "CSE_6_3_7")
    @JsonProperty("CSE-6-3-7")
    private String CSE_6_3_7; // 具体发作频率为
    @Column(name = "CSE_6_3_3")
    @JsonProperty("CSE-6-3-3")
    private String CSE_6_3_3; // 发作是否为局灶起源
    @Column(name = "CSE_6_3_4")
    @JsonProperty("CSE-6-3-4")
    private String CSE_6_3_4; // 发作是否伴知觉障碍
    @Column(name = "CSE_6_3_5")
    @JsonProperty("CSE-6-3-5")
    private String CSE_6_3_5; // 发作是否以运动症状起病
    @Column(name = "CSE_6_3_8")
    @JsonProperty("CSE-6-3-8")
    private String CSE_6_3_8; // 发作是否为全面起源
    @Column(name = "CSE_6_3_9")
    @JsonProperty("CSE-6-3-9")
    private String CSE_6_3_9; // 发作包含何种表现
    @Column(name = "CSE_6_3_10")
    @JsonProperty("CSE-6-3-10")
    private String CSE_6_3_10; // 发作是否为未知起源（指发作起源被错过或掩盖）
    @Column(name = "CSE_6_3_11")
    @JsonProperty("CSE-6-3-11")
    private String CSE_6_3_11; // 是否为不能分类的癫痫发作（根据现有信息无法分类的发作）
    @Column(name = "CSE_6_3_12")
    @JsonProperty("CSE-6-3-12")
    private String CSE_6_3_12; // 是否服用过抗癫痫药物
    @Column(name = "CSE_6_3_2")
    @JsonProperty("CSE-6-3-2")
    private String CSE_6_3_2; // 首次使用抗癫痫药物日期
    @Column(name = "CSE_6_3_13")
    @JsonProperty("CSE-6-3-13")
    private String CSE_6_3_13; // 使用的抗癫痫药物种类
    @Column(name = "CSE_6_3_13_1")
    @JsonProperty("CSE-6-3-13-1")
    private String CSE_6_3_13_1; // 其他抗癫痫药物种类
    @Column(name = "CSE_6_3_14")
    @JsonProperty("CSE-6-3-14")
    private String CSE_6_3_14; // 是否目前正在使用此药，并且已连续规律使用三个月及以上
    @Column(name = "CSE_6_3_15")
    @JsonProperty("CSE-6-3-15")
    private String CSE_6_3_15; // 既往或者现在使用此药期间是否有严重不良事件
    @Column(name = "CSE_7_1_0")
    @JsonProperty("CSE-7-1-0")
    private String CSE_7_1_0; // 是否入院时进行重点护理评估且有记录
    @Column(name = "CSE_7_1_1")
    @JsonProperty("CSE-7-1-1")
    private String CSE_7_1_1; // 行走评估结果
    @Column(name = "CSE_7_1_2")
    @JsonProperty("CSE-7-1-2")
    private String CSE_7_1_2; // 呼吸评估结果
    @Column(name = "CSE_7_1_3")
    @JsonProperty("CSE-7-1-3")
    private String CSE_7_1_3; // 饮食评估结果
    @Column(name = "CSE_7_1_4")
    @JsonProperty("CSE-7-1-4")
    private String CSE_7_1_4; // 吞咽评估结果
    @Column(name = "CSE_7_1_5_0")
    @JsonProperty("CSE-7-1-5-0")
    private String CSE_7_1_5_0; // 压疮评估（Braden评分值）分值
    @Column(name = "CSE_7_1_5")
    @JsonProperty("CSE-7-1-5")
    private String CSE_7_1_5; // 压疮评估（Braden评分值）分值
    @Column(name = "CSE_7_1_5_1")
    @JsonProperty("CSE-7-1-5-1")
    private String CSE_7_1_5_1; // 压疮评估结果选择
    @Column(name = "CSE_7_1_5_2")
    @JsonProperty("CSE-7-1-5-2")
    private String CSE_7_1_5_2; // 预防压疮告知
    @Column(name = "CSE_7_1_6")
    @JsonProperty("CSE-7-1-6")
    private String CSE_7_1_6; // 实施癫痫持续状态健康教育有记录
    @Column(name = "CSE_7_2_1")
    @JsonProperty("CSE-7-2-1")
    private String CSE_7_2_1; // 出院时是否进行STESS评分
    @Column(name = "CSE_7_2_1_1")
    @JsonProperty("CSE-7-2-1-1")
    private String CSE_7_2_1_1; // STESS评分值
    @Column(name = "CSE_7_2_2_1")
    @JsonProperty("CSE-7-2-2-1")
    private String CSE_7_2_2_1; // 交与患者“出院小结”的副本，并告知患者出院时风险因素
    @Column(name = "CSE_7_2_2_2")
    @JsonProperty("CSE-7-2-2-2")
    private String CSE_7_2_2_2; // 出院带药
    @Column(name = "CSE_7_2_2_3")
    @JsonProperty("CSE-7-2-2-3")
    private String CSE_7_2_2_3; // 告知发生紧急情况时求援救治途径
    @Column(name = "CSE_7_2_2_4")
    @JsonProperty("CSE-7-2-2-4")
    private String CSE_7_2_2_4; // 出院时教育与随访
    @Column(name = "CSE_7_2_2_5")
    @JsonProperty("CSE-7-2-2-5")
    private String CSE_7_2_2_5; // 告知何为风险因素与紧急情况
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