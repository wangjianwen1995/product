package com.sxdl.base.service;


import com.sxdl.base.entity.SysDictVal;

import java.util.List;

public interface SysDictValService extends BaseService<SysDictVal> {

    void updateAppDcDitVal();
    void updateByPrimaryKeySelective(SysDictVal dcDitVal);

    void insertDV(SysDictVal dcDitVal);
    /**
     * 根据字典表id查询字典数据
     *
     * @param tableid
     * @return
     */
    List<SysDictVal> findDictValsByTableId(Integer tableid);
}
