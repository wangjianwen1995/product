package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：J45，J46；2 岁≤年龄＜18 岁的出院患儿。
*/
@ApiModel(value = "22信息")
@Entity
@Data
@Table(name = "sd_info_CAC2")
public class SdInfoCAC2 implements Serializable {
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
    @Column(name = "CACC_0_1_4_1")
    @JsonProperty("CACC-0-1-4-1")
    private String CACC_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CACC_0_1_4_2")
    @JsonProperty("CACC-0-1-4-2")
    private String CACC_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否出院后31天内重复住院
    @Column(name = "CM_0_2_1_1")
    @JsonProperty("CM-0-2-1-1")
    private String CM_0_2_1_1; // 出生日期
    @Column(name = "CACC_0_2_1_1")
    @JsonProperty("CACC-0-2-1-1")
    private String CACC_0_2_1_1; // 患儿年龄分组
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
    @Column(name = "CACC_1_1_1")
    @JsonProperty("CACC-1-1-1")
    private String CACC_1_1_1; // 儿童哮喘急性发作入院标准
    @Column(name = "CACC_1_1_1_1")
    @JsonProperty("CACC-1-1-1-1")
    private String CACC_1_1_1_1; // 符合儿童哮喘急性发作入院标准的选择
    @Column(name = "CACC_1_1_1_2")
    @JsonProperty("CACC-1-1-1-2")
    private String CACC_1_1_1_2; // 符合哮喘儿童急性发作入住 ICU标准的选择
    @Column(name = "CACC_1_2_1")
    @JsonProperty("CACC-1-2-1")
    private String CACC_1_2_1; // 危险因素的选择
    @Column(name = "CACC_1_2_1_1")
    @JsonProperty("CACC-1-2-1-1")
    private String CACC_1_2_1_1; // 其他危险因素
    @Column(name = "CACC_1_3_1")
    @JsonProperty("CACC-1-3-1")
    private String CACC_1_3_1; // 严重程度评判的客观指标的选择
    @Column(name = "CACC_1_3_1_1")
    @JsonProperty("CACC-1-3-1-1")
    private String CACC_1_3_1_1; // 严重程度评判的其他客观指标
    @Column(name = "CACC_1_3_2")
    @JsonProperty("CACC-1-3-2")
    private String CACC_1_3_2; // 是否作严重程度评估的
    @Column(name = "CACC_1_3_3")
    @JsonProperty("CACC-1-3-3")
    private String CACC_1_3_3; // ＜6岁CAC严重程度评估结论的分级
    @Column(name = "CACC_1_3_4")
    @JsonProperty("CACC-1-3-4")
    private String CACC_1_3_4; // ≥6岁CAC严重程度评估结论的分级
    @Column(name = "CACC_2_1_1")
    @JsonProperty("CACC-2-1-1")
    private String CACC_2_1_1; // 氧疗方法途径
    @Column(name = "CACC_2_1_2")
    @JsonProperty("CACC-2-1-2")
    private String CACC_2_1_2; // 氧疗后是否进行复查动脉血气
    @Column(name = "CACC_2_1_2_1")
    @JsonProperty("CACC-2-1-2-1")
    private String CACC_2_1_2_1; // 复查动脉血气 血氧饱和度(%)
    @Column(name = "CACC_2_2_1")
    @JsonProperty("CACC-2-2-1")
    private String CACC_2_2_1; // 是否实施速效β2受体激动剂（SABA）治疗
    @Column(name = "CACC_2_2_2")
    @JsonProperty("CACC-2-2-2")
    private String CACC_2_2_2; // 实施首次速效β2受体激动剂（SABA）治疗途径的选择
    @Column(name = "CACC_2_2_3")
    @JsonProperty("CACC-2-2-3")
    private String CACC_2_2_3; // 常用的速效β2受体激动剂（SABA）的选择
    @Column(name = "CACC_2_2_3_1")
    @JsonProperty("CACC-2-2-3-1")
    private String CACC_2_2_3_1; // 常用的其他速效β2受体激动剂（SABA）
    @Column(name = "CACC_2_3_1")
    @JsonProperty("CACC-2-3-1")
    private String CACC_2_3_1; // 是否吸入糖皮质激素（ICS）治疗
    @Column(name = "CACC_2_3_2")
    @JsonProperty("CACC-2-3-2")
    private String CACC_2_3_2; // 常用的吸入糖皮质激素（ICS）的选择
    @Column(name = "CACC_2_3_2_1")
    @JsonProperty("CACC-2-3-2-1")
    private String CACC_2_3_2_1; // 常用的其他吸入糖皮质激素（ICS）
    @Column(name = "CACC_2_3_3")
    @JsonProperty("CACC-2-3-3")
    private String CACC_2_3_3; // 是否吸入糖皮吸入糖皮质激素（ICS）剂量的选择质激素（ICS）治疗
    @Column(name = "CACC_2_4_3")
    @JsonProperty("CACC-2-4-3")
    private String CACC_2_4_3; // 是否使用常用的抗胆碱能药物
    @Column(name = "CACC_2_4_1")
    @JsonProperty("CACC-2-4-1")
    private String CACC_2_4_1; // 常用的抗胆碱能药物
    @Column(name = "CACC_2_4_1_1")
    @JsonProperty("CACC-2-4-1-1")
    private String CACC_2_4_1_1; // 其他抗胆碱能药物
    @Column(name = "CACC_2_4_4")
    @JsonProperty("CACC-2-4-4")
    private String CACC_2_4_4; // 是否使用茶碱类药物
    @Column(name = "CACC_2_4_2")
    @JsonProperty("CACC-2-4-2")
    private String CACC_2_4_2; // 茶碱类药物
    @Column(name = "CACC_2_4_2_1")
    @JsonProperty("CACC-2-4-2-1")
    private String CACC_2_4_2_1; // 其他茶碱类药物
    @Column(name = "CACC_3_1_1")
    @JsonProperty("CACC-3-1-1")
    private String CACC_3_1_1; // 是否长效β2受体激动剂（LABA）治疗
    @Column(name = "CACC_3_1_2")
    @JsonProperty("CACC-3-1-2")
    private String CACC_3_1_2; // 常用的长效β2受体激动剂（LABA）
    @Column(name = "CACC_3_1_2_1")
    @JsonProperty("CACC-3-1-2-1")
    private String CACC_3_1_2_1; // 其他长效β2受体激动剂（LABA）药物
    @Column(name = "CACC_3_2_1")
    @JsonProperty("CACC-3-2-1")
    private String CACC_3_2_1; // 是否白三烯调节剂治疗
    @Column(name = "CACC_3_2_2")
    @JsonProperty("CACC-3-2-2")
    private String CACC_3_2_2; // 常用的三白烯调节剂
    @Column(name = "CACC_3_2_2_1")
    @JsonProperty("CACC-3-2-2-1")
    private String CACC_3_2_2_1; // 其他白三烯调节剂药物
    @Column(name = "CACC_3_3_1")
    @JsonProperty("CACC-3-3-1")
    private String CACC_3_3_1; // 是否变应原特异免疫（SIT）治疗
    @Column(name = "CACC_3_3_2")
    @JsonProperty("CACC-3-3-2")
    private String CACC_3_3_2; // 选用药物
    @Column(name = "CACC_3_3_3")
    @JsonProperty("CACC-3-3-3")
    private String CACC_3_3_3; // 治疗途径
    @Column(name = "CACC_4_1_1")
    @JsonProperty("CACC-4-1-1")
    private String CACC_4_1_1; // 是否应用全身糖皮质激素
    @Column(name = "CACC_4_1_2")
    @JsonProperty("CACC-4-1-2")
    private String CACC_4_1_2; // 糖皮质激素（ICS）治疗途径的选择
    @Column(name = "CACC_4_1_3")
    @JsonProperty("CACC-4-1-3")
    private String CACC_4_1_3; // 全身使用糖皮质激素药物情况
    @Column(name = "CACC_4_1_3_1")
    @JsonProperty("CACC-4-1-3-1")
    private String CACC_4_1_3_1; // 全身使用其他糖皮质激素药物
    @Column(name = "CACC_4_2_1")
    @JsonProperty("CACC-4-2-1")
    private String CACC_4_2_1; // 全身糖皮质激素医嘱使用起始日期时间
    @Column(name = "CACC_4_2_2")
    @JsonProperty("CACC-4-2-2")
    private String CACC_4_2_2; // 全身糖皮质激素医嘱使用终止日期
    @Column(name = "CACC_4_2_3")
    @JsonProperty("CACC-4-2-3")
    private String CACC_4_2_3; // 全身糖皮质激素使用天数(天)
    @Column(name = "CACC_5_1_1")
    @JsonProperty("CACC-5-1-1")
    private String CACC_5_1_1; // 符合出院标准
    @Column(name = "CACC_5_2_1")
    @JsonProperty("CACC-5-2-1")
    private String CACC_5_2_1; // 出院带药
    @Column(name = "CACC_5_2_1_1")
    @JsonProperty("CACC-5-2-1-1")
    private String CACC_5_2_1_1; // 其他出院带药
    @Column(name = "CACC_6_1_1")
    @JsonProperty("CACC-6-1-1")
    private String CACC_6_1_1; // 是否对患儿家长与患儿进行如何正确使用吸入装置操作和吸入技术培训教育
    @Column(name = "CACC_6_1_2")
    @JsonProperty("CACC-6-1-2")
    private String CACC_6_1_2; // 如何正确使用吸入装置操作和吸入技术的培训教育
    @Column(name = "CACC_6_1_2_1")
    @JsonProperty("CACC-6-1-2-1")
    private String CACC_6_1_2_1; // 其他危险因素
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    @Column(name = "CACC_6_2_4")
    @JsonProperty("CACC-6-2-4")
    private String CACC_6_2_4; // 告知患儿进入慢性持续期和临床缓解期，需要进一步控制治疗
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
    private String CM_5_1; // 患儿家长是否对服务的体验与评价
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