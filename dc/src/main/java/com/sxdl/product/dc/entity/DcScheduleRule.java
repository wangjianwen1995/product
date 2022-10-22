package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "调度任务频率规则类")
@Entity
@Data
@Table(name = "dc_schedule_rule")
public class DcScheduleRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;
    @ApiModelProperty(value = "规则名称")
    private String name;
    @ApiModelProperty(value = "cron表达式")
    private String value;
    @ApiModelProperty(value = "对应调度任务的方法名称后缀")
    private String suffix;
    @ApiModelProperty("调度任务解释")
    private String remark;

    @ApiModelProperty("调度频率时间")
    private Integer param;

    @ApiModelProperty("调度频率类型单位")
    private String param_unit;



}
