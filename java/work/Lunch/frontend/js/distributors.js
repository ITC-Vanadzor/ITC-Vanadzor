var productList = { "Movses":[ {"product": "Iqibir", "count": "3"},
    {"product": "Qyabab", "count": "2"},
    {"product": "Pizza", "count": "4"} ],
 "Hrach":[ {"product": "Spas", "count": "3"},
    {"product": "Hamburger", "count": "12"} ] }; 

var users = [ {"userId": "1", "userName": "Movses" },
{"userId": "2", "userName": "Hrach" }
];

var distributors = [{ "placeID":"Tashir", "userID":"Movses" },
{ "placeID":"Valod", "userID":"" }]

function changePlaceName(place) {
    localStorage[place]=place;
}

function changeName(place) {
    document.getElementById("placeName").innerHTML = localStorage[place];
}

function replaceExample(btnid) {
    var item = document.getElementById(btnid).parentNode.nodeName;
    item.innerHTML="aaa";
}

function becomeDistributor(json_distributor) {
    //json_disributor has such structure [{"sessionId:"01"},{"plceId":"0364"}]
    var xmlhttp;
    xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==204) {
            //Todo
        }
    }
    xmlhttp.open("POST","http://localhost:8080",true);
    xmlhttp.send(jsondistributor);

}


function getOrderList() {
    var xmlhttp;
    xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            //Todo
        }
    }
    xmlhttp.open("POST","http://localhost:8080",true);
    xmlhttp.send();
}

//Function filling distributors table
function addDistributorList() {
    for(i in distributors) {
        var tableRow = document.createElement("tr");
        var tableData = document.createElement("td");
        var userName = document.createTextNode(distributors[i].userID);
        var placeName = document.createTextNode(distributors[i].placeID); 
        var Name = distributors[i].placeID;
        changePlaceName(Name);
        var btn = document.createElement("button");
        tableA = document.createElement('a');
        tableData.appendChild(tableA);
        tableA.appendChild(placeName);
        tableA.setAttribute("href","placespage.html");
        tableA.setAttribute("onclick", "changeName(Name)");
        tableRow.appendChild(tableData);
        var tableData1 =document.createElement("td");
        tableData1.appendChild(userName);
        if (distributors[i].userID == "") {
            tableData1.appendChild(btn);
            var btnName = document.createTextNode("Add");
            btn.appendChild(btnName);
            btn.setAttribute("id",i);
            btn.setAttribute("onclick", "replaceExample(this.id);");
        }
        tableRow.appendChild(tableData1);
        document.getElementById("distrTable").appendChild(tableRow);
    }

}

//Function filling product table
function addProductList() {
    //response body [{"product":""},{"count":""}]
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

//Function filling user table
function addUserList() {
    //response body [{"userID":""},{"productID":""},{"count":""}]
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

//Function filling order table
function addOrderList() {
    //response body [{"userId":""},{"productID":""},{"count":""}]
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
