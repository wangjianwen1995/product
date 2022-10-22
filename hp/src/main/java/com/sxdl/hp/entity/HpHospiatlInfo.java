package com.sxdl.hp.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel(value = "hp_hospiatlInfo", description = "医院信息")
@Entity
@Data
@Table(name="hp_hospiatlInfo")
public class HpHospiatlInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(newid(), '-', '')")
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "机构名称(社会代码9位)")
    private String jgmc;

    @ApiModelProperty(value = "机构代码(社会代码9位)")
    private String jgdm;

    @ApiModelProperty(value = "卫生机构（组织）分类名称16位")
    private String jgdm2;

    @ApiModelProperty(value = "地址")
    private String addr;

    @ApiModelProperty(value = "行政区划")
    private String dstrict;

    @ApiModelProperty(value = "邮编")
    private String postcode;

    @ApiModelProperty(value = "电话")
    private String tel;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "法人")
    private String legal_person;

    @ApiModelProperty(value = "统计负责人")
    private String staduty_person;

    @ApiModelProperty(value = "首页类型: 1中医 2西医 ")
    private Integer homepage_type;

    @ApiModelProperty(value = "医院等次:甲乙丙..")
    private Integer hosl_rank;

    @ApiModelProperty(value = "医院级别:一二三级")
    private Integer hos_level;

    @ApiModelProperty(value = "省行政代码")
    private String sheng_code;

    @ApiModelProperty(value = "市行政代码")
    private String shi_code;

    @ApiModelProperty(value = "县行政代码")
    private String xian_code;

    @ApiModelProperty(value = "中医表名称")
    private String chinese_medicine;

    @ApiModelProperty(value = "西医表名称")
    private String western_medicine;

    @ApiModelProperty(value = "医院his代码")
    private String his_code;

    @ApiModelProperty(value = "医院his名称")
    private String his_name;

    @ApiModelProperty(value = "医院医保付费方式,1. 按项目付费\n" +
            "2. 按单病种付费\n" +
            "3. 按病种分值(DIP)付费\n" +
            "4. 按疾病诊断相关分组(DRG)付费\n" +
            "5. 按床日付费\n" +
            "6. 按人头付费 \n" +
            "7. 按定额")
    private Integer ybfffs;
    @Transient
    //本省的中西医省附页字段和页面是否一致
    private Integer isEqual=1;
    @Transient
    private List<HpColumn> columnsCM;
    @Transient
    private List<HpColumn> columnsWM;
    @Transient
    private Map<String, String> bmVersion;
}