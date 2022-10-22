package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "drplus_code_version", description = "编码版本表")
@Entity
@Data
@Table(name="drplus_code_version")
public class DrplusCodeVersion implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     @ApiModelProperty(value = "id")
     @Id
     @KeySql(genId = UUIdGenId.class)
     private String id;

     */
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "版本名称")
    @NotNull(message = "版本号")
    private String code;
    @ApiModelProperty(value = "版本名称")
    @NotNull(message = "版本名称不能为空")
    private String name;

    @ApiModelProperty(value = "版本说明")
    private String msg;


    @ApiModelProperty(value = "类型: 1 疾病 2 手术")
    private Integer type;





    /*
    @Transient
    private Integer isqy;
*/

}
