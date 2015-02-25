<?php

$con = mysql_connect("127.0.0.1", "root", "231996");
if (!$con) {
	die('Could not connect: ' . mysql_error());
}
createDB($con);
mysql_select_db("user_APP", $con);

function createDB($c) {
	$myDB = 'CREATE DATABASE IF NOT EXISTS user_APP';
	if (mysql_query($myDB, $c)) {
		echo "Database user_APP created successfully\n";
	} else {
		echo 'Error creating database:  ' . mysql_error() . "\n";
	}
}

function createTable($DB, $table_name) {
	if (mysql_query($table_name, $DB)) {
		echo "Table created successfully\n";
	} else {
		echo "Error creating table: " . mysql_error() . "\n";
	}
}

$users = "CREATE TABLE Users (user_id INT(3) AUTO_INCREMENT NOT NULL PRIMARY KEY,  name VARCHAR(15) NOT NULL, password VARCHAR(15) NOT NULL)";
createTable($con, $users);
$app = "CREATE TABLE APP (app_id INT(3) AUTO_INCREMENT NOT NULL PRIMARY KEY,app_name VARCHAR(25) NOT NULL)";
createTable($con, $app);
$history = "CREATE TABLE History (history_id INT(4) UNSIGNED AUTO_INCREMENT PRIMARY KEY, user INT(3) NOT NULL, app INT(3) NOT NULL, add_time TIME NOT NULL, FOREIGN KEY (user) REFERENCES Users (user_id), FOREIGN KEY (app) REFERENCES APP (app_id))";
createTable($con, $history);
mysql_close($con);
?>
