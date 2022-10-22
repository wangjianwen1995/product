package com.sxdl.fm.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.fm.entity.FmTargetShow;
import com.sxdl.fm.service.FmSecondHandlerService;
import com.sxdl.fm.service.FmTargetShowService;
import com.sxdl.fm.util.app.FMone;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/indexData")
public class IndexController {
    @Autowired
    FmSecondHandlerService fmSecondHandlerService;

    @ApiOperation(value = "获取一段时间的17块", notes = "获取一段时间的17块")
    @GetMapping("/findByTime")
    @ResponseBody
    public ResultUtil findByTime(String sdate, String edate) {
        Map<String, Object> map = new HashMap ();
        String sDate1 = "";
        String edate1 = "";
        String sDate2 = "";
        String eDate2 = "";
        String sDate3 = "";
        String eDate3 = "";
        try {
            List<Map<String, Object>> bc = fmSecondHandlerService.selectGzlSum ( sdate, edate );
            SimpleDateFormat myFmt = new SimpleDateFormat ( "yyyy-MM-dd" );
            Date date = new Date ();
            sDate1 = DateUtil.getYearSDate ( DateUtil.year ( date ) );
            edate1 = myFmt.format ( date );
            List<Map<String, Object>> jn = fmSecondHandlerService.selectGzlSum ( sDate1, edate1 );
            sDate2 = DateUtil.getMonSDate ( 0 );
            eDate2 = myFmt.format ( date );
            sDate3 = DateUtil.getMonSDate ( -1 );
            eDate3 = DateUtil.getMonEDate ( 0 );
            List<Map<String, Object>> jy = fmSecondHandlerService.selectGzlSum ( sDate2, eDate2 );
            List<Map<String, Object>> sy = fmSecondHandlerService.selectGzlSum ( sDate3, eDate3 );
            map.put ( "bc", bc );
            map.put ( "jn", jn );
            map.put ( "jy", jy );
            map.put ( "sy", sy );
            return ResultUtil.success ( map );
        } catch (Exception e) {
            return ResultUtil.error ( "操作失败" );
        }
    }

    @ApiOperation(value = "获取折线图", notes = "获取折线图")
    @GetMapping("/findByFid")
    @ResponseBody
    public ResultUtil findByFid(String flag, Integer fid) {

        SimpleDateFormat myFmt = new SimpleDateFormat ( "yyyy-MM-dd" );
        Date date = new Date ();
        Calendar calendar = Calendar.getInstance ();
        String nameParam = FMone.getName ( fid );

        String sDate1 = "";
        String edate1 = "";
        String sDate2 = "";
        String eDate2 = "";
        String sDate3 = "";
        String eDate3 = "";
        int year;
        try {
            if (flag.equals ( "年" )) {
                year = DateUtil.year ( date );
                sDate1 = DateUtil.getYearSDate ( year );
                edate1 = myFmt.format ( date );
                sDate2 = DateUtil.getYearSDate ( year - 1 );
                eDate2 = DateUtil.getYearEDate ( year - 1 );
                sDate3 = DateUtil.getYearSDate ( year - 2 );
                eDate3 = DateUtil.getYearEDate ( year - 2 );
            } else {
                year = DateUtil.month ( date );
                year = year + 1;
                sDate1 = DateUtil.getMonSDate ( 0 );
                edate1 = myFmt.format ( date );
                sDate2 = DateUtil.getMonSDate ( -1 );
                sDate3 = DateUtil.getMonSDate ( -2 );
                eDate2 = DateUtil.getMonEDate ( 0 );
                eDate3 = DateUtil.getMonEDate ( -1 );
            }
            Map<Object, Object> map = fmSecondHandlerService.selectByYear (
                    sDate1, edate1, sDate2, eDate2, sDate3, eDate3, nameParam, year );
            System.out.println ( map );
            return ResultUtil.success ( map );
        } catch (Exception e) {
            return ResultUtil.error ( "操作失败" );
        }
    }


