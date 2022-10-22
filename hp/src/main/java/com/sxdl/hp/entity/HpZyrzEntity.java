package com.sxdl.hp.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "hp_zyrz", description = "住院日志")
@Entity
@Data
@Table(name="hp_zyrz")
public class HpZyrzEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "统计日期")
    private String tjrq;

    @ApiModelProperty(value = "统计科别")
    private String tjkb;

    @ApiModelProperty(value = "实际开放床位数")
    private Integer sjkfcws;


    @ApiModelProperty(value = "原有人数")
    private Integer yyrs;

    @ApiModelProperty(value = "入院人数")
    private Integer ryrs;

    @ApiModelProperty(value = "他科转入人数")
    private Integer tkzrrs;

    @ApiModelProperty(value = "出院人数")
    private Integer cyrs;

    @ApiModelProperty(value = "转往他科人数")
    private Integer zwtkrs;
    @ApiModelProperty(value = "留院人数")
    private Integer lyrs;
    @ApiModelProperty(value = "出院人数日志与病案对比人数")
    private Integer cyrsdb;

    @ApiModelProperty(value = "统计科别名称")
    private String tjkb_name;

    public HpZyrzEntity() {
    }

    public HpZyrzEntity(String tjrq) {
        this.tjrq = tjrq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HpZyrzEntity that = (HpZyrzEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(tjrq, that.tjrq) &&
                Objects.equals(tjkb, that.tjkb) &&
                Objects.equals(sjkfcws, that.sjkfcws) &&
                Objects.equals(yyrs, that.yyrs) &&
                Objects.equals(ryrs, that.ryrs) &&
                Objects.equals(tkzrrs, that.tkzrrs) &&
                Objects.equals(cyrs, that.cyrs) &&
                Objects.equals(zwtkrs, that.zwtkrs) &&
                Objects.equals(lyrs, that.lyrs) &&
                Objects.equals(cyrsdb, that.cyrsdb) &&
                Objects.equals(tjkb_name, that.tjkb_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tjrq, tjkb, sjkfcws, yyrs, ryrs, tkzrrs, cyrs, zwtkrs, lyrs, cyrsdb, tjkb_name);
    }
}
