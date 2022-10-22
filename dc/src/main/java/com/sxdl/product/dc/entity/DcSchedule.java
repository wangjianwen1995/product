package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @version 1.0
 */
@ApiModel(value = "调度任务类")
@Entity
@Data
@Table(name = "dc_schedule")
public class DcSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;
    @ApiModelProperty(value = "任务名称")
    @NotBlank(message = "任务名称不能为空")
    private String name;
    @ApiModelProperty(value = "调度值")
    private String value;
    @ApiModelProperty(value = "修改时间")
    private String time;
    @ApiModelProperty(value = "任务规则id")
    private Integer rule_id;
    @ApiModelProperty(value = "执行任务类名称")
    private String bean_name;
    @ApiModelProperty(value = "执行任务方法名称")
    private String method_name;
    @ApiModelProperty(value = "任务状态，默认0")
    private Integer status;
    @ApiModelProperty(value = "任务类型")
    private String type;
    @ApiModelProperty(value = "任务类型id")
    private Integer type_id;
    @ApiModelProperty("调度标签")
    private String tag;
    @ApiModelProperty("调度频率时间")
    private Integer param;
    @ApiModelProperty("调度频率类型单位")
    private String param_unit;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("调度规则方法后缀")
    private String rule_suffix;

    @ApiModelProperty("执行范围以天为单位")
    private Integer scope;
    @ApiModelProperty("存储过程名称")
    private String procedure_name;
    @ApiModelProperty("存储过程id")
    private String procedure_id;

    @ApiModelProperty("调度的优先级")
    private Integer ordernum;
    @ApiModelProperty("产品id")
    private String product_id;



}
