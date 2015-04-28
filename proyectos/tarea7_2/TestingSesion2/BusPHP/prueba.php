<form method="post" action="prueba.php">
<?php

$conexion=mysqli_connect(  "localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect the DataBase..';
exit;
}

echo "<p> Passenger id: <select name='seleccion_Passengers'></p>";
$consulta="SELECT idPassengers FROM Passengers";
$res_consulta=mysqli_query($conexion, $consulta);

while($rdo=mysqli_fetch_array($res_consulta)){
		echo "<option>" . $rdo['idPassengers'] . "</option>";
}
echo "</select>";
echo "<p> Bus identifier: <select name='seleccion_Buses'></p>";
$consulta_Buses="SELECT idBuses FROM Buses";
$res_consulta_Buses=mysqli_query($conexion, $consulta_Buses);

while($rdo_Buses=mysqli_fetch_array($res_consulta_Buses)){
		echo "<option>" . $rdo_Buses['idBuses'] . "</option>";
}
echo "</select>";
?>
</form>