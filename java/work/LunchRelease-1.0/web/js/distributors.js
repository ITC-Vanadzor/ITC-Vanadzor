var host = "http://localhost:8080";
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
    xmlhttp.open("GET",host+"/lunch-1/getdistributors",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send(null);
}

function becomeDistributor(element) {
    var placeId = element.name;
    var sessionId = JSON.parse(localStorage.session_json).sessionId;
    var json_distr = {"sessionId":sessionId,"placeId":placeId};
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==204) {
            var parentElement = element.parentNode;
            var distName = document.createTextNode("Me");
            parentElement.appendChild(distName);
            parentElement.removeChild(element);
        }
        else if (xmlhttp.readyState==4 && xmlhttp.status==500) {
            document.getElementById('distrTable').rows[placeId].cells[1].innerHTML =" iServer error" ;
        }
    }
    xmlhttp.open("POST",host+"/lunch-1/becomedistributor",true);
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
        //Name = distributors[i].placeName;//"Name" is variable in locaslStorage to point place name in placespage.
        var btn = document.createElement("button");
        tableData.appendChild(placeName);
        tableData.setAttribute("class","placeNameClass");
        tableData.setAttribute("id", distributors[i].placeId);
        tableData.setAttribute("onclick", "changePlaceName(this.id)");
        tableRow.appendChild(tableData);
        var tableData1 =document.createElement("td");
        if (distributors[i].name == null) {
            tableData1.appendChild(btn);
            var btnName = document.createTextNode("Add");
            btn.appendChild(btnName);
            btn.setAttribute("name", distributors[i].placeId);
            btn.setAttribute("onclick", "becomeDistributor(this);");
        } else {
            tableData1.appendChild(userName);
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
            printProductList(productList);  
        }
        if (xmlhttp.readyState==4 && xmlhttp.status==404) {
            document.getElementById("productList1").innerHTML = "Not Found";  
        }
        if (xmlhttp.readyState==4 && xmlhttp.status==500) {
            document.getElementById("productList1").innerHTML = "Server error";  
        }
    }
    xmlhttp.open("POST",host+"/lunch-1/getproducts",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send(JSON.stringify(place_json));
}

//Function filling product table(2.1)
function printProductList(productList) {
    for(i in productList) {
        var tableRow = document.createElement("tr");
        var tableData = document.createElement("td");
        var product = document.createTextNode(productList[i].productName);
        var count = document.createTextNode(productList[i].count);
        tableData.appendChild(product);
        tableData.setAttribute('style', 'font-size: 16px');
        tableRow.appendChild(tableData);
        var tableData1 = document.createElement("td");
        tableData1.appendChild(count);
        tableData1.setAttribute('style', 'font-size: 16px');
        tableRow.appendChild(tableData1);
        document.getElementById("productTable").appendChild(tableRow);
    }
}

function getUserList() {
    var place_json = {"placeId":localStorage.distPlaceId};
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var users = JSON.parse(xmlhttp.responseText);
            printUserList(users);
        }
        if (xmlhttp.readyState==4 && xmlhttp.status==404) {
            document.getElementByClass("productList2").innerHTML = "Not Found";  
        }
        if (xmlhttp.readyState==4 && xmlhttp.status==500) {
            document.getElementByClass("productList2").innerHTML = "Server error";  
        }
    }
    xmlhttp.open("POST",host+"/lunch-1/getcustomers",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send(JSON.stringify(place_json));
}

//Function filling user table (2.2)
function printUserList(users) {
    for(i=0; i<users.length; i++) {
        var tableRow = document.createElement("tr");   
        var tableData = document.createElement("td");
        var name = document.createTextNode(users[i].userName+"  ");
        var btn = document.createElement("button");
        tableData.appendChild(name);
        tableData.setAttribute('style', 'font-size: 16px;')
        tableData.appendChild(btn);
        var btnName = document.createTextNode("List");
        btn.appendChild(btnName);
        btn.setAttribute("id", users[i].userId)
            btn.setAttribute("onclick", "getOrdersByUser(this.id);");
        tableRow.appendChild(tableData);
        document.getElementById("nameTable").appendChild(tableRow);
    } 
}

function getOrdersByUser(userId) {
    var user_json = {"userId":userId,"placeId":localStorage.distPlaceId};
    var xmlhttp=new XMLHttpRequest();
    xmlhttp.onreadystatechange=function() {
        if (xmlhttp.readyState==4 && xmlhttp.status==200) {
            var orderList = JSON.parse(xmlhttp.responseText);
            printOrderList(orderList);
        }
        if (xmlhttp.readyState==4 && xmlhttp.status==404) {
            document.getElementByClass("productList2").innerHTML = "Not Found";  
        }
        if (xmlhttp.readyState==4 && xmlhttp.status==500) {
            document.getElementByClass("productList2").innerHTML = "Server error";  
        }
    }
    xmlhttp.open("POST",host+"/lunch-1/getorders",true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send(JSON.stringify(user_json));
}

//Function filling order tablei (2.3)
function printOrderList(orderList) {
    var list = document.getElementById("orderTable")
        var childsCount = list.childNodes.length;
    for(j=0; j<childsCount-2; j++) {
        list.removeChild(list.childNodes[2]); 
    }
    for(i in orderList){
        var tableRow = document.createElement("tr");
        var tableData = document.createElement("td");
        var product = document.createTextNode(orderList[i].productName);
        var count = document.createTextNode(orderList[i].count);
        tableData.appendChild(product);
        tableRow.appendChild(tableData);
        var tableData1 = document.createElement("td");
        tableData1.appendChild(count);
        tableRow.appendChild(tableData1);
        list.appendChild(tableRow);
    }   
}
/*function signout(){
    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status==204){
            window.location = "loginpage.html";
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==404 ){
        }
        else if(ajaxRequest.readyState == 4 && ajaxRequest.status==500 ){
        }

    }
    ajaxRequest.open("POST", host+"/lunch-1/logout", true);
    ajaxRequest.setRequestHeader("Content-type", "application/json");
    ajaxRequest.send(localStorage.session_json);

}*/
