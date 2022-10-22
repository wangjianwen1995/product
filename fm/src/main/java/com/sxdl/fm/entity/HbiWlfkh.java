package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="W_lf_khdy")
public class HbiWlfkh implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String dm;
    private String xh;
    private String mc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HbiWlfkh) {
        HbiWlfkh hbiWlfkh = (HbiWlfkh) o;
        return this.mc.equals(hbiWlfkh.getMc());
        }else if(o instanceof String){
            return this.dm.equals(o);
        }else return false;
    }
}
