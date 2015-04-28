<?php


//1.conectar base de datos
$conexion=mysqli_connect("localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect the DataBase..';
exit;
}

print "<p> PASSENGERS MANAGEMENT:CREATE PASSENGER </p>";

$id=$_REQUEST['id'];
$nom=$_REQUEST['nombre'];

//comprobar que no hay campos vacios en el form
if(!$id)	
{
print "<p> You must provide an identifier </p>";	
}
else if(!$nom)	
{
print "<p> You must provide a name </p>";	
}

else
{
//buscar Passengers
$consulta="SELECT * FROM Passengers where idPassengers='$id'";
$result_consulta=mysqli_query($conexion,$consulta);
$num_result_consulta=mysqli_num_rows($result_consulta);

if($num_result_consulta)
{
print "<p> The passenger already exists in the system. If you would like to include him in a bus, please go to passengers management</p>";
}
else if(!$num_result_consulta)
{//anyadir a bd Passengers
$consulta="INSERT INTO Passengers VALUES ('$id', '$nom', 0)";
$result_consulta=mysqli_query($conexion, $consulta);
$num_result_consulta=mysqli_affected_rows($conexion);
//print "<p> Resultado de insertar".$num_result_consulta." fila(s)</p>";
if($num_result_consulta)
{
print "<p> The passenger has been created successfully </p>";
}

}//elseif
}//else

//cerrar conexion
mysqli_close($conexion); 
?>


<a href="https://localhost/BusPHP/index.html"> <font color="#cc0000"><strong>Go back to the main page</strong></font>
<br>
<br>