    @ApiOperation(value = "同比环比", notes = "同比环比")
    @GetMapping("/findByHBTB")
    @ResponseBody
    public ResultUtil findByHBTB(String sDate, String eDate, Integer fid) {
        String nameParam = FMone.getName ( fid );
        try {
            //查询同期环期值
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy-MM-dd" );
            // 字符串转日期时间
            LocalDate nowstime = LocalDate.parse ( sDate, formatter );
            LocalDate nowetime = LocalDate.parse ( eDate, formatter );
            int diffmonth = Period.between ( nowstime, nowetime ).getDays ();//输出 15
            //int diffmonth = Period.between(nowstime, nowetime).getMonths()+1;  //输出1
            //System.out.println (diffmonth);
            //环比的开始和结束时间
            LocalDate hbsDate = nowstime.plus ( -diffmonth, ChronoUnit.DAYS );
            LocalDate hbeDate = nowetime.plus ( -diffmonth, ChronoUnit.DAYS );
            LocalDate tbsDate = nowstime.plus ( -1, ChronoUnit.YEARS );
            LocalDate tbeDate = nowetime.plus ( -1, ChronoUnit.YEARS );
            List<Map<String, Object>> list = fmSecondHandlerService.selectByHBTB (
                    sDate, eDate, hbsDate, hbeDate, tbsDate, tbeDate, nameParam );
            return ResultUtil.success ( list );
        } catch (Exception e) {
            return ResultUtil.error ( "操作失败" );
        }
    }

    @ApiOperation(value = "根据科室查医生", notes = "根据科室查医生")
    @GetMapping("/findByKs")
    @ResponseBody
    public ResultUtil findByKs(String sDate, String eDate, Integer fid, String ks) {
        String nameParam = FMone.getName ( fid );
        try {
            Map<String, Object> map = fmSecondHandlerService.selectByKs ( sDate, eDate, nameParam, ks );
            System.out.println ( ResultUtil.success ( map ) );
            return ResultUtil.success ( map );
        } catch (Exception e) {
            return ResultUtil.error ( "操作失败" );
        }
    }

    @ApiOperation(value = "单病种", notes = "单病种")
    @GetMapping("/findBySd")
    @ResponseBody
    public ResultUtil findBySd(PageInfo pageInfo, String sDate, String eDate, String flag) {
        List<Map<String, Object>> map = new ArrayList<> ();
        String sql = "";
        try {
            if (flag.equals ( "单病种" )) {
                map = fmSecondHandlerService.findBySd ( sDate, eDate );
            } else {
                map = fmSecondHandlerService.findByKsAndSd ( sDate, eDate, flag );
                if (pageInfo == null || pageInfo.getPageNum () == 0 || pageInfo.getPageSize () == 0) {
                    return ResultUtil.success ( map );
                }
                Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), map );
                return ResultUtil.success ( listPage );
            }
            return ResultUtil.success ( map );
        } catch (Exception e) {
            return ResultUtil.error ( "操作失败" );
        }
    }

    @ApiOperation(value = "单病种下拉", notes = "单病种下拉")
    @GetMapping("/findSd")
    @ResponseBody
    public ResultUtil findSd() {
        try {
            List<Map<String, Object>> map= fmSecondHandlerService.findSd ();
            return ResultUtil.success ( map );
        } catch (Exception e) {
            return ResultUtil.error ( "操作失败" );
        }
    }


    @Autowired
    FmTargetShowService fmTargetShowService;
    List<FmTargetShow> shows, showList;
    List<String> strings;
    Map<String, Object> datas;

    @GetMapping("jx")
    public ResultUtil get(String year) {
//        shows = fmTargetShowService.findAll ();
//        showList = shows.stream ().filter ( e -> e.getXh () == 1 || e.getXh () == 2 || e.getXh () == 3 || e.getXh () == 4 || e.getXh () == 5 || e.getXh () == 31 || e.getXh () == 33 || e.getXh () == 36 || e.getXh () == 9 || e.getXh () == 37 ).collect ( Collectors.toList () );
//        datas = new HashMap<> ();
//        datas.put ( "infos", showList );
//        if (StringUtil.isEmpty ( year )) {
//            strings = showList.stream ().map ( FmTargetShow::getTyear ).collect ( Collectors.toList () );
//        } else {
//            int i = LocalDate.now ().getYear () - Integer.parseInt ( year );
//            if (i == 0) {
//                strings = showList.stream ().map ( FmTargetShow::getTyear ).collect ( Collectors.toList () );
//            } else if (i == 1) {
//                strings = showList.stream ().map ( FmTargetShow::getLyear ).collect ( Collectors.toList () );
//            } else if (1 == 2) {
//                strings = showList.stream ().map ( FmTargetShow::getQyear ).collect ( Collectors.toList () );
//            }
//        }
//        datas.put ( "echars", strings );
        shows = fmTargetShowService.findAll ();
        datas = new HashMap<> ();
        showList = shows.stream ().filter ( e -> e.getId () == 1 || e.getId () == 2 || e.getId () == 3 || e.getId () == 64 || e.getId () == 50 || e.getId () == 52 ).collect ( Collectors.toList () );
        datas.put ( "echars", showList );
        return ResultUtil.success ( datas );
    }

    @GetMapping("zycy")
    public ResultUtil zycy(){
        return ResultUtil.success ( fmSecondHandlerService.selectIndexCYZY());
    }

}
