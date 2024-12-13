/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sphereex.ep.sqlparser.detector.env;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * SQL parser external IT environment.
 */
@Getter
public final class SQLParserEnvironment {
    
    private static final String SQL_PARSER_REPORTER_PATH = "sql.parser.report.path";
    
    private static final String SQL_PARSER_REPORTER_TYPE = "sql.parser.report.processor.type";
    
    private static final String SQL_PARSER_READER_TYPE = "sql.parser.source.reader.type";
    
    private static final SQLParserEnvironment INSTANCE = new SQLParserEnvironment();
    
    private final String resultPath;
    
    private final String resultProcessorType;
    
    private final String sourceReaderType;
    
    private final Map<String, String> externalEnv;
    
    private SQLParserEnvironment() {
        Properties props = loadProperties();
        resultPath = props.getProperty(SQL_PARSER_REPORTER_PATH, "/tmp/");
        resultProcessorType = props.getProperty(SQL_PARSER_REPORTER_TYPE, "LOG");
        sourceReaderType = props.getProperty(SQL_PARSER_READER_TYPE, "GITHUB");
        externalEnv = new HashMap<>(16);
        if (!props.isEmpty()) {
            for (String each : props.stringPropertyNames()) {
                externalEnv.put(each, props.getProperty(each));
            }
        }
    }
    
    /**
     * Get instance.
     *
     * @return got instance
     */
    public static SQLParserEnvironment getInstance() {
        return INSTANCE;
    }
    
    @SneakyThrows(IOException.class)
    private Properties loadProperties() {
        Properties result = new Properties();
        try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("sql-parser-env.properties")) {
            result.load(inputStream);
        }
        for (String each : System.getProperties().stringPropertyNames()) {
            result.setProperty(each, System.getProperty(each));
        }
        return result;
    }
}
