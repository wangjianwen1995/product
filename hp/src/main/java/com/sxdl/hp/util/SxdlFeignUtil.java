package com.sxdl.hp.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sxdl.base.util.ResultUtil;
import org.apache.poi.ss.formula.functions.T;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公司内部后台系统服务之间接口调用工具类
 * 默认接口返回值都为 ResultUtil
 *
 * @see com.sxdl.base.util.ResultUtil
 */
public class SxdlFeignUtil {
    public static Map<Integer, String> PORTS = new HashMap<>();

    static {
        PORTS.put(23300, "数据中心");
        PORTS.put(23301, "数据上报(旧)");
        PORTS.put(23302, "单病种管理");
        PORTS.put(23304, "护士护理");
        PORTS.put(23305, "智慧病案");
        PORTS.put(23306, "javahbi");
        PORTS.put(23308, "病案上报");
        PORTS.put(23310, "数据质控");
        PORTS.put(23311, "传染病上报");
        PORTS.put(23313, "不良事件");
        PORTS.put(23314, "院感上报");
    }

    /**
     * 通用的网络请求封装类,传字符串类型参数(包含json格式),最少参数的重载方法
     *
     * @param isGet 是否get方式,true: get;false: post
     * @param url   地址
     * @param data  字符串类型参数
     * @return
     */
    public static ResultUtil send(boolean isGet, String url, String data)  {
        return send(isGet, url, data, null, true);
    }

    /**
     * 通用的网络请求封装类,传Map类型参数,最少参数的重载方法
     *
     * @param isGet 是否get方式,true: get;false: post
     * @param url   地址
     * @param data  map类型参数
     * @return
     */
    public static ResultUtil send(boolean isGet, String url, Map<String, Object> data)  {
        return send(isGet, url, data, null, false);
    }

    /**
     * 通用的网络请求封装类,传字符串类型参数(包含json格式),增加等待响应时间参数
     *
     * @param isGet   是否get方式,true: get;false: post
     * @param url     地址
     * @param data    字符串类型参数
     * @param timeout 等待响应时间
     * @return
     */
    public static ResultUtil send(boolean isGet, String url, String data, Integer timeout)  {
        return send(isGet, url, data, timeout, true);
    }

    /**
     * 通用的网络请求封装类,传Map类型参数,增加等待响应时间参数
     *
     * @param isGet   是否get方式,true: get;false: post
     * @param url     地址
     * @param data    map类型参数
     * @param timeout 等待响应时间
     * @return
     */
    public static ResultUtil send(boolean isGet, String url, Map<String, Object> data, Integer timeout)  {
        return send(isGet, url, data, timeout, false);
    }

    /**
     * 发送完请求,并且解析返回值为指定对象类型
     *
     * @param isGet 是否get方式,true: get;false: post
     * @param url   地址
     * @param data  字符串类型参数
     * @param cls   自定义返回数据类型,示例: ResultUtil.class
     * @return T      对象类型
     */
    public static T sendThenParseToObject(boolean isGet, String url, String data, Class<T> cls)  {
        ResultUtil rst = send(isGet, url, data, null, true);
        return convertToObject(rst, cls);
    }

    /**
     * 发送完请求,并且解析返回值为通用对象类型,Map格式
     *
     * @param isGet 是否get方式,true: get;false: post
     * @param url   地址
     * @param data  字符串类型参数
     * @return Map    对象类型
     */
    public static Map sendThenParseToObject(boolean isGet, String url, String data)  {
        ResultUtil rst = send(isGet, url, data, null, true);
        return convertToObject(rst);
    }

    /**
     * 发送完请求,并且解析返回值为泛型对象类型,List格式
     *
     * @param isGet 是否get方式,true: get;false: post
     * @param url   地址
     * @param data  字符串类型参数
     * @param cls   自定义返回数据类型,可以null
     * @return List   列表
     */
    public static List sendThenParseToList(boolean isGet, String url, String data, Class<T> cls)  {
        ResultUtil rst = send(isGet, url, data, null, true);
        return convertToList(rst, cls);
    }

    /**
     * 通用的网络请求封装类,传Map类型参数,增加等待响应时间参数,可自定义返回数据列表类型
     *
     * @param isGet 是否get方式,true: get;false: post
     * @param url   地址
     * @param data  map类型参数
     * @param cls   自定义返回数据类型,可以null
     */
    public static T sendThenParseToObject(boolean isGet, String url, Map<String, Object> data, Class<T> cls)  {
        ResultUtil rst = send(isGet, url, data, null, false);
        return convertToObject(rst, cls);
    }

