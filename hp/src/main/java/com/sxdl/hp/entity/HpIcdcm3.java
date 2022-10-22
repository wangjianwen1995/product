package com.sxdl.hp.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "HP_ICDCM3")
public class HpIcdcm3 {
    @Id
    @KeySql(genId = UUIdGenId.class)
    String id;
    @Column(name = "lc1_2dm")
    String lc1_2dm;
    @Column(name = "lc1_2mc")
    String lc1_2mc;
    @Column(name = "lc2_0dm")
    String lc2_0dm;
    @Column(name = "lc2_0mc")
    String lc2_0mc;
    @Column(name = "yb1_0dm")
    String yb1_0dm;
    @Column(name = "yb1_0mc")
    String yb1_0mc;
    @Column(name = "lc3_0dm")
    String lc3_0dm;
    @Column(name = "lc3_0mc")
    String lc3_0mc;
    @Column(name = "lb")
    String lb;
    @Column(name = "ssdj")
    String ssdj;
    @Column(name = "iswc")
    String iswc;
    @Column(name = "isrj")
    String isrj;
    @Column(name = "isss")
    String isss;
    @Column(name = "isjr")
    String isjr;
    @Column(name = "iszlxcz")
    String iszlxcz;
    @Column(name = "iszdxcz")
    String iszdxcz;
    @Column(name = "bz")
    //执行的标准代码,sys_dict_val,137
    String bz;
    @Column(name = "bz_name")
    //执行的标准名称,sys_dict_val,137
    String bz_name;
    @Column(name = "flag")
    //是否有效    1 有效(默认) 0 无效
    String flag;
    @Column(name = "create_time")
    //创建时间
    Date create_time;
    @Column(name = "modify_time")
    //修改时间
    Date modify_time;
    //录入选项,0必选、 1 选择性、2 中医必选
    String lrxx;

    @Transient
    String oldssdj;
    @Transient
    String oldrj;
    @Transient
    String oldwc;
}
