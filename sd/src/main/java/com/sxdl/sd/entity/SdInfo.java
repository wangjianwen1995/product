package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "单病种信息")
@Entity
@Data
@Table(name = "sd_info")
public class SdInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String name; //名称

    @Column(name="name_zh")
    private String name_zh;//中文名称

    @Column(name="group_id")
    private Integer group_id;//分组id

    @Column(name="group_name")
    private String group_name;//分组名称

    private String detail;//详情

    @Column(name="detail_sql")
    private String detail_sql;//详情sql

    @Column(name="ison")
    private Integer ison;

    @Transient
    private List<SdInfoColumn> columns;

}




