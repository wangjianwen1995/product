package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断原发病 ICD-10 编码：I05 至 I09、或 I11 至 I13、或 I20 至 I21、或 I40 至 I41、或 I42 至 I43 伴第二诊断为I50 的出院患者。
*/
@ApiModel(value = "02信息")
@Entity
@Data
@Table(name = "sd_info_HF")
public class SdInfoHF implements Serializable {
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
    private String CM_0_1_3_1; // 主要诊断或其他诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断或其他诊断ICD-10六位临床扩展编码与名称
    @Column(name = "HF_0_1_4_1")
    @JsonProperty("HF-0-1-4-1")
    private String HF_0_1_4_1; // 第一诊断或第二诊断对应的原发疾病ICD-10的三位类亚目编码与名称
    @Column(name = "HF_0_1_4_2")
    @JsonProperty("HF-0-1-4-2")
    private String HF_0_1_4_2; // 第一诊断或第二诊断对应的原发疾病ICD-10的三位类目编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为出院后31天内非计划重复住院
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
    private String CM_0_2_5_1; // 入住CCU日期时间
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开CCU日期时间
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
    @Column(name = "HF_1_1_1")
    @JsonProperty("HF-1-1-1")
    private String HF_1_1_1; // 是否实施首次X线胸片检查
    @Column(name = "HF_1_1_2")
    @JsonProperty("HF-1-1-2")
    private String HF_1_1_2; // 首次X线胸片检查报告日期时间
    @Column(name = "HF_1_1_3")
    @JsonProperty("HF-1-1-3")
    private String HF_1_1_3; // 首次X线胸片检查报告是否有肺淤血或肺水肿
    @Column(name = "HF_1_2_1")
    @JsonProperty("HF-1-2-1")
    private String HF_1_2_1; // 是否实施首次超声心动图(CDFA)检查
    @Column(name = "HF_1_2_2")
    @JsonProperty("HF-1-2-2")
    private String HF_1_2_2; // 报告日期时间
    @Column(name = "HF_1_2_3_4")
    @JsonProperty("HF-1-2-3-4")
    private String HF_1_2_3_4; // 左室舒张末内径（LVEDD）(mm)
    @Column(name = "HF_1_2_3_1")
    @JsonProperty("HF-1-2-3-1")
    private String HF_1_2_3_1; // 左室射血分（LVEF）测量值(%)
    @Column(name = "HF_1_2_3_2")
    @JsonProperty("HF-1-2-3-2")
    private String HF_1_2_3_2; // 左室射血分数评估结论
    @Column(name = "HF_1_2_3_3")
    @JsonProperty("HF-1-2-3-3")
    private String HF_1_2_3_3; // 是否有左心室室壁瘤
    @Column(name = "HF_1_3_1")
    @JsonProperty("HF-1-3-1")
    private String HF_1_3_1; // 实施首次评估患者的危险程度
    @Column(name = "HF_1_3_3")
    @JsonProperty("HF-1-3-3")
    private String HF_1_3_3; // Killip分级评估结果的选择
    @Column(name = "HF_1_3_2")
    @JsonProperty("HF-1-3-2")
    private String HF_1_3_2; // NYHA分级结果的选择
    @Column(name = "HF_1_3_5")
    @JsonProperty("HF-1-3-5")
    private String HF_1_3_5; // 是否为非瓣膜性房颤/房扑患者
    @Column(name = "HF_1_3_6_1")
    @JsonProperty("HF-1-3-6-1")
    private String HF_1_3_6_1; // 是否实施房颤患者风险评估
    @Column(name = "HF_1_3_6_2")
    @JsonProperty("HF-1-3-6-2")
    private String HF_1_3_6_2; // 房颤患者脑险评估分值
    @Column(name = "HF_1_3_6_3")
    @JsonProperty("HF-1-3-6-3")
    private String HF_1_3_6_3; // CHA2DS2-VASc评分大于2分
    @Column(name = "HF_1_4_1")
    @JsonProperty("HF-1-4-1")
    private String HF_1_4_1; // 急诊或入院后是否首次心电图（ECG）检查
    @Column(name = "HF_1_4_2")
    @JsonProperty("HF-1-4-2")
    private String HF_1_4_2; // 报告日期时间
    @Column(name = "HF_1_4_3")
    @JsonProperty("HF-1-4-3")
    private String HF_1_4_3; // QRS宽度(ms)
    @Column(name = "HF_1_4_4")
    @JsonProperty("HF-1-4-4")
    private String HF_1_4_4; // 心电图（ECG）检查结果选择
    @Column(name = "HF_1_4_4_1")
    @JsonProperty("HF-1-4-4-1")
    private String HF_1_4_4_1; // 其他心电图检查结果
    @Column(name = "HF_1_5_1_1")
    @JsonProperty("HF-1-5-1-1")
    private String HF_1_5_1_1; // 是否实施首次检测
    @Column(name = "HF_1_5_1_2")
    @JsonProperty("HF-1-5-1-2")
    private String HF_1_5_1_2; // 首次检测结果报告日期
    @Column(name = "HF_1_5_3")
    @JsonProperty("HF-1-5-3")
    private String HF_1_5_3; // 首次检测选择
    @Column(name = "HF_1_5_2_1")
    @JsonProperty("HF-1-5-2-1")
    private String HF_1_5_2_1; // 肌钙蛋白T（TnT）检测值(ng/mL)
    @Column(name = "HF_1_5_2_2")
    @JsonProperty("HF-1-5-2-2")
    private String HF_1_5_2_2; // 肌钙蛋白I（TnI）检测值(ng/mL)
    @Column(name = "HF_1_5_2_3")
    @JsonProperty("HF-1-5-2-3")
    private String HF_1_5_2_3; // 肌酸激酶同工酶（CK-MB）检测值(ng/mL)
    @Column(name = "HF_1_5_2_4")
    @JsonProperty("HF-1-5-2-4")
    private String HF_1_5_2_4; // 心肌肌红蛋白（Myo）检测值(ng/mL)
    @Column(name = "HF_1_5_2_5")
    @JsonProperty("HF-1-5-2-5")
    private String HF_1_5_2_5; // B型钠尿肽（BNP）检测值(ng/L)
    @Column(name = "HF_1_5_2_6")
    @JsonProperty("HF-1-5-2-6")
    private String HF_1_5_2_6; // N端B型钠尿肽前体（NT-ProBNP）检测值(ng/L)
    @Column(name = "HF_2_1_A")
    @JsonProperty("HF-2-1-A")
    private String HF_2_1_A; // 是否有利尿剂的禁忌证
    @Column(name = "HF_2_1")
    @JsonProperty("HF-2-1")
    private String HF_2_1; // 使用利尿剂的禁忌证选择
    @Column(name = "HF_2_1_1")
    @JsonProperty("HF-2-1-1")
    private String HF_2_1_1; // 其他使用利尿剂的禁忌证
    @Column(name = "HF_2_2")
    @JsonProperty("HF-2-2")
    private String HF_2_2; // 首剂用药日期时间
    @Column(name = "HF_2_3")
    @JsonProperty("HF-2-3")
    private String HF_2_3; // 常用利尿剂药物
    @Column(name = "HF_2_3_1")
    @JsonProperty("HF-2-3-1")
    private String HF_2_3_1; // 其他利尿剂药物填写
    @Column(name = "HF_2_2_dump")
    @JsonProperty("HF-2-2-dump")
    private String HF_2_2_dump; // 首剂利尿剂时长
    @Column(name = "HF_2_5")
    @JsonProperty("HF-2-5")
    private String HF_2_5; // 入院至使用首剂利尿剂时间大于24小时
    @Column(name = "HF_2_4")
    @JsonProperty("HF-2-4")
    private String HF_2_4; // 延迟治疗原因的选择
    @Column(name = "HF_2_4_1")
    @JsonProperty("HF-2-4-1")
    private String HF_2_4_1; // 其他延迟治疗原因
    @Column(name = "HF_3_1")
    @JsonProperty("HF-3-1")
    private String HF_3_1; // 左心室收缩功能障碍
    @Column(name = "HF_3_2_A")
    @JsonProperty("HF-3-2-A")
    private String HF_3_2_A; // 是否有ACEI抑制剂类药物禁忌证
    @Column(name = "HF_3_2_1")
    @JsonProperty("HF-3-2-1")
    private String HF_3_2_1; // ACEI抑制剂类药物禁忌证与须慎用的情况
    @Column(name = "HF_3_4_A")
    @JsonProperty("HF-3-4-A")
    private String HF_3_4_A; // ACE抑制剂药物
    @Column(name = "HF_3_4_A_1")
    @JsonProperty("HF-3-4-A-1")
    private String HF_3_4_A_1; // 其他ACEI药物
    @Column(name = "HF_3_4_B")
    @JsonProperty("HF-3-4-B")
    private String HF_3_4_B; // ARB类药物
    @Column(name = "HF_3_4_B_1")
    @JsonProperty("HF-3-4-B-1")
    private String HF_3_4_B_1; // 其他ARB类药物填写
    @Column(name = "HF_3_2_B")
    @JsonProperty("HF-3-2-B")
    private String HF_3_2_B; // 是否有ARNI类药物禁忌证
    @Column(name = "HF_3_2_2")
    @JsonProperty("HF-3-2-2")
    private String HF_3_2_2; // ARNI类药物禁忌证与须慎用的情况
    @Column(name = "HF_3_4_C")
    @JsonProperty("HF-3-4-C")
    private String HF_3_4_C; // 使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物的选择
    @Column(name = "HF_3_4_C_1")
    @JsonProperty("HF-3-4-C-1")
    private String HF_3_4_C_1; // 其他使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物
    @Column(name = "HF_3_3_1")
    @JsonProperty("HF-3-3-1")
    private String HF_3_3_1; // 首剂用药日期是否未确定
    @Column(name = "HF_3_3")
    @JsonProperty("HF-3-3")
    private String HF_3_3; // 首剂用药日期时间
    @Column(name = "HF_jump_2")
    @JsonProperty("HF-jump-2")
    private String HF_jump_2; // HF-jump-2
    @Column(name = "HF_3_6")
    @JsonProperty("HF-3-6")
    private String HF_3_6; // 入院至使用首剂ACEI/ARB类药物时间大于24小时
    @Column(name = "HF_3_5")
    @JsonProperty("HF-3-5")
    private String HF_3_5; // 延迟治疗原因
    @Column(name = "HF_3_5_1")
    @JsonProperty("HF-3-5-1")
    private String HF_3_5_1; // 其他延迟治疗原因
    @Column(name = "HF_4_1_1")
    @JsonProperty("HF-4-1-1")
    private String HF_4_1_1; // 是否有禁忌证与须慎用的情况
    @Column(name = "HF_4_1_2")
    @JsonProperty("HF-4-1-2")
    private String HF_4_1_2; // β-受体阻滞剂禁忌证选择
    @Column(name = "HF_4_3")
    @JsonProperty("HF-4-3")
    private String HF_4_3; // 使用首剂β-受体阻滞剂药物
    @Column(name = "HF_4_3_1")
    @JsonProperty("HF-4-3-1")
    private String HF_4_3_1; // 其他β-受体阻滞剂药物
    @Column(name = "HF_4_2_1")
    @JsonProperty("HF-4-2-1")
    private String HF_4_2_1; // 首剂用药日期是否未确定
    @Column(name = "HF_4_2")
    @JsonProperty("HF-4-2")
    private String HF_4_2; // 首剂用药日期时间
    @Column(name = "HF_jump_3")
    @JsonProperty("HF-jump-3")
    private String HF_jump_3; // HF-jump-3
    @Column(name = "HF_4_5")
    @JsonProperty("HF-4-5")
    private String HF_4_5; // 入院至使用首剂β-受体阻滞剂时间大于24小时
    @Column(name = "HF_4_4")
    @JsonProperty("HF-4-4")
    private String HF_4_4; // 延迟治疗原因
    @Column(name = "HF_4_4_1")
    @JsonProperty("HF-4-4-1")
    private String HF_4_4_1; // 其他延迟治疗原因
    @Column(name = "HF_5_1_1")
    @JsonProperty("HF-5-1-1")
    private String HF_5_1_1; // 是否有醛固酮受体拮抗剂的禁忌证
    @Column(name = "HF_5_1_2")
    @JsonProperty("HF-5-1-2")
    private String HF_5_1_2; // 醛固酮受体拮抗剂的禁忌证
    @Column(name = "HF_5_2")
    @JsonProperty("HF-5-2")
    private String HF_5_2; // 重度心衰使用醛固酮受体拮抗剂适用症
    @Column(name = "HF_5_2_1_1")
    @JsonProperty("HF-5-2-1-1")
    private String HF_5_2_1_1; // 其他重度心衰使用醛固酮受体拮抗剂适用症
    @Column(name = "HF_5_3_1")
    @JsonProperty("HF-5-3-1")
    private String HF_5_3_1; // 首剂用药日期是否未确定
    @Column(name = "HF_jump_4")
    @JsonProperty("HF-jump-4")
    private String HF_jump_4; // HF-jump-4
    @Column(name = "HF_5_3")
    @JsonProperty("HF-5-3")
    private String HF_5_3; // 首剂用药日期时间
    @Column(name = "HF_5_6")
    @JsonProperty("HF-5-6")
    private String HF_5_6; // 入院至使用首剂醛固酮受体拮抗剂时间大于24小时
    @Column(name = "HF_5_4")
    @JsonProperty("HF-5-4")
    private String HF_5_4; // 使用醛固酮受体拮抗剂
    @Column(name = "HF_5_4_1")
    @JsonProperty("HF-5-4-1")
    private String HF_5_4_1; // 其他醛固酮受体拮抗剂类药物
    @Column(name = "HF_5_5")
    @JsonProperty("HF-5-5")
    private String HF_5_5; // 延迟治疗原因
    @Column(name = "HF_5_5_1")
    @JsonProperty("HF-5-5-1")
    private String HF_5_5_1; // 其他延迟治疗原因
    @Column(name = "HF_6_1_1")
    @JsonProperty("HF-6-1-1")
    private String HF_6_1_1; // 是否有用药长期医嘱
    @Column(name = "HF_6_1_2")
    @JsonProperty("HF-6-1-2")
    private String HF_6_1_2; // 常用利尿剂药物的选择
    @Column(name = "HF_6_1_2_1")
    @JsonProperty("HF-6-1-2-1")
    private String HF_6_1_2_1; // 其他常用利尿剂
    @Column(name = "HF_6_2_1")
    @JsonProperty("HF-6-2-1")
    private String HF_6_2_1; // 是否有ACEI或ARB药物长期医嘱
    @Column(name = "HF_6_2_2")
    @JsonProperty("HF-6-2-2")
    private String HF_6_2_2; // 使用ACEI抑制剂或者ARB或者ARNI类药物选择
    @Column(name = "HF_6_2_2_A")
    @JsonProperty("HF-6-2-2-A")
    private String HF_6_2_2_A; // ACE抑制剂药物
    @Column(name = "HF_6_2_2_A_1")
    @JsonProperty("HF-6-2-2-A-1")
    private String HF_6_2_2_A_1; // 其他ACEI药物填写
    @Column(name = "HF_6_2_2_B")
    @JsonProperty("HF-6-2-2-B")
    private String HF_6_2_2_B; // ARB类药物
    @Column(name = "HF_6_2_2_B_1")
    @JsonProperty("HF-6-2-2-B-1")
    private String HF_6_2_2_B_1; // 其他ARB药物填写
    @Column(name = "HF_6_2_2_C")
    @JsonProperty("HF-6-2-2-C")
    private String HF_6_2_2_C; // 使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物的选择
    @Column(name = "HF_6_2_2_C_1")
    @JsonProperty("HF-6-2-2-C-1")
    private String HF_6_2_2_C_1; // 其他使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物
    @Column(name = "HF_6_3_1")
    @JsonProperty("HF-6-3-1")
    private String HF_6_3_1; // 是否有β受体阻滞剂药物医嘱
    @Column(name = "HF_6_3_2")
    @JsonProperty("HF-6-3-2")
    private String HF_6_3_2; // 使用首剂β-受体阻滞剂药物
    @Column(name = "HF_6_3_2_1")
    @JsonProperty("HF-6-3-2-1")
    private String HF_6_3_2_1; // 其他β-受体阻滞剂药物填写
    @Column(name = "HF_6_4_1")
    @JsonProperty("HF-6-4-1")
    private String HF_6_4_1; // 是否有醛固酮拮抗剂药物医嘱
    @Column(name = "HF_6_4_2")
    @JsonProperty("HF-6-4-2")
    private String HF_6_4_2; // 使用醛固酮受体拮抗剂
    @Column(name = "HF_6_4_2_1")
    @JsonProperty("HF-6-4-2-1")
    private String HF_6_4_2_1; // 其他醛固酮受体拮抗剂类药物填写
    @Column(name = "HF_6_5_1")
    @JsonProperty("HF-6-5-1")
    private String HF_6_5_1; // 是否常用抗凝药物
    @Column(name = "HF_6_5_2")
    @JsonProperty("HF-6-5-2")
    private String HF_6_5_2; // 选择抗凝药物
    @Column(name = "HF_6_5_2_1")
    @JsonProperty("HF-6-5-2-1")
    private String HF_6_5_2_1; // 其他抗凝药物
    @Column(name = "HF_7_1_1")
    @JsonProperty("HF-7-1-1")
    private String HF_7_1_1; // 出院带药医嘱中是否有继续使用利尿剂记录医嘱
    @Column(name = "HF_7_1_2")
    @JsonProperty("HF-7-1-2")
    private String HF_7_1_2; // 常用利尿剂药物
    @Column(name = "HF_7_1_2_1")
    @JsonProperty("HF-7-1-2-1")
    private String HF_7_1_2_1; // 其他常用利尿剂
    @Column(name = "HF_7_2_1")
    @JsonProperty("HF-7-2-1")
    private String HF_7_2_1; // 出院带药医嘱中是否有继续使用ACEI或ARB药物记录医嘱
    @Column(name = "HF_7_2_2")
    @JsonProperty("HF-7-2-2")
    private String HF_7_2_2; // 使用ACEI抑制剂或者ARB或者ARNI类药物选择
    @Column(name = "HF_7_2_2_A")
    @JsonProperty("HF-7-2-2-A")
    private String HF_7_2_2_A; // ACE抑制剂药物
    @Column(name = "HF_7_2_2_A_1")
    @JsonProperty("HF-7-2-2-A-1")
    private String HF_7_2_2_A_1; // 其他ACEI药物
    @Column(name = "HF_7_2_2_B")
    @JsonProperty("HF-7-2-2-B")
    private String HF_7_2_2_B; // ARB类药物
    @Column(name = "HF_7_2_2_B_1")
    @JsonProperty("HF-7-2-2-B-1")
    private String HF_7_2_2_B_1; // 其他ARB药物填写
    @Column(name = "HF_7_2_2_C")
    @JsonProperty("HF-7-2-2-C")
    private String HF_7_2_2_C; // 使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物的选择
    @Column(name = "HF_7_2_2_C_1")
    @JsonProperty("HF-7-2-2-C-1")
    private String HF_7_2_2_C_1; // 其他使用血管紧张素受体脑啡肽酶抑制剂（ARNI）类药物
    @Column(name = "HF_7_3_1")
    @JsonProperty("HF-7-3-1")
    private String HF_7_3_1; // 出院带药医嘱中是否有继续使用β受体阻滞剂药物医嘱
    @Column(name = "HF_7_3_2")
    @JsonProperty("HF-7-3-2")
    private String HF_7_3_2; // 使用首剂β-受体阻滞剂药物
    @Column(name = "HF_7_3_2_1")
    @JsonProperty("HF-7-3-2-1")
    private String HF_7_3_2_1; // 其他β-受体阻滞剂药物填写
    @Column(name = "HF_7_4_1")
    @JsonProperty("HF-7-4-1")
    private String HF_7_4_1; // 出院带药医嘱中是否有继续使用醛固酮拮抗剂药物医嘱
    @Column(name = "HF_7_4_2")
    @JsonProperty("HF-7-4-2")
    private String HF_7_4_2; // 使用醛固酮受体拮抗剂
    @Column(name = "HF_7_4_2_1")
    @JsonProperty("HF-7-4-2-1")
    private String HF_7_4_2_1; // 其他醛固酮受体拮抗剂
    @Column(name = "HF_7_5_1")
    @JsonProperty("HF-7-5-1")
    private String HF_7_5_1; // 出院带药医嘱中是否有继续使用使用抗凝药物医嘱
    @Column(name = "HF_7_5_2")
    @JsonProperty("HF-7-5-2")
    private String HF_7_5_2; // 选择抗凝药物
    @Column(name = "HF_7_5_2_1")
    @JsonProperty("HF-7-5-2-1")
    private String HF_7_5_2_1; // 其他抗凝药物
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
    @Column(name = "HF_8_1_1")
    @JsonProperty("HF-8-1-1")
    private String HF_8_1_1; // 是否有吸烟史
    @Column(name = "HF_8_1_2")
    @JsonProperty("HF-8-1-2")
    private String HF_8_1_2; // 吸烟程度评估有记录
    @Column(name = "HF_8_1_3")
    @JsonProperty("HF-8-1-3")
    private String HF_8_1_3; // 接受戒烟的建议或者戒烟治疗有记录
    @Column(name = "HF_8_2_1_A")
    @JsonProperty("HF-8-2-1-A")
    private String HF_8_2_1_A; // 心衰原发疾病评估与教育
    @Column(name = "HF_8_2_1_B")
    @JsonProperty("HF-8-2-1-B")
    private String HF_8_2_1_B; // 实施控制主要危险因素评估与教育
    @Column(name = "HF_8_2_2")
    @JsonProperty("HF-8-2-2")
    private String HF_8_2_2; // 对控制危险因素评估的结果进行针对性的教育
    @Column(name = "HF_8_3")
    @JsonProperty("HF-8-3")
    private String HF_8_3; // 二级预防
    @Column(name = "HF_8_4_1")
    @JsonProperty("HF-8-4-1")
    private String HF_8_4_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "HF_8_4_2")
    @JsonProperty("HF-8-4-2")
    private String HF_8_4_2; // 出院带药
    @Column(name = "HF_8_4_3")
    @JsonProperty("HF-8-4-3")
    private String HF_8_4_3; // 告知发生紧急情况时求援救治途径
    @Column(name = "HF_8_4_4")
    @JsonProperty("HF-8-4-4")
    private String HF_8_4_4; // 出院时教育与随访
    @Column(name = "HF_8_4_5")
    @JsonProperty("HF-8-4-5")
    private String HF_8_4_5; // 告知何为风险因素与紧急情况
    @Column(name = "HF_9_2_1_1")
    @JsonProperty("HF-9-2-1-1")
    private String HF_9_2_1_1; // 实施末次X线胸片检查
    @Column(name = "HF_9_2_1_2")
    @JsonProperty("HF-9-2-1-2")
    private String HF_9_2_1_2; // 是否有肺淤血或肺水肿
    @Column(name = "HF_9_2_2_1")
    @JsonProperty("HF-9-2-2-1")
    private String HF_9_2_2_1; // 是否实施末次超声心动图(CDFA)检查
    @Column(name = "HF_9_2_2_2_4")
    @JsonProperty("HF-9-2-2-2-4")
    private String HF_9_2_2_2_4; // QRS宽度(ms)
    @Column(name = "HF_9_2_2_2_1")
    @JsonProperty("HF-9-2-2-2-1")
    private String HF_9_2_2_2_1; // 左室射血分（LVEF）测量值(%)
    @Column(name = "HF_9_2_2_2_2")
    @JsonProperty("HF-9-2-2-2-2")
    private String HF_9_2_2_2_2; // 左室射血分数评估结论
    @Column(name = "HF_9_2_2_2_3")
    @JsonProperty("HF-9-2-2-2-3")
    private String HF_9_2_2_2_3; // 是否有左心室室壁瘤
    @Column(name = "HF_9_2_3_1")
    @JsonProperty("HF-9-2-3-1")
    private String HF_9_2_3_1; // 实施末次风险程度评估
    @Column(name = "HF_9_2_3_2_AB")
    @JsonProperty("HF-9-2-3-2-AB")
    private String HF_9_2_3_2_AB; // 末次风险程度评估
    @Column(name = "HF_9_2_3_2")
    @JsonProperty("HF-9-2-3-2")
    private String HF_9_2_3_2; // NYHA分级结果
    @Column(name = "HF_9_2_3_3")
    @JsonProperty("HF-9-2-3-3")
    private String HF_9_2_3_3; // Killip分级评估结果
    @Column(name = "HF_9_2_4_1")
    @JsonProperty("HF-9-2-4-1")
    private String HF_9_2_4_1; // 实施末次检测
    @Column(name = "HF_9_2_4_2")
    @JsonProperty("HF-9-2-4-2")
    private String HF_9_2_4_2; // 末次检测选择
    @Column(name = "HF_9_2_4_2_1")
    @JsonProperty("HF-9-2-4-2-1")
    private String HF_9_2_4_2_1; // 肌钙蛋白T（TnT）检测值(ng/mL)
    @Column(name = "HF_9_2_4_2_2")
    @JsonProperty("HF-9-2-4-2-2")
    private String HF_9_2_4_2_2; // 肌钙蛋白I（TnI）检测值(ng/mL)
    @Column(name = "HF_9_2_4_2_3")
    @JsonProperty("HF-9-2-4-2-3")
    private String HF_9_2_4_2_3; // 肌酸激酶同工酶（CK-MB）检测值(ng/mL)
    @Column(name = "HF_9_2_4_2_4")
    @JsonProperty("HF-9-2-4-2-4")
    private String HF_9_2_4_2_4; // 心肌肌红蛋白（Myo）检测值(ng/mL)
    @Column(name = "HF_9_2_4_2_5")
    @JsonProperty("HF-9-2-4-2-5")
    private String HF_9_2_4_2_5; // B型钠尿肽（BNP）检测值(ng/L)
    @Column(name = "HF_9_2_4_2_6")
    @JsonProperty("HF-9-2-4-2-6")
    private String HF_9_2_4_2_6; // N端B型钠尿肽前体（NT-ProBNP）检测值(ng/L)
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
    @Column(name = "HF_11_4_1")
    @JsonProperty("HF-11-4-1")
    private String HF_11_4_1; // 心脏再同步化临床应用符合适应症
    @Column(name = "HF_11_1_1")
    @JsonProperty("HF-11-1-1")
    private String HF_11_1_1; // CRT临床应用的适应证（Ⅰ类）选择
    @Column(name = "HF_11_1_2")
    @JsonProperty("HF-11-1-2")
    private String HF_11_1_2; // 安装心脏再同步治疗（CRT）装置
    @Column(name = "HF_11_1_3")
    @JsonProperty("HF-11-1-3")
    private String HF_11_1_3; // 安装日期时间
    @Column(name = "HF_11_1_4_1")
    @JsonProperty("HF-11-1-4-1")
    private String HF_11_1_4_1; // 心脏再同步治疗（CRT）装置生产企业
    @Column(name = "HF_11_1_4_2")
    @JsonProperty("HF-11-1-4-2")
    private String HF_11_1_4_2; // 心脏再同步治疗（CRT）装置型号
    @Column(name = "HF_11_1_4_3")
    @JsonProperty("HF-11-1-4-3")
    private String HF_11_1_4_3; // 心脏再同步治疗（CRT）装置的费用(元)
    @Column(name = "HF_11_5_1")
    @JsonProperty("HF-11-5-1")
    private String HF_11_5_1; // 是否有在药物优化治疗超过3个月后实施埋藏式心律转复除颤器（ICD）的记录
    @Column(name = "HF_11_5_2")
    @JsonProperty("HF-11-5-2")
    private String HF_11_5_2; // 心衰患者植入ICD适应证
    @Column(name = "HF_11_5_4")
    @JsonProperty("HF-11-5-4")
    private String HF_11_5_4; // 二级预防适应证
    @Column(name = "HF_11_5_3")
    @JsonProperty("HF-11-5-3")
    private String HF_11_5_3; // 一级预防适应证
    @Column(name = "HF_11_5_3_1")
    @JsonProperty("HF-11-5-3-1")
    private String HF_11_5_3_1; // 缺血性心脏病患者
    @Column(name = "HF_11_5_3_2")
    @JsonProperty("HF-11-5-3-2")
    private String HF_11_5_3_2; // 非缺血性心衰患者
    @Column(name = "HF_11_2_2")
    @JsonProperty("HF-11-2-2")
    private String HF_11_2_2; // 是否安装埋藏式心律转复除颤器（ICD）装置
    @Column(name = "HF_11_2_3")
    @JsonProperty("HF-11-2-3")
    private String HF_11_2_3; // 安装日期时间
    @Column(name = "HF_11_2_4_1")
    @JsonProperty("HF-11-2-4-1")
    private String HF_11_2_4_1; // 埋藏式心律转复除颤器（ICD）装置生产企业
    @Column(name = "HF_11_2_4_2")
    @JsonProperty("HF-11-2-4-2")
    private String HF_11_2_4_2; // 埋藏式心律转复除颤器（ICD）装置型号
    @Column(name = "HF_11_2_5")
    @JsonProperty("HF-11-2-5")
    private String HF_11_2_5; // 埋藏式心律转复除颤器（ICD）装置的费用(元)
    @Column(name = "HF_11_3_1")
    @JsonProperty("HF-11-3-1")
    private String HF_11_3_1; // 通过优化流程实现从医院到社区的无缝衔接
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