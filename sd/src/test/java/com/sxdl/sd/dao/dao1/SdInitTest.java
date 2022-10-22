package com.sxdl.sd.dao.dao1;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sxdl.sd.SdMainTest;
import com.sxdl.sd.dao.dao2.HandleDao;
import com.sxdl.sd.entity.SdInfoColumn;
import com.sxdl.sd.entity.SdInfoColumnKeyVals;
import com.sxdl.sd.util.init.Init;
import com.sxdl.sd.util.init.InitJson;
import com.sxdl.sd.util.init.SdInfoInit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.sxdl.sd.util.MatchBmAndMc.matchBmAndMc;

public class SdInitTest extends SdMainTest {

//    @Autowired
//    SysDeptDao sysDeptDao;
//
//    @Autowired
//    SdZzzDao sdZzzDao;

    @Autowired
    SdInfoDao sdInfoDao;

    @Autowired
    SdInfoColumnDao sdInfoColumnDao;
    @Autowired
    SdInfoColumnKeyValsDao sdInfoColumnKeyValsDao;
    @Autowired
    HandleDao handleDao;
    @Autowired
    SdInfoColumnOldBakDao sdInfoColumnOldBakDao;

    @Test
    public void testInitJson() throws Exception {
        InitJson ij = new InitJson();
        //0fdd07a6-2f5a-436f-8037-8a08af241c04
        //40360d5e-323e-4f1c-ac12-83785e1e7abd   0fdd07a6-2f5a-436f-8037-8a08af241c04
        ij.spider("ff4074bd-4f56-4927-a3d8-2f562669f8fb");
    }


    //备份数据库
    @Test
    public void back_db() throws Exception {
        String truncate_sql = "IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sd_info_column_old_bak]') AND type in (N'U'))\n" +
                "DROP TABLE [dbo].[sd_info_column_old_bak]";
        handleDao.excuteSqlWithSQL(truncate_sql);
        String sql = "select * into sd_info_column_old_bak from sd_info_column where 1=1";
        handleDao.excuteSqlWithSQL(sql);
    }
    @Test
    public void whenQuerySucc() throws Exception {
        String truncate_sql = "truncate table sd_info_column  truncate table sd_info_column_key_vals ";
        handleDao.excuteSqlWithSQL(truncate_sql);
        Map<String, List<SdInfoInit>> map = Init.createFiles();
        map.forEach((k, v) -> {
            String[] ss = k.split(",");
            Integer g = Integer.valueOf(ss[1]);
            String gn = ss[0].split("、")[1];
            v.stream().filter(e -> e.getEts() != null).forEach(e -> {
                e.getEts().forEach((k2, v2) -> {
                    SdInfoColumn sc = new SdInfoColumn();
                    com.sxdl.sd.util.init.et e2 = (com.sxdl.sd.util.init.et) v2;
                    sc.setName(e2.getName().replaceAll("-", "_"));
                    sc.setSd_info_id(e.getId());
                    List<SdInfoColumn> columns = sdInfoColumnDao.select(sc);
                    if (columns.size() == 0) {
                        sc.setName_zh(e2.getTitle());
                        sc.setType(e2.getType());
                        JSONArray ja = JSONUtil.parseArray(e2.getVals());
                        sdInfoColumnDao.insert(sc);
                        System.out.println(sc);
                        for (Object o : ja) {
                            JSONObject jo = (JSONObject) o;
                            SdInfoColumnKeyVals sckv = new SdInfoColumnKeyVals();
//                                String keybm = "", keymc = "";
                            sckv.setSd_info_column_id(sc.getId());
                            sckv.setSd_info_id(sc.getSd_info_id());
                            sckv.setSd_info_column_name(sc.getName());
                            sckv.setVal(jo.getStr("val"));
                            if (sdInfoColumnKeyValsDao.select(sckv).size() == 0) {
                                sckv.setKeyall(jo.getStr("remark"));
                                try {
                                    Thread.sleep(10);
                                    sdInfoColumnKeyValsDao.insert(sckv);
                                    System.out.println(sckv);
                                } catch (InterruptedException interruptedException) {
                                    interruptedException.printStackTrace();
                                }
                            }
                        }
                    }
                });
            });
        });
    }

