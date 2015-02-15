//Adding optiond elements in Select years
function addSelectYears() {
    var curDate = new Date();
    var year = curDate.getFullYear();
    for (i = 1900; i <= year; i++) {
        var x = document.getElementById("year");
        var option = document.createElement("option");
        option.text = i;
        x.add(option);
    }
    addSelectDays(31);
}
//Set days count, this function adding option elements in Select 
function addSelectDays(daysCount) {
    document.getElementById("day").innerHTML = "";
    for (i = 1; i <= daysCount; i++) {
        var x = document.getElementById("day");
        var option = document.createElement("option");
        option.text = i;
        x.add(option);
    }
}
//Set month name, this function return count days for month
function getDaysCount(month) {
    switch (month) {
        case "February":
            var curDate = new Date();
            var curYear = curDate.getFullYear();
            if ((curYear % 4) == 0) {
                return 29;
            } else {
                return 28;
            }
            break;
        case "April":
            return 30;
            break;
        case "June":
            return 30;
            break;
        case "September":
            return 30;
            break;
        case "November":
            return 30;
            break;
        default :
            return 31;
    }
}
function updateDays() {
    var month = document.getElementById("month").value;
    var daysCount = getDaysCount(month);
    addSelectDays(daysCount);
    updateAge();
}
function updateAge() {
    var birtDayStr = document.getElementById("month").value + " " + document.getElementById("day").value + "," + document.getElementById("year").value;
    var birtDayMs = Date.parse(birtDayStr);
    var birtDay = new Date(birtDayMs)
    var ageDifMs = Date.now() - birtDay;
    var ageDate = new Date(ageDifMs);
    var age = Math.abs(ageDate.getUTCFullYear() - 1970);
    document.getElementById("age").value = age;
}
function hideRequiredFields() {
    allForm = document.getElementById("form-container");
    noRequired = allForm.getElementsByClassName("no-required");
    for (i = 0; i < noRequired.length; i++) {
        noRequired[i].classList.add("hidden");
    }
    document.getElementById("link-switch").setAttribute("onclick", "showRequiredFields()");
    document.getElementById("link-switch").setAttribute("rel", "hidden");
    document.getElementById("link-switch").innerHTML = "show no required fields";
}
function showRequiredFields() {
    allForm = document.getElementById("form-container");
    noRequired = allForm.getElementsByClassName("no-required");
    for (i = 0; i < noRequired.length; i++) {
        noRequired[i].classList.remove("hidden");
    }
    document.getElementById("link-switch").setAttribute("onclick", "hideRequiredFields()");
    document.getElementById("link-switch").setAttribute("rel", "showed");
    document.getElementById("link-switch").innerHTML = "hide no required fields";
}

//Validation
function resetErrorMessages() {
    document.getElementById("name");
    errors = document.getElementsByClassName("error");
    for (i = 0; i < errors.length; i++) {
        errors[i].classList.add("hidden");
    }
}
function resetNoRequiredFields() {
    rel = document.getElementById("link-switch").getAttribute("rel");
    if (rel == "hidden") {
        document.getElementById("year").value = "";
        document.getElementById("month").value = "";
        document.getElementById("day").value = "";
        document.getElementById("male").removeAttribute("checked");
        document.getElementById("female").removeAttribute("checked");
        document.getElementById("age").value = "";
    }
}
function validateForm() {
    validated = 0;
    resetErrorMessages();
    resetNoRequiredFields();
    validField("login", /^[a-zA-Z ]+$/);
    validField("name", /^[a-zA-Z ]+$/);
    validField("lastname", /^[a-zA-Z ]+$/);
    validField("email", /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
    validField("password", /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$/);
    if (validated == 5) {
        return true;
    } else {
        return false;
    }
}
//Validation Field
function validField(fieldId, pattern) {
    var element = document.getElementById(fieldId);
    if (pattern.test(element.value)) {
        validated++;
    } else {
        if (element.value == "") {
            element.parentNode.getElementsByClassName('error')[1].classList.remove('hidden');
        } else {
            element.parentNode.getElementsByClassName('error')[0].classList.remove('hidden');
        }
    }
}
