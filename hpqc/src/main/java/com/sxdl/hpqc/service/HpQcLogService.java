package com.sxdl.hpqc.service;


import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hpqc.entity.HpQcLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HpQcLogService extends BaseUUIDServiceImpl<HpQcLog> {

}
