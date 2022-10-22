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

@ApiModel(value = "dc_table_vs_table", description = "表映射关系")
@Entity
@Data
@Table(name = "dc_table_vs_table")
public class DcTableVsTable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "源表id")
    @NotBlank(message = "源表id不能为空")
    private String from_table_id;

    @ApiModelProperty(value = "源表字段id")
    @NotBlank(message = "源表字段不能为空")
    private String from_table_column_id;

    @ApiModelProperty(value = "目标表id")
    @NotBlank(message = "目标表不能为空")
    private String to_table_id;

    @ApiModelProperty(value = "目标表字段id")
    @NotBlank(message = "目标表字段不能为空")
    private String to_table_column_id;


    @ApiModelProperty(value = "存储过程id")
    private String procedure_id;

    @ApiModelProperty(value = "字段关联替换类型，0否，1 自定义")
    private Integer dc_relation_replace_type_id;

    @ApiModelProperty(value = "字段关联替字段别名")
    private String relation_replace_table_id;

    @ApiModelProperty(value = "字段关联替换sql")
    private String relation_replace_sql;

    @ApiModelProperty(value = "去向表的字段属性")
    private String to_table_column_type;//去向表的字段属性

    @ApiModelProperty(value = "去向表的字段名称")
    private String to_table_column;  //去向表的列名称

    @ApiModelProperty(value = "去向表的字段中文名称")
    private String to_table_column_zh;//去向表的列名称中文名

    @ApiModelProperty(value = "编码对照-历史对照1/标准对照2")
    private Integer is_history;

    @ApiModelProperty(value = "编码对照-编码类型")
    private Integer bm_type;

    @ApiModelProperty(value = "编码对照-代码1或者名称2")
    private Integer dmormc;



    @ApiModelProperty(value = "来源表的列名称")
    private String from_table_column;  //来源表的列名称

    @ApiModelProperty(value = "来源表的列名称中文名称")
    private String from_table_column_zh;  //来源表的列名称中文名称


    @ApiModelProperty(value = "字典对照类型 1HIS 2上报")
    private Integer map_type;

    @ApiModelProperty(value = "字典对照对应HIS或上报ID")
    private String map_code;

    @ApiModelProperty(value = "字典对照对应HIS或上报ID名称")
    private String map_code_name;


    @ApiModelProperty(value = "顺序")
    private Integer ordernum;



}