package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GitHubUriSQLParserExecutor implements SQLParserExecutor {
    

    @Override
    public Object getType() {
        return SQLParserConstant.GITHUB;
    }
    
    @Override
    public void close() throws Exception {
    }
    
    @Override
    public void executeSQL(final String databaseType, final Map<String, String> resources) {
        // no need to implement
    }
}
