package com.sxdl.hn.util;

import com.sxdl.base.dao.dao1.SysUserDao;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.TreeUtils;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.dto.StartAssessmentDBO;
import com.sxdl.hn.dto.StartAssessmentEndDBO;
import com.sxdl.hn.entity.HnQualityCategory;
import com.sxdl.hn.entity.HnQualitySuborder;
import com.sxdl.hn.entity.HnQualityTemplate;
import com.sxdl.hn.entity.HnQualitydetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class HNApplicationRunnerImpl extends ApplicationRunnerImpl {

    //类目亚目
    public volatile static Map<String, List<HnQualityCategory>> contextMap = new ConcurrentHashMap<>();

    //这个是用来快速查询出来的细目
    public volatile static Map<Integer, List<HnQualitydetails>> detailsMap = new ConcurrentHashMap<>();

    //这个用来储存模板的细目:这里将模板跟细目整合号,目地是为了让开始考核的时候整合数据更加快速
    public volatile static Map<Integer, List<HnQualitydetails>> templateMap = new ConcurrentHashMap<>();

    //存储开始考核的行列融合的数据
    public volatile static  Map<Integer, StartAssessmentEndDBO> startAssessment = new  ConcurrentHashMap<>();

    @Autowired
    private HnHandleDao hnHandleDao;

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        init();
        //类目亚目放到缓存中
        setLmYm();

        //细目放到缓存中
        setXm();

        //考核模板放到缓存中
        putTemplate();

        //开始考核放到缓存中
        templateMap.forEach((k,v)-> {
            try {
                putStartAssessment(k);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }



    /**
     *  重新加载类目亚目缓存
     */
    public void setLmYm(){
        //类目
        List<HnQualityCategory> category = hnHandleDao.findCategory();
        //亚目
        List<HnQualitySuborder> suborder = hnHandleDao.findSuborder();
        //重新加载类目亚目缓存
        contextMap.clear();
        for (HnQualityCategory hnQualityCategory : category) {
            List<HnQualitySuborder> temp = new ArrayList<>();
            for (HnQualitySuborder hnQualitySuborder : suborder) {
                if(hnQualityCategory.getId().equals(hnQualitySuborder.getCategory_id())){
                    temp.add(hnQualitySuborder);
                }
            }
            hnQualityCategory.setSuborders(temp);
        }
        contextMap.put("lmym",category);
    }

    /**
     * 重新加载细目到缓存中
     */
    public void setXm(){
        //细目
        List<HnQualitydetails> details = hnHandleDao.findDetails();
        detailsMap.clear();
        //只保存考核细目  key 是亚目  val是 细目
        detailsMap = details.stream().filter(e -> !StringUtils.isEmpty(e.getSuborder_id())).
                collect(Collectors.groupingBy(e -> e.getSuborder_id()));

    }


    /***
     * 获取考核类目 亚目
     */
    public static List<HnQualityCategory> getLmYm (){
       return   contextMap.get("lmym");
    }



    /**
     * 初始化数据的时候,重新加载 考核模板数据
     */
    public   void putTemplate(){
        List<HnQualityTemplate> templates = hnHandleDao.findTemplate();
        for (HnQualityTemplate template : templates) {
            if(StringUtils.isEmpty(template.getDetails_ids())||"".equals(template.getDetails_ids())){
                break;
            }
            List<HnQualitydetails> detailsInids = hnHandleDao.findDetailsInids(template.getDetails_ids());
            if(detailsInids.size()>0){
                detailsInids.forEach(e->{
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
                    //考核模板

                });
                templateMap.put(detailsInids.get(0).getTemplate_id(),detailsInids);
            }
        }
    }


    /**
     * 开始考核的时候,需要的数据, 这里就是将模板中的数据重新加载
     */
    public void putStartAssessment(Integer template_id) throws  Exception{
        //复制 模板中的数据
        List<HnQualitydetails> list = MyListUtil.deepCopy(templateMap.get(template_id));
        //将复制出来的数据进行树分组
        List<HnQualitydetails> tree = TreeUtils.tree(list, HnQualitydetails::getId,
                HnQualitydetails::getPid,
                HnQualitydetails::getChildren,
                HnQualitydetails::setChildren, null);

        //重新组装数据
        List<StartAssessmentDBO> startlist = new ArrayList<>();

        //前端第一列 融合多少行
        List<Integer> colArrays_one = new ArrayList<>();

        //前端第二列 融合多少行
        List<Integer> colArrays_two = new ArrayList<>();
        StartAssessmentDBO stratDbo = null;

        for (HnQualitydetails onehnQualitydetails : tree) {

            if(!StringUtils.isEmpty(onehnQualitydetails.getChildren())){ //第一层下面有数据 直接开始第二层计算
                List<HnQualitydetails> oneChildren = onehnQualitydetails.getChildren();


               for (HnQualitydetails towChild : oneChildren) {
                    if(!StringUtils.isEmpty(towChild.getChildren())){ //第二层下有数据 直接开始第三层计算
                        List<HnQualitydetails> towChildrens = towChild.getChildren();

                        for (HnQualitydetails thirdChildren : towChildrens) {
                            stratDbo = new StartAssessmentDBO();
                            stratDbo.setId(thirdChildren.getId());
                            stratDbo.setFirst_col(onehnQualitydetails.getName());
                            stratDbo.setSecond_col(towChild.getName());
                            stratDbo.setThird_col(thirdChildren.getName());
                            stratDbo.setDeduction_comment(thirdChildren.getDeduction_comment());
                            stratDbo.setDetails(thirdChildren);

                            // 添加oneArray 数据
                            boolean flag = true;
                            if(startlist.size()>0){ //判断有没有同一父级的数据有就 在添加oneArray->list里面添加0
                                end: for (StartAssessmentDBO startAssessmentDBO : startlist) {
                                    List<HnQualitydetails> collect = oneChildren.stream().filter(e -> e.getId().equals(startAssessmentDBO.getDetails().getPid())).collect(Collectors.toList());
                                    if(collect.size()>0){
                                        if( towChild.getPid().equals(collect.get(0).getPid())){
                                            flag = false;
                                            break end;
                                        }
                                    }

                                }
                            }
                            //同级的数据,不重复添加到数组中
                            if (flag){
                                int size = 0;
                                for (HnQualitydetails twojs : oneChildren) {
                                    if(!StringUtils.isEmpty(twojs.getChildren())){
                                        size+=twojs.getChildren().size();
                                    }else{
                                        size+=1;
                                    }
                                }
                                colArrays_one.add(size);
                            }else {
                                colArrays_one.add(0);
                            }
                            //添加数据

                            // 添加twoArray 数据
                            boolean flag2 = true;
                            //startlist 这里面存储的是刚刚放进去的考核数据,用这里的数据对比 新进来的数据 是否有同一级别的
                            if(startlist.size()>0){ //判断有没有同一父级的数据有就 在twoArray->list里面添加0
                                endTwo: for (StartAssessmentDBO startAssessmentDBO : startlist) {
                                    if( thirdChildren.getPid().equals(startAssessmentDBO.getDetails().getPid())){
                                        flag2 = false;
                                        break endTwo;
                                    }
                                }
                            }
                            //同级的数据,不重复添加到数组中
                            if (flag2){
                                colArrays_two.add(towChildrens.size());
                            }else {
                                colArrays_two.add(0);
                            }
                            startlist.add(stratDbo);
                        }

                    }else{ //第二层 的下面 没有 子数据
                        stratDbo = new StartAssessmentDBO();
                        stratDbo.setId(towChild.getId());
                        stratDbo.setFirst_col(onehnQualitydetails.getName());
                        stratDbo.setSecond_col(towChild.getName());
                        stratDbo.setDeduction_comment(towChild.getDeduction_comment());
                        stratDbo.setDetails(towChild);
                        boolean flag = true;
                        if(startlist.size()>0){ //判断有没有同一父级的数据有就 在list里面添加0
                            end: for (StartAssessmentDBO startAssessmentDBO : startlist) {
                               if( towChild.getPid().equals(startAssessmentDBO.getDetails().getPid())){
                                   flag = false;
                                   break end;
                               }
                            }
                        }
                        //同级的数据,不重复添加到数组中
                        if (flag){
                            int size = 0;
                            for (HnQualitydetails twojs : oneChildren) {
                                if(!StringUtils.isEmpty(twojs.getChildren())){
                                    size+=twojs.getChildren().size();
                                }else{
                                    size+=1;
                                }
                            }
                            colArrays_one.add(size);
                        }else {
                            colArrays_one.add(0);
                        }
                        colArrays_two.add(1);
                        startlist.add(stratDbo);
                    }
                }

            }else{//只有一层数据
                stratDbo = new StartAssessmentDBO();
                stratDbo.setId(onehnQualitydetails.getId());
                stratDbo.setFirst_col(onehnQualitydetails.getName());
                stratDbo.setDeduction_comment(onehnQualitydetails.getDeduction_comment());
                stratDbo.setDetails(onehnQualitydetails);
                colArrays_one.add(1);
                colArrays_two.add(1);
                startlist.add(stratDbo);
            }

        }
        StartAssessmentEndDBO assessmentEndDBO = new StartAssessmentEndDBO();
        assessmentEndDBO.setColArrays_one(colArrays_one);
        assessmentEndDBO.setColArrays_two(colArrays_two);
        assessmentEndDBO.setStartAssessment(startlist);

        Iterator<Integer> iter = startAssessment.keySet().iterator();
        while(iter.hasNext()){
            Integer key = iter.next();
            if(template_id.equals(key)){
                iter.remove();
            }
        }
        startAssessment.put(template_id,assessmentEndDBO);
    }





    /**
     * 模板那块,修改新增的时候,或者模板右侧 勾选考核细目的时候 重新加载 考核模板缓存
     *
     * @param template
     */
    public   void putTemplate(HnQualityTemplate template) {
       /* if(StringUtils.isEmpty(template.getDetails_ids())||"".equals(template.getDetails_ids())){
            return;
        }*/
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
            templateMap.put(template.getId(), detailsInids);

        }
    }


    // 移除缓存中的模板数据, 模板 是map形式保存的 key就是模板id
    public   void delTemplate(Integer template) {
        Iterator<Integer> iter = templateMap.keySet().iterator();
        while(iter.hasNext()){
            Integer key = iter.next();
            if(template.equals(key)){
                iter.remove();
            }
        }
    }


    /**
     * 删除开始考核中的数据
     * @param template
     */
    public void delstartAssessment(Integer template){
        Iterator<Integer> iter = startAssessment.keySet().iterator();
        while(iter.hasNext()){
            Integer key = iter.next();
            if(template.equals(key)){
                iter.remove();
            }
        }
    }


}
