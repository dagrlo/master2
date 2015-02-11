USE empresa
-- ***********************************************
-- **                                           **
-- **  DEPARTAMENTOS                            **
-- **                                           **
-- ***********************************************
INSERT INTO Departamentos (nombre)
  VALUES ('DIRECCION'),
         ('PLANIFICACION'),
         ('CENTRO DE INFORMACION'),
         ('SISTEMAS DE PRODUCCION'),
         ('SOPORTE DE SOFTWARE');
-- ***********************************************
-- **                                           **
-- **  EMPLEADOS                                **
-- **                                           **
-- ***********************************************
INSERT INTO Empleados (nombre,apellidos,departamento,fechaContrato,
                        puesto,nivelEducacion,sueldo,complemento)
VALUES
   ('JURGEN','LOPEZ NAVARRO',1,'2006-06-21','SLS',6,27731.00,6729.00),
   ('JOSE LUIS','TORRES TORRES',5,'2007-04-05','SLS',11,43391.00,1691.00),
   ('PABLO','IVARS SORIANO',4,'2006-07-06','MGR',7,20396.00,11109.00),
   ('SERGIO','LLOPIS BARBERA',4,'2005-05-10','FLD',6,27983.00,11298.00),
   ('ALFONSO CHRISTIAN','LOPEZ TROYANO',2,'2004-11-26','DES',8,29416.00,11504.00),
   ('FRANCISCO JAVIER','PEREZ PRUDENCIO',3,'2006-04-22','ANL',12,26499.00,7235.00),
   ('JORGE','GIL BAILEN',3,'2006-07-15','FLD',9,30756.00,11145.00),
   ('ALEJANDRO','SEVADILLA PICAZO',2,'2007-11-25','FLD',5,30534.00,4010.00),
   ('CRISTOBAL','MARTINEZ AGUT',2,'2006-01-27','MGR',11,15908.00,8538.00),
   ('IVAN','SOLER LOPEZ',4,'2004-11-18','FLD',5,34426.00,2495.00),
   ('ANA ISABEL','GANDIA BARROSO',4,'2004-08-25','ANL',9,28702.00,10875.00),
   ('ROSA ARANCHA','HENNCHEN BELENGUER',2,'2004-10-04','MGR',6,17144.00,3368.00),
   ('JUAN','ANGULLO GARCIA',3,'2005-06-19','DES',9,20139.00,8543.00),
   ('REBECA','ANGULO SANCHEZ',4,'2004-09-04','FLD',8,35894.00,11499.00),
   ('ANTONIO','RAMON ABAD',4,'2007-08-10','DES',9,17702.00,3227.00),
   ('MERCEDES','PASCUAL ESTEVE',2,'2004-07-01','ANL',5,23648.00,7090.00),
   ('JAIME','MUÑOZ MENENDEZ',3,'2007-11-06','SLS',6,42841.00,10628.00),
   ('JOSE','SORIANO SANZ',1,'2004-04-07','FLD',10,23972.00,8970.00),
   ('ANA FELICIA','STURM CLIMENT',5,'2007-12-08','DES',7,35880.00,5398.00),
   ('LUCIA','CASCALES ABAD',4,'2005-11-18','SLS',9,27269.00,6990.00),
   ('DAVID','ALFARO VIDAL',4,'2005-10-23','ANL',7,36880.00,4458.00),
   ('FERNANDO AGUSTIN','LLUNA IRANZO',2,'2006-01-04','PRES',9,45532.00,1087.00),
   ('EDUARD','BENET TORAN',5,'2007-07-05','MGR',5,32148.00,7682.00),
   ('MIGUEL ANGEL','SANCHO',2,'2007-09-24','SLS',9,31503.00,8706.00),
   ('EDUARDO','TELLEZ GARCIA',5,'2006-11-24','FLD',7,22563.00,943.00),
   ('MARIA DEL CARMEN','OSUNA SANZ',5,'2007-03-18','DES',5,29747.00,2414.00),
   ('SERGIO','MARQUEZ',4,'2007-08-27','SLS',5,24331.00,6234.00),
   ('FRANCISCO LAZARO','ALGARIN LOPEZ',3,'2006-12-05','DES',9,21210.00,1581.00),
   ('ELVIRA','FUSTER CAMPOS',4,'2005-07-09','SLS',9,25454.00,4792.00),
   ('JOAQUIN','COLLADO LOPEZ',2,'2006-08-23','DES',5,41996.00,2737.00),
   ('DARIO','ROIG SANCHEZ',4,'2005-06-23','SLS',8,23610.00,8102.00),
   ('GEMA','MARTINEZ ARIAS',2,'2005-03-10','FLD',8,13491.00,1948.00),
   ('RAFAEL','BOLUDA ALVAREZ',2,'2004-04-02','SLS',5,13725.00,1031.00),
   ('JESUS','SORLI ADAME',5,'2007-05-24','ANL',10,40365.00,1679.00),
   ('MARIA AMPARO','PRIETO AGUILA',3,'2005-10-16','MGR',6,39194.00,1209.00),
   ('CHRISTOPHE','ESTEVE CARBO',2,'2007-01-03','SLS',11,23983.00,2017.00),
   ('EUSTASIO','PERIS BOU',2,'2005-07-27','FLD',9,40660.00,4954.00),
   ('ZULEMA','GARCIA FONFRIA',4,'2006-04-06','SLS',10,42871.00,2817.00),
   ('MARIA TERESA','RODRIGUEZ FAYOS',3,'2004-07-24','SLS',12,21908.00,7878.00),
   ('DAVINIA','MAESO SORIANO',3,'2005-07-15','DES',11,38799.00,6083.00),
   ('SERGIO','EDO LORENTE',4,'2005-03-12','SLS',7,12832.00,6116.00),
   ('BLANCA','RIBERA HERRERO',5,'2004-03-11','SLS',6,36293.00,10848.00),
   ('LUIS','ROMERO MARCH',2,'2004-12-04','FLD',7,39623.00,5952.00),
   ('FRANCISCO JAVIER','ANSON FERRER',2,'2005-08-19','FLD',7,25059.00,6595.00),
   ('LUIS FRANCISCO','RAMON MORENO',4,'2004-04-15','DES',10,40847.00,1516.00),
   ('ROBERTO','LUCAS MERENCIANO',2,'2005-02-27','PRES',7,28818.00,5489.00),
   ('ANGEL','CRUZ',1,'2004-01-09','DES',9,39805.00,2241.00),
   ('JORGE','PERIS GIMENO',3,'2004-12-13','DES',6,43051.00,7265.00),
   ('MARIA','ALMENAR BALLESTER',3,'2005-03-18','DES',12,29951.00,2315.00),
   ('SERGIO','TUDELA MORELL',3,'2005-02-11','SLS',6,31007.00,8776.00),
   ('DAVID','BOU VILAR',2,'2007-06-22','PRES',10,39506.00,3196.00),
   ('ENRIQUE CARLOS','LLOREDA BOU',3,'2006-05-08','MGR',11,13079.00,2924.00),
   ('ENRIQUE','LOPEZ PENALVA',3,'2007-09-02','ANL',10,45430.00,7071.00),
   ('VANESA','SURIA NAVAS',3,'2004-06-10','SLS',9,32331.00,3689.00),
   ('CARLOS','ARANDIGA SANCHEZ',4,'2007-11-20','FLD',9,28599.00,7325.00),
   ('TOBIAS','JORNET ALOCEN',2,'2006-01-09','FLD',5,25192.00,2798.00),
   ('ABRAHAM','NUÑEZ MONTERDE',3,'2007-12-08','ANL',7,27557.00,9760.00),
   ('JAVIER','OLIVER GRAU',3,'2006-03-20','SLS',5,31376.00,4392.00),
   ('JOSE IGNACIO','BARBERA RUIZ',5,'2004-02-04','MGR',7,19539.00,3702.00),
   ('RAUL','SORIANO IVARS',5,'2006-11-27','SLS',9,23575.00,8632.00),
   ('AARON','PEREZ SANCHEZ',4,'2005-07-03','SLS',10,17496.00,8575.00),
   ('ADOLFO JOSE','GARCIA SOLER',3,'2004-08-24','DES',7,28699.00,338.00);
