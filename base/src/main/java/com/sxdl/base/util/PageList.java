package com.sxdl.base.util;


import cn.hutool.core.util.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageList {
    /**
     * 将list数据,按照分页要求切割
     * @param pageNum  当前页数
     * @param pageSize 每页得大小
     * @param list     分页的对象
     */
    public static Map<String, Object> getListPage(int pageNum, int pageSize, List list) {
        if (list == null || list.size () == 0) {
            return new HashMap<> ();
        }
        int[] sne= PageUtil.transToStartEnd(pageNum-1,pageSize);
        int s=sne[0];
        int e=sne[1];
        int totalCount = list.size ();
        Map<String, Object> map = new HashMap<> ();
        map.put ( "total", list.size () );
        map.put ( "pageNum", pageNum );
        if(s>totalCount){
            map.put ( "list", new ArrayList<> () );
            return map;
        }
        if(e>totalCount){
            e=totalCount;
        }
        map.put ( "list", list.subList ( s, e ) );
        return map;
    }

    /**
     * 将list数据,按照分页要求切割
     * @param page 分页信息
     * @param list 列表数据
     * @return 分页后的列表
     */
    public static Map<String, Object> getListPage(PageInfo page, List list) {
        return getListPage(page.getPageNum(),page.getPageSize(),list);
    }

    public static PageInfo getListPage1(PageInfo page, List list) {
        if (list == null || list.size () == 0) {
            return page;
        }
        int[] sne= PageUtil.transToStartEnd(page.getPageNum()-1,page.getPageSize());
        int s=sne[0];
        int e=sne[1];
        int totalCount = list.size ();
        page.setTotal ( list.size () );

        if(s>totalCount){
            page.setList (list=new ArrayList<> ());

            return page;
        }
        if(e>totalCount){
            e=totalCount;
        }
        page.setList (list.subList ( s, e ));
        return page;
    }

}

