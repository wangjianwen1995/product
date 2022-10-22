package com.sxdl.product.dc.service.impl;

import com.sxdl.base.entity.SysUserVsKs;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao2.SysKsDao;
import com.sxdl.product.dc.entity.SysKs;
import com.sxdl.product.dc.service.SysKsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("sysKsService")
@Transactional
public class SysKsServiceImpl extends BaseServiceImpl<SysKs> implements SysKsService {
    @Autowired
    private SysKsDao sysKsDao;

    public String getUserStandard(List<SysUserVsKs> sysUserVsKsList) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        SysKs sysKs = new SysKs();
        sysUserVsKsList.forEach(e -> {

            sysKs.setCode(e.getKs_id());
            SysKs sysKs1 = sysKsDao.selectOne(sysKs);
            set.add(sysKs1.getStandard_ks_id());
        });

        set.forEach(e -> {
            list.add(e);
        });
        StringBuilder kss = new StringBuilder();
        if (list.size() > 1) {
            kss.append("in (");
            kss.append("'" + list.get(0) + "'");
            for (int i = 1; i < list.size(); i++) {
                kss.append(",'" + list.get(i) + "'");
            }
            kss.append(")");
        } else if (list.size() == 1) {
            kss.append("=");
            kss.append(list.get(0));
        }
        return kss.toString();
    }


    public String getUserStandard1(List<SysUserVsKs> sysUserVsKsList) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        SysKs sysKs = new SysKs();
        sysUserVsKsList.forEach(e -> {

            sysKs.setCode(e.getKs_id());
            SysKs sysKs1 = sysKsDao.selectOne(sysKs);
            set.add(sysKs1.getCode());
        });

        set.forEach(e -> {
            list.add(e);
        });
        StringBuilder kss = new StringBuilder();
        if (list.size() > 1) {
            kss.append("in (");
            kss.append("'" + list.get(0) + "'");
            for (int i = 1; i < list.size(); i++) {
                kss.append(",'" + list.get(i) + "'");
            }
            kss.append(")");
        } else if (list.size() == 1) {
            kss.append("=");
            kss.append(list.get(0));
        }
        //System.out.println (kss);
        return kss.toString();
    }


    @Override
    public List<SysKs> selectBySome(String name, String type){

        String sql = " select *  from sys_ks a where 1=1 ";
        if (StringUtil.isNotEmpty(name)) {
            sql += " and (a.code like '%"+name+"%' or a.name like '%"+name+"%' ) ";
        }
        if (StringUtil.isNotEmpty(type)) {
            sql+=" and @@@@=1 ";
            String str="";
            if("0".equals(type)){
                str="1";
            }else if("1".equals(type)){
                str="is_id";
            }else if("2".equals(type)){
                str="is_od";
            }else if("3".equals(type)){
                str="is_ed";
            }else if("4".equals(type)){
                str="is_gcs";
            }else if("5".equals(type)){
                str="is_yj";
            }else if("6".equals(type)){
                str="is_opr";
            }else{
                str="1!";
            }
            sql=sql.replace("@@@@",str);
//            if(!"0".equals(type)){
//                sql+=" and is_on=1 ";
//            }
        }

        List<SysKs> maps = sysKsDao.findBysql(sql);


        return maps;
    }

}
