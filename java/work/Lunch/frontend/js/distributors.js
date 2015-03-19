var productList = 
{ "Movses":[ {"product": "Iqibir", "count": "3"},
    {"product": "Qyabab", "count": "2"},
    {"product": "Pizza", "count": "4"} ],
 "Hrach":[ {"product": "Spas", "count": "3"},
    {"product": "Hamburger", "count": "12"} ] }; 

var users = [ {"userId": "1", "userName": "Movses" },
{"userId": "2", "userName": "Hrach" }
];

function changePlaceName(place) {
    localStorage["place"]=place;
}

function changeName() {
    document.getElementById("placeName").innerHTML = localStorage["place"];
}

function addProductList() {
    for(i in productList) {
        for(j  in productList[i]) {
            var tableRow = document.createElement("tr");
            var tableData = document.createElement("td");
            var product = document.createTextNode(productList[i][j].product);
            var count = document.createTextNode(productList[i][j].count);
            tableData.appendChild(product);
            tableRow.appendChild(tableData);
            var tableData1 = document.createElement("td");
            tableData1.appendChild(count);
            tableRow.appendChild(tableData1);
            document.getElementById("productTable").appendChild(tableRow);
        }
    }
}
function addUserList() {
    for(i=0; i<users.length; i++) {
        var tableRow = document.createElement("tr");   
        var tableData = document.createElement("td");
        var name = document.createTextNode(users[i].userName);
        var btn = document.createElement("button");
        tableData.appendChild(name);
        tableData.appendChild(btn);
        var btnName = document.createTextNode("List");
        btn.appendChild(btnName);
        btn.setAttribute("onclick", "addOrderList();");
        tableRow.appendChild(tableData);
        document.getElementById("nameTable").appendChild(tableRow);
    } 
}

function addOrderList() {
    var list = document.getElementById("orderTable")
    var childsCount = list.childNodes.length;
    for(j=0; j<childsCount-2; j++) {
        list.removeChild(list.childNodes[2]); 
    }
    for(i in productList){
        for(j in productList[i]) {
            var tableRow = document.createElement("tr");
            var tableData = document.createElement("td");
            var product = document.createTextNode(productList[i][j].product);
            var count = document.createTextNode(productList[i][j].count);
            tableData.appendChild(product);
            tableRow.appendChild(tableData);
            var tableData1 = document.createElement("td");
            tableData1.appendChild(count);
            tableRow.appendChild(tableData1);
            list.appendChild(tableRow);
        }   
    }
}
