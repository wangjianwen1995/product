package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "quality_suborder", description = "护理质量考核亚目")
@Entity
@Data
@Table(name="quality_suborder")
public class HnQualitySuborder {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "质量考核类目")
    private String name;

    @ApiModelProperty(value = "父级 类目id")
    private Integer category_id;

    @ApiModelProperty(value = "管理的考核模板id")
    private Integer template_id;


}
