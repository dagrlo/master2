use testdbunit;

create table if not exists users (id INT PRIMARY KEY,
first_name VARCHAR (50),
last_name VARCHAR (50),
date_created DATE,
is_admin BOOLEAN,
num_points INT);



INSERT INTO users values (1,'Ignacio', 'Panach', '2013-10-04', true, 7);

INSERT INTO users values (2,'Paquito', 'Chocolatero', '2013-11-14', true, 6);
