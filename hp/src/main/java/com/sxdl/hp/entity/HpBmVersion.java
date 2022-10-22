package com.sxdl.hp.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(value = "hp_bm_version", description = "编码使用版本管理")
@Entity
@Data
@Table(name="hp_bm_version")
public class HpBmVersion implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @Column(name="id")
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "分类")
    private String type;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "是否启用")
    private String ison;

    @ApiModelProperty(value = "版本名称")
    private String version_name;

    @ApiModelProperty(value = "启用时间")
    private String stime;

    @ApiModelProperty(value = "停用时间")
    private String etime;

    @ApiModelProperty(value = "医院id")
    private String hid;

    @Transient
    //字典库中保存的取对照表的字段
    private String remark;
}
