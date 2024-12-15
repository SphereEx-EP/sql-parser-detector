package com.sphereex.ep.sqlparser.detector.reporter.creator;

import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultFileReporter;
import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;

import java.util.Map;

public class SQLParserResultReporterFileCreator implements SQLParserResultReporterCreator {
    
    @Override
    public SQLParseResultReporter create(String databaseType, Map<String, String> resources) {
        return new SQLParseResultFileReporter();
    }
    
    @Override
    public Object getType() {
        return "file";
    }
}
