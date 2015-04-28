<?php

//1.conectar base de datos
$conexion=mysqli_connect("localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect with the DataBase..';
exit;
}

print "<p> CREATE CITY </p>";

$id=$_REQUEST['id'];
$nom=$_REQUEST['nombre'];

if(!$id)	
{
print "<p> You must provode an identifier </p>";	
}
else if(!$nom)	
{
print "<p> You must provide a name </p>";	
}
else
{
//buscar id entre las naves nodrizas existentes
$consulta="SELECT * FROM Cities where idCities='$id'";
$result_consulta=mysqli_query($conexion,$consulta);
$num_result_consulta=mysqli_num_rows($result_consulta);
if($num_result_consulta)
{
print "<p> Duplicated identifier, please provide another one. </p>";
}
else
{
//insertar datos en base de datos
$inserta="INSERT INTO Cities VALUES ('$id','$nom')";
$result_inserta=mysqli_query($conexion, $inserta);
//$num_result=mysqli_affected_rows($conexion);
print "<p> The city ".$nom." has been successfully created :-)</p>";



/*print "<p> Listado de naves nodrizas existentes: </p>";
//mostrar registros en pantalla una vez insertados
//Leyendo datos almacenados en la base de datos
$consulta="SELECT * FROM Cities";
$resultado=mysqli_query($conexion, $consulta);
//numero de filas seleccionadas
$num=mysqli_num_rows($resultado);

for($i=0; $i<$num; $i++)
{
$fila=mysqli_fetch_row($resultado);
print "<p> Identificador nave: " .$fila[0]. ". Nombre nave nodriza: " .$fila[1]."</p>";
}*/
}
}
print "<p>---------------------------------------------------------------------------<br></p>";
echo "EXISTING CITIES IN THE SYSTEM:";

$consulta="SELECT * FROM Cities";
$resultado=mysqli_query($conexion, $consulta);
$num=mysqli_num_rows($resultado);

for($i=0; $i<$num; $i++)
{
$fila=mysqli_fetch_row($resultado);
print "<p> City identifier: " .$fila[0]. ". City name: " .$fila[1]."</p>";
}
mysqli_close($conexion); 



?>
<a href="https://localhost/BusPHP/index.html"> <font color="#cc0000"><strong>Go back the main page</strong></font>
<br>
<br>