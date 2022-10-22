package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断/其他诊断 ICD-10 编码：A02.1，A22.7，A32.7，A40.1 至 A40.9， A41.0 至 A41.9，A42.7，A54.8，B73.7，R65.2，R65.3，R65.9 的出院患者。
*/
@ApiModel(value = "47信息")
@Entity
@Data
@Table(name = "sd_info_SEP")
public class SdInfoSEP implements Serializable {
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
    private String CM_0_1_3_1; // 主要/其他诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要/其他诊断ICD-10六位临床扩展编码与名称
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
    private String CM_0_1_5; // SEP出院后31天内是否重复住院
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
    @Column(name = "SEP_1_1_1")
    @JsonProperty("SEP-1-1-1")
    private String SEP_1_1_1; // 初始SEP日期时间
    @Column(name = "SEP_1_3_1_1")
    @JsonProperty("SEP-1-3-1-1")
    private String SEP_1_3_1_1; // 存在"败血症"诊断
    @Column(name = "SEP_1_3_1_2")
    @JsonProperty("SEP-1-3-1-2")
    private String SEP_1_3_1_2; // 血清乳酸水平
    @Column(name = "SEP_1_3_1_3")
    @JsonProperty("SEP-1-3-1-3")
    private String SEP_1_3_1_3; // 血清乳酸水平首次测定值的日期与时间
    @Column(name = "SEP_1_3_2_1")
    @JsonProperty("SEP-1-3-2-1")
    private String SEP_1_3_2_1; // 存在"脓毒血症/脓毒性休克/ 感染性休克"诊断
    @Column(name = "SEP_1_3_2_2")
    @JsonProperty("SEP-1-3-2-2")
    private String SEP_1_3_2_2; // 连续二次监测为低血压
    @Column(name = "SEP_1_3_2_3")
    @JsonProperty("SEP-1-3-2-3")
    private String SEP_1_3_2_3; // 第二次测量血压为持续性低血压的日期时间
    @Column(name = "SEP_2_1_1")
    @JsonProperty("SEP-2-1-1")
    private String SEP_2_1_1; // 是否在使用抗菌药物之前获得血液培养
    @Column(name = "SEP_2_1_2_2")
    @JsonProperty("SEP-2-1-2-2")
    private String SEP_2_1_2_2; // 血液培养标本采集日期时间是否确定
    @Column(name = "SEP_2_1_2")
    @JsonProperty("SEP-2-1-2")
    private String SEP_2_1_2; // 血液培养标本采集日期时间
    @Column(name = "SEP_2_1_3_2")
    @JsonProperty("SEP-2-1-3-2")
    private String SEP_2_1_3_2; // 病原学诊断报告日期时间是否确定
    @Column(name = "SEP_2_1_3_1")
    @JsonProperty("SEP-2-1-3-1")
    private String SEP_2_1_3_1; // 病原学诊断报告日期时间
    @Column(name = "SEP_2_1_4")
    @JsonProperty("SEP-2-1-4")
    private String SEP_2_1_4; // 病原学诊断结果选择
    @Column(name = "SEP_2_1_4_1")
    @JsonProperty("SEP-2-1-4-1")
    private String SEP_2_1_4_1; // 其他病原学诊断结果
    @Column(name = "SEP_2_2_1")
    @JsonProperty("SEP-2-2-1")
    private String SEP_2_2_1; // 是否有使用静脉注射广谱或其他抗菌药物的信息
    @Column(name = "SEP_2_2_2_2")
    @JsonProperty("SEP-2-2-2-2")
    private String SEP_2_2_2_2; // 给予抗菌药物静脉内给药的最早日期时间是否确定
    @Column(name = "SEP_2_2_2_1")
    @JsonProperty("SEP-2-2-2-1")
    private String SEP_2_2_2_1; // 给予抗菌药物静脉内给药的最早日期时间
    @Column(name = "SEP_2_2_3")
    @JsonProperty("SEP-2-2-3")
    private String SEP_2_2_3; // 使用广谱或其他抗抗感染药物选择
    @Column(name = "SEP_2_2_3_1")
    @JsonProperty("SEP-2-2-3-1")
    private String SEP_2_2_3_1; // 青霉素类抗感染药物
    @Column(name = "SEP_2_2_3_1_1")
    @JsonProperty("SEP-2-2-3-1-1")
    private String SEP_2_2_3_1_1; // 其他青霉素类抗菌药
    @Column(name = "SEP_2_2_3_2")
    @JsonProperty("SEP-2-2-3-2")
    private String SEP_2_2_3_2; // 头孢菌素类抗感染药物
    @Column(name = "SEP_2_2_3_2_1")
    @JsonProperty("SEP-2-2-3-2-1")
    private String SEP_2_2_3_2_1; // 其他头孢菌素类抗菌药
    @Column(name = "SEP_2_2_3_3")
    @JsonProperty("SEP-2-2-3-3")
    private String SEP_2_2_3_3; // 大环内酯类抗感染药物
    @Column(name = "SEP_2_2_3_3_1")
    @JsonProperty("SEP-2-2-3-3-1")
    private String SEP_2_2_3_3_1; // 其他大环内酯类抗菌药
    @Column(name = "SEP_2_2_3_4")
    @JsonProperty("SEP-2-2-3-4")
    private String SEP_2_2_3_4; // 喹诺酮类抗感染药物
    @Column(name = "SEP_2_2_3_4_1")
    @JsonProperty("SEP-2-2-3-4-1")
    private String SEP_2_2_3_4_1; // 其他-喹诺酮类抗菌药
    @Column(name = "SEP_2_2_3_5")
    @JsonProperty("SEP-2-2-3-5")
    private String SEP_2_2_3_5; // 其他类抗感染药物
    @Column(name = "SEP_2_2_3_5_1")
    @JsonProperty("SEP-2-2-3-5-1")
    private String SEP_2_2_3_5_1; // 其他抗菌药
    @Column(name = "SEP_2_3_1")
    @JsonProperty("SEP-2-3-1")
    private String SEP_2_3_1; // 是否有初始乳酸水平测量
    @Column(name = "SEP_2_3_2_2")
    @JsonProperty("SEP-2-3-2-2")
    private String SEP_2_3_2_2; // 标本采集日期时间是否确定
    @Column(name = "SEP_2_3_2_1")
    @JsonProperty("SEP-2-3-2-1")
    private String SEP_2_3_2_1; // 标本采集日期时间
    @Column(name = "SEP_2_3_3_2")
    @JsonProperty("SEP-2-3-3-2")
    private String SEP_2_3_3_2; // 初始乳酸水平测定报告日期时间是否确定
    @Column(name = "SEP_2_3_3_1")
    @JsonProperty("SEP-2-3-3-1")
    private String SEP_2_3_3_1; // 初始乳酸水平测定报告日期时间
    @Column(name = "SEP_2_3_4")
    @JsonProperty("SEP-2-3-4")
    private String SEP_2_3_4; // 初始乳酸水平测量值(mmol / L)
    @Column(name = "SEP_2_3_5")
    @JsonProperty("SEP-2-3-5")
    private String SEP_2_3_5; // 判定初始乳酸水平测量值评估结果
    @Column(name = "SEP_2_4_1")
    @JsonProperty("SEP-2-4-1")
    private String SEP_2_4_1; // 在时间窗内,是否经静脉给予复苏液体
    @Column(name = "SEP_2_4_2")
    @JsonProperty("SEP-2-4-2")
    private String SEP_2_4_2; // 在时间窗内经静脉补给复苏液体量
    @Column(name = "SEP_2_4_3")
    @JsonProperty("SEP-2-4-3")
    private String SEP_2_4_3; // 患者体重
    @Column(name = "SEP_2_4_4")
    @JsonProperty("SEP-2-4-4")
    private String SEP_2_4_4; // 给予复苏液体种类
    @Column(name = "SEP_2_4_2_1")
    @JsonProperty("SEP-2-4-2-1")
    private String SEP_2_4_2_1; // 复苏液体给药日期时间是否确定
    @Column(name = "SEP_2_4_2_2")
    @JsonProperty("SEP-2-4-2-2")
    private String SEP_2_4_2_2; // 复苏液体给药日期时间
    @Column(name = "SEP_3_1_1")
    @JsonProperty("SEP-3-1-1")
    private String SEP_3_1_1; // 给予复苏液体补充液后使用升压药物指征
    @Column(name = "SEP_3_1_2")
    @JsonProperty("SEP-3-1-2")
    private String SEP_3_1_2; // 首次,选择使用升压药物名称
    @Column(name = "SEP_3_1_2_1")
    @JsonProperty("SEP-3-1-2-1")
    private String SEP_3_1_2_1; // 其他升压药物名称
    @Column(name = "SEP_3_1_4")
    @JsonProperty("SEP-3-1-4")
    private String SEP_3_1_4; // 首次,使用升压药物的途径
    @Column(name = "SEP_3_1_4_1")
    @JsonProperty("SEP-3-1-4-1")
    private String SEP_3_1_4_1; // 其他升压药物的途径
    @Column(name = "SEP_3_1_3_2")
    @JsonProperty("SEP-3-1-3-2")
    private String SEP_3_1_3_2; // 首次,使用升压药物的日期时间是否确定
    @Column(name = "SEP_3_1_3_1")
    @JsonProperty("SEP-3-1-3-1")
    private String SEP_3_1_3_1; // 首次,使用升压药物的日期时间
    @Column(name = "SEP_3_2_1")
    @JsonProperty("SEP-3-2-1")
    private String SEP_3_2_1; // 是否进行2次及以上乳酸水平测量
    @Column(name = "SEP_3_2_2_2")
    @JsonProperty("SEP-3-2-2-2")
    private String SEP_3_2_2_2; // 重复乳酸水平测量，末次标本采集时间是否确定
    @Column(name = "SEP_3_2_2_1")
    @JsonProperty("SEP-3-2-2-1")
    private String SEP_3_2_2_1; // 重复乳酸水平测量，末次标本采集时间
    @Column(name = "SEP_3_2_3_2")
    @JsonProperty("SEP-3-2-3-2")
    private String SEP_3_2_3_2; // 末次乳酸水平测量报告时间是否确定
    @Column(name = "SEP_3_2_3_1")
    @JsonProperty("SEP-3-2-3-1")
    private String SEP_3_2_3_1; // 末次乳酸水平测量报告时间
    @Column(name = "SEP_3_2_4")
    @JsonProperty("SEP-3-2-4")
    private String SEP_3_2_4; // 末次，重复乳酸水平测量值（mmol / L）
    @Column(name = "SEP_3_2_5")
    @JsonProperty("SEP-3-2-5")
    private String SEP_3_2_5; // 判定末次乳酸水平测量值评估结果分层
    @Column(name = "SEP_3_3_1")
    @JsonProperty("SEP-3-3-1")
    private String SEP_3_3_1; // 在时间窗口是否进行了复苏和组织灌注状态评估
    @Column(name = "SEP_3_3_2")
    @JsonProperty("SEP-3-3-2")
    private String SEP_3_3_2; // 常用评估项目 
    @Column(name = "SEP_3_3_3_2")
    @JsonProperty("SEP-3-3-3-2")
    private String SEP_3_3_3_2; // 上述a至h中最后一个项目完成的时间是否确定
    @Column(name = "SEP_3_3_3_1")
    @JsonProperty("SEP-3-3-3-1")
    private String SEP_3_3_3_1; // 上述a至h中最后一个项目完成的时间
    @Column(name = "SEP_3_3_4")
    @JsonProperty("SEP-3-3-4")
    private String SEP_3_3_4; // 评估其他相关测量值 
    @Column(name = "SEP_3_3_4_1")
    @JsonProperty("SEP-3-3-4-1")
    private String SEP_3_3_4_1; // 其他评估相关测量值
    @Column(name = "SEP_3_3_5_2")
    @JsonProperty("SEP-3-3-5-2")
    private String SEP_3_3_5_2; // 上述a至d中最后一个项目完成的时间是否确定
    @Column(name = "SEP_3_3_5_1")
    @JsonProperty("SEP-3-3-5-1")
    private String SEP_3_3_5_1; // 上述a至d中最后一个项目完成的时间
    @Column(name = "SEP_4_1_1")
    @JsonProperty("SEP-4-1-1")
    private String SEP_4_1_1; // 是否由急诊科/ICU集束治疗后转至本院其他科室
    @Column(name = "SEP_4_1_2")
    @JsonProperty("SEP-4-1-2")
    private String SEP_4_1_2; // 由急诊科/ICU集束治疗后转至本院其他科室
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