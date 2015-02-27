<?php
$host="localhost";
$user="root";
$pass="student2014";
$db_name="user_APP";
$con = mysql_connect($host, $user, $pass);
if (!$con) {
	die('Could not connect: ' . mysql_error());
}
createDB($con);
mysql_select_db($db_name, $con);

function createDB($c) {
// variablessssssss
	$myDB = 'CREATE DATABASE IF NOT EXISTS '.$db_name;
	if (mysql_query($myDB, $c)) {
		echo "Database $db_name created successfully\n";
	} else {
		echo 'Error creating database:  ' . mysql_error() . "\n";
	}
}

function createTable($DB, $table) {
        $table="CREATE TABLE ".$table;
	if (mysql_query($table, $DB)) {
		echo "Table created successfully\n";
	} else {
		echo "Error creating table: " . mysql_error() . "\n";
	}
}

$users = "Users (user_id INT(3) AUTO_INCREMENT NOT NULL PRIMARY KEY,  name VARCHAR(30) NOT NULL, password VARCHAR(30) NOT NULL)";
createTable($con, $users);
$app = "APP (app_id INT(3) AUTO_INCREMENT NOT NULL PRIMARY KEY,app_name VARCHAR(30) NOT NULL)";
createTable($con, $app);
$history = "History (history_id INT(4) UNSIGNED AUTO_INCREMENT PRIMARY KEY, user INT(3) NOT NULL, app INT(3) NOT NULL, add_time TIME NOT NULL, FOREIGN KEY (user) REFERENCES Users (user_id), FOREIGN KEY (app) REFERENCES APP (app_id))";
createTable($con, $history);
mysql_close($con);
?>
