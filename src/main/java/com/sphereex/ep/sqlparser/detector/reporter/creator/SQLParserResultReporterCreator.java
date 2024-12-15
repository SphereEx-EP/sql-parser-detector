package com.sphereex.ep.sqlparser.detector.reporter.creator;

import com.sphereex.ep.sqlparser.detector.reporter.SQLParseResultReporter;
import com.sphereex.ep.sqlparser.detector.spi.BaseSPI;

import java.util.Map;

public interface SQLParserResultReporterCreator extends BaseSPI {
    
    /**
     * Create SQL parse result reporter.
     *
     * @param databaseType database type
     * @param resources creator resources
     * @return created SQL parse result reporter
     */
    SQLParseResultReporter create(String databaseType, Map<String, String> resources);
}
