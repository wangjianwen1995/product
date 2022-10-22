package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "fm_target")
public class FmTarget implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String xh;
    private String name;
    private String source;
    private String status;
    private String type;

}
