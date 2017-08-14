--drop table user if exists

create table if not exists user(
	id int not null primary key auto_increment,
	name varchar(20),
	tel varchar(11)
);

--insert into user(name,tel) values("admin","110")