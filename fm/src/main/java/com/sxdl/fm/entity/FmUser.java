package com.sxdl.fm.entity;

import com.sxdl.base.entity.SysUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "fm_user")
public class FmUser extends SysUser {

    @Id
    private Integer id;

    @Column(name = "title_lev")
    private Integer titleLev;
    @Column(name = "khdy_id")
    private Integer khdyId;
    @Column(name = "khdy_name")
    private String khdyName;
    @Column(name="title_name")
    private String titleName;
    @Column(name="title_name_id")
    private Integer titleNameId;
    @Column(name="position_id")
    private Integer positionId;
}
