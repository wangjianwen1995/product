package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 请求类型类
 */
@ApiModel(value = "dcTransfer", description = "OTS信息表")
@Entity
@Data
@Table(name = "dc_transfer")
public class DcTransfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "数据源ID")
    private String data_source_id;

    @ApiModelProperty(value = "来源数据库类型")
    private String from_type;

    @ApiModelProperty(value = "来源数据类型id")
    private Integer from_type_id;

    @ApiModelProperty(value = "来源数据库地址及配置")
    private String from_uri;

    @ApiModelProperty(value = "来源数据库登录用户名")
    private String from_username;

    @ApiModelProperty(value = "来源数据库登录密码")
    private String from_pwd;

    @ApiModelProperty(value = "最后修改时间")
    private String time;

    @ApiModelProperty(value = "产品id")
    private String product_id;

    @ApiModelProperty(value = "来源产品id")
    private String resource_product_id;

    @ApiModelProperty(value = "医院id")
    private String hospital_id;

    @ApiModelProperty(value = "工单id")
    private String job_id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "数据库名")
    private String dbname;

    @ApiModelProperty(value = "是否同源同库")
    private Integer isogenytk;

    @ApiModelProperty(value = "是否同源 1是0否")
    private Integer isogeny;

    @ApiModelProperty(value = "抽取类型")
    private String etlp_type;

    @ApiModelProperty(value = "目标表数据库名称")
    private String to_product_dbname;



    @ApiModelProperty(value = "链接串")
    private String link_str;//DB2专用字段


    @ApiModelProperty(value = "去向表的数据源ID")
    private String to_data_source_id;

    @ApiModelProperty(value = "去向数据库类型")
    private String to_type;

    @ApiModelProperty(value = "去向数据类型id")
    private Integer to_type_id;

    @ApiModelProperty(value = "去向数据库地址及配置")
    private String to_uri;

    @ApiModelProperty(value = "去向数据库登录用户名")
    private String to_username;

    @ApiModelProperty(value = "去向数据库登录密码")
    private String to_pwd;

    @ApiModelProperty(value = "去向名称")
    private String to_name;

    @ApiModelProperty(value = "去向数据库名")
    private String to_dbname;

    @ApiModelProperty(value = "去向是否同源同库")
    private Integer to_isogenytk;

    @ApiModelProperty(value = "去向是否同源 1是0否")
    private Integer to_isogeny;

    @ApiModelProperty(value = "去向链接串")
    private String to_link_str;//DB2专用字段

    @Transient
    private String fromPorductName;
    @Transient
    private String toPorductName;

    @Transient
    private String toPorductShortName;


}