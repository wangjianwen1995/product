package com.sxdl.sd.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {
    public static void createExcel(List<String> header, List<String[]> data, OutputStream out) throws IOException {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");
        // 添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        // 添加表头内容
        for (int i = 0; i < header.size(); i++) {
            HSSFCell headCell = hssfRow.createCell(i);
            headCell.setCellValue(header.get(i));
            headCell.setCellStyle(cellStyle);
        }

        // 添加数据内容
        for (int i = 0; i < data.size(); i++) {
            String[] strings = data.get(i);
            hssfRow = sheet.createRow(i + 1);
            for (int j = 0; j < strings.length; j++) {
                HSSFCell cell = hssfRow.createCell(j);
                cell.setCellValue(strings[j]);
                cell.setCellStyle(cellStyle);
            }
        }
        //单元格自适应
        sheet.autoSizeColumn(2,true);
        // 保存Excel文件
        workbook.write(out);
    }

    /**
     *
     * @param title 表头
     * @param header 列明
     * @param data  数据
     * @param out   io输出
     * @throws IOException
     */
    public static void createExcel(String title,List<String> header, List<String[]> data, OutputStream out) throws IOException {
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
        //设置标题的样式
        HSSFCellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置标题字体的样式
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);//设置字体大小
        titleCellStyle.setFont(font);
        //标题设置(四个参数分别表示起始行，终止行，起始列，终止列)
        cellTitle.setCellValue(title);
        int lastCol = header.size() > 1 ? header.size() : 2;
        CellRangeAddress region1 = new CellRangeAddress(0, 1, (short) 0, (short) lastCol - 1);
        sheet.addMergedRegion(region1);
        hssfRow = sheet.createRow(1);
        hssfRow = sheet.createRow(2);
        cellTitle.setCellStyle(titleCellStyle);
        // 添加表头内容
        for (int i = 0; i < header.size(); i++) {
            HSSFCell headCell = hssfRow.createCell(i);
            headCell.setCellValue(header.get(i));
            headCell.setCellStyle(cellStyle);
        }

        // 添加数据内容
        for (int i = 0; i < data.size(); i++) {
            String[] strings = data.get(i);
            hssfRow = sheet.createRow(i + 3);
            for (int j = 0; j < strings.length; j++) {
                HSSFCell cell = hssfRow.createCell(j);
                cell.setCellValue(strings[j]);
                cell.setCellStyle(cellStyle);
            }
        }

        // 保存Excel文件
        workbook.write(out);
    }

    /**
     * 读取Excel的内容
     *
     * @param fileType 文件类型，xls或xlsx
     * @param startRows 开始读取行数，比喻行头不需要读入 忽略的行数为1
     * @param ignoreRowBlank 是否忽略空行
     * @param is 文件输入流
     * @return 读出的Excel中数据的内容
     * @throws IOException duxxxxx
     */
    public static List<String[]> readData(String fileType, int startRows, boolean ignoreRowBlank, InputStream is) throws IOException {
        List<String[]> result = new ArrayList<>();

        Workbook wb = readExcel(fileType, is);
        for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
            Sheet sheet = wb.getSheetAt(sheetIndex);

            for (int rowIndex = startRows, z = sheet.getLastRowNum(); rowIndex <= z; rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    continue;
                }

                int rowSize = row.getLastCellNum();
                String[] values = new String[rowSize];
                boolean hasValue = false;
                for (int columnIndex = 0; columnIndex < rowSize; columnIndex++) {
                    String value = "";
                    Cell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        // 注意：一定要设成这个，否则可能会出现乱码,后面版本默认设置
                        switch (cell.getCellType().getCode()) {
                            case 1:
                                value = cell.getStringCellValue();
                                break;
                            case 0:
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    Date date = cell.getDateCellValue();
                                    if (date != null) {
                                        value = new SimpleDateFormat("yyyy-MM-dd")
                                                .format(date);
                                    } else {
                                        value = "";
                                    }
                                } else {
                                    //value = new DecimalFormat("0").format(cell.getNumericCellValue());
                                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                        value = String.valueOf(cell.getDateCellValue());
                                    } else {
                                        cell.setCellType(CellType.STRING);
                                        String temp = cell.getStringCellValue();
                                        // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                        if (temp.indexOf(".") > -1) {
                                            value = String.valueOf(new Double(temp)).trim();
                                        } else {
                                            value = temp.trim();
                                        }
                                    }
                                }
                                break;
                            case 2:
                                // 导入时如果为公式生成的数据则无值
                                if (!cell.getStringCellValue().equals("")) {
                                    value = cell.getStringCellValue();
                                } else {
                                    value = cell.getNumericCellValue() + "";
                                }
                                break;
                            case 3:
                                break;
                            case 5:
                                value = "";
                                break;
                            case 4:
                                value = (cell.getBooleanCellValue() == true ? "Y"

                                        : "N");
                                break;
                            default:
                                value = "";
                        }
                    }
                    values[columnIndex] = value;
                    if (!value.isEmpty()) {
                        hasValue = true;
                    }
                }
                if (!ignoreRowBlank || hasValue) {//不为忽略空行模式或不为空行
                    result.add(values);
                }
            }
        }
        return result;
    }

    //读取excel
    private static Workbook readExcel(String fileType, InputStream is) throws IOException {
        if ("xls".equals(fileType)) {
            return new HSSFWorkbook(is);
        } else if ("xlsx".equals(fileType)) {
            return new XSSFWorkbook(is);
        } else {
            throw new IllegalArgumentException("不支持的文件类型，仅支持xls和xlsx");
        }
    }

    /**
     * 去掉字符串右边的空格
     *
     * @param str 要处理的字符串
     * @return 处理后的字符串
     */
    private static String rightTrim(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != 0x20) {
                break;
            }
            length--;
        }
        return str.substring(0, length);
    }
}
