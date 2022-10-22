package com.sxdl.hn.util;

import com.sxdl.base.entity.SysUser;
import com.sxdl.hn.entity.HnBasicInfo;
import com.sxdl.hn.entity.HnQualitydetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyListUtil {

    /**
     *  list 深度拷贝
     * @param src 如题
     * @param <T> 如题

     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }


    /**
     *  obj 深度拷贝
     * @param src 如题
     * @param <T> 如题
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> T deepCopyObj(T src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        T dest = (T) in.readObject();
        return dest;
    }

    /**
     *
     * @param request  用来获取session
     * @param hblUsers 护理部考核人员
     * @return 是否是护理部考核
     */
    public static Integer isHlb(HttpServletRequest request,String hblUsers){
        SysUser user = (SysUser)request.getSession().getAttribute("user");
        String code = user.getCode();
        List<String> list = new ArrayList<>( Arrays.asList(hblUsers.split(",")));
        boolean contains = list.contains(code);
        return contains? 1:-1;

    }


    public static List<String> treeToList(HnQualitydetails node, List<String> list){
        if(list==null){
            list=new ArrayList<String>();
        }
        //设置当前节点的必要数据
        list.add(node.getId().toString());
        //遍历递归子节点
        if(!StringUtils.isEmpty(node.getChildren())){
            for (int i = 0; i < node.getChildren().size(); i++) {
                HnQualitydetails node_= node.getChildren().get(i);
                treeToList(node_,list);
            }
        }
        return list;
    }



    public static List<String> treeToListUp(HnQualitydetails node, List<String> list,Integer state){
        if(list==null){
            list=new ArrayList<String>();
        }
        list.add(node.getId().toString());
        if(StringUtils.isEmpty(node.getPid())){
            return list;
        }
        
        for (HnQualitydetails hnQualitydetails : HNApplicationRunnerImpl.detailsMap.get("details") ) {
            if(hnQualitydetails.getId().equals(node.getPid())){
                treeToListUp(hnQualitydetails,list,state);
            }
        }

        return list;
    }


    public static void main(String[] args) throws Exception{
        List<HnBasicInfo> list  = new ArrayList<>();


    }




}
