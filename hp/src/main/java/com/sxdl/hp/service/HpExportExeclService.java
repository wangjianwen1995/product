package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpExprotExeclDao;
import com.sxdl.hp.dao.dao1.HpExprotTemplateDao;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpExportTemplate;
import com.sxdl.hp.entity.HpExprotExecl;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;

@Service
@Transactional
public class HpExportExeclService extends BaseServiceImpl<HpExprotExecl> {

    @Autowired
    private HpExprotExeclDao hpExprotExeclDao;
    @Autowired
    private HpExprotTemplateDao hpExprotTemplateDao;

    /**
     * 导出下载excel
     *
     * @param sql         sql
     * @param template_id 模板id
     * @param response    响应
     * @throws Exception 异常
     */
    public void down(String sql,Integer template_id,HttpServletResponse response)throws  Exception{
        //设置默认的数据
        StringBuffer sb = new StringBuffer("select distinct homepage.bah,homepage.XM,homepage.CYSJ,homepage.CYKBMC,homepage.ZYZD" +
                ",homepage.ZYZD_JBBM,homepage.SSJCZBM1,homepage.SSJCZMC1,homepage.ZFY,");
        //初始化数据题头
        List<String> header = new ArrayList<>();
        header.add("病案号");
        header.add("姓名");
        header.add("出院日期");
        header.add("出院科别");
        header.add("主诊断名称");
        header.add("主诊断编码");
        header.add("主手术名称");
        header.add("主手术编码");
        header.add("住院总费用");
        //先判断template_id有没有,有代表点击的是右侧模版列表,没有的话代表只点击了导出
        if (StringUtil.isEmptyNumber(template_id)) { //这里代表点击了模板导出,没有传模版id
            Integer aDefault = findDefault();
            if (!StringUtil.isEmptyNumber(aDefault)) {//默认模版不空,取默认模版的id
                template_id=aDefault;
            }else{//默认模版空了,去查配置过字段的模版
                List<HpExportTemplate> templateByColNotNull = getTemplateByColNotNull();
                if(CollUtil.isNotEmpty(templateByColNotNull)){//模版不空,取第一个
                    template_id=templateByColNotNull.get(0).getId();
                }
            }
        }
        //查询模板中的数据
        List<HpExprotExecl> defaultCols = hpExprotExeclDao.findDataByExportId(template_id);
        String name = "病案查询结果";
        Set<String> tables=new HashSet<>();//去重复的表名称
        if (defaultCols.size() > 0) { //模板中有数据 就用模板中数据 没哟数据就不动了就用默认的吧
            header.clear();
            HpExportTemplate hpExportTemplate = hpExprotTemplateDao.selectByPrimaryKey(template_id);
            name = hpExportTemplate.getName();
            sb.setLength(0);
            sb.append(" select distinct ");
            //检查导出字段中是否包含病案号,防止去重后导出数据变少的问题
            if(!defaultCols.stream().anyMatch(e->"bah".equals(e.getCol_name()))){
                defaultCols.add(HpExprotExecl.builder().col_name("bah").col_name_zh("病案号").table_name("homepage").build());
            }
            defaultCols.forEach(e -> {
                header.add(StrUtil.emptyToDefault(e.getCol_name_zh(), ""));
                if(!"homepage".equals(e.getTable_name())){//排除homepage
                    tables.add(e.getTable_name());
                }
                if (StringUtil.isNotEmpty(e.getCol_name_case())) {
                    sb.append(e.getCol_name_case() + "  as  [" + e.getCol_name_zh() + "] ,");
                } else {
                    sb.append("  " + e.getTable_name() + ".[" + e.getCol_name() + "] as  [" + e.getCol_name_zh() + "] ,");
                }
            });
        }
        sb.deleteCharAt(sb.length() - 1).append(" from homepage ");
        if(CollUtil.isNotEmpty(tables)){
            tables.forEach(e -> {
                sb.append(" left join  " + e + " on homepage.A_ID = " + e + ".A_ID \n");
            });
        }
        if (StrUtil.isNotEmpty(sql)) {
            sb.append(" where 1=1 " +sql);
        }
//        System.out.println("高级查询sql: " + sb);
        //数据库中获取sql结果数据
        List<LinkedHashMap<String, Object>> dataBySql = getDataBySql(sb.toString());
        //清空buffer,设置页面不缓存   是为了防止程序下载出错设置的！
        response.reset();
        //处理乱码问题
        response.setCharacterEncoding("UTF-8");
        //设置上下文类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //客户使用目标另存为对话框保存指定文件
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(name, "utf-8") + ".xls;");
        String filePath = HpApplicationRunnerImpl.FILESPATH + "/execl/查询数据结果(病案)" + DateUtil.formatFromDate3(new Date()) + ".xls";

