function validateName() {
    var x = document.forms["reg"]["name"].value;
    if (x==null || x=="") {
        document.getElementById("required1").style.color = "red";
        document.getElementById("name").className += "formInvalid";
        document.getElementById("name").placeholder = " must be filled out";
        //return false;
    }
}
function validateSurename() {
    var x = document.forms["reg"]["surename"].value;
    if (x==null || x=="") {
       document.getElementById("required2").style.color = "red";
       document.getElementById("surename").className += "formInvalid";
       document.getElementById("surename").placeholder=" must be filled out";
       //return false;
    }
}
function validateEmail() {
    var x = document.forms["reg"]["email"].value;
    var pos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (pos<1 || dotpos<pos+2 || dotpos+2>=x.length || (pos==-1) || (dotpos==-1)) {
        document.getElementById("required3").style.color = "red";
        document.getElementById("email").value = "";
        document.getElementById("email").className += "formInvalid";
        document.getElementById("email").placeholder = "Not a valid e-mail";
        //return false;
    }
}
function validatePswd(){
    var x = document.getElementById("pswd").value;
    if(x.length < 6){
        document.getElementById("required4").style.color = "red";
        document.getElementById("pswd").value = "";
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
function verifyAge(){
    var x = new Date().getFullYear();
    var age = document.getElementById("age").value;
    var year = document.getElementById("year").value;
    year = parseInt(year);
    var diff = (x-year); 
    if ((age != diff) && (year != "year") && !isNaN(year)) {
        document.getElementById("age").style.border ="1px solid red";
    }
}
function validate() {
    validateName();
    validateSurename();
    validateEmail();
    validatePswd();
    verifyAge();
}
