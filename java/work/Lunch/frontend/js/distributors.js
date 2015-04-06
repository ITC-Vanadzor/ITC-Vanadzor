function changePlaceName(id) {
    place = document.getElementById(id).innerHTML;
    localStorage["place"]=place;
    window.location.href = "placespage.html";
}

function changeName(place) {
    document.getElementById("placeName").innerHTML = localStorage["place"];
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
function becomeDistributor(btnid,placeId,sessionId) {
    var json_distr = {"sessionId":sessionId,"placeId":placeId};
    var placeName = document.getElementById("distrTable").rows[btnid*1+1].cells[0].innerHTML;
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==204) {
            document.getElementById('distrTable').rows[btnid*1+1].cells[1].innerHTML = "usrname";
        }

    }
    xmlhttp.open("POST","http://localhost:8080/lunch-1/becomedistributor",true);
    xmlhttp.send(JSON.stringify(json_distr));
}

//Function filling distributors table(1.1)
function addDistributorList(distributors) {
    var distributors = [{ "placeName":"Tashir", "userName":"" },
    { "placeName":"Valod", "userName":"" }]
    for(i in distributors) {
        var tableRow = document.createElement("tr");
        var tableData = document.createElement("td");
        var userName = document.createTextNode(distributors[i].userName);
        var placeName = document.createTextNode(distributors[i].placeName); 
        Name = distributors[i].placeName;
        var btn = document.createElement("button");
        tableData.appendChild(placeName);
        tableData.setAttribute("class","placeNameClass");
        tableData.setAttribute("id", Name);
        tableData.setAttribute("onclick", "changePlaceName(this.id)");
        tableRow.appendChild(tableData);
        var tableData1 =document.createElement("td");
        tableData1.appendChild(userName);
        if (distributors[i].userName == "") {
            tableData1.appendChild(btn);
            var btnName = document.createTextNode("Add");
            btn.appendChild(btnName);
            btn.setAttribute("id",i);
            btn.setAttribute("onclick", "becomeDistributor(this.id);");
        }
        tableRow.appendChild(tableData1);
        document.getElementById("distrTable").appendChild(tableRow);
    }

}

function getProductList(placeId) { 
    var place_json = {"placeId":placeId};
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

function getUserList(placeId) {
    var place_json = {"placeId":placeId};
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var users = JSON.parse(xmlhttp.responseText);
            addUserList(users);
        }
    }
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.open("POST","http://localhost:8080/lunch-1/getCustomers",true);
    xmlhttp.send(JSON.stringify(place_json));
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

function getOrdersByUser(userId,placeId) {
    var user_json = {"userId":userId,"placeId":placeId};
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var orderList = JSON.parse(xmlhttp.responseText);
            addOrderList(orderList);
        }
    }
    xmlhttp.open("POST","http://localhost:8080/lunch-1/getOrders",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
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
