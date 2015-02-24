<?php
switch($_SERVER['REQUEST_METHOD'])
{
    case 'POST': postMethod(); break;
    case 'DELETE': deleteMethod(); break;
    case 'PUT': putMethod(); break;
    case 'GET': getMethod(); break;
    default:
}
function Validate() {
    $name = $_POST["name"];
    if (!preg_match("/^[a-zA-Z ]*$/",$name) ||$name=="") {
        $nameErr = "Only letters and white space allowed"; 
        throw new Exception($nameErr);
        return false;
    }
    $lname = $_POST["lname"];
    if (!preg_match("/^[a-zA-Z ]*$/",$lname) || $lname =="") {
        $lnameErr = "Only letters and white space allowed"; 
        throw new Exception($lnameErr);
        return false;

    }
    $email = $_POST["email"];
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $emailErr = "Invalid email format"; 
        throw new Exception($emailErr);
        return false;
    }
    if(strlen($_POST['pswd'])<6 || strlen($_POST['pswd'])>20 || $_POST['pswd']==""){
        $pswdErr = "Should be more than 6 simbols and less than 20";
        throw new Exception($pswdErr);
        return false;
    }
    return true;
}
function postMethod(){
    try{
        if(Validate()){
        $a ="Name: ".$_POST['name']."\n"."LastName: ".$_POST['lname']."\n"."Email: ".$_POST['email']."\n"."Password: ".$_POST["pswd"]."\n";
        file_put_contents("./txt.txt", $a, FILE_APPEND);
        }
    }
    catch (Exception $e){
        echo "ooooops: ", $e->getMessage(),"\n";
    }
}
?>
