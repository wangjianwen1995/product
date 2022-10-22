package com.sxdl.product.dc.service.impl;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcScheduleConfigDao;
import com.sxdl.product.dc.dao.dao1.DcSingleConfigDao;
import com.sxdl.product.dc.entity.DcScheduleConfig;
import com.sxdl.product.dc.entity.DcSingleConfig;
import com.sxdl.product.dc.service.DcSingleConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("dcSingleConfigService")
@Transactional
public class DcSingleConfigServiceImpl extends BaseUUIDServiceImpl<DcSingleConfig> implements DcSingleConfigService {
    @Autowired
    private DcSingleConfigDao dcSingleConfigDao;
    @Autowired
    private DcScheduleConfigDao dcScheduleConfigDao;

    @Override
    public PageInfo selectBySome(PageInfo pageInfo, String name, String product_id) {
        String columnsSql = " * ";
        String fromAndWhereSql = " from dc_single_config   where 1=1  ";
        if (StringUtil.isNotEmpty(product_id)) {
            fromAndWhereSql += " and Product_id='" + product_id + "'";
        }
        if (StringUtil.isNotEmpty(name)) {
            fromAndWhereSql += " and name like '%" + name + "%'";
        }
        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "Product_id", pageInfo, false);
       // System.out.println(columnsSql);


        List<Map<String, Object>> maps = dcSingleConfigDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;
    }

    @Override
    public void deleteSomeById(String id) {
        DcScheduleConfig dcScheduleConfig=new DcScheduleConfig();
        dcScheduleConfig.setSingle_id(id);
        dcScheduleConfigDao.delete(dcScheduleConfig);
        dcSingleConfigDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<DcSingleConfig> selectByProduct(String ids) {
        return dcSingleConfigDao.selectByProductIds(ids);
    }

}
