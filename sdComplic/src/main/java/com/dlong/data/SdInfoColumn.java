package com.dlong.data;

import lombok.Data;

import java.io.Serializable;



@Data
//@Table(name = "sd_info_column")
public class SdInfoColumn implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;//字段名称

    private String name_zh;//字段中文名称

    private String type;//字段类型

    private Integer sd_info_id;//单病种id

    private Integer is_monitor;//是否监控数据，1否，2是

    private String fz;

    private String sd_info_name;  //单病种名称
}
