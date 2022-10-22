package com.sxdl.hp.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "数据抽取相关配置")
@Entity
@Data
@Table(name = "hp_etl_config")
public class HpEtlConfig {
    @Id
    @KeySql(genId = UUIdGenId.class)
    String id;
    String name;
    String remark;
    /**
     * 类型:1,数据抽取菜单;2,重抽费用按钮
     */
    String type;
    /**
     * 参数中id的值
     */
    String id_param;
    /**
     * 状态:1,全链路抽取;2,局部链路抽取
     */
    String status;
}
