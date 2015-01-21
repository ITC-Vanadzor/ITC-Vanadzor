function isValid() {
    var patt1 = /\W/g;
    var myName = document.getElementById("name").value;
    var result = myName.match(patt1);
    console.log(result);
}
/*if (myName =  ) {
    
}*/

/*function validateForm() {
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
}*/
