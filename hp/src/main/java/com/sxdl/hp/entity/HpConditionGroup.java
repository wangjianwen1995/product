package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "hp_condition_group", description = "条件组")
@Entity
@Data
@Table(name="hp_condition_group")
public class HpConditionGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "条件组名称")
    private String name;

    @ApiModelProperty(value = "分类 1 系统 2基本信息 3 手术模块 4 费用模块 5其他")
    private Integer type;

    @ApiModelProperty(value = "条件中的sql整合")
    private String total_sql;

/*

    @ApiModelProperty(value = "创建时间")
    private String create_time;
*/

    @Transient
    @ApiModelProperty(value = "是否启用 0 禁用,1 启用")
    private String isenable;

    @Transient
    @ApiModelProperty(value = "条件表")
    private List<HpCondition> hpConditions;


    @Transient
    @ApiModelProperty(value = "用户id")
    private Integer user_id;




}
