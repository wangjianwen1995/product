package com.sxdl.product.dc.service.impl;//package com.sxdl.product.dc.service.impl;
//
//import com.sxdl.base.service.impl.BaseServiceImpl;
//import com.sxdl.base.util.ApplicationRunnerImpl;
//import com.sxdl.product.dc.dao.dao1.DcDitTableDao;
//import com.sxdl.product.dc.dao.dao1.DcDitValDao;
//import com.sxdl.product.dc.entity.DcDitTable;
//import com.sxdl.product.dc.entity.DcDitVal;
//import com.sxdl.product.dc.service.DcDitTableService;
//import com.sxdl.product.dc.service.DcDitValService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service("dcDitTableService")
//@Transactional
//public class DcDitTableServiceImpl extends BaseServiceImpl<DcDitTable> implements DcDitTableService {
//    @Autowired
//    private DcDitTableDao dcDitTableDao;
//    @Autowired
//    private DcDitValDao dcDitValDao;
//    @Autowired
//    private DcDitValService dcDitValService;
//
//    @Override
//    public void updateDT(DcDitTable dcDitTable, List<DcDitVal> dcDitVals) {
//        dcDitTableDao.updateByPrimaryKeySelective ( dcDitTable );
//        if(dcDitVals!=null&&dcDitVals.size ()>0){
//            for (DcDitVal dcDitVal : dcDitVals) {
//                dcDitVal.setDict_name ( dcDitTable.getName () );
//                dcDitVal.setSource_id ( dcDitTable.getSource_id () );
//                dcDitValDao.updateByPrimaryKeySelective ( dcDitVal );
//            }
//            dcDitValService.updateAppDcDitVal ();
//        }
//
//        updateAppDcDitTable ();
//    }
//
//    @Override
//    public void insertDT(DcDitTable dcDitTable) {
//        dcDitTableDao.insertSelective ( dcDitTable );
//        updateAppDcDitTable ();
//    }
//
//    @Override
//    public void updateAppDcDitTable() {
//        //符合 国家标准的字典表类型
//        List<DcDitTable> dcDitTableList = dcDitTableDao.selectAll ();
//        ApplicationRunnerImpl.contextMap.put ( "dcDitTableList", dcDitTableList );
//    }
//}
