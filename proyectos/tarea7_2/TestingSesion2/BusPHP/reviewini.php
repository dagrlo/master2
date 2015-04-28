<form method="get" action="review.php">
<p>  REVIEWING BUS </p>
<p> Review identifier: <input type="text" name="idRevision" /></p> 
<p> Reviewer name: <input type="text" name="nombreRevisor" /></p> 
<?php

$conexion=mysqli_connect("localhost", "udb","pudb", "Buses");

if(mysqli_connect_errno())
{
echo 'Error, I cannot connect the DataBase..';
exit;
}

echo "<p> Bus identifier: <select name='id_Buses_r'></p>";
$consulta_Buses="SELECT idBus FROM Buses";
$res_consulta_Buses=mysqli_query($conexion, $consulta_Buses);

while($rdo_Buses=mysqli_fetch_array($res_consulta_Buses)){
		echo "<option>" . $rdo_Buses['idBus'] . "</option>";
}
echo "</select>";
?>


<p> Date: <input type="text" name="fecha_revision" /></p>
<p><input type="submit" value="Submit" /></p>
</form>