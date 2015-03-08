function validateName() {
    var x = document.forms["myForm"]["fname"].value;
    var patt = /\W/g;
    var resultN = x.match(patt);
    if ((x == null || x == "") || (resultN != null)) {
        document.getElementById("fName").style.color = "red";
        document.getElementById("w1").innerHTML = "Invalid input";
        return false;
    }
    else {
        return true;
    }
}
function validateSname() {
    var x = document.forms["myForm"]["lname"].value;
    var patt = /\W/g;
    var resultN = x.match(patt);
    if ((x == null || x == "") || (resultN != null)) {
        document.getElementById("lName").style.color = "red";
        document.getElementById("w2").innerHTML = "Invalid input";
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
        document.getElementById("w3").innerHTML = "Invalid input"
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
        document.getElementById("w4").innerHTML = "Invalid input"
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
    validateSname();
    validateMail();
    validatePassword();
}

function regMassege() {
    if ( validateName() && validateMail() && validatePassword() ) {
         document.forms["myForm"].action = "regSuccess.html";
    }
}

function hideFields() {
    var isChecked = document.getElementById("myCheck").checked;
    if (isChecked){
        document.getElementById("field5").style.visibility = "hidden";
        document.getElementById("field6").style.visibility = "hidden";
        document.getElementById("vbox").innerHTML = "Show";
    }
    else {
        document.getElementById("field5").style.visibility = "inherit";
        document.getElementById("field6").style.visibility = "inherit";
        document.getElementById("vbox").innerHTML = "Hide";
    }
}

