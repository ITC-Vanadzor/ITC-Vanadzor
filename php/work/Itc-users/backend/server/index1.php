<?php

switch($_SERVER['REQUEST_METHOD'])
{ 
    case 'POST': postMethod(); break;
    case 'DELETE': deleteMethod(); break;
default: 
}
echo substr($_SERVER['PHP_SELF'],1 );
function postMethod() {
    if ($_SERVER['REQUEST_URI']==('add_user')) {
        addUser();
    }
}

function deleteMethod() {
    if ($_SERVER['REQUEST_URI']=='delete_user'){
        deleteUser();
    }
    else
    {
        echo "ccccc";
    }
}
function addUser() {
    echo "add";   
}

function deleteUser() {
    echo "delete";   
}
?>
