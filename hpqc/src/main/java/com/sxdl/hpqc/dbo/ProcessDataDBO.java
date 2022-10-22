package com.sxdl.hpqc.dbo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProcessDataDBO implements Serializable {



    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    private String id;


    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_extract_detailed;

    @ApiModelProperty(value = "患者病历号")
    private String patient_key;

    @ApiModelProperty(value = "患者姓名")
    private String patient_name;


    @ApiModelProperty(value = "患者住院号")
    private String patient_zyh;

    @ApiModelProperty(value = "患者出院时间")
    private String patient_cysj;

    @ApiModelProperty(value = "上报结果")
    private String report_content;


    @ApiModelProperty(value = "撤销时候用到的代码")
    private String revoke_code ;


/*    @ApiModelProperty(value = "与type 字段  合用定位到哪个质控表的,哪个质控条件")
    private Integer drplus_quality_id;

    @ApiModelProperty(value = "1 标准质控表 2 完整质控表 3 逻辑质控表")
    private Integer type;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "创建时间")
    private String create_time;*/







//    @Transient
//    private String key;


}
