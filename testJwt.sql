CREATE DATABASE test_jwt;
USE test_jwt;

SET GLOBAL time_zone = '-3:00';

CREATE TABLE users(
	id_user int auto_increment,
    username varchar(30),
    pass varchar(20),
    first_name varchar(20),
    last_name varchar(20),
    rol enum('client', 'employee', 'administrator'),
    constraint pk_id_user primary key (id_user)
);

CREATE TABLE cars(
	id_car int auto_increment,
    id_user int,
    patent varchar(8),
    brand varchar(20),
    model varchar(20),
    constraint pk_id_car primary key (id_car),
    constraint fk_id_user foreign key (id_user) references users (id_user)
);

SELECT * FROM users;
SELECT * FROM cars;