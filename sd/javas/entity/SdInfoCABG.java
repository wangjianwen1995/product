package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要手术 ICD-9-CM-3 编码：36.1 的手术出院患者。
*/
@ApiModel(value = "03信息")
@Entity
@Data
@Table(name = "sd_info_CABG")
public class SdInfoCABG implements Serializable {
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
    @Column(name = "CM_0_1_4_1_1")
    @JsonProperty("CM-0-1-4-1-1")
    private String CM_0_1_4_1_1; // 其他ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CM_0_1_4_2_1")
    @JsonProperty("CM-0-1-4-2-1")
    private String CM_0_1_4_2_1; // 其他ICD-9-CM-3 六位临床扩展编码与名称
    @Column(name = "CM_0_1_5")
    @JsonProperty("CM-0-1-5")
    private String CM_0_1_5; // 是否为出院后31天内非预期重复住院
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
    private String CM_0_2_5_1; // 入住ICU/麻醉复苏室日期时间
    @Column(name = "CM_0_2_5_2")
    @JsonProperty("CM-0-2-5-2")
    private String CM_0_2_5_2; // 离开ICU/麻醉复苏室日期时间
    @Column(name = "CM_0_2_6_1")
    @JsonProperty("CM-0-2-6-1")
    private String CM_0_2_6_1; // 手术开始日期时间
    @Column(name = "CM_0_2_6_2")
    @JsonProperty("CM-0-2-6-2")
    private String CM_0_2_6_2; // 手术结束日期时间
    @Column(name = "CM_0_3_1")
    @JsonProperty("CM-0-3-1")
    private String CM_0_3_1; // 费用支付方式
    @Column(name = "CM_0_3_2")
    @JsonProperty("CM-0-3-2")
    private String CM_0_3_2; // 收入住院途径
    @Column(name = "CM_0_3_3")
    @JsonProperty("CM-0-3-3")
    private String CM_0_3_3; // 到院交通工具
    @Column(name = "CABG_1_2_1")
    @JsonProperty("CABG-1-2-1")
    private String CABG_1_2_1; // 实施手术前的冠状动脉造影评估
    @Column(name = "CABG_1_2_2_1")
    @JsonProperty("CABG-1-2-2-1")
    private String CABG_1_2_2_1; // 冠状动脉病变数量
    @Column(name = "CABG_1_2_2_2")
    @JsonProperty("CABG-1-2-2-2")
    private String CABG_1_2_2_2; // 血管病变主要位置
    @Column(name = "CABG_1_1_1")
    @JsonProperty("CABG-1-1-1")
    private String CABG_1_1_1; // 是否使用“SinoSCOREⅡ风险评估表”进行手术前风险评估
    @Column(name = "CABG_1_1_2")
    @JsonProperty("CABG-1-1-2")
    private String CABG_1_1_2; // ”CABG手术风险评估（SinoSCOREⅡ）“评估值
    @Column(name = "CABG_1_1_3")
    @JsonProperty("CABG-1-1-3")
    private String CABG_1_1_3; // 评估结果分层的选择
    @Column(name = "CABG_1_3_1")
    @JsonProperty("CABG-1-3-1")
    private String CABG_1_3_1; // 是否使用”欧州心血管手术危险因素评分 EuroSCORE“进行手术前评估
    @Column(name = "CABG_1_3_4")
    @JsonProperty("CABG-1-3-4")
    private String CABG_1_3_4; // 实施手术前的危险因素EuroSCORE 评分值
    @Column(name = "CABG_1_3_5")
    @JsonProperty("CABG-1-3-5")
    private String CABG_1_3_5; // 评估结果分层
    @Column(name = "CABG_1_4_2_1")
    @JsonProperty("CABG-1-4-2-1")
    private String CABG_1_4_2_1; // 是否在术前24小时内使用β受体阻滞剂
    @Column(name = "CABG_1_4_2_2")
    @JsonProperty("CABG-1-4-2-2")
    private String CABG_1_4_2_2; // 使用首剂β-受体阻滞剂
    @Column(name = "CABG_1_4_2_2_1")
    @JsonProperty("CABG-1-4-2-2-1")
    private String CABG_1_4_2_2_1; // 使用首剂β-受体阻滞剂编写
    @Column(name = "CABG_1_4_1")
    @JsonProperty("CABG-1-4-1")
    private String CABG_1_4_1; // 术前最后一次实验室检查结果
    @Column(name = "CABG_1_4_2")
    @JsonProperty("CABG-1-4-2")
    private String CABG_1_4_2; // 术前最后一次血肌酐值（mg/dL）
    @Column(name = "CABG_1_4_3")
    @JsonProperty("CABG-1-4-3")
    private String CABG_1_4_3; // 术前最后一次总胆固醇（mg/dL）
    @Column(name = "CABG_1_4_4")
    @JsonProperty("CABG-1-4-4")
    private String CABG_1_4_4; // 术前最后一次低密度脂蛋白（mg/dL）
    @Column(name = "CABG_1_4_5")
    @JsonProperty("CABG-1-4-5")
    private String CABG_1_4_5; // 术前最后一次血糖（mg/dL）
    @Column(name = "CABG_1_4_6")
    @JsonProperty("CABG-1-4-6")
    private String CABG_1_4_6; // 术前最后一次血红蛋白（g/L）
    @Column(name = "CABG_1_4_7")
    @JsonProperty("CABG-1-4-7")
    private String CABG_1_4_7; // 术前最高血肌酐值（mg/dL）
    @Column(name = "CABG_1_4_8")
    @JsonProperty("CABG-1-4-8")
    private String CABG_1_4_8; // 术前最高CK-MB（U/L）
    @Column(name = "CABG_1_4_9")
    @JsonProperty("CABG-1-4-9")
    private String CABG_1_4_9; // 术前最高cTnI（ug/L）
    @Column(name = "CABG_1_5_1")
    @JsonProperty("CABG-1-5-1")
    private String CABG_1_5_1; // 术前最后一次超声心动图左室射血分数
    @Column(name = "CABG_1_5_2")
    @JsonProperty("CABG-1-5-2")
    private String CABG_1_5_2; // 术前最后一次超声心动图左室射血分数(%)
    @Column(name = "CABG_1_5_3")
    @JsonProperty("CABG-1-5-3")
    private String CABG_1_5_3; // 左室舒张末内径(mm)
    @Column(name = "CABG_1_5_4")
    @JsonProperty("CABG-1-5-4")
    private String CABG_1_5_4; // 左房内径(mm)
    @Column(name = "CABG_1_5_5")
    @JsonProperty("CABG-1-5-5")
    private String CABG_1_5_5; // 三尖瓣收缩期返流流速(m/s)
    @Column(name = "CABG_1_5_6")
    @JsonProperty("CABG-1-5-6")
    private String CABG_1_5_6; // 主动脉瓣跨瓣压差(mmHg)
    @Column(name = "CABG_2_1_1_1")
    @JsonProperty("CABG-2-1-1-1")
    private String CABG_2_1_1_1; // 手术指征  
    @Column(name = "CABG_2_1_2")
    @JsonProperty("CABG-2-1-2")
    private String CABG_2_1_2; // 其他手术指征  
    @Column(name = "CABG_2_1")
    @JsonProperty("CABG-2-1")
    private String CABG_2_1; // 是否实施急诊CABG手术
    @Column(name = "CABG_2_2")
    @JsonProperty("CABG-2-2")
    private String CABG_2_2; // 是否实施急诊CABG手术
    @Column(name = "CABG_2_2_1")
    @JsonProperty("CABG-2-2-1")
    private String CABG_2_2_1; // 其他急诊CABG手术
    @Column(name = "CABG_2_3_1")
    @JsonProperty("CABG-2-3-1")
    private String CABG_2_3_1; // 手术切口的选择
    @Column(name = "CABG_2_4_1_1")
    @JsonProperty("CABG-2-4-1-1")
    private String CABG_2_4_1_1; // 是否合并其他手术
    @Column(name = "CABG_2_5")
    @JsonProperty("CABG-2-5")
    private String CABG_2_5; // 手术方法
    @Column(name = "CABG_2_6")
    @JsonProperty("CABG-2-6")
    private String CABG_2_6; // 是否使用体外循环
    @Column(name = "CABG_3_3_1")
    @JsonProperty("CABG-3-3-1")
    private String CABG_3_3_1; // 体外循环使用日期开始时间
    @Column(name = "CABG_3_3_3")
    @JsonProperty("CABG-3-3-3")
    private String CABG_3_3_3; // 体外循环使用日期结束时间
    @Column(name = "CABG_3_3_4")
    @JsonProperty("CABG-3-3-4")
    private String CABG_3_3_4; // 体外循环持续时间
    @Column(name = "CABG_2_7")
    @JsonProperty("CABG-2-7")
    private String CABG_2_7; // 是否术中转为体外循环
    @Column(name = "CABG_2_7_1")
    @JsonProperty("CABG-2-7-1")
    private String CABG_2_7_1; // CABG术中是否放置漂浮导管
    @Column(name = "CABG_2_8_1")
    @JsonProperty("CABG-2-8-1")
    private String CABG_2_8_1; // 围术期使用血制品
    @Column(name = "CABG_2_8_3")
    @JsonProperty("CABG-2-8-3")
    private String CABG_2_8_3; // 其中:全血量（ml）
    @Column(name = "CABG_2_8_4")
    @JsonProperty("CABG-2-8-4")
    private String CABG_2_8_4; // 其中:红细胞量（ml）
    @Column(name = "CABG_2_8_5")
    @JsonProperty("CABG-2-8-5")
    private String CABG_2_8_5; // 其中:血浆量（ml）
    @Column(name = "CABG_2_8_6")
    @JsonProperty("CABG-2-8-6")
    private String CABG_2_8_6; // 其中:血小板量（ml）
    @Column(name = "CABG_2_8_2")
    @JsonProperty("CABG-2-8-2")
    private String CABG_2_8_2; // 临床用血总量（ml）
    @Column(name = "CABG_3_1_0")
    @JsonProperty("CABG-3-1-0")
    private String CABG_3_1_0; // 建立血管桥支数
    @Column(name = "CABG_3_10_1_1")
    @JsonProperty("CABG-3-10-1-1")
    private String CABG_3_10_1_1; // 血管桥材料
    @Column(name = "CABG_3_10_1_1_1")
    @JsonProperty("CABG-3-10-1-1-1")
    private String CABG_3_10_1_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_1_3")
    @JsonProperty("CABG-3-10-1-3")
    private String CABG_3_10_1_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_1_5")
    @JsonProperty("CABG-3-10-1-5")
    private String CABG_3_10_1_5; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_1_6")
    @JsonProperty("CABG-3-10-1-6")
    private String CABG_3_10_1_6; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_2_1")
    @JsonProperty("CABG-3-10-2-1")
    private String CABG_3_10_2_1; // 血管桥材料
    @Column(name = "CABG_3_10_2_1_1")
    @JsonProperty("CABG-3-10-2-1-1")
    private String CABG_3_10_2_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_2_3")
    @JsonProperty("CABG-3-10-2-3")
    private String CABG_3_10_2_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_2_4")
    @JsonProperty("CABG-3-10-2-4")
    private String CABG_3_10_2_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_2_5")
    @JsonProperty("CABG-3-10-2-5")
    private String CABG_3_10_2_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_3_1")
    @JsonProperty("CABG-3-10-3-1")
    private String CABG_3_10_3_1; // 血管桥材料
    @Column(name = "CABG_3_10_3_1_1")
    @JsonProperty("CABG-3-10-3-1-1")
    private String CABG_3_10_3_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_3_3")
    @JsonProperty("CABG-3-10-3-3")
    private String CABG_3_10_3_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_3_4")
    @JsonProperty("CABG-3-10-3-4")
    private String CABG_3_10_3_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_3_5")
    @JsonProperty("CABG-3-10-3-5")
    private String CABG_3_10_3_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_4_1")
    @JsonProperty("CABG-3-10-4-1")
    private String CABG_3_10_4_1; // 血管桥材料
    @Column(name = "CABG_3_10_4_1_1")
    @JsonProperty("CABG-3-10-4-1-1")
    private String CABG_3_10_4_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_4_3")
    @JsonProperty("CABG-3-10-4-3")
    private String CABG_3_10_4_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_4_4")
    @JsonProperty("CABG-3-10-4-4")
    private String CABG_3_10_4_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_4_5")
    @JsonProperty("CABG-3-10-4-5")
    private String CABG_3_10_4_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_5_1")
    @JsonProperty("CABG-3-10-5-1")
    private String CABG_3_10_5_1; // 血管桥材料
    @Column(name = "CABG_3_10_5_1_1")
    @JsonProperty("CABG-3-10-5-1-1")
    private String CABG_3_10_5_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_5_3")
    @JsonProperty("CABG-3-10-5-3")
    private String CABG_3_10_5_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_5_4")
    @JsonProperty("CABG-3-10-5-4")
    private String CABG_3_10_5_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_5_5")
    @JsonProperty("CABG-3-10-5-5")
    private String CABG_3_10_5_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_6_1")
    @JsonProperty("CABG-3-10-6-1")
    private String CABG_3_10_6_1; // 血管桥材料
    @Column(name = "CABG_3_10_6_1_1")
    @JsonProperty("CABG-3-10-6-1-1")
    private String CABG_3_10_6_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_6_3")
    @JsonProperty("CABG-3-10-6-3")
    private String CABG_3_10_6_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_6_4")
    @JsonProperty("CABG-3-10-6-4")
    private String CABG_3_10_6_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_6_5")
    @JsonProperty("CABG-3-10-6-5")
    private String CABG_3_10_6_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_7_1")
    @JsonProperty("CABG-3-10-7-1")
    private String CABG_3_10_7_1; // 血管桥材料
    @Column(name = "CABG_3_10_7_1_1")
    @JsonProperty("CABG-3-10-7-1-1")
    private String CABG_3_10_7_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_7_3")
    @JsonProperty("CABG-3-10-7-3")
    private String CABG_3_10_7_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_7_4")
    @JsonProperty("CABG-3-10-7-4")
    private String CABG_3_10_7_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_7_5")
    @JsonProperty("CABG-3-10-7-5")
    private String CABG_3_10_7_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_8_1")
    @JsonProperty("CABG-3-10-8-1")
    private String CABG_3_10_8_1; // 血管桥材料
    @Column(name = "CABG_3_10_8_1_1")
    @JsonProperty("CABG-3-10-8-1-1")
    private String CABG_3_10_8_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_8_3")
    @JsonProperty("CABG-3-10-8-3")
    private String CABG_3_10_8_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_8_4")
    @JsonProperty("CABG-3-10-8-4")
    private String CABG_3_10_8_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_8_5")
    @JsonProperty("CABG-3-10-8-5")
    private String CABG_3_10_8_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_9_1")
    @JsonProperty("CABG-3-10-9-1")
    private String CABG_3_10_9_1; // 血管桥材料
    @Column(name = "CABG_3_10_9_1_1")
    @JsonProperty("CABG-3-10-9-1-1")
    private String CABG_3_10_9_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_9_3")
    @JsonProperty("CABG-3-10-9-3")
    private String CABG_3_10_9_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_9_4")
    @JsonProperty("CABG-3-10-9-4")
    private String CABG_3_10_9_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_9_5")
    @JsonProperty("CABG-3-10-9-5")
    private String CABG_3_10_9_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_10_10_1")
    @JsonProperty("CABG-3-10-10-1")
    private String CABG_3_10_10_1; // 血管桥材料
    @Column(name = "CABG_3_10_10_1_1")
    @JsonProperty("CABG-3-10-10-1-1")
    private String CABG_3_10_10_1_1; // 其他血管桥材料
    @Column(name = "CABG_3_10_10_3")
    @JsonProperty("CABG-3-10-10-3")
    private String CABG_3_10_10_3; // 远端吻合口位置
    @Column(name = "CABG_3_10_10_4")
    @JsonProperty("CABG-3-10-10-4")
    private String CABG_3_10_10_4; // 是否实施桥血管流量监测
    @Column(name = "CABG_3_10_10_5")
    @JsonProperty("CABG-3-10-10-5")
    private String CABG_3_10_10_5; // 桥血管流量（mL/min）
    @Column(name = "CABG_3_12")
    @JsonProperty("CABG-3-12")
    private String CABG_3_12; // 术后是否入住ICU/术后复苏室
    @Column(name = "CABG_3_13")
    @JsonProperty("CABG-3-13")
    private String CABG_3_13; // 在ICU/术后复苏室是否实施机械通气
    @Column(name = "CABG_3_15_1")
    @JsonProperty("CABG-3-15-1")
    private String CABG_3_15_1; // 起始时间
    @Column(name = "CABG_3_15_2")
    @JsonProperty("CABG-3-15-2")
    private String CABG_3_15_2; // 终止时间
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM-1-1-1")
    private String CM_1_1_1; // 是否使用预防性抗菌药物
    @Column(name = "CM_1_2_1_2")
    @JsonProperty("CM-1-2-1-2")
    private String CM_1_2_1_2; // 预防性抗菌药物选择
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
    @Column(name = "CM_1_5_1")
    @JsonProperty("CM-1-5-1")
    private String CM_1_5_1; // 手术时间是否≥3小时
    @Column(name = "CM_1_5_2")
    @JsonProperty("CM-1-5-2")
    private String CM_1_5_2; // 是否术中追加抗菌药物
    @Column(name = "CM_1_5_3")
    @JsonProperty("CM-1-5-3")
    private String CM_1_5_3; // 术中出血量是否≥1500ml
    @Column(name = "CM_1_5_4")
    @JsonProperty("CM-1-5-4")
    private String CM_1_5_4; // 是否术中追加抗菌药物
    @Column(name = "CM_1_6_1")
    @JsonProperty("CM-1-6-1")
    private String CM_1_6_1; // 术后抗菌药物停止使用时间
    @Column(name = "CM_1_6_1_dump")
    @JsonProperty("CM-1-6-1-dump")
    private String CM_1_6_1_dump; // 使用抗菌药物时间
    @Column(name = "CM_1_6_2")
    @JsonProperty("CM-1-6-2")
    private String CM_1_6_2; // 使用抗菌药物时间使用时间分层
    @Column(name = "CM_1_6_3_2")
    @JsonProperty("CM-1-6-3-2")
    private String CM_1_6_3_2; // 术后72小时之后继续使用的原因
    @Column(name = "CABG_13_1_1")
    @JsonProperty("CABG-13-1-1")
    private String CABG_13_1_1; // 术后医嘱-是否使用阿司匹林药物
    @Column(name = "CABG_4_1_2")
    @JsonProperty("CABG-4-1-2")
    private String CABG_4_1_2; // 用药日期时间
    @Column(name = "CABG_13_2_1")
    @JsonProperty("CABG-13-2-1")
    private String CABG_13_2_1; // 术后医嘱-是否使用氯吡格雷药物
    @Column(name = "CABG_5_4_2")
    @JsonProperty("CABG-5-4-2")
    private String CABG_5_4_2; // 用药日期时间
    @Column(name = "CABG_5_4_3")
    @JsonProperty("CABG-5-4-3")
    private String CABG_5_4_3; // 术后医嘱-是否使用替格瑞洛药物
    @Column(name = "CABG_5_4_3_1")
    @JsonProperty("CABG-5-4-3-1")
    private String CABG_5_4_3_1; // 用药日期时间
    @Column(name = "CABG_5_1_1")
    @JsonProperty("CABG-5-1-1")
    private String CABG_5_1_1; // 术后是否有活动性出血或血肿
    @Column(name = "CABG_5_1_2")
    @JsonProperty("CABG-5-1-2")
    private String CABG_5_1_2; // 术后活动性出血或血肿主要情况
    @Column(name = "CABG_5_2_1")
    @JsonProperty("CABG-5-2-1")
    private String CABG_5_2_1; // 再手术
    @Column(name = "CABG_5_2_2")
    @JsonProperty("CABG-5-2-2")
    private String CABG_5_2_2; // 再手术指征
    @Column(name = "CABG_5_2_2_1")
    @JsonProperty("CABG-5-2-2-1")
    private String CABG_5_2_2_1; // 其他心脏问题再手术
    @Column(name = "CABG_5_2_2_2")
    @JsonProperty("CABG-5-2-2-2")
    private String CABG_5_2_2_2; // 其他非心脏问题再手术
    @Column(name = "CABG_5_4_1")
    @JsonProperty("CABG-5-4-1")
    private String CABG_5_4_1; // 再手术起始时间
    @Column(name = "CM_2_1")
    @JsonProperty("CM-2-1")
    private String CM_2_1; // 是否有手术后并发证
    @Column(name = "CM_2_2")
    @JsonProperty("CM-2-2")
    private String CM_2_2; // 手术后并发证类别及ICD-10四位亚目的选择
    @Column(name = "CM_2_3_1_1")
    @JsonProperty("CM-2-3-1-1")
    private String CM_2_3_1_1; // 其他手术后并发证类别及ICD-10四位亚目和名称填写
    @Column(name = "CM_2_3_1")
    @JsonProperty("CM-2-3-1")
    private String CM_2_3_1; // 介入操作与手术其他并发证
    @Column(name = "CM_2_3_2")
    @JsonProperty("CM-2-3-2")
    private String CM_2_3_2; // 手术患者手术后肺栓塞
    @Column(name = "CM_2_3_3")
    @JsonProperty("CM-2-3-3")
    private String CM_2_3_3; // 手术患者手术后深静脉血栓
    @Column(name = "CM_2_3_4")
    @JsonProperty("CM-2-3-4")
    private String CM_2_3_4; // 手术患者手术后败血症
    @Column(name = "CM_2_3_5")
    @JsonProperty("CM-2-3-5")
    private String CM_2_3_5; // 手术患者手术后出血或血肿
    @Column(name = "CM_2_3_6")
    @JsonProperty("CM-2-3-6")
    private String CM_2_3_6; // 手术患者手术伤口裂开
    @Column(name = "CM_2_3_7")
    @JsonProperty("CM-2-3-7")
    private String CM_2_3_7; // 手术患者猝死
    @Column(name = "CM_2_3_8")
    @JsonProperty("CM-2-3-8")
    private String CM_2_3_8; // 手术患者手术后呼吸道并发证
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
    private String CM_2_3_12; // 麻醉并发证
    @Column(name = "CM_2_3_13")
    @JsonProperty("CM-2-3-13")
    private String CM_2_3_13; // 输注、输血反应
    @Column(name = "CM_2_70")
    @JsonProperty("CM-2-70")
    private String CM_2_70; // 住院患者发生压疮
    @Column(name = "CM_2_71")
    @JsonProperty("CM-2-71")
    private String CM_2_71; // 循环系统术后并发证
    @Column(name = "CM_2_72")
    @JsonProperty("CM-2-72")
    private String CM_2_72; // 心脏和血管植入物的并发证
    @Column(name = "CM_2_73")
    @JsonProperty("CM-2-73")
    private String CM_2_73; // 脑卒中/脑血管事件
    @Column(name = "CABG_6_2_4")
    @JsonProperty("CABG-6-2-4")
    private String CABG_6_2_4; // CABG术后特指并发症--手术后急性肾损伤
    @Column(name = "CABG_7_2")
    @JsonProperty("CABG-7-2")
    private String CABG_7_2; // 是否进行术后头颅影像学检查
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 头颅影像学检查结果
    @Column(name = "CABG_14_1_1")
    @JsonProperty("CABG-14-1-1")
    private String CABG_14_1_1; // 出院带药医嘱：阿司匹林医嘱
    @Column(name = "CABG_14_1_2")
    @JsonProperty("CABG-14-1-2")
    private String CABG_14_1_2; // 药物品名的选择
    @Column(name = "CABG_14_1_2_1")
    @JsonProperty("CABG-14-1-2-1")
    private String CABG_14_1_2_1; // 其他抗血小板药物
    @Column(name = "CABG_14_2_1")
    @JsonProperty("CABG-14-2-1")
    private String CABG_14_2_1; // 出院带药医嘱-β阻滞剂医嘱
    @Column(name = "CABG_14_2_2")
    @JsonProperty("CABG-14-2-2")
    private String CABG_14_2_2; // 药物品名的选择
    @Column(name = "CABG_14_2_3")
    @JsonProperty("CABG-14-2-3")
    private String CABG_14_2_3; // 其他β-受体阻滞剂
    @Column(name = "CABG_14_3_1")
    @JsonProperty("CABG-14-3-1")
    private String CABG_14_3_1; // 出院带药医嘱-他汀类药物医嘱
    @Column(name = "CABG_14_3_2")
    @JsonProperty("CABG-14-3-2")
    private String CABG_14_3_2; // 药物品名的选择
    @Column(name = "CABG_14_3_2_1")
    @JsonProperty("CABG-14-3-2-1")
    private String CABG_14_3_2_1; // 其他降脂药物
    @Column(name = "CABG_7_1")
    @JsonProperty("CABG-7-1")
    private String CABG_7_1; // 手术前健康教育项目的选择
    @Column(name = "CABG_7_4_1_1")
    @JsonProperty("CABG-7-4-1-1")
    private String CABG_7_4_1_1; // 围术期心梗的护理措施
    @Column(name = "CABG_7_4_1_2")
    @JsonProperty("CABG-7-4-1-2")
    private String CABG_7_4_1_2; // 循环维护
    @Column(name = "CABG_7_4_1_3")
    @JsonProperty("CABG-7-4-1-3")
    private String CABG_7_4_1_3; // 心律失常
    @Column(name = "CABG_7_4_1_4")
    @JsonProperty("CABG-7-4-1-4")
    private String CABG_7_4_1_4; // 下肢组织灌注量改变
    @Column(name = "CABG_7_4_1_5")
    @JsonProperty("CABG-7-4-1-5")
    private String CABG_7_4_1_5; // 合并糖尿病的护理
    @Column(name = "CABG_7_4_1_6")
    @JsonProperty("CABG-7-4-1-6")
    private String CABG_7_4_1_6; // 术后主要护理措施无法确定或无记录
    @Column(name = "CABG_7_3_1")
    @JsonProperty("CABG-7-3-1")
    private String CABG_7_3_1; // 血运重建术后应当定期进行全面的临床和预后评估的选择
    @Column(name = "CABG_7_3_2")
    @JsonProperty("CABG-7-3-2")
    private String CABG_7_3_2; // 应当对患者进行健康教育的选择
    @Column(name = "CABG_7_3_3")
    @JsonProperty("CABG-7-3-3")
    private String CABG_7_3_3; // 饮食和体重的控制标准的选择
    @Column(name = "CABG_7_3_4")
    @JsonProperty("CABG-7-3-4")
    private String CABG_7_3_4; // 推荐选择健康食品，改变生活方式、饮食疗法及药物治疗的选择
    @Column(name = "CABG_7_3_5")
    @JsonProperty("CABG-7-3-5")
    private String CABG_7_3_5; // 糖尿病患者控制血糖水平
    @Column(name = "CM_3_1")
    @JsonProperty("CM-3-1")
    private String CM_3_1; // 手术野皮肤准备常用方法的选择
    @Column(name = "CM_3_2")
    @JsonProperty("CM-3-2")
    private String CM_3_2; // 使用含抗菌剂（三氯生）缝线
    @Column(name = "CM_3_2_1")
    @JsonProperty("CM-3-2-1")
    private String CM_3_2_1; // 其他含抗菌剂缝线填写
    @Column(name = "CM_3_3")
    @JsonProperty("CM-3-3")
    private String CM_3_3; // 手术切口类别的选择
    @Column(name = "CM_3_4")
    @JsonProperty("CM-3-4")
    private String CM_3_4; // 手术切口愈合情况的选择
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