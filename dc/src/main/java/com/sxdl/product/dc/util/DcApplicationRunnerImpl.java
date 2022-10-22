package com.sxdl.product.dc.util;

import com.sxdl.base.dao.dao1.SysDictTableDao;
import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.AreaZipDao;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.HospiatlInfo;
import com.sxdl.product.dc.entity.HpAreaZip;
import com.sxdl.product.dc.service.DcColumnService;
import com.sxdl.product.dc.service.HospiatlInfoService;
import com.sxdl.product.dc.service.HpBzdmkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DcApplicationRunnerImpl extends ApplicationRunnerImpl {
    @Autowired
    public SysDictValDao sysDictValDao;

    @Autowired
    public AreaZipDao areaZipDao;
    @Autowired
    public SysDictTableDao sysDictTableDao;
    @Autowired
    private HospiatlInfoService hpHospiatlInfoService;
    @Autowired
    private HpBzdmkService bzdmkService;

    @Autowired
    private DcColumnService columnService;

    @Override
    public void run(ApplicationArguments args)throws Exception {
        init();
        List<SysDictTable> dcDitTableList2 = dcDitTableList.stream().filter(e -> null != e && !StringUtil.isEmpty(e.getSource_id().toString()) && 2 == e.getSource_id()).collect(Collectors.toList());
        List<HpAreaZip> hpAreaZips = areaZipDao.selectAll();
        Map<Integer, List<SysDictVal>> baBmMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1 && "病案编码字典".equals(e.getSupplement_name())).collect(Collectors.groupingBy(e -> e.getDict_id()));

        List<DcColumn> columns = columnService.findMappingColumn("");

        contextMap.put("dcDitTableList2", dcDitTableList2);
        contextMap.put("areaZip", hpAreaZips);
        contextMap.put("baBmMap", baBmMap);
        contextMap.put("dictMap", columns);
        List<HospiatlInfo> all = hpHospiatlInfoService.findAll();
        if (null == all || all.size() <= 0) {
            contextMap.put("hpHospiatlInfo", new HospiatlInfo());
        } else {
            HospiatlInfo hospiatlInfo = all.get(0);
            contextMap.put("hpHospiatlInfo", hospiatlInfo);
        }
        System.out.println("山西雕龙欢迎您！欢迎使用DC（Date Center）智慧数据中心管理平台~");
    }


}
