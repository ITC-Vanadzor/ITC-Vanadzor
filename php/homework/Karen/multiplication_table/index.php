<!Doctype html>
<html>
<head>
	<title>Test PHP</title>
	<link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="wrapper">
	<?php
		function multiplicationTable($point=1){
			echo "<h2>Multiplication table for $point </h2>";
			for($i=1; $i<=10; $i++){
				echo "$point * $i = ".$point*$i."<br/>";
			}
		}
		multiplicationTable(5);
		multiplicationTable(7);
	?>
	</div>
</body>
</html>
