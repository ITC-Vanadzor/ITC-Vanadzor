
<?php
    $target_dir = "upload/";
    $target_file = $target_dir . basename($_FILES["my_file"]["name"]);
    
    move_uploaded_file($_FILES["my_file"]["tmp_name"], $target_file);
    
?>    

