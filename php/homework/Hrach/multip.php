<?php
	$val=$_POST['val'];
?>

<!DOCTYPE html>
	<html>
		<head>
		</head>
		<body>
		<?php
			for ($a =1; $a < 11; $a++){
        		$c=$a*$val;
        		echo "$val*$a=$c","<br>";
			}
		?>
		</body>
	</html>
