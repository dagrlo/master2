<?php

//1.conectar base de datos
$conexion=mysqli_connect(  "localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect with the DataBase..';
exit;
}

print "<p> PASSENGERS MANAGEMENTS: GET OUT A PASSENGER </p>";

/*$idAnave=$_REQUEST['idBuses'];	
$idPassengers=$_REQUEST['idPassengers'];*/
if(isset($_REQUEST['seleccion_Passengers']) && $_REQUEST['seleccion_Passengers'] != null)	$Passengers=$_REQUEST['seleccion_Passengers'];
//if(isset($_REQUEST['seleccion_Buses']) && $_REQUEST['seleccion_Buses'] != null)	$nave=$_REQUEST['seleccion_Buses'];	


//comprobar que no hay campos vacios en el form
/*if(!$nave)
{
print "<p>VALUE FOR IDPASENGER".$Passengers."</p>";
print "<p>VALUE FOR IDBUS".$nave."</p>";
print "<p> You must provide the bus identifier</p>";
exit;
}
else if(!$Passengers)	
{
print "<p> You must specify the passenger's identifier </p>";
exit;
}

else
{
//buscar Passengers
$consulta="SELECT * FROM Passengers where idPassengers='$Passengers'";
$result_consulta=mysqli_query($conexion,$consulta);
$num_result_consulta=mysqli_num_rows($result_consulta);
if(!$num_result_consulta)
{
print "<p> Passenger does not exist in the system. You must go to Create passenger to create a new one </p>";
}*/

//if($num_result_consulta)
//{

	//modificar de la base de datos Passengers su idNave
	$modificar="UPDATE Passengers SET idBus='0' where idPassenger='$Passengers'";
	$consulta_insertar=mysqli_query($conexion, $modificar);
	$num_result_consulta=mysqli_affected_rows($conexion);
		if($num_result_consulta)
		{
		print "<p> Passenger with identifier: ".$Passengers." has got out the bus. </p>";
		}
		else 
		{
		print "<p> Error, passenger is not in the bus currently </p>";
		}
	//}

//}//else
//cerrar conexion
mysqli_close($conexion); 

?>

<a href="https://localhost/BusPHP/index.html"> <font color="#cc0000"><strong>Go back to the main page</strong></font>
<br>
<br>