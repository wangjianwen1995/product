package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpBzdmkDao;
import com.sxdl.hp.entity.HpBzdmkEntity;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpBzdmkService extends BaseServiceImpl<HpBzdmkEntity> {

    @Autowired
    private HpBzdmkDao hpBzdmkDao;

    public List<HpBzdmkEntity> getEnableByType(String type)  {
        return hpBzdmkDao.getEnableByType(type);
    }

    /**
     * 初始化诊断,手术,中医的标准版本的库表信息
     * 系统启动时,清除旧数据,根据配置重新生成相应版本库表数据
     */
    public void initBiaozuns() {
        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            System.out.println("医院信息未维护，请先维护医院信息");
            return;
        }
        String ssv = "9",//国临3.0
                jbv = "6",//国临2.0
                sunshv = "6",//国临2.0
                zlv = "6",//国临2.0
                zyv = "10";//中医2020
        Map<String, String> bms = hpHospiatlInfo.getBmVersion();
        if (null != bms && bms.size() > 0) {
            ssv = bms.get("1");//手术编码
            jbv = bms.get("0");//疾病编码
            sunshv = bms.get("2");//损伤编码
            zlv = bms.get("3");//肿瘤编码
            zyv = bms.get("4");//中医编码
        }
        //先清除旧版本的库表
        ifExistsTableThenDrop("zdbz");
        ifExistsTableThenDrop("ssbz");
        ifExistsTableThenDrop("zybz");
        //清除现行版本的库表
        ifExistsTableThenDrop("hp_zdbz");
        ifExistsTableThenDrop("hp_ssbz");
        ifExistsTableThenDrop("hp_zybz");
        //获取编码版本字典库
        Map<Integer, List<SysDictVal>> bmMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        if (CollUtil.isNotEmpty(bmMap) && bmMap.containsKey(89)) {
            //hp_bm_version列表
            Map<String, List<SysDictVal>> dictVals = bmMap.get(89).stream().collect(Collectors.groupingBy(SysDictVal::getVal));
            //查询了标准代码库关联历史对照记录表,同时关联了全版本手术对照表
            String sql = "SELECT\n" +
                    "dmk.code code,lsdz.use_dm use_dm,use_mc use_mc,dmk.name name,dmk.type type,dmk.version version,iccm.ssdj,(case when iccm.iszlxcz='1' or iccm.iszlxcz='2' or iccm.iszdxcz='1' then 1 else 0 end) as iscz ,dmk.query query INTO hp_ssbz \n" +
                    "FROM\n" +
                    "hp_bzdmk dmk LEFT JOIN hp_history_iccm_dz lsdz ON upper(lsdz.report_dm)= upper(dmk.code) AND lsdz.report_version= dmk.version \n" +
                    "and (case when lsdz.report_mc in(dmk.name) and lsdz.use_mc in (dmk.name) then lsdz.use_mc end)=dmk.name\n" +
                    "AND lsdz.type= dmk.type AND ( isnull( use_mc, '' ) != '' OR isnull( use_dm, '' ) != '' )\n" +
                    //采用院内标准,bz=3
                    //采用当前医院配置的手术版本的代码 **dm=dmk.code
                    "LEFT JOIN HP_ICDCM3 iccm ON upper(iccm.@@dm)= upper(dmk.code) AND bz = 3 \n" +
                    "WHERE dmk.type= 1 AND dmk.version= @version ";
            sql = sql.replace("@version", ssv).replace("@@dm", dictVals.get(ssv).get(0).getRemark() + "dm");
            selectSqlWithSQL(sql);
            if (StrUtil.isNotEmpty(zyv)) {//如果配置了中医的版本则去更新
                //查询了标准代码库关联历史对照记录表,默认查询2020版中医编码病症治编码,特殊处理中医编码,有一码多名的情况,先按编码分组排序,然后取每组第一条
                sql = "select  * into hp_zybz from(\n" +
                        "select ROW_NUMBER() OVER(PARTITION BY code ORDER BY name desc ) AS Row_Index,dmk.code code,dz.use_dm use_dm,dz.use_mc use_mc,dmk.name name,dmk.type type,dmk.version version,dmk.query query  \n" +
                        "from hp_bzdmk dmk left join hp_history_iccm_dz dz on dz.report_dm=dmk.code and dz.report_version=dmk.version and dz.type=dmk.type where dmk.type=4 and dmk.version=@version )  \n" +
                        "a where Row_Index=1";
                sql = sql.replace("@version", zyv);

                selectSqlWithSQL(sql);
                sql = "CREATE NONCLUSTERED INDEX [mc_zybz]ON [dbo].[hp_zybz] ([name] ASC);\n" +
                        "CREATE NONCLUSTERED INDEX [query_zybz]ON [dbo].[hp_zybz] ([query] ASC);\n" +
                        "CREATE NONCLUSTERED INDEX [code_zybz]ON [dbo].[hp_zybz] ([code] ASC);";
                selectSqlWithSQL(sql);
            }
            //查询了标准代码库管理历史对照记录表,查询了所有icd编码
            sql = "select dmk.code,lsdz.use_dm,lsdz.use_mc,dmk.name name,dmk.type type,dmk.version version,dmk.query query into hp_zdbz \n" +
                    "FROM hp_bzdmk dmk LEFT JOIN hp_history_iccm_dz lsdz ON " +
                    "upper(lsdz.report_dm)= upper(dmk.code) AND lsdz.report_version= dmk.version  and (case when lsdz.report_mc in(dmk.name) and lsdz.use_mc in (dmk.name) then lsdz.use_mc end)=dmk.name AND lsdz.type= dmk.type AND ( isnull( use_mc, '' ) != '' OR isnull( use_dm, '' ) != '' )\n" +
                    "where dmk.type in('0','2','3') and dmk.version=@version";
            sql = sql.replace("@version", jbv);
            selectSqlWithSQL(sql);
            //给这2个表增加索引
            sql = "CREATE NONCLUSTERED INDEX [mc_zdbz]ON [dbo].[hp_zdbz] ([name] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [code_zbbz]ON [dbo].[hp_zdbz] ([code] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [query_zbbz]ON [dbo].[hp_zdbz] ([query] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [mc_ssbz]ON [dbo].[hp_ssbz] ([name] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [query_ssbz]ON [dbo].[hp_ssbz] ([query] ASC);\n" +
                    "CREATE NONCLUSTERED INDEX [code_ssbz]ON [dbo].[hp_ssbz] ([code] ASC);";
            selectSqlWithSQL(sql);
            System.out.println("已经初始化完成诊断,手术,中医的当前版本库表");
        } else {
            System.out.println("请联系管理员重新初始化系统字典表,缺少系统编码版本字典!");
        }
    }

    /**
     * 查询icd或中医编码信息
     * @param name  参数
     * @param p     分页
     * @param kind  1 icd;2 zybz
     * @param type  0 诊断;2 病理诊断 ;3 损伤中毒
     * @return
     */
    public ResultUtil findIcdOrZybz(String name , PageInfo p,String kind,String type){
        String sql="";
        if("1".equals(kind)){
            sql=" from hp_zdbz where isnull(use_dm,'')='' and isnull(use_mc,'')='' ";
            if(StrUtil.isNotEmpty(type)&&!"99".equals(type)){
                sql+=" and type ="+type ;
            }
        }else if("2".equals(kind)){
            sql=" from hp_zybz where isnull(use_dm,'')='' and isnull(use_mc,'')='' ";
        }
        if(StrUtil.isNotEmpty(name)){
            sql+=" and query like '%"+name+"%' ";
        }
//        sql+=" order by query,len(name)";
        return ResultUtil.success( selectPageinfoWithSQL("code,name,type,version",sql,"query,len(name)",p,true));
//        return ResultUtil.success(selectSqlWithSQL(sql));
    }


}
