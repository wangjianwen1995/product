package com.sxdl.hpqc.entity;


import com.sxdl.hpqc.annotation.ValidKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "drplus_center_table", description = "平台字段维护表(对映表,以病案总表为中心,对映来源表,抽取数据,对映上报字段,上报数据,里面的sql是简单的数据转换脚本)")
@Entity
@Data
@Table(name="drplus_center_table")
public class DrPlusCenterTable implements Serializable {


   /*
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;


    @Transient
   */

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @NotNull(message = "平台外键不能为空")
    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @NotNull(message = "字段名称不能为空")
    @ApiModelProperty(value = "字段名称")
    private String name;

    @NotNull(message = "字段中文不能为空")
    @ApiModelProperty(value = "字段中文")
    private String name_zh;


    @ApiModelProperty(value = "来源字段")
    private String source_column;

    @ApiModelProperty(value = "sql 查询脚本 ,sql中字段中前面需要添加a.")
    private String sql;

    @NotNull(message = "字段类型不能为空")
    @ApiModelProperty(value = "字段类型(int/varchar..)")
    private String column_type;

    @ApiModelProperty(value = "上报转换字段")
    private String report_column;

    @ApiModelProperty(value = "表拆分 类型有 a 主表 b附表")
    private String table_type;

    // 用来接受验证码
    @ValidKey
    @Transient
    private String key;


}
