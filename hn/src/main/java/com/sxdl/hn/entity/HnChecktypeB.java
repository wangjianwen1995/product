package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "checktype_b", description = "消毒隔离结果")
@Entity
@Data
@Table(name="checktype_b")
public class HnChecktypeB implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "无菌物品总件数")
    private Integer wjwp_sum;

    @ApiModelProperty(value = "无菌物品不合格件数")
    private Integer wjwp_unqualified;

    @ApiModelProperty(value = "一次性物品总数")
    private Integer ycxwp_sum;

    @ApiModelProperty(value = "一次性物品不合格件数")
    private Integer ycxwp_unqualified;

    @ApiModelProperty(value = "真实考核id")
    private Integer assessment_id;

    @ApiModelProperty(value = "无菌物品合格率")
    private Double wjwp_rate;

    @ApiModelProperty(value = "一次性物品合格率")
    private Double ycxwp_rate;


}
