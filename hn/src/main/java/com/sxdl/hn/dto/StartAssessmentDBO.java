package com.sxdl.hn.dto;

import com.sxdl.hn.entity.HnQualitydetails;
import lombok.Data;

import java.io.Serializable;

@Data
public class StartAssessmentDBO implements Serializable {
    private static final long serialVersionUID = 1L;
    //最后要考核的标准 id
    private Integer id;

    //第一列数据
    private String first_col;
    //第二列数据
    private String second_col;
    //第三列数据
    private String third_col;

   //扣分说明
    private String deduction_comment;

    //扣分
    private double point_deduction ;

    // 责任人
    private String person_liable ;

    // 责任人名称
    private String person_liable_name ;

    // 批注
    private String problem;




    private HnQualitydetails details;


}
