package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_history_update", description = "历史修改记录表(上报数据修改记录,记录修改前和修改后的数据,有汉字解释 和实际代码记录)")
@Entity
@Data
@Table(name="drplus_history_update")
public class DrPlusHistoryUpdate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "主键值")
    private String primarykey_val;


    @ApiModelProperty(value = "修改字段名")
    private String column_en;


    @ApiModelProperty(value = "修改字段中文名")
    private String column_zh;

    @ApiModelProperty(value = "修改前数据中文")
    private String before_update_zh;

    @ApiModelProperty(value = "修改前数据")
    private String before_update;

    @ApiModelProperty(value = "修改后数据中文")
    private String after_update_zh;

    @ApiModelProperty(value = "修改后数据")
    private String after_update;

    @ApiModelProperty(value = "修改时间")
    private String update_time;

    @ApiModelProperty(value = "有附表时,区别A.B表 取值范围:a或b或null")
    private String table_type;



}
