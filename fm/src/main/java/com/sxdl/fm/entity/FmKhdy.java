package com.sxdl.fm.entity;

import com.sxdl.fm.util.app.FmSingle;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "fm_khdy")
public class FmKhdy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    String name;//名称
    Integer ison;//是否开启,1开启,-1关闭,默认-1

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FmSingle)) return false;
        FmKhdy fmKhdy = (FmKhdy) o;
        return this.name.equals(fmKhdy.getName());
    }

}
