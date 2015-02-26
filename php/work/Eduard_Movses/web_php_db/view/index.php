<?php

$servername = "localhost";
$username = "root";
$password = "student2014";
$dbname = "newDB";

$users_table = " id INT(5) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
)";
$apps_table = "apps_id INT(5) UNSIGNED AUTO_INCREMENT PRIMARY KEY, apps_list VARCHAR(30) NOT NULL";
$history_table="history_id INT(5) UNSIGNED AUTO_INCREMENT PRIMARY KEY, user_id INT(5) NOT NULL, FOREIGN KEY (user_id) REFERENCES users_table(user_id), apps_id INT(5) NOT NULL, FOREIGN KEY (app_id) REFERENCES apps_table(app_id),reg_time TIMESTAMP(14) NOT NULL)";

$conn = mysqli_connect($servername, $username, $password, $dbname);
if (!$conn) {
    $conn = mysqli_connect($servername, $username, $password);
    if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }
} 
$sql = "CREATE DATABASE newDB";
if (mysqli_query($conn, $sql)) {
    echo "Database created successfully";
    createTable("users_table",$users_table);
    createTable("apps_table",$apps_table);
    createTable("history_table",$history_table);
} else {
    echo "Error creating database: " . mysqli_error($conn);
}

function createTable($tableName,$filedsList) {
    $sql_query = "CREATE TABLE $tableName ( ";
    $sql_query .= "$filedsList";
    $sql_query .= " );";
    //    echo "-----------------";
    //    echo $sql_query;
    $result = mysqli_query($sql_query);
    if (!$result) {
        die('Invalid query: ' . mysqli_error($result));
    }
}


function adduser($user_name,$pass) {
    $adding_user = "INSERT INTO users_table (username, password)
        VALUES ($user_name, $pass)";
    if (mysqli_query($conn, $adding_user)) {
        echo "New record created successfully";
    } else {
        echo "Error: " . $adding_user . "<br>" . mysqli_error($conn);
    }
}


if (isset($_POST['submit1'])) {
    $user_name = $_POST['username'];
    $pass = $_POST['password'];
    adduser($user_name,$pass)
}
mysqli_close($conn);

?>

<head>
<title> Working with DB</title>
</head>
<body>
<form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
Username: <input type="text" name="username"/>
Password: <input type="password" name="password"/>
<input type="submit" name="submit1" value="add user"/>
</form>
<form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST"/>
Application: <input type="text" name="app"/>
<input type="submit" name="submit2" value="add application"/>
</form>
</body>

