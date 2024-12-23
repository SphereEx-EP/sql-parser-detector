package com.sphereex.ep.sqlparser.detector.reader.creator;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.reader.CsvDatasourceSQLParserExecutor;
import com.sphereex.ep.sqlparser.detector.reader.MySQLDatasourceSQLParserExecutor;
import com.sphereex.ep.sqlparser.detector.reader.SQLParserExecutor;

import java.util.Map;

public class CsvSQLParserReaderCreator implements SQLParserReaderCreator {
    
    @Override
    public SQLParserExecutor create(final String databaseType, final Map<String, String> resources) {
        return new CsvDatasourceSQLParserExecutor();
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.CSV;
    }
}
