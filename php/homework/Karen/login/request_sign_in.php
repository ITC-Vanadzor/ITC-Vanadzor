<?php
include 'function.php';
$result = findLogin($_POST['login'],$file);
//var_dump($_POST);
//var_dump($result);
if($result && ($result->password == $_POST['password'])){
    header("Location: page.php?login=".$_POST['login']);
}else{
    header("Location: index.php?err=1");
}