-- ***********************************************
-- **                                           **
-- **  GESTORES DE DEPARTAMENTO.                **
-- **                                           **
-- ***********************************************
UPDATE Departamentos
   SET manager = 20
 WHERE idDepartamento = 1;

UPDATE Departamentos
   SET manager = 11
 WHERE idDepartamento = 2;

UPDATE Departamentos
   SET manager = 13
 WHERE idDepartamento = 3;

UPDATE Departamentos
   SET manager = 3
 WHERE idDepartamento = 4;

UPDATE Departamentos
   SET manager = 38
 WHERE idDepartamento = 5;

-- ***********************************************
-- **                                           **
-- **  PROYECTOS.                               **
-- **                                           **
-- ***********************************************
INSERT INTO Proyectos (nombre, nomclave, departamento, responsable, proPrincipal)
  VALUES 
    ('SERVICIO DE CONSULTA', 'SC2011', 3, 39, NULL),
    ('FORMACION DE USUARIOS', 'FU2012', 3, 6, NULL),
    ('DOCUMENTACION', 'DA2012', 4, 38, 2),
    ('PROGRAMACION DE SISTEMAS', 'PA2013', 4, 45, 3),
    ('SOPORTE DE SISTEMAS', 'SK2011', 5, 2, NULL),
    ('SOPORTE DE APLICACIONES', 'SK2012', 5, 34, 5);

