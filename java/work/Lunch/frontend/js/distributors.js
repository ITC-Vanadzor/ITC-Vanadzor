function changePlaceName(place) {
    localStorage[place]=place;
}

function changeName(place) {
    document.getElementById("placeName").innerHTML = localStorage[place];
}


//not finished function
function becomeDistributor(json_distributor) {
    //json_disributor has such structure [{"sessionId:"01"},{"placeId":"0364"}]
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


function getDistributors(sessionId,placeId) {
    var distr_json = [{"sessionId":sessionId},{"placeId":placeId}]
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var distributors = JSON.parse(xmlhttp.responseText);
            addProductList(distributors);  
        }
    }
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.open("GET","http://localhost:8080/lunch-1/getDistributors",true);
    xmlhttp.send(JSON.stringify(distr_json));
}

//example for becomeDistributor
function replaceExample(btnid, usrName) {
    var item = document.getElementById(btnid)//.parentNode.nodeName;
    alert("Hi");
    item.innerHTML= usrName;
}

//Function filling distributors table(1.1)
function addDistributorList(distributors) {
    var distributors = [{ "placeID":"Tashir", "userName":"" },
    { "placeID":"Valod", "userName":"Eduard" }]
    for(i in distributors) {
        var tableRow = document.createElement("tr");
        var tableData = document.createElement("td");
        userName = document.createTextNode(distributors[i].userName);
        var placeName = document.createTextNode(distributors[i].placeID); 
        usrName = distributors[i].userName; 
        Name = distributors[i].placeID;
        changePlaceName(Name);
        var btn = document.createElement("button");
        tableA = document.createElement('a');
        tableData.appendChild(tableA);
        tableA.appendChild(placeName);
        tableA.setAttribute("href","placespage.html");
        tableA.setAttribute("onclick", "changePlaceName(Name)");
        tableRow.appendChild(tableData);
        var tableData1 =document.createElement("td");
        tableData1.appendChild(userName);
        if (distributors[i].userName == "") {
            tableData1.appendChild(btn);
            var btnName = document.createTextNode("Add");
            btn.appendChild(btnName);
            btn.setAttribute("id",i);
            btn.setAttribute("value","i");
            btn.setAttribute("onclick", "replaceExample(i, usrName);");
        }
        tableRow.appendChild(tableData1);
        document.getElementById("distrTable").appendChild(tableRow);
    }

}

function getProductList(placeId) { 
    var place_json = [{"placeId":placeId}];
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var productList = JSON.parse(xmlhttp.responseText);
            addProductList(productList);  
        }
    }
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.open("GET","http://localhost:8080/lunch-1/getProducts",true);
    xmlhttp.send(JSON.stringify(place_json));
}

//Function filling product table(2.1)
function addProductList(productList) {
    var productList = [ {"productName": "Iqibir", "count": "3"},
        {"productName": "Qyabab", "count": "2"},
       {"productName": "Pizza", "count": "4"} ];
    //response body [{"product":""},{"count":""}]
    for(i in productList) {
            var tableRow = document.createElement("tr");
            var tableData = document.createElement("td");
            var product = document.createTextNode(productList[i].productName);
            var count = document.createTextNode(productList[i].count);
            tableData.appendChild(product);
            tableRow.appendChild(tableData);
            var tableData1 = document.createElement("td");
            tableData1.appendChild(count);
            tableRow.appendChild(tableData1);
            document.getElementById("productTable").appendChild(tableRow);
    }
}

function getUserList() {
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var users = JSON.parse(xmlhttp.responseText);
            addUserList(users);
        }
    }
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.open("POST","http://localhost:8080/lunch-1/getCustomers",true);
    xmlhttp.send();
}

//Function filling user table (2.2)
function addUserList(users) {
    var users = [ {"userId": "1", "userName": "Movses" },
    {"userId": "2", "userName": "Hrach" }
    ];
    //response body [{"userId":"","userName":""}]
    for(i=0; i<users.length; i++) {
        var tableRow = document.createElement("tr");   
        var tableData = document.createElement("td");
        var name = document.createTextNode(users[i].userName);
        var btn = document.createElement("button");
        tableData.appendChild(name);
        tableData.appendChild(btn);
        var btnName = document.createTextNode("List");
        btn.appendChild(btnName);
        btn.setAttribute("onclick", "getOrdersByUser();");
        tableRow.appendChild(tableData);
        document.getElementById("nameTable").appendChild(tableRow);
    } 
}

function getOrdersByUser(userId) {
    var user_json = [{"userId":userId}];
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var orderList = JSON.parse(xmlhttp.responseText);
            addOrderList(orderList);
        }
    }
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.open("POST","http://localhost:8080/lunch-1/getOrders",true);
    xmlhttp.send(JSON.stringify(user_json));
}

//Function filling order tablei (2.3)
function addOrderList(orderList) {
    var orderList = [ {"product": "Iqibir", "count": "3"},
        {"product": "Qyabab", "count": "2"},
       {"product": "Pizza", "count": "4"} ];
    //response body [{"productID":""},{"count":""}]
    var list = document.getElementById("orderTable")
    var childsCount = list.childNodes.length;
    for(j=0; j<childsCount-2; j++) {
        list.removeChild(list.childNodes[2]); 
    }
    for(i in orderList){
            var tableRow = document.createElement("tr");
            var tableData = document.createElement("td");
            var product = document.createTextNode(orderList[i].product);
            var count = document.createTextNode(orderList[i].count);
            tableData.appendChild(product);
            tableRow.appendChild(tableData);
            var tableData1 = document.createElement("td");
            tableData1.appendChild(count);
            tableRow.appendChild(tableData1);
            list.appendChild(tableRow);
        }   
}
