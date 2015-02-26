<?php

$conn = mysqli_connect("127.0.0.1", "root", "student2014", "user_APP");
if (!$conn) {
	$con = mysqli_connect("127.0.0.1", "root", "student2014");
	if (!$conn) {
    	die('Could not connect: ' . mysqli_error());
	}
	createDB($conn);
}

function createDB($conn) {
	$myDB = 'CREATE DATABASE user_APP';
	if (mysqli_query($conn,$myDB)) {
    	echo "Database my_db created successfully\n";
  	}
	else {
    	echo 'Error creating database:  ' . mysqli_error() . "\n";
  	}
}

function createTable($table_name,$conn) {
	if (mysqli_query($conn,$table_name)) {
    	echo "Table ".$table_name." created successfully\n";
  	}
	else {
    	echo "Error creating table: " . mysqli_error();
  	}
}

$users = "CREATE TABLE IF NOT EXISTS Users(
		Id_user INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		name VARCHAR(15) NOT NULL,
		password VARCHAR(15) NOT NULL
		)";
createTable($users,$conn);
$app = "CREATE TABLE IF NOT EXISTS APP(
		Id_app INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
		app_name VARCHAR(25) NOT NULL
		)";
createTable($app,$conn);
$history = "CREATE TABLE IF NOT EXISTS History(
		user_id INT(3) UNSIGNED NOT NULL,
		app_id INT(3) UNSIGNED NOT NULL,
		time TIME NOT NULL,
		FOREIGN KEY (user_id) REFERENCES Users(Id_user),
		FOREIGN KEY (app_id) REFERENCES APP(Id_app)
		)";
createTable($history,$conn);
mysqli_close($conn);
?>
