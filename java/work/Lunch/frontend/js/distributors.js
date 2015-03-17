var productList = [ {"product": "Iqibir", "count": 3},
    {"product": "Qyabab", "count": 2},
    {"product": "Pizza", "count": 4}
];
 
var users = [ {"user_id": 1, user_name: "Movses" },
{"user_id": 2, user_name: "Hrach" }
];

function change(place) {
    localStorage["place"]=place;
}

function changeName() {
    document.getElementById("placeName").innerHTML = localStorage["place"];
}

function addProductList() {
    for(i=0; i<productList.length; i++) {
        var tr = document.createElement("tr");
        var td = document.createElement("td");
        var product = document.createTextNode(productList[i].product);
        var count = document.createTextNode(productList[i].count);
        td.appendChild(product);
        tr.appendChild(td);
        var td1 = document.createElement("td");
        td1.appendChild(count);
        tr.appendChild(td1);
        document.getElementById("productTable").appendChild(tr);

    } 
}
function addUserList() {
    for(i=0; i<users.length; i++) {
    var tr = document.createElement("tr");   
    var td = document.createElement("td");
    var user_id = document.createTextNode(users[i].user_id);
    var name = document.createTextNode(users[i].user_name);
    //TODO
    } 
}

function addOrderList() {
    for(i=0; i<productList.length; i++) {
        var tr = document.createElement("tr");
        var td = document.createElement("td");
//        var name = document.createTextNode(productList[i].name);
        var product = document.createTextNode(productList[i].product);
        var count = document.createTextNode(productList[i].count);
//        td.appendChild(name);
//        tr.appendChild(td);
        var td1 = document.createElement("td");
        td1.appendChild(product);
        tr.appendChild(td1);
        var td2 = document.createElement("td");
        td2.appendChild(count);
        tr.appendChild(td2);
        document.getElementById("orderTable").appendChild(tr);
    }   
}
