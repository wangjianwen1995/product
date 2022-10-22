package com.sxdl.hpqc.service;


import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hpqc.dao.dao1.HpQcResultDao;
import com.sxdl.hpqc.entity.HpQcResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpQcResultService extends BaseUUIDServiceImpl<HpQcResult> {

    @Autowired
    private HpQcResultDao hpQcResultDao;

    public List<HpQcResult> selectbyBah(String bah) {
        return hpQcResultDao.selectbyBah(bah);
    }

    public List<Map<String, Object>> selectByCysj(String sdate, String edate, Integer is_link, String max,String lb ,String tableName, Integer coount) {
        Map map = new HashMap();
       /* String sql = "with ls as \n" +
                "  (select distinct classify,\n" +
                "  bah  from hp_link_result a where  a.qc_time=(select " + max + "("+lb+".qc_time) from  hp_qm_log l left join  hp_link_result b  on l.id=b.qc_id  \n" +
                "  " +
                " where b.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " ) \n" +
                "  and a.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " \n" +
                "  union all\n" +
                "  select distinct '病历评分' as classify,\n" +
                "  bah  from hp_link_pf_result a \n" +
                "  where  a.qc_time=(select " + max + "("+lb+".qc_time) from    hp_qm_log l left join     hp_link_pf_result b  on l.id=b.qc_id \n" +
                "   where b.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " ) \n" +
                "  and a.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " \n" +
                "  )\n" +
                " \n" +
                "select '病历评分' classify  ,isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='病历评分' \n" +
                "union all\n" +
                "select '完整检测' classify,  isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='完整检测' \n" +
                "union all\n" +
                "select '规范检测' classify, isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='规范检测' \n" +
                "union all\n" +
                "select '组合检测' classify,   isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='组合检测' \n" +
                " union all\n" +
                "select '合理检测' classfiy  ,isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls \n" +
                "where classify='合理检测' \n" +
                "union all\n" +
                "select '入组检测' classify,  isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='入组检测' \n" +
                "union all\n" +
                "select '辅助编码' classify,  isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='辅助编码' ";*/

        String sql = "with ls as \n" +

                " (select distinct classify,cykb_name cykb, bah,qc_time from hp_link_result a  \n" +
                " where 1 > (select count(*) from hp_link_result where bah = a.bah and qc_time "+max+" a.qc_time )     \n" +
                " and 1> (select count(*) from hp_qm_log  where  id = a.qc_id and qc_time "+max+" a.qc_time )   \n" +
                "and a.time between '"+sdate+"'  and '"+edate+"' and is_link="+is_link+" \n" +
                " union all select distinct '病历评分',cykb_name cykb,   bah,qc_time   from hp_link_pf_result a   \n" +
                " where  1 > (select count(*) from hp_link_pf_result where bah = a.bah and qc_time "+max+" a.qc_time )    \n" +
                " and 1> (select count(*) from hp_qm_log  where  id = a.qc_id and qc_time "+max+" a.qc_time )    \n" +
                " and a.time between '"+sdate+"'  and '"+edate+"' and is_link="+is_link+")  \n" +
             /*

                "  (select distinct classify,\n" +
                "  bah  from hp_link_result a where  a.qc_time=(select " + max + "(qc_time) from hp_link_result \n" +
                "  B where b.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " ) \n" +
                "  and a.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " \n" +
                "  union all\n" +
                "  select distinct '病历评分' as classify,\n" +
                "  bah  from hp_link_pf_result a \n" +
                "  where  a.qc_time=(select " + max + "(qc_time) from       hp_link_pf_result \n" +
                "  B where b.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " ) \n" +
                "  and a.time between '" + sdate + "'  and '" + edate + "' and is_link=" + is_link + " \n" +
                "  )\n" +
                " \n" +*/
                "select '病历评分' classify  ,isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='病历评分' \n" +
                "union all\n" +
                "select '完整检测' classify,  isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='完整检测' \n" +
                "union all\n" +
                "select '规范检测' classify, isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='规范检测' \n" +
               /* "union all\n" +
                "select '组合检测' classify,   isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='组合检测' \n" +*/
                " union all\n" +
                "select '合理检测' classfiy  ,isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls \n" +
                "where classify='合理检测' \n" +
                "union all\n" +
                "select '入组检测' classify,  isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='入组检测' \n" +
                "union all\n" +
                "select '内涵质控' classify,  isnull(COUNT(*),0) num ,\n" +
                "   Convert(decimal(18,2),Convert(decimal(18,2),COUNT(*))/Convert(decimal(18,2),2966) * 100) as zb\n" +
                "from  ls where classify='内涵质控' ";
        List<Map<String, Object>> mapList = selectSqlWithSQL(sql);

        return mapList;


    }

    public List<Map<String, Object>> selectByCykb(String sdate, String edate, Integer is_link, String tableName, Integer count) {
        String sql = " SELECT cykb,sum(num) num ,sum(hlnum) hlnum ,sum(pfnum) pfnum,sum(wznum) wznum,sum(gfnum) gfnum,sum(rznum) rznum,sum(fzbmnum) fzbmnum,sum(isnull(cnt,0)) cnt from (\n   select  cykb,COUNT(classify) num, SUM(case when classify='合理检测' \n" +
                "then 1  else 0 end) as hlnum, \n" +
                "SUM(case when classify='病历评分' then 1 else 0 end) as pfnum, \n" +
                "SUM(case when classify='完整检测' then 1   else 0 end) \n" +
                "as wznum, SUM(case when classify='规范检测' then 1 else 0 end) as gfnum," +
               // " SUM(case when classify='组合检测' then 1 else 0 end) as zhnum,  \n" +
                "SUM(case when classify='入组检测' then 1 else 0 end) as rznum ,\n" +
                "SUM(case when classify='辅助编码' then 1 else 0 end) as fzbmnum , \n" +
                "(select COUNT(cykbmc) from dl_merge.dbo.homepage where cysj between '"+sdate+"' \n" +
                " and '"+edate+"'  and  t.cykb=cykbmc group by cykbmc ) as cnt\n" +
                "from  \n" +
                " (select distinct classify,cykb_name cykb, bah,qc_time from hp_link_result a  \n" +
                " where 1 > (select count(*) from hp_link_result where bah = a.bah and qc_time > a.qc_time )     \n" +
                " and 1> (select count(*) from hp_qm_log  where  id = a.qc_id and qc_time > a.qc_time )    \n" +
                "and a.time between '"+sdate+"'  and '"+edate+"' and is_link="+is_link+" \n" +
                " union all select distinct '病历评分',cykb_name cykb,   bah,qc_time   from hp_link_pf_result a   \n" +
                " where  1 > (select count(*) from hp_link_pf_result where bah = a.bah and qc_time > a.qc_time )    \n" +
                " and 1> (select count(*) from hp_qm_log  where  id = a.qc_id and qc_time > a.qc_time )    \n" +
                " and a.time between '"+sdate+"'  and '"+edate+"' and is_link="+is_link+") t \n" +
                " GROUP BY cykb  ) x group  by cykb with rollup  order by cykb";
       // System.out.println(sql);
        List<Map<String, Object>> mapList = selectSqlWithSQL(sql);
        mapList.forEach(e -> {
            if (null == e.get("cykb") ) {
                e.put("cykb", "总计");
               // e.put("cnt", count);
            }
        });
        return mapList;
    }
}
