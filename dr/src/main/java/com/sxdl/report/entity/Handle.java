package com.sxdl.report.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "需求接口类", description = "需求接口类")
@Entity
@Data
@Table(name = "handle")
public class Handle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;
}
