package com.sxdl.hr.controller.report;

import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.hr.dao.dao1.Handle1Dao;
import com.sxdl.hr.dao.dao1.HrTgrXytxDao;
import com.sxdl.hr.entity.Handle1;
import com.sxdl.hr.entity.TgrBlmEntity;
import com.sxdl.hr.entity.TgrXytxEntity;
import com.sxdl.hr.util.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shqrpknife
 * @create 2022-09-02-16:54
 */
@Api(tags = "血液透析数据上报")
@RestController
@RequestMapping("/HhReport")
public class HrHhReportController {
    public static final String LineBreak = "\r\n";
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    Handle1Dao handle1Dao;

    @Autowired
    HrTgrXytxDao hrTgrXytxDao;

    @ApiOperation(value = "导出上报数据")
    @GetMapping("/exportReportDate")
    public String execute(String ssyy, String endsj, String kssj) {
        String path = ApplicationRunnerImpl.getFilesPath();
        //String path = request.getSession().getServletContext().getRealPath("/");
        Long l = System.currentTimeMillis() << 20;
        String NIOASn = "NIOA-" + l;
        File dir = new File(path+"\\" + NIOASn);
        String zipfile = NIOASn + ".zip";
        if (!dir.exists()) {//如果文件夹不存在
            dir.mkdir();//创建文件夹
        }
        kssj = kssj + " 00:00:00";
        endsj = endsj + " 23:59:59";
        try {
            UserInfo(dir, kssj, endsj, NIOASn,ssyy);
            PatientMain(dir, kssj, endsj);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            e.getMessage();
        }
        FileUtils.compressToZip(path+"\\"+NIOASn,path,zipfile);
        return zipfile;
    }

    private void UserInfo(File dir, String kssj, String endsj, String nioaSn,String ssyy) {
        File file = new File(dir + "\\UserInfo.xml");


        String dateFroms = kssj;
        String dateTos = endsj;

        String year = kssj.substring(0, 4);
        ;
        String month = kssj.substring(6, 7);

        String notes = year + "年" + month + "月" + "的血液透析数据";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String exportDates = df.format(new Date());
        String eightElements = ssyy;

        int count = handle1Dao.SqlWithSQL("select count(*) from tgr_xytx where zdbm is not null and isconfirm=1 " +
                "AND dcrq between  '"+kssj+"' and  '"+endsj+"'");

        try {
            //创建document
            Document document = DocumentHelper.createDocument();
            //创建根节点
            Element root = document.addElement("userInfo");
            // 在根节点下添加第一个子节点
            Element oneChildElement = root.addElement("NIOASn").addText(nioaSn);
            Element twoChildElement = root.addElement("type").addText("3");
            Element treeElement = root.addElement("dateFrom").addText(dateFroms);
            Element fourElement = root.addElement("dateTo").addText(dateTos);
            Element fiveElement = root.addElement("note").addText(notes);
            Element sixElement = root.addElement("exportDate").addText(exportDates);
            Element sevenElment = root.addElement("caseCount").addText(String.valueOf(count));
            Element eightElement = root.addElement("loginUser").addText(eightElements);

            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            logger.error(e + LineBreak);
            e.getMessage();
        }
    }


