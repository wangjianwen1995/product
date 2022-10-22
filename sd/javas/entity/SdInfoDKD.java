package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断和其他诊断 ICD-10 编码：E10 至 E14，且伴主要操作 ICD-9-CM-3 编码：55.23 的非产妇出院患者。
*/
@ApiModel(value = "35信息")
@Entity
@Data
@Table(name = "sd_info_DKD")
public class SdInfoDKD implements Serializable {
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
    private String CM_0_2_1_4; // 体重指数(Kg/m²)
    @Column(name = "CM_0_2_2_1")
    @JsonProperty("CM-0-2-2-1")
    private String CM_0_2_2_1; // 糖尿病发病日期时间是否无法确定或无记录
    @Column(name = "CM_0_2_2_2")
    @JsonProperty("CM-0-2-2-2")
    private String CM_0_2_2_2; // 糖尿病发病日期时间
    @Column(name = "DKD_0_2_2_1")
    @JsonProperty("DKD-0-2-2-1")
    private String DKD_0_2_2_1; // 肾病发病日期时间是否无法确定或无记录
    @Column(name = "DKD_0_2_2_2")
    @JsonProperty("DKD-0-2-2-2")
    private String DKD_0_2_2_2; // 肾病发病日期时间
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
    @Column(name = "DKD_0_2_6_1")
    @JsonProperty("DKD-0-2-6-1")
    private String DKD_0_2_6_1; // 肾活检操作日期是否无法确定或无记录
    @Column(name = "DKD_0_2_6")
    @JsonProperty("DKD-0-2-6")
    private String DKD_0_2_6; // 肾活检操作日期
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "DKD_1_1_1")
    @JsonProperty("DKD-1-1-1")
    private String DKD_1_1_1; // 入院首次实验室检测
    @Column(name = "DKD_1_1_1_1")
    @JsonProperty("DKD-1-1-1-1")
    private String DKD_1_1_1_1; // 尿蛋白检测值
    @Column(name = "DKD_1_1_1_2")
    @JsonProperty("DKD-1-1-1-2")
    private String DKD_1_1_1_2; // 肌酐（ACR）检测值(mg/mmol)
    @Column(name = "DKD_1_1_1_3")
    @JsonProperty("DKD-1-1-1-3")
    private String DKD_1_1_1_3; // 24小时尿蛋白定量检测值(mg/24h)
    @Column(name = "DKD_1_1_2")
    @JsonProperty("DKD-1-1-2")
    private String DKD_1_1_2; // 提取最后一个项目的检测结果报告时间
    @Column(name = "DKD_1_1_3")
    @JsonProperty("DKD-1-1-3")
    private String DKD_1_1_3; // 蛋白尿程度的分层
    @Column(name = "DKD_1_2_1")
    @JsonProperty("DKD-1-2-1")
    private String DKD_1_2_1; // 肾小球滤过率GFR数值(mL/min/1.73m²)
    @Column(name = "DKD_1_2_1_1")
    @JsonProperty("DKD-1-2-1-1")
    private String DKD_1_2_1_1; // 患者年龄(岁)
    @Column(name = "DKD_1_2_1_2")
    @JsonProperty("DKD-1-2-1-2")
    private String DKD_1_2_1_2; // 患者性别
    @Column(name = "DKD_1_2_2")
    @JsonProperty("DKD-1-2-2")
    private String DKD_1_2_2; // 血肌酐（Scr）检测结果首次报告日期时间
    @Column(name = "DKD_1_2_3")
    @JsonProperty("DKD-1-2-3")
    private String DKD_1_2_3; // CKD分期
    @Column(name = "DKD_2_1_1")
    @JsonProperty("DKD-2-1-1")
    private String DKD_2_1_1; // 是否实施视网膜病变检测
    @Column(name = "DKD_2_1_2")
    @JsonProperty("DKD-2-1-2")
    private String DKD_2_1_2; // 首次眼底检查项目内容
    @Column(name = "DKD_2_1_3")
    @JsonProperty("DKD-2-1-3")
    private String DKD_2_1_3; // 最后一个项目结果报告日期时间
    @Column(name = "DKD_2_1_4")
    @JsonProperty("DKD-2-1-4")
    private String DKD_2_1_4; // 眼底检查辅助检查
    @Column(name = "DKD_2_1_5")
    @JsonProperty("DKD-2-1-5")
    private String DKD_2_1_5; // 最后一个项目结果报告日期时间
    @Column(name = "DKD_2_1_6")
    @JsonProperty("DKD-2-1-6")
    private String DKD_2_1_6; // 是否有糖尿病视网膜病变
    @Column(name = "DKD_2_1_7")
    @JsonProperty("DKD-2-1-7")
    private String DKD_2_1_7; // 糖尿病视网膜病变诊断及分期
    @Column(name = "DKD_2_2_1")
    @JsonProperty("DKD-2-2-1")
    private String DKD_2_2_1; // 是否实施血管病变检测
    @Column(name = "DKD_2_2_2")
    @JsonProperty("DKD-2-2-2")
    private String DKD_2_2_2; // 实施血管病变检测
    @Column(name = "DKD_2_2_2_1")
    @JsonProperty("DKD-2-2-2-1")
    private String DKD_2_2_2_1; // 实施血管病变其他检测
    @Column(name = "DKD_2_2_3")
    @JsonProperty("DKD-2-2-3")
    private String DKD_2_2_3; // 血管病变
    @Column(name = "DKD_2_2_3_1")
    @JsonProperty("DKD-2-2-3-1")
    private String DKD_2_2_3_1; // 其他血管病变
    @Column(name = "DKD_2_3_1")
    @JsonProperty("DKD-2-3-1")
    private String DKD_2_3_1; // 糖尿病其他并发症或合并症
    @Column(name = "DKD_2_3_1_1")
    @JsonProperty("DKD-2-3-1-1")
    private String DKD_2_3_1_1; // 其他糖尿病并发症
    @Column(name = "DKD_3_1_0")
    @JsonProperty("DKD-3-1-0")
    private String DKD_3_1_0; // 是否有做肾脏组织活检
    @Column(name = "DKD_3_1_1")
    @JsonProperty("DKD-3-1-1")
    private String DKD_3_1_1; // 是否有肾穿刺活检的禁忌证
    @Column(name = "DKD_3_1_2")
    @JsonProperty("DKD-3-1-2")
    private String DKD_3_1_2; // 肾穿刺活检禁忌证
    @Column(name = "DKD_3_1_2_1")
    @JsonProperty("DKD-3-1-2-1")
    private String DKD_3_1_2_1; // 肾穿刺活检其他禁忌证
    @Column(name = "DKD_3_1_3")
    @JsonProperty("DKD-3-1-3")
    private String DKD_3_1_3; // 不必须行肾脏组织活检病理检查的情况
    @Column(name = "DKD_3_1_3_1")
    @JsonProperty("DKD-3-1-3-1")
    private String DKD_3_1_3_1; // 不必须行肾脏组织活检病理检查其他情况
    @Column(name = "DKD_3_1_4")
    @JsonProperty("DKD-3-1-4")
    private String DKD_3_1_4; // 肾脏组织活检病理检查的适应证
    @Column(name = "DKD_3_1_5")
    @JsonProperty("DKD-3-1-5")
    private String DKD_3_1_5; // 是否签署知情同意
    @Column(name = "DKD_3_1_6")
    @JsonProperty("DKD-3-1-6")
    private String DKD_3_1_6; // 闭合性[经皮][针吸]肾活组织检查术式
    @Column(name = "DKD_3_1_6_1")
    @JsonProperty("DKD-3-1-6-1")
    private String DKD_3_1_6_1; // 闭合性[经皮][针吸]肾活组织检查其他术式
    @Column(name = "DKD_3_1_7")
    @JsonProperty("DKD-3-1-7")
    private String DKD_3_1_7; // 肾脏组织活检日期
    @Column(name = "DKD_3_1_8")
    @JsonProperty("DKD-3-1-8")
    private String DKD_3_1_8; // 是否有肾穿刺术后并发症
    @Column(name = "DKD_3_1_9")
    @JsonProperty("DKD-3-1-9")
    private String DKD_3_1_9; // 肾穿刺术后并发症
    @Column(name = "DKD_3_2_1")
    @JsonProperty("DKD-3-2-1")
    private String DKD_3_2_1; // 肾活检标本的取材
    @Column(name = "DKD_3_2_2")
    @JsonProperty("DKD-3-2-2")
    private String DKD_3_2_2; // 光镜标本染色
    @Column(name = "DKD_3_2_2_1")
    @JsonProperty("DKD-3-2-2-1")
    private String DKD_3_2_2_1; // 光镜标本其他染色
    @Column(name = "DKD_3_2_3")
    @JsonProperty("DKD-3-2-3")
    private String DKD_3_2_3; // 免疫病理染色
    @Column(name = "DKD_3_2_3_1")
    @JsonProperty("DKD-3-2-3-1")
    private String DKD_3_2_3_1; // 免疫病理其他染色
    @Column(name = "DKD_3_2_4")
    @JsonProperty("DKD-3-2-4")
    private String DKD_3_2_4; // 肾活检组织形态学病变的描述
    @Column(name = "DKD_3_2_4_1")
    @JsonProperty("DKD-3-2-4-1")
    private String DKD_3_2_4_1; // 大体描述 组织的条数
    @Column(name = "DKD_3_2_4_2")
    @JsonProperty("DKD-3-2-4-2")
    private String DKD_3_2_4_2; // 光镜检查描述 肾小球病变描述
    @Column(name = "DKD_3_2_4_3")
    @JsonProperty("DKD-3-2-4-3")
    private String DKD_3_2_4_3; // 光镜检查描述 肾小管病变描述
    @Column(name = "DKD_3_2_4_4")
    @JsonProperty("DKD-3-2-4-4")
    private String DKD_3_2_4_4; // 光镜检查描述 间质病变描述
    @Column(name = "DKD_3_2_4_5")
    @JsonProperty("DKD-3-2-4-5")
    private String DKD_3_2_4_5; // 光镜检查描述 血管病变描述
    @Column(name = "DKD_3_2_4_6")
    @JsonProperty("DKD-3-2-4-6")
    private String DKD_3_2_4_6; // 免疫荧光描述 阳性强度、分布方式、沉积部位
    @Column(name = "DKD_3_2_4_7")
    @JsonProperty("DKD-3-2-4-7")
    private String DKD_3_2_4_7; // 电镜检查描述 肾小球基底膜厚度
    @Column(name = "DKD_3_2_5")
    @JsonProperty("DKD-3-2-5")
    private String DKD_3_2_5; // 是否肾脏病理诊断为糖尿病肾病
    @Column(name = "DKD_3_2_6")
    @JsonProperty("DKD-3-2-6")
    private String DKD_3_2_6; // 有肾单位各部分的损伤类型及损伤程度的描述
    @Column(name = "DKD_3_2_6_1")
    @JsonProperty("DKD-3-2-6-1")
    private String DKD_3_2_6_1; // 有糖尿病肾病病理分型
    @Column(name = "DKD_3_2_6_2")
    @JsonProperty("DKD-3-2-6-2")
    private String DKD_3_2_6_2; // 有糖尿病肾病间质评分
    @Column(name = "DKD_3_2_6_3")
    @JsonProperty("DKD-3-2-6-3")
    private String DKD_3_2_6_3; // 有糖尿病肾病血管病变
    @Column(name = "DKD_3_2_7")
    @JsonProperty("DKD-3-2-7")
    private String DKD_3_2_7; // 光镜报告日期
    @Column(name = "DKD_3_2_8")
    @JsonProperty("DKD-3-2-8")
    private String DKD_3_2_8; // 免疫荧光报告日期
    @Column(name = "DKD_3_2_9")
    @JsonProperty("DKD-3-2-9")
    private String DKD_3_2_9; // 电镜报告日期
    @Column(name = "DKD_3_2_5_1")
    @JsonProperty("DKD-3-2-5-1")
    private String DKD_3_2_5_1; // 非糖尿病肾病病理诊断名称
    @Column(name = "DKD_4_1_1")
    @JsonProperty("DKD-4-1-1")
    private String DKD_4_1_1; // 入院后首次，血糖评估
    @Column(name = "DKD_4_1_1_1")
    @JsonProperty("DKD-4-1-1-1")
    private String DKD_4_1_1_1; // 入院后首次，糖化血红蛋白检测值(%)
    @Column(name = "DKD_4_1_1_2")
    @JsonProperty("DKD-4-1-1-2")
    private String DKD_4_1_1_2; // 入院后首次，空腹血糖检测值(mmol/L)
    @Column(name = "DKD_4_1_1_3")
    @JsonProperty("DKD-4-1-1-3")
    private String DKD_4_1_1_3; // 入院后首次，餐后2小时血糖检测值(mmol/L)
    @Column(name = "DKD_4_1_2")
    @JsonProperty("DKD-4-1-2")
    private String DKD_4_1_2; // 三项中最后一项检测报告的日期
    @Column(name = "DKD_4_1_3")
    @JsonProperty("DKD-4-1-3")
    private String DKD_4_1_3; // 降糖药物种类
    @Column(name = "DKD_4_1_3_1")
    @JsonProperty("DKD-4-1-3-1")
    private String DKD_4_1_3_1; // 降糖药物其他种类
    @Column(name = "DKD_4_1_4")
    @JsonProperty("DKD-4-1-4")
    private String DKD_4_1_4; // 出院前未次，血糖评估
    @Column(name = "DKD_4_1_4_1")
    @JsonProperty("DKD-4-1-4-1")
    private String DKD_4_1_4_1; // 出院前未次，空腹血糖检测值(mmol/L)
    @Column(name = "DKD_4_1_4_2")
    @JsonProperty("DKD-4-1-4-2")
    private String DKD_4_1_4_2; // 出院前未次，餐后2小时血糖检测值(mmol/L)
    @Column(name = "DKD_4_1_5")
    @JsonProperty("DKD-4-1-5")
    private String DKD_4_1_5; // 三项中最后一项检测报告的日期
    @Column(name = "DKD_4_2_1")
    @JsonProperty("DKD-4-2-1")
    private String DKD_4_2_1; // 入院后首次,血压评估
    @Column(name = "DKD_4_2_1_1")
    @JsonProperty("DKD-4-2-1-1")
    private String DKD_4_2_1_1; // 收缩压测量值(mmHg)
    @Column(name = "DKD_4_2_1_2")
    @JsonProperty("DKD-4-2-1-2")
    private String DKD_4_2_1_2; // 舒张压测量值(mmHg)
    @Column(name = "DKD_4_2_2")
    @JsonProperty("DKD-4-2-2")
    private String DKD_4_2_2; // 降压药物种类
    @Column(name = "DKD_4_2_2_1")
    @JsonProperty("DKD-4-2-2-1")
    private String DKD_4_2_2_1; // 降压药物其他种类
    @Column(name = "DKD_4_2_3")
    @JsonProperty("DKD-4-2-3")
    private String DKD_4_2_3; // 出院前未次，血压评估
    @Column(name = "DKD_4_2_3_1")
    @JsonProperty("DKD-4-2-3-1")
    private String DKD_4_2_3_1; // 收缩压测量值(mmHg)
    @Column(name = "DKD_4_2_3_2")
    @JsonProperty("DKD-4-2-3-2")
    private String DKD_4_2_3_2; // 舒张压测量值(mmHg)
    @Column(name = "DKD_4_3_1")
    @JsonProperty("DKD-4-3-1")
    private String DKD_4_3_1; // 入院后首次,血脂评估
    @Column(name = "DKD_4_3_1_1")
    @JsonProperty("DKD-4-3-1-1")
    private String DKD_4_3_1_1; // 总胆固醇(TC)检测值(mmol/L)
    @Column(name = "DKD_4_3_1_2")
    @JsonProperty("DKD-4-3-1-2")
    private String DKD_4_3_1_2; // 甘油三酯(TG)检测值(mmol/L)
    @Column(name = "DKD_4_3_1_3")
    @JsonProperty("DKD-4-3-1-3")
    private String DKD_4_3_1_3; // 低密度脂蛋白(LDL-C)检测值(mmol/L)
    @Column(name = "DKD_4_3_1_4")
    @JsonProperty("DKD-4-3-1-4")
    private String DKD_4_3_1_4; // 高密度脂蛋白(HDL-C)检测值(mmol/L)
    @Column(name = "DKD_4_3_2")
    @JsonProperty("DKD-4-3-2")
    private String DKD_4_3_2; // 降脂药物种类
    @Column(name = "DKD_4_3_2_1")
    @JsonProperty("DKD-4-3-2-1")
    private String DKD_4_3_2_1; // 降压药物其他种类
    @Column(name = "DKD_4_3_3")
    @JsonProperty("DKD-4-3-3")
    private String DKD_4_3_3; // 出院前未次,血脂评估
    @Column(name = "DKD_4_3_3_1")
    @JsonProperty("DKD-4-3-3-1")
    private String DKD_4_3_3_1; // 总胆固醇(TC)检测值(mmol/L)
    @Column(name = "DKD_4_3_3_2")
    @JsonProperty("DKD-4-3-3-2")
    private String DKD_4_3_3_2; // 甘油三酯(TG)检测值(mmol/L)
    @Column(name = "DKD_5_1_1")
    @JsonProperty("DKD-5-1-1")
    private String DKD_5_1_1; // 是否提供生活方式指导
    @Column(name = "DKD_5_1_2")
    @JsonProperty("DKD-5-1-2")
    private String DKD_5_1_2; // 是否控制血糖
    @Column(name = "DKD_5_1_3")
    @JsonProperty("DKD-5-1-3")
    private String DKD_5_1_3; // 是否控制血压
    @Column(name = "DKD_5_1_4")
    @JsonProperty("DKD-5-1-4")
    private String DKD_5_1_4; // 是否纠正脂质代谢紊乱
    @Column(name = "DKD_5_1_5")
    @JsonProperty("DKD-5-1-5")
    private String DKD_5_1_5; // 肾穿刺活检
    @Column(name = "DKD_5_2_1")
    @JsonProperty("DKD-5-2-1")
    private String DKD_5_2_1; // 主要危险因素的评估
    @Column(name = "DKD_5_2_2")
    @JsonProperty("DKD-5-2-2")
    private String DKD_5_2_2; // 实施针对控制危险因素评估结果的教育
    @Column(name = "DKD_5_3_1")
    @JsonProperty("DKD-5-3-1")
    private String DKD_5_3_1; // 二级预防要素
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    @Column(name = "DKD_5_4_5_1")
    @JsonProperty("DKD-5-4-5-1")
    private String DKD_5_4_5_1; // 其他发生紧急意外情况或者疾病复发
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
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