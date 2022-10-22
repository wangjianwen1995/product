package com.sxdl.product.dc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.HpBzdmkDao;
import com.sxdl.product.dc.entity.HospiatlInfo;
import com.sxdl.product.dc.entity.HpBmVersion;
import com.sxdl.product.dc.entity.HpBzdmkEntity;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpBzdmkService extends BaseServiceImpl<HpBzdmkEntity> {

    @Autowired
    private HpBzdmkDao hpBzdmkDao;

    @Autowired
    private HpBmVersionService hpBmVersionService;

    public List<HpBzdmkEntity> getEnableByType(String type) throws Exception {
        return hpBzdmkDao.getEnableByType(type);
    }

    /**
     * 初始化手术标准版本,中医标准版本的永久临时表
     */
    public void initBiaozuns() throws Exception {
        HospiatlInfo hpHospiatlInfo = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        String ssv = "9",//国临3.0
                jbv = "6",//国临2.0
                sunshv = "6",//国临2.0
                zlv = "6",//国临2.0
                zyv = "10";//中医2020
        if (StringUtil.isNotEmpty(hpHospiatlInfo.getId())) {
            Map<String, String> bms = hpHospiatlInfo.getBmVersion();
            if (null != bms && bms.size() > 0) {
                ssv = bms.get("1");//手术编码
                jbv = bms.get("0");//疾病编码
                sunshv = bms.get("2");//损伤编码
                zlv = bms.get("3");//肿瘤编码
                zyv = bms.get("4");//中医编码
            }
        }
        //获取编码版本字典库
        Map<Integer, List<SysDictVal>> bmMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");

        if (CollUtil.isNotEmpty(bmMap) && bmMap.containsKey(89)) {
            //hp_bm_version列表
            Map<String, List<SysDictVal>> dictVals = bmMap.get(89).stream().collect(Collectors.groupingBy(SysDictVal::getVal));
            //查询了标准代码库关联历史对照记录表,同时关联了全版本手术对照表
            String sql = "SELECT\n" +
                    "dmk.code code,lsdz.use_dm use_dm,use_mc use_mc,dmk.name name,dmk.type type,dmk.version version,iccm.ssdj,(case when iccm.iszlxcz='1' or iccm.iszlxcz='2' or iccm.iszdxcz='1' then 1 else 0 end) as iscz INTO ssbz \n" +
                    "FROM\n" +
                    "hp_bzdmk dmk LEFT JOIN hp_history_iccm_dz lsdz ON upper(lsdz.report_dm)= upper(dmk.code) AND lsdz.report_version= dmk.version \n" +
                    "and (case when lsdz.report_mc in(dmk.name) and lsdz.use_mc in (dmk.name) then lsdz.use_mc end)=dmk.name\n" +
                    "AND lsdz.type= dmk.type AND ( isnull( use_mc, '' ) != '' OR isnull( use_dm, '' ) != '' )\n" +
                    //采用院内标准,bz=3
                    //采用当前医院配置的手术版本的代码 **dm=dmk.code
                    "LEFT JOIN HP_ICDCM3 iccm ON upper(iccm.@@dm)= upper(dmk.code) AND bz = 3 \n" +
                    "WHERE dmk.type= 1 AND dmk.version= @version ";
            sql = sql.replace("@version", ssv).replace("@@dm", dictVals.get(ssv).get(0).getRemark() + "dm");
            ifExistsTableThenDrop("ssbz");
            selectSqlWithSQL(sql);
            if (StrUtil.isNotEmpty(zyv)) {//如果配置了中医的版本则去更新
                //查询了标准代码库关联历史对照记录表,默认查询2020版中医编码病症治编码,特殊处理中医编码,有一码多名的情况,先按编码分组排序,然后取每组第一条
                sql = "select  * into zybz from(\n" +
                        "select ROW_NUMBER() OVER(PARTITION BY code ORDER BY name desc ) AS Row_Index,dmk.code code,dz.use_dm use_dm,dmk.name name,dmk.type type,dmk.version version  \n" +
                        "from hp_bzdmk dmk left join hp_history_iccm_dz dz on dz.report_dm=dmk.code and dz.report_version=dmk.version and dz.type=dmk.type where dmk.type=4 and dmk.version=@version )  \n" +
                        "a where Row_Index=1";
                sql = sql.replace("@version", zyv);
                ifExistsTableThenDrop("zybz");
                selectSqlWithSQL(sql);
                sql = "CREATE NONCLUSTERED INDEX [mc_zybz]ON [dbo].[zybz] ([name] ASC);\n" +
                        "CREATE NONCLUSTERED INDEX [code_zybz]ON [dbo].[zybz] ([code] ASC);";
                selectSqlWithSQL(sql);
            }
            //查询了标准代码库管理历史对照记录表,查询了所有icd编码
            sql = "select dmk.code,lsdz.use_dm,lsdz.use_mc,dmk.name name,dmk.type type,dmk.version version into zdbz \n" +
                    "FROM hp_bzdmk dmk LEFT JOIN hp_history_iccm_dz lsdz ON " +
                    "upper(lsdz.report_dm)= upper(dmk.code) AND lsdz.report_version= dmk.version  and (case when lsdz.report_mc in(dmk.name) and lsdz.use_mc in (dmk.name) then lsdz.use_mc end)=dmk.name AND lsdz.type= dmk.type AND ( isnull( use_mc, '' ) != '' OR isnull( use_dm, '' ) != '' )\n" +
                    "where dmk.type in('0','2','3') and dmk.version=@version";
            sql = sql.replace("@version", jbv);
            ifExistsTableThenDrop("zdbz");
            selectSqlWithSQL(sql);
            //给这3个表增加索引
            sql = "CREATE NONCLUSTERED INDEX [mc_zdbz]ON [dbo].[zdbz] ([name] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [code_zbbz]ON [dbo].[zdbz] ([code] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [mc_ssbz]ON [dbo].[ssbz] ([name] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [code_ssbz]ON [dbo].[ssbz] ([code] ASC);";
            selectSqlWithSQL(sql);
            System.out.println("已经初始化完成手术,诊断,中医的永久临时表");
        } else {
            System.out.println("请联系管理员重新初始化系统字典表,缺少系统编码版本字典!");
        }

    }

    public ResultUtil getDmkInfos(String type, String name, String version) {
        if (StrUtil.isEmpty(name)) {
            return ResultUtil.success(new ArrayList<Map<String, Object>>());
        }
        name = name.toUpperCase();
        HospiatlInfo hpHospiatlInfo = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        HpBmVersion bmVersion = new HpBmVersion();
        bmVersion.setIson("1");
        bmVersion.setHid(hpHospiatlInfo.getId());
        if (StrUtil.isEmpty(type) && StrUtil.isEmpty(version)) {
            type = "1";//查询手术编码
        }
        bmVersion.setType(type);
        bmVersion = hpBmVersionService.selectOne(bmVersion);
        if (null == bmVersion) {
            return ResultUtil.error("此分类未维护标准版本！");
        }
        version = bmVersion.getVersion();
        //支持页面模糊搜索,以%分割之前的字符做为开头
        if (name.contains("%")) {
            name = "%&" + name + "%";
        } else {
            name = "%" + name + "%";
        }
        String sql = "select top 30 code,name from hp_bzdmk where type='" + type + "' and version='" + version + "' " +
                "and query like '" + name + "' order by len(name),len(code),code";
        if ("1".equals(type)) {
            sql = "select a.code,a.name,ssdj,iscz from (" + sql + ")a ,ssbz  where ssbz.name=a.name and ssbz.code=a.code";
        }
        return ResultUtil.success(hpBmVersionService.selectSqlWithSQL(sql));
    }

}
