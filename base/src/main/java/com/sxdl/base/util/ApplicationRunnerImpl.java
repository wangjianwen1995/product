package com.sxdl.base.util;

import cn.hutool.json.JSONUtil;
import com.sxdl.base.dao.dao1.SysDictTableDao;
import com.sxdl.base.dao.dao1.SysDictValDao;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.verify.VerifyReturn;
import com.sxdl.base.util.verify.VerifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 当项目启动以后需要执行的方法
 * 包含全局内存安全的缓存类
 * 以及全局的注册文件校验方法
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    public static String PATH, FILESPATH, SEP = File.separator;
    //全局变量
    public volatile static Map<String, Object> contextMap = new ConcurrentHashMap<>();
    @Autowired
    public SysDictValDao sysDictValDao;
    @Autowired
    public SysDictTableDao sysDictTableDao;
    public List<SysDictTable> dcDitTableList;
    public List<SysDictVal> dcDitVals;
    @Autowired
    private ReportUtil reportUtil;
    @Autowired
    private Environment env;

    public static String getFilesPath() {
        //默认是exe包运行环境
        String classPath = System.getProperty("exe.path"), file = "files";

        if (StringUtil.isEmpty(classPath)) {
            try {
                classPath = ResourceUtils.getURL("classpath:").getPath().trim();
                if (classPath.contains(".jar!")) {//jar包运行环境
                    classPath="config"+SEP;
                } else {
                    int len = 15;//开发环境
                    if (classPath.contains("test")) {//开发的测试环境
                        len = 20;
                    }
                    classPath = classPath.substring(1, classPath.length() - len);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FILESPATH = classPath + file;
//        System.out.println(" base设置路径:"+FILESPATH);
        return FILESPATH;
    }

    public void setPATH() {
        PATH = getFilesPath() + SEP + "sysfile" + SEP + "longlicenses.lisp";
    }

    public void init() {
        //符合 国家标准的字典表类型
        dcDitTableList = sysDictTableDao.selectAll();
        //字典表数据
        dcDitVals = sysDictValDao.selectAll();
        Map<Integer, List<SysDictVal>> dvAllMap = dcDitVals.stream().filter(e -> null != e).collect(Collectors.groupingBy(e -> e.getDict_id()));
      //  Map<String, List<SysDictVal>> dictValMap = dcDitVals.stream().filter(e -> null != e && 1== e.getIs_on() ).collect(Collectors.groupingBy(e -> e.getDict_name()));
        contextMap.put("dvAllMap", dvAllMap);
        //contextMap.put("dictValMap", dictValMap);
        contextMap.put("dictValList",dcDitVals);
        contextMap.put("dcDitTableList", dcDitTableList);
        //判断hbi端口是否开启
        if (reportUtil.addrIsOpen()) {
            contextMap.put("hbitoken", reportUtil.getHbiToken());
        }
        //验证需要配置的端口
        contextMap.put("env", env);
        setPATH();
        verify( PATH);
    }

    /**
     * 验证注册文件并且存放在缓存中
     * @param PATH
     */
    public static void verify(String PATH){
    //验证系统是否注册,以及是否过期
    VerifyReturn vr = VerifyUtil.builder().verify(null, PATH);
    if (!vr.getFlag()) {
        contextMap.put("verify", false);
        System.out.println(vr.getMeg());
    } else {
        contextMap.put("verify", true);
        contextMap.put("verifyInfo", JSONUtil.parseObj(vr.getMeg()));
    }
}
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
