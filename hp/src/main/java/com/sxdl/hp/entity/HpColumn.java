package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "hp_column", description = "字段")
@Entity
@Data
@Table(name="hp_column")
/**
 * 特殊说明(已废弃,整体功能迁移到dc中)
 * table_name字段中值为"dataCenter"时,该类型的值是系统中可以his字典对照的字段的列表(页面左侧列表)
 *                值为"homepage"时,该类型的值是系统中his字典对照中,上报模版可以对照的字段的列表(页面左侧列表)
 *                同时需要is_hisenable字段的值为1时,才会启用
 */
public class HpColumn implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "字段英文名称")
    private String name;

    @ApiModelProperty(value = "字段中名称")
    private String name_zh;

    @ApiModelProperty(value = "字段类型(4->int  12->varchar 11->datetime  3->decimal  -9->date)")
    private Integer column_type;

    @ApiModelProperty(value = "字段长度")
    private Integer size;

    @ApiModelProperty(value = "小数点位数")
    private Integer scale;

    @ApiModelProperty(value = "表代码")
    private String table_id;

    @ApiModelProperty(value = "表名称")
    private String table_name;

    @ApiModelProperty(value = "是否上报字段")
    private Integer is_report;

    @ApiModelProperty(value = "是否展示:用来雕龙附页的字段显隐藏 ")
    private Integer is_show;

    @ApiModelProperty(value = "是否中医字段")
    private Integer is_zy;

    @ApiModelProperty(value = "模块类型: 1 基本信息  2 诊疗信息  3 手术信息  4 费用信息  5 其他")
    private Integer model_type;


    @ApiModelProperty(value = "是否下拉框 0 否 1 是单选下拉框 2 是多选下拉框 ")
    private Integer is_query;

    @ApiModelProperty(value = "接口名称,前端通过他来匹配接口中的数据,主要针对的是下拉框的数据加载")
    private String web_name;

    @ApiModelProperty(value = "是否单个小框框(主要用于高级查询) 0是 1两个小框框主要用来一个区间")
    private Integer is_single;


    @ApiModelProperty(value = "字段对映的字典表的id")
    private Integer dict_table_id;

    @ApiModelProperty(value = "his字典是否启用转换")
    private Integer is_hisenable;

    @ApiModelProperty(value = "是否属于高级查询中的字段 1 是 0否")
    private Integer is_gjcx;

    @ApiModelProperty(value = "(雕龙附页)是否属于组的代表字段 1 是 0否")
    private Integer operable_show;

    @ApiModelProperty(value = "雕龙附页组名称")
    private String group_name;


    @ApiModelProperty(value = "默认初始化是查询的字段(高级查询使用)")
    private Integer is_default;

    @ApiModelProperty(value = "是否能导出execl字段")
    private Integer is_export;
    @ApiModelProperty(value = "是否能导出execl字段")
    private String export_case;


    @Transient
    @ApiModelProperty(value = "当前登录人员 是否启动 1 启动 0不启动")
    private String isenable;

    @Transient
    @ApiModelProperty(value = "当前登录人员id")
    private Integer user_id;

    @Transient
    @ApiModelProperty(value = "模板id")
    private String template_id;

    @Transient
    @ApiModelProperty(value = "xh")
    private Integer xh;

    @Transient
    @ApiModelProperty(value = "对映字典数据")
    private List<HpDictMap> hpDictMaps;


    @Transient
    @ApiModelProperty(value = "医院his代码")
    private String his_code;

    @Transient
    @ApiModelProperty(value = "医院his代码")
    private String his_name;

    @Transient
    @ApiModelProperty(value = "前端专用")
    private String value1;

    @Transient
    @ApiModelProperty(value = "前端专用")
    private String value2;


}
