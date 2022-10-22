package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "公告信息")
@Entity
@Data
@Table(name = "sys_notice")
public class SysNotice {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    @Column(name="title")
    private String title; //标题

    @Column(name="content")
    private String content;//内容

    @Column(name="name")
    private String name;//发布者名称

    @Column(name="code")
    private String code;//发布者工号

    @Column(name="create_time")
    private String create_time;//创建时间

    @Column(name="update_time")
    private String update_time;//更新时间

    @Column(name="flag")
    private String flag;//是否发布标识 0是未发布,1是已发布
}
