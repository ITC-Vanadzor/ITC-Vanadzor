function validateName() {
    var x = document.forms["myForm"]["fname"].value;
    var y = document.forms["myForm"]["lname"].value;
    var patt = /\W/g;
    var resultN = x.match(patt);
    var resultL = y.match(patt);
    if ((x == null || x == "") || (resultN != null)) {
        document.getElementById("name").focus();
        document.getElementById("name").style.color = "red";
        document.getElementById("warnText").innerHTML = "empty name"
       // alert("First name must be filled out correctly!");
        return false;
    }
    else if ((y == null || y == "") || (resultL != null)) {  
        document.getElementById("lName").style.color = "red";
       // alert("Last name must be filled out correctly!");
        return false;
    }
    else {
        return true;
    }
}

function validateMail() {
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        document.getElementById("eMail").style.color = "red";
       // alert("Not a valid e-mail address");
        return false;
    }
    else {
        return true;
    }
}

function validatePassword() {
    var x = document.forms["myForm"]["pswd"].value;
    var patt1 = /\W/g;
    var patt2 = /\w/g;
    var result1  = x.match(patt1);
    var result2  = x.match(patt2);
    if (x.length < 6) {
        document.getElementById("pswd").style.color = "red";
       // alert("Password is not valid");
        return false;
    }
    else if ((result1 == null) || (result2 == null)) {
        document.getElementById("pswd").style.color = "red";
       // alert("Password must contain at least one symbol");
        return false;
    }
    else if (x == null || x == "") {
        document.getElementById("pswd").style.color = "red";
       // alert("Password is not valid");
        return false;
    }
    else {
        return true;
    }
}

function isValid() {
    validateName();
    validateMail();
    validatePassword();
}

function regMassege() {
    if ( validateName() && validateMail() && validatePassword() ) {
         document.forms["myForm"].action = "regSuccess.html";
    }
    else {return document.getElementById("name").style.color = "red";}
}

function changeStar(){
document.getElementById("name").style.color = "red";
}
/*document.getElementById("butt").onclick = function() {myFunction()};

function myFunction() {
    if ()
        document.getElementById("name").style.color = "red";
}
*/

