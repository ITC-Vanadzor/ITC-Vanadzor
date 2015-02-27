<?php
$servername = "localhost";
$username = "root";
$password = "student2014";
$db_name = "my_web_db";


// 1. functions
// 2. createTable($tableName, $fields)
$userQuery = "CREATE TABLE User_table (
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY , 
    user VARCHAR(30) , 
    password VARCHAR(30) )";
$appQuery = " CREATE TABLE App_table (
    app_id INT(6) UNSIGNED AUTO_INCREMENT NOT NULL, 
    app_name VARCHAR(30) NOT NULL)";
$hisQuery = "create table  History (
    FOREIGN KEY (user_id) REFERENCES User_table(user_id),
    FOREIGN KEY (app_id) REFERENCES APP_table(app_id),
    OrderDate datetime NOT NULL DEFAULT NOW() )";

function createTable($conn,$db_name, $queryS){
    echo "------NN\n";
    $prep = "use $db_name";
    $conn->query($prep);
    if ($conn->query($queryS) === TRUE) {
        echo "Table was created successfully";
    } else {
        echo "Error creating table: " . $conn->error;
    }
}
function create_if_dont_exist($servername, $username, $password, $db_name){
    // Create connection
    $conn = new mysqli($servername, $username, $password, $db_name);
    // Check connection
    if ($conn->connect_error) {
        $conn = new mysqli($servername, $username, $password);
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        } 
        // Create database
        $sql = "CREATE DATABASE $db_name";
        if ($conn->query($sql) === TRUE) {
            echo "Database created successfully";
            echo "------NN\n";
            global $userQuery,$appQuery, $hisQuery ;
            createTable($conn,$db_name,$userQuery);
            createTable($conn,$db_name,$appQuery);           
            createTable($conn,$db_name, $hisQuery);           
        } else {
            die("Error creating database: " . $conn->error);
        }
    } else{
     //  createTable($conn,$userQuery);           
     //  createTable($conn,$appQuery);           
     //  createTable($conn,$hisQuery);           
    }
    $conn->close();
}

create_if_dont_exist($servername, $username, $password, $db_name);


?>
