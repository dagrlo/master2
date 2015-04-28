<?php
//1.conectar base de datos
$conexion=mysqli_connect(  "localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect the DataBase..';
exit;
}

echo "BUS-PASSENGER LIST:";



$consulta_Buses="SELECT * FROM Buses";
$resultado_Buses=mysqli_query($conexion, $consulta_Buses);
$num_Buses=mysqli_num_rows($resultado_Buses);


for($i=0; $i<$num_Buses; $i++)
{
$fila_Buses=mysqli_fetch_assoc($resultado_Buses);
print "<p> Bus identifier: ".$fila_Buses[idBus]."</p>";
//buscamos los Passengerss que se encuentran en esa Buses
$consulta_Passengers="SELECT * FROM Passengers where idBus='$fila_Buses[idBus]'";
$resultado_Passengers=mysqli_query($conexion, $consulta_Passengers);
$num_Passengers=mysqli_num_rows($resultado_Passengers);

	while($fila_Passengers=mysqli_fetch_array($resultado_Passengers))
	{
		print "<p>-------------> Passenger identifier: ".$fila_Passengers['idPassenger']."</p>";
		
	}//while
	
}//1for

mysqli_close($conexion); 

?>

<a href="https://localhost/BusPHP/index.html"> <font color="#cc0000"><strong>Go back to the main page</strong></font>
<br>
<br>