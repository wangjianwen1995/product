package com.sxdl.report.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "dr_dbzinfo", description = "单病种与上报关系")
@Entity
@Data
@Table(name = "dr_dbzinfo")
public class DrDbzinfo {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    private Integer id;

    @ApiModelProperty(value = "单病种id", position = 2)
    private Integer sid;

    @ApiModelProperty(value = "单病种名称", position = 2)
    private String sidname;

    @ApiModelProperty(value = "模板id", position = 2)
    private Integer templateid;

    @ApiModelProperty(value = "对应字段ID", position = 2)
    private Integer tableid;


}
