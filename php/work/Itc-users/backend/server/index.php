<?php 
if ($_SERVER['REQUEST_METHOD']=='POST' && $_SERVER['REQUEST_URI']=='add_user'){
    echo "aaaaaaaa";
}
if ($_SERVER['REQUEST_METHOD']=='DELETE' && $_SERVER['REQUEST_URI']=='delete_user'){
    echo "bbbbb";
}
else
{
    echo "ccccc"
}
?>

