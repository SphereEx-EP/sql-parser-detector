package com.sphereex.ep.sqlparser.detector.reader.creator;

import com.sphereex.ep.sqlparser.detector.reader.SQLParserExecutor;
import com.sphereex.ep.sqlparser.detector.spi.BaseSPI;

import java.util.Map;

public interface SQLParserReaderCreator extends BaseSPI {
    
    /**
     * Create SQL parse reader.
     *
     * @param databaseType database type
     * @param resources creator resources
     * @return created SQL parse reader
     */
    SQLParserExecutor create(String databaseType, Map<String, String> resources);
}
