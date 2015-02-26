<?php
echo $_POST['username'] ;
$servername='localhost';
$username='root';
$passwd='student2014';
$dbname='user_APP';
$conn = mysqli_connect($servername, $username, $passwd, $dbname);
if (!$conn) {
    die('Could cot connect: ' . mysql_error());
}
echo 'Connected successfully'."\n";
$user=$_POST['username'];
$pass=$_POST['pass'];
$sql = "INSERT INTO Users (name, password)
VALUES ('{$user}','{$pass}')";

if (mysqli_query($conn, $sql)) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?>
