create table package(
id serial primary key,
name varchar(50) not null,
start_date timestamp not null,
monthly_payment integer not null
);

create table customer(
id serial primary key,
first_name varchar(50) not null,
last_name varchar(50) not null,
package_id integer references package(id)
);

insert into package(name, start_date, monthly_payment)
values('laptop',  current_timestamp, 800);

insert into package(name, start_date, monthly_payment)
values('telephone',  current_timestamp, 500);

insert into package(name, start_date, monthly_payment)
values('watch',  current_timestamp, 400);

insert into package(name, start_date, monthly_payment)
values('mp3Player',  current_timestamp, 300);

insert into package(name, start_date, monthly_payment)
values('televizor',  current_timestamp, 1000);

insert into customer(first_name, last_name, package_id)
values('Aibek', 'Alimov', 1);

insert into customer(first_name, last_name, package_id)
values('Kamila', 'Aibekova', 2);

insert into customer(first_name, last_name, package_id)
values('Max', 'Alimov', 4);

insert into customer(first_name, last_name, package_id)
values('Justin', 'Bieber', 5);

insert into customer(first_name, last_name)
values('Olivia', 'Hussey');

--1
select * from customer;
select * from package;

--2
--False

--3
select id, name from package;

--4
--True

--5
--False

--6
select * from customer c
left join package p on p.id = c.package_id;

select * from customer c
right join package p on p.id = c.package_id;

select * from customer c
inner join package p on p.id = c.package_id;

select * from customer c
full outer join package p on p.id = c.package_id;
