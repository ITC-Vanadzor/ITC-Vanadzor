<?php
$checkout=false;
$cookie_name="user";
$cookie_value="user pass";
if (!$_POST['checkbox']){
  setcookie($cookie_name,$cookie_value,time()+12);echo "false";
}
else {
setcookie("user1",$cookie_value,time()+12000000);echo "true";
}
?>
<html>
    <head>
        <script src="login.js"></script>
    </head>
    <body>
        <div>
            <form action="" method="post">
		<input type="checkbox" name="checkbox" id="checkbox" value="Remember Me">
    		<button onclick="check()">Click me</button>
    </form>
  </div>
</body>
</html>
