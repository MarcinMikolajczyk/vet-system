insert into CUSTOMER (id, pin, first_name, last_name) values ('0001', '3421', 'Alice', 'Smith');
insert into CUSTOMER (id, pin, first_name, last_name) values ('0002', '3417', 'Lily', 'Brown');
insert into CUSTOMER (id, pin, first_name, last_name) values ('0003', '8720', 'Sophie', 'Ryan');
insert into CUSTOMER (id, pin, first_name, last_name) values ('0004', '2323', 'Oliver', 'Thomas');

insert into DOCTOR (first_name, last_name) values ('Adam', 'Smasher');
insert into DOCTOR (first_name, last_name) values ('Viktor', 'Vector');

insert into APPOINTMENT (start_visit, end_visit, DOCTOR_ID, CUSTOMER_ID)
values (parsedatetime('2021-01-22 14:30', 'yyyy-MM-dd hh:mm'), parsedatetime('2021-01-22 15:30', 'yyyy-MM-dd hh:mm'), 2, '0001');