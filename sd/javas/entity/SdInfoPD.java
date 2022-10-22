package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：G20.x00 的出院患者。
*/
@ApiModel(value = "17信息")
@Entity
@Data
@Table(name = "sd_info_PD")
public class SdInfoPD implements Serializable {
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
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "PD_0_1_4_1")
    @JsonProperty("PD-0-1-4-1")
    private String PD_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "PD_0_1_4_2")
    @JsonProperty("PD-0-1-4-2")
    private String PD_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
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
    @Column(name = "PD_1_1_1")
    @JsonProperty("PD-1-1-1")
    private String PD_1_1_1; // 绝对排除标准
    @Column(name = "PD_1_2_1")
    @JsonProperty("PD-1-2-1")
    private String PD_1_2_1; // 是否在发病 5 年内出现快速进展的步态障碍，且需要规律使用轮椅
    @Column(name = "PD_1_2_2")
    @JsonProperty("PD-1-2-2")
    private String PD_1_2_2; // 是否发病 5 年或 5 年以上，运动症状或体征完全没有进展；除非这种稳定是与治疗相关的
    @Column(name = "PD_1_2_3")
    @JsonProperty("PD-1-2-3")
    private String PD_1_2_3; // 是否早期出现的球部功能障碍：发病 5 年内出现的严重的发音困难或构音障碍（大部分时候言语难以理解）或严重的吞咽困难（需要进食较软的食物，或鼻胃管、胃造瘘进食）
    @Column(name = "PD_1_2_4")
    @JsonProperty("PD-1-2-4")
    private String PD_1_2_4; // 是否有吸气性呼吸功能障碍：出现白天或夜间吸气性喘鸣或者频繁的吸气性叹息
    @Column(name = "PD_1_2_5")
    @JsonProperty("PD-1-2-5")
    private String PD_1_2_5; // 是否在发病 5 年内出现严重的自主神经功能障碍
    @Column(name = "PD_1_2_5_1")
    @JsonProperty("PD-1-2-5-1")
    private String PD_1_2_5_1; // 出现严重的自主神经功能障碍具体表现为
    @Column(name = "PD_1_2_6")
    @JsonProperty("PD-1-2-6")
    private String PD_1_2_6; // 是否在发病 3 年内由于平衡损害导致的反复（>1 次 / 年）摔倒
    @Column(name = "PD_1_2_7")
    @JsonProperty("PD-1-2-7")
    private String PD_1_2_7; // 是否在发病 10 年内出现不成比例地颈部前倾（肌张力障碍）或手足挛缩
    @Column(name = "PD_1_2_8")
    @JsonProperty("PD-1-2-8")
    private String PD_1_2_8; // 是否是病程到了 5 年也不出现任何一种常见的非运动症状，包括睡眠障碍（保持睡眠障碍性失眠、日间过度嗜睡、快速眼动期睡眠行为障碍），自主神经功能障碍（便秘、日间尿急、症状性体位性低血压）、嗅觉减退、精神障碍（抑郁、焦虑、或幻觉）
    @Column(name = "PD_1_2_9")
    @JsonProperty("PD-1-2-9")
    private String PD_1_2_9; // 是否有其他原因不能解释的锥体束征，定义为锥体束性肢体无力或明确的病理性反射活跃（包括轻度的反射不对称以及孤立性的跖趾反应）
    @Column(name = "PD_1_2_10")
    @JsonProperty("PD-1-2-10")
    private String PD_1_2_10; // 是否是双侧对称性的帕金森综合征。患者或看护者报告为双侧起病，没有任何侧别优势，且客观体格检查也没有观察到明显的侧别性
    @Column(name = "PD_1_3_1")
    @JsonProperty("PD-1-3-1")
    private String PD_1_3_1; // 是否对多巴胺药物治疗具有明确且显著的有效应答
    @Column(name = "PD_1_3_1_1")
    @JsonProperty("PD-1-3-1-1")
    private String PD_1_3_1_1; // 初始治疗显著应答表现为
    @Column(name = "PD_1_3_2")
    @JsonProperty("PD-1-3-2")
    private String PD_1_3_2; // 是否出现左旋多巴诱导的异动症
    @Column(name = "PD_1_3_3")
    @JsonProperty("PD-1-3-3")
    private String PD_1_3_3; // 临床体格检查记录的单个肢体静止性震颤（既往或本次检查）
    @Column(name = "PD_1_3_4")
    @JsonProperty("PD-1-3-4")
    private String PD_1_3_4; // 存在嗅觉丧失或心脏 MIBG 闪烁显像法显示存在心脏去交感神经支配
    @Column(name = "PD_1_4_1")
    @JsonProperty("PD-1-4-1")
    private String PD_1_4_1; // 帕金森病标准选择
    @Column(name = "PD_1_4_2")
    @JsonProperty("PD-1-4-2")
    private String PD_1_4_2; // 患者确诊帕金森病（PD）的主要依据
    @Column(name = "PD_1_4_3")
    @JsonProperty("PD-1-4-3")
    private String PD_1_4_3; // 患者诊断为可能帕金森病（PD）的主要依据
    @Column(name = "PD_2_1_1")
    @JsonProperty("PD-2-1-1")
    private String PD_2_1_1; // 是否实施头部MRI检查
    @Column(name = "PD_2_1_2")
    @JsonProperty("PD-2-1-2")
    private String PD_2_1_2; // 完成MRI序列
    @Column(name = "PD_2_1_3")
    @JsonProperty("PD-2-1-3")
    private String PD_2_1_3; // 是否实施头部CT检查
    @Column(name = "PD_2_1_4")
    @JsonProperty("PD-2-1-4")
    private String PD_2_1_4; // 报告日期时间
    @Column(name = "PD_2_2_1")
    @JsonProperty("PD-2-2-1")
    private String PD_2_2_1; // 是否实施黑质超声检查
    @Column(name = "PD_2_2_2")
    @JsonProperty("PD-2-2-2")
    private String PD_2_2_2; // 报告日期时间
    @Column(name = "PD_2_3_1")
    @JsonProperty("PD-2-3-1")
    private String PD_2_3_1; // 是否实施震颤分析检查
    @Column(name = "PD_2_3_2")
    @JsonProperty("PD-2-3-2")
    private String PD_2_3_2; // 报告日期时间
    @Column(name = "PD_2_4_1")
    @JsonProperty("PD-2-4-1")
    private String PD_2_4_1; // 是否实施肛门括约肌肌电图检查
    @Column(name = "PD_2_4_2")
    @JsonProperty("PD-2-4-2")
    private String PD_2_4_2; // 报告日期时间
    @Column(name = "PD_2_5_1")
    @JsonProperty("PD-2-5-1")
    private String PD_2_5_1; // 是否实施头PET检查
    @Column(name = "PD_2_5_2")
    @JsonProperty("PD-2-5-2")
    private String PD_2_5_2; // 完成头PET项目
    @Column(name = "PD_2_5_2_1")
    @JsonProperty("PD-2-5-2-1")
    private String PD_2_5_2_1; // 其他头PET项目
    @Column(name = "PD_2_5_3")
    @JsonProperty("PD-2-5-3")
    private String PD_2_5_3; // 报告日期时间
    @Column(name = "PD_3_1_1")
    @JsonProperty("PD-3-1-1")
    private String PD_3_1_1; // 是否进行多巴胺能反应性评测
    @Column(name = "PD_3_1_2")
    @JsonProperty("PD-3-1-2")
    private String PD_3_1_2; // 评测适应证的选择
    @Column(name = "PD_3_2_1")
    @JsonProperty("PD-3-2-1")
    private String PD_3_2_1; // 是否有被选择评测药物的禁忌证
    @Column(name = "PD_3_2_2")
    @JsonProperty("PD-3-2-2")
    private String PD_3_2_2; // 评测药物的禁忌证
    @Column(name = "PD_3_2_2_1")
    @JsonProperty("PD-3-2-2-1")
    private String PD_3_2_2_1; // 多巴丝肼片（美多芭）禁忌证的选择
    @Column(name = "PD_3_2_2_2")
    @JsonProperty("PD-3-2-2-2")
    private String PD_3_2_2_2; // 其他多巴丝肼片（美多芭）禁忌证
    @Column(name = "PD_3_2_2_3")
    @JsonProperty("PD-3-2-2-3")
    private String PD_3_2_2_3; // 卡左双多巴（息宁）禁忌证的选择
    @Column(name = "PD_3_2_2_4")
    @JsonProperty("PD-3-2-2-4")
    private String PD_3_2_2_4; // 其他卡左双多巴（息宁）禁忌证
    @Column(name = "PD_3_2_3")
    @JsonProperty("PD-3-2-3")
    private String PD_3_2_3; // 盐酸苯海索（安坦）禁忌证的选择
    @Column(name = "PD_3_2_3_1")
    @JsonProperty("PD-3-2-3-1")
    private String PD_3_2_3_1; // 其他盐酸苯海索（安坦）禁忌证
    @Column(name = "PD_3_2_4")
    @JsonProperty("PD-3-2-4")
    private String PD_3_2_4; // 盐酸阿罗洛尔（阿尔马尔）禁忌证的选择
    @Column(name = "PD_3_2_4_1")
    @JsonProperty("PD-3-2-4-1")
    private String PD_3_2_4_1; // 其他盐酸阿罗洛尔（阿尔马尔）禁忌证
    @Column(name = "PD_3_2_5")
    @JsonProperty("PD-3-2-5")
    private String PD_3_2_5; // 盐酸普拉克索（森福罗）禁忌证的选择
    @Column(name = "PD_3_2_5_1")
    @JsonProperty("PD-3-2-5-1")
    private String PD_3_2_5_1; // 其他盐酸普拉克索（森福罗）禁忌证
    @Column(name = "PD_3_2_6")
    @JsonProperty("PD-3-2-6")
    private String PD_3_2_6; // 盐酸金刚烷胺禁忌证的选择
    @Column(name = "PD_3_2_6_1")
    @JsonProperty("PD-3-2-6-1")
    private String PD_3_2_6_1; // 其他盐酸金刚烷胺禁忌证
    @Column(name = "PD_3_2_7")
    @JsonProperty("PD-3-2-7")
    private String PD_3_2_7; // 恩他卡朋禁忌证的选择
    @Column(name = "PD_3_2_7_1")
    @JsonProperty("PD-3-2-7-1")
    private String PD_3_2_7_1; // 其他恩他卡朋禁忌证
    @Column(name = "PD_3_2_8")
    @JsonProperty("PD-3-2-8")
    private String PD_3_2_8; // 雷沙吉兰禁忌证的选择
    @Column(name = "PD_3_2_8_1")
    @JsonProperty("PD-3-2-8-1")
    private String PD_3_2_8_1; // 其他雷沙吉兰禁忌证
    @Column(name = "PD_3_2_9")
    @JsonProperty("PD-3-2-9")
    private String PD_3_2_9; // 盐酸罗匹尼罗禁忌证的选择
    @Column(name = "PD_3_2_9_1")
    @JsonProperty("PD-3-2-9-1")
    private String PD_3_2_9_1; // 其他盐酸罗匹尼罗禁忌证
    @Column(name = "PD_3_2_10")
    @JsonProperty("PD-3-2-10")
    private String PD_3_2_10; // 司来吉兰禁忌证的选择
    @Column(name = "PD_3_2_10_1")
    @JsonProperty("PD-3-2-10-1")
    private String PD_3_2_10_1; // 其他司来吉兰禁忌证
    @Column(name = "PD_3_3_1_3")
    @JsonProperty("PD-3-3-1-3")
    private String PD_3_3_1_3; // 运动检查 
    @Column(name = "PD_3_3_1_1")
    @JsonProperty("PD-3-3-1-1")
    private String PD_3_3_1_1; // 基线值（关期)
    @Column(name = "PD_3_3_1_2")
    @JsonProperty("PD-3-3-1-2")
    private String PD_3_3_1_2; // 最佳改善值（开期）
    @Column(name = "PD_3_4_1")
    @JsonProperty("PD-3-4-1")
    private String PD_3_4_1; // 疗效反应结论的选择
    @Column(name = "PD_3_5_1")
    @JsonProperty("PD-3-5-1")
    private String PD_3_5_1; // 不良反应风险的选择
    @Column(name = "PD_3_6_1")
    @JsonProperty("PD-3-6-1")
    private String PD_3_6_1; // 完成日期时间
    @Column(name = "PD_4_1_1")
    @JsonProperty("PD-4-1-1")
    private String PD_4_1_1; // 是否在入院24小时进行帕金森病Hoehn-Yahr分期评估
    @Column(name = "PD_4_1_2")
    @JsonProperty("PD-4-1-2")
    private String PD_4_1_2; // 临床分期依据一:  主要有那些临床表现及体征
    @Column(name = "PD_4_1_3")
    @JsonProperty("PD-4-1-3")
    private String PD_4_1_3; // H-Y分期结论
    @Column(name = "PD_4_1_4")
    @JsonProperty("PD-4-1-4")
    private String PD_4_1_4; // 完成日期时间
    @Column(name = "PD_5_1_1")
    @JsonProperty("PD-5-1-1")
    private String PD_5_1_1; // 是否进行神经功能缺损评估
    @Column(name = "PD_5_1_2")
    @JsonProperty("PD-5-1-2")
    private String PD_5_1_2; // 第一部分：日常生活非运动症状体验 
    @Column(name = "PD_5_1_3")
    @JsonProperty("PD-5-1-3")
    private String PD_5_1_3; // 第二部分：日常生活运动症状体验
    @Column(name = "PD_5_1_4")
    @JsonProperty("PD-5-1-4")
    private String PD_5_1_4; // 第三部分：运动功能检查
    @Column(name = "PD_5_1_5")
    @JsonProperty("PD-5-1-5")
    private String PD_5_1_5; // 第四部分：运动并发症
    @Column(name = "PD_5_1_6")
    @JsonProperty("PD-5-1-6")
    private String PD_5_1_6; // 日常分值合计
    @Column(name = "PD_5_1_7")
    @JsonProperty("PD-5-1-7")
    private String PD_5_1_7; // 完成日期时间
    @Column(name = "PD_6_1_1")
    @JsonProperty("PD-6-1-1")
    private String PD_6_1_1; // 运动并发症类型
    @Column(name = "PD_6_1_2")
    @JsonProperty("PD-6-1-2")
    private String PD_6_1_2; // 剂末现象的筛查
    @Column(name = "PD_6_1_2_1")
    @JsonProperty("PD-6-1-2-1")
    private String PD_6_1_2_1; // 其他剂末现象
    @Column(name = "PD_6_1_3")
    @JsonProperty("PD-6-1-3")
    private String PD_6_1_3; // 剂末现象的处理
    @Column(name = "PD_6_1_3_1")
    @JsonProperty("PD-6-1-3-1")
    private String PD_6_1_3_1; // 其他剂末现象处理
    @Column(name = "PD_6_1_4")
    @JsonProperty("PD-6-1-4")
    private String PD_6_1_4; // 异动症类型
    @Column(name = "PD_6_1_4_1")
    @JsonProperty("PD-6-1-4-1")
    private String PD_6_1_4_1; // 剂峰异动症处理
    @Column(name = "PD_6_1_4_1_1")
    @JsonProperty("PD-6-1-4-1-1")
    private String PD_6_1_4_1_1; // 其他剂峰异动处理
    @Column(name = "PD_6_1_4_2")
    @JsonProperty("PD-6-1-4-2")
    private String PD_6_1_4_2; // 剂末异动症处理
    @Column(name = "PD_6_1_4_2_1")
    @JsonProperty("PD-6-1-4-2-1")
    private String PD_6_1_4_2_1; // 其他剂末异动处理
    @Column(name = "PD_6_1_4_3")
    @JsonProperty("PD-6-1-4-3")
    private String PD_6_1_4_3; // 双相异动症处理
    @Column(name = "PD_6_1_4_3_1")
    @JsonProperty("PD-6-1-4-3-1")
    private String PD_6_1_4_3_1; // 其他双相异动处理
    @Column(name = "PD_6_1_5")
    @JsonProperty("PD-6-1-5")
    private String PD_6_1_5; // 筛查完成日期时间
    @Column(name = "PD_6_2_1")
    @JsonProperty("PD-6-2-1")
    private String PD_6_2_1; // 是否实施筛查认知功能障碍评估
    @Column(name = "PD_6_2_2")
    @JsonProperty("PD-6-2-2")
    private String PD_6_2_2; // 进行认知功能筛查类型的选择
    @Column(name = "PD_6_2_3_1")
    @JsonProperty("PD-6-2-3-1")
    private String PD_6_2_3_1; // 定向力筛查结果
    @Column(name = "PD_6_2_3_2")
    @JsonProperty("PD-6-2-3-2")
    private String PD_6_2_3_2; // 记忆力筛查结果
    @Column(name = "PD_6_2_3_3")
    @JsonProperty("PD-6-2-3-3")
    private String PD_6_2_3_3; // 注意力和计算力筛查结果
    @Column(name = "PD_6_2_3_4")
    @JsonProperty("PD-6-2-3-4")
    private String PD_6_2_3_4; // 回忆能力筛查结果
    @Column(name = "PD_6_2_3_5")
    @JsonProperty("PD-6-2-3-5")
    private String PD_6_2_3_5; // 语言能力筛查结果
    @Column(name = "PD_6_2_3")
    @JsonProperty("PD-6-2-3")
    private String PD_6_2_3; // 入院1周完成筛查认知功能障碍（MMSE）评估分值
    @Column(name = "PD_6_2_4")
    @JsonProperty("PD-6-2-4")
    private String PD_6_2_4; // 痴呆严重程度分级
    @Column(name = "PD_6_2_5")
    @JsonProperty("PD-6-2-5")
    private String PD_6_2_5; // 认知功能障碍类型
    @Column(name = "PD_6_2_6")
    @JsonProperty("PD-6-2-6")
    private String PD_6_2_6; // 完成日期时间
    @Column(name = "PD_6_2_2_1")
    @JsonProperty("PD-6-2-2-1")
    private String PD_6_2_2_1; // 其他进行认知功能筛查类型
    @Column(name = "PD_6_2_7")
    @JsonProperty("PD-6-2-7")
    private String PD_6_2_7; // Moca量表评分值
    @Column(name = "PD_6_2_8")
    @JsonProperty("PD-6-2-8")
    private String PD_6_2_8; // 痴呆严重程度分层
    @Column(name = "PD_6_2_9")
    @JsonProperty("PD-6-2-9")
    private String PD_6_2_9; // 是否实施认知功能障碍治疗
    @Column(name = "PD_6_2_10")
    @JsonProperty("PD-6-2-10")
    private String PD_6_2_10; // 认知功能障碍治疗措施的选择
    @Column(name = "PD_6_2_10_1")
    @JsonProperty("PD-6-2-10-1")
    private String PD_6_2_10_1; // 其他认知功能障碍治疗措施
    @Column(name = "PD_6_2_11")
    @JsonProperty("PD-6-2-11")
    private String PD_6_2_11; // 治疗医嘱执行日期时间
    @Column(name = "PD_6_3_1")
    @JsonProperty("PD-6-3-1")
    private String PD_6_3_1; // 是否实施心理状况的筛查
    @Column(name = "PD_6_3_2")
    @JsonProperty("PD-6-3-2")
    private String PD_6_3_2; // 进行心理状况筛查的项目
    @Column(name = "PD_6_3_3")
    @JsonProperty("PD-6-3-3")
    private String PD_6_3_3; // 完成日期时间
    @Column(name = "PD_6_4_1")
    @JsonProperty("PD-6-4-1")
    private String PD_6_4_1; // 是否实施睡眠状况的筛查
    @Column(name = "PD_6_4_2")
    @JsonProperty("PD-6-4-2")
    private String PD_6_4_2; // 进行睡眠状况筛查的项目
    @Column(name = "PD_6_4_2_1")
    @JsonProperty("PD-6-4-2-1")
    private String PD_6_4_2_1; // 其他睡眠状况筛查的项目
    @Column(name = "PD_6_4_3")
    @JsonProperty("PD-6-4-3")
    private String PD_6_4_3; // 完成日期时间
    @Column(name = "PD_6_5_1")
    @JsonProperty("PD-6-5-1")
    private String PD_6_5_1; // 入院查体时是否实施卧立位血压的检测
    @Column(name = "PD_6_5_2_1")
    @JsonProperty("PD-6-5-2-1")
    private String PD_6_5_2_1; // 卧位血压-收缩压(mmHg)
    @Column(name = "PD_6_5_2_2")
    @JsonProperty("PD-6-5-2-2")
    private String PD_6_5_2_2; // 卧位血压-舒张压(mmHg)
    @Column(name = "PD_6_5_3_1")
    @JsonProperty("PD-6-5-3-1")
    private String PD_6_5_3_1; // 立位即刻血压-收缩压(mmHg)
    @Column(name = "PD_6_5_3_2")
    @JsonProperty("PD-6-5-3-2")
    private String PD_6_5_3_2; // 立位即刻血压-舒张压(mmHg)
    @Column(name = "PD_6_5_4_1")
    @JsonProperty("PD-6-5-4-1")
    private String PD_6_5_4_1; // 立位1min血压-收缩压(mmHg)
    @Column(name = "PD_6_5_4_2")
    @JsonProperty("PD-6-5-4-2")
    private String PD_6_5_4_2; // 立位1min血压-舒张压(mmHg)
    @Column(name = "PD_6_5_5_1")
    @JsonProperty("PD-6-5-5-1")
    private String PD_6_5_5_1; // 立位3min血压-收缩压(mmHg)
    @Column(name = "PD_6_5_5_2")
    @JsonProperty("PD-6-5-5-2")
    private String PD_6_5_5_2; // 立位3min血压-舒张压(mmHg)
    @Column(name = "PD_6_5_6_1")
    @JsonProperty("PD-6-5-6-1")
    private String PD_6_5_6_1; // 立位大于3min血压-收缩压(mmHg)
    @Column(name = "PD_6_5_6_2")
    @JsonProperty("PD-6-5-6-2")
    private String PD_6_5_6_2; // 立位大于3min血压-舒张压(mmHg)
    @Column(name = "PD_6_5_7")
    @JsonProperty("PD-6-5-7")
    private String PD_6_5_7; // 完成日期时间
    @Column(name = "PD_6_5_8")
    @JsonProperty("PD-6-5-8")
    private String PD_6_5_8; // 告知患者,体位性低血压干预措施有记录
    @Column(name = "PD_6_5_8_1")
    @JsonProperty("PD-6-5-8-1")
    private String PD_6_5_8_1; // 其他体位性低血压干预措施记录
    @Column(name = "PD_7_1_1")
    @JsonProperty("PD-7-1-1")
    private String PD_7_1_1; // 是否为合并运动并发症的患者
    @Column(name = "PD_7_1_2_1")
    @JsonProperty("PD-7-1-2-1")
    private String PD_7_1_2_1; // 是否为原发性PD
    @Column(name = "PD_7_1_2_2")
    @JsonProperty("PD-7-1-2-2")
    private String PD_7_1_2_2; // 优化药物治疗后，仍存在下列情况之一者
    @Column(name = "PD_7_1_2_3")
    @JsonProperty("PD-7-1-2-3")
    private String PD_7_1_2_3; // 急性左旋多巴药物反应良好，存在下列情况之一者
    @Column(name = "PD_7_1_2_4")
    @JsonProperty("PD-7-1-2-4")
    private String PD_7_1_2_4; // 病程
    @Column(name = "PD_7_1_2_5")
    @JsonProperty("PD-7-1-2-5")
    private String PD_7_1_2_5; // 年龄：符合一条
    @Column(name = "PD_7_1_3")
    @JsonProperty("PD-7-1-3")
    private String PD_7_1_3; // 手术禁忌证的选择
    @Column(name = "PD_7_1_4")
    @JsonProperty("PD-7-1-4")
    private String PD_7_1_4; // 完成日期时间
    @Column(name = "PD_7_2_1")
    @JsonProperty("PD-7-2-1")
    private String PD_7_2_1; // 是否进行脑深部电刺激手术（DBS）
    @Column(name = "PD_7_2_2")
    @JsonProperty("PD-7-2-2")
    private String PD_7_2_2; // 实施脑深部电刺激手术（DBS）的ICD-9-CM-3四位亚目编码及名称的选择
    @Column(name = "PD_7_2_2_1")
    @JsonProperty("PD-7-2-2-1")
    private String PD_7_2_2_1; // 实施脑深部电刺激其他手术
    @Column(name = "PD_7_2_3")
    @JsonProperty("PD-7-2-3")
    private String PD_7_2_3; // DBS手术完成日期
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
    private String CM_2_3_2; // 手术患者手术后肺栓塞例数
    @Column(name = "CM_2_3_3")
    @JsonProperty("CM-2-3-3")
    private String CM_2_3_3; // 手术患者手术后深静脉血栓例数
    @Column(name = "CM_2_3_4")
    @JsonProperty("CM-2-3-4")
    private String CM_2_3_4; // 手术患者手术后败血症例数
    @Column(name = "CM_2_3_5")
    @JsonProperty("CM-2-3-5")
    private String CM_2_3_5; // 手术患者手术后出血或血肿例数
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
    @Column(name = "PD_7_3_3")
    @JsonProperty("PD-7-3-3")
    private String PD_7_3_3; // 神经系统手术并发症
    @Column(name = "PD_7_3_3_1")
    @JsonProperty("PD-7-3-3-1")
    private String PD_7_3_3_1; // 其他术后并发症
    @Column(name = "PD_8_1_1")
    @JsonProperty("PD-8-1-1")
    private String PD_8_1_1; // 是否有冻结步态
    @Column(name = "PD_8_1_2")
    @JsonProperty("PD-8-1-2")
    private String PD_8_1_2; // 是否有冻结步态量表（FOG-Q）评分
    @Column(name = "PD_8_1_3_1")
    @JsonProperty("PD-8-1-3-1")
    private String PD_8_1_3_1; // (FOG-Q）评分值是否确定
    @Column(name = "PD_8_1_3")
    @JsonProperty("PD-8-1-3")
    private String PD_8_1_3; // 冻结步态量表（FOG-Q）评分值
    @Column(name = "PD_8_1_4")
    @JsonProperty("PD-8-1-4")
    private String PD_8_1_4; // 评估日期时间
    @Column(name = "PD_8_2_1")
    @JsonProperty("PD-8-2-1")
    private String PD_8_2_1; // 康复方式选择
    @Column(name = "PD_8_2_2")
    @JsonProperty("PD-8-2-2")
    private String PD_8_2_2; // 康复实施日期(首次)
    @Column(name = "PD_8_2_3")
    @JsonProperty("PD-8-2-3")
    private String PD_8_2_3; // 未能进行康复原因
    @Column(name = "PD_9_1_1")
    @JsonProperty("PD-9-1-1")
    private String PD_9_1_1; // 入院时是否进行重点护理评估且有记录
    @Column(name = "PD_9_1_1_1")
    @JsonProperty("PD-9-1-1-1")
    private String PD_9_1_1_1; // 行走评估结果
    @Column(name = "PD_9_1_2")
    @JsonProperty("PD-9-1-2")
    private String PD_9_1_2; // 跌倒/坠床评估
    @Column(name = "PD_9_1_3")
    @JsonProperty("PD-9-1-3")
    private String PD_9_1_3; // 饮食评估结果
    @Column(name = "PD_9_1_4")
    @JsonProperty("PD-9-1-4")
    private String PD_9_1_4; // 吞咽评估结果
    @Column(name = "PD_9_1_5")
    @JsonProperty("PD-9-1-5")
    private String PD_9_1_5; // 误吸
    @Column(name = "PD_9_1_5_1")
    @JsonProperty("PD-9-1-5-1")
    private String PD_9_1_5_1; // 压疮评估是否无法确定或无记录
    @Column(name = "PD_9_1_6")
    @JsonProperty("PD-9-1-6")
    private String PD_9_1_6; // 压疮评估（Braden评分值）分值
    @Column(name = "PD_9_1_6_1")
    @JsonProperty("PD-9-1-6-1")
    private String PD_9_1_6_1; // 压疮评估结果选择
    @Column(name = "PD_9_1_6_2")
    @JsonProperty("PD-9-1-6-2")
    private String PD_9_1_6_2; // 预防压疮是否告知
    @Column(name = "PD_9_1_7")
    @JsonProperty("PD-9-1-7")
    private String PD_9_1_7; // Wells深静脉血栓风险评分
    @Column(name = "PD_9_1_8")
    @JsonProperty("PD-9-1-8")
    private String PD_9_1_8; // 尿失禁评估
    @Column(name = "PD_9_1_9")
    @JsonProperty("PD-9-1-9")
    private String PD_9_1_9; // 疼痛评估
    @Column(name = "PD_9_1_2_1")
    @JsonProperty("PD-9-1-2-1")
    private String PD_9_1_2_1; // DBS前、后是否实施健康教育有记录
    @Column(name = "PD_9_1_2_2")
    @JsonProperty("PD-9-1-2-2")
    private String PD_9_1_2_2; // 手术（DBS）前健康教育有记录
    @Column(name = "PD_9_1_3_3")
    @JsonProperty("PD-9-1-3-3")
    private String PD_9_1_3_3; // 手术（DBS）后健康教育有记录
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
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