-- подключение
delete
from products;

-- создание таблицы
create table products
(
    id          integer,
    description varchar(100),
    rate        float,
    quantity    integer
);
Insert into products (id, description, rate, quantity)
values (1, 'Computer', 20000, 10);
Insert into products (id, description, rate, quantity)
values (2, 'iPad', 30000, 10);
Insert into products (id, description, rate, quantity)
values (3, 'Tablet', 7000, 10);
Insert into products (id, description, rate, quantity)
values (4, 'Phone', 5000, 10);
Insert into products (id, description, rate, quantity)
values (5, 'Display Dell', 2000, 10);
Insert into products (id, description, rate, quantity)
values (6, 'iPhone', 19000, 10);
Insert into products (id, description, rate, quantity)
values (7, 'Apple Mac', 40000, 10);
Insert into products (id, description, rate, quantity)
values (8, 'Printer HP', 5000, 10);
Insert into products (id, description, rate, quantity)
values (9, 'TV', 22000, 10);
Insert into products (id, description, rate, quantity)
values (10, 'Server IBM', 100000, 10);
