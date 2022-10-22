package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：I63.0 至 I63.9 的出院患者。
*/
@ApiModel(value = "09信息")
@Entity
@Data
@Table(name = "sd_info_STK")
public class SdInfoSTK implements Serializable {
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
    @Column(name = "STK_0_1_3_1")
    @JsonProperty("STK-0-1-3-1")
    private String STK_0_1_3_1; // 其他主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为"STK"出院后31天内重复住院
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
    private String CM_0_2_5_1; // 入住卒中中心/ICU日期时间
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开卒中中心/ICU日期时间
    @Column(name = "CM_0_2_6_1")
    @JsonProperty("CM-0-2-6-1")
    private String CM_0_2_6_1; // 手术/介入开始（切皮）日期时间 
    @Column(name = "CM_0_2_6_2")
    @JsonProperty("CM-0-2-6-2")
    private String CM_0_2_6_2; // 手术/介入结束（缝皮结束）日期时间
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "STK_0_4_1")
    @JsonProperty("STK-0-4-1")
    private String STK_0_4_1; // 现场评估生命体征，施行急救
    @Column(name = "STK_0_4_2")
    @JsonProperty("STK-0-4-2")
    private String STK_0_4_2; // 到达现场后10分钟内完成院前卒中评分
    @Column(name = "STK_0_4_3")
    @JsonProperty("STK-0-4-3")
    private String STK_0_4_3; // 现场急救维持生命体征稳定
    @Column(name = "STK_0_4_4")
    @JsonProperty("STK-0-4-4")
    private String STK_0_4_4; // 利用车载信息系统、微信、彩信等多种形式传输心电图等院前信息至目标医院
    @Column(name = "STK_1_1_1_1")
    @JsonProperty("STK-1-1-1-1")
    private String STK_1_1_1_1; // 急诊/门诊 医师接诊日期时间是否确定
    @Column(name = "STK_1_1_1_2")
    @JsonProperty("STK-1-1-1-2")
    private String STK_1_1_1_2; // 急诊/门诊 医师接诊日期时间
    @Column(name = "STK_1_1_4")
    @JsonProperty("STK-1-1-4")
    private String STK_1_1_4; // 呼吸(次/分)
    @Column(name = "STK_1_1_5")
    @JsonProperty("STK-1-1-5")
    private String STK_1_1_5; // 脉搏(次/分)
    @Column(name = "STK_1_1_6")
    @JsonProperty("STK-1-1-6")
    private String STK_1_1_6; // 收缩压(mmHg)
    @Column(name = "STK_1_1_7")
    @JsonProperty("STK-1-1-7")
    private String STK_1_1_7; // 舒张压(mmHg)
    @Column(name = "STK_1_2_1")
    @JsonProperty("STK-1-2-1")
    private String STK_1_2_1; // 急诊/门诊后首次评估还是入院后首次评估
    @Column(name = "STK_1_2_1_1")
    @JsonProperty("STK-1-2-1-1")
    private String STK_1_2_1_1; // 急诊/门诊 首次实施神经功能缺损NIHSS评估
    @Column(name = "STK_1_2_1_2_1")
    @JsonProperty("STK-1-2-1-2-1")
    private String STK_1_2_1_2_1; // 急诊/门诊 首次评估日期时间
    @Column(name = "STK_1_2_1_3_1")
    @JsonProperty("STK-1-2-1-3-1")
    private String STK_1_2_1_3_1; // 实施神经功能缺损NIHSS评估分值
    @Column(name = "STK_1_2_2_1")
    @JsonProperty("STK-1-2-2-1")
    private String STK_1_2_2_1; // 入院后首次实施神经功能缺损NIHSS评估
    @Column(name = "STK_1_2_2_2_1")
    @JsonProperty("STK-1-2-2-2-1")
    private String STK_1_2_2_2_1; // 入院后首次评估日期时间
    @Column(name = "STK_1_2_2_3_1")
    @JsonProperty("STK-1-2-2-3-1")
    private String STK_1_2_2_3_1; // 实施神经功能缺损NIHSS评估分值
    @Column(name = "STK_1_3_1")
    @JsonProperty("STK-1-3-1")
    private String STK_1_3_1; // 是否实施首次头部影像学检查
    @Column(name = "STK_1_3_2")
    @JsonProperty("STK-1-3-2")
    private String STK_1_3_2; // 头部影像学检查项目
    @Column(name = "STK_1_3_3_1")
    @JsonProperty("STK-1-3-3-1")
    private String STK_1_3_3_1; // 报告日期时间
    @Column(name = "STK_2_1_3")
    @JsonProperty("STK-2-1-3")
    private String STK_2_1_3; // 头部影像学检查评估的选择
    @Column(name = "STK_2_1_3_1")
    @JsonProperty("STK-2-1-3-1")
    private String STK_2_1_3_1; // 其他头部影像学检查
    @Column(name = "STK_1_4_1")
    @JsonProperty("STK-1-4-1")
    private String STK_1_4_1; // 全血细胞计数
    @Column(name = "STK_1_4_1_3")
    @JsonProperty("STK-1-4-1-3")
    private String STK_1_4_1_3; // 红血球计数RBC检测值(10^12/L)
    @Column(name = "STK_1_4_1_4")
    @JsonProperty("STK-1-4-1-4")
    private String STK_1_4_1_4; // 白细胞计数WBC检测值(10^9/L)
    @Column(name = "STK_1_4_1_5")
    @JsonProperty("STK-1-4-1-5")
    private String STK_1_4_1_5; // 血小板PLT检测值(10E9/L)
    @Column(name = "STK_1_4_1_2")
    @JsonProperty("STK-1-4-1-2")
    private String STK_1_4_1_2; // 急诊/门诊 或入院后首次全血细胞计数报告日期时间
    @Column(name = "STK_1_4_1_1_1")
    @JsonProperty("STK-1-4-1-1-1")
    private String STK_1_4_1_1_1; // 急诊/门诊 或入院后首次全血细胞计数报告日期时间
    @Column(name = "STK_1_4_2_1")
    @JsonProperty("STK-1-4-2-1")
    private String STK_1_4_2_1; // 凝血功能检查项目
    @Column(name = "STK_1_4_2_3")
    @JsonProperty("STK-1-4-2-3")
    private String STK_1_4_2_3; // 报告日期时间是否确定
    @Column(name = "STK_1_4_2_2_1")
    @JsonProperty("STK-1-4-2-2-1")
    private String STK_1_4_2_2_1; // 报告日期时间
    @Column(name = "STK_1_4_3_1")
    @JsonProperty("STK-1-4-3-1")
    private String STK_1_4_3_1; // 生化检验项目
    @Column(name = "STK_1_4_3_3")
    @JsonProperty("STK-1-4-3-3")
    private String STK_1_4_3_3; // 报告日期时间是否确定
    @Column(name = "STK_1_4_3_2_1")
    @JsonProperty("STK-1-4-3-2-1")
    private String STK_1_4_3_2_1; // 报告日期时间
    @Column(name = "STK_1_4_2")
    @JsonProperty("STK-1-4-2")
    private String STK_1_4_2; // 急诊/门诊 或入院后24小时内首次临床检验检查
    @Column(name = "STK_1_4_2_4")
    @JsonProperty("STK-1-4-2-4")
    private String STK_1_4_2_4; // C-反应蛋白:检测值(mg/L)
    @Column(name = "STK_1_4_2_5")
    @JsonProperty("STK-1-4-2-5")
    private String STK_1_4_2_5; // 同型半胱氨酸（HCY）:检测值(μmol/L)
    @Column(name = "STK_1_4_2_6")
    @JsonProperty("STK-1-4-2-6")
    private String STK_1_4_2_6; // 空腹血糖:检测值(mmol/l)
    @Column(name = "STK_1_4_2_7")
    @JsonProperty("STK-1-4-2-7")
    private String STK_1_4_2_7; // 血清肌酐:检测值(μmol/l)
    @Column(name = "STK_1_4_2_8")
    @JsonProperty("STK-1-4-2-8")
    private String STK_1_4_2_8; // 血清尿素氮:检测值(mmol/l)
    @Column(name = "STK_1_4_2_9")
    @JsonProperty("STK-1-4-2-9")
    private String STK_1_4_2_9; // 尿酸:检测值(μmol/l)
    @Column(name = "STK_1_4_4_2")
    @JsonProperty("STK-1-4-4-2")
    private String STK_1_4_4_2; // 临床检验检查日期时间是否确定
    @Column(name = "STK_1_4_4_3")
    @JsonProperty("STK-1-4-4-3")
    private String STK_1_4_4_3; // 临床检验检查日期时间
    @Column(name = "STK_1_4_5_1")
    @JsonProperty("STK-1-4-5-1")
    private String STK_1_4_5_1; // 急诊/门诊 或入院后24小时内首次心肌损伤标志物检测
    @Column(name = "STK_1_4_5_2")
    @JsonProperty("STK-1-4-5-2")
    private String STK_1_4_5_2; // 肌钙蛋白T（TnT）检测值(ng/Ml)
    @Column(name = "STK_1_4_5_3")
    @JsonProperty("STK-1-4-5-3")
    private String STK_1_4_5_3; // 肌钙蛋白I（TnI）检测值(ng/Ml)
    @Column(name = "STK_1_4_5_4")
    @JsonProperty("STK-1-4-5-4")
    private String STK_1_4_5_4; // 肌酸激酶同工酶（CK-MB）检测值(ng/Ml)
    @Column(name = "STK_1_4_5_5")
    @JsonProperty("STK-1-4-5-5")
    private String STK_1_4_5_5; // 心肌肌红蛋白（Myo）检测值(ng/Ml)
    @Column(name = "STK_1_4_5_6")
    @JsonProperty("STK-1-4-5-6")
    private String STK_1_4_5_6; // B型钠尿肽（BNP）检测值(ng/Ml)
    @Column(name = "STK_1_4_5_7")
    @JsonProperty("STK-1-4-5-7")
    private String STK_1_4_5_7; // N端B型钠尿肽前体（NT-ProBNP）检测值(ng/Ml)
    @Column(name = "STK_1_4_5_8")
    @JsonProperty("STK-1-4-5-8")
    private String STK_1_4_5_8; // 心肌损伤标志物检测日期时间是否确定
    @Column(name = "STK_1_4_5_9")
    @JsonProperty("STK-1-4-5-9")
    private String STK_1_4_5_9; // 心肌损伤标志物检测日期时间
    @Column(name = "STK_1_5_1")
    @JsonProperty("STK-1-5-1")
    private String STK_1_5_1; // 急诊/门诊 或入院后是否首次实施心电图（ECG）检查
    @Column(name = "STK_1_5_2_1")
    @JsonProperty("STK-1-5-2-1")
    private String STK_1_5_2_1; // 报告日期时间
    @Column(name = "STK_1_5_3")
    @JsonProperty("STK-1-5-3")
    private String STK_1_5_3; // 心电图（ECG）检查结果
    @Column(name = "STK_1_5_3_1")
    @JsonProperty("STK-1-5-3-1")
    private String STK_1_5_3_1; // 其他心电图（ECG）检查结果
    @Column(name = "STK_2_1_1_1")
    @JsonProperty("STK-2-1-1-1")
    private String STK_2_1_1_1; // 发病→到达急诊“绿色通道”时间是否确定
    @Column(name = "STK_2_1_1_2")
    @JsonProperty("STK-2-1-1-2")
    private String STK_2_1_1_2; // 发病→到达急诊“绿色通道”时间(小时)
    @Column(name = "STK_2_1_2")
    @JsonProperty("STK-2-1-2")
    private String STK_2_1_2; // 发病→到达急诊“绿色通道”时间评估结论
    @Column(name = "STK_2_2_1")
    @JsonProperty("STK-2-2-1")
    private String STK_2_2_1; // 是否有溶栓禁忌证
    @Column(name = "STK_2_2_2_2")
    @JsonProperty("STK-2-2-2-2")
    private String STK_2_2_2_2; // 溶栓禁忌证选择
    @Column(name = "STK_2_2_2_1")
    @JsonProperty("STK-2-2-2-1")
    private String STK_2_2_2_1; // 其他临床医师认定的其他禁忌症
    @Column(name = "STK_2_3_1_1")
    @JsonProperty("STK-2-3-1-1")
    private String STK_2_3_1_1; // 发病时段适应证
    @Column(name = "STK_2_3_1_2")
    @JsonProperty("STK-2-3-1-2")
    private String STK_2_3_1_2; // 溶栓适应证的选择
    @Column(name = "STK_2_3_2")
    @JsonProperty("STK-2-3-2")
    private String STK_2_3_2; // 溶栓的评估结论的选择
    @Column(name = "STK_2_4_1_1_1")
    @JsonProperty("STK-2-4-1-1-1")
    private String STK_2_4_1_1_1; // 溶栓开始日期时间
    @Column(name = "STK_2_4_2_1_1")
    @JsonProperty("STK-2-4-2-1-1")
    private String STK_2_4_2_1_1; // 溶栓终止日期时间
    @Column(name = "STK_2_4_3")
    @JsonProperty("STK-2-4-3")
    private String STK_2_4_3; // 溶栓药选择
    @Column(name = "STK_2_4_4")
    @JsonProperty("STK-2-4-4")
    private String STK_2_4_4; // 实施溶栓（治疗性操作）途径
    @Column(name = "STK_2_4_5_1")
    @JsonProperty("STK-2-4-5-1")
    private String STK_2_4_5_1; // 溶栓药物使用时机 DTN(Door-To-Needle)
    @Column(name = "STK_2_5_1_1")
    @JsonProperty("STK-2-5-1-1")
    private String STK_2_5_1_1; // 是否实施溶栓后72小时NIHSS评估
    @Column(name = "STK_2_5_1_2_1")
    @JsonProperty("STK-2-5-1-2-1")
    private String STK_2_5_1_2_1; // 溶栓后2小时分值
    @Column(name = "STK_2_5_1_3_1")
    @JsonProperty("STK-2-5-1-3-1")
    private String STK_2_5_1_3_1; // 溶栓后24小时分值
    @Column(name = "STK_2_5_1_4_1")
    @JsonProperty("STK-2-5-1-4-1")
    private String STK_2_5_1_4_1; // 溶栓后48小时分值
    @Column(name = "STK_2_5_1_5_1")
    @JsonProperty("STK-2-5-1-5-1")
    private String STK_2_5_1_5_1; // 溶栓后72小时分值
    @Column(name = "STK_2_5_3_1")
    @JsonProperty("STK-2-5-3-1")
    private String STK_2_5_3_1; // 是否出现溶栓治疗并发症
    @Column(name = "STK_2_5_3_2")
    @JsonProperty("STK-2-5-3-2")
    private String STK_2_5_3_2; // 并发症严重程度
    @Column(name = "STK_2_6_1")
    @JsonProperty("STK-2-6-1")
    private String STK_2_6_1; // 溶栓治疗院内延误时间超过1小时主要原因的选择
    @Column(name = "STK_2_6_2")
    @JsonProperty("STK-2-6-2")
    private String STK_2_6_2; // 溶栓治疗医嘱未能执行主要原因的
    @Column(name = "STK_15_1_0")
    @JsonProperty("STK-15-1-0")
    private String STK_15_1_0; // 是否实施血管内治疗
    @Column(name = "STK_15_1_1_1")
    @JsonProperty("STK-15-1-1-1")
    private String STK_15_1_1_1; // 血管内治疗日期时间
    @Column(name = "STK_15_2")
    @JsonProperty("STK-15-2")
    private String STK_15_2; // 血管内治疗时机
    @Column(name = "STK_15_3")
    @JsonProperty("STK-15-3")
    private String STK_15_3; // 决定适应证医师职称
    @Column(name = "STK_15_4")
    @JsonProperty("STK-15-4")
    private String STK_15_4; // 主刀医师职称
    @Column(name = "STK_15_6")
    @JsonProperty("STK-15-6")
    private String STK_15_6; // 大血管闭塞重症患者实施血管内适应证选择
    @Column(name = "STK_15_6_1")
    @JsonProperty("STK-15-6-1")
    private String STK_15_6_1; // 其它适应证
    @Column(name = "STK_15_5_1")
    @JsonProperty("STK-15-5-1")
    private String STK_15_5_1; // 血管内治疗术式选择
    @Column(name = "STK_2_6_2_1")
    @JsonProperty("STK-2-6-2-1")
    private String STK_2_6_2_1; // 急诊入院时间
    @Column(name = "STK_2_6_2_2")
    @JsonProperty("STK-2-6-2-2")
    private String STK_2_6_2_2; // 完成动脉穿刺时间
    @Column(name = "STK_2_6_2_3")
    @JsonProperty("STK-2-6-2-3")
    private String STK_2_6_2_3; // 成功再灌注时间
    @Column(name = "STK_2_6_2_4")
    @JsonProperty("STK-2-6-2-4")
    private String STK_2_6_2_4; // DPT：入院到完成动脉穿刺时间(分)
    @Column(name = "STK_2_6_2_5")
    @JsonProperty("STK-2-6-2-5")
    private String STK_2_6_2_5; // PRT：完成动脉穿刺到成功再灌注时间(分)
    @Column(name = "STK_15_7")
    @JsonProperty("STK-15-7")
    private String STK_15_7; // 是否实施影像学评估血管再通分级（mTICI评分）
    @Column(name = "STK_15_7_1")
    @JsonProperty("STK-15-7-1")
    private String STK_15_7_1; // 血管再通分级（mTICI评分标准）
    @Column(name = "STK_3_1_1_1")
    @JsonProperty("STK-3-1-1-1")
    private String STK_3_1_1_1; // 是否为房颤患者脑卒中
    @Column(name = "STK_3_1_1")
    @JsonProperty("STK-3-1-1")
    private String STK_3_1_1; // 是否实施房颤患者脑卒中风险评估
    @Column(name = "STK_3_1_2_1")
    @JsonProperty("STK-3-1-2-1")
    private String STK_3_1_2_1; // 房颤患者脑卒中风险评估分值
    @Column(name = "STK_3_1_3")
    @JsonProperty("STK-3-1-3")
    private String STK_3_1_3; // CHA2DS2-VASc评分大于2分
    @Column(name = "STK_3_4_1")
    @JsonProperty("STK-3-4-1")
    private String STK_3_4_1; // 是否实施房颤鉴别STAF评分
    @Column(name = "STK_3_4_2")
    @JsonProperty("STK-3-4-2")
    private String STK_3_4_2; // 房颤鉴别STAF评分分值
    @Column(name = "STK_3_4_3")
    @JsonProperty("STK-3-4-3")
    private String STK_3_4_3; // 是否STAF评分评分值大于5分
    @Column(name = "STK_3_5_1")
    @JsonProperty("STK-3-5-1")
    private String STK_3_5_1; // 是否实施房颤抗凝出血风险评估HAS-BLED评分
    @Column(name = "STK_3_5_2")
    @JsonProperty("STK-3-5-2")
    private String STK_3_5_2; // 房颤抗凝出血风险评估HAS-BLED评分值
    @Column(name = "STK_3_5_3")
    @JsonProperty("STK-3-5-3")
    private String STK_3_5_3; // 是否HAS-BLED评分值大于3分
    @Column(name = "STK_3_2_1")
    @JsonProperty("STK-3-2-1")
    private String STK_3_2_1; // 是否有使用抗凝药物的禁忌证
    @Column(name = "STK_3_2_2")
    @JsonProperty("STK-3-2-2")
    private String STK_3_2_2; // 使用抗凝药物的禁忌症
    @Column(name = "STK_3_3_1")
    @JsonProperty("STK-3-3-1")
    private String STK_3_3_1; // 是否使用抗凝药物
    @Column(name = "STK_3_3_2_1_1")
    @JsonProperty("STK-3-3-2-1-1")
    private String STK_3_3_2_1_1; // 首剂用药日期时间
    @Column(name = "STK_3_3_3")
    @JsonProperty("STK-3-3-3")
    private String STK_3_3_3; // 抗凝药物选择
    @Column(name = "STK_4_1_1")
    @JsonProperty("STK-4-1-1")
    private String STK_4_1_1; // 是否有使用抗血小板药物禁忌证
    @Column(name = "STK_4_1_2")
    @JsonProperty("STK-4-1-2")
    private String STK_4_1_2; // 抗血小板药物禁忌证
    @Column(name = "STK_4_2_3")
    @JsonProperty("STK-4-2-3")
    private String STK_4_2_3; // 患者类别选择
    @Column(name = "STK_4_2_2_1")
    @JsonProperty("STK-4-2-2-1")
    private String STK_4_2_2_1; // 首剂用药日期时间
    @Column(name = "STK_4_3_2")
    @JsonProperty("STK-4-3-2")
    private String STK_4_3_2; // 药物选择
    @Column(name = "STK_4_3_1")
    @JsonProperty("STK-4-3-1")
    private String STK_4_3_1; // 其他抗血小板药物
    @Column(name = "STK_5_1")
    @JsonProperty("STK-5-1")
    private String STK_5_1; // 血脂评价时间的选择
    @Column(name = "STK_5_2")
    @JsonProperty("STK-5-2")
    private String STK_5_2; // 血脂评价结果
    @Column(name = "STK_5_3_1")
    @JsonProperty("STK-5-3-1")
    private String STK_5_3_1; // 是否有他汀药物禁忌症
    @Column(name = "STK_5_3_2")
    @JsonProperty("STK-5-3-2")
    private String STK_5_3_2; // 他汀类药物禁忌证的选择
    @Column(name = "STK_5_4")
    @JsonProperty("STK-5-4")
    private String STK_5_4; // 是否有用药长期医嘱-他汀类药物
    @Column(name = "STK_5_4_1")
    @JsonProperty("STK-5-4-1")
    private String STK_5_4_1; // 他汀类常用药物选择
    @Column(name = "STK_5_5_1")
    @JsonProperty("STK-5-5-1")
    private String STK_5_5_1; // 是否糖尿病患者
    @Column(name = "STK_5_5_2")
    @JsonProperty("STK-5-5-2")
    private String STK_5_5_2; // 选择降糖药物的类别
    @Column(name = "STK_5_5_2_1")
    @JsonProperty("STK-5-5-2-1")
    private String STK_5_5_2_1; // 其他降糖药物
    @Column(name = "STK_5_7_1")
    @JsonProperty("STK-5-7-1")
    private String STK_5_7_1; // 是否高血压患者
    @Column(name = "STK_5_7_2")
    @JsonProperty("STK-5-7-2")
    private String STK_5_7_2; // 选择降压药物的类别
    @Column(name = "STK_5_7_2_1")
    @JsonProperty("STK-5-7-2-1")
    private String STK_5_7_2_1; // 其它降压药物
    @Column(name = "STK_6_1")
    @JsonProperty("STK-6-1")
    private String STK_6_1; // 入院时是否正常进食与饮水
    @Column(name = "STK_6_2_0")
    @JsonProperty("STK-6-2-0")
    private String STK_6_2_0; // 是否进行吞咽评估
    @Column(name = "STK_6_2_1_1")
    @JsonProperty("STK-6-2-1-1")
    private String STK_6_2_1_1; // 首次吞咽困难评估日期时间
    @Column(name = "STK_6_3_1_2")
    @JsonProperty("STK-6-3-1-2")
    private String STK_6_3_1_2; // 评价方法选择
    @Column(name = "STK_6_3_1_1")
    @JsonProperty("STK-6-3-1-1")
    private String STK_6_3_1_1; // 其他评价方法填写
    @Column(name = "STK_6_3_2")
    @JsonProperty("STK-6-3-2")
    private String STK_6_3_2; // 未进行吞咽困难评价的原因
    @Column(name = "STK_6_3_2_1")
    @JsonProperty("STK-6-3-2-1")
    private String STK_6_3_2_1; // 其它未进行吞咽困难评价的原因
    @Column(name = "STK_7_1")
    @JsonProperty("STK-7-1")
    private String STK_7_1; // 入院后病情判定
    @Column(name = "STK_7_2_1")
    @JsonProperty("STK-7-2-1")
    private String STK_7_2_1; // 是否需要做预防DVT治疗
    @Column(name = "STK_7_2_2")
    @JsonProperty("STK-7-2-2")
    private String STK_7_2_2; // 禁忌证选择
    @Column(name = "STK_7_2_3_1_1")
    @JsonProperty("STK-7-2-3-1-1")
    private String STK_7_2_3_1_1; // 血栓泵-间歇充气加压治疗医嘱执行日期与时间
    @Column(name = "STK_8_1_2")
    @JsonProperty("STK-8-1-2")
    private String STK_8_1_2; // 出院时继续使用抗血小扳聚集治疗药物
    @Column(name = "STK_8_1_1")
    @JsonProperty("STK-8-1-1")
    private String STK_8_1_1; // 其他抗血小板聚集治疗药物
    @Column(name = "STK_8_2_2")
    @JsonProperty("STK-8-2-2")
    private String STK_8_2_2; // 出院时使用选择他汀类药物
    @Column(name = "STK_8_2_2_1")
    @JsonProperty("STK-8-2-2-1")
    private String STK_8_2_2_1; // 其他他汀类药物
    @Column(name = "STK_8_3_2")
    @JsonProperty("STK-8-3-2")
    private String STK_8_3_2; // 出院时使用抗凝药物
    @Column(name = "STK_8_3_2_1")
    @JsonProperty("STK-8-3-2-1")
    private String STK_8_3_2_1; // 其他抗凝药物
    @Column(name = "STK_8_4")
    @JsonProperty("STK-8-4")
    private String STK_8_4; // 出院时使用降糖药物的类别
    @Column(name = "STK_8_4_1")
    @JsonProperty("STK-8-4-1")
    private String STK_8_4_1; // 其他降糖药物
    @Column(name = "STK_8_5_0")
    @JsonProperty("STK-8-5-0")
    private String STK_8_5_0; // 是否出院时有高血压
    @Column(name = "STK_8_5")
    @JsonProperty("STK-8-5")
    private String STK_8_5; // 出院时有高血压患者选择降压药物的类别
    @Column(name = "STK_8_5_1")
    @JsonProperty("STK-8-5-1")
    private String STK_8_5_1; // 其他降压药物
    @Column(name = "STK_9_1")
    @JsonProperty("STK-9-1")
    private String STK_9_1; // 入院时是否有重点护理评估记录
    @Column(name = "STK_9_1_1")
    @JsonProperty("STK-9-1-1")
    private String STK_9_1_1; // 行走评估结果
    @Column(name = "STK_9_1_2")
    @JsonProperty("STK-9-1-2")
    private String STK_9_1_2; // 呼吸评估结果
    @Column(name = "STK_9_1_3")
    @JsonProperty("STK-9-1-3")
    private String STK_9_1_3; // 饮食评估结果
    @Column(name = "STK_9_1_4")
    @JsonProperty("STK-9-1-4")
    private String STK_9_1_4; // 吞咽评估结果
    @Column(name = "STK_9_1_5_1")
    @JsonProperty("STK-9-1-5-1")
    private String STK_9_1_5_1; // 压疮评估（Braden评分值）分值
    @Column(name = "STK_9_1_6")
    @JsonProperty("STK-9-1-6")
    private String STK_9_1_6; // 压疮评估结果选择
    @Column(name = "STK_9_1_7")
    @JsonProperty("STK-9-1-7")
    private String STK_9_1_7; // 预防压疮告知
    @Column(name = "STK_9_3_1")
    @JsonProperty("STK-9-3-1")
    private String STK_9_3_1; // 吸烟史
    @Column(name = "STK_9_3_2")
    @JsonProperty("STK-9-3-2")
    private String STK_9_3_2; // 吸烟程度评估
    @Column(name = "STK_9_3_3")
    @JsonProperty("STK-9-3-3")
    private String STK_9_3_3; // 接受戒烟的建议或者戒烟治疗
    @Column(name = "STK_13_1_1")
    @JsonProperty("STK-13-1-1")
    private String STK_13_1_1; // 是否提供早期康复医疗服务
    @Column(name = "STK_13_0")
    @JsonProperty("STK-13-0")
    private String STK_13_0; // 是否有功能障碍
    @Column(name = "STK_13_1")
    @JsonProperty("STK-13-1")
    private String STK_13_1; // 功能障碍评价
    @Column(name = "STK_13_2")
    @JsonProperty("STK-13-2")
    private String STK_13_2; // 康复治疗适宜性评估结果
    @Column(name = "STK_13_3")
    @JsonProperty("STK-13-3")
    private String STK_13_3; // 康复实施人员资质选择
    @Column(name = "STK_13_4_1")
    @JsonProperty("STK-13-4-1")
    private String STK_13_4_1; // 首次实施康复治疗时间
    @Column(name = "STK_13_5")
    @JsonProperty("STK-13-5")
    private String STK_13_5; // 选择未能进行康复原因
    @Column(name = "STK_10_1")
    @JsonProperty("STK-10-1")
    private String STK_10_1; // 血管功能评估时间
    @Column(name = "STK_10_2_2")
    @JsonProperty("STK-10-2-2")
    private String STK_10_2_2; // 血管功能评价（动脉粥样硬化病因检查）方法选择
    @Column(name = "STK_10_2_3")
    @JsonProperty("STK-10-2-3")
    private String STK_10_2_3; // 血管功能评估其他方法
    @Column(name = "STK_10_2_4")
    @JsonProperty("STK-10-2-4")
    private String STK_10_2_4; // 其他病因学检查方法选择
    @Column(name = "STK_10_2_5")
    @JsonProperty("STK-10-2-5")
    private String STK_10_2_5; // 其他病因学检查
    @Column(name = "STK_12_1_3")
    @JsonProperty("STK-12-1-3")
    private String STK_12_1_3; // 实施卒中健康教育有记录
    @Column(name = "STK_12_1_1")
    @JsonProperty("STK-12-1-1")
    private String STK_12_1_1; // 出院时Essen卒中风险评分
    @Column(name = "STK_12_1_2_1")
    @JsonProperty("STK-12-1-2-1")
    private String STK_12_1_2_1; // Essen卒中风险评分值
    @Column(name = "STK_12_2_1")
    @JsonProperty("STK-12-2-1")
    private String STK_12_2_1; // 主要风险因素(住院病历既往史记录)评估
    @Column(name = "STK_12_2_2")
    @JsonProperty("STK-12-2-2")
    private String STK_12_2_2; // 其他风险因素(住院病历既往史记录)评估
    @Column(name = "STK_12_4_1")
    @JsonProperty("STK-12-4-1")
    private String STK_12_4_1; // 是否有出院时mRS评分
    @Column(name = "STK_12_4_2")
    @JsonProperty("STK-12-4-2")
    private String STK_12_4_2; // 出院时mRS评分
    @Column(name = "STK_12_4_3")
    @JsonProperty("STK-12-4-3")
    private String STK_12_4_3; // 出院时mRS评分
    @Column(name = "STK_12_4_4")
    @JsonProperty("STK-12-4-4")
    private String STK_12_4_4; // 发病的主要原因
    @Column(name = "STK_12_4_4_1")
    @JsonProperty("STK-12-4-4-1")
    private String STK_12_4_4_1; // 其他发病的主要原因
    @Column(name = "STK_12_3_1")
    @JsonProperty("STK-12-3-1")
    private String STK_12_3_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "STK_12_3_2")
    @JsonProperty("STK-12-3-2")
    private String STK_12_3_2; // 出院带药
    @Column(name = "STK_12_3_5")
    @JsonProperty("STK-12-3-5")
    private String STK_12_3_5; // 告知何为风险因素与紧急情况
    @Column(name = "STK_12_3_3")
    @JsonProperty("STK-12-3-3")
    private String STK_12_3_3; // 告知发生紧急情况时求援救治途径
    @Column(name = "STK_12_3_4")
    @JsonProperty("STK-12-3-4")
    private String STK_12_3_4; // 出院时教育与随访
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