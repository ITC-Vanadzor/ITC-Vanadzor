<?php
include 'adddel.php';
//add($_POST['checkbox']);*/
?>
<html>
  <head>
  <script type="text/javascript" src="jquery-1.11.2.min.js"></script>
    <script src="login.js"></script> 
 </head>
   <body>
   <button onclick="logout()">Click me</button>
<form action="cookie.php" method="post">
<button name="logout" value="logout" onclick="logout()">LogOut</button>
  </form>
</body>
</html>
