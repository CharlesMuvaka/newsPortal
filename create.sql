CREATE DATABASE news_portal;
\c news_portal_test

CREATE TABLE workers(
id serial PRIMARY KEY,
workername VARCHAR,
workerposition VARCHAR,
departmentid INTEGER
);

CREATE TABLE departments(
id serial PRIMARY KEY,
name VARCHAR,
description VARCHAR
);

CREATE TABLE news(
id serial PRIMARY KEY,
topic VARCHAR,
description VARCHAR,
departmentid INTEGER
);