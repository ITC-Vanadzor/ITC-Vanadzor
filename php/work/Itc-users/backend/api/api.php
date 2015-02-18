<?php 


class Database {

    private $db_name;
    private $db_host;
    private $db_port;
    private $db_user;
    private $db_password;
    private $db_connection;

       public  function __construct($db_name, $host, $port, $user, $password) {
        $this->db_name = $db_name;
        $this->db_host = $host;
        $this->db_port = $port;
        $this->db_user = $user;
        $this->db_password = $password;

        $this->connect();
    }

    private function connect() {
        echo $this->port;
        $this->db_connection = pg_connect('host =' .host, 'port =' .port, 'datebase =' .db_name, 'user =' .user, 'password =' .password);
    }

    function getJson ($userdata) {
        $jsonIterator = new RecursiveIteratorIterator(
                new RecursiveArrayIterator(json_decode($json, TRUE)),
                    RecursiveIteratorIterator::SELF_FIRST);
        foreach ($jsonIterator as $key => $val) {
               if(is_array($val)) {
                          echo "$key:\n";
                             } else {
                                        echo "$key => $val\n";
                                           }
        } 
   
   
    }

    function addUser($user_data) {
        $user_data_array = json_decode($user_data, true)
        $anun = $user_data_array['anun']
        $query = "INSERT INTO person (name, username, email, password) VALUES ('".anun"','".azganun"','".email"','".password"')";
        $adduser = pg_query($this->db_connection, $query);
    }

    function deleteUser ($userId) {
      //  $deletuser = DELETE FROM person WHERE id = '';
    }

    function updateUser ($userId, $user_data) {
     //  $updateuser =  ;
    }

    function checkUser($username, $password) {
   //     $checkuser = ;
    }

    function getAllUsersData () {
    //    $getalldata = ;
    }
}


$db_name = 'itc_users';
$db_port = '5432';
$db_host = '127.0.0.1';
$db_user = 'postgres';
$db_password = 'postgres';

$db_obj = new Database($db_name, $db_host, $db_port, $db_user, $db_password);

    if (!$db_obj) {
        echo "ERROR";
    } else {
       echo "OK";
    }   

$userdata = '{"name": "anun1", "username": "username2", "email": "email2", "password": "pass2"}';   
$db_obj->addUser($aa);


?>


