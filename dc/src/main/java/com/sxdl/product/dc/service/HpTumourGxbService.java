package com.sxdl.product.dc.service;

import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.product.dc.dao.dao1.HpBzdmkDao;
import com.sxdl.product.dc.dao.dao1.HpICCMGxbDao;
import com.sxdl.product.dc.dao.dao1.HpTumourGxbDao;
import com.sxdl.product.dc.entity.HpTumourGxb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpTumourGxbService extends BaseServiceImpl<HpTumourGxb> {
    @Autowired
    HpTumourGxbDao hpTumourGxbDao;
    @Autowired
    HpICCMGxbDao hpICCMGxbDao;
    @Autowired
    HpBzdmkDao hpBzdmkDao;

    public HpTumourGxb getVersion(String leftVersion, String rightVersion) throws Exception {
        Map<Integer, List<SysDictVal>> baMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        List<SysDictVal> sysDictVals = baMap.get(89);
        HpTumourGxb hpTumourGxb = new HpTumourGxb();
        sysDictVals.forEach(e -> {
            if (leftVersion.equals(e.getVal())) {
                String left_dm = e.getRemark() + "dm";
                String left_mc = e.getRemark() + "mc";
                hpTumourGxb.setLeft_bm(left_dm);
                hpTumourGxb.setLeft_mc(left_mc);
            } else if (rightVersion.equals(e.getVal())) {
                String right_dm = e.getRemark() + "dm";
                String right_mc = e.getRemark() + "mc";
                hpTumourGxb.setRight_dm(right_dm);
                hpTumourGxb.setRight_mc(right_mc);
            }
        });


        return hpTumourGxb;
    }
}
