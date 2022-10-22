package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "checktype_d", description = "护士结果数据")
@Entity
@Data
@Table(name="checktype_d")
public class HnChecktypeD implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "护士工号")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "扣分 暂时不用")
    private Double care;

    @ApiModelProperty(value = "真实考核id")
    private Integer assessment_id;
}
