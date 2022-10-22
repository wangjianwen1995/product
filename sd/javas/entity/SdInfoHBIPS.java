package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：F00-F99 的出院患者。
*/
@ApiModel(value = "45信息")
@Entity
@Data
@Table(name = "sd_info_HBIPS")
public class SdInfoHBIPS implements Serializable {
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
    private String CM_0_1_3_1; // 主要诊断或第一诊断中提取ICD-10类目编码与疾病名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断或第一诊断中提取ICD-10六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_1")
    @JsonProperty("CM-0-1-4-1")
    private String CM_0_1_4_1; // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "HBIPS_0_1_1")
    @JsonProperty("HBIPS-0-1-1")
    private String HBIPS_0_1_1; // 其他主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "HBIPS_0_1_2")
    @JsonProperty("HBIPS-0-1-2")
    private String HBIPS_0_1_2; // 其他主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
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
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "HBIPS_0_3_6")
    @JsonProperty("HBIPS-0-3-6")
    private String HBIPS_0_3_6; // 入院种类
    @Column(name = "HBIPS_0_3_7")
    @JsonProperty("HBIPS-0-3-7")
    private String HBIPS_0_3_7; // 第几次住院
    @Column(name = "HBIPS_1_1")
    @JsonProperty("HBIPS-1-1")
    private String HBIPS_1_1; // 入院时是否实施首次评估
    @Column(name = "HBIPS_1_2")
    @JsonProperty("HBIPS-1-2")
    private String HBIPS_1_2; // 入院时对住院患者实施评估
    @Column(name = "HBIPS_1_2_1_1")
    @JsonProperty("HBIPS-1-2-1-1")
    private String HBIPS_1_2_1_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_1_2")
    @JsonProperty("HBIPS-1-2-1-2")
    private String HBIPS_1_2_1_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_2_1")
    @JsonProperty("HBIPS-1-2-2-1")
    private String HBIPS_1_2_2_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_2_2")
    @JsonProperty("HBIPS-1-2-2-2")
    private String HBIPS_1_2_2_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_3_1")
    @JsonProperty("HBIPS-1-2-3-1")
    private String HBIPS_1_2_3_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_3_2")
    @JsonProperty("HBIPS-1-2-3-2")
    private String HBIPS_1_2_3_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_4_1")
    @JsonProperty("HBIPS-1-2-4-1")
    private String HBIPS_1_2_4_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_4_2")
    @JsonProperty("HBIPS-1-2-4-2")
    private String HBIPS_1_2_4_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_5_1")
    @JsonProperty("HBIPS-1-2-5-1")
    private String HBIPS_1_2_5_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_5_2")
    @JsonProperty("HBIPS-1-2-5-2")
    private String HBIPS_1_2_5_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_6_1")
    @JsonProperty("HBIPS-1-2-6-1")
    private String HBIPS_1_2_6_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_6_2")
    @JsonProperty("HBIPS-1-2-6-2")
    private String HBIPS_1_2_6_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_7_1")
    @JsonProperty("HBIPS-1-2-7-1")
    private String HBIPS_1_2_7_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_7_2")
    @JsonProperty("HBIPS-1-2-7-2")
    private String HBIPS_1_2_7_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_8_1")
    @JsonProperty("HBIPS-1-2-8-1")
    private String HBIPS_1_2_8_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_8_2")
    @JsonProperty("HBIPS-1-2-8-2")
    private String HBIPS_1_2_8_2; // 出院前末次评估分值
    @Column(name = "HBIPS_1_2_9_1")
    @JsonProperty("HBIPS-1-2-9-1")
    private String HBIPS_1_2_9_1; // 入院后首次评估分值
    @Column(name = "HBIPS_1_2_9_2")
    @JsonProperty("HBIPS-1-2-9-2")
    private String HBIPS_1_2_9_2; // 出院前末次评估分值
    @Column(name = "HBIPS_2_1")
    @JsonProperty("HBIPS-2-1")
    private String HBIPS_2_1; // 住院患者是否发生压疮
    @Column(name = "HBIPS_2_2_1")
    @JsonProperty("HBIPS-2-2-1")
    private String HBIPS_2_2_1; // 患者入院前是否已有压疮
    @Column(name = "HBIPS_2_2_2")
    @JsonProperty("HBIPS-2-2-2")
    private String HBIPS_2_2_2; // 门诊或急诊诊断中有压疮
    @Column(name = "HBIPS_2_2_3")
    @JsonProperty("HBIPS-2-2-3")
    private String HBIPS_2_2_3; // 门诊或急诊记录的压疮发生地点
    @Column(name = "HBIPS_2_3_1")
    @JsonProperty("HBIPS-2-3-1")
    private String HBIPS_2_3_1; // 是否进行压疮危险因素评估
    @Column(name = "HBIPS_2_3_2")
    @JsonProperty("HBIPS-2-3-2")
    private String HBIPS_2_3_2; // 压疮危险因素评估选择
    @Column(name = "HBIPS_2_3_2_1")
    @JsonProperty("HBIPS-2-3-2-1")
    private String HBIPS_2_3_2_1; // Waterlow压疮危险因素评估的分值
    @Column(name = "HBIPS_2_3_2_2")
    @JsonProperty("HBIPS-2-3-2-2")
    private String HBIPS_2_3_2_2; // Norton压疮危险因素评估的分值
    @Column(name = "HBIPS_2_3_2_3")
    @JsonProperty("HBIPS-2-3-2-3")
    private String HBIPS_2_3_2_3; // Braden压疮危险因素评估的分值
    @Column(name = "HBIPS_2_4")
    @JsonProperty("HBIPS-2-4")
    private String HBIPS_2_4; // 出院时，其他诊断中有ICD-10编码L89及受压区压疮
    @Column(name = "HBIPS_2_5")
    @JsonProperty("HBIPS-2-5")
    private String HBIPS_2_5; // 住院期间发生压疮的部位
    @Column(name = "HBIPS_3_1")
    @JsonProperty("HBIPS-3-1")
    private String HBIPS_3_1; // 住院患者是否发生跌倒/坠床
    @Column(name = "HBIPS_3_2")
    @JsonProperty("HBIPS-3-2")
    private String HBIPS_3_2; // 发生的跌倒/坠床及其原因的选择
    @Column(name = "HBIPS_3_3")
    @JsonProperty("HBIPS-3-3")
    private String HBIPS_3_3; // 跌倒/坠床造成的伤害程度
    @Column(name = "HBIPS_4_1")
    @JsonProperty("HBIPS-4-1")
    private String HBIPS_4_1; // 住院患者是否发生烫伤
    @Column(name = "HBIPS_4_2")
    @JsonProperty("HBIPS-4-2")
    private String HBIPS_4_2; // 造成烫伤可能的因素
    @Column(name = "HBIPS_4_3")
    @JsonProperty("HBIPS-4-3")
    private String HBIPS_4_3; // 烫伤伤害的程度
    @Column(name = "HBIPS_4_4")
    @JsonProperty("HBIPS-4-4")
    private String HBIPS_4_4; // 烫伤累及的体表面积与ICD-10编码T31.0-31.9
    @Column(name = "HBIPS_5_1")
    @JsonProperty("HBIPS-5-1")
    private String HBIPS_5_1; // 住院患者是否发生噎食窒息
    @Column(name = "HBIPS_5_2")
    @JsonProperty("HBIPS-5-2")
    private String HBIPS_5_2; // 噎食窒息的原因
    @Column(name = "HBIPS_5_3")
    @JsonProperty("HBIPS-5-3")
    private String HBIPS_5_3; // 呼吸道阻塞的程度
    @Column(name = "HBIPS_5_4")
    @JsonProperty("HBIPS-5-4")
    private String HBIPS_5_4; // 噎食窒息造成的伤害程度
    @Column(name = "HBIPS_6_1_1")
    @JsonProperty("HBIPS-6-1-1")
    private String HBIPS_6_1_1; // 住院患者是否发生自杀
    @Column(name = "HBIPS_6_1_2")
    @JsonProperty("HBIPS-6-1-2")
    private String HBIPS_6_1_2; // 入院后有自杀危险因素评估
    @Column(name = "HBIPS_6_1_3")
    @JsonProperty("HBIPS-6-1-3")
    private String HBIPS_6_1_3; // 住院患者的自杀原因
    @Column(name = "HBIPS_6_1_4")
    @JsonProperty("HBIPS-6-1-4")
    private String HBIPS_6_1_4; // 自杀造成伤害程度的选择
    @Column(name = "HBIPS_6_2_1")
    @JsonProperty("HBIPS-6-2-1")
    private String HBIPS_6_2_1; // 住院患者是否发生自伤
    @Column(name = "HBIPS_6_2_2")
    @JsonProperty("HBIPS-6-2-2")
    private String HBIPS_6_2_2; // 入院后是否有自伤危险因素评估
    @Column(name = "HBIPS_6_2_3")
    @JsonProperty("HBIPS-6-2-3")
    private String HBIPS_6_2_3; // 住院患者的自伤原因
    @Column(name = "HBIPS_6_2_4")
    @JsonProperty("HBIPS-6-2-4")
    private String HBIPS_6_2_4; // 自伤造成的伤害程度
    @Column(name = "HBIPS_7_1")
    @JsonProperty("HBIPS-7-1")
    private String HBIPS_7_1; // 住院患者是否发生伤人、毁物
    @Column(name = "HBIPS_7_2")
    @JsonProperty("HBIPS-7-2")
    private String HBIPS_7_2; // 入院后是否有伤人、毁物的危险因素评估
    @Column(name = "HBIPS_7_3")
    @JsonProperty("HBIPS-7-3")
    private String HBIPS_7_3; // 伤人与毁物的原因
    @Column(name = "HBIPS_7_4")
    @JsonProperty("HBIPS-7-4")
    private String HBIPS_7_4; // 造成的伤害程度
    @Column(name = "HBIPS_8")
    @JsonProperty("HBIPS-8")
    private String HBIPS_8; // 住院患者是否发生擅自离院
    @Column(name = "HBIPS_9_1")
    @JsonProperty("HBIPS-9-1")
    private String HBIPS_9_1; // 住院期间是否实施约束
    @Column(name = "HBIPS_9_1_2")
    @JsonProperty("HBIPS-9-1-2")
    private String HBIPS_9_1_2; // 住院期间首次实施约束的主要原因
    @Column(name = "HBIPS_9_1_6_1")
    @JsonProperty("HBIPS-9-1-6-1")
    private String HBIPS_9_1_6_1; // 首次使用身体约束开始时间是否确定
    @Column(name = "HBIPS_9_1_6")
    @JsonProperty("HBIPS-9-1-6")
    private String HBIPS_9_1_6; // 首次使用身体约束开始时间
    @Column(name = "HBIPS_9_1_3")
    @JsonProperty("HBIPS-9-1-3")
    private String HBIPS_9_1_3; // 使用身体约束开始时间段
    @Column(name = "HBIPS_9_1_7_1")
    @JsonProperty("HBIPS-9-1-7-1")
    private String HBIPS_9_1_7_1; // 首次实施约束终止时间是否确定
    @Column(name = "HBIPS_9_1_7")
    @JsonProperty("HBIPS-9-1-7")
    private String HBIPS_9_1_7; // 首次实施约束终止时间
    @Column(name = "HBIPS_9_1_8")
    @JsonProperty("HBIPS-9-1-8")
    private String HBIPS_9_1_8; // 首次实施约束持续时间
    @Column(name = "HBIPS_9_1_9")
    @JsonProperty("HBIPS-9-1-9")
    private String HBIPS_9_1_9; // 住院期间实施约束累积次数
    @Column(name = "HBIPS_9_1_4")
    @JsonProperty("HBIPS-9-1-4")
    private String HBIPS_9_1_4; // 住院期间实施约束累积时间
    @Column(name = "HBIPS_9_1_5")
    @JsonProperty("HBIPS-9-1-5")
    private String HBIPS_9_1_5; // 住院期间实施约束是否有并发症
    @Column(name = "HBIPS_9_2_1")
    @JsonProperty("HBIPS-9-2-1")
    private String HBIPS_9_2_1; // 住院期间是否实施隔离保护
    @Column(name = "HBIPS_9_2_2")
    @JsonProperty("HBIPS-9-2-2")
    private String HBIPS_9_2_2; // 住院期间实施使用隔离措施的主要事由
    @Column(name = "HBIPS_9_2_6_1")
    @JsonProperty("HBIPS-9-2-6-1")
    private String HBIPS_9_2_6_1; // 首次使用隔离保护开始时间是否确定
    @Column(name = "HBIPS_9_2_6")
    @JsonProperty("HBIPS-9-2-6")
    private String HBIPS_9_2_6; // 首次使用隔离保护开始时间
    @Column(name = "HBIPS_9_2_3")
    @JsonProperty("HBIPS-9-2-3")
    private String HBIPS_9_2_3; // 使用隔离保护开始时间段
    @Column(name = "HBIPS_9_2_7_1")
    @JsonProperty("HBIPS-9-2-7-1")
    private String HBIPS_9_2_7_1; // 首次实施约束终止时间是否确定
    @Column(name = "HBIPS_9_2_7")
    @JsonProperty("HBIPS-9-2-7")
    private String HBIPS_9_2_7; // 首次实施约束终止时间
    @Column(name = "HBIPS_3_2_4_r")
    @JsonProperty("HBIPS-3-2-4-r")
    private String HBIPS_3_2_4_r; // 首次实施约束时间(小时)
    @Column(name = "HBIPS_3_2_4")
    @JsonProperty("HBIPS-3-2-4")
    private String HBIPS_3_2_4; // 首次实施约束时间
    @Column(name = "HBIPS_3_2_5")
    @JsonProperty("HBIPS-3-2-5")
    private String HBIPS_3_2_5; // 实施约束累计时间(h)
    @Column(name = "HBIPS_3_2_6")
    @JsonProperty("HBIPS-3-2-6")
    private String HBIPS_3_2_6; // 住院期间实施约束累积次数(次)
    @Column(name = "HBIPS_9_2_5")
    @JsonProperty("HBIPS-9-2-5")
    private String HBIPS_9_2_5; // 住院期间实施隔离保护是否有并发症
    @Column(name = "HBIPS_10_1")
    @JsonProperty("HBIPS-10-1")
    private String HBIPS_10_1; // 出院前是否实施社会功能评估
    @Column(name = "HBIPS_10_2")
    @JsonProperty("HBIPS-10-2")
    private String HBIPS_10_2; // 评定量表
    @Column(name = "HBIPS_11_1")
    @JsonProperty("HBIPS-11-1")
    private String HBIPS_11_1; // 是否制定有出院后持续服务计划
    @Column(name = "HBIPS_11_2_1")
    @JsonProperty("HBIPS-11-2-1")
    private String HBIPS_11_2_1; // 出院后持续服务计划是否转至后续服务机构
    @Column(name = "HBIPS_11_2_2")
    @JsonProperty("HBIPS-11-2-2")
    private String HBIPS_11_2_2; // 服务机构选择
    @Column(name = "HBIPS_12_1")
    @JsonProperty("HBIPS-12-1")
    private String HBIPS_12_1; // 出院时是否带药继续使用
    @Column(name = "HBIPS_12_2")
    @JsonProperty("HBIPS-12-2")
    private String HBIPS_12_2; // 出院时带药:常用抗精神药物选择
    @Column(name = "HBIPS_12_2_1")
    @JsonProperty("HBIPS-12-2-1")
    private String HBIPS_12_2_1; // 其它抗精神病药物
    @Column(name = "HBIPS_12_4")
    @JsonProperty("HBIPS-12-4")
    private String HBIPS_12_4; // 出院时带药:常用抗抑郁药物选择
    @Column(name = "HBIPS_12_4_1")
    @JsonProperty("HBIPS-12-4-1")
    private String HBIPS_12_4_1; // 其它抗抑郁药物
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