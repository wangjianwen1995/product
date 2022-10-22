package com.sxdl.product.dc.service.impl;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcKnowledgeDao;
import com.sxdl.product.dc.entity.DcKnowledge;
import com.sxdl.product.dc.service.DcKnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dcKnowledgeService")
@Transactional
public class DcKnowledgeServiceImpl extends BaseUUIDServiceImpl<DcKnowledge> implements DcKnowledgeService {

    @Autowired
    private DcKnowledgeDao dcKnowledgeDao;

    @Override
    public Map<String,String> upload(MultipartFile file, HttpServletRequest req) {
        Map<String,String> m = new HashMap();
        String url="";
        String realpath = System.getProperty("user.dir")+"\\files\\dcUpload";
        String fileName= file.getOriginalFilename();
        File folder = new File(realpath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        try {
            file.transferTo(new File(folder,fileName));
            url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/files/dcUpload/"+fileName;
            String oldName= fileName.substring(0,fileName.lastIndexOf("."));

            String suffix = url.substring(url.lastIndexOf("."));
//            String type = FileTransForUtils.getResourceTypesDocument(suffix);
//            if("word".equals(type)){
//                FileTransForUtils.word3Pdf(realpath+"\\"+fileName,realpath+"\\"+oldName+".pdf");
//            }else if("excel".equals(type)){
//                FileTransForUtils.excel3pdf(realpath+"\\"+fileName,realpath+"\\"+oldName+".pdf");
//            }else if("ppt".equals(type)){
//                FileTransForUtils.ppt3pdf(realpath+"\\"+fileName,realpath+"\\"+realpath+".pdf");
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        m.put("url",url);
        m.put("fileName",fileName);
        return m;
    }

    @Override
    public Boolean delfile(String fileName) {
        String filepath = System.getProperty("user.dir")+"\\files\\dcUpload\\"+fileName;
        String pdfFilepath= filepath.substring(0,filepath.lastIndexOf("."));
        System.out.println(filepath);
        System.out.println(pdfFilepath);
        File oldFile = new File(filepath);
        File oldpdfFile = new File(pdfFilepath+".pdf");
        if (!oldFile.exists() || !oldpdfFile.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return true;
        } else {
            oldFile.delete();
            oldpdfFile.delete();
            return true;
        }


    }

    @Override
    public PageInfo likeFind(PageInfo pageInfo, String name,String typeid) {
        String columnsSql = " * ";
        String fromAndWhereSql = " from dc_knowledgebase  where 1=1";
        if (StringUtil.isNotEmpty(name)) {
            fromAndWhereSql += " and (filename like '%"+name+"%' or type like '%"+name+"%' or filesource like '%"+name+"%' or stowedposi like '%"+name+"%' or name like '%"+name+"%')";
        }
        if(StringUtil.isNotEmpty(typeid)){
            fromAndWhereSql += " and type='"+typeid+"' ";

        }        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, " filepublish ", pageInfo, true);
        //System.out.println(columnsSql);
        List<Map<String, Object>> maps = dcKnowledgeDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;

    }
}
