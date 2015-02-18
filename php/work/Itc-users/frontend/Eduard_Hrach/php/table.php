<?php
	$mail=$_POST['mail'];
	if ($mail ==""){  header('Location: login.php');  }	
?>

<html>
	<head>
		<meta charset="UTF-8">
		<link href="../css/form.css" rel="stylesheet">
		<script src="../js/form.js"></script>
		</head>
	<body>
		<div id="form">
		<h1>Welcome <?php echo $mail; ?></h1>
		<a href="login.php"><button>Log Out</button></a>
		<button class="signup">Add</button>
		</div>
	</body>
