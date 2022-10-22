package com.sxdl.hpqc.dbo;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class QualityDBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;



    @Column(name="sqls")
    @ApiModelProperty(value = "sqls")
    private String sqls;

    @ApiModelProperty(value = "是否启用 1是 0否")
    private String is_on;

    @ApiModelProperty(value = "分类代码")
    private Integer classify_id;

    @ApiModelProperty(value = "环节质控是否启用")
    private String link_on;






}
