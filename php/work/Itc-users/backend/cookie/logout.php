<?php
$cookie_name="user";
$cookie_value="user pass";
if (!$_POST['checkbox']){
  setcookie($cookie_name,$cookie_value,time()+12);echo "false";
}
else {
setcookie($cookie_name,$cookie_value);echo "true";
}
?>
<html>
  <head>
<script src="login.js"></script> 
 </head>
   <body>
   <div id="del">
<?php
function removeCookie(){
$cookie_name;
$cookie_value;
setcookie($cookie_name,$cookie_value,time()-1200);
echo isset($_COOKIE[$cookie_name]);
}
?>
<div>
<form action="cookie.php" method="post">
<button name="logout" value="logout" onclick="<?php removeCookie()?>">LogOut</button>
  </body>
</html>
