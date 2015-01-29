function validateName() {
    var x = document.forms["reg"]["name"].value;
    if (x==null || x=="") {
        document.getElementById("name").className += "formInvalid";
        document.getElementById("name").placeholder = " must be filled out";
        //return false;
    }
}
function validateSurename() {
    var x = document.forms["reg"]["surename"].value;
    if (x==null || x=="") {
       document.getElementById("surename").className += "formInvalid";
       document.getElementById("surename").placeholder=" must be filled out";
       //return false;
    }
}
function validateEmail() {
    var x = document.forms["reg"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        document.getElementById("email").className += "formInvalid";
        document.getElementById("email").placeholder = "Not a valid e-mail";
        //return false;
    }
}
function validatePswd(){
    var x = document.getElementById("pswd").value;
    if(x.length < 6){
        document.getElementById("pswd").className += "formInvalid";
        document.getElementById("pswd").placeholder = "at least 6 symbols";
    }

}
function showBlock(block){
    if (document.getElementById(block).style.display == "none"){
        document.getElementById(block).style.display = "block";
    }
    else {
        document.getElementById(block).style.display = "none";
    }

}
function validate(){
    validateName();
    validateSurename();
    validateEmail();
    validatePswd();
}
