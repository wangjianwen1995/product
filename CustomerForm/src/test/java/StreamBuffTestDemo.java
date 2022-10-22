import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBuffTestDemo {

    @Test
    public void t1() throws IOException, ClassNotFoundException {
        List<LinkedHashMap<String, Object>> streamArray = new ArrayList<>();
        LinkedHashMap<String, Object> l = new LinkedHashMap<String, Object>();
        l.put("1",1);
        l.put("2",2);
        l.put("3",3);
        streamArray.add(l);

        Stream<LinkedHashMap<String, Object>> stream1 = streamArray.stream();
        Stream<LinkedHashMap<String, Object>> stream2 = streamArray.stream();
        Stream<LinkedHashMap<String, Object>> stream3 = streamArray.stream();
        List<Stream<LinkedHashMap<String, Object>>> streamList = Arrays.asList(stream1,stream2,stream3);
        Stream<LinkedHashMap<String, Object>>[] streams = streamList.toArray(new Stream[0]);
        System.out.println(streams.length);
        Stream<LinkedHashMap<String, Object>> stream = streams[0];
        List<LinkedHashMap<String, Object>> collect = stream.collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void t2(){
        String s = null,g = null,f="sss";
        System.out.println(s+g+f);
    }
}
