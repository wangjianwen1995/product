package com.sxdl.sd.controller;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SysNotice;
import com.sxdl.sd.service.SysNoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class SysNoticeController {
    @Autowired
    private SysNoticeService sysNoticeService;

    @ApiOperation(value = "根据时间范围查询公告信息", notes = "根据时间范围查询公告信息")
    @GetMapping("/findNotices")
    @ResponseBody
    public ResultUtil findNotices(PageInfo pageInfo, @RequestParam(value = "stime",required = true) String stime,
                                 @RequestParam(value = "etime",required = true) String etime) {
        try {
            stime += " 00:00:00";
            etime += " 23:59:59";
            List<SysNotice> sysNoticeList = sysNoticeService.findByTime (stime,etime);
            if (pageInfo == null || pageInfo.getPageNum () == 0 || pageInfo.getPageSize () == 0) {
                return ResultUtil.success ( sysNoticeList );
            }
            Map<String, Object> listPage = com.sxdl.base.util.PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), sysNoticeList );
            return ResultUtil.success ( listPage );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "根据时间范围查询已发布公告信息", notes = "根据时间范围查询已发布公告信息")
    @GetMapping("/findNoticesByFlag")
    @ResponseBody
    public ResultUtil findNoticesByFlag( @RequestParam(value = "stime",required = true) String stime,
                                  @RequestParam(value = "etime",required = true) String etime) {
        try {
            stime += " 00:00:00";
            etime += " 23:59:59";
            List<SysNotice> sysNoticeList = sysNoticeService.findByTimeByFlag (stime,etime);
            return ResultUtil.success ( sysNoticeList );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存修改公告信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysNotice sysNotice ) {
        if (sysNotice == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            if(sysNotice.getFlag() ==null || "".equals(sysNotice.getFlag())) {
                sysNotice.setFlag("0");
            }
            Integer id=sysNotice.getId();
            if("".equals(id) || null==id){
                String updateTime = DateUtil.now();
                sysNotice.setCreate_time(updateTime);
                sysNotice.setUpdate_time(updateTime);
                sysNoticeService.insert(sysNotice);
            }else{
                String updateTime = DateUtil.now();
                sysNotice.setUpdate_time(updateTime);
                sysNoticeService.update(sysNotice);
            }
            return  ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }


    @ApiOperation(value="删除公告信息",notes="删除公告信息")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
        try{
            sysNoticeService.deleteById(id);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
    }
}
