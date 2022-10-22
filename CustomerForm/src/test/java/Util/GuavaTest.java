package Util;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GuavaTest {

    @Test
    public void Test()  {

        Splitter on = Splitter.on(",");
        List<String> list = on.splitToList("a,b,b,b,b,b,b,bc,c,c");

    }

    /**
     * 集合快读创建  Lists  / Sets  Maps
     */
    @Test
    public void Test2()  {
        ArrayList<HashMap<Object, Object>> lists = Lists.newArrayList(new HashMap<>(), new HashMap<>(), new HashMap<>(), new HashMap<>());
        //对集合进行分组
        List<List<HashMap<Object, Object>>> partition = Lists.partition(lists, 2);


        List<TDBO> list = new ArrayList<>();
        list.add(new TDBO().setId(1).setName("名称1"));
        list.add(new TDBO().setId(2).setName("名称2"));
        list.add(new TDBO().setId(3).setName("名称3"));
        list.add(new TDBO().setId(4).setName("名称4"));

        //list 数据反转
        List<TDBO> reverse = Lists.reverse(list);

        System.out.println(reverse);


    }

    @Data
    @Accessors(chain=true)
    class TDBO{
        private Integer id;
        private String name;
    }



    @Data
    @Accessors(chain=true)
    class TDBO2{
        private String name;
        private String code;
    }
}
