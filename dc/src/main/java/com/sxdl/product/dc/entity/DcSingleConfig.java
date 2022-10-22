package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 请求类型类
 */
@ApiModel(value = "单抽配置")
@Entity
@Table(name = "dc_single_config")
@Data
public class DcSingleConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "产品ID")
    private String Product_id;

    @ApiModelProperty(value = "单抽名称")
    private String name;

    @ApiModelProperty(value = "产品名称")
    private String Product_name;

    @ApiModelProperty(value = "状态 1启2停")
    private Integer status;

  /*  @Transient
    private List<DcSingleConfig> list;*/


}