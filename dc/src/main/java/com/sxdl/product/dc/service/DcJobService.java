package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcJob;

import java.util.List;
import java.util.Map;

public interface DcJobService /*extends Jpa<DcJob>*/  extends BaseService<DcJob> {

    void insertByJob(Map<String,Object> map);

    List<DcJob> selectByIds(String substring);
}
