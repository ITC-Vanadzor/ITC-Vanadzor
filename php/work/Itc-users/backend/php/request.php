<html>
<body>
<?php
    $username = $_POST["username"];
    $pswd = $_POST["password"];
    $usr_pswd = array($username => $pswd);
    $json_data = json_encode($usr_pswd);
    $ch = curl_init(http://localhost/Itc_usr/login.html); 
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
    curl_setopt($ch, CURLOPT_POSTFIELDS, $json_data);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array(
        'Content-Type: application/json',
        'Content-Length: ' . strlen($json_data))
    );
    echo $json_data;
    $result = curl_exec($ch);
?>
</body>
</html>
