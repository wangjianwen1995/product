package com.sxdl.drplus.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.drplus.dao1.SysScheduleTaskDao;
import com.sxdl.drplus.entity.SysScheduleTaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional
@RequiredArgsConstructor
public class SysScheduleTaskService extends BaseUUIDServiceImpl<SysScheduleTaskEntity> {

    private final SysScheduleTaskDao taskDao;

    public List<ConcurrentHashMap<String,Object>> getListConcurrentHashMap(String sql){
        return taskDao.getListConcurrentHashMap(sql);
    }

}
