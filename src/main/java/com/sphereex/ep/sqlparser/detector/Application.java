package com.sphereex.ep.sqlparser.detector;

import com.sphereex.ep.sqlparser.detector.reporter.creator.SQLParserResultReporterCreator;
import com.sphereex.ep.sqlparser.detector.spi.BaseSPILoader;
import org.apache.shardingsphere.sql.parser.api.CacheOption;
import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;

public class Application {
    
    public static void main(String[] args) {
        ParseASTNode parseASTNode = new SQLParserEngine("MySQL", new CacheOption(128, 1024L)).parse("select * from tablex", false);
        SQLParserResultReporterCreator creator = BaseSPILoader.getInstance().getService(SQLParserResultReporterCreator.class, "file");
        creator.create("MySQL", null);
    }
}
