import com.sxdl.base.util.MD5Util;
import com.sxdl.fm.util.app.FMone;
import com.sxdl.fm.util.app.FmAllTwenty;
import com.sxdl.fm.util.app.FmSingle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static String encrypt_Base64(String str) throws Exception {
        return Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
    }

    public static String decrypt_Base64(String str) throws Exception {
        return new String(Base64.getDecoder().decode(str), "UTF-8");
    }
    @org.junit.jupiter.api.Test
public void testEn(){
        String s="123",md5;
        md5=MD5Util.MD5Encoder(s);
    System.out.println(md5);
    System.out.println(md5.length());
    md5=MD5Util.MD5Encoder("MAC :60-F2-62-C5-6A-84\n" +
            "CPU :BFEBFBFF000806EC\n" +
            "MBD :PM05T0203L000670");
    System.out.println(md5);
    System.out.println(md5.length());
    md5=MD5Util.MD5Encoder("abdfadsjafkldhjadsiohguiabjkfdhnkjbnjkvhuifyaudsunfjkbgjmadsbnmdhnxjkfhsdjksdyhuiyasdihbjdkabjnadskl;mnkmadkoasdhfieqyrfidbnaklgndklandfasdkjfhdaojiankglnklasfjasklfjasdklnjkvnaskhjdksajfdajhcj");
    System.out.println(md5);
    System.out.println(md5.length());

}

    @org.junit.jupiter.api.Test
public void testtime() throws ParseException {
        Date date=new Date();
    System.out.println(date);
    DateFormat df=new SimpleDateFormat("YYYY-MM-dd");
    System.out.println(df.parse("2021-01-01"));
//    Calendar instance = Calendar.getInstance ();
//    String edate = DateUtil.dateToStr ( instance.getTime () );
//    instance.add ( Calendar.DAY_OF_YEAR, -15 );
//    String sdate = DateUtil.dateToStr ( instance.getTime () );
//    List<String> list = DateUtil.getSplicTimeParam ( sdate, edate, "天", 1 );
//    list.forEach(System.out::println);

//    System.out.println(DateUtil.formatYYYYMMDDFromDateToLocalDate("20200101"));
//    System.out.println(DateUtil.formatYYYYMMDDFromDateToYMDHmS("20200101"));

//    String yestoday= LocalDate.now().plusDays(-1).toString();
//    System.out.println(yestoday);
//    System.out.println(DateUtil.getSplicTimeParam ( "2021-01-01","2021-01-01", "天", 1 ));
    //        String s="20201101";
//    LocalDate parse = DateUtil.formatYYYYMMDDFromDate(s);
//    System.out.println(parse.getYear());
//    System.out.println(DateUtil.getQuarter(parse.getMonthValue()));
//    System.out.println(parse.getMonthValue());
//    System.out.println( parse.get(WeekFields.ISO.weekOfWeekBasedYear()));
//    System.out.println( parse.get(WeekFields.ISO.weekBasedYear()));
//    System.out.println( parse.get(WeekFields.ISO.weekOfYear()));
//    System.out.println(parse);
////    System.out.println(parse.compareTo(LocalDate.parse("2020-12-01")));
//    System.out.println(LocalDate.now().getYear()-Integer.parseInt("2020"));
//    System.out.println(LocalDate.now().getYear()-Integer.parseInt("2019"));
//    System.out.println(LocalDate.now().getYear()-Integer.parseInt("2018"));
}
    @org.junit.jupiter.api.Test
    public void tttttt() {
//        String[] roleIds = "1,".split(",");
//        System.out.println(Integer.parseInt(roleIds[1]));

//        String ss="qewr,";
//        System.out.println(ss.substring(0,ss.length()-1));
//        DecimalFormat df = new DecimalFormat("#.00");
//        System.out.println(df.format(0.001));
//        String s="1.134";
//        System.out.println(s.split(".")[0]);
        String sql = "insert into aaa  select distinct name,name from T_fm_drgs_dr where name is not null and name not in (select dm from aaa )";
        String sql1;
        for(int i=1;i<5;i++){


        switch (i) {
            case 1:
                sql1 = sql.replace("aaa", "W_fm_drgs_kzr").replace("name", "kzr");
                System.out.println(sql1);
                break;
            case 2:
                sql1 = sql.replace("aaa", "W_fm_drgs_zrys").replace("name", "zrys");
                System.out.println(sql1);
                break;
            case 3:
                sql1 = sql.replace("aaa", "W_fm_drgs_zzys").replace("name", "zzys");
                System.out.println(sql1);
                break;
            case 4:
                sql1 = sql.replace("aaa", "W_fm_drgs_zyys").replace("name", "zyys");
                System.out.println(sql1);
                break;
        }
        }
    }
    @org.junit.jupiter.api.Test
