package com.sxdl.report.service;


import com.sxdl.base.service.BaseService;
import com.sxdl.report.entity.DrTemplate;

import java.util.List;

public interface DrTemplateService extends BaseService<DrTemplate> {

    //删除链接服务器
    void delLinkService(String linkName);

    //创建链接服务器
    String creatLinkService(DrTemplate drTemplate);

    //判断链接是否存在 1 存在 2 不存在
    String linkIsExists(String serverName);

    List<DrTemplate> getTemplateByType();
}
