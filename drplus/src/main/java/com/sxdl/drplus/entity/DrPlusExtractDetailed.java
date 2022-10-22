package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@ApiModel(value = "drplus_extract_detailed", description = "抽取明细表(每次抽取记录的list记录,有应该抽取实际抽取失败多少条,可以下钻到明细)")
@Entity
@Data
@Table(name="drplus_extract_detailed")
public class DrPlusExtractDetailed implements Serializable {


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
    private Integer id;

    @ApiModelProperty(value = "应抽数量")
    private Integer should_num;

    @ApiModelProperty(value = "实抽数量(作废)")
    private Integer actual_num;

    @ApiModelProperty(value = "创建时间")
    private String create_time;

    @ApiModelProperty(value = "抽取开始时间")
    private String start_time;

    @ApiModelProperty(value = "抽取结束时间")
    private String end_time;

    @ApiModelProperty(value = "抽取类型 : 1抽取未审核数据 2 抽取遗漏数据 3 重新抽取已审核数据  4 抽取上报失败数据 5 抽取除上报成功外的数据, 6抽取所有数据 ")
    private Integer type;

    @ApiModelProperty(value = "抽取状态 1成功 0未抽取 -1失败 ")
    private Integer state;

    @ApiModelProperty(value = "报错信息")
    private String error_reason;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "是否自动抽取: 1手动 2自动")
    private Integer is_auto;


    @Transient
    @ApiModelProperty(value = "质控出有问题的数据")
    private Integer quality_question_num;




    @Transient
    @ApiModelProperty(value = "实际抽取")
    private Integer actual_extract_num;


    @Transient
    @ApiModelProperty(value = "质控异常的数据:报错的")
    private Integer quality_exception_num;

    @Transient
    @ApiModelProperty(value = "审核通过数据")
    private Integer review_pass_num;


    @Transient
    @ApiModelProperty(value = "审核不通过数据")
    private Integer review_failed_num;


    @Transient
    @ApiModelProperty(value = "上报成功数据")
    private Integer report_pass_num;


    @Transient
    @ApiModelProperty(value = "上报失败数据")
    private Integer report_failed_num;





}
