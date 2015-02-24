<?php

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$txt = "";
	$name = $_POST["name"];
	$lName = $_POST["lastname"];
	$email = $_POST["email"];
	$pass = $_POST["password"];
	$pass = htmlspecialchars($pass);
	if ($name == "") {
		$txt = $txt . "Name is Empty\n";
	} else if (!preg_match("/^[a-zA-Z]{2,15}$/", $name)) {
		exit("invalid name. Use only letters\n");
	} else {
		$txt = $txt . "Name: " . $name . "\n";
	}
	
	if ($lName == "") {
		$txt = $txt . "Last Name is Empty\n";
	} else if (!preg_match("/^[a-zA-Z]{2,15}$/", $lName)) {
		exit("invalid Last name. Use only letters\n");
	} else {
		$txt = $txt . "Last name: " . $lName . "\n";
	}

	if ($email == "") {
		exit("Email is required\n");
	} else if (!preg_match("/^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$/", $email)) {
		exit("invalid Email. Example: example@example.example\n");
	} else {
		$txt = $txt . "Email: " . $email . "\n";
	}

	if ($pass == "") {
		$txt = $txt . "Password is Empty\n\n";
	} else if (!preg_match("/^.{4,8}$/", $pass)) {
		exit("invalid Password. Use 4-8 characters\n");
	} else {
		$txt = $txt . "Password: " . $pass . "\n\n";
	}
	
} else if ($_SERVER["REQUEST_METHOD"] == "GET") {
	$txt = "";
	$name = $_GET["name"];
	$lName = $_GET["lastname"];
	$email = $_GET["email"];
	$pass = $_GET["password"];
	if ($name == "") {
		$txt = $txt . "Name is Empty\n";
	} else if (!preg_match("/^[a-zA-Z]{2,15}$/", $name)) {
		exit("invalid name. Use only letters\n");
	} else {
		$txt = $txt . "Name: " . $name . "\n";
	}
	
	if ($lName == "") {
		$txt = $txt . "Last Name is Empty\n";
	} else if (!preg_match("/^[a-zA-Z]{2,15}$/", $lName)) {
		exit("invalid Last name. Use only letters\n");
	} else {
		$txt = $txt . "Last name: " . $lName . "\n";
	}

	if ($email == "") {
		exit("Email is required\n");
	} else if (!preg_match("/^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$/", $email)) {
		exit("invalid Email. Example: example@example.example\n");
	} else {
		$txt = $txt . "Email: " . $email . "\n";
	}

	if ($pass == "") {
		$txt = $txt . "Password is Empty\n\n";
	} else {
		exit("Please use POST methodt for password\n");
	}
} else {
	exit("Invalid method\n");
}

$file = fopen('data.txt', 'a');
fwrite($file, $txt);
fclose($file);

?>
