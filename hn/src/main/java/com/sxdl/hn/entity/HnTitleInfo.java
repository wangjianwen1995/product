package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "title_info", description = "社会兼职")
@Entity
@Data
@Table(name = "title_info")

public class HnTitleInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "晋升日期")
    private String promotionTime;

    @ApiModelProperty(value = "晋升职称")
    private String promotionTitle;

    @ApiModelProperty(value = "晋升url")
    private String promotionPath;

}
