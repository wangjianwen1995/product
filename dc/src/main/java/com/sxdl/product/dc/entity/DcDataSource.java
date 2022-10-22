package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 请求类型类
 */
@ApiModel(value = "dcDataSource", description = "源数据管理")
@Entity
@Data
@Table(name = "dc_data_source")
public class DcDataSource implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "数据库类型")
    private String db_type;

    @ApiModelProperty(value = "数据类型id")
    private Integer db_type_id;

    @ApiModelProperty(value = "链接服务器名称")
    private String name;

    @ApiModelProperty(value = "链接服务器中文名")
    private String name_zh;

    @ApiModelProperty(value = "数据库名")
    private String dbname;

    @ApiModelProperty(value = "数据库地址及配置")
    private String url;

    @ApiModelProperty(value = "数据库登录用户名")
    private String username;

    @ApiModelProperty(value = "数据库登录密码")
    private String pwd;

    @ApiModelProperty(value = "最后修改时间")
    private String time;

    @ApiModelProperty(value = "链接串")
    private String link_str;//DB2专用字段




}