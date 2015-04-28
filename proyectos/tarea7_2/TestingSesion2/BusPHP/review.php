<?php

//1.conectar base de datos
$conexion=mysqli_connect("localhost", "udb","pudb", "buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect the DataBase..';
exit;
}

print "<p> BUS REVIEW </p>";

$idRevision=$_REQUEST['idRevision'];
$nomRevisor=$_REQUEST['nombreRevisor'];
$idBus=$_REQUEST['id_Buses_r'];
$fecha=$_REQUEST['fecha_revision'];
//var_dump($idRevision);die;
if(!$idRevision)
{
print "<p> You must provide the review identifier</p>";	
}
else if(!$nomRevisor)	
{
print "<p> You must provide the reviewer name</p>";	
}
else if(!$idBus)
{
print "<p> You must provide the bus identifier </p>";
}
else if(!$fecha)
{
print "<p> You must provide the review date</p>";
}


else
{
//comprobamos que la fecha no esté en la tabla Reviewse para esa Bus en concreto
$consulta_fecha="SELECT * FROM Reviews where date='$fecha' and idBus='$idBus'";
$res_consulta_fecha=mysqli_query($conexion, $consulta_fecha);
$num_res_consulta_fecha=mysqli_num_rows($res_consulta_fecha);



//comprobamos que la Bus no esté en la tabla Reviews
//$consulta_Bus="SELECT * FROM Reviews where idBus='$idBus'";
//$res_consulta_Bus=mysqli_query($conexion, $consulta_Bus);
//$num_res_consulta_Bus=mysqli_num_rows($res_consulta_Bus);

//comprobamos que la Bus existe en el sistema
$consulta_Bus="SELECT * FROM Buses where idBus='$idBus'";
$result_consulta_Bus=mysqli_query($conexion, $consulta_Bus);
$num_result_consulta_Bus=mysqli_num_rows($result_consulta_Bus);


//buscar idRevision entre las revisiones existentes
$consulta_revision="SELECT * FROM Reviews where idReview='$idRevision'";
$result_consulta_revision=mysqli_query($conexion,$consulta_revision);
$num_result_consulta_revision=mysqli_num_rows($result_consulta_revision);
 

if($num_result_consulta_revision)
{
print "<p> Duplicated review identifier, please provide a new one. </p>";
}
else
{
	if(!$num_result_consulta_Bus)	
	{	
		print "<p> Bus does not exist in the system. To create it, please go to Create bus \n </p>";
	}
	else if($num_result_consulta_Bus)
	{	

		if($num_res_consulta_fecha)
		{
			print "<p> Bus already reviewed in date: ".$fecha."</p>";
		}
		else 
		{
			$listado="SELECT idPassenger FROM Passengers where idBus='$idBus'";
			$consulta_listado=mysqli_query($conexion, $listado);
			$num_consulta_listado=mysqli_num_rows($consulta_listado);
			
			if($num_consulta_listado > 0)
			{
			print "<p> The bus review could be done successfully in the specified date </p>";
			$Passengers_id;
			//for ($i=0; $i<$num_consulta_listado; $i++)
			while($fila=mysqli_fetch_array($consulta_listado))
			{
						
						print "<p> Passenger:".$fila[0]." </p>";
						$Passengers_id .= $fila['idPassenger'] . ", ";
						$insertar="INSERT INTO PassengerReview VALUES ('$fila[0]', '$idRevision')";
					$result_insertar=mysqli_query($conexion, $insertar);
					$num_result_insertar=mysqli_affected_rows($conexion);
						
			}//while
					$insertar="INSERT INTO Reviews VALUES ('$idRevision', '$nomRevisor', '$idBus', '$fecha')";
					$result_insertar=mysqli_query($conexion, $insertar);
					$num_result_insertar=mysqli_affected_rows($conexion);
			
			
			if($num_result_insertar)
			{
				print "<p> The review has been stored in the system successfully</p>";
			}//if
			}//if
			else
			{
				print "<p> There is no passenger in the bus ".$idBus." </p>";
			}
		}//else		
	}//elseif
	
}
}

print "<p> LIST OF REVIEWS </p>";
$consulta_revisiones="SELECT * FROM Reviews";
$result_consulta_revisiones=mysqli_query($conexion,$consulta_revisiones);
$num_result_consulta_revisiones=mysqli_num_rows($result_consulta_revisiones);
for($i=0; $i<$num_result_consulta_revisiones; $i++)
{
$fila=mysqli_fetch_row($result_consulta_revisiones);
print "<p> Review identifier: ".$fila[0]. ". Reviewer name: " .$fila[1].". Bus identifier: ".$fila[2].". Date: ".$fila[3].". List of passengers: ";

$consulta_par_revision_Passenger="SELECT P.namePassenger FROM PassengerReview PR, Passengers P WHERE PR.idReview='$fila[0]' AND PR.idPassenger=P.idPassenger";
$result_consulta_par_revision_Passenger=mysqli_query($conexion,$consulta_par_revision_Passenger);
$num_result_consulta_par_revision_Passenger=mysqli_num_rows($result_consulta_par_revision_Passenger);
//

//print "NumFILAS=".$num_result_consulta_par_revision_Passenger."";
	for($j=0; $j<$num_result_consulta_par_revision_Passenger; $j++){
	
	$fila_par_Passenger=mysqli_fetch_row($result_consulta_par_revision_Passenger);
	print $fila_par_Passenger[0] ;
	print " ";
	}
	print "</p>";
}
mysqli_close($conexion); 

?>

<a href="https://localhost/BusPHP/index.html"> <font color="#cc0000"><strong>Go back to the main page</strong></font>
<br>
<br>