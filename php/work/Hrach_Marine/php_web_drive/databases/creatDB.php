<?php

$con = mysql_connect("127.0.0.1", "root", "student2014", "user_APP");
if (!$con) {
  $con = mysql_connect("127.0.0.1", "root", "student2014");
  if (!$con) {
    die('Could not connect: ' . mysql_error());
  }
  createDB($con);
  $con = mysql_connect("127.0.0.1", "root", "student2014", "user_APP");
}

function createDB($con) {
  $myDB = 'CREATE DATABASE user_APP';
  if (mysql_query($myDB, $con)) {
    echo "Database my_db created successfully\n";
  } else {
    echo 'Error creating database:  ' . mysql_error() . "\n";
  }
}

function createTable($table_name) {
  if (mysql_query($con, $table_name)) {
    echo "Table ".$table_name." created successfully";
  } else {
    echo "Error creating table: " . mysql_error($con);
  }
}

$users = "CREATE TABLE Users(Id_user INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,  name VARCHAR(15) NOT NULL, password VARCHAR(15) NOT NULL )";
createTable($users);
$app="CREATE TABLE APP (Id_app INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,app_name VARCHAR(25) NOT NULL)";
createTable($app);
$history="CREATE TABLE History (Id_history INT(4) UNSIGNED AUTO_INCREMENT PRIMARY KEY,user_id INT(3) NOT NULL, FOREIGN KEY (user_id) REFERENCES Users(Id_user), app_id INT(3) NOT NULL, FOREIGN KEY (app_id) REFERENCES APP(Id_app),time TIME NOT NULL)";
createTable($history);
?>
