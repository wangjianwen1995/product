package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 请求类型类
 */
@ApiModel(value = "文件知识库")
@Entity
@Table(name = "dc_knowledgebase")
@Data
public class DcKnowledge implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "文件名称")
    private String filename;

    @ApiModelProperty(value = "文件类型")
    private String type;

    @ApiModelProperty(value = "标题名称")
    private String name;

    @ApiModelProperty(value = "上传人")
    private String uploadperson;

    @ApiModelProperty(value = "上传时间")
    private String uploadtime;

    @ApiModelProperty(value = "文件状态")
    private String status;

    @ApiModelProperty(value = "文件来源")
    private String filesource;

    @ApiModelProperty(value = "参考网址")
    private String referenceurl;

    @ApiModelProperty(value = "文件发布时间")
    private String filepublish;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "文件存放位置")
    private String stowedposi;

//    @Transient
//    private MultipartFile file ;
}