package com.sxdl.hr.service.impl;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hr.entity.TxhlGrbwxxEntity;
import com.sxdl.hr.service.HrTxhlGrbwxxService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("hrTxhlGrbwxxService")
@Transactional
public class HrTxhlGrbwxxServiceImpl extends BaseUUIDServiceImpl<TxhlGrbwxxEntity> implements HrTxhlGrbwxxService {
}
