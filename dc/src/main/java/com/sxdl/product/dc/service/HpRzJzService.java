package com.sxdl.product.dc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.entity.HospiatlInfo;
import com.sxdl.product.dc.entity.HpRzJz;
import com.sxdl.product.dc.entity.HpRzJzYy;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpRzJzService extends BaseUUIDServiceImpl<HpRzJz> {

    List<SysDictVal> dicts;
    @Autowired
    HpRzJzYyService hpRzJzYyService;
    int len;

    public PageInfo findlist(String ksid, String start, String end, PageInfo p) throws Exception {
        String sql = " from hp_rz_jz where 1=1";
        if (StrUtil.isNotEmpty(ksid)) {
            sql += " and ksid='" + ksid + "'";
        }
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            sql += " and CONVERT(date,[time],121) between '" + start + "' and '" + end + "'";
        }
        return selectPageinfoWithSQL(HpRzJz.class, " * ", sql, "time", p, true);
    }

    /**
     * 获取危重抢救原因字典表
     *
     * @return 字典列表
     */
    public List<SysDictVal> getWZQJYYDict(Integer ison) throws Exception {
        Map<Integer, List<SysDictVal>> alldict = (Map<Integer, List<SysDictVal>>) DcApplicationRunnerImpl.contextMap.get("dvAllMap");
        dicts = alldict.get(130);
        return sortAndFilterDicts(ison, dicts);
    }

    /**
     * 根据字典表中的name排序并且筛选是否开启
     *
     * @param ison  是否开启
     * @param dicts 待处理的数据列表
     * @return
     */
    public List<SysDictVal> sortAndFilterDicts(Integer ison, List<SysDictVal> dicts) throws Exception {
        if (CollUtil.isEmpty(dicts)) {
            return new ArrayList<SysDictVal>();
        }
        if (StringUtil.isEmptyNumber(ison) || 0 != ison) {
            dicts = dicts.stream().filter(e -> e.getIs_on() == 1).collect(Collectors.toList());
        }
        dicts.sort(Comparator.comparing(SysDictVal::getName));
        return dicts;
    }

    /**
     * 获取急诊科室字典表
     *
     * @return 字典列表
     */
    public List<SysDictVal> getJZKSDict(Integer ison) throws Exception {
        Map<Integer, List<SysDictVal>> alldict = (Map<Integer, List<SysDictVal>>) DcApplicationRunnerImpl.contextMap.get("dvAllMap");
        dicts = alldict.get(131);
        return sortAndFilterDicts(ison, dicts);
    }

    /**
     * 查询急诊日志报表
     *
     * @param ksid
     * @param start
     * @param end
     */
    public Map<String, Object> selectJZRZ(String ksid, String start, String end) throws Exception {
        String select = "select \n" +
                "ks,\n" +
                "sum(jzrc) as jzrc,\n" +
                "sum(lyrc) as lyrc,\n" +
                "sum(rgcsrc) as rgcsrc,\n" +
                "sum(ryrc) as ryrc,\n" +
                "sum(swrc) as swrc,\n" +
                "sum(cccs) as cccs,\n" +
                "Convert(decimal(18,2),sum(ryrc)*100/case when sum(jzrc)<=0 then 1 else sum(jzrc) end) as 急诊住院率,\n" +
                "sum(wzqjrc) as wzqjrc,\n" +
                "sum(wzqjcgrc) as wzqjcgrc,\n" +
                "sum(ynswrc)\tas ynswrc,\n" +
                "sum(yqswrc) as yqswrc,\n" +
                "Convert(decimal(18,2),sum(wzqjcgrc)*100/case when sum(wzqjrc)<=0 then 1 else sum(wzqjrc) end) as 抢救成功率\n" +
                "from hp_rz_jz \n";
        String groupAhead = "GROUP BY ks with rollup\n" +
                "ORDER BY ks desc";
        String whereSql = " where 1=1 ";
        if (StrUtil.isNotEmpty(ksid)) {
            whereSql += " and ksid='" + ksid + "' ";
        }
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            whereSql += " and CONVERT(date,[time],121) between '" + start + "' and '" + end + "' ";
        }
        Map<String, Object> result = new HashMap<>();
        String allsql = select + whereSql + groupAhead;
//        System.out.println(allsql);
        List<Map<String, Object>> maps = selectSqlWithSQL(allsql);
        len = 0;
        if (!maps.isEmpty()) {
            maps.forEach(e -> {
                if (null == e.get("ks")) {
                    e.put("ks", "总计");
                }
            });
            len = maps.get(0).keySet().size() - 1;
        }
        result.put("jzlen", len);
        result.put("jz", maps);
        select = "select \n" +
                "isnull(wzqjyyName,'总计') as yy,\n" +
                "sum(isnull(wzqjcgrc,0)) as cgrc,\n" +
                "sum(isnull(ynswrc,0)) as swrc,\n" +
                "sum(isnull(wzqjcgrc,0))+sum(isnull(ynswrc,0)) as zrc\n" +
                "from hp_rz_jz_qjyy ";
        String groupEnd = "GROUP BY wzqjyyName with rollup\n" +
                "ORDER BY yy";
        allsql = select + whereSql + groupEnd;
//        System.out.println(allsql);
        maps = selectSqlWithSQL(allsql);
        result.put("yy", maps);
        len = 0;
        if (!maps.isEmpty()) {
            len = maps.get(0).keySet().size() - 1;
        }
        result.put("yylen", len);
        HospiatlInfo hospiatlInfo = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        result.put("hospital", hospiatlInfo.getJgmc());
        return result;
    }

    public ResultUtil insertorupdate(HpRzJz hpRzJz) throws Exception {
        String oldid = hpRzJz.getId();
        if (StrUtil.isEmpty(oldid)) {
            insert(hpRzJz);
        } else {
            update(hpRzJz);
        }
        //处理急诊日志抢救原因表数据
        ArrayList<HpRzJzYy> yys = hpRzJz.getYys();
        if (CollUtil.isEmpty(yys)) {
            return ResultUtil.success("操作成功!");
        } else {
            String id = hpRzJz.getId();
            String sql;
            for (HpRzJzYy e : yys) {
                e.setRzjzid(id);
                if (StrUtil.isEmpty(oldid)) {
                    hpRzJzYyService.insert(e);
                } else {
                    sql = "update hp_rz_jz_qjyy set ynswrc=" + e.getYnswrc() + " ,wzqjcgrc=" + e.getWzqjcgrc() + " where ksid='" + e.getKsid() + "' and ks='" + e.getKs() + "' and time='" + e.getTime() + "' and wzqjyyid='" + e.getWzqjyyid() + "' and wzqjyyname='" + e.getWzqjyyName() + "'";
                    selectSqlWithSQL(sql);
                }
            }
        }
        return ResultUtil.success("保存成功!");
    }

    public void deleteAll(String id) throws Exception {
        deleteById(id);
        String sql = "delete from hp_rz_jz_qjyy where rzjzid='" + id + "'";
        selectSqlWithSQL(sql);
    }
}
