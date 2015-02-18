$(document).ready(function () {
    sellectAllOrNull();
    getEditUser();
   // printUsers();
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
objUsers={"users":[]};
function printUsers() {
    cc={"userId": "1", "name": "Poghos", "lastname": "Poghosyan", "email": "poghosyan@gmail.com", "sex": "male", "age": "54"};
    //objUsers = {"users": [{"userId": "1", "name": "Poghos", "lastname": "Poghosyan", "email": "poghosyan@gmail.com", "sex": "male", "age": "54"}]};
    objUsers.users[objUsers.users.length]=cc;
    var parentObj = document.getElementById("tablePage");
        var kk="us"+objUsers.users.length;
        ul = createElement(parentObj,"ul",{"class":"user","id":kk});
        li = createElement(ul,"li",{});         
        div = createElement(li,"div",{}); 
        input = createElement(div,"input",{"type":"checkbox","name":"user","value":"1","class":"checkUser"});
        for (key in objUsers.users[objUsers.users.length-1]) {
            if ( key == "userId") {
               continue;
            }
        li = createElement(ul,"li",{"class":key}); 
        div= createElement(li,"div",{}); 
        div.appendChild(document.createTextNode(objUsers.users[objUsers.users.length-1][key]));
    }
     li = createElement(ul,"li",{"class":"edit"});
     div = createElement(li,"div",{"class":"action"}); 
     i=createElement(div,"i",{}); 
     a=createElement(div,"a",{"href":"#edit-user"});
     a.appendChild(document.createTextNode("edit")); 
     li = createElement(ul,"li",{"class":"delete"});
     div = createElement(li,"div",{"class":"action","onclick":"removeLi('"+kk+"')"}); 
     i=createElement(div,"i",{}); 
     span=createElement(div,"span",{});
     span.appendChild(document.createTextNode("delete")); 
    }                
function removeLi(a) {
    var ul=document.getElementById(a);
    if (ul) {
        while (ul.firstChild) {
            ul.removeChild(ul.firstChild);
        }
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
