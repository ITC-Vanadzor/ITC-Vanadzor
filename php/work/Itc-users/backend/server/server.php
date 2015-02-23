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
    if (preg_match('/table_data/i',$_SERVER['REQUEST_URI'])) { 
        echo 'test';
       #$name = "Anun";
       #$lname = "Azganun";
       #$email = "Email";
       #$tableData = array($name => "Poghos",
       #    $lname => "Poghosyan",
       #    $email => "poghos1945@petr.os");
       #$jsonData = json_encode($tableData);
       #echo $jsonData."\n";
       #HttpResponse::setCache(true);
       #HttpResponse::setContentType('application/json');
       #HttpResponse::setContentDisposition("$jsonData", true);
       #HttpResponse::setFile('path/fileName');
       #HttpResponse::send();
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
    if ($_POST['miban'] == 'get_allusers'){
        $db = new DATABASE('itc-users', 'localhost', 5432, 'postgres', '123456');
        $data = $db->getAllUsersData();
        echo json_encode($data);
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
