package com.sxdl.report.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "上报中项目信息")
@Entity
@Data
@Table(name = "dr_program")
public class DrProgram implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private String name;
}
