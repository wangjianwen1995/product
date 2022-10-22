package com.sxdl.hn.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.dto.ObjDBO;
import com.sxdl.hn.dto.StartAssessmentDBO;
import com.sxdl.hn.dto.StartAssessmentEndDBO;
import com.sxdl.hn.entity.*;
import com.sxdl.hn.service.HnAssessmentQuestionsService;
import com.sxdl.hn.service.HnQualityAssessmentService;
import com.sxdl.hn.service.HnQualityTemplateService;
import com.sxdl.hn.util.HNApplicationRunnerImpl;
import com.sxdl.hn.util.MyListUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = "开始考核的质量考核保存表只保存公共抬头数据")
@RestController
@RequestMapping("/assessment")
public class HnQualityAssessmentController {

    @Autowired
    private HnQualityAssessmentService assessmentService;

    @Autowired
    private HnHandleDao hnHandleDao;

    @Autowired
    private HnQualityTemplateService templateService;

    @Autowired
    private HnAssessmentQuestionsService questionsService;

    @Autowired
    private HNApplicationRunnerImpl hnApplicationRunner;

    @Autowired
    private YmlUtil ymlUtil;

    @ApiOperation(value = "查询患者信息")
    @GetMapping("/findhzinfo")
    public ResultUtil findhzinfo(PageInfo pageInfo,
                                 @RequestParam(value = "kscode", required = false) String kscode,
                                 @RequestParam(value = "zyhOrname", required = false) String zyhOrname) {
        Map<String, Object> listPage = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select top 100 * from hnpatientinfo where 1=1 ");
            if (!StringUtils.isEmpty(kscode)) {
                sb.append(" and ry_code='" + kscode + "' ");
            }
            if (!StringUtils.isEmpty(zyhOrname)) {
                sb.append(" and ( zyh like '%" + zyhOrname + "%' or name like '%" + zyhOrname + "%' ) ");
            }
            sb.append(" order by ry_time desc ");
            String sql = sb.toString();
            List<Hnpatientinfo> hzxx = hnHandleDao.findHzxx(sql);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hzxx);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "新增时 查询 考核数据的模板")
    @GetMapping("/findTempAssessment")
    public ResultUtil findTempAssessment(@RequestParam(value = "template_id", required = true) Integer template_id) {
        StartAssessmentEndDBO startAssessment;
        try {
            startAssessment = hnApplicationRunner.startAssessment.get(template_id);
            String checktype = startAssessment.getChecktype();
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(startAssessment);
    }




    /**
     * 查看数据的时候, 需要加上科室权限,没哟科室权限的看不到数据
     *
     * @param pageInfo    如题
     * @param suborder_id 如题
     * @param stime       如题
     * @param etime       如题
     * @param is_hlb      如题
     * @param kscode      如题
     */
    @ApiOperation(value = "查询科室考核记录")
    @GetMapping("/findKsAssessment")
    public ResultUtil findKsAssessment(PageInfo pageInfo,
                                       @RequestParam(value = "suborder_id", required = true) Integer suborder_id,
                                       @RequestParam(value = "stime", required = true) String stime,
                                       @RequestParam(value = "etime", required = true) String etime,
                                       @RequestParam(value = "is_hlb", required = true) Integer is_hlb,
                                       @RequestParam(value = "kscode", required = false) String kscode,
                                       @RequestParam(value = "isadmin", required = true) String isadmin,
                                       @RequestParam(value = "allkscodes", required = true) String allkscodes) {
        Map<String, Object> listPage = null;
        List<HnQualityAssessment> list = new ArrayList<>();
        try {
            if (StringUtils.isEmpty(kscode)) {
                if ("1".equals(isadmin)) { //没有选择科室,管理人员查看全部科室数据
                    list = assessmentService.findByCanAllKs(stime, etime, is_hlb, suborder_id);
                } else {//没有选择科室,科级人员查看  可看科室数据
                    list = assessmentService.findByCanseeKs(stime, etime, allkscodes, is_hlb, suborder_id);
                }
            } else {
                list = assessmentService.findByKs(stime, etime, kscode, is_hlb, suborder_id);
            }
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
            List<HnQualityAssessment> list1 = (List<HnQualityAssessment>) listPage.get("list");
            if (!StringUtils.isEmpty(list1)) {
                list1.forEach(e -> {
                    //String ksname = hnHandleDao.getksname(e.getKs_code(), ymlUtil.getDCDBname());
                    String ksname = hnHandleDao.selectSqlWithSQLStr("select name from sys_ks where code ="+e.getKs_code());
                    String assessor = e.getAssessor();
                    String assessorname = hnHandleDao.getassessorname(assessor);
                    e.setAssessor_ksname(ksname);
                    e.setAssessor_name(assessorname);
                });
            } else {
                return ResultUtil.success(null);
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success(listPage);
    }


    @ApiOperation(value = "点击修改 回显数据  ")
    @GetMapping("/showAssessment")
    public ResultUtil showAssessment(@RequestParam(value = "id", required = true) Integer id,
                                     @RequestParam(value = "template_id", required = true) Integer template_id) {
        HnQualityAssessment e = new HnQualityAssessment();
        try {

            e = assessmentService.selectByKey(id);
            /**
             *   准备模板数据(开始考核的数据) ,缓存中有在缓存中提取
             */

            StartAssessmentEndDBO tempDbo = hnApplicationRunner.startAssessment.get(template_id);
            //缓存中没有,将数据放到缓存中
            if (StringUtils.isEmpty(tempDbo)) {
                List<HnQualitydetails> hnQualitydetails = returnObj(template_id);
                hnApplicationRunner.putStartAssessment(template_id);
                tempDbo = hnApplicationRunner.startAssessment.get(template_id);
            }


            //String ksname = hnHandleDao.getksname(e.getKs_code(), ymlUtil.getDCDBname());
            String ksname = hnHandleDao.selectSqlWithSQLStr("select * from sys_ks where code =" +e.getKs_code());
            String assessor = e.getAssessor();
            String assessorname = hnHandleDao.getassessorname(assessor);
            e.setAssessor_ksname(ksname);
            e.setAssessor_name(assessorname);

            /**
             * 模板数据容器 一个人(患者/护士) 对映一个模板数据
             */
            List<StartAssessmentEndDBO> container = new ArrayList<>();

            /**
             *   准备问题数据
             */
            List<HnAssessmentQuestions> questions = questionsService.findquestionsByPid(e.getId());

            /**
             *  整理模板数据
             */

            //Tabs 题头数据
            List<ObjDBO> objs = new ArrayList<>();
            if ("a".equals(e.getChecktype())) { //是针对患者的考核
                List<HnChecktypeA> list = assessmentService.findbyPidA(e.getId());
                if (StringUtils.isEmpty(list)) return ResultUtil.success(e);
                for (HnChecktypeA hnChecktypeA : list) {
                    //组装 Tabs 题头 标签数据
                    ObjDBO obj = new ObjDBO();
                    obj.setAssessment_id(id);
                    obj.setCode(hnChecktypeA.getBlh());
                    obj.setName(hnChecktypeA.getName());
                    obj.setBlh(hnChecktypeA.getBlh());
                    obj.setZyh(hnChecktypeA.getZyh());
                    /**
                     *  组装 考核模板数据
                     */
                    //1 先copy 数据
                    StartAssessmentEndDBO startAssessmentEndDBO = MyListUtil.deepCopyObj(tempDbo);
                    for (StartAssessmentDBO startDBO : startAssessmentEndDBO.getStartAssessment()) {
                        for (HnAssessmentQuestions question : questions) {
                            if (startDBO.getId().equals(question.getDetalis_id()) && hnChecktypeA.getBlh().equals(question.getBlh())) {
                                startDBO.setPoint_deduction(question.getPoint_deduction());//扣分
                                startDBO.setPerson_liable(question.getPerson_liable());  // 责任人
                                startDBO.setPerson_liable_name(question.getPerson_liable_name()); // 责任人名称
                                startDBO.setProblem(question.getProblem());  // 批注
                            }
                        }
                    }
                    objs.add(obj);
                    container.add(startAssessmentEndDBO);
                }


            } else {//针对护士的考核
                List<HnChecktypeD> list = assessmentService.findbyPidD(e.getId());
                if (StringUtils.isEmpty(list)) return ResultUtil.success(e);
                for (HnChecktypeD hnChecktypeD : list) {
                    //组装 Tabs 题头 标签数据
                    ObjDBO obj = new ObjDBO();
                    obj.setCode(hnChecktypeD.getCode());
                    obj.setName(hnChecktypeD.getName());
                    obj.setAssessment_id(id);
                    /**
                     *  组装 考核模板数据
                     */
                    //1 先copy 数据
                    StartAssessmentEndDBO startAssessmentEndDBO = MyListUtil.deepCopyObj(tempDbo);
                    for (StartAssessmentDBO startDBO : startAssessmentEndDBO.getStartAssessment()) {
                        for (HnAssessmentQuestions question : questions) {
                            if (startDBO.getId().equals(question.getDetalis_id())
                                    && hnChecktypeD.getCode().equals(question.getPerson_liable())) {
                                startDBO.setPoint_deduction(question.getPoint_deduction());//扣分
                                startDBO.setPerson_liable(question.getPerson_liable());  // 责任人
                                startDBO.setPerson_liable_name(question.getPerson_liable_name()); // 责任人名称
                                startDBO.setProblem(question.getProblem());  // 批注
                            }
                        }
                    }
                    objs.add(obj);
                    container.add(startAssessmentEndDBO);
                }
                if ("b".equals(e.getChecktype())) {
                    HnChecktypeB checktypeB = assessmentService.findbyPidB(e.getId());
                    e.setChecktypeB(checktypeB);
                } else if ("c".equals(e.getChecktype())) {
                    HnChecktypeC checktypeC = assessmentService.findbyPidC(e.getId());
                    e.setChecktypeC(checktypeC);
                } else if ("e".equals(e.getChecktype())) {
                    HnChecktypeE checktypeE = assessmentService.findbyPidE(e.getId());
                    e.setChecktypeE(checktypeE);
                }
            }
            e.setContainer(container);
            e.setObjs(objs);
        } catch (Exception ex) {
            return ResultUtil.error(ex.getMessage());
        }
        return ResultUtil.success(e);
    }

    @ApiOperation(value = "修改 保存考核记录")
    @PostMapping("/saveAssessment")
    public ResultUtil saveAssessment(@RequestBody HnQualityAssessment hnQualityAssessment) {
        try {
            if (StringUtils.isEmpty(hnQualityAssessment.getId())) { //保存操作
                Integer i = assessmentService.saveAllAssessment(hnQualityAssessment);
            } else {//修改操作
                Integer i = assessmentService.updateAllAssessment(hnQualityAssessment);
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }


    @ApiOperation(value = "删除 考核记录")
    @GetMapping("/delAssessment")
    public ResultUtil delAssessment(@RequestParam(value = "id", required = true) Integer id,
                                    @RequestParam(value = "checktype", required = true) String checktype) {
        try {
            //查看要删除的数据 是否被反馈过 ,有就不允许删除
            List<HnAssessmentQuestions> questions = hnHandleDao.findIsfeedback(id);
            if (questions.size() > 0) {
                return ResultUtil.error("本条数据已经被反馈,无法删除");
            } else {
                Integer del = assessmentService.delAssessmentByid(id, checktype);
            }
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }


    /*
    暂时将 查询的历史模板的数据存储到缓存中,以防止再次查询历史数据的时候缓慢
     */
    public List<HnQualitydetails> returnObj(Integer template_id) {
        HnQualityTemplate template = templateService.selectByKey(template_id);
        List<HnQualitydetails> detailsInids = hnHandleDao.findDetailsInids(template.getDetails_ids());
        if (detailsInids.size() > 0) {
            detailsInids.forEach(e -> {
                e.setTemplate_id(template.getId());
                e.setTemplate_name(template.getName());
                e.setTemplate_create_time(template.getCreate_time());
                e.setTemplate_assessor(template.getAssessor());
                e.setTemplate_content_code(template.getContent_code());
                e.setTemplate_total_score(template.getTotal_score());
                e.setTemplate_qualified_score(template.getQualified_score());
                e.setTemplate_pass_rate(template.getPass_rate());
                e.setTemplate_checktype(template.getChecktype());
                e.setTemplate_scoring_type(template.getScoring_type());
                e.setTemplate_comment(template.getComment());
                e.setTemplate_suborder_id(template.getSuborder_id());
                e.setTemplate_details_ids(template.getDetails_ids());
                e.setTemplate_state(template.getState());
            });
            //考核模板
            hnApplicationRunner.templateMap.put(template.getId(), detailsInids);
        }
        return detailsInids;
    }


}
