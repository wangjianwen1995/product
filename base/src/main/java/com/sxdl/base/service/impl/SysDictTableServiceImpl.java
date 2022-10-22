package com.sxdl.base.service.impl;

import com.sxdl.base.dao.dao1.SysDictTableDao;
import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictTableService;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.ApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("SysDictTableService")
@Transactional
public class SysDictTableServiceImpl extends BaseServiceImpl<SysDictTable> implements SysDictTableService {
    @Autowired
    private SysDictTableDao dcDitTableDao;
    @Autowired
    private SysDictValDao dcDitValDao;
    @Autowired
    private SysDictValService dcDitValService;

    @Override
    public void updateDT(SysDictTable dcDitTable, List<SysDictVal> dcDitVals) {
        dcDitTableDao.updateByPrimaryKeySelective ( dcDitTable );
        if(dcDitVals!=null&&dcDitVals.size ()>0){
            for (SysDictVal dcDitVal : dcDitVals) {
                dcDitVal.setDict_name ( dcDitTable.getName () );
                dcDitVal.setSource_id ( dcDitTable.getSource_id () );
                dcDitValDao.updateByPrimaryKeySelective ( dcDitVal );
            }
            dcDitValService.updateAppDcDitVal ();
        }

        updateAppDcDitTable ();
    }



    @Override
    public void insertDT(SysDictTable dcDitTable) {
        dcDitTableDao.insertSelective ( dcDitTable );
        updateAppDcDitTable ();
    }

    @Override
    public void updateAppDcDitTable() {
        //符合 国家标准的字典表类型
        List<SysDictTable> dcDitTableList = dcDitTableDao.selectAll ();
        ApplicationRunnerImpl.contextMap.put ( "dcDitTableList", dcDitTableList );
    }
}
