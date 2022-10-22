package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "drplus_platform_detailed", description = "平台明细(平台上报配置信息, 数据来源表,手术疾病编码版本,抽取数据sql,和上报数据sql)")
@Entity
@Data
@Table(name="drplus_platform_detailed")
public class DrPlusPlatformDetailed implements Serializable {




    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @NotNull(message = "id不能为空")
    private Integer id;

    @NotNull(message = "平台分类名称id不能为空")
    @ApiModelProperty(value = "平台分类id")
    private Integer drplus_platform_bigclass_id;

    @NotNull(message = "平台分类名称不能为空")
    @ApiModelProperty(value = "平台分类名称")
    private String drplus_platform_bigclass_name;

    @ApiModelProperty(value = "上报平台名称")
    private String name;

    @ApiModelProperty(value = "数据来源表 主表 a表")
    private String source_table;

    @ApiModelProperty(value = "数据来源附表 b表")
    private String source_table_add;

    @ApiModelProperty(value = "数据来源附表 c表")
    private String source_table_add_c;

    @ApiModelProperty(value = "数据来源附表 d表")
    private String source_table_add_d;

    @ApiModelProperty(value = "数据来源附表 e表")
    private String source_table_add_e;

    @ApiModelProperty(value = "数据来源附表 f表")
    private String source_table_add_f;

    @ApiModelProperty(value = "数据来源附表 g表")
    private String source_table_add_g;

    @ApiModelProperty(value = "上报地址")
    private String report_url;


    @ApiModelProperty(value = "上报请求格式类型")
    private String content_type;

    @ApiModelProperty(value = "撤销地址")
    private String obsolete_url;

    @ApiModelProperty(value = "机构代码")
    private String orgcode;

    @ApiModelProperty(value = "令牌/签到编号")
    private String token;

    @ApiModelProperty(value = "上报用户名")
    private String reportname;

    @ApiModelProperty(value = "上报密码")
    private String reportpass;

    @ApiModelProperty(value = "appid/秘钥")
    private String appid;

    @ApiModelProperty(value = "accept")
    private String accept;

    @ApiModelProperty(value = "User-Agent")
    private String useragent;

    @ApiModelProperty(value = "上报版本")
    private String reportversion;

    @ApiModelProperty(value = "上报方法名称")
    private String reportmethod;

    @ApiModelProperty(value = "生成文件路径")
    private String path_file;

    @ApiModelProperty(value = "生成全名称包括文件后缀")
    private String file_name;

    @ApiModelProperty(value = "文件头信息")
    private String file_header;

    @ApiModelProperty(value = "当前使用手术编码版本")
    private Integer current_ss_version_id;

    @ApiModelProperty(value = "需要转换手术编码版本")
    private Integer ask_ss_version_id;

    @ApiModelProperty(value = "当前使用疾病编码版本")
    private Integer current_jb_version_id;

    @ApiModelProperty(value = "需要转换疾病编码版本")
    private Integer ask_jb_version_id;

    @ApiModelProperty(value = "抽取数据sql")
    private String extract_sql;

    @ApiModelProperty(value = "上报sql")
    private String report_sql;


    @ApiModelProperty(value = "1 启用 0停用")
    private Integer is_qy;

    @ApiModelProperty(value = " 是否开启自动抽取 1 启用 0停用")
    private Integer is_autoextract;

    @ApiModelProperty(value = " 是否开启自动编码转换 1 启用 0停用")
    private Integer is_autocode;

    @ApiModelProperty(value = " 是否开启自动审核 1 启用 0停用")
    private Integer is_autoreview;

    @ApiModelProperty(value = " 是否开启自动上报 1 启用 0停用")
    private Integer is_autoreport;




    /*
    key 下面是 有关 调度设置的
     */
    @ApiModelProperty(value = "抽取中:调度频率")
    private String cron;

    @ApiModelProperty(value = "抽取中:抽取偏移量不能为空")
    private Integer offset;

    @ApiModelProperty(value = "抽取中:抽取天数不能为空")
    private Integer e_days;

    @ApiModelProperty(value = "抽取中:总开启状态")
    private Integer isopen;



    @ApiModelProperty(value = "上报中:调度频率")
    private String cron2;

    @ApiModelProperty(value = "上报中:抽取偏移量不能为空")
    private Integer offset2;

    @ApiModelProperty(value = "上报中:抽取天数不能为空")
    private Integer e_days2;

    @ApiModelProperty(value = "上报中:总开启状态")
    private Integer isopen2;


    @ApiModelProperty(value = "首页上报要求时间的cron表达式")
    private String cronindex;

}
