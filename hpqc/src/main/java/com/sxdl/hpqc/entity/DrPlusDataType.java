package com.sxdl.hpqc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_data_type", description = "数据状态表(记录数据的审核状态,上报状态 上报时间和上报结果,这里每个病人只有最终一条数据)")
@Entity
@Data
@Accessors(chain = true)
@Table(name="drplus_data_type")
public class DrPlusDataType implements Serializable {


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
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;



    @ApiModelProperty(value = "主键值/病案号")
    private String primarykey_val;

    @ApiModelProperty(value = "0 未审 1 已审 -1 审核未通过  2已复审 -2 复审未通过 ")
    private Integer review_type;


    @ApiModelProperty(value = "初审时间 ")
    private String first_review_time;
    @ApiModelProperty(value = "初审信息 ")
    private String first_review_msg;

    @ApiModelProperty(value = "复审时间 ")
    private String second_review_time;
    @ApiModelProperty(value = "复审信息 ")
    private String second_review_msg;

    @ApiModelProperty(value = "0 未上报 1 已上报  -1 上报失败 2已撤销 -2 撤销失败")
    private Integer report_type;

    @ApiModelProperty(value = "上报结果")
    private String report_content;

    @ApiModelProperty(value = "上报状态码")
    private String reprot_code;

    @ApiModelProperty(value = "上报时间")
    private String reprot_time;

    @ApiModelProperty(value = "撤销时间")
    private String revoke_time;

    @ApiModelProperty(value = "撤销结果内容")
    private String revoke_content;

    @ApiModelProperty(value = "撤销流水号:特殊平台撤销使用,数据来源上报后,平台返回数据")
    private String revoke_code;


}
