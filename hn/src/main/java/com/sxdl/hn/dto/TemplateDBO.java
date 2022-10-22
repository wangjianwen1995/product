package com.sxdl.hn.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TemplateDBO implements Serializable {

    private Integer id;
    private Double total_score;
    private String  details_ids;


}
