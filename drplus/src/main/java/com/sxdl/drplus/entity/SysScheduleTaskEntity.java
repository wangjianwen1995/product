package com.sxdl.drplus.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "sys_schedule_task", description = "调度表")
@Entity
@Data
@Table(name="sys_schedule_task")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class SysScheduleTaskEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "调度名称")
    private String name;

    @ApiModelProperty(value = "调度说明")
    private String explain;

    @ApiModelProperty(value = "调度cron表达式")
    private String cron;

    @ApiModelProperty(value = "是否开启: 1开启 0关闭")
    private Integer isonable;

    @ApiModelProperty(value = "关联外键")
    private String pid;

}
