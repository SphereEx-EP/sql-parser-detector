package com.sphereex.ep.sqlparser.detector.reporter.creator;

import com.sphereex.ep.sqlparser.detector.reporter.FileSQLParseResultReporter;
import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;

import java.util.Map;

public class SQLParserResultReporterFileCreator implements SQLParserResultReporterCreator {
    
    @Override
    public SQLParseResultReporter create(String databaseType, Map<String, String> resources) {
        return new FileSQLParseResultReporter();
    }
    
    @Override
    public Object getType() {
        return "file";
    }
}
