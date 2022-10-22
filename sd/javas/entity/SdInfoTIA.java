package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：G45.0 至 G45.9 的出院患者。
*/
@ApiModel(value = "10信息")
@Entity
@Data
@Table(name = "sd_info_TIA")
public class SdInfoTIA implements Serializable {
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
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为出院后30天内非计划重复住院
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
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "TIA_1_1_1_1")
    @JsonProperty("TIA-1-1-1-1")
    private String TIA_1_1_1_1; // 急诊/门诊日期时间
    @Column(name = "TIA_1_1_2_1")
    @JsonProperty("TIA-1-1-2-1")
    private String TIA_1_1_2_1; // 评估日期时间
    @Column(name = "TIA_1_1_3")
    @JsonProperty("TIA-1-1-3")
    private String TIA_1_1_3; // 是否实施ABCD/2/3/3-I评分
    @Column(name = "TIA_1_1_4")
    @JsonProperty("TIA-1-1-4")
    private String TIA_1_1_4; // 选择评估分值实施类型
    @Column(name = "TIA_1_1_4_1_0")
    @JsonProperty("TIA-1-1-4-1-0")
    private String TIA_1_1_4_1_0; // ABCD评估分值
    @Column(name = "TIA_1_1_4_1_1")
    @JsonProperty("TIA-1-1-4-1-1")
    private String TIA_1_1_4_1_1; // ABCD2评估分值
    @Column(name = "TIA_1_1_4_2_1")
    @JsonProperty("TIA-1-1-4-2-1")
    private String TIA_1_1_4_2_1; // ABCD3评估分值
    @Column(name = "TIA_1_1_4_3_1")
    @JsonProperty("TIA-1-1-4-3-1")
    private String TIA_1_1_4_3_1; // ABCD3-I评估分值
    @Column(name = "TIA_1_1_4_5")
    @JsonProperty("TIA-1-1-4-5")
    private String TIA_1_1_4_5; // ABCD2/3/3-I 评估风险分层
    @Column(name = "TIA_1_2_1_1")
    @JsonProperty("TIA-1-2-1-1")
    private String TIA_1_2_1_1; // 是否实施首次头部影像学检查
    @Column(name = "TIA_1_2_1_2")
    @JsonProperty("TIA-1-2-1-2")
    private String TIA_1_2_1_2; // 头部影像学检查项目
    @Column(name = "TIA_1_2_1_4")
    @JsonProperty("TIA-1-2-1-4")
    private String TIA_1_2_1_4; // 其他头部影像学检查项目
    @Column(name = "TIA_1_2_1_3_1")
    @JsonProperty("TIA-1-2-1-3-1")
    private String TIA_1_2_1_3_1; // 报告日期时间
    @Column(name = "TIA_1_2_2_1")
    @JsonProperty("TIA-1-2-2-1")
    private String TIA_1_2_2_1; // 是否实施首次全血细胞计数检查
    @Column(name = "TIA_1_2_2_2_1")
    @JsonProperty("TIA-1-2-2-2-1")
    private String TIA_1_2_2_2_1; // 报告日期时间
    @Column(name = "TIA_1_2_3_1")
    @JsonProperty("TIA-1-2-3-1")
    private String TIA_1_2_3_1; // 是否实施首次凝血功能检查
    @Column(name = "TIA_1_2_3_2_1")
    @JsonProperty("TIA-1-2-3-2-1")
    private String TIA_1_2_3_2_1; // 凝血功能检查项目
    @Column(name = "TIA_1_2_3_3_1")
    @JsonProperty("TIA-1-2-3-3-1")
    private String TIA_1_2_3_3_1; // 报告日期时间
    @Column(name = "TIA_1_2_4_1")
    @JsonProperty("TIA-1-2-4-1")
    private String TIA_1_2_4_1; // 是否实施首次生化检验检查
    @Column(name = "TIA_1_2_4_2_1")
    @JsonProperty("TIA-1-2-4-2-1")
    private String TIA_1_2_4_2_1; // 生化检验项目
    @Column(name = "TIA_1_2_4_3_1")
    @JsonProperty("TIA-1-2-4-3-1")
    private String TIA_1_2_4_3_1; // 报告日期时间
    @Column(name = "TIA_1_2_5_1")
    @JsonProperty("TIA-1-2-5-1")
    private String TIA_1_2_5_1; // 是否实施首次ECG检查
    @Column(name = "TIA_1_2_5_2_1")
    @JsonProperty("TIA-1-2-5-2-1")
    private String TIA_1_2_5_2_1; // 报告日期时间
    @Column(name = "TIA_1_2_5_3")
    @JsonProperty("TIA-1-2-5-3")
    private String TIA_1_2_5_3; // 心电图（ECG）检查结果
    @Column(name = "TIA_1_2_5_4")
    @JsonProperty("TIA-1-2-5-4")
    private String TIA_1_2_5_4; // 心电图检查其他结果
    @Column(name = "TIA_1_2_6_1")
    @JsonProperty("TIA-1-2-6-1")
    private String TIA_1_2_6_1; // 是否实施首次心脏与血管检查
    @Column(name = "TIA_1_2_6_3")
    @JsonProperty("TIA-1-2-6-3")
    private String TIA_1_2_6_3; // 心脏检查相关项目选择
    @Column(name = "TIA_1_2_6_3_1")
    @JsonProperty("TIA-1-2-6-3-1")
    private String TIA_1_2_6_3_1; // 其他心脏检查项目
    @Column(name = "TIA_1_2_6_5")
    @JsonProperty("TIA-1-2-6-5")
    private String TIA_1_2_6_5; // 血管检查相关项目选择
    @Column(name = "TIA_1_2_6_5_1")
    @JsonProperty("TIA-1-2-6-5-1")
    private String TIA_1_2_6_5_1; // 其他血管检查相关项目
    @Column(name = "TIA_1_2_6_2_1")
    @JsonProperty("TIA-1-2-6-2-1")
    private String TIA_1_2_6_2_1; // 首次报告日期时间
    @Column(name = "TIA_1_2_6_4")
    @JsonProperty("TIA-1-2-6-4")
    private String TIA_1_2_6_4; // 评估结论
    @Column(name = "TIA_1_2_6_4_1")
    @JsonProperty("TIA-1-2-6-4-1")
    private String TIA_1_2_6_4_1; // 其他评估结论
    @Column(name = "TIA_1_3")
    @JsonProperty("TIA-1-3")
    private String TIA_1_3; // 收入院诊疗指征
    @Column(name = "TIA_2_1_1_1")
    @JsonProperty("TIA-2-1-1-1")
    private String TIA_2_1_1_1; // 房颤患者
    @Column(name = "TIA_2_1_1")
    @JsonProperty("TIA-2-1-1")
    private String TIA_2_1_1; // 是否实施房颤患者脑卒中风险评估（CHA2DS2-VASc评分）
    @Column(name = "TIA_2_1_2_1")
    @JsonProperty("TIA-2-1-2-1")
    private String TIA_2_1_2_1; // 房颤患者脑卒中风险评估分值
    @Column(name = "TIA_2_5_1")
    @JsonProperty("TIA-2-5-1")
    private String TIA_2_5_1; // 是否实施房颤鉴别STAF评分
    @Column(name = "TIA_2_5_2")
    @JsonProperty("TIA-2-5-2")
    private String TIA_2_5_2; // 房颤鉴别STAF评分值(≥5分时心源性卒中可能性大)
    @Column(name = "TIA_2_6_1")
    @JsonProperty("TIA-2-6-1")
    private String TIA_2_6_1; // 是否实施房颤抗凝出血风险评估HAS-BLED评分值
    @Column(name = "TIA_2_6_2")
    @JsonProperty("TIA-2-6-2")
    private String TIA_2_6_2; // 房颤抗凝出血风险评估HAS-BLED评分值
    @Column(name = "TIA_2_3_1")
    @JsonProperty("TIA-2-3-1")
    private String TIA_2_3_1; // 是否有使用抗凝药物的禁忌证
    @Column(name = "TIA_2_3_2")
    @JsonProperty("TIA-2-3-2")
    private String TIA_2_3_2; // 使用抗凝药物的禁忌证
    @Column(name = "TIA_2_4_1")
    @JsonProperty("TIA-2-4-1")
    private String TIA_2_4_1; // 是否使用常用抗凝药物
    @Column(name = "TIA_2_4_2")
    @JsonProperty("TIA-2-4-2")
    private String TIA_2_4_2; // 选择抗凝药物
    @Column(name = "TIA_2_4_2_1")
    @JsonProperty("TIA-2-4-2-1")
    private String TIA_2_4_2_1; // 选择其他抗凝药物
    @Column(name = "TIA_2_4_3")
    @JsonProperty("TIA-2-4-3")
    private String TIA_2_4_3; // 用药日期时间
    @Column(name = "TIA_3_1_1_1")
    @JsonProperty("TIA-3-1-1-1")
    private String TIA_3_1_1_1; // 高卒中复发风险因素
    @Column(name = "TIA_3_1_1_2")
    @JsonProperty("TIA-3-1-1-2")
    private String TIA_3_1_1_2; // 其他高卒中复发风险因素
    @Column(name = "TIA_3_1_1")
    @JsonProperty("TIA-3-1-1")
    private String TIA_3_1_1; // 是否有使用阿司匹林禁忌证
    @Column(name = "TIA_3_1_2")
    @JsonProperty("TIA-3-1-2")
    private String TIA_3_1_2; // 阿司匹林禁忌证
    @Column(name = "TIA_3_2_1")
    @JsonProperty("TIA-3-2-1")
    private String TIA_3_2_1; // 患者是否使用首剂阿司匹林/氯吡格雷
    @Column(name = "TIA_3_2_2_1")
    @JsonProperty("TIA-3-2-2-1")
    private String TIA_3_2_2_1; // 用药日期时间
    @Column(name = "TIA_3_3_2")
    @JsonProperty("TIA-3-3-2")
    private String TIA_3_3_2; // 选择双联抗血小板药物
    @Column(name = "TIA_3_3_1")
    @JsonProperty("TIA-3-3-1")
    private String TIA_3_3_1; // 其他双联抗血小板药物
    @Column(name = "TIA_4_1_1")
    @JsonProperty("TIA-4-1-1")
    private String TIA_4_1_1; // 患者评估时机选择
    @Column(name = "TIA_4_1_2_1")
    @JsonProperty("TIA-4-1-2-1")
    private String TIA_4_1_2_1; // 评估日期
    @Column(name = "TIA_4_2_1")
    @JsonProperty("TIA-4-2-1")
    private String TIA_4_2_1; // 选择血脂评估项目
    @Column(name = "TIA_4_3")
    @JsonProperty("TIA-4-3")
    private String TIA_4_3; // 评价血脂水平
    @Column(name = "TIA_4_4_0")
    @JsonProperty("TIA-4-4-0")
    private String TIA_4_4_0; // 是否使用他汀类药物
    @Column(name = "TIA_4_4_1_1")
    @JsonProperty("TIA-4-4-1-1")
    private String TIA_4_4_1_1; // 首次使用他汀类医嘱的日期
    @Column(name = "TIA_4_4_2")
    @JsonProperty("TIA-4-4-2")
    private String TIA_4_4_2; // 他汀类药物
    @Column(name = "TIA_5_1")
    @JsonProperty("TIA-5-1")
    private String TIA_5_1; // 选择抗血小扳聚集治疗药物
    @Column(name = "TIA_5_1_1")
    @JsonProperty("TIA-5-1-1")
    private String TIA_5_1_1; // 其他抗血小扳聚集治疗药物
    @Column(name = "TIA_5_2")
    @JsonProperty("TIA-5-2")
    private String TIA_5_2; // 他汀类药物
    @Column(name = "TIA_5_2_1")
    @JsonProperty("TIA-5-2-1")
    private String TIA_5_2_1; // 他汀类其他药物
    @Column(name = "TIA_5_3")
    @JsonProperty("TIA-5-3")
    private String TIA_5_3; // 选择抗凝药物
    @Column(name = "TIA_5_3_1")
    @JsonProperty("TIA-5-3-1")
    private String TIA_5_3_1; // 选择其他抗凝药物
    @Column(name = "TIA_5_4_1")
    @JsonProperty("TIA-5-4-1")
    private String TIA_5_4_1; // 患者是否伴发糖尿病
    @Column(name = "TIA_5_4")
    @JsonProperty("TIA-5-4")
    private String TIA_5_4; // 选择降糖药物
    @Column(name = "TIA_5_4_2")
    @JsonProperty("TIA-5-4-2")
    private String TIA_5_4_2; // 其他降糖药物
    @Column(name = "TIA_5_5_1")
    @JsonProperty("TIA-5-5-1")
    private String TIA_5_5_1; // 患者是否伴发高血压
    @Column(name = "TIA_5_5")
    @JsonProperty("TIA-5-5")
    private String TIA_5_5; // 选择降压药物
    @Column(name = "TIA_5_5_2")
    @JsonProperty("TIA-5-5-2")
    private String TIA_5_5_2; // 其他降压药物
    @Column(name = "TIA_6_1_1")
    @JsonProperty("TIA-6-1-1")
    private String TIA_6_1_1; // 行走评估结果
    @Column(name = "TIA_6_1_2")
    @JsonProperty("TIA-6-1-2")
    private String TIA_6_1_2; // 呼吸评估结果
    @Column(name = "TIA_6_1_3")
    @JsonProperty("TIA-6-1-3")
    private String TIA_6_1_3; // 饮食评估结果
    @Column(name = "TIA_6_2_1")
    @JsonProperty("TIA-6-2-1")
    private String TIA_6_2_1; // 实施卒中健康教育有记录
    @Column(name = "TIA_6_3_1")
    @JsonProperty("TIA-6-3-1")
    private String TIA_6_3_1; // 吸烟史
    @Column(name = "TIA_6_3_2")
    @JsonProperty("TIA-6-3-2")
    private String TIA_6_3_2; // 吸烟程度评估有记录
    @Column(name = "TIA_6_3_3")
    @JsonProperty("TIA-6-3-3")
    private String TIA_6_3_3; // 接受戒烟的建议或者戒烟治疗有记录
    @Column(name = "TIA_7_1")
    @JsonProperty("TIA-7-1")
    private String TIA_7_1; // 血管功能评估时间
    @Column(name = "TIA_7_2")
    @JsonProperty("TIA-7-2")
    private String TIA_7_2; // 血管功能评估方法
    @Column(name = "TIA_7_2_1")
    @JsonProperty("TIA-7-2-1")
    private String TIA_7_2_1; // 血管功能评估其他方法
    @Column(name = "TIA_7_3_1")
    @JsonProperty("TIA-7-3-1")
    private String TIA_7_3_1; // 其他病因学检查方法
    @Column(name = "TIA_7_3_1_1")
    @JsonProperty("TIA-7-3-1-1")
    private String TIA_7_3_1_1; // 其他病因学检查
    @Column(name = "TIA_9_1_1")
    @JsonProperty("TIA-9-1-1")
    private String TIA_9_1_1; // 出院时是否进行Essen卒中风险评分
    @Column(name = "TIA_9_1_2_1")
    @JsonProperty("TIA-9-1-2-1")
    private String TIA_9_1_2_1; // Essen卒中风险评分值
    @Column(name = "TIA_9_2_1")
    @JsonProperty("TIA-9-2-1")
    private String TIA_9_2_1; // 主要风险因素评估
    @Column(name = "TIA_9_2_1_1")
    @JsonProperty("TIA-9-2-1-1")
    private String TIA_9_2_1_1; // 其他主要风险因素填写
    @Column(name = "TIA_9_2_2")
    @JsonProperty("TIA-9-2-2")
    private String TIA_9_2_2; // 其他风险因素评估
    @Column(name = "TIA_9_2_2_1")
    @JsonProperty("TIA-9-2-2-1")
    private String TIA_9_2_2_1; // 其他风险因素填写
    @Column(name = "TIA_9_3_1")
    @JsonProperty("TIA-9-3-1")
    private String TIA_9_3_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "TIA_9_3_2")
    @JsonProperty("TIA-9-3-2")
    private String TIA_9_3_2; // 出院带药
    @Column(name = "TIA_9_3_3")
    @JsonProperty("TIA-9-3-3")
    private String TIA_9_3_3; // 告知发生紧急情况时求援救治途径
    @Column(name = "TIA_9_3_4")
    @JsonProperty("TIA-9-3-4")
    private String TIA_9_3_4; // 出院时教育与随访
    @Column(name = "TIA_9_3_5")
    @JsonProperty("TIA-9-3-5")
    private String TIA_9_3_5; // 告知何为风险因素与紧急情况
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