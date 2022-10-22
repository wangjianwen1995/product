package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.entity.HpRzMz;
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
public class HpRzMzService extends BaseUUIDServiceImpl<HpRzMz> {

    @Autowired
    HpRzJzService hpRzJzService;
    String ks;
    @Autowired
    HpKsService hpKsService;

    /**
     * 查询普通list
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     * @param p     分页信息
     * @return 分页数据
     */
    public PageInfo findlist(String ksid, String start, String end, PageInfo p)  {
        String sql = getFindSQL(ksid, start, end);
        return selectPageinfoWithSQL(HpRzMz.class, " * ", sql, "time", p, true);
    }

    /**
     * 根据参数拼接查询sql语句
     */
    String getFindSQL(String ksid, String start, String end)  {
        String sql = " from hp_rz_mz where 1=1";
        if (StrUtil.isNotEmpty(ksid)) {
            sql += " and ksid='" + ksid + "'";
        }
        if (StrUtil.isNotEmpty(start)) {
            if(start.length()<=12){
                end=start+" 23:59:59";
            }
            sql += " and time between '" + start + "' and '" + end + "'";
        }
        return sql;
    }

    /**
     * 获取门诊科室字典表
     */
    public List<Map<String, Object>> getMzKSDict()  {
        return hpKsService.findKsByType(2, "val");
    }

    /**
     * 查询急诊日志报表
     * 急诊科(科室名称包含"急"或者"急诊")
     * ● 门诊人次数量不统计到门诊人次数量的总计,但是汇总到总诊疗人次的总计
     * ● 单独计算平均门急诊数量;
     * ● 门急诊手术例数,参与总计计算
     *
     * @param ksid  科室id
     * @param start 开始时间
     * @param end   结束时间
     */
    public Map<String, Object> selectMZRZ(String ksid, String start, String end)  {
        String select = "select ks,max(ksid) as ksid,sum(mzrc) as mzrc,sum(zj) as zj,max(pjmz) as pjmz,sum(ptmz) as ptmz,sum(zjmz) as zjmz," +
                "sum(jkjc) as jkjc,sum(mzss) as mzss,sum(hz) as hz,sum(cz) as cz,sum(jtbczl) as jtbczl,sum(mzqj) as mzqj,sum(mzqjcg) as mzqjcg," +
                "sum(mzqjsw) as mzqjsw from (\n";
        String whereSql = " 1=1 ", whereTimesql;
        if (StrUtil.isNotEmpty(ksid)) {
            whereSql += " and ksid='" + ksid + "' ";
        }
        select += "SELECT ( ptmz + zjmz ) AS mzrc,( ptmz + zjmz + cz + jtbczl ) AS zj,";
        String pjmzrc, pjmzrcDown;
        if (StrUtil.isNotEmpty(start) && StrUtil.isNotEmpty(end)) {
            pjmzrc = "CONVERT (DECIMAL(18,2),(ptmz+zjmz+cz+jtbczl)*1.0/(DATEDIFF(d,CONVERT(DATE,'" + start + "'),CONVERT (DATE,'" + end + "'))+1)) AS pjmz,";
            pjmzrcDown = "CONVERT (DECIMAL(18,2),(ptmzrc+zjmzrc+czrc+jtbczlrc)*1.0/(DATEDIFF(d,CONVERT(DATE,'" + start + "'),CONVERT (DATE,'" + end + "'))+1)) AS pjmz,";
            whereTimesql = " and time between '" + start + "' and '" + end + "' ";
        } else {
            pjmzrc = pjmzrcDown = "0 as pjmz,";
            whereTimesql = " and time between '2999-12-31' and '2999-12-31' ";
        }
        select += pjmzrc + "* FROM(\n" +
                "    SELECT ks,max(ksid) as ksid,SUM ( isnull( ptmzrc, 0 ) ) AS ptmz,SUM ( isnull( zjmzrc, 0 ) ) AS zjmz,SUM ( isnull( jkjcrc, 0 ) ) AS jkjc," +
                "SUM ( isnull( mzssls, 0 ) ) AS mzss,SUM ( isnull( hzrc, 0 ) ) AS hz,SUM ( isnull( czrc, 0 ) ) AS cz,SUM ( isnull( jtbczlrc, 0 ) ) AS jtbczl," +
                "SUM ( isnull( mzqjrc, 0 ) ) AS mzqj,SUM ( isnull( mzqjcgrc, 0 ) ) AS mzqjcg,SUM ( isnull( mzqjswrc, 0 ) ) AS mzqjsw " +
                "FROM hp_rz_mz where (ks not like '%急诊%' or ks not like '%急%') " + whereTimesql + "GROUP BY ks) b\n" +
                "    UNION all\n" +
                "    select 0 AS mzrc,(ptmzrc+zjmzrc) as zj," + pjmzrcDown + "ks,ksid,0 AS ptmz,0 AS zjmz,0 AS jkjc,isnull(mzssls,0) AS mzss,0 AS hz,0 AS cz,0 AS jtbczl,0 AS mzqj," +
                "0 AS mzqjcg,0 AS mzqjsw FROM hp_rz_mz where (ks  like '%急诊%' or ks  like '%急%') " + whereTimesql + "\n)a where " + whereSql + " GROUP BY ks with rollup ORDER BY ks DESC,mzrc DESC";
//        System.out.println(select);
        List<Map<String, Object>> maps = selectSqlWithSQL(select);
        Map<String, Object> result = new HashMap<>();
        HpHospiatlInfo hospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        result.put("hospital", hospiatlInfo.getJgmc());
        if (!maps.isEmpty()) {
            maps.forEach(e -> {
                ks = String.valueOf(e.get("ks"));
                //科室为空时候,是总计
                if (StrUtil.isEmpty(ks) || "null".equals(ks)) {
                    e.put("ks", "总计");
                }
            });
        }
        result.put("mz", maps);
        return result;
    }

