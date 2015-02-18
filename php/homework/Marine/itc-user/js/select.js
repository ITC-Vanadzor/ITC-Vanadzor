checked=false;
function checkedAll (frm1) {
    var aa= document.getElementById('frm1');
    if (checked == false) {
        checked = true
    }
    else {
        checked = false
    }
    for (var i =0; i < aa.elements.length; i++) {
        aa.elements[i].checked = checked;
    }
}
function removeLi(a) {
    var ul=document.getElementById(a);
    if (ul) {
        while (ul.firstChild) {
            ul.removeChild(ul.firstChild);
        }
    }
}
login="Mane:Hambardzumyan:hambardzumyan.mane@gmail.com:female:24";
usLog=login.split(":");
function addUser() {
    var frm=document.getElementById("frm1");
    var ul=document.createElement("ul");
    ul.setAttribute("id","ur4");
    ul.setAttribute("class","user");
    frm.appendChild(ul);

//document.getElementsByTagName("ul").setAttribute("id","ur4");
    alert(ul.id);
    chkLi();
    hiddenLi(); 
    addName();
    editLi();
    deleteLi();
}
function chkLi() {
    var ul=document.getElementById("ur4");
    var li=document.createElement("ul");
    ul.appendChild(li);
    var div=document.createElement("li");
    li.appendChild(div);
    var input=document.createElement("div"); 
    input.setAttribute("type","checkbox");
    input.setAttribute("name","chk");
    div.appendChild(input);
    alert(input.type);
}
function hiddenLi() {
    var ul=document.getElementById("ur4");
    var li=document.createElement("ul");
    li.setAttribute("rel","user_id");
    li.setAttribute("style","display:none");
    ul.appendChild(li);
    var div=document.createElement("li");
    div.appendChild(document.createTextNode("1"));
    li.appendChild(div);
}    
function addName() {
    for (var i=0; i<usLog.length; i++) {
        var ul=document.getElementById("ur4");
        var li=document.createElement("ul");
        ul.appendChild(li);
        var div=document.createElement("li");
        div.appendChild(document.createTextNode(usLog[i]));
        li.appendChild(div);
    }
}
function editLi() {
    var ul=document.getElementById("ur4");
    var li=document.createElement("ul");
    ul.appendChild(li);
    var div=document.createElement("li");
    div.setAttribute("class","action");
    li.appendChild(div);
    var i=document.createElement("div");
    div.setAttribute("class","edit");
    div.appendChild(i);
    var a=document.createElement("div");
    div.setAttribute("href","#edit-user");
    a.appendChild(document.createTextNode("edit"));
    div.appendChild(a);
}    
function deleteLi() {
    var ul=document.getElementById("ur4");
    var li=document.createElement("ul");
    ul.appendChild(li);
    var div=document.createElement("li");
    div.setAttribute("class","action");
    div.setAttribute("onclick","removeLi('ul4')");
    li.appendChild(div);
    var i=document.createElement("div");
    div.setAttribute("class","delete");
    div.appendChild(i);
    var span=document.createElement("div");
    span.appendChild(document.createTextNode("delete"));
    div.appendChild(span);
}

