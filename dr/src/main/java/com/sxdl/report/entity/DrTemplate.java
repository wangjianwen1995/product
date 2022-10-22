package com.sxdl.report.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "drTemplate", description = "上报模板管理")
@Entity
@Data
@Table(name = "dr_template")
public class DrTemplate {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "模板名称", position = 2)
    @NotBlank(message = "模板名称不能为空")
    private String name;

    @ApiModelProperty(value = "模板简称", position = 3)
    private String short_name;

    @ApiModelProperty(value = "病案服务器地址", position = 4)
    private String db_host;

    @ApiModelProperty(value = "病案数据库名称", position = 5)
    private String db_name;

    @ApiModelProperty(value = "病案服务器数据库用户名", position = 6)
    private String db_user;

    @ApiModelProperty(value = "病案服务器数据库密码", position = 7)
    private String db_password;

    @ApiModelProperty(value = "上报来源", position = 8)
    private Integer report_source;

    @ApiModelProperty(value = "上报平台地址/5 医院机构代码", position = 9)
    private String host;


    @ApiModelProperty(value = "上报平台令牌/4上报用户名/5上报appid", position = 10)
    private String token;

    @ApiModelProperty(value = "上报平台上报地址", position = 11)
    private String report_url;

    @ApiModelProperty(value = "上报平台作废地址/4上报密码/5accept/User-Agent", position = 12)
    private String obsolete_url;

    @ApiModelProperty(value = "上报平台请求方式", position = 13)
    private String request_type;

    @ApiModelProperty(value = "上报超时时间", position = 14)
    private Integer timeout;

    @ApiModelProperty(value = "上报调度频率", position = 15)
    private String corn;

    @ApiModelProperty(value = "上报平台上报结束时间/4上报版本", position = 16)
    private String end_time;

    @ApiModelProperty(value = "上报平台数据编码/4上报方法名称", position = 17)
    private String encode;

    @ApiModelProperty(value = "上报要求数据类型", position = 18)
    private String body_type;

    @ApiModelProperty(value = "上报请求格式类型", position = 19)
    private String report_type;

    @ApiModelProperty(value = "上报要求数据打包格式类型", position = 20)
    private String package_type;

    @ApiModelProperty(value = "上报响应的格式类型", position = 21)
    private String response_type;

    @ApiModelProperty(value = "抽取时间", position = 22)
    private String scope;

    @ApiModelProperty(value = "抽取时间单位", position = 23)
    private String scope_unit;

    @ApiModelProperty(value = "生成文件路径", position = 24)
    private String path_file;

    @ApiModelProperty(value = "生成全名称包括文件后缀", position = 25)
    private String file_name;

    @ApiModelProperty(value = "模板类型", position = 26)
    private String template_type;

    @ApiModelProperty(value = "文件头信息", position = 27)
    private String file_header;


    @ApiModelProperty(value = "项目id，前端数据定义", position = 28)
    private Integer product_id;










}
