package com.sxdl.hp.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.hp.dao.dao1.HpVsch0ADao;
import com.sxdl.hp.dbo.ModelC;
import com.sxdl.hp.entity.*;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import com.sxdl.hp.util.SxdlFeignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class HpQmLinkingService extends BaseUUIDServiceImpl<HomepageEntity> {
    @Autowired
    YmlUtil ymlUtil;
    @Autowired
    HpEtlConfigService hpEtlConfigService;
    @Autowired
    HpVsch0AService hpVsch0AService;
    HpHospiatlInfo hpHospiatlInfo;
    String pTableName;
    @Autowired
    HpHomepageService hpHomepageService;
    @Autowired
    HpVsch0HService hpVsch0HService;
    @Autowired
    HpFllowService hpFllowService;
    @Autowired
    HpFileService hpFileService;
    @Autowired
    HpVsch0ADao hpVsch0ADao;

    /**
     * 环节质控的登录功能
     */
    public ResultUtil login(String noStaff, String ysName) {
        ResultUtil send = preCheckQcIsOk();
        if (null != send) {
            return send;
        }
        //医生用户注册
        StpUtil.login(noStaff);
        SysUser user = new SysUser();
        user.setCode(noStaff);
        user.setName(ysName);
        StpUtil.getSession(true).set("user", user);
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        JSONObject j = new JSONObject();
        j.putOpt("tokenName", "sxdl");
        j.putOpt("tokenValue", tokenInfo.getTokenValue());
        j.putOpt("user", tokenInfo.getTokenValue());
        j.put("dcip", ymlUtil.getYmlValue("dcip"));
        j.put("drip", ymlUtil.getYmlValue("drip"));
        j.put("qcip", ymlUtil.getYmlValue("qcip"));
        return ResultUtil.success(j);
    }

    /**
     * 环节质控中病案数据初始化
     */
    public ResultUtil linking(String bah, String zycs, String cysj)  {
        if (StrUtil.isBlank(bah) || StrUtil.isBlank(zycs) || StrUtil.isBlank(cysj)) {
            return ResultUtil.error("所有参数都是必填项!");
        }
        if (!DateUtil.isDate(cysj)) {
            return ResultUtil.error("时间参数错误");
        }
        zycs = getZYCS(zycs);
        bah+=zycs;
        TimeInterval timer = DateUtil.timer();
        String aid = hpVsch0ADao.selectAHasLinkingSave(bah);
        System.out.println(timer.intervalRestart());
        if(StrUtil.isNotEmpty(aid)){//已经录入过环节质控数据
//TODO 已经录入过环节的是否调用历史数据还是每次抽取最新的
        }
        //抽取外部数据,抽取到接口数据
        HpEtlConfig conf = hpEtlConfigService.findDefaultToInterface();
        if (null == conf) {
            return ResultUtil.error("系统抽取配置错误,请联系");
        }
        System.out.println(timer.intervalRestart());
        //调用查询数据接口

        Date cy = DateUtil.parse(cysj);
        String start = DateUtil.format(cy, DatePattern.NORM_DATE_PATTERN);
        ResultUtil ru = hpEtlConfigService.exec(start,start, conf, bah );
        System.out.println(timer.intervalRestart());
        if (!ru.isSuc()) {
            return ru;
        }
        ru= hpVsch0AService.findAllInit(DateUtil.year(cy) + "", bah );
        System.out.println(timer.intervalRestart());
        return ru;
    }

    /**
     * 环节质控中的保存数据功能
     * 先调用批量保存,状态为 2
     * 再将数据状态修改为 6
     */
    public ResultUtil save(ModelC data)  {
        hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        ResultUtil ru = hpHomepageService.saveCoreData(data, hpHospiatlInfo);
        if (!ru.isSuc()) {
            return ru;
        }
        Map map = (Map) ru.getT();
        Object aid = map.get("AID");
        if (null == aid) {
            return ResultUtil.error("数据保存异常,请检查!");
        } else {
            hpVsch0AService.changeStatus(aid.toString(), "6");//环节质控状态
            HpVsch0AEntity entityA = (HpVsch0AEntity) map.get("A");
            entityA.setSTATUS("6");
            map.put("A", entityA);
            return ResultUtil.success(map, "保存成功!");
        }
    }

    /**
     * 给外部推送质控后的病案数据
     */
    public ResultUtil find(String bah, String zycs) {
        if (StrUtil.isBlankOrUndefined(bah) || StrUtil.isBlankOrUndefined(zycs)) {
            return ResultUtil.error("所有参数都是必填项!");
        }
        ResultUtil send = preCheckQcIsOk();
        if (null != send) {
            return send;
        }
        //调用查询数据接口
        zycs = getZYCS(zycs);
        Object aid = hpVsch0AService.getAidByBah(bah + zycs);
        if (null == aid) {
            return ResultUtil.success("没有查到数据!");
        } else {
            String aId = aid.toString();
            Map<String, Object> data = new HashMap<>();
            HomepageEntity homepage = hpHomepageService.selectByAid(aId);
            if (null != homepage) {
                data.put("主页", homepage);
            } else {
                data.put("主页", null);
            }
            HpVsch0HEntity entityH = hpVsch0HService.selectOne(HpVsch0HEntity.builder().A_ID(aId).build());
            if (null != entityH) {
                data.put("输血信息", entityH);
            } else {
                data.put("输血信息", null);
            }
            pTableName = HpApplicationRunnerImpl.contextMap.get("fyTableName").toString();
            List<Map<String, Object>> maps = hpVsch0AService.selectSqlWithSQL("select * from " + pTableName + " where  A_ID='" + aId + "' ");
            if (CollUtil.isNotEmpty(maps)) {
                data.put("省附页", maps.get(0));
            } else {
                data.put("省附页", null);
            }
            HpfllowEntity hpfllow = hpFllowService.selectOne(HpfllowEntity.builder().A_ID(aId).build());
            if (null != entityH) {
                data.put("院内附页", hpfllow);
            } else {
                data.put("院内附页", null);
            }
            return ResultUtil.success(data, "查询成功");
        }
    }

    /**
     * 处理住院次数数据,用于拼接病案号
     */
    String getZYCS(String zycs) {
        if (zycs.length() == 1) {
            zycs = "0" + zycs;
        }
        return zycs;
    }

    /**
     * 预先检查环节质控功能是否开启,环节质控系统是否开启
     */
    public ResultUtil preCheckQcIsOk() {
        if (!HpApplicationRunnerImpl.contextMap.get("qcIsOn").equals(1)) {
            return ResultUtil.error("当前用户环节质控功能开启或者配置异常,详情咨询\"雕龙科技\"微信公众号!");
        }
        //检查质控系统是否开启,是否在注册期内,是否有环节质控功能
        String qcip = HpApplicationRunnerImpl.contextMap.get("qcip").toString();
        if (!SxdlFeignUtil.netIsOpen(SxdlFeignUtil.parseUrl(qcip))) {
            return ResultUtil.error("检测到 " + qcip + ",数据质控系统不可访问,请检查!");
        } else {
            return null;
        }
    }
}
