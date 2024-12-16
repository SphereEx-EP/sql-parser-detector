package com.sphereex.ep.sqlparser.detector.reader;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySQLDatasourceSQLParserReader implements SQLParserReader {
    
    @Override
    public ResultSet readSQL(final String databaseType, final Map<String, String> resources) {
        // TODO: implement sql reader here
        ResultSet result = null;
        String url = resources.get("datasource.url");
        String username = resources.get("datasource.username");
        String password = resources.get("datasource.password");
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT id, mysql FROM test_table";
            result = statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.MYSQL_DATASOURCE;
    }
    
    @Override
    public void close() throws Exception {
    }
}
