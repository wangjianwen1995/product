package com.sxdl.fm.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name="handler")
public class FmSecondHandler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String name;
}
