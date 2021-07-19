drop table if exists customer cascade;
drop table if exists account cascade;
drop table if exists transactions cascade;

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

create table transactions (
	username varchar primary key not null references account(username),
	deposit int,
	withdrawn int
);

select * from customer;
select * from account;
select * from transactions;