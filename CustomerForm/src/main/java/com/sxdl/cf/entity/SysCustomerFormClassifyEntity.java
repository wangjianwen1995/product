package com.sxdl.cf.entity;

import com.sxdl.cf.util.GUID;
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
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "sys_cf_classify", description = "分类")
@Entity
@Data
@Table(name="sys_cf_classify")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class SysCustomerFormClassifyEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;

    @NotNull(message = "分类名称 不能为空")
    @ApiModelProperty(value = "分类名称")
    private String name;

/*
    @NotNull(message = "分类代码 不能为空")
    @ApiModelProperty(value = "分类代码")
    private String code;
*/


    @ApiModelProperty(value = "分类备注说明")
    private String remarks;

    @ApiModelProperty(value = "序号")
    private Integer order_number;

}
