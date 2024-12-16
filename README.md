# sql-parser-detector
该项目用于检测 SQL 语句是否为 AST 可解析的SQL语句，并根据 SPI 指定的接口生成报告。

## 使用
1. 配置 sql-parser-env.properties
   - 配置文件路径：sql-parser-env.properties
   - 配置内容：
      - 配置 SPI Reader 实现类对应的名称
        - Reader 为数据库时，配置数据库的连接信息
      - 配置 SPI Reporter 实现类对应的名称
2. 运行 Application

## 结构

```
├── java
│   └── com
│       └── sphereex
│           └── ep
│               └── sqlparser
│                   └── detector
│                       ├── Application.java
│                       ├── constants
│                       │   └── SQLParserConstant.java
│                       ├── engine
│                       │   └── SQLParserExecutor.java
│                       ├── env
│                       │   └── SQLParserEnvironment.java
│                       ├── pojo
│                       │   └── FileSummary.java
│                       ├── reader
│                       │   ├── GitHubUriSQLParserReader.java
│                       │   ├── MySQLDatasourceSQLParserReader.java
│                       │   ├── SQLParserReader.java
│                       │   └── creator
│                       │       ├── GitHubUriSQLParserReaderCreator.java
│                       │       ├── MySQLDatasourceSQLParserReaderCreator.java
│                       │       └── SQLParserReaderCreator.java
│                       ├── reporter
│                       │   ├── CsvSQLParseResultReporter.java
│                       │   ├── FileSQLParseResultReporter.java
│                       │   ├── SQLParseResultReporter.java
│                       │   └── creator
│                       │       ├── SQLParserResultReporterCreator.java
│                       │       └── SQLParserResultReporterFileCreator.java
│                       └── spi
│                           ├── BaseSPI.java
│                           ├── BaseSPILoader.java
│                           ├── engine
│                           │   └── SQLParserEngineSPI.java
│                           ├── reader
│                           │   └── SourceReaderSPI.java
│                           └── reporter
│                               └── ReportProcessorSPI.java
└── resources
    ├── META-INF
    │   └── services
    │       ├── com.sphereex.ep.sqlparser.detector.reporter.creator.SQLParserReaderCreator
    │       └── com.sphereex.ep.sqlparser.detector.reporter.creator.SQLParserResultReporterCreator
    └── sql-parser-env.properties
```
