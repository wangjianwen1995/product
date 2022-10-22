package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dbo.ModelC;
import com.sxdl.hp.entity.*;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SingleToMain {

    /**
     * 合并总表数据
     */
    public static HomepageEntity convert(ModelC data, String Aid, int cfts)  {
        HomepageEntity homepage = new HomepageEntity();
        HpVsch0AEntity entityA = data.getA();
        HpVsch0BEntity entityB = data.getB();
        HpVsch0KEntity entityK = data.getK();
        List<HpVsch0CEntity> ListEntityC = data.getC();
        List<HpVsch0EEntity> ListEntityE = data.getE();
        List<HpVsch0SEntity> ListEntityS = data.getS();
        int csize = ListEntityC.size();
        
        int esize =0;
        if(CollUtil.isNotEmpty(ListEntityE)){
            esize=ListEntityE.size();
        }
        int ssize = 0;
        if(CollUtil.isNotEmpty(ListEntityS)){
            ssize=ListEntityS.size();
        }

        //HpfllowEntity entityFlow = data.getF();

        /*
         * 计算术前住院天数以及术后住院天数
         * 1.术前住院天数：
         * 第一次手术时间-入院时间
         * 2.术后住院天数：
         * 出院时间-最后一次手术时间
         */
        Date minSsrq = esize >= 1 ? ListEntityE.stream().filter(e -> null != e.getCH0E11()).min(Comparator.comparing(HpVsch0EEntity::getCH0E11)).get().getCH0E11() : null;
        Date maxSsrq = esize >= 1 ? ListEntityE.stream().filter(e -> null != e.getCH0E11()).max(Comparator.comparing(HpVsch0EEntity::getCH0E11)).get().getCH0E11() : null;
        long sqzyts = 0L;
        long shzyts = 0L;
        if (minSsrq != null) {
            sqzyts = (minSsrq.getTime() - entityA.getCH0A24().getTime() + 1000000) / (60 * 60 * 24 * 1000);
            shzyts = (entityA.getCH0A27().getTime() - maxSsrq.getTime() + 1000000) / (60 * 60 * 24 * 1000);
        }

        homepage.setSQZYTS(Integer.parseInt(String.valueOf(sqzyts))); // 术前住院天数
        homepage.setSHZYTS(Integer.parseInt(String.valueOf(shzyts))); // 术后住院天数
        homepage.setCFTS(cfts); // 重返天数
        homepage.setA_id(Aid);

        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");

        homepage.setZzjgdm(StringUtil.isNotEmpty(entityA.getZZJGDM()) ? entityA.getZZJGDM() : hpHospiatlInfo.getJgdm()); // 组织机构代码
        homepage.setJgmc(StringUtil.isNotEmpty(entityA.getJGMC()) ? entityA.getJGMC() : hpHospiatlInfo.getJgmc()); // 组织机构名称
        homepage.setZzjgdm2(
                StringUtil.isNotEmpty(entityA.getZZJGDM2()) ? entityA.getZZJGDM2() : hpHospiatlInfo.getJgdm()); // 组织机构代码2
        homepage.setYydsdm(hpHospiatlInfo.getShi_code());
        homepage.setYyqxdm(hpHospiatlInfo.getXian_code());
        homepage.setYysjdm(hpHospiatlInfo.getSheng_code());
        homepage.setUsername("dl");
        homepage.setYlfkfs(entityA.getCH0A82()); // 医疗付款方式
        homepage.setJkkh(entityA.getCH0A81()); // 健康卡号
        homepage.setZycs(entityA.getCH0AZYCS()); // 住院次数
        homepage.setBah(entityA.getCH0A01()); // 病案号
        homepage.setXm(entityA.getCH0A02()); // 姓名
        homepage.setXb(String.valueOf(entityA.getCH0A03())); // 性别
        homepage.setCsrq(null==entityA.getCH0A04()? null:entityA.getCH0A04()); // 出生日期 yyyy-mm-dd
        homepage.setNl(entityA.getCH0A06()); // 年龄(岁)n
        homepage.setGj(entityA.getCH0AA2()); // 国籍
        // 计算年龄不足一周岁的患者的年龄天数(计算方式：入院时间-出生日期)
        // homepage.setBzyzsNl(StringUtils.isEmpty(entityA.getCH0A24() ) &&
        // StringUtils.isEmpty(entityA.getCH0A04()) ? 0.00:
        // (int)(entityA.getCH0A24().getTime()-entityA.getCH0A04().getTime())
        // /(1000*3600*24)); //年龄（月）
        homepage.setBzyzsNl(entityA.getCh0AN1()); // 年龄不足一周岁的患者的年龄月数
        homepage.setXsetz(entityA.getCh0AN2()); // 新生儿出生体重(克)
        homepage.setXserytz(entityA.getCh0AN3()); // 新生儿入院体重（克）
        homepage.setCsd_sheng(entityA.getHPCSD_sheng()); // 出生地省
        homepage.setCsd_sheng_dm(entityA.getHPCSD_sheng_dm()); // 出生地省代码
        homepage.setCsd_shi(entityA.getHPCSD_shi()); // 出生地市
        homepage.setCsd_shi_dm(entityA.getHPCSD_shi_dm()); // 出生地市代码
        homepage.setCsd_xian(entityA.getHPCSD_xian()); // 出生地县
        homepage.setCsd_xian_dm(entityA.getHPCSD_xian_dm()); // 出生地县代码
        homepage.setCsd_addr_all(entityA.getHPCSD_sheng() + entityA.getHPCSD_shi() + entityA.getHPCSD_xian()); // 出生地详细地址加省市县
        homepage.setJg_sheng(entityA.getJG_sheng()); // 籍贯省
        homepage.setJg_sheng_dm(entityA.getJG_sheng_dm()); // 籍贯省代码
        homepage.setJg_shi(entityA.getJG_shi()); // 籍贯市
        homepage.setJg_shi_dm(entityA.getJG_shi_dm()); // 籍贯市代码
        homepage.setJg_all(entityA.getJG_sheng() + entityA.getJG_shi()); // 籍贯详细
        homepage.setMz(entityA.getCH0A10()); // 民族
        homepage.setSfzh(entityA.getCH0A05()); // 身份证
        homepage.setZy(entityA.getCH0A08()); // 职业
        homepage.setHy(entityA.getCH0A07()); // 婚姻
        homepage.setXzz_sheng(entityA.getHPXZZ_sheng()); // 现住址省
        homepage.setXzz_sheng_dm(entityA.getHPXZZ_sheng_dm()); // 现住址省代码
        homepage.setXzz_shi(entityA.getHPXZZ_shi()); // 现住址市
        homepage.setXzz_shi_dm(entityA.getHPXZZ_shi_dm()); // 现住址市代码
        homepage.setXzz_xian(entityA.getHPXZZ_xian()); // 现住址县
        homepage.setXzz_xian_dm(entityA.getHPXZZ_xian_dm()); // 现住址县代码
        homepage.setXzz_addr(entityA.getHPXZZ_addr()); // 现住址附加地址
        homepage.setXzz_addr_all(
                entityA.getHPXZZ_sheng() + entityA.getHPXZZ_shi() + entityA.getHPXZZ_xian() + entityA.getHPXZZ_addr()); // 现住址详细地址加省市县
        homepage.setDh(entityA.getCh0AN7()); // 现住址电话
        homepage.setYb1(entityA.getCh0AN8()); // 现住址邮编
        homepage.setHkdz_sheng(entityA.getHPHK_sheng()); // 户口地址省
        homepage.setHkdz_sheng_dm(entityA.getHPHK_sheng_dm()); // 户口地址省代码
        homepage.setHkdz_shi(entityA.getHPHK_shi()); // 户口地址市
        homepage.setHkdz_shi_dm(entityA.getHPHK_shi_dm()); // 户口地址市代码
        homepage.setHkdz_xian(entityA.getHPHK_xian()); // 户口地址县
        homepage.setHkdz_xian_dm(entityA.getHPHK_xian_dm()); // 户口地址县代码
        homepage.setHkdz_addr(entityA.getHPHK_addr()); // 户口地址附加地址
        homepage.setHkdz_addr_all(
                entityA.getHPHK_sheng() + entityA.getHPHK_shi() + entityA.getHPHK_xian() + entityA.getHPHK_addr()); // 户口地址详细地址加省市县
        homepage.setYb2(entityA.getCH0A14()); // 户口邮编
        homepage.setGzdwjdz(entityA.getCH0AA3()); // 工作单位及地址
        homepage.setDwdh(entityA.getCH0AA5()); // 工作单位电话
        homepage.setYb3(entityA.getCH0AA4()); // 工作单位邮政编码
        homepage.setLxrxm(entityA.getCH0A15()); // 联系人姓名
        homepage.setGx(entityA.getCH0A16()); // 联系人关系
        homepage.setLxr_sheng(entityA.getHPLXR_sheng()); // 联系人地址省
        homepage.setLxr_sheng_dm(entityA.getHPLXR_sheng_dm()); // 联系人地址省代码
        homepage.setLxr_shi(entityA.getHPLXR_shi()); // 联系人地址市
        homepage.setLxr_shi_dm(entityA.getHPLXR_shi_dm()); // 联系人地址市代码
        homepage.setLxr_xian(entityA.getHPLXR_xian()); // 联系人地址县
        homepage.setLxr_xian_dm(entityA.getHPLXR_xian_dm()); // 联系人地址县代码
        homepage.setLxr_addr(entityA.getHPLXR_addr()); // 联系人地址附加地址
        homepage.setLxr_addr_all(
                entityA.getHPLXR_sheng() + entityA.getHPLXR_shi() + entityA.getHPLXR_xian() + entityA.getHPLXR_addr()); // 联系人地址详细地址加省市县
        homepage.setDh1(entityA.getCH0A19()); // 联系人电话
        homepage.setRytj(entityA.getCH0A56()); // 入院途径
        homepage.setQTYLJGMC(entityA.getCH0AAB()); // 入院途径
        // homepage.setZllb(entityA.getCh0ANP()); //治疗类别
        homepage.setZllb(StringUtil.isNotEmpty(entityA.getCh0ANP()) ? entityA.getCh0ANP()
                : StringUtil.isEmptyNumber(entityA.getCH0A55()) ? "" : entityA.getCH0A55() + ""); // 治疗类别
        homepage.setRysj(StringUtils.isEmpty(entityA.getCH0A24()) ? null : entityA.getCH0A24()); // 入院时间
        homepage.setRysj_S(null==entityA.getCH0A24()?"":entityA.getCH0A24().getHours() + ""); // 时
        homepage.setRykb(entityA.getCH0A21()); // 入院科别
        homepage.setRybf(entityA.getCh0ANA()); // 入院病房
        homepage.setZkkb(entityA.getCH0A22()); // 转科科别
        homepage.setCysj(entityA.getCH0A27()); // 出院时间
        homepage.setCH0AJZLSH(entityA.getCH0AJZLSH()); // 就诊流水号
        homepage.setCysj_S(null==entityA.getCH0A27()?"":entityA.getCH0A27().getHours() + ""); // 时
        homepage.setCykb(entityA.getCH0A23()); // 出院科别
        homepage.setCybf(entityA.getCh0ANB()); // 出院病房
        homepage.setSjzy(entityA.getCH0A29()); // 实际住院(天)

        homepage.setMzzd_xyzd(entityA.getCH0A36_Desc()); // 门（急）诊诊断名称(西医诊断)
        homepage.setJbbm(entityA.getCH0A36()); // 门（急）诊诊断编码(西医诊断)
        homepage.setSslclj(entityA.getCh0ANQ()); // 实施临床路径
        homepage.setZyyj(entityA.getCH0A70()); // 使用医疗机构中药制剂
        homepage.setZyzlsb(entityA.getCh0ANR()); // 使用中医诊疗设备
        homepage.setZyzljs(entityA.getCh0ANS()); // 使用中医诊疗技术
        homepage.setBzsh(entityA.getCh0ANT()); // 辩证施护
        homepage.setNldw(entityA.getCH0AA1()); // 年龄单位

        homepage.setWbyy(entityA.getCh0ASS()); // 损伤、中毒外部原因名称
        homepage.setJbbm1(entityA.getCH0A79()); // 损伤、中毒外部原因编码
        homepage.setBlzd(entityA.getCh0ACK()); // 病理诊断名称
        homepage.setJbbm2(entityA.getCH0A77()); // 病理诊断编码
        homepage.setBlh(entityA.getCH0AHBL1()); // 病理号
        homepage.setYwgm(entityA.getCH0A52()); // 有无药物过敏
        homepage.setGmyw(entityA.getCH0AAA()); // 过敏药物名称
        homepage.setSj(entityA.getCh0ANC()); // 死亡患者尸检
        homepage.setXx(entityA.getCH0A45()); // ABO血型
        homepage.setRh(entityA.getCH0AC5()); // Rh血型

        homepage.setKzr(entityA.getCH0AB1()); // 科主任
        homepage.setKzrdm(entityA.getCH0AB1DM()); // 科主任代码
        homepage.setZrys(entityA.getCH0A32()); // 主任（副主任）医师
        homepage.setZrysdm(entityA.getCH0A32DM()); // 主任（副主任）医师代码
        homepage.setZzys(entityA.getCH0A33()); // 主治医师
        homepage.setZzysdm(entityA.getCH0A33DM()); // 主治医师代码
        homepage.setZyys(entityA.getCH0A34()); // 住院医师
        homepage.setZyysdm(entityA.getCH0A34DM()); // 住院医师代码
        homepage.setZrhs(entityA.getCh0AND()); // 责任护士
        homepage.setZrhsdm(entityA.getCh0ANDDM()); // 责任护士代码
        homepage.setJxys(entityA.getCH0AB2()); // 进修医师
        homepage.setJxysdm(entityA.getCH0AB2DM()); // 进修医师代码
        homepage.setSxys(entityA.getCH0AB4()); // 实习医师
        homepage.setSxysdm(entityA.getCH0AB4DM()); // 实习医师代码
        homepage.setBmy(entityA.getCH0A59()); // 编码员
        homepage.setBazl(entityA.getCH0A51()); // 病案质量
        homepage.setZkys(entityA.getCH0AB5()); // 质控医师
        homepage.setZkysdm(entityA.getCH0AB5DM()); // 质控医师代码
        homepage.setZkhs(entityA.getCH0A69()); // 质控护士
        homepage.setZkhsdm(entityA.getCH0A69DM()); // 质控护士代码
        homepage.setZkrq(StringUtils.isEmpty(entityA.getCH0AB6()) ? entityA.getCH0A27() : entityA.getCH0AB6()); // 质控日期

        homepage.setLyfs(entityA.getCh0ANE()); // 离院方式
        homepage.setYzzy_jgmc(entityA.getCh0ANF()); // 医嘱转院，拟接收医疗机构名称
        homepage.setWsy_jgmc(entityA.getCh0ANF2()); // 医嘱转社区卫生服务机构/乡镇卫生院，拟接收医疗机构
        homepage.setZzyjh(String.valueOf(entityA.getCh0ANG())); // 是否有出院31天内再住院计划
        homepage.setMd(entityA.getCh0ANH()); // 目的
        homepage.setRyq_t(entityA.getCh0ANI()); // 颅脑损伤患者昏迷入院前时间（天)
        homepage.setRyq_xs(entityA.getCh0ANJ()); // 小时
        homepage.setRyq_fz(entityA.getCh0ANK()); // 分钟
        homepage.setRyh_t(entityA.getCh0ANL()); // 颅脑损伤患者昏迷时间天
        homepage.setRyh_xs(entityA.getCh0ANM()); // 小时
        homepage.setRyh_fz(entityA.getCh0ANN()); // 分钟

        homepage.setZXFLAG(StringUtil.isNotEmpty(entityA.getZXFLAG()) ? entityA.getZXFLAG()
                : (StringUtil.isNotEmpty(hpHospiatlInfo.getHomepage_type().toString())
                ? hpHospiatlInfo.getHomepage_type().toString()
                : "1")); // 中西医标志
        homepage.setZDGS(csize); // 诊断个数
        homepage.setSSGS(esize); // 手术个数

        homepage.setSTATUS(entityA.getSTATUS());
        homepage.setGJMC(entityA.getCH0AA2_mc()); // 国籍名称
        homepage.setGJPYM(entityA.getCH0AA2_jp()); // 国籍名称拼音码
        homepage.setZYH(entityA.getCH0A00()); // 住院号
        homepage.setRYKBMC(entityA.getCH0A21_mc()); // 入院科别名称
        homepage.setCYKBMC(entityA.getCH0A23_mc()); // 出院科别名称
        homepage.setIsManual(entityA.getIsManual()); // 是否手工录入
        homepage.setInputReason(entityA.getInputReason()); // 手工录入的原因
        homepage.setSfzjlx(entityA.getCH0A05A()); // 身份证件类型

        fillB(homepage, entityB);
        fillC(homepage, ListEntityC, csize);
        fillE(homepage, ListEntityE, esize);
        fillS(homepage, ListEntityS, ssize);
        fillK(homepage, entityK);
        return homepage;
    }

    /**
     * 装填C表数据
     */
    public static void fillC(HomepageEntity homepage, List<HpVsch0CEntity> ListEntityC, int csize) {
        homepage.setZyzd(csize >= 1 ? ListEntityC.get(0).getCH0C03_Desc() : null); // 出院主要诊断名称(西医)
        homepage.setZyzd_jbbm(csize >= 1 ? ListEntityC.get(0).getCH0C11() : null); // 出院主要诊断编码(西医)
        StringBuilder allc = new StringBuilder();
        if (csize > 0) {
            ListEntityC.forEach(e -> {
                allc.append(e.getCH0C11()).append(",");
            });
            homepage.setZyzd_jbbm_allc(allc.toString().substring(0, allc.length() - 1));
        } else {
            homepage.setZyzd_jbbm_allc("");
        }
        homepage.setXy_rybq(csize >= 1 ? ListEntityC.get(0).getCh0CN1() : null); // 出院主要诊断入院病情(西医)
        homepage.setZYZD_CYQK(csize >= 1 ? ListEntityC.get(0).getCH0C05() : null); // 出院住要诊断出院情情况
        homepage.setQtzd1(csize >= 2 ? ListEntityC.get(1).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd2(csize >= 3 ? ListEntityC.get(2).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd3(csize >= 4 ? ListEntityC.get(3).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd4(csize >= 5 ? ListEntityC.get(4).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd5(csize >= 6 ? ListEntityC.get(5).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd6(csize >= 7 ? ListEntityC.get(6).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd7(csize >= 8 ? ListEntityC.get(7).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd8(csize >= 9 ? ListEntityC.get(8).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd9(csize >= 10 ? ListEntityC.get(9).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd10(csize >= 11 ? ListEntityC.get(10).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd11(csize >= 12 ? ListEntityC.get(11).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd12(csize >= 13 ? ListEntityC.get(12).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd13(csize >= 14 ? ListEntityC.get(13).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd14(csize >= 15 ? ListEntityC.get(14).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd15(csize >= 16 ? ListEntityC.get(15).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd16(csize >= 17 ? ListEntityC.get(16).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd17(csize >= 18 ? ListEntityC.get(17).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd18(csize >= 19 ? ListEntityC.get(18).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd19(csize >= 20 ? ListEntityC.get(19).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd20(csize >= 21 ? ListEntityC.get(20).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd21(csize >= 22 ? ListEntityC.get(21).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd22(csize >= 23 ? ListEntityC.get(22).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd23(csize >= 24 ? ListEntityC.get(23).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd24(csize >= 25 ? ListEntityC.get(24).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd25(csize >= 26 ? ListEntityC.get(25).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd26(csize >= 27 ? ListEntityC.get(26).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd27(csize >= 28 ? ListEntityC.get(27).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd28(csize >= 29 ? ListEntityC.get(28).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd29(csize >= 30 ? ListEntityC.get(29).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd30(csize >= 31 ? ListEntityC.get(30).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd31(csize >= 32 ? ListEntityC.get(31).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd32(csize >= 33 ? ListEntityC.get(32).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd33(csize >= 34 ? ListEntityC.get(33).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd34(csize >= 35 ? ListEntityC.get(34).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd35(csize >= 36 ? ListEntityC.get(35).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd36(csize >= 37 ? ListEntityC.get(36).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd37(csize >= 38 ? ListEntityC.get(37).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd38(csize >= 39 ? ListEntityC.get(38).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd39(csize >= 40 ? ListEntityC.get(39).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setQtzd40(csize >= 41 ? ListEntityC.get(40).getCH0C03_Desc() : null); // 出院其他诊断名称(西医)
        homepage.setZyzd_jbbm1(csize >= 2 ? ListEntityC.get(1).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm2(csize >= 3 ? ListEntityC.get(2).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm3(csize >= 4 ? ListEntityC.get(3).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm4(csize >= 5 ? ListEntityC.get(4).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm5(csize >= 6 ? ListEntityC.get(5).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm6(csize >= 7 ? ListEntityC.get(6).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm7(csize >= 8 ? ListEntityC.get(7).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm8(csize >= 9 ? ListEntityC.get(8).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm9(csize >= 10 ? ListEntityC.get(9).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm10(csize >= 11 ? ListEntityC.get(10).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm11(csize >= 12 ? ListEntityC.get(11).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm12(csize >= 13 ? ListEntityC.get(12).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm13(csize >= 14 ? ListEntityC.get(13).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm14(csize >= 15 ? ListEntityC.get(14).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm15(csize >= 16 ? ListEntityC.get(15).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm16(csize >= 17 ? ListEntityC.get(16).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm17(csize >= 18 ? ListEntityC.get(17).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm18(csize >= 19 ? ListEntityC.get(18).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm19(csize >= 20 ? ListEntityC.get(19).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm20(csize >= 21 ? ListEntityC.get(20).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm21(csize >= 22 ? ListEntityC.get(21).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm22(csize >= 23 ? ListEntityC.get(22).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm23(csize >= 24 ? ListEntityC.get(23).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm24(csize >= 25 ? ListEntityC.get(24).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm25(csize >= 26 ? ListEntityC.get(25).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm26(csize >= 27 ? ListEntityC.get(26).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm27(csize >= 28 ? ListEntityC.get(27).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm28(csize >= 29 ? ListEntityC.get(28).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm29(csize >= 30 ? ListEntityC.get(29).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm30(csize >= 31 ? ListEntityC.get(30).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm31(csize >= 32 ? ListEntityC.get(31).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm32(csize >= 33 ? ListEntityC.get(32).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm33(csize >= 34 ? ListEntityC.get(33).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm34(csize >= 35 ? ListEntityC.get(34).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm35(csize >= 36 ? ListEntityC.get(35).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm36(csize >= 37 ? ListEntityC.get(36).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm37(csize >= 38 ? ListEntityC.get(37).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm38(csize >= 39 ? ListEntityC.get(38).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm39(csize >= 40 ? ListEntityC.get(39).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setZyzd_jbbm40(csize >= 41 ? ListEntityC.get(40).getCH0C11() : null); // 出院其他诊断编码(西医)
        homepage.setRybq1(csize >= 2 ? ListEntityC.get(1).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq2(csize >= 3 ? ListEntityC.get(2).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq3(csize >= 4 ? ListEntityC.get(3).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq4(csize >= 5 ? ListEntityC.get(4).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq5(csize >= 6 ? ListEntityC.get(5).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq6(csize >= 7 ? ListEntityC.get(6).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq7(csize >= 8 ? ListEntityC.get(7).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq8(csize >= 9 ? ListEntityC.get(8).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq9(csize >= 10 ? ListEntityC.get(9).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq10(csize >= 11 ? ListEntityC.get(10).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq11(csize >= 12 ? ListEntityC.get(11).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq12(csize >= 13 ? ListEntityC.get(12).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq13(csize >= 14 ? ListEntityC.get(13).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq14(csize >= 15 ? ListEntityC.get(14).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq15(csize >= 16 ? ListEntityC.get(15).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq16(csize >= 17 ? ListEntityC.get(16).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq17(csize >= 18 ? ListEntityC.get(17).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq18(csize >= 19 ? ListEntityC.get(18).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq19(csize >= 20 ? ListEntityC.get(19).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq20(csize >= 21 ? ListEntityC.get(20).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq21(csize >= 22 ? ListEntityC.get(21).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq22(csize >= 23 ? ListEntityC.get(22).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq23(csize >= 24 ? ListEntityC.get(23).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq24(csize >= 25 ? ListEntityC.get(24).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq25(csize >= 26 ? ListEntityC.get(25).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq26(csize >= 27 ? ListEntityC.get(26).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq27(csize >= 28 ? ListEntityC.get(27).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq28(csize >= 29 ? ListEntityC.get(28).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq29(csize >= 30 ? ListEntityC.get(29).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq30(csize >= 31 ? ListEntityC.get(30).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq31(csize >= 32 ? ListEntityC.get(31).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq32(csize >= 33 ? ListEntityC.get(32).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq33(csize >= 34 ? ListEntityC.get(33).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq34(csize >= 35 ? ListEntityC.get(34).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq35(csize >= 36 ? ListEntityC.get(35).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq36(csize >= 37 ? ListEntityC.get(36).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq37(csize >= 38 ? ListEntityC.get(37).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq38(csize >= 39 ? ListEntityC.get(38).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq39(csize >= 40 ? ListEntityC.get(39).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setRybq40(csize >= 41 ? ListEntityC.get(40).getCh0CN1() : null); // 出院其他诊断入院病情(西医)
        homepage.setCYQK1(csize >= 2 ? ListEntityC.get(1).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK2(csize >= 3 ? ListEntityC.get(2).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK3(csize >= 4 ? ListEntityC.get(3).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK4(csize >= 5 ? ListEntityC.get(4).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK5(csize >= 6 ? ListEntityC.get(5).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK6(csize >= 7 ? ListEntityC.get(6).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK7(csize >= 8 ? ListEntityC.get(7).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK8(csize >= 9 ? ListEntityC.get(8).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK9(csize >= 10 ? ListEntityC.get(9).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK10(csize >= 11 ? ListEntityC.get(10).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK11(csize >= 12 ? ListEntityC.get(11).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK12(csize >= 13 ? ListEntityC.get(12).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK13(csize >= 14 ? ListEntityC.get(13).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK14(csize >= 15 ? ListEntityC.get(14).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK15(csize >= 16 ? ListEntityC.get(15).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK16(csize >= 17 ? ListEntityC.get(16).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK17(csize >= 18 ? ListEntityC.get(17).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK18(csize >= 19 ? ListEntityC.get(18).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK19(csize >= 20 ? ListEntityC.get(19).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK20(csize >= 21 ? ListEntityC.get(20).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK21(csize >= 22 ? ListEntityC.get(21).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK22(csize >= 23 ? ListEntityC.get(22).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK23(csize >= 24 ? ListEntityC.get(23).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK24(csize >= 25 ? ListEntityC.get(24).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK25(csize >= 26 ? ListEntityC.get(25).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK26(csize >= 27 ? ListEntityC.get(26).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK27(csize >= 28 ? ListEntityC.get(27).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK28(csize >= 29 ? ListEntityC.get(28).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK29(csize >= 30 ? ListEntityC.get(29).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK30(csize >= 31 ? ListEntityC.get(30).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK31(csize >= 32 ? ListEntityC.get(31).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK32(csize >= 33 ? ListEntityC.get(32).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK33(csize >= 34 ? ListEntityC.get(33).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK34(csize >= 35 ? ListEntityC.get(34).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK35(csize >= 36 ? ListEntityC.get(35).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK36(csize >= 37 ? ListEntityC.get(36).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK37(csize >= 38 ? ListEntityC.get(37).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK38(csize >= 39 ? ListEntityC.get(38).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK39(csize >= 40 ? ListEntityC.get(39).getCH0C05() : null); // 出院其他诊断出院情况
        homepage.setCYQK40(csize >= 41 ? ListEntityC.get(40).getCH0C05() : null); // 出院其他诊断出院情况
    }

    /**
     * 装填E表数据
     */
    public static void fillE(HomepageEntity homepage, List<HpVsch0EEntity> ListEntityE, int esize) {
        homepage.setSsjczbm1(esize >= 1 ? ListEntityE.get(0).getCH0E05() : null); // 主要手术操作编码
        homepage.setSsjczmc1(esize >= 1 ? ListEntityE.get(0).getCH0E05_Desc() : null); // 主要手术操作名称
        homepage.setSsjczrq1(
                esize >= 1 ? StringUtils.isEmpty(ListEntityE.get(0).getCH0E11()) ? null : ListEntityE.get(0).getCH0E11()
                        : null); // 主要手术操作日期
        homepage.setSsjb1(esize >= 1 ? ListEntityE.get(0).getCh0E04() : null); // 主要手术操作级别
        homepage.setSz1(esize >= 1 ? ListEntityE.get(0).getCH0E09() : null); // 主要手术操作术者
        homepage.setYz1(esize >= 1 ? ListEntityE.get(0).getCH0E14() : null); // 主要手术操作Ⅰ助
        homepage.setEz1(esize >= 1 ? ListEntityE.get(0).getCH0E15() : null); // 主要手术操作Ⅱ助
        homepage.setQkdj1(esize >= 1 ? ListEntityE.get(0).getCH0E12() : null); // 主要手术操作切口愈合
        // 等级
        homepage.setQkylb1(esize >= 1 ? ListEntityE.get(0).getCH0E13() : null); // 主要手术操作切口愈合类别
        homepage.setMzfs1(esize >= 1 ? ListEntityE.get(0).getCH0E10() : null); // 主要手术操作麻醉方式
        homepage.setMzys1(esize >= 1 ? ListEntityE.get(0).getCH0E16() : null); // 主要手术操作麻醉医师
        homepage.setMZFJ1(esize >= 1 ? ListEntityE.get(0).getCH0EE2() : null); // 主要手术操作麻醉分级
        homepage.setSSCZBW1(esize >= 1 ? ListEntityE.get(0).getCH0EE4() : null); // 主要手术操作手术部位
        if (esize > 0) {
            StringBuilder allc = new StringBuilder();
            ListEntityE.forEach(e -> {
                allc.append(e.getCH0E05()).append(",");
            });
            homepage.setSSJCZBMALLC(allc.toString().substring(0, allc.length() - 1));
        } else {
            homepage.setSSJCZBMALLC("");
        }
        homepage.setSsjczbm2(esize >= 2 ? ListEntityE.get(1).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm3(esize >= 3 ? ListEntityE.get(2).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm4(esize >= 4 ? ListEntityE.get(3).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm5(esize >= 5 ? ListEntityE.get(4).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm6(esize >= 6 ? ListEntityE.get(5).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm7(esize >= 7 ? ListEntityE.get(6).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm8(esize >= 8 ? ListEntityE.get(7).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm9(esize >= 9 ? ListEntityE.get(8).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm10(esize >= 10 ? ListEntityE.get(9).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm11(esize >= 11 ? ListEntityE.get(10).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm12(esize >= 12 ? ListEntityE.get(11).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm13(esize >= 13 ? ListEntityE.get(12).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm14(esize >= 14 ? ListEntityE.get(13).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm15(esize >= 15 ? ListEntityE.get(14).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm16(esize >= 16 ? ListEntityE.get(15).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm17(esize >= 17 ? ListEntityE.get(16).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm18(esize >= 18 ? ListEntityE.get(17).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm19(esize >= 19 ? ListEntityE.get(18).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm20(esize >= 20 ? ListEntityE.get(19).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm21(esize >= 21 ? ListEntityE.get(20).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm22(esize >= 22 ? ListEntityE.get(21).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm23(esize >= 23 ? ListEntityE.get(22).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm24(esize >= 24 ? ListEntityE.get(23).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm25(esize >= 25 ? ListEntityE.get(24).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm26(esize >= 26 ? ListEntityE.get(25).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm27(esize >= 27 ? ListEntityE.get(26).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm28(esize >= 28 ? ListEntityE.get(27).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm29(esize >= 29 ? ListEntityE.get(28).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm30(esize >= 30 ? ListEntityE.get(29).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm31(esize >= 31 ? ListEntityE.get(30).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm32(esize >= 32 ? ListEntityE.get(31).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm33(esize >= 33 ? ListEntityE.get(32).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm34(esize >= 34 ? ListEntityE.get(33).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm35(esize >= 35 ? ListEntityE.get(34).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm36(esize >= 36 ? ListEntityE.get(35).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm37(esize >= 37 ? ListEntityE.get(36).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm38(esize >= 38 ? ListEntityE.get(37).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm39(esize >= 39 ? ListEntityE.get(38).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm40(esize >= 40 ? ListEntityE.get(39).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczbm41(esize >= 41 ? ListEntityE.get(40).getCH0E05() : null); // 其他手术操作编码
        homepage.setSsjczmc2(esize >= 2 ? ListEntityE.get(1).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc3(esize >= 3 ? ListEntityE.get(2).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc4(esize >= 4 ? ListEntityE.get(3).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc5(esize >= 5 ? ListEntityE.get(4).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc6(esize >= 6 ? ListEntityE.get(5).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc7(esize >= 7 ? ListEntityE.get(6).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc8(esize >= 8 ? ListEntityE.get(7).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc9(esize >= 9 ? ListEntityE.get(8).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc10(esize >= 10 ? ListEntityE.get(9).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc11(esize >= 11 ? ListEntityE.get(10).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc12(esize >= 12 ? ListEntityE.get(11).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc13(esize >= 13 ? ListEntityE.get(12).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc14(esize >= 14 ? ListEntityE.get(13).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc15(esize >= 15 ? ListEntityE.get(14).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc16(esize >= 16 ? ListEntityE.get(15).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc17(esize >= 17 ? ListEntityE.get(16).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc18(esize >= 18 ? ListEntityE.get(17).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc19(esize >= 19 ? ListEntityE.get(18).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc20(esize >= 20 ? ListEntityE.get(19).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc21(esize >= 21 ? ListEntityE.get(20).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc22(esize >= 22 ? ListEntityE.get(21).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc23(esize >= 23 ? ListEntityE.get(22).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc24(esize >= 24 ? ListEntityE.get(23).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc25(esize >= 25 ? ListEntityE.get(24).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc26(esize >= 26 ? ListEntityE.get(25).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc27(esize >= 27 ? ListEntityE.get(26).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc28(esize >= 28 ? ListEntityE.get(27).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc29(esize >= 29 ? ListEntityE.get(28).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc30(esize >= 30 ? ListEntityE.get(29).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc31(esize >= 31 ? ListEntityE.get(30).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc32(esize >= 32 ? ListEntityE.get(31).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc33(esize >= 33 ? ListEntityE.get(32).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc34(esize >= 34 ? ListEntityE.get(33).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc35(esize >= 35 ? ListEntityE.get(34).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc36(esize >= 36 ? ListEntityE.get(35).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc37(esize >= 37 ? ListEntityE.get(36).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc38(esize >= 38 ? ListEntityE.get(37).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc39(esize >= 39 ? ListEntityE.get(38).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc40(esize >= 40 ? ListEntityE.get(39).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczmc41(esize >= 41 ? ListEntityE.get(40).getCH0E05_Desc() : null); // 其他手术操作名称
        homepage.setSsjczrq2(esize >= 2 ? ListEntityE.get(1).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq3(esize >= 3 ? ListEntityE.get(2).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq4(esize >= 4 ? ListEntityE.get(3).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq5(esize >= 5 ? ListEntityE.get(4).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq6(esize >= 6 ? ListEntityE.get(5).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq7(esize >= 7 ? ListEntityE.get(6).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq8(esize >= 8 ? ListEntityE.get(7).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq9(esize >= 9 ? ListEntityE.get(8).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq10(esize >= 10 ? ListEntityE.get(9).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq11(esize >= 11 ? ListEntityE.get(10).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq12(esize >= 12 ? ListEntityE.get(11).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq13(esize >= 13 ? ListEntityE.get(12).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq14(esize >= 14 ? ListEntityE.get(13).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq15(esize >= 15 ? ListEntityE.get(14).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq16(esize >= 16 ? ListEntityE.get(15).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq17(esize >= 17 ? ListEntityE.get(16).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq18(esize >= 18 ? ListEntityE.get(17).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq19(esize >= 19 ? ListEntityE.get(18).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq20(esize >= 20 ? ListEntityE.get(19).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq21(esize >= 21 ? ListEntityE.get(20).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq22(esize >= 22 ? ListEntityE.get(21).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq23(esize >= 23 ? ListEntityE.get(22).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq24(esize >= 24 ? ListEntityE.get(23).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq25(esize >= 25 ? ListEntityE.get(24).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq26(esize >= 26 ? ListEntityE.get(25).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq27(esize >= 27 ? ListEntityE.get(26).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq28(esize >= 28 ? ListEntityE.get(27).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq29(esize >= 29 ? ListEntityE.get(28).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq30(esize >= 30 ? ListEntityE.get(29).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq31(esize >= 31 ? ListEntityE.get(30).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq32(esize >= 32 ? ListEntityE.get(31).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq33(esize >= 33 ? ListEntityE.get(32).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq34(esize >= 34 ? ListEntityE.get(33).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq35(esize >= 35 ? ListEntityE.get(34).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq36(esize >= 36 ? ListEntityE.get(35).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq37(esize >= 37 ? ListEntityE.get(36).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq38(esize >= 38 ? ListEntityE.get(37).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq39(esize >= 39 ? ListEntityE.get(38).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq40(esize >= 40 ? ListEntityE.get(39).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjczrq41(esize >= 41 ? ListEntityE.get(40).getCH0E11() : null); // 其他手术操作日期
        homepage.setSsjb2(esize >= 2 ? ListEntityE.get(1).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb3(esize >= 3 ? ListEntityE.get(2).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb4(esize >= 4 ? ListEntityE.get(3).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb5(esize >= 5 ? ListEntityE.get(4).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb6(esize >= 6 ? ListEntityE.get(5).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb7(esize >= 7 ? ListEntityE.get(6).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb8(esize >= 8 ? ListEntityE.get(7).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb9(esize >= 9 ? ListEntityE.get(8).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb10(esize >= 10 ? ListEntityE.get(9).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb11(esize >= 11 ? ListEntityE.get(10).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb12(esize >= 12 ? ListEntityE.get(11).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb13(esize >= 13 ? ListEntityE.get(12).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb14(esize >= 14 ? ListEntityE.get(13).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb15(esize >= 15 ? ListEntityE.get(14).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb16(esize >= 16 ? ListEntityE.get(15).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb17(esize >= 17 ? ListEntityE.get(16).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb18(esize >= 18 ? ListEntityE.get(17).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb19(esize >= 19 ? ListEntityE.get(18).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb20(esize >= 20 ? ListEntityE.get(19).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb21(esize >= 21 ? ListEntityE.get(20).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb22(esize >= 22 ? ListEntityE.get(21).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb23(esize >= 23 ? ListEntityE.get(22).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb24(esize >= 24 ? ListEntityE.get(23).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb25(esize >= 25 ? ListEntityE.get(24).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb26(esize >= 26 ? ListEntityE.get(25).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb27(esize >= 27 ? ListEntityE.get(26).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb28(esize >= 28 ? ListEntityE.get(27).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb29(esize >= 29 ? ListEntityE.get(28).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb30(esize >= 30 ? ListEntityE.get(29).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb31(esize >= 31 ? ListEntityE.get(30).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb32(esize >= 32 ? ListEntityE.get(31).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb33(esize >= 33 ? ListEntityE.get(32).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb34(esize >= 34 ? ListEntityE.get(33).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb35(esize >= 35 ? ListEntityE.get(34).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb36(esize >= 36 ? ListEntityE.get(35).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb37(esize >= 37 ? ListEntityE.get(36).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb38(esize >= 38 ? ListEntityE.get(37).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb39(esize >= 39 ? ListEntityE.get(38).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb40(esize >= 40 ? ListEntityE.get(39).getCh0E04() : null); // 其他手术操作级别
        homepage.setSsjb41(esize >= 41 ? ListEntityE.get(40).getCh0E04() : null); // 其他手术操作级别
        homepage.setSz2(esize >= 2 ? ListEntityE.get(1).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz3(esize >= 3 ? ListEntityE.get(2).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz4(esize >= 4 ? ListEntityE.get(3).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz5(esize >= 5 ? ListEntityE.get(4).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz6(esize >= 6 ? ListEntityE.get(5).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz7(esize >= 7 ? ListEntityE.get(6).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz8(esize >= 8 ? ListEntityE.get(7).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz9(esize >= 9 ? ListEntityE.get(8).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz10(esize >= 10 ? ListEntityE.get(9).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz11(esize >= 11 ? ListEntityE.get(10).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz12(esize >= 12 ? ListEntityE.get(11).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz13(esize >= 13 ? ListEntityE.get(12).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz14(esize >= 14 ? ListEntityE.get(13).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz15(esize >= 15 ? ListEntityE.get(14).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz16(esize >= 16 ? ListEntityE.get(15).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz17(esize >= 17 ? ListEntityE.get(16).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz18(esize >= 18 ? ListEntityE.get(17).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz19(esize >= 19 ? ListEntityE.get(18).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz20(esize >= 20 ? ListEntityE.get(19).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz21(esize >= 21 ? ListEntityE.get(20).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz22(esize >= 22 ? ListEntityE.get(21).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz23(esize >= 23 ? ListEntityE.get(22).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz24(esize >= 24 ? ListEntityE.get(23).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz25(esize >= 25 ? ListEntityE.get(24).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz26(esize >= 26 ? ListEntityE.get(25).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz27(esize >= 27 ? ListEntityE.get(26).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz28(esize >= 28 ? ListEntityE.get(27).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz29(esize >= 29 ? ListEntityE.get(28).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz30(esize >= 30 ? ListEntityE.get(29).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz31(esize >= 31 ? ListEntityE.get(30).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz32(esize >= 32 ? ListEntityE.get(31).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz33(esize >= 33 ? ListEntityE.get(32).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz34(esize >= 34 ? ListEntityE.get(33).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz35(esize >= 35 ? ListEntityE.get(34).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz36(esize >= 36 ? ListEntityE.get(35).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz37(esize >= 37 ? ListEntityE.get(36).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz38(esize >= 38 ? ListEntityE.get(37).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz39(esize >= 39 ? ListEntityE.get(38).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz40(esize >= 40 ? ListEntityE.get(39).getCH0E09() : null); // 其他手术操作术者
        homepage.setSz41(esize >= 41 ? ListEntityE.get(40).getCH0E09() : null); // 其他手术操作术者
        homepage.setYz2(esize >= 2 ? ListEntityE.get(1).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz3(esize >= 3 ? ListEntityE.get(2).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz4(esize >= 4 ? ListEntityE.get(3).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz5(esize >= 5 ? ListEntityE.get(4).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz6(esize >= 6 ? ListEntityE.get(5).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz7(esize >= 7 ? ListEntityE.get(6).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz8(esize >= 8 ? ListEntityE.get(7).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz9(esize >= 9 ? ListEntityE.get(8).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz10(esize >= 10 ? ListEntityE.get(9).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz11(esize >= 11 ? ListEntityE.get(10).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz12(esize >= 12 ? ListEntityE.get(11).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz13(esize >= 13 ? ListEntityE.get(12).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz14(esize >= 14 ? ListEntityE.get(13).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz15(esize >= 15 ? ListEntityE.get(14).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz16(esize >= 16 ? ListEntityE.get(15).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz17(esize >= 17 ? ListEntityE.get(16).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz18(esize >= 18 ? ListEntityE.get(17).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz19(esize >= 19 ? ListEntityE.get(18).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz20(esize >= 20 ? ListEntityE.get(19).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz21(esize >= 21 ? ListEntityE.get(20).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz22(esize >= 22 ? ListEntityE.get(21).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz23(esize >= 23 ? ListEntityE.get(22).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz24(esize >= 24 ? ListEntityE.get(23).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz25(esize >= 25 ? ListEntityE.get(24).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz26(esize >= 26 ? ListEntityE.get(25).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz27(esize >= 27 ? ListEntityE.get(26).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz28(esize >= 28 ? ListEntityE.get(27).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz29(esize >= 29 ? ListEntityE.get(28).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz30(esize >= 30 ? ListEntityE.get(29).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz31(esize >= 31 ? ListEntityE.get(30).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz32(esize >= 32 ? ListEntityE.get(31).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz33(esize >= 33 ? ListEntityE.get(32).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz34(esize >= 34 ? ListEntityE.get(33).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz35(esize >= 35 ? ListEntityE.get(34).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz36(esize >= 36 ? ListEntityE.get(35).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz37(esize >= 37 ? ListEntityE.get(36).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz38(esize >= 38 ? ListEntityE.get(37).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz39(esize >= 39 ? ListEntityE.get(38).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz40(esize >= 40 ? ListEntityE.get(39).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setYz41(esize >= 41 ? ListEntityE.get(40).getCH0E14() : null); // 其他手术操作Ⅰ助
        homepage.setEz2(esize >= 2 ? ListEntityE.get(1).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz3(esize >= 3 ? ListEntityE.get(2).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz4(esize >= 4 ? ListEntityE.get(3).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz5(esize >= 5 ? ListEntityE.get(4).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz6(esize >= 6 ? ListEntityE.get(5).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz7(esize >= 7 ? ListEntityE.get(6).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz8(esize >= 8 ? ListEntityE.get(7).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz9(esize >= 9 ? ListEntityE.get(8).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz10(esize >= 10 ? ListEntityE.get(9).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz11(esize >= 11 ? ListEntityE.get(10).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz12(esize >= 12 ? ListEntityE.get(11).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz13(esize >= 13 ? ListEntityE.get(12).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz14(esize >= 14 ? ListEntityE.get(13).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz15(esize >= 15 ? ListEntityE.get(14).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz16(esize >= 16 ? ListEntityE.get(15).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz17(esize >= 17 ? ListEntityE.get(16).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz18(esize >= 18 ? ListEntityE.get(17).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz19(esize >= 19 ? ListEntityE.get(18).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz20(esize >= 20 ? ListEntityE.get(19).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz21(esize >= 21 ? ListEntityE.get(20).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz22(esize >= 22 ? ListEntityE.get(21).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz23(esize >= 23 ? ListEntityE.get(22).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz24(esize >= 24 ? ListEntityE.get(23).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz25(esize >= 25 ? ListEntityE.get(24).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz26(esize >= 26 ? ListEntityE.get(25).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz27(esize >= 27 ? ListEntityE.get(26).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz28(esize >= 28 ? ListEntityE.get(27).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz29(esize >= 29 ? ListEntityE.get(28).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz30(esize >= 30 ? ListEntityE.get(29).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz31(esize >= 31 ? ListEntityE.get(30).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz32(esize >= 32 ? ListEntityE.get(31).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz33(esize >= 33 ? ListEntityE.get(32).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz34(esize >= 34 ? ListEntityE.get(33).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz35(esize >= 35 ? ListEntityE.get(34).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz36(esize >= 36 ? ListEntityE.get(35).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz37(esize >= 37 ? ListEntityE.get(36).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz38(esize >= 38 ? ListEntityE.get(37).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz39(esize >= 39 ? ListEntityE.get(38).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz40(esize >= 40 ? ListEntityE.get(39).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setEz41(esize >= 41 ? ListEntityE.get(40).getCH0E15() : null); // 其他手术操作Ⅱ助
        homepage.setQkdj2(esize >= 2 ? ListEntityE.get(1).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj3(esize >= 3 ? ListEntityE.get(2).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj4(esize >= 4 ? ListEntityE.get(3).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj5(esize >= 5 ? ListEntityE.get(4).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj6(esize >= 6 ? ListEntityE.get(5).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj7(esize >= 7 ? ListEntityE.get(6).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj8(esize >= 8 ? ListEntityE.get(7).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj9(esize >= 9 ? ListEntityE.get(8).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj10(esize >= 10 ? ListEntityE.get(9).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj11(esize >= 11 ? ListEntityE.get(10).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj12(esize >= 12 ? ListEntityE.get(11).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj13(esize >= 13 ? ListEntityE.get(12).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj14(esize >= 14 ? ListEntityE.get(13).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj15(esize >= 15 ? ListEntityE.get(14).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj16(esize >= 16 ? ListEntityE.get(15).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj17(esize >= 17 ? ListEntityE.get(16).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj18(esize >= 18 ? ListEntityE.get(17).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj19(esize >= 19 ? ListEntityE.get(18).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj20(esize >= 20 ? ListEntityE.get(19).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj21(esize >= 21 ? ListEntityE.get(20).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj22(esize >= 22 ? ListEntityE.get(21).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj23(esize >= 23 ? ListEntityE.get(22).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj24(esize >= 24 ? ListEntityE.get(23).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj25(esize >= 25 ? ListEntityE.get(24).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj26(esize >= 26 ? ListEntityE.get(25).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj27(esize >= 27 ? ListEntityE.get(26).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj28(esize >= 28 ? ListEntityE.get(27).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj29(esize >= 29 ? ListEntityE.get(28).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj30(esize >= 30 ? ListEntityE.get(29).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj31(esize >= 31 ? ListEntityE.get(30).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj32(esize >= 32 ? ListEntityE.get(31).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj33(esize >= 33 ? ListEntityE.get(32).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj34(esize >= 34 ? ListEntityE.get(33).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj35(esize >= 35 ? ListEntityE.get(34).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj36(esize >= 36 ? ListEntityE.get(35).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj37(esize >= 37 ? ListEntityE.get(36).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj38(esize >= 38 ? ListEntityE.get(37).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj39(esize >= 39 ? ListEntityE.get(38).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj40(esize >= 40 ? ListEntityE.get(39).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkdj41(esize >= 41 ? ListEntityE.get(40).getCH0E12() : null); // 其他手术操作切口愈合等级
        homepage.setQkylb2(esize >= 2 ? ListEntityE.get(1).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb3(esize >= 3 ? ListEntityE.get(2).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb4(esize >= 4 ? ListEntityE.get(3).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb5(esize >= 5 ? ListEntityE.get(4).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb6(esize >= 6 ? ListEntityE.get(5).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb7(esize >= 7 ? ListEntityE.get(6).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb8(esize >= 8 ? ListEntityE.get(7).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb9(esize >= 9 ? ListEntityE.get(8).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb10(esize >= 10 ? ListEntityE.get(9).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb11(esize >= 11 ? ListEntityE.get(10).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb12(esize >= 12 ? ListEntityE.get(11).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb13(esize >= 13 ? ListEntityE.get(12).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb14(esize >= 14 ? ListEntityE.get(13).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb15(esize >= 15 ? ListEntityE.get(14).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb16(esize >= 16 ? ListEntityE.get(15).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb17(esize >= 17 ? ListEntityE.get(16).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb18(esize >= 18 ? ListEntityE.get(17).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb19(esize >= 19 ? ListEntityE.get(18).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb20(esize >= 20 ? ListEntityE.get(19).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb21(esize >= 21 ? ListEntityE.get(20).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb22(esize >= 22 ? ListEntityE.get(21).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb23(esize >= 23 ? ListEntityE.get(22).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb24(esize >= 24 ? ListEntityE.get(23).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb25(esize >= 25 ? ListEntityE.get(24).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb26(esize >= 26 ? ListEntityE.get(25).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb27(esize >= 27 ? ListEntityE.get(26).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb28(esize >= 28 ? ListEntityE.get(27).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb29(esize >= 29 ? ListEntityE.get(28).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb30(esize >= 30 ? ListEntityE.get(29).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb31(esize >= 31 ? ListEntityE.get(30).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb32(esize >= 32 ? ListEntityE.get(31).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb33(esize >= 33 ? ListEntityE.get(32).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb34(esize >= 34 ? ListEntityE.get(33).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb35(esize >= 35 ? ListEntityE.get(34).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb36(esize >= 36 ? ListEntityE.get(35).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb37(esize >= 37 ? ListEntityE.get(36).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb38(esize >= 38 ? ListEntityE.get(37).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb39(esize >= 39 ? ListEntityE.get(38).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb40(esize >= 40 ? ListEntityE.get(39).getCH0E13() : null); // 切口愈合类别
        homepage.setQkylb41(esize >= 41 ? ListEntityE.get(40).getCH0E13() : null); // 切口愈合类别
        homepage.setMzfs2(esize >= 2 ? ListEntityE.get(1).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs3(esize >= 3 ? ListEntityE.get(2).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs4(esize >= 4 ? ListEntityE.get(3).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs5(esize >= 5 ? ListEntityE.get(4).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs6(esize >= 6 ? ListEntityE.get(5).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs7(esize >= 7 ? ListEntityE.get(6).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs8(esize >= 8 ? ListEntityE.get(7).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs9(esize >= 9 ? ListEntityE.get(8).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs10(esize >= 10 ? ListEntityE.get(9).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs11(esize >= 11 ? ListEntityE.get(10).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs12(esize >= 12 ? ListEntityE.get(11).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs13(esize >= 13 ? ListEntityE.get(12).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs14(esize >= 14 ? ListEntityE.get(13).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs15(esize >= 15 ? ListEntityE.get(14).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs16(esize >= 16 ? ListEntityE.get(15).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs17(esize >= 17 ? ListEntityE.get(16).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs18(esize >= 18 ? ListEntityE.get(17).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs19(esize >= 19 ? ListEntityE.get(18).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs20(esize >= 20 ? ListEntityE.get(19).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs21(esize >= 21 ? ListEntityE.get(20).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs22(esize >= 22 ? ListEntityE.get(21).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs23(esize >= 23 ? ListEntityE.get(22).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs24(esize >= 24 ? ListEntityE.get(23).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs25(esize >= 25 ? ListEntityE.get(24).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs26(esize >= 26 ? ListEntityE.get(25).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs27(esize >= 27 ? ListEntityE.get(26).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs28(esize >= 28 ? ListEntityE.get(27).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs29(esize >= 29 ? ListEntityE.get(28).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs30(esize >= 30 ? ListEntityE.get(29).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs31(esize >= 31 ? ListEntityE.get(30).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs32(esize >= 32 ? ListEntityE.get(31).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs33(esize >= 33 ? ListEntityE.get(32).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs34(esize >= 34 ? ListEntityE.get(33).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs35(esize >= 35 ? ListEntityE.get(34).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs36(esize >= 36 ? ListEntityE.get(35).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs37(esize >= 37 ? ListEntityE.get(36).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs38(esize >= 38 ? ListEntityE.get(37).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs39(esize >= 39 ? ListEntityE.get(38).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs40(esize >= 40 ? ListEntityE.get(39).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzfs41(esize >= 41 ? ListEntityE.get(40).getCH0E10() : null); // 其他手术操作麻醉方式
        homepage.setMzys2(esize >= 2 ? ListEntityE.get(1).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys3(esize >= 3 ? ListEntityE.get(2).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys4(esize >= 4 ? ListEntityE.get(3).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys5(esize >= 5 ? ListEntityE.get(4).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys6(esize >= 6 ? ListEntityE.get(5).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys7(esize >= 7 ? ListEntityE.get(6).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys8(esize >= 8 ? ListEntityE.get(7).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys9(esize >= 9 ? ListEntityE.get(8).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys10(esize >= 10 ? ListEntityE.get(9).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys11(esize >= 11 ? ListEntityE.get(10).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys12(esize >= 12 ? ListEntityE.get(11).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys13(esize >= 13 ? ListEntityE.get(12).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys14(esize >= 14 ? ListEntityE.get(13).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys15(esize >= 15 ? ListEntityE.get(14).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys16(esize >= 16 ? ListEntityE.get(15).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys17(esize >= 17 ? ListEntityE.get(16).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys18(esize >= 18 ? ListEntityE.get(17).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys19(esize >= 19 ? ListEntityE.get(18).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys20(esize >= 20 ? ListEntityE.get(19).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys21(esize >= 21 ? ListEntityE.get(20).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys22(esize >= 22 ? ListEntityE.get(21).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys23(esize >= 23 ? ListEntityE.get(22).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys24(esize >= 24 ? ListEntityE.get(23).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys25(esize >= 25 ? ListEntityE.get(24).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys26(esize >= 26 ? ListEntityE.get(25).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys27(esize >= 27 ? ListEntityE.get(26).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys28(esize >= 28 ? ListEntityE.get(27).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys29(esize >= 29 ? ListEntityE.get(28).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys30(esize >= 30 ? ListEntityE.get(29).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys31(esize >= 31 ? ListEntityE.get(30).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys32(esize >= 32 ? ListEntityE.get(31).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys33(esize >= 33 ? ListEntityE.get(32).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys34(esize >= 34 ? ListEntityE.get(33).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys35(esize >= 35 ? ListEntityE.get(34).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys36(esize >= 36 ? ListEntityE.get(35).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys37(esize >= 37 ? ListEntityE.get(36).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys38(esize >= 38 ? ListEntityE.get(37).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys39(esize >= 39 ? ListEntityE.get(38).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys40(esize >= 40 ? ListEntityE.get(39).getCH0E16() : null); // 其他手术操作麻醉医师
        homepage.setMzys41(esize >= 41 ? ListEntityE.get(40).getCH0E16() : null); // 其他手术操作麻醉医师

        homepage.setMZFJ2(esize >= 2 ? ListEntityE.get(1).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ3(esize >= 3 ? ListEntityE.get(2).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ4(esize >= 4 ? ListEntityE.get(3).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ5(esize >= 5 ? ListEntityE.get(4).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ6(esize >= 6 ? ListEntityE.get(5).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ7(esize >= 7 ? ListEntityE.get(6).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ8(esize >= 8 ? ListEntityE.get(7).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ9(esize >= 9 ? ListEntityE.get(8).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ10(esize >= 10 ? ListEntityE.get(9).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ11(esize >= 11 ? ListEntityE.get(10).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ12(esize >= 12 ? ListEntityE.get(11).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ13(esize >= 13 ? ListEntityE.get(12).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ14(esize >= 14 ? ListEntityE.get(13).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ15(esize >= 15 ? ListEntityE.get(14).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ16(esize >= 16 ? ListEntityE.get(15).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ17(esize >= 17 ? ListEntityE.get(16).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ18(esize >= 18 ? ListEntityE.get(17).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ19(esize >= 19 ? ListEntityE.get(18).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ10(esize >= 20 ? ListEntityE.get(19).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ11(esize >= 21 ? ListEntityE.get(20).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ2(esize >= 22 ? ListEntityE.get(21).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ3(esize >= 23 ? ListEntityE.get(22).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ4(esize >= 24 ? ListEntityE.get(23).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ5(esize >= 25 ? ListEntityE.get(24).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ6(esize >= 26 ? ListEntityE.get(25).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ7(esize >= 27 ? ListEntityE.get(26).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ8(esize >= 28 ? ListEntityE.get(27).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ9(esize >= 29 ? ListEntityE.get(28).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ10(esize >= 30 ? ListEntityE.get(29).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ11(esize >= 31 ? ListEntityE.get(30).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ2(esize >= 32 ? ListEntityE.get(31).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ3(esize >= 33 ? ListEntityE.get(32).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ4(esize >= 34 ? ListEntityE.get(33).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ5(esize >= 35 ? ListEntityE.get(34).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ6(esize >= 36 ? ListEntityE.get(35).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ7(esize >= 37 ? ListEntityE.get(36).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ8(esize >= 38 ? ListEntityE.get(37).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ9(esize >= 39 ? ListEntityE.get(38).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ10(esize >= 40 ? ListEntityE.get(39).getCH0EE2() : null); // 麻醉分级
        homepage.setMZFJ11(esize >= 41 ? ListEntityE.get(40).getCH0EE2() : null); // 麻醉分级

        homepage.setSSCZBW2(esize >= 2 ? ListEntityE.get(1).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW3(esize >= 3 ? ListEntityE.get(2).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW4(esize >= 4 ? ListEntityE.get(3).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW5(esize >= 5 ? ListEntityE.get(4).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW6(esize >= 6 ? ListEntityE.get(5).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW7(esize >= 7 ? ListEntityE.get(6).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW8(esize >= 8 ? ListEntityE.get(7).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW9(esize >= 9 ? ListEntityE.get(8).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW10(esize >= 10 ? ListEntityE.get(9).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW11(esize >= 11 ? ListEntityE.get(10).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW22(esize >= 12 ? ListEntityE.get(11).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW23(esize >= 13 ? ListEntityE.get(12).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW24(esize >= 14 ? ListEntityE.get(13).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW25(esize >= 15 ? ListEntityE.get(14).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW26(esize >= 16 ? ListEntityE.get(15).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW27(esize >= 17 ? ListEntityE.get(16).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW28(esize >= 18 ? ListEntityE.get(17).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW29(esize >= 19 ? ListEntityE.get(18).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW20(esize >= 20 ? ListEntityE.get(19).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW21(esize >= 21 ? ListEntityE.get(20).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW22(esize >= 22 ? ListEntityE.get(21).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW23(esize >= 23 ? ListEntityE.get(22).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW24(esize >= 24 ? ListEntityE.get(23).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW25(esize >= 25 ? ListEntityE.get(24).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW26(esize >= 26 ? ListEntityE.get(25).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW27(esize >= 27 ? ListEntityE.get(26).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW28(esize >= 28 ? ListEntityE.get(27).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW29(esize >= 29 ? ListEntityE.get(28).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW30(esize >= 30 ? ListEntityE.get(29).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW31(esize >= 31 ? ListEntityE.get(30).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW32(esize >= 32 ? ListEntityE.get(31).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW33(esize >= 33 ? ListEntityE.get(32).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW34(esize >= 34 ? ListEntityE.get(33).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW35(esize >= 35 ? ListEntityE.get(34).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW36(esize >= 36 ? ListEntityE.get(35).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW37(esize >= 37 ? ListEntityE.get(36).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW38(esize >= 38 ? ListEntityE.get(37).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW39(esize >= 39 ? ListEntityE.get(38).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW40(esize >= 40 ? ListEntityE.get(39).getCH0EE4() : null); // 手术部位
        homepage.setSSCZBW41(esize >= 41 ? ListEntityE.get(40).getCH0EE4() : null); // 手术部位
    }

    /**
     * 装填B表数据
     */
    public static void fillB(HomepageEntity homepage, HpVsch0BEntity entityB) {
        homepage.setZfy(entityB.getCH0B83()); // 总费用
        homepage.setZfje(entityB.getCH0BP1()); // 自付金额
        homepage.setYlfwf(entityB.getCH0BP2()); // 综合医疗服务类(1)一般医疗服务费
        homepage.setBzlzf(entityB.getCh0BZ1()); // 中医辨证论治费
        homepage.setZyblzhzf(entityB.getCh0BZ2()); // 中医辨证论治会诊费
        homepage.setZlczf(entityB.getCH0BP3()); // (2)一般治疗操作费
        homepage.setHlf(entityB.getCH0BP4()); // (3)护理费
        homepage.setQtfy(entityB.getCH0BP5()); // (4)其他费用
        homepage.setBlzdf(entityB.getCH0BP6()); // 诊断类(5)病理诊断费
        homepage.setZdf(entityB.getCH0BP7()); // (6)实验室诊断费
        homepage.setYxxzdf(entityB.getCH0BP8()); // (7)影像学诊断费
        homepage.setLczdxmf(entityB.getCH0BP9()); // (8)临床诊断项目费
        homepage.setFsszlxmf(entityB.getCH0BPA()); // 治疗类(9)非手术治疗项目费
        homepage.setZlf(entityB.getCH0BPB()); // 临床物理治疗费
        homepage.setSszlf(entityB.getCH0BPC()); // (10)手术治疗费
        homepage.setMzf(entityB.getCH0BPD()); // 麻醉费
        homepage.setSsf(entityB.getCH0BPE()); // 手术费
        homepage.setKff(entityB.getCH0BPF()); // 康复类(11)康复费
        homepage.setZyl_zyzd(entityB.getCh0BZ3()); // 中医类(中医和名族医医疗服务)（12）中医诊断
        homepage.setZyzl(entityB.getCH0BPG()); // (13)中医治疗
        homepage.setZywz(entityB.getCh0BZ4()); // 中医外治
        homepage.setZygs(entityB.getCh0BZ5()); // 中医骨伤
        homepage.setZcyjf(entityB.getCh0BZ6()); // 针刺与灸法
        homepage.setZytnzl(entityB.getCh0BZ7()); // 中医推拿治疗
        homepage.setZygczl(entityB.getCh0BZ8()); // 中医肛肠治疗
        homepage.setZytszl(entityB.getCh0BZ9()); // 中医特殊治疗
        homepage.setZyqt(entityB.getCh0BZA()); // (14)中医其他
        homepage.setZytstpjg(entityB.getCh0BZB()); // 中医特殊调配加工
        homepage.setBzss(entityB.getCh0BZC()); // 辨证施膳
        homepage.setXyf(entityB.getCH0BPH()); // 西药类(15)西药费
        homepage.setKjywf(entityB.getCH0BPI()); // 抗菌药物费
        homepage.setZcyf(entityB.getCH0BPJ()); // 中药类(16)中成药费
        homepage.setZyzjf(entityB.getCh0BZD()); // 医疗机构中药制剂费
        homepage.setZcyf1(entityB.getCH0BPK()); // (17)中草药费
        homepage.setXf(entityB.getCH0BPL()); // 血液和血液制品类(18)血费
        homepage.setBdblzpf(entityB.getCH0BPM()); // (19)白蛋白类制品费
        homepage.setQdblzpf(entityB.getCH0BPN()); // (20)球蛋白类制品费
        homepage.setNxyzlzpf(entityB.getCH0BPO()); // (21)凝血因子类制品费
        homepage.setXbyzlzpf(entityB.getCH0BPP()); // (22)细胞因子类制品费
        homepage.setJcyyclf(entityB.getCH0BPQ()); // 耗材类(23)检查用一次性医用材料费
        homepage.setYyclf(entityB.getCH0BPR()); // (24)治疗用一次性医用材料费
        homepage.setSsycxclf(entityB.getCH0BPS()); // (25)手术用一次性医用材料费
        homepage.setQtf(entityB.getCH0BPT()); // 其他类(26)其他费
    }

    /**
     * 装填s表数据
     */
    public static void fillS(HomepageEntity homepage, List<HpVsch0SEntity> ListEntityS, int ssize) {
        homepage.setZZICULX(ssize > 0 ? ListEntityS.get(0).getCH0S03() : null); // ICU类型
        homepage.setZZICULX2(ssize > 1 ? ListEntityS.get(1).getCH0S03() : null); // ICU类型2
        homepage.setZZICULX3(ssize > 2 ? ListEntityS.get(2).getCH0S03() : null); // ICU类型3
        homepage.setZZICULX4(ssize > 3 ? ListEntityS.get(3).getCH0S03() : null); // ICU类型4
        homepage.setZZICULX5(ssize > 4 ? ListEntityS.get(4).getCH0S03() : null); // ICU类型5

        homepage.setZZRZSJ(ssize > 0 ? ListEntityS.get(0).getCH0S04() : null); // 入住ICU时间
        homepage.setZZRZSJ2(ssize > 1 ? ListEntityS.get(1).getCH0S04() : null); // 入住ICU时间2
        homepage.setZZRZSJ3(ssize > 2 ? ListEntityS.get(2).getCH0S04() : null); // 入住ICU时间3
        homepage.setZZRZSJ4(ssize > 3 ? ListEntityS.get(3).getCH0S04() : null); // 入住ICU时间4
        homepage.setZZRZSJ5(ssize > 4 ? ListEntityS.get(4).getCH0S04() : null); // 入住ICU时间5

        homepage.setZZZCSJ(ssize > 0 ? ListEntityS.get(0).getCH0S05() : null); // 转出ICU时间
        homepage.setZZZCSJ2(ssize > 1 ? ListEntityS.get(1).getCH0S05() : null); // 转出ICU时间2
        homepage.setZZZCSJ3(ssize > 2 ? ListEntityS.get(2).getCH0S05() : null); // 转出ICU时间3
        homepage.setZZZCSJ4(ssize > 3 ? ListEntityS.get(3).getCH0S05() : null); // 转出ICU时间4
        homepage.setZZZCSJ5(ssize > 4 ? ListEntityS.get(4).getCH0S05() : null); // 转出ICU时间5

        homepage.setZZZRICUJH(ssize > 0 ? String.valueOf(ListEntityS.get(0).getCH0S06()) : null); // 有无再入ICU计划
        homepage.setZZZRICUJH2(ssize > 1 ? String.valueOf(ListEntityS.get(1).getCH0S06()) : null); // 有无再入ICU计划2
        homepage.setZZZRICUJH3(ssize > 2 ? String.valueOf(ListEntityS.get(2).getCH0S06()) : null); // 有无再入ICU计划3
        homepage.setZZZRICUJH4(ssize > 3 ? String.valueOf(ListEntityS.get(3).getCH0S06()) : null); // 有无再入ICU计划4
        homepage.setZZZRICUJH5(ssize > 4 ? String.valueOf(ListEntityS.get(4).getCH0S06()) : null); // 有无再入ICU计划5

        homepage.setZZZRZYY(ssize > 0 ? ListEntityS.get(0).getCH0S07() : null); // 再入ICU原因
        homepage.setZZZRZYY2(ssize > 1 ? ListEntityS.get(1).getCH0S07() : null); // 再入ICU原因2
        homepage.setZZZRZYY3(ssize > 2 ? ListEntityS.get(2).getCH0S07() : null); // 再入ICU原因3
        homepage.setZZZRZYY4(ssize > 3 ? ListEntityS.get(3).getCH0S07() : null); // 再入ICU原因4
        homepage.setZZZRZYY5(ssize > 4 ? ListEntityS.get(4).getCH0S07() : null); // 再入ICU原因5

        homepage.setZZJHSPF(ssize > 0 ? ListEntityS.get(0).getCH0S08() : null); // 患者入ICU评分
        homepage.setZZJHSPF2(ssize > 1 ? ListEntityS.get(1).getCH0S08() : null); // 患者入ICU评分
        homepage.setZZJHSPF3(ssize > 2 ? ListEntityS.get(2).getCH0S08() : null); // 患者入ICU评分
        homepage.setZZJHSPF4(ssize > 3 ? ListEntityS.get(3).getCH0S08() : null); // 患者入ICU评分
        homepage.setZZJHSPF5(ssize > 4 ? ListEntityS.get(4).getCH0S08() : null); // 患者入ICU评分
    }

    /**
     * 装填k表数据
     */
    public static void fillK(HomepageEntity homepage, HpVsch0KEntity entityK) {
        if (StringUtil.isNotEmpty(homepage.getZXFLAG()) && homepage.getZXFLAG().equals("1")) {
            homepage.setMzd_zyzd(entityK.getCH0K02()); // 门(急)诊诊断(中医诊断)
            homepage.setJbdm(entityK.getCH0K02ID()); // 门(急)诊诊断疾病代码(中医诊断)
            homepage.setZz1(entityK.getCH0K07()); // 主证出院中医诊断
            homepage.setZz2(entityK.getCH0K14()); // 主证出院中医诊断
            homepage.setZz3(entityK.getCH0K15()); // 主证出院中医诊断
            homepage.setZz4(entityK.getZZ4()); // 主证出院中医诊断
            homepage.setZz5(entityK.getZZ5()); // 主证出院中医诊断
            homepage.setZz6(entityK.getZZ6()); // 主证出院中医诊断
            homepage.setZz7(entityK.getZZ7()); // 主证出院中医诊断
            homepage.setZz_jbbm1(entityK.getCH0K07ID()); // 主证疾病编码
            homepage.setZz_jbbm2(entityK.getCH0K14ID()); // 主证疾病编码
            homepage.setZz_jbbm3(entityK.getCH0K15ID()); // 主证疾病编码
            homepage.setZz_jbbm4(entityK.getZZ_JBBM4()); // 主证疾病编码
            homepage.setZz_jbbm5(entityK.getZZ_JBBM5()); // 主证疾病编码
            homepage.setZz_jbbm6(entityK.getZZ_JBBM6()); // 主证疾病编码
            homepage.setZz_jbbm7(entityK.getZZ_JBBM7()); // 主证疾病编码
            homepage.setZz_rybq1(entityK.getCh0KN2()); // 主证住入院病情
            homepage.setZz_rybq2(entityK.getCh0KN4()); // 主证住入院病情
            homepage.setZz_rybq3(entityK.getCh0KN3()); // 主证住入院病情
            homepage.setZz_rybq4(entityK.getZZ_RYBQ4()); // 主证住入院病情
            homepage.setZz_rybq5(entityK.getZZ_RYBQ5()); // 主证住入院病情
            homepage.setZz_rybq6(entityK.getZZ_RYBQ6()); // 主证住入院病情
            homepage.setZz_rybq7(entityK.getZZ_RYBQ7()); // 主证住入院病情
            homepage.setCH0K16ID(entityK.getCH0K16ID()); // 中医治法编码
            homepage.setZZ_ZFBM2(entityK.getZZ_ZFBM2()); // 中医治法编码
            homepage.setZZ_ZFBM3(entityK.getZZ_ZFBM3()); // 中医治法编码
            homepage.setZZ_ZFBM4(entityK.getZZ_ZFBM4()); // 中医治法编码
            homepage.setZZ_ZFBM5(entityK.getZZ_ZFBM5()); // 中医治法编码
            homepage.setZZ_ZFBM6(entityK.getZZ_ZFBM6()); // 中医治法编码
            homepage.setZZ_ZFBM7(entityK.getZZ_ZFBM7()); // 中医治法编码
            homepage.setCH0K16(entityK.getCH0K16()); // 中医治法名称
            homepage.setZZ_ZFMC2(entityK.getZZ_ZFMC2()); // 中医治法名称
            homepage.setZZ_ZFMC3(entityK.getZZ_ZFMC3()); // 中医治法名称
            homepage.setZZ_ZFMC4(entityK.getZZ_ZFMC4()); // 中医治法名称
            homepage.setZZ_ZFMC5(entityK.getZZ_ZFMC5()); // 中医治法名称
            homepage.setZZ_ZFMC6(entityK.getZZ_ZFMC6()); // 中医治法名称
            homepage.setZZ_ZFMC7(entityK.getZZ_ZFMC7()); // 中医治法名称
            homepage.setZY_CYQK_ZB(entityK.getCH0K08()); // 中医转归
            homepage.setZb_rybq(entityK.getCh0KN1()); // 出院主要中医疾病入院病情（中医疾病诊断）
            homepage.setZb_jbbm(entityK.getCH0K06ID()); // 出院主要中医疾病诊断编码（中医疾病诊断）
            homepage.setZb(entityK.getCH0K06()); // 出院主要中医疾病诊断名称（中医疾病诊断）
            homepage.setJbdm(entityK.getCH0K02ID()); // 门(急)诊中医疾病诊断编码（中医疾病诊断）1
            homepage.setJBDM_ZZ1(entityK.getCH0K03ID()); // 门(急)诊中医证候诊断编码（中医证候诊断）1
            homepage.setJBDM_ZZ2(entityK.getJBDM_ZZ2()); // 门(急)诊中医证候诊断编码（中医证候诊断）2
            homepage.setMZD_ZZ1(entityK.getCH0K03()); // 门(急)诊中医证候诊断名称（中医证候诊断）1
            homepage.setMZD_ZZ2(entityK.getMZD_ZZ2()); // 门(急)诊中医证候诊断名称（中医证候诊断）2
            homepage.setZZ_CYQK1(entityK.getZZ_CYQK1()); // 中医转归 主证 1
            homepage.setZZ_CYQK2(entityK.getZZ_CYQK2()); // 中医转归 主证 2
            homepage.setZZ_CYQK3(entityK.getZZ_CYQK3()); // 中医转归 主证 3
            homepage.setZZ_CYQK4(entityK.getZZ_CYQK4()); // 中医转归 主证 4
            homepage.setZZ_CYQK5(entityK.getZZ_CYQK5()); // 中医转归 主证 5
            homepage.setZZ_CYQK6(entityK.getZZ_CYQK6()); // 中医转归 主证 6
            homepage.setZZ_CYQK7(entityK.getZZ_CYQK7()); // 中医转归 主证 7
        }
    }

}