    private void PatientMain(File dir, String kssj, String endsj) {
        try {
            File file = new File(dir + "\\PatientMain.xml");
            List<TgrXytxEntity> list= hrTgrXytxDao.getallxytx("select * from tgr_xytx where zdbm is not null  and isconfirm=1 " +
                    "AND dcrq between  '"+kssj+"' and  '"+endsj+"'");
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("data");
            Element PatientMainList = root.addElement("PatientMainList");

            for (TgrXytxEntity tgrxytx : list) {
                String nldw = tgrxytx.getNldw();
                String age = tgrxytx.getHznl();
                Element PatientMain = PatientMainList.addElement("PatientMain");
                //病人主键
                Element BRID = PatientMain.addElement("BRID").addText(tgrxytx.getGid());
                //病人编号
                Element PATIENTID = PatientMain.addElement("PATIENT_ID").addText(tgrxytx.getZyh());
                //姓名
                Element PATIENT_NAME = PatientMain.addElement("PATIENT_NAME").addText(tgrxytx.getHzxm());
                //性别
                Element SEX = PatientMain.addElement("SEX").addText(tgrxytx.getHzxb());
                //年龄
                Element AGE_Y = PatientMain.addElement("AGE_Y").addText(tgrxytx.getHznl());
                //年龄单位
                Element AGE_UNIT = PatientMain.addElement("AGE_UNIT").addText(tgrxytx.getNldw());
                //诊断编码
                Element DIAGNOSE_ID = PatientMain.addElement("DIAGNOSE_ID").addText(tgrxytx.getZdbm());
                //诊断名称
                Element DIAGNOSE = PatientMain.addElement("DIAGNOSE").addText("1".equals(tgrxytx.getZdbm())?"慢性肾衰竭":"急性肾衰竭");
                //开始血液透析时间
                Element XT_DATE = PatientMain.addElement("XT_DATE").addText(tgrxytx.getKssj());
                //曾在几所医院接受过血液透析治疗
                Element XT_UNIT = PatientMain.addElement("XT_UNIT").addText(tgrxytx.getHscount());
                //目前血液透析频率
                Element XT_COUNT = PatientMain.addElement("XT_COUNT").addText(tgrxytx.getPlcount());
                //血管通路类型
                Element XT_TYPE = PatientMain.addElement("XT_TYPE").addText(tgrxytx.getXttype());
                //乙型肝炎病毒感染
                Element XCB_YG = PatientMain.addElement("XCB_YG").addText(tgrxytx.getIsyggr());
                //丙型肝炎病毒感染
                Element XCB_BG = PatientMain.addElement("XCB_BG").addText(tgrxytx.getIsbggr());
                //艾滋病病毒感染
                Element XCB_HIV = PatientMain.addElement("XCB_HIV").addText(tgrxytx.getIsazgr());
                //梅毒感染
                Element XCB_MD = PatientMain.addElement("XCB_MD").addText(tgrxytx.getIsmdgr());
                //发热
                Element GR_FR = PatientMain.addElement("GR_FR").addText(tgrxytx.getIsfr());
                //全身使用抗菌药物
                Element GR_KJYW = PatientMain.addElement("GR_KJYW").addText(tgrxytx.getIskjy());
                //血管穿刺部位感染
                Element GR_XGCC = PatientMain.addElement("GR_XGCC").addText(tgrxytx.getIsccgr());
                //血流感染
                Element GR_XLGR = PatientMain.addElement("GR_XLGR").addText(tgrxytx.getIsxlgr());
                //血管通路相关血流感染
                Element GR_XLTLGR = PatientMain.addElement("GR_XLTLGR").addText(tgrxytx.getIsxggr());
                //肺部感染
                Element GR_FBGR = PatientMain.addElement("GR_FBGR").addText(tgrxytx.getIsfbgr());
                //调查人 ID
                Element REPORT_USER_ID = PatientMain.addElement("REPORT_USER_ID").addText("");
                //调查人名称
                Element REPORT_USER_NAME = PatientMain.addElement("REPORT_USER_NAME").addText(tgrxytx.getDcrmc());
                //调查日期
                Element REPORT_DATE = PatientMain.addElement("REPORT_DATE").addText(tgrxytx.getDcrq());
                //创建日期
                Element CREATE_DATE = PatientMain.addElement("CREATE_DATE").addText(tgrxytx.getCjrq());
                //医院编码
                Element UNITID = PatientMain.addElement("UNITID").addText("");
                //住院号
                Element ZYID = PatientMain.addElement("ZYID").addText("");
                //门诊号
                Element MZID = PatientMain.addElement("MZID").addText("");
            }
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(document);
            writer.close();
        } catch (Exception e) {
            logger.error(e + LineBreak);
            e.getMessage();
        }
    }


}
