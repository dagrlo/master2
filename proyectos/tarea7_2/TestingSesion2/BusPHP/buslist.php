<?php
//1.conectar base de datos
$conexion=mysqli_connect(  "localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect with the DataBase..';
exit;
}
echo "EXISTING BUSES IN THE SYSTEM:";

$consulta="SELECT * FROM Buses";
$resultado=mysqli_query($conexion, $consulta);
$num=mysqli_num_rows($resultado);

for($i=0; $i<$num; $i++)
{
$fila=mysqli_fetch_row($resultado);
print "<p> Bus identifier: ".$fila[0]. ". Bus name: " .$fila[1].". Maximum number of passengers: ".$fila[2].". Source city: ".$fila[3].". Destination city: ".$fila[4]. ". </p>";
}

mysqli_close($conexion); 

?>