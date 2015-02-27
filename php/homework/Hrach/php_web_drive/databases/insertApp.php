<?php
$name = $_GET["appname"];
$host="localhost";
$user="root";
$pass="student2014";
$db_name="user_APP";
$con = mysql_connect($host, $user, $pass);
if (!$con) {
    die('Could not connect: ' . mysql_error());
}
mysql_select_db($db_name, $con);

$sql = "INSERT INTO APP (app_name)
VALUES ('$name')";
if (mysql_query($sql, $con)) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . mysql_error();
}

mysql_close($con);

//header("Location: ../view/index.html");
?>
