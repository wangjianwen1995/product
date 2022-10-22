package com.sxdl.hp.service;

import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.hp.dao.dao1.HpBzdmkDao;
import com.sxdl.hp.dao.dao1.HpICCMGxbDao;
import com.sxdl.hp.dao.dao1.HpICDGxbDao;
import com.sxdl.hp.entity.HpICDGxb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpICDGxbService extends BaseUUIDServiceImpl<HpICDGxb> {
    @Autowired
    HpICDGxbDao hpICDGxbDao;
    @Autowired
    HpICCMGxbDao hpICCMGxbDao;
    @Autowired
    HpBzdmkDao hpBzdmkDao;

    public List selectnNewVersionSome(String leftVersion, String rightVersion, String flag, String type)  {
        String gxType = leftVersion + "_" + rightVersion;
        HpICDGxb hpICDGxb = new HpICDGxb();
        hpICDGxb.setType(gxType);
        List<HpICDGxb> list = new ArrayList<>();
        switch (flag) {
            case "2":
                //查询新版本已对照数据
                /*list = hpICDAutoDzDao.selectByBzVersion(version.getLeft_bm(), version.getLeft_mc(),
                        rightVersion, type);*/
                hpICDGxb.setStatus("1");
                list = hpICDGxbDao.select(hpICDGxb);
                break;
            case "3":
                hpICDGxb.setStatus("0");
                list = hpICDGxbDao.select(hpICDGxb);
                break;
            case "4":
                list = hpICDGxbDao.select(hpICDGxb);
                break;
        }
        return list;

    }

    public HpICDGxb getVersion(String leftVersion, String rightVersion)  {
        Map<Integer, List<SysDictVal>> baMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        List<SysDictVal> sysDictVals = baMap.get(89);
        HpICDGxb hpICDGxb = new HpICDGxb();
        sysDictVals.forEach(e -> {
            if (leftVersion.equals(e.getVal())) {
                String left_dm = e.getRemark() + "dm";
                String left_mc = e.getRemark() + "mc";
                hpICDGxb.setLeft_bm(left_dm);
                hpICDGxb.setLeft_mc(left_mc);
            } else if (rightVersion.equals(e.getVal())) {
                String right_dm = e.getRemark() + "dm";
                String right_mc = e.getRemark() + "mc";
                hpICDGxb.setRight_dm(right_dm);
                hpICDGxb.setRight_mc(right_mc);
            }
        });


        return hpICDGxb;
    }

    public void saveGxb(String leftVersion, String rightVersion, String type, String tableName, String gxbName)  {
        //获取查询的列
        HpICDGxb version = getVersion(leftVersion, rightVersion);
        //拼接type
        String gxType = leftVersion + "_" + rightVersion;

        //查找关系表中已存在的对照
        List<String> list = hpICCMGxbDao.selectGxType(gxbName);
        long count = list.stream().filter(e -> null != e && e.equals(gxType)).count();
        //long count = list.stream().filter(e -> null != e && e.substring(0,1).equals(leftVersion)).count();
        String sql = "";
        if (count <= 0) {
            sql = " insert into " + gxbName + " (left_bm,left_mc,type,status,id)  select distinct  " + version.getLeft_bm() + " as left_bm," + version.getLeft_mc() + " as left_mc ,'" + gxType + "','0',newid() from  " + tableName + "   where " + version.getLeft_bm() + " is not null";
            hpICDGxbDao.updateSqlWithSQL(sql);
        }

        String update_sql = "with lsb as ( select code,name from hp_bzdmk  where  type='" + type + "' and version='" + rightVersion + "' )\n" +
                "update a set right_dm=b.code,right_mc=b.name,a.status='1' \n" +
                "from " + gxbName + " a,lsb b where a.status='0' and \n" +
                "((ltrim(rtrim(a.left_bm))=ltrim(rtrim(b.code)) and ltrim(rtrim(a.left_mc))=ltrim(rtrim(b.name))) or(ltrim(rtrim(a.left_bm))=ltrim(rtrim(b.code)) )or(ltrim(rtrim(a.left_mc))=ltrim(rtrim(b.name))))";
        //System.out.println(update_sql);
        hpICDGxbDao.updateSqlWithSQL(update_sql);

    }
}
