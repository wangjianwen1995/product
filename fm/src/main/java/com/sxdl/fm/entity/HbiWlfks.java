package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Data
@Table(name="W_lfks")
public class HbiWlfks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String dm;
    private String xh;
    private String mc;

}
