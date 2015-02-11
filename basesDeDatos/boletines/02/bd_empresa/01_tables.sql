-- ***************************************************************
-- **                                                           **
-- ** GESTION DE EMPLEADOS DEPARTAMENTOS Y PROYECTOS.           **
-- **                                                           **
-- ** Base de datos: empresa                                    **
-- ** Usuario: recursos                                         **
-- ** Password: recpwd                                          **
-- **                                                           **
-- ** Script de creación de las tablas.                         **
-- **                                                           **
-- ***************************************************************
USE empresa;
-- **************************************
-- **                                  **
-- ** DEPARTAMENTOS                    **
-- **                                  **
-- **************************************
CREATE TABLE Departamentos
(
   idDepartamento  INT NOT NULL AUTO_INCREMENT,
   nombre          VARCHAR(36)        NOT NULL,
   manager         INT            DEFAULT NULL,
   CONSTRAINT Deptos_idDepto_PK
      PRIMARY KEY (idDepartamento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- **************************************
-- **                                  **
-- ** EMPLEADOS                        **
-- **                                  **
-- **************************************
CREATE TABLE Empleados
(
   idEmpleado      INT NOT NULL AUTO_INCREMENT,
   nombre          VARCHAR(20)        NOT NULL,
   apellidos       VARCHAR(50)        NOT NULL,
   departamento    INT                NOT NULL,
   fechaContrato   DATE                       ,
   puesto          CHAR(8)                    ,
   nivelEducacion  SMALLINT                   ,
   sueldo          DECIMAL(9,2)               ,
   complemento     DECIMAL(9,2)               ,
   CONSTRAINT Emp_idEmp_PK
      PRIMARY KEY (idEmpleado),
   CONSTRAINT Emp_depto_FK
      FOREIGN KEY (departamento)
         REFERENCES Departamentos (idDepartamento)
         ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE Departamentos
   ADD CONSTRAINT Depto_manager_FK
      FOREIGN KEY (manager)
         REFERENCES Empleados (idEmpleado)
         ON DELETE RESTRICT;

-- **************************************
-- **                                  **
-- ** PROYECTOS                        **
-- **                                  **
-- **************************************
CREATE TABLE Proyectos
(
   idProyecto    INT NOT NULL AUTO_INCREMENT,
   nombre        VARCHAR(30)        NOT NULL,
   nomclave      CHAR(8)                    ,
   departamento  INT                NOT NULL,
   responsable   INT                NOT NULL,
   proPrincipal  INT            DEFAULT NULL,
   CONSTRAINT Proy_idProy_PK
      PRIMARY KEY (idProyecto),
   CONSTRAINT Proy_depto_FK
      FOREIGN KEY (departamento)
         REFERENCES Departamentos (idDepartamento)
         ON DELETE RESTRICT,
   CONSTRAINT Proy_respon_FK
      FOREIGN KEY (responsable)
         REFERENCES Empleados (idEmpleado)
         ON DELETE RESTRICT,
   CONSTRAINT Proy_proPrin_FK
      FOREIGN KEY (proPrincipal)
         REFERENCES Proyectos (idProyecto)
         ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- **************************************
-- **                                  **
-- ** ENTIDAD DE INTERSECCION EMPLEADO **
-- ** Y PROYECTO.                      **
-- **                                  **
-- **************************************
CREATE TABLE Participa
(
   idEmpleado    INT  NOT NULL,
   idProyecto    INT  NOT NULL,
   fechaInicio   DATE NOT NULL,
   fechaFin      DATE,
   CONSTRAINT Part_idEmp_idProy_PK
      PRIMARY KEY (idEmpleado, idProyecto),
   CONSTRAINT Part_idEmp_FK
      FOREIGN KEY (idEmpleado)
         REFERENCES Empleados (idEmpleado)
         ON DELETE RESTRICT,
   CONSTRAINT Part_idProy__FK
      FOREIGN KEY (idProyecto)
         REFERENCES Proyectos (idProyecto)
         ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


