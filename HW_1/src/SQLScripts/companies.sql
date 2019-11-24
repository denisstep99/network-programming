-- подключение
delete
from companies;

-- создание таблицы
create table companies
(
    id                integer,
    name              varchar(100),
    country           varchar(100),
    numberOfEmployees integer,
    revenue           integer,
    type              varchar(100)
);
Insert into companies (id, name, country, numberOfEmployees, revenue, type)
values (1, 'Apple', 'USA', 100000, 200000000, 'public');
Insert into companies (id, name, country, numberOfEmployees, revenue, type)
values (2, 'IBM', 'USA', 50000, 40000000, 'public');
Insert into companies (id, name, country, numberOfEmployees, revenue, type)
values (3, 'Microsoft', 'USA', 150000, 150000000, 'public');
Insert into companies (id, name, country, numberOfEmployees, revenue, type)
values (4, 'JetBrains', 'Czech', 30000, 20000000, 'public');
Insert into companies (id, name, country, numberOfEmployees, revenue, type)
values (5, 'Cisco', 'USA', 100000, 80000000, 'public');
