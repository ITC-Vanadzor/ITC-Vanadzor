<html>
	<head>
		<title>
			Multiplication table
		</title>
	</head>
	<body>	

	<style>
	body {
	font-size:50px;
	text-align:center;
	}
	</style>
		<?php
		$a = $_POST["number"];
		for ($i = 1; $i <= 10; $i++) {
			echo $a." x ".$i." = ".$a*$i."<br>" ;
		}
		
		?>
	</body>
<html>

