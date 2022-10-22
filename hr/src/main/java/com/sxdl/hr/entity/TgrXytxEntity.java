package com.sxdl.hr.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author shqrpknife
 * @create 2022-09-09-8:51
 */
@Data
@Entity
@Table(name = "tgr_xytx")
public class TgrXytxEntity {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String gid;
    private String dcgid;
    private String zyh;
    private String hzxm;
    private String hzxb;
    private String hznl;
    private String nldw;
    private String ryzd;
    private String zdbm;
    private String kssj;
    private String hscount;
    private String plcount;
    private String xttype;
    private String isyggr;
    private String isbggr;
    private String isazgr;
    private String ismdgr;
    private String isfr;
    private String iskjy;
    private String isccgr;
    private String isxlgr;
    private String isxggr;
    private String isfbgr;
    private String dcrmc;
    private String dcrq;
    private String cjrq;
    private String isconfirm;

}
