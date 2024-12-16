package com.sphereex.ep.sqlparser.detector;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.env.SQLParserEnvironment;
import com.sphereex.ep.sqlparser.detector.reader.MySQLDatasourceSQLParserReader;
import com.sphereex.ep.sqlparser.detector.reader.creator.SQLParserReaderCreator;
import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;
import com.sphereex.ep.sqlparser.detector.reporter.creator.SQLParserResultReporterCreator;
import com.sphereex.ep.sqlparser.detector.spi.BaseSPILoader;
import lombok.SneakyThrows;
import org.apache.shardingsphere.sql.parser.api.CacheOption;
import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.api.SQLStatementVisitorEngine;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;

import java.sql.ResultSet;

public class Application {
    
    @SneakyThrows
    public static void main(String[] args) {
        SQLParserReaderCreator readerCreator = BaseSPILoader.getInstance().getService(SQLParserReaderCreator.class, SQLParserConstant.MYSQL_DATASOURCE);
        MySQLDatasourceSQLParserReader mySQLDatasourceSQLParserReader = (MySQLDatasourceSQLParserReader)readerCreator.create("MySQL", SQLParserEnvironment.getInstance().getExternalEnv());
        SQLParserResultReporterCreator reporterCreator = BaseSPILoader.getInstance().getService(SQLParserResultReporterCreator.class, "file");
        SQLParseResultReporter resultReporter = reporterCreator.create("MySQL", SQLParserEnvironment.getInstance().getExternalEnv());
        ResultSet resultSet = mySQLDatasourceSQLParserReader.readSQL("MySQL", SQLParserEnvironment.getInstance().getExternalEnv());
        while (resultSet.next()) {
            String sql = resultSet.getString("sql");
            try {
                ParseASTNode parseASTNode = new SQLParserEngine("MySQL", new CacheOption(128, 1024L)).parse(sql, false);
                new SQLStatementVisitorEngine("MySQL").visit(parseASTNode);
                resultReporter.printResult(resultSet.getString("id"), "MySQL", true, sql);
            } catch (Exception ignore){
                resultReporter.printResult(resultSet.getString("id"), "MySQL", false, sql);
            }
        }
    }
}
