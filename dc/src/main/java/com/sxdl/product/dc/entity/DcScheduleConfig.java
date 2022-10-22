package com.sxdl.product.dc.entity;

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

/**
 * 请求类型类
 */
@ApiModel(value = "调度配置")
@Entity
@Table(name = "dc_schedule_config")
@Data
public class DcScheduleConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "产品ID")
    private String Product_id;

    @ApiModelProperty(value = "父级ID")
    private String parent_id;

    @ApiModelProperty(value = "工单ID")
    private String Job_id;

    @ApiModelProperty(value = "存储ID")
    private String procedure_id;

    @ApiModelProperty(value = "存储名称")
    private String name;

    @ApiModelProperty(value = "先决存储ID")
    private String Prent_procedure_id;

    @ApiModelProperty(value = "序号")
    private Integer Ordernum;

    @Transient
    private List<DcScheduleConfig> children;

    @ApiModelProperty(value = "产品名称")
    private String Product_name;

    @ApiModelProperty(value = "工单名称")
    private String Job_name;

    @ApiModelProperty(value = "存储名称")
    private String procedure_name;

    @ApiModelProperty("执行范围以天为单位")
    private Integer scope;

    @ApiModelProperty(value = "任务规则id")
    private String rule_id;

    @ApiModelProperty("是否有参")
    private Integer param;

    @ApiModelProperty("参数单位")
    private String param_unit;

    @ApiModelProperty("调度规则方法后缀")
    private String rule_suffix;
    @ApiModelProperty(value = "任务类型id")  // 0：工单 1：web 2:存储
    private Integer type_id;

    @ApiModelProperty(value = "是否单抽")  // 1：自动调度 2:单抽
    private Integer is_single;

    @ApiModelProperty(value = "单抽配置的ID")
    private String single_id;

    @Transient
    private Integer status; //运行状态 0：等待 1：成功 2 失败
    @Transient
    private String duration;//运行时长 秒
    @Transient
    private String message;//运行信息
}