-- ***********************************************
-- **                                           **
-- **  PARTICIPACION EN PROYECTOS.              **
-- **                                           **
-- ***********************************************
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (12, 1, '2011-01-10', '2011-06-13');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (6, 1, '2011-06-13', '2011-11-19');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (11, 1, '2011-03-18', '2011-07-02');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (25, 1, '2011-08-03', '2011-12-22');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (33, 1, '2011-09-28', '2012-01-02');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (8 , 1, '2011-12-16','2012-01-15');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (49, 1, '2011-07-27','2012-01-04');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (28, 1, '2011-03-04', '2011-03-09');

INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (45, 2, '2012-07-24', '2012-10-05');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (61, 2, '2012-02-20', '2012-09-08');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (57, 2, '2012-09-15', '2013-01-21');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (36, 2, '2012-05-17', '2012-08-05');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (16, 2, '2012-01-06','2012-03-12');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (23, 2, '2012-12-17', '2013-03-16');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (31, 2, '2012-06-07', '2012-12-25');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (50, 2, '2012-05-08', '2012-06-08');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (62, 2, '2012-06-09', '2012-07-16');

INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (10, 3, '2012-05-22', '2012-10-08');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (11, 3, '2012-07-15', '2012-07-20');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (15, 3, '2012-05-25', '2012-10-29');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (29, 3, '2012-07-19', '2012-08-07');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (41, 3, '2012-10-24', '2013-01-18');

INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (14, 4, '2013-01-10', NULL);

INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (2, 5, '2011-05-08', '2011-10-26');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (23, 5, '2011-03-17', '2011-05-01');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (42, 5, '2011-07-08', '2012-01-24');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (36, 5, '2011-10-21', '2012-02-17');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (59, 5, '2011-06-15', '2011-12-08');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (34, 5, '2011-09-22', '2011-12-03');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (57, 5, '2011-06-07', '2011-06-24');

INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (26, 6, '2012-01-02', '2013-02-12');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (42, 6, '2012-11-09', '2013-02-21');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (14, 6, '2012-01-07', '2012-03-16');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (55, 6, '2012-05-15', '2012-06-06');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (24, 6, '2012-01-01', '2012-04-18');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (60, 6, '2011-06-14', '2012-08-19');
INSERT INTO Participa (idEmpleado, idProyecto, fechaInicio, fechaFin)
  VALUES (33, 6, '2012-01-11', '2013-01-27');
