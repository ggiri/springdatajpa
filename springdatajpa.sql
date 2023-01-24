create database mydb;
use mydb;

create table employee(
id int primary key,
name varchar(20)
);

drop table employee;

create table id_gen(
gen_name varchar(60) PRIMARY KEY,
gen_value int
);

drop table id_gen;

select * from employee;
delete from employee;
select * from id_gen;


select * from product;

insert into product values(1,'Noise fusion', 'Noise Inc', 7000);

insert into product values(2,'Dell laptop', 'Dell ', 10000);
insert into product values(3,'Pixel 7', 'Google', 70000);
insert into product values(4,'Predator', 'Acer', 80000);

update product set price = 80000 where id = 3;

create table Student(
id int primary key auto_increment,
fname varchar(20),
lname varchar(20),
score int);

select * from student;
delete from student;


create table payment(
id int PRIMARY KEY,
pmode varchar(2),
amount decimal(8,3) ,
cardnumber varchar(20),
checknumber varchar(20)
);

select * from payment;

drop table payment;


create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
);

create table bankcheck(
id int PRIMARY KEY,
amount decimal(8,3),
checknumber varchar(20)
);

select * from card;

select * from bankcheck;

drop table card;

drop table bankcheck;

create table payment(
id int PRIMARY KEY,
amount decimal(8,3)
);

create table card(
id int ,
cardnumber varchar(20),
 FOREIGN KEY (id)
REFERENCES payment(id)
);

create table bankcheck(
id int ,
checknumber varchar(20),
FOREIGN KEY (id)
REFERENCES payment(id)
);


select * from employee;

drop table employee;

create table employee(
id int,
name varchar(20),
streetaddress varchar(30),
city varchar(20),
state varchar(20),
zipcode varchar(20),
country varchar(20)
);

drop table customer;

create table customer(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

create table phone_number(
id int PRIMARY KEY AUTO_INCREMENT,
customer_id int,
number varchar(20),
type varchar(20),
 FOREIGN KEY (customer_id)
REFERENCES customer(id)
);
use mydb;
select * from Customer;

delete from Customer where id in (1,2,3,4,5);

select * from phone_number;

drop table phone_number;
drop table customer;

create table programmer(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20),
salary int
);

create table project(
id int PRIMARY KEY AUTO_INCREMENT,
name varchar(20)
);

create table programmers_projects(
programmer_id int,
project_id int,
FOREIGN KEY (programmer_id)
REFERENCES programmer(id),
FOREIGN KEY (project_id)
REFERENCES project(id)
);

select * from programmer;

select * from project;

select * from programmers_projects;

create table person(
id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(20),
age int
);

create table license(
id int PRIMARY KEY AUTO_INCREMENT,
type varchar(20),
valid_from date,
valid_to date,
person_id int,
FOREIGN KEY (person_id)
REFERENCES person(id)
);


select * from license;

select * from person;

select * from product;

create table bankaccount (
accno int,
lastname varchar(25),
firstname varchar(25),
bal int);

select * from bankaccount;

create TABLE image(
	id BIGINT NOT NULL,
	name varchar(100) NOT NULL,
	data BLOB NOT NULL,
	PRIMARY KEY(id)
);

select * from image;

insert into bankaccount values(1,'obama','barack',5000);
insert into bankaccount values(2,'donald','trump',4000);

select * from product;

DELIMITER //

CREATE PROCEDURE GetAllProducts()
BEGIN
	SELECT *  FROM product;
END //

DELIMITER //

CREATE PROCEDURE GetAllProductsByPrice(IN price_in decimal)
BEGIN
	SELECT *  FROM product where price>price_in;
END //

DELIMITER //

CREATE PROCEDURE GetAllProductsCountByPrice(IN price_in decimal)
BEGIN
	SELECT count(*)  FROM product where price>price_in;
END //

create table patient(
id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(30),
phone varchar(30),
provider_name varchar(30),
copay decimal(10,5)
);

create table doctor(
id int PRIMARY KEY AUTO_INCREMENT,
first_name varchar(20),
last_name varchar(30),
speciality varchar(30)
);

create table patients_doctors(
patient_id int,
doctor_id int,
FOREIGN KEY (patient_id)
REFERENCES patient(id),
FOREIGN KEY (doctor_id)
REFERENCES doctor(id)
);

create table appointment(
id int PRIMARY KEY AUTO_INCREMENT,
patient_id int,
doctor_id int,
appointment_time datetime,
started TINYINT(1),
ended TINYINT(1),
reason varchar(200),
FOREIGN KEY (patient_id)
REFERENCES patient(id),
FOREIGN KEY (doctor_id)
REFERENCES doctor(id)
);

select * from doctor;

select * from patient;

select * from patients_doctors;

select * from appointment;

use mydb
 drop table customer;
CREATE TABLE customer (
    id int NOT NULL ,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id,email)
);

select * from customer;
select * from customer_id;