    /**
     * 通用的网络请求封装类,传Map类型参数,增加等待响应时间参数,可自定义返回数据列表类型
     *
     * @param isGet 是否get方式,true: get;false: post
     * @param url   地址
     * @param data  map类型参数
     * @param cls   自定义返回数据类型,可以null
     * @return
     */
    public static List sendThenParseToList(boolean isGet, String url, Map<String, Object> data, Class<T> cls)  {
        ResultUtil rst = send(isGet, url, data, null, false);
        return convertToList(rst, cls);
    }

    /**
     * 核心发送请求工具类
     * 先判断对方接口是否开启
     *
     * @param isGet      是否get方式,true: get;false: post
     * @param url        地址
     * @param data       数据
     * @param timeout    等待响应时间,默认20000
     * @param isStrParam 是否string类型的参数
     * @return
     */
    public static ResultUtil send(boolean isGet, String url, Object data, Integer timeout, boolean isStrParam) {
        if (StrUtil.isEmpty(url) || !url.contains("/") || !url.contains("//")) {
            return ResultUtil.error("参数错误!");
        }
        InetSocketAddress isa = parseUrl(url);
        if (!netIsOpen(isa)) {
            Integer port = isa.getPort();
            return ResultUtil.error("检测到 " + isa.getHostName() + " : " + port + "," + PORTS.get(port) + "系统不可访问,请检查!");
        }
        HttpRequest request;
        if (isGet) {
            request = HttpUtil.createGet(url);
        } else {
            request = HttpUtil.createPost(url);
        }
        if (isStrParam) {
            request.body(data.toString());
        } else {
            request.form((Map<String, Object>) data);
        }
        if (null == timeout) {
            timeout = 20000;
        }
        String body = request.timeout(timeout).execute().body();
//        System.out.println(body);
        if (JSONUtil.isJson(body)) {
            return JSONUtil.toBean(JSONUtil.parseObj(body,true), ResultUtil.class);
        } else {
            return ResultUtil.error(body);
        }
    }

    /**
     * 将结果转换成指定对象类型
     *
     * @param rst 返回的ResultUtil
     * @param cls 需要转换的类型
     */
    public static T convertToObject(ResultUtil rst, Class<T> cls) {
        if (rst.isSuc()) {
            return null;
        }
        return Convert.convert(cls, rst.getT());
    }

    /**
     * 将结果转换成通用对象类型
     */
    public static Map convertToObject(ResultUtil rst) {
        if (rst.isSuc()) {
            return null;
        }
        return Convert.convert(new TypeReference<Map>() {
        }, rst.getT());
    }

    /**
     * 将结果转换成list泛型类型
     * 如果指定了对象类型,则转成List<T>,否则转成List<Map<String, Object>>
     *
     * @param rst 返回的ResultUtil
     * @param cls 需要转换的类型,可以null
     * @return List
     */
    public static List convertToList(ResultUtil rst, Class<T> cls) {
        if (rst.isSuc()) {
            return null;
        }
        if (null != cls) {
            return Convert.convert(new TypeReference<List<T>>() {
            }, rst.getT());
        } else {
            return Convert.convert(new TypeReference<List<Map<String, Object>>>() {
            }, rst.getT());
        }
    }

    /**
     * 从url地址中解析为ip和port
     */
    public static InetSocketAddress parseUrl(String url) {
        if (StrUtil.isEmpty(url)) {
            return null;
        }
        String[] ss = url.split(":");
        String ip, port;
        if (url.startsWith("http://") || url.startsWith("https://")) {
            ip = ss[1].substring(2, ss[1].length());
            port = ss[2].split("/")[0];
        } else {
            ip = ss[0];
            port = ss[1].split("/")[0];
        }
        return new InetSocketAddress(ip, NumberUtil.parseInt(port));
    }

    /**
     * 检测网络和端口是否畅通
     */
    public static boolean netIsOpen(InetSocketAddress isa) {
        return NetUtil.isOpen(isa, 2000);
    }
    /**
     * 检测网络和端口是否畅通
     */
    public static boolean netIsOpen(String url) {
        return netIsOpen(parseUrl(url));
    }
}
