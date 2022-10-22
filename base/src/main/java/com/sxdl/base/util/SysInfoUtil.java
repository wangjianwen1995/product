package com.sxdl.base.util;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 系统运行信息工具类
 */
public class SysInfoUtil {

    public static Map<String,Object> printlnCpuInfo() throws InterruptedException {
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        SystemInfo systemInfo = new SystemInfo();
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        map.put("cpu核数",processor.getLogicalProcessorCount()+"");
        map.put("cpu系统使用率",new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));
        map.put("cpu用户使用率",new DecimalFormat("#.##%").format(user * 1.0 / totalCpu));
        map.put("cpu当前等待率",new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu));
        map.put("cpu当前使用率",new DecimalFormat("#.##%").format(1.0-(idle * 1.0 / totalCpu)));
        return  map;
    }

    /**
     * 服务器内存信息
     */
    public static Map<String,Object> MemInfo(){
        /*System.out.println("----------------主机内存信息----------------");*/
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        SystemInfo systemInfo = new SystemInfo();
        GlobalMemory memory = systemInfo.getHardware().getMemory();
        //总内存
        long totalByte = memory.getTotal();
        //剩余
        long acaliableByte = memory.getAvailable();
        map.put("总内存",formatByte(totalByte));
        map.put("使用",formatByte(totalByte-acaliableByte));
        map.put("剩余内存",formatByte(acaliableByte));
        map.put("使用率",new DecimalFormat("#.##%").format((totalByte-acaliableByte)*1.0/totalByte));
        return map;
    }

    public static Map<String,Object> setSysInfo(){
        /*System.out.println("----------------操作系统信息----------------");*/
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        Properties props = System.getProperties();
        //系统名称
        String osName = props.getProperty("os.name");
        //架构名称
        String osArch = props.getProperty("os.arch");
        map.put("操作系统名",osName);
        map.put("系统架构",osArch);
        return map;
    }

    /**
     * 服务器JVM信息
     */
    public static Map<String,Object> setJvmInfo(){
        /*System.out.println("----------------jvm信息----------------");*/
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        Properties props = System.getProperties();
        Runtime runtime = Runtime.getRuntime();
        //jvm总内存
        long jvmTotalMemoryByte = runtime.totalMemory();
        //jvm最大可申请
        long jvmMaxMoryByte = runtime.maxMemory();
        //空闲空间
        long freeMemoryByte = runtime.freeMemory();
        //jdk版本
        String jdkVersion = props.getProperty("java.version");
        //jdk路径
        String jdkHome = props.getProperty("java.home");
        map.put("jvm内存总量",formatByte(jvmTotalMemoryByte));
        map.put("jvm已使用内存",formatByte(jvmTotalMemoryByte-freeMemoryByte));
        map.put("jvm剩余内存",formatByte(freeMemoryByte));
        map.put("jvm内存使用率",new DecimalFormat("#.##%").format((jvmTotalMemoryByte-freeMemoryByte)*1.0/jvmTotalMemoryByte));
        map.put("java版本",jdkVersion);
        return map;
    }

    /**
     * 服务器线程信息
     */
    public static Map<String,Object> getThread(){
        /*System.out.println("----------------线程信息----------------");*/
        Map<String,Object> map = new LinkedHashMap<String,Object>();
        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();

        while (currentGroup.getParent()!=null){
            // 返回此线程组的父线程组
            currentGroup=currentGroup.getParent();
        }
        //此线程组中活动线程的估计数
        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];
        //把对此线程组中的所有活动子组的引用复制到指定数组中。
        /*currentGroup.enumerate(lstThreads);
        for (Thread thread : lstThreads) {
            System.out.println("线程数量："+noThreads+" 线程id：" + thread.getId() + " 线程名称：" + thread.getName() + " 线程状态：" + thread.getState());
        }*/
        map.put("线程数量",noThreads);
        return map;
    }

    /**
     * 硬盘或内存占用单位转换
     * @param byteNumber  如题

     */
    public static String formatByte(long byteNumber){
        //换算单位
        double FORMAT = 1024.0;
        double kbNumber = byteNumber/FORMAT;
        if(kbNumber<FORMAT){
            return new DecimalFormat("#.##KB").format(kbNumber);
        }
        double mbNumber = kbNumber/FORMAT;
        if(mbNumber<FORMAT){
            return new DecimalFormat("#.##MB").format(mbNumber);
        }
        double gbNumber = mbNumber/FORMAT;
        if(gbNumber<FORMAT){
            return new DecimalFormat("#.##GB").format(gbNumber);
        }
        double tbNumber = gbNumber/FORMAT;
        return new DecimalFormat("#.##TB").format(tbNumber);
    }
}
