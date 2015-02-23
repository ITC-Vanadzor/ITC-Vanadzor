<?php
include 'class.php';echo "aaaaaaaaaaaaaaaaaaaaaaaa";
$c = NULL;
switch($_POST['functionname']){
  //function add($check_value) {
case 'add':
  add();
  break;
  //	}

  //      function del() {
case 'del':
  echo "mmmmmmmmmmmmmmmmm";
  del();
  break;
default:
  break;
}
function add() {

  $c = new Cookies('aaaa', 'aaaa');
  $c->addCookie($_POST['arguments']);
  echo "1111111";
}
function del() {
  if($c==NULL) {
    $c = new Cookies('aaaa', 'aaaa');
  }
  $c->deleteCookie();
  echo "22222222";

}
?>
