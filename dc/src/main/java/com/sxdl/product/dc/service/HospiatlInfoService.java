package com.sxdl.product.dc.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.product.dc.entity.HospiatlInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HospiatlInfoService extends BaseUUIDServiceImpl<HospiatlInfo> {

//    @Autowired
//    private HpTableDao tableDao;

    /**
     * 获取当前医院所配置的附页信息,
     * <p>
     * 这里注意一定要确保 医院基础数据设置完整
     *
     * @return
     */
    public String getFollowerPageTable() throws Exception {
//        List<HpHospiatlInfo> hpHospiatlInfos = hpHospiatlInfoDao.selectAll();
        HospiatlInfo hpHospiatlInfo = (HospiatlInfo) ApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
//        HpTable hpTable = new HpTable();
        if (null == hpHospiatlInfo) {
            return null;
        }
        //1中医 2西医
        String tablename = "";
        if (hpHospiatlInfo.getHomepage_type() == 1) {
            tablename = hpHospiatlInfo.getChinese_medicine();
        } else if (hpHospiatlInfo.getHomepage_type() == 2) {
            tablename = hpHospiatlInfo.getWestern_medicine();
        }

//        if (!StringUtils.isEmpty(tablename)) {
//            hpTable.setName(tablename);
//            //后续只用了省附页的名称,所以没必要去查数据
////            List<HpTable> select = tableDao.select(hpTable);
////            hpTable=select.get(0);
//        }
        return tablename;
    }
}
