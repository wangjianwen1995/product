package com.sxdl.product.dc.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcLogDao;
import com.sxdl.product.dc.dao.dao1.DcProductDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcEtlLog;
import com.sxdl.product.dc.service.DcEtlLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("dcEtlLogService")
@Transactional
public class DcLogServiceImpl extends BaseUUIDServiceImpl<DcEtlLog> implements DcEtlLogService {
    @Autowired
    private DcLogDao dcLogDao;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcProductDao dcProductDao;

    @Override
    public List<DcEtlLog> findByFactor(String str) {
        return dcLogDao.findByFactor(str);
    }

    @Override
    public PageInfo selectBySome(PageInfo pageInfo, String startTime, String endTime,Integer status, String productId,String name) {
        String columnsSql = " a.*,b.product_name,b.job_name,b.procedure_name ";
        //a.product_id=b.product_id and a.job_id=b.job_id and a.exec_id=b.procedure_id
        String fromAndWhereSql = " from dc_etl_log a left join dc_schedule_config b on a.schedule_id=b.id and isnull(b.type_id,0)!=0  where 1=1";
        if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
            fromAndWhereSql += " and a.start_time between '" + startTime + "' and '"+endTime+"' ";
        }
        if (StringUtil.isNotEmpty(productId)) {
            fromAndWhereSql += " and b.product_id='" + productId + "' ";
        }
        if (StringUtil.isNotEmpty(name)) {
            fromAndWhereSql += " and (b.product_name like '%" + name + "%' or b.job_name like '%" + name + "%' or b.procedure_name like '%"+name+"%')";
        }
        if (null!=status && status>0) {
            //3.运行失败 2成功
            fromAndWhereSql += " and isnull(a.status,3)="+status;
        }

        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "a.product_id,start_time", pageInfo, false);
       // System.out.println(columnsSql);

        List<Map<String, Object>> maps = dcLogDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;
    }

    @Override
    public Boolean selectByPro(String prent_procedure_id,String batch) {
        String sql ="select * from dc_etl_log where exec_id='"+prent_procedure_id+"' and batch="+batch;
        List<DcEtlLog> logList= dcLogDao.findByFactor(sql);
        return CollUtil.isNotEmpty(logList)?true:false;
    }

    @Override
    public String selecsql(String sql) {
        return dcLogDao.execSelectSql(sql);
    }
}
