<? php 

$host = '127.0.0.1';
$port = '5432';
$datebase = 'itcusers';
$user = 'pstgres';
$password = 'student2014';

$connection = pg_connect('host =' .host, 'port =' .port, 'datebase =' .datebase, 'user =' .user, 'pasword =' .password);

//  INSERT TO THE DATEBASE //

$insert = $connection(INSERT INTO user_personal(NAME, SURNAME, EMAIL, PASSWORD) ) VALUES ('ANUN', 'AZGANUN', 'EMAIL', 'PASSWORD') )

    //  CHEK USER //

$query = "SELECT * FROM user_personal"

// Delete //







?>
