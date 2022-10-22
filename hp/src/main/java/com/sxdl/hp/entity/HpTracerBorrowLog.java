package com.sxdl.hp.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hp_tracer_borrow_log")
public class HpTracerBorrowLog implements Serializable {

    @Id
    @KeySql(genId = UUIdGenId.class, order = ORDER.BEFORE)
    String id;
    //借阅人id
    @Column(name = "borrower_id")
    String borrowerId;
    //借阅人姓名
    @Column(name = "borrower_name")
    String borrowerName;
    //借阅人ksid
    @Column(name = "borrower_ks_id")
    String borrowerKsId;
    //借阅人ks名称
    @Column(name = "borrower_ks_name")
    String borrowerKsName;
    //借阅人职级,字典136
    @Column(name = "borrower_title_level")
    String borrowerTitleLevel;
    //借阅人用途,字典135
    @Column(name = "borrower_used")
    String borrowerUsed;
    //开始时间
    String start;
    //期限
    String scope;
    //结束时间
    @Column(name = "endtime")
    String end;
    //病案号
    String bah;
    //病人姓名
    String bxm;
    //病人年度
    String byear;
    //病人性别
    String bxb;
    //病人出院科别
    String bcykb;
    //病人出院时间
    String bcysj;
    //病人条形码
    String btxm;
    //住院医师
    String bzyys;
    //初始状态//状态; 0 在档;1 借出;2 挂失;3 寻回
    @Column(name = "pre_status")
    String preStatus;
    //完结状态//状态; 0 在档;1 借出;2 挂失;3 寻回
    @Column(name = "current_status")
    String currentStatus;
    //备注
    String remark;
    //操作时间
    String optime;

}
