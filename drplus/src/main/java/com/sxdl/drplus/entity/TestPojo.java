package com.sxdl.drplus.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Properties;

@Entity
@Data
@Table(name="jobs")
@Accessors(chain = true) //set链式编程
public class TestPojo {


    private static final long serialVersionUID = 1L;


    @Id
    /**
     * SQLSERVER	SELECT SCOPE_IDENTITY() 这是主键回显策略,没有针对NEWSEQUENTIALID()的回显, 这里dao 使用sqlserverMapper就ok
        因此 插入数据主键不能回显
     */
   // @GeneratedValue(strategy = GenerationType.IDENTITY)

    //@KeySql(dialect = IdentityDialect.SQLSERVER)
/*    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @KeySql(dialect = IdentityDialect.SQLSERVER)*/

    private String id;

    private String account;

    private String password;

    @Version
    private Integer version=0;
/*
    final  static String TPREFIX ;


    static {
        Properties properties = new Properties();
        //把一个properties读进来
        TPREFIX = properties.getProperty("TablePrefix");

    }*/
}
