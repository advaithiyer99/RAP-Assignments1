drop table if exists customer cascade;
drop table if exists account cascade;

create table customer (
	username varchar primary key not null,
	password varchar not null,
	name varchar not null,
	gender varchar not null,
	age int not null
);

create table account (
	username varchar primary key not null references customer(username),
	account_id int not null,
	balance real not null,
	account_type varchar not null,
	status varchar not null
);

select * from customer;
select * from account;