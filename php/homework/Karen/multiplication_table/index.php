<!Doctype html>
<html>
<head>
	<title>Test PHP</title>
</head>
<body>
<?php
	function multiplicationTable($point=1){
		echo "***** $point *****<br/>";
		for($i=1; $i<=10; $i++){
			echo "$point * $i = ".$point*$i."<br/>";
		}
	}
	multiplicationTable(5);
	multiplicationTable(7);
?>
</body>
</html>
