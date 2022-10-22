package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@ApiModel(value = "quality_category", description = "护理质量考核类目")
@Entity
@Data
@Table(name="quality_category")
public class HnQualityCategory {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "质量考核类目")
    private String name;

    @Transient
    private List<HnQualitySuborder> suborders;


}
