-- Active: 1660487431057@@127.0.0.1@3306@board
show databases;
-- drop database board;
-- create database board;

select user, host from mysql.user;
-- drop user app@'localhost';
-- create user 'app'@'localhost' identified by 'app';

show grants for app@localhost;
-- show grants for root@localhost;
-- grant all on board.* to app@localhost with grant option;
-- grant proxy on ``@`` to app@localhost with grant option;
-- flush privileges;

-- select user, host from mysql.user;
-- create user 'app'@'172.%' identified by 'app';
-- show grants for app@'172.%';
-- grant all on board.* to app@'172.%' with grant option;
-- flush privileges;
