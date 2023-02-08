create database coupondb;

use coupondb;

create table coupon(
id int auto_increment primary key,
code varchar(20) unique,
discount decimal(8,3),
exp_date varchar(100));