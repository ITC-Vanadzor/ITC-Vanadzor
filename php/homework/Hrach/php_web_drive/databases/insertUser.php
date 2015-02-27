<?php
$name = $_POST["username"];
$pass = $_POST["pass"];
$host="localhost";
$user="root";
$pass="student2014";
$db_name="user_APP";
$con = mysql_connect($host, $user, $pass);
if (!$con) {
	die('Could not connect: ' . mysql_error());
}
mysql_select_db($db_name, $con);

$sql = "INSERT INTO Users (name, password)
VALUES ('$name', '$pass')";
if (mysql_query($sql, $con)) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . mysql_error();
}

mysql_close($con);

//header("Location: ../view/index.html");
?>
