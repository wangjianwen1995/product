package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 请求类型类
 */
@ApiModel(value = "指标知识库")
@Entity
@Table(name = "dc_target")
@Data
public class DcTarget implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "指标名称")
    private String targetname;

    @ApiModelProperty(value = "父级ID")
    private String parentid;

    @ApiModelProperty(value = "父级名称")
    private String parentname;

    @ApiModelProperty(value = "指标等级")
    private String targetlevel;

    @ApiModelProperty(value = "指标来源")
    private String targetsource;

    @ApiModelProperty(value = "计算单位")
    private String unit;

    @ApiModelProperty(value = "计算方式")
    private String formula;

    @ApiModelProperty(value = "指标解释")
    private String tagerexplain;

    @ApiModelProperty(value = "执行标准")
    private String executivestandard;

    @ApiModelProperty(value = "数据来源")
    private String datasource;

    @ApiModelProperty(value = "标准值")
    private String standardvalue;

    @ApiModelProperty(value = "采集方式")
    private String collectionmode;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "维护时间")
    @ColumnType(jdbcType= JdbcType.DATE)
    private Date remaindate;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "是否分类信息")
    private String istype;

    @ApiModelProperty(value = "排序")
    private Integer ordernum;

    @ApiModelProperty(value = "提取说明")
    private String etlremark;

    @ApiModelProperty(value = "计算细则")
    private String calculationrules;

    @ApiModelProperty(value = "数据归集")
    private String dataproject;


    @Transient
    private List<DcTarget> children;

}