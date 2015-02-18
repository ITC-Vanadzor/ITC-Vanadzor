<?php
	$upDir = "uploads";
	$tmp = $_FILES["Up"]["tmp_name"];
	$name = $_FILES["Up"]["name"];
	move_uploaded_file($tmp, "$upDir/$name"
?>
