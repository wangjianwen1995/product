package com.sxdl.base.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import com.google.common.util.concurrent.AtomicDouble;
import com.sxdl.base.dao.dao1.SysLogDao;
import com.sxdl.base.service.ServiceDiskService;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.SysInfoUtil;
import com.sxdl.base.util.YmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 服务器和数据库磁盘服务
 *
 * @date 2021/11/05
 */
@Service("dcLogService")
@Transactional
public class ServiceDiskServiceImpl implements ServiceDiskService {

    @Value("${spring.datasource.primary.url:}")
    public String url;
    @Autowired
    private SysLogDao sysLogDao;
    @Autowired
    private YmlUtil ymlUtil;

    /**
     * 找到数据库信息
     *
     * @return {@link Map}<{@link String}, {@link List}<{@link Map}<{@link String}, {@link Object}>>> 所有数据库信息
     * @throws InterruptedException 中断异常
     */
    @Override
    public Map<String, List<Map<String, Object>>> findDbInfo() throws InterruptedException {
        Map<String, List<Map<String, Object>>> map = new HashMap<String, List<Map<String, Object>>>();
        List<Map<String, Object>> listTwo = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> listSix = new ArrayList<Map<String, Object>>();

        Map<String, Object> map2 = SysInfoUtil.MemInfo();//主机内存信息
        Map<String, Object> map5 = SysInfoUtil.setJvmInfo();//jvm信息
        listTwo.add(map2);
        listSix.add(map5);

        map.put("host", listTwo);
        map.put("jvm", listSix);

        //磁盘可用空间
        Map<String, Object> mapBig = new LinkedHashMap<String, Object>();
        List<Map<String, Object>> listSeven = new ArrayList<Map<String, Object>>();
        File[] roots = File.listRoots();
        long totalSpace = 0l, freeSpace = 0l, uesedSpace = 0l;
        for (int i = 0; i < roots.length; i++) {
            totalSpace = roots[i].getTotalSpace() / 1024 / 1024 / 1024;
            freeSpace = roots[i].getFreeSpace() / 1024 / 1024 / 1024;
            uesedSpace = totalSpace - freeSpace;
            Map<String, Object> mapSmall = new LinkedHashMap<String, Object>();
            mapSmall.put("总空间大小", totalSpace + "G");
            mapSmall.put("可用空间大小", freeSpace + "G");
            mapSmall.put("使用率", new DecimalFormat("0.00 %").format((double) uesedSpace / totalSpace));
            mapBig.put(roots[i].toString().replace("\\", ""), mapSmall);
        }
        listSeven.add(mapBig);
        map.put("disk", listSeven);
        return map;
    }

    /**
     * 清除日志
     *
     * @param dbName 数据库的名字
     */
    @Override
    public void clearUpLogs(String dbName) {
        String s = "   SELECT name FROM [" + dbName + "].dbo.sysfiles where name like '%log%' ";
        //数据库对应的日志文件名称
        List<String> bases = sysLogDao.findSingleCol(s);
        for (String dbLogName : bases) {
            StringBuilder clearStr = new StringBuilder();
            clearStr.append(" USE ").append(dbName);
            clearStr.append(" alter database " + dbName + " set recovery simple with no_wait ");
            clearStr.append(" alter database " + dbName + " set recovery simple ");
            clearStr.append(" DBCC SHRINKFILE (N'" + dbLogName + "' ,11,TRUNCATEONLY) ");
            clearStr.append(" alter database " + dbName + " set recovery full with no_wait ");
            System.out.println(clearStr);
            sysLogDao.selectSqlWithSQL(clearStr.toString());
        }
    }

