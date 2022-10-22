package com.sxdl.hp.service;

import com.sxdl.hp.HpMainTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HpIndexTest extends HpMainTest {

    @Autowired
    HpIndexService hpIndexService;

    @Test
    public void t(){
        long s=System.currentTimeMillis(),e;
        String start="2018-11-01",end="2018-11-30",ks="";
        hpIndexService.getGZL(start,end,ks);
        e=System.currentTimeMillis()-s;
        System.out.println(e);
    }
}
