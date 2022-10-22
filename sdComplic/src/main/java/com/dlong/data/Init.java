package com.dlong.data;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Init {

    public static Set<String> set = new TreeSet<>();//总共需要的疑似病案首页数据总量
    public static Integer num = 0;//总计字段数量


    /**
     * 根据国家平台网页抓取的数据和国家平台配套的接口文档初始化单病种系统中需要的各种文件
     *
     * @return
     */
    public static Map<String, List<SdInfoInit>> init() {
        Map<String, List<SdInfoInit>> map = new LinkedHashMap<>();//平台所有接口
        List<SdInfoInit> list = new ArrayList<>();
        list.add(new SdInfoInit(1, "急性心肌梗死（ST 段抬高型，首次住院）", "STEMI", 1, "主要诊断 ICD-10 编码：I21.0 至 I21.3、I21.9 的出院患者。"));
        list.add(new SdInfoInit(2, "心力衰竭", "HF", 1, "主要诊断原发病 ICD-10 编码：I05 至 I09、或 I11 至 I13、或 I20 至 I21、或 I40 至 I41、或 I42 至 I43 伴第二诊断为I50 的出院患者。"));
        list.add(new SdInfoInit(3, "冠状动脉旁路移植术", "CABG", 1, "主要手术 ICD-9-CM-3 编码：36.1 的手术出院患者。"));
        list.add(new SdInfoInit(4, "房颤", "AF", 1, "主要诊断 ICD-10 编码：I48 的出院患者。"));
        list.add(new SdInfoInit(5, "主动脉瓣置换术", "AVR", 1, "主要手术 ICD-9-CM-3 编码：35.0、35.2 的手术出院患者。"));
        list.add(new SdInfoInit(6, "二尖瓣置换术", "MVR", 1, "主要手术 ICD-9-CM-3 编码：35.02、35.12、35.23、35.24的手术出院患者。"));
        list.add(new SdInfoInit(7, "房间隔缺损手术", "ASD", 1, "主要手术 ICD-9-CM-3 编码：35.51、35.52、35.61、35.71的手术出院患者。"));
        list.add(new SdInfoInit(8, "室间隔缺损手术", "VSD", 1, "主要手术 ICD-9-CM-3 编码：35.53、35.55、35.62、35.72的手术出院患者。"));
        map.put("一、心血管系统疾病/手术,1", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(9, "脑梗死（首次住院）", "STK", 1, "主要诊断 ICD-10 编码：I63.0 至 I63.9 的出院患者。"));
        list.add(new SdInfoInit(10, "短暂性脑缺血发作", "TIA", 1, "主要诊断 ICD-10 编码：G45.0 至 G45.9 的出院患者。"));
        list.add(new SdInfoInit(11, "脑出血", "ICH", 1, "主要诊断 ICD-10 编码：I61.0 至 I61.9 的出院患者。"));
        list.add(new SdInfoInit(12, "脑膜瘤（初发，手术治疗）", "MEN", 1, "主要诊断 ICD-10 编码：C70.0、C70.9、D32.0、D32.9、D42.9，伴 ICD-9-CM-3 编码：01.51、01.59 的手术出院患者。"));
        list.add(new SdInfoInit(13, "胶质瘤（初发，手术治疗）", "GLI", 1, "主要诊断 ICD-10 编码：C71，伴 ICD-9-CM-3 编码：01.52至 01.59 的手术出院患者。"));
        list.add(new SdInfoInit(14, "垂体腺瘤（初发，手术治疗）", "PA", 1, "主要诊断 ICD-10 编码：D35.2、C75.1、D44.3、E22.0、E23.6，伴 ICD-9-CM-3 编码：07.61 至 07.69、07.71、07.72、07.79 和 01.59 的手术出院患者。"));
        list.add(new SdInfoInit(15, "急性动脉瘤性蛛网膜下腔出血（初发，手术治疗）", "aSAH", 1, "主要诊断 ICD-10 编码：I60.0 至 I60.9，且伴主要手术ICD-9-CM 编码：01.3，02.2，02.3，38.3，38.4，38.6，39.5的手术出院患者。"));
        list.add(new SdInfoInit(16, "惊厥性癫痫持续状态", "CSE", 1, "主要诊断 ICD-10 编码：G41.0、G41.8、G41.9 的出院患者。"));
        list.add(new SdInfoInit(17, "帕金森病", "PD", 1, "主要诊断 ICD-10 编码：G20.x00 的出院患者。"));
        map.put("二、神经系统疾病/手术,2", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(18, "社区获得性肺炎（成人，首次住院）", "CAP", 1, "主要诊断 ICD-10 编码：J13 至 J16，J18；年龄≥18 岁的出院患者。"));
        list.add(new SdInfoInit(19, "社区获得性肺炎（儿童，首次住院）", "CAP2", 1, "主要诊断 ICD-10 编码：J13 至 J16，J18；2 岁≤年龄＜18 岁的出院患儿。"));
        list.add(new SdInfoInit(20, "慢性阻塞性肺疾病（急性发作，住院）", "AECOPD", 1, "主要诊断 ICD-10 编码：J44.0，J44.1 的出院患者。"));
        list.add(new SdInfoInit(21, "哮喘（成人，急性发作，住院）", "CAC", 1, "主要诊断 ICD-10 编码：J45，J46；年龄≥18 岁的出院患者。"));
        list.add(new SdInfoInit(22, "哮喘（儿童，住院）", "CAC2", 1, "主要诊断 ICD-10 编码：J45，J46；2 岁≤年龄＜18 岁的出院患儿。"));
        map.put("三、呼吸系统疾病,3", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(23, "髋关节置换术", "THR", 1, "主要手术 ICD-9-CM-3 编码：00.7，81.51 至 81.53 的手术出院患者。"));
        list.add(new SdInfoInit(24, "膝关节置换术", "TKR", 1, "主要手术 ICD-9-CM-3 编码：00.80 至 00.83，81.54，81.55 的手术出院患者。"));
        list.add(new SdInfoInit(25, "发育性髋关节发育不良（手术治疗）", "DDH", 1, "主要诊断 ICD-10 编码：Q65.0 至 Q65.6、Q65.8、Q65.9, 伴主要手术 ICD-9-CM-3 编码: 79.85、77.25、77.29；1 岁≤年龄≤8 岁（旧称先天性髋关节脱位）的手术出院患儿。"));
        map.put("四、运动系统疾病/手术,4", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(26, "剖宫产", "CS", 1, "主要手术 ICD-9-CM-3 编码：74.0，74.1，74.2，74.4，74.99 的手术出院患者。"));
        list.add(new SdInfoInit(27, "异位妊娠（手术治疗）", "EP", 1, "主要诊断 ICD-10 编码 ： O00 开头，且伴主要手术ICD-9-CM-3 编码：66.01，66.02，66.62，66.95，74.30的手术出院患者。"));
        list.add(new SdInfoInit(28, "子宫肌瘤（手术治疗）", "UM", 1, "主要诊断 ICD-10 编码与名称：D25 开头，且伴主要手术ICD-9-CM-3 编码：68.29，68.3 至 68.5，68.9 的手术出院患者。"));
        map.put("五、生殖系统疾病/手术,5", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(29, "肺癌（手术治疗）", "LC", 1, "主要诊断 ICD-10 编码 ： C34 开头，且伴主要手术ICD-9-CM-3 编码：32.2 至 32.6，32.9 的手术出院患者。"));
        list.add(new SdInfoInit(30, "甲状腺癌（手术治疗）", "TC", 1, "主要诊断 ICD-10 编码：C73 开头，且伴主要手术操作ICD-9-CM-3 编码：06.2 至 06.5 的手术出院患者。"));
        list.add(new SdInfoInit(31, "乳腺癌（手术治疗）", "BC", 1, "主要诊断 ICD-10 编码 ： C50 开头，且伴主要手术ICD-9-CM-3 编码：85.2 至 85.4 的手术出院患者。"));
        list.add(new SdInfoInit(32, "胃癌（手术治疗）", "GC", 1, "主要诊断 ICD-10 编码 ： C16 开头，且伴主要手术ICD-9-CM-3 编码：43.4 至 43.9 的手术出院患者。"));
        list.add(new SdInfoInit(33, "宫颈癌（手术治疗）", "CC", 1, "主要诊断 ICD-10 编码 ： C53 开头，且伴主要手术ICD-9-CM-3 编码：67.2 至 67.4，68.4，68.5，68.6，68.7的手术出院患者。"));
        list.add(new SdInfoInit(34, "结肠癌（手术治疗）", "CoC", 1, "主要诊断 ICD-10 编码：C18，D01.0；且伴主要手术操作 ICD-9-CM-3 编码：45.4,45.73 至 45.79,45.8 的手术出院患者。"));
        map.put("六、肿瘤（手术治疗）,6", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(35, "糖尿病肾病", "DKD", 1, "主要诊断和其他诊断 ICD-10 编码：E10 至 E14，且伴主要操作 ICD-9-CM-3 编码：55.23 的非产妇出院患者。"));
        list.add(new SdInfoInit(36, "终末期肾病血液透析", "ESRD-HD", 1, "主要诊断 ICD-10 编码：N18.0，且伴主要操作 ICD-9-CM-3编码：38.95，39.27，39.42，39.95 的血液透析患者。"));
        list.add(new SdInfoInit(37, "终末期肾病腹膜透析", "ESRD-PD", 1, "主要诊断 ICD-10 编码：N18.0，且伴主要操作 ICD-9-CM-3编码：54.98 的腹膜透析患者。"));
        map.put("七、泌尿系统疾病/操作,7", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(38, "舌鳞状细胞癌（手术治疗）", "TSCC", 1, "主要诊断 ICD-10 编码：C01，C02，且伴主要手术ICD-9-CM-3 编码：25.1 至 25.4，40.4 的手术出院患者。"));
        list.add(new SdInfoInit(39, "腮腺肿瘤（手术治疗）", "PT", 1, "主要诊断 ICD-10 编码：D11.0，且伴主要手术 ICD-9-CM-3编码：26.2，26.3 伴 04.42 的手术出院患者。"));
        list.add(new SdInfoInit(40, "口腔种植术", "OIT", 1, "主要手术 ICD-9-CM-3 编码：23.5，23.6 的门诊患者或者 76.09，76.91，76.92，22.79 的手术出院患者。"));
        map.put("八、口腔系统疾病/手术,8", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(41, "原发性急性闭角型青光眼（手术治疗）", "PACG", 1, "主要诊断 ICD-10 编码：H26.2，H40.0，H40.2，H40.9，且伴主要手术 ICD-9-CM-3 编码：10.1，10.49，10.6，10.91，10.99，12.11，12.12，12.64，12.66，12.67，12.71 至 12.73，12.79，12.83，12.85，12.87，12.91，12.92，12.99，13.19，13.3，13.41，13.59，13.70，13.71，13.90，14.73，14.74，14.79 的手术出院患者。"));
        list.add(new SdInfoInit(42, "复杂性视网膜脱离（手术治疗）", "RD", 1, "主要诊断 ICD-10 编码：E10.3，E11.3，E14.3，H33.0 至H33.5，H59.8，且伴主要手术 ICD-9-CM-3 编码：13.19，13.3，13.41，13.42，13.43，13.59，13.64，13.65，13.69，13.70，13.71，13.73，13.8，13.90，14.29，14.31，14.49，14.51，14.52，14.53，14.54，14.59，14.71，14.72，14.73，14.75，14.9 的手术出院患者。"));
        map.put("九、眼科系统疾病/手术,9", list);

        list = new ArrayList<>();
        list.add(new SdInfoInit(43, "围手术期预防感染", "PIP", 1, "主要手术 ICD-9-CM-3 编码如下的手术出院患者：\n" +
                "1.甲状腺叶切除术：06.2 至 06.5\n" +
                "2.膝半月软骨切除术：80.6\n" +
                "3.晶状体相关手术：13.0 至 13.9\n" +
                "4.腹股沟疝相关手术：17.11 至 17.13，17.21 至 17.24，53.00 至 53.17\n" +
                "5.乳房组织相关手术：85.2 至 85.4\n" +
                "6.动脉内膜切除术：38.1\n" +
                "7.足和踝关节固定术和关节制动术：81.1\n" +
                "8.其他颅骨切开术：01.24\n" +
                "9.椎间盘切除术或破坏术：80.50 至 80.59\n" +
                "10.骨折切开复位+内固定术：03.53，21.72，76.72 至76.79，79.30 至 79.39\n" +
                "11.关节脱位切开复位内固定术：76.94，79.8\n" +
                "12.骨内固定不伴骨折复位术及置入装置去除：78.5 至78.6\n" +
                "13.卵巢相关手术：65.2 至 65.6\n" +
                "14.肌腱相关手术：83.11 至 83.14\n" +
                "15.睾丸相关手术：62.0 至 62.9\n" +
                "16.阴茎相关手术：64.0 至 64.4\n" +
                "17.室间隔缺损修补术：35.62\n" +
                "18.房间隔缺损修补术：35.61\n" +
                "19.髋关节置换术：00.7，81.51 至 81.53\n" +
                "20.膝关节置换术：00.80 至 00.83，81.54，81.55\n" +
                "21.冠状动脉旁路移植术：36.1\n" +
                "22.剖宫产：74.0，74.1，74.2，74.4，74.99"));
        list.add(new SdInfoInit(44, "围手术期预防深静脉血栓栓塞", "DVT", 1, "主要手术 ICD-9-CM-3 编码如下的手术出院患者：\n" +
                "1.闭合性心脏瓣膜切开术：35.00 至 35.04\n" +
                "2.心脏瓣膜切开和其他置换术：35.20 至 35.28\n" +
                "3.脊柱颈融合术：81.04 至 81.08\n" +
                "4.脊柱再融合术：81.34 至 81.38\n" +
                "5.胃部分切除术伴胃十二指肠吻合术：43.6\n" +
                "6.胃部分切除术伴胃空肠吻合术：43.7\n" +
                "7.其他胃部分切除术：43.8\n" +
                "8.胃全部切除术：43.9\n" +
                "9.开放性和其他部分大肠切除术：45.7\n" +
                "10.腹会阴直肠切除术：48.5\n" +
                "11.直肠其他切除术：48.6\n" +
                "12.肝叶切除术：50.3\n" +
                "13.部分肾切除术：55.4\n" +
                "14.全部肾切除术：55.5\n" +
                "15.部分膀胱切除术：57.6\n" +
                "16.全部膀胱切除术：57.7\n" +
                "17.卵巢病损或卵巢组织的局部切除术或破坏术：65.2\n" +
                "18.单侧卵巢切除术：65.3\n" +
                "19.单侧输卵管-卵巢切除术：65.4\n" +
                "20.双侧卵巢切除术：65.5\n" +
                "21.双侧输卵管-卵巢切除术：65.6\n" +
                "22.子宫病损或组织的切除术或破坏术：68.2\n" +
                "23.经腹子宫次全切除术：68.3\n" +
                "24.经腹子宫全部切除术：68.4\n" +
                "25.阴道子宫切除术：68.5\n" +
                "26.经腹根治性子宫切除术：68.6\n" +
                "27.根治性阴道子宫切除术：68.7\n" +
                "28.盆腔脏器去除术：68.8\n" +
                "29.髋关节置换术：00.7，81.51 至 81.53\n" +
                "30.膝关节置换术：00.80 至 00.83，81.54，81.55\n" +
                "31.冠状动脉旁路移植术：36.1"));
        list.add(new SdInfoInit(45, "住院精神疾病", "HBIPS", 1, "主要诊断 ICD-10 编码：F00-F99 的出院患者。"));
        list.add(new SdInfoInit(46, "中高危风险患者预防静脉血栓栓塞症", "VTE", 1, "需要落实预防静脉血栓措施的重点患者：\n" +
                "1.入住 ICU 的患者\n" +
                "2.中高危风险患者：\n" +
                "（1） 高龄（≥70 岁）\n" +
                "（2） 既往 VTE 病史或 VTE 家族史\n" +
                "（3） 恶性肿瘤(ICD-10 类目编码:C00-C97)\n" +
                "（4） 严重创伤\n" +
                "（5） 脓毒症(ICD-10 亚目编码：“A40.0、A40.1、A40.2、A40.3、A40.8、A40.9、A41.0、A41.1、A41.2、A41.3、A41.4、A41.5、A41.8、A41.9，R65.2、R65.3、R65.9)\n" +
                "（6） 急性生理和慢性健康评分⁃ Ⅱ（APACHE⁃ Ⅱ）＞12 分\n" +
                "（7） 急诊手术及麻醉复苏室转入\n" +
                "（8） 转入 ICU 前住院时间长（>30 天）\n" +
                "（9） 制动\n" +
                "（10）机械通气(ICD-9-CM-3 亚目编码：96.7 其他持续侵入性机械性通气,93.90、93.91 无创机械性通气)\n" +
                "（11）留置中心静脉导管(ICD-9-CM-3亚目编码89.60-89.69)\n" +
                "（12）血液净化治疗（ICD-9-CM-3 亚目编码：“39.95”）\n" +
                "（13）使用肌肉松弛和镇静药物\n" +
                "（14）应用收缩血管药物\n" +
                "（15）输注血小板\n" +
                "（16）血栓预防失败\n" +
                "（17）医师认为需评估的其他中高风险患者"));
        list.add(new SdInfoInit(47, "感染性休克", "SEP", 1, "主要诊断/其他诊断 ICD-10 编码：A02.1，A22.7，A32.7，A40.1 至 A40.9， A41.0 至 A41.9，A42.7，A54.8，B73.7，R65.2，R65.3，R65.9 的出院患者。"));
        list.add(new SdInfoInit(48, "儿童急性淋巴细胞白血病（初始诱导化疗）", "ALL", 1, "主要诊断 ICD-10 编码：C91.0，且伴主要操作 ICD-9-CM-3编码：99.25 的出院患儿。"));
        list.add(new SdInfoInit(49, "儿童急性早幼粒细胞白血病（初始化疗）", "APL", 1, "主要诊断 ICD-10 编码：C92.4，且伴主要操作 ICD-9-CM-3编码：99.25 的出院患儿。"));
        list.add(new SdInfoInit(50, "甲状腺结节（手术治疗）", "TN", 1, "主要诊断 ICD-10 编码：D34，E04.0，E04.1，E04.2，且伴主要手术 ICD-9-CM-3 编码：06.2 至 06.5 的手术出院患者。"));
        list.add(new SdInfoInit(51, "HBV 感染分娩母婴阻断", "HBV", 1, "主要诊断 ICD-10 编码：O98.4，Z22.5 + O80 至 O84+Z37；且伴①阴道分娩操作 ICD-9-CM-3 编码 72.0 至 72.9，73.0，73.1，73.21，73.4 至 73.6,73.9；或伴②剖宫产手术 ICD9-CM-3 编码：74.0，74.1，74.2，74.4，74.99 的出院患者。"));
        map.put("十、其他疾病/手术,10", list);

        List<String> ls = new ArrayList<>();//平台现在开放的接口
        ls.add("脑出血");
        ls.add("垂体腺瘤（初发，手术治疗）");
        ls.add("短暂性脑缺血发作");
        ls.add("二尖瓣置换术");
        ls.add("房颤");
        ls.add("房间隔缺损手术");
        ls.add("肺癌（手术治疗）");
        ls.add("冠状动脉旁路移植术");//36.1
        ls.add("急性动脉瘤性蛛网膜下腔出血");
        ls.add("急性心肌梗死（ST 段抬高型，首次住院）");
        ls.add("甲状腺癌（手术治疗）");
        ls.add("胶质瘤（初发，手术治疗）");
        ls.add("惊厥性癫痫持续状态");
        ls.add("髋关节置换术");
        ls.add("慢性阻塞性肺疾病（急性发作，住院）");
        ls.add("脑梗死（首次住院）");
        ls.add("脑膜瘤（初发，手术治疗）");
        ls.add("帕金森病");
        ls.add("剖宫产");
        ls.add("乳腺癌（手术治疗）");
        ls.add("社区获得性肺炎（成人，首次住院）");
        ls.add("社区获得性肺炎（儿童，首次住院）");
        ls.add("室间隔缺损手术");
        ls.add("围手术期预防深静脉血栓栓塞");
        ls.add("围手术期预防感染");
        ls.add("胃癌（手术治疗）");
        ls.add("膝关节置换术");
        ls.add("哮喘（成人，急性发作，住院）");
        ls.add("心力衰竭");
        ls.add("异位妊娠（手术治疗）");
        ls.add("主动脉瓣置换术");
        ls.add("住院精神疾病");
        return map;
    }


    public static Map<String, List<SdInfoInit>> createFiles() {
        Map<String, List<SdInfoInit>> map = init();
        AtomicInteger i = new AtomicInteger();
        map.forEach((k, v) -> {
            AtomicInteger j = new AtomicInteger();
            v.stream().forEach(e -> {
                try {
                    parseJson(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                i.getAndIncrement();
                j.getAndIncrement();
            });
            System.out.println(k + " 中共有 " + v.size() + " ，开放了 " + j);
        });
        System.out.println("全部共有 " + i + "   个单病种信息");
        System.out.println("全部共有" + num + "   个字段");
        System.out.println("需要的病案首页数据总量  " + set.size());
//        System.out.println(set);
        System.out.println("现有文件数量 ： " + iii);
        return map;
    }

    /**
     * 生成配套的文件和sql文件
     *
     * @param zhs    中文名，文件名
     * @param tns    数据库表名
     * @param ens    entity的java文件名称
     * @param detail
     * @throws Exception
     */
    static Integer iii = 0;

    public static void parseJson(SdInfoInit sdinfo) throws Exception {
//        String zhs = sdinfo.getName();
        Integer sdid = sdinfo.getId();
        String zhs = sdid + "";
        if (sdid <= 9 && sdid >= 0) zhs = "0" + sdid;
        String tns = sdinfo.getTableName();
        String ens = sdinfo.getEntityName();
        String detail = sdinfo.getDetail();
        File f = new File("jsons/" + zhs + ".json");
        if (!f.exists()) {
            System.out.println("没找到文件");
            return;
        }
        iii++;
        JSONObject jo = JSONUtil.readJSONObject(f, Charset.defaultCharset());
        JSONArray ja = JSONUtil.parseArray(jo.get("object")), ja2, ja3, ja4, ja5, ja6, ja7, ja8, ja9, ja10, ja11, ja12, ja13, ja14, ja15,
                ja16;
        Map<String, Object> map = new HashMap<>(), entity = new LinkedHashMap<>();
        List<Object> list;
        //总体json
        for (Object j : ja) {
            //各个模块
            list = fill((JSONObject) j, entity);
            ja2 = (JSONArray) list.get(0);
            entity = (Map<String, Object>) list.get(1);
            if (ja2.isEmpty()) {
                continue;
            }
            for (Object j2 : ja2) {
                //各个模块
                list = fill((JSONObject) j2, entity);
                ja3 = (JSONArray) list.get(0);
                entity = (Map<String, Object>) list.get(1);
                if (ja3.isEmpty()) {
                    continue;
                }
                for (Object j3 : ja3) {
                    //各个模块
                    list = fill((JSONObject) j3, entity);
                    ja4 = (JSONArray) list.get(0);
                    entity = (Map<String, Object>) list.get(1);
                    if (ja4.isEmpty()) {
                        continue;
                    }
                    for (Object j4 : ja4) {
                        //各个模块
                        list = fill((JSONObject) j4, entity);
                        ja5 = (JSONArray) list.get(0);
                        entity = (Map<String, Object>) list.get(1);
                        if (ja5.isEmpty()) {
                            continue;
                        }
                        for (Object j5 : ja5) {
                            //各个模块
                         /*   list = fill((JSONObject) j5, entity);
                            ja6 = (JSONArray) list.get(0);
                            entity = (Map<String, Object>) list.get(1);*/
                            //****
                            list = fill((JSONObject) j5, entity);
                            ja6 = (JSONArray) list.get(0);
                            entity = (Map<String, Object>) list.get(1);
                            if (ja6.isEmpty()) {
                                continue;
                            }
                            for (Object j6 : ja6) {
                                //各个模块
                                list = fill((JSONObject) j6, entity);
                                ja7 = (JSONArray) list.get(0);
                                entity = (Map<String, Object>) list.get(1);
                                if (ja7.isEmpty()) {
                                    continue;
                                }
                                for (Object j7 : ja7) {
                                    //各个模块
                                    list = fill((JSONObject) j7, entity);
                                    ja8 = (JSONArray) list.get(0);
                                    entity = (Map<String, Object>) list.get(1);
                                    if (ja8.isEmpty()) {
                                        continue;
                                    }
                                    for (Object j8 : ja8) {
                                        //各个模块
                                        list = fill((JSONObject) j8, entity);
                                        ja9 = (JSONArray) list.get(0);
                                        entity = (Map<String, Object>) list.get(1);
                                        if (ja9.isEmpty()) {
                                            continue;
                                        }
                                        for (Object j9 : ja9) {
                                            //各个模块
                                            list = fill((JSONObject) j9, entity);
                                            ja10 = (JSONArray) list.get(0);
                                            entity = (Map<String, Object>) list.get(1);
                                            if (ja10.isEmpty()) {
                                                continue;
                                            }
                                            for (Object j10 : ja10) {
                                                //各个模块
                                                list = fill((JSONObject) j10, entity);
                                                ja11 = (JSONArray) list.get(0);
                                                entity = (Map<String, Object>) list.get(1);
                                                if (ja11.isEmpty()) {
                                                    continue;
                                                }
                                                for (Object j11 : ja11) {
                                                    //各个模块
                                                    list = fill((JSONObject) j11, entity);
                                                    ja12 = (JSONArray) list.get(0);
                                                    entity = (Map<String, Object>) list.get(1);
                                                    if (ja12.isEmpty()) {
                                                        continue;
                                                    }
                                                    for (Object j12 : ja12) {
                                                        //各个模块
                                                        list = fill((JSONObject) j12, entity);
                                                        ja13 = (JSONArray) list.get(0);
                                                        entity = (Map<String, Object>) list.get(1);
                                                        if (ja13.isEmpty()) {
                                                            continue;
                                                        }
                                                        for (Object j13 : ja13) {
                                                            //各个模块
                                                            list = fill((JSONObject) j13, entity);
                                                            ja14 = (JSONArray) list.get(0);
                                                            entity = (Map<String, Object>) list.get(1);
                                                            if (ja14.isEmpty()) {
                                                                continue;
                                                            }
                                                            for (Object j14 : ja14) {
                                                                //各个模块
                                                                list = fill((JSONObject) j14, entity);
                                                                ja15 = (JSONArray) list.get(0);
                                                                if (ja15.isEmpty()) {
                                                                    continue;
                                                                }
                                                                entity = (Map<String, Object>) list.get(1);
                                                                for (Object j15 : ja15) {
                                                                    //各个模块
                                                                    list = fill((JSONObject) j15, entity);
                                                                    ja16 = (JSONArray) list.get(0);
                                                                    entity = (Map<String, Object>) list.get(1);
                                                                    if (ja16.isEmpty()) {
                                                                        continue;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        sdinfo.setEts(entity);
//        for (Object o : entity.values()) {
//            et e = (et) o;
//        }


        num += entity.values().size();
        StringBuilder sb = new StringBuilder ( "package com.sxdl.sd.entity;\n" +
                "\n" +
                "import io.swagger.annotations.ApiModel;\n" +
                "import lombok.Data;\n" +
                "\n" +
                "import com.fasterxml.jackson.annotation.JsonProperty;\n" +
                "import javax.persistence.Column;\n" +
                "import javax.persistence.Entity;\n" +
                "import javax.persistence.Id;\n" +
                "import javax.persistence.Table;\n" +
                "import java.io.Serializable;\n" +
                "\n" +
                "/*" + detail + "\n" +
                "*/\n" +
                "@ApiModel(value = \"" );
        String zh = "信息\")\n" +
                "@Entity\n" +
                "@Data\n" +
                "@Table(name = \"", tablen = "\")\n" +
                "public class ", entityn = " implements Serializable {\n" +
                "    private static final long serialVersionUID = 1L;\n" +
                "    @Id\n" +
                "    private Integer id; \n", end = "}";
        String replaceStr;
        sb.append ( zhs ).append ( zh ).append ( tns ).append ( tablen ).append ( ens ).append ( entityn );

        //拼接sql
        StringBuilder sb2 = new StringBuilder ( "CREATE TABLE [dbo].[" );
        String tablent = "]([id] [int] IDENTITY(1,1) NOT NULL,[submit_id] [varchar](255) NULL,[submit_time] [varchar](255) NULL,[check_id] [varchar](255) NULL,[check_time] [varchar](255) NULL,[check_result] [varchar](255) NULL, [status] [int] NULL, ",
                tcn = "] [varchar](255) NULL, ",
                endt = "PRIMARY KEY CLUSTERED ([id] ASC)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]";
        sb2.append ( tns ).append ( tablent );

        List<String> l = new ArrayList<> ();
        for (Object o : entity.values ()) {
            et e = (et) o;
            // 判断疑似病案首页数据
            if (e.getName ().startsWith ( "CM" )) {
                l.add ( e.getName () + "    " + e.getTitle () );
                set.add ( e.getName () + "    " + e.getTitle () );
            }

            replaceStr = e.getName ().replace ( "-", "_" );
            String replaceStr1 = e.getName ().replace ( "_", "-" );
            sb.append ( "    @Column(name = \"" ).append ( replaceStr ).append ( "\")\n" );
            sb.append ( "    @JsonProperty(\"" ).append ( replaceStr1 ).append ( "\")\n" );
            sb.append ( "    private String " ).append ( replaceStr ).append ( "; // " ).append ( e.getTitle () ).append ( "\n" );

            sb2.append ( "[" ).append ( replaceStr ).append ( tcn );
        }
        // TODO
        Map<String, Object> m = new LinkedHashMap<> ();
        m.put ( "key", zhs );
        m.put ( "size", l.size () );
        m.put ( "list", l );
        //System.out.println(m);


        sb.append ( end );
        sb2.append ( endt );

        StringBuilder sb3 = new StringBuilder ( "package com.sxdl.sd.dao.dao1;\n" +
                "\n" +
                "import com.sxdl.base.dao.BaseDao;\n" +
                "import com.sxdl.sd.entity." + ens + ";\n" +
                "\n" +
                "public interface " + ens + "Dao extends BaseDao<" + ens + "> {\n" +
                "}" );
        String Ens = StrUtil.lowerFirst ( ens );
        StringBuilder sb4 = new StringBuilder ( "package com.sxdl.sd.service;\n" +
                "\n" +
                "import com.sxdl.sd.entity." + ens + ";\n" +
                "\n" +
                "import com.sxdl.base.service.BaseService;\n" +
                "\n" +
                "import com.sxdl.sd.entity.SdPatientInfo;\n" +
                "\n" +
                "public interface " + ens + "Service extends BaseService<" + ens + ">{\n" +
                " void insertOrUpdate(" + ens+" " + Ens +", SdPatientInfo sdPatientInfo);"+
                "\n" +
                "}" );
        StringBuilder sb5 = new StringBuilder ( "package com.sxdl.sd.service.impl;\n" +
                "\n" +
                "import com.sxdl.base.service.impl.BaseServiceImpl;\n" +
                "import com.sxdl.sd.dao.dao1." + ens + "Dao;\n" +
                "import com.sxdl.sd.dao.dao1.SdPatientInfoDao;\n" +
                "import com.sxdl.sd.entity." + ens + ";\n" +
                "import com.sxdl.sd.entity.SdPatientInfo;\n" +
                "import com.sxdl.sd.service." + ens + "Service;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;"+
                "import org.springframework.stereotype.Service;\n" +
                "import org.springframework.transaction.annotation.Transactional;\n" +
                "\n" +
                "@Service\n" +
                "@Transactional\n" +
                "public class " + ens + "ServiceImpl extends BaseServiceImpl<" + ens + "> implements " + ens + "Service {\n" +
                "    @Autowired\n" +
                "    SdPatientInfoDao sdPatientInfoDao;\n" +
                "    @Autowired\n" +
                "    "+ens+ "Dao  " + Ens + "Dao;\n" +
                "    \n" +
                "    @Override\n" +
                "    public void insertOrUpdate(" + ens+" " + Ens + ", SdPatientInfo sdPatientInfo) {\n" +
                "       if (sdPatientInfo != null) {\n" +
                "            Integer id = sdPatientInfo.getId ();\n" +
                "            if (null != id && !\"\".equals ( id ) && id > 0) {\n" +
                "                sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );\n" +
                "            } else {\n" +
                "                SdPatientInfo sdPatientInfo1=new SdPatientInfo ();\n" +
                "                sdPatientInfo1.setPatient_code ( sdPatientInfo.getPatient_code () );\n" +
                "                sdPatientInfo1.setSd_info_id ( sdPatientInfo.getSd_info_id () );\n" +
                "                SdPatientInfo sdPatientInfo2 = sdPatientInfoDao.selectOne ( sdPatientInfo1 );\n" +
                "                if(sdPatientInfo2!=null){\n" +
                "                    Integer id1 = sdPatientInfo2.getId ();\n" +
                "                    if (null != id1 && !\"\".equals ( id1 ) && id1 > 0) {\n" +
                "                        sdPatientInfo.setId ( id1);\n" +
                "                        sdPatientInfoDao.updateByPrimaryKeySelective ( sdPatientInfo );\n" +
                "                    }\n" +
                "                    else {\n" +
                "                        sdPatientInfoDao.insertSelective ( sdPatientInfo );\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }"+
                "        if (" + Ens + " != null) {\n" +
                "            Integer id = " + Ens + ".getId ();\n" +
                "            if (null != id && !\"\".equals ( id ) && id > 0) { \n" +
                Ens + "Dao.updateByPrimaryKeySelective ( " + Ens + " );\n" +
                "            } else {\n" +
                "                //病人不存在  新增\n" +
                Ens + "Dao.insertSelective (  " + Ens + ");\n" +
                "            }\n" +
                "        }\n" +
                "    }" +
                "}" );
        //String Ens = StringUtil.AToa ( ens );
        StringBuilder sb6 = new StringBuilder ( "package com.sxdl.sd.controller;\n" +
                "\n" +
                "import com.sxdl.base.util.ResultUtil;\n" +
                "import com.sxdl.sd.entity." + ens + ";\n" +
                "import com.sxdl.sd.service." + ens + "Service;\n" +
                "import io.swagger.annotations.Api;\n" +
                "import io.swagger.annotations.ApiOperation;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.web.bind.annotation.*;\n" +
                "\n" +
                "@Api(tags = " + "\"" + ens + "信息\"" + ")\n" +
                "@RestController\n" +
                "@RequestMapping( " + "\"/" + ens + "\"" + ")\n" +
                "public class " + ens + "Controller{\n" +
                "\n" +
                "// 新增单病种\n" +
                "\n" +
                " @Autowired\n" +
                " private " + ens + "Service  " + Ens + "Service;\n" +
                "\n" +
                "@ApiOperation(value = " + "\" 新增 \" " + ", notes = " + "\" 新增" + ens + "信息\"" + ")\n" +
                "@PostMapping( " + "\"/insert" + ens + "\"" + ")\n" +
                "\n" +
                "public ResultUtil insert" + ens + "(@RequestBody  " + ens + " " + Ens + "){\n" +
                "\n" +
                "if(" + Ens + "==null){\n" +
                "\n" +
                " return ResultUtil.error (" + "\"" + "没有" + ens + "数据需要保存\" " + " );}\n" +
                "try {\n" +
                "\n" +
                Ens + "Service.insert ( " + Ens + " );\n" +
                " return ResultUtil.success (" + "\"" + ens + "数据信息保存成功\" " + " );\n" +
                "} catch (Exception e) {\n" +
                "return ResultUtil.error ( e.getMessage () );}\n" +
                "}\n" +
                "\n" +
                "// 修改单病种\n" +
                "\n" +
                "@ApiOperation(value = " + "\" 修改 \"" + ", notes = " + "\" 修改" + ens + " 信息\"" + ")\n" +
                "@PutMapping( " + "\"/update" + ens + "\"" + ")\n" +
                "\n" +
                "public ResultUtil update" + ens + "(@RequestBody  " + ens + " " + Ens + "){\n" +
                "\n" +
                "if(" + Ens + "==null){\n" +
                "\n" +
                " return ResultUtil.error (" + "\"" + "没有" + ens + "数据需要修改\" " + " );}\n" +
                "try {\n" +
                "\n" +
                Ens + "Service.update ( " + Ens + " );\n" +
                " return ResultUtil.success (" + "\"" + ens + "数据信息修改成功\" " + " );\n" +
                "} catch (Exception e) {\n" +
                "return ResultUtil.error ( e.getMessage () );}\n" +
                "}\n" +
                "\n" +
                "//查单个单病种信息\n" +
                "\n" +
                "@ApiOperation(value = " + "\" 根据id查询单病种信息 \"" + ", notes = " + "\" 根据id查询单病种信息\"" + ")\n" +
                "@GetMapping( " + "\"/findById\"" + ")\n" +
                "@ResponseBody\n" +
                "\n" +
                "public ResultUtil findById (@RequestParam (value = " + "\"id\"" + ",required = true) Integer id){\n" +
                "\n" +
                "try {\n" +
                "\n" +
                ens + "  byId = " + Ens + "Service.findById ( id );\n" +
                " return ResultUtil.success (byId);\n" +
                "} catch (Exception e) {\n" +
                "return ResultUtil.error ( e.getMessage () );}\n" +
                "}\n" +
                "\n" +
                "}"
        );
        StringBuilder sb7 = new StringBuilder ( " @Autowired\n" +
                " private " + ens + "Service  " + Ens + "Service;\n" +
                "\n" );
        //System.out.println (sb7);
        //serviceMap.put ( id, Ens + "Service" );
        //System.out.println ( "serviceMap.put ( " + id + "," + Ens + "Service );" );

        StringBuilder sb8 = new StringBuilder ( "truncate table " );
        sb8.append ( tns );
        System.out.println (sb8.toString ());

        File file = new File ( "javas/entity/" + ens + ".java" );
        file.createNewFile ();
        File file2 = new File ( "sqls/" + ens + ".sql" );
        file2.createNewFile ();
        File file3 = new File ( "javas/dao/" + ens + "Dao.java" );
        file3.createNewFile ();
        File file4 = new File ( "javas/service/" + ens + "Service.java" );
        file4.createNewFile ();
        File file5 = new File ( "javas/service/impl/" + ens + "ServiceImpl.java" );
        file5.createNewFile ();
        File file6 = new File ( "javas/controller/" + ens + "Controller.java" );
        file6.createNewFile ();
        File file7 = new File ( "sqls/" + "qb"+ens + ".sql" );
        file7.createNewFile ();

        FileOutputStream fo = new FileOutputStream ( file );
        fo.write ( sb.toString ().getBytes () );//生成entity的java

        fo = new FileOutputStream ( file2 );
        fo.write ( sb2.toString ().getBytes () );//生成sql

        fo = new FileOutputStream ( file3 );
        fo.write ( sb3.toString ().getBytes () );//生成dao

        fo = new FileOutputStream ( file4 );
        fo.write ( sb4.toString ().getBytes () );//生成service

        fo = new FileOutputStream ( file5 );
        fo.write ( sb5.toString ().getBytes () );//生成serviceImpl

        fo = new FileOutputStream ( file6 );
        fo.write ( sb6.toString ().getBytes () );//生成controller


        fo = new FileOutputStream ( file7 );
        fo.write ( sb8.toString ().getBytes () );//生成controller

    }


    public static List<Object> fill(JSONObject jsonObject, Map<String, Object> entity) {
        String t1 = jsonObject.getStr("title");//每个节点都有

        JSONArray jsonArray = new JSONArray();
        String type = jsonObject.getStr("type");
        if ("box1".equals(type) || "box".equals(type) || jsonObject.containsKey("sonList")) {
            //每个模块中的子模块的信息
            jsonArray = JSONUtil.parseArray(jsonObject.get("sonList"));
        } else if (jsonObject.containsKey("submitName")) {
            et et = new et();
            et.setTitle(t1);
            et.setFlag(true);//submitName
            et.setName(jsonObject.getStr("submitName"));
            et.setNo(jsonObject.getStr("no"));
            et.setType(type);
            if ("select".equals(type) || "checkbox".equals(type)) {
                et.setVals(jsonObject.getStr("values"));
            }
            //entity.put(t1, et);
            entity.put ( et.getName (), et );
        }

        List<Object> list = new ArrayList<>();
        list.add(jsonArray);
        list.add(entity);
        return list;
    }
}