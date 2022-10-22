package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcDataSource;

import java.util.List;

public interface DcDataSourceService extends BaseService<DcDataSource> {

    String findInfo(String name, String fromType, String fromUrl, String username, String pwd,String linkStr);

    void deleteServerLink(String sql);

    List<DcDataSource> findByCondition(String name);

}
