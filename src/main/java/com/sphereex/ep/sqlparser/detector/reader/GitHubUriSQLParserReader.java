package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GitHubUriSQLParserReader implements SQLParserReader{
    
    @Override
    public List<String> readSQL(final String databaseType, final Map<String, String> resources) {
        return new ArrayList<>(16);
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.GITHUB;
    }
    
    @Override
    public void close() throws Exception {
    }
}
