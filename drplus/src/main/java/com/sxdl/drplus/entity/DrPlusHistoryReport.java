package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_history_report", description = "上报历史记录(上报记录的list页面 回显上报时间范围,什么时间上报,和应该/实际/失败上报的总条数)")
@Entity
@Data
@Table(name="drplus_history_report")
@Deprecated
public class DrPlusHistoryReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private String create_time;

    @ApiModelProperty(value = "上报时间范围")
    private String upload_time;
    @ApiModelProperty(value = "上报主键值")
    private String keys;

    @ApiModelProperty(value = "实际上报")
    private Integer should_num;

    @ApiModelProperty(value = "上报成功")
    private Integer actual_num;

    @ApiModelProperty(value = "上报失败数")
    private Integer error_num;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;
/*
    @ApiModelProperty(value = "外键")
    private Integer drplus_extract_detailed_id;*/



}
