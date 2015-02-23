tableTitlesJson = {"checkboxName": "selectAll", "name": "Name", "lastname": "Lastname", "email": "Email", "sex": "Sex", "birthday": "Birthday", "action": "Action"}
objUsers = {"users": [{"userId": "1", "name": "Poghos", "lastname": "Poghosyan", "email": "poghan@gmail.com", "sex": "male", "birthday": "54"},
    {"userId": "2", "name": "Petros", "lastname": "Posyan", "email": "poan@gmail.com", "sex": "male", "birthday": "24"},
    {"userId": "3", "name": "Mari", "lastname": "Grghyan", "email": "pogho@gmail.com", "sex": "female", "birthday": "38"}
    ]};
tableId = "tablePage";
modalId = "modal-dialog";
tmpId = 50;
$(document).ready(function () {
    myMain(tableTitlesJson, objUsers, tableId);
});
function getAllData(){
    var xmlhttp = new XMLHttpRequest();
    var url = "http://192.168.33.76:8888/get_allusers";
    /*
       xmlhttp.onreadystatechange = function() {
       if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
       var myArr = JSON.parse(xmlhttp.responseText);
       alert(myArr);
       }
       }
       */
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    alert("OK");
    alert(xmlhttp.responseText);

}
function myMain(tableTitlesJson, objUsers, tableId) {
    printTitles(tableTitlesJson, tableId);
    printUsers(objUsers, tableId);
    sellectAllOrNull();
    getEditUser();
}
function printTitles(tableTitlesJson, tableId) {
    var parentObj = document.getElementById(tableId);
    ul = createElement(parentObj, "ul", {"class": "title"});
    //checkout column
    creatLiDiv();
    var input = createElement(div, "input", {"type": "checkbox", "name": tableTitlesJson.checkboxName});
    creatLiDiv();
    div.textContent = tableTitlesJson.name;
    creatLiDiv();
    div.textContent = tableTitlesJson.lastname;
    creatLiDiv();
    div.textContent = tableTitlesJson.email;
    creatLiDiv();
    div.textContent = tableTitlesJson.sex;
    creatLiDiv();
    div.textContent = tableTitlesJson.birthday;
    creatLiDiv();
    div.textContent = tableTitlesJson.action;
}
function printUsers(objUsers, tableId) {
    //alert(objUsers.users.length);
    for (i = 0; i < objUsers.users.length; i++) {
        var parentObj = document.getElementById(tableId);
        ul = createElement(parentObj, "ul", {"class": "user"});
        //checkout column
        idColumn(ul, objUsers.users[i].userId);
        userInfoColumn(ul, "name", objUsers.users[i].name);
        userInfoColumn(ul, "lastname", objUsers.users[i].lastname);
        userInfoColumn(ul, "email", objUsers.users[i].email);
        userInfoColumn(ul, "sex", objUsers.users[i].sex);
        userInfoColumn(ul, "birthday", objUsers.users[i].birthday);
        actionColumn(ul, "edit", "edit");
        actionColumn(ul, "delete", "delete");
    }
}
function createElement(parentObj, tagName, attributes) {
    var tag = document.createElement(tagName);
    for (var key in attributes) {
        tag.setAttribute(key, attributes[key]);
    }
    parentObj.appendChild(tag);
    return tag;
}
function creatLiDiv() {
    li = createElement(ul, "li", {});
    div = createElement(li, "div", {});
}
function idColumn(ul, id) {
    var li = createElement(ul, "li", {});
    var div = createElement(li, "div", {});
    var input = createElement(div, "input", {"type": "checkbox", "name": "user" + id, "value": id, "class": "checkUser"});
}
function userInfoColumn(ul, classVal, value) {
    var li = createElement(ul, "li", {"class": classVal});
    var div = createElement(li, "div", {"class": "text"});
    div.textContent = value;
}
function actionColumn(ul, classVal, value) {
    var li = createElement(ul, "li", {"class": classVal});
    var div = createElement(li, "div", {"class": "action"});
    var iTag = createElement(div, "i", {});
    var a = createElement(div, "a", {"href": "#" + modalId, "rel": objUsers.users[i].userId, "onclick": classVal + "User(this.getAttribute('rel'))"});
    a.textContent = value;
}
function  editUser(userId) {
    userJson = objUsers.users[getUsersArrayIndex(objUsers, userId)];
    editedUserJson = getEditedUserJson(userJson);
    objUsers.users[getUsersArrayIndex(objUsers, userId)] = editedUserJson;
    document.getElementById(tableId).innerHTML = "";
    myMain(tableTitlesJson, objUsers, tableId);
}
function  deleteUser(userId) {
    var index = getUsersArrayIndex(objUsers, userId);
    objUsers.users.splice(index, 1);
    document.getElementById(tableId).innerHTML = "";
    myMain(tableTitlesJson, objUsers, tableId);
}
function addUser() {
    addedUserJson = getAddedUserJson();
    objUsers.users[objUsers.users.length] = addedUserJson;
    document.getElementById(tableId).innerHTML = "";
    myMain(tableTitlesJson, objUsers, tableId);
}
function  getEditedUserJson(userJson) {
    return {"userId": "15", "name": "Edited Name", "lastname": "Edited last n", "email": "edited email", "sex": "Edited sex", "birthday": "Edited birthday"};
}
function  getAddedUserJson() {
    return {"userId": tmpId++, "name": "Added Name", "lastname": "Added last n", "email": "Added email", "sex": "Added sex", "birthday": "Added birthday"};
}
//checked first checkbox: all select box in begin line make selected,
//and remove checked in first checkbox: all make no selected 
function sellectAllOrNull() {
    $('#' + tableId + ' .title li input[name="' + tableTitlesJson.checkboxName + '"]').click(function () {
        if (this.checked) {
            $('#' + tableId + ' ul li .checkUser').each(function () {
                this.checked = true;
            });
        } else {
            $('#' + tableId + ' ul li .checkUser').each(function () {
                this.checked = false;
            });
        }
    });
}
function getJson() {
    var modalHtml = document.getElementById("modal-content");
    var list = modalHtml.getElementsByClassName("text");
    var i;
    var key;
    var val;
    var json = {};
    for (i = 0; i < list.length; i++) {
        val = list[i].value;
        key = list[i].getAttribute("name");
        json[key] = val;
    }
    updateTable(json);
    return json;
}
function updateTable(json) {
    var userId = json['user_id'];
    document.getElementById(tableId).innerHTML = "";
    objUsers.users[getUsersArrayIndex(objUsers, userId)] = json;
    myMain(tableTitlesJson, objUsers, tableId);

}
function getUsersArrayIndex(objUsers, userId) {
    for (i = 0; i < objUsers.users.length; i++) {
        if (objUsers.users[i].userId == userId) {
            return i;
        }
    }
    return false;
}

