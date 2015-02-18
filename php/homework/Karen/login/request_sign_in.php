<?php
include 'function.php';
$result = findLogin($_POST['login'],$file);
//var_dump($_POST);
//var_dump($result);

if($result && ($result->password == $_POST['password'])){
    if($_POST['remember']){
        setcookie('login',$_POST['login']);
    }else{
        setcookie('login',$_POST['login'],  time()+1200);
    }
    header("Location: index.php");
}else{
    header("Location: index.php?err=1");
}
