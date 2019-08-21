use estate4mont2019;
create table building(
	id BIGINT not null primary key auto_increment,
	name  varchar(255) null,
	numberofbasement int null,
	buildingarea int null,
	ward varchar(100) null,
	street varchar(100) null,
	structure varchar(100) null,
	costrent int null,
	costdescription texr null,
	servicecost varchar(225) null,
	carcost varchar (255) null,
	motorbikecost varchar(255) null,
	overtimecost varchar(255) null,
	electricitycost varchar(255) null,
	deposit varchar(255) null,
	payment varchar(255) null,
	timerent varchar(255) null,
	timedecorator varchar(255) null,
	managername  varchar(255) null,
	managerphone  varchar(255) null,
	district_id bigint not null,
	createddate timestamp null,
	modifieddate timestamp null,
	createdby varchar(255) null,
	modifiedby varchar(255) null
);
create table user (
	id bigint not null primary key auto_increment,
	username varchar (150) not null,
	password varchar (150) not null ,
	fullname varchar (150) null,
	status int not null ,
	createddate timestamp null,
	modifieddate timestamp null,
	createdby varchar(255) null,
	modifiedby varchar(255) null
);
create table district
(
	id bigint not null primary key auto_increment,
	name varchar(255) not null,
	code varchar(255) not null,
	createddate timestamp null,
	modifieddate timestamp null,
	createdby varchar(255) null,
	modifiedby varchar(255) null
);
alter table building ADD CONSTRAINT fk_building_district foreign key (district_id) references district(id);
create table role
(
	id bigint not null primary key auto_increment,
	name varchar(255) not null,
	code varchar(255) not null
);
create table user_role
(
	id bigint not null primary key auto_increment,
	roleid bigint not null,
	userid bigint not null
);
alter table user_role ADD CONSTRAINT fk_user_role foreign key (roleid) references role(id);
alter table user_role ADD CONSTRAINT fk_userrole_role foreign key (userid) references user(id);

create table assignment
(
	id bigint not null primary key auto_increment,
	building_id bigint not null,
	user_id bigint not null
);
alter table assignment ADD CONSTRAINT fk_assignment_user foreign key (roleid) references role(id);
alter table assignment ADD CONSTRAINT fk_assignment_building foreign key (userid) references user(id);