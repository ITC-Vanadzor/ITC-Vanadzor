<?php
$servername = "localhost";
$username = "root";
$password = "student2014";
$dbname = "newDB";

$users_table = " id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
    )";
$conn = mysqli_connect($servername, $username, $password, $dbname);
if (!$conn) {
    $conn = mysqli_connect($servername, $username, $password);
    if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    } else {
        $sql = "CREATE DATABASE newDB";
        createTable("user_table",$users_table);
//} else {
//    echo "Error creating database: " . mysqli_error($conn);
//    }
}
}

//  function createTable() {
//      $sqlt = "CREATE TABLE UserTable (
//          id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//          username VARCHAR(30) NOT NULL,
//          password VARCHAR(30) NOT NULL
//      )";

//      if (mysqli_query($conn, $sqlt)) {
//          echo "Table UserTable created successfully";
//      } else {
//          echo "Error creating table: " . mysqli_error($conn);
//      }
//  }


function createTable($tableName,$filedsList) {
    $sql_query = "CREATE TABLE $tableName ( ";
    $sql_query .= "$filedsList";
    $sql_query .= " );";
    echo "-----------------";
    echo $sql_query;
//if (mysqli_query($conn, $sqlt)) {
//    echo "Table UserTable created successfully";
//} else {
//   echo "Error creating table: " . mysqli_error($conn);
//}

}

mysqli_close($conn);
?> 
