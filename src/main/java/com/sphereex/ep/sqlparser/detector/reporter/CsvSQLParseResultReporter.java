package com.sphereex.ep.sqlparser.detector.reporter;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class CsvSQLParseResultReporter implements SQLParseResultReporter {
    
    private final CSVPrinter printer;
    
    @SneakyThrows(IOException.class)
    public CsvSQLParseResultReporter(final String databaseType, final Map<String, String> resources) {
        File csvFile = new File(resources.get(SQLParserConstant.REPORT_PATH) + databaseType + "-result.csv");
        printHeader(csvFile);
        printer = new CSVPrinter(Files.newBufferedWriter(Paths.get(csvFile.toURI()), StandardOpenOption.APPEND), CSVFormat.DEFAULT.builder().setSkipHeaderRecord(true).build());
    }
    
    @SneakyThrows(IOException.class)
    private void printHeader(final File csvFile) {
        if (csvFile.exists()) {
            return;
        }
        try (
                CSVPrinter csvHeaderPrinter = new CSVPrinter(Files.newBufferedWriter(Paths.get(csvFile.toURI())), CSVFormat.DEFAULT.builder().setSkipHeaderRecord(false).build())) {
            csvHeaderPrinter.printRecord("SQLCaseId", "DatabaseType", "Result", "SQL");
            csvHeaderPrinter.flush();
        }
    }
    
    @SneakyThrows(IOException.class)
    @Override
    public void printResult(final String sqlCaseId, final String databaseType, final boolean isSuccess, final String sql) {
        printer.printRecord(sqlCaseId, databaseType, isSuccess ? "success" : "failed", sql);
        printer.flush();
    }
    
    @Override
    public void close() throws IOException {
        printer.close();
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.CSV;
    }
}
