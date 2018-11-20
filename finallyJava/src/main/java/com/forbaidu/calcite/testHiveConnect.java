package com.forbaidu.calcite;

/**
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 *
 * @Author: lvliangliang@baidu.com
 * @Description：
 * @DATE: 2018/8/2
 */

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.calcite.adapter.jdbc.JdbcSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.commons.dbcp.BasicDataSource;

public class testHiveConnect {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        Connection connection = DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);
        SchemaPlus rootSchema = calciteConnection.getRootSchema();

        Class.forName("org.apache.hive.jdbc.HiveDriver");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:hive2://10.64.29.108:10000");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");

        Schema schema = JdbcSchema.create(rootSchema, "temp", dataSource, null, "temp");
        rootSchema.add("temp", schema);

        Statement statement = calciteConnection.createStatement();

        String sql1 = "select count(*) from hr.emps";
        String sql11 = "select name from hr.emps";
        String sql2 = "desc hr.emps";
        String sql3 = "exec sp_pkeys 'hr.emps'";
        String sql4 = "select TABLE_NAME,COLUMN_NAME from information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME='emps'";
        String sql5 = "show index from hr.emps";
        String sql6 = "select COLUMN_NAME,DATA_TYPE,CHARACTER_MAXIMUM_LENGTH from information_schema.COLUMNS where "
                + "TABLE_NAME='emps'";
        String sql7 = "select * from temp";

        ResultSet resultSet = statement.executeQuery(sql7);
        output(resultSet, System.out);
        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void output(ResultSet resultSet, PrintStream out) throws SQLException {
        final ResultSetMetaData metaData = resultSet.getMetaData();
        final int columnCount = metaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1;; i++) {
                out.print(resultSet.getString(i));
                if (i < columnCount) {
                    out.print(", ");
                } else {
                    out.println();
                    break;
                }
            }
        }
    }
}
