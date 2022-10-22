package com.sxdl.base.util.verify;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.json.JSONObject;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.HardwareInfo;
import com.sxdl.base.util.StringUtil;
import org.springframework.core.env.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 注册文件校验工具类
 */
public class VerifyUtil {
    //统一公钥,禁止修改
    private static final String pb1 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwHt7fEjA3EDLXndzqLiZTpzL89wPIGyERG+cfTUAugSyBQ/6qn8EVcnrxKfMdN17KEcRYPijpGzGonHNF3TbvUJ7pkoIADu0CFBdlDoQiv3g30ycoPXnl50XYDtW5xKIqN380/abm7gQ6gPpPo7e06hCKVIYzZUNRDekXuGMxzWsH2RdNF9+ftRBxiyzLDVx5mVxA4VmV6xeRJmM7IgIXoJjEbqBLEUmhhCtFW96UhQU9m8+XS16AOcMEeH9SRrbrYW817N5oY0eYiGaztIwHVF31dMc+zGmOCONDrzOd8BChAAayd7ySxUFVF9pH8nHoWIHNLWfcWEH98zSY7hlHwIDAQAB";
    private static final VerifyUtil verifyUtil = new VerifyUtil();
    public static RSA rsa = new RSA(null, pb1);
    private List<String> strings;
    private File serverFile;
    private Environment env;
    public static String msg="请联系管理员重新注册!";
    private static final String HI=HardwareInfo.getHardWare();

    /**
     * 最简单的建造者模式的实现
     * @return
     */
    public static VerifyUtil builder() {
        return verifyUtil;
    }

    /**
     * 生成本地的密文
     */
    public static String generatVerify() {
        return Base64.encode(rsa.encrypt(StringUtil.bytes(HardwareInfo.getHardWare(), CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey));
    }

    public static void main(String[] args) {
        System.out.println(generatVerify());
    }
    /**
     * 验证通用的注册项
     * @param cipher 如题
     * @return VerifyReturn
     */
    public VerifyReturn verify(String cipher,String path) {
        boolean flag = false;
        //如果传入的值空,去服务器本地读取密文
        if (StringUtil.isEmpty(cipher)) {
            serverFile = new File(path);
            if(!serverFile.exists()){
                return new VerifyReturn(flag,msg );
            }
            strings = new ArrayList<>();
            try {
                strings = FileUtil.readLines(serverFile, CharsetUtil.UTF_8);
            } catch (Exception e) {
                return new VerifyReturn(flag, msg);
            }
            cipher = strings.get(0);
        }
        //根据传入的值去验证密文
        JSONObject j;
        try {
            j = new JSONObject(new String(rsa.decrypt(Base64.decode(cipher.replace("\n", "")), KeyType.PublicKey)));
        } catch (Exception e) {
            return new VerifyReturn(flag, msg);
        }
        env = (Environment) ApplicationRunnerImpl.contextMap.get("env");
        if (!env.getProperty("server.port").equals(j.get("port"))) return new VerifyReturn(flag, msg);
        j.remove("port");//是否本端口的系统
        if (!HI.equals(j.get("hi"))) return new VerifyReturn(flag, msg);
        j.remove("hi");//是否本硬件的环境
        if (null == j.get("scopeType")) return new VerifyReturn(flag, msg);
        String st = j.get("scopeType").toString();//注册类型
        if (st.equals("1")) {//固定天数
            if (null == j.get("scope")) return new VerifyReturn(flag, msg);
            long scope = 0;
            try {
                scope = Long.parseLong(j.get("scope").toString());
            } catch (Exception e) {
                return new VerifyReturn(flag, msg);
            }
            Date now = new Date();
            long last = (scope - now.getTime()) / 24 / 60 / 60 / 1000;
            if (last < 0) return new VerifyReturn(flag, msg+"已经过期");
            else {
                j.putOpt("scope", last);
                return new VerifyReturn(true, j.toString());
            }
        } else if (st.equals("2")) {//永久
            return new VerifyReturn(true, j.toString());
        } else {
            return new VerifyReturn(flag, msg);
        }
    }
}

