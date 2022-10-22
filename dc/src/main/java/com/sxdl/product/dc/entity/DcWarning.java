package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 */
@ApiModel(value = "dc_warning", description = "抽取预警")
@Entity
@Data
@Table(name = "dc_warning")
public class DcWarning implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "抽取时间", position = 2)
    private String etltime;

    @ApiModelProperty(value = "预警信息", position = 3)
    private String warnmessage;

    @ApiModelProperty(value = "预警原因", position = 4)
    private String warnreason;

    @ApiModelProperty(value = "预警分类", position = 4)// 1:抽取0条数据；2数据增减幅度；3：数据抽取一致性；4：指标预警
    private Integer type;

    @ApiModelProperty(value = "调度ID", position = 5)
    private String schedule_id;

    @ApiModelProperty(value = "关联产品ID", position = 6)
    private String product_id;

    @ApiModelProperty(value = "存储/webID", position = 7)
    private String exec_id;

    @ApiModelProperty(value = "存储/web 名称", position = 7)
    private String exec_name;


}