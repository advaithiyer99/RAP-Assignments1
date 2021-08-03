insert into customer values ('user1','1111','Joe Smith','male', 37);
insert into customer values ('user2','2323','Sarah Smith','female', 32);
insert into customer values ('user3','5648','Tom Bryant','male', 23);
insert into customer values ('user4','0874','Amanda Thompson','female', 24);

insert into account values ('user1', '1234567898', 100.20, 'Checking', 'Active');
insert into account values ('user2', '2134957379', 175.65, 'Savings', 'Active');
insert into account values ('user3', '1271827212', 249.89, 'Savings', 'Active');
insert into account values ('user4', '2054654646', 122.22, 'Checking', 'Active');

insert into transactions values ('user1', 49.98, 0, '1234534349', '1234567898', 50.22, 100.20);
insert into transactions values ('user2', 0, 80.00, '1748573578', '2134957379', 255.65, 175.65);
insert into transactions values ('user3', 50.39, 0, '2134546447', '1271827212', 199.50, 249.89);
insert into transactions values ('user4', 0, 78.35, '1694068699', '2054654646', 200.57, 122.22);