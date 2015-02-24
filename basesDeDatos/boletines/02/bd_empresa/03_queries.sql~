-- Seleccionar columnas
SELECT *
  FROM Departamentos;
-- Seleccionar algunas columnas
SELECT idEmpleado, nombre, apellidos, fechaContrato, puesto
  FROM Empleados;
-- Seleccionar columnas derivadas, dar nombre a columnas derivadas
SELECT nombre, apellidos, sueldo + complemento AS salario_total
  FROM Empleados;
-- Eliminación de columnas duplicadas
SELECT DISTINCT administrador
  FROM Departamentos;
-- Concatenacion
SELECT CONCAT(apellidos,',',nombre) AS Nombre
  FROM Empleados;
-- Calculo de valores en una columna
SELECT idEmpleado,
       sueldo / 12 AS Sueldo_Mensual,
       sueldo / 52 AS Sueldo_Semanal
  FROM Empleados
 WHERE departamento = 'A00';
 -- Calculo de valores agregados
 SELECT SUM(sueldo) AS sueldoSuma,
        MIN(sueldo) AS sueldoMin,
        AVG(sueldo) AS sueldoMedio,
        MAX(sueldo) AS sueldoMax,
        COUNT(*) AS nominas
   FROM Empleados
  WHERE departamento = 'C01';
-- Dando formato al informe
SELECT YEAR(MAX(fechaContrato)) AS ultimaContratacion
  FROM Empleados
 WHERE departamento = 'E21';
-- Salida numerica con formato
SELECT FORMAT(AVG(sueldo), 2)
  FROM Empleados;
-- La expresión CASE
SELECT nombre, apellidos,
        CASE
          WHEN nivelEducacion <= 1                        THEN 'Elemental'
          WHEN nivelEducacion >  1 AND nivelEducacion < 3 THEN 'Bachiller'
          WHEN nivelEducacion >= 3 AND nivelEducacion < 6 THEN 'FP'
          WHEN nivelEducacion >= 6 AND nivelEducacion < 8 THEN 'Diplomado'
          WHEN nivelEducacion >= 8 AND nivelEducacion <10 THEN 'Licenciado'
          ELSE 'Doctor'
        END
    AS Educacion
  FROM Empleados;
-- Otro tipo de operaciones
SELECT nombre, apellidos, fechaContrato
  FROM Empleados
 WHERE fechaContrato < '2005-01-01';
-- Uso de operaciones en el WHERE
SELECT departamento, idEmpleado
  FROM Empleados
 WHERE NOT (sueldo + complemento) > 35000
   AND puesto = 'MGR'
 ORDER BY departamento;
-- Busqueda de caracteres similares
SELECT nombre, apellidos, departamento
  FROM Empleados
 WHERE apellidos LIKE 'LO%';
-- Rango de valores
SELECT idDepartamento, manager
  FROM Departamentos
 WHERE idDepartamento BETWEEN 'C00' AND 'D31';
-- Uso de la clausula IN
SELECT idDepartamento, manager
  FROM Departamentos
 WHERE idDepartamento IN ('B01','C01','D11');
-- Ordenación
SELECT idEmpleado, apellidos, fechaContrato
  FROM Empleados
 WHERE departamento = 'A00'
 ORDER BY fechaContrato ASC;
-- Agrupamiento
 SELECT departamento, puesto, AVG(sueldo) AS sueldoMedio
   FROM Empleados
  WHERE departamento IN ('D11', 'E21')
  GROUP BY departamento, puesto;
-- Otras clausulas...
 SELECT e.apellidos, e.nombre,
        SUM(DATEDIFF(ep.fechaFin,ep.fechaInicio)) AS diasTrabajados
   FROM Empleados e, Participa ep
  WHERE e.idEmpleado = ep.idempleado
  GROUP BY e.apellidos, e.nombre;

SELECT p.idProyecto, p.nombre,
       SUM(DATEDIFF(ep.fechaFin,ep.fechaInicio)) AS diasDedicados
  FROM Proyectos p, Participa ep
 WHERE p.idProyecto = ep.idProyecto
 GROUP BY p.idProyecto, p.nombre;
