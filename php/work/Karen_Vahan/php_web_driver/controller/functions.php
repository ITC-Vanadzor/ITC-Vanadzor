<?php

include '../database/functions_db.php';

//$user_name = $_POST["username"];
$user_name = "vmjtiybyrjfzltb";
//$app_name = $_POST["appname"];
$app_name = "ekdxdtuzhncacfj";

//Main
//add_history($user_name, $app_name);
var_dump(get_history("history"));

//Add data in history by user name and application name
function add_history($user_name, $app_name){
	$conn = check_connection_db("my_web_db");
	$user_id = get_id($user_name,"users");
	$app_id = get_id($app_name,"apps");
	$time = date('Y-m-d h:i:s');
	$sql = "INSERT INTO history (user_id, app_id, time)
		VALUES ('".$user_id."', '".$app_id."', '".$time."')";

	if ($conn->query($sql) === TRUE) {
		echo "New record created successfully";
	} else {
		echo "Error: " . $sql . "<br>" . $conn->error;
	}
	$conn->close();
}

//Get id by name
function get_id($name,$table_name){
	$conn = check_connection_db("my_web_db");
	$sql = "SELECT * FROM ".$table_name." where name = '".$name."'";
	$result = $conn->query($sql);

	if ($result->num_rows > 0) {
		// output data of each row
		while($row = $result->fetch_assoc()) {
			return $row["id"];
		}
	} else {
		return false;
	}

	//Close connection DB
	$conn->close();
}


function get_history($table_name){
	$conn = check_connection_db("my_web_db");
	$sql = "SELECT * FROM ".$table_name;
    $result = $conn->query($sql);
    $table_array=array();

	if ($result->num_rows > 0) {
		// output data of each row
		while($row = $result->fetch_assoc()) {
			$table_array[] = $row;
		}
	} else {
		return false;
	}
    return $table_array;
	//Close connection DB
	$conn->close();
}
