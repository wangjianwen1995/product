//package com.sxdl.product.dc.controller;
//
//import cn.hutool.json.JSONUtil;
//import com.sxdl.product.dc.MainTest;
//import com.sxdl.product.dc.entity.DcUser;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.Arrays;
//import java.util.IntSummaryStatistics;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//
//public class DcLogControllerTest extends MainTest {
//
//    //@Disabled
//    @Test
//    public void selectAll() throws Exception {
//        DcUser dcUser = new DcUser();
//        dcUser.setId ( 1 );
//        dcUser.setName ( "admin" );
//        dcUser.setPwd ( "1234" );
//        mockMvc.perform(MockMvcRequestBuilders.get("/log/findAll")//
//                .content ( JSONUtil.toJsonStr (dcUser) )
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect( OK)
//                .andDo( print() );
//    }
//
//    @Test
//    public void findByFactor() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/log/findByFactor")//
//                .param("dctime","1598322314437-1598322591747")
//                .param("level","INFO")
//                .contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect( OK)
//                .andDo( print() );
//    }
//
//    @Disabled
//    @Test
//    public void test(){
//        long m =1597204652364l;
//        long n =1597204591383l;
//        String a = DateUtil.formatTime(m-n);
//        System.out.println(a);
//    }
//
//    @Disabled
//    @Test
//    public void  testLambda(){
//        //Lambda 表达式主要用来定义行内执行的方法类型接口
//        DcLogControllerTest tester  = new DcLogControllerTest();
//        //类型声明
//        MathOperation addition = (int a, int b) -> a + b;
//        //不用类型声明
//        MathOperation subtraction = (a, b) -> a - b;
//        //大括号中的返回语句
//        MathOperation multiplication = (int a, int b) -> {
//            return a* b;
//        };
//        //没有大括号及返回语句
//        MathOperation division = ( int a, int b) -> a/b;
//        System.out.println("10 + 5 = "+ tester.operate(10,5,addition) );
//        System.out.println("10 - 5 = "+ tester.operate(10,5,subtraction));
//        System.out.println("10 * 5 = "+ tester.operate(10,5,multiplication));
//        System.out.println("10 / 5 = "+ tester.operate(10,5,division));
//        //不用括号
//        GreetingService greetService1 = message -> System.out.println("Hello "+ message);
//        //用括号
//        GreetingService greetService2 =(message) -> System.out.println( "Hello "+ message);
//        greetService1.sayMessage("Runoob");
//        greetService2.sayMessage("Google");
//
//
//    }
//    interface MathOperation {
//        int operation(int a, int b);
//    }
//    interface GreetingService {
//        void sayMessage(String message);
//    }
//    private int operate(int a, int b, MathOperation mathOperation) {
//        return mathOperation.operation(a, b);
//    }
//
//    static String salutation = "Hello! ";
//    @Test
//    public void  testLambda1(){
//        GreetingService greetService1 = message ->
//                System.out.println(salutation + message);
//        greetService1.sayMessage("Runoob");
//
//    }
//
//    @FunctionalInterface
//    public  interface Supplier<T>{
//        T get();
//    }
//    //Supplier 是jdk1.8的接口，这里和lamda一起使用了
//    public static  DcLogControllerTest create(final Supplier<DcLogControllerTest> supplier){
//        return supplier.get();
//    }
//    public void collide(final DcLogControllerTest test){
//        System.out.println("Collided "+ test.toString());
//    }
//    public void follow(final DcLogControllerTest another){
//        System.out.println("Follewing the "+ another.toString());
//    }
//
//    public void repair(){
//        System.out.println("Repaired "+this.toString());
//    }
//    @Test
//    public  void testNew(){
//        DcLogControllerTest test = DcLogControllerTest.create(DcLogControllerTest::new);
//        DcLogControllerTest test1 = DcLogControllerTest.create(DcLogControllerTest::new);
//        DcLogControllerTest test2= DcLogControllerTest.create(DcLogControllerTest::new);
//        DcLogControllerTest test3= new DcLogControllerTest();
//
//        List<DcLogControllerTest> tests = Arrays.asList(test,test1,test2,test3);
//        tests.forEach(test::collide);
//
//    }
//    @Test
//    public  void testStream(){
//        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
//        List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
//        System.out.println(strings);
//        System.out.println(filtered);
//        // forEach
//        Random random = new Random();
//        random.ints().limit(2).forEach(System.out::println);
//        //map  //获取对应的平方数
//        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
//        List<Integer> squaresList = numbers.stream().map(i ->i * i).distinct().collect(Collectors.toList());
//        System.out.println(squaresList);
//        //获取空字符串的数量
//        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
//        //sortesd
//        random.ints().limit(5).sorted().forEach(System.out::println);
//        //并行程序
//        int count1 = (int)strings.parallelStream().filter(string -> string.isEmpty()).count();
//        System.out.println( "count: "+ count +";count1:"+ count1);
//
//        //Collections
//        System.out.println("筛选列表："+ filtered);
//
//        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
//        System.out.println("合并字符串：" +mergedString);
//        //统计
//        IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
//        System.out.println("列表中最大的数：" + stats.getMax());
//        System.out.println("列表中最小的数：" + stats.getMin());
//        System.out.println("所有数之和：" + stats.getSum());
//        System.out.println("平均数：" + stats.getAverage());
//
//        String[] strarr = {"abc", "defg", "vwxyz"};
//        int iSum = Arrays.stream(strarr).mapToInt(s -> s.length()).sum();
//        System.out.println("长度和: "+iSum);
//
//    }
//
//}
