package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="T_lf_gzlzb")
public class HbiTlfgzlzb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String ys;
    private String ks;
    private String kh;
    private Float mjzrs;
    private Float szrs;
    private Float sscs;
    private Float zdssls;
    private Float yzssls;
    private Float zqssls;
    private Float jzssls;
    private Float xy1h;
    private Float z1d3h;
    private Float dy3h;
    private Float zlczls;
    private Float sjssls;
    private Float wcssls;
    private Float jrssls;
    private Float ylqkshls;
    private Float ylqkgrls;
    private Float ssbfzls;
    private String creattime;

}
