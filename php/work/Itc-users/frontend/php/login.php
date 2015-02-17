<html>
	<head>
	<meta charset="UTF-8">
	<link href="../css/form.css" rel="stylesheet">
	<script src="../js/login.js"></script>
	</head>
	<body>
	<img src="../images/login.jpg"/>
	<div id="form">
	<form action="table.php" method="post">
		<p>Email: <input name="mail" type="text" id="mail" placeholder=" YOUR EMAIL"></input></p>
		<p>Password: <input name="pass" type="password" id="pass" placeholder=" YOUR PASSWORD"></input></p>
		<input type="checkbox" id="box" name="box" >Remember me</input> 		
		<input type="submit" id="login" value="Log In"  onclick="return login_valid('itc@mail.ru','student2014');"/> 
</form>
		<a href="sign_up.php"><input type="button" class="signup" value="Sign Up" /></a>
		</div>
		</body>

</html>
