package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;
import com.sphereex.ep.sqlparser.detector.engine.SQLParserEngine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySQLDatasourceSQLParserExecutor implements SQLParserExecutor {
    
    @Override
    public void executeSQL(final String databaseType, final Map<String, String> resources) {
        ResultSet resultSet;
        String url = resources.get("datasource.url");
        String username = resources.get("datasource.username");
        String password = resources.get("datasource.password");
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT id, sql_case FROM t_sql";
            resultSet = statement.executeQuery(sqlQuery);
            SQLParserEngine parserEngine = new SQLParserEngine();
            parseSQL(resultSet, databaseType, parserEngine);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private void parseSQL(ResultSet resultSet, String databaseType, SQLParserEngine parserEngine) {
        try {
            while (resultSet.next()) {
                String sqlCaseId = resultSet.getString("id");
                String sql = resultSet.getString("sql_case");
                parserEngine.executeSQLParse(sqlCaseId, databaseType, sql, SQLParserConstant.FILE);
            }
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.MYSQL_DATASOURCE;
    }
    
    @Override
    public void close() throws Exception {
    }
}
