<?php
$host="localhost";
$user="root";
$pass="student2014";
$db_name="user_APP";
$conn = mysqli_connect($host, $user, $pass);
if (!$conn) {
    die('Could not connect: ' . mysqli_error());
}
  createDB($conn,$db_name);

$users = "Users(
  Id_user INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  password VARCHAR(30) NOT NULL
)";
createTable($users,$conn);

$app = "APP(
  Id_app INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  app_name VARCHAR(25) NOT NULL
)";
createTable($app,$conn);

$history = "History(
  user_id INT(3) UNSIGNED NOT NULL,
  app_id INT(3) UNSIGNED NOT NULL,
  time TIME NOT NULL,
  FOREIGN KEY (user_id) REFERENCES Users(Id_user),
  FOREIGN KEY (app_id) REFERENCES APP(Id_app)
              )";
createTable($history,$conn);
 
function createDB($conn,$db_name) {
  $myDB = 'CREATE DATABASE '.$db_name;
  if (mysqli_query($conn,$myDB)) {
    echo "Database my_db created successfully\n";
  } else {
    echo 'Error creating database:  ' . mysqli_error() . "\n";
  }
  $conn=mysqli_query($conn, "USE ".$db_name);
}

function createTable($table_name,$conn) {
$table="CREATE TABLE IF NOT EXISTS ".$table_name;
  if (mysqli_query($conn,$table)) {
    echo "Table ".$table_name." created successfully\n";
  }
  else {
    echo "Error creating table: " . mysqli_error()."\n";
  }
}

mysqli_close($conn);

?>
