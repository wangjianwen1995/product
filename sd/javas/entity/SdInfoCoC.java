package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*主要诊断 ICD-10 编码：C18，D01.0；且伴主要手术操作 ICD-9-CM-3 编码：45.4,45.73 至 45.79,45.8 的手术出院患者。
*/
@ApiModel(value = "34信息")
@Entity
@Data
@Table(name = "sd_info_CoC")
public class SdInfoCoC implements Serializable {
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
    @Column(name = "CoC_0_1_4_1")
    @JsonProperty("CoC-0-1-4-1")
    private String CoC_0_1_4_1; // 其他主要手术操作ICD-9-CM-3四位亚目编码与名称
    @Column(name = "CM_0_1_4_2")
    @JsonProperty("CM-0-1-4-2")
    private String CM_0_1_4_2; // 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
    @Column(name = "CoC_0_1_4_2")
    @JsonProperty("CoC-0-1-4-2")
    private String CoC_0_1_4_2; // 其他主要手术操作ICD-9-CM-3六位临床扩展编码与名称
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
    @Column(name = "CoC_1_1_1")
    @JsonProperty("CoC-1-1-1")
    private String CoC_1_1_1; // 临床表现
    @Column(name = "CoC_1_1_1_1")
    @JsonProperty("CoC-1-1-1-1")
    private String CoC_1_1_1_1; // 其他临床表现
    @Column(name = "CoC_1_1_2")
    @JsonProperty("CoC-1-1-2")
    private String CoC_1_1_2; // 遗传/家族性高风险评估
    @Column(name = "CoC_1_1_2_1")
    @JsonProperty("CoC-1-1-2-1")
    private String CoC_1_1_2_1; // 遗传/家族性其他高风险评估
    @Column(name = "CoC_1_1_3")
    @JsonProperty("CoC-1-1-3")
    private String CoC_1_1_3; // 实验室检查
    @Column(name = "CoC_1_1_3_1")
    @JsonProperty("CoC-1-1-3-1")
    private String CoC_1_1_3_1; // 实验室其他检查
    @Column(name = "CoC_1_1_4")
    @JsonProperty("CoC-1-1-4")
    private String CoC_1_1_4; // 内窥镜检查方法
    @Column(name = "CoC_1_1_4_1")
    @JsonProperty("CoC-1-1-4-1")
    private String CoC_1_1_4_1; // 内窥镜检查其他方法
    @Column(name = "CoC_1_2_1")
    @JsonProperty("CoC-1-2-1")
    private String CoC_1_2_1; // 影像学评价方法
    @Column(name = "CoC_1_2_1_1")
    @JsonProperty("CoC-1-2-1-1")
    private String CoC_1_2_1_1; // 影像学评价其他方法
    @Column(name = "CoC_1_2_2")
    @JsonProperty("CoC-1-2-2")
    private String CoC_1_2_2; // 肿瘤位置
    @Column(name = "CoC_1_2_3")
    @JsonProperty("CoC-1-2-3")
    private String CoC_1_2_3; // 肿瘤大小
    @Column(name = "CoC_1_2_3_1")
    @JsonProperty("CoC-1-2-3-1")
    private String CoC_1_2_3_1; // 肿块大小(mm)
    @Column(name = "CoC_1_2_3_2")
    @JsonProperty("CoC-1-2-3-2")
    private String CoC_1_2_3_2; // 最大肿块(mm)
    @Column(name = "CoC_1_2_3_3")
    @JsonProperty("CoC-1-2-3-3")
    private String CoC_1_2_3_3; // 肿瘤最厚层面
    @Column(name = "CoC_1_2_4")
    @JsonProperty("CoC-1-2-4")
    private String CoC_1_2_4; // 肿瘤有无侵犯腹膜后
    @Column(name = "CoC_1_2_5")
    @JsonProperty("CoC-1-2-5")
    private String CoC_1_2_5; // 肿瘤T分期
    @Column(name = "CoC_1_2_6")
    @JsonProperty("CoC-1-2-6")
    private String CoC_1_2_6; // 淋巴结情况（N分期）
    @Column(name = "CoC_1_2_6_1")
    @JsonProperty("CoC-1-2-6-1")
    private String CoC_1_2_6_1; // 区域可疑阳性淋巴结数量(个)
    @Column(name = "CoC_1_2_6_2")
    @JsonProperty("CoC-1-2-6-2")
    private String CoC_1_2_6_2; // 单个最大短径(mm)
    @Column(name = "CoC_1_2_6_3")
    @JsonProperty("CoC-1-2-6-3")
    private String CoC_1_2_6_3; // 腹膜后可疑阳性淋巴结数量(个)
    @Column(name = "CoC_1_2_6_4")
    @JsonProperty("CoC-1-2-6-4")
    private String CoC_1_2_6_4; // 单个最大短径(mm)
    @Column(name = "CoC_1_2_7")
    @JsonProperty("CoC-1-2-7")
    private String CoC_1_2_7; // 远处转移（M分期）
    @Column(name = "CoC_1_2_8")
    @JsonProperty("CoC-1-2-8")
    private String CoC_1_2_8; // 结肠壁外血管侵犯（EMVI）
    @Column(name = "CoC_1_2_9")
    @JsonProperty("CoC-1-2-9")
    private String CoC_1_2_9; // 其他异常征象
    @Column(name = "CoC_1_2_10")
    @JsonProperty("CoC-1-2-10")
    private String CoC_1_2_10; // 影像学评价报告日期与时间
    @Column(name = "CoC_1_2_11")
    @JsonProperty("CoC-1-2-11")
    private String CoC_1_2_11; // 分期结论选择
    @Column(name = "CoC_1_2_11_1")
    @JsonProperty("CoC-1-2-11-1")
    private String CoC_1_2_11_1; //  cTNM 分期结论
    @Column(name = "CoC_1_2_11_2")
    @JsonProperty("CoC-1-2-11-2")
    private String CoC_1_2_11_2; // yTNM 分期结论
    @Column(name = "CoC_2_1_1")
    @JsonProperty("CoC-2-1-1")
    private String CoC_2_1_1; // 内窥镜检查方法
    @Column(name = "CoC_2_1_1_1")
    @JsonProperty("CoC-2-1-1-1")
    private String CoC_2_1_1_1; // 内窥镜检查其他方法
    @Column(name = "CoC_2_1_2")
    @JsonProperty("CoC-2-1-2")
    private String CoC_2_1_2; // 内窥镜活组织取材方式
    @Column(name = "CoC_2_1_2_1")
    @JsonProperty("CoC-2-1-2-1")
    private String CoC_2_1_2_1; // 内窥镜活组织取材其他方式
    @Column(name = "CoC_2_2_1")
    @JsonProperty("CoC-2-2-1")
    private String CoC_2_2_1; // 活检标本的病理报告内容和要求
    @Column(name = "CoC_2_2_2")
    @JsonProperty("CoC-2-2-2")
    private String CoC_2_2_2; // 活检病理报告时间
    @Column(name = "CoC_2_2_3")
    @JsonProperty("CoC-2-2-3")
    private String CoC_2_2_3; // 病理活检诊断
    @Column(name = "CoC_3_1_1")
    @JsonProperty("CoC-3-1-1")
    private String CoC_3_1_1; // 是否为急诊开腹或腹腔镜探查术
    @Column(name = "CoC_3_1_2")
    @JsonProperty("CoC-3-1-2")
    private String CoC_3_1_2; // 行急诊开腹或腹腔镜探查术原因
    @Column(name = "CoC_3_1_2_1")
    @JsonProperty("CoC-3-1-2-1")
    private String CoC_3_1_2_1; // 行急诊开腹或腹腔镜探查术其他原因
    @Column(name = "CoC_3_1_3")
    @JsonProperty("CoC-3-1-3")
    private String CoC_3_1_3; // 手术前病情评估结论
    @Column(name = "CoC_3_1_3_1")
    @JsonProperty("CoC-3-1-3-1")
    private String CoC_3_1_3_1; // 外科治疗模式
    @Column(name = "CoC_3_1_3_2")
    @JsonProperty("CoC-3-1-3-2")
    private String CoC_3_1_3_2; // 内窥镜下切除或局部切除的要求
    @Column(name = "CoC_3_1_3_3")
    @JsonProperty("CoC-3-1-3-3")
    private String CoC_3_1_3_3; // 手术时间
    @Column(name = "CoC_3_1_4_1")
    @JsonProperty("CoC-3-1-4-1")
    private String CoC_3_1_4_1; // 手术方式
    @Column(name = "CoC_3_1_4_2")
    @JsonProperty("CoC-3-1-4-2")
    private String CoC_3_1_4_2; // 其他手术方式
    @Column(name = "CoC_3_1_4_3")
    @JsonProperty("CoC-3-1-4-3")
    private String CoC_3_1_4_3; // 手术时间
    @Column(name = "CoC_3_1_5_1")
    @JsonProperty("CoC-3-1-5-1")
    private String CoC_3_1_5_1; // 治疗方式
    @Column(name = "CoC_3_1_5_2")
    @JsonProperty("CoC-3-1-5-2")
    private String CoC_3_1_5_2; // 手术时间
    @Column(name = "CoC_3_2_1")
    @JsonProperty("CoC-3-2-1")
    private String CoC_3_2_1; // 是否清扫淋巴结
    @Column(name = "CoC_3_2_2")
    @JsonProperty("CoC-3-2-2")
    private String CoC_3_2_2; // 淋巴结清扫范围选择
    @Column(name = "CoC_3_2_3_1")
    @JsonProperty("CoC-3-2-3-1")
    private String CoC_3_2_3_1; // D1 肠旁淋巴结
    @Column(name = "CoC_3_2_3_2")
    @JsonProperty("CoC-3-2-3-2")
    private String CoC_3_2_3_2; // 201,淋巴结数(个)
    @Column(name = "CoC_3_2_3_3")
    @JsonProperty("CoC-3-2-3-3")
    private String CoC_3_2_3_3; // 211,淋巴结数(个)
    @Column(name = "CoC_3_2_3_4")
    @JsonProperty("CoC-3-2-3-4")
    private String CoC_3_2_3_4; // 221,淋巴结数(个)
    @Column(name = "CoC_3_2_3_5")
    @JsonProperty("CoC-3-2-3-5")
    private String CoC_3_2_3_5; // D2 中间淋巴结 
    @Column(name = "CoC_3_2_3_6")
    @JsonProperty("CoC-3-2-3-6")
    private String CoC_3_2_3_6; // 202,淋巴结数(个)
    @Column(name = "CoC_3_2_3_7")
    @JsonProperty("CoC-3-2-3-7")
    private String CoC_3_2_3_7; // 212,淋巴结数(个)
    @Column(name = "CoC_3_2_3_8")
    @JsonProperty("CoC-3-2-3-8")
    private String CoC_3_2_3_8; // 222,淋巴结数(个)
    @Column(name = "CoC_3_2_3_9")
    @JsonProperty("CoC-3-2-3-9")
    private String CoC_3_2_3_9; // D3 系膜根部淋巴结 
    @Column(name = "CoC_3_2_3_10")
    @JsonProperty("CoC-3-2-3-10")
    private String CoC_3_2_3_10; // 203,淋巴结数(个)
    @Column(name = "CoC_3_2_3_11")
    @JsonProperty("CoC-3-2-3-11")
    private String CoC_3_2_3_11; // 213,淋巴结数(个)
    @Column(name = "CoC_3_2_3_12")
    @JsonProperty("CoC-3-2-3-12")
    private String CoC_3_2_3_12; // 223,淋巴结数(个)
    @Column(name = "CoC_3_2_4_1")
    @JsonProperty("CoC-3-2-4-1")
    private String CoC_3_2_4_1; // D1 肠旁淋巴结
    @Column(name = "CoC_3_2_4_2")
    @JsonProperty("CoC-3-2-4-2")
    private String CoC_3_2_4_2; // 231,淋巴结数(个)
    @Column(name = "CoC_3_2_4_3")
    @JsonProperty("CoC-3-2-4-3")
    private String CoC_3_2_4_3; // 241,淋巴结数(个)
    @Column(name = "CoC_3_2_4_4")
    @JsonProperty("CoC-3-2-4-4")
    private String CoC_3_2_4_4; // 251,淋巴结数(个)
    @Column(name = "CoC_3_2_4_5")
    @JsonProperty("CoC-3-2-4-5")
    private String CoC_3_2_4_5; // D2 中间淋巴结 
    @Column(name = "CoC_3_2_4_6")
    @JsonProperty("CoC-3-2-4-6")
    private String CoC_3_2_4_6; // 232,淋巴结数(个)
    @Column(name = "CoC_3_2_4_7")
    @JsonProperty("CoC-3-2-4-7")
    private String CoC_3_2_4_7; // 242,淋巴结数(个)
    @Column(name = "CoC_3_2_4_8")
    @JsonProperty("CoC-3-2-4-8")
    private String CoC_3_2_4_8; // 252,淋巴结数(个)
    @Column(name = "CoC_3_2_4_9")
    @JsonProperty("CoC-3-2-4-9")
    private String CoC_3_2_4_9; // D3 系膜根部淋巴结 
    @Column(name = "CoC_3_2_4_10")
    @JsonProperty("CoC-3-2-4-10")
    private String CoC_3_2_4_10; // 253,淋巴结数(个)
    @Column(name = "CoC_3_2_5_1")
    @JsonProperty("CoC-3-2-5-1")
    private String CoC_3_2_5_1; // 腹主动脉旁淋巴结
    @Column(name = "CoC_3_2_5_2")
    @JsonProperty("CoC-3-2-5-2")
    private String CoC_3_2_5_2; // 216,淋巴结数(个)
    @Column(name = "CoC_3_2_6_2")
    @JsonProperty("CoC-3-2-6-2")
    private String CoC_3_2_6_2; // 术中摘除淋巴结个数是否无法确定或无记录
    @Column(name = "CoC_3_2_6")
    @JsonProperty("CoC-3-2-6")
    private String CoC_3_2_6; // 术中摘除淋巴结个数(个)
    @Column(name = "CoC_4_1_1")
    @JsonProperty("CoC-4-1-1")
    private String CoC_4_1_1; // 术中对肿瘤切除完整性进行评估
    @Column(name = "CoC_4_1_1_1")
    @JsonProperty("CoC-4-1-1-1")
    private String CoC_4_1_1_1; // 术中对肿瘤切除完整性其他评估
    @Column(name = "CoC_4_1_2")
    @JsonProperty("CoC-4-1-2")
    private String CoC_4_1_2; // 手术切除平面
    @Column(name = "CoC_4_1_2_1")
    @JsonProperty("CoC-4-1-2-1")
    private String CoC_4_1_2_1; // 手术切除其他平面
    @Column(name = "CoC_4_1_3")
    @JsonProperty("CoC-4-1-3")
    private String CoC_4_1_3; // 淋巴结清扫安全措施
    @Column(name = "CoC_4_1_3_1")
    @JsonProperty("CoC-4-1-3-1")
    private String CoC_4_1_3_1; // 淋巴结清扫其他措施
    @Column(name = "CoC_4_1_4_1")
    @JsonProperty("CoC-4-1-4-1")
    private String CoC_4_1_4_1; // 结肠系膜切除的面积是否无法确定或无记录
    @Column(name = "CoC_4_1_4")
    @JsonProperty("CoC-4-1-4")
    private String CoC_4_1_4; // 结肠系膜切除面积(mm²)
    @Column(name = "CoC_4_1_5_1")
    @JsonProperty("CoC-4-1-5-1")
    private String CoC_4_1_5_1; // 结肠肠管切除的范围
    @Column(name = "CoC_4_1_5_2")
    @JsonProperty("CoC-4-1-5-2")
    private String CoC_4_1_5_2; // 肿瘤边缘距远端(cm)
    @Column(name = "CoC_4_1_5_3")
    @JsonProperty("CoC-4-1-5-3")
    private String CoC_4_1_5_3; // 肿瘤边缘距近端(cm)
    @Column(name = "CoC_4_1_5_4")
    @JsonProperty("CoC-4-1-5-4")
    private String CoC_4_1_5_4; // 肠管切除总长度(cm)
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
    @Column(name = "CM_2_1")
    @JsonProperty("CM-2-1")
    private String CM_2_1; // 是否有手术后并发症
    @Column(name = "CM_2_2")
    @JsonProperty("CM-2-2")
    private String CM_2_2; // 手术后并发症类别及ICD-10四位亚目的选择
    @Column(name = "CM_2_3_1")
    @JsonProperty("CM-2-3-1")
    private String CM_2_3_1; // 介入操作与手术其他并发症
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
    private String CM_2_3_8; // 手术患者手术后呼吸道并发症
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
    private String CM_2_3_12; // 麻醉并发症
    @Column(name = "CM_2_3_13")
    @JsonProperty("CM-2-3-13")
    private String CM_2_3_13; // 输注、输血反应
    @Column(name = "CoC_6_1_3")
    @JsonProperty("CoC-6-1-3")
    private String CoC_6_1_3; // 消化道手术后特指并发症的选择
    @Column(name = "CM_2_3_1_1")
    @JsonProperty("CM-2-3-1-1")
    private String CM_2_3_1_1; // 其他手术后并发症类别及ICD-10四位亚目和名称填写
    @Column(name = "CM_2_4")
    @JsonProperty("CM-2-4")
    private String CM_2_4; // 影响程度的选择
    @Column(name = "CoC_6_2_1")
    @JsonProperty("CoC-6-2-1")
    private String CoC_6_2_1; // 是否手术后再手术
    @Column(name = "CoC_6_2_2")
    @JsonProperty("CoC-6-2-2")
    private String CoC_6_2_2; // 手术后再手术ICD-9-CM-3 六位临床扩展编码与名称
    @Column(name = "CoC_6_2_3")
    @JsonProperty("CoC-6-2-3")
    private String CoC_6_2_3; // 再手术日期时间
    @Column(name = "CoC_7_1_1")
    @JsonProperty("CoC-7-1-1")
    private String CoC_7_1_1; // 是否有术后病理诊断报告
    @Column(name = "CoC_7_1_2")
    @JsonProperty("CoC-7-1-2")
    private String CoC_7_1_2; // 术后病理诊断基本内容包括
    @Column(name = "CoC_7_2_1")
    @JsonProperty("CoC-7-2-1")
    private String CoC_7_2_1; // 是否接受术前新辅助治疗
    @Column(name = "CoC_7_2_2")
    @JsonProperty("CoC-7-2-2")
    private String CoC_7_2_2; // 原发肿瘤（T）
    @Column(name = "CoC_7_2_3")
    @JsonProperty("CoC-7-2-3")
    private String CoC_7_2_3; // 区域淋巴结（N）
    @Column(name = "CoC_7_2_3_r")
    @JsonProperty("CoC-7-2-3-r")
    private String CoC_7_2_3_r; // 
    @Column(name = "CoC_7_2_4")
    @JsonProperty("CoC-7-2-4")
    private String CoC_7_2_4; // 远处转移（M）
    @Column(name = "CoC_7_2_4_r")
    @JsonProperty("CoC-7-2-4-r")
    private String CoC_7_2_4_r; // 
    @Column(name = "CoC_7_2_5")
    @JsonProperty("CoC-7-2-5")
    private String CoC_7_2_5; // pTNM分期结论
    @Column(name = "CoC_7_2_5_2")
    @JsonProperty("CoC-7-2-5-2")
    private String CoC_7_2_5_2; // ypTNM分期结论
    @Column(name = "CoC_7_2_6_1")
    @JsonProperty("CoC-7-2-6-1")
    private String CoC_7_2_6_1; // 淋巴结清扫个数
    @Column(name = "CoC_7_2_6_2")
    @JsonProperty("CoC-7-2-6-2")
    private String CoC_7_2_6_2; // 淋巴结转移个数
    @Column(name = "CoC_7_2_7")
    @JsonProperty("CoC-7-2-7")
    private String CoC_7_2_7; // 报告日期
    @Column(name = "CoC_8_1_1")
    @JsonProperty("CoC-8-1-1")
    private String CoC_8_1_1; // 是否是营养风险筛查与评估
    @Column(name = "CoC_8_1_2")
    @JsonProperty("CoC-8-1-2")
    private String CoC_8_1_2; // 营养风险筛查与评估方法选择
    @Column(name = "CoC_8_1_2_2")
    @JsonProperty("CoC-8-1-2-2")
    private String CoC_8_1_2_2; // NRS-2002评估分值
    @Column(name = "CoC_8_1_2_1")
    @JsonProperty("CoC-8-1-2-1")
    private String CoC_8_1_2_1; // 其他筛查与评估方法
    @Column(name = "CoC_8_1_3")
    @JsonProperty("CoC-8-1-3")
    private String CoC_8_1_3; // 术前是否给予营养支持
    @Column(name = "CoC_8_1_4")
    @JsonProperty("CoC-8-1-4")
    private String CoC_8_1_4; // 术前给予营养支持依据
    @Column(name = "CoC_8_1_4_1")
    @JsonProperty("CoC-8-1-4-1")
    private String CoC_8_1_4_1; // 术前给予营养支持其他依据
    @Column(name = "CoC_8_1_5")
    @JsonProperty("CoC-8-1-5")
    private String CoC_8_1_5; // 是否给予补充性肠外营养（SPN）
    @Column(name = "CoC_8_1_6")
    @JsonProperty("CoC-8-1-6")
    private String CoC_8_1_6; // 补充性肠外营养（SPN）给予依据
    @Column(name = "CoC_8_1_6_1")
    @JsonProperty("CoC-8-1-6-1")
    private String CoC_8_1_6_1; // 补充性肠外营养其他给予依据
    @Column(name = "CoC_8_2_1")
    @JsonProperty("CoC-8-2-1")
    private String CoC_8_2_1; // 是否进行手术后镇痛治疗
    @Column(name = "CoC_8_2_2")
    @JsonProperty("CoC-8-2-2")
    private String CoC_8_2_2; // 疼痛强度评估方法的选择
    @Column(name = "CoC_8_2_2_1")
    @JsonProperty("CoC-8-2-2-1")
    private String CoC_8_2_2_1; // 疼痛强度评估其他方法
    @Column(name = "CoC_8_2_3")
    @JsonProperty("CoC-8-2-3")
    private String CoC_8_2_3; // 药物选择
    @Column(name = "CoC_8_2_3_1")
    @JsonProperty("CoC-8-2-3-1")
    private String CoC_8_2_3_1; // 其他镇痛药物
    @Column(name = "CoC_8_2_4")
    @JsonProperty("CoC-8-2-4")
    private String CoC_8_2_4; // 镇痛药物用药时机选择
    @Column(name = "CoC_8_2_4_1")
    @JsonProperty("CoC-8-2-4-1")
    private String CoC_8_2_4_1; // 其他镇痛方法
    @Column(name = "CoC_8_3_1")
    @JsonProperty("CoC-8-3-1")
    private String CoC_8_3_1; // 是否进行精神心理干预
    @Column(name = "CoC_8_3_2")
    @JsonProperty("CoC-8-3-2")
    private String CoC_8_3_2; // 精神心理干预方法的选择
    @Column(name = "CoC_8_3_2_1")
    @JsonProperty("CoC-8-3-2-1")
    private String CoC_8_3_2_1; // 精神心理干预其他方法
    @Column(name = "CoC_9_1_1")
    @JsonProperty("CoC-9-1-1")
    private String CoC_9_1_1; // 是否进行Ⅱ期结肠癌的辅助化疗<br/>(注：仅限本次住院手术Ⅱ期结肠癌患者，术后辅助化疗)
    @Column(name = "CoC_9_1_2")
    @JsonProperty("CoC-9-1-2")
    private String CoC_9_1_2; // Ⅱ期结肠癌行术后辅助化疗前高危因素评估
    @Column(name = "CoC_9_1_2_1")
    @JsonProperty("CoC-9-1-2-1")
    private String CoC_9_1_2_1; // 结肠癌行术后辅助化疗前其他高危因素
    @Column(name = "CoC_9_1_3")
    @JsonProperty("CoC-9-1-3")
    private String CoC_9_1_3; // 化疗方案选择
    @Column(name = "CoC_9_1_3_1")
    @JsonProperty("CoC-9-1-3-1")
    private String CoC_9_1_3_1; // 化疗其他方案
    @Column(name = "CoC_9_1_4")
    @JsonProperty("CoC-9-1-4")
    private String CoC_9_1_4; // 辅助化疗起始时间
    @Column(name = "CoC_14_1_1")
    @JsonProperty("CoC-14-1-1")
    private String CoC_14_1_1; // 是否进行术前护理与健康教育
    @Column(name = "CM_7_1_1")
    @JsonProperty("CM-7-1-1")
    private String CM_7_1_1; // 术前护理与健康教育
    @Column(name = "CoC_14_1_2_1")
    @JsonProperty("CoC-14-1-2-1")
    private String CoC_14_1_2_1; // 其他术前护理与健康教育
    @Column(name = "CoC_14_2_1")
    @JsonProperty("CoC-14-2-1")
    private String CoC_14_2_1; // 是否进行术后护理与健康教育
    @Column(name = "CM_7_1_2")
    @JsonProperty("CM-7-1-2")
    private String CM_7_1_2; // 术后护理与健康教育
    @Column(name = "CoC_14_1_4_1")
    @JsonProperty("CoC-14-1-4-1")
    private String CoC_14_1_4_1; // 其他术后护理与健康教育
    @Column(name = "CM_7_2_1")
    @JsonProperty("CM-7-2-1")
    private String CM_7_2_1; // 交与患者“出院小结”的副本告知患者出院时风险因素
    @Column(name = "CoC_14_2_1_1")
    @JsonProperty("CoC-14-2-1-1")
    private String CoC_14_2_1_1; // 交与患者“出院小结”的副本告知患者出院时其他风险因素
    @Column(name = "CM_7_2_2")
    @JsonProperty("CM-7-2-2")
    private String CM_7_2_2; // 出院带药
    @Column(name = "CoC_14_2_2")
    @JsonProperty("CoC-14-2-2")
    private String CoC_14_2_2; // 出院放化疗及饮食原则
    @Column(name = "CoC_14_2_2_1")
    @JsonProperty("CoC-14-2-2-1")
    private String CoC_14_2_2_1; // 出院放化疗及饮食其他原则
    @Column(name = "CoC_14_2_3")
    @JsonProperty("CoC-14-2-3")
    private String CoC_14_2_3; // 有无肠造口
    @Column(name = "CoC_14_2_3_1")
    @JsonProperty("CoC-14-2-3-1")
    private String CoC_14_2_3_1; // 肠造口术后出院指导
    @Column(name = "CoC_14_2_3_2")
    @JsonProperty("CoC-14-2-3-2")
    private String CoC_14_2_3_2; // 肠造口术后出院其他指导
    @Column(name = "CM_7_2_3")
    @JsonProperty("CM-7-2-3")
    private String CM_7_2_3; // 告知何为发生紧急意外情况或者疾病复发
    @Column(name = "CM_7_2_4")
    @JsonProperty("CM-7-2-4")
    private String CM_7_2_4; // 告知发生紧急意外情况或者疾病复发如何救治及前途经
    @Column(name = "CoC_14_2_4_1")
    @JsonProperty("CoC-14-2-4-1")
    private String CoC_14_2_4_1; // 告知发生紧急意外情况或者疾病复发如何救治及其他途经
    @Column(name = "CM_7_2_5")
    @JsonProperty("CM-7-2-5")
    private String CM_7_2_5; // 出院时教育与随访
    @Column(name = "CoC_14_2_5_1")
    @JsonProperty("CoC-14-2-5-1")
    private String CoC_14_2_5_1; // 出院时其他教育与随访
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