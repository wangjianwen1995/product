package com.sxdl.hpqc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_qm_result", description = "质控结果表")
@Entity
@Data
@Table(name="hp_link_result")
public class HpLinkQcResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "A_id 也是A表的Id ")
    private String bah;

    @ApiModelProperty(value = "分类名称")
    private String classify;

    @ApiModelProperty(value = "分类代码")
    private Integer classify_id;

    @ApiModelProperty(value = "总表字段")
    private String fields;

    @ApiModelProperty(value = "返回信息")
    private String message;


    @ApiModelProperty(value = "排序号")
    private Integer ordernum;

    @ApiModelProperty(value = "正式表锚点字段(ABCEP..表的字段)")
    private String fields_anchor;

    @ApiModelProperty(value = "是否强制1是 0否 ")
    private Integer can_forced;

    @ApiModelProperty(value = "出院时间 总表字段-->CYSJ")
    private String time;

   /* @Transient
    @ApiModelProperty(value = " ")
    private String web_name;
*/




}
