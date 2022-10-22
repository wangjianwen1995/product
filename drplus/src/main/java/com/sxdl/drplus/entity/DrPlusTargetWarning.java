package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "drplus_target_warning", description = "指标预警")
@Entity
@Data
@Table(name="drplus_target_warning")
public class DrPlusTargetWarning implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "外键不能为空")
    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @NotNull(message = "指标名称不能为空")
    @ApiModelProperty(value = "指标名称")
    private String name;

    @NotNull(message = "指标类型不能为空")
    @ApiModelProperty(value = "类型: 1 上限(<=) 2下限(>=)  3范围(between and)")
    private Integer type;

    @NotNull(message = "指标sql不能为空")
    @ApiModelProperty(value = "指标sql脚本片段: 页面案例: 类似于HBI 指标sql ,但对于分别上报平台需要注意字段前需要添加表别名用a、b 代替")
    private String sql;


    @ApiModelProperty(value = "值1")
    private String val;

    @ApiModelProperty(value = "值2 (针对 type选择3的 保存时间范围 后面值)")
    private String val2;

    @ApiModelProperty(value = "(6和7 10平台才需显示) 是否使用附表: 1 使用 0 未用")
    private Integer isuse;

    @ApiModelProperty(value = "(10 平台才需显示)使用哪几个表 使用逗号隔开 例如:a,b,c,d")
    private String usetable;

    @ApiModelProperty(value = "是否启用: 1 启用 0 停用")
    private Integer isqy;

    public DrPlusTargetWarning() {
    }

    public DrPlusTargetWarning(  Integer drplus_platform_detailed_id,  String name,  Integer type,  String sql, String val, String val2, Integer isuse, Integer isqy) {
        this.drplus_platform_detailed_id = drplus_platform_detailed_id;
        this.name = name;
        this.type = type;
        this.sql = sql;
        this.val = val;
        this.val2 = val2;
        this.isuse = isuse;
        this.isqy = isqy;
    }
}
