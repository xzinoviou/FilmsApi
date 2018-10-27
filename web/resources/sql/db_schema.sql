#CREATE DATABASE
CREATE DATABASE FILMS_DB

USE FILMS_DB

CREATE TABLE USER (
USER_ID BIGINT NOT NULL AUTO_INCREMENT,
USER_EMAIL VARCHAR(100) NOT NULL UNIQUE,
USER_PASSWORD VARCHAR(20) NOT NULL,
USER_KEY TEXT,
FIRST_NAME TEXT,
LAST_NAME TEXT,
PRIMARY KEY(USER_ID)
)ENGINE = INNODB DEFAULT CHARSET = UTF8;
