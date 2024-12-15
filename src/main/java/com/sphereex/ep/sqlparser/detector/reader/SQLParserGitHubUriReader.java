package com.sphereex.ep.sqlparser.detector.reader;

import java.util.List;
import java.util.Map;

public class SQLParserGitHubUriReader implements SQLParserReader{
    
    @Override
    public List<String> readSQL(final String databaseType, final Map<String, String> resources) {
        return null;
    }
    
    @Override
    public Object getType() {
        return "github";
    }
    
    @Override
    public void close() throws Exception {
    
    }
}
