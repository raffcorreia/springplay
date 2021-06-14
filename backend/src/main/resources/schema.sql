DROP SCHEMA IF EXISTS dbo;

CREATE SCHEMA dbo;

DROP TABLE IF EXISTS TB_XSS;

CREATE TABLE dbo.TB_XSS
(
    ID      bigint identity (0, 1) constraint TB_XSS_PK primary key,
    TEXT    varchar(max)
);

create table dbo.TB_LOGIN
(
    ID bigint identity(0, 1),
    NAME varchar(250) not null,
    PASSWORD varchar(100) not null
);

create unique index dbo.TB_LOGIN_NAME_IDX
    on dbo.TB_LOGIN (NAME);

