package com.sxdl.base.entity;

import com.sxdl.base.config.PrefixConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "sys_dict_val", description = "字典表值")
@Entity
@Table(name = PrefixConfig.PREFIX+"sys_dict_val")
@Data
@Accessors(chain = true)
public class SysDictVal implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "字典表id", position = 2)
    private Integer dict_id;
    @ApiModelProperty(value = "字典表名称", position = 3)
    private String dict_name;
    @ApiModelProperty(value = "数值", position = 4)
    private String val;
    @ApiModelProperty(value = "名称", position = 5)
    private String name;
    @ApiModelProperty(value = "是否启用", position = 6)
    private Integer is_on;
    @ApiModelProperty(value = "备注", position = 7)
    private String remark;
    @ApiModelProperty(value = "附加名称", position = 8)
    private String supplement_name;
    @ApiModelProperty(value = "来源id", position = 9)
    private Integer source_id;


    @Transient
    private List<SysDictVal> children;
}
