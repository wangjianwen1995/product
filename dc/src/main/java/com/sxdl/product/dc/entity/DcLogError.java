package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "dcLogError", description = "错误日志类")
@Entity
@Data
@Table(name = "dc_log_error")
public class DcLogError implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "错误截图", position = 2)
    private String jpg;
    @ApiModelProperty(value = "错误描述", position = 3)
    private String describe;
    @ApiModelProperty(value = "错误标题", position = 4)
    private String title;
    @ApiModelProperty(value = "错误状态(0未修改 1已修改)", position = 5)
    private String status;
    @ApiModelProperty(value = "修改bug的人", position = 6)
    private String name;
    @ApiModelProperty(value = "修改时间", position = 7)
    private String updateTime;
    @ApiModelProperty(value = "修改备注(bug产生原因，怎么改的)", position = 8)
    private String comment;
    @ApiModelProperty(value = "提交bug的人", position = 9)
    private String name2;
    @ApiModelProperty(value = "提交时间", position = 10)
    private String submitTime;
    @ApiModelProperty(value = "产品名称", position = 11)
    private String productName;
}
