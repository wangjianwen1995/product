package com.sxdl.base.service;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ServiceDiskService {

    Map<String,List<Map<String,Object>>> findDbInfo() throws InterruptedException;

    /**
     * 清理特定数据库日志文件
     * @param dbName 如题
     */
    void clearUpLogs(String dbName);

    /**
     * 清理本实例中所有库的日志文件
     */
    String clearUpAllLogs();

    /**
     * 备份数据库功能,保存${back_time}天的备份,自动清理之前的备份,如果当天已备份过,则不重复备份
     */
    void backUp() throws ParseException;
}
