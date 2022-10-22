package com.sxdl.base.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
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

public class PoiUtils {

    /**
     * 获取导出excel的数据合并单元格的长度
     *
     * @param maps   数据列表
     * @param colmap 字段列表
     * @return
     */
    private static Integer getMapKeyLen(List<Map<String, Object>> maps, Map colmap) throws Exception {
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
        ExcelWriter writer = ExcelUtil.getWriter(ApplicationRunnerImpl.FILESPATH + "/execl/" + title + ".xslx");
        writer.merge(getMapKeyLen(data, colmap), title);
        if (MapUtil.isNotEmpty(colmap)) {
            for (String key : colmap.keySet()) {
                writer.addHeaderAlias(key, colmap.get(key));
            }
        }
        Workbook workbook = writer.write(data, true).getWorkbook();
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(title, "UTF-8") + ".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    /**
     * 生成超长excel,并响应输出
     *
     * @param path
     * @param title
     * @param length
     * @param response
     * @param data
     * @throws Exception
     */
    public static void createBigExcel(String path, String title, int length, HttpServletResponse response, Collection data) throws Exception {
        BigExcelWriter writer = ExcelUtil.getBigWriter(path);
        writer.merge(length, "测试标题");
        Workbook workbook = writer.write(data).getWorkbook();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public static String createExcel(String fileName, String filePath, List<String> header, List<LinkedHashMap<String, Object>> data
    ) throws IOException {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");
        // 添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell cellTitle = hssfRow.createCell(0);
        // 设置标题外的单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font1 = workbook.createFont();
        font1.setFontName("宋体");
        font1.setFontHeightInPoints((short) 12);//设置字体大小
        cellStyle.setFont(font1);
        //设置标题的样式
        HSSFCellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置标题字体的样式
        HSSFFont font = workbook.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 14);//设置字体大小
        titleCellStyle.setFont(font);
        //标题设置(四个参数分别表示起始行，终止行，起始列，终止列)
        cellTitle.setCellValue(fileName);
        int lastCol = header.size() > 1 ? header.size() : 2;
        CellRangeAddress region1 = new CellRangeAddress(0, 1, (short) 0, (short) lastCol - 1);
        sheet.addMergedRegion(region1);
        hssfRow = sheet.createRow(1);
        hssfRow = sheet.createRow(2);
        cellTitle.setCellStyle(titleCellStyle);
        // 添加表头内容
        for (int i = 0; i < header.size(); i++) {
            sheet.setColumnWidth(i, 120 * 50);
            HSSFCell headCell = hssfRow.createCell(i);
            headCell.setCellValue(header.get(i));
            headCell.setCellStyle(cellStyle);
        }

        // 添加数据内容
        for (int i = 0; i < data.size(); i++) {
            LinkedHashMap<String, Object> map = data.get(i);
            hssfRow = sheet.createRow(i + 3);
            for (Object value : map.values()) {
                //short lastCellNum = hssfRow.getLastCellNum();
                HSSFCell cell = hssfRow.createCell(hssfRow.getLastCellNum() > 0 ? hssfRow.getLastCellNum() : 0);
                cell.setCellValue(value.toString());
                cell.setCellStyle(cellStyle);
            }


        }
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        workbook.write(file);
        workbook.close();
        return filePath;
    }

    public static HSSFWorkbook createExcel2(String fileName, List<String> header, List<LinkedHashMap<String, Object>> data
    ) throws IOException {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");
        // 添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell cellTitle = hssfRow.createCell(0);
        // 设置标题外的单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font1 = workbook.createFont();
        font1.setFontName("宋体");
        font1.setFontHeightInPoints((short) 12);//设置字体大小
        cellStyle.setFont(font1);
        //设置标题的样式
        HSSFCellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置标题字体的样式
        HSSFFont font = workbook.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 14);//设置字体大小
        titleCellStyle.setFont(font);
        //标题设置(四个参数分别表示起始行，终止行，起始列，终止列)
        cellTitle.setCellValue(fileName);
        int lastCol = header.size() > 1 ? header.size() : 2;
        CellRangeAddress region1 = new CellRangeAddress(0, 1, (short) 0, (short) lastCol - 1);
        sheet.addMergedRegion(region1);
        hssfRow = sheet.createRow(1);
        hssfRow = sheet.createRow(2);
        cellTitle.setCellStyle(titleCellStyle);
        // 添加表头内容
        for (int i = 0; i < header.size(); i++) {
            sheet.setColumnWidth(i, 120 * 50);
            HSSFCell headCell = hssfRow.createCell(i);
            headCell.setCellValue(header.get(i));
            headCell.setCellStyle(cellStyle);
        }

        // 添加数据内容
        for (int i = 0; i < data.size(); i++) {
            LinkedHashMap<String, Object> map = data.get(i);
            hssfRow = sheet.createRow(i + 3);
            for (Object value : map.values()) {
                //short lastCellNum = hssfRow.getLastCellNum();
                HSSFCell cell = hssfRow.createCell(hssfRow.getLastCellNum() > 0 ? hssfRow.getLastCellNum() : 0);
                cell.setCellValue(StringUtils.isEmpty(value) ? "" : value.toString());
                cell.setCellStyle(cellStyle);
            }
        }
        return workbook;
    }



}
