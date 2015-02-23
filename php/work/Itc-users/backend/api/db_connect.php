<?php 

class DATABASE {

    private $db_name;
    private $db_host;
    private $db_port;
    private $db_user;
    private $db_password;
    private $db_connection;

    // DATABASE Class Constructor    
    public function __construct($db_name, $db_host, $db_port, $db_user, $db_password) {
        $this->db_name = $db_name;
        $this->db_host = $db_host;
        $this->db_port = $db_port;
        $this->db_user = $db_user;
        $this->db_password = $db_password;
        $this->connect();
    }

    // DATABASE Class Function for Connecting to PostgreSQL DataBase 
    private function connect() {
            // added string $conn to pass as an argument(Sargis)
            $conn = 'host='.$this->db_host.' port='.$this->db_port.' dbname='.$this->db_name.' user='.$this->db_user.' password='.$this->db_password; 
            $this->db_connection = pg_connect($conn);
    }

    // DATABASE Class Function for Disconecting of PostgreSQL DataBase 
    // (CLOSE CONNECTION)
    public function disconnect(){
        pg_close($this->db_connection);
    }

    // DATABASE Class Function for Adding New Data into DataBase Tables
    public function addUser($user_data) {
        # TODO check  
        $user_data_array = json_decode($user_data, true);
        $name = $user_data_array['name'];
        $username = $user_data_array['username'];
        $email = $user_data_array['email'];
        $password = $user_data_array['password'];
        #$birth_date = $user_data_array['birth_date'];
        #$age = $user_data_array['age'];
        #$gender = $user_data_array['gender'];

        $query_req = "INSERT INTO person (name, username, email, password) VALUES ('";
        $query_req += $name + "','" + $username + "','"+ $email + "','" + $password + "')";
        $adduser_req = pg_query($this->db_connection, $query_req);
    }
    
// DATABASE Class Function for Delete Data from DataBase Tables     //
    
    public function deleteUser ($userId) {
        $delete = "DELETE FROM persons WHERE id = '$userId'";
        $delete_data = pg_delete($this->db_connection, $delete);
    }

// DATABASE Class Function for Apdating Data into DataBase Tables   //   

    //author: Sargis. Here are syntax errors. that's why I've commented. Need to execute this file.
   public  function updateUser ($email, $user_data) { 
        #if ($name !=''){
        #    $update = "UPDATE persons SET name ='$name' WHERE email = '$email'";
       /* } elseif($username !='') {
            $update = "UPDATE persons SET username =$username WHERE email = $email";
        } elseif ($password !='') {
            $update = "UPDATE persons SET password=$password WHERE email = $email";
       */
        #$update_data = pg_query($this->db_connection, $update);
    }

// DATABASE Class Function for Check User information into DataBase Tables    //
    
    public function checkUser($username, $password) {
        $check = "SELECT * FROM persons WHERE username='$username' AND password='$password'";
        $checkuser = pg_query($this->db_connection, $check);
        if($result->num_rows() === 1){
            echo "Welcome, " .$username;
        } else {
            echo "User/pass are incorrect";
        }       
    }

// DATABASE Class Function for Check User information into DataBase Tables    //

    //author:Sargis. corrected some errors. Need this function to execute in server API.
    public function getAllUsersData () {
        $alldata = "SELECT * FROM users;";//here instead of 'users' should be table name,where are all data, that we need.
        $get_alldata = pg_query($this->db_connection, $alldata);
        $ret = pg_fetch_all($get_alldata);
        return $ret;
    }
}
  


/*---------------------------------------------------
--------            TESTING CODE             --------                      
---------------------------------------------------*/

   #$db_name = 'itc_users';
   #$db_port = '5432';
   #$db_host = '127.0.0.1';
   #$db_user = 'postgres';
   #$db_password = 'postgres';

   #$db_obj = new DATABASE($db_name, $db_host, $db_port, $db_user, $db_password);
   #   

   #$user_data = '{"name": "anun1", "username": "username2", "email": "email2", "password": "pass2"}';   
   #$db_obj->addUser($user_data);
   #$db_obj->updateUser($user_data, $email);

?>
