<!doctype html>
<html>
<head>
<meta charset="utf-8">
	<title>Login</title>
    <meta name="author" content="Gor Julhakyan" />
    <meta name="Description" content="Registration Form in JavaScript, CSS , HTML & PHP" />
    <link href='http://fonts.googleapis.com/css?family=Roboto|Oswald:400,700' rel='stylesheet' type='text/css'>
    <link href="css/style.css" rel="stylesheet">
    <script src="js/validator.js"></script>
	<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="container">
		<div>
			<h1 class="title">Login</h1>
		</div>
			<form name="form" >
				<div class="raw">
					<div id="emailerrorBox"></div>
					<input type="text" name="Email" id="email" value=""  placeholder="E-mail *" >
				</div>
				<div class="raw">
					<div id="passerrorBox"></div>
					<input type="password" name="Password" id="password" value=""  placeholder="Password *" >
				</div>
				<div class="raw">
					<div id="passerrorBox"></div>
					<input type="submit" name="submit" id="sign_user" value="Login" >
				</div>

			</form>
	</div>
</body>
</html>
