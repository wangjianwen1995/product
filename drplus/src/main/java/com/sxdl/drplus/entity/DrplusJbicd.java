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

@ApiModel(value = "drplus_jbicd", description = "疾病编码库表")
@Entity
@Data
@Table(name="drplus_jbicd")
@Accessors(chain = true) //set链式编程
public class DrplusJbicd implements Serializable {

    private static final long serialVersionUID = 1L;





    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;


    @ApiModelProperty(value = "外键")
    private Integer drplus_code_version_id;


    @ApiModelProperty(value = "编码")
    private String code;


    @ApiModelProperty(value = "名称")
    private String name;




/*    @Transient
    private Integer Type;*/

}
