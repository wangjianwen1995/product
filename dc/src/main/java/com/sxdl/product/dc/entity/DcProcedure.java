package com.sxdl.product.dc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.util.List;

@ApiModel(value = "DcProcedure", description = "存储过程表")
@Entity
@Data
@Table(name = "dc_procedure")
public class DcProcedure {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "中文名称")
    private String name_zh;

    @ApiModelProperty(value = "存储过程sql")
    private String content;

    @ApiModelProperty(value = "借用table的type")
    private Integer type_id;

    @ApiModelProperty(value = "存储过程中文解释")
    private String remark;

    @ApiModelProperty(value = "直联库抽取id")
    private String transfer_id;

    @ApiModelProperty(value = "清洗转换id")
    private Integer clean_id;

    @ApiModelProperty(value = "灌装数据id")
    private Integer fill_id;

    @ApiModelProperty(value = "调度任务id")
    private String schedule_id;

    @ApiModelProperty(value = "标签")
    private String tag;

    @ApiModelProperty(value = "直接库表筛选时间条件对应字段")
    private String time_column_name;

    @ApiModelProperty(value = "直接库的表")
    private String table_mian_name;

    @ApiModelProperty(value = "直接库的表中文名称")
    private String table_mian_name_zh;

    @ApiModelProperty(value = "数据抽取类型：0全部 1时间范围")
    private Integer isparam;

    @ApiModelProperty(value = "join sql")
    private String join_sql;

    @ApiModelProperty(value = "where sql")
    private String where_sql;

    @ApiModelProperty(value = "")
    private String time_column_id;

    @ApiModelProperty(value = "")
    private String table_main_id;

    @ApiModelProperty(value = "")
    private String from_product_id;

    @ApiModelProperty(value = "")
    private String to_product_id;

    @ApiModelProperty(value = "")
    private String map_sql;

    @ApiModelProperty(value = "目标表id")
    private String to_table_id;

    @ApiModelProperty(value = "项目id")
    private String product_id;

    @ApiModelProperty(value = "医院id")
    private String hospital_id;

    @ApiModelProperty(value = "时间长度")
    private Integer tiem_length;

    @ApiModelProperty(value = "规则 id")
    private Integer rule_id; //规则 id

    @ApiModelProperty(value = "工单 id")
    private String job_id; //规则 id

    @ApiModelProperty(value = "单抽时【目标表】的病案号字段")
    private String singelbah;

    @ApiModelProperty(value = "单抽时【来源表】的病案号字段")
    private String singelbah_id;

    @ApiModelProperty(value = "单抽时【目标表】的科室字段")
    private String singelks;

    @ApiModelProperty(value = "单抽时【来源表】的科室字段 ")
    private String singelks_id;

    @ApiModelProperty(value = "是否支持单抽 1是0否")
    private String support_single;

    @ApiModelProperty(value = "预处理sql")
    private String presql;

    @ApiModelProperty(value = "目标表名称")
    private String to_table_name; //目标表名称

    @ApiModelProperty(value = "来源表ID")
    private String from_table_id;

    @ApiModelProperty(value = "来源表名称")
    private String from_table_name;

    @ApiModelProperty(value = "来源表主键")
    private String from_table_pk;

    @ApiModelProperty(value = "去向表主键")
    private String to_table_pk;

    @ApiModelProperty(value = "去向表时间字段")
    private String to_table_time_column;

    @ApiModelProperty(value = "存储的类型") //1 对照映射 2 自定义
    private Integer proc_type;

    @Transient
    private String stime;   //开始时间

    @Transient
    private String etime;    //结束时间

    private Integer scope;//自动调度抽取时间范围（单位：天）

    @Transient
    private String tablename_zh;   //中文表名称

    @Transient
    private String[] ytable;   //原表的下拉框数据

    @Transient
    private String bztable;  //标准表下拉框中的值

    @Transient
    private List<DcTableVsTable> dcTableVsTables;

    @Transient
    private List<DcVirtualTable> dcvirtualTables;

    //调度中的状态
    @Transient
    private String status;

    //用于创建表结构的同时，判断是否生成dc把表结构和实体
    @Transient
    private Integer iscreateatdc;

    @Transient
    private String bah;

    @Transient
    private String kscode;

    @Transient
    private String presql_qd;


    @ApiModelProperty(value = "来源表是多表时，目标表的关联关系")
    private String target_join_sql;

}
