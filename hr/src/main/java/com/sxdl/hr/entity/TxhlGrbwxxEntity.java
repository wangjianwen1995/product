package com.sxdl.hr.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author shqrpknife
 * @create 2022-08-11-16:33
 */
@Entity
@Table(name = "txhl_grbwxx")
public class TxhlGrbwxxEntity implements Serializable {
    private String gid;
    private String grgid;
    private String zyh;
    private String grlx;
    private String grbwdm;
    private String grbwmc;
    private String tbsj;

    @Basic
    @Column(name = "gid", nullable = true, length = 50)
    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Id
    @Column(name = "grgid", nullable = false, length = 50)
    public String getGrgid() {
        return grgid;
    }

    public void setGrgid(String grgid) {
        this.grgid = grgid;
    }

    @Basic
    @Column(name = "zyh", nullable = true, length = 50)
    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    @Basic
    @Column(name = "grlx", nullable = true, length = 50)
    public String getGrlx() {
        return grlx;
    }

    public void setGrlx(String grlx) {
        this.grlx = grlx;
    }

    @Basic
    @Column(name = "grbwdm", nullable = true, length = 50)
    public String getGrbwdm() {
        return grbwdm;
    }

    public void setGrbwdm(String grbwdm) {
        this.grbwdm = grbwdm;
    }

    @Basic
    @Column(name = "grbwmc", nullable = true, length = 100)
    public String getGrbwmc() {
        return grbwmc;
    }

    public void setGrbwmc(String grbwmc) {
        this.grbwmc = grbwmc;
    }

    @Basic
    @Column(name = "tbsj", nullable = true, length = 20)
    public String getTbsj() {
        return tbsj;
    }

    public void setTbsj(String tbsj) {
        this.tbsj = tbsj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxhlGrbwxxEntity that = (TxhlGrbwxxEntity) o;
        return Objects.equals(gid, that.gid) &&
                Objects.equals(grgid, that.grgid) &&
                Objects.equals(zyh, that.zyh) &&
                Objects.equals(grlx, that.grlx) &&
                Objects.equals(grbwdm, that.grbwdm) &&
                Objects.equals(grbwmc, that.grbwmc) &&
                Objects.equals(tbsj, that.tbsj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gid, grgid, zyh, grlx, grbwdm, grbwmc, tbsj);
    }
}
