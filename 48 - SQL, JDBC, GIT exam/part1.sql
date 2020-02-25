---------------------------------------------------EXAM

create table route(
id serial primary key,
endpoint varchar(50) not null,
startpoint varchar(50) not null
);

create table bus(
id serial primary key,
route_id integer references route(id) not null
);

create table driver(
id serial primary key,
name_surname varchar(50) not null,
bus_id integer references bus(id) not null
);

create table journal(
id serial primary key,
driver_id integer references driver(id) not null,
bus_id integer references bus(id) not null,
times timestamp not null
);

insert into route(endpoint, startpoint)
values('Nijniy Jal', 'Verhniy Jal');

insert into route(endpoint, startpoint)
values('street Ahunbaeva', 'street Aitmatova');

insert into route(endpoint, startpoint)
values('street Tynalieva', 'street Tynystanova');

insert into bus(route_id)
values(1);

insert into bus(route_id)
values(2);

insert into bus(route_id)
values(3);

insert into driver(name_surname, bus_id)
values('Azamat Temirov', 1);

insert into driver(name_surname, bus_id)
values('Alinur Karimov', 2);

insert into driver(name_surname, bus_id)
values('Daniel Turarov', 3);

insert into journal(driver_id, bus_id, times)
values(1, 1, current_timestamp);

insert into journal(driver_id, bus_id, times)
values(2, 2, current_timestamp);

insert into journal(driver_id, bus_id, times)
values(3, 3, current_timestamp);
