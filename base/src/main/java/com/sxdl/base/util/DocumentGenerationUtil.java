package com.sxdl.base.util;

import cn.smallbun.screw.core.Configuration;
import cn.smallbun.screw.core.engine.EngineConfig;
import cn.smallbun.screw.core.engine.EngineFileType;
import cn.smallbun.screw.core.engine.EngineTemplateType;
import cn.smallbun.screw.core.execute.DocumentationExecute;
import cn.smallbun.screw.core.process.ProcessConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * 数据库文档生成工具
 */
public class DocumentGenerationUtil {

    public static void main(String[] args) {
        ArrayList<String> designatedTableNames=new ArrayList<>();
        designatedTableNames.add("hp_tjhzmx");
        designatedTableNames.add("hp_tjzkmx");
        designatedTableNames.add("hp_rz_mz");
        documentGeneration(3, "jdbc:sqlserver://140.143.190.251:1433;databaseName=dl_hp",
                "sa", "ckboar123!@#", "C:\\Users\\Administrator\\Desktop",
                "住院日志和门诊日志",designatedTableNames,new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }

    public static String getJDBCClassName(Integer type) {
        String classname = "com.mysql.cj.jdbc.Driver";
        switch (type) {
            case 1:
                break;
            case 2:
                classname = "com.mysql.jdbc.Driver";
                break;
            case 3:
                classname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                break;
            case 4:
                classname = "oracle.jdbc.driver.OracleDriver";
                break;
            case 5:
                classname = "org.postgresql.Driver";
                break;
        }
        return classname;
    }

    /**
     * 文档生成
     *
     * @param type                   1 mysql8-;2 mysql8+;3 sqlserver;4 oracle;5 postgre
     * @param jdbcurl                url
     * @param username               name
     * @param pw                     password
     * @param fileOutputDir          输出文件路径
     * @param fileName               输出文件名称
     * @param designatedTableNames   根据名称指定表生成
     * @param designatedTablePrefixs 根据表前缀生成
     * @param designatedTableSuffixs 根据表后缀生成
     * @param ignoreTableNames       忽略表名
     * @param ignoreTablePrefixs     忽略表前缀
     * @param ignoreTableSuffixs     忽略表后缀
     */
    public static void documentGeneration(Integer type, String jdbcurl, String username, String pw,
                                          String fileOutputDir, String fileName,
                                          ArrayList<String> designatedTableNames,
                                          ArrayList<String> designatedTablePrefixs,
                                          ArrayList<String> designatedTableSuffixs,
                                          ArrayList<String> ignoreTableNames,
                                          ArrayList<String> ignoreTablePrefixs,
                                          ArrayList<String> ignoreTableSuffixs) {

        //数据源
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(getJDBCClassName(type));
        hikariConfig.setJdbcUrl(jdbcurl);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(pw);
        //设置可以获取tables remarks信息
        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
        hikariConfig.setMinimumIdle(2);
        hikariConfig.setMaximumPoolSize(5);
        DataSource dataSource = new HikariDataSource(hikariConfig);
        //生成配置
        EngineConfig engineConfig = EngineConfig.builder()
                //生成文件路径
                .fileOutputDir(fileOutputDir)
                //打开目录
                .openOutputDir(true)
                //文件类型
                .fileType(EngineFileType.HTML)
                //生成模板实现
                .produceType(EngineTemplateType.freemarker)
                //自定义文件名称
                .fileName(fileName).build();

        //忽略表
//        ArrayList<String> ignoreTableName = new ArrayList<>();
//        ignoreTableName.add("test_user");
//        ignoreTableName.add("test_group");
//        //忽略表前缀
//        ArrayList<String> ignorePrefix = new ArrayList<>();
//        ignorePrefix.add("test_");
//        //忽略表后缀
//        ArrayList<String> ignoreSuffix = new ArrayList<>();
//        ignoreSuffix.add("_test");
        ProcessConfig processConfig = ProcessConfig.builder()
                //指定生成逻辑、当存在指定表、指定表前缀、指定表后缀时，将生成指定表，其余表不生成、并跳过忽略表配置
                //根据名称指定表生成
                .designatedTableName(designatedTableNames)
                //根据表前缀生成
                .designatedTablePrefix(designatedTablePrefixs)
                //根据表后缀生成
                .designatedTableSuffix(designatedTableSuffixs)
                //忽略表名
                .ignoreTableName(ignoreTableNames)
                //忽略表前缀
                .ignoreTablePrefix(ignoreTablePrefixs)
                //忽略表后缀
                .ignoreTableSuffix(ignoreTableSuffixs).build();
        //配置
        Configuration config = Configuration.builder()
                //版本
                .version("1.0.0")
                //描述
                .description(fileName)
                //数据源
                .dataSource(dataSource)
                //生成配置
                .engineConfig(engineConfig)
                //生成配置
                .produceConfig(processConfig)
                .build();
        //执行生成
        new DocumentationExecute(config).execute();
    }
}
