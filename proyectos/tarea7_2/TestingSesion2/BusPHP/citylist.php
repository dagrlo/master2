<?php
//1.conectar base de datos
$conexion=mysqli_connect(  "localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect the DataBase..';
exit;
}
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