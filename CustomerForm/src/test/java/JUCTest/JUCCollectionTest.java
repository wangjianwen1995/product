package JUCTest;

import org.junit.jupiter.api.Test;

import java.util.*;


/**
 *  集合线程安全
 */
public class JUCCollectionTest {


    /**
     * 不安全ArrayList--->ConcurrentModificationException 并发修改异常
     */
    @Test
    public void t1(){
        //不安全的
        List<String> list = new ArrayList<>();
        //方法一Vector解决
        //List<String> list = new Vector<>();
        //方法二Collections解决
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        /*
          方法三CopyOnWriteArrayList 解决
             源码分析: 写时复制技术,读数据时候并发读取数据,在写入数据是先 复制一份数据,之后将此数据 覆盖
               final ReentrantLock lock = this.lock;
                lock.lock();
                try {
                    Object[] elements = getArray();
                    int len = elements.length;
                    Object[] newElements = Arrays.copyOf(elements, len + 1);
                    newElements[len] = e;
                    setArray(newElements);
                    return true;
                } finally {
                    lock.unlock();
                }
         */
        //List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(()->{
                list.add(finalI +"sdfsdfsdfdsfsdfsdfsdfsdfsdf".substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();

            //System.out.println(list);
        }
    }


    /**
     * HashSet 线程不安全  ConcurrentModificationException
     *
     *
     */
    @Test
    public void t2(){
        //HashSet 底层是一个 HashMap add 其实就是给k赋值 vlaue 给的是 Object PRESENT = new Object 固定值 所有是不重复 无序的集合
        Set<String> set = new HashSet<>();
        //CopyOnWriteArraySet 解决
        //Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(()->{
                set.add(finalI +"sdfsdfsdfdsfsdfsdfsdfsdfsdf".substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();

            //System.out.println(list);
        }


    }

    /**
     * HashMap 线程不安全  ConcurrentModificationException
     *
     *
     */
    @Test
    public void t3(){
        //HashSet 底层是一个 HashMap add 其实就是给k赋值 vlaue 给的是 Object PRESENT = new Object 固定值 所有是不重复 无序的集合
        Map<String,String> map = new HashMap<>();

        //ConcurrentHashMap 解决
        //Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(()->{
                map.put(finalI +"sdfsdfsdfdsfsdfsdfsdfsdfsdf".substring(0,8),"");
                System.out.println(map);
            },String.valueOf(i)).start();

            //System.out.println(list);
        }


    }


}
