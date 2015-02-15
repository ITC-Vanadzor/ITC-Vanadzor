<?php
include 'function.php';

$postArray = array(strtolower($_POST['login']) => $_POST);
//var_dump($postArray);

$json = json_encode($postArray);
$fileCont = file_get_contents($file);
if ($fileCont) {
    $fileCont = substr($fileCont, 0, -1) . "," . substr($json, 1);
} else {
    $fileCont = $json;
}

if(!findLogin($_POST['login'],$file)) {
    file_put_contents($file, $fileCont);
    setcookie('login',$_POST['login']);
    header("Location: index.php");
}else{
    header("Location: register.php?err=2");
}

?>
