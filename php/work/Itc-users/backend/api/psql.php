<?php 

class PSQL {
    private $db_host;
    private $db_port;
    private $db_name;
    private $db_user;
    private $db_password;
    private $db_connection;
    private $data_json;
    private $u_name;
    private $u_surname;
    private $u_email;

    public function __construct($db_host, $db_port, $db_name, $db_user, $db_password) {
        $this->db_host = $db_host;
        $this->db_port = $db_port;
        $this->db_name = $db_name;
        $this->db_user = $db_user;
        $this->db_password = $db_password;
        
        $this->connect();
    }
    
    public function connect() {
        $db_connect = 'host =' .$this->db_host . ' port =' . $this->db_port . ' dbname =' .$this->db_name . '  user =' .$this->db_user . ' password =' .$this->db_password;
        
        $this->db_connection = pg_connect ($db_connect); 
    }
    
    public function disconnect(){
        pg_close($this->db_connection);
    }
   
    private function jsonDecode($data_json) {
        $data_array = json_decode($data_json, true);
        $this->u_name = $data_array["name"];
        $this->u_surname = $data_array["surname"];
        $this->u_email = $data_array["email"];
        $this->u_password = $data_array["password"];
    #    $this->birsthday = $data_array["birthsath"];
    #    $this->u_age = $data_array["age"];
    #    $this->u_gender = $data_array["gender"];
    }


    public function addUser($data_json) {
        $this->jsonDecode($data_json);
        $query_req = "INSERT INTO persons (name, username, email, password)";
        $query_req = $query_req . "VALUES ('$this->u_name' ,";
        $query_req = $query_req . "'$this->u_surname', '$this->u_email', '$this->u_password' )";
        echo "\n $query_req \n";
        $adduser_req = pg_query($this->db_connection, $query_req);
    }
    
    public function deleteUser($data_json) {
        $this->jsonDecode($data_json);
        $delete = "DELETE FROM persons WHERE email='$this->u_email'";
        $delete_data = pg_query($this->db_connection, $delete);
    }
    
    public function updateUser ($data_json) {
        $this->jsonDecode($data_json);
        $update = "UPDATE persons SET name = '$this->u_name' , username= '$this->u_surname' WHERE email='$this->u_email'";
        $update_data = pg_query($this->db_connection, $update);
    }
    
    public function checkUser($data_json) {
        $this->jsonDecode($data_json);
        $check = "SELECT * FROM persons WHERE email='$this->u_email' AND password='$this->u_password'";
        $result= pg_query($this->db_connection, $check);
        if($result){
            echo "Welcome,  '$this->u_email'" ,"\n";
        } else {
            echo "User/pass are incorrect", "\n";
        }
    }
    
    public function getAllUsersData ($data_json) {
        $this->jsonDecode($data_json);
        $alldata = "SELECT * FROM persons";
        $get_alldata = pg_query($this->db_connection, $alldata);
        $result = pg_fetch_all($get_alldata);
        return $result;
    }
}

/*---------------------------------------------------
--------            TESTING CODE             --------                      
---------------------------------------------------*/
$db_name = 'itc_users';
$db_port = '5432';
$db_host = '127.0.0.1';
$db_user = 'postgres';
$db_password = 'postgres';

$db_obj = new PSQL($db_host, $db_port, $db_name, $db_user, $db_password);
 if (!$db_obj){
    echo "Error: Connect to DataBase NOT POSSIBLE, Please FIX my ERROS" , "\n";  
} else {
    echo "CONNECTED to the DataBase   ", $db_name, "\n";   
} 

$data_json = '{"name": "simon", "surname": "Simonyan", "email": "simon@mail.com", "password": "petros"}';
#$db_obj->addUser($data_json);
#$db_obj->deleteUser($data_json);
#$db_obj->updateUser($data_json);
$db_obj->checkUser($data_json);
#$db_obj->getAllUsersData($data_json);





/*---------------------------------------------------
--------            END OF TEST              --------    
---------------------------------------------------*/

?>
