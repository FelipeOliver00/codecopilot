---- please write 5 sample insert statements for different customers
--
--insert into customers (customer_id, first_name, last_name, email, password)
--values (1, 'A', 'ALEX', 'a1@gmail.com', '123456');
--
--insert into customers (customer_id, first_name, last_name, email, password)
--values (2, 'B', 'BOB', 'b1@gmail.com', '123456');
--
--insert into customers (customer_id, first_name, last_name, email, password)
--values (3, 'C', 'CO', 'c1@gmail.com', '123456');
--
--insert into customers (customer_id, first_name, last_name, email, password)
--values (4, 'D', 'DOL', 'd1@gmail.com', '123456');
--
--insert into customers (customer_id, first_name, last_name, email, password)
--values (5, 'E', 'ELI', 'e1@gmail.com', '123456');
--
---- please write 5 sample insert statements for diferent products
--insert into products (product_id, name, description, price)
--values (1, 'DESK', 'LITTLE DESK', 1.0);
--
--insert into products (product_id, name, description, price)
--values (2, 'BALL', 'A TOY', 2.0);
--
--insert into products (product_id, name, description, price)
--values (3, 'CHAIR', 'A CHAIR', 3.0);
--
--insert into products (product_id, name, description, price)
--values (4, 'DOLLAR', 'A DOLLAR TOY', 4.0);
--
--insert into products (product_id, name, description, price)
--values (5, 'CASE', 'A SCHOOL CASE', 5.0);
--
---- please write 5 sample insert statements for different orders
--insert into orders (order_id, customer_id, product_id, quantity, price, status)
--VALUES (1, 1, 1, 1, 1.0, 'NEW');
--
--insert into orders (order_id, customer_id, product_id, quantity, price, status)
--VALUES (2, 2, 2, 2, 2.0, 'NEW');
--
--insert into orders (order_id, customer_id, product_id, quantity, price, status)
--VALUES (3, 3, 3, 3, 3.0, 'NEW');
--
--insert into orders (order_id, customer_id, product_id, quantity, price, status)
--VALUES (4, 4, 4, 4, 4.0, 'NEW');
--
--insert into orders (order_id, customer_id, product_id, quantity, price, status)
--VALUES (5, 5, 5, 5, 5.0, 'NEW');

-- create two users user and admin with password user123 and admin123 respectively and with roles ROLE_USER and ROLE_ADMIN respectively

insert into users values ('user', 'user123', true);
insert into authorities values ('user', 'ROLE_USER');

insert into users values ('admin', 'admin123', true);
insert into authorities values ('admin', 'ROLE_ADMIN');