    /**
     * 导出报表
     *
     * @param ksid     科室
     * @param start    开始
     * @param end      结束
     * @param response 页面响应
     * @
     */
    public void down(String ksid, String start, String end, HttpServletResponse response)  throws Exception {
        Map<String, Object> map = selectMZRZ(ksid, start, end);
        List<Map<String, Object>> maps = (List<Map<String, Object>>) map.get("mz");
        Map<String, String> colmap = new LinkedHashMap<>();
        colmap.put("ks", "科室");
        colmap.put("zj", "总计人次");
        colmap.put("mzrc", "门诊人次人次");
        colmap.put("ptmz", "普通门诊人次");
        colmap.put("zjmz", "专家门诊人次");
        colmap.put("jkjc", "健康检查人次");
        colmap.put("mzss", "门诊手术例数");
        colmap.put("hz", "会诊人次");
        colmap.put("cz", "出诊人次");
        colmap.put("jtbczl", "家庭病床诊疗人次");
        colmap.put("mzqj", "门诊抢救人次");
        colmap.put("mzqjcg", "门诊抢救成功人次");
        colmap.put("mzqjsw", "门诊抢救死亡人次");
        colmap.put("pjmz", "平均门急诊人数");
        PoiUtil.createExcel("门诊工作报表", response, maps, colmap);
    }

    /**
     * 预处理批量保存或者修改
     */
    public ResultUtil toInsertAll(String start)  {
        List<Map<String, Object>> mzKSDict = getMzKSDict();
        if (CollUtil.isEmpty(mzKSDict)) {
            return ResultUtil.error("门诊科室是空的,请先维护门诊科室!");
        }
        String sql = "select * " + getFindSQL(null, start, start);
        List<HpRzMz> hpRzMzs = selectListWithSQL(sql, HpRzMz.class);
        Map<String, Object> dv;
        Map<String, List<Map<String, Object>>> ksnamedvMap = mzKSDict.stream().collect(Collectors.groupingBy(e -> e.get("name") + ""));
        Set<String> dictKss = ksnamedvMap.keySet();
        if (CollUtil.isNotEmpty(hpRzMzs)) {//库中有数据,当作修改操作
            Set<String> findKss = hpRzMzs.stream().collect(Collectors.groupingBy(HpRzMz::getKs)).keySet();
            Collection<String> disjunction = CollUtil.disjunction(findKss, dictKss);//差集,可能是新增科室或者是删除过科室
            if (CollUtil.isNotEmpty(disjunction)) {
                for (String s : disjunction) {
                    dv = ksnamedvMap.get(s).get(0);
                    if (!findKss.contains(s)) {//新增科室的情况,添加只包含科室空白到列表中
                        hpRzMzs.add(HpRzMz.builder().ks(dv.get("name") + "").ksid(dv.get("val") + "").build());
                    }
                    if (!dictKss.contains(s)) {//删除科室的情况,移除列表
                        hpRzMzs.removeIf(e -> e.getKs().equals(s));
                    }
                }
            }
        } else {//新增操作
            hpRzMzs = new ArrayList<>();
            for (String s : dictKss) {
                dv = ksnamedvMap.get(s).get(0);
                hpRzMzs.add(HpRzMz.builder().ks(dv.get("name") + "").ksid(dv.get("val") + "").build());
            }
        }
        return ResultUtil.success(hpRzMzs);
    }

    /**
     * 批量新增修改
     */
    public ResultUtil insertAll(List<LinkedHashMap> list, String start)  {
        delete(HpRzMz.builder().time(start).build());
        for (LinkedHashMap mz : list) {
            HpRzMz mz1 = JSONUtil.toBean(JSONUtil.parseObj(mz), HpRzMz.class);
            mz1.setTime(start);
            insertSelective(mz1);
        }
        return ResultUtil.success("保存成功");
    }
}
