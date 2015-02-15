<?php
include 'function.php';
include 'header.php';

$login = $_REQUEST['login'];
$pageArray=findLogin($login,$file);
//var_dump($pageArray);

if ($pageArray->name){
    echo "<b>Name : </b>".$pageArray->name."<br/>";
}
if ($pageArray->name){
    echo "<b>Last name : </b>".$pageArray->lastname."<br/>";
}
if ($pageArray->email){
    echo "<b>Email : </b>".$pageArray->email."<br/>";
}
if ($pageArray->sex){
    echo "<b>Sex : </b>".$pageArray->sex."<br/>";
}
if (($pageArray->day)&&($pageArray->month)&&($pageArray->year)){
    echo "<b>Birtday : </b>".$pageArray->day."-".$pageArray->month."-".$pageArray->year."<br/>";
}

include 'footer.php';