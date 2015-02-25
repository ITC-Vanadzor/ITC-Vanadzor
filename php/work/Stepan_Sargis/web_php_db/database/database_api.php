<?php
$servername = "localhost";
$username = "root";
$password = "student2014";
$db_name = "my_web_db";


// 1. functions
// 2. createTable($tableName, $fields)

function create_if_dont_exist($servername, $username, $password, $db_name){
    // Create connection
    $conn = new mysqli($servername, $username, $password, $db_name);
    // Check connection
    if ($conn->connect_error) {
echo " 111_____iiiii\n";
        $conn = new mysqli($servername, $username, $password);
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        } 
echo " 211_____iiiii\n";
        // Create database
        $sql = "CREATE DATABASE $db_name";
        if ($conn->query($sql) === TRUE) {
echo " 411_____iiiii\n";
            echo "Database created successfully";
            $sql = "CREATE TABLE User_table (
                user_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
                user VARCHAR(30) NOT NULL,
                password VARCHAR(30) NOT NULL )";
            if ($conn->query($sql) === TRUE) {
                    echo "User_table was created successfully";
            } else {
                    echo "Error creating User_table: " . $conn->error;
            }
            $sql = "CREATE TABLE App_table (
                app_id INT(6) UNSIGNED AUTO_INCREMENT NOT NULL, 
                app_name VARCHAR(30) NOT NULLi)";
            if ($conn->query($sql) === TRUE) {
                    echo "App_table was created successfully";
            } else {
                    echo "Error creating App_table: " . $conn->error;
            }
            $sql = "CREATE TABLE History (
                FOREIGN KEY (user_id) REFERENCES User_table(user_id),
                FOREIGN KEY (app_id) REFERENCES APP_table(app_id),
                OrderDate datetime NOT NULL DEFAULT NOW() )";
            if ($conn->query($sql) === TRUE) {
                    echo "History table was created successfully";
            } else {
                    echo "Error creating History table: " . $conn->error;
            }

        } else {
echo " 511_____iiiii\n";
            die("Error creating database: " . $conn->error);
        }
    }
echo "end 811_____iiiii\n";
    $conn->close();
}

echo "iiiii\n";
create_if_dont_exist($servername, $username, $password, $db_name);
echo "iiii\n";


?>
