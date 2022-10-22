package com.sxdl.ae.service.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxdl.ae.dao.MapperDao;
import com.sxdl.base.util.PropertyReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

@Transactional
public class MapperService<T> {
    @Autowired
    public MapperDao<T> baseDao;


    public void execSqlText(String sql) {
        baseDao.execSqlText(sql);
    }
    public Integer saveSimple(T obj) throws Exception{
        if (PropertyReflectUtil.getId(obj)){
            return baseDao.insert(obj);
        }else {
            return baseDao.updateByPrimaryKey(obj);
        }

    }

    public void dropTable(String name) {
        baseDao.dropTable(name);
    }


    public PageInfo<T> selectListPage(PageInfo<T> pageInfo, String sql) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo<T> list = new PageInfo( baseDao.selectListObj(sql));
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }

    public PageInfo<T> selectListPage(PageInfo<T> pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageInfo<T> list = new PageInfo( baseDao.selectAll());
        list.setPageSize(pageInfo.getPageSize());
        list.setPageNum(pageInfo.getPageNum());
        return list;
    }

    public Integer insert(T obj) {
        return baseDao.insert(obj);
    }


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


    public T selectOne(T t) {
        return baseDao.selectOne(t);
    }


    public T selectByKey(Object o) {
        return baseDao.selectByPrimaryKey(o);
    }



    public List<T> selectListObj(String sql ) {
        return baseDao.selectListObj(sql);
    }



    public Integer addField(String tableName, String column) {
        return baseDao.addField(tableName, column);
    }



    public Integer delField(String tableName, String columnName) {
        return baseDao.delField(tableName, columnName);
    }

    public String selectField(String name) {
        return baseDao.selectField(name);
    }




    public List<LinkedHashMap<String, Object>> selectListLinkedMap(String sql) {
        return baseDao.selectListLinkedMap(sql);
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

    public String selectString( String sql) {
        return baseDao.selectString(sql);

    }


    public Integer selectInteger( String sql){
        return baseDao.selectInteger(sql);
    }

}
