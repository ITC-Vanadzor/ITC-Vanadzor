<?php
$value = 'something from somewhere';

$a = setcookie("TestCookie", $value);
setcookie("TestCookie", $value, time()+3000600);  /* expire in 1 hour */
setcookie("TestCookie", $value, time()+3000600, "/~rasmus/", "example.com", 1);

$a = "aaaaaa";
echo "aa = $a \n ";
?>
