<?php 


class Database {

    private $db_name;
    private $host;
    private $port;
    private $user;
    private $password;

       public  function __construct($db_name, $host, $port, $user, $password) {
        $this->$db_name = $db_name;
        $this->$host = $host;
        $this->$port = $port;
        $this->$user = $user;
        $this->$password = $password;

        $this->connect();
    }

    private function connect() {
        $connection = pg_connect('host =' .host, 'port =' .port, 'datebase =' .db_name, 'user =' .user, 'password =' .password);
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


$db_name = 'itcusers';
$port = '5432';
$host = '127.0.0.1';
$user = 'postgres';
$password = 'student2014';

$db_obj = new Database($db_name, $host, $port, $user, $password);


echo "sd"       
   
?>


