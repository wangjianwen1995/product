package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "单病种信息字段汇总信息")
@Entity
@Data
@Table(name = "sd_info_column")
public class SdInfoColumn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String name;//字段名称
    @Column(name="name_zh")
    private String name_zh;//字段中文名称
//    @Column(name="rule")
//    private String rule;//字段规则
    @Column(name="type")
    private String type;//字段类型
    @Column(name="sd_info_id")
    private Integer sd_info_id;//单病种id
    @Column(name="is_monitor")
    private Integer is_monitor;//是否监控数据，1否，2是
    @Transient
    private String fz;

    @Transient
    private String sd_info_name;  //单病种名称
}
