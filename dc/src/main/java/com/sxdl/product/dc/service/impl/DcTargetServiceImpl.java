package com.sxdl.product.dc.service.impl;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcTargetDao;
import com.sxdl.product.dc.entity.DcTarget;
import com.sxdl.product.dc.service.DcTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("dcTargetService")
@Transactional
public class DcTargetServiceImpl extends BaseUUIDServiceImpl<DcTarget> implements DcTargetService {

    @Autowired
    DcTargetDao dcTargetDao;

    @Override
    public PageInfo likeFind(PageInfo pageInfo, String name) {
        String columnsSql = " * ";
        String fromAndWhereSql = " from dc_target  where 1=1";
        if (StringUtil.isNotEmpty(name)) {
            fromAndWhereSql += " and (targetname like '%"+name+"%')";
        }
        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, " ordernum ", pageInfo, false);
        //System.out.println(columnsSql);
        List<Map<String, Object>> maps = dcTargetDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;

    }
}
