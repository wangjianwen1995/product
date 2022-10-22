package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.entity.HpRzYj;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import com.sxdl.hp.util.PoiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpRzYjService extends BaseUUIDServiceImpl<HpRzYj> {

    @Autowired
    HpRzJzService hpRzJzService;
    @Autowired
    SysDictValService sysDictValService;

    @Autowired
    HpKsService hpKsService;

    /**
     * 查询普通list
     *
     * @param ksid  科室id
     * @param xmid  项目id
     * @param start 时间
     * @return 分页数据
     */
    public List<HpRzYj> findlist(String ksid, String xmid, String start)  {
        String sql = "select * from hp_rz_yj where 1=1";
        if (StrUtil.isNotEmpty(ksid)) {
            sql += " and ksid='" + ksid + "'";
        }
        if (StrUtil.isNotEmpty(xmid)) {
            sql += " and xmid='" + xmid + "'";
        }
        if (StrUtil.isNotEmpty(start)) {
            sql += " and time = '" + start + "'";
        }
        sql+=" order by ks";
        List<HpRzYj> list = selectListWithSQL(sql, HpRzYj.class);
        if (CollUtil.isEmpty(list)) {//当天数据是空的,去查科室和项目组装新数据
            list = new LinkedList<>();
            List<Map<String, Object>> kss = hpKsService.findKsByType(5,null);
            if (CollUtil.isNotEmpty(kss)) {//科室列表不空
                List<SysDictVal> yjksxmDict;
                for (Map<String, Object> ks : kss) {
                    yjksxmDict = getYJKSXMDict(1, ks.get("code").toString());//查科室的项目列表
                    if (CollUtil.isEmpty(yjksxmDict)) {
                        continue;
                    }
                    for (SysDictVal dv : yjksxmDict) {
                        list.add(HpRzYj.builder().ksid(ks.get("code").toString()).ks(ks.get("name").toString())
                                .xmid(dv.getId().toString()).xm(dv.getName()).unit(dv.getSupplement_name()).build());
                    }
                }
            }
            return list;
        }
        return list;
    }

    /**
     * 批量保存
     */
    public ResultUtil saveall(List<HpRzYj> list, String time) {
        if (CollUtil.isEmpty(list) || StrUtil.isEmpty(time)) {
            return ResultUtil.error("参数不能为空");
        }
        for (HpRzYj e : list) {
            e.setTime(time);
            if (e.getZrc() != e.getMzrc() + e.getZyrc()) {//数量总和必须等于门诊+住院
                return ResultUtil.error(e.getKs() + " 的\"数量小计\"必须等于(\"门诊数量\" + \"住院数据\") 的总和");
            }
            if (e.getZsr() != e.getMzsr() + e.getZysr()) {//总收入必须等于门诊+住院
                return ResultUtil.error(e.getKs() + " 的\"收入小计\"必须等于(\"门诊收入\" + \"住院收入\") 的总和");
            }
            if (StrUtil.isEmpty(e.getId())) {
                e.setId(null);
                insert(e);
            } else {
                update(e);
            }
        }
        return ResultUtil.success("保存成功!");
    }

    /**
     * 获取医技科室字典表
     */
    public List<Map<String, Object>> getYJKSDict() {
        return hpKsService.findKsByType(5,null);
    }

    /**
     * 获取医技科室项目字典表
     *
     * @param ison 是否开启
     * @param ksid 科室id
     * @return 字典列表
     */
    public List<SysDictVal> getYJKSXMDict(Integer ison, String ksid)  {
        List<SysDictVal> dicts = sysDictValService.findDictValsByTableId(133);
        dicts = dicts.stream().filter(e -> StrUtil.isNotEmpty(e.getRemark()) && ksid.equals(e.getRemark())).collect(Collectors.toList());
        return hpRzJzService.sortAndFilterDicts(ison, dicts);
    }

    /**
     * 查询同比,环比数据报表
     */
    public Map<String, Object> selectYJRZNew(String ksid, String xmid, String start, String end)  {
        HpHospiatlInfo hospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        Map<String, Object> result = new HashMap<>();
        result.put("hospital", hospiatlInfo.getJgmc());
        List<Map<String, Object>> base = selectYJRZ(ksid, xmid, start, end);
        if (CollUtil.isEmpty(base)) {
            result.put("yj", base);
            return result;
        }
        List<Map<String, Object>> lastmonth = selectYJRZ(ksid, xmid, DateUtil.offsetMonth(DateUtil.parse(start), -1).toString(), DateUtil.offsetMonth(DateUtil.parse(end), -1).toString());
        List<Map<String, Object>> lastyear = selectYJRZ(ksid, xmid, DateUtil.offsetMonth(DateUtil.parse(start), -12).toString(), DateUtil.offsetMonth(DateUtil.parse(end), -12).toString());

        Map<String, String> lmksmap = new HashMap<>(), lyksmap = new HashMap<>();
        if (CollUtil.isNotEmpty(lastmonth)) {
            lmksmap = lastmonth.stream().collect(Collectors.toMap(e -> e.get("ks") + "_" + e.get("xm"), e -> e.get("yxs").toString()));
        }
        if (CollUtil.isNotEmpty(lastyear)) {
            lyksmap = lastyear.stream().collect(Collectors.toMap(e -> e.get("ks") + "_" + e.get("xm"), e -> e.get("yxs").toString()));
        }
        if (CollUtil.isNotEmpty(lmksmap)) {
            Map<String, String> finalLmksmap = lmksmap;
            for (Map<String, Object> e : base) {
                finalLmksmap.forEach((k, v) -> {
                    String[] s = k.split("_");
                    if (e.get("ks").equals(s[0]) && e.get("xm").equals(s[1])) {
                        Integer baseyxs = NumberUtil.parseInt(e.get("yxs").toString());
                        Integer lastyxs = NumberUtil.parseInt(v);
                        double rst = 0.0;
                        if (0 != baseyxs) {
                            rst = (baseyxs - lastyxs) / baseyxs * 100.0;
                        }
                        e.put("syzf", NumberUtil.round(rst, 2) + "%");
                    }
                });
            }
        } else {
            base.stream().forEach(e -> {
                e.put("syzf", "0.00%");
            });
        }

        if (CollUtil.isNotEmpty(lyksmap)) {
            Map<String, String> finalLmksmap = lyksmap;
            for (Map<String, Object> e : base) {
                finalLmksmap.forEach((k, v) -> {
                    String[] s = k.split("_");
                    if (e.get("ks").equals(s[0]) && e.get("xm").equals(s[1])) {
                        Integer baseyxs = NumberUtil.parseInt(e.get("yxs").toString());
                        Integer lastyxs = NumberUtil.parseInt(v);
                        double rst = 0.0;
                        if (0 != baseyxs) {
                            rst = (baseyxs - lastyxs) / baseyxs * 100.0;
                        }
                        e.put("qnzf", NumberUtil.round(rst, 2) + "%");
                    }
                });
            }
        } else {
            base.stream().forEach(e -> {
                e.put("qnzf", "0.00%");
            });
        }
        result.put("yj", base);
        return result;
    }

    /**
     * 查询医技日志报表
     */
    public List<Map<String, Object>> selectYJRZ(String ksid, String xmid, String start, String end)  {
        String select = "select * from (select ks,xm,unit,sum(isnull(zrc,0)) as zrc,sum(isnull(mzrc,0)) as mzrc,sum(isnull(zyrc,0)) as zyrc," +
                "sum(isnull(yxs,0)) as yxs,sum(isnull(zsr,0)) as zsr,sum(isnull(mzsr,0)) as mzsr,sum(isnull(zysr,0)) as zysr," +
                "sum(isnull(gzjjs,0)) as gzjjs,sum(isnull(gss,0)) as gss  from hp_rz_yj\n" +
                "where ";
        String whereSql = " 1=1 ";
        if (StrUtil.isNotEmpty(ksid)) {
            whereSql += " and ksid='" + ksid + "' ";
        }
        if (StrUtil.isNotEmpty(xmid)) {
            whereSql += " and xmid='" + xmid + "' ";
        }
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            whereSql += " and time between '" + start + "' and '" + end + "' ";
        }
        String groupEnd = " GROUP BY ks,xm,unit with rollup\n" +
                ") a where (isnull(ks,'')='' and isnull(xm,'')='' and isnull(unit,'')='') " +
                "or (isnull(ks,'')!='' and isnull(xm,'')!='' and isnull(unit,'')!='') " +
                "or (isnull(ks,'')!='' and isnull(xm,'')='' and isnull(unit,'')='')\n" +
                "ORDER BY ks desc,xm desc,zrc desc,yxs desc";
        select += whereSql + groupEnd;
        List<Map<String, Object>> maps = selectSqlWithSQL(select);
        if (!maps.isEmpty()) {
            maps.forEach(e -> {
                boolean ksflag, xmflag, unitflag;
                String ks = String.valueOf(e.get("ks"));
                String xm = String.valueOf(e.get("xm"));
                String unit = String.valueOf(e.get("unit"));
                ksflag = StrUtil.isBlankOrUndefined(ks);
                xmflag = StrUtil.isBlankOrUndefined(xm) ;
                unitflag = StrUtil.isBlankOrUndefined(unit) ;
                //项目和科室都为空时候,是总计
                if (ksflag && xmflag && unitflag) {
                    e.put("unit", "-");
                    e.put("ks", "总    计");
                    e.put("xm", "总    计");
                } else if (!ksflag&&xmflag && unitflag) {
                    e.put("xm", "小    计");
//                    e.put("ks", "小    计");
                    e.put("unit", "-");
                }
            });
        }
        return maps;
    }

    /**
     * 导出报表
     *
     * @param ksid     科室
     * @param xmid     项目
     * @param start    开始
     * @param end      结束
     * @param response 页面响应
     * @
     */
    public void down(String ksid, String xmid, String start, String end, HttpServletResponse response)  throws Exception {
        Map<String, Object> map = selectYJRZNew(ksid, xmid, start, end);
        List<Map<String, Object>> maps = (List<Map<String, Object>>) map.get("yj");
        Map<String, String> colmap = new LinkedHashMap<>();
        colmap.put("ks", "科室");
        colmap.put("xm", "项目");
        colmap.put("zrc", "总数");
        colmap.put("mzrc", "门诊人次");
        colmap.put("zyrc", "住院人次");
        colmap.put("unit", "单位");
        colmap.put("yxs", "阳性数");
        colmap.put("syzf", "阳性数与上月对比增幅");
        colmap.put("qnzf", "阳性数与去年对比增幅");
        colmap.put("zsr", "总收入");
        colmap.put("mzsr", "门诊收入");
        colmap.put("zysr", "住院收入");
        colmap.put("gzjjs", "工作甲级数");
        colmap.put("gss", "工时数");
        PoiUtil.createExcel("医技工作报表", response, maps, colmap);
    }
}
