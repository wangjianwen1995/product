package com.sxdl.fm.controller;

import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.fm.service.HbiTlfgzlzbService;
import com.sxdl.fm.util.app.FmAllTwenty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("hbiTlfgzlzb")
public class HbiTlfgzlzbController {
    @Autowired
    HbiTlfgzlzbService hbiTlfgzlzbService;
    @Autowired
    AppFrontController appFrontController;
    List<FmAllTwenty> list1;
    @ApiOperation(value = "保存报表数据", notes = "保存报表数据")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil save() {
        try {
            String guid = "a97ab58d-5743-4fdd-ac5e-31631bec26fb";
            Calendar instance = Calendar.getInstance ();
            instance.add ( Calendar.DAY_OF_YEAR, -1 );
            String time = DateUtil.dateToStr ( instance.getTime () );
            String cxtj = time + ";" + time+"|@novalue";//"2019-11-14;2020-11-14";
            List<FmAllTwenty> list = appFrontController.getHttpReport ( guid, "admin", cxtj );
            hbiTlfgzlzbService.insertSome ( list, time );
        } catch (Exception e) {
            return ResultUtil.error ( "操作失败" );
        }
        return ResultUtil.success ( "操作成功" );
    }

    @ApiOperation(value = "抽取历史数据", notes = "抽取历史数据")
    @PostMapping("/saveHistory")
    @ResponseBody
    public ResultUtil saveHistory(String sdate,String edate) {
        String guid = "a97ab58d-5743-4fdd-ac5e-31631bec26fb";
        try {
            List<String> list = DateUtil.getSplicTimeParam ( sdate, edate, "天", 1 );
            list.forEach ( e -> {
                list1= appFrontController.getHttpReport ( guid, "admin", e + ";" + e+"|@novalue" );
                if(list1!=null&&list1.size ()>0){
                    hbiTlfgzlzbService.insertSome ( list1, e );
                }
            } );
        } catch (ParseException e) {
            e.printStackTrace ();
            return ResultUtil.error ( "操作失败" );
        }
        return ResultUtil.success ( "操作成功" );
    }

}
