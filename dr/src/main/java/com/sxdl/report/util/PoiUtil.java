package com.sxdl.report.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class PoiUtil {

    public static void main(String[] args) throws IOException {


    }

    public static String createExcel(String fileName,String filePath ,List<String> header, List<LinkedHashMap<String, Object>> data
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
            sheet.setColumnWidth(i,  120  *  50 );
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
                HSSFCell cell = hssfRow.createCell(hssfRow.getLastCellNum()>0?hssfRow.getLastCellNum():0);
                cell.setCellValue(value.toString());
                cell.setCellStyle(cellStyle);
            }


        }
        File file = new File(filePath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        if(!file.exists()){
            file.createNewFile();
        }

        workbook.write(file);
        workbook.close();
        return filePath;
    }

    public static HSSFWorkbook createExcel2(String fileName ,List<String> header, List<LinkedHashMap<String, Object>> data
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
            sheet.setColumnWidth(i,  120  *  50 );
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
                HSSFCell cell = hssfRow.createCell(hssfRow.getLastCellNum()>0?hssfRow.getLastCellNum():0);
                cell.setCellValue(StringUtils.isEmpty(value)?"":value.toString());
                cell.setCellStyle(cellStyle);
            }
        }
        return workbook;
    }



}
