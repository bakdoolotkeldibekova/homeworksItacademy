create table users(
id serial primary key,
login varchar not null unique,
password varchar not null,
email varchar unique,
is_woman boolean not null
);
