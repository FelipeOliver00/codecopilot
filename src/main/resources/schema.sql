--drop table if exists customers;
--create table customers (
--     customer_id int not null auto_increment,
--     first_name varchar(50) not null,
--     last_name varchar(50) not null,
--     email varchar(50) not null,
--     password varchar(50) not null,
--     primary key (customer_id)
--);
--
--drop table if exists products;
--create table products (
--     product_id int not null auto_increment,
--     name varchar(50) not null,
--     description varchar(50) not null,
--     price double not null,
--     primary key (product_id)
--);
--
--drop table if exists orders;
--create table orders (
--     order_id int not null auto_increment,
--     customer_id int not null,
--     product_id int not null,
--     quantity int not null,
--     price double not null,
--     status varchar(50) not null,
--     primary key (order_id)
--);

-- creata table for spring security

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

create table users (
    username varchar(50) not null primary key,
    password varchar(50) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);
