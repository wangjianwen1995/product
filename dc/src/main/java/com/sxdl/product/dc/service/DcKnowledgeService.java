package com.sxdl.product.dc.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.entity.DcKnowledge;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface DcKnowledgeService extends BaseService<DcKnowledge> {

    Map<String,String> upload(MultipartFile file, HttpServletRequest req);
    Boolean delfile(String fileNames);

    PageInfo likeFind(PageInfo pageInfo,String name,String typeid);
}
