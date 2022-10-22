package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：C92.4，且伴主要操作 ICD-9-CM-3编码：99.25 的出院患儿。
*/
@ApiModel(value = "49信息")
@Entity
@Data
@Table(name = "sd_info_APL")
public class SdInfoAPL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id; 
    @Column(name = "APL_0_1_1")
    @JsonProperty("APL-0-1-1")
    private String APL_0_1_1; // 治疗模式
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
    @Column(name = "APL_0_1_3_1")
    @JsonProperty("APL-0-1-3-1")
    private String APL_0_1_3_1; // 其他主要诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "APL_0_1_3_2")
    @JsonProperty("APL-0-1-3-2")
    private String APL_0_1_3_2; // 其他主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "APL_0_1_4_1")
    @JsonProperty("APL-0-1-4-1")
    private String APL_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "APL_0_1_4_2")
    @JsonProperty("APL-0-1-4-2")
    private String APL_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "APL_0_1_5_1")
    @JsonProperty("APL-0-1-5-1")
    private String APL_0_1_5_1; // 出院诊断ICD-10六位临床扩展编码与名称
    @Column(name = "APL_0_1_5_2")
    @JsonProperty("APL-0-1-5-2")
    private String APL_0_1_5_2; // 其他出院诊断ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否出院后31天内非计划重复住院
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
    @Column(name = "APL_0_2_3_1")
    @JsonProperty("APL-0-2-3-1")
    private String APL_0_2_3_1; // 入住日间化疗日期时间是否无法确定或无记录
    @Column(name = "APL_0_2_3_2")
    @JsonProperty("APL-0-2-3-2")
    private String APL_0_2_3_2; // 入住日间化疗日期时间
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
    @Column(name = "APL_1_1_1")
    @JsonProperty("APL-1-1-1")
    private String APL_1_1_1; // 血液常规、生化、凝血检查
    @Column(name = "APL_1_1_1_1")
    @JsonProperty("APL-1-1-1-1")
    private String APL_1_1_1_1; // 血液常规、生化、凝血其他检查
    @Column(name = "APL_1_1_2")
    @JsonProperty("APL-1-1-2")
    private String APL_1_1_2; // 是否进行骨髓检查
    @Column(name = "APL_1_1_3")
    @JsonProperty("APL-1-1-3")
    private String APL_1_1_3; // 细胞遗传学及分子生物学检查
    @Column(name = "APL_1_1_3_1")
    @JsonProperty("APL-1-1-3-1")
    private String APL_1_1_3_1; // 细胞遗传学及分子生物学其他检查
    @Column(name = "APL_1_1_4")
    @JsonProperty("APL-1-1-4")
    private String APL_1_1_4; // 脑脊液检查
    @Column(name = "APL_1_1_5_1")
    @JsonProperty("APL-1-1-5-1")
    private String APL_1_1_5_1; // 脑脊液其他检查
    @Column(name = "APL_1_1_5")
    @JsonProperty("APL-1-1-5")
    private String APL_1_1_5; // 上述四项，最末一项检查完成日期
    @Column(name = "APL_1_1_6")
    @JsonProperty("APL-1-1-6")
    private String APL_1_1_6; // 影像学检查
    @Column(name = "APL_1_1_6_1")
    @JsonProperty("APL-1-1-6-1")
    private String APL_1_1_6_1; // 影像学其他检查
    @Column(name = "APL_2_1_1")
    @JsonProperty("APL-2-1-1")
    private String APL_2_1_1; // 诊断符合标准
    @Column(name = "APL_2_1_1_1")
    @JsonProperty("APL-2-1-1-1")
    private String APL_2_1_1_1; // 其他疾病诊断
    @Column(name = "APL_2_1_2")
    @JsonProperty("APL-2-1-2")
    private String APL_2_1_2; // 临床危险度分层
    @Column(name = "APL_3_1_1")
    @JsonProperty("APL-3-1-1")
    private String APL_3_1_1; // 是否有诱导期化疗前准备
    @Column(name = "APL_3_1_2")
    @JsonProperty("APL-3-1-2")
    private String APL_3_1_2; // 化疗前准备
    @Column(name = "APL_3_1_2_1")
    @JsonProperty("APL-3-1-2-1")
    private String APL_3_1_2_1; // 化疗前其他治疗用药
    @Column(name = "APL_3_2_1")
    @JsonProperty("APL-3-2-1")
    private String APL_3_2_1; // 用药分组的选择
    @Column(name = "APL_3_2_2")
    @JsonProperty("APL-3-2-2")
    private String APL_3_2_2; // 低危组--诱导治疗用药的选择
    @Column(name = "APL_3_2_2_1")
    @JsonProperty("APL-3-2-2-1")
    private String APL_3_2_2_1; // 全反式维甲酸
    @Column(name = "APL_3_2_2_2")
    @JsonProperty("APL-3-2-2-2")
    private String APL_3_2_2_2; // 其他全反式维甲酸用药(mg/m²/d)
    @Column(name = "APL_3_2_2_3")
    @JsonProperty("APL-3-2-2-3")
    private String APL_3_2_2_3; // 其他全反式维甲酸用药天数(d)
    @Column(name = "APL_3_2_2_4")
    @JsonProperty("APL-3-2-2-4")
    private String APL_3_2_2_4; // 三氧化二砷
    @Column(name = "APL_3_2_2_5")
    @JsonProperty("APL-3-2-2-5")
    private String APL_3_2_2_5; // 其他三氧化二砷用药(mg/kg/d)
    @Column(name = "APL_3_2_2_6")
    @JsonProperty("APL-3-2-2-6")
    private String APL_3_2_2_6; // 其他三氧化二砷用药天数(d)
    @Column(name = "APL_3_2_2_7")
    @JsonProperty("APL-3-2-2-7")
    private String APL_3_2_2_7; // 复方黄黛片
    @Column(name = "APL_3_2_2_8")
    @JsonProperty("APL-3-2-2-8")
    private String APL_3_2_2_8; // 其他复方黄黛片用药(mg/kg/d)
    @Column(name = "APL_3_2_2_9")
    @JsonProperty("APL-3-2-2-9")
    private String APL_3_2_2_9; // 其他复方黄黛片用药天数(d)
    @Column(name = "APL_3_2_2_10")
    @JsonProperty("APL-3-2-2-10")
    private String APL_3_2_2_10; // 其他治疗药品名称
    @Column(name = "APL_3_2_2_11")
    @JsonProperty("APL-3-2-2-11")
    private String APL_3_2_2_11; // 其他治疗用药(mg/m²/d )
    @Column(name = "APL_3_2_2_12")
    @JsonProperty("APL-3-2-2-12")
    private String APL_3_2_2_12; // 其他治疗用药(mg/kg/d)
    @Column(name = "APL_3_2_2_13")
    @JsonProperty("APL-3-2-2-13")
    private String APL_3_2_2_13; // 其他治疗用药天数(d)
    @Column(name = "APL_3_2_3")
    @JsonProperty("APL-3-2-3")
    private String APL_3_2_3; // 高危组--诱导治疗用药的选择
    @Column(name = "APL_3_2_3_1")
    @JsonProperty("APL-3-2-3-1")
    private String APL_3_2_3_1; // 全反式维甲酸
    @Column(name = "APL_3_2_3_2")
    @JsonProperty("APL-3-2-3-2")
    private String APL_3_2_3_2; // 其他全反式维甲酸用药(mg/m²/d)
    @Column(name = "APL_3_2_3_3")
    @JsonProperty("APL-3-2-3-3")
    private String APL_3_2_3_3; // 其他全反式维甲酸用药天数(d)
    @Column(name = "APL_3_2_3_4")
    @JsonProperty("APL-3-2-3-4")
    private String APL_3_2_3_4; // 三氧化二砷
    @Column(name = "APL_3_2_3_5")
    @JsonProperty("APL-3-2-3-5")
    private String APL_3_2_3_5; // 其他三氧化二砷用药(mg/kg/d)
    @Column(name = "APL_3_2_3_6")
    @JsonProperty("APL-3-2-3-6")
    private String APL_3_2_3_6; // 其他三氧化二砷用药天数(d)
    @Column(name = "APL_3_2_3_7")
    @JsonProperty("APL-3-2-3-7")
    private String APL_3_2_3_7; // 去甲氧柔红霉素
    @Column(name = "APL_3_2_3_8")
    @JsonProperty("APL-3-2-3-8")
    private String APL_3_2_3_8; // 其他去甲氧柔红霉素用药(mg/m²/d)
    @Column(name = "APL_3_2_3_9")
    @JsonProperty("APL-3-2-3-9")
    private String APL_3_2_3_9; // 其他去甲氧柔红霉素用药天数(d)
    @Column(name = "APL_3_2_3_10")
    @JsonProperty("APL-3-2-3-10")
    private String APL_3_2_3_10; // 其他去甲氧柔红霉素用药每隔日次数(qod)
    @Column(name = "APL_3_2_3_11")
    @JsonProperty("APL-3-2-3-11")
    private String APL_3_2_3_11; // 柔红霉素
    @Column(name = "APL_3_2_3_12")
    @JsonProperty("APL-3-2-3-12")
    private String APL_3_2_3_12; // 其他柔红霉素用药(mg/m²/d)
    @Column(name = "APL_3_2_3_13")
    @JsonProperty("APL-3-2-3-13")
    private String APL_3_2_3_13; // 其他柔红霉素用药天数(d)
    @Column(name = "APL_3_2_3_14")
    @JsonProperty("APL-3-2-3-14")
    private String APL_3_2_3_14; // 其他柔红霉素用药每隔日次数(qod)
    @Column(name = "APL_3_2_3_15")
    @JsonProperty("APL-3-2-3-15")
    private String APL_3_2_3_15; // 其他治疗药品名称
    @Column(name = "APL_3_2_3_16")
    @JsonProperty("APL-3-2-3-16")
    private String APL_3_2_3_16; // 其他治疗用药(mg/m²/d )
    @Column(name = "APL_3_2_3_17")
    @JsonProperty("APL-3-2-3-17")
    private String APL_3_2_3_17; // 其他治疗用药(mg/kg/d)
    @Column(name = "APL_3_2_3_18")
    @JsonProperty("APL-3-2-3-18")
    private String APL_3_2_3_18; // 其他治疗用药天数(d)
    @Column(name = "APL_3_2_3_19")
    @JsonProperty("APL-3-2-3-19")
    private String APL_3_2_3_19; // 其他治疗用药每隔日次数(qod)
    @Column(name = "APL_3_2_4")
    @JsonProperty("APL-3-2-4")
    private String APL_3_2_4; // 减积治疗组--用药的选择
    @Column(name = "APL_3_2_4_1")
    @JsonProperty("APL-3-2-4-1")
    private String APL_3_2_4_1; // 羟基脲
    @Column(name = "APL_3_2_4_2")
    @JsonProperty("APL-3-2-4-2")
    private String APL_3_2_4_2; // 其他羟基脲用药(mg/kg/d)
    @Column(name = "APL_3_2_4_3")
    @JsonProperty("APL-3-2-4-3")
    private String APL_3_2_4_3; // 其他羟基脲用药天数(d)
    @Column(name = "APL_3_2_4_4")
    @JsonProperty("APL-3-2-4-4")
    private String APL_3_2_4_4; // 阿糖胞苷
    @Column(name = "APL_3_2_4_5")
    @JsonProperty("APL-3-2-4-5")
    private String APL_3_2_4_5; // 其他阿糖胞苷用药(mg/m²)
    @Column(name = "APL_3_2_4_6")
    @JsonProperty("APL-3-2-4-6")
    private String APL_3_2_4_6; // 其他阿糖胞苷用药天数(d)
    @Column(name = "APL_3_2_4_7")
    @JsonProperty("APL-3-2-4-7")
    private String APL_3_2_4_7; // 高三尖杉酯碱
    @Column(name = "APL_3_2_4_8")
    @JsonProperty("APL-3-2-4-8")
    private String APL_3_2_4_8; // 其他高三尖杉酯碱用药(mg/m²)
    @Column(name = "APL_3_2_4_9")
    @JsonProperty("APL-3-2-4-9")
    private String APL_3_2_4_9; // 其他高三尖杉酯碱用药天数(d)
    @Column(name = "APL_3_2_4_10")
    @JsonProperty("APL-3-2-4-10")
    private String APL_3_2_4_10; // 去甲氧柔红霉素
    @Column(name = "APL_3_2_4_11")
    @JsonProperty("APL-3-2-4-11")
    private String APL_3_2_4_11; // 其他去甲氧柔红霉素用药(mg/m²/d)
    @Column(name = "APL_3_2_4_12")
    @JsonProperty("APL-3-2-4-12")
    private String APL_3_2_4_12; // 其他去甲氧柔红霉素用药天数(d)
    @Column(name = "APL_3_2_4_13")
    @JsonProperty("APL-3-2-4-13")
    private String APL_3_2_4_13; // 其他去甲氧柔红霉素用药每隔日次数(qod)
    @Column(name = "APL_3_2_4_14")
    @JsonProperty("APL-3-2-4-14")
    private String APL_3_2_4_14; // 柔红霉素
    @Column(name = "APL_3_2_4_15")
    @JsonProperty("APL-3-2-4-15")
    private String APL_3_2_4_15; // 其他柔红霉素用药(mg/m²/d)
    @Column(name = "APL_3_2_4_16")
    @JsonProperty("APL-3-2-4-16")
    private String APL_3_2_4_16; // 其他柔红霉素用药天数(d)
    @Column(name = "APL_3_2_4_17")
    @JsonProperty("APL-3-2-4-17")
    private String APL_3_2_4_17; // 其他柔红霉素用药每隔日次数(qod)
    @Column(name = "APL_3_2_4_18")
    @JsonProperty("APL-3-2-4-18")
    private String APL_3_2_4_18; // 其他治疗药品名称
    @Column(name = "APL_3_2_4_19")
    @JsonProperty("APL-3-2-4-19")
    private String APL_3_2_4_19; // 其他治疗用药(mg/m²/d )
    @Column(name = "APL_3_2_4_20")
    @JsonProperty("APL-3-2-4-20")
    private String APL_3_2_4_20; // 其他治疗用药(mg/kg/d)
    @Column(name = "APL_3_2_4_21")
    @JsonProperty("APL-3-2-4-21")
    private String APL_3_2_4_21; // 其他治疗用药天数(d)
    @Column(name = "APL_3_2_4_22")
    @JsonProperty("APL-3-2-4-22")
    private String APL_3_2_4_22; // 其他治疗用药每隔日次数(qod)
    @Column(name = "APL_4_1_1")
    @JsonProperty("APL-4-1-1")
    private String APL_4_1_1; // 是否有缓解后巩固治疗方案
    @Column(name = "APL_4_1_2")
    @JsonProperty("APL-4-1-2")
    private String APL_4_1_2; // 缓解后巩固治疗方案的组别选择
    @Column(name = "APL_4_2_1")
    @JsonProperty("APL-4-2-1")
    private String APL_4_2_1; // 低危组 巩固治疗方案
    @Column(name = "APL_4_2_1_1")
    @JsonProperty("APL-4-2-1-1")
    private String APL_4_2_1_1; // 全反式维甲酸（ATRA）
    @Column(name = "APL_4_2_1_4")
    @JsonProperty("APL-4-2-1-4")
    private String APL_4_2_1_4; // 其他ATRA用药输注方式
    @Column(name = "APL_4_2_1_2")
    @JsonProperty("APL-4-2-1-2")
    private String APL_4_2_1_2; // 其他全反式维甲酸用药(mg/m²/d)
    @Column(name = "APL_4_2_1_3")
    @JsonProperty("APL-4-2-1-3")
    private String APL_4_2_1_3; // 其他全反式维甲酸用药天数(d)
    @Column(name = "APL_4_2_1_5")
    @JsonProperty("APL-4-2-1-5")
    private String APL_4_2_1_5; // 三氧化二砷(ATO)/复方黄黛片(RIF)
    @Column(name = "APL_4_2_1_8")
    @JsonProperty("APL-4-2-1-8")
    private String APL_4_2_1_8; // 其他ATO用药输注方式
    @Column(name = "APL_4_2_1_6")
    @JsonProperty("APL-4-2-1-6")
    private String APL_4_2_1_6; // 其他三氧化二砷用药(mg/kg/d)
    @Column(name = "APL_4_2_1_7")
    @JsonProperty("APL-4-2-1-7")
    private String APL_4_2_1_7; // 其他三氧化二砷用药天数(d)
    @Column(name = "APL_4_2_1_11")
    @JsonProperty("APL-4-2-1-11")
    private String APL_4_2_1_11; // 其他RIF用药输注方式
    @Column(name = "APL_4_2_1_9")
    @JsonProperty("APL-4-2-1-9")
    private String APL_4_2_1_9; // 其他复方黄黛片用药(mg/kg/d)
    @Column(name = "APL_4_2_1_10")
    @JsonProperty("APL-4-2-1-10")
    private String APL_4_2_1_10; // 其他复方黄黛片用药天数(d)
    @Column(name = "APL_4_2_1_12")
    @JsonProperty("APL-4-2-1-12")
    private String APL_4_2_1_12; // 其他治疗药品名称
    @Column(name = "APL_4_2_1_13")
    @JsonProperty("APL-4-2-1-13")
    private String APL_4_2_1_13; // 其他治疗用药输注方式
    @Column(name = "APL_4_2_1_14")
    @JsonProperty("APL-4-2-1-14")
    private String APL_4_2_1_14; // 其他治疗用药(mg/m²/d )
    @Column(name = "APL_4_2_1_15")
    @JsonProperty("APL-4-2-1-15")
    private String APL_4_2_1_15; // 其他治疗用药(mg/kg/d)
    @Column(name = "APL_4_2_1_16")
    @JsonProperty("APL-4-2-1-16")
    private String APL_4_2_1_16; // 其他治疗用药天数(d )
    @Column(name = "APL_4_2_2")
    @JsonProperty("APL-4-2-2")
    private String APL_4_2_2; // 高危组 巩固治疗方案
    @Column(name = "APL_4_2_2_1")
    @JsonProperty("APL-4-2-2-1")
    private String APL_4_2_2_1; // 全反式维甲酸（ATRA）
    @Column(name = "APL_4_2_2_4")
    @JsonProperty("APL-4-2-2-4")
    private String APL_4_2_2_4; // 其他ATRA用药输注方式
    @Column(name = "APL_4_2_2_2")
    @JsonProperty("APL-4-2-2-2")
    private String APL_4_2_2_2; // 其他全反式维甲酸用药(mg/m²/d)
    @Column(name = "APL_4_2_2_3")
    @JsonProperty("APL-4-2-2-3")
    private String APL_4_2_2_3; // 其他全反式维甲酸用药天数(d)
    @Column(name = "APL_4_2_2_5")
    @JsonProperty("APL-4-2-2-5")
    private String APL_4_2_2_5; // 三氧化二砷(ATO)/复方黄黛片(RIF)
    @Column(name = "APL_4_2_2_8")
    @JsonProperty("APL-4-2-2-8")
    private String APL_4_2_2_8; // 其他ATO用药输注方式
    @Column(name = "APL_4_2_2_6")
    @JsonProperty("APL-4-2-2-6")
    private String APL_4_2_2_6; // 其他三氧化二砷用药(mg/kg/d)
    @Column(name = "APL_4_2_2_7")
    @JsonProperty("APL-4-2-2-7")
    private String APL_4_2_2_7; // 其他三氧化二砷用药天数(d)
    @Column(name = "APL_4_2_2_11")
    @JsonProperty("APL-4-2-2-11")
    private String APL_4_2_2_11; // 其他RIF用药输注方式
    @Column(name = "APL_4_2_2_9")
    @JsonProperty("APL-4-2-2-9")
    private String APL_4_2_2_9; // 其他复方黄黛片用药(mg/kg/d)
    @Column(name = "APL_4_2_2_10")
    @JsonProperty("APL-4-2-2-10")
    private String APL_4_2_2_10; // 其他复方黄黛片用药天数(d)
    @Column(name = "APL_4_2_2_12")
    @JsonProperty("APL-4-2-2-12")
    private String APL_4_2_2_12; // 去甲氧柔红霉素(IDA)/柔红霉素(DNR)
    @Column(name = "APL_4_2_2_13")
    @JsonProperty("APL-4-2-2-13")
    private String APL_4_2_2_13; // 其他IDA用药输注方式
    @Column(name = "APL_4_2_2_14")
    @JsonProperty("APL-4-2-2-14")
    private String APL_4_2_2_14; // 其他去甲氧柔红霉素用药(mg/m²/d)
    @Column(name = "APL_4_2_2_15")
    @JsonProperty("APL-4-2-2-15")
    private String APL_4_2_2_15; // 其他去甲氧柔红霉素用药天数(d)
    @Column(name = "APL_4_2_2_16")
    @JsonProperty("APL-4-2-2-16")
    private String APL_4_2_2_16; // 其他去甲氧柔红霉素用药每隔日次数(qod)
    @Column(name = "APL_4_2_2_17")
    @JsonProperty("APL-4-2-2-17")
    private String APL_4_2_2_17; // 其他DNR用药输注方式
    @Column(name = "APL_4_2_2_18")
    @JsonProperty("APL-4-2-2-18")
    private String APL_4_2_2_18; // 其他柔红霉素用药(mg/m²/d)
    @Column(name = "APL_4_2_2_19")
    @JsonProperty("APL-4-2-2-19")
    private String APL_4_2_2_19; // 其他柔红霉素用药天数(d)
    @Column(name = "APL_4_2_2_20")
    @JsonProperty("APL-4-2-2-20")
    private String APL_4_2_2_20; // 其他柔红霉素用药每隔日次数(qod)
    @Column(name = "APL_4_2_2_21")
    @JsonProperty("APL-4-2-2-21")
    private String APL_4_2_2_21; // 其他治疗药品名称
    @Column(name = "APL_4_2_2_22")
    @JsonProperty("APL-4-2-2-22")
    private String APL_4_2_2_22; // 其他治疗用药输注方式
    @Column(name = "APL_4_2_2_23")
    @JsonProperty("APL-4-2-2-23")
    private String APL_4_2_2_23; // 其他治疗用药(mg/m²/d )
    @Column(name = "APL_4_2_2_24")
    @JsonProperty("APL-4-2-2-24")
    private String APL_4_2_2_24; // 其他治疗用药(mg/kg/d)
    @Column(name = "APL_4_2_2_25")
    @JsonProperty("APL-4-2-2-25")
    private String APL_4_2_2_25; // 其他治疗用药天数(d)
    @Column(name = "APL_4_2_2_26")
    @JsonProperty("APL-4-2-2-26")
    private String APL_4_2_2_26; // 其他治疗用药每隔日次数(qod)
    @Column(name = "APL_5_1_1")
    @JsonProperty("APL-5-1-1")
    private String APL_5_1_1; // 复查的检查项目
    @Column(name = "APL_5_1_1_1")
    @JsonProperty("APL-5-1-1-1")
    private String APL_5_1_1_1; // 复查的其他检查项目
    @Column(name = "APL_5_1_2")
    @JsonProperty("APL-5-1-2")
    private String APL_5_1_2; // 完成上述复查中最末一项的日期
    @Column(name = "APL_5_2_1")
    @JsonProperty("APL-5-2-1")
    private String APL_5_2_1; // 评估后治疗意见
    @Column(name = "APL_5_2_1_1")
    @JsonProperty("APL-5-2-1-1")
    private String APL_5_2_1_1; // 其他评估意见
    @Column(name = "APL_6_1_1")
    @JsonProperty("APL-6-1-1")
    private String APL_6_1_1; // 有无诱导治疗后并发症
    @Column(name = "APL_6_1_2")
    @JsonProperty("APL-6-1-2")
    private String APL_6_1_2; // 术后并发症/不良反应
    @Column(name = "APL_6_1_2_1")
    @JsonProperty("APL-6-1-2-1")
    private String APL_6_1_2_1; // 其他术后并发症/不良反应
    @Column(name = "APL_6_1_3")
    @JsonProperty("APL-6-1-3")
    private String APL_6_1_3; // 有无不良反应的防治/治疗措施
    @Column(name = "APL_6_1_4")
    @JsonProperty("APL-6-1-4")
    private String APL_6_1_4; // 弥散性血管内凝血(DIC)的预防及治疗
    @Column(name = "APL_6_1_4_1")
    @JsonProperty("APL-6-1-4-1")
    private String APL_6_1_4_1; // 其他预防及治疗措施
    @Column(name = "APL_6_1_5")
    @JsonProperty("APL-6-1-5")
    private String APL_6_1_5; // 分化综合征的预防及治疗
    @Column(name = "APL_6_1_5_1")
    @JsonProperty("APL-6-1-5-1")
    private String APL_6_1_5_1; // 其他预防及治疗措施
    @Column(name = "APL_6_2_1")
    @JsonProperty("APL-6-2-1")
    private String APL_6_2_1; // 有无药物毒副作用
    @Column(name = "APL_6_2_2")
    @JsonProperty("APL-6-2-2")
    private String APL_6_2_2; // 药物毒副作用
    @Column(name = "APL_6_2_2_1")
    @JsonProperty("APL-6-2-2-1")
    private String APL_6_2_2_1; // 药物毒副其他作用
    @Column(name = "APL_6_3_1")
    @JsonProperty("APL-6-3-1")
    private String APL_6_3_1; // 是否有WHO化疗毒副作用评估
    @Column(name = "APL_6_3_2")
    @JsonProperty("APL-6-3-2")
    private String APL_6_3_2; // 粘膜损害程度
    @Column(name = "APL_6_3_3")
    @JsonProperty("APL-6-3-3")
    private String APL_6_3_3; // 感染程度
    @Column(name = "APL_6_3_4")
    @JsonProperty("APL-6-3-4")
    private String APL_6_3_4; // 肝功能损伤
    @Column(name = "APL_6_3_5")
    @JsonProperty("APL-6-3-5")
    private String APL_6_3_5; // 肾功能损伤
    @Column(name = "APL_6_3_6")
    @JsonProperty("APL-6-3-6")
    private String APL_6_3_6; // 胃肠道反应
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM-1-1-1")
    private String CM_1_1_1; // 是否使用预防性抗菌药物
    @Column(name = "CM_1_2_1_2")
    @JsonProperty("CM-1-2-1-2")
    private String CM_1_2_1_2; // 预防性抗菌药物选择
    @Column(name = "APL_7_2_1")
    @JsonProperty("APL-7-2-1")
    private String APL_7_2_1; // 抗霉菌药物选择
    @Column(name = "APL_7_2_1_1")
    @JsonProperty("APL-7-2-1-1")
    private String APL_7_2_1_1; // 其他抗霉菌药物
    @Column(name = "CM_1_2_2_2")
    @JsonProperty("CM-1-2-2-2")
    private String CM_1_2_2_2; // 选择碳青霉烯类及替加环素等特殊使用级抗菌药物 
    @Column(name = "CM_1_2_2_1")
    @JsonProperty("CM-1-2-2-1")
    private String CM_1_2_2_1; // 其他特殊使用级抗菌药物名称
    @Column(name = "CM_1_3_1_2")
    @JsonProperty("CM-1-3-1-2")
    private String CM_1_3_1_2; // 选用“特殊使用级抗菌药物”或者其他类抗菌药物的因素
    @Column(name = "CM_1_3_1_1")
    @JsonProperty("CM-1-3-1-1")
    private String CM_1_3_1_1; // 选用“特殊使用级抗菌药物”或者其他类抗菌药物的因素填写
    @Column(name = "CM_1_4_1")
    @JsonProperty("CM-1-4-1")
    private String CM_1_4_1; // 使用首剂抗菌药物起始时间
    @Column(name = "CM_1_6_1")
    @JsonProperty("CM-1-6-1")
    private String CM_1_6_1; // 术后抗菌药物停止使用时间
    @Column(name = "APL_8_1_1")
    @JsonProperty("APL-8-1-1")
    private String APL_8_1_1; // 是否输血及成份血
    @Column(name = "APL_8_1_2")
    @JsonProperty("APL-8-1-2")
    private String APL_8_1_2; // 输血及成份血指征
    @Column(name = "APL_8_1_2_1")
    @JsonProperty("APL-8-1-2-1")
    private String APL_8_1_2_1; // 输血及成份血指其他征
    @Column(name = "APL_8_1_3")
    @JsonProperty("APL-8-1-3")
    private String APL_8_1_3; // 临床用血类别与输血量
    @Column(name = "APL_8_1_3_1")
    @JsonProperty("APL-8-1-3-1")
    private String APL_8_1_3_1; // 全血 输血量(ml)
    @Column(name = "APL_8_1_3_2")
    @JsonProperty("APL-8-1-3-2")
    private String APL_8_1_3_2; // 成份血 输血量(ml)
    @Column(name = "APL_8_1_3_3")
    @JsonProperty("APL-8-1-3-3")
    private String APL_8_1_3_3; // 血浆 输血量(ml)
    @Column(name = "APL_8_1_3_4")
    @JsonProperty("APL-8-1-3-4")
    private String APL_8_1_3_4; // 其他 用血类别
    @Column(name = "APL_8_1_3_5")
    @JsonProperty("APL-8-1-3-5")
    private String APL_8_1_3_5; // 其他 输血量(ml)
    @Column(name = "APL_8_2_1")
    @JsonProperty("APL-8-2-1")
    private String APL_8_2_1; // 是否使用造血生长因子
    @Column(name = "APL_8_2_2")
    @JsonProperty("APL-8-2-2")
    private String APL_8_2_2; // 造血生长因子指征
    @Column(name = "APL_8_2_2_1")
    @JsonProperty("APL-8-2-2-1")
    private String APL_8_2_2_1; // 造血生长因子其他指征
    @Column(name = "APL_8_2_3")
    @JsonProperty("APL-8-2-3")
    private String APL_8_2_3; // 使用制剂名称
    @Column(name = "APL_8_2_3_1")
    @JsonProperty("APL-8-2-3-1")
    private String APL_8_2_3_1; // 使用其他制剂名称
    @Column(name = "CM_7_1_1")
    @JsonProperty("CM-7-1-1")
    private String CM_7_1_1; // 术前健康教育
    @Column(name = "APL_9_1_1_1")
    @JsonProperty("APL-9-1-1-1")
    private String APL_9_1_1_1; // 术前其他健康教育
    @Column(name = "CM_7_1_2")
    @JsonProperty("CM-7-1-2")
    private String CM_7_1_2; // 术后健康教育
    @Column(name = "APL_9_1_2_1")
    @JsonProperty("APL-9-1-2-1")
    private String APL_9_1_2_1; // 术后其他健康教育
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "APL_9_2_1_1")
    @JsonProperty("APL-9-2-1-1")
    private String APL_9_2_1_1; // 其他告知患者出院时风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "APL_9_2_2_1")
    @JsonProperty("APL-9-2-2-1")
    private String APL_9_2_2_1; // 出院带药其他
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    @Column(name = "APL_9_2_3_1")
    @JsonProperty("APL-9-2-3-1")
    private String APL_9_2_3_1; // 其他发生紧急意外情况或者疾病复发
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "APL_9_2_4_1")
    @JsonProperty("APL-9-2-4-1")
    private String APL_9_2_4_1; // 其他发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
    @Column(name = "APL_9_2_5_1")
    @JsonProperty("APL-9-2-5-1")
    private String APL_9_2_5_1; // 其他教育与随访
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
    private String CM_5_2_2; // 患儿家长推荐
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