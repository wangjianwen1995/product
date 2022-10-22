package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@Transactional
public class HpHospiatlInfoService extends BaseUUIDServiceImpl<HpHospiatlInfo> {

    @Autowired
    HpTableService hpTableService;
@Autowired
HpBzdmkService hpBzdmkService;
    /**
     * 获取当前医院所配置的附页信息,
     * 这里注意一定要确保 医院基础数据设置完整
     *
     * @return
     */
    public String getFollowerPageTable()  {
        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) ApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (null == hpHospiatlInfo) {
            return null;
        }
        String tablename = "";
        if (hpHospiatlInfo.getHomepage_type() == 1) { //1中医
            tablename = hpHospiatlInfo.getChinese_medicine();
        } else if (hpHospiatlInfo.getHomepage_type() == 2) {//2西医
            tablename = hpHospiatlInfo.getWestern_medicine();
        }
        return tablename;
    }

    /**
     * 插入或者更新医院信息,
     *  更新医院信息的编码版本
     *  更新标准科目字典表
     */
    public ResultUtil saveorupdate(HpHospiatlInfo hpHospiatlInfo, HttpServletRequest request)  {
        ResultUtil  resultUtil = hpTableService.selectEnables(hpHospiatlInfo);
        if (resultUtil.getState().equals("error")) return resultUtil;
        hpHospiatlInfo = (HpHospiatlInfo) resultUtil.getT();
        Integer type=hpHospiatlInfo.getHomepage_type();
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            insert(hpHospiatlInfo);
            initStandardKs(type);
        } else {//更新数据时候,同步更新sys_standard_ks,标准科目表
            HpHospiatlInfo old = findById(hpHospiatlInfo.getId());
            if (null == old) {
                insert(hpHospiatlInfo);
                initStandardKs(type);
            }
            type=old.getHomepage_type();
            if (!type.equals(hpHospiatlInfo.getHomepage_type())) {
                initStandardKs(type);
            }
            update(hpHospiatlInfo);
        }
        HpApplicationRunnerImpl.contextMap.put("hpHospiatlInfo", hpHospiatlInfo);
        HttpSession session = request.getSession();
        session.setAttribute("his_code", hpHospiatlInfo.getHis_code());
        session.setAttribute("his_name", hpHospiatlInfo.getHis_name());
        return ResultUtil.success("操作成功");
    }

    /**
     * 初始化标准科目字典表
     */
    public void initStandardKs(Integer type){
        //首页类型: 1中医 2西医
        ifExistsTableThenDrop("sys_standard_ks");
        String sql="select * into sys_standard_ks from sys_standard_ks_";
        if(1==type){
            sql+="zy";
        }else if(2==type){
            sql+="xy";
        }
        selectSqlWithSQL(sql);
    }
}
