<?php

include 'functions_db.php';

create_db("my_web_db");

//Make connection for DB 'my_web_db'
$conn = check_connection_db("my_web_db");

//Create table 'users'
$sql ="CREATE TABLE IF NOT EXISTS users (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
)";
if ($conn->query($sql) === TRUE) {
        echo "\nTable users created successfully";
} else {
        echo "\nError creating table: " . $conn->error;
}

//Create table 'apps'
$sql ="CREATE TABLE IF NOT EXISTS apps (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30) NOT NULL
)";
if ($conn->query($sql) === TRUE) {
        echo "\nTable apps created successfully";
} else {
        echo "\nError creating table: " . $conn->error;
}

//Create table 'history'
$sql ="CREATE TABLE IF NOT EXISTS history (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
		user_id INT(6) UNSIGNED NOT NULL REFERENCES users(id),
		app_id INT(6) UNSIGNED NOT NULL REFERENCES apps(id),
    time DATETIME NOT NULL
)";
if ($conn->query($sql) === TRUE) {
        echo "\nTable history created successfully";
} else {
        echo "\nError creating table: " . $conn->error;
}

//Close connection DB
close_connection_db($conn);
