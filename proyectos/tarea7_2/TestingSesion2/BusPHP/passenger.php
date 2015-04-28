<?php

//1.conectar base de datos
$conexion=mysqli_connect("localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect with the DataBase..';
exit;
}

print "<p> PASSENGERS MANAGEMENT: INSERT A PASSENGER </p>";


if(isset($_REQUEST['seleccion_Passengers']) && $_REQUEST['seleccion_Passengers'] != null)	$Passengers=$_REQUEST['seleccion_Passengers'];
if(isset($_REQUEST['seleccion_Buses']) && $_REQUEST['seleccion_Buses'] != null)	$nave=$_REQUEST['seleccion_Buses'];	

//comprobar que no hay campos vacios en el form
/*if(!$Passengers)	
{
print "<p> Tienes que introducir el nombre </p>";	
exit;
}
else if(!$nave)
{
print "<p> Tienes que introducir la nave </p>";
exit;
}
else
{
//comprobar que el Passengers existe en el sistema
$consulta_Passengers="SELECT * FROM Passengers where idPassengers='$Passengers'";
$result_consulta_Passengers=mysqli_query($conexion, $consulta_Passengers);
$num_result_consulta_Passengers=mysqli_num_rows($result_consulta_Passengers);

	if(!$num_result_consulta_Passengers)
	{
	print "<p> Passengers no existe en el sistema. Para su creacion ir a Crear Passengers \n </p>";
	}

//comprobar que la nave existe en el sistema
$consulta_Buses="SELECT * FROM Buses where idBuses='$nave'";
$result_consulta_Buses=mysqli_query($conexion, $consulta_Buses);
$num_result_consulta_Buses=mysqli_num_rows($result_consulta_Buses);

	if(!$num_result_consulta_Buses)
	{
	print "<p> Buses no existe en el sistema. Para su creacion ir a Crear Buses \n </p>";
	}*/

//comprobar cuantos Passengerss tiene la nave cuyo id se ha introducido en el form
$consulta_Passengerss_nave="SELECT idPassenger FROM Passengers where idBus='$nave'"; 
$res_Passengerss_nave=mysqli_query($conexion, $consulta_Passengerss_nave);
$num_Passengerss_nave=mysqli_num_rows($res_Passengerss_nave);


//obtener el maxMarcianos de la nave dada en el formulario
$consulta_numMax="SELECT * FROM Buses where idBus='$nave'";
$res_consulta_numMax=mysqli_query($conexion, $consulta_numMax);
$num_res_consulta_numMax=mysqli_num_rows($res_consulta_numMax);

//buscar si el Passengers ya esta en una nave
$consulta_Passengers_nonave="SELECT * FROM Passengers where idPassenger='$Passengers' and idBus='0'";
$result_consulta_Passengers_nonave=mysqli_query($conexion, $consulta_Passengers_nonave);
$num_result_consulta_Passengers_nonave=mysqli_num_rows($result_consulta_Passengers_nonave);

	if($num_res_consulta_numMax>0)
	{
	$numMax_marc=mysqli_fetch_assoc($res_consulta_numMax);
	}

	if($numMax_marc[maxPassengers]==$num_Passengerss_nave)
	{
	print "<p> Error inserting the passenger with identifier ".$Passengers." in the bus with identifier:  ".$nave.", Bus full!</p>";
	}
	else if($num_result_consulta_Passengers_nonave == 1)
	{
	$modificar="UPDATE Passengers SET idBus='$nave' where idPassenger='$Passengers'";
	$consulta_insertar=mysqli_query($conexion, $modificar);
	$num_result_consulta=mysqli_affected_rows($conexion);
		if($num_result_consulta)
		{
			print "<p> The passenger with identifier: ".$Passengers." has been inserted in the bus with identifier:  ".$nave."</p>";
		}

	}
	else
	{
		print "<p> Error when inserting the passenger with identifier ".$Passengers." in the bus with identifier:  ".$nave.", Passenger in other bus!</p>";

	}
	
	//}//if($numMax_marc > $num_Passengerss_nave)

//}//else
//cerrar conexion
mysqli_close($conexion); 

?>

<a href="https://localhost/BusPHP/index.html"> <font color="#cc0000"><strong>Go back to the main page</strong></font>
<br>
<br>