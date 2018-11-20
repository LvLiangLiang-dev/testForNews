package com.forbaidu.calcite;

import java.sql.SQLException;
import java.util.List;

import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.config.Lex;
import org.apache.calcite.plan.RelTraitDef;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.rel.rel2sql.RelToSqlConverter;
import org.apache.calcite.schema.SchemaPlus;
import org.apache.calcite.sql.SqlDialect;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.dialect.CalciteSqlDialect;
import org.apache.calcite.sql.dialect.MysqlSqlDialect;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql2rel.SqlToRelConverter;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;
import org.apache.calcite.tools.Program;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

public class PlanTest {

    static Planner getPlanner(List<RelTraitDef> traitDefs, SqlParser.Config parserConfig,
                              SqlToRelConverter.Config sqlToRelConf, Program... programs) throws SQLException, ClassNotFoundException {

        final SchemaPlus rootSchema = Frameworks.createRootSchema(true);

        ReflectiveSchema hrs = new ReflectiveSchema(new JavaHrSchema());
        rootSchema.add("hr", hrs);

        final FrameworkConfig config = Frameworks.newConfigBuilder().parserConfig(parserConfig)
                .defaultSchema(rootSchema).traitDefs(traitDefs).sqlToRelConverterConfig(sqlToRelConf).programs(programs)
                .build();
        return Frameworks.getPlanner(config);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String sql = "select * from hr.emps as e join hr.depts as d on e.deptno = d.deptno where d.deptno < 150";

        ImmutableList.<Function<RelNode, RelNode>>of();
        SqlDialect dialect = CalciteSqlDialect.DEFAULT;

        SqlToRelConverter.Config DEFAULT_REL_CONFIG = SqlToRelConverter.configBuilder().withExplain(false)
                .withTrimUnusedFields(false).withConvertTableAccess(false).build();

        final Planner planner = getPlanner(null, SqlParser.configBuilder().setLex(Lex.JAVA).build(),
                DEFAULT_REL_CONFIG);
        try {
            long begin = System.currentTimeMillis();

            SqlNode parse = planner.parse(sql);

            System.out.println(parse.toSqlString(MysqlSqlDialect.DEFAULT).getSql());

            SqlNode validate = planner.validate(parse);

            RelRoot root = planner.rel(validate);
            System.out.println("root:  ");
            System.out.println(root);
            RelNode rel = root.rel;

            // for (Function<RelNode, RelNode> transform : ImmutableList.<Function<RelNode,
            // RelNode>>of()) {
            // rel = transform.apply(rel);
            // }
            final RelToSqlConverter converter = new RelToSqlConverter(dialect);

            final SqlNode sqlNode = converter.visitChild(0, rel).asStatement();
            System.out.println(sqlNode.toSqlString(dialect).getSql());

            long end = System.currentTimeMillis();
            System.out.println(end - begin);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
