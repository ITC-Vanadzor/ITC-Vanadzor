<?php 

class PSQL {
    private $db_host;
    private $db_port;
    private $db_name;
    private $db_user;
    private $db_password;
    private $db_connection;
    
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
   
     function addUser() {
        $query_req = "INSERT INTO user_personal (name, surname, email) VALUES ('Poghos' , 'poghosyan', 'poxos@gmail.com')";
        $adduser_req = pg_query($this->db_connection, $query_req);
    }
    
      public function deleteUser() {
        $delete = "DELETE FROM user_personal WHERE email='poxos@gmail.com'";
        $delete_data = pg_query($this->db_connection, $delete);
    }
    
    public function updateUser () {
        $update = "UPDATE user_personal SET name = 'Petros' , surname= 'Petrosyan' WHERE email='poxos@gmail.com'";
        $update_data = pg_query($this->db_connection, $update);
    }
    
    public function checkUser() {
        $check = "SELECT * FROM user_personal WHERE email=' USER EMAIL' AND password='USER PASSWORD'";
    }
    
    public function getAllUsersData () {
        $alldata = "SELECT * FROM user_personal";
        $get_alldata = pg_query($this->db_connection, $alldata);
    }
}

/*---------------------------------------------------
--------            TESTING CODE             --------                      
---------------------------------------------------*/
$db_name = 'gor_db';
$db_port = '5432';
$db_host = '127.0.0.1';
$db_user = 'postgres';
$db_password = 'aa';

$db_obj = new PSQL($db_host, $db_port, $db_name, $db_user, $db_password);
 if (!$db_obj){
    echo "Error: Connect to DataBase NOT POSSIBLE, Please FIX my ERRORS" , "\n";  
} else {
    echo "CONNECTED to the DataBase   ", $db_name, "\n";   
} 

#$db_obj->addUser();
#$db_obj->deleteUser();
#$db_obj->updateUser();
#$db_obj->checkUser();
#$db_obj->getAllUsersData();



/*---------------------------------------------------
--------            END OF TEST              --------    
---------------------------------------------------*/

?>