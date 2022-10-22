package com.sxdl.drplus.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_control_process_data", description = "质控数据时保存病历号(用来数据下钻)")
@Entity
@Data
@Table(name="drplus_control_process_data")
public class DrPlusControlProcessData implements Serializable {


   /*
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;


    @Transient
   */

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;


    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_extract_detailed_id;

    @ApiModelProperty(value = "患者病历号")
    private String patient_key;

    @ApiModelProperty(value = "患者姓名")
    private String patient_name;


    @ApiModelProperty(value = "患者住院号")
    private String patient_zyh;

    @ApiModelProperty(value = "患者出院时间")
    private String patient_cysj;


    @ApiModelProperty(value = " 种类: 1 质控有问题的   2 质控时系统失败的")
    private Integer type;

//    @Transient
//    private String key;


}
