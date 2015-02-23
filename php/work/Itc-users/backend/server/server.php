<?php

require "../api/db_connect.php";

switch($_SERVER['REQUEST_METHOD'])
{ 
    case 'POST': postMethod(); break;
    case 'DELETE': deleteMethod(); break;
    case 'PUT': putMethod(); break;
    case 'GET': getMethod(); break;
default: 
}

function getMethod() {
    if (preg_match('/get_allusers/i',$_SERVER['REQUEST_URI'])) { 
       $name = "Anun";
       $lname = "Azganun";
       $email = "Email";
       $tableData = array($name => "Poghos",
           $lname => "Poghosyan",
           $email => "poghos2015@petr.os");
       $jsonData = json_encode($tableData);
       echo $jsonData."\n";
       var obj = new HttpResponse();
       obj.setContentType('application/json');
       obj.setContentDisposition("$jsonData", true);
       obj.send();
    }
} 

function putMethod() {
    #$extra = 'add_user';
    #$uri   = rtrim(dirname($_SERVER['PHP_SELF']), '/\\');
    if (preg_match('/add_user/i',$_SERVER['REQUEST_URI'])) { 
        addUser();
    }
}

function deleteMethod() {
    if (preg_match('/delete_user/i',$_SERVER['REQUEST_URI'])) {
        deleteUser();
    }
}

function postMethod() {
    if ($_SERVER['REQUEST_URI'] == 'get_allusers'){
        //$db = new DATABASE('itc-users', 'localhost', 5432, 'postgres', '123456');
        //$data = $db->getAllUsersData();
        //echo json_encode($data);
        echo "ekaaaaav??";
    }

    if (preg_match('/login/i',$_SERVER['REQUEST_URI'])) {
        login();
    } elseif (preg_match('/logout/i',$_SERVER['REQUEST_URI'])) {
        logout();
    } elseif (preg_match('/update/i',$_SERVER['REQUEST_URI'])) {
        update();
    }
}

function login() {
    echo "login() function was called\n";
}
function update(){
    echo "update() function was called\n";
}
function logout() {
    echo "logout() function was called\n";
}
function addUser() {
    echo "add_user() fubction was called\n";   
}

function deleteUser() {
    echo "delete_user() function was called\n";   
}
?>
