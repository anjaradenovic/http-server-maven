create table employee (
id int(6) unsigned auto_increment primary key,
first_name varchar(80) not null,
last_name varchar(100) not null,
role varchar(120) not null,
user_name varchar(100) not null,
email varchar(100) not null );