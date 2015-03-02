<?php
	include "../database/functions_db.php";
	
	$conn = check_connection_db("Computers");
 
	
	function getTableColumn($conn,$column) {
		$sql = 'SELECT name FROM '.$column;
	    foreach ($conn->query($sql) as $row) {
	        $pesponce[] = $row['name'];
	    }
	    return '{"names" : ['.'"'.implode('","',$pesponce).'"'.']}';
	}
	$json = getTableColumn($conn,$_GET["tablename"]);
	echo $json;
?>
