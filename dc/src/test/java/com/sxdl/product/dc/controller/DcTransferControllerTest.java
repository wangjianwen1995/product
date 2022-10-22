//package com.sxdl.product.dc.controller;
//
//import cn.hutool.json.JSONUtil;
//import com.sxdl.product.dc.MainTest;
//import com.sxdl.product.dc.dao.dao2.HandleDao;
//import com.sxdl.product.dc.entity.DcTransfer;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import oshi.SystemInfo;
//import oshi.hardware.CentralProcessor;
//import oshi.hardware.GlobalMemory;
//
//import java.io.File;
//import java.text.DecimalFormat;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//public class DcTransferControllerTest extends MainTest {
//
//    @Autowired
//    private HandleDao handleDao;
//
//    @Test
//    public void findAll() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/transfer/findAll")//路径
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void findByFactor() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/transfer/findByFactor")//路径
//                .param("name","")
//                .param("","")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void insertLink() throws Exception {
//        DcTransfer dcTransfer =new DcTransfer() ;
//        dcTransfer.setName("www");
//        dcTransfer.setFrom_type("SQLOLEDB");
//        dcTransfer.setFrom_uri("140.143.190.251");
//        dcTransfer.setFrom_username("sa");
//        dcTransfer.setFrom_pwd("ckboar123!@#");
//        mockMvc.perform(MockMvcRequestBuilders.post("/transfer/insert")//路径
//                .content(JSONUtil.toJsonStr(dcTransfer))
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void testLink() throws Exception {
//        DcTransfer dcTransfer =new DcTransfer() ;
//        dcTransfer.setName("aaa");
//        dcTransfer.setFrom_type("SQLOLEDB");
//        dcTransfer.setFrom_uri("140.143.190.251");
//        dcTransfer.setFrom_username("sa");
//        dcTransfer.setFrom_pwd("ckboar123!@#");
//        mockMvc.perform(MockMvcRequestBuilders.post("/transfer/findTest")//路径
//                .content(JSONUtil.toJsonStr(dcTransfer))
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void deleteLink() throws Exception {
//        DcTransfer dcTransfer =new DcTransfer() ;
//        dcTransfer.setId(4);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/transfer/delete")//路径
//                .content(JSONUtil.toJsonStr(dcTransfer))
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//    @Test
//    public void updateLink() throws Exception {
//        DcTransfer dcTransfer =new DcTransfer() ;
//        dcTransfer.setId(5);
//        dcTransfer.setJob_id(2);
//        mockMvc.perform(MockMvcRequestBuilders.put("/transfer/update")//路径
//                .content(JSONUtil.toJsonStr(dcTransfer))
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public  void test2(){
//        handleDao.findInfo("www","SQLOLEDB","140.143.190.251","sa","ckboar123!@#","1134");
//    }
//    @Test
//    public  void testDB(){
//        List<Map<String,Object>> list = handleDao.findDbInfo("DBCC SQLPERF(LOGSPACE) ");
//        for( Map<String, Object> mapList : list ) {
//            StringBuilder str = new StringBuilder();
//            String dbName = (String) mapList.get("Database Name");
//            str.append("SELECT name, convert(float,size) * (8192.0/1024.0)/1024. as size FROM [").append(dbName).append("].dbo.sysfiles");
//            List<Map<String,Object>> listTwo = handleDao.findDbInfo(str.toString());
//            for (int i =0 ; i< listTwo.size(); i++){
//                mapList.put("name"+i,listTwo.get(i).get("name"));
//                mapList.put("size"+i+"(MB)",String.valueOf(listTwo.get(i).get("size")));
//            }
//        }
//        System.out.println(list);
//    }
//    @Test
//    public  void test10(){
//        StringBuilder strTwo = new StringBuilder();
//        strTwo.append("Exec master.dbo.xp_fixeddrives");
//        Map<String,String> map6  = new LinkedHashMap<String,String>();
//        List<Map<String,Object>> listThree = handleDao.findDbInfo(strTwo.toString());
//        for(int i =0 ; i< listThree.size(); i++){
//            map6.put("driver"+i, (String) listThree.get(i).get("drive"));
//            map6.put("可用空间"+i+"(MB)",String.valueOf(listThree.get(i).get("MB 可用空间")));
//        }
//        System.out.println(map6);
//    }
//
//
//    @Test
//    public  void testSys(){
//            try {
//                List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//                Map<String,Object> map  = DcTransferControllerTest.printlnCpuInfo();
//                Map<String,Object> map2 = DcTransferControllerTest.MemInfo();
//                Map<String,Object> map3 = DcTransferControllerTest.getThread();
//                Map<String,Object> map4 = DcTransferControllerTest.setSysInfo();
//                Map<String,Object> map5 = DcTransferControllerTest.setJvmInfo();
//                list.add(map);
//                list.add(map2);
//                list.add(map3);
//                list.add(map4);
//                list.add(map5);
//                System.out.println(list);
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//    }
//
//    private static Map<String,Object> printlnCpuInfo() throws InterruptedException {
//        //System.out.println("----------------cpu信息----------------");
//        Map<String,Object> map = new LinkedHashMap<String,Object>();
//        SystemInfo systemInfo = new SystemInfo();
//        CentralProcessor processor = systemInfo.getHardware().getProcessor();
//        long[] prevTicks = processor.getSystemCpuLoadTicks();
//        // 睡眠1s
//        TimeUnit.SECONDS.sleep(1);
//        long[] ticks = processor.getSystemCpuLoadTicks();
//        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
//        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
//        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
//        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
//        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
//        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
//        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
//        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
//        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
//        System.out.println("----------------cpu信息----------------");
//        System.out.println("cpu核数:" + processor.getLogicalProcessorCount());
//        System.out.println("cpu系统使用率:" + new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));
//        System.out.println("cpu用户使用率:" + new DecimalFormat("#.##%").format(user * 1.0 / totalCpu));
//        System.out.println("cpu当前等待率:" + new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu));
//        System.out.println("cpu当前使用率:" + new DecimalFormat("#.##%").format(1.0-(idle * 1.0 / totalCpu)));
//        map.put("cpu核数",processor.getLogicalProcessorCount());
//        map.put("cpu系统使用率",new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));
//        map.put("cpu用户使用率",new DecimalFormat("#.##%").format(user * 1.0 / totalCpu));
//        map.put("cpu当前等待率",new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu));
//        map.put("cpu当前使用率",new DecimalFormat("#.##%").format(1.0-(idle * 1.0 / totalCpu)));
//        return  map;
//    }
//    public static Map<String,Object> MemInfo(){
//        System.out.println("----------------主机内存信息----------------");
//        Map<String,Object> map = new LinkedHashMap<String,Object>();
//        SystemInfo systemInfo = new SystemInfo();
//        GlobalMemory memory = systemInfo.getHardware().getMemory();
//        //总内存
//        long totalByte = memory.getTotal();
//        //剩余
//        long acaliableByte = memory.getAvailable();
//        System.out.println("总内存:" + formatByte(totalByte));
//        System.out.println("使用:" + formatByte(totalByte-acaliableByte));
//        System.out.println("剩余内存:" + formatByte(acaliableByte));
//        System.out.println("使用率:" + new DecimalFormat("#.##%").format((totalByte-acaliableByte)*1.0/totalByte));
//        map.put("总内存",formatByte(totalByte));
//        map.put("使用",formatByte(totalByte-acaliableByte));
//        map.put("剩余内存",formatByte(acaliableByte));
//        map.put("使用率",new DecimalFormat("#.##%").format((totalByte-acaliableByte)*1.0/totalByte));
//        return map;
//    }
//
//    public static Map<String,Object> setSysInfo(){
//        System.out.println("----------------操作系统信息----------------");
//        Map<String,Object> map = new LinkedHashMap<String,Object>();
//        Properties props = System.getProperties();
//        //系统名称
//        String osName = props.getProperty("os.name");
//        //架构名称
//        String osArch = props.getProperty("os.arch");
//        System.out.println("操作系统名:" + osName);
//        System.out.println("系统架构:" + osArch);
//        map.put("操作系统名",osName);
//        map.put("系统架构",osArch);
//        return map;
//    }
//
//    public static Map<String,Object> setJvmInfo(){
//        System.out.println("----------------jvm信息----------------");
//        Map<String,Object> map = new LinkedHashMap<String,Object>();
//        Properties props = System.getProperties();
//        Runtime runtime = Runtime.getRuntime();
//        //jvm总内存
//        long jvmTotalMemoryByte = runtime.totalMemory();
//        //jvm最大可申请
//        long jvmMaxMoryByte = runtime.maxMemory();
//        //空闲空间
//        long freeMemoryByte = runtime.freeMemory();
//        //jdk版本
//        String jdkVersion = props.getProperty("java.version");
//        //jdk路径
//        String jdkHome = props.getProperty("java.home");
//        System.out.println("jvm内存总量:" + formatByte(jvmTotalMemoryByte));
//        System.out.println("jvm已使用内存:" + formatByte(jvmTotalMemoryByte-freeMemoryByte));
//        System.out.println("jvm剩余内存:" + formatByte(freeMemoryByte));
//        System.out.println("jvm内存使用率:" + new DecimalFormat("#.##%").format((jvmTotalMemoryByte-freeMemoryByte)*1.0/jvmTotalMemoryByte));
//        System.out.println("java版本:" + jdkVersion);
//        //System.out.println("jdkHome = " + jdkHome);
//        map.put("jvm内存总量",formatByte(jvmTotalMemoryByte));
//        map.put("jvm已使用内存",formatByte(jvmTotalMemoryByte-freeMemoryByte));
//        map.put("jvm剩余内存",formatByte(freeMemoryByte));
//        map.put("jvm内存使用率",new DecimalFormat("#.##%").format((jvmTotalMemoryByte-freeMemoryByte)*1.0/jvmTotalMemoryByte));
//        map.put("java版本",jdkVersion);
//        return map;
//    }
//
//    public static Map<String,Object> getThread(){
//        System.out.println("----------------线程信息----------------");
//        Map<String,Object> map = new LinkedHashMap<String,Object>();
//        ThreadGroup currentGroup =Thread.currentThread().getThreadGroup();
//
//        while (currentGroup.getParent()!=null){
//            // 返回此线程组的父线程组
//            currentGroup=currentGroup.getParent();
//        }
//        //此线程组中活动线程的估计数
//        int noThreads = currentGroup.activeCount();
//
//        Thread[] lstThreads = new Thread[noThreads];
//        //把对此线程组中的所有活动子组的引用复制到指定数组中。
//        currentGroup.enumerate(lstThreads);
//        for (Thread thread : lstThreads) {
//            System.out.println("线程数量："+noThreads+" 线程id：" + thread.getId() + " 线程名称：" + thread.getName() + " 线程状态：" + thread.getState());
//        }
//        map.put("线程数量",noThreads);
//        return map;
//    }
//
//    public static String formatByte(long byteNumber){
//        //换算单位
//        double FORMAT = 1024.0;
//        double kbNumber = byteNumber/FORMAT;
//        if(kbNumber<FORMAT){
//            return new DecimalFormat("#.##KB").format(kbNumber);
//        }
//        double mbNumber = kbNumber/FORMAT;
//        if(mbNumber<FORMAT){
//            return new DecimalFormat("#.##MB").format(mbNumber);
//        }
//        double gbNumber = mbNumber/FORMAT;
//        if(gbNumber<FORMAT){
//            return new DecimalFormat("#.##GB").format(gbNumber);
//        }
//        double tbNumber = gbNumber/FORMAT;
//        return new DecimalFormat("#.##TB").format(tbNumber);
//    }
//
//    @Test
//    public void findBydb() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/log/findDbInfo")//路径
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect ( OK )//状态码200
//                .andDo ( print () );//结束后打印所有数据
//    }
//
//    @Test
//    public void test9() throws Exception{
//        File[] roots = File.listRoots();
//        for (int i = 0; i < roots.length; i++) {
//            System.out.println(roots[i]);
//            System.out.println(roots[i].getTotalSpace()/ 1024 / 1024 / 1024 + "G");
//            System.out.println(roots[i].getFreeSpace()/ 1024 / 1024 / 1024 + "G");
//        }
//
//
//
//        /*StringBuilder strTwo = new StringBuilder();
//        strTwo.append("Exec master.dbo.xp_fixeddrives");
//        List<Map<String,Object>> listThree = handleDao.findDbInfo(strTwo.toString());
//        for(Map<String,Object> map : listThree){
//            Object value = map.get("drive");
//            File file = new File((String) value+":");
//            long totalSpace = file.getTotalSpace();
//            long freeSpace = file.getFreeSpace();
//            long usedSpace = totalSpace - freeSpace;
//            System.out.println(value);
//            System.out.println("总空间大小:" + totalSpace / 1024 / 1024 / 1024 + "G");
//            System.out.println("已用空间大小:" + usedSpace / 1024 / 1024 / 1024 + "G");
//        }*/
//    }
//
//}
