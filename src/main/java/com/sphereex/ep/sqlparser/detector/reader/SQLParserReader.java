package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.spi.BaseSPI;

import java.util.List;
import java.util.Map;

public interface SQLParserReader extends BaseSPI, AutoCloseable{
    
    /**
     * Read SQL
     * @param databaseType database type
     * @param resources resources, maybe GitHub uri or database info.
     * @return SQL list
     */
    List<String> readSQL(String databaseType, Map<String, String> resources);
}
