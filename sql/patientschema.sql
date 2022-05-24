-- drop database if exists
drop schema if exists patientvttp;

-- create a new database
create schema patientvttp;

-- select database
use patientvttp;

-- create table
create table patient (
    email varchar(128) not null,
    name varchar(128) not null,
    phone varchar(16), 
    dob date,
    Prognosis varchar(256) not null,
    address varchar(128),
    
    primary key(email)
);