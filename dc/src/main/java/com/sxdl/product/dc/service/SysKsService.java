package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.SysKs;

import java.util.List;

public interface SysKsService extends BaseService<SysKs> {


    List selectBySome(String name, String type);


}
