package com.sphereex.ep.sqlparser.detector.reporter.creator;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.reporter.CsvSQLParseResultReporter;
import com.sphereex.ep.sqlparser.detector.reporter.FileSQLParseResultReporter;
import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;

import java.util.Map;

public class SQLParserResultReporterCsvCreator implements SQLParserResultReporterCreator {
    
    @Override
    public SQLParseResultReporter create(String databaseType, Map<String, String> resources) {
        return new CsvSQLParseResultReporter(databaseType, resources);
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.CSV;
    }
}
