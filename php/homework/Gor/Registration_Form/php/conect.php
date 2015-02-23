<?php

$host = '127.0.0.1';
$port = '5432';
$database = 'gor_db';
$user = 'postgres';
$password = 'aa';

$connectString = 'host=' . $host . ' port=' . $port . ' dbname=' . $database . 
        ' user=' . $user . ' password=' . $password;


$link = pg_connect ($connectString);
if (!$link)
{
    echo 'Error: Could not connect: ';
}
echo 'aaaaa \n';

$query = "SELECT * FROM user_personal";
$result = pg_query($query);

while ($row = pg_fetch_row($result)) {
    echo "$row[0] $row[1] $row[2]\n";
}

?>