function changePlaceName(id) {
    var placeName = document.getElementById(id).innerHTML;
    localStorage["distPlaceName"]=placeName;
    localStorage["distPlaceId"]= id;
    window.location.href = "placespage.html";
}

function changeName() {
    document.getElementById("placeName").innerHTML = localStorage["distPlaceName"];
}



function getDistributors() {
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var distributors = JSON.parse(xmlhttp.responseText);
            printDistributorList(distributors);  
        }
        else if (xmlhttp.readyState==4 && xmlhttp.status==500) {
             document.getElementById("distributors").innerHTML= "Inner Server Error" ;  
        }
        else if (xmlhttp.readyState==4 && xmlhttp.status==404) {
             document.getElementById("distributors").innerHTML= "Not Found" ;  
        }
    }
    xmlhttp.open("GET","http://192.168.33.64:8080/lunch-1/getdistributors",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send(null);
}

function becomeDistributor(placeId) {
    var sessionId = JSON.parse(localStorage.session_json).sessionId;
    console.log(sessionId);
    var json_distr = {"sessionId":sessionId,"placeId":placeId};
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==204) {
            document.getElementById('distrTable').rows[placeId].cells[1].innerHTML =" localStorage.username" ;
        }
        else if (xmlhttp.readyState==4 && xmlhttp.status==500) {
            document.getElementById('distrTable').rows[placeId].cells[1].innerHTML =" iServer error" ;
        }
    }
    xmlhttp.open("POST","http://192.168.33.64:8080/lunch-1/becomedistributor",true);
    xmlhttp.send(JSON.stringify(json_distr));
}
//Function filling distributors table(1.1)
function printDistributorList(distributors) {
    //var distributors = [{"placeId":"01" "placeName":"Tashir", "nameId":"2", "name":"movses@itc.com"}];
    for(i in distributors) {
        var tableRow = document.createElement("tr");
        var tableData = document.createElement("td");
        var userName = document.createTextNode(distributors[i].name);
        var placeName = document.createTextNode(distributors[i].placeName); 
        Name = distributors[i].placeName;//"Name" is variable in locaslStorage to point place name in placespage.
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
            btn.setAttribute("id",distributors[i].placeId);
            btn.setAttribute("onclick", "becomeDistributor(this.id);");
        }
        tableRow.appendChild(tableData1);
        document.getElementById("distrTable").appendChild(tableRow);
    }

}

function getProductList() { 
    var place_json = {"placeId":localStorage.distPlaceId};
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var productList = JSON.parse(xmlhttp.responseText);
            addProductList(productList);  
        }
    }
    xmlhttp.open("GET","http://localhost:8080/lunch-1/getProducts",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send(JSON.stringify(place_json));
}

//Function filling product table(2.1)
function addProductList(productList) {
   /* var productList = [ {"productName": "Iqibir", "count": "3"},
        {"productName": "Qyabab", "count": "2"},
       {"productName": "Pizza", "count": "4"} ];*/
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
    xmlhttp.open("POST","http://localhost:8080/lunch-1/getCustomers",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
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
