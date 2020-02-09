create table sport
(
id integer primary key,
name varchar (50) unique not null,
salary integer not null
);

create table trainer
(
id integer primary key,
name varchar (100) unique not null,
phone_nunmber integer unique,
inn integer unique not null,
sport_id integer references sport(id) unique
);

insert into sport(id, name, salary)
values(1, 'football', 300);

insert into sport(id, name, salary)
values(2, 'basketball', 400);

insert into sport(id, name, salary)
values(3, 'volleyball', 100);

insert into sport(id, name, salary)
values(4, 'tennis', 400);

insert into sport(id, name, salary)
values(5, 'hockey', 500);

insert into sport(id, name, salary)
values(6, 'boks', 700);

insert into sport(id, name, salary)
values(7, 'table tennis', 500);

insert into trainer(id, name, phone_nunmber, inn, sport_id)
values(1, 'Beka', 055525151, 118120000, 2);

insert into trainer(id, name, phone_nunmber, inn, sport_id)
values(2, 'Alim', 055055951, 118120001, 1);

insert into trainer(id, name, phone_nunmber, inn, sport_id)
values(3, 'Kamila', 077725121, 118120002, 3);

insert into trainer(id, name, phone_nunmber, inn, sport_id)
values(4, 'Artur', 055725121, 118120004, 4);

insert into trainer(id, name, phone_nunmber, inn, sport_id)
values(5, 'Dilan', 077725136, 118120005, 5);

insert into trainer(id, name, phone_nunmber, inn, sport_id)
values(6, 'Dima', 077729636, 118120006, 7);

insert into trainer(id, name, phone_nunmber, inn, sport_id)
values(7, 'Fera', 077025136, 118120007, 6);

----------------------------------------------------------------

create table visitor(
id integer primary key,
name varchar(50) not null,
birthdate date not null,
gender varchar not null
);

create table visit(
id integer primary key,
visitor_id integer references visitor(id) not null unique,
visit_time time,
trainer_id integer references trainer(id) not null
);


insert into visitor(id, name, birthdate, gender)
values(1, 'Alim', '2000-10-18', 'm');

insert into visitor(id, name, birthdate, gender)
values(2, 'Kamila', '1990-02-10', 'w');

insert into visit(id, visitor_id, visit_time, trainer_id)
values(1, 1, '01:02', 5);

insert into visit(id, visitor_id, visit_time, trainer_id)
values(2, 2, '18:00', 3);
