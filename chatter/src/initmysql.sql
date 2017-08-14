

create table if not exists Title (
	id int not null auto_increment primary key,
	message varchar(140) not null,
	created_at timestamp not null,
	latitude double,
	longitude double
);

create table  if not exists User(
	id int not null auto_increment primary key,
	username varchar(20) unique not null,
	password varchar(20) not null,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	email varchar(30) not null
);