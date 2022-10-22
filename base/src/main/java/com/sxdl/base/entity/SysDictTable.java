package com.sxdl.base.entity;

import com.sxdl.base.config.PrefixConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "sys_dict_table", description = "字典表表名称表")
@Entity
@Table(name = PrefixConfig.PREFIX+"sys_dict_table")
@Data
public class SysDictTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "名称", position = 2)
    private String name;
    @ApiModelProperty(value = "中文名称", position = 3)
    private String name_zh;
    @ApiModelProperty(value = "来源id", position = 4)
    private Integer source_id;
    @ApiModelProperty(value = "来源名称", position = 5)
    private String source_name;
    @ApiModelProperty(value = "来源内容", position = 6)
    private String source_content;

}
