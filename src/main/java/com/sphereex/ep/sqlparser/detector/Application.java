package com.sphereex.ep.sqlparser.detector;

import org.apache.shardingsphere.sql.parser.api.CacheOption;
import org.apache.shardingsphere.sql.parser.api.SQLParserEngine;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;

public class Application {
    
    public static void main(String[] args) {
        ParseASTNode parseASTNode = new SQLParserEngine("MySQL", new CacheOption(128, 1024L)).parse("select * from tablex", false);
    }
}
