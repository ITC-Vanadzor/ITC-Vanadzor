<html>
	<head>
		<title>
			Divide
		</title>
	</head>
	<body>	
	<style>
	body {
	font-size:50px;
	text-align:center;
	}
	input {
	padding:15px;
	}
	</style>
		<form action="divide.php" method="get">
		<input type="number" name="first_val" placeholder="Input first number"/>:
		<input type="number" name="second_val" placeholder="Input second number"/>	
		<input type="submit" value="Rezult integer value">
		</form>
		<?php
		$a = $_GET["first_val"];
		$b = $_GET["second_val"];
		echo (int)($a/$b);
		?>
	</body>
<html>

