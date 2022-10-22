package com.sxdl.hr.controller.report;

import cn.hutool.core.lang.UUID;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.hr.dao.dao1.Handle1Dao;
import com.sxdl.hr.dao.dao1.HrTgrBlmDao;
import com.sxdl.hr.dao.dao1.HrTxhlGrbwxx;
import com.sxdl.hr.dao.dao1.HrTxhlTdbytymjg;
import com.sxdl.hr.dao.dao2.HandleDao;
import com.sxdl.hr.entity.TgrBlmEntity;
import com.sxdl.hr.entity.TxhlGrbwxxEntity;
import com.sxdl.hr.entity.TxhlTdbytymjgEntity;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author shqrpknife
 * @create 2022-08-11-9:17
 * 现患率数据导出上报
 */
@Api(tags = "现患率数据导出上报")
@RestController
@RequestMapping("/PrReport")
public class HrPrReportController {
    public static final String LineBreak = "\r\n";
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    HrTgrBlmDao hrTgrBlmDao;

    @Autowired
    Handle1Dao handle1Dao;

    @Autowired
    HrTxhlGrbwxx hrTxhlGrbwxx;

    @Autowired
    HrTxhlTdbytymjg hrTxhlTdbytymjg;

    @ApiOperation(value = "导出上报数据")
    @GetMapping("/exportReportDate")
    public String execute(String ssyy, String endsj, String kssj, HttpServletRequest request) {
        String path = ApplicationRunnerImpl.getFilesPath();
        //String path = request.getSession().getServletContext().getRealPath("/");
        Long l = System.currentTimeMillis() << 20;
        String NIOASn = "NIOA-" + l;
        File dir = new File(path+"\\" + NIOASn);
        String zipfile = "\\xhldata"+"\\"+NIOASn + ".zip";
        if (!dir.exists()) {//如果文件夹不存在
            dir.mkdir();//创建文件夹
        }
        kssj = kssj + " 00:00:00";
        endsj = endsj + " 23:59:59";
        try {
            hrTgrBlmDao.xhlSh(kssj, endsj);
            UserInfo(dir, kssj, endsj, ssyy, NIOASn);
            DeptInfo(dir);
            PatientMain(dir, kssj, endsj);
            InfectInfo(dir);
            PathoInfo(dir);
            AntibInfo(dir);
        } catch (Exception e) {
            logger.error(e + LineBreak);
            e.getMessage();
        }
        FileUtils.compressToZip(path+"\\"+NIOASn,path,zipfile);
        return zipfile;
    }

