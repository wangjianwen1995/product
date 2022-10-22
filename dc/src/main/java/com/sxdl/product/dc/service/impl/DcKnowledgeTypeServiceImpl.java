package com.sxdl.product.dc.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.entity.DcKnowledgeType;
import com.sxdl.product.dc.service.DcKnowledgeTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("dcKnowledgeTypeService")
@Transactional
public class DcKnowledgeTypeServiceImpl extends BaseUUIDServiceImpl<DcKnowledgeType> implements DcKnowledgeTypeService {


}
