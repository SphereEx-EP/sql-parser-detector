package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;
import com.sphereex.ep.sqlparser.detector.spi.BaseSPI;

import java.util.Map;

public interface SQLParserExecutor extends BaseSPI, AutoCloseable{
    
    /**
     * Execute SQL
     * @param databaseType database type
     * @param resources resources, maybe GitHub uri or database info.
     */
    void executeSQL(String databaseType, Map<String, String> resources);
}
