package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "fm_target_show")
public class FmTargetShow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private Integer xh;
    private String targetname;
    private String itemname;
    private String unit;
    private String critical;
    private String ksname;
    private String qyear;
    private String lyear;
    private String tyear;

}
