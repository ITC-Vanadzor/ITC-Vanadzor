<?php 

//Create connection on DB
function check_connection_db($db_name=false){
	$servername = "localhost";
	$username = "root";
	$password = "student2014";
	if($db_name){
		$conn = new mysqli($servername, $username, $password,$db_name);
	}else{
		$conn = new mysqli($servername, $username, $password);
	}
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 
	return $conn;
}

?>