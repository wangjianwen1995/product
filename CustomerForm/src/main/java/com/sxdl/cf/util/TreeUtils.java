package com.sxdl.cf.util;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * 数据列表转换成树列表工具类
 */
public class TreeUtils {

    /**
     * 将含父子关系的类列表进行子列表属性设置并最高级的类列表(如分类树parentId为null时为一级分类，则取设置完子列表的parentId为null的分类列表)
     *
     * @param list           元素列表
     * @param idGetter       类唯一标识id getter function
     * @param parentIdGetter 类的父id标识 getter function
     * @param sonsGetter     类的子元素列表属性getter function
     * @param sonsSetter     类的子元素列表属性setter function
     * @param ancestorVal    最高级的parentId值
     * @param <K>            父子标识属性类型
     * @param <T>            对象类型
     */
   public static <K, T> List<T> tree(List<T> list, Function<T, K> idGetter, Function<T, K> parentIdGetter,
                                     Function<T, List<T>> sonsGetter, BiConsumer<T, List<T>> sonsSetter, K ancestorVal) {
        // ① 将对象列表以对象id、对象转为映射
        Map<K, T> idMap = ListUtils.collectToMap(list, idGetter);

        // 最高级的元素列表映射, id最高级元素的父标识(parentId)值，value为最高级元素列表
        Map<K, List<T>> ancestorMap = new HashMap<> (1);
        // ②
        list.forEach(each -> {
            // 获取当前对象的父id
            K parentId = parentIdGetter.apply(each);
            // 父id为最高级的标识值则放入ancestorMap中
            if (Objects.equals(parentId, ancestorVal)) {
                ancestorMap.compute(ancestorVal,
                        (key, parentList) -> parentList == null ? Lists.newArrayList(each) : ListUtils.add(parentList, each));
            } else {
                // 获取当前对象的父关系对象
                T parent = idMap.get(parentId);
                // 获取当前对象的父关系对象下的子对象列表，并向列表中添加当前对象
                List<T> parentSons = sonsGetter.apply(parent);
                if (parentSons == null) {
                    sonsSetter.accept(parent, Lists.newArrayList(each));
                } else {
                    sonsGetter.apply(parent).add(each);
                }
            }
        });
       // System.out.println (ancestorVal);
        // 返回最高级元素列表
        return ancestorMap.get(ancestorVal);
    }
//    public static void main(String[] args) {
//        List<SysMenu> totalList = new ArrayList<> (16);
//
//
//
//        totalList.add(buildClassify(1, null, "classify-L1-A"));
//        totalList.add(buildClassify(2, null, "classify-L1-B"));
//        totalList.add(buildClassify(3, null, "classify-L1-C"));
//        totalList.add(buildClassify(4, null, "classify-L1-D"));
//        totalList.add(buildClassify(11, 1, "classify-L2-parent1-A"));
//        totalList.add(buildClassify(12, 1, "classify-L2-parent1-B"));
//        totalList.add(buildClassify(13, 1, "classify-L2-parent1-C"));
//        totalList.add(buildClassify(21, 2, "classify-L2-parent2-A"));
//        totalList.add(buildClassify(22, 2, "classify-L2-parent2-B"));
//        totalList.add(buildClassify(41, 4, "classify-L2-parent4-A"));
//        totalList.add(buildClassify(42, 4, "classify-L2-parent4-B"));
//        totalList.add(buildClassify(211, 21, "classify-L3-parent21-A"));
//        totalList.add(buildClassify(212, 21, "classify-L3-parent21-B"));
//        //public interface Comparator<T> ---> int compare(T o1, T o2);
//        Comparator<Integer> comparator2 = (a , b)->Integer.compare(a,b);
//        Comparator<Integer> comparator = Integer::compare;
//
//        // public interface Function<T, R>  --> R apply(T t);
//        Function<SysMenu, Integer> getIds = sysMenu->sysMenu.getId();
//        Function<SysMenu, Integer> getId = SysMenu::getId;
//
//        List<SysMenu> levelOneList = tree(totalList, SysMenu::getId, SysMenu::getParent_code, SysMenu::getChildren,
//                SysMenu::setChildren, null);
//        levelOneList.forEach(System.out::println);
//    }
//    private static SysMenu buildClassify(Integer id, Integer parentId, String name) {
//        SysMenu menu = new SysMenu();
//        menu.setId(id);
//        menu.setParent_code(parentId);
//        menu.setName (name);
//        return menu;
//    }
}
