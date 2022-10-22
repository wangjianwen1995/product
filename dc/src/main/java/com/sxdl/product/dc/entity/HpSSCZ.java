package com.sxdl.product.dc.entity;

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

@ApiModel(value = "hp_2sscz", description = "手术等级信息")
@Entity
@Data
@Table(name="hp_2sscz")
public class HpSSCZ implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @Column(name="id")
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "编码")
    private String zybm;
    
    @ApiModelProperty(value = "名称")
    private String ssmc;

    @ApiModelProperty(value = "录入选项")
    private String lrxx;
    @ApiModelProperty(value = "类别")
    private String lb;

    @ApiModelProperty(value = "版本中文名")
    private String bb;

    @ApiModelProperty(value = "手术等级")
    private String ssjb;
    @ApiModelProperty(value = "是否手术")
    private String isss;
    @ApiModelProperty(value = "是否治疗性操作")
    private String iszlxcz;
    @ApiModelProperty(value = "是否诊断性操作")
    private String iszdxcz;
    @ApiModelProperty(value = "是否介入")
    private String isjr;
    @ApiModelProperty(value = "是否微创")
    private String iswc;
    @ApiModelProperty(value = "手术级别中文")
    private String ssjb_name;
    @ApiModelProperty(value = "版本")
    private String ssdjversion;















}
