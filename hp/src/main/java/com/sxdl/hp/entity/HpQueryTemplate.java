package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_query_template", description = "查询模板")
@Entity
@Data
@Table(name="hp_query_template")
public class HpQueryTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private String id;

    @ApiModelProperty(value = "字段表id")
    private String column_id;

    @ApiModelProperty(value = "用户id")
    private Integer user_id;

    @ApiModelProperty(value = "字段英文名称")
    private String column_name;

    @ApiModelProperty(value = "字段类型(4->int  12->varchar 11->datetime  3->decimal)")
    private Integer column_type;

    @ApiModelProperty(value = "是否下拉框 1 是 0 否")
    private Integer is_query;

    @ApiModelProperty(value = "接口名称,前端通过他来匹配接口中的数据,主要针对的是下拉框的数据加载")
    private String web_name;

    @ApiModelProperty(value = "小数位几位")
    private Integer decimal_size;

    @ApiModelProperty(value = "表名称")
    private Integer table_name;

    @ApiModelProperty(value = "序号")
    private Integer xh;











}
