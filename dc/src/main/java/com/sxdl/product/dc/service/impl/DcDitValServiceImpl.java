package com.sxdl.product.dc.service.impl;//package com.sxdl.product.dc.service.impl;
//
//import com.sxdl.base.service.impl.BaseServiceImpl;
//import com.sxdl.base.util.ApplicationRunnerImpl;
//import com.sxdl.product.dc.dao.dao1.DcDitValDao;
//import com.sxdl.product.dc.entity.DcDitVal;
//import com.sxdl.product.dc.service.DcDitValService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Service("dcDitValService")
//@Transactional
//public class DcDitValServiceImpl extends BaseServiceImpl<DcDitVal> implements DcDitValService {
//    @Autowired
//    private DcDitValDao dcDitValDao;
//
//    @Override
//    public void updateAppDcDitVal() {
//        //符合 国家标准的字典表类型
//        List<DcDitVal> dcDitVals = dcDitValDao.selectAll ();
//        Map<Integer, List<DcDitVal>> dvOnMap, dvAllMap;
//        dvOnMap = dcDitVals.stream ().filter ( e -> null != e && e.getIs_on () == 1 ).collect ( Collectors.groupingBy ( e -> e.getDict_id () ) );
//        dvAllMap = dcDitVals.stream ().filter ( e -> null != e ).collect ( Collectors.groupingBy ( e -> e.getDict_id () ) );
//        ApplicationRunnerImpl.contextMap.put ( "dvAllMap", dvAllMap );
//        ApplicationRunnerImpl.contextMap.put ( "dvOnMap", dvOnMap );
//
//    }
//
//    @Override
//    public void insertDV(DcDitVal dcDitVal) {
//        dcDitValDao.insertSelective ( dcDitVal );
//        updateAppDcDitVal ();
//    }
//
//    @Override
//    public void updateByPrimaryKeySelective(DcDitVal dcDitVal) {
//        dcDitValDao.updateByPrimaryKeySelective ( dcDitVal );
//        updateAppDcDitVal ();
//    }
//}
