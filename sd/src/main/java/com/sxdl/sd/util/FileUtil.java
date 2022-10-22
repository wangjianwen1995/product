package com.sxdl.sd.util;

import cn.hutool.core.util.StrUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

    public static JSONObject getJsonDate(String filename) throws Exception{
        StringBuilder sb = new StringBuilder();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        JSONObject jsonObject = JSONObject.fromObject(sb.toString());
        return jsonObject;
    }
    public static void bufferedWriterToFile(String str,String name) throws  Exception{
        File file =new File("d://"+name);
        if(!file.getParentFile().exists()){ //判断文件父目录是否存在
            file.getParentFile().mkdirs();  //不存在创建父目录
        }
        if(!file.exists()){ //判断文件是否存在
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        bw.write(new String(str.getBytes("utf-8"),"utf-8"));
        bw.flush();
        bw.close();
    }


    public static List getFile(String path,List list) {
        File file = new File(path);
        File[] array = file.listFiles();
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                Map map = new HashMap();
                map.put("name",array[i].getName());
                String pathFile = array[i].getPath();
                String drPlusFiles = pathFile.substring(pathFile.indexOf("drPlusFiles") + "drPlusFiles".length());
                map.put("path", "files\\drPlusFiles"+drPlusFiles);
                /* 找出指定的2个字符在 该字符串里面的 位置 */
                int strStartIndex = drPlusFiles.indexOf("\\");
                int strEndIndex = drPlusFiles.lastIndexOf("\\");
                map.put("pid",   drPlusFiles.subSequence(strStartIndex+1,strEndIndex) );
                list.add(map);
            } else if (array[i].isDirectory()) {
                getFile(array[i].getPath(),list);
            }
        }
        return list;
    }

    public static JSONArray getExtendedbyJson( Integer pid ) throws IOException{
        String filename = "createTable"+pid+".json";
        StringBuilder sb = new StringBuilder();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        JSONArray jsonArray = JSONArray.fromObject(sb.toString());


        return jsonArray ;
    }

    public static JSONArray getExtendedbyJson( Integer pid,String tableType) throws IOException{
        String filename = "createTable"+pid+tableType+".json";
        StringBuilder sb = new StringBuilder();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        JSONArray jsonArray = JSONArray.fromObject(sb.toString());


        return jsonArray ;
    }

    /**
     *
     * @param pid
     * @param tableType  abcd 哪个表
     * @return
     * @throws IOException
     */
    public static StringBuilder getStrsqlbyJson( Integer pid,String tableType) throws IOException{
        String filename = "createTable"+pid+tableType+".json";
        StringBuilder sb = new StringBuilder();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        JSONArray jsonArray = JSONArray.fromObject(sb.toString());
        StringBuilder stringBuilder = new StringBuilder();
        jsonArray.forEach(e->{
            JSONObject jsonObject = JSONObject.fromObject(e);
            stringBuilder.append(jsonObject.getString("col"));
        });

        return stringBuilder ;
    }




    public static StringBuilder getStrsqlbyJson( Integer pid ) throws IOException{
        String filename = "createTable"+pid+".json";
        StringBuilder sb = new StringBuilder();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        JSONArray jsonArray = JSONArray.fromObject(sb.toString());
        StringBuilder stringBuilder = new StringBuilder();
        jsonArray.forEach(e->{
            JSONObject jsonObject = JSONObject.fromObject(e);
            stringBuilder.append(jsonObject.getString("col"));
        });

        return stringBuilder ;
    }


    /**
     * 获取需要上报的字段
     * @param pid
     * @return
     * @throws IOException
     */
    public static String[] getStrColbyJson( Integer pid ) throws IOException{
        String filename = "resources"+pid+".json";
        StringBuilder sb = new StringBuilder();
        InputStream resourceAsStream = FileUtil.class.getClassLoader().getResourceAsStream(filename);
        InputStreamReader isr = new InputStreamReader(new BufferedInputStream(resourceAsStream),"UTF-8");
        BufferedReader br  =new BufferedReader(isr);
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        JSONObject jsonObject = JSONObject.fromObject(sb.toString());
        //上报字段
        String[] cols = jsonObject.getString("col").split(",");
        return cols ;
    }






    /**
     * 创建文件
     * @param filePath
     * @throws IOException
     */
    public static void createFile(String filePath) throws IOException {
        File  file = new File(filePath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if (!file.exists()){
          file.createNewFile();
        }

    }

    /**
     * 创建文件夹
     * @param filePath
     * @throws IOException
     */
    public static void createFileFolder(String filePath) throws IOException {
        File  file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
    }




    /**
     *  自定义导出
     * @param fileName
     * @param header
     * @param data
     * @param outputStream
     * @throws IOException
     */
    public static void doExcel(String fileName , List<String> header
                 , List<LinkedHashMap<String, Object>> data ,
                  OutputStream outputStream) throws IOException {
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

        workbook.write(outputStream);
        workbook.close();
        outputStream.flush();
        outputStream.close();
        return ;
    }


    /**
     *  真是上报导出  key 这里处理正式数据 可以简单点,本方法是针对 特殊上报特殊数据
     * @param header
     * @param data
     * @param outputStream
     * @throws IOException
     */
    public static void doExcel2(  List<LinkedHashMap<String, Object>> data , List<String> header
                 ,
                  OutputStream outputStream) throws IOException {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");
        // 添加表头行
        HSSFRow hssfRow = sheet.createRow(0);

        // 设置标题外的单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFFont font1 = workbook.createFont();
        font1.setFontName("宋体");
        font1.setFontHeightInPoints((short) 12);//设置字体大小
        cellStyle.setFont(font1);


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
            hssfRow = sheet.createRow(i +1);
            for (String key : header) {
                HSSFCell cell = hssfRow.createCell(hssfRow.getLastCellNum()>0?hssfRow.getLastCellNum():0);
                String s = StringUtils.isEmpty(map.get(key)) ? "" : StrUtil.startWith(map.get(key).toString(), "0") ? "\t" + map.get(key).toString() : map.get(key).toString();
                cell.setCellValue(s);
                cell.setCellStyle(cellStyle);
            }
            /*

            key 直接使用map值 ,上面是 根据 列表的顺序遍历数据

              for (Object value : map.values()) {
                //short lastCellNum = hssfRow.getLastCellNum();
                HSSFCell cell = hssfRow.createCell(hssfRow.getLastCellNum()>0?hssfRow.getLastCellNum():0);
                String s = StringUtils.isEmpty(value) ? "" : StrUtil.startWith(value.toString(), "0") ? "\t" + value.toString() : value.toString();
                cell.setCellValue(s);
                cell.setCellStyle(cellStyle);
            }*/
        }
        workbook.write(outputStream);
        workbook.close();
        outputStream.flush();
        outputStream.close();
        return ;
    }

    /**
     * 将文件打包成zip 压缩文件
     * @param outputStream
     * @param fileList
     */
    public static void doZip(OutputStream outputStream, List<File> fileList){
        BufferedInputStream bufferedInputStream = null;
        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(outputStream);
            for (File file : fileList) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);
                byte[] buf = new byte[1024];
                int len;
                FileInputStream in = new FileInputStream(file);
                while ((len = in.read(buf)) != -1) {
                    zipOutputStream.write(buf, 0, len);
                    zipOutputStream.flush();
                }
            }
            zipOutputStream.flush();
            zipOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (zipOutputStream != null ) {
                    zipOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 将文件打包成zip 压缩文件
     * @param outputStream
     * @param file
     */
    public static void doZip(OutputStream outputStream, File file){

        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(outputStream);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            byte[] buf = new byte[1024];
            int len;
            FileInputStream in = new FileInputStream(file);
            while ((len = in.read(buf)) != -1) {
                zipOutputStream.write(buf, 0, len);
                zipOutputStream.flush();
            }

            zipOutputStream.flush();
            zipOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {

                if (zipOutputStream != null ) {
                    zipOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 删除文件夹下所有文件
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }


}
