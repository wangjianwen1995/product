package com.sxdl.hr.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

/**
 * @author shqrpknife
 * @create 2022-08-09-10:29
 */
@Data
@Entity
@Table(name = "tgr_blm")
public class TgrBlmEntity implements Serializable {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String gid;
    private String dcgid;
    private String blh;
    private String zyh;
    private String zycs;
    private String dcsj;
    private String kscode;
    private String blm02;
    private String blm04;
    private String blm05;
    private String blm06;
    private String zd;
    private String blm07;
    private String blm08;
    private String blm09;
    private String blm10;
    private String blm11;
    private String blm36;
    private String blm38;
    private String blm37;
    private String blm39;
    private String spysjwkjywsyq;
    private String bbglrs;
    private String bbksrs;
    private String bbmzrs;
    private String bbjycs;
    private String blm40;
    private String tbsj;
    private String pym;
    private String lsh;
    private String isconfirm;
    private String zgys;
    private String issqgr;
    private String isywgr;
    private String isshfy;
    private String ksname;
    private String scyygrrq;
    private String rysj;

}
