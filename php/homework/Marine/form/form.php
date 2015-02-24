<?php
	if ($_SERVER['REQUEST_METHOD']=='POST')	{
		methodPost();
	}
	else if ($_SERVER['REQUEST_METHOD']=='GET')	{
		methodGet();
	}
	function addTxt() {	
		$txt="./aaa.txt";
 		$file=fopen($txt,'a+');
		foreach ($_POST as $key=>$value){echo $key."///".$value."\n";
   			$add_txt="NNN";echo $add_txt;
			$add_txt=$key."--".$value."\n ";
	 		fwrite($file,$add_txt);
		}
 		fclose($file);
	}
	function validField(){
		$name= $_POST["name"];
    	if (!preg_match("/^[a-zA-Z ]*$/",$name) ||empty($name)) {
        	$name_err = "Invalid or empty Name"; 
			throw new Exception($name_err);
			return false;
		}
		$lname= $_POST["lastname"];
    	if (!preg_match("/^[a-zA-Z ]*$/",$lname) ||empty($lname)) {
        	$lname_err = "Invalid or empty lastname"; 
			throw new Exception($lname_err);
			return false;
		}
		$email=$_POST['email'];
		if (!filter_var($email, FILTER_VALIDATE_EMAIL)||empty($email)) {
	        $email_err = "Input email"; 
			throw new Exception($email_err);
			return false;
		}		
		$pass=$_POST['pass'];
		if ($_SERVER['REQUEST_METHOD']=='GET') {
			$method_error="Method POST";
			throw new Exception($method_error);
			return false;
		}
    	else if (!preg_match('/^(?=.*\d)(?=.*[A-Za-z])[0-9A-Za-z!@#$%]{8,12}$/',$pass) ||empty($pass)) {
        	$pass_err = "Invalid or empty password"; 
			throw new Exception($pass_err);
			return false;
		}
		return true;
	}
	function methodPost(){
		try {
			if (validField()) {
				addTxt();
			}
		}
		catch (Exception $e) {
			echo "Error:  ", $e->getMessage()."\n";
		}	
	}
?>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form action="" method="post">
     Name: <input type="text" name="name" class="textbox"><br><br>
     Lname: <input type="text" name="lastname"  class="textbox"><br><br>
     Email: <input type="email" name="email"  class="textbox"><br><br>
     Password: <input type="password" name="pass"  class="textbox"><br><br>
            <input type="submit" class="mybutton">
</form>
<a href='aaa.txt'>Text file</a>
</body>
</html>

