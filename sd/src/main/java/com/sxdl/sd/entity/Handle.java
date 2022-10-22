package com.sxdl.sd.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "handle")
public class Handle {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private String name;

}


