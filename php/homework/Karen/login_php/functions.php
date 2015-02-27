<?php 
function validateForm(){
    $validated = 0;
    validField("name", "/^[a-zA-Z ]+$/");
    validField("lastname", "/^[a-zA-Z ]+$/");
    validField("email", '/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/' );
    validField("password", "/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$/");
    if(validated == 4){
            return true;
    }else{
            return false;
    }
}
//Validation Field
function validField($fieldName, $pattern){
    if (!preg_match($pattern, $_POST[$fieldName])) {
        return "err".$fieldName."&";
    } else {
        return true;
    }
}
//echo validField("name", "/^[a-zA-Z ]+$/");
    
?>