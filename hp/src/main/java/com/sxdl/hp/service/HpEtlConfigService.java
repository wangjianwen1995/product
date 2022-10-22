package com.sxdl.hp.service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.hp.dao.dao1.HpEtlConfigDao;
import com.sxdl.hp.entity.HpEtlConfig;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import com.sxdl.hp.util.SxdlFeignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HpEtlConfigService extends BaseUUIDServiceImpl<HpEtlConfig> {
    /**
     * 全链路抽取的参数
     */
    public static String ALL_PARAMS = "{\"startTime\":\"SSSS\",\"endTime\":\"EEEE\",\"ids\":\"'IIII'\",\"flag\":\"手动调度执行\"}";
    /**
     * 局部(单抽)链路抽取的参数
     */
    public static String PART_PARAMS = "{\"bah\":\"BBBB\",\"startTime\":\"SSSS\",\"endTime\":\"EEEE\",\"ids\":\"'IIII'\"}";
    public static String EXEC_URL = "dcSingleConfig/insertAndExec";
    @Autowired
    YmlUtil ymlUtil;
    @Autowired
    HpEtlConfigDao hpEtlConfigDao;

    /**
     * 新增或修改数据
     */
    public ResultUtil insertOrUpdate(HpEtlConfig conf) {
        HpEtlConfig config;
        config = hpEtlConfigDao.selectHasType2();
        if (null != config&&config.getName().equals(conf.getName())) {//库里已经有重抽费用的
            if (StrUtil.isEmpty(conf.getId())) {
                return ResultUtil.error("\"重抽费用\"类型的只能配置一个");
            }
        }
        config = hpEtlConfigDao.selectHasToIF();
        if (null != config&&config.getName().equals(conf.getName())) {//库里已经有"到接口表"配置
            if (StrUtil.isEmpty(conf.getId())) {
                return ResultUtil.error("\"到接口表\"类型的只能配置一个");
            }
        }
        config = hpEtlConfigDao.selectHasAll();
        if (null != config&&config.getName().equals(conf.getName())) {//库里已经有"全链路抽取"配置
            if (StrUtil.isEmpty(conf.getId())) {
                return ResultUtil.error("\"全链路抽取\"类型的只能配置一个");
            }
        }
        if ("2".equals(conf.getType())) {
            conf.setStatus("2");
        }
        if (StrUtil.isEmpty(conf.getId())) {
            insert(conf);
        } else {
            update(conf);
        }
        return ResultUtil.success("保存成功");
    }

    /**
     * 查询列表
     */
    public ResultUtil findList(PageInfo p, String name, String type, String status) {
        String sql = " from hp_etl_config where 1=1 ";
        if (StrUtil.isNotEmpty(name)) {
            sql += " and name like '%" + name + "%'";
        }
        if (StrUtil.isNotEmpty(type)) {
            sql += " and type='" + type + "'";
        }
        if (StrUtil.isNotEmpty(status)) {
            sql += " and status='" + status + "'";
        }
        if (null == p) {
            p = new PageInfo();
            p.setPageSize(100);
            p.setPageNum(0);
        }
        return ResultUtil.success(selectPageinfoWithSQL("*", sql, "name", p, true));
    }

    /**
     * 查询默认的重抽费用链条
     */
    public HpEtlConfig findDefaultReloadFare() {
        return hpEtlConfigDao.selectHasType2();
    }

    /**
     * 查询默认的到接口表的方案链条
     */
    public HpEtlConfig findDefaultToInterface() {
        return hpEtlConfigDao.selectHasToIF();
    }

    /**
     * 统一执行dc链条方法
     * 时间参数,只能传年月日格式,yyyy-mm-dd
     *
     * @param start 开始时间
     * @param end   结束时间
     * @param conf  抽取配置类
     * @param bah   病案号,重抽费用时,是必填项,其他可以传空
     * @return
     */
    public ResultUtil exec(String start, String end, HpEtlConfig conf, String bah){
        String dcip = HpApplicationRunnerImpl.contextMap.get("dcip").toString();
        if (StrUtil.isBlankOrUndefined(start) || StrUtil.isBlankOrUndefined(end)) {
            return ResultUtil.error("数据抽取失败,时间参数不能为空!");
        }
        if (null == conf || StrUtil.isEmpty(conf.getType()) || StrUtil.isEmpty(conf.getStatus()) || StrUtil.isEmpty(conf.getId_param())) {
            return ResultUtil.error("数据中心系统配置错误,请联系雕龙系统管理员,排查数据!");
        }
        if ("1".equals(conf.getType())) {
            bah = "";//默认为空,替换bah
        } else if ("2".equals(conf.getType())) {//重抽费用,按钮
            bah = "";//默认为空,替换bah
        } else {//超出范围
            return ResultUtil.error("数据中心系统配置错误,请联系雕龙系统管理员,排查数据,type超出范围!");
        }
        String data;
        if ("1".equals(conf.getStatus())) {//全链路
            data = ALL_PARAMS.replace("SSSS", start).replace("EEEE", end).replace("IIII", conf.getId_param());
        } else if ("2".equals(conf.getStatus())) {//局部的,单抽的
            data = PART_PARAMS.replace("SSSS", start).replace("EEEE", end).replace("BBBB", bah).replace("IIII", conf.getId_param());
        } else {//超出范围
            return ResultUtil.error("数据中心系统配置错误,请联系雕龙系统管理员,排查数据,status超出范围!");
        }
        if (!dcip.endsWith("/")) {
            dcip += "/" + EXEC_URL;
        } else {
            dcip += EXEC_URL;
        }
        return SxdlFeignUtil.send(false, dcip, data);
    }
}
