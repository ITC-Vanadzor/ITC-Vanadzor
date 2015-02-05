<?php
	echo $a;
	$b = date("Y:m:d-h:i:s");
	error_log("$b Error\n", 3, "/home/hrach/error_logs.txt");
?>
