package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "worksandpapers_info", description = "著作与论文登记")
@Entity
@Data
@Table(name = "worksandpapers_info")

public class HnWorksandpapersInfo {
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "time")
    private String time;

    @ApiModelProperty(value = "论文论著题目")
    private String title;

    @ApiModelProperty(value = "出版或等在刊物")
    private String publish;

    @ApiModelProperty(value = "url")
    private String worksandpapers_path;

    @ApiModelProperty(value = "文件名称")
    private String worksandpapers_name;
}
