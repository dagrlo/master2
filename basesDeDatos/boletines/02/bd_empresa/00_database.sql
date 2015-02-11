-- ***************************************************************
-- **                                                           **
-- ** GESTION DE EMPLEADOS DEPARTAMENTOS Y PROYECTOS.           **
-- **                                                           **
-- ** Base de datos: empresa                                    **
-- ** Usuario: recursos                                         **
-- ** Password: recpwd                                          **
-- **                                                           **
-- ** Script de creación de la base de datos y del usuario.     **
-- **                                                           **
-- ***************************************************************
CREATE DATABASE empresa;
GRANT ALL ON empresa.* TO recursos@'%' IDENTIFIED BY 'recpwd'
   WITH GRANT OPTION;
GRANT ALL ON empresa.* TO recursos@localhost IDENTIFIED BY 'recpwd'
   WITH GRANT OPTION;
