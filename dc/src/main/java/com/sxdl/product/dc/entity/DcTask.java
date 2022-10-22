package com.sxdl.product.dc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

//任务表,一个产品应该只有一个任务,包含很多工单
public class DcTask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    @Column(name="product_id")
    private String productId;//产品id

    @Column(name="product_name")
    private String productName;//产品名称

    @Column(name="product_short_name")
    private String productShortName;//产品简写

    @Column(name="jobs")
    private String jobs;//工单ids
}
