package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_condition_template", description = "条件组模板")
@Entity
@Data
@Table(name="hp_condition_template")
public class HpConditionTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "用户id")
    private Integer user_id;

    @ApiModelProperty(value = "条件组id")
    private String group_id;








}
