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

package com.sphereex.ep.sqlparser.detector.reporter;

import com.sphereex.ep.sqlparser.detector.constants.SQLParserConstant;

import java.io.IOException;

/**
 * SQL parse result reporter.
 */
public final class FileSQLParseResultReporter implements SQLParseResultReporter {
    
    @Override
    public void printResult(final String sqlCaseId, final String databaseType, final boolean isSuccess, final String sql) {
        System.out.println("'" + sqlCaseId + " " + databaseType + " " + sql + "'" + " is success: " + isSuccess);
    }
    
    @Override
    public void close() throws IOException {
    
    }
    
    @Override
    public Object getType() {
        return SQLParserConstant.FILE;
    }
}
