<?php

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

function close_connection_db($conn){
    $conn->close();
}

function create_db($db_name){
    // Create database
    $conn=check_connection_db();
    $sql = "CREATE DATABASE ".$db_name;
    if ($conn->query($sql) === TRUE) {
        echo "Database created successfully";
    } else {
        echo "Error creating database: " . $conn->error;
    }
}


//create_db("my_web_db");

$conn = check_connection_db("my_web_db");
$sql ="CREATE TABLE users (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
)";
if ($conn->query($sql) === TRUE) {
        echo "Table users created successfully";
} else {
        echo "Error creating table: " . $conn->error;
}
$sql ="CREATE TABLE apps (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    name VARCHAR(30) NOT NULL
)";
if ($conn->query($sql) === TRUE) {
        echo "Table users created successfully";
} else {
        echo "Error creating table: " . $conn->error;
}
$sql ="CREATE TABLE history (
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (app_id) REFERENCES apps(id),
    time DATETIME NOT NULL
)";
if ($conn->query($sql) === TRUE) {
        echo "Table users created successfully";
} else {
        echo "Error creating table: " . $conn->error;
}
echo "\ntest\n";