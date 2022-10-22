package com.sxdl.hpqc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_qm_bz", description = "质控字典标准表")
@Entity
@Data
@Table(name="hp_qm_bz")
public class HpQcBz implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "锚点字段")
    private String fields;

    @Column(name="sqls")
    @ApiModelProperty(value = "sqls")
    private String sqls;

    @ApiModelProperty(value = "返回信息")
    private String message;  //message

    @ApiModelProperty(value = "是否启用 1是 0否")
    private Integer is_on;


    @ApiModelProperty(value = "是否强制1是 0否 ")
    private Integer can_forced;

    @ApiModelProperty(value = "分类名称")
    private String classify;

    @ApiModelProperty(value = "分类代码")
    private Integer classify_id;

    @ApiModelProperty(value = "排序号")
    private Integer ordernum;

    @ApiModelProperty(value = "(ABCEP..表的字段)")
    private String fields_anchor;

 /*   @ApiModelProperty(value = "对映字典表id")
    private Integer dict_talbe_id;*/


   /* @ApiModelProperty(value = "总表字段")
    private String home_col;
    @ApiModelProperty(value = "总表字段2")
    private String home_col2;*/


   /* @Transient
    @ApiModelProperty(value = " ")
    private String web_name;
*/

   @ApiModelProperty(value = "环节质控是否启用")
   private Integer link_on;

  /* @ApiModelProperty(value = "临时sql")
   private String temp_sql;*/
   @ApiModelProperty(value = "等级 1:vip,2:vip+;3:vip++")
   private String lever;

/*    @ApiModelProperty(value = "sql用到的总表字段  用英文逗号隔开")
    private String home_fields;*/

    @Column(name = "home_type")
    @ApiModelProperty(value = "首页信息类型") // 1：基本2：诊疗3：手术4：费用5：其他
    private Integer home_type;



}
