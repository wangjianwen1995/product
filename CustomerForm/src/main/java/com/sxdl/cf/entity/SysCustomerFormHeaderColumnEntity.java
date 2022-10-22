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


@ApiModel(value = "sys_cf_headercolumn", description = "字段表管理")
@Entity
@Data
@Table(name="sys_cf_headercolumn")
@NoArgsConstructor
@Accessors(chain = true) //set链式编程
public class SysCustomerFormHeaderColumnEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;


    @ApiModelProperty(value = "sys_cf_facttable.id")
    private String facttable_id;

    @ApiModelProperty(value = "字段名称 不能修改")
    private String prop;

    @ApiModelProperty(value = "字段备注")
    private String label;

    @ApiModelProperty(value = "列表显示长度")
    private String width;

    @ApiModelProperty(value = "列表样式:居左 居中  居右")
    private String align;


    // 1 整数 2 小数 3 文本 4 大文本 5 单选下拉框 6 多选下拉框 7 日期(yyyy-MM-dd) 8 日期时间(yyyy-MM-dd HH:mm:ss) 9 年份(yyyy) 10 年月(yyyy-MM) 11 时间(HH:mm:ss)
    @ApiModelProperty(value = "列表类型 text(直接显示数据) " +
            "option(需要查询字段表获取字典id 转换数据) options(需要查询字段表获取字典id 转换数据)" +
            "sql (需要查询字段表获取sql 转换数据) sqls (需要查询字段表获取sql 转换数据)等等其他类型的数据" +
            "radio 单选框 checkbox 多选框  ")
    private String type;

    @ApiModelProperty(value = "与上面type 字段对映 (字典id)  (sql语句)")
    private String type_content;

    @ApiModelProperty(value = "显示顺序")
    private Integer order_number;

    @ApiModelProperty(value = "列表默认显示 : 1 显示 0隐藏")
    private Integer default_show;

    @ApiModelProperty(value = "列表默认查询 : 1 查询 0不查询")
    private Integer default_query;

    @ApiModelProperty(value = "是否系统字段:1是 0否")
    private Integer is_system;

    @Transient
    private String formatter;   //前端格式化值,特殊地方使用  默认值 formatterProcess


    @Transient
    private List<LinkedHashMap<String,Object>> optionList;

    public SysCustomerFormHeaderColumnEntity(String facttable_id,String prop,String label,Integer order_number){
        this.facttable_id = facttable_id;
        this.prop = prop;
        this.label = label;
        this.order_number = order_number;
        this.width = "120";
        this.align = "center";
        this.type = "text";
        this.default_show = 0;
        this.default_query = 0;
    }


}
