package com.sxdl.report.service.impl;

import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.report.dao.dao1.DrTemplateDao;
import com.sxdl.report.dao.dao1.HandleDao;
import com.sxdl.report.entity.DrTemplate;
import com.sxdl.report.service.DrTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("drTemplateService")
@Transactional
public class DrTemplateServiceImpl extends BaseServiceImpl<DrTemplate> implements DrTemplateService {

    @Autowired
    HandleDao handleDao;

    @Autowired
    DrTemplateDao drTemplateDao;

    //创建链接服务器
    @Override
    public String creatLinkService(DrTemplate template){
        try{
            //获取到模板中的链接信息
            Integer linkType=template.getReport_source();
            String linkName="";



            switch (linkType){
                case 1:
                    linkName="DRBA";
                    break;
                case 2:
                    linkName="DRBA";
                    break;
                case 3:
                    linkName="DRSD";
                    break;
            }
            String host=template.getDb_host();
            String port="";
            if(host.contains(",")){
                port=host.substring(host.indexOf(","),host.length());
            }
            //String dbName=template.getDb_name();
            String userName=template.getDb_user();
            String password=template.getDb_password();
            return handleDao.creatLinkService(linkName,"SQLOLEDB",host,userName,password);
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public String linkIsExists(String serverName) {
        return handleDao.excuteCallProcedueParam("LINK_ISEXISTS",serverName);
    }

    //删除链接服务器
    @Override
    public void delLinkService(String linkName){
        try{
            String sql=" EXEC master.dbo.sp_dropserver @server=N'"+linkName+"', @droplogins='droplogins' ";
            handleDao.excuteSqlWithSQL(sql);

        }catch (Exception e){
        }

    }

    @Override
    public List<DrTemplate> getTemplateByType(){
        return drTemplateDao.getTemplateByType();
    }





}
