//package com.sxdl.base.util;
//
//import com.aspose.cells.Workbook;
//import com.aspose.slides.Presentation;
//import com.aspose.words.Document;
//import com.aspose.words.SaveFormat;
//
//import java.io.*;
//
//public class FileTransForUtils {
//
//    //word转PDF
//    public synchronized static boolean word3Pdf(String wordPath, String pdfPath) {
//        if (!getLicense("word")) {          // 验证License 若不验证则转化出的pdf文档会有水印产生
//            return false;
//        }
//        try {
//            long old = System.currentTimeMillis();
//            File file = new File(pdfPath);  //新建一个pdf文档
//            FileOutputStream os = new FileOutputStream(file);
//            Document doc = new Document(wordPath);  //Address是将要被转化的word文档
//
//            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB,
//
//            // XPS, SWF 相互转换
//            long now = System.currentTimeMillis();
//            os.close();
//            System.out.println("word共耗时：" + ((now - old) / 1000.0) + "秒");
//
//            return true;
//        } catch (Exception e) {
//            System.out.println(String.valueOf(e));
//            e.printStackTrace();
//            return false;
//        }
//    }
//    //excel转PDF
//    public synchronized static boolean excel3pdf(String excelPath, String pdfPath) {
//        if (!getLicense("excel")) { // 验证License 若不验证则转化出的pdf文档会有水印产生
//            return false;
//        }
//        try {
//            long old = System.currentTimeMillis();
//            File pdfFile = new File(pdfPath);  //新建一个pdf文档
//            FileOutputStream os = new FileOutputStream(pdfFile);
//            Workbook wb = new Workbook(excelPath);// 原始excel路径
//            wb.save(os,com.aspose.cells.SaveFormat.PDF);
//            long now = System.currentTimeMillis();
//            os.close();
//            System.out.println("excel共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
//            return true;
//        } catch (Exception e) {
//            System.out.println(String.valueOf(e));
//            e.printStackTrace();
//            return false;
//        }
//    }
//    //ppt转PDF
//    public synchronized static boolean ppt3pdf(String pptPath, String pdfPath) {
//        // 验证License
//        if (!getLicense("ppt")) {
//            return false;
//        }
//        FileOutputStream os = null;
//        try {
//            long old = System.currentTimeMillis();
//            File pdfFile = new File(pdfPath);  //新建一个pdf文档
//            os = new FileOutputStream(pdfFile);
//            Presentation pres = new Presentation(pptPath);//输入ppt路径
//            //IFontsManager fontsManager = pres.getFontsManager();
//            pres.save(os,com.aspose.slides.SaveFormat.Pdf);
//            long now = System.currentTimeMillis();
//            System.out.println("ppt共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
//            return true;
//        } catch (Exception e) {
//            System.out.println(String.valueOf(e));
//            e.printStackTrace();
//            return false;
//        }finally {
//            try {
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    //剔除水印
//    private static boolean getLicense(String type) {
//        boolean result = false;
//        try {
//            // 凭证
//            String license =
//                    "<License>\n" +
//                            "  <Data>\n" +
//                            "    <Products>\n" +
//                            "      <Product>Aspose.Total for Java</Product>\n" +
//                            "      <Product>Aspose.Words for Java</Product>\n" +
//                            "    </Products>\n" +
//                            "    <EditionType>Enterprise</EditionType>\n" +
//                            "    <SubscriptionExpiry>20991231</SubscriptionExpiry>\n" +
//                            "    <LicenseExpiry>20991231</LicenseExpiry>\n" +
//                            "    <SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>\n" +
//                            "  </Data>\n" +
//                            "  <Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature>\n" +
//                            "</License>";
//            InputStream is = new ByteArrayInputStream(license.getBytes("UTF-8"));
//            if(type.equals("word")){
//                com.aspose.words.License asposeLic = new com.aspose.words.License();
//                asposeLic.setLicense(is);
//            }else if (type.equals("excel")){
//                com.aspose.cells.License asposeLic = new com.aspose.cells.License();
//                asposeLic.setLicense(is);
//            }else if (type.equals("ppt")){
//                com.aspose.slides.License aposeLic = new com.aspose.slides.License();
//                aposeLic.setLicense(is);
//            }
//            result = true;
//        } catch (Exception e) {
//            System.out.println(String.valueOf(e));
//            e.printStackTrace();
//            return false;
//        }
//        return result;
//    }
//    /**
//     * 判断资源类型文档类
//     */
//    public static String getResourceTypesDocument(String suffix) {
//        String type = null;
//        switch (suffix) {
//            //文档类型
//            case ".doc":
//            case ".docx":
//            case ".txt":
//                type = "word";
//                break;
//            case ".xls":
//            case ".xlsx":
//                type = "excel";
//                break;
//            case ".ppt":
//            case ".pptx":
//                type = "ppt";
//                break;
//        }
//        return type;
//    }
//
//    public static void main(String[] args) {
//
//        String inputPath = "D:\\AA_工作\\项目相关文档\\雕龙产品统一接口1.0-整理(1).xlsx";
//        String outputPath = "D:\\AA_工作\\项目相关文档\\雕龙产品统一接口1.0-整理(1).pdf";
//        String suffix = inputPath.substring(inputPath.lastIndexOf("."));
//        String suffix2 = inputPath.substring(0,inputPath.lastIndexOf("."));
//        System.out.println(suffix2);
//        String type = getResourceTypesDocument(suffix);
//        if("word".equals(type)){
//            word3Pdf(inputPath,outputPath);
//        }else if("excel".equals(type)){
//            excel3pdf(inputPath,outputPath);
//        }else if("ppt".equals(type)){
//            ppt3pdf(inputPath,outputPath);
//        }
//    }
//}
