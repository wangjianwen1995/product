package com.sxdl.hp.util;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.hp.dbo.AddrResult;
import com.sxdl.hp.entity.HpAreaZip;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AddressUtil {
    private static AddressUtil au;
    public List<HpAreaZip> hpAreaZips = (List<HpAreaZip>) HpApplicationRunnerImpl.contextMap.get("areaZip");
    Map<String, List<HpAreaZip>> shengs = hpAreaZips.stream().filter(e -> e.getGrade() == 2).collect(Collectors.groupingBy(HpAreaZip::getName));
    Map<String, List<HpAreaZip>> shis = hpAreaZips.stream().filter(e -> e.getGrade() == 3).collect(Collectors.groupingBy(HpAreaZip::getName));
    List<HpAreaZip> xians = hpAreaZips.stream().filter(e -> e.getGrade() == 4).collect(Collectors.toList());

    /**
     * 简单单例构造器
     */
    public static AddressUtil build() {
        if (null == au) {
            return new AddressUtil();
        }
        return au;
    }

    //已经弃用
    @Deprecated
    public static List<Map<String, String>> addressResolution(String address) {
        //特殊：特别行政区 台湾省
        //1级 省 自治区  2级 市 自治州 地区 3级：区县市旗(镇？)
        String province = null, city = null, provinceAndCity = null, town = null, detailAddress = null;
        Map<String, String> row = new LinkedHashMap<String, String>();
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        if (address.contains("特别行政区")) {
            //特殊处理
        } else if (address.contains("香港")) {
            //特殊处理
        } else if (address.contains("澳门")) {
            //特殊处理
        } else if (address.contains("台湾")) {
            //特殊处理
        } else {
            //普通地址
            String regex = "((?<provinceAndCity>[^市]+市|.*?自治州)(?<town>[^县]+县|.*?区|.*?镇|.*?市|.*?旗)(?<detailAddress>.*))";
            Matcher m = Pattern.compile(regex).matcher(address);
            while (m.find()) {
                provinceAndCity = m.group("provinceAndCity");
                String regex2 = "((?<province>[^省]+省|.+自治区|上海市|北京市|天津市|重庆市|上海|北京|天津|重庆)(?<city>.*))";
                Matcher m2 = Pattern.compile(regex2).matcher(provinceAndCity);
                while (m2.find()) {
                    province = m2.group("province");
                    row.put("province", province == null ? "" : province.trim());
                    city = m2.group("city");
                    row.put("city", city == null ? "" : city.trim());
                }
                town = m.group("town");
                row.put("town", town == null ? "" : town.trim());
                detailAddress = m.group("detailAddress");
                row.put("detailAddress", detailAddress == null ? "" : detailAddress.trim());
                table.add(row);
            }
        }
        return table;
    }

    //已经弃用
    @Deprecated
    public static List<Map<String, String>> addressResolutionPlus(String address) {
        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String province = null, city = null, county = null, town = null, village = null;
        List<Map<String, String>> table = new ArrayList<Map<String, String>>();
        Map<String, String> row = null;
        while (m.find()) {
            row = new LinkedHashMap<String, String>();
            province = m.group("province");
            row.put("province", province == null ? "" : province.trim());
            city = m.group("city");
            row.put("city", city == null ? "" : city.trim());
            county = m.group("county");
            row.put("county", county == null ? "" : county.trim());
            town = m.group("town");
            row.put("town", town == null ? "" : town.trim());
            village = m.group("village");
            row.put("village", village == null ? "" : village.trim());
            table.add(row);
        }
        return table;
    }

    /**
     * 获取除了行政区划外的详细地址信息
     *
     * @param addr     待解析的信息
     * @param areaName 需要处理的行政区划名称
     * @return
     */
    public static String getDetail(String addr, String areaName) {
        return addr.substring(addr.indexOf(areaName) + areaName.length());
    }

    public AddrResult fromAll(HpAreaZip area, String addr) {
        return AddrResult.builder().hasxian("1").xian(area.getXian()).hasshi("1").shi(area.getShi()).hassheng("1").sheng(area.getSheng())
                .detail(getDetail(addr, area.getXian())).area(area).build();
    }

    public AddrResult fromShiSheng(HpAreaZip area, String addr) {
        return AddrResult.builder().hasshi("1").shi(area.getShi()).hassheng("1").sheng(area.getSheng()).detail(getDetail(addr, area.getShi())).area(area).build();
    }

    public AddrResult fromSheng(HpAreaZip area, String addr) {
        return AddrResult.builder().hassheng("1").sheng(area.getSheng()).detail(getDetail(addr, area.getSheng())).area(area).build();
    }

    public AddrResult fromNull() {
        return AddrResult.builder().build();
    }

    public AddrResult addrResolutPro(String addr) {
        List<HpAreaZip> resultShi, result = xians.stream().filter(e -> addr.contains(e.getXian())).collect(Collectors.toList());
        HpAreaZip area;
        if (result.isEmpty()) {//没有匹配到区县
            //直接从全部市中取值
            return getAddrFromALLShi(addr, result);
        } else if (result.size() == 1) { //唯一的县区名称
            area = result.get(0);
            return fromAll(area, addr);
        } else {//重名的区县,匹配市或者省
            resultShi = result.stream().filter(e -> addr.contains(e.getShi())).collect(Collectors.toList());
            if (resultShi.isEmpty()) { //在重名的区县列表数据中,查不到对应的市
                //直接从全部市中取值
                return getAddrFromALLShi(addr, result);
            } else if (resultShi.size() == 1) {//重名的区县能匹配上市
                HpAreaZip finalArea = resultShi.get(0);
                area = result.stream().filter(e -> e.getShi_code().equals(finalArea.getShi_code())).collect(Collectors.toList()).get(0);
                return fromAll(area, addr);
            } else {
                //同一个市下类似的区县名称
                result = result.stream().filter(e -> addr.contains(e.getFullname())).collect(Collectors.toList());
                if (!result.isEmpty()) {
                    area = result.get(0);
                    return fromAll(area, addr);
                }
            }
        }
        return fromNull();
    }

    /**
     * 直接从全部市列表中查取数据
     *
     * @param addr
     * @return
     */
    private AddrResult getAddrFromALLShi(String addr, List<HpAreaZip> result) {
        HpAreaZip area;
        List<String> collect = shis.keySet().stream().filter(e -> addr.contains(e)).collect(Collectors.toList());
        if (!collect.isEmpty()) {//查到有相应的市
            area = shis.get(collect.get(0)).get(0);
            return fromShiSheng(area, addr);
        } else {//查不到相应的市,直接从全部省去查
            List<String> finalCollect = shengs.keySet().stream().filter(e -> addr.contains(e)).collect(Collectors.toList());
            if (!finalCollect.isEmpty()) {//查到相应的省,返回省信息
                if (CollUtil.isNotEmpty(result)) {//能查到县,查不到市,能查到省,倒查全部
                    List<HpAreaZip> list = result.stream().filter(e -> e.getSheng().equals(finalCollect.get(0))).collect(Collectors.toList());
                    if (list.size() == 1) {//倒查出来数据只有一条,那就返回全部
                        area = list.get(0);
                        return fromAll(area, addr);
                    } else {//如果有多条,只返回省代码
                        area = shengs.get(finalCollect.get(0)).get(0);
                    }
                } else {
                    area = shengs.get(finalCollect.get(0)).get(0);
                }
                return fromSheng(area, addr);
            } else {//查不到省,直接返回空的
                return fromNull();
            }
        }
    }

}
