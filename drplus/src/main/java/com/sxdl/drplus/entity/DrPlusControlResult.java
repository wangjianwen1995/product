package com.sxdl.drplus.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_control_result", description = "质控结果表")
@Entity
@Data
@Table(name="drplus_control_result")
public class DrPlusControlResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "保存时间")
    private String save_time;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_extract_detailed_id;

    @ApiModelProperty(value = "主键值:病历号")
    private String primary_keyval;


    @ApiModelProperty(value = "质控外键 与质控类型 一块判断 哪个表 ")
    private Integer drplus_quality_id;

    @ApiModelProperty(value = "质控结果")
    private String result_message;


    @ApiModelProperty(value = "锚点字段")
    private String field_name;


    @ApiModelProperty(value = "质控类型")
    private Integer type;

    @ApiModelProperty(value = "1 强制 2 提示")
    private Integer termlevel;


}
