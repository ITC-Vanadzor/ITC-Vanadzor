<?php 

//Create connection on DB
function check_connection_db($db_name=false){
	$servername = "localhost";
	$username = "root";
	$password = "student2014";
	if($db_name){
		$conn = new mysqli($servername, $username, $password,$db_name);
	}else{
		$conn = new mysqli($servername, $username, $password);
	}
	// Check connection
	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	} 
	return $conn;
}

//Create datebase 
function create_db($db_name){
	// Create database
	$conn=check_connection_db();
	$sql = "CREATE DATABASE IF NOT EXISTS ".$db_name;
	if ($conn->query($sql) === TRUE) {
		echo "\nDatabase my_web_db created successfully";
	} else {
		echo "\nError creating database: " . $conn->error;
	}
}

//Get random words
function get_rand_word ($max_len, $c = 'abcdefghijklmnopqrstuvwxyz') {
	$len = mt_rand(3, $max_len);
	for ($s = '', $cl = strlen($c)-1, $i = 0; $i < $len; $s .= $c[mt_rand(0, $cl)], ++$i);
	return $s;
}

//Insert random users in table users by '$count'
function insert_rand_users($count){
	//Make connection for DB 'my_web_db'
	$conn = check_connection_db("my_web_db");

	// prepare and bind
	$stmt = $conn->prepare("INSERT INTO users (name, password) VALUES (?, ?)");
	$stmt->bind_param("ss", $name, $password);

	for ($i=0;$i<$count;$i++){
		// set parameters and execute
		$name = get_rand_word(15);
		$password = get_rand_word(32);
		$stmt->execute();
	}

	echo "New records created successfully";

	$stmt->close();

	//Close connection DB
	$conn->close();
}

//Insert random applications in table apps by '$count'
function insert_rand_apps($count){
	//Make connection for DB 'my_web_db'
	$conn = check_connection_db("my_web_db");

	// prepare and bind
	$stmt = $conn->prepare("INSERT INTO apps (name) VALUES (?)");
	$stmt->bind_param("s", $name);

	for ($i=0;$i<$count;$i++){
		// set parameters and execute
		$name = get_rand_word(15);
		$stmt->execute();
	}

	$stmt->close();

	//Close connection DB
	$conn->close();
}

//Insert random history in table history by '$count'
function insert_rand_dates($count){
	//Make connection for DB 'my_web_db'
	$conn = check_connection_db("my_web_db");

	// prepare and bind
	$stmt = $conn->prepare("INSERT INTO history (user_id, app_id, time) VALUES (?, ?, ?)");
	$stmt->bind_param("iis", $user_id, $app_id, $time);

	for ($i=0;$i<$count;$i++){
		// set parameters and execute
		$user_id = mt_rand(0,20);
		$app_id = mt_rand(0, 10); 
		$time = date('Y-m-d h:i:s');
		$stmt->execute();
	}

	echo "New records created successfully";

	$stmt->close();

	//Close connection DB
	$conn->close();
}
