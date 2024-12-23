create database sql_parser_test;
use sql_parser_test;
CREATE TABLE t_sql
(
    id       INT          NOT NULL,
    sql_case VARCHAR(400) NULL,
    PRIMARY KEY (id)
);

insert into t_sql values (1, "select * from table a");
insert into t_sql values (2, "insert into table a values (1, 2, 3)");
insert into t_sql values (3, "insert into table_a values (1, 2, 3)");
