package com.sxdl.hr.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hr.entity.TxhlTdbytymjgEntity;
import com.sxdl.hr.service.HrTxhlTdbytymjgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("txhlTdbytymjgService")
@Transactional
public class HrTxhlTdbytymjgServiceImpl extends BaseUUIDServiceImpl<TxhlTdbytymjgEntity> implements HrTxhlTdbytymjgService {
}
