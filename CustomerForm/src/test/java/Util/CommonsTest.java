package Util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CommonsTest {

    /**
     * apache.commons 工具类测试
     */
    @Test
    public void test4(){

        // null "" "   "

        System.out.println("开始:"+ StringUtils.isBlank("   "));
        System.out.println(StringUtils.isNotBlank("   "));
        System.out.println(StringUtils.isEmpty("   "));
        System.out.println(StringUtils.isNotEmpty("   "));

        System.out.println(CollectionUtils.isEmpty(new HashSet()));
        System.out.println(CollectionUtils.isEmpty(null));
        System.out.println(CollectionUtils.isNotEmpty(new ArrayList()));

        Map<String,Object> hashMap = new HashMap();
        System.out.println(MapUtils.isEmpty(null));
        System.out.println(MapUtils.isEmpty(new HashMap()));
        System.out.println(MapUtils.isEmpty(hashMap));


        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        List<String> list2 = new ArrayList<>();
        list2.add("c");
        list2.add("e");
        list2.add("f");

        //交集
        System.out.println("交集:"+CollectionUtils.intersection(list1, list2));
        //并集
        System.out.println("并集:"+CollectionUtils.union(list1, list2));
        //差集
        System.out.println("并集:"+CollectionUtils.subtract(list1, list2));
    }


    @Test
    public void IOTest() throws IOException {

        String path="D:\\my_product\\SpringBootProduct\\cf\\src\\main\\resources\\tableCU.sql";
        String string = FileUtils.readFileToString(new File(path), "utf-8");
        System.out.println(string);


    }
}
