package com.forbaidu.calcite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.SchemaPlus;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.calcite.jdbc.Driver");
        Properties info = new Properties();
        info.setProperty("lex", "JAVA");
        Connection connection = DriverManager.getConnection("jdbc:calcite:", info);
        CalciteConnection calciteConnection = (CalciteConnection) connection;
        SchemaPlus rootSchema = calciteConnection.getRootSchema();

        ReflectiveSchema hrs = new ReflectiveSchema(new JavaHrSchema());
        rootSchema.add("hr", hrs);
        Statement statement = calciteConnection.createStatement();

//        ResultSet resultSet = statement
//                .executeQuery("select count(*) from hr.emps as e join hr.depts as d on e.deptno = d.deptno");
        ResultSet resultSet1 = statement.executeQuery("select * from hr.emps");

//        while (resultSet.next()) {
//            System.out.println(resultSet.getObject(1));
//        }
        while(resultSet1.next()) {
            System.out.println(resultSet1.getObject(1)+" "+resultSet1.getObject(2)+" "+resultSet1.getObject(3));
        }
        resultSet1.close();
//        resultSet.close();
        statement.close();
        connection.close();
    }
}
