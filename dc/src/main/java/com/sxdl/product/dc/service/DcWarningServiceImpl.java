package com.sxdl.product.dc.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcWarningDao;
import com.sxdl.product.dc.entity.DcWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("dcWarningService")
@Transactional
public class DcWarningServiceImpl extends BaseUUIDServiceImpl<DcWarning> implements DcWarningService {
    @Autowired
    private DcWarningDao dcWarningDao;

    @Override
    public PageInfo selectBySome(PageInfo pageInfo, String startTime, String endTime, String schedule_id, String productId, String exec_id) {
        String columnsSql = " a.*,b.product_name,b.procedure_name ";
        //a.product_id=b.product_id and a.job_id=b.job_id and a.exec_id=b.procedure_id
        String fromAndWhereSql = " from dc_warning a left join dc_schedule_config b on a.schedule_id=b.id and isnull(b.type_id,0)!=0  where 1=1";
        if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
            fromAndWhereSql += " and a.etltime between '" + startTime + "' and '"+endTime+"' ";
        }
        if (StringUtil.isNotEmpty(productId)) {
            fromAndWhereSql += " and a.product_id='" + productId + "' ";
        }
        if (StringUtil.isNotEmpty(schedule_id)) {
            fromAndWhereSql += " and a.schedule_id='" + schedule_id + "' ";
        }
        if (StringUtil.isNotEmpty(exec_id)) {
            fromAndWhereSql += " and a.exec_id='" + exec_id + "' ";
        }

        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "a.product_id,etltime", pageInfo, false);
        // System.out.println(columnsSql);

        List<Map<String, Object>> maps = dcWarningDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;

    }
}
