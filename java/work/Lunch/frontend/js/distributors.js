var productList = 
{ "Movses":[ {"product": "Iqibir", "count": 3},
    {"product": "Qyabab", "count": 2},
    {"product": "Pizza", "count": 4} ],
 "Hrach":[ {"product": "spas", "count": 32},
    {"product": "google", "count": 23} ] };
 
var users = [ {"user_id": 1, user_name: "Movses" },
{"user_id": 2, user_name: "Hrach" }
];

function changePlaceName(place) {
    localStorage["place"]=place;
}

function changeName() {
    document.getElementById("placeName").innerHTML = localStorage["place"];
}

function addProductList() {
    for(j=0; j<productList.length; j++) {
        alert("j");
        for(i=0; i<productList[j].length; i++) {
            alert("i");
            var tr = document.createElement("tr");
            var td = document.createElement("td");
            var product = document.createTextNode(productList.Movses[i].product);
            var count = document.createTextNode(productList.Hrach[i].count);
            td.appendChild(product);
            tr.appendChild(td);
            var td1 = document.createElement("td");
            td1.appendChild(count);
            tr.appendChild(td1);
            document.getElementById("productTable").appendChild(tr);

        } 
    }
}
function addUserList() {
    for(i=0; i<users.length; i++) {
        var tr = document.createElement("tr");   
        var td = document.createElement("td");
        var user_id = document.createTextNode(users[i].user_id);
        var name = document.createTextNode(users[i].user_name);
        td.appendChild(user_id);
        tr.appendChild(td);
        var td1 = document.createElement("td");
        var btn = document.createElement("button");
        td1.appendChild(name);
        td1.appendChild(btn);
        var btnName = document.createTextNode("List");
        btn.appendChild(btnName);
        btn.setAttribute("onclick", "addOrderList();");
        tr.appendChild(td1);

        document.getElementById("nameTable").appendChild(tr);
    } 
}

function addOrderList() {
    var list = document.getElementById("orderTable")
    var childsCount = list.childNodes.length;
    for(j=0; j<childsCount-2; j++) {
        list.removeChild(list.childNodes[2]); 
    }
    for(i=0; i<productList.length; i++) {
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        var product = document.createTextNode(productList[i].product);
        var count = document.createTextNode(productList[i].count);
// AREG -> avoid using numbers in variable / class / function names
        var td1 = document.createElement("td");
        td1.appendChild(product);
        tr.appendChild(td1);
        var td2 = document.createElement("td");
        td2.appendChild(count);
        tr.appendChild(td2);
        document.getElementById("orderTable").appendChild(tr);
    }   
}
