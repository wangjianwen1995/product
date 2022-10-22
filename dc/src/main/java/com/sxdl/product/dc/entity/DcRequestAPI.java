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
import java.io.Serializable;

/**
 * 请求接口类
 */
@ApiModel(value = "请求接口类")
@Entity
@Data
@Table(name = "dc_request_api")
public class DcRequestAPI implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "用户名", position = 2)
    @NotBlank(message = "请求名称不能为空")
    private String name;

    @ApiModelProperty(value = "接口地址", position = 3)
    @NotBlank(message = "请求接口地址不能为空")
    private String url;

    @ApiModelProperty(value = "请求头", position = 4)
    private String headers;

/*    @ApiModelProperty(value = "请求参数", position = 5)
    private String params;*/
    @ApiModelProperty(value = "请求协议", position = 6)
    private String reqtype;



    @ApiModelProperty(value = "响应体", position = 6)
    private String respbody;

    @ApiModelProperty(value = "响应头", position = 7)
    private String respheader;

    @ApiModelProperty(value = "cookie", position = 8)
    private String cookie;

    @ApiModelProperty(value = "工单id", position = 9)
    private String job_id;

    @ApiModelProperty(value = "调度id", position = 10)
    private String schedule_id;

    @ApiModelProperty(value = "请求方式", position = 11)
    private String type;

    @ApiModelProperty(value = "请求方式id", position = 12)
    private Integer type_id;

    @ApiModelProperty(value = "医院id", position = 13)
    private String hospital_id;

    @ApiModelProperty(value = "产品id", position = 14)
    private String product_id;

    @ApiModelProperty(value = "创建表名称")
    private String tag;

    @ApiModelProperty(value = "请求协议/返回数据类型:1是xml 2是json")
    private String agreetype;

    @ApiModelProperty(value = "响应内容类型")
    private String contenttype;

    @ApiModelProperty(value = "是否有参数")
    private Integer isparam;

    @ApiModelProperty(value = "dc_request_api表的id，例如:需要有病历号支持的web接口")
    private String web_id;

    @ApiModelProperty(value = "单个参数父接口提供数据的节点:通过此节点获，父接口的数据用web_node,遍历出实际的数据 比如父接口的数据中有<blh>1111</blh><name>战三</name> 这里就应该是blh ")
    private String web_node;

    @ApiModelProperty(value = "单个参数入参节点")
    private String single_node_name;

    @ApiModelProperty(value = "单个参数的值(一般是病历号、住院号)")
    private String single_node_value;

    @ApiModelProperty(value = "开始时间的入参节点名称")
    private String start_node_name;

    @ApiModelProperty(value = "开始时间入参值")
    private String start_node_value;

    @ApiModelProperty(value = "结束时间的入参节点名称")
    private String end_node_name;

    @ApiModelProperty(value = "结束时间入参值")
    private String end_node_value;


    @ApiModelProperty(value = "请求体")
    private String reqbody;

    @ApiModelProperty(value = "返回体解析节点名称")
    private String analysis_node;

    @ApiModelProperty(value = "是否规范的xml文件，1是(直接解析);-1否根据xml解析节点来截取xml文件")
    private Integer is_standard;
    @ApiModelProperty(value = "是否多层xml/卫宁数据类型")
    private Integer is_multiwall;//1是;-1否;2首页;3科室;4日志;5人员
    @ApiModelProperty(value = "命名空间")
    private String name_space;

    @ApiModelProperty(value = "命名空间地址")
    private String name_space_url;

    @ApiModelProperty(value = "时间的长度")
    private String time_length;

    @ApiModelProperty(value = "web时间字段（数据库表中的字段）")
    private String tag_time;

    @ApiModelProperty(value = "web单参字段（数据库表中的字段）")
    private String tag_blh;

    @ApiModelProperty(value = "soapaction值")
    private String soapaction;

    @ApiModelProperty(value = "tag_null")
    private String tag_null;

    @Transient
    private String webName;   //web_id 的名称

    @ApiModelProperty(value = "scope")
    private Integer scope;  //规则抽取的时间范围

    @Transient
    private Integer rule_id; //规则id


    @Transient
    private String startTime;  //抽取历史数据开始时间

    @Transient
    private String endTime;  //抽取历史数据结束时间

    //调度中的启停状态
    @Transient
    private String status;
}
