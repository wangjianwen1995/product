package com.sxdl.hp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_history_tumour_dz", description = "肿瘤历史数据编码对照")
@Entity
@Data
@Table(name="hp_history_tumour_dz")
public class HpTumourHistoricalDataDz implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "当前需要对照的代码")
    private String use_dm;



    @ApiModelProperty(value = "当前需要对照的代码名称")
    private String use_mc;


    @ApiModelProperty(value = "标准代码")
    private String report_dm;

    @ApiModelProperty(value = "标准代码名称")
    private String report_mc;


    @ApiModelProperty(value = "标准代码版本")
    private String report_version;

    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "编码开始时间")
    private String bm_stime;

    @ApiModelProperty(value = "编码结束时间")
    private String bm_etime;
    @ApiModelProperty(value = "标准代码版本")
    private String report_version_ch;

}
