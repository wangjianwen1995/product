package com.sxdl.sd.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "单病种信息字段备选值信息")
@Entity
@Data
@Table(name = "sd_info_column_key_vals")
public class SdInfoColumnKeyVals implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    @Column(name="sd_info_column_id")
    private Integer sd_info_column_id;//单病种字段id
    @Column(name="sd_info_column_name")
    private String sd_info_column_name;//单病种字段名称
    private String val;//值
    private String keyall;//key
    @Column(name="key_bm")
    private String key_bm;//key编码
    @Column(name="key_mc")
    private String key_mc;//key名称
    @Column(name="sd_info_id")
    private Integer sd_info_id;//单病种id
}
