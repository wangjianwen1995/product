package com.sxdl.product.dc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.comparator.PropertyComparator;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.product.dc.dao.dao1.DcColumnDao;
import com.sxdl.product.dc.dao.dao1.HpDictMapDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.HospiatlInfo;
import com.sxdl.product.dc.entity.HpDictMap;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import com.sxdl.product.dc.util.ZipUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpDictMapService extends BaseServiceImpl<HpDictMap> {

    /**
     * 处理his到病案中的数据字典转换
     *
     * @param map
     * @param hiscode
     * @return
     */
    List<HpDictMap> hpDictMaps;
    Map<String, List<HpDictMap>> collect;
    @Autowired
    HandleDao handleDao;
    @Autowired
    YmlUtil ymlUtil;
    @Autowired
    DcColumnDao columnDao;
    HospiatlInfo hi;
    @Autowired
    private HpDictMapDao dictMapDao;

    public List<HpDictMap> findDataByHisCodeAndColId(String his_code,String his_name,  String col_id) throws Exception {
        return dictMapDao.findDataByHisCodeAndColId(his_code, his_name ,col_id);
    }

    //TODO 其实这里可以考虑一下需不需要添加一个入参 表名称,防止不同表中的字段一样 那就尴了个尬了
    public Map<String, Object> operationMappingDictData(Map<String, Object> map, String hiscode) throws Exception {
        //1 查询出所有 hisiseanble 启用的字典转换数据
        hpDictMaps = dictMapDao.findDataByHisEnableAndHisCodeData(hiscode);
        //根据hp字段名称分组
        collect = hpDictMaps.stream().collect(Collectors.groupingBy(e -> e.getHp_column_name().toUpperCase()));
        Map<String, String> mapkeys = new HashMap<>();//转换成全大写的key映射
        for (String k : map.keySet()) {
            mapkeys.put(k.toUpperCase(), k);//放入大写的key和实际的key的映射
        }
        String shijikey;//实际的key
        for (String k : collect.keySet()) {
            if (!mapkeys.containsKey(k.toUpperCase())) {
                continue;
            }
            shijikey = mapkeys.get(k.toUpperCase());
            if (null == map.get(shijikey)) {
                map.put(shijikey, "");//设置默认值为空字符串
            }
            //遍历该key分组里的列表
            for (HpDictMap e : collect.get(k)) {
                if (null != e.getHis_key()) {
                    if (e.getHis_key().equals(map.get(shijikey).toString().trim())) {
                        map.put(shijikey, e.getHp_key());
                        break;
                    }
                }
            }
        }
        return map;
    }

    public Map<String, Object> operationMappingDictDataAtoa(Map<String, Object> map, String hiscode) throws Exception {
        //1 查询出所有 hisiseanble 启用的字典转换数据
        List<HpDictMap> hpDictMaps = dictMapDao.findDataByHisEnableAndHisCodeData(hiscode);
        Map<String, List<HpDictMap>> collect = hpDictMaps.stream().collect(Collectors.groupingBy(e -> e.getHp_column_name()));
        /*
        缓存中获取数据
        * List<SysDictTable>  dcDitTableList2 = (List<SysDictTable>) HpApplicationRunnerImpl.contextMap.get("dcDitTableList");
        * */
        collect.forEach((key, val) -> {
            val.forEach(e -> {
                if (StringUtil.isNotEmpty(e.getHis_key())) {
                    if (e.getHis_key().equals(map.get(StrUtil.lowerFirst(key)))) {
                        map.put(key, e.getHp_key());
                    }
                }

            });
        });
        return map;
    }

    public Integer save(DcColumn hpColumn) throws Exception {
        //先根据his_code 和 col_id 删除对映的数据,然后一次性的保存
        Integer del = dictMapDao.deleteByHisCodeAndColId(hpColumn.getHis_code(), hpColumn.getId());
        List<HpDictMap> hpDictMaps = hpColumn.getHpDictMaps();
        for (HpDictMap hpDictMap : hpDictMaps) {
            hpDictMap.setDict_talbe_id(hpColumn.getDict_id());
            hpDictMap.setHp_column_name(hpColumn.getColumn_name());
            dictMapDao.insert(hpDictMap);
        }
        return del;
    }

    /**
     * 导出his对照数据
     *
     * @param hisCode  his厂商code
     * @param type     类型:1 sql;2 json
     * @param response 响应
     */
    public void exportData(String hisCode, String type, HttpServletResponse response) throws Exception {
        List<HpDictMap> datas = dictMapDao.findDataByHisCode(hisCode);
        response.setCharacterEncoding(CharsetUtil.UTF_8);
        response.setContentType("text/plain");
        if (CollUtil.isEmpty(datas)) {
            response.setStatus(403);
            response.getWriter().println("没有查询到数据!请检查后再导出!");
            return;
        }
        hi = (HospiatlInfo) DcApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        String title = hi.getJgmc() + hi.getHis_name();
        StringBuilder sb = new StringBuilder();
        if ("1".equals(type)) {//导出sql
            sb.append("truncate table hp_dict_map\n");
            sb = getDMLInsert(datas, sb);
            title += ".sql";
        } else if ("2".equals(type)) {//导出json
            JSON parse = JSONUtil.parse(datas);
            sb.append(ZipUtils.gzipCompress(parse.toJSONString(0)));
            title += ".json";
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(title, "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(sb.toString().getBytes());
        outputStream.close();

    }

    /**
     * 生成insert语句
     *
     * @param datas 数据
     * @param sb    文本
     * @return
     */
    StringBuilder getDMLInsert(List<HpDictMap> datas, StringBuilder sb) throws Exception {
        for (HpDictMap map : datas) {
            sb.append("INSERT INTO [hp_dict_map]([id], [his_code], [his_name], [hp_table_name], [hp_column_name], [hp_key], [hp_val], [his_key], [his_val], [hp_table_id], [hp_column_id], [dict_talbe_id], [hp_val_id]) VALUES (").append("'").append(map.getId()).append("',").append("'").append(map.getHis_code()).append("',").append("'").append(map.getHis_name()).append("',").append("'").append(map.getHp_table_name()).append("',").append("'").append(map.getHp_column_name()).append("',").append("'").append(map.getHp_key()).append("',").append("'").append(map.getHp_val()).append("',").append("'").append(map.getHis_key()).append("',").append("'").append(map.getHis_val()).append("',").append("'").append(map.getHp_table_id()).append("',").append("'").append(map.getHp_column_id()).append("',").append(map.getDict_talbe_id()).append(",").append(map.getHp_val_id()).append(");\n");
        }
        return sb;
    }

    /**
     * 导入数据,并且和目前库中的数据对比,将新增的数据保存
     *
     * @param file 上传的文件
     */
    public ResultUtil importData(MultipartFile file) throws Exception {
        String read = IoUtil.read(file.getInputStream(), CharsetUtil.UTF_8);
//        System.out.println(read);
        JSONArray ja = JSONUtil.parseArray(ZipUtils.gzipUnCompress(read));
//        System.out.println(ja);
        //导入的数据
        List<HpDictMap> maps = new ArrayList<>();
        for (Object j : ja) {
            maps.add(JSONUtil.toBean(j.toString(), HpDictMap.class, true));
        }
//        System.out.println(maps);
        //目前库中的数据
        List<HpDictMap> datas = dictMapDao.findDataByHisCode(maps.get(0).getHis_code());
        //对比后新增的数据
        List<HpDictMap> extras = CollUtil.subtractToList(maps, datas);
        if (CollUtil.isEmpty(extras)) {
            return ResultUtil.success("没有检测到新增的字典对照数据!");
        }
        for (HpDictMap dm : extras) {
            insert(dm);
        }
        return ResultUtil.success("解析成功!" + extras.get(0).getHis_name() + " 厂商的字典对照数据,新增了 " + extras.size() + " 条!");
    }


    /**
     * 自动对照接口表中的历史数据
     *
     * @param name    字段名称
     * @param hisCode
     * @return
     */
    public ResultUtil autoMap(String name, String hisCode) throws Exception {
        if (StrUtil.isEmpty(name)) {
            return ResultUtil.error("参数不能为空");
        }
        name = name.toLowerCase();
        String tname = "VsCh_PatientInfo", instanceName, result = getMatchedTnC(name, tname);
        if (null == result) {
            return ResultUtil.error("当前类型字段不能自动对照");
        } else {
            String[] tnc = result.split(",");
            instanceName = tnc[0];
            tname = tnc[1];
        }
        ResultUtil error = preCheck(instanceName, tname);
        if (error != null) return error;
        List<String> instanceDatasStrs = handleDao.findInstanceData(tname, instanceName);//查接口表中该字段distinct的数据
        if (CollUtil.isEmpty(instanceDatasStrs)) {
            return ResultUtil.error("当前字段在接口表中没有历史数据!");
        }
        List<HpDictMap> nowDatas = dictMapDao.findDataByHisCodeAndColName(hisCode, name);//查目前库中对照过的所有字典对照数据
        Set<String> nowKeyS = new HashSet<>();//应该包括目前对照过的数据,和现有字典
        HpDictMap dm = null, nowDictMap = null;
        if (CollUtil.isNotEmpty(nowDatas)) {
            //装填目前对照过的数据
            nowKeyS = nowDatas.stream().collect(Collectors.groupingBy(e -> e.getHis_key().toLowerCase())).keySet();//提取出目前对照过的hiskey列表
            nowDictMap = nowDatas.get(0);//获取对照数据其他信息,方便后续使用
        }
        Map<Integer, List<SysDictVal>> dicts = (Map<Integer, List<SysDictVal>>) DcApplicationRunnerImpl.contextMap.get("baMap");
        List<DcColumn> mappingColumn = columnDao.findMappingColumn(name);
        Set<String> dictKeyStrs = new HashSet<>(), dictNameStrs = new HashSet<>();//目前库中字段对应的字典的key列表和name列表
        Map<String, List<SysDictVal>> dictNames = new HashMap<>();
        DcColumn column = new DcColumn();//系统中配置的字段对象
        if (CollUtil.isNotEmpty(mappingColumn)) {
            column = mappingColumn.get(0);//如果结果不空应该只有一条
            Integer dictTid = column.getDict_id();
            if (dicts.containsKey(dictTid)) {
                List<SysDictVal> dictVals = dicts.get(dictTid);
                dictKeyStrs = dictVals.stream().collect(Collectors.groupingBy(e -> e.getVal().toLowerCase())).keySet();
                dictNames = dictVals.stream().filter(e->StrUtil.isNotEmpty(e.getName())&&e.getName().contains("_")).collect(Collectors.groupingBy(e -> e.getName().split("-")[1].trim().toLowerCase()));
                dictNameStrs = dictNames.keySet();
            }
        }
        List<HpDictMap> instanceDatas = new ArrayList<>();//新增的内容,期望能匹配相关的
        SysDictVal dv = null;
        for (String s : instanceDatasStrs) {
            if (StrUtil.isEmpty(s)) {//单独判断空值
                if (nowKeyS.contains("")) {//已经配置过空值,继续下个循环
                    continue;
                }
                dm = new HpDictMap();
                dm.setHis_code(hisCode);
                dm.setHis_key("");
                dm.setHis_val("空值");
                instanceDatas.add(dm);
            } else if (!nowKeyS.contains(s.toLowerCase())//目前库中没有匹配的历史对照数据则添加到新增
                    && !dictKeyStrs.contains(s.toLowerCase())) {//目前库中没有匹配的字典数据则添加到新增,应该是在抽取过程中转成了相应的字典值
                dm = new HpDictMap();
                dm.setHis_code(hisCode);
                //筛选出需要新增的
                dm.setHis_key(s);
                dm.setHis_val(s);
                if (dictNameStrs.contains(s)) {//在字典的name列表中直接包含了目前接口中的当前字段的这个值,
                    //这时候dv,一定有值
                    dv = dictNames.get(s).get(0);
                    dm = extractedDictmap(dm, column, dv);
                } else if (dictKeyStrs.stream().anyMatch(e -> s.contains(e))) {//在字典的name列表中间接包含了目前接口中的当前字段的这个值
                    dv = dictNames.get(dictKeyStrs.stream().filter(e -> s.contains(e)).findFirst().get()).get(0);
                    dm = extractedDictmap(dm, column, dv);
                } else if (dictKeyStrs.stream().anyMatch(e -> StringUtil.simPro(s, e) > 0.2)) {//在字典的name列表中间接包含了目前接口中的当前字段的这个值
                    dv = dictNames.get(dictKeyStrs.stream().filter(e -> StringUtil.simPro(s, e) > 0.2).findFirst().get()).get(0);
                    dm = extractedDictmap(dm, column, dv);
                } else if (null != nowDictMap) {
                    dm.setDict_talbe_id(nowDictMap.getDict_talbe_id());
                    dm.setHp_table_id(nowDictMap.getHp_table_id());
                    dm.setHp_table_name(nowDictMap.getHp_table_name());
                    dm.setHp_column_id(nowDictMap.getHp_column_id());
                    dm.setHp_column_name(nowDictMap.getHp_column_name());
                }
                instanceDatas.add(dm);
            }
        }
        nowDatas.addAll(instanceDatas);//将新增全部添加
        //将id空的新增的排在最前头
        nowDatas = ListUtil.sort(nowDatas, new PropertyComparator("id", false));
        return ResultUtil.success(nowDatas, "对照成功!新增了 " + instanceDatas.size() + " 条需要对照的字典数据!");
    }

    HpDictMap extractedDictmap(HpDictMap dm, DcColumn column, SysDictVal dv) throws Exception {
        dm.setDict_talbe_id(column.getDict_id());
        dm.setHp_table_id(column.getTable_id());
        dm.setHp_table_name(column.getTable_name());
        dm.setHp_column_id(column.getId());
        dm.setHp_column_name(column.getColumn_name());
        dm.setHp_key(dv.getVal());
        dm.setHp_val(dv.getName());
        return dm;
    }

    /**
     * 前置检查,检查有没有表,有没有字段
     *
     * @param name
     * @param tname
     * @return
     */
    private ResultUtil preCheck(String name, String tname) throws Exception {
        //检查库中是否有表
        List<Map<String, Object>> maps = handleDao.selectSqlWithSQL(SQLPackageUtil.generateIfExists(tname, " table "));
        if (CollUtil.isEmpty(maps)) {
            return ResultUtil.error("当前环境中dc没有接口表,请检查相关配置!");
        }
        String columns = handleDao.getColumnsFromOneTable(tname);//查询表的字段列表
        if (StrUtil.isEmpty(columns)) {
            return ResultUtil.error("当前环境中数据库,请检查相关配置!");
        }
        String finalName = name;
        List<String> collect = Arrays.stream(columns.split(",")).filter(e -> e.toLowerCase().equals(finalName)).collect(Collectors.toList());
        if (CollUtil.isEmpty(collect)) {//目前库表中是否有该字段
            return ResultUtil.error("当前接口表中没有该字段:" + name + ",请检查相关配置!");
        }
        return null;
    }

    /**
     * 获取匹配的表名,字段名
     *
     * @param name
     * @param tname
     * @return
     */
    String getMatchedTnC(String name, String tname) throws Exception {
        if (name.startsWith("ch0a")) {
            name = name.replace("ch0a", "ch0m");
        } else if (name.startsWith("ch0c")) {
            tname = "VsCH_CH0C";
        } else if (name.startsWith("ch0e")) {
            tname = "VsCH_CH0E";
        } else if (name.startsWith("ch0f")) {
            tname = "VsCH_CH0F";
        } else if (name.startsWith("ch0h")) {
            tname = "VsCH_CH0H";
        } else if (name.startsWith("ch0k")) {
            tname = "VsCH_CH0K";
        } else if (name.startsWith("ch0p")) {
            tname = "VSCH_CH0P";
        } else if (name.startsWith("ch0s")) {
            tname = "VsCh_WT47_CFNew";
        } else if (name.startsWith("ch0s")) {
            tname = "VSCH_CH0S";
        } else {
            return null;
        }
        return name + "," + tname;
    }
}
