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
	username varchar unique references customer(username) on delete cascade,
	account_id serial primary key not null unique,
	balance numeric(8, 2) not null default 0,
	account_type varchar not null,
	status varchar not null
);

create table transactions (
	username varchar references account(username) on delete cascade,
	deposit numeric(8, 2) default 0,
	withdrawn numeric(8, 2) default 0,
	transaction_id serial primary key not null,
	account_id serial references account(account_id) on delete cascade,
	starting_balance numeric(8, 2) default 0,
	balance numeric(8, 2) default 0
);

select * from customer;
select * from account;
select * from transactions;