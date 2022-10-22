package com.sxdl.hn.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "handle")
public class DcBaseHandle {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    private String name;

}
