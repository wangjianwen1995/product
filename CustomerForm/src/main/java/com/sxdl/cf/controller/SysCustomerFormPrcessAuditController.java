package com.sxdl.cf.controller;


import com.sxdl.cf.dto.CodeNameDBO;
import com.sxdl.cf.dto.ToExamineDBO;
import com.sxdl.cf.entity.SysCustomerFormHistoryToexamineEntity;
import com.sxdl.cf.entity.SysCustomerFormProcessStepEntity;
import com.sxdl.cf.service.SysCustomerFormFactTableService;
import com.sxdl.cf.service.SysCustomerFormHistoryToexamineService;
import com.sxdl.cf.service.SysCustomerFormProcessStepService;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

@Api(tags = "审核流程|流程管理|步骤管理|分支管理" )
@RestController
@RequestMapping("/dev/processAudit")
@RequiredArgsConstructor
public class SysCustomerFormPrcessAuditController {



    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    private final SysCustomerFormProcessStepService processStepService;
    private final SysCustomerFormHistoryToexamineService historyToexamineService;

    private final SysCustomerFormFactTableService factTableService;
    /***
     * CodeNameDBO  启停状态  流程代码 流程说明
     * @param formId
     * @return
     */
    @ApiOperation(value = "查询流程")
    @GetMapping("/proce/getProcess")
    public ResultUtil getProcess( @RequestParam(value = "formId",required = true) String formId){
        Set<CodeNameDBO> set = null;
        try {
            set = processStepService.getProcess(formId);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( set);
    }

    /**
     *  新增流程  流程中的代码 无法选择 默认是 流程一 再次新增流程二 以此类推,必须写说明
     * @param1 process_code  自动生成可排序的无重复 可排序 字符串(根据他来判断 是否是修改还是新增)
     * @param1 process_explain  流程说明
     * @param1 form_id  表单id
     * @param1 stateon  启停状态
     * @return
     */
    @ApiOperation(value = "修改保存|启停流程")
    @PostMapping("/proce/saveProcess")
    public ResultUtil saveProcess(@RequestBody SysCustomerFormProcessStepEntity stepEntity ) {
        try {
            processStepService.saveProcess(stepEntity );
        } catch (Exception e) {
            logger.error(e+DataUtil.LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }






    ///////////////////////////////////////////////////////////////////步骤开始/////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * 每个流程下都会默认有一个步骤数据(初始化时空的)
     * @param formId      表单键
     * @param processcode 流程代码
     * @return
     */
    @ApiOperation(value = "查询步骤")
    @GetMapping("/step/getStepByProcessCode")
    public ResultUtil getStepByProcessCode( @RequestParam(value = "formId",required = true) String formId,
                                            @RequestParam(value = "processcode",required = true) String processcode){
        List<SysCustomerFormProcessStepEntity> list = null;
        try {
            list =   processStepService.getStepByProcessCode(formId,processcode);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( list);
    }



    /**
     *
     * @param stepEntity
     * @return
     */
    @ApiOperation(value = "修改保存步骤")
    @PostMapping("/step/saveStep")
    public ResultUtil saveStep(@RequestBody SysCustomerFormProcessStepEntity stepEntity) {
        try {
              processStepService.saveStep(stepEntity);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     *
     * @param formId
     * @param processCode
     * @param stepNumberOld   修改前的序号
     * @param stepNumberNew   修改后的序号
     * @return
     */
    @ApiOperation(value = "修改步骤顺序")
    @GetMapping("/step/setStepNumber")
    public ResultUtil setStepNumber(@RequestParam(value = "formId",required = true) String formId,
                                    @RequestParam(value = "processCode",required = true) String processCode,
                                    @RequestParam(value = "stepNumberOld",required = true) Integer stepNumberOld,
                                    @RequestParam(value = "stepNumberNew",required = true) Integer stepNumberNew) {
        try {
            if(factTableService.existsToexamineData(formId,processCode))
                return ResultUtil.error("非法操作：表单中正在进行该审核流程[不包括未开始的流程],需先完成审核流程");

            processStepService.saveStepNumber(formId,processCode,stepNumberOld,stepNumberNew);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    ///////////////////////////////////////////////////////////////////分支开始/////////////////////////////////////////////////////////////////////////////////////////

    @ApiOperation(value = "查询分支")
    @GetMapping("/branch/getBranchByStepCode")
    public ResultUtil getBranchByStepCode( @RequestParam(value = "formId",required = true) String formId,
                                           @RequestParam(value = "stepNumber",required = true) Integer stepNumber,
                                           @RequestParam(value = "processCode",required = true) String processCode ){
        List<SysCustomerFormProcessStepEntity> list = null;
        try {
            list =   processStepService.getBranchByStepCode(formId,stepNumber,processCode);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( list);
    }

    /**
     *
     * @param stepEntity
     * @return
     */
    @ApiOperation(value = "保存分支")
    @PostMapping("/branch/saveBranch")
    public ResultUtil saveBranch(@RequestBody SysCustomerFormProcessStepEntity stepEntity) {
        try {
            if(factTableService.existsToexamineData(stepEntity.getForm_id(),stepEntity.getProcess_code()))
                return ResultUtil.error("非法操作：表单中正在进行该审核流程[不包括未开始的流程],需先完成审核流程");
             processStepService.saveBranch(stepEntity);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    /**
     *  //key 这里注意删除后 步骤序号会改变的情况
     * 流程不予删除, 只需删除流程下的所有步骤对映流程即可消失
     * @param id
     * @return
     */
    @ApiOperation(value = "删除分支")
    @DeleteMapping("/step/delBranch")
    public ResultUtil delBranch( @RequestParam(value = "id",required = true) String id,
                                 @RequestParam(value = "stepNumber",required = true) Integer stepNumber,
                                 @RequestParam(value = "formId",required = true) String formId,
                                 @RequestParam(value = "processCode",required = true) String processCode ) {
        try {
            if(factTableService.existsToexamineData(formId,processCode))
                return ResultUtil.error("非法操作：单中正在进行该审核流程[不包括未开始的流程],需先完成审核流程");

            Integer integer = processStepService.delBranch(id,formId,processCode,stepNumber);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    ///////////////////////////////////////////步骤权限//////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * /dev/sysRole/ 人员信息
     * @param stepEntity
     * @return
     */
    @ApiOperation(value = "新增分支权限:人员数据")
    @PostMapping("/branchRole/setUsers")
    public ResultUtil setUsers( @RequestBody SysCustomerFormProcessStepEntity stepEntity ) {
        try {
            Integer integer = processStepService.updateSelective(stepEntity);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    //////////////////////////////////////////////////////审核流程//////////////////////////////////////////////////

    /**
     *
     *   只有新增保存的时候才会弹出  . 修改保存不能弹出
     *  key 如果表单下只有一个流程无需选择
     *  这里保存表单数据时候 ,选择流程后 应该赋值的字段有下面,
     *  toexamine_process       流程代码
     *  toexamine_step          步骤代码
     *  toexamine_branchs       分支代码组
     *  toexamine_result        结果0     ---->0
     *  toexamine_currentusers   当前审核人代码
     *  toexamine_currentname   当前审核人名称

     * @param formId
     * @return
     */
    @ApiOperation(value = "选择流程")
    @GetMapping("/toexamine/getStep")
    public ResultUtil getStep( @RequestParam(value = "formId",required = true)  String formId  ) {
        Set<ToExamineDBO> processOnable= null;
        try {
            //将查询到的流程数据返回给前端
            processOnable = processStepService.getProcessOnable(formId);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(processOnable);
    }

    /**
     * 核心逻辑:
     *   通过审核
     *      是否为驳回过的数据重新审核
     *        是
     *           先删除历史审核数据
     *           后续有步骤继续执行,表单数据标识执行中..
     *              ...分支
     *           没有,标识表单数据完成审核
     *              ...分支
     *        否
     *            后续有步骤继续执行,表单数据标识执行中..
     *            没有,标识表单数据完成审核
     *   驳回审核
     *      重第一步骤开始执行流程
     * key toexamine_result 审核结果:
     *     1进行中 9完成 0未开始 -1驳回   0 -1 允许当前操作人员删除修改,
     *      1 9 不能修改删除数据 但  1中 当前审核人可以修改数据
     * @param toexamineEntity
     * @return
     */
    @ApiOperation(value = "执行审核流程")
    @PostMapping("/toexamine/executeToexamine")
    public ResultUtil executeToexamine(   @RequestBody SysCustomerFormHistoryToexamineEntity toexamineEntity ){

        try {
            historyToexamineService.executeToexamine(toexamineEntity,factTableService.selectByKey(toexamineEntity.getForm_id()));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage() );
        }
        return  ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }


    /**
     * @param formDataId
     * @param formId
     * @param processCode
     * @return
     */
    @ApiOperation(value = "查询审核历史数据")
    @GetMapping("/toexamine/getHistoryStep")
    public ResultUtil getHistoryStep( @RequestParam(value = "formDataId",required = true)  String formDataId ,
                                      @RequestParam(value = "formId",required = true)  String formId,
                                      @RequestParam(value = "processCode",required = true)  String processCode ) {

        ReentrantLock lock = new ReentrantLock();
        List<Map<String,Object>> resultList = new ArrayList<>();
        try {
            //获取组装好的流程数据
            List<List<SysCustomerFormProcessStepEntity>> listList = processStepService.getProcessData(formDataId, formId, processCode);
            lock.lock();
            try {
                processStepService.coreMethod(resultList, listList);
            }catch (Exception e){
                throw new RuntimeException("线程异常:"+e.getMessage());
            }finally {
                lock.unlock();
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(resultList);
    }



}