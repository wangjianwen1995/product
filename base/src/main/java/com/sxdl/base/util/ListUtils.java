package com.sxdl.base.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Hui
 * @version 1.0
 */
public class ListUtils {
    private ListUtils() {
    }

    public static <T> List<T> add(List<T> list, T t) {
        list.add(t);
        return list;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<>(elements.length + elements.length >> 1 + 5);
        Collections.addAll(list, elements);
        return list;
    }

    /**
     * 条件为true时才添加元素
     *
     * @param condition  条件
     * @param collection 集合
     * @param val 如题
     * @return 添加结果
     */
    public static <T> boolean addIf(boolean condition, Collection<T> collection, T val) {
        return condition && collection.add(val);
    }

    /**
     * 从对象列表中提取对象属性
     *
     * @param list      对象列表
     * @param valGetter 对象属性get方法
     * @param <T>       对象
     * @param <V>       对象属性
     * @return 对象属性列表
     */
    public static <T, V> List<V> collectToList(Collection<T> list, Function<T, V> valGetter) {
        List<V> properties = new ArrayList<>(list.size());
        list.forEach(e -> properties.add(valGetter.apply(e)));
        return properties;
    }

    /**
     * 从对象列表中提取指定属性为key,当前对象为value转为map
     *
     * @param list 如题
     * @param keyGetter 如题
     * @param <T> 如题
     * @param <K> 如题
     */
    public static <T, K> Map<K, T> collectToMap(Collection<T> list, Function<T, K> keyGetter) {
        Map<K, T> propertiesMap = new HashMap<>(list.size());
        list.forEach(e -> propertiesMap.put(keyGetter.apply(e), e));
        return propertiesMap;
    }

    /**
     * 从对象列表中提取指定属性T为key,属性V为value转为map
     *
     * @param list      对象列表
     * @param keyGetter  如题
     * @param valGetter 如题
     * @param <T> 如题
     * @param <K> 如题
     * @param <V> 如题
     */
    public static <T, K, V> Map<K, V> collectToMap(Collection<T> list, Function<T, K> keyGetter, Function<T, V> valGetter) {
        Map<K, V> propertiesMap = new HashMap<> (list.size());
        list.forEach(e -> propertiesMap.put(keyGetter.apply(e), valGetter.apply(e)));
        return propertiesMap;
    }

    /**
     * 根据列表对象中的某属性值为key划分列表,value为key的属性值相同的对象列表,
     * 功能同stream().collect(Collectors.groupingBy())
     *
     * @param list 如题
     * @param keyGetter 如题
     * @param <T> 如题
     * @param <K> 如题
     */
    public static <T, K> Map<K, List<T>> groupToMap(Collection<T> list, Function<T, K> keyGetter) {
        Map<K, List<T>> propertiesMap = new HashMap<>(list.size());
        for (T each : list) {
            propertiesMap.compute(keyGetter.apply(each),
                    (key, valueList) -> isEmpty(valueList) ? add(new ArrayList<> (list.size()), each) : add(valueList, each));
        }
        return propertiesMap;
    }

    /**
     * 根据列表对象中的某属性值为key划分列表,value为key的属性值相同的对象列表,value为key的属性值相同的对象中指定属性的值列表,
     * 功能同stream().collect(Collectors.groupingBy())
     *
     * @param list 如题
     * @param keyGetter 如题
     * @param valGetter 如题
     * @param <T> 如题
     * @param <K> 如题
     * @param <V> 如题
     */
    public static <T, K, V> Map<K, List<V>> groupToMap(Collection<T> list, Function<T, K> keyGetter, Function<T, V> valGetter) {
        Map<K, List<V>> propertiesMap = new HashMap<>(list.size());
        for (T each : list) {
            K key = keyGetter.apply(each);
            List<V> values = Optional.ofNullable(propertiesMap.get(key)).orElse(new ArrayList<>());
            values.add(valGetter.apply(each));
            propertiesMap.put(key, values);
        }
        return propertiesMap;
    }

    /**
     * 获取列表中重复的值
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Set<T> collectRepeats(Collection<T> list) {
        Set<T> set = new HashSet<>(list.size());
        return list.stream()
                .filter(e -> !set.add(e))
                .collect( Collectors.toSet());
    }

    /**
     * 按指定大小，分隔集合，将集合按规定个数分为n个部分
     *
     * @param <T>
     * @param list
     * @param len
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int len) {
        if (list == null || list.isEmpty() || len < 1) {
            return Collections.emptyList();
        }
        List<List<T>> result = new ArrayList<>();

        int size = list.size();
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }

}