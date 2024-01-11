drop table if exists customer;
create table customer (
     customer_id int not null auto_increment,
     first_name varchar(50) not null,
     last_name varchar(50) not null,
     email varchar(50) not null,
     password varchar(50) not null,
     primary key (customer_id)
);

drop table if exists Product;
create table Product (
     product_id int not null auto_increment,
     name varchar(50) not null,
     description varchar(50) not null,
     price double not null,
     primary key (product_id)
);

drop table if exists orders;
create table orders (
     order_id int not null auto_increment,
     customer_id int not null,
     product_id int not null,
     quantity int not null,
     price double not null,
     status varchar(50) not null,
     primary key (order_id)
);