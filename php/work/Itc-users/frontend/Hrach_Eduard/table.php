<?php
	$mail=$_POST['mail'];
	if ($mail ==""){  header('Location: login.php');  }	
?>

<html>
	<head>
		<meta charset="UTF-8">
		<link href="table.css" rel="stylesheet">
		<script src="table.js"></script>
	</head>
	<body>
		<h1>Welcome <?php echo $mail; ?></h1>
		<a href="login.php"><button>log out</button></a>
		<button>add</button>
	</body>
