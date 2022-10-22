package com.sxdl.hr.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author shqrpknife
 * @create 2022-08-11-17:59
 */
@Entity
@Table(name = "txhl_tdbytymjg")
public class TxhlTdbytymjgEntity implements Serializable {
    private String grgid;
    private String bytid;
    private String byt;
    private String gid;
    private String ywdm;
    private String ymjg;
    private String tbsj;
    private String zyh;

    @Basic
    @Column(name = "grgid", nullable = true, length = 50)
    public String getGrgid() {
        return grgid;
    }

    public void setGrgid(String grgid) {
        this.grgid = grgid;
    }

    @Id
    @Column(name = "bytid", nullable = false, length = 50)
    public String getBytid() {
        return bytid;
    }

    public void setBytid(String bytid) {
        this.bytid = bytid;
    }

    @Basic
    @Column(name = "byt", nullable = false, length = 50)
    public String getByt() {
        return byt;
    }

    public void setByt(String byt) {
        this.byt = byt;
    }
    @Basic
    @Column(name = "gid", nullable = false, length = 100)
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }
    @Basic
    @Column(name = "ywdm", nullable = true, length = 50)
    public String getYwdm() {
        return ywdm;
    }

    public void setYwdm(String ywdm) {
        this.ywdm = ywdm;
    }

    @Basic
    @Column(name = "ymjg", nullable = true, length = 10)
    public String getYmjg() {
        return ymjg;
    }

    public void setYmjg(String ymjg) {
        this.ymjg = ymjg;
    }

    @Basic
    @Column(name = "tbsj", nullable = true, length = 20)
    public String getTbsj() {
        return tbsj;
    }

    public void setTbsj(String tbsj) {
        this.tbsj = tbsj;
    }

    @Id
    @Column(name = "zyh", nullable = false, length = 50)
    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }
}