public void testEnum(){
//    Arrays.stream(FMone.values()).forEach(e->{
//        System.out.println(e.code);
//        System.out.println(e.toString());
//    });
    Arrays.stream(FMone.values()).forEach(e->{
        System.out.print(FMone.getNameParam(e.code,1));
//        System.out.print("sum("+e.name+") as "+e.name+",");
    });
}
    @org.junit.jupiter.api.Test
    public void testReplace() {
        String s = "2020-11-01;2020-11-30";
        String[] times = s.split(";");
        String sql = FMone.getSql(2);
        sql = sql.replace("@!@", times[0]).replace("@!!@", times[1]).replace("@!!!@", "张三");
        System.out.println(sql);
    }

    @org.junit.jupiter.api.Test
    public void tt() throws Exception {
        String s = "zzz";
        System.out.println("原始 " + s);
        String ec = Test.encrypt_Base64(s);
        System.out.println("加密一次 " + ec);
        ec = Test.encrypt_Base64(ec);
        System.out.println("加密两次 " + ec);
        s = Test.decrypt_Base64(ec);
        System.out.println("解密一次 " + s);
        s = Test.decrypt_Base64(s);
        System.out.println("解密两次 " + s);
    }

    @org.junit.jupiter.api.Test
    public void ttttt() {
        String s = "aaa\nbbb";
        System.out.println(s.replace("\n", ""));
    }

    @org.junit.jupiter.api.Test
    public void t() {
//        FmStaffMid fmStaffMid=new FmStaffMid(),f2=new FmStaffMid();
//        fmStaffMid.setXm("123");
//        fmStaffMid.setKs("321");
//        System.out.println(fmStaffMid);
//        f2.setXm("123");
//        f2.setKs("321");
//
//        System.out.println(fmStaffMid.equals(f2));

        List<FmSingle> list = new ArrayList<>();
        list.add(new FmSingle("12"));
        list.add(new FmSingle("3"));
        list.add(new FmSingle("5"));
        Map<String, List<FmSingle>> map = new HashMap();
        map.put("13", list);
        list = new ArrayList<>();
        list.add(new FmSingle("6"));
        list.add(new FmSingle("7"));
        list.add(new FmSingle("8"));
        map.put("55", list);
//        map.keySet().forEach(e -> {
//            double groupval = map.get(e).stream().map(FmSingle::getDoubleVal).reduce(0.0, (a, b) -> a + b);
//            FmSingle f = new FmSingle(groupval + "");
//            System.out.println(f);
//
//        });
//        list.stream().map(FmSingle::getDoubleVal).reduce(0.0, (a, b) -> a + b);
        System.out.println(list.subList(0, 3));
    }

    @org.junit.jupiter.api.Test
    public void tenum() {
//        Arrays.stream(FMone.values()).forEach(System.out::println);
//        System.out.println(FMone.mjzrs.sql);
//        System.out.println(FMone.getSql(1));
    }

    @org.junit.jupiter.api.Test
    public void tttttttt() {
        List<FmAllTwenty> fs = new ArrayList<>(), fs2 = new ArrayList<>();
        FmAllTwenty f = new FmAllTwenty();
        f.setYs("张三");
        f.setMjzrs("10");
        f.setDy3h("1");
        fs.add(f);
        f = new FmAllTwenty();
        f.setYs("张三");
        f.setMjzrs("20");
        f.setDy3h("2");
        fs.add(f);
        f = new FmAllTwenty();
        f.setYs("lisi");
        f.setMjzrs("99");
        f.setDy3h("2");

        fs.add(f);
        System.out.println(fs.subList(2, 3));
//        fs.stream().collect(Collectors.groupingBy(FmAllTwenty::getYs,
//                Collectors.summingInt(fall -> Integer.valueOf(fall.getMjzrs())))).forEach((k, v) -> System.out.println(k + " @ " + v));
//        fs.stream().collect(Collectors.groupingBy(FmAllTwenty::getYs,
//                Collectors.summingInt(fall -> Integer.valueOf(fall.getDy3h())))).forEach((k, v) -> System.out.println(k + " @ " + v));
//        Stream.of(c1,c2).flatMap(u->u.values().stream()).collect(Collectors.toList()).forEach(System.out::println);

    }
}
