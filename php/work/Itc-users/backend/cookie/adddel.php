<?php
	include 'class.php';
	$c=new Cookies();
	$c->cookie_name='user';
	$c->cookie_value='user pass';
	$c->check_value=$_POST['checkbox'];
	function add() {
		$c->addCookie();
		echo "1111111";
	}
	function del() {
		$c->deleteCookie();
		echo "22222222";
	}


?>
