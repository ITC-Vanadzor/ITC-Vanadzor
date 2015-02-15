<?php
$file='data/data.json';
//Functions
//Searching $login in $file(file path and name),result array or false
function findLogin($login,$file) {
    $fileCont = file_get_contents($file);
    $fileJsonArray = json_decode($fileCont);
    foreach ($fileJsonArray as $key => $value) {
        if ($key == strtolower($login)) {
            return $value;
        }
    }
    return false;
}
//TODO
function printLogins($file) {
    $fileCont = file_get_contents($file);
    $fileJsonArray = json_decode($fileCont);
    foreach ($fileJsonArray as $key => $value) {
        echo $key."<br/>";
    }    
}