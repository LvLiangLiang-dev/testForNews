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

public class testMysqlConnect {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        Connection connection = DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);
        SchemaPlus rootSchema = calciteConnection.getRootSchema();

        // 本地Schema.
        // Schema schema = ReflectiveSchema.create(calciteConnection, rootSchema, "hr",
        // new HrSchema());

        Class.forName("com.mysql.jdbc.Driver");
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/information_schema");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

//        Schema schema = JdbcSchema.create(rootSchema, "hr", dataSource, null, "hr");
//        rootSchema.add("hr", schema);

        Schema schema = JdbcSchema.create(rootSchema, "information_schema", dataSource, null, "information_schema");
        rootSchema.add("information_schema", schema);

        Statement statement = calciteConnection.createStatement();

        String sql1 = "select count(*) from hr.emps";
        String sql11 = "select name from hr.emps";
        String sql2 = "desc hr.emps";
        String sql3 = "exec sp_pkeys 'hr.emps'";
        String sql4 = "select TABLE_NAME,COLUMN_NAME from information_schema.KEY_COLUMN_USAGE WHERE TABLE_NAME='emps'";
        String sql5 = "show index from hr.emps";
        String sql6 = "select COLUMN_NAME,DATA_TYPE,CHARACTER_MAXIMUM_LENGTH from information_schema.COLUMNS where "
                + "TABLE_NAME='emps'";

        String sql7 = "select * from information_schema.COLLATIONS";


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
