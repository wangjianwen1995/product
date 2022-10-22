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

@ApiModel(value = "hp_icd_gxb", description = "各种icd编码对照")
@Entity
@Data
@Table(name="hp_icd_gxb")
public class HpICDGxb implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @Column(name="id")
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "左列编码")
    private String left_bm;
    
    @ApiModelProperty(value = "左列名称")
    private String left_mc;


    @ApiModelProperty(value = "右列代码")
    private String right_dm;

    @ApiModelProperty(value = "右列名称")
    private String right_mc;

    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "状态")
    private String status;


}
