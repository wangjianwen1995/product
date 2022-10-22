package com.sxdl.hp.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.sxdl.base.util.DateUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用的excel导出下载的工具类
 */
public class PoiUtil {

    /**
     * 获取导出excel的数据合并单元格的长度
     *
     * @param maps   数据列表
     * @param colmap 字段列表
     * @return
     */
    private static Integer getMapKeyLen(List<Map<String, Object>> maps, Map colmap) {
        int len = 0;
        if (CollUtil.isEmpty(colmap)) {
            if (CollUtil.isNotEmpty(maps)) {
                len = maps.get(0).size();
            }
        } else {
            len = colmap.size() - 1;
        }
        return len;
    }

    /**
     * 生成普通excel,并响应输出
     *
     * @param title    报表名称
     * @param response 响应
     * @param data     具体数据
     * @throws Exception
     */
    public static void createExcel(String title, HttpServletResponse response, List<Map<String, Object>> data, Map<String, String> colmap) throws Exception {
        String path=HpApplicationRunnerImpl.FILESPATH + "/execl/" + title + ".xslx";
        if(CollUtil.isEmpty(data)){
            return;
        }
        ExcelWriter writer;
        //数据量大时,使用超大excel
        if(data.size()>10000){
             writer = ExcelUtil.getBigWriter(path);
        }else {
            writer= ExcelUtil.getWriter(path);
        }
        writer.merge(getMapKeyLen(data, colmap), title);
        if (MapUtil.isNotEmpty(colmap)) {
            for (String key : colmap.keySet()) {
                writer.addHeaderAlias(key, colmap.get(key));
            }
        }
        Workbook workbook = writer.write(data, true).getWorkbook();
        response.reset();
        //处理乱码问题
        response.setCharacterEncoding("UTF-8");
        //设置上下文类型,普通excel2003
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //excel2007以后
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(title+"_"+ DateUtil.today(), "UTF-8") + ".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }




}
