package com.sphereex.ep.sqlparser.detector.reader.creator;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.reader.MySQLDatasourceSQLParserReader;
import com.sphereex.ep.sqlparser.detector.reader.SQLParserReader;

import java.util.Map;

public class MySQLDatasourceSQLParserReaderCreator implements SQLParserReaderCreator {
    
    @Override
    public SQLParserReader create(final String databaseType, final Map<String, String> resources) {
        return new MySQLDatasourceSQLParserReader();
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.MYSQL_DATASOURCE;
    }
}
