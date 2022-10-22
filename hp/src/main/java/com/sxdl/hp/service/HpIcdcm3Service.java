package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.hp.entity.HpIcdcm3;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpIcdcm3Service extends BaseUUIDServiceImpl<HpIcdcm3> {
    List<SysDictVal> dicts;
    @Autowired
    HpRzJzService hpRzJzService;

    /**
     * 查询手术编码版本信息
     *
     * @param name 名称编码
     * @param ssdj 等级
     * @param lb   类别
     * @param wc   是否微创
     * @param rj   是否日间
     * @param p    分页信息
     */
    public PageInfo findIccm(String name, String ssdj, String lb, String wc, String rj, PageInfo p)  {
        String sqls = " from HP_ICDCM3 where bz=3 ";
        if (StrUtil.isNotEmpty(name)) {
            sqls += " and (lc3_0dm like '%" + name + "%' or lc3_0mc like '%" + name + "%')";
        }
        if (StrUtil.isNotEmpty(ssdj)) {
            sqls += " and ssdj='" + ssdj + "'";
        }
        if (StrUtil.isNotEmpty(lb)) {
            sqls += " and lb='" + lb + "'";
        }
        if (StrUtil.isNotEmpty(wc)) {
            sqls += " and iswc=" + wc;
        }
        if (StrUtil.isNotEmpty(rj)) {
            sqls += " and isrj=" + rj;
        }
        String col = "[id],[lc1_2dm],lrxx,[lc1_2mc],[lc2_0dm],[lc2_0mc],[yb1_0dm],[yb1_0mc],[lc3_0dm],[lc3_0mc],[lb],[ssdj],[iswc],[isrj],[isss],(case when iszlxcz=1 or iszlxcz=2 then 1 else 0 end) as [iszlxcz],[isjr],[iszdxcz],[bz],[bz_name],[flag],[create_time],[modify_time]";
        return selectPageinfoWithSQL(HpIcdcm3.class, col, sqls, "lc3_0dm", p, true);
    }

    /**
     * 查询执行标准字典表
     */
    public List<SysDictVal> findBZDicts()  {
        Map<Integer, List<SysDictVal>> alldict = (Map<Integer, List<SysDictVal>>) HpApplicationRunnerImpl.contextMap.get("dvAllMap");
        if (alldict.containsKey(137)) {
            dicts = alldict.get(137);
            return hpRzJzService.sortAndFilterDicts(0, dicts);
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 检查初始化的表中是否有历史数据
     *
     * @param bz     标准id
     * @param bzname 标准名称
     * @return 是/否
     * @
     */
    public boolean checkHasData(String bz, String bzname)  {
        String sqls = SQLPackageUtil.getCountSQL(" from HP_ICDCM3 where bz=" + bz + " and bz_name='" + bzname + "' ");
        List<Map<String, Object>> maps = selectSqlWithSQL(sqls);
        if (CollUtil.isNotEmpty(maps) && Integer.parseInt(maps.get(0).get("cnt").toString()) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 初始化某一个手术执行标准的数据
     *
     * @param bz     标准id
     * @param bzname 标准名称
     * @
     */
    public void initData(String bz, String bzname)  {
        String sqls = "insert INTO HP_ICDCM3 ([lc3_0dm],[lc3_0mc],[lc1_2dm],[lc1_2mc],[lc2_0dm],[lc2_0mc],[yb1_0dm],[yb1_0mc],[lb],[ssdj],[iswc],[isrj],[isss],[iszlxcz],[isjr],[iszdxcz],[bz],[bz_name],[flag],[create_time],[modify_time])" +
                " SELECT DISTINCT [lc3_0dm],[lc3_0mc],[lc1_2dm],[lc1_2mc],[lc2_0dm],[lc2_0mc],[yb1_0dm],[yb1_0mc],[lb],[ssdj],[iswc],0,[isss],[iszlxcz],[isjr],[iszdxcz],@@@,'!!!',1,GETDATE(),GETDATE() FROM hp_ICCMAutoDz WHERE isnull(lc3_0dm,'')!=''";
        sqls = sqls.replace("@@@", bz).replace("!!!", bzname);
        selectSqlWithSQL(sqls);
    }
}
