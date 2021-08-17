create table tbl_employee(
    id int primary key auto_increment,
    last_name varchar(255),
    gender char(1),
    email varchar(255),
);

create table tbl_dept(
	id int primary key auto_increment,
	dept_name varchar(255)
);

alter table tbl_employee add column dept_id int;