/**************/
function validateLogInForm() {
    validated = 0;
    validField("emailId", /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
    validField("passwordId", /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$/);
    if (validated != 2) {
        return false;
    }
}
function validateSignUpForm() {
    validated = 0;
    validField("nameId", /^[a-zA-Z ]+$/);
    validField("lastNameId", /^[a-zA-Z ]+$/);
    validField("emailId", /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
    validField("passwordId", /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$/);
    if (validated != 4) {
        return false;
    }
}
//Validation Field
function validField(fieldId, pattern) {
    var element = document.getElementById(fieldId);
        div = element.parentNode;
        error=div.getElementsByClassName("error");
    if (pattern.test(element.value)) {
        if (error[0]) {
            error[0].remove();
        }
        validated++;
    } else {
        if (!error[0]) {
            createElement(div, "p", {"class":"error"});
        }
        div.lastChild.innerHTML=getErrorsMesages(fieldId);
    }
}
function getErrorsMesages(elementId) {
    switch (elementId) {
        case "nameId":
            return "Invalid Name! Password should contain at least one digit, at least one lower case, at least one upper case, at least 6 from the mentioned characters";
            break;
        case "lastNameId":
            return "Invalid Last Name! Check that name does not contain special symbols(e.g. %, $, #. @ etc.)";
            break;
        case "emailId":
            return "Invalid Email! Check the format of the email, input value should be of email format (e.g. user@example.com)";
            break;
        case "passwordId":
            return "Invalid Password! Password should contain at least one digit, at least one lower case, at least one upper case, at least 6 from the mentioned characters";
            break;
    }
}
/**onclicks LOGIN***/
//document.getElementById('logInId').onclick == validateLogInForm()
