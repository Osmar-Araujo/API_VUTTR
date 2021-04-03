create table tool(
	id bigint not null auto_increment,
	description varchar(255) not null,
	link varchar(255) not null,
	title varchar(100) not null,
	tags varchar(255) not null,
	
	primary key (id)
);