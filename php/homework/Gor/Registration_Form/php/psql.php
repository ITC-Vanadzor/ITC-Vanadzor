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
    private $name_rgx;
    private $email_rgx;
    private $password_rgx;
    private $birth_rgx;
    private $genderm_rgx;
    private $genderf_rgx;

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
    
    private function secureValid() {
        $this->name_rgx = "([A-Z,a-z]){2,20}\b";
        $this->email_rgx = "/([\w\.\-_]+)?\w+@[\w-_]+(\.\w+){1,}/igm";
        $this->password_rgx = "[0-9A-Za-z! .@#$%*]{6,32}";
        $this->birth_rgx = "^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$";
        $this->genderm_rgx = "male";
        $this->genderf_rgx = "feemale";
    }
    
    private function jsonDecode($data_json) {
        $this->secureValid();
        $data_array = json_decode($data_json, true);
        if (preg_match($this->name_rgx, $data_array["name"])) {
            $this->u_name = $data_array["name"];
        } else {
            return false;
        }
        if (preg_match($this->name_rgx, $data_array["surname"])) {
            $this->u_name = $data_array["surname"];
        } else {
            return false;
        }   
        if (preg_match($this->email_rgx, $data_array["email"])) {
            $this->u_name = $data_array["email"];
        } else {
            return false;
        }
        if (preg_match($this->password_rgx, $data_array["password"])) {
            $this->u_name = $data_array["password"];
        } else {
            return false;
        }
      /*  if (preg_match($this->birth_rgx, $data_array["birthdath"])) {
            $this->u_name = $data_array["birthdath"];
        } else {
            return false;
        } 
        if ($data_array["gender"] == $this->genderm_rgx || $this->genderf_rgx) {
            $this->u_name = $data_array["gender"];
        } else {
            return false;
        } */
    #    $this->u_age = $data_array["age"];
    }


    public function addUser($data_json) {
        $this->jsonDecode($data_json);
        if ($this->u_name && $this->u_surname && $this->u_email && $this->u_password == false) {
            echo 'No valid';
            break;
        } else { 
            $query_req = $query_req . "'$this->u_surname', '$this->u_email', '$this->u_password)"; 
            $query_req = "INSERT INTO persons (name, username, email, password)";
            $query_req = $query_req . "VALUES ('$this->u_name' ,";
            $query_req = $query_req . "'$this->u_surname', '$this->u_email', '$this->u_password' )";
            $adduser_req = pg_query($this->db_connection, $query_req);
        }
    }
    
    public function deleteUser($data_json) {
        $this->jsonDecode($data_json);
        if ($this->u_email == false) {
            echo 'No valid';
            break;
        } else { 
            $delete = "DELETE FROM persons WHERE email='$this->u_email'";
            $delete_data = pg_query($this->db_connection, $delete);
        }
    }
    
    public function updateUser ($data_json) {
        $this->jsonDecode($data_json);
        if ($this->u_name && $this->u_surname && $this->u_email == false) {
            echo 'No valid';
            break;
        } else { 
            $update = "UPDATE persons SET name = '$this->u_name' , username= '$this->u_surname' WHERE email='$this->u_email'";
            $update_data = pg_query($this->db_connection, $update);
        }      
    }
    
    public function checkUser($data_json) {
        $this->jsonDecode($data_json);
        if ($this->u_email && $this->u_password == false) {
            echo 'No valid';
            break;
        } else { 
            $check = "SELECT * FROM persons WHERE email='$this->u_email' AND password='$this->u_password'";
            $result= pg_query($this->db_connection, $check);
            if($result){
                echo "Welcome,  '$this->u_email'" ,"\n";
            } else {
                echo "User/pass are incorrect", "\n";
            }
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
#$db_obj->checkUser($data_json);
#$db_obj->getAllUsersData($data_json);





/*---------------------------------------------------
--------            END OF TEST              --------    
---------------------------------------------------*/

?>
