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
echo "<a href='index.php'>Sign in</a>";
}else{
    echo "This login is exist";
echo "<a herf='register.php'>Registration</a>";
}
//Print Logins
//printLogins($file);
include 'footer.php';

