package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpRzOldMz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpRzOldMzService extends BaseUUIDServiceImpl<HpRzOldMz> {
    @Autowired
    HpKsService hpKsService;

    /**
     * 查询列表
     */
    public ResultUtil getlist(String date) {
        if (StrUtil.isEmpty(date)) {
            return ResultUtil.error("参数不能为空!");
        }
        String listsql = "select * from T_VsTjMz where TJMZRQ between '" + date + "' and  '" + date + " 23:59:59' order by ks desc";
        List<Map<String, Object>> maps = selectSqlWithSQL(listsql);
        if(CollUtil.isEmpty(maps)){//当天数据是空的
            maps= hpKsService.findKsByType(2,null);
            if(CollUtil.isEmpty(maps)) {//科室列表是空的
                return ResultUtil.error("请先维护科室的门诊相关信息!");
            }
            List<HpRzOldMz> list=new LinkedList<>();
            for(Map<String, Object> e:maps){
                list.add(HpRzOldMz.builder().TJMZKB(e.get("code")+"").ks(e.get("name")+"").build());
            }
            return ResultUtil.success(list);
        }
        return ResultUtil.success(maps);
    }

    /**
     * 批量保存
     */
    public ResultUtil saveAll(List<HpRzOldMz> list,String time) {
        if (CollUtil.isEmpty(list)) {
            return ResultUtil.error("数据是空的");
        }
        for (HpRzOldMz e : list) {
            if (e.getTJMZMZRC() != (e.getTJMZZKRS() + e.getTJMZZJCS())) {
                return ResultUtil.error(e.getKs() + " 的\"门诊人次\"必须等于\"专科人次\"和\"专家次数\"的总和");
            }
            if (e.getTJMZJZRC() < e.getTJMZJZQJ()) {
                return ResultUtil.error(e.getKs() + " 的\"急诊人次\"不能小于\"抢救人次\"");
            }
            if (e.getTJMZJZQJ() < e.getTJMZJZQJSB()) {
                return ResultUtil.error(e.getKs() + " 的\"抢救人次\"不能小于\"抢救失败人次\"");
            }
            if (e.getTJMZMZQJ() != (e.getTJMZQJCG() + e.getTJMZQJSW())) {
                return ResultUtil.error(e.getKs() + " 的\"门诊抢救人次\"必须等于\"门诊抢救成功人次\"和\"门诊抢救死亡人次\"的总和");
            }
            e.setTJMZRQ(DateUtil.parse(time));
            insertOrUpdate(e);
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 新增或保存
     */
    public ResultUtil insertOrUpdate(HpRzOldMz old) {
        Date date = old.getTJMZRQ();
        old.setBiyear(DateUtil.year(date));
        old.setBiquarter(DateUtil.quarter(date));
        old.setBimonth(DateUtil.month(date) + 1);
        old.setBiweek(DateUtil.weekOfYear(date));
        old.setBidate(date);
        if (StrUtil.isEmpty(old.getId())) {
            old.setId(null);
            insert(old);
        } else {
            update(old);
        }
        return ResultUtil.success("保存成功!");
    }
}
