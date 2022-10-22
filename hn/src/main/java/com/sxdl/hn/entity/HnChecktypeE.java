package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "checktype_e", description = "急救物品管理")
@Entity
@Data
@Table(name="checktype_e")
public class HnChecktypeE implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "急救药品总数")
    private Integer yp_sum;

    @ApiModelProperty(value = "急救药品不合格件数")
    private Integer yp_unqualified;

    @ApiModelProperty(value = "急救物品设备总数")
    private Integer dmyp_sum;

    @ApiModelProperty(value = "急救物品设备不合格件数")
    private Integer dmyp_unqualified;

    @ApiModelProperty(value = "急救药品合格率")
    private Double yp_rate;

    @ApiModelProperty(value = "急救物品设备合格率")
    private Double dmyp_rate;

    @ApiModelProperty(value = "真实考核id")
    private Integer assessment_id;
}
