<?php
include 'class.php';echo "aaaaaaaaaaaaaaaaaaaaaaaa";
$c = NULL;
switch($_POST['functionname']){
case 'add':
  add();
  break;
case 'del':
  echo "mmmmmmmmmmmmmmmmm";
  del();
  break;
default:
  break;
}
function add() {echo "444444444444444444444";
  $c = new Cookies('aaaa', md5($_POST['pass']));
  $c->addCookie($_POST['argument']);
  echo "1111111";
}
function del() {
  if($c==NULL) {
    $c = new Cookies('aaaa', md5($_POST['pass'])); 
  }var_dump(md5($_POST['pass']));
  $c->deleteCookie();
  echo "22222222";
}
?>
