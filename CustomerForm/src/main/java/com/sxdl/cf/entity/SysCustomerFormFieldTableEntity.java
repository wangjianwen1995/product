package com.sxdl.cf.entity;

import com.sxdl.cf.util.GUID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;


/**
 *  该表添加字段修改tableCU.sql 文件
 */
@ApiModel(value = "sys_cf_fieldtable", description = "字段表管理")
@Entity
@Data
@Table(name="sys_cf_fieldtable")
@NoArgsConstructor
@Accessors(chain = true) //set链式编程
public class SysCustomerFormFieldTableEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;

    @ApiModelProperty(value = "数据库表名称")
    private String table_name;

    @ApiModelProperty(value = "字段名称")
    private String name;

    @ApiModelProperty(value = "字段备注")
    private String label;

    @ApiModelProperty(value = "类型: 1 整数 2 小数 3 文本 4 大文本 5 单选下拉框 6 多选下拉框 " +
            "7 日期(yyyy-MM-dd) 8 日期时间(yyyy-MM-dd HH:mm:ss) 9 年份(yyyy) 10 年月(yyyy-MM) " +
            "11 时间(HH:mm:ss) 12 文件  13 图片 14单选 15多选 16电子签名")
    private Integer type;

    @ApiModelProperty(value = "type=5的下拉框 代码名称全部展示 1 全部展示(选择后,代码和名称全部显示,并且存储代码名称 用逗号隔开) 0不展示(默认是0 页面回显时代码,实际存储的是代码,页面会汉化数据)")
    private Integer codename_allshow;

    @ApiModelProperty(value = "是否主键: 1是 0否")
    private Integer is_mainfield;

    @ApiModelProperty(value = "是否系统字段:1是 0否")
    private Integer is_system;

    @ApiModelProperty(value = "sys_cf_facttable.id")
    private String facttable_id;

    @ApiModelProperty(value = "序号 ,可修改")
    private Integer order_number;

/*    //key 不使用了 由SysCustomerFormHeaderColumnEntity 接管 列表属性
    @ApiModelProperty(value = "列表默认显示 : 1 显示 0隐藏")
    private Integer default_show;*/

    @ApiModelProperty(value = "是否允许空值 : 1 是 0否")
    private Integer is_null;

    @ApiModelProperty(value = "允许修改字段 : 1 是 0否")
    private Integer is_edit;

    @ApiModelProperty(value = "字段校验函数")
    private String verifiable;





    @ApiModelProperty(value = "文件大小限定")
    private Integer file_size;


    @ApiModelProperty(value = "小数位位数")
    private Integer num_length;

    @ApiModelProperty(value = "字段长度")
    private Integer field_length;

    @ApiModelProperty(value = "文件路径")
    private String file_path;

    @ApiModelProperty(value = "图片路径")
    private String image_path;

    @ApiModelProperty(value = "判断是字段下拉还是sql自定义下拉框: 1 字典 2 sql自定义")
    private Integer dictortsql;

    @ApiModelProperty(value = "字典选项管理id")
    private String data_code;

    @ApiModelProperty(value = "字段sql 存储SQL脚本(用来处理下拉框数据直接查询表)")
    private String field_sql;

    //key 下11字段触发 字段与子表单的联动效果 这几个字段修改 需要 同事修改 SysCustomerFormFactTableService.saveLayout方法
    @ApiModelProperty(value = "子表单关联父表的id")
    private String associated_table_id;
    @ApiModelProperty(value = "子表单关联父表的name")
    private String associated_table_name;
    @ApiModelProperty(value = "子表单关联父表的表中文名")
    private String associated_tablename_zh;
/*    @ApiModelProperty(value = "触发值: 主要针对下拉框,单选框 什么值来触发弹框一对一表单")
    private String associated_value;*/

/*    @ApiModelProperty(value = "禁用条件")
    private String disable_condition;
    @ApiModelProperty(value = "禁用字段集")
    private String disable_fields;
    @ApiModelProperty(value = "隐藏条件")
    private String hide_condition;
    @ApiModelProperty(value = "隐藏字段集")
    private String hide_fields;
    @ApiModelProperty(value = "必填条件")
    private String must_condition;
    @ApiModelProperty(value = "必填字段集")
    private String must_fields;*/
    @ApiModelProperty(value = "赋值公式")
    private String assignment_formula;




    @Transient
    private List<LinkedHashMap<String,Object>> optionList;


    public SysCustomerFormFieldTableEntity(String table_name,String name, String label, Integer type, Integer is_mainfield, Integer is_system, String facttable_id,Integer is_null,Integer is_edit,Integer field_length,Integer order_number) {
        this.table_name = table_name;
        this.name = name;
        this.label = label;
        this.type = type;
        this.is_mainfield = is_mainfield;
        this.is_system = is_system;
        this.facttable_id = facttable_id;
        this.is_null = is_null;
        this.is_edit = is_edit;
        this.field_length = field_length;
        this.order_number = order_number;
    }


}
