<?php
$path="../controller/add_user.php"
?>
<html>
<body>
	<form action="<?php echo $path?>" method="post">
		<input type="text" name="username"> 
		<input type="password" name="pass"> 
		<input type="submit" value="Add User">
	</form>
	<br><br>
	<form action="<?php echo $path?>" method="get">
		<input type="text" name="appname"> 
		<input type="submit" value="Add APP">
	</form>
</body>
</html>
