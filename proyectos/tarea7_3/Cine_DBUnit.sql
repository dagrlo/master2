use CineDBunit;



create table if not exists sala (id_sala INT PRIMARY KEY,
nombre VARCHAR (50)
);
create table if not exists actor (id_actor INT PRIMARY KEY,
nombre VARCHAR (50),
apellidos VARCHAR (50)
);
create table if not exists pelicula (id_pelicula INT PRIMARY KEY,
titulo VARCHAR (50),
id_actor INT REFERENCES actor 
);

create table if not exists provincia (id_provincia INT PRIMARY KEY,
nombre VARCHAR (50)
);

create table if not exists cine (id_cine INT PRIMARY KEY,
nombre VARCHAR (50),
direccion VARCHAR (50),
id_provincia INT REFERENCES provincia
);


create table if not exists sesion (id_sesion INT PRIMARY KEY,
hora VARCHAR (50),
id_sala INT REFERENCES sala,
id_pelicula INT REFERENCES pelicula,
id_cine INT REFERENCES cine
);
