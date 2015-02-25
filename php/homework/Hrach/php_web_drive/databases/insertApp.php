<?php
$name = $_GET["appname"];
$con = mysql_connect("127.0.0.1", "root", "231996");
if (!$con) {
    die('Could not connect: ' . mysql_error());
}
mysql_select_db("user_APP", $con);

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
