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
if (isset($_COOKIE[$cookie_name])) {
    unset($_COOKIE[$cookie_name]);
    setcookie($cookie_name,"",time()-1200);
    var_dump(isset($_COOKIE[$cookie_name]));
  }}
  public function addCookie($check_value){
    $this->check_value=$check_value;echo var_dump($check_value);
    if ($check_value=="true"){
      setcookie($cookie_name,$cookie_value,time());echo "yes";
    var_dump(isset($_COOKIE[$cookie_name]));
    }else {
      setcookie($cookie_name,$cookie_value,time()+12);echo "no";
    var_dump(isset($_COOKIE[$cookie_name]));
	}
  }
}
