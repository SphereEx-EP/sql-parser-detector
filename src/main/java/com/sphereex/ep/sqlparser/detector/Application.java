package com.sphereex.ep.sqlparser.detector;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.env.SQLParserEnvironment;
import com.sphereex.ep.sqlparser.detector.reader.MySQLDatasourceSQLParserExecutor;
import com.sphereex.ep.sqlparser.detector.reader.creator.SQLParserReaderCreator;
import com.sphereex.ep.sqlparser.detector.spi.BaseSPILoader;
import lombok.SneakyThrows;

public class Application {
    
    @SneakyThrows
    public static void main(String[] args) {
        SQLParserReaderCreator readerCreator = BaseSPILoader.getInstance().getService(SQLParserReaderCreator.class, SQLParserConstant.MYSQL_DATASOURCE);
        MySQLDatasourceSQLParserExecutor mySQLDatasourceSQLParserReader = (MySQLDatasourceSQLParserExecutor)readerCreator.create("MySQL", SQLParserEnvironment.getInstance().getExternalEnv());
        mySQLDatasourceSQLParserReader.executeSQL("MySQL", SQLParserEnvironment.getInstance().getExternalEnv());
    }
}
