package com.sxdl.product.dc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.util.List;

@ApiModel(value = "dcColumn", description = "自定义表的字段信息")
@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dc_column")
public class DcColumn {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @KeySql(genId = UUIdGenId.class)
    private @NotBlank() String id;

    @ApiModelProperty(value = "自定义表id", position = 2)
    private @NotBlank(message = "自定义表名称不能为空") String table_id;

    @ApiModelProperty(value = "自定义表名称", position = 3)
    @NotBlank(message = "自定义表名称不能为空")
    private String table_name;

    @ApiModelProperty(value = "字段名称", position = 4)
    @NotBlank(message = "字段名称不能为空")
    private String column_name;

    @ApiModelProperty(value = "字段中文名", position = 5)
    @NotBlank(message = "字段中文名不能为空")
    private String column_name_zh;

    @ApiModelProperty(value = "字段类型id", position = 6)
    @NotBlank(message = "字段类型id不能为空")
    private Integer type_id;

    @ApiModelProperty(value = "字段类型", position = 7)
    @NotBlank(message = "字段类型不能为空")
    private String type;

    @ApiModelProperty(value = "字段长度", position = 8)
    @NotBlank(message = "字段长度不能为空")
    private Integer size;

    @ApiModelProperty(value = "小数点后位数", position = 9)
    @NotBlank(message = "小数点后位数不能为空")
    private Integer scale;

    @ApiModelProperty(value = "是否字典字段", position = 8)
    @NotBlank(message = "是否字典字段")
    private Integer is_dict;  // 1：是 0 ：否

    @ApiModelProperty(value = "字典字段对应字典表id", position = 9)
    @NotBlank(message = "字典字段对应字典表id")
    private Integer dict_id;

    @ApiModelProperty(value = "字段是否启用", position = 9)
    @NotBlank(message = "字段是否启用")
    private Integer is_on; // 字段是否启用 1：是 0 否 目前主要是 his 字典对照时使用

    @ApiModelProperty(value = "字段排序", position = 9)
    private Integer ordernum;

    @Transient
    private Integer vsTable_Id;

    @Transient
    private Integer vsColumn_Id;

    @Transient
    @ApiModelProperty(value = "对映字典数据")
    private List<HpDictMap> HpDictMaps;

    @Transient
    @ApiModelProperty(value = "医院his代码")
    private String his_code;

    @Transient
    @ApiModelProperty(value = "医院his代码")
    private String his_name;


}