    //对比数据库字段
    @Test
    public void check_db() throws Exception {
        List<SdInfoColumn> sdInfoColumns = sdInfoColumnDao.selectSome();
        //List<String> list = new ArrayList<>();
        sdInfoColumns.forEach(e -> {
            String s="if not  exists(select * from syscolumns \n" +
                    "where id=object_id('sd_info_"+e.getSd_info_name()+"') and name='"+e.getName()+"') \n" +
                    "begin\n" +
                    "alter table sd_info_" + e.getSd_info_name() + " add " + e.getName() + " varchar(30) \r\n" +
                    "end";
           /* String sql = "alter table sd_info_" + e.getSd_info_name() + " add " + e.getName() + " varchar(30) \r\n" ;
            list.add(sql);*/
            System.out.println(s);
            handleDao.excuteSqlWithSQL(s);

            try {
                BufferedWriter bufferedWriter =new BufferedWriter((new FileWriter("G:/单病种更新sql.txt")));
                bufferedWriter.write(s);
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });
       // System.out.println(list);
    }



    //    @Disabled
    @Test
    public void ttt() {
//        String s = "%7C%u547C%u5438%u673A%7C";
//        System.out.println(EscapeUtil.unescape(s));
//        System.out.println(111);
//        String s = "C06x", ss = "C35x", is = "";
//        for (int i = 1; i < 41; i++) {
//            if (i < 11) {
//                is = "0" + i;
//            } else {
//                is = i + "";
//            }
//            System.out.print(s + is + "C nvarchar(255) NULL," + ss + is + "C nvarchar(255) NULL,");
//        }
//
//        String s = "J44.001x003爱好较广你";
//        int i = StringUtil.lastNumberOfStr(s);
//        System.out.println(s.charAt(i));
//        System.out.println(s.substring(0, i + 1) + " @ " + s.substring(i + 1));
        List<Map> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("id", i + " id@ " + i);
            map.put("name", i + " name@ " + i);
            map.put("val", i + " val@ " + i);
            list.add(map);
        }
//        Map<Object, List<Map>> name = list.stream().collect(Collectors.groupingBy(e -> e.get("name")));
//        name.forEach((k, v) -> {
//            System.out.println(k + "    " + v);
//        });
       /* List<String> names = (List<String>) list.stream().map(e -> e.get("name")).collect(Collectors.toList());
        List<Object> vals = list.stream().map(e -> e.get("val")).collect(Collectors.toList());
        list.forEach(e->{
           *//* e.put("menzhenmax", Collections.max(names));
            e.put("menzhenmin", );
            e.put("menzhenavg", );
            e.put("menzhenlen", );*//*
        });*/
        // names.forEach(System.out::println);
        //vals.forEach(System.out::println);
    }

    @Test
    public void t() {
        //I21.004	急性广泛前壁心肌梗死              疾病
        //59.9901	输尿管支架置换术            手术
        //sdinfoid sdinfocolumn.name
        //CM_0_1_3_1 CM_0_1_3_2 CM_0_1_4_1 CM_0_1_4_2
        //   4          6           4           6
        String goal = "I21.004 急性广泛前壁心肌梗死";
        String jbm = "I21.004", jmc = "急性广泛前壁心肌梗死", sbm = "59.9901", smc = "输尿管支架置换术", mjb, mss;
//        List<SdInfoColumn> sdInfoColumns = sdInfoColumnDao.selectAll();
//        List<SdInfoColumnKeyVals> sdInfoColumnKeyVals = sdInfoColumnKeyValsDao.selectAll();
        System.out.println(matchBmAndMc(jbm, jmc, goal));
        //
        System.out.println(Pattern.matches("^" + "I21.0" + "+.*" + "急性广泛前壁心肌梗死" + "$", goal));
    }


}


