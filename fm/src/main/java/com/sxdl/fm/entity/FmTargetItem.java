package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "fm_target_item")
public class FmTargetItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String xh;
    private String name;
    private Integer target_id;
    private Integer unit_id;
    private String unit_name;
    private String critical;
    private String duty_ks_id;
    private String duty_ks_name;
    private String status;
    private String numerator;
    private String denominator;
    private String type;


}
