<?php
$fnameErr = $emailErr = $lnameErr = $passwordErr = "";
$fname = $email = $lname = $password = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["fname"])) {
        $fnameErr = "Name is required";
    } 
    elseif (!preg_match("/^[a-zA-Z ]*$/",$_POST["fname"])) {
        $fnameErr = "Only letters and white space allowed"; 
    }
    else {
        $fname = test_input($_POST["fname"]);
    }

    if (empty($_POST["lname"])) {
        $lnameErr = "Last Name is required";
    } 
    elseif (!preg_match("/^[a-zA-Z ]*$/",$_POST["lname"])) {
        $lnameErr = "Only letters and white space allowed"; 
        }
    else {
        $lname = test_input($_POST["lname"]);
    }

    if (empty($_POST["pswd"])) {
        $passwordErr = "Password is required";
    }         
    elseif (strlen($_POST["password"]) <= '8') {
            $passwordErr = "Your Password Must Contain At Least 8 Characters!";
        }
    else {
        $password = test_input($_POST["pswd"]);
    }

    if (empty($_POST["email"])) {
        $emailErr = "Email is required";
    } 
    elseif (!preg_match("/([\w\-]+\@[\w\-]+\.[\w\-]+)/",$_POST["email"])) {
            $emailErr = "You Entered An Invalid Email Format"; 
        }
    else {
        $email = test_input($_POST["email"]);
    }
}
function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
}
echo $fnameErr;
echo "\n";
echo $lnameErr;
echo "\n";
echo $passwordErr;
echo "\n";
echo $emailErr;
echo "\n";

$file = fopen('info.txt', 'w');
fwrite($file, $fname);
fwrite($file, $lname);
fwrite($file, $email);
fwrite($file, $password);
fclose($file);
?>

