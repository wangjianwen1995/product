package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "fm_target_input")
public class FmTargetInput implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private Integer target_id;
    private String target_name;
    private Integer item_id;
    private String item_name;
    private Integer unit_id;
    private String unit_name;
    private Integer year;
    private Integer month;
    private String value;
    private String input_ks_id;
    private String input_ks_name;
    private String input_user_id;
    private String input_user_name;
    private String critical;
    private String numerator_val;
    private String denominator_val;

}
