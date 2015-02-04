function addSelectYears() {
    var curDate = new Date();
    var year = curDate.getFullYear(); 
    for(i=1900;i<=year;i++){
        var x = document.getElementById("year");
        var option = document.createElement("option");
        option.text = i;
        x.add(option);
    }
}

function validateForm() {
    console.log("Entering validation function...");
    var x = document.forms["myForm"]["name"].value;
    if (x==null || x=="") {
        alert("First name must be filled out");
        return false;
    }
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
    var x = document.forms["myForm"]["lastname"].value;
    if (x==null || x=="") {
        alert("Last name must be filled out");
        return false;
    }
    var x = document.forms["myForm"]["pass"].value;
    if (x.length<5) {
        alert("password must contain 6-12  simbols");
        return false;
    }

    alert("Registration passed");
}

function hide(){
    var div = document.getElementById("hi")
    var btn = document.getElementById("so")
    if (btn.value=="show") {
            div.style.display = "block"
            btn.value = "hide"
    } else {
            div.style.display = "none"
            btn.value = "show"
    }
}
