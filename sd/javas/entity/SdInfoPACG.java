package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：H26.2，H40.0，H40.2，H40.9，且伴主要手术 ICD-9-CM-3 编码：10.1，10.49，10.6，10.91，10.99，12.11，12.12，12.64，12.66，12.67，12.71 至 12.73，12.79，12.83，12.85，12.87，12.91，12.92，12.99，13.19，13.3，13.41，13.59，13.70，13.71，13.90，14.73，14.74，14.79 的手术出院患者。
*/
@ApiModel(value = "41信息")
@Entity
@Data
@Table(name = "sd_info_PACG")
public class SdInfoPACG implements Serializable {
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
    @Column(name = "PACG_0_1_3_1")
    @JsonProperty("PACG-0-1-3-1")
    private String PACG_0_1_3_1; // 其他主要诊断ICD-10四位亚目编码与名称
    @Column(name = "CM_0_1_3_2")
    @JsonProperty("CM-0-1-3-2")
    private String CM_0_1_3_2; // 主要诊断ICD-10六位临床扩展编码与名称
    @Column(name = "PACG_0_1_3_2")
    @JsonProperty("PACG-0-1-3-2")
    private String PACG_0_1_3_2; // 其他主要诊断ICD-10六位临床扩展编码与名称
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
    @Column(name = "PACG_1_1_1")
    @JsonProperty("PACG-1-1-1")
    private String PACG_1_1_1; // 患者年龄
    @Column(name = "PACG_1_1_2")
    @JsonProperty("PACG-1-1-2")
    private String PACG_1_1_2; // 临床表现
    @Column(name = "PACG_1_1_3")
    @JsonProperty("PACG-1-1-3")
    private String PACG_1_1_3; // 体征
    @Column(name = "PACG_1_2_1")
    @JsonProperty("PACG-1-2-1")
    private String PACG_1_2_1; // 是否进行术前生活视力检查
    @Column(name = "PACG_1_2_2")
    @JsonProperty("PACG-1-2-2")
    private String PACG_1_2_2; // 术前生活视力检查结果
    @Column(name = "PACG_1_2_3")
    @JsonProperty("PACG-1-2-3")
    private String PACG_1_2_3; // 是否进行术前矫正视力检查
    @Column(name = "PACG_1_2_4")
    @JsonProperty("PACG-1-2-4")
    private String PACG_1_2_4; // 术前矫正视力检查结果
    @Column(name = "PACG_1_2_5")
    @JsonProperty("PACG-1-2-5")
    private String PACG_1_2_5; // 是否术前气动非接触眼压测量
    @Column(name = "PACG_1_2_6")
    @JsonProperty("PACG-1-2-6")
    private String PACG_1_2_6; // 术前眼压测量结果(mmHg)
    @Column(name = "PACG_1_3_1")
    @JsonProperty("PACG-1-3-1")
    private String PACG_1_3_1; // 手术前是否进行前房角镜检查
    @Column(name = "PACG_1_3_2")
    @JsonProperty("PACG-1-3-2")
    private String PACG_1_3_2; // 房角镜检查报告中应描述的内容
    @Column(name = "PACG_1_3_2_1")
    @JsonProperty("PACG-1-3-2-1")
    private String PACG_1_3_2_1; // 房角镜检查报告中其他阳性发现
    @Column(name = "PACG_1_3_3")
    @JsonProperty("PACG-1-3-3")
    private String PACG_1_3_3; // 房角镜下是否有下列所见
    @Column(name = "PACG_1_3_3_1")
    @JsonProperty("PACG-1-3-3-1")
    private String PACG_1_3_3_1; // 房角镜下其他阳性发现
    @Column(name = "PACG_1_3_4")
    @JsonProperty("PACG-1-3-4")
    private String PACG_1_3_4; // 房角镜检查印象
    @Column(name = "PACG_1_3_4_1")
    @JsonProperty("PACG-1-3-4-1")
    private String PACG_1_3_4_1; // 其他房角镜检查印象
    @Column(name = "PACG_1_4_1")
    @JsonProperty("PACG-1-4-1")
    private String PACG_1_4_1; // 手术前是否进行UBM镜检查
    @Column(name = "PACG_1_4_2")
    @JsonProperty("PACG-1-4-2")
    private String PACG_1_4_2; // UBM报告中应描述的内容
    @Column(name = "PACG_1_4_2_1")
    @JsonProperty("PACG-1-4-2-1")
    private String PACG_1_4_2_1; // UBM报告中其他阳性发现
    @Column(name = "PACG_1_4_3")
    @JsonProperty("PACG-1-4-3")
    private String PACG_1_4_3; // 中央前房深度(mm)
    @Column(name = "PACG_1_4_5")
    @JsonProperty("PACG-1-4-5")
    private String PACG_1_4_5; // UBM报告中是否有下列所见
    @Column(name = "PACG_1_4_5_1")
    @JsonProperty("PACG-1-4-5-1")
    private String PACG_1_4_5_1; // UBM报告中其他阳性发现
    @Column(name = "PACG_1_4_6")
    @JsonProperty("PACG-1-4-6")
    private String PACG_1_4_6; // UBM检查印象
    @Column(name = "PACG_1_4_6_1")
    @JsonProperty("PACG-1-4-6-1")
    private String PACG_1_4_6_1; // UBM检查印象中其他阳性发现
    @Column(name = "PACG_1_5_1")
    @JsonProperty("PACG-1-5-1")
    private String PACG_1_5_1; // 手术前是否进行免散瞳眼底照相检查
    @Column(name = "PACG_1_5_2")
    @JsonProperty("PACG-1-5-2")
    private String PACG_1_5_2; // 眼底照相结果如何
    @Column(name = "PACG_1_5_2_1")
    @JsonProperty("PACG-1-5-2-1")
    private String PACG_1_5_2_1; // 眼底照相结果其他阳性发现
    @Column(name = "PACG_1_6_1")
    @JsonProperty("PACG-1-6-1")
    private String PACG_1_6_1; // 手术前是否进行视神经OCT测量
    @Column(name = "PACG_1_6_2")
    @JsonProperty("PACG-1-6-2")
    private String PACG_1_6_2; // OCT测量结果如何
    @Column(name = "PACG_1_6_2_1")
    @JsonProperty("PACG-1-6-2-1")
    private String PACG_1_6_2_1; // OCT测量结果其他阳性发现
    @Column(name = "PACG_1_7_1")
    @JsonProperty("PACG-1-7-1")
    private String PACG_1_7_1; // 手术前是否进行视野检查
    @Column(name = "PACG_1_7_2")
    @JsonProperty("PACG-1-7-2")
    private String PACG_1_7_2; // 视野检查结果如何
    @Column(name = "PACG_1_7_2_1")
    @JsonProperty("PACG-1-7-2-1")
    private String PACG_1_7_2_1; // 视野检查结果其他阳性发现
    @Column(name = "PACG_1_8_1")
    @JsonProperty("PACG-1-8-1")
    private String PACG_1_8_1; // 手术前是否进行眼轴长度测量
    @Column(name = "PACG_1_8_2")
    @JsonProperty("PACG-1-8-2")
    private String PACG_1_8_2; // 眼轴测量结果(mm)
    @Column(name = "PACG_1_9_1")
    @JsonProperty("PACG-1-9-1")
    private String PACG_1_9_1; // 分类结果
    @Column(name = "PACG_2_1_1")
    @JsonProperty("PACG-2-1-1")
    private String PACG_2_1_1; // 既往是否曾行预防性激光治疗（LPI或/和ALPI)
    @Column(name = "PACG_2_1_2")
    @JsonProperty("PACG-2-1-2")
    private String PACG_2_1_2; // 既往是否曾接受过抗青光眼手术治疗
    @Column(name = "PACG_2_1_3")
    @JsonProperty("PACG-2-1-3")
    private String PACG_2_1_3; // 既往是否曾接受过抗青光眼手术以外的其他手术治疗
    @Column(name = "PACG_2_2_1")
    @JsonProperty("PACG-2-2-1")
    private String PACG_2_2_1; // 本次抗青光眼手术适应证的选择
    @Column(name = "PACG_2_2_1_1")
    @JsonProperty("PACG-2-2-1-1")
    private String PACG_2_2_1_1; // 其他抗青光眼手术适应证
    @Column(name = "PACG_2_2_2")
    @JsonProperty("PACG-2-2-2")
    private String PACG_2_2_2; // 手术治疗方式选择
    @Column(name = "PACG_2_2_2_1")
    @JsonProperty("PACG-2-2-2-1")
    private String PACG_2_2_2_1; // 其他手术治疗方式
    @Column(name = "CM_1_1_1")
    @JsonProperty("CM-1-1-1")
    private String CM_1_1_1; // 是否使用预防性抗菌药物
    @Column(name = "PACG_3_1_2")
    @JsonProperty("PACG-3-1-2")
    private String PACG_3_1_2; // 预防性抗菌药物给药途径选择
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
    @Column(name = "PACG_4_1_1")
    @JsonProperty("PACG-4-1-1")
    private String PACG_4_1_1; // 是否存在术中并发症
    @Column(name = "PACG_4_1_2")
    @JsonProperty("PACG-4-1-2")
    private String PACG_4_1_2; // PACG术中并发症
    @Column(name = "PACG_4_1_2_1")
    @JsonProperty("PACG-4-1-2-1")
    private String PACG_4_1_2_1; // 其他PACG术中并发症
    @Column(name = "PACG_4_2_1")
    @JsonProperty("PACG-4-2-1")
    private String PACG_4_2_1; // 术中并发症的处理
    @Column(name = "PACG_5_1_1")
    @JsonProperty("PACG-5-1-1")
    private String PACG_5_1_1; // 是否术后气动非接触眼压测量
    @Column(name = "PACG_5_1_2")
    @JsonProperty("PACG-5-1-2")
    private String PACG_5_1_2; // 术后眼压测量结果(mmHg)
    @Column(name = "PACG_5_1_3")
    @JsonProperty("PACG-5-1-3")
    private String PACG_5_1_3; // 术后眼压与术前比较
    @Column(name = "PACG_6_1_1")
    @JsonProperty("PACG-6-1-1")
    private String PACG_6_1_1; // 是否术后生活视力检查
    @Column(name = "PACG_6_1_2")
    @JsonProperty("PACG-6-1-2")
    private String PACG_6_1_2; // 术后生活视力检查结果
    @Column(name = "PACG_6_1_3")
    @JsonProperty("PACG-6-1-3")
    private String PACG_6_1_3; // 术后生活视力与术前比较
    @Column(name = "PACG_6_2_1")
    @JsonProperty("PACG-6-2-1")
    private String PACG_6_2_1; // 是否术后矫正视力检查
    @Column(name = "PACG_6_2_2")
    @JsonProperty("PACG-6-2-2")
    private String PACG_6_2_2; // 术后矫正视力检查结果
    @Column(name = "PACG_6_2_3")
    @JsonProperty("PACG-6-2-3")
    private String PACG_6_2_3; // 术后矫正视力与术前比较
    @Column(name = "PACG_7_1_1")
    @JsonProperty("PACG-7-1-1")
    private String PACG_7_1_1; // 是否存在术后并发症
    @Column(name = "PACG_7_1_2")
    @JsonProperty("PACG-7-1-2")
    private String PACG_7_1_2; // 眼科手术后特指并发症
    @Column(name = "PACG_7_1_2_1")
    @JsonProperty("PACG-7-1-2-1")
    private String PACG_7_1_2_1; // 其他眼科手术后特指并发症
    @Column(name = "PACG_7_2_1")
    @JsonProperty("PACG-7-2-1")
    private String PACG_7_2_1; // 术后并发症的处理
    @Column(name = "PACG_7_3_1")
    @JsonProperty("PACG-7-3-1")
    private String PACG_7_3_1; // 影响程度的选择
    @Column(name = "PACG_8_1_1")
    @JsonProperty("PACG-8-1-1")
    private String PACG_8_1_1; // 是否进行术前健康教育，且有记录可追踪
    @Column(name = "CM_7_1_1")
    @JsonProperty("CM-7-1-1")
    private String CM_7_1_1; // PACG术前健康教育项目的选择
    @Column(name = "PACG_8_1_2")
    @JsonProperty("PACG-8-1-2")
    private String PACG_8_1_2; // 是否进行术后健康教育，且有记录可追踪
    @Column(name = "CM_7_1_2")
    @JsonProperty("CM-7-1-2")
    private String CM_7_1_2; // PACG术后康复教育项目的选择
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