package com.sphereex.ep.sqlparser.detector.executor;

//import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;
//import com.sphereex.ep.sqlparser.detector.reporter.creator.SQLParseResultReporterCreator;
//import com.sphereex.ep.sqlparser.detector.spi.BaseSPILoader;
//import org.apache.shardingsphere.infra.exception.core.external.ShardingSphereExternalException;
//import org.apache.shardingsphere.sql.parser.api.CacheOption;
//import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
//import org.apache.shardingsphere.sql.parser.api.SQLStatementVisitorEngine;
//import org.apache.shardingsphere.sql.parser.core.ParseASTNode;

import java.io.IOException;

public final class SQLParserExecutor {

//    void executeSQLParse(final String sqlCaseId, final String databaseType, final String sql, final String reportType) throws IOException {
//        boolean isSuccess = false;
//        try (
//                SQLParseResultReporter resultReporter = BaseSPILoader.getInstance().getService(SQLParseResultReporterCreator.class, reportType)
//                        ) {
//            try {
//                ParseASTNode parseASTNode = new SQLParserEngine(databaseType, new CacheOption(128, 1024L)).parse(sql, false);
//                new SQLStatementVisitorEngine(databaseType).visit(parseASTNode);
//                isSuccess = true;
//            } catch (final ShardingSphereExternalException | ClassCastException | IllegalArgumentException | IndexOutOfBoundsException ignore) {
//            } finally {
//                resultReporter.printResult(sqlCaseId, databaseType, isSuccess, sql);
//            }
//        }
//    }
}
