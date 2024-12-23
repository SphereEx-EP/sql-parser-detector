package com.sphereex.ep.sqlparser.detector;

import com.sphereex.ep.sqlparser.detector.env.SQLParserEnvironment;
import com.sphereex.ep.sqlparser.detector.reader.SQLParserExecutor;
import com.sphereex.ep.sqlparser.detector.reader.creator.SQLParserReaderCreator;
import com.sphereex.ep.sqlparser.detector.spi.BaseSPILoader;
import lombok.SneakyThrows;

public class Application {
    
    @SneakyThrows
    public static void main(String[] args) {
        SQLParserReaderCreator readerCreator = BaseSPILoader.getInstance().getService(SQLParserReaderCreator.class, SQLParserEnvironment.getInstance().getSourceReaderType());
        SQLParserExecutor sqlParserExecutor = readerCreator.create("MySQL", SQLParserEnvironment.getInstance().getExternalEnv());
        sqlParserExecutor.executeSQL("MySQL", SQLParserEnvironment.getInstance().getExternalEnv());
    }
}
