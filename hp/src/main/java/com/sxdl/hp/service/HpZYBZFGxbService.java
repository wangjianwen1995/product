package com.sxdl.hp.service;

import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.hp.dao.dao1.HpBzdmkDao;
import com.sxdl.hp.dao.dao1.HpICCMGxbDao;
import com.sxdl.hp.dao.dao1.HpZYBZFGxbDao;
import com.sxdl.hp.entity.HpZYBZFGxb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpZYBZFGxbService extends BaseServiceImpl<HpZYBZFGxb> {
    @Autowired
    HpZYBZFGxbDao hpZYBZFGxbDao;
    @Autowired
    HpICCMGxbDao hpICCMGxbDao;
    @Autowired
    HpBzdmkDao hpBzdmkDao;

    public HpZYBZFGxb getVersion(String leftVersion, String rightVersion)  {
        Map<Integer, List<SysDictVal>> baMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        List<SysDictVal> sysDictVals = baMap.get(89);
        HpZYBZFGxb hpZYBZFGxb = new HpZYBZFGxb();
        sysDictVals.forEach(e -> {
            if (leftVersion.equals(e.getVal())) {
                String left_dm = e.getRemark() + "dm";
                String left_mc = e.getRemark() + "mc";
                hpZYBZFGxb.setLeft_bm(left_dm);
                hpZYBZFGxb.setLeft_mc(left_mc);
            } else if (rightVersion.equals(e.getVal())) {
                String right_dm = e.getRemark() + "dm";
                String right_mc = e.getRemark() + "mc";
                hpZYBZFGxb.setRight_dm(right_dm);
                hpZYBZFGxb.setRight_mc(right_mc);
            }
        });


        return hpZYBZFGxb;
    }
}
