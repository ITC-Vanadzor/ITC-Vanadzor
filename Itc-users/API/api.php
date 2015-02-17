<?php 


class Database {

    private $db_name;
    private $host;
    private $user;
    private $password;

    function __construct($db_name, $host, $user, $password) {
        this-> $db_name = $db_name;
        this->$host = $host;
        this->$user = $user;
        this->$password = $password;

        this->connect();
    }

    private function connect() {
        $connection = pg_connect('host =' .host, 'port =' .port, 'datebase =' .datebase, 'user =' .user, 'pasword =' .password);
    }

    function addUser () {

    }

    function deleteUser () {

    }

    function updateUser () {

    }

    function checkUser () {

    }

    function getAllUsersData () {

    }
}


$database = 'itcusers';
$host = '5432';
$user = 'pstgres';
$password = 'student2014';

$db_obj = new DATEBASE($db_name, $host, $user, $password)

    if (!db_obj) {
       echo  ERROR: 1
    }



?>