    public void UserInfo(File dir, String kssj, String endsj, String ssyy, String NIOASn) {
        File file = new File(dir + "\\UserInfo.xml");


        String dateFroms = kssj;
        String dateTos = endsj;

        String year = kssj.substring(0, 4);
        ;
        String month = kssj.substring(6, 7);

        String notes = year + "年" + month + "月" + ssyy + "医院的院感现患率数据";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String exportDates = df.format(new Date());
        String eightElements = ssyy;

        int count =0;
        String sysname = handle1Dao.selectSqlWithSQLStr("SELECT name_zh FROM dbo.hr_sys_dict_table WHERE name='systemname'");
        if("net".equals(sysname)){
            count = hrTgrBlmDao.getCount(kssj, endsj);
        }else if("java".equals(sysname)){
            count = hrTgrBlmDao.getCount1(kssj, endsj);
        }

        try {
            //创建document
            Document document = DocumentHelper.createDocument();
            //创建根节点
            Element root = document.addElement("userInfo");
            // 在根节点下添加第一个子节点
            Element oneChildElement = root.addElement("NIOASn").addText(NIOASn);
            Element twoChildElement = root.addElement("type").addText("2");
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

    //生成科室文件
    public void DeptInfo(File dir) {
        try {
            File file = new File(dir + "\\DeptInfo.xml");
            List<Map<String, String>> dzkss = handle1Dao.getCollection("select yyksname, dzid from dzks");
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("data");
            Element deptList = root.addElement("deptList");
            for (int i = 0; i < dzkss.size(); i++) {
                Element dept = deptList.addElement("DEPT");
                for (String dzks : dzkss.get(i).keySet()) {
                    if (dzks.equals("dzid")) {
                        //国家医院感染网标准科室编号
                        Element standofficeid = dept.addElement("STANDOFFICEID").addText(dzkss.get(i).get(dzks));
                    } else {
                        //医院科室名称
                        Element standofficeid = dept.addElement("OFFICE").addText(dzkss.get(i).get(dzks));
                    }
                }
            }


            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            logger.error(e + LineBreak);
            e.getMessage();
        }
    }

    //现患率上报患者相关信息
    public void PatientMain(File dir, String kssj, String endsj) {
        try {
            File file = new File(dir + "\\PatientMain.xml");

            String sysname = handle1Dao.selectSqlWithSQLStr("SELECT name_zh FROM dbo.hr_sys_dict_table WHERE name='systemname'");
            List<TgrBlmEntity> list =new ArrayList<>();
            if("net".equals(sysname)){
                list= hrTgrBlmDao.getAllTgrblm(kssj, endsj);
            }else if("java".equals(sysname)){
                list= hrTgrBlmDao.getAllTgrblm1(kssj, endsj);
            }

            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("data");
            Element PatientMainList = root.addElement("PatientMainList");

            for (TgrBlmEntity tgrblm : list) {
                System.out.println(tgrblm);
                System.out.println(tgrblm.getKscode());
                String nldw = tgrblm.getBlm06().substring(tgrblm.getBlm06().length() - 1, tgrblm.getBlm06().length());
                String age = tgrblm.getBlm06().substring(0, tgrblm.getBlm06().length() - 1);


                Element PatientMain = PatientMainList.addElement("PatientMain");
                //上报患者唯一编码
                Element BRID = PatientMain.addElement("BRID").addText(tgrblm.getZyh());
                //患者编号
                Element PATIENTID = PatientMain.addElement("PATIENTID").addText(tgrblm.getBlh());
                //科室名称
                Element OFFICE = PatientMain.addElement("OFFICE").addText(tgrblm.getKsname());
                //标准科室编号
                Element STANDOFFICEID = PatientMain.addElement("STANDOFFICEID").addText(handle1Dao.excuteSqlWithSQL("select dzid from dzks where yyksname='" + tgrblm.getKsname() + "'"));
                //床号
                Element BEDNO = PatientMain.addElement("BEDNO").addText(tgrblm.getBlm02());
                //患者病历号(需唯一)
                Element CASEID = PatientMain.addElement("CASEID").addText(tgrblm.getBlh());
                //患者姓名
                Element PATIENTNAME = PatientMain.addElement("PATIENTNAME").addText(tgrblm.getBlm04());
                //患者性别
                Element PATSEX = PatientMain.addElement("PATSEX").addText(tgrblm.getBlm05());
                //年龄单位
                if (nldw.equals("岁")) {
                    Element AGEY = PatientMain.addElement("AGEY").addText(age);
                    Element AGEM = PatientMain.addElement("AGEM").addText("0");
                    Element AGED = PatientMain.addElement("AGED").addText("0");
                } else if (nldw.equals("月")) {
                    Element AGEY = PatientMain.addElement("AGEY").addText("0");
                    Element AGEM = PatientMain.addElement("AGEM").addText(age);
                    Element AGED = PatientMain.addElement("AGED").addText("0");
                } else {
                    Element AGEY = PatientMain.addElement("AGEY").addText("0");
                    Element AGEM = PatientMain.addElement("AGEM").addText("0");
                    Element AGED = PatientMain.addElement("AGED").addText(age);
                }
                //疾病诊断名称  --------字典
                Element DIAGNOSE = PatientMain.addElement("DIAGNOSE").addText(tgrblm.getZd());
                //是否感染
                Element IFINFECT = PatientMain.addElement("IFINFECT").addText(tgrblm.getBlm10());
                //医院感染
                Element YYGR = PatientMain.addElement("YYGR").addText(tgrblm.getBlm11());
                //社区感染
                Element SQGR = PatientMain.addElement("SQGR").addText(tgrblm.getIssqgr());
                //社区感染
                Element WYGR = PatientMain.addElement("WYGR").addText(tgrblm.getIsywgr());
                //首次医院感染日期
                if (String.valueOf(tgrblm.getScyygrrq()).length() > 5 && !String.valueOf(tgrblm.getScyygrrq()).contains("1900")) {
                    Element FIRST_HOSP_INFECT = PatientMain.addElement("FIRST_HOSP_INFECT").addText(String.valueOf(tgrblm.getScyygrrq()));
                }else{
                    Element FIRST_HOSP_INFECT = PatientMain.addElement("FIRST_HOSP_INFECT").addText("");
                }
                //上传时间
                Element INPUTDATE = PatientMain.addElement("INPUTDATE").addText(String.valueOf(tgrblm.getTbsj()));
                //调查人名称
                Element VOTENAME = PatientMain.addElement("VOTENAME").addText(tgrblm.getBlm40());
                //调查时间
                Element VOTEDATE = PatientMain.addElement("VOTEDATE").addText(String.valueOf(tgrblm.getDcsj()));
                //是否手术
                Element OPERATOR = PatientMain.addElement("OPERATOR").addText(tgrblm.getBlm08());
                //手术切口等级
                if (!tgrblm.getBlm09().equals("-1")) {
                    Element OPERTION_INCISION = PatientMain.addElement("OPERTION_INCISION").addText(tgrblm.getBlm09());
                }else{
                    Element OPERTION_INCISION = PatientMain.addElement("OPERTION_INCISION").addText("");
                }
                //是否手术后肺炎
                Element SSHFY = PatientMain.addElement("SSHFY").addText(tgrblm.getIsshfy());
                //抗菌药物使用标示
                Element KJYWSY = PatientMain.addElement("KJYWSY").addText(tgrblm.getBlm36());
                //抗菌药物使用目的
                if (String.valueOf(tgrblm.getBlm38()) != null && !"".equals(String.valueOf(tgrblm.getBlm38())) && !"0".equals(String.valueOf(tgrblm.getBlm38()))) {
                    Element YYMD = PatientMain.addElement("YYMD").addText(tgrblm.getBlm37());
                } else {
                    Element YYMD = PatientMain.addElement("YYMD").addText("0");
                }
                //治疗用药已送细菌培养
                Element ZLYYSPY = PatientMain.addElement("ZLYYSPY").addText(tgrblm.getBlm39());
                //送培养时机为抗菌药物使用前
                if(!tgrblm.getSpysjwkjywsyq().equals("-1")){
                    Element PYSJ = PatientMain.addElement("PYSJ").addText(tgrblm.getSpysjwkjywsyq());
                }else{
                    Element PYSJ = PatientMain.addElement("PYSJ").addText("");
                }
                //抗菌药物联用
                if (String.valueOf(tgrblm.getBlm38()) != null && !"".equals(String.valueOf(tgrblm.getBlm38())) && !"0".equals(String.valueOf(tgrblm.getBlm38()))) {
                    Element LHYY = PatientMain.addElement("LHYY").addText(String.valueOf(tgrblm.getBlm38()));
                } else {
                    Element LHYY = PatientMain.addElement("LHYY").addText("0");
                }

                //空节点增加
                Element KJYWMC1 = PatientMain.addElement("KJYWMC1").addText("");
                Element KJYWMC2 = PatientMain.addElement("KJYWMC2").addText("");
                Element KJYWMC3 = PatientMain.addElement("KJYWMC3").addText("");
                Element KJYWMC4 = PatientMain.addElement("KJYWMC4").addText("");
                //入院日期  必填
                Element IN_HOSP_AT = PatientMain.addElement("IN_HOSP_AT").addText(String.valueOf(tgrblm.getRysj()));
                //标本革兰染色
                if(!tgrblm.getBbglrs().equals("-1")){
                    Element BBGLRS = PatientMain.addElement("BBGLRS").addText(tgrblm.getBbglrs());
                }else{
                    Element BBGLRS = PatientMain.addElement("BBGLRS").addText("");
                }
                //标本抗酸染色
                if(!tgrblm.getBbksrs().equals("-1")){
                    Element BBKSRS = PatientMain.addElement("BBKSRS").addText(tgrblm.getBbksrs());
                }else{
                    Element BBKSRS = PatientMain.addElement("BBKSRS").addText("");
                }
                //标本基因测序
                if(!tgrblm.getBbjycs().equals("-1")){
                    Element BBJYCX = PatientMain.addElement("BBJYCX").addText(tgrblm.getBbjycs());
                }else{
                    Element BBJYCX = PatientMain.addElement("BBJYCX").addText("");
                }
                //标本墨汁染色
                if(!tgrblm.getBbmzrs().equals("-1")){
                    Element BBMZRS = PatientMain.addElement("BBMZRS").addText(tgrblm.getBbmzrs());
                }else{
                    Element BBMZRS = PatientMain.addElement("BBMZRS").addText("");
                }
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

    //现患率上报患者感染部位相关信息
    public void InfectInfo(File dir) {
        try {
            File file = new File(dir + "\\InfectInfo.xml");
            List<TxhlGrbwxxEntity> grbw = hrTxhlGrbwxx.getGrbw();
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("data");
            Element InfectInfoList = root.addElement("InfectInfoList");
            for (TxhlGrbwxxEntity Grbw : grbw) {
                Element InfectInfo = InfectInfoList.addElement("InfectInfo");
                //疾病感染诊断部位编号
                Element DIAGID = InfectInfo.addElement("DIAGID").addText(Grbw.getGrbwdm());
                //疾病感染归属类型：1:医院感染，2：社区感染，3：外院感染
                Element INFECTTYPE = InfectInfo.addElement("INFECTTYPE").addText(Grbw.getGrlx());
                //患者编号
                Element BRID = InfectInfo.addElement("BRID").addText(Grbw.getZyh());
                //感染编号唯一
                Element GRID = InfectInfo.addElement("GRID").addText(Grbw.getGrgid());
                //上传时间
                if (Grbw.getTbsj() != null) {
                    Element INPUTDATE = InfectInfo.addElement("INPUTDATE").addText(Grbw.getTbsj());
                }else{
                    Element INPUTDATE = InfectInfo.addElement("INPUTDATE").addText("");
                }
                //疾病诊断部位名称
                if (Grbw.getGrbwmc() != null) {
                    Element INFECTDIAG = InfectInfo.addElement("INFECTDIAG").addText(Grbw.getGrbwmc());
                }else{
                    Element INFECTDIAG = InfectInfo.addElement("INFECTDIAG").addText("");
                }
            }
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            logger.error(e + LineBreak);
            e.getMessage();
        }
    }

    //现患率上报患者感染部位对应病原体
    public void PathoInfo(File dir) {
        try {
            File file = new File(dir + "\\PathoInfo.xml");
            List<TxhlTdbytymjgEntity> list = hrTxhlTdbytymjg.getTdBytYmjg();
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("data");
            Element PathoInfoList = root.addElement("PathoInfoList");
            for (TxhlTdbytymjgEntity byt : list) {
                Element PathoInfo = PathoInfoList.addElement("PathoInfo");
                //感染病原体名称
                String bytmc = handle1Dao.excuteSqlWithSQL("select mc from bzbyt where bm='" + byt.getByt() + "'");
                Element PATHONAME = PathoInfo.addElement("PATHONAME").addText(bytmc);
                //感染病原体编号，唯一
                Element BYTID = PathoInfo.addElement("BYTID").addText(byt.getBytid());
                //病人编号，关联患者编号
                Element BRID = PathoInfo.addElement("BRID").addText(byt.getZyh()==null?"":byt.getZyh());
                //是否审核，1 审核，0 未审核。默认 0 未审核
                Element CHECHED = PathoInfo.addElement("CHECHED").addText("1");
                //关联字段：感染编号
                Element GRID = PathoInfo.addElement("GRID").addText(byt.getGrgid());
                //上传时间
                Element INPUTDATE = PathoInfo.addElement("INPUTDATE").addText(byt.getTbsj()==null?"":byt.getTbsj());
                //感染病原体编号
                Element PATHOID = PathoInfo.addElement("PATHOID").addText(byt.getByt());
                //-病原体多重耐药试验结果:敏感，MDR,XDR,PDR
                Element PATHORESULT = PathoInfo.addElement("PATHORESULT").addText("");
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

    //现患率上报患者感染部位对应病原体下对应药敏药物试验
    public void AntibInfo(File dir) {
        try {
            File file = new File(dir + "\\AntibInfo.xml");
            List<TxhlTdbytymjgEntity> list = hrTxhlTdbytymjg.getYmjg();
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("data");
            Element AntibInfoList = root.addElement("AntibInfoList");
            for (TxhlTdbytymjgEntity byt : list) {
                if(byt.getYmjg() !=null && byt.getYwdm() !=null){
                    Element PathoInfo = AntibInfoList.addElement("AntibInfo");
                    //药敏药物试验结果，耐药，敏感，未做，中介
                    Element ANTIBRESULT = PathoInfo.addElement("ANTIBRESULT").addText(byt.getYmjg());
                    //药敏药物编号
                    Element DURGID = PathoInfo.addElement("DURGID").addText(UUID.randomUUID().toString());
                    //关联字段：病原体编号
                    Element BYTID = PathoInfo.addElement("BYTID").addText(byt.getBytid());
                    //药敏药物名称
                    Element ANTIBNAME = PathoInfo.addElement("ANTIBNAME").addText(byt.getYwdm());
                    //关联字段：病人编号
                    Element BRID = PathoInfo.addElement("BRID").addText(byt.getZyh()==null?"":byt.getZyh());
                    //关联字段：感染编号
                    Element GRID = PathoInfo.addElement("GRID").addText(byt.getGrgid());
                    //药敏药物编号
                    Element TROCHEID = PathoInfo.addElement("TROCHEID").addText(handle1Dao.excuteSqlWithSQL("select ymymbm from txhl_tdbytkss WHERE ymymmc ='"+byt.getYwdm()+"' AND bm ='"+byt.getByt()+"' "));
                    //填报时间
                    Element INPUTDATE = PathoInfo.addElement("INPUTDATE").addText(byt.getTbsj()==null?"":byt.getTbsj());
                }
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
