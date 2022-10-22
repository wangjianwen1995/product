package com.sxdl.hmi.entity;


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
import java.sql.Date;
import java.util.List;

@ApiModel(value = "hmi_input_hos_info", description = "录入--医院部分信息")
@Entity
@Data
@Table(name="hmi_input_hos_info")
public class HmiInputHosInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "年度")
    private Integer year;

    @ApiModelProperty(value = "月份")
    private Integer month;

    @ApiModelProperty(value = "核定床位数")
    private Integer hdbed;

    @ApiModelProperty(value = "医院实际开放床位数")
    private Integer yysjkfbed;

    @ApiModelProperty(value = "可转换感染性疾病床位数")
    private Integer convertgrbed;

    @ApiModelProperty(value = "医院实有手术间数")
    private Integer syssrome;

    @ApiModelProperty(value = "开放手术间数")
    private Integer kfssrome;

    @ApiModelProperty(value = "录入日期")
    private Date inputdate;

    @ApiModelProperty(value = "录入人员工号")
    private String inputuser;

    @ApiModelProperty(value = "录入人员名称")
    private String inputusername;

    @Transient
    private List<HmiInputBedEntity> ksInfo;




}
