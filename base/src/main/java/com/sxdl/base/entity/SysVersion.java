package com.sxdl.base.entity;

import com.sxdl.base.config.PrefixConfig;
import com.sxdl.base.util.StringUtil;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Table(name = PrefixConfig.PREFIX+"sys_version")
public class SysVersion implements Serializable, Comparable<SysVersion> {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String v;//版本
    private String info;//app更新信息
    private String time;//更新时间
    private Integer type;//版本类型，1系统版本；2app版本

    @Override
    public int compareTo(SysVersion o) {
        if (null == o) return -1;
        if (StringUtil.isEmpty(o.getTime())) return -1;
        return LocalDate.parse(o.getTime()).compareTo(LocalDate.parse(this.getTime()));
    }
}
