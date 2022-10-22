package com.sxdl.drplus.dto;

import com.sxdl.drplus.entity.DrPlusHistoryUpdate;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
@Data
public class PatientDataDBO implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull(message = "平台外键不能为空")
    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;


    @NotNull(message = "数据抽取外键不能为空")
    @ApiModelProperty(value = "外键")
    private Integer drplus_extract_detailed_id;

    @NotNull(message = "病案号不能为空")
    @ApiModelProperty(value = "外键")
    private String PRIMAEYKEY;


    private List<DrPlusHistoryUpdate> updates;


}
