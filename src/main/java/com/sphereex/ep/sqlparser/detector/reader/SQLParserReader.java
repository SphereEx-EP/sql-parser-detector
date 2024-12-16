package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.spi.BaseSPI;

import java.util.Map;

public interface SQLParserReader extends BaseSPI, AutoCloseable{
    
    /**
     * Read SQL
     * @param databaseType database type
     * @param resources resources, maybe GitHub uri or database info.
     * @return SQL list
     */
    Object readSQL(String databaseType, Map<String, String> resources);
}
