package com.sxdl.hp.service;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpHomepageDao;
import com.sxdl.hp.dao.dao1.HpVsch0ADao;
import com.sxdl.hp.dbo.AddrResult;
import com.sxdl.hp.dbo.ModelC;
import com.sxdl.hp.entity.*;
import com.sxdl.hp.util.AddressUtil;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpVsch0AService extends BaseUUIDServiceImpl<HpVsch0AEntity> {

    @Autowired
    HpVsch0ADao hpVsch0ADao;
    @Autowired
    HpHomepageDao hpHomepageDao;
    @Autowired
    HpBmVersionService hpBmVersionService;
    @Autowired
    HpBzdmkService hpBzdmkService;
    @Autowired
    HpVsch0BService hpVsch0BService;
    @Autowired
    HpVsch0CService hpVsch0CService;
    @Autowired
    HpVsch0EService hpVsch0EService;
    @Autowired
    HpFllowService hpFllowService;
    @Autowired
    HpVsch0PService hpVsch0PService;
    @Autowired
    HpVsch0FService hpVsch0FService;
    @Autowired
    HpVsch0HService hpVsch0HService;
    @Autowired
    HpVsch0KService hpVsch0KService;
    @Autowired
    HpVsWt47CfnewService hpVsWt47CfnewService;
    @Autowired
    HpVsch0SService hpVsch0SService;
    @Autowired
    HpCompService hpCompService;
    @Autowired
    HpClinicalPathwayService hpClinicalPathwayService;
    List<HpAreaZip> areas;
    Map<String, String> areamap;
    List<Map<String, String>> arealist;
    @Autowired
    HpHomepageService hpHomepageService;
    @Autowired
    HpKsService hpKsService;
    private String sql =
            "select " +
                    "CHYear as CHYear, \n" +
                    "CH0M00 as CH0A00, --住院号\n" +
                    "CH0M06 as CH0A06, --满1周岁年龄(岁)\n" +
                    "CH0M82 as CH0A82, -- 医疗付款方式\n" +
                    "CH0M81 as CH0M81, -- 健康卡号\n" +
                    "CH0MZYCS as CH0AZYCS, -- 住院次数\n" +
                    "CH0M01 as CH0A01, -- 病案号\n" +
                    "CH0M02 as CH0A02, -- 姓名\n" +
                    "CH0M03 as CH0A03, -- 性别\n" +
                    "CH0M04 as CH0A04, -- 出生日期\n" +
                    "CH0MN3 as CH0AN3, -- 入院体重\n" +
                    "CH0MA1 as CH0AA1, --年龄单位\n" +
                    "CH0MA2 as CH0AA2, -- 国籍\n" +
                    "CH0M10 as CH0A10, -- 民族\n" +
                    "CH0M05 as CH0A05, -- 身份证号\n" +
                    "CH0M08 as CH0A08, -- 职业\n" +
                    "CH0M07 as CH0A07, -- 婚姻\n" +
                    "HPCSD_sheng, --出生地省名称\n" +
                    "HPCSD_sheng_dm, --出生地省区划代码\n" +
                    "HPCSD_shi, --出生地市名称\n" +
                    "HPCSD_shi_dm, --出生地市区划代码\n" +
                    "HPCSD_xian, --出生地县名称\n" +
                    "HPCSD_xian_dm, --出生地县区划代码\n" +
                    "HPCSD_addr, --出生地详细地址\n" +
                    "CH0MN7 as CH0AN7, --出生地电话\n" +
                    // "CH0MN8 as CH0AN8, --出生地邮编\n" +
                    "HPHK_sheng, --户口地址省名称\n" +
                    "HPHK_sheng_dm, --户口地址省区划代码\n" +
                    "HPHK_shi, --户口地址市名称\n" +
                    "HPHK_shi_dm, --户口地址市区划代码\n" +
                    "HPHK_xian, --户口地址县名称\n" +
                    "HPHK_xian_dm, --户口地址县区划代码\n" +
                    "HPHK_addr, --户口地址详细地址\n" +
                    "CH0M11 as CH0A11, --户口电话\n" +
                    "CH0M14 as CH0A14, --户口邮编\n" +
                    "HPXZZ_sheng, --现住址省名称\n" +
                    "HPXZZ_sheng_dm, --现住址省区划代码\n" +
                    "HPXZZ_shi, --现住址市名称\n" +
                    "HPXZZ_shi_dm, --现住址市区划代码\n" +
                    "HPXZZ_xian, --现住址县名称\n" +
                    "HPXZZ_xian_dm, --现住址县区划代码\n" +
                    "HPXZZ_addr, --现住址详细地址\n" +
                    "CH0MN7 as CH0AN7, -- 现住址电话\n" +
                    "CH0MN8 as CH0AN8, -- 现住址邮政编码\n" +
                    "CH0MA3 as CH0AA3, -- 工作单位及地址\n" +
                    "CH0MA5 as CH0AA5, -- 工作单位电话\n" +
                    "CH0MA4 as CH0AA4, -- 工作单位邮政编码\n" +
                    "HPLXR_sheng, --联系人省名称\n" +
                    "HPLXR_sheng_dm, --联系人省区划代码\n" +
                    "HPLXR_shi, --联系人市名称\n" +
                    "HPLXR_shi_dm, --联系人市区划代码\n" +
                    "HPLXR_xian, --联系人县名称\n" +
                    "HPLXR_xian_dm, --联系人县区划代码\n" +
                    "HPLXR_addr, --联系人详细地址\n" +
                    "CH0M15 as CH0A15, -- 联系人姓名\n" +
                    "CH0M16 as CH0A16, -- 联系人关系\n" +
                    "CH0M19 as CH0A19, -- 联系人电话\n" +
                    "CH0M56 as CH0A56, -- 入院途径\n" +
                    "CH0M24 as CH0A24, -- 入院时间\n" +
                    "CH0M21 as CH0A21, -- 入院科别\n" +
                    "CH0M22 as CH0A22, -- 转科科别\n" +
                    "CH0MNA as CH0ANA, -- 入院病房\n" +
                    "CH0M27 as CH0A27, -- 出院时间\n" +
                    "CH0M23 as CH0A23, -- 出院科别\n" +
                    "CH0MNB as CH0ANB, -- 出院病房\n" +
                    "CH0M29 as CH0A29, -- 实际住院(天)\n" +
                    "CH0M59 as CH0A59, -- 编码员\n" +
                    "(select zdbz.name from hp_zdbz zdbz where zdbz.type=0  and (zdbz.code =upper(isnull(a.CH0M36,'')) or zdbz.use_dm=upper(isnull(a.CH0M36,'')))) AS CH0A36_desc, -- 门（急）诊诊断名称(西医诊断)\n" +
                    "(select zdbz.code from hp_zdbz zdbz where zdbz.type=0  and (zdbz.code =upper(isnull(a.CH0M36,'')) or zdbz.use_dm=upper(isnull(a.CH0M36,'')))) as CH0A36,-- 门（急）诊诊断编码(西医诊断)\n" +
                    "(select zdbz.name from hp_zdbz zdbz where zdbz.type=3  and (zdbz.code =upper(isnull(a.CH0M79,'')) or zdbz.use_dm=upper(isnull(a.CH0M79,'')))) as CH0ASS, -- 损伤、中毒外部原因名称\n" +
                    "(select zdbz.code from hp_zdbz zdbz where zdbz.type=3  and (zdbz.code =upper(isnull(a.CH0M79,'')) or zdbz.use_dm=upper(isnull(a.CH0M79,'')))) as CH0A79, -- 损伤、中毒外部原因编码\n" +
                    "(select zdbz.name from hp_zdbz zdbz where zdbz.type=2  and (zdbz.code =upper(isnull(a.CH0M77,'')) or zdbz.use_dm=upper(isnull(a.CH0M77,'')))) as CH0ACK, -- 病理诊断名称\n" +
                    "(select zdbz.code from hp_zdbz zdbz where zdbz.type=2  and (zdbz.code =upper(isnull(a.CH0M77,'')) or zdbz.use_dm=upper(isnull(a.CH0M77,'')))) as CH0A77, -- 病理诊断编码\n" +
                    "CH0MHBL1 as CH0AHBL1, -- 病理号\n" +
                    "CH0M52 as CH0A52, -- 有无药物过敏\n" +
                    "CH0MAA as CH0AAA, -- 过敏药物名称\n" +
                    "CH0MNC as Ch0ANC, -- 死亡患者尸检\n" +
                    "CH0M45 as CH0A45, -- ABO血型\n" +
                    "CH0MC5 as CH0AC5, -- Rh血型\n" +
                    "CH0MB1 as CH0AB1, -- 科主任\n" +
                    "CH0MB1DM as CH0AB1DM, -- 科主任代码\n" +
                    "CH0M32 as CH0A32, -- 主任（副主任）医师\n" +
                    "CH0M32DM as CH0A32DM, -- 主任（副主任）医师代码\n" +
                    "CH0M33 as CH0A33, -- 主治医师\n" +
                    "CH0M33DM as CH0A33DM, -- 主治医师代码\n" +
                    "CH0M34 as CH0A34, -- 住院医师\n" +
                    "CH0M34DM as CH0A34DM, -- 住院医师代码\n" +
                    "CH0MND as CH0AND, -- 责任护士\n" +
                    "CH0MNDDM as CH0ANDDM, -- 责任护士代码\n" +
                    "CH0MB2 as CH0AB2, -- 进修医师\n" +
                    "CH0MB2DM as CH0AB2DM, -- 进修医师代码\n" +
                    "CH0MB4 as CH0AB4, -- 实习医师\n" +
                    "CH0MB4DM as CH0AB4DM, -- 实习医师代码\n" +
                    "CH0M51 as CH0A51, -- 病案质量\n" +
                    "CH0MB5 as CH0AB5, -- 质控医师\n" +
                    "CH0MB5DM as CH0AB5DM, -- 质控医师代码\n" +
                    "CH0M69 as CH0A69, -- 质控护士\n" +
                    "CH0M69DM as CH0A69DM, -- 质控护士代码\n" +
                    "isnull(CH0MB6,ch0m27) as CH0AB6, -- 质控日期\n" +
                    "CH0MNE as CH0ANE, -- 离院方式\n" +
                    "CH0MNF as CH0ANF, -- 医嘱转院，拟接收医疗机构名称\n" +
                    "CH0MNF as CH0ANF2, -- 医嘱转社区卫生服务机构，拟接收医疗机构名称\n" +
                    "CH0MNG as CH0ANG, -- 是否有出院31天内再住院计划\n" +
                    "CH0MNH as CH0ANH, -- 目的\n" +
                    "CH0MNI as CH0ANI, -- 颅脑损伤患者昏迷入院前时间（天)\n" +
                    "CH0MNJ as CH0ANJ, -- 小时\n" +
                    "CH0MNK as CH0ANK, -- 分钟\n" +
                    "CH0MNL as CH0ANL, -- 颅脑损伤患者昏迷时间天\n" +
                    "CH0MNM as CH0ANM, -- 小时\n" +
                    "CH0MNN as CH0ANN, -- 分钟\n" +
                    "CH0M81 as CH0A81, -- 健康卡号 \n" +
                    "JG_sheng , --籍贯省 \n" +
                    "JG_sheng_dm, --籍贯省代码\n" +
                    "JG_shi, --籍贯市\n" +
                    "JG_shi_dm, --籍贯市代码\n" +
                    "CH0MJZLSH as CH0AJZLSH, --就诊流水号\n" +
                    "CH0MNP as CH0ANP, --治疗类别\n" +
                    "CH0M55 as CH0A55, --治疗类别_中医\n" +
                    "CH0M05A as CH0A05A, --身份证件类型\n" +
                    "Ch0MNR as Ch0ANR, --使用中医诊疗设备\n" +
                    "Ch0MNS as Ch0ANS, --使用中医诊疗技术\n" +
                    "Ch0MNT as Ch0ANT, --辨证施护\n" +
                    "Ch0MNQ as Ch0ANQ, --实施临床路径名称\n" +
                    "CH0M70 as CH0A70, --自制中药制剂\n" +
                    "CH0MN2 as CH0AN2, --出生体重\n" +
                    "CH0MAB as CH0AAB, --其他医疗机构转入名称\n" +
                    "CH0MN1 as CH0AN1, --年龄(月)\n" +
                    "1 as status --状态默认是已归档\n" +
                    "from dcLinkvsch_PatientInfo a " +
                    "where CHYear='@@@' and CH0M01='!!!' order by CH0A27 ";
    @Autowired
    private ZipService zipService;
    private String pTableName;
    private HpHospiatlInfo hpHospiatlInfo;

    /**
     * 查询a表相关信息
     */
    public HpVsch0AEntity findAForInit(String year, String bah, String hiscode, String dcLink) {
        List<HpVsch0AEntity> list = selectListWithSQL(sql.replaceAll("@@@", year).replaceAll("dcLink", dcLink)
                .replaceAll("!!!", bah), HpVsch0AEntity.class);
        if (CollUtil.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 将户口,出生地,现住址,联系人,工作单位,籍贯地址处理成标准行政区划
     * 更新国籍简拼,国籍名称信息
     */
    public HpVsch0AEntity getStandardArea(HpVsch0AEntity entityA) {
        AddressUtil addressUtil = AddressUtil.build();
        AddrResult addrResult;
        String detail,zip;
        HpAreaZip addr;
        //户口地址
        //省市县代码有空,且详细地址不空
        if (StringUtil.isNotEmpty(entityA.getHPHK_addr())) {
            if (StringUtil.isEmpty(entityA.getHPHK_sheng_dm()) || StringUtil.isEmpty(entityA.getHPHK_shi_dm()) || StringUtil.isEmpty(entityA.getHPHK_xian_dm())) {
                addrResult = addressUtil.addrResolutPro(entityA.getHPHK_addr());
                addr = addrResult.getArea();
                detail = addrResult.getDetail();
                if (null != addr) {
                    entityA.setHPHK_sheng_dm(addr.getSheng_code());
                    entityA.setHPHK_sheng(addr.getSheng());
                    entityA.setHPHK_shi_dm(addr.getShi_code());
                    entityA.setHPHK_shi(addr.getShi());
                    entityA.setHPHK_xian_dm(addr.getXian_code());
                    entityA.setHPHK_xian(addr.getXian());
                    entityA.setHPHK_addr(detail);
                    zip=entityA.getCH0A14();
                    if(null!=addr&&( StrUtil.isBlankOrUndefined(zip)||zip.length()!=6)){
                       entityA.setCH0A14(addr.getZip());
                   }
                }
            } else if (StrUtil.isNotEmpty(entityA.getHPHK_xian())) {
                if (entityA.getHPHK_addr().contains(entityA.getHPHK_xian())) {
                    entityA.setHPHK_addr(AddressUtil.getDetail(entityA.getHPHK_addr(), entityA.getHPHK_xian()));
                }
            }
        }
        //现住址
        if (StringUtil.isNotEmpty(entityA.getHPXZZ_addr())) {
            if (StringUtil.isEmpty(entityA.getHPXZZ_sheng_dm()) || StringUtil.isEmpty(entityA.getHPXZZ_shi_dm()) || StringUtil.isEmpty(entityA.getHPXZZ_xian_dm())) {
                addrResult = addressUtil.addrResolutPro(entityA.getHPXZZ_addr());
                addr = addrResult.getArea();
                detail = addrResult.getDetail();
                if (null != addr) {
                    entityA.setHPXZZ_sheng_dm(addr.getSheng_code());
                    entityA.setHPXZZ_sheng(addr.getSheng());
                    entityA.setHPXZZ_shi_dm(addr.getShi_code());
                    entityA.setHPXZZ_shi(addr.getShi());
                    entityA.setHPXZZ_xian_dm(addr.getXian_code());
                    entityA.setHPXZZ_xian(addr.getXian());
                    entityA.setHPXZZ_addr(detail);
                    zip=entityA.getCh0AN8();
                    if(null!=addr&&( StrUtil.isBlankOrUndefined(zip)||zip.length()!=6)){
                        entityA.setCh0AN8(addr.getZip());
                    }
                }
            } else if (StrUtil.isNotEmpty(entityA.getHPXZZ_xian())) {
                if (entityA.getHPXZZ_addr().contains(entityA.getHPXZZ_xian())) {
                    entityA.setHPXZZ_addr(AddressUtil.getDetail(entityA.getHPXZZ_addr(), entityA.getHPXZZ_xian()));
                }
            }
        }
        //籍贯
        if ((StringUtil.isEmpty(entityA.getJG_sheng_dm()) || StringUtil.isEmpty(entityA.getJG_shi_dm())) && StringUtil.isNotEmpty(entityA.getJG_shi())) {
            addrResult = addressUtil.addrResolutPro(entityA.getJG_shi());
            addr = addrResult.getArea();
            if (null != addr) {
                entityA.setJG_sheng_dm(addr.getSheng_code());
                entityA.setJG_sheng(addr.getSheng());
                entityA.setJG_shi_dm(addr.getShi_code());
                entityA.setJG_shi(addr.getShi());
            }
        }
        //联系人地址
        if (StringUtil.isNotEmpty(entityA.getHPLXR_addr())) {
            if (StringUtil.isEmpty(entityA.getHPLXR_sheng_dm()) || StringUtil.isEmpty(entityA.getHPLXR_shi_dm()) || StringUtil.isEmpty(entityA.getHPLXR_xian_dm())) {
                addrResult = addressUtil.addrResolutPro(entityA.getHPLXR_addr());
                addr = addrResult.getArea();
                detail = addrResult.getDetail();
                if (null != addr) {
                    entityA.setHPLXR_sheng_dm(addr.getSheng_code());
                    entityA.setHPLXR_sheng(addr.getSheng());
                    entityA.setHPLXR_shi_dm(addr.getShi_code());
                    entityA.setHPLXR_shi(addr.getShi());
                    entityA.setHPLXR_xian_dm(addr.getXian_code());
                    entityA.setHPLXR_xian(addr.getXian());
                    entityA.setHPLXR_addr(detail);
                }
            } else if (StrUtil.isNotEmpty(entityA.getHPLXR_xian())) {
                if (entityA.getHPLXR_addr().contains(entityA.getHPLXR_xian())) {
                    entityA.setHPLXR_addr(AddressUtil.getDetail(entityA.getHPLXR_addr(), entityA.getHPLXR_xian()));
                }
            }
        }
        //工作单位地址
        if (StringUtil.isNotEmpty(entityA.getCH0AA3())) {
            addrResult = addressUtil.addrResolutPro(entityA.getCH0AA3());
            addr = addrResult.getArea();
            zip=entityA.getCH0AA4();
            if(null!=addr&&( StrUtil.isBlankOrUndefined(zip)||zip.length()!=6)){
                entityA.setCH0AA4(addr.getZip());
            }
        }
        //出生地
        if (StringUtil.isNotEmpty(entityA.getHPCSD_addr())) {
            if (StringUtil.isEmpty(entityA.getHPCSD_sheng_dm()) || StringUtil.isEmpty(entityA.getHPCSD_shi_dm()) || StringUtil.isEmpty(entityA.getHPCSD_xian_dm())) {
                addrResult = addressUtil.addrResolutPro(entityA.getHPCSD_addr());
                addr = addrResult.getArea();
                detail = addrResult.getDetail();
                if (null != addr) {
                    entityA.setHPCSD_sheng_dm(addr.getSheng_code());
                    entityA.setHPCSD_sheng(addr.getSheng());
                    entityA.setHPCSD_shi_dm(addr.getShi_code());
                    entityA.setHPCSD_shi(addr.getShi());
                    entityA.setHPCSD_xian_dm(addr.getXian_code());
                    entityA.setHPCSD_xian(addr.getXian());
                    entityA.setHPCSD_addr(detail);
                }
            } else if (StrUtil.isNotEmpty(entityA.getHPCSD_xian())) {
                if (entityA.getHPCSD_addr().contains(entityA.getHPCSD_xian())) {
                    entityA.setHPCSD_xian(AddressUtil.getDetail(entityA.getHPCSD_addr(), entityA.getHPCSD_xian()));
                }
            }
        }
        //更新国籍名称和国籍简拼
        Map<Integer, List<SysDictVal>> bamaps = (Map<Integer, List<SysDictVal>>) HpApplicationRunnerImpl.contextMap.get("baMap");
        if (StringUtil.isNotEmpty(entityA.getCH0AA2())) {
            List<SysDictVal> sysDictVals = bamaps.get(121);
            sysDictVals = sysDictVals.stream().filter(e -> e.getVal().equals(entityA.getCH0AA2())).collect(Collectors.toList());
            if (sysDictVals.size() == 1) {
                entityA.setCH0AA2_jp(sysDictVals.get(0).getRemark());
                entityA.setCH0AA2_mc(sysDictVals.get(0).getName().split("-")[1]);
            }
        }
        return entityA;
    }

    /**
     * 录入界面初始化数据
     */
    public ResultUtil<?> findAllInit(String year, String bah) {
        //获取当前医院的默认中西医类型
        hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        String hiscode = hpHospiatlInfo.getHis_code();
        if (StringUtil.isEmpty(hiscode)) {
            return ResultUtil.error("医院信息未维护his厂商，请先维护医院信息");
        }
        pTableName = HpApplicationRunnerImpl.contextMap.get("fyTableName").toString();
        Map<String, Object> data = new HashMap<>();
        HpHospiatlInfo newh = ObjectUtil.cloneByStream(hpHospiatlInfo);
        newh.setColumnsCM(null);
        newh.setColumnsWM(null);
        data.put("hospital", newh);
        //给前端返回附表的标志，调用不同的省附页页面
        data.put("temp", pTableName);
        //如果病案号是空的，则认为是手工录入功能，返回前端空数据便于打开页面
        if (StringUtil.isEmpty(bah) || StringUtil.isEmpty(bah)) {
            data.put("A", new HpVsch0AEntity());
            data.put("B", new HpVsch0BEntity());
            data.put("C", null);
            data.put("E", null);
            data.put("K", new HpVsch0KEntity());
            data.put("H", new HpVsch0HEntity());
            data.put("S", null);
            data.put("NEW", new HpVsWt47CfnewEntity());
            data.put("F", new HpfllowEntity());
            data.put("P", null);
            data.put("SW", new HpVsch0FEntity());
            data = initAreas(null, data);
            return ResultUtil.success(data);
        }
        String dcLink = HpApplicationRunnerImpl.contextMap.get("dcLink").toString();
        //根据病案年度和病案号，查询中间库病人首页基本信息
        HpVsch0AEntity entityA = findAForInit(year, bah, hiscode, dcLink);
        if (null == entityA) {
            return ResultUtil.error("接口表中没有病人基本信息相关数据,请联系管理员！");
        }
        String mBah = hpVsch0ADao.selectMidWithNotInA(entityA.getCH0A01());
        if (StrUtil.isNotEmpty(mBah)) {//正常病案室操作数据,归档后录入
            //从satoken中取session,防止页面session过期导致数据空
            SysUser user = (SysUser) StpUtil.getSession().get("user");
            entityA.setCH0A59(user.getName());
            entityA.setCH0A59DM(user.getCode());
        }

//        Map<String, Date> usedQueue = (Map) HpApplicationRunnerImpl.contextMap.get("usedQueue");
        //判断锁定集合中是否有改病例
            /*if(usedQueue.containsKey(bah+year)){
                return ResultUtil.error("其他人正在操作该份病例,或者操作流程错误,请重新按照正确流程选择病例操作!等待30分钟后,将自动解锁");
            }*/
        //将该份病例放入锁定集合中
        // usedQueue.put(bah + year, new Date());//生产
        entityA.setZXFLAG(hpHospiatlInfo.getHomepage_type().toString());
        entityA.setJGMC(hpHospiatlInfo.getJgmc());
        entityA.setZZJGDM(hpHospiatlInfo.getJgdm());
        entityA.setZZJGDM2(hpHospiatlInfo.getJgdm2());
        Map<String, String> kss = hpKsService.findMapKs(1, null);

        String kscode = entityA.getCH0A23();
        kscode = StringUtil.isEmpty(kscode) ? "" : kscode;
        if (kss.containsKey(kscode)) {
            entityA.setCH0A23_mc(kss.get(kscode));
        }
        kscode = entityA.getCH0A21();
        kscode = StringUtil.isEmpty(kscode) ? "" : kscode;
        if (kss.containsKey(kscode)) {
            entityA.setCH0A21_mc(kss.get(kscode));
        }

        entityA = getStandardArea(entityA);
        data = initAreas(entityA, data);

        data.put("A", entityA);

        //根据病案年度和病案号，查询中间库病人费用信息
        HpVsch0BEntity entityB = hpVsch0BService.findBForInit(year, bah, hiscode, dcLink);
        if (null == entityB) {
            return ResultUtil.error("接口表中没有费用相关数据,请联系管理员！");
        }
        data.put("B", entityB);

        //根据病案年度和病案号，查询中间库病人诊断信息
        List<HpVsch0CEntity> ListEntityC = hpVsch0CService.findCForInit(year, bah, hiscode, dcLink);
        if (ListEntityC.size() > 0) {
            Collections.sort(ListEntityC, Comparator.comparing(HpVsch0CEntity::getCH0C02));
            data.put("C", ListEntityC);
        }

        //根据病案年度和病案号，查询中间库病人手术信息
        List<HpVsch0EEntity> ListEntityE = hpVsch0EService.findEForInit(year, bah, hiscode, dcLink);
        if (null != ListEntityE && ListEntityE.size() > 0) {
            Collections.sort(ListEntityE, Comparator.comparing(HpVsch0EEntity::getCH0E07));
            data.put("E", ListEntityE);
        }

        //根据病案年度和病案号，查询中间库病人中医相关信息
        HpVsch0KEntity entityK = hpVsch0KService.findKForInit(year, bah, hiscode, dcLink);
        data.put("K", null == entityK ? new HpVsch0KEntity() : entityK);

        //根据病案年度和病案号，查询中间库病人输血/输液相关信息
        HpVsch0HEntity entityH = hpVsch0HService.findHForInit(year, bah, hiscode, dcLink);
        data.put("H", null == entityH ? new HpVsch0HEntity() : entityH);

        //根据病案年度和病案号，查询中间库重症信息
        List<HpVsch0SEntity> listEntityS = hpVsch0SService.findSForInit(year, bah, hiscode, dcLink);
        data.put("S", CollUtil.isEmpty(listEntityS) ? new ArrayList() : listEntityS);

        //根据病案年度和病案号，查询中间库新生儿信息
        HpVsWt47CfnewEntity entityNEW = hpVsWt47CfnewService.findWt47ForInit(year, bah, hiscode, dcLink);
        data.put("NEW", null == entityNEW ? new HpVsWt47CfnewEntity() : entityNEW);

        //根据病案年度和病案号，查询中间库病人附页信息
        HpfllowEntity entityF = hpFllowService.findDlfollowForInit(year, bah, hiscode, dcLink);
        data.put("F", null == entityF ? new HpfllowEntity() : entityF);

        //根据病案年度和病案号，查询病人死亡信息
        HpVsch0FEntity entitySW = hpVsch0FService.findFForInit(year, bah, hiscode, dcLink);
        data.put("SW", null == entitySW ? new HpVsch0FEntity() : entitySW);

        //根据病案年度和病案号，查询省附页信息
        List<Map<String, Object>> maps = hpVsch0PService.findSFY(year, bah, dcLink);
        data.put("P", CollUtil.isEmpty(maps) ? new HashMap<>() : maps.get(0));

        return ResultUtil.success(data);
    }

    public HpVsch0AEntity findByBano(String year, String bah, Integer zycs) {
        HpVsch0AEntity entity = new HpVsch0AEntity();
        entity.setCHYear(year);
        entity.setCH0A01(bah);
        entity.setCH0AZYCS(zycs);
        entity = hpVsch0ADao.selectOne(entity);
        return entity;
    }

    public void saveHomepage(HomepageEntity home) {
        hpHomepageDao.insertSelective(home);
    }

    public void update(HomepageEntity home) {
        hpHomepageDao.updateByPrimaryKey(home);
    }

    public HomepageEntity select(HomepageEntity home) {
        return hpHomepageDao.selectOne(home);
    }

    /**
     * 更改病案状态
     */
    public void changeStatus(String Aid, String status) {
        if (!"".equals(Aid) && null != Aid) {
            HpVsch0AEntity entity = hpVsch0ADao.selectByPrimaryKey(Aid);
            entity.setSTATUS(status);
            hpVsch0ADao.updateByPrimaryKey(entity);

            HomepageEntity homepage = hpHomepageDao.selectByAid(Aid);
            homepage.setSTATUS(status);
            hpHomepageDao.updateByPrimaryKeySelective(homepage);
        }
    }

    /**
     * 根据aid查询homepageid
     */
    public String findHomePageIDByAId(String id) {
        return hpHomepageDao.selectHid(id);
    }

    /**
     * 根据病案号查询aid
     */
    public String findAIDByBah(String id) {
        return hpHomepageDao.selectAid(id);
    }

    public ResultUtil updateBano(String id, String newBano, Integer newZycs) {
        HpVsch0AEntity entityA = findById(id);
        if (null == entityA) {
            return ResultUtil.error("修改失败！");
        } else {
            String oldBAH = entityA.getCH0A01(), tableName = "";
            entityA.setCH0AZYCS(newZycs);
            entityA.setCH0A01(newBano);
            this.update(entityA);
            hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
            //开始获取医院当地的附页表名称
            if (StringUtil.isNotEmpty(hpHospiatlInfo.getId())) {
                if (hpHospiatlInfo.getIsEqual() == 1) {
                    tableName = hpHospiatlInfo.getChinese_medicine();
                } else {
                    if ("1".equals(entityA.getZXFLAG())) {
                        tableName = hpHospiatlInfo.getChinese_medicine();
                    } else if ("2".equals(entityA.getZXFLAG())) {
                        tableName = hpHospiatlInfo.getWestern_medicine();
                    }
                }
            }
            //同步更新费用,诊断,手术,输血输液,中医,重症,死亡,省附页,院内附页,排除上报,质控结果,大表
            String mysql = "update vsch0B set  ch0B01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update vsch0C set  ch0C01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update vsch0E set  ch0E01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update vsch0H set  ch0H01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update vsch0K set  ch0K01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update vsch0S set  ch0S01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update vsch0F set  ch0F01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update " + tableName + " set  ch0p01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update dl_fllow set  CH0A01='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update VsWT47_CFNew set  WT4701='" + newBano + "'  where A_ID ='" + id + "'\n" +
                    "update hp_data_cancel set hp_bah='" + newBano + "' where hp_aid='" + id + "'\n" +
                    "update hp_qm_pf_result set bah='" + newBano + "' where bah='" + oldBAH + "'\n" +
                    "update hp_qm_result set bah='" + newBano + "' where bah='" + oldBAH + "'\n" +
                    "update hp_qm_pf_result_record set bah='" + newBano + "' where bah='" + oldBAH + "'\n" +
                    "update homepage set bah='" + newBano + "',zycs='" + newZycs + "' where A_ID ='" + id + "'\n";
            this.updateSqlWithSQL(mysql);
            return ResultUtil.success("修改成功！");
        }
    }

    /**
     * 查询疾病,手术,中医编码列表通用方法
     * 返回30条数据;支持中文模糊查询;支持拼音首字母查询;使用编码,中文长度排序
     *
     * @param type "0",疾病编码; "1",手术编码; "2";//损伤编码;  "3";//肿瘤编码;  "4";//中医编码
     * @param name 可以传入汉字拼音首字母,汉字,编码
     */
    public ResultUtil getDmkInfos(String type, String name) {
        if (StrUtil.isEmpty(name) || (StrUtil.isEmpty(name) && StrUtil.isEmpty(type))) {
            return ResultUtil.success(new ArrayList<Map<String, Object>>());
        }
        name = name.toUpperCase();
        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        String tname = "select top 30 code,name from hp_zdbz";
        if (StrUtil.isEmpty(type)) {//查询手术,需要处理的
            type = "1";//查询手术编码
            tname = "select top 30 code,name,ssdj,iscz from hp_ssbz";
        }
        if ("4".equals(type)) {//查询中医,需要处理的
            tname = "select top 30 code,name from  hp_zybz";
        }
        //支持页面模糊搜索,以%分割之前的字符做为开头
        if (name.contains("%")) {
            name = "%&" + name + "%";
        } else {
            name = "%" + name + "%";
        }
        return ResultUtil.success(hpBzdmkService.selectSqlWithSQL(tname + " where type='" + type + "' and query like '" + name + "' order by len(name),len(code),code"));
    }

    /**
     * 打开修改页面,需要查询的数据
     */
    public ResultUtil findOneBa(String id) {
        hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        pTableName = HpApplicationRunnerImpl.contextMap.get("fyTableName").toString();
        Map<String, Object> data = new HashMap<>();
        data.put("hospital", hpHospiatlInfo);
        //给前端返回附表的标志，调用不同的省附页页面
        data.put("temp", pTableName);

        //根据ID查询病人首页基本信息
        HpVsch0AEntity entityA = findById(id);
        data.put("A", null == entityA ? new HpVsch0AEntity() : entityA);

//        Map<String, Date> usedQueue = (Map) HpApplicationRunnerImpl.contextMap.get("usedQueue");
//        //判断锁定集合中是否有改病例
//        if (usedQueue.containsKey(entityA.getCH0A01() + entityA.getCHYear())) {
//            return ResultUtil.error("其他人正在操作该份病例,或者操作流程错误,请重新按照正确流程选择病例操作!等待30分钟后,将自动解锁");
//        }
        data = initAreas(entityA, data);
        //根据病案年度和病案号，查询省附页信息
        List<Map<String, Object>> maps = selectSqlWithSQL("select * from " + pTableName + " where  A_ID='" + entityA.getID() + "' ");
        data.put("P", CollUtil.isEmpty(maps) ? null : maps.get(0));

        //根据ID查询病人总表信息
        String homID = findHomePageIDByAId(id);
        data.put("homID", homID);

        //根据病案年度和病案号，查询病人费用信息
        HpVsch0BEntity entityB = new HpVsch0BEntity();
        entityB.setA_ID(entityA.getID());
        entityB = hpVsch0BService.selectOne(entityB);
        data.put("B", null == entityB ? new HpVsch0BEntity() : entityB);

        //根据病案年度和病案号，查询病人诊断信息
        HpVsch0CEntity entityC = new HpVsch0CEntity();
        entityC.setA_ID(entityA.getID());
        List<HpVsch0CEntity> ListEntityC = hpVsch0CService.select(entityC);
        if (ListEntityC.size() > 0) {
            Collections.sort(ListEntityC, Comparator.comparing(HpVsch0CEntity::getCH0C02));
            data.put("C", ListEntityC);
        } else {
            data.put("C", null);
        }

        //根据病案年度和病案号，查询病人手术信息
        HpVsch0EEntity entityE = new HpVsch0EEntity();
        entityE.setA_ID(entityA.getID());
        List<HpVsch0EEntity> ListEntityE = hpVsch0EService.select(entityE);
        if (ListEntityE.size() > 0) {
            Collections.sort(ListEntityE, Comparator.comparing(HpVsch0EEntity::getCH0E07));
            data.put("E", ListEntityE);
        } else {
            data.put("E", null);
        }

        //A表ID查询输血输液信息
        HpVsch0HEntity entityH = new HpVsch0HEntity();
        entityH.setA_ID(entityA.getID());
        entityH = hpVsch0HService.selectOne(entityH);
        data.put("H", null == entityH ? new HpVsch0HEntity() : entityH);

        //A表ID查询中医信息
        HpVsch0KEntity entityK = new HpVsch0KEntity();
        entityK.setA_ID(entityA.getID());
        entityK = hpVsch0KService.selectOne(entityK);
        data.put("K", null == entityK ? new HpVsch0KEntity() : entityK);

        //A表ID查询重症信息
        HpVsch0SEntity entityS = new HpVsch0SEntity();
        entityS.setA_ID(entityA.getID());
        List<HpVsch0SEntity> listEntityS = hpVsch0SService.select(entityS);
        data.put("S", CollUtil.isEmpty(listEntityS) ? null : listEntityS);

        //A表ID查询新生儿信息
        HpVsWt47CfnewEntity entityNEW = new HpVsWt47CfnewEntity();
        entityNEW.setA_ID(entityA.getID());
        entityNEW = hpVsWt47CfnewService.selectOne(entityNEW);
        data.put("NEW", null == entityNEW ? new HpVsWt47CfnewEntity() : entityNEW);

        //A表ID查询死亡信息
        HpVsch0FEntity entitySW = new HpVsch0FEntity();
        entitySW.setA_ID(entityA.getID());
        entitySW = hpVsch0FService.selectOne(entitySW);
        data.put("SW", null == entitySW ? new HpVsch0FEntity() : entitySW);

        //根据病案年度和病案号，查询病人附页信息
        HpfllowEntity entityF = new HpfllowEntity();
        entityF.setA_ID(entityA.getID());
        entityF = hpFllowService.selectOne(entityF);
        data.put("F", null == entityF ? new HpfllowEntity() : entityF);

        return ResultUtil.success(data);
    }

    /**
     * 初始化行政区划以及其他下拉框内容
     */
    public Map<String, Object> initAreas(HpVsch0AEntity entityA, Map<String, Object> data) {
        //附页中的临床路径名称下拉框
        data.put("pathway", hpClinicalPathwayService.selectSelectsIfON());
        //附页中的并发症名称下拉框
        data.put("bfz", hpCompService.selectSelectsIfON());
        //病案首页用到的字典
        data.put("DIC", ApplicationRunnerImpl.contextMap.get("baMapSimple"));
        //已经开启的科室
        data.put("ksList", hpKsService.findKsByType(1, null));
        if (null == entityA) {
            return data;
        }
        data.put("hkshi", getChildAreas(entityA.getHPHK_sheng_dm(), true));
        data.put("hkxian", getChildAreas(entityA.getHPHK_shi_dm(), false));
        data.put("csdshi", getChildAreas(entityA.getHPCSD_sheng_dm(), true));
        data.put("csdxian", getChildAreas(entityA.getHPCSD_shi_dm(), false));
        data.put("xzzshi", getChildAreas(entityA.getHPXZZ_sheng_dm(), true));
        data.put("xzzxian", getChildAreas(entityA.getHPXZZ_shi_dm(), false));
        data.put("jgshi", getChildAreas(entityA.getJG_sheng_dm(), true));
        data.put("lxrshi", getChildAreas(entityA.getHPLXR_sheng_dm(), true));
        data.put("lxrxian", getChildAreas(entityA.getHPLXR_shi_dm(), false));
        return data;
    }

    /**
     * 根据上级code查询下级列表
     *
     * @param area 父级code
     * @param flag 是否查下级市,否则查下级县
     * @return 下级列表, 并简化处理, 减少数据传输
     */
    public List<Map<String, String>> getChildAreas(String area, boolean flag) {
        if (StringUtil.isNotEmpty(area)) {
            if (flag) {//查市
                areas = zipService.findCityByProId(area);
            } else {//查县
                areas = zipService.findCountyByCityId(area);
            }
        } else {
            areas = new ArrayList<>();
        }
        arealist = new ArrayList<>();
        areas.forEach(e -> {
            areamap = new HashMap<>();
            areamap.put("name", e.getName());
            areamap.put("code", e.getCode());
            if (!flag) {
                areamap.put("zip", e.getZip());
            }
            arealist.add(areamap);
        });
        return arealist;
    }

    /**
     * 通过病案号查询a表id
     */
    public Object getAidByBah(String bah) {
        String sqls = "select top 1 id from vsch0a where ch0a01='" + bah + "'";
        List<Map<String, Object>> maps = selectSqlWithSQL(sqls);
        return CollUtil.isEmpty(maps) ? null : maps.get(0).get("id");
    }

    /**
     * 查询接口表中有数据,A表没有数据
     *
     * @return
     */
    public List<Map<String, Object>> selectInterfaceWithNotInA(String start, String end) {
        return selectSqlWithSQL("select ch0m01,chyear from " + HpApplicationRunnerImpl.contextMap.get("dcLink").toString() + "vsch_PatientInfo " +
                "where ch0m01 not in (select ch0a01 from vsch0a where ch0a27 between '" + start + "' and '" + end + "')" +
                " and ch0m27 between '" + start + "' and '" + end + "'");
    }

    /**
     * 批量保存数据,批量保存到homepage表
     * 1 旧病案数据,需要将对应数据抽到正式表abcde...中
     * 2 接口中数据,需要将对应数据抽到接口表vsch_patientinfo...中,批量保存到abcde....中
     */
    public ResultUtil mergeOldBa(String stardate, String enddate, HpHospiatlInfo hospital) {
        if (StrUtil.isEmpty(enddate) || !DateUtil.isDate(enddate)) {
            return ResultUtil.error("请核实时间参数!");
        }
        enddate = DateUtil.endOfDay(DateUtil.parse(enddate)).toString();
        String Aid = "", bah = "", year = "", hisCode = hospital.getHis_code(), kscode = "", detail = "";
        Map<String, String> errList = new HashMap<>();
        pTableName = HpApplicationRunnerImpl.contextMap.get("fyTableName").toString();
//        从satoken中取session,防止页面session过期导致数据空
        SysUser user = (SysUser) StpUtil.getSession().get("user");
        Map<String, String> kss = hpKsService.findMapKs(1, null);
        ModelC data = new ModelC();
        HpVsch0AEntity entityA;
        HpVsch0BEntity entityB;
        HpVsch0KEntity entityK;
        HpVsch0HEntity entityH;
        HpVsch0CEntity entityC;
        HpVsch0EEntity entityE;
        HpVsch0SEntity entityS;
        HomepageEntity homepages = new HomepageEntity();
        List<HpVsch0EEntity> entityEList, eList;
        List<HpVsch0CEntity> entityCList, cList;
        List<HpVsch0SEntity> listEntityS;
        HpVsWt47CfnewEntity entityNEW;
        HpfllowEntity entityF;
        HpVsch0FEntity entitySW;
        List<Map<String, Object>> mapsfy;
        ResultUtil rst;
        //更新国籍名称和国籍简拼
        Map<Integer, List<SysDictVal>> dictmap = (Map<Integer, List<SysDictVal>>) HpApplicationRunnerImpl.contextMap.get("baMap");
        //1.查询出A表中有的数据，但是homepage中没有的A表数据,旧病案数据
        List<HpVsch0AEntity> maps = hpVsch0ADao.selectAWithNotInHomepage(stardate, enddate);
        if (CollUtil.isEmpty(maps)) {//如果旧病案没有数据则去批量保存接口表中数据
            List<Map<String, Object>> notInA = selectInterfaceWithNotInA(stardate, enddate);
            String dcLink = HpApplicationRunnerImpl.contextMap.get("dcLink").toString();
            if (CollUtil.isEmpty(notInA)) {
                return ResultUtil.success("当前时间段没没有数据可以操作!");
            }
            for (Map<String, Object> baInfo : notInA) {
                bah = baInfo.get("ch0m01").toString();
                year = baInfo.get("chyear").toString();
                data = new ModelC();
                //根据病案年度和病案号，查询中间库病人首页基本信息
                entityA = findAForInit(year, bah, hisCode, dcLink);
                if (null == entityA) {
                    errList.put(bah, "基本数据欠缺!");
                }
                if (null != user) {
                    entityA.setCH0A59(StrUtil.emptyToDefault(user.getName(), ""));
                    entityA.setCH0A59DM(StrUtil.emptyToDefault(user.getCode(), ""));
                }
                entityA.setZXFLAG(hpHospiatlInfo.getHomepage_type().toString());
                entityA.setJGMC(hpHospiatlInfo.getJgmc());
                entityA.setZZJGDM(hpHospiatlInfo.getJgdm());
                entityA.setZZJGDM2(hpHospiatlInfo.getJgdm2());

                kscode = StringUtil.emptyToDefault(entityA.getCH0A23(), "");
                if (kss.containsKey(kscode)) {
                    entityA.setCH0A23_mc(kss.get(kscode));
                }
                kscode = entityA.getCH0A21();
                kscode = StringUtil.isEmpty(kscode) ? "" : kscode;
                if (kss.containsKey(kscode)) {
                    entityA.setCH0A21_mc(kss.get(kscode));
                }

                data.setA(getStandardArea(entityA));
                //根据病案年度和病案号，查询中间库病人费用信息
                entityB = hpVsch0BService.findBForInit(year, bah, hisCode, dcLink);
                if (null == entityB) {
                    errList.put(bah, StrUtil.emptyToDefault(errList.get(bah), "") + ",费用数据欠缺!");
                }
                data.setB(entityB);

                //根据病案年度和病案号，查询中间库病人诊断信息
                entityCList = hpVsch0CService.findCForInit(year, bah, hisCode, dcLink);
                //if (null != ListEntityC && ListEntityC.size() > 0) data.put("C", ListEntityC);
                if (entityCList.size() > 0) {
                    Collections.sort(entityCList, Comparator.comparing(HpVsch0CEntity::getCH0C02));
                    data.setC(entityCList);
                } else {
                    errList.put(bah, StrUtil.emptyToDefault(errList.get(bah), "") + ",诊断数据欠缺!");
                }

                //根据病案年度和病案号，查询中间库病人手术信息
                entityEList = hpVsch0EService.findEForInit(year, bah, hisCode, dcLink);
                if (null != entityEList && entityEList.size() > 0) {
                    Collections.sort(entityEList, Comparator.comparing(HpVsch0EEntity::getCH0E07));
                    data.setE(entityEList);
                }

                //根据病案年度和病案号，查询中间库病人中医相关信息
                entityK = hpVsch0KService.findKForInit(year, bah, hisCode, dcLink);
                data.setK(null == entityK ? new HpVsch0KEntity() : entityK);

                //根据病案年度和病案号，查询中间库病人输血/输液相关信息
                entityH = hpVsch0HService.findHForInit(year, bah, hisCode, dcLink);
                data.setH(null == entityH ? new HpVsch0HEntity() : entityH);

                //根据病案年度和病案号，查询中间库重症信息
                listEntityS = hpVsch0SService.findSForInit(year, bah, hisCode, dcLink);
                data.setS(CollUtil.isEmpty(listEntityS) ? new ArrayList<>() : listEntityS);

                //根据病案年度和病案号，查询中间库新生儿信息
                entityNEW = hpVsWt47CfnewService.findWt47ForInit(year, bah, hisCode, dcLink);
                data.setNEW(null == entityNEW ? new HpVsWt47CfnewEntity() : entityNEW);

                //根据病案年度和病案号，查询中间库病人附页信息
                entityF = hpFllowService.findDlfollowForInit(year, bah, hisCode, dcLink);
                data.setF(null == entityF ? new HpfllowEntity() : entityF);

                //根据病案年度和病案号，查询病人死亡信息
                entitySW = hpVsch0FService.findFForInit(year, bah, hisCode, dcLink);
                data.setSW(null == entitySW ? new HpVsch0FEntity() : entitySW);

                //根据病案年度和病案号，查询省附页信息
                mapsfy = hpVsch0PService.findSFY(year, bah, dcLink);
                if (null != mapsfy && mapsfy.size() > 0) {
                    Map<String, Object> map = mapsfy.get(0);
                    if (null == map) {
                        errList.put(bah, StrUtil.emptyToDefault(errList.get(bah), "") + ",省附页数据欠缺!");
                    } else {
                        data.setP(map);
                    }
                } else {
                    data.setP(null);
                }
                rst = hpHomepageService.saveCoreData(data, hospital);
                if ("errorr".equals(rst.getState())) {
                    errList.put(bah, StrUtil.emptyToDefault(errList.get(bah), "") + rst.getT().toString());
                }
            }
        } else {//旧病案数据
            Map mapEntity;
            long cfts;
            //2.遍历未合并的A表数据
            for (HpVsch0AEntity A : maps) {
                entityB = new HpVsch0BEntity();
                entityK = new HpVsch0KEntity();
                entityC = new HpVsch0CEntity();
                entityE = new HpVsch0EEntity();
                entityS = new HpVsch0SEntity();
                //2.1 根据A表和其他表的关联关系，查询掐他数据
                Aid = A.getID();
                entityB.setA_ID(Aid);
                entityK.setA_ID(Aid);
                entityC.setA_ID(Aid);
                entityE.setA_ID(Aid);
                entityS.setA_ID(Aid);
                //计算重返天数

                cfts = hpHomepageService.getCfts(A.getCH0AZYCS(), Aid);
                //组装数据  A
                A = getStandardArea(A);
                data.setA(A);
                //组装数据  B
                entityB = hpVsch0BService.selectOne(entityB);

                data.setB(null == entityB ? new HpVsch0BEntity() : entityB);
                //组装数据  K
                entityK = hpVsch0KService.selectOne(entityK);
                data.setK(null == entityK ? new HpVsch0KEntity() : entityK);
                //组装数据  C
                entityCList = hpVsch0CService.select(entityC);
                data.setC(entityCList);
                //组装数据  E
                entityEList = hpVsch0EService.select(entityE);
                //组装数据  S
                data.setS(hpVsch0SService.select(entityS));
                //2.2 合并总表
                try {
                    homepages = SingleToMain.convert(data, Aid, Integer.parseInt(String.valueOf(cfts)));
                } catch (Exception e) {
                    errList.put(homepages.getBah(), "");
                    continue;
                }
                saveHomepage(homepages);
                if (StrUtil.isEmpty(homepages.getId())) {
                    errList.put(homepages.getBah(), "");
                }
            }
        }
        return ResultUtil.success("保存成功!" + errList);
    }

    /**
     * 批量质控后,通过质控的数据变更数据
     *
     * @param start  病案开始
     * @param end    病案结束
     * @param qcid   批量质控批次id
     * @param qctime 批量质控时间
     */
    public void auditList(String start, String end, String qcid, String qctime) {
        if ((StrUtil.isEmpty(start) && StrUtil.isEmpty(end)) || StrUtil.isEmpty(qcid) || StrUtil.isEmpty(qctime)) {
            return;
        }
        end = DateUtil.endOfDay(DateUtil.parse(end)).toString();
        StringBuilder sb = new StringBuilder("select a.bah from homepage a \n" +
                "left join ( select distinct bah,time,case when isnull(b.can_forced,0)=1 then 1 else 2 end as status \n" +
                "from hp_link_result b where b.is_link=2 and  qc_id='");
        sb.append(qcid).append("' and qc_time='").append(qctime).append("') t on a.bah=t.bah and a.cysj=t.time  \n" +
                "where t.status=2 and a.cysj between '").append(start).append("'  and '").append(end).append("'");
        List<Map<String, Object>> maps = selectSqlWithSQL(sb.toString());
        if (CollUtil.isNotEmpty(maps)) {
            String bah;
            for (Map<String, Object> info : maps) {
                bah = info.get("bah").toString();
                sb = new StringBuilder("update homepage set status=4 where bah='");
                sb.append(bah).append("';update vsch0a set status=4 where ch0a01='")
                        .append(bah).append("'");
                selectSqlWithSQL(sb.toString());
            }
        }
    }
}
