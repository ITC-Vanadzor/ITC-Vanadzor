<?php
$fnameErr = $emailErr = $lnameErr = $passwordErr = "";
$fname = $email = $lname = $password = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["fname"])) {
        $fnameErr = "Name is required";
    } else {
        $fname = test_input($_POST["fname"]);
        if (!preg_match("/^[a-zA-Z ]*$/",$fname)) {
            $fnameErr = "Only letters and white space allowed"; 
        }
    }

    if (empty($_POST["lname"])) {
        $lnameErr = "Last Name is required";
    } else {
        $lname = test_input($_POST["lname"]);
        if (!preg_match("/^[a-zA-Z ]*$/",$lname)) {
            $lnameErr = "Only letters and white space allowed"; 
        }
    }

    if (empty($_POST["pswd"])) {
        $passwordErr = "Password is required";
    } else {
        $password = test_input($_POST["pswd"]);
        if (strlen($_POST["password"]) <= '8') {
            $passwordErr = "Your Password Must Contain At Least 8 Characters!";
        }
    }

    if (empty($_POST["email"])) {
        $emailErr = "Email is required";
    } else {
        $email = test_input($_POST["email"]);
        if (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/",$email)) {
            $emailErr = "You Entered An Invalid Email Format"; 
        }
    }

}
function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}
$file = fopen('info.txt', 'w');
fwrite($file, $fname.'\n');
fwrite($file, $lname.'\n');
fwrite($file, $email.'\n');
fwrite($file, $password.'\n');
fclose($file);
?>

