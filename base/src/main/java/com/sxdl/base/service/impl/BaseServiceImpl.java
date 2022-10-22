package com.sxdl.base.service.impl;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.context.model.SaRequest;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.dao.BaseDao;
import com.sxdl.base.service.BaseService;
import com.sxdl.base.util.PropertyReflectUtil;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Transient;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
    @Lazy
    @Autowired
    public BaseDao<T> baseDao;
    //    protected Logger logger = LogManager.getLogger(BaseServiceImpl.class);
//    protected List<Map<String, Object>> maps;
//    protected Map<String, Object> map;

    public static Integer valueOf(String param, Integer def) {
        return (null == param || param.isEmpty()) ? def : Integer.valueOf(param);
    }
    public PageInfo<T> queryPageList(PageInfo<T> pageInfo, Object obj) {
        SaRequest request = SaHolder.getRequest();
        Integer pageNum =Integer.valueOf(request.getParam("pageNum",pageInfo.getPageNum()+""));
        Integer pageSize = Integer.valueOf(request.getParam("pageSize",pageInfo.getPageSize()+""));
        PageHelper.startPage(pageNum, pageSize);
        String orderField = request.getParam("sort");
        String orderDirection = request.getParam("order");
        if (StringUtil.isNotEmpty(orderField)) {
            PageHelper.orderBy(orderField);
            if (StringUtil.isNotEmpty(orderDirection)) {
                PageHelper.orderBy(orderField + " " + orderDirection);
            }
        }
        Class<? extends Object> class1 = obj.getClass();
        Example example = new Example(class1);
        example.setOrderByClause("id ASC"); //升序排列，desc为降序排列。
        Example.Criteria criteria = example.createCriteria();
        Field[] fields = class1.getDeclaredFields(); // 获取该类所有属性
        for (Field field : fields) {
            if (field.isAnnotationPresent(Transient.class)) {//字段是瞬态,不参与数据库查询等操作
                continue;
            }
            String name = field.getName();
            Class<?> type = field.getType();
            if (!"serialVersionUID".equals(name)) {
                PropertyDescriptor pd;
                try {
                    pd = new PropertyDescriptor(name, class1);
                    Method getMethod = pd.getReadMethod(); // 获得所有属性的读取方法
                    Object temp = getMethod.invoke(obj); // 执行读取方法，获得属性值
                    if (temp != null && type.getName().equals("java.lang.String")) {
                        criteria.andLike(name, "%" + temp + "%");
                    } else if (temp != null && type.getName().equals("java.lang.Integer")) {
                        criteria.andEqualTo(name, temp);
                    }
                } catch (Exception e) {
//                    logger.error("错误的查询!", e);
                    e.printStackTrace();
                }
            }
        }
        PageInfo pi2 = new PageInfo<T>(baseDao.selectByExample(example));
        pi2.setPageSize(pageInfo.getPageSize());
        pi2.setPageNum(pageInfo.getPageNum());
        return pi2;
    }

    public PageInfo<T> queryPageListDesc(PageInfo<T> pageInfo, Object obj) {
        SaRequest request = SaHolder.getRequest();
        Integer pageNum =Integer.valueOf(request.getParam("pageNum",pageInfo.getPageNum()+""));
        Integer pageSize = Integer.valueOf(request.getParam("pageSize",pageInfo.getPageSize()+""));
        PageHelper.startPage(pageNum, pageSize);
        String orderField = request.getParam("sort");
        String orderDirection = request.getParam("order");
        if (StringUtil.isNotEmpty(orderField)) {
            PageHelper.orderBy(orderField);
            if (StringUtil.isNotEmpty(orderDirection)) {
                PageHelper.orderBy(orderField + " " + orderDirection);
            }
        }
        Class<? extends Object> class1 = obj.getClass();
        Example example = new Example(class1);
        example.setOrderByClause("id DESC"); //升序排列，desc为降序排列。
        Example.Criteria criteria = example.createCriteria();
        Field[] fields = class1.getDeclaredFields(); // 获取该类所有属性
        for (Field field : fields) {
            if (field.isAnnotationPresent(Transient.class)) {//字段是瞬态,不参与数据库查询等操作
                continue;
            }
            String name = field.getName();
            Class<?> type = field.getType();
            if (!"serialVersionUID".equals(name)) {
                PropertyDescriptor pd;
                try {
                    pd = new PropertyDescriptor(name, class1);
                    Method getMethod = pd.getReadMethod(); // 获得所有属性的读取方法
                    Object temp = getMethod.invoke(obj); // 执行读取方法，获得属性值
                    if (temp != null && type.getName().equals("java.lang.String")) {
                        criteria.andLike(name, "%" + temp + "%");
                    } else if (temp != null && type.getName().equals("java.lang.Integer")) {
                        criteria.andEqualTo(name, temp);
                    }
                } catch (Exception e) {
//                    logger.error("错误的查询!", e);
                    e.printStackTrace();
                }
            }
        }
        PageInfo pi2 = new PageInfo<T>(baseDao.selectByExample(example));
        pi2.setPageSize(pageInfo.getPageSize());
        pi2.setPageNum(pageInfo.getPageNum());
        return pi2;
    }

    public PageInfo<T> queryPageListOrderBy(PageInfo<T> pageInfo, Object obj, String column, String orderby) {
        SaRequest request = SaHolder.getRequest();
        Integer pageNum =Integer.valueOf(request.getParam("pageNum",pageInfo.getPageNum()+""));
        Integer pageSize = Integer.valueOf(request.getParam("pageSize",pageInfo.getPageSize()+""));
        PageHelper.startPage(pageNum, pageSize);
        String orderField = request.getParam("sort");
        String orderDirection = request.getParam("order");
        if (StringUtil.isNotEmpty(orderField)) {
            PageHelper.orderBy(orderField);
            if (StringUtil.isNotEmpty(orderDirection)) {
                PageHelper.orderBy(orderField + " " + orderDirection);
            }
        }
        Class<? extends Object> class1 = obj.getClass();
        Example example = new Example(class1);
        example.setOrderByClause(column + " " + orderby); //升序排列，desc为降序排列。
        Example.Criteria criteria = example.createCriteria();
        Field[] fields = class1.getDeclaredFields(); // 获取该类所有属性
        for (Field field : fields) {
            String name = field.getName();
            Class<?> type = field.getType();
            if (!"serialVersionUID".equals(name)) {
                PropertyDescriptor pd;
                try {
                    pd = new PropertyDescriptor(name, class1);
                    Method getMethod = pd.getReadMethod(); // 获得所有属性的读取方法
                    Object temp = getMethod.invoke(obj); // 执行读取方法，获得属性值
                    if (temp != null && type.getName().equals("java.lang.String")) {
                        criteria.andLike(name, "%" + temp + "%");
                    } else if (temp != null && type.getName().equals("java.lang.Integer")) {
                        criteria.andEqualTo(name, temp);
                    }
                } catch (Exception e) {
//                    logger.error("错误的查询!", e);
                    e.printStackTrace();
                }
            }
        }
        PageInfo pi2 = new PageInfo<T>(baseDao.selectByExample(example));
        pi2.setPageSize(pageInfo.getPageSize());
        pi2.setPageNum(pageInfo.getPageNum());
        return pi2;
    }

    public PageInfo<T> queryPageListBuffer(PageInfo<T> pageInfo, Object obj, String columnTime, String starTime, String endTime) {
        SaRequest request = SaHolder.getRequest();
        Integer pageNum =Integer.valueOf(request.getParam("pageNum",pageInfo.getPageNum()+""));
        Integer pageSize = Integer.valueOf(request.getParam("pageSize",pageInfo.getPageSize()+""));
        PageHelper.startPage(pageNum, pageSize);
        String orderField = request.getParam("sort");
        String orderDirection = request.getParam("order");
        if (StringUtil.isNotEmpty(orderField)) {
            PageHelper.orderBy(orderField);
            if (StringUtil.isNotEmpty(orderDirection)) {
                PageHelper.orderBy(orderField + " " + orderDirection);
            }
        }
        Class<? extends Object> class1 = obj.getClass();
        Example example = new Example(class1);
        example.setOrderByClause("id DESC"); //ASC升序排列，desc为降序排列。
        Example.Criteria criteria = example.createCriteria();
        Field[] fields = class1.getDeclaredFields(); // 获取该类所有属性
        for (Field field : fields) {
            String name = field.getName();
            Class<?> type = field.getType();
            if (!"serialVersionUID".equals(name)) {
                PropertyDescriptor pd;
                try {
                    pd = new PropertyDescriptor(name, class1);
                    Method getMethod = pd.getReadMethod(); // 获得所有属性的读取方法
                    Object temp = getMethod.invoke(obj); // 执行读取方法，获得属性值
                    if (temp != null && type.getName().equals("java.lang.String")) {
                        if (temp.toString().startsWith("(==)")) {
                            criteria.andEqualTo(name, temp.toString().substring(4));
                        } else {
                            criteria.andLike(name, "%" + temp + "%");
                        }
                    } else if (temp != null && type.getName().equals("java.lang.Integer")) {
                        criteria.andEqualTo(name, temp);
                    }
                } catch (Exception e) {
//                    logger.error("错误的查询!", e);
                    e.printStackTrace();
                }
            }
        }
        if (StrUtil.isNotEmpty(columnTime) && StrUtil.isNotEmpty(starTime) && StrUtil.isNotEmpty(endTime)) {
            criteria.andBetween(columnTime, starTime, endTime);
        }
        PageInfo pi2 = new PageInfo<T>(baseDao.selectByExample(example));
        pi2.setPageSize(pageInfo.getPageSize());
        pi2.setPageNum(pageInfo.getPageNum());
        return pi2;
    }

    public PageInfo<T> queryPageListByIds(PageInfo<T> pageInfo, Object obj, Integer[] ids) {
        Class<? extends Object> class1 = obj.getClass();
        Example example = new Example(class1);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids));
        return new PageInfo<T>(baseDao.selectByExample(example));
    }

    public Integer insert(T obj) {
        return baseDao.insert(obj);
    }


    public Integer saveSimple(T obj) {
        if (PropertyReflectUtil.getId(obj)){
            return baseDao.insert(obj);
        }else {
            return baseDao.updateByPrimaryKey(obj);
        }

    }

    @Override
    public Integer insertSelective(T obj) {
        return baseDao.insertSelective(obj);
    }

    public Integer update(T obj) {
        return baseDao.updateByPrimaryKey(obj);
    }

    public Integer updateSelective(T obj) {
        return baseDao.updateByPrimaryKeySelective(obj);
    }

    public Integer delete(T obj) {
        return baseDao.delete(obj);
    }

    @Override
    public Integer deleteById(Object id) {
        return baseDao.deleteByPrimaryKey(id);
    }

    public T findById(Object id) {
        return baseDao.selectByPrimaryKey(id);
    }

    public List<T> findAll() {
        return baseDao.selectAll();
    }

    public List<T> select(T t) {
        return baseDao.select(t);
    }

    @Override
    public T selectOne(T t) {
        return baseDao.selectOne(t);
    }

    @Override
    public T selectByKey(Object o) {
        return baseDao.selectByPrimaryKey(o);
    }

    @Override
    public int updateSqlWithSQL(String sql) {
        return baseDao.updateSqlWithSQL(sql);
    }

    @Override
    public List<Map<String, Object>> selectSqlWithSQL(String sql) {
        return baseDao.selectSqlWithSQL(sql);
    }

    @Override
    public List<T> selectListWithSQL(String sql, Class<T> c) {
        List<Map<String, Object>> maps = baseDao.selectSqlWithSQL(sql);
        List<T> list = new ArrayList<>();
        maps.forEach(e -> list.add(JSON.parseObject(JSON.toJSONString(e), c)));
        return list;
    }
    @Override
    public PageInfo<T> selectPageinfoWithSQL(String colums, String fromAndWhere, String order, PageInfo p, boolean isDesc) {
        String sql = SQLPackageUtil.getPageSQL(colums, fromAndWhere, order, p, isDesc);
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        long cnt = selectCountWithSQL(fromAndWhere);
        p.setList(maps);
        p.setTotal(cnt);
        return p;
    }
    @Override
    public PageInfo<T> selectPageinfoWithSQL(Class<T> c,String colums, String fromAndWhere, String order, PageInfo p, boolean isDesc) {
        String sql = SQLPackageUtil.getPageSQL(colums, fromAndWhere, order, p, isDesc);
        List<T> ts = selectListWithSQL(sql, c);
        long cnt = selectCountWithSQL(fromAndWhere);
        p.setList(ts);
        p.setTotal(cnt);
        return p;
    }
    @Override
    public Long selectCountWithSQL(String fromAndWhere) {
        String sql = SQLPackageUtil.getCountSQL(fromAndWhere);
        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
        return Long.parseLong(maps.get(0).get("cnt").toString());
    }

    @Override
    public Integer addColumnOfIntToTable(String tableName, String column) {
        return baseDao.addColumnOfIntToTable(tableName, column);
    }

    @Override
    public Integer addColumnOfStringToTable(String tableName, String column, Integer colLength) {
        return baseDao.addColumnOfStringToTable(tableName, column, colLength);
    }

    @Override
    public Integer deleteColumnFromTable(String tableName, String columnName) {
        return baseDao.deleteColumnFromTable(tableName, columnName);
    }

    @Override
    public String getColumnsFromOneTable(String name) {
        return baseDao.getColumnsFromOneTable(name);
    }

    @Override
    public List<Map<String, Object>> excuteProcedue(String pname) {
        return baseDao.excuteProcedue(pname);
    }


    @Override
    public List<Map<String, Object>> excuteProcedueWithParams(String pname, String start, String end) {
        return baseDao.excuteProcedueWithParams(pname, start, end);
    }

    @Override
    public List<LinkedHashMap> execAllData(String tablename) {
        List<LinkedHashMap> list = new ArrayList<>();
        LinkedHashMap linkedmap = null;

        List<LinkedHashMap> linkedHashMaps = baseDao.selectAllTableData(tablename);
        List<String> dtjmybDRG = baseDao.selectAllTableColumns(tablename);
        for (LinkedHashMap map : linkedHashMaps) { //遍历数据库中的数据
            linkedmap = new LinkedHashMap();
            for (String str : dtjmybDRG) {
                if (!map.containsKey(str)) {
                    linkedmap.put(str, null);
                } else {
                    linkedmap.put(str, map.get(str));
                }

            }
            list.add(linkedmap);
        }
        return list;
    }

    @Override
    public List<LinkedHashMap<String, Object>> execAllData2(String tablename) {
        List<LinkedHashMap<String, Object>> list = new ArrayList<>();
        LinkedHashMap linkedmap = null;

        List<LinkedHashMap<String, Object>> linkedHashMaps = baseDao.selectAllTableData2(tablename);
        List<String> dtjmybDRG = baseDao.selectAllTableColumns(tablename);
        for (LinkedHashMap map : linkedHashMaps) { //遍历数据库中的数据
            linkedmap = new LinkedHashMap();
            for (String str : dtjmybDRG) {
                if (!map.containsKey(str)) {
                    linkedmap.put(str, null);
                } else {
                    linkedmap.put(str, map.get(str));
                }

            }
            list.add(linkedmap);
        }
        return list;
    }


    /**
     * null xiu改成空字符串
     *
     * @param tablename 如题
     */
    @Override
    public List<LinkedHashMap<String, Object>> execAllData3(String tablename) {
        List<LinkedHashMap<String, Object>> list = new ArrayList<>();
        LinkedHashMap linkedmap = null;
        List<LinkedHashMap<String, Object>> linkedHashMaps = baseDao.selectAllTableData2(tablename);
        List<String> dtjmybDRG = baseDao.selectAllTableColumns(tablename);
        for (LinkedHashMap map : linkedHashMaps) { //遍历数据库中的数据
            linkedmap = new LinkedHashMap();
            for (String str : dtjmybDRG) {
                if (!map.containsKey(str)) {
                    linkedmap.put(str, "");
                } else {
                    linkedmap.put(str, map.get(str).toString());
                }
            }
            list.add(linkedmap);
        }
        return list;
    }


    /**
     * null xiu改成空字符串 并且KEY大写转小写 toLowerCase()
     *
     * @param tablename 如题
     */
    @Override
    public List<LinkedHashMap<String, Object>> execAllData4(String tablename) {
        List<LinkedHashMap<String, Object>> list = new ArrayList<>();
        LinkedHashMap linkedmap = null;
        List<LinkedHashMap<String, Object>> linkedHashMaps = baseDao.selectAllTableData2(tablename);
        List<String> dtjmybDRG = baseDao.selectAllTableColumns(tablename);
        for (LinkedHashMap map : linkedHashMaps) { //遍历数据库中的数据
            linkedmap = new LinkedHashMap();
            for (String str : dtjmybDRG) {
                if (!map.containsKey(str)) {
                    linkedmap.put(str.toLowerCase(), "");
                } else {
                    linkedmap.put(str.toLowerCase(), map.get(str).toString());
                }
            }
            list.add(linkedmap);
        }
        return list;
    }


    @Override
    public List<LinkedHashMap> selectAllTableData(String tablename) {
        List<LinkedHashMap> linkedHashMaps = baseDao.selectAllTableData(tablename);
        return linkedHashMaps;
    }

    @Override
    public List<LinkedHashMap<String, Object>> selectAllTableData2(String tablename) {
        List<LinkedHashMap<String, Object>> linkedHashMaps = baseDao.selectAllTableData2(tablename);
        return linkedHashMaps;
    }

    @Override
    public void deleteList(List<T> list) {
        list.forEach(e -> baseDao.delete(e));
    }

    @Override
    public List<LinkedHashMap<String, Object>> getDataBySql(String sql) {
        return baseDao.getDataBySql(sql);
    }


    String ifExistsThenDropsql;
    /**
     * 如果数据库中存在表则删除
     */
    @Override
    public void ifExistsTableThenDrop(String name){
        ifExistsThenDropsql= SQLPackageUtil.generateIfExistsThenDropSql(name," table ");
        selectSqlWithSQL(ifExistsThenDropsql);
    }
    /**
     * 如果数据库中存在存储过程则删除
     */
    @Override
    public void ifExistsProcureThenDrop(String name){
        ifExistsThenDropsql=SQLPackageUtil.generateIfExistsThenDropSql(name," PROCEDURE ");
        selectSqlWithSQL(ifExistsThenDropsql);
    }
    /**
     * 如果数据库中存在视图则删除
     */
    @Override
    public void ifExistsViewThenDrop(String name){
        ifExistsThenDropsql=SQLPackageUtil.generateIfExistsThenDropSql(name," view ");
        selectSqlWithSQL(ifExistsThenDropsql);
    }
    /**
     * 如果数据库中存在临时表则删除
     */
    @Override
    public void ifExistsTempTableThenDrop(String name){
        ifExistsThenDropsql="if object_id('tempdb.."+name+"') is not null Begin drop table "+name+" End";
        selectSqlWithSQL(ifExistsThenDropsql);
    }


    public  static<E> E convert(Object obj, Class<E> type) {

        if (obj != null && !StringUtils.isEmpty(obj.toString())) {
            if (type.equals(Integer.class)||type.equals(int.class)) {
                return (E)new Integer(obj.toString());
            } else if (type.equals(Long.class)||type.equals(long.class)) {
                return (E)new Long(obj.toString());
            } else if (type.equals(Boolean.class)||type.equals(boolean.class)) {
                return (E) new Boolean(obj.toString());
            } else if (type.equals(Short.class)||type.equals(short.class)) {
                return (E) new Short(obj.toString());
            } else if (type.equals(Float.class)||type.equals(float.class)) {
                return (E) new Float(obj.toString());
            } else if (type.equals(Double.class)||type.equals(double.class)) {
                return (E) new Double(obj.toString());
            } else if (type.equals(Byte.class)||type.equals(byte.class)) {
                return (E) new Byte(obj.toString());
            } else if (type.equals(Character.class)||type.equals(char.class)) {
                return (E)new Character(obj.toString().charAt(0));
            } else if (type.equals(String.class)) {
                return (E) obj.toString();
            } else if (type.equals(BigDecimal.class)) {
                return (E) new BigDecimal(obj.toString());
            } else if (type.equals(LocalDateTime.class)) {
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                return (E) LocalDateTime.parse(obj.toString());
            }  else{
                return null;
            }
        } else {
            if (type.equals(int.class)) {
                return (E)new Integer(0);
            } else if (type.equals(long.class)) {
                return (E)new Long(0L);
            } else if (type.equals(boolean.class)) {
                return (E)new Boolean(false);
            } else if (type.equals(short.class)) {
                return (E)new Short("0");
            } else if (type.equals(float.class)) {
                return (E) new Float(0.0);
            } else if (type.equals(double.class)) {
                return (E) new Double(0.0);
            } else if (type.equals(byte.class)) {
                return (E) new Byte("0");
            } else if (type.equals(char.class)) {
                return (E) new Character('\u0000');
            }else if (type.equals(String.class)) {
                return (E) "";
            }else {
                return null;
            }
        }
    }
}
