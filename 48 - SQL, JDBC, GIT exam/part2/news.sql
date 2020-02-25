create table news(
id serial primary key,
newsHeadline varchar(50) not null,
newsText varchar(50) not null,
publicationTime timestamp not null
);
