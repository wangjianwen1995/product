package com.sxdl.drplus.entity;


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

@ApiModel(value = "drplus_ssicd_map", description = "手术编码对照关系表")
@Entity
@Data
@Table(name="drplus_ssicd_map")
@Accessors(chain = true) //set链式编程
public class DrplusSsicdMap implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "左侧版本id")
    private Integer left_version_id;

    @ApiModelProperty(value = "左侧编码")
    private String left_code;

    @ApiModelProperty(value = "左侧名称")
    private String left_name;


    @ApiModelProperty(value = "右侧版本id")
    private Integer right_version_id;

    @ApiModelProperty(value = "右侧编码")
    private String right_code;

    @ApiModelProperty(value = "右侧名称")
    private String right_name;



    /*
    @Transient
    private Integer isqy;
*/

}
