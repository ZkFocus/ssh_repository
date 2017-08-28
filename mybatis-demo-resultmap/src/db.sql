create table address(id int not null primary key auto_increment,city varchar(20));

alter table user add column a_id int;

alter table user add 
	constraint  fk_user_addr
foreign key(a_id) references address(id)