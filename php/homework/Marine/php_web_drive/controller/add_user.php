<?php
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
$appname=$_GET['appname'];
if ($_SERVER['REQUEST_METHOD']=='POST') { 
	if (!is_null($_POST['appname'])) {
		echo "APP name send by Get method";
	} else{
		$sql = "INSERT INTO Users (name, password)
			VALUES ('$user','$pass')";
		rec_create($conn,$sql);
	}
} else{
	if (!is_null($_GET['username']) || !is_null($_GET['pass'])) {
		echo "Username and Password send by Post method";
	} else {
		$sql = "INSERT INTO APP (app_name)
			VALUES ('$appname')";
		rec_create($conn,$sql);
	}
}
function rec_create($conn,$sql){
	if (mysqli_query($conn, $sql)) {
    	echo "New record created successfully";
	} else {
    	echo "Error: " . $sql . "<br>" . mysqli_error($conn);
	}
}

mysqli_close($conn);
?>
