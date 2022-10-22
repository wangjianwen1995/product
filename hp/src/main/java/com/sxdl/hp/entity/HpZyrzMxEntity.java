package com.sxdl.hp.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_zyrz_mx", description = "住院日志患者明细表(手动录入明细)")
@Entity
@Data
@Table(name="hp_zyrz_mx")
public class HpZyrzMxEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @JsonProperty("id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "患者姓名")
    @JsonProperty("hz_xm")
    private String hz_xm;


    @ApiModelProperty(value = "统计科室")
    @JsonProperty("tjks")
    private String tjks;

    @ApiModelProperty(value = "统计科室")
    @JsonProperty("tjks_mc")
    private String tjks_mc;


    @ApiModelProperty(value = "患者病案号")
    @JsonProperty("bah")
    private String bah;

    @ApiModelProperty(value = "患者住院号")
    @JsonProperty("zyh")
    private String zyh;


    @ApiModelProperty(value = "统计时间类型")
    @JsonProperty("type")
    private String type;

    @ApiModelProperty(value = "统计时间")
    @JsonProperty("tjsj")
    private String tjsj;


    @ApiModelProperty(value = "录入时间")
    @JsonProperty("lrsj")
    private String lrsj;


    @ApiModelProperty(value = "录入人")
    @JsonProperty("lur")
    private String lur;

    @ApiModelProperty(value = "录入人名称")
    @JsonProperty("lur_mc")
    private String lur_mc;






}
