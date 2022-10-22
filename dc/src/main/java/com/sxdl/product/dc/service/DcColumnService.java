package com.sxdl.product.dc.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.BaseService;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcColumn;

import java.util.List;

public interface DcColumnService extends BaseService<DcColumn> {

    public List<DcColumn> selectByTableid(String tableid);

    public PageInfo findMappingColumn(PageInfo pageInfo, String name);

    public List<DcColumn> findMappingColumn(String name);

    public Integer updateDictIsOn(String id, Integer is_on);

    public ResultUtil deleteByList(List<DcColumn> dcColumnList);

    public List<DcColumn> findReportTempColumn(String name);

    public Integer updateMappingEnable(String id, Integer is_hisenable);
}
