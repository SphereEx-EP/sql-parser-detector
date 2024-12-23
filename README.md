# sql-parser-detector
该项目用于检测 SQL 语句是否为 AST 可解析的SQL语句，并根据 SPI 指定的接口生成报告。

## 使用
Executor :
  用于处理 SQL 源读取与执行的接口，SQL 数据源可以是文件、CSV、甚至数据库中的记录。

Reporter :
   用于生成 SQL 解析结果报告的接口，报告可以是文件、CSV、甚至数据库中的记录。

1. 配置 sql-parser-env.properties
   - 配置文件路径：sql-parser-env.properties
   - 配置内容：
      - 配置 SPI Reader 实现类对应的 name
      - 配置 SPI Reporter 实现类对应的 name
2. 打包
    - 项目根目录中执行 `mvn clean package` 命令，打包生成 jar 包
    - 执行对应的 jar 包，例如 `java -jar target/sql-parser-detector-jar-with-dependencies.jar`

测试
```shell
## 通过容器测试
docker run --restart=always --platform linux/x86_64 -itd --name mysql_13306 -e MYSQL_ROOT_PASSWORD=root -p13306:3306 mysql:5.7.44

## 登录 MySQL
mysql -h127.0.0.1 -P13306 -uroot -proot

## 导入 resource/sql/test_sql.sql 的测试数据

mysql> use sql_parser_test;
Database changed
mysql> select * from t_sql;
+----+--------------------------------------+
| id | sql_case                             |
+----+--------------------------------------+
|  1 | select * from table a                |
|  2 | insert into table a values (1, 2, 3) |
|  3 | insert into table_a values (1, 2, 3) |
+----+--------------------------------------+
3 rows in set (0.01 sec)

## 配置 reource/sql-parser-env.properties 为如下内容
sql.parser.source.reader.type=mysql_datasource
sql.parser.report.processor.type=csv

sql.parser.reader.datasource.url=jdbc:mysql://127.0.0.1:13306/sql_parser_test
sql.parser.reader.datasource.username=root
sql.parser.reader.datasource.password=root

## 执行 Appliction 类，或将项目打包后执行 sql-parser-detector-jar-with-dependencies.jar
```

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
│                       │   └── SQLParserEngine.java
│                       ├── env
│                       │   └── SQLParserEnvironment.java
│                       ├── pojo
│                       │   └── FileSummary.java
│                       ├── reader
│                       │   ├── GitHubUriSQLParserExecutor.java
│                       │   ├── MySQLDatasourceSQLParserExecutor.java
│                       │   ├── SQLParserExecutor.java
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
├── resources
│   ├── META-INF
│   │   └── services
│   │       ├── com.sphereex.ep.sqlparser.detector.reader.creator.SQLParserReaderCreator
│   │       └── com.sphereex.ep.sqlparser.detector.reporter.creator.SQLParserResultReporterCreator
│   ├── sql
│   │   └── test_sql.sql
│   └── sql-parser-env.properties
```
