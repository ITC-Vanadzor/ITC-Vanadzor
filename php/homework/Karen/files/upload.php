<?php
var_dump($_FILES);
$uploads_dir = '/home/student/Desktop/ITC-Vanadzor/php/homework/Karen/files/uploads';
    $tmp_name = $_FILES["file"]["tmp_name"];
    $name = $_FILES["file"]["name"];
    move_uploaded_file($tmp_name, "$uploads_dir/$name");
    echo "<br>temp name - ". $tmp_name . "<br>";
    echo "Upload dir - " . $uploads_dir."<br>";
    echo "<br>name name - ". $name;
/*
move_uploaded_file($_FILES["file"]["tmp_name"], "uploads/" . $_FILES["file"]["name"]);
echo "ECHO";
 */
?>
