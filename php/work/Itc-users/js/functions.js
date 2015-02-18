$(document).ready(function () {
    sellectAllOrNull();
    getEditUser();
    printUsers();
});
//checked first checkbox: all select box in begin line make selected,
//and remove checked in first checkbox: all make no selected 
function sellectAllOrNull() {
    $('.tablePage .title li input[name="selectAll"]').click(function () {
        if (this.checked) {
            $('.tablePage ul li .checkUser').each(function () {
                this.checked = true;
            });
        } else {
            $('.tablePage ul li .checkUser').each(function () {
                this.checked = false;
            });
        }
    });
}

function getEditUser() {
    var value;
    var user_id;
    var rel;
    $('.action a').click(function () {
        $('.modal-content').html('<ul class="editUser"></ul>');
        user_id = $(this).parents('.user').find('input[type="checkbox"]').val();
        $('.editUser').append('<li style="display:none;"><input name="user_id" type="text" class="text" value="' + user_id + '" /></li>');
        $(this).parents('.user').find('div.text').each(function () {
            rel = $(this).parent().attr('class');
            value = $(this).text();
            $('.editUser').append('<li><input type="text" class="text" value="' + value + '" name="' + rel + '"/></li>');
        });
        $('.modal-content').append('<button id="updateUser" onclick="getJson()">Update</button>');
        //      updateUser();
    });
}
function updateUser(json) {
    //TODO
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
    var table = document.getElementById("tablePage");
    var list = table.getElementsByTagName("li");
}
function printUsers() {
    objUsers = {"users": [{"userId": "1", "name": "Poghos", "lastname": "Poghosyan", "email": "poghosyan@gmail.com", "sex": "male", "age": "54"},
            {"userId": "1", "name": "Poghos", "lastname": "Poghosyan", "email": "poghosyan@gmail.com", "sex": "male", "age": "54"},
            {"userId": "1", "name": "Poghos", "lastname": "Poghosyan", "email": "poghosyan@gmail.com", "sex": "male", "age": "54"}]};
    //alert(objUsers.users.length);
    for (i = 0; i < objUsers.users.length; i++) {
    var parentObj = document.getElementById("tablePage");
        ul = createElement(parentObj,"ul",{"class":"user"});
        li = createElement(ul,"li",{});         
        div = createElement(li,"div",{}); 
        input = createElement(div,"input",{"type":"checkbox","name":"user","value":"1","class":"checkUser"});                 
    }
}
function createElement(parentObj,tagName,attributes){
    var tag = document.createElement(tagName);
        for (var key in attributes) {        
            tag.setAttribute(key, attributes[key]);
        }
    parentObj.appendChild(tag);        
    return tag;
}