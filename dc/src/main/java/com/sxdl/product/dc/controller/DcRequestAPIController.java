package com.sxdl.product.dc.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.scheduled.SpringContextUtils;
import com.sxdl.product.dc.entity.DcRequestAPI;
import com.sxdl.product.dc.entity.DcSchedule;
import com.sxdl.product.dc.entity.DcScheduleConfig;
import com.sxdl.product.dc.service.DcScheduleService;
import com.sxdl.product.dc.service.impl.DcProcedureServiceImpl;
import com.sxdl.product.dc.service.impl.DcRequestAPIServiceImpl;
import com.sxdl.product.dc.util.WebPostUtil;
import com.sxdl.product.dc.util.WebSoapUtil;
import com.sxdl.product.dc.util.WebSopJavaReflex;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @version 1.0
 */

@Api(tags = "数据获取请求接口")
@RestController
@RequestMapping("/api")
public class DcRequestAPIController {
    @Autowired
    private DcRequestAPIServiceImpl dcRequestAPIService;

    @Autowired
    private DcScheduleService dcScheduleService;

    @Autowired
    private DcProcedureServiceImpl dcProcedureService;

    @ApiOperation(value = "查询所有接口信息", notes = "查询所有接口信息")
    @GetMapping("/getAll")
    @ResponseBody
    public ResultUtil findAll(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "", required = false) String name) {
        try {
            DcRequestAPI dcRequestAPI = new DcRequestAPI();
            if (StrUtil.isNotEmpty(name)) {
                dcRequestAPI.setName(name);
            }

            PageInfo<DcRequestAPI> pageList = dcRequestAPIService.queryPageList(pageInfo, dcRequestAPI);
            if (pageList.getList().size() > 0) {
                for (DcRequestAPI requestAPI : pageList.getList()) {
                    if (StrUtil.isNotEmpty(requestAPI.getWeb_id())) {
                        DcRequestAPI dcRequestAPI1 = dcRequestAPIService.findById(requestAPI.getWeb_id());
                        if (null != dcRequestAPI1) {
                            requestAPI.setWebName(dcRequestAPI1.getName());
                        }
                    }
                    /*if (StrUtil.isNotEmpty(requestAPI.getSchedule_id())) {
                        DcSchedule byId = dcScheduleService.findById(requestAPI.getSchedule_id());
                        requestAPI.setRule_id(byId.getRule_id());
                        requestAPI.setScope(byId.getScope());
                    }*/
                }
            }
            return ResultUtil.success(pageList);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据id获取数据", notes = "根据id获取数据")
    @GetMapping("/findById")
    @ResponseBody
    public ResultUtil findById(@RequestParam(value = "id", required = true) Integer id) {
        try {
            DcRequestAPI byId = dcRequestAPIService.findById(id);
            return ResultUtil.success(byId);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据工单的id获取数据", notes = "根据工单的id获取数据")
    @GetMapping("/findByJobId")
    @ResponseBody
    public ResultUtil findByJobId(PageInfo pageInfo, @RequestParam(value = "job_id", required = true) String job_id,
                                  @RequestParam(value = "name", required = false) String name) {
        try {
//            DcRequestAPI dcbyId = new DcRequestAPI();
//            dcbyId.setJob_id(job_id);

            String sql ="from dc_job j left join dc_request_api a on j.id=a.job_id\n" +
                    "left join dc_schedule s on a.schedule_id=s.id\n" +
                    "where job_id= '"+job_id+"' ";
            if (StrUtil.isNotEmpty(name)) {
                sql+=" and name ='"+name+"' ";
            }
            PageInfo<DcRequestAPI> pageList = dcRequestAPIService.selectPageinfoWithSQL(DcRequestAPI.class," a.*,s.status ",sql,"a.name",pageInfo,true);
            if (pageList.getList().size() > 0) {
                for (DcRequestAPI requestAPI : pageList.getList()) {
                    if (StrUtil.isNotEmpty(requestAPI.getWeb_id())) {
                        DcRequestAPI dcRequestAPI1 = dcRequestAPIService.findById(requestAPI.getWeb_id());
                        if (null != dcRequestAPI1) {
                            requestAPI.setWebName(dcRequestAPI1.getName());
                        } else {
                            requestAPI.setWebName("父接口配置错误请检查数据!");
                        }
                    }
                    /*if (StrUtil.isNotEmpty(requestAPI.getSchedule_id())) {
                        DcSchedule byId = dcScheduleService.findById(requestAPI.getSchedule_id());
                        requestAPI.setRule_id(byId.getRule_id());
                        requestAPI.setScope(byId.getScope());
                    }*/
                }
            }
            return ResultUtil.success(pageList);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "解析", notes = "测试解析")
    @PostMapping("/analysis")
    @ResponseBody
    public ResultUtil analysis(@RequestBody DcRequestAPI dcRequestAPI) {
        try {
            String sqlText = "";
            // 1 xml格式  2json 格式
            String agreetype = dcRequestAPI.getAgreetype();

            HttpResponse response = WebSoapUtil.getResponse(dcRequestAPI.getUrl(), dcRequestAPI.getContenttype(), dcRequestAPI.getReqbody(), dcRequestAPI.getSoapaction());
            //用来存放colums字段
            Set<String> tableColumns = null;
            Integer is_standard = dcRequestAPI.getIs_standard(); //是否规范 -1否
            if ("1".equals(agreetype)) {
                Document xmlDocument = null;
                if (1 == is_standard) {
                    xmlDocument = WebSoapUtil.getXmlDocument(response);
                } else {
                    xmlDocument = WebSoapUtil.getXmlDocument(response, dcRequestAPI.getAnalysis_node());
                }

                tableColumns = WebSoapUtil.getXmlColumns(xmlDocument, dcRequestAPI.getAnalysis_node(), dcRequestAPI.getName_space(), dcRequestAPI.getName_space_url());
            } else if ("2".equals(agreetype)) { //json数据
                if (-1 == is_standard) {
                    tableColumns = WebPostUtil.getJsonColumnsNOStandard(response);
                } else {
                    tableColumns = WebPostUtil.getJsonColumns(response, dcRequestAPI.getAnalysis_node());
                }
            }

            if (tableColumns.size() == 0) {
                return ResultUtil.error("解析失败,勾选非标准xml,请重新点击解析按钮");
            }
            return ResultUtil.success("解析成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "保存", notes = "保存接口信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody DcRequestAPI dcRequestAPI) {
        try {
            ResultUtil resultUtil = dcRequestAPIService.saveApi(dcRequestAPI);
            return resultUtil;
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }


    @ApiOperation(value = "修改", notes = "修改接口信息")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtil update(@RequestBody DcRequestAPI dcRequestAPI) {
        try {
            dcRequestAPIService.update(dcRequestAPI);
            return ResultUtil.success("修改成功");
        } catch (Exception e) {
            return ResultUtil.error(e.toString());
        }
    }

    //修改接口信息
    @ApiOperation(value = "删除", notes = "删除接口信息")
    @GetMapping("/del")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id", required = true) String id) {
        try {
            dcRequestAPIService.deleteInfosById(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "发送按钮", notes = "接口按钮发送，连接是否通过调试")
    @PostMapping("/sendOut")
    @ResponseBody
    public ResultUtil sendOut(@RequestBody DcRequestAPI dcRequestAPI) {
        DcRequestAPI test = null;
        try {
            // String agreetype = dcRequestAPI.getAgreetype();
            HttpResponse response = null;
            String reqbody = dcRequestAPI.getReqbody();
            String url = dcRequestAPI.getUrl();
            String contentType = dcRequestAPI.getContenttype();
            //agreetype 1 xml  2 json 目前就这两种
            try{
                if ("1".equals(dcRequestAPI.getAgreetype())) {
                    response = WebSoapUtil.getResponse(url, contentType, reqbody, dcRequestAPI.getSoapaction());
                } else if ("2".equals(dcRequestAPI.getAgreetype())) {
                    response = WebPostUtil.getResponse(url, contentType, reqbody);
                }
            }catch(Exception e){
                return ResultUtil.error(e.getMessage());
            }
            test = WebSoapUtil.getResponseInfo(response, dcRequestAPI);
            return ResultUtil.success(test, "发送成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "抽取历史数据", notes = "抽取历史数据")
    @PostMapping("/saveOneTable")
    @ResponseBody
    public ResultUtil saveOneTable(@RequestBody DcRequestAPI dcRequestAPI) {
        try {
            return dcRequestAPIService.saveOneTable(dcRequestAPI);
//            return ResultUtil.success("抽取历史数据成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("抽取历史数据失败" + e.getMessage());
        }
    }

    /**
     * 作业抽取数据--->利用动态sql
     *
     * @param schedules 是更具规则分好组的 DcSchedule类的数据
     */
    public void saveAutoEverySql(List<DcSchedule> schedules) throws Exception{
        try {
            System.out.println("作业开始执行");
            dcRequestAPIService.saveAutoEverySql(schedules);
//            dcProcedureService.saveAutoEverySql2(jsonArray);
//            dcProcedureService.saveAutoEverySql3(jsonArray);
//            dcProcedureService.saveAutoEverySql4(jsonArray);
            System.out.println("作业结束执行");
        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        }
    }

    /**
     * 作业抽取数据--->利用动态sql
     *
     * @param schedules 是更具规则分好组的 DcScheduleConfig类的数据
     */
    public void saveAutoEverySql1(List<DcScheduleConfig> schedules) throws Exception{
        try {
            System.out.println("作业开始执行");
            dcRequestAPIService.saveAutoEverySql1(schedules);
            System.out.println("作业结束执行");
        } catch (Exception e) {
            e.printStackTrace();
            throw  e;
        }
    }



    @Deprecated
    @ApiOperation(value = "生成文件", notes = "接口生成文件")
    @PostMapping("/createFile")
    @ResponseBody
    public ResultUtil createFile(@RequestBody DcRequestAPI dcRequestAPI) {
        try {
            Map<String, String> map = new LinkedHashMap<>();
            if (1 == dcRequestAPI.getIsparam()) {
                map = WebSopJavaReflex.getKeyValues("dcRequestAPI.getParams()");
            }
            //处理前端你的参数
            // 获取请求的 类 和响应的信息 类
            com.sxdl.product.dc.util.ResultUtil responseAndDom = WebSopJavaReflex.getResponse(dcRequestAPI.getIsparam(), dcRequestAPI.getUrl(), dcRequestAPI.getTag(), dcRequestAPI.getContenttype(), map);
            if ("error".equals(responseAndDom.getState())) {
                return ResultUtil.error("请求错误");
            }
            //获取Document对象
            Map<String, Object> reAndDom = (Map<String, Object>) responseAndDom.getT();
            Document document = (Document) reAndDom.get("document");

            //3 连接 Document 对象 获取 数据库表字段（entity属性值 ）
            Set<String> tableColumn = WebSopJavaReflex.getTableColumn(document, dcRequestAPI.getTag());

            if (tableColumn.size() == 0) {
                return ResultUtil.error("字段获取失败，请检查接口数据");
            }

            // 4 拼接java类、和sql脚本 字符串
            String strEntity = WebSopJavaReflex.strEntity(dcRequestAPI.getTag(), tableColumn);
            // 5 动态生成 C:\javaBean\entity\yg\XXXXentity.java
            WebSopJavaReflex.createFileJavaBean(strEntity, WebSopJavaReflex.ENTITYPATH, 1, dcRequestAPI.getTag());
            // 生成C:\javaBean\dao2\xxxxDao.java
            WebSopJavaReflex.createFileJavaBean(WebSopJavaReflex.strDao(dcRequestAPI.getTag()), WebSopJavaReflex.DAOPATH, 2, dcRequestAPI.getTag());
            // 生成 C:\javaBean\controller\XXXController.java
            WebSopJavaReflex.createFileJavaBean(WebSopJavaReflex.strController(dcRequestAPI.getTag()), WebSopJavaReflex.CONTROLLERPATH, 3, dcRequestAPI.getTag());
            //生成 C:\javaBean\table.sql脚本文件
            WebSopJavaReflex.createFileJavaBean(WebSopJavaReflex.strSqlTable(dcRequestAPI.getTag(), tableColumn), WebSopJavaReflex.CREATETALBESQL, 4, dcRequestAPI.getTag());

        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("操作成功");
    }

    @Deprecated
/*    @ApiOperation(value = "保存", notes = "抽取历史数据")
    @GetMapping ("/saveOneTable2")
    @ResponseBody*/
    public void saveWhileTalbeOld(Integer isparam, String url, String Tag, String content, String STime, String ETime) throws Exception {
        List<Object> list = new ArrayList<>();
        // 获取请求的 类 和响应的信息 类
        Map<String, String> time = new LinkedHashMap<>();
        if (1 == isparam) {
            time.put("startDate", STime);
            time.put("endDate", ETime);
        }
        com.sxdl.product.dc.util.ResultUtil responseAndDom = WebSopJavaReflex.getResponse(isparam, url, Tag, content, time);
        //获取Document对象
        Map<String, Object> reAndDom = (Map<String, Object>) responseAndDom.getT();
        Document document = (Document) reAndDom.get("document");
        List<Node> nodes = document.selectNodes("//" + Tag);
        Iterator<Node> iterator = nodes.iterator();
        try {
            while (iterator.hasNext()) {
                Class<?> aClass = this.getClass().getClassLoader().loadClass("com.sxdl.product.dc.entity.yg." + Tag);
                Object objclass = aClass.newInstance();
                Element element = (Element) iterator.next();
                Iterator<Element> elementIterator = element.elementIterator();
                while (elementIterator.hasNext()) {
                    Element next = elementIterator.next();
                    //抽取 需要入参为 病历号的接口数据 这里以     住院患者基本信息 里面的blh 为准抽取数据（患者相关病历 表）
                    if ("ETL_His_HzJbxx".equals(Tag) || "blh".equals(next.getName())) {
                        //设定 患者相关病历  接口的Tag 标签
                        String blhTag = "GetPatientRecords";
                        WebSopJavaReflex.saveWebBLH(next.getTextTrim(), blhTag);
                    }
                    //System.out.println("名称："+next.getName()+" 值："+next.getTextTrim());
                    String md = next.getName().substring(0, 1).toUpperCase() + next.getName().substring(1);
                    Method method = aClass.getDeclaredMethod("set" + md, String.class);
                    method.setAccessible(true);
                    method.invoke(objclass, next.getTextTrim());
                }
                list.add(objclass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //spring工厂中获取 对应controller对象 以及class
//            WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
//            Class bean = currentWebApplicationContext.getBean(dcRequestAPI.getTag().substring(0, 1).toUpperCase() + dcRequestAPI.getTag().substring(1) + "Controller").getClass();
        Object bean1 = SpringContextUtils.getBean(Tag.substring(0, 1).toUpperCase() + Tag.substring(1) + "Controller");
        Method insert = bean1.getClass().getDeclaredMethod("insert", List.class);
        //Method insert = bean.getDeclaredMethod("insert", List.class);
        insert.invoke(bean1, list);
    }
}
