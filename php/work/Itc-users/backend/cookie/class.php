<?php
class Cookies{
  var $cookie_name;
  var $cookie_value;
  var $check_value;

  function __construct($cookie_name,$cookie_value) {
    $this->cookie_name=$cookie_name;
    $this->cookie_value=$cookie_value;
   // $this->check_value=$check_value;
  }
  public function  deleteCookie(){
    setcookie($cookie_name,$cookie_value,time()-1200);
    echo isset($_COOKIE[$cookie_name]);
  }
  public function addCookie($check_value){
    $this->check_value=$check_value;
    if ($check_value){
      setcookie($cookie_name,$cookie_value,time());echo "yes";
    }else {
      setcookie($cookie_name,$cookie_value,time()+12);echo "no";
	}
  }
}
