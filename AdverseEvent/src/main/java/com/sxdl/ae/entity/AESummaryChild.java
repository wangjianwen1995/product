package com.sxdl.ae.entity;


import com.sxdl.ae.util.GUID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ae_summary_child", description = "不良事件当事人相关情况(子表)")
@Entity
@Data
@Table(name="ae_summary_child")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class AESummaryChild {


    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;

    @ApiModelProperty(value = "父键:ae_summary.id")
    private String pid;

    @ApiModelProperty(value = "姓名")
    private String xm;

    @ApiModelProperty(value = "职别")
    private String zb;

    @ApiModelProperty(value = "职称")
    private String zc;

    @ApiModelProperty(value = "其他说明")
    private String qtsm;

    @ApiModelProperty(value = "身份类别")
    private String sflb;


    @ApiModelProperty(value = "担任现职称年资")
    private String drxzcnz;

    @ApiModelProperty(value = "所在现科室服务年资")
    private String szxksfwnz;





}
