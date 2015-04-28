<?php

//1.conectar base de datos
$conexion=mysqli_connect("localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect with the database..';
exit;
}

print "<p> CREATING BUS </p>";


//insertar datos en base de datos
$id=$_REQUEST['id'];
$nom=$_REQUEST['nombre'];
$numMax=$_REQUEST['max_marcianos'];
$naveNodOrig=$_REQUEST['nave_origen'];
$naveNodDest=$_REQUEST['nave_destino'];

if(!$id)
{
print "<p> You must provide a bus identifier </p>";	
}
else if(!$nom)	
{
print "<p> You must provide the name of the bus</p>";	
}
else if(!$numMax)
{
print "<p> You must provide the maximum number of passengers </p>";
}
else if(!$naveNodOrig)
{
print "<p> You must provide a source city </p>";
}
 else if(!$naveNodDest)
{
print "<p> You must provide a destination city</p>";
} 

else
{
 //comprobar que nave nodriza origen y destino existan
$consulta_nnorigen="SELECT * FROM Cities where nameCity='$naveNodOrig'";
$resultado_consulta_nnorigen=mysqli_query($conexion, $consulta_nnorigen);
//numero de filas seleccionadas
$num_consulta_nnorig=mysqli_num_rows($resultado_consulta_nnorigen);
if(!$num_consulta_nnorig)
{
print "<p>Bus could not be created. Source city does not exist </p>";
print "<p> Existing cities are: </p>";
$consulta_orig="SELECT * FROM Cities";
$resultado_orig=mysqli_query($conexion, $consulta_orig);
$num=mysqli_num_rows($resultado_orig);
//listado nave nodrizas existentes..
for($i=0; $i<$num; $i++)
{
$fila=mysqli_fetch_row($resultado_orig);
print "<p> City identifier: " .$fila[0]. ". City name: " .$fila[1]."</p>";
}
}//if

$consulta_nndestino="SELECT * FROM Cities where nameCity='$naveNodDest'";
$resultado_consulta_nndest=mysqli_query($conexion, $consulta_nndestino);
//numero de filas seleccionadas
$num_consulta_nndest=mysqli_num_rows($resultado_consulta_nndest);
if(!$num_consulta_nndest)
{
print "<p>Bus could not be created. Destination city does not exist </p>";
print "<p> Existing cities are: </p>";
$consulta="SELECT * FROM Cities";
$resultado=mysqli_query($conexion, $consulta);
//numero de filas seleccionadas
$num=mysqli_num_rows($resultado);

for($i=0; $i<$num; $i++)
{
$fila=mysqli_fetch_row($resultado);
print "<p> City identifier: " .$fila[0]. ". City name: " .$fila[1]."</p>";
}
}//if

 if($num_consulta_nndest && $num_consulta_nnorig)
 {
$inserta="INSERT INTO Buses VALUES ( '$id','$nom', '$numMax', '$naveNodOrig', '$naveNodDest')";
$result_inserta=mysqli_query($conexion, $inserta);

print "<p> Bus created successfully. </p>";
}

}//else
echo "----------------------------------------------<br>";
echo "EXISTING BUSES:";

$consulta="SELECT * FROM Buses";
$resultado=mysqli_query($conexion, $consulta);
$num=mysqli_num_rows($resultado);

for($i=0; $i<$num; $i++)
{
$fila=mysqli_fetch_row($resultado);
print "<p> Bus identifier: ".$fila[0]. ". Busname: " .$fila[1].". Maximum number of passengers: ".$fila[2].". Source city: ".$fila[3].". Destination city: ".$fila[4]. ". </p>";
}


mysqli_close($conexion); 
?>

<a href="https://localhost/BusPHP/index.html"> <font color="#cc0000"><strong>Go back to the main page</strong></font>
<br>
<br>