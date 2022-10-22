package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpRzOldGcs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpRzOldGcsServcie extends BaseUUIDServiceImpl<HpRzOldGcs> {

    @Autowired
    HpKsService hpKsService;

    /**
     * 查询列表
     */
    public ResultUtil getlist(String date) {
        if (StrUtil.isEmpty(date)) {
            return ResultUtil.error("参数不能为空!");
        }
        String listsql = "select * from T_VsTJgcs where TJgcsRQ between '" + date + "' and  '" + date + " 23:59:59' order by ks desc";
        List<Map<String, Object>> maps = selectSqlWithSQL(listsql),yyrs;
        if (CollUtil.isEmpty(maps)) {//当天数据是空的
            maps = hpKsService.findKsByType(4, "code,(case when bed>0 then bed when auth_bed>0 then auth_bed else 0 end) as bed");
            if (CollUtil.isEmpty(maps)) {//科室列表是空的
                return ResultUtil.error("请先维护科室的观察室相关信息!");
            }
            List<HpRzOldGcs> list = new LinkedList<>();
            for (Map<String, Object> e : maps) {
                listsql="select TJgcsLSBRS yyrs from T_VsTJgcs where TJgcsRQ=(\n" +
                        "select max(TJgcsRQ) maxrq from T_VsTJgcs where TJgcsRQ<'"+date+"') and ks='"+e.get("name")+"' ";
                yyrs = selectSqlWithSQL(listsql);
                list.add(HpRzOldGcs.builder().TJgcsKB(e.get("code") + "").ks(e.get("name") + "")
                                .TJgcsYYBRS(NumberUtil.parseInt(StrUtil.emptyToDefault(yyrs.get(0).get("yyrs")+"","0")))
                        .TJgcsGcsCWS(NumberUtil.parseInt(e.get("bed")+"")).build());
            }
            return ResultUtil.success(list);
        }
        return ResultUtil.success(maps);
    }

    /**
     * 获取观察室科室
     */
    public ResultUtil getGcsks() {
        return ResultUtil.success(hpKsService.findKsByType(4, null));
    }

    /**
     * 批量保存
     */
    public ResultUtil saveAll(List<HpRzOldGcs> list, String time) {
        if (CollUtil.isEmpty(list)) {
            return ResultUtil.error("数据是空的");
        }
        for (HpRzOldGcs e : list) {
            if (e.getTJgcsCSBRS() != (e.getTJgcsHJ() + e.getTJgcsRY() + e.getTJgcsSW()+ e.getTJgcsZY())) {
                return ResultUtil.error(e.getKs() + " 的\"出室病人数\"必须等于\"回家\" + \"入院\"+ \"转院\"+ \"死亡\"的总和");
            }
            if (e.getTJgcsYYBRS() + e.getTJgcsRSBRS() != e.getTJgcsCSBRS() + e.getTJgcsLSBRS()) {
                return ResultUtil.error(e.getKs() + " 的\"原有病人数\"+\"入室病人数\" 必须等于 \"出室病人数\" + \"留室病人数\"");
            }
            e.setTJgcsRQ(DateUtil.parse(time));
            insertOrUpdate(e);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 新增或保存
     */
    public ResultUtil insertOrUpdate(HpRzOldGcs old) {
        Date date = old.getTJgcsRQ();
        old.setBiyear(DateUtil.year(date));
        old.setBiquarter(DateUtil.quarter(date));
        old.setBimonth(DateUtil.month(date) + 1);
        old.setBiweek(DateUtil.weekOfYear(date));
        old.setBidate(date);
        if (StrUtil.isEmpty(old.getId())) {
            old.setId(null);
            insertSelective(old);
        } else {
            update(old);
        }
        return ResultUtil.success("保存成功!");
    }
}
