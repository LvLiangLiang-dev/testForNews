package com.forbaidu.calcite;

import java.sql.SQLException;

import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlDataTypeSpec;
import org.apache.calcite.sql.SqlDynamicParam;
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.sql.SqlIntervalQualifier;
import org.apache.calcite.sql.SqlLiteral;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlNodeList;
import org.apache.calcite.sql.dialect.MysqlSqlDialect;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.util.SqlVisitor;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;

public class PlanTest2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, SqlParseException {
        String sql = "select * from hr.emps as e join hr.depts as d on e.deptno = d.deptno where d.deptno < 150";

        // String sql = "insert into avc values ('a','b')";

        long begin = System.currentTimeMillis();

        final FrameworkConfig config = Frameworks.newConfigBuilder().build();

        final Planner planner = Frameworks.getPlanner(config);

        SqlNode parse = planner.parse(sql);

        System.out.println(parse.toSqlString(MysqlSqlDialect.DEFAULT).getSql());
        long end = System.currentTimeMillis();
        System.out.println("end-begin: "+(end - begin));

        parse.accept(new VV());
        System.out.println(parse.toSqlString(MysqlSqlDialect.DEFAULT).getSql());

    }

    public static class VV implements SqlVisitor<Void> {

        public Void visit(SqlLiteral literal) {

            System.out.println("literal " + literal);

            return null;
        }

        public Void visit(SqlCall call) {

            for (SqlNode node : call.getOperandList()) {
                if (node != null)
                    node.accept(this);
            }

            return null;
        }

        public Void visit(SqlNodeList nodeList) {
            for (SqlNode node : nodeList) {
                if (node != null)
                    node.accept(this);
            }

            return null;
        }

        public Void visit(SqlIdentifier id) {

            System.out.println("id " + id);

            return null;
        }

        public Void visit(SqlDataTypeSpec type) {

            System.out.println("type " + type);

            return null;
        }

        public Void visit(SqlDynamicParam param) {

            System.out.println("param " + param);

            return null;
        }

        public Void visit(SqlIntervalQualifier intervalQualifier) {

            System.out.println("intervalQualifier " + intervalQualifier);

            return null;
        }

    }

}
