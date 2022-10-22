package com.dlong.util;

import java.sql.*;

public class JDBCtest {


    /**
     * 启用单例模式
     * @param args
     */
    public static void main(String[] args) {
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=demo";
        String username="sa";
        String password="sa";

        Connection connection =null;
        Statement statement =null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from course");
            ResultSetMetaData metaData = resultSet.getMetaData();

            String columnName = "";

            while(resultSet.next()) {//rs.next();  OK
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    columnName = metaData.getColumnName(i + 1);
                    System.out.print(resultSet.getString(columnName)+"  ");
                }
            }
            System.out.println("-=----");
            statement.executeUpdate("select * into ttt from course1");


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
