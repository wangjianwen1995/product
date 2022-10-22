package com.sxdl.fm.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.fm.service.FmSecondHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("drgs")
public class HbiFmDrgsController {
    @Autowired
    FmSecondHandlerService fmSecondHandlerService;
    StringBuffer sb;
    LocalDate ld;
    String fn = "2020.11月DRGs分组明细信息20201212170008.xlsx";
    String sql = "INSERT INTO T_fm_drgs_dr_temp ([biyear], [biquarter], [bimonth], [biweek], [bah], [ryrq], [cyrq], [lyfs], [xm], [xb], [nl], [cyks], [zyts], [drgsbm], [drgsmc], [bzmc], [rw], [zyzdbm], [zyzdmc], [dyssbm], [dyssmc], [zfy], [xyf], [zyf], [hcf], [kzr], [zrys], [zzys], [zyys]) VALUES (", end = ")", sep = ",", sinq = "'";
    String tracsql = "TRUNCATE table T_fm_drgs_dr_temp";
    String bah, cyrq, lyfs, kzr, zrys, zzys, zyys, selectsql, fname;
    List<Map<String, Object>> datas;
    @PostMapping("upload")
    public ResultUtil upload(MultipartFile name) throws IOException {
        if (null == name) return ResultUtil.error("文件不能为空!");
        fname = name.getOriginalFilename();
        if (!fname.contains(".") && !fname.endsWith("xls") && !fname.endsWith("xlsx"))
            return ResultUtil.error("文件格式必须是xls或者xlsx!");
        long s = System.currentTimeMillis();
        ExcelReader reader = ExcelUtil.getReader(name.getInputStream());
        List<List<Object>> list = reader.read(0);
        if (null == list || list.size() == 0 || list.get(0).size() != 26) return ResultUtil.error("上传文件格式错误!必须是26列!");
        list.remove(0);//移除第一行
        fmSecondHandlerService.updateSqlWithSQL(tracsql);//将全部数据插入缓存表
        list.forEach(e -> {
            sb = new StringBuffer(sql);
            bah = e.get(0).toString();
            cyrq = e.get(2).toString();
            kzr = e.get(21).toString();//科主任
            zrys = e.get(22).toString();//主任医师
            zzys = e.get(23).toString();//主治医师
            zyys = e.get(24).toString();//住院医师
            switch (e.get(3).toString()) {
                case "1":
                    lyfs = "1-治愈";
                    break;
                case "2":
                    lyfs = "2-好转";
                    break;
                case "3":
                    lyfs = "3-未愈";
                    break;
                case "4":
                    lyfs = "4-死亡";
                    break;
                case "5":
                    lyfs = "5-其他";
                    break;
            }
            try {
                ld = DateUtil.formatYYYYMMDDFromDateToLocalDate(cyrq);
                sb.append(ld.getYear()).append(sep)//年
                        .append(DateUtil.getQuarter(ld.getMonthValue())).append(sep)//季度
                        .append(ld.getMonthValue()).append(sep)//月
                        .append(DateUtil.getWeek(ld)).append(sep)//周
                        .append(sinq).append(bah).append(sinq).append(sep)//病案号
                        .append(sinq).append(DateUtil.formatYYYYMMDDFromDateToYMDHmS(e.get(1).toString())).append(sinq).append(sep)//入院日期
                        .append(sinq).append(DateUtil.formatYYYYMMDDFromDateToYMDHmS(cyrq)).append(sinq).append(sep)//出院日期
                        .append(sinq).append(lyfs).append(sinq).append(sep)//离院方式
                        .append(sinq).append(e.get(4)).append(sinq).append(sep)//姓名
                        .append(sinq).append(e.get(5)).append(sinq).append(sep)//性别
                        .append(sinq).append(e.get(6)).append(sinq).append(sep)//年龄
                        .append(sinq).append(e.get(7)).append(sinq).append(sep)//出院科室
                        .append(sinq).append(e.get(8)).append(sinq).append(sep)//住院天数
                        .append(sinq).append(e.get(9)).append(sinq).append(sep)//drgs编码
                        .append(sinq).append(e.get(10)).append(sinq).append(sep)//drgs名称
                        .append(sinq).append(e.get(11)).append(sinq).append(sep)//病种名称
                        .append(sinq).append(e.get(12)).append(sinq).append(sep)//RW
                        .append(sinq).append(e.get(13)).append(sinq).append(sep)//主要诊断编码
                        .append(sinq).append(e.get(14)).append(sinq).append(sep)//主要诊断名称
                        .append(sinq).append(e.get(15)).append(sinq).append(sep)//第一手术编码
                        .append(sinq).append(e.get(16)).append(sinq).append(sep)//第一手术名称
                        .append(sinq).append(e.get(17)).append(sinq).append(sep)//总费用
                        .append(sinq).append(e.get(18)).append(sinq).append(sep)//西药费
                        .append(sinq).append(e.get(19)).append(sinq).append(sep)//中药费
                        .append(sinq).append(e.get(20)).append(sinq).append(sep)//耗材费
                        .append(sinq).append(kzr).append(sinq).append(sep)//科主任
                        .append(sinq).append(zrys).append(sinq).append(sep)//主任医师
                        .append(sinq).append(zzys).append(sinq).append(sep)//主治医师
                        .append(sinq).append(zyys).append(sinq)//住院医师
                        .append(end);
                fmSecondHandlerService.selectSqlWithSQL(sb.toString());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
//            }
        });
        fmSecondHandlerService.updateWFromDrgs(5);
        fmSecondHandlerService.updateWFromDrgs(1);
        fmSecondHandlerService.updateWFromDrgs(2);
        fmSecondHandlerService.updateWFromDrgs(3);
        fmSecondHandlerService.updateWFromDrgs(4);
        return ResultUtil.success("上传并保存成功!耗时" + (System.currentTimeMillis() - s) / 1000 + "秒!");
    }
}
