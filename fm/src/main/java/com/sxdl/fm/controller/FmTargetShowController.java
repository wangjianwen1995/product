package com.sxdl.fm.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.fm.dao.dao1.FmTargetShowDao;
import com.sxdl.fm.entity.FmTargetShow;
import com.sxdl.fm.service.FmTargetShowService;
import com.sxdl.fm.util.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "数据展示")
@RestController
@RequestMapping("/targetShow")
public class FmTargetShowController {

    @Autowired
    FmTargetShowService fmTargetShowService;

    @Autowired
    FmTargetShowDao fmTargetShowDao;

    @ApiOperation(value = "查询所有", notes = "查询所有数据")
    @GetMapping("/finfAll")
    public ResultUtil<PageInfo<FmTargetShow>> findAll(PageInfo pageInfo, String name,String type) {
        try {
            FmTargetShow show = new FmTargetShow();
            show.setItemname(name);
            //前端传入1的话，就需要重新计算指标再进行展示
            if("1".equals(type)){
                fmTargetShowDao.excuteProcedue("targetshow");
            }
            PageInfo<FmTargetShow> list = fmTargetShowService.queryPageListOrderBy(pageInfo, show,"id","ASC");
            return ResultUtil.success(list);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }

    }


    @ApiOperation(value = "导出", notes = "导出EXCEL")
    @GetMapping("/exportOperateLog")
    @ResponseBody
    public void exportOperateLog(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            response.reset();
            response.setContentType("text/html;charset=GBK");// 设置response内容的类型
            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode("三级公立医院绩效考核指标数据") + dateFormat.format(new Date()) + ".xls;");
            String strTableName = "三级公立医院绩效考核指标数据"; //这个是标题
            List<String> headers = new ArrayList<>();

            Date date = DateUtil.date();
            int year=DateUtil.year(date);
            int lyear=year-1;
            int qyear=year-2;
            int month=DateUtil.month(date);

            headers.add("序号"); //这里的表头，根据数据的字段命名也行，随你喜欢
            headers.add("三级指标");
            headers.add("评价使用数据项");
            headers.add("满分值（临界值）");
            headers.add("单位");
            headers.add("科室");
            headers.add(qyear+"年");
            headers.add(lyear+"年");
            headers.add(year+"年"+month+"月");
            List<FmTargetShow> datas = fmTargetShowService.findAll();
            List<String[]> operateListStr = new ArrayList<>();
            for (int i = 0; i < datas.size(); i++) {
                FmTargetShow data = datas.get(i);
                String[] strarr = new String[]{(StringUtils.isEmpty(data.getXh().toString()) ? "-" : data.getXh().toString()),
                        (StringUtils.isEmpty(data.getTargetname()) ? "-" : data.getTargetname()),
                        (StringUtils.isEmpty(data.getItemname()) ? "-" : data.getItemname()),
                        (StringUtils.isEmpty(data.getCritical()) ? "-" : data.getCritical()),
                        (StringUtils.isEmpty(data.getUnit()) ? "-" : data.getUnit()),
                        (StringUtils.isEmpty(data.getKsname()) ? "-" : data.getKsname()),
                        (StringUtils.isEmpty(data.getQyear()) ? "" : data.getQyear()),
                        (StringUtils.isEmpty(data.getLyear()) ? "" : data.getLyear()),
                        (StringUtils.isEmpty(data.getTyear()) ? "" : data.getTyear()),
                };
                operateListStr.add(strarr);
            }

            ExcelUtil.createExcel(strTableName, headers, operateListStr, response.getOutputStream());

        } catch (IOException e) {
            e.getMessage();
        }
    }


}
