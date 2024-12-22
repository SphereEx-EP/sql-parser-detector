package com.sphereex.ep.sqlparser.detector.reader.creator;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.reader.MySQLDatasourceSQLParserExecutor;
import com.sphereex.ep.sqlparser.detector.reader.SQLParserExecutor;

import java.util.Map;

public class MySQLDatasourceSQLParserReaderCreator implements SQLParserReaderCreator {
    
    @Override
    public SQLParserExecutor create(final String databaseType, final Map<String, String> resources) {
        return new MySQLDatasourceSQLParserExecutor();
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.MYSQL_DATASOURCE;
    }
}
