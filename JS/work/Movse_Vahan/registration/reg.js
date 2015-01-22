function validateName() {
    var x = document.forms["myForm"]["fname"].value;
    var y = document.forms["myForm"]["lname"].value;
    var patt = /\W/g;
    var resultN = x.match(patt);
    var resultL = y.match(patt);
    if ( (x == null || x == "") || (resultN != null) ) {
        alert("First name must be filled out correctly!");
        return false;
    }
    else if ( (y == null || y == "") || (resultL != null) ) {  
        alert("Last name must be filled out correctly!");
        return false;
    }
}

function validateMail() {
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
}

function validatePassword {
    var x = document.form["myForm"]["pswd"].value;
    var patt = /\W\d\w/g;
    var result = x.match(patt)
    if ((x.length < 6) || (result == null) || (x == null || x == ""))
        alert("Password is not valid");
        return false;
}

function isValid() {
    validateName();
    validateMail();
    validatePassword();
}


