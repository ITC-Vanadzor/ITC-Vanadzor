<html>
    <head>
  <script type="text/javascript" src="jquery-1.11.2.min.js"></script>
        <script src="login.js"></script>
    </head>
    <body>
        <div>
            <form action="logout.php" method="post">
		<input name="mail" type="text" id="email"/>
		<input name="pass" type="password" id="password"/>
		<input type="checkbox" name="checkbox" id="checkbox" value="Remember Me"/>
    		<button onclick="check('Marine','marine')">Click me</button>
    </form>
  </div>
</body>
</html>