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

@ApiModel(value = "dc_conversion", description = "行列转换信息")
@Entity
@Data
@Table(name = "dc_conversion")
public class DcConversion {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "需要转换的表名称", position = 2)
    @NotBlank(message = "需要转换的表名称不能为空")
    private String from_table;

    @ApiModelProperty(value = "需要转换的表id", position = 3)
    @NotBlank(message = "需要转换的表id不能为空")
    private String from_table_id;

    @ApiModelProperty(value = "转换后的表名称", position = 2)
    @NotBlank(message = "转换后的表名称不能为空")
    private String to_table;

    @ApiModelProperty(value = "转换后的表id", position = 3)
    @NotBlank(message = "转换后的表id不能为空")
    private String to_table_id;

    @ApiModelProperty(value = "转换为列名的列", position = 3)
    @NotBlank(message = "转换为列名的列")
    private String for_column;

    @ApiModelProperty(value = "列值转换为值的列名", position = 2)
    @NotBlank(message = "列值转换为值的列名")
    private String max_column;

    @ApiModelProperty(value = "转换的数据范围的sql")
    private String relation_scope_sql;
    @ApiModelProperty(value = "转换的数据范围select")
    private String relation_scope_columns;

    @ApiModelProperty(value = "转换的数据范围from")
    private String relation_scope_from;

    @ApiModelProperty(value = "转换的数据范围关联时间字段")
    private String relation_scope_time;

    @ApiModelProperty(value = "主键字段")
    private String id_column;

    @ApiModelProperty(value = "冗余字段")
    private String other_column;

    @ApiModelProperty(value = "产品id", position = 6)
    @NotBlank(message = "产品id不能为空")
    private String product_id;


    @ApiModelProperty(value = "转换类型", position = 6)
    @NotBlank(message = "转换类型") //转换类型 1：行转列 2：列转行
    private String type;




}