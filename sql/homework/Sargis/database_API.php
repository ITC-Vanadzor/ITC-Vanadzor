<?php
$username = 'root';
$servername = 'localhost';
$password = '123456';
$db_name = 'comp_store';
$conn = mysql_connect($servername, $username, $password, $db_name);
if (!$conn){
    die("Can't connect :" . mysql_error());
}
#return all data about realizated sells;
$query1 = 'use $db_name; select * from realization '
$conn->multy_query($query1);
TTTTTTTTTTTTTTTTTTTTTOOOOOOOOOOOOOOOOOOOOODDDDDDDDDDDDDDdOOOOOOOOOOOOOOOOOOO
   
?>
