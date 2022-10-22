package com.sxdl.hp.util;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.dao.dao1.AreaZipDao;
import com.sxdl.hp.entity.HpAreaZip;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.service.HpBzdmkService;
import com.sxdl.hp.service.HpHospiatlInfoService;
import com.sxdl.hp.service.HpTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class HpApplicationRunnerImpl extends ApplicationRunnerImpl {
    //定义了一个全局超时缓存,期限为1小时,超时后会自动释放
    public volatile static TimedCache<String, DateTime> timedCache = CacheUtil.newTimedCache(360000);
    Map<String, String> dictVal;
    List<Map<String, String>> dicts;
    Map<Integer, Object> dictmap;
    @Autowired
    private AreaZipDao areaZipDao;
    @Autowired
    private HpBzdmkService bzdmkService;
    @Autowired
    private HpHospiatlInfoService hpHospiatlInfoService;
    @Autowired
    private HpTableService hpTableService;

    /**
     * 系统级缓存中是否有唯一编码,没有的话插入缓存
     *
     * @param bah   病案号+年度
     * @param table 表名
     * @return
     */
    public static String getCache(String bah, String table) {
        //从缓存中获取数据不触发更新过期时间机制
        DateTime old = timedCache.get(bah + table, false), now = new DateTime();
        if (null != old) {
            //当前操作时间和上次操作时间间隔
            long l = DateUtil.betweenMs(old, now);
            //不超过10秒钟,认定为重复提交
            if (l <= 10000) {
                return "23305";
            } else {
                //超过10秒钟,认定为上次正常操作失败,重新操作
                timedCache.put(bah + table, now);
            }
        }
        timedCache.put(bah + table, now);
        return null;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        super.init();
        //线程安全的集合类,用来放置已经使用的已归档的病案号
        Map<String, Date> usedQueue = new ConcurrentHashMap<>();
        contextMap.put("usedQueue", usedQueue);
        Map<Integer, List<SysDictVal>> baMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1 && "病案首页字典".equals(e.getSupplement_name())).collect(Collectors.groupingBy(e -> e.getDict_id()));
        Map<Integer, List<SysDictVal>> baBmMap = dcDitVals.stream().filter(e -> null != e && e.getIs_on() == 1 && "病案编码字典".equals(e.getSupplement_name())).collect(Collectors.groupingBy(e -> e.getDict_id()));
        //查询首页的所有字典库信息
        dictmap = new HashMap<>();
        baMap.forEach((k, v) -> {
            v.sort(Comparator.comparing(SysDictVal::getVal));
            dicts = new ArrayList<>();
            v.forEach(e -> {
                dictVal = new HashMap<>();
                dictVal.put("name", e.getName());
                dictVal.put("val", e.getVal());
                if(121==e.getDict_id()){//只有国籍字段使用备注的拼音码简拼
                    dictVal.put("remark", e.getRemark());
                }
                dicts.add(dictVal);
            });
            dictmap.put(k, dicts);
        });

        contextMap.put("baMap", baMap);
        contextMap.put("baMapSimple", dictmap);
        contextMap.put("baBmMap", baBmMap);
        contextMap.put("dvAllList", dcDitVals);

        List<HpAreaZip> hpAreaZips = areaZipDao.selectAll();
        contextMap.put("areaZip", hpAreaZips);
        List<HpHospiatlInfo> all = hpHospiatlInfoService.findAll();
        contextMap.put("ZYICDMap", new HashMap<>());
        if (null == all || all.size() <= 0) {
            contextMap.put("hpHospiatlInfo", new HpHospiatlInfo());
        } else {
            HpHospiatlInfo hospiatlInfo;
            ResultUtil hhi = hpTableService.selectEnables(all.get(0));
            if ("success".equals(hhi.getMsg())) {
                hospiatlInfo = (HpHospiatlInfo) hhi.getT();
                contextMap.put("hpHospiatlInfo", hospiatlInfo);
                String zyversion = hospiatlInfo.getBmVersion().get("4");
//                Map<String, String> ZYICDMap = ZYICD.parallelStream().filter(e -> e.getVersion().equals(zyversion)).collect(Collectors.toMap(HpBzdmkEntity::getCode, HpBzdmkEntity::getName));
//                contextMap.put("ZYICDMap", ZYICDMap);
            } else {
                hospiatlInfo = all.get(0);
                contextMap.put("hpHospiatlInfo", hospiatlInfo);
            }
            if (1 == hospiatlInfo.getIsEqual()) {
                contextMap.put("fyTableName", hospiatlInfo.getChinese_medicine());
            } else if (2 == hospiatlInfo.getIsEqual()) {
                if (1 == hospiatlInfo.getHomepage_type()) {
                    contextMap.put("fyTableName", hospiatlInfo.getChinese_medicine());
                } else if (2 == hospiatlInfo.getHomepage_type()) {
                    contextMap.put("fyTableName", hospiatlInfo.getWestern_medicine());
                }
            }

        }

        Environment env = (Environment) contextMap.get("env");
        String dcLink = StrUtil.emptyToDefault(env.getProperty("dcLink"), "");
        contextMap.put("dcLink", dcLink);

        //将标准代码库插入到永久临时表中
        bzdmkService.initBiaozuns();

        //缓存用到的ip地址以及相关信息
        InetAddress inetAddress = InetAddress.getLocalHost();
        //获得本机Ip
        String ip = inetAddress.getHostAddress();
        String dcip = StrUtil.emptyToDefault(env.getProperty("dcip"), ip);
        String drip = StrUtil.emptyToDefault(env.getProperty("drip"), ip);
        String qcip = StrUtil.emptyToDefault(env.getProperty("qcip"), ip);
        contextMap.put("localip", ip);
        contextMap.put("dcip", dcip);
        contextMap.put("drip", drip);
        contextMap.put("qcip", qcip);
        ResultUtil send = SxdlFeignUtil.send(true, qcip + "/verify/linking/getToken", "");
        if (!send.isSuc()) {
            contextMap.put("qcIsOn", 0);
            System.out.println(send.getMsg());
        } else {
            contextMap.put("qcIsOn", 1);
        }

        System.out.println("山西雕龙欢迎您！欢迎使用HP（Home Page）智慧病案首页管理平台~");
        //启动系统级的超时缓存
        timedCache.schedulePrune(3600000);
//        hpDcBaseHandleService.getDrPros();
    }

}