        BigExcelWriter writer = ExcelUtil.getBigWriter(filePath);
        // 一次性写出内容，使用默认样式
        Workbook workbook = writer.write(dataBySql).getWorkbook();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    public List<HpColumn> findCanExeclColumn()  {
        return hpExprotExeclDao.findCanExeclColumn();
    }

    public void saveTemplate(HpExportTemplate template)  {
        if (StringUtil.isEmptyNumber(template.getId())) {
            hpExprotTemplateDao.insert(template);
        } else {
            hpExprotTemplateDao.updateByPrimaryKey(template);
        }
        if (null == template.getIs_default() || 1 != template.getIs_default()) {
            findDefaultExceptSelfThenUpdateDefault(template.getId(), template.getId());
        }
    }

    /**
     * 查除了自己以外的其他模版是否有默认,如果没有默认则设置特定的为默认
     *
     * @param id      自己id
     * @param otherId 特定id
     */
    void findDefaultExceptSelfThenUpdateDefault(Integer id, Integer otherId)  {
        Integer res = hpExprotTemplateDao.findDefaultExceptSelf(id);
        if (1 != res) {//没有默认的模版
            hpExprotTemplateDao.updateSelfDefault(otherId);
        }
    }

    /**
     * 如果仅有一条不能删除,且将本条设为默认
     * 如果有多条数据,先查其他模版中配置字段最少的模版id,本身是否默认都不重要因为马上要删除
     * 其他模版中没有默认,则将刚才查到的模版设置为默认
     * 其他模版中有默认,则继续删除方法
     *
     * @param template 需要删除的模版
     * @return
     * @
     */
    public ResultUtil delTemplate(HpExportTemplate template)  {
        Integer id = template.getId();
        Integer cnt = hpExprotTemplateDao.getAllTemplateExceptSelf(id);
        if (0 == cnt) {//仅有一条数据
            hpExprotTemplateDao.updateSelfDefault(id);
            return ResultUtil.error("只有一条不能删除");
        } else {
            Integer otherId = hpExprotTemplateDao.getMinLenColsTemplateExceptSelf(id);
            findDefaultExceptSelfThenUpdateDefault(id, otherId);
            hpExprotExeclDao.delDataByExportId(id);
            hpExprotTemplateDao.deleteByPrimaryKey(id);
            return ResultUtil.success("删除成功!");
        }
    }

    public List<HpExprotExecl> getColByTempalateID(Integer exprot_id)  {
        return hpExprotExeclDao.findDataByExportId(exprot_id);
    }

    public Integer saveColExecl(HpExprotExecl hpExprotExecl)  {
        Integer insert = null;
        if (hpExprotExecl.getCol_name().toLowerCase().startsWith("ssjb")) {
            hpExprotExecl.setCol_name_case("");
        }
        if (StringUtils.isEmpty(hpExprotExecl.getId())) {
            insert = hpExprotExeclDao.insert(hpExprotExecl);
        } else {
            insert = hpExprotExeclDao.updateByPrimaryKey(hpExprotExecl);
        }
        return insert;
    }

    public void delColExecl(HpExprotExecl exprotExecl)  {
        int i = hpExprotExeclDao.deleteByPrimaryKey(exprotExecl.getId());

    }

    /**
     * 更新自己的为默认,其他全部置空
     */
    public void updateDefault(Integer id)  {
        hpExprotTemplateDao.updateSelfDefault(id);
    }

    /**
     * 查询默认导出模板
     */
    public Integer findDefault()  {
        return hpExprotTemplateDao.findDefault();
    }

    /**
     * 查询配置了字段的模版
     */
    public List<HpExportTemplate> getTemplateByColNotNull()  {
        return hpExprotTemplateDao.getTemplateByColNotNull();
    }

    /**
     * 查询所有模版
     */
    public List<HpExportTemplate> getAllTemplate()  {
        return hpExprotTemplateDao.getAllTemplate();
    }
}
