package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.engine.SQLParserEngine;
import com.sphereex.ep.sqlparser.detector.env.SQLParserEnvironment;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class CsvDatasourceSQLParserExecutor implements SQLParserExecutor {
    
    @Override
    public void executeSQL(final String databaseType, final Map<String, String> resources) {
        try (Reader reader = new FileReader(resources.get(SQLParserConstant.READER_CSV_PATH));
             CSVParser csvParser = new CSVParser(reader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            SQLParserEngine parserEngine = new SQLParserEngine();
            for (CSVRecord record : csvParser) {
                String sqlCaseId = record.get(0);
                String sql = record.get(1);
                parseSQL(databaseType, parserEngine, sqlCaseId, sql);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void parseSQL(String databaseType, SQLParserEngine parserEngine, String sqlCaseId, String sql) {
        try {
            parserEngine.executeSQLParse(sqlCaseId, databaseType, sql, SQLParserEnvironment.getInstance().getResultProcessorType());
        } catch (Exception ignore) {
        }
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.CSV;
    }
    
    @Override
    public void close() throws Exception {
    }
}
