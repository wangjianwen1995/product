package com.sxdl.hn.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.hn.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

//his 其它sql数据
public interface HnHandleDao extends BaseDao<Hnpatientinfo> {

    @Select("${sql}")
    List<Hnpatientinfo> findHzxx(String sql);

    /**
     * 获取考核亚目
     */
    @Select("select * from quality_category")
    List<HnQualityCategory> findCategory();



    /**
     * 考核亚目
     */
    @Select("select * from quality_suborder")
    List<HnQualitySuborder> findSuborder();


    /**
     * 考核细目
     *@return
     */
    @Select("select * from quality_details")
    List<HnQualitydetails> findDetails();


    /**
     *  处理模板中转换数据
     * @param ids 如题
     */
    @Select("select * from quality_details where id in (${ids})")
    List<HnQualitydetails> findDetailsInids(String ids);

    /**
     *考核模板
     */
    @Select("select * from quality_template where state=1")
    List<HnQualityTemplate> findTemplate();

    /**
     * 查询亚目下启用的模板,一般是一个,但是为了防止出错,弄成 1,2,3 这样的
     * @param suborder_id 如题
     */
    @Select("select stuff(( SELECT ',' + convert(varchar(50),id)    FROM quality_template   where state = 1 and suborder_id=${suborder_id} for xml path('')),1,1,'') ")
    String findTemplateEnbleid2(Integer suborder_id);





    @Select("select * from quality_template ")
    List<HnQualityTemplate> findAllTemplate();

    @Select("select * from quality_template where suborder_id = ${suborder_id}")
    List<HnQualityTemplate> findsuborderTemplate(Integer suborder_id);

    @Select("select * from checktype_a where assessment_id = ${assessment_id}")
    List<HnChecktypeA> findChecktypeAByAssessment(Integer assessment_id);

    @Select("select * from checktype_b where  assessment_id = ${assessment_id}")
    List<HnChecktypeB> findChecktypeBByAssessment(Integer assessment_id);

    @Select("select * from checktype_c where  assessment_id = ${assessment_id}")
    List<HnChecktypeC> findChecktypeCByAssessment(Integer assessment_id);

    @Select("select * from assessment_questions where assessment_id= ${assessment_id}")
    List<HnAssessmentQuestions> findQuestions(Integer assessment_id);

    @Delete("delete from assessment_questions where  assessment_id=${id}")
    Integer delQuestionsByAId(Integer id);

    @Delete("delete from checktype_a where  assessment_id=${id}")
    Integer delByAId(Integer id);

    @Delete("delete from checktype_b where  assessment_id=${id}")
    Integer delByBId(Integer id);

    @Delete("delete from checktype_c where  assessment_id=${id}")
    Integer delByCId(Integer id);

    @Delete("delete from checktype_d where  assessment_id=${id}")
    Integer delByDId(Integer id);

    @Select("select * from quality_details where state=1 ")
    List<HnQualitydetails> findEnableDetails();

    @Select("select stuff(( SELECT ',' + convert(varchar(50),id)    FROM quality_details   where id in (${ids}) and type = 1 for xml path('')),1,1,'') ")
    String findDetailsIds(String ids);

    @Select(" select * from assessment_questions where assessment_id= ${id} and isnull(assessment_feedback_id,'')!='' ")
    List<HnAssessmentQuestions> findIsfeedback(Integer id);

    @Select(" select name from quality_suborder where id = ${suborder_id} ")
    String getSuborderName(Integer suborder_id);

    @Select("  select name from ${dcLink}..sys_ks where code = ${ks_code}")
    String getksname(String ks_code,String dcLink);
    @Select(" select name from sys_user where code = '${assessor}' ")
    String getassessorname(String assessor);

    @Select("{ call dbo.AutoWarningYj ('${code}') }")
    List<LinkedHashMap<String,String>> execProcYj(String code);

    @Select("{ call dbo.AutoWarningKj ('${code}') }")
    List<LinkedHashMap<String,String>> execProcKj(String code);

}