    /**
     * 清除所有日志
     *///在多语句事务内不允许使用 ALTER,需要手动关闭事务,调用就近原则
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public String clearUpAllLogs() {
        List<Map<String, Object>> maps = sysLogDao.selectSqlWithSQL("execute('dbcc sqlperf(logspace)')");
        StringBuilder sb = new StringBuilder();
        sb.append("本数据库实例中共有 " + maps.size() + " 个数据库\n");
        AtomicInteger i = new AtomicInteger(0);
        AtomicDouble changeSize = new AtomicDouble(0);
        maps.forEach(e -> {
            String name = (String) e.get("Database Name");
            if ("tempdb".equals(name)) {
                return;
            }
            float size = (float) e.get("Log Size (MB)");
            float used = (float) e.get("Log Space Used (%)");
            if (size > 500 || used > 60) {
                sb.append("数据库 " + name + " 需要清理,已经占用了 " + size + " M 磁盘空间,日志文件磁盘占用率达到了 " + used + " %\n");
                i.incrementAndGet();
                clearUpLogs(name);
            }
        });
        List<Map<String, Object>> maps2 = sysLogDao.selectSqlWithSQL("execute('dbcc sqlperf(logspace)')");
        maps2.forEach(e -> {
            String name = (String) e.get("Database Name");
            float size = (float) e.get("Log Size (MB)");
            float used = (float) e.get("Log Space Used (%)");
            maps.forEach(e1 -> {
                if (e1.get("Database Name").equals(name)) {
                    double cs = (float) e1.get("Log Size (MB)") - size;
                    double cu = (float) e1.get("Log Space Used (%)") - used;
                    if (cs > 0 || cu > 0) {
                        changeSize.addAndGet(cs);
                        sb.append("数据库 " + name + " ,已经释放了 " + cs + " M 磁盘空间,日志文件磁盘使用率达到 " + used + " %,磁盘可用率增加了 " + cu + " %\n");
                    }
                }
            });
        });
        sb.append("日志文件>500M,或者日志占用率大于60%的数据库有 " + i + " 个\n");
        sb.append("本数据库实例共释放了 " + changeSize + "  M 磁盘空间");
        return sb.toString();
    }

    /**
     * 备份当前项目所使用的数据库
     */
    public void backUp() throws ParseException {
        //获取配置中的备份文件所在硬盘地址,默认是D:bf文件夹
        File file = new File(ymlUtil.getBackupPath());
        if (!file.exists()) {//如果没有则创建
            file.mkdirs();
        }
        String dbName = getDBName(url);//获取配置中的主要数据库名称
        String fullNanme = file.getPath() + File.separator + dbName + "_" + DateUtil.today(); //文件名;
        File[] files = file.listFiles();//获取文件夹中的所有文件
        //过滤出当前项目使用库,在备份文件夹中已存在的文件列表
        List<File> collect = Arrays.asList(files).stream().filter(e -> e.getName().contains(dbName) && e.getName().contains("_"))
                .collect(Collectors.toList());
        if (CollUtil.isNotEmpty(collect)) {
            Integer someDaysBefore = ymlUtil.getBackupPeriodOfValidity();//获取配置中需要保留的数据库备份的数量
            String time, name;
            Date now = new Date();
            Date daysBefore = DateUtil.offsetDay(now, -someDaysBefore);//配置的最早的日期
            Iterator<File> it = collect.iterator();//在循环中可能会删除多个文件,所以用iterator循环
            while (it.hasNext()) {
                File f = it.next();
                name = f.getName();
                time = name.replace(dbName, "").split("_")[1];
                if (time.contains("副本")) {
                    f.delete();
                    it.remove();
                    continue;
                }
                if (!DateUtil.isDate(time) && time.contains("-")) {
                    time = time.split("-")[0];
                }
                DateTime fileDay = DateUtil.parse(time);
                if (DateUtil.isSameDay(now, fileDay)) {//如果已经有当天的备份,则删除旧的
                    f.delete();
                    it.remove();
                    continue;
                }
                if (collect.size() >= someDaysBefore && fileDay.before(daysBefore)) {
                    f.delete();
                    it.remove();
                    continue;
                }
            }
        }
        //当前没有备份再去备份
        sysLogDao.selectSqlWithSQL("BACKUP DATABASE " + dbName + " TO  DISK ='" + fullNanme + "' with compression ");
        System.out.println("数据库 " + dbName + " 备份成功!");
    }

    /**
     * 得到dbname
     *
     * @param s url
     * @return {@link String}
     *///获取数据库名
    public String getDBName(String s) {
        return s.split("=")[1];
    }
}
