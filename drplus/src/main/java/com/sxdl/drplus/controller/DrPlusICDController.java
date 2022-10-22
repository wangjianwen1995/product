package com.sxdl.drplus.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.config.DrPlusApplicationRunnerImpl;
import com.sxdl.drplus.dto.ICDDBO;
import com.sxdl.drplus.entity.*;
import com.sxdl.drplus.service.*;
import com.sxdl.drplus.util.DataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "所有编码操作项目")
@RestController
@RequestMapping("/icd")
public class DrPlusICDController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private DrplusCodeVersionService versionService;

    @Autowired
    private DrplusSsicdMapService ssicdMapService;

    @Autowired
    private DrplusSsicdService ssicdService;

    @Autowired
    private DrplusJbicdMapService jbicdMapService;

    @Autowired
    private DrplusJbicdService jbicdService;
    @Autowired
    private DrPlusPlatformDetailedService platformDetailedService;




    /**
     * 平台明细回显 版本名称时候使用
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询版本号")
    @GetMapping("/getICDVersionById")
    public ResultUtil getICDVersionById(@RequestParam(value = "id",required = true) Integer id) {
        DrplusCodeVersion version = new DrplusCodeVersion ();
        try {
            version = versionService.selectByKey(id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(version);
    }
    /**
     *
     * @param type 1 基本 2 手术
     * @param val  like name
     * @return
     */
    @ApiOperation(value = "根据类型查询版本号")
    @GetMapping("/getICDVersionBytype")
    public ResultUtil getICDVersionBytype(@RequestParam(value = "type",required = true) Integer type,
                                             @RequestParam(value = "val",defaultValue = "") String val) {
        List<DrplusCodeVersion> list = new ArrayList<>();
        try {
            list = versionService.getVersionBytype(type,val);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }

    @ApiOperation(value = "修改保存版本号")
    @PostMapping("/saveICDVersion")
    public ResultUtil saveICDVersion(@RequestBody  @Valid DrplusCodeVersion drplusCodeVersion, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            versionService.saveICDVersion(drplusCodeVersion);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     * @param type
     * @return
     */
    @ApiOperation(value = "删除版本号")
    @GetMapping("/delICDVersionById")
    public ResultUtil delICDVersionById(@RequestParam(value = "type",required = true) Integer type ,
                                        @RequestParam(value = "id",required = true) Integer id ) {

        try {
            if(versionService.getCountBytype(type,id)>0)
                return  ResultUtil.error("此版本号中已经存在数据,请先删除该本版对映数据");
            versionService.delICDVersionById(id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }




    /* ================================= 2  ICD明细篇  =================================*/




    @ApiOperation(value = "保存修改ICD编码")
    @PostMapping("/saveICD")
    public ResultUtil saveICD(@RequestBody ICDDBO icddbo ){
        try {
            versionService.saveICD(icddbo);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    @ApiOperation(value = "删除ICD编码")
    @DeleteMapping("/delICD")
    public ResultUtil delICD(@RequestBody ICDDBO icddbo ){
        try {
            versionService.delICD(icddbo);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     *
     * @param pageInfo
     * @param pid    drplus_code_version_id
     * @param type 1 疾病 2 手术
     * @return
     */
    @ApiOperation(value = "查询 疾病/手术 明细")
    @GetMapping("/getDetailedByPid")
    public ResultUtil getDetailedByPid(PageInfo pageInfo,
                                          @RequestParam(value = "pid",required = true) Integer pid ,
                                          @RequestParam(value = "type",required = true) Integer type ,
                                       @RequestParam(value = "val",defaultValue = "") String val) {
        Map<String, Object> listPage=null;
        try {
            if (type==1){
                List<DrplusJbicd> list = jbicdService.getDetailedByPid(pid,val);
                listPage = PageList.getListPage(pageInfo, list);
            }else if (type==2){
                List<DrplusSsicd> list = ssicdService.getDetailedByPid(pid,val);
                listPage = PageList.getListPage(pageInfo, list);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }



    // 1 先执行客户端sql脚本数据 采用 select distinct  dm ,mc  ,'这里建荣给我拼接好' pid  from ttt where ?

    @ApiOperation(value = "根据前端脚本 执行结果")
    @GetMapping("/getDataBySql")
    public ResultUtil getDataBySql(PageInfo pageInfo,
                                    @RequestParam(value = "sqltext",required = true) String sqltext
                                             ) {
        Map<String, Object> listPage=null;
        try {
            List<LinkedHashMap<String, Object>> dataBySql = ssicdService.getDataBySql(sqltext);
            if(!StringUtils.isEmpty(dataBySql) && dataBySql.size()>0){
                listPage = PageList.getListPage(pageInfo, dataBySql);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }

     // 2 看到数据后  保存  前端直接凭借完成
     //  insert into drplus_jbicd ( drplus_code_version_id,code,name) select distinct <版本号直接写上>  dm ,mc  ....
        // 这个表 id 做了默认值newid()
     @ApiOperation(value = "看到数据后  保存")
     @GetMapping("/insertSelectICD")
     public ResultUtil saveImportDataICD(@RequestParam(value = "sqltext",required = true) String sqltext,
                                         @RequestParam(value = "type",required = true) Integer type,
                                         @RequestParam(value = "versionId",required = true) Integer versionId,
                                         @RequestParam(value = "yzm",defaultValue = "") String yzm){

         String falg ;
         try {
             //1 先判断 这个版本下有没有数据  有数据需要他们 选择
             if("".equals(yzm)){
                 if(type==1){
                     if(jbicdService.getCountByVersionId(versionId)>0){
                         falg = "确定覆盖,需要验证码";
                         return ResultUtil.error(falg);
                     }else{
                         Integer integer2 = jbicdService.saveImportDataICD(sqltext);
                     }
                 }else if(type==2){
                     if(ssicdService.getCountByVersionId(versionId)>0){
                         falg = "确定覆盖,需要验证码";
                         return ResultUtil.error(falg);
                     }else{
                         Integer integer3 = ssicdService.saveImportDataICD(sqltext);
                     }
                 }
             }else{
                 if( !DataUtil.isValid(yzm))
                     return ResultUtil.error("验证码错误");
                 if(type==1){
                     //先删除数据 根据版本号
                     jbicdService.delinsertICDSql( versionId,sqltext);
                    /* Integer integer = jbicdService.delByVersionId(versionId);
                     Integer integer2 = jbicdService.saveImportDataICD(sqltext);*/
                 }else if(type==2){
                     //先删除数据 根据版本号
                     ssicdService.delinsertICDSql( versionId,sqltext);
                /*     Integer integer = ssicdService.delByVersionId(versionId);
                     Integer integer3 = ssicdService.saveImportDataICD(sqltext);*/
                 }
             }
         } catch (Exception e) {
             logger.error(e+LineBreak);
             return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
         }
         return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
     }


    // 第二种方式 文件上传    把数据储存到容器中
    @ApiOperation(value = "文件上传读取 不展示")
    @PostMapping("/fileuploadShow")
    public ResultUtil fileuploadShow(PageInfo pageinfo,@RequestParam("file") MultipartFile file  ){
        try {
            List<Map<String, Object>> maps = DataUtil.readExcelData(file);
            //使用一个 集合做容器
            DrPlusApplicationRunnerImpl.contextMap.put("execl",maps);
        }catch (Exception e){
            logger.error(e+LineBreak);
            return ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    @ApiOperation(value = "文件数据回显")
    @GetMapping("/getDataByExeclShow")
    public ResultUtil getDataBySql(PageInfo pageInfo) {
        Map<String, Object> listPage=null;
        try {
            List<Map<String,Object>> list = (List<Map<String, Object>>) DrPlusApplicationRunnerImpl.contextMap.get("execl");
            if(!StringUtils.isEmpty(list) && list.size()>0){
                listPage = PageList.getListPage(pageInfo, list);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }



    /**
     *  点击保存 先判断 此版本编码有没有数据 没有数据可以保存  如果有数据需要 输入验证码 验证通过 然后再保存
     * @return
     */
   @ApiOperation(value = "确定保存文件数据")
   @GetMapping("/savefileuploadShow")
   public ResultUtil savefileuploadShow(@RequestParam(value = "versionId",required = true) Integer versionId ,
                                        @RequestParam(value = "type",required = true) Integer type,
                                        @RequestParam(value = "yzm",defaultValue = "") String yzm ){
       String falg ;
       try {
            //1 先判断 这个版本下有没有数据  有数据需要他们
           if("".equals(yzm)){
               if(type==1){
                   Integer integer = jbicdService.getCountByVersionId(versionId);
                   if(integer>0){
                       falg = "确定覆盖,需要验证码";
                       return ResultUtil.error(falg);
                   }else{
                       //拼接sql insert into table (col1,col2,col3) values (1,2,versionId),(1,2,versionId)  执行
                       List<Map<String,Object>> list = (List<Map<String, Object>>) DrPlusApplicationRunnerImpl.contextMap.get("execl");
                       StringBuilder sb =  DataUtil.getInsertSqlText(list,type,versionId);
                       Integer  i = jbicdService.saveImportDataICD(sb.toString());
                   }
               }else if(type==2){
                   Integer integer = ssicdService.getCountByVersionId(versionId);
                   if(integer>0){
                       falg = "确定覆盖,需要验证码";
                       return ResultUtil.error(falg);
                   }else{
                       List<Map<String,Object>> list = (List<Map<String, Object>>) DrPlusApplicationRunnerImpl.contextMap.get("execl");
                       StringBuilder sb =  DataUtil.getInsertSqlText(list,type,versionId);
                       Integer  i = ssicdService.saveImportDataICD(sb.toString());
                   }
               }
           }else{
              if( !DataUtil.isValid(yzm))
                  return ResultUtil.error("验证码错误");
               if(type==1){
                   //先删除数据 根据版本号
                   jbicdService.delinsertICD(versionId,type);
                  /* Integer integer = jbicdService.delByVersionId(versionId);
                   // (注意主键问题)拼接sql insert into table (col1,col2,col3) values (1,2,versionId),(1,2,versionId)  执行
                   List<Map<String,Object>> list = (List<Map<String, Object>>) DrPlusApplicationRunnerImpl.contextMap.get("execl");
                   StringBuilder sb =  DataUtil.getInsertSqlText(list,type,versionId);
                   Integer  i = jbicdService.insertBysql(sb.toString());*/
               }else if(type==2){
                   //先删除数据 根据版本号
                   ssicdService.delinsertICD(versionId,type);
                  /* Integer integer = ssicdService.delByVersionId(versionId);
                   List<Map<String,Object>> list = (List<Map<String, Object>>) DrPlusApplicationRunnerImpl.contextMap.get("execl");
                   StringBuilder sb =  DataUtil.getInsertSqlText(list,type,versionId);
                   Integer  i = ssicdService.insertBysql(sb.toString());*/
               }
           }
       }catch (Exception e){
           logger.error(e+LineBreak);
           return ResultUtil.error(e.getMessage());
       }
       return ResultUtil.success( DataUtil.SUCCESS_MASSAGE );
   }



    @ApiOperation(value = "导出Excel" )
    @GetMapping("/exportExecl")
    public void exportExecl(   @RequestParam(value = "pid" ,required = true) Integer pid ,
                            @RequestParam(value = "type" ,required = true) Integer type ,
                            HttpServletResponse response) {

        try {
            //初始化数据题头
            List<String> header = initializationHeard();
            //设置HttpServletResponse中的属性
            setServletResponseProperties(response);
            List<LinkedHashMap<String, Object>> dataBySql = null;
            if (type==1){
                dataBySql = jbicdService.getDataBySql("select code,name from drplus_jbicd where drplus_code_version_id="+pid +" order by code ");
            }else if (type==2){
                dataBySql = ssicdService.getDataBySql("select code,name from drplus_ssicd where drplus_code_version_id="+pid +" order by code ");
            }
            //String filePath="files/upload/execl/查询数据结果(病案)"+modelD.getUser_id()+".xls";
            //path = PoiUtil.createExcel("查询数据结果",filePath,header,dataBySql);
            HSSFWorkbook wb = DataUtil.createExcel("导出数据结果", header, dataBySql);
            OutputStream outputStream = response.getOutputStream();
            wb.write(response.getOutputStream());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            logger.error( e+LineBreak);
        }
        return;
    }

    public List<String> initializationHeard(){
        List<String> header = new ArrayList<>();
       // header.add("序号");
        header.add("代码");
        header.add("名称");
        return header;
    }

    private void setServletResponseProperties(HttpServletResponse response) throws UnsupportedEncodingException {
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        //处理乱码问题
        response.setCharacterEncoding("UTF-8");
        //设置上下文类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //客户使用目标另存为对话框保存指定文件
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode("编码","utf-8")  + ".xls;");

    }






    /* ================================= 3  ICD数据对映篇  =================================*/











    /**
     *   选择左侧下拉框 ,或者左右都选择完成后查询的结果 ,而右侧的idc编码数据需要 走getDetailedByPid(查询 疾病/手术 明细)接口
     * @param pageInfo
     * @param leftid
     * @param rightid
     * @param type
     * @param lval
     * @param rval
     * @param rval2 空字符串代表全部  有值代表查询未对映编码数据
     * @return
     */
    //
    @ApiOperation(value = "选择左侧下拉框 ,或者左右都选择完成后查询的结果")
    @GetMapping("/getContrastDate")
    public ResultUtil getContrastDate(PageInfo pageInfo,
                                      @RequestParam(value = "leftid",required = true) Integer leftid,
                                      @RequestParam(value = "rightid",defaultValue= "") Integer rightid,
                                      @RequestParam(value = "type",required = true) Integer type,
                                      @RequestParam(value = "lval",defaultValue = "") String lval,
                                      @RequestParam(value = "rval",defaultValue = "") String rval,
                                      @RequestParam(value = "rval2",defaultValue = "") String rval2
                                      ) {
        Map<String, Object> listPage=null;
        try {
            List  list = new ArrayList<>();
            if(StringUtils.isEmpty(rightid)){ //进来直接只查询左侧的数据
                if(type==1){
                    list = jbicdMapService.selectLeftData(leftid,lval);
                }else if(type==2){
                    list = ssicdMapService.selectLeftData(leftid,lval);
                }
                if(list.size()<1){
                    return ResultUtil.error("该版本没有对映的数据编码,请先插入数据编码!");
                }
                listPage = PageList.getListPage(pageInfo, list);
                return  ResultUtil.success(listPage);
            }

            if(type==1){
                  list = jbicdMapService.getContrastDate(leftid,rightid,lval,rval,rval2);
            }else if(type==2){
                  list = ssicdMapService.getContrastDate(leftid,rightid,lval,rval,rval2);
            }
            if(list.size()<1 ){
                return  ResultUtil.success(null);
            }
            listPage = PageList.getListPage(pageInfo, list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "自动对映(注入数据)")
    @GetMapping("/autoContrastICD")
    public ResultUtil autoContrastICD(@RequestParam(value = "leftid",required = true) Integer leftid,
                                      @RequestParam(value = "rightid",required = true) Integer rightid,
                                      @RequestParam(value = "type",required = true) Integer type) {

        try {
            if(type==1){
                if (jbicdService.getCountByVersionId(leftid)<=0)
                    return  ResultUtil.error(versionService.selectByKey(leftid).getName()+" 版本中没有数据");
                if (jbicdService.getCountByVersionId(rightid)<=0)
                    return  ResultUtil.error(versionService.selectByKey(rightid).getName()+" 版本中没有数据");
                Integer integer = jbicdMapService.autoContrastICD(leftid,rightid);
            }else if(type==2){
                if (ssicdService.getCountByVersionId(leftid)<=0)
                    return  ResultUtil.error(versionService.selectByKey(leftid).getName()+" 版本中没有数据");
                if (ssicdService.getCountByVersionId(rightid)<=0)
                    return  ResultUtil.error(versionService.selectByKey(rightid).getName()+" 版本中没有数据");
                Integer integer = ssicdMapService.autoContrastICD(leftid,rightid);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "手动对映保存")
    @PostMapping("/saveOneContrastICD")
    public ResultUtil saveOneContrastICD(@RequestBody DrplusJbicdMap drplusJbicdMap) {

        try {
            if(drplusJbicdMap.getType()==1){
                if(StringUtils.isEmpty(drplusJbicdMap.getId())){
                    //Integer integer = jbicdMapService.insert(drplusJbicdMap);
                    return  ResultUtil.error("请先点击注入数据");
                }else{
                    Integer integer = jbicdMapService.update(drplusJbicdMap);
                }
            }else if(drplusJbicdMap.getType()==2){
                DrplusSsicdMap ssicdMap = getSsicdMap(drplusJbicdMap);

                if(StringUtils.isEmpty(ssicdMap.getId())){
                   // Integer integer = ssicdMapService.insert(ssicdMap);
                    return  ResultUtil.error("请先点击注入数据");
                }else{
                    Integer integer = ssicdMapService.update(ssicdMap);
                }
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "清除对映")
    @GetMapping("/cleanMapping")
    public ResultUtil cleanMapping(@RequestParam(value = "leftid",required = true) Integer leftid,
                                   @RequestParam(value = "rightid",required = true) Integer rightid,
                                   @RequestParam(value = "type",required = true) Integer type) {

        try {
            if(type==1){
                Integer integer = jbicdMapService.cleanMapping(leftid,rightid);
            }else if(type==2){
                Integer integer = ssicdMapService.cleanMapping(leftid,rightid);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    // 1 先执行客户端sql脚本数据
    // 采用 select distinct  前端加 left_version_id  ,前端加  right_version_id ,left_code as left_code ,left_name as left_name ,right_code as right_code,right_name as right_name   from ttt where
    @ApiOperation(value = "根据前端脚本 执行结果 对映关系")
    @GetMapping("/getDataBySqlMap")
    public ResultUtil getDataBySqlMap(PageInfo pageInfo,
                                   @RequestParam(value = "sqltext",required = true) String sqltext
    ) {
        Map<String, Object> listPage=null;
        try {
            List<LinkedHashMap<String, Object>> dataBySql = ssicdService.getDataBySql(sqltext);
            if(!StringUtils.isEmpty(dataBySql) && dataBySql.size()>0){
                listPage = PageList.getListPage(pageInfo, dataBySql);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }

    /**
     *
     * 逻辑: 明细表一定比对映关闭里面的多,先插入明细,在用对映关系修改数据
     *
     *    第一步: 先将左侧版本的明细加到map对映表中
     *     insert into drplus_jbicd_map ( left_version_id,right_version_id,left_code,left_name,right_code,right_name)
     *     select code,name,null,null,参数版本1 ,参数版本2 from drplus_jbicd
     *     where not exists( select 1 from drplus_jbicd_map where left_version_id =drplus_jbicd.id and  left_code = name)
     *    第二步: 前端给的sql 脚本 用来当做子表连表更新操作
     *
     *     update a set a.right_code = b.right_code ,a.right_name = b.right_name
     *     from drplus_jbicd_map a,(前端脚本) where a.left_code = b.left_code
     *
     *   key 前端脚本:  select distinct 前端加 left_version_id  ,前端加  right_version_id, left_code as left_code ,left_name as left_name ,right_code as right_code,right_name as right_name   from ttt where
     *
     *
     *
     * @param sqltext
     * @param type
     * @param lvid
     * @param rvid
     * @param yzm
     * @return
     */

    //
    @ApiOperation(value = "看到数据后  保存 对映关系")
    @GetMapping("/insertSelectICDMap")
    public ResultUtil insertSelectICDMap(@RequestParam(value = "sqltext",required = true) String sqltext,
                                        @RequestParam(value = "type",required = true) Integer type,
                                        @RequestParam(value = "lvid",required = true) Integer lvid,
                                        @RequestParam(value = "rvid",required = true) Integer rvid,
                                        @RequestParam(value = "yzm",defaultValue = "") String yzm){

        String falg ;
        try {
            //1 先判断 这个版本下有没有数据  有数据需要他们 选择
            if("".equals(yzm)){
                if(type==1){
                    if(jbicdMapService.getCountByVersionId(lvid,rvid)>0){
                        falg = "确定覆盖,需要验证码";
                        return ResultUtil.error(falg);
                    }else{
                        Integer integer2 = jbicdMapService.saveImportDataICD(sqltext,lvid,rvid);
                    }
                }else if(type==2){
                    if(ssicdMapService.getCountByVersionId(lvid,rvid)>0){
                        falg = "确定覆盖,需要验证码";
                        return ResultUtil.error(falg);
                    }else{
                        Integer integer3 = ssicdMapService.saveImportDataICD(sqltext,lvid,rvid);
                    }
                }
            }else{
                if( !DataUtil.isValid(yzm))
                    return ResultUtil.error("验证码错误");
                if(type==1){
                    //先删除数据 根据版本号
                    jbicdMapService.delinsertICDSql( lvid,rvid,sqltext);
                }else if(type==2){
                    //先删除数据 根据版本号
                    ssicdMapService.delinsertICDSql( lvid,rvid,sqltext);
                }
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    /* ================================= 4 编码转换  =================================*/

    /**
     *  这里 只转换 加上主要的编码 总共15个   加到抽取列表后面
     * @param extractId
     * @param pid
     * @return
     */

    @ApiOperation(value = "编码转换")
    @GetMapping("/transformationICD")
    public ResultUtil transformationICD(
                                   @RequestParam(value = "extractId",required = true) Integer extractId,
                                   @RequestParam(value = "pid",required = true) Integer pid) {

        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            DrPlusPlatformDetailed detailed = platformDetailedService.selectByKey(pid);
            Integer leftSsId = detailed.getCurrent_ss_version_id();
            Integer rightSsId = detailed.getAsk_ss_version_id();
            Integer leftJbId = detailed.getCurrent_jb_version_id();
            Integer rightJbId = detailed.getAsk_jb_version_id();

            if(ssicdMapService.getCount(leftSsId,rightSsId)>0   ){
                if(!leftSsId.equals(rightSsId)){
                    if(2==pid || 3==pid){
                        ssicdMapService.transformationICD3(pid,extractId,leftSsId,rightSsId);
                    }else if(5==pid){
                        ssicdMapService.transformationICD5(pid,extractId,leftSsId,rightSsId);
                    }else if(6==pid){
                        ssicdMapService.transformationICD6(pid,extractId,leftSsId,rightSsId);
                    }else if(7==pid){
                        ssicdMapService.transformationICD7(pid,extractId,leftSsId,rightSsId);
                    }else if(8==pid){
                        ssicdMapService.transformationICD8(pid,extractId,leftSsId,rightSsId);
                    }else if(9==pid){
                        ssicdMapService.transformationICD9(pid,extractId,leftSsId,rightSsId);
                    }else if(10==pid){
                        ssicdMapService.transformationICD10(pid,extractId,leftSsId,rightSsId);
                    }else if(13==pid){
                        ssicdMapService.transformationICD13(pid,extractId,leftSsId,rightSsId);
                    }else if(14==pid){
                        ssicdMapService.transformationICD14(pid,extractId,leftSsId,rightSsId);
                    }else if(15==pid){
                        ssicdMapService.transformationICD15(pid,extractId,leftSsId,rightSsId);
                    }
                }
            }

            if(jbicdMapService.getCount(leftJbId,rightJbId)>0){
                if(!leftJbId.equals(rightJbId)){
                    if(2==pid || 3==pid){
                        jbicdMapService.transformationICD3(pid,extractId,leftJbId,rightJbId);
                    }else if(5==pid){
                        jbicdMapService.transformationICD5(pid,extractId,leftJbId,rightJbId);
                    }else if(6==pid){
                        jbicdMapService.transformationICD6(pid,extractId,leftJbId,rightJbId);
                    }else if(7==pid){
                        jbicdMapService.transformationICD7(pid,extractId,leftJbId,rightJbId);
                    }else if(8==pid){
                        jbicdMapService.transformationICD8(pid,extractId,leftJbId,rightJbId);
                    }else if(9==pid){
                        jbicdMapService.transformationICD9(pid,extractId,leftJbId,rightJbId);
                    }else if(10==pid){
                        jbicdMapService.transformationICD10(pid,extractId,leftJbId,rightJbId);
                    }else if(13==pid){
                        jbicdMapService.transformationICD13(pid,extractId,leftJbId,rightJbId);
                    }else if(14==pid){
                        jbicdMapService.transformationICD14(pid,extractId,leftJbId,rightJbId);
                    }else if(15==pid){
                        jbicdMapService.transformationICD15(pid,extractId,leftJbId,rightJbId);
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }







    DrplusSsicdMap getSsicdMap(DrplusJbicdMap drplusJbicdMap){
        DrplusSsicdMap drplusSsicdMap = new DrplusSsicdMap();
        drplusSsicdMap.setId(drplusJbicdMap.getId());
        drplusSsicdMap.setLeft_code(drplusJbicdMap.getLeft_code());
        drplusSsicdMap.setLeft_name(drplusJbicdMap.getLeft_name());
        drplusSsicdMap.setLeft_version_id(drplusJbicdMap.getLeft_version_id());
        drplusSsicdMap.setRight_code(drplusJbicdMap.getRight_code());
        drplusSsicdMap.setRight_name(drplusJbicdMap.getRight_name());
        drplusSsicdMap.setRight_version_id(drplusJbicdMap.getRight_version_id());
        return drplusSsicdMap;
    }









}
