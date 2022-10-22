package com.sxdl.hpqc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@ApiModel(value = "drplus_errorlog", description = "质控报错信息")
@Entity
@Data
@Table(name="drplus_errorlog")
@Accessors(chain = true) //set链式编程
public class DrPlusErrorQualityLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_extract_detailed_id;


    @ApiModelProperty(value = "与type 字段  合用定位到哪个质控表的,哪个质控条件")
    private Integer drplus_quality_id;

    @ApiModelProperty(value = "1 标准质控表 2 完整质控表 3 逻辑质控表")
    private Integer type;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "创建时间")
    private String create_time;

/*    @ApiModelProperty(value = "患者姓名")
    private String patient_name;
    @ApiModelProperty(value = "住院号")
    private String patient_zyh;
    @ApiModelProperty(value = "出院时间")
    private String patient_cysj;*/

    @ApiModelProperty(value = "病案号: bah有的代表是单人质控的也就是说在保存数据的时候质控的  ,没有病案号的 代表是自动抽取的时候那块的质控,需要在页面上显示质控异常信息")
    private String patient_key;


    @Transient
    @ApiModelProperty(value = "质控名称")
    private String name